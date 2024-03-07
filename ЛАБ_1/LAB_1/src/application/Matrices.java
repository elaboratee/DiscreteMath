package application;

import java.util.Arrays;

public class Matrices {
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

    public static Matrix toIncidenceMatrix(Matrix matrix) {
        Matrix adjacencyMatrix = null;

        try {
            adjacencyMatrix = (Matrix) matrix.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Matrix incidenceMatrix = new Matrix(adjacencyMatrix.getV(), findArcAmount(matrix.getMatrix()));

        int arcCounter = 0;

        for (int i = 0; i < adjacencyMatrix.getV(); i++) {
            for (int j = i; j < adjacencyMatrix.getH(); j++) {
                // диагональный элемент (петля)
                if (i == j && adjacencyMatrix.getElement(i, j) == 1) {
                    incidenceMatrix.setElement(i, arcCounter, 1);
                    arcCounter++;
                } else {
                    if (adjacencyMatrix.getElement(i, j) == 1 && adjacencyMatrix.getElement(j, i) == 1) {
                        incidenceMatrix.setElement(i, arcCounter, 1);
                        incidenceMatrix.setElement(j, arcCounter, 1);
                        arcCounter++;
                    } else {
                        if (adjacencyMatrix.getElement(i, j) == 1) {
                            incidenceMatrix.setElement(i, arcCounter, 1);
                            incidenceMatrix.setElement(j, arcCounter, -1);
                            arcCounter++;
                        } else if (adjacencyMatrix.getElement(j, i) == 1) {
                            incidenceMatrix.setElement(j, arcCounter, 1);
                            incidenceMatrix.setElement(i, arcCounter, -1);
                            arcCounter++;
                        }
                    }
                }
            }
        }
        return incidenceMatrix;
    }

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

    private static int findColumnSum(int column, int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][column];
        }
        return sum;
    }

    private static int findArcAmount(int[][] matrix) {
        int arcAmount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    arcAmount += 1;
                } else if (matrix[j][i] == 1) {
                    arcAmount += 1;
                }
            }
        }
        return arcAmount;
    }

    public static int findDegreeOfApproach(int index, int[][] matrix) {
        int degree = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[index][i] == -1) {
                degree++;
            } else if (matrix[index][i] == 1) {
                if (findColumnSum(i, matrix) != 0) {
                    degree++;
                }
            }
        }
        return degree;
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
