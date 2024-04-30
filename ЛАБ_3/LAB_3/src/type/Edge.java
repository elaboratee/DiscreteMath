package type;

import java.util.Objects;

public class Edge {

    private final Integer source;
    private final Integer target;

    public Edge(int source, int target) {
        this.source = source;
        this.target = target;
    }

    public String getSource() {
        return "x" + String.valueOf(source);
    }

    public int getSourceIndex() {
        return source;
    }

    public String getTarget() {
        return "x" + String.valueOf(target);
    }

    public int getTargetIndex() {
        return target;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(getSource(), edge.getSource()) && Objects.equals(getTarget(), edge.getTarget());
    }

    @Override
    public String toString() {
        return "(" + getSource() + ", " + getTarget() + ")";
    }
}
