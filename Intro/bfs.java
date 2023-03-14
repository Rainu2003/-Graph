import java.io.*;
import java.util.*;


public class Graph{
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];

        for(int i = 0 ; i < V ; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int src , int dest)
    {
        adj[src].add(dest);
        adj[dest].add(src);
    }


    void bfs(int src)
    {
        boolean vis[] = new boolean[V];
        LinkedList<Integer> q = new LinkedList();

        vis[src] = true;
        q.add(src);

        while(!q.isEmpty())
        {
            int node = q.poll();
            System.out.print(node + " ");
            Iterator<Integer> it = adj[node].listIterator();
        
            while(it.hasNext())
            {
                int nums = it.next();

                if(!vis[nums])
                {
                    vis[nums] = true;
                    q.add(nums);
                }
            }
        
        }
    }





public static void main(String args[])
{
    int V , E;
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number of vertex =  "); 
    V = sc.nextInt();

    // Graph creation 
    Graph g = new Graph(V);

    System.out.println("Enter the number of edges =  "); 
    E = sc.nextInt(); 

    int src , dest;

    for(int i = 0 ; i < E ; i++)
    {

        src = sc.nextInt();
        dest = sc.nextInt();

        g.addEdge(src , dest);
    }

    System.out.println("The bfs Traversal of the graph is = ");
    g.bfs(0);
    
}
}