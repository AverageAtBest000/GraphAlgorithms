import java.util.*;
import java.io.*;

class Dijkstra {

  public class Node {
    public int weight;
    public int value;

    public Node(int weight, int value) {
      this.weight = weight;
      this.value = value;
    }

    public String tString() {
      return value + weight + "";
    }
  }

  public void main(String[] args) throws IOException {

    HashMap<Integer, ArrayList<Node>> graph = new HashMap<Integer, ArrayList<Node>>();

    BufferedReader br = new BufferedReader(new FileReader("dijkstra_input.txt"));

    StringTokenizer strtok = new StringTokenizer(br.readLine());
    int v = Integer.parseInt(strtok.nextToken());
    int e = Integer.parseInt(strtok.nextToken());
    int startingNode = Integer.parseInt(strtok.nextToken());

    while (v-- > 0) {
      graph.put(v, new ArrayList<Node>());
    }

    String line = br.readLine();

    while (line != null) {

      StringTokenizer strTok = new StringTokenizer(line);

      int from = Integer.parseInt(strTok.nextToken());
      int to = Integer.parseInt(strTok.nextToken());
      int weight = Integer.parseInt(strTok.nextToken());

      graph.get(from).add(new Node(weight, to));

      line = br.readLine();
    }

    search(graph, startingNode);

    br.close();
  }

  public void search(HashMap<Integer, ArrayList<Node>> graph, int startingNode) {

    PriorityQueue<Node> queue = new PriorityQueue<Node>((a, b) -> a.weight - b.weight);
    int[] dists = new int[graph.size()];
    Arrays.fill(dists, Integer.MAX_VALUE);
    boolean[] visited = new boolean[graph.size()];

    queue.add(new Node(startingNode, 0));
    dists[startingNode] = 0;

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      visited[current.value] = true;

      for (Node neighboor : graph.get(current.value)) {

        if (dists[neighboor.value] > dists[current.value] + neighboor.weight) {
          dists[neighboor.value] = dists[current.value] + neighboor.weight;
        }

        if (!visited[neighboor.value]) {
          queue.add(neighboor);
        }
      }
    }

    for (int i = 0; i < dists.length; i++)
      System.out.println(i + " " + dists[i]);
  }
}
