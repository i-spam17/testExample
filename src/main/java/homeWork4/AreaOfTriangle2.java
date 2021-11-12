package homeWork4;

import java.util.stream.Stream;

public class AreaOfTriangle2 {
    public static void main(String[] args) {
        calculateTriangleArea(3, 4, 5);
    }
//проверка ввода отрицательного цисла
    public static double calculateTriangleArea(double sideA, double sideB, double sideC) throws MyException {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) throw new MyException("Введете число больше ноля! ");

//проверка существования треугольника
        double maxSide = Stream.of(sideA, sideB, sideC).max((Double::compareTo)).get();
        double sumOtherTriangleSides = Stream.of(sideA, sideB, sideC)
                .sorted(Double::compareTo)
                .limit(2)
                .reduce((aDouble, aDouble2) -> aDouble + aDouble2)
                .get();
//        System.out.println("max side " + maxSide + "sum sides = " + sumOtherTriangleSides);
        if (maxSide > sumOtherTriangleSides) throw new MyException("Такой треугольник не существует! " +
                "Введите стороны треугольника, соблюдая условие: А + В > С");

//расчет треугольника
        double halfPer = (sideA + sideB + sideC) / 2;
        double areaOfTriangle = Math.sqrt(halfPer * (halfPer - sideA) * (halfPer - sideB) * (halfPer - sideC));
        System.out.println("Площадь треугольника = " + areaOfTriangle + " см2");
        return areaOfTriangle;
    }
}
