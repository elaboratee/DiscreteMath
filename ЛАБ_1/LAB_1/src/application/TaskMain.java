package application;

public class TaskMain {
    public static void main(String[] args) {
        Matrix matrix = null;
        try {
            matrix = new Matrix(InOut.readMatrix("files/matrix.txt"));
        } catch (FileInputException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Исходная матрица инцидентности:");
        InOut.printMatrix(matrix);

        System.out.println("Матрица смежности:");
        matrix = Matrices.toAdjacencyMatrix(matrix);
        InOut.printMatrix(matrix);
    }
}
