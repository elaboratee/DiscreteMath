package application;

import exceptions.FileInputException;

public class TaskMain {
    public static void main(String[] args) {
        Matrix matrix = null;
        try {
            matrix = new Matrix(InOut.readMatrix("files/matrix_2.txt"));
        } catch (FileInputException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Исходная матрица инцидентности:");
        InOut.printMatrix(matrix);

        System.out.println("Матрица смежности:");
        matrix = Matrices.toAdjacencyMatrix(matrix);
        InOut.printMatrix(matrix);

        System.out.println("Матрица инцидентности:");
        matrix = Matrices.toIncidenceMatrix(matrix);
        InOut.printMatrix(matrix);

        System.out.println("Матрица смежности (для проверки в обратную сторону):");
        matrix = Matrices.toAdjacencyMatrix(matrix);
        InOut.printMatrix(matrix);
    }
}
