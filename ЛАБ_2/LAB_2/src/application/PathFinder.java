package application;

import java.util.Arrays;

public class PathFinder {
    public static Path findShortestPath(Matrix matrix) {
        Matrix clonedMatrix = null;

        try {
            clonedMatrix = (Matrix) matrix.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Расстановка пометок вершин
        int[] labels = findLabels(clonedMatrix);

        // Поиск кратчайшего пути
        String pathString = findWay(labels, clonedMatrix);

        return new Path(labels, pathString);
    }

    public static int[] findLabels(Matrix matrix) {
        Matrix clonedMatrix = null;

        try {
            clonedMatrix = (Matrix) matrix.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Размерность матрицы
        final int SIZE = clonedMatrix.getH();

        // Создание массива пометок
        int[] labels = new int[SIZE];
        Arrays.fill(labels,1, SIZE, Integer.MAX_VALUE);

        // Расстановка пометок
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                int currentElement = clonedMatrix.getElement(i, j);
                if (currentElement != -1) {
                    labels[j] = Math.min(labels[j], labels[i] + currentElement);
                }
            }
        }

        return labels;
    }

    public static String findWay(int[] labels, Matrix matrix)
            throws IllegalArgumentException {
        Matrix clonedMatrix = null;

        try {
            clonedMatrix = (Matrix) matrix.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Размерность матрицы
        final int SIZE = clonedMatrix.getH();

        if (labels == null || labels.length != SIZE) {
            throw new IllegalArgumentException("Label array is invalid");
        }

        // Поиск пути
        StringBuilder sb = new StringBuilder();
        sb.append(SIZE).append("x");
        for (int j = SIZE - 1; j >= 0; j--) {
            for (int i = SIZE - 1; i >= 0; i--) {
                int currentElement = clonedMatrix.getElement(i, j);

                boolean FirstIf = (currentElement != -1);
                boolean LastIf = (labels[j] == labels[i] + currentElement);

                if (FirstIf && LastIf) {
                    sb.append(';').append(j).append('x');
                }
            }
        }
        return sb.reverse().toString();
    }
}
