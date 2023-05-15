import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    private ArrayList<String> vertices;
    private int[][] adjMatrix;

    public Graph() {
        vertices = new ArrayList<>();
        adjMatrix = new int[0][0];
    }

    public void addVertex(String s) {
        vertices.add(s);
        int size = vertices.size();
        int[][] newAdjMatrix = new int[size][size];
        for (int i = 0; i < size - 1; i++) {
            System.arraycopy(adjMatrix[i], 0, newAdjMatrix[i], 0, size - 1);
        }
        adjMatrix = newAdjMatrix;
    }

    public String deleteVertex(int n) {
        if (n >= 0 && n < vertices.size()) {
            String deletedVertex = vertices.remove(n);
            int size = vertices.size();
            int[][] newAdjMatrix = new int[size][size];
            int row = 0, col;
            for (int i = 0; i < size + 1; i++) {
                if (i != n) {
                    col = 0;
                    for (int j = 0; j < size + 1; j++) {
                        if (j != n) {
                            newAdjMatrix[row][col] = adjMatrix[i][j];
                            col++;
                        }
                    }
                    row++;
                }
            }
            adjMatrix = newAdjMatrix;
            return deletedVertex;
        } else {
            return null;
        }
    }

    public void addEdge(String v, String w, int airfare) {
        int srcIndex = vertices.indexOf(v);
        int destIndex = vertices.indexOf(w);
        if (srcIndex != -1 && destIndex != -1) {
            adjMatrix[srcIndex][destIndex] = airfare;
            adjMatrix[destIndex][srcIndex] = airfare;
        }
    }

    public void removeEdge(String v, String w) {
        int srcIndex = vertices.indexOf(v);
        int destIndex = vertices.indexOf(w);
        if (srcIndex != -1 && destIndex != -1) {
            adjMatrix[srcIndex][destIndex] = 0;
            adjMatrix[destIndex][srcIndex] = 0;
        }
    }

    public void displayAdj() {
        int size = vertices.size();
        System.out.print("   ");
        for (String vertex : vertices) {
            System.out.print(vertex + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(vertices.get(i) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void displayEdges() {
        int size = vertices.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (adjMatrix[i][j] != 0) {
                    System.out.println(vertices.get(i) + "->" + vertices.get(j));
                    System.out.println(vertices.get(j) + "->" + vertices.get(i));
                }
            }
        }
    }

    public void BFS(String v) {
        int size = vertices.size();
        boolean[] visited = new boolean[size];
        Queue<String> queue = new LinkedList<>();

        int startIndex = vertices.indexOf(v);
        if (startIndex != -1)
        visited[startIndex] = true;
        queue.add(vertices.get(startIndex));

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            System.out.print(vertex + " ");

            int index = vertices.indexOf(vertex);
            for (int i = 0; i < size; i++) {
                if (adjMatrix[index][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(vertices.get(i));
                }
            }
        }
    }

    public void DFS(String v) {
        int size = vertices.size();
        boolean[] visited = new boolean[size];
        Stack<String> stack = new Stack<>();

        int startIndex = vertices.indexOf(v);
        if (startIndex != -1) {
            visited[startIndex] = true;
            stack.push(vertices.get(startIndex));

            while (!stack.isEmpty()) {
                String vertex = stack.pop();
                System.out.print(vertex + " ");

                int index = vertices.indexOf(vertex);
                for (int i = 0; i < size; i++) {
                    if (adjMatrix[index][i] != 0 && !visited[i]) {
                        visited[i] = true;
                        stack.push(vertices.get(i));
                    }
                }
            }
        }
    }

    public void flightAvailable(String s, String d) {
        if (vertices.contains(s) && vertices.contains(d)) {
            int sIndex = vertices.indexOf(s);
            int dIndex = vertices.indexOf(d);
            int cost = adjMatrix[sIndex][dIndex];
            if (cost != 0) {
             System.out.println("Flight price is " + cost);
            } else {
                System.out.println("No flight available");
             }
         }
    }
}

