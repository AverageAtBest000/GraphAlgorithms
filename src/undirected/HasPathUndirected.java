import java.util.*;
import java.io.*;

public class HasPathUndirected{

    public static void main(String[] args){
        String[][] grph = {
            {"i","j"},
            {"k","i"},
            {"m","k"},
            {"k","l"},
            {"o","n"}
        };

        HashMap<String, ArrayList<String>> graph = getGraph(grph);

        System.out.print(hasPath(graph, "i", "l"));

    }

    public static boolean hasPath(HashMap<String, ArrayList<String>> graph, String startNode, String endNode){

        Queue<String> queue =  new LinkedList<>();
        queue.add(startNode);
        HashSet<String> visited = new HashSet<>();

        while(!queue.isEmpty()){

            String current = queue.poll();
            if (current.equals(endNode)) return true;
            visited.add(current);

            for(String neighboor : graph.get(current)){
                if(!visited.contains(neighboor)) 
                    queue.add(neighboor);
            }
        }

        return false;

    }

    public static HashMap<String, ArrayList<String>> getGraph(String[][] inputArray){

        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        for(String[] edge : inputArray){

            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        return graph;
    }

}