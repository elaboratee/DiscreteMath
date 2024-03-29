package application;

import java.util.Arrays;

public class Matrices {
    /**
     * Translation from the incidence matrix to adjacency
     * @param matrix - The incidence matrix
     * @return The adjacency matrix
     */
    public static Matrix toAdjacencyMatrix(Matrix matrix) {
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
            rowSum = findRowSum(row);

            if (rowSum == 0) {
                index_j = indexOf(row, -1);
                index_i = indexOf(row, 1);
                adjacencyMatrix.setElement(index_i, index_j, 1);
            } else if (rowSum == 2) {
                index_j = indexOf(row, 1);
                index_i = indexOf(row, index_j + 1, row.length, 1);
                adjacencyMatrix.setElement(index_i, index_j, 1);
                adjacencyMatrix.setElement(index_j, index_i, 1);
            } else {
                index_i = indexOf(row, 1);
                adjacencyMatrix.setElement(index_i, index_i, 1);
            }
        }
        return adjacencyMatrix;
    }

    /**
     * Translation from the adjacency matrix to incidence
     * @param matrix The adjacency matrix
     * @return The incidence matrix
     */
    public static Matrix toIncidenceMatrix(Matrix matrix) {
        Matrix adjacencyMatrix = null;

        try {
            adjacencyMatrix = (Matrix) matrix.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        int amountRows = adjacencyMatrix.getV();
        int amountColumns = adjacencyMatrix.getH();
        int amountArcs = findArcAmount(matrix.getMatrix());

        Matrix incidenceMatrix = new Matrix(amountRows, amountArcs);

        int arcCounter = 0;

        for (int i = 0; i < amountRows; i++) {
            for (int j = 0; j < amountColumns; j++) {
                if (adjacencyMatrix.getElement(i, j) == 1) {
                    if (i == j) {
                        incidenceMatrix.setElement(i, arcCounter, 1);
                    } else {
                        incidenceMatrix.setElement(i, arcCounter, 1);
                        incidenceMatrix.setElement(j, arcCounter, -1);
                    }
                    arcCounter++;
                }
            }
        }
        return incidenceMatrix;
    }

    /**
     * Matrix transposition
     * @param matrix Any object of the matrix
     * @return The transposed of matrix
     */
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

    /**
     * Find the sum of the elements of the matrix row
     * @param row The row of the matrix
     * @return The sum of the elements of the matrix row
     */
    private static int findRowSum(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return sum;
    }

    /**
     * Find the amount of the arcs of the matrix
     * @param matrix The adjacency matrix
     * @return The number of arcs in the incident matrix
     */
    private static int findArcAmount(int[][] matrix) {
        int countArc = 0;
        for (int[] row : matrix) {
            countArc += findRowSum(row);
        }
        return countArc;
    }

    /**
     * Find the index of an array element by its value
     * @param array Any array
     * @param key The value of the element
     * @return The index of the element
     */
    private static int indexOf(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Find the index of an array element by its value in a certain segment
     * @param array Any array
     * @param fromIndex The beginning of the interval
     * @param toIndex End of the interval
     * @param key The value of the element
     * @return
     */
    private static int indexOf(int[] array, int fromIndex, int toIndex, int key) {
        for (int i = fromIndex; i < toIndex; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
