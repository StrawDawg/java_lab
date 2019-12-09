import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyList {
    private static class AdjacencyListLine extends LinkedList<GraphEdge> {};

    private AdjacencyListLine[] adjList;

    private AdjacencyList(AdjacencyListLine[] adjList) {
        this.adjList = new AdjacencyListLine[adjList.length];

        System.arraycopy(adjList, 0, this.adjList, 0, adjList.length);
    }

    public static AdjacencyList parseAdjacencyList(List<String> lines) {
        int vertex_count = Integer.parseInt(lines.get(0).split("[ ]+")[0]);

        AdjacencyListLine[] adjList = new AdjacencyListLine[vertex_count];
        for(int i = 0; i < vertex_count; i++) {
            adjList[i] = new AdjacencyListLine();
        }

        Iterator<String> it = lines.listIterator(1);

        while(it.hasNext()) {
            String[] splitLine = it.next().split("[ ]+");

            int first_vertex = Integer.parseInt(splitLine[0]);
            int second_vertex = Integer.parseInt(splitLine[1]);
            int weight = Integer.parseInt(splitLine[2]);

            adjList[first_vertex - 1].add(new GraphEdge(first_vertex, second_vertex, weight));
            adjList[second_vertex - 1].add(new GraphEdge(second_vertex, first_vertex, weight));
        }

        return new AdjacencyList(adjList);
    }

    public AdjacencyListLine[] getAdjList() {
        return adjList;
    }

    private GraphEdge getMinWeightEdge(List<GraphEdge> edges, boolean[] used) {
        GraphEdge min = new GraphEdge(-1, -1, Integer.MAX_VALUE);

        for(GraphEdge edge: edges) {
            if(min.getWeight() > edge.getWeight() &&
                    (!used[edge.getFirst_vertex() - 1] || !used[edge.getSecond_vertex() - 1])) {
                min = edge;
            }
        }

        return min;
    }

    public List<GraphEdge> getMinSubTree() {
        List<GraphEdge> treeEdges = new ArrayList<>();

        List<GraphEdge> temp = adjList[0];
        boolean[] used = new boolean[adjList.length];
        used[0] = true;

        GraphEdge min = getMinWeightEdge(temp, used);

        while(min.getWeight() < Integer.MAX_VALUE) {
            temp.addAll(adjList[min.getSecond_vertex() - 1]);
            temp.remove(min);

            used[min.getSecond_vertex() - 1] = true;

            if (min.getSecond_vertex() < min.getFirst_vertex()) {
                min.changeVertexOrder();
            }
            treeEdges.add(min);

            min = getMinWeightEdge(temp, used);
        }

        return treeEdges;
    }

}