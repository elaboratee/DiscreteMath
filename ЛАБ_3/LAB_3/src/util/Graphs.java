package util;

import type.Edge;
import type.Matrix;
import type.SpanningTree;

import java.util.ArrayList;
import java.util.Arrays;

public class Graphs {

    /**
     * Prima-Kruskal algorithm of building a spanning tree from the incidence {@link Matrix}
     * @param matrix incidence {@link Matrix} representing non-oriented graph
     * @return ArrayList of {@link Edge}s included in the spanning tree
     * @see Matrix
     * @see Matrices
     */
    public static SpanningTree primaKruskal(Matrix matrix) {

        ArrayList<Integer> vertexes = new ArrayList<>(); // ArrayList of added to the spanning tree vertexes
        ArrayList<Edge> edges = new ArrayList<>(); // ArrayList of the spanning tree output edges (will be returned)
        boolean[] tags = new boolean[matrix.getV()]; // Array of vertex boolean tags
        int length = 0;

        vertexes.add(0);  // Add first vertex of the spanning tree (always vertex with index = 1)
        tags[0] = true; // Set first vertex tag

        // Continue iterations until all vertexes added into the spanning tree
        while (vertexes.size() != matrix.getV()) {
            int minEdgeLength = Integer.MAX_VALUE;  // Minimal edge length on each iteration
            int indexOfMinStart = -1;  // Index of a minimal edge start
            int indexOfMinEnd = -1;  // Index of a minimal edge end

            for (int i = 0;  i < matrix.getV() - 1; i++) {
                // If specified vertex already added to the spanning tree
                if (vertexes.contains(i)) {
                    int[] row = matrix.getRow(i);
                    for (int j = 0; j < row.length - 1; j++) {
                        if (row[j] != 0) {
                            int indexOfPairColumnElement = Matrices.indexOf(matrix.getColumn(j), row[j], i);
                            if (!tags[indexOfPairColumnElement] && row[j] < minEdgeLength) {
                                minEdgeLength = row[j];
                                indexOfMinStart = i;
                                indexOfMinEnd = indexOfPairColumnElement;
                            }
                        }
                    }
                }
            }
            tags[indexOfMinEnd] = true;
            vertexes.add(indexOfMinEnd);
            edges.add(new Edge(indexOfMinStart, indexOfMinEnd));
            length += minEdgeLength;
        }
        return new SpanningTree(vertexes, edges, tags, length);
    }
}
