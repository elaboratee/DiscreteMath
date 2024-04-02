package application;

/*
    Сделать пометки всех вершин L(x_i)
    Найти кратчайший путь от x_1 до x_n
 */

import exceptions.FileInputException;

import java.sql.SQLOutput;

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

        System.out.println(PathFinder.findShortestPath(matrix));
    }
}
