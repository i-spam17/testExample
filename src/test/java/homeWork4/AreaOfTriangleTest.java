package homeWork4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AreaOfTriangleTest {
    private static Logger logger = LoggerFactory.getLogger(AreaOfTriangleTest.class);
    AreaOfTriangle areaOfTriangle = new AreaOfTriangle();

    @Test
    @DisplayName("Позитивная проверка метода расчета площади треугольника calculateTriangleArea ")
    void givenAreaTriangleWhenInputValidDataThenTrue() {
        logger.debug("debug log");
        double[] testDataArr = {3.0, 4.0, 5};
        Assertions.assertEquals(6, areaOfTriangle.calculateTriangleArea(testDataArr));
    }

}
