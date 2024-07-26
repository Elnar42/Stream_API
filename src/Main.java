import domain.Employee;
import enums.Department;
import enums.Position;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static service.EmployeeService.loadEmployees;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = loadEmployees();

        //1.Filter employees by age greater than 30.
        List<Employee> list = employees.stream().filter(employee -> employee.getAge() > 30).toList();

        //2.Get a list of employee names.
        List<String> collect = employees.stream().map(Employee::getName).toList();

        //3.Find the employee with the highest salary.
        Employee employee = employees.stream().max(Comparator.comparing(Employee::getSalary)).orElseThrow();

        //4.Calculate the average salary of all employees.
        OptionalDouble average = employees.stream().mapToDouble(Employee::getSalary).average();

        //5.List all employees sorted by their surname.
        List<Employee> surnameAsc = employees.stream().sorted(Comparator.comparing(Employee::getSurname)).toList();
        List<Employee> surnameDesc = employees.stream().sorted(Comparator.comparing(Employee::getSurname).reversed()).toList();

        //6.Check if all employees are older than 25.
        boolean checkAge = employees.stream().allMatch(employee1 -> employee1.getAge() > 25);

        //7.Find the names of employees working in the IT department.
        List<String> employeesInIT = employees.stream().filter(employee1 -> employee1.getDepartment().equals(Department.IT)).toList().stream().map(Employee::getName).toList();

        //8.Group employees by department.
        Map<Department, List<Employee>> collectDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        //9.Count the number of employees in each department.
        Map<Department, Long> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        //10.Find the average age of employees in each department.
        Map<Department, Double> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getAge)));

        //11.Partition employees into employers and non-employers.
        Map<Boolean, List<Employee>> collect3 = employees.stream().collect(Collectors.partitioningBy(Employee::isEmployer));

        //12.Get the total salary of all employees
        double totalSalary = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getSum();

        //13.Find the employee with the lowest salary.
        List<Employee> list1 = employees.stream().filter(employee1 -> employee1.getSalary() == employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getMin()).toList();

        //14. Get a list of the unique surnames of all employees.
        List<String> uniqueEmployeeSurnames = employees.stream().map(Employee::getName).collect(Collectors.toSet()).stream().toList();

        //15.Get a map of employee names to their respective salaries. (Problem is that we can have same named workers, it is not effective
        Map<String, Double> collect5 = employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary, (_, newValue) -> newValue));

        //16.List the names of employees who are not employers.
        List<String> unemployed = employees.stream().filter(employee1 -> !employee1.isEmployer()).map(Employee::getName).toList();

        //17.Get a list of employees' full names (name + surname).
        List<String> fullName = employees.stream().map(t -> t.getName() + " " + t.getSurname()).toList();

        //18.Increase the salary of all employees by 10% and collect the updated list.
        List<Employee> salaryUpdated = employees.stream().map(e -> e.saveWithNewSalary(e.getSalary() * 1.1)).toList();

        //19.Find the sum of the salaries of all employees in the IT department.
        double sum = employees.stream().filter(t -> t.getDepartment().equals(Department.IT)).collect(Collectors.summarizingDouble(Employee::getSalary)).getSum();

        //20.Group employees by department and calculate the total salary for each department.
        //    employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach(((department, employeesList) -> System.out.println("Department: " + department + " ---> Total salary: " + employeesList.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getSum())));

        //21.List employees who have a salary greater than the average salary of all employees.
        List<Employee> highPayedEmployees = employees.stream().filter(e -> e.getSalary() > employees.stream().collect(Collectors.averagingDouble(Employee::getSalary))).toList();

        //22.Convert the list of employees to a map where the key is the employee's ID and the value is the employee object.
        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(Employee::getId, emp -> emp));

        //23.Get the names of employees sorted by their salary in descending order.
        List<String> salaryDecreasedOrder = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).map(Employee::getName).toList();

        //24.Find the oldest employee in each department. (* too confusing, used AI to find)
        Map<Department, Employee> oldestInEachDepartment = employees.stream().collect(Collectors.toMap(Employee::getDepartment, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Employee::getAge))));

        //25.Merge the names and surnames of employees into a single string, separated by commas.
        List<String> list2 = employees.stream().map(e -> e.getName() + "," + e.getSurname()).toList();

        //26.Flatten a list of lists of employees and collect the results.
        List<String> flattedListOfEmployees = employees.stream().flatMap(e -> Stream.of(e.toString())).toList();

        //27.Calculate the total number of years of experience for all employees (assume ‘startDate’ is the start of their employment).
        long totalExperience = employees.stream().mapToLong(e -> ChronoUnit.YEARS.between(e.getStartDate(), LocalDateTime.now())).sum();

        //28.Find the longest-serving employee.
        Employee longestServing = employees.stream().max(Comparator.comparing(e -> ChronoUnit.YEARS.between(e.getStartDate(), LocalDateTime.now()))).orElseThrow();

        //29.Reduce the list of employees to get the combined salary of all employees. (* too confusing, used AI to find)
        double total = employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum);

        //30.Count the number of employees with each position.
        Map<Position, Long> numberOfEmployeesBasedOnPosition = employees.stream().collect(Collectors.groupingBy(Employee::getPosition, Collectors.counting()));


    }


}