package application;

import java.util.Arrays;
import java.util.Objects;

public class Matrix implements Cloneable {
    // Fields
    private int[][] matrix;
    private int v; // vertical size
    private int h; // horizontal size

    // Constructors
    public Matrix() {};

    public Matrix(int v, int h) {
        this.v = v;
        this.h = h;
        this.matrix = new int[v][h];
    }

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.v = matrix.length;
        this.h = matrix[0].length;
    }

    public Matrix(int size) {
        this.matrix = new int[size][size];
        this.v = size;
        this.h = size;
    }

    // Getters and setters
    public void setV(int v) {
        this.v = v;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void setElement(int i, int j, int value) {
        this.matrix[i][j] = value;
    }

    public int getV() {
        return v;
    }

    public int getH() {
        return h;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getElement(int i, int j) {
        return matrix[i][j];
    }

    public int[] getRow(int i) {
        return matrix[i];
    }

    // Methods
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Matrix matrix1 = (Matrix) object;
        return getV() == matrix1.getV() && getH() == matrix1.getH() &&
                Arrays.deepEquals(getMatrix(), matrix1.getMatrix());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getV(), getH());
        result = 31 * result + Arrays.deepHashCode(getMatrix());
        return result;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.deepToString(matrix) +
                ", v=" + v +
                ", h=" + h +
                '}';
    }
}
