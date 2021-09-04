package graph;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.stream.IntStream;

public class DFS {
    static class Graph {
        int V;
        LinkedList<Integer> adj[];

        public Graph(int v) {
            this.V = v;
            adj = new LinkedList[v];
            IntStream.range(0, v).forEach(i -> adj[i] = new LinkedList<>());
        }

        public void addEdge(int s, int d) {
            adj[s].add(d);
        }

        public void DFSUtil(int s, boolean[] visited) {
            visited[s] = true;
            System.out.println(s + " ");
            ListIterator<Integer> list = adj[s].listIterator();
            while (list.hasNext()) {
                int n = list.next();
                if (!visited[n]) {
                    DFSUtil(n, visited);
                }
            }

        }

        public void DFS(int s) {
            boolean[] visited = new boolean[V];
            DFSUtil(s, visited);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
