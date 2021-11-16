package homeWork4;

import java.util.NoSuchElementException;

public class MyException extends NoSuchElementException {
    public MyException(String message) {
        super(message);
    }
}
