package exposed;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class C5 {


    public interface Logging {
        void write(String message);
    }

    public class ConsoleLogging implements Logging {
        @Override
        public void write(final String message){
            System.out.println(message);
        }
    }


    public static void deneme() {
        Map<String, Integer> hashmap = new TreeMap<>();
        Set<String> mySet = new HashSet<>();
        mySet.add("osman");
        mySet.add("kerem");
    }

}
