# Stream API Demonstration in Java

## Overview

This documentation provides a detailed overview of various Java Stream API methods used to process a list of `Employee` objects. Each method is explained in terms of its functionality and use case within the provided examples.

## Stream API Methods

### `filter(Predicate<T> predicate)`

- **Definition**: Returns a stream consisting of the elements of this stream that match the given predicate.
- **Use Case**: Filtering employees based on specific conditions, such as age.

### `map(Function<T, R> mapper)`

- **Definition**: Returns a stream consisting of the results of applying the given function to the elements of this stream.
- **Use Case**: Transforming employee objects into a different form, such as extracting names.

### `max(Comparator<T> comparator)`

- **Definition**: Returns an `Optional` describing the maximum element of the stream according to the provided comparator.
- **Use Case**: Finding the employee with the highest salary.

### `mapToDouble(ToDoubleFunction<T> mapper)`

- **Definition**: Returns a `DoubleStream` consisting of the results of applying the given function to the elements of this stream.
- **Use Case**: Converting employee salaries to a `DoubleStream` to calculate the average salary.

### `sorted(Comparator<T> comparator)`

- **Definition**: Returns a stream consisting of the elements of this stream, sorted according to the provided comparator.
- **Use Case**: Sorting employees by surname in ascending or descending order.

### `allMatch(Predicate<T> predicate)`

- **Definition**: Returns `true` if all elements of the stream match the given predicate.
- **Use Case**: Checking if all employees are older than a certain age.

### `collect(Collector<T, A, R> collector)`

- **Definition**: Performs a reduction on the elements of the stream using the provided `Collector`.
- **Use Case**: Grouping employees by department, counting employees per department, and summarizing salaries.

### `distinct()`

- **Definition**: Returns a stream consisting of the distinct elements of this stream.
- **Use Case**: Removing duplicate surnames from the list of employee surnames.

### `toList()`

- **Definition**: Collects the elements of the stream into a `List`.
- **Use Case**: Converting the stream of employees, names, or other objects into a list.

### `flatMap(Function<T, Stream<R>> mapper)`

- **Definition**: Returns a stream that is the result of replacing each element of this stream with the contents of a mapped stream produced by applying the provided function to each element.
- **Use Case**: Flattening a list of lists into a single list.

### `reduce(T identity, BinaryOperator<T> accumulator)`

- **Definition**: Performs a reduction on the elements of the stream using an associative accumulation function and returns the reduced result.
- **Use Case**: Summing up salaries of all employees.

### `partitioningBy(Predicate<T> predicate)`

- **Definition**: Partitions the elements of the stream into two groups based on the given predicate.
- **Use Case**: Dividing employees into employers and non-employers.

### `toMap(Function<T, K> keyMapper, Function<T, V> valueMapper, BinaryOperator<V> mergeFunction)`

- **Definition**: Collects the elements of the stream into a `Map` using the provided key and value mappers, and merge function for duplicate keys.
- **Use Case**: Creating a map of employee names to their salaries.

### `count()`

- **Definition**: Returns the count of elements in the stream.
- **Use Case**: Counting the number of elements in a stream.

### `average()`

- **Definition**: Returns an `OptionalDouble` describing the average value of elements in a stream.
- **Use Case**: Calculating the average salary of employees.

### `min(Comparator<T> comparator)`

- **Definition**: Returns an `Optional` describing the minimum element of the stream according to the provided comparator.
- **Use Case**: Finding the employee with the lowest salary.

### `summarizingDouble(ToDoubleFunction<T> mapper)`

- **Definition**: Returns a `DoubleSummaryStatistics` describing various summary statistics for the elements of the stream, including count, sum, min, average, and max.
- **Use Case**: Summarizing salary statistics of employees.

### `findFirst()`

- **Definition**: Returns an `Optional` describing the first element of the stream.
- **Use Case**: Retrieving the first element after applying a filter or transformation.

### `forEach(Consumer<T> action)`

- **Definition**: Performs an action for each element of the stream.
- **Use Case**: Executing a specified action for each employee in the stream, such as printing employee details.

## Conclusion

The Stream API provides a powerful and flexible way to handle collections of data. The methods outlined above offer various ways to filter, sort, group, and perform aggregate operations on streams, making it easier to process data efficiently and effectively.
