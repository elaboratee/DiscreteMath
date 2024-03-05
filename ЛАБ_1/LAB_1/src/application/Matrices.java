package application;

import java.util.Arrays;

public class Matrices {
    public static Matrix toAdjacencyMatrix (Matrix matrix) {
        Matrix incidenceMatrix = null;

        try {
            incidenceMatrix = (Matrix) matrix.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Matrix adjacencyMatrix = new Matrix(incidenceMatrix.getV());
        incidenceMatrix = transpose(incidenceMatrix);

        int index_j;
        int index_i;
        int rowSum;

        int[] row;
        for (int i = 0; i < incidenceMatrix.getMatrix().length; i++) {
            row = incidenceMatrix.getRow(i);

//            System.out.println(Arrays.toString(row));

            rowSum = findRowSum(row);

            if (rowSum == 0) {
//                index_j = Arrays.binarySearch(row, -1);
//                index_i = Arrays.binarySearch(row, 1);

                index_j = indexOf(row, -1);
                index_i = indexOf(row, 1);

//                System.out.printf("i = %d\tj = %d\nsum = %d\n", index_i, index_j, rowSum);

                adjacencyMatrix.setElement(index_i, index_j, 1);
            } else if (rowSum == 2) {
//                index_j = Arrays.binarySearch(row, 1);
//                index_i = Arrays.binarySearch(row, index_j + 1, row.length - 1, 1);

                index_j = indexOf(row, 1);
                index_i = indexOf(row, index_j + 1, row.length, 1);

//                System.out.printf("i = %d\tj = %d\nsum = %d\n", index_i, index_j, rowSum);

                adjacencyMatrix.setElement(index_i, index_j, 1);
                adjacencyMatrix.setElement(index_j, index_i, 1);
            } else {
//                index_i = Arrays.binarySearch(row, 1);

                index_i = indexOf(row, 1);

//                System.out.printf("i = %d\nsum = %d\n", index_i, rowSum);

                adjacencyMatrix.setElement(index_i, index_i, 1);
            }
        }
        return adjacencyMatrix;
    }

    //    static Matrix toIncidenceMatrix(Matrix matrix) {}

    private static Matrix transpose(Matrix matrix) {
        Matrix newMatrix = new Matrix();
        newMatrix.setMatrix(new int[matrix.getH()][matrix.getV()]);

        for (int i = 0; i < matrix.getH(); i++) {
            for (int j = 0; j < matrix.getV(); j++) {
                newMatrix.setElement(i, j, matrix.getElement(j, i));
            }
        }
        return newMatrix;
    }

    private static int findRowSum(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return sum;
    }

    private static int indexOf(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private static int indexOf(int[] array, int fromIndex, int toIndex, int key) {
        for (int i = fromIndex; i < toIndex; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
