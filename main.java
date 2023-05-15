import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Vertex");
            System.out.println("2. Remove Vertex");
            System.out.println("3. Add Edge");
            System.out.println("4. Remove Edge");
            System.out.println("5. Display Adjacency Matrix");
            System.out.println("6. Display Edges");
            System.out.println("7. BFS");
            System.out.println("8. DFS");
            System.out.println("9. Check Flight Availability");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter vertex: ");
                String vertex = scanner.next();
                graph.addVertex(vertex);
            } else if (choice == 2) {
                System.out.print("Enter position of vertex to delete: ");
                int position = scanner.nextInt();
                String deletedVertex = graph.deleteVertex(position);
                System.out.println("Deleted vertex: " + deletedVertex);
            } else if (choice == 3) {
                System.out.print("Enter source vertex: ");
                String v = scanner.next();
                System.out.print("Enter destination vertex: ");
                String w = scanner.next();
                System.out.print("Enter airfare: ");
                int x = scanner.nextInt();
                graph.addEdge(v, w, x);
            } else if (choice == 4) {
                System.out.print("Enter source vertex: ");
                String v = scanner.next();
                System.out.print("Enter destination vertex: ");
                String w = scanner.next();
                graph.removeEdge(v, w);
            } else if (choice == 5) {
                graph.displayAdj();
            } else if (choice == 6) {
                graph.displayEdges();
            } else if (choice == 7) {
                System.out.print("Enter starting vertex for BFS: ");
                String v = scanner.next();
                graph.BFS(v);
            } else if (choice == 8) {
                System.out.print("Enter starting vertex for DFS: ");
                String v = scanner.next();
                graph.DFS(v);
            } else if (choice == 9) {
                System.out.print("Enter source vertex: ");
                String s = scanner.next();
                System.out.print("Enter destination vertex: ");
                String d = scanner.next();
                graph.flightAvailable(s, d);
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
