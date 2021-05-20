import java8.functional.FunctionalDigest;
import java8.streams.StreamsDigest;

public class Main {
    public static void main(String[] args) {
        //Insert desired driver here...
        StreamsDigest streamsDigest = new StreamsDigest();
        streamsDigest.getJava8StreamFeatures();
        FunctionalDigest functionalDigest = new FunctionalDigest();
        functionalDigest.getJava8FunctionalFeatures();
    }
}
