package application;

import exceptions.FileInputException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InOut {
    public static int[][] readMatrix(String filename) throws FileInputException {
        int[][] inMatrix;
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            inMatrix = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (scanner.hasNextInt()) {
                        inMatrix[i][j] = scanner.nextInt();
                    } else {
                        scanner.close();
                        throw new FileInputException("File doesn't contain enough" +
                                "elements for matrix of size" + rows + "x" + cols);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new FileInputException("File not found: " + e.getMessage());
        }
        return inMatrix;
    }

    public static void printMatrix(Matrix matrixObject) {
        if (matrixObject == null) {
            System.out.println("Matrix is empty or invalid");
            return;
        }

        StringBuilder sb = new StringBuilder();
        int[][] matrix = matrixObject.getMatrix();

        for (int[] row : matrix) {
            for (int element : row) {
                String elString = String.format("%3d", element);
                sb.append(elString).append("\t");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void printLabels(int[] array) {
        if (array == null) {
            System.out.println("Array is empty or invalid");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            String elString = "L(x" + (i + 1) + ") = " + array[i];
            sb.append(elString).append('\n');
        }
        System.out.println(sb.toString());
    }
}
