import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graphh {

    static class Edges {
        int st;
        int end;
        int wt;

        public Edges(int st, int end, int wt) {
            this.st = st;
            this.end = end;
            this.wt = wt;
        }
    }

    public void createGraph(ArrayList<Edges>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edges(0, 1, 5));
        graph[0].add(new Edges(0, 2, 3));

        graph[1].add(new Edges(1, 3, 6));
        graph[1].add(new Edges(1, 2, 2));

        graph[2].add(new Edges(2, 4, 4));
        graph[2].add(new Edges(2, 1, 2));

        graph[3].add(new Edges(3, 4, 1));
        graph[3].add(new Edges(3, 0, 5));

        graph[4].add(new Edges(4, 3, 1));
        graph[4].add(new Edges(4, 2, 4));
    }

    public void bfs(ArrayList<Edges>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];

        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;

                for (Edges e : graph[curr]) {
                    q.add(e.end);
                }
            }
        }
    }

    public void dfs(ArrayList<Edges>[] graph, int curr, boolean[] vis) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (Edges e : graph[curr]) {
            if (!vis[e.end]) {
                dfs(graph, e.end, vis);
            }
        }
    }

    public static void main(String[] args) {
        Graphh g = new Graphh();
        int v = 5;

       
        ArrayList<Edges>[] graph = new ArrayList[v];

        g.createGraph(graph);

        System.out.print("DFS: ");
        g.dfs(graph, 0, new boolean[v]);

        System.out.println();

        System.out.print("BFS: ");
        g.bfs(graph);
    }
}
