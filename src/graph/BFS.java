package graph;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.stream.IntStream;

public class BFS {
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

        public void BFS(int s) {
            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();
            visited[s] = true;
            queue.add(s);
            while (!queue.isEmpty()) {
                s = queue.poll();
                System.out.println(s + " ");
                ListIterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
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

        g.BFS(2);
    }
}
