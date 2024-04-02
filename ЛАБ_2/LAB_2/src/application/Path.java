package application;

import java.util.Arrays;
import java.util.Objects;

public class Path {
    final int[] labels;
    final String pathString;

    public Path(int[] labels, String pathString) {
        this.labels = labels;
        this.pathString = pathString;
    }

    public int[] getLabels() {
        return labels;
    }

    public String getPathString() {
        return pathString;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Path path = (Path) object;
        return Arrays.equals(labels, path.labels) && Objects.equals(pathString, path.pathString);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(pathString);
        result = 31 * result + Arrays.hashCode(labels);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Пометки вершин:\n");
        for (int i = 0; i < labels.length; i++) {
            String elString = "L(x" + (i + 1) + ") = " + labels[i];
            sb.append(elString).append('\n');
        }
        sb.append("Кратчайший путь: ").append(pathString);

        return sb.toString();
    }
}
