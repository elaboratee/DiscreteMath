package application;

import java.util.Arrays;

public class PathFinder {
    public static int[] findShortestPath(Matrix matrix) {
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
}
