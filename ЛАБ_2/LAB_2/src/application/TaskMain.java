package application;

/*
    Сделать пометки всех вершин L(x_i)
    Найти кратчайший путь от x_1 до x_n
 */

import exceptions.FileInputException;

public class TaskMain {
    public static void main(String[] args) {
        Matrix matrix = null;
        try {
            matrix = new Matrix(InOut.readMatrix("files/matrix_1.txt"));
        } catch (FileInputException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Исходная матрица смежности:");
        InOut.printMatrix(matrix);
    }
}
