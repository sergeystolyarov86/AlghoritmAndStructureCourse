package homeWork7;

import java.util.Objects;

class Vertex {
    private String label;
    private boolean wasVisited;

    public Vertex(String label) {
        this.label = label;
        this.wasVisited = false;
    }
    public String getLabel() {
        return label;
    }
    public boolean isWasVisited() {
        return wasVisited;
    }
    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return wasVisited == vertex.wasVisited && Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, wasVisited);
    }

    @Override
    public String toString() {
        return label;
    }
}
