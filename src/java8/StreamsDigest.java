package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDigest {

    public StreamsDigest() {}

    public void getJava8StreamFeatures() {
        String[] arr = new String[] {"a", "b", "c", "d", "d"};
        Stream<String> myFirstStream = Arrays.stream(arr); //Creating a stream through the Collection functions
        myFirstStream = Stream.of("a", "b", "c", "d", "d"); //Creating a stream through Stream.class function of()

        //Stream default method added to the Collection interface, creates Stream<T> from any collection
        List<String> arrList = new ArrayList<>();
        Stream<String> mySecondStream = arrList.stream();

        //Multi-Threading with parallelStream()
        Arrays.stream(arr).parallel().forEach(System.out::println); //Note that the order is not preserved here, since its parallel..
        System.out.println("*********");
        Arrays.stream(arr).forEach(System.out::println); //Order preserved

        //Some cool stream operations!
        //Streams are made up of two kinds of operations, intermediary and terminal operations.
        //Intermediary operations return a type Stream<T>
        //Terminal operations return a definitive type, as seen below.

        Stream<String> myThirdStream = Stream.of("a", "b", "c", "d", "d");
        long count = myThirdStream.distinct().count(); //Note that .distinct() here is based on the elements equal() function.
        System.out.println("The count of each distinct element: " + count);

        //Iterating with streams can make some simple operations easier!
        Stream<String> myFourthStream = Stream.of("a", "b", "c", "d", "d");
        boolean hasA = myFourthStream.anyMatch(element -> "a".equals(element)); //Terminal operation
        System.out.println("Does this list have the character 'a'? : " + hasA);

        //Map & reduce!
        //We convert the elements of a stream to a new element using a specified function! The new elements are then collected into a new stream!
        Stream<String> myFifthStream = Stream.of("a", "b", "c", "d", "d");
        int result = myFifthStream.map(this::getCharNumber).reduce(0, Integer::sum);
        System.out.println("The sum of all char codes is : " + result);

        //Lets filter!
        Stream<String> mySixthStream = Stream.of("a", "b", "c", "d", "d");
        long numberOfLetterD = mySixthStream.map(this::isLetterD).filter(bool -> bool).count();
        System.out.println("The the number of letter Ds is : " + numberOfLetterD);

        //We can also use flatmap to iterate and perform operations over the inner collections of a collection!
        List<List<String>> nestedCollection = new ArrayList<>();
        List<String> arrayListOne = new ArrayList<>();
        arrayListOne.add("a");
        arrayListOne.add("b");
        arrayListOne.add("c");
        arrayListOne.add("d");
        List<String> arrayListTwo = new ArrayList<>();
        arrayListTwo.add("d");
        arrayListTwo.add("d");
        arrayListTwo.add("d");
        arrayListTwo.add("d");
        arrayListTwo.add("d");
        arrayListTwo.add("d");
        arrayListTwo.add("d");

        nestedCollection.add(arrayListOne);
        nestedCollection.add(arrayListTwo);

        long numberOfLetterDInNestedCollection
                = nestedCollection
                        .stream()
                        .flatMap(Collection::stream)
                        .map(this::isLetterD)
                        .filter(bool -> bool)
                        .count();

        System.out.println("The the number of letter Ds in this nested collection is : " + numberOfLetterDInNestedCollection);

        //Matching! The Stream API provides a set of self-evident and handy methods to validate elements of a sequence.

        //anyMatch() checks if any elements in the collection being streamed satisfy the given predicate
        List<String> anyMatchList = new ArrayList<>();
        anyMatchList.add("a");
        anyMatchList.add("b");
        anyMatchList.add("c");
        anyMatchList.add("d");

        boolean hasAnyMatch = anyMatchList.stream().anyMatch("c"::equalsIgnoreCase);
        System.out.println("Do any elements in the list match the character 'c'? : " + hasAnyMatch);

        //allMatch() checks if all elements in the collection being streamed satisfy the given predicate
        List<String> allMatchList = new ArrayList<>();
        allMatchList.add("a");
        allMatchList.add("a");
        allMatchList.add("a");
        allMatchList.add("d");
        boolean doAllMatch = allMatchList.stream().allMatch("a"::equalsIgnoreCase);
        System.out.println("Do all elements in the list match the character 'a'? : " + doAllMatch);

        List<String> noneMatchList = new ArrayList<>();
        noneMatchList.add("w");
        noneMatchList.add("x");
        noneMatchList.add("y");
        noneMatchList.add("z");
        boolean hasNoMatch = noneMatchList.stream().noneMatch("a"::equalsIgnoreCase);
        System.out.println("Do no elements in the list match the character 'a'? : " + hasNoMatch);

        //For empty streams allMatch returns true, as all elements of the list would satisfy the predicate.
        boolean isTrueWhenEmpty = Stream.empty().allMatch(Objects::nonNull);
        System.out.println("An empty stream with allMatch is always true : " + isTrueWhenEmpty);

        //For empty streams anyMatch returns false, as no elements of the list can satisfy the predicate.
        boolean isFalseWhenEmpty = Stream.empty().anyMatch(Objects::nonNull);
        System.out.println("An empty stream with anyMatch is always false : " + isFalseWhenEmpty);

        //Reduction! We saw some earlier, this operation allows a sequence of elements in a collection to be reduced down to one value..
        //..according to a specified function.
        List<String> abcList = Arrays.asList("a", "b", "c");
        String abcListConcat = abcList.stream().reduce("", (a,b) -> a + b); //Note the identity parameter is the starting value for the accumulation function
        System.out.println("The reduced abc list : " + abcListConcat);

        //Collecting! This operation is handy for reducing a Stream back into a Collection of elements.
        //Allowing us to perform functions on elements via a Stream and then collect the elements once again.
        //We can also create our own custom collectors if required.
        List<String> lowerCaseList = Arrays.asList("a", "b", "c");
        List<String> upperCaseList = lowerCaseList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("The lowerCaseList has been converted to an upperCaseList: " + upperCaseList);
    }


    private int getCharNumber (String s) {
        return s.toCharArray()[0];
    }

    private boolean isLetterD (String s) {
        return "d".equalsIgnoreCase(s);
    }
}
