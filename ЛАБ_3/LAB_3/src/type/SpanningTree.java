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

    public SpanningTree(ArrayList<Integer> vertexes, ArrayList<Edge> edges, boolean[] tags) {
        this.vertexes = vertexes;
        this.edges = edges;
        this.tags = tags;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpanningTree that = (SpanningTree) o;
        return Objects.equals(getVertexes(), that.getVertexes()) && Objects.equals(getEdges(), that.getEdges()) && Objects.deepEquals(getTags(), that.getTags());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVertexes(), getEdges(), Arrays.hashCode(getTags()));
    }

    @Override
    public String toString() {
        return "\nVertexes: " + vertexes.toString() +
                "\nEdges: " + edges.toString() +
                "\nTags: " + Arrays.toString(tags);
    }
}
