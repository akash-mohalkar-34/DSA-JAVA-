import java.util.ArrayList;
import java.util.PriorityQueue;

public  class Dijkstra {

    public static class Edge{
        int wt;
        int src;
        int dest;

        public Edge(int src , int dest , int wt){
            this.src = src;
            this.wt = wt;
            this.dest = dest;
        }
    }

    public static void creatGraph(ArrayList<Edge> []graph){
         for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
         }

         graph[0].add(new Edge(0, 1, 2));
         graph[0].add(new Edge(0, 2, 4));

         graph[1].add(new Edge(1, 3, 7));
         graph[1].add(new Edge(1, 2, 1));

         graph[2].add(new Edge(2, 0, 3));

         graph[3].add(new Edge(3, 5, 1));

         graph[4].add(new Edge(4, 3, 2));
         graph[4].add(new Edge(4, 5, 5));


    }

    public static class Pair implements Comparable< Pair>{
          int n ;
          int path;

          public Pair(int n , int path)
          {
            this.n = n;
            this.path = path;
          }     

          @Override
          public int compareTo(Pair p2){
             return this.path - p2.path;
          }
        }

        public static void dijkastra(ArrayList<Edge> [] graph , int src)
        {
            int dist[] = new int[graph.length];
           for(int i = 0 ; i < graph.length ; i++){
               if(i != src)
               {
                   dist[i] = Integer.MAX_VALUE;   
               }
           }     

           boolean vis[] = new boolean[graph.length];
           PriorityQueue<Pair> pq = new PriorityQueue<>();

           pq.add(new Pair(src,0));

           while (! pq.isEmpty()) {
                  Pair curr = pq.remove();
                  vis[curr.n] = true;
                  for(int i = 0 ; i < graph[curr.n].size();i++){
                      Edge e = graph[curr.n].get(i);
                      int u = e.src;
                      int v = e.dest;
                      int wt = e.wt;

                      if(dist[u] + wt < dist[v]){
                        dist[v] = wt + dist[u];

                        pq.add(new Pair(v, dist[v]));
                      }
                  }
           }

           for(int i = 0; i < dist.length ;i++){
            System.out.print(dist[i] + "  ");
           }

           System.out.println();
        }
///////////////////////////////////////
       
    public static void main(String args[]){
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        creatGraph(graph);
        
        System.out.println();
        // dijkastra(graph, 0);

    }
}
