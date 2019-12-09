public class GraphEdge {
    private int first_vertex;
    private int second_vertex;
    private int weight;

    public GraphEdge() {
        first_vertex = 0;
        second_vertex = 0;
        weight = 0;
    }

    public GraphEdge(int first_vertex, int second_vertex, int weight) {
        this.first_vertex = first_vertex;
        this.second_vertex = second_vertex;
        this.weight = weight;
    }

    public void changeVertexOrder() {
        int temp = first_vertex;
        first_vertex = second_vertex;
        second_vertex = temp;
    }

    public Integer getSecond_vertex() {
        return second_vertex;
    }

    public Integer getFirst_vertex() {
        return first_vertex;
    }

    public Integer getWeight() {
        return weight;
    }

    public boolean equals(GraphEdge other) {
        if (other.weight == weight) {
            return (other.first_vertex == first_vertex && other.second_vertex == second_vertex) ||
                    other.first_vertex == second_vertex && other.second_vertex == first_vertex;
        }

        return false;
    }

    @Override
    public String toString() {
        return "{" + first_vertex + ", " + second_vertex + "}";
    }
}