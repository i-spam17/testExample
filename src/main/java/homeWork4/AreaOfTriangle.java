package homeWork4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        AreaOfTriangle areaOfTriangle = new AreaOfTriangle();
        areaOfTriangle.calculateTriangleArea(areaOfTriangle.getTriangleSides(areaOfTriangle));
    }

    public double checkInputData(char sideTriangleName) {
        Scanner scanner = new Scanner(System.in);
        double sideOfTriangle;
        while (true) {
            System.out.println("Введите сторону треугольника " + sideTriangleName + ", см = ");
            sideOfTriangle = scanner.nextDouble();
            if (sideOfTriangle <= 0) {
                System.out.println("Сторона треугольника не может быть отрицательным числом или равна 0! Введите число больше 0 !");
            } else {
                System.out.println("Сторона треугольника " + sideTriangleName + "= " + sideOfTriangle + " см");
                break;
            }
        }
        return sideOfTriangle;
    }

    public double[] getTriangleSides(AreaOfTriangle areaOfTriangle) {
        double[] triangleSidesArr = new double[3];
        char[] triangleSideNamesArr = {'A', 'B', 'C'};
        for (int i = 0; i < triangleSidesArr.length; i++) {
            while (true) {
                try {
                    triangleSidesArr[i] = areaOfTriangle.checkInputData(triangleSideNamesArr[i]);
                    break;
                } catch (InputMismatchException e) {
                    e.getStackTrace();
                    System.out.println("Введете числовое значение! В качестве разделителя дробной части используйте \",\"");
                }
            }
        }
        System.out.println("Стороны треугольника = " + Arrays.toString(triangleSidesArr) + " см");
        return triangleSidesArr;
    }

    public double calculateTriangleArea(double[] arr) {
        double perimeter = 0;
        for (int i = 0; i < arr.length; i++) {
            perimeter = perimeter + arr[i];
        }
//        System.out.println("периметр треугольника = " + perimeter);
        double areaOfTriangle = Math.sqrt(perimeter / 2 *
                (perimeter/2 - arr[0]) *
                (perimeter/2 - arr[1]) *
                (perimeter/2 - arr[2]));
        System.out.println("Площадь треугольника = " + areaOfTriangle + " см2");
        return areaOfTriangle;
    }
}