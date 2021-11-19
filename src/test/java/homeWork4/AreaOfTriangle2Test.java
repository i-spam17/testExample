package homeWork4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AreaOfTriangle2Test {
    private static Logger logger = LoggerFactory.getLogger(AreaOfTriangleTest.class);

    @Test
    @DisplayName("Позитивная проверка метода расчета площади треугольника ")
    void givenAreaTriangleWhenInputValidDataThenTrue() {
        logger.info("info log");
        Assertions.assertEquals(6, AreaOfTriangle2.calculateTriangleArea(3, 4, 5));
    }

    @Test
    @DisplayName("Негативная проверка метода расчета площади треугольника ")
    void givenAreaTriangleWhenInputInvalidDataThenTrue() {
        logger.debug("debug log");
        Assertions.assertThrows(MyException.class, () -> AreaOfTriangle2.calculateTriangleArea(-3, 4, 5));
    }

    @Test
    @DisplayName("Негативная проверка существования треугольника ")
    void isTriangleReal() {
        logger.trace("trace log");
        Assertions.assertThrows(MyException.class, () -> AreaOfTriangle2.calculateTriangleArea(3, 4, 8));
    }
}
