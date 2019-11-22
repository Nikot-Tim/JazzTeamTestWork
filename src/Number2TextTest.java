import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class Number2TextTest {

    @Test
    public void inputValidation() {
        String actual = Number2Text.inputValidation(0);
        String expected = "ноль";

        String actual1 = Number2Text.inputValidation(1);
        String expected1 = "один";
        String actual2 = Number2Text.inputValidation(-1);
        String expected2 = "минус один";
        String actual3 = Number2Text.inputValidation(12);
        String expected3 = "двенадцать";
        String actual4 = Number2Text.inputValidation(123);
        String expected4 = "сто двадцать три";
        String actual5 = Number2Text.inputValidation(1234);
        String expected5 = "одна тысяча двести тридцать четыре";
        String actual6 = Number2Text.inputValidation(2234);
        String expected6 = "две тысячи двести тридцать четыре";
        String actual7 = Number2Text.inputValidation(5234);
        String expected7 = "пять тысяч двести тридцать четыре";
        Assertions.assertAll(
                ()->assertEquals(actual, expected),
                ()->assertEquals(actual1, expected1),
                ()->assertEquals(actual2, expected2),
                ()->assertEquals(actual3, expected3),
                ()->assertEquals(actual4, expected4),
                ()->assertEquals(actual5, expected5),
                ()->assertEquals(actual6, expected6),
                ()->assertEquals(actual7, expected7)
        );
    }
}