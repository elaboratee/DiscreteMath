package type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class SpanningTree {

    // Spanning tree vertexes
    private final ArrayList<Integer> vertexes;

    // Spanning tree edges
    private final ArrayList<Edge> edges;

    // Vertex boolean tags
    private final boolean[] tags;

    // SpanningTree length
    private final int length;

    public SpanningTree(ArrayList<Integer> vertexes,
                        ArrayList<Edge> edges,
                        boolean[] tags,
                        Integer length) {
        this.vertexes = vertexes;
        this.edges = edges;
        this.tags = tags;
        this.length = length;
    }

    public ArrayList<Integer> getVertexes() {
        return vertexes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public boolean[] getTags() {
        return tags;
    }

    public Integer getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpanningTree that = (SpanningTree) o;
        return Objects.equals(getVertexes(), that.getVertexes()) && Objects.equals(getEdges(), that.getEdges()) && Objects.deepEquals(getTags(), that.getTags()) && Objects.equals(getLength(), that.getLength());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVertexes(), getEdges(), Arrays.hashCode(getTags()), getLength());
    }

    @Override
    public String toString() {
        return "\nVertexes: " + vertexes.toString() +
                "\nEdges: " + edges.toString() +
                "\nTags: " + Arrays.toString(tags) +
                "\nLength: " + length;
    }
}
