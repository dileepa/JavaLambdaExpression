import com.sun.xml.internal.ws.util.StreamUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter {

    public static void main(String[] args) {

        List<Person> personList = PersonDataLoader.getPersonList();
        Stream<Person> stream = personList.stream();

        /**
         * How to use println for print stream elements
         */
        //stream6.forEach(System.out::println);

        /**
         * Integer::new -> (value) -> new Integer(value)
         * Person::getName -> (person) -> person.getName()
         */

        /**Apply Filter extract results to list.**/
        Predicate<Person> singlePersonPredicate = person -> person.getStatus().equals(Person.SINGLE);
        List<Person> singleList = stream.filter(singlePersonPredicate).collect(Collectors.toList());
        singleList.forEach(sing -> System.out.println(sing.toString()));

        //How to use allMatch, anyMatch and noneMatch
        /**
         * Stream.allMatch -> That predicate is applied to each element of stream and if each and every element satisfies the predicate then it returns true otherwise false.
         * Stream.anyMatch -> The element of stream is iterated for this predicate. If any element matches then it returns true otherwise false.
         * Stream.noneMatch -> NoneMatch method is a method which takes argument as a predicate and if none of element of stream matches the predicate, then it returns true else false.
         */
        Stream<Person> stream1 = personList.stream();
        Predicate<Person> personNumberGreaterThan = person -> person.getPersonNumber() > 1;
        boolean allMatch = stream1.allMatch(personNumberGreaterThan);
        Stream<Person> stream2 = personList.stream();
        boolean anyMatch = stream2.anyMatch(personNumberGreaterThan);
        Stream<Person> stream3 = personList.stream();
        boolean noneMatch = stream3.noneMatch(personNumberGreaterThan);
        System.out.println("AllMatch -> {" + allMatch + "}, AnyMatch -> {" + anyMatch + "}, NonMatch -> {" + noneMatch + "}");
        //out put AllMatch -> {false}, AnyMatch -> {true}, NonMatch -> {false}


        //How to use findAny, findFirst, limit, max, min

        Stream<Person> stream4 = personList.stream();
        Optional<Person> findAny = stream4.filter(singlePersonPredicate).findAny(); //Return Random Element from the Filtered Stream
        Stream<Person> stream5 = personList.stream();
        Optional<Person> findFirst = stream5.filter(singlePersonPredicate).findFirst(); //Return First Element from the Filtered Stream.
        if (findAny.isPresent() && findFirst.isPresent() )
        {
            Person anyPerson = findAny.get();
            Person firstPerson = findFirst.get();
            System.out.println( "Any Person -> {" + anyPerson +" }, First Person -> { "+ firstPerson+" }");

        }
        Stream<Person> stream6 = personList.stream();
        Stream<Person> stream7 = stream6.filter(singlePersonPredicate).limit(10);
        stream7.forEach(System.out::println); //limit method of stream API, returns stream instance with the given number of element in limit as an argument.

        //max method returns maximum element on the basis of given comparator. It returns Optional instance.
        Optional<Person> max = personList.stream().filter(singlePersonPredicate).max(new PersonComparator());
        //min method returns minimum element on the basis of given comparator. It returns Optional instance.
        Optional<Person> min = personList.stream().filter(singlePersonPredicate).min(new PersonComparator());
        if ( max.isPresent() && min.isPresent() )
        {
            Person maxPerson = max.get();
            Person minPerson = min.get();
            System.out.println( "Max Person -> {" + maxPerson +" }, Min Person -> { "+ minPerson+" }");
        }

        //How to use count and distinct operations
        long singleStateCount = personList.stream().filter(singlePersonPredicate).count();
        System.out.println("Single Persons are -> " + singleStateCount);
        Stream<Person> distinctStream = personList.stream().filter(singlePersonPredicate).distinct();
        distinctStream.forEach(System.out::println);

        /**
         * Reduce Functionality.
         */
        Stream<Integer> personNumberStream = personList.stream().map(Person::getPersonNumber);
        int sum = personNumberStream.mapToInt(Integer::new).sum(); //map to int use convert to integer list.
        System.out.println("Sum of Passenger numbers -> { " + sum + "}");
        Stream<Integer> personNumberStream1 = personList.stream().map(Person::getPersonNumber);
        Optional<Integer> sumValue = personNumberStream1.reduce((x, y) -> x + y); // without initial value return optional
        System.out.println(sumValue);
        Stream<Integer> personNumberStream2 = personList.stream().map(Person::getPersonNumber);
        long sumValue1 = personNumberStream2.reduce(0, (x, y) -> x + y); //initial value with is zero
        System.out.println(sumValue1);

        //mapFunctionality
        Stream<String> passengerNames = personList.stream().map(Person::getName);
        passengerNames.forEach(System.out::println);

        //GroupBy Functionality.
        //Grouping list by single married as a key.
        Map<String, List<Person>> groupByStatus = personList.stream().collect(Collectors.groupingBy(Person::getStatus));
        System.out.println(groupByStatus);
        //Group list as single married as key and get salary for one shot against them.
        Map<String, Double> salaryWithStatus = personList.stream().collect(Collectors.groupingBy(Person::getStatus, Collectors.summingDouble(Person::getSalary)));
        System.out.println(salaryWithStatus);
        //partition grouping salary ( if salary is greater than 120, is one partition)
        Map<Boolean, List<Person>> collect = personList.stream().collect(Collectors.partitioningBy(person -> person.getSalary() > 120));
        System.out.println(collect);

        //HashMap Operations
        // Print the key value pair in one line.
        //hm.forEach((k,v) -> System.out.println("key: "+k+" value:"+v));

    }
}
