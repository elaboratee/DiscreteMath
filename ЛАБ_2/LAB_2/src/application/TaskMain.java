package application;

/*
    Сделать пометки всех вершин L(x_i)
    Найти кратчайший путь от x_1 до x_n
 */

import exceptions.FileInputException;

import java.util.Arrays;

public class TaskMain {
    public static void main(String[] args) {
        Matrix matrix = null;
        try {
            matrix = new Matrix(InOut.readMatrix("files/first.txt"));
        } catch (FileInputException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Исходная матрица смежности:");
        InOut.printMatrix(matrix);

        System.out.println("Пометки вершин:");
        InOut.printArray(PathFinder.findShortestPath(matrix));
//        System.out.println(Arrays.toString(PathFinder.findShortestPath(matrix)));
    }
}
