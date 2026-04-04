import java.io.*;
import java.util.*;

// I used ./google-java-format-1.35.0-all-deps.jar as vim doesn't have a good java linter I mean it does but it a whole thing to install it.

public class shortestpath {
  static List<Integer>[] graph;
  static int numVertices;

  public static void readGraph(String filename) throws IOException {
    graph = new ArrayList[50]; // assignment says max 50 vertices so I'm hardcoding it here
    for (int i = 0; i < 50; i++) {
      graph[i] = new ArrayList<>();
    }

    int maxVertex = -1;

    BufferedReader br = new BufferedReader(new FileReader(filename));
    String line;

    while ((line = br.readLine()) != null) {
      line = line.trim();

      if (line.isEmpty()) {
        continue;
      }

      String[] parts = line.split("\\s*,\\s*"); // handles "0,9" and "0, 9"
      int u = Integer.parseInt(parts[0]);
      int v = Integer.parseInt(parts[1]);

      if (!graph[u].contains(v)) {
        graph[u].add(v);
      }
      if (!graph[v].contains(u)) { // undirected graph
        graph[v].add(u);
      }

      maxVertex = Math.max(maxVertex, Math.max(u, v));
    }

    br.close();

    numVertices = maxVertex + 1;

    for (int i = 0; i < numVertices; i++) {
      Collections.sort(graph[i]); // cleaner output
    }
  }

  public static void printGraph() {
    for (int v = 0; v < numVertices; v++) {
      System.out.print(v + "--> ");
      for (int adj : graph[v]) {
        System.out.print(adj + " ");
      }
      System.out.println();
    }
  }

  public static List<Integer> shortestPath(int src, int dst) {
    boolean[] visited = new boolean[numVertices];
    int[] parent = new int[numVertices];
    Arrays.fill(parent, -1);

    Queue<Integer> q = new LinkedList<>();
    visited[src] = true;
    q.add(src);

    while (!q.isEmpty()) {
      int curVertex = q.remove();

      if (curVertex == dst) {
        break;
      }

      for (int adj : graph[curVertex]) {
        if (!visited[adj]) {
          visited[adj] = true;
          parent[adj] = curVertex;
          q.add(adj);
        }
      }
    }

    if (!visited[dst]) {
      return new ArrayList<>();
    }

    List<Integer> path = new ArrayList<>();
    int curr = dst;

    while (curr != -1) {
      path.add(0, curr);
      curr = parent[curr];
    }

    return path;
  }

  public static void ensureTestGraphs()
      throws
          IOException { // This is based on the code from GraphAlgorithms_DFS_W the idea here is to
                        // generate 10 graphs to test if we don't have any if we do just use those
    for (int k = 1; k <= 10; k++) {
      String fileName = "graph" + k + ".txt";
      File f = new File(fileName);

      if (!f.exists()) {
        generateRandomConnectedGraphFile(fileName, 10, 0.3);
        System.out.println("Generated " + fileName);
      }
    }
  }

  public static void generateRandomConnectedGraphFile(
      String fileName, int numNodes, double extraEdgeProb) throws IOException {
    int[][] adjMatrix = new int[numNodes][numNodes];
    Random rand = new Random();

    // force connectivity with a random spanning tree
    for (int i = 1; i < numNodes; i++) {
      int j = rand.nextInt(i);
      adjMatrix[i][j] = 1;
      adjMatrix[j][i] = 1;
    }

    // add extra random edges
    for (int i = 0; i < numNodes; i++) {
      for (int j = i + 1; j < numNodes; j++) {
        if (adjMatrix[i][j] == 0 && rand.nextDouble() < extraEdgeProb) {
          adjMatrix[i][j] = 1;
          adjMatrix[j][i] = 1;
        }
      }
    }

    FileWriter writer = new FileWriter(fileName);

    for (int i = 0; i < numNodes; i++) {
      for (int j = i + 1; j < numNodes; j++) {
        if (adjMatrix[i][j] == 1) {
          writer.write(i + ", " + j + "\n");
        }
      }
    }

    writer.close();
  }

  public static void main(String[] args) {
    try {
      ensureTestGraphs();

      Scanner in = new Scanner(System.in);
      System.out.print("Enter source vertex: ");
      int src = in.nextInt();

      for (int k = 1; k <= 10; k++) {
        String fileName = "graph" + k + ".txt";

        System.out.println("\n===== Testing " + fileName + " =====");
        readGraph(fileName);
        printGraph();

        for (int dst = 0; dst < numVertices; dst++) {
          List<Integer> path = shortestPath(src, dst);
          System.out.println("Shortest path from " + src + " to " + dst + ": " + path);
        }
      }

      in.close();
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
