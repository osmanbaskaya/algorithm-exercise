package exposed;

/**
 * Author: Osman Baskaya
 * E-mail: obaskaya@ku.edu.tr
 * Date: 20.Jun.2014 | 18:11
 */
public class StringLengthOperation implements GenericOperation<String, Integer> {
    @Override
    public Integer performOperation(String value) {
        return value.length();
    }

}
