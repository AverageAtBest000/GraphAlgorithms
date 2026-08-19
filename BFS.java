import java.util.*;
import java.io.*;

public class BFS
{
    public static void main(String[] args){
        HashMap<String,String[]> graph = new HashMap<>();
        graph.put( "a" , new String[]{"b", "c"} );
        graph.put( "b" , new String[]{"d"} );
        graph.put( "c" , new String[]{"e"} );
        graph.put( "d" , new String[]{} );
        graph.put( "e" , new String[]{} );
        graph.put( "f" , new String[]{} );



        search(graph, "a");

    }

    public static void search(HashMap<String,String[]> graph, String startNode){
        
        //Declare a queue
        Queue<String> queue = new LinkedList<>();
        // Add the start node to the queue, so we visit it first
        queue.add(startNode);

        //while we still have nodes to visit
        while (!queue.isEmpty()) {
            
            String current =  queue.poll();
            System.out.println(current);

            for(String neighboor : graph.get(current)){
                queue.add(neighboor);
            }
        }

    }
}