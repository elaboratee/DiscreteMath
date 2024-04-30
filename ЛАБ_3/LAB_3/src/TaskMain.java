import exceptions.FileInputException;
import type.Edge;
import type.Matrix;
import type.SpanningTree;
import util.Graphs;
import util.InOut;

import java.util.Arrays;
import java.util.List;

public class TaskMain {

    public static void main(String[] args) {
        Matrix matrix = null;
        try {
            matrix = new Matrix(InOut.readMatrix("files/second.txt"));
        } catch (FileInputException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Исходная матрица инцидентности:");
        InOut.printMatrix(matrix);

        assert matrix != null;
        SpanningTree spanningTree = Graphs.primaKruskal(matrix);

        List<String> vertexesList = spanningTree.getVertexes().stream()
                .map(v -> "x" + (v + 1))
                .toList();

        List<Edge> edgesList = spanningTree.getEdges().stream()
                .map(edge -> new Edge(edge.getSourceIndex() + 1, edge.getTargetIndex() + 1))
                .toList();

        boolean[] isVisited = spanningTree.getTags();

        int treeLength = spanningTree.getLength();

        System.out.println("ПОЛУЧЕННОЕ ОСТОВНОЕ ДЕРЕВО");
        System.out.println("Множество вершин: " + vertexesList);
        System.out.println("Множество ребер: " + edgesList);
        System.out.println("Пометки вершин: " + Arrays.toString(isVisited));
        System.out.println("Длина остовного дерева: " + treeLength);
    }
}
