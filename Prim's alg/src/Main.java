import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String path = "input.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

            AdjacencyList adjList = AdjacencyList.parseAdjacencyList(lines);

            List<GraphEdge> minSubTree = adjList.getMinSubTree();

            Comparator<GraphEdge> comparator = new Comparator<GraphEdge>() {
                @Override
                public int compare(GraphEdge x, GraphEdge y) {
                    int compareFirst = x.getFirst_vertex().compareTo(y.getFirst_vertex());
                    return compareFirst == 0 ? x.getSecond_vertex().compareTo(y.getSecond_vertex()): compareFirst;
                }
            };

            minSubTree.stream().sorted(comparator).forEach(System.out::print);
            System.out.println("\n" + minSubTree.stream().mapToInt(GraphEdge::getWeight).sum());


        }catch(IOException ex) {
            System.out.print(ex.getMessage());
        }

    }
}