package exposed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tyr on 6/6/14.
 */
public class C8Person {

    private final String name;
    private final int age;
    public C8Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        C8Person c8Person = (C8Person) o;
        if (age != c8Person.age) return false;
        if (name != null ? !name.equals(c8Person.name) : c8Person.name != null) return false;
        return true;

    }


}