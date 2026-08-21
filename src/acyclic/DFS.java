import java.util.*;

public class DFS{
    public static void main(String[] args){
        HashMap<String,String[]> graph = new HashMap<>();
        graph.put( "a" , new String[]{"c", "b"} );
        graph.put( "b" , new String[]{"d"} );
        graph.put( "c" , new String[]{"e"} );
        graph.put( "d" , new String[]{} );
        graph.put( "e" , new String[]{} );
        graph.put( "f" , new String[]{} );



        search(graph, "a");
        recursiveSearch(graph, "a");
    }

    public static void search(HashMap<String, String[]> graph, String startNode){

        //Declare a stack 
        Stack<String> stack = new Stack<>();

        //Add the starting node to the stack
        stack.push(startNode);

        //While tha stack is not empty
        while (!stack.isEmpty()) {

            //Pop the top node
            String current = stack.pop();
            System.out.println(current);

            //Visit the node by adding its neighboors to the stack
            for(String neighboor : graph.get(current))
                stack.add(neighboor);
        }
    }

    public static void recursiveSearch(HashMap<String, String[]> graph, String node){
        
        System.out.println(node);
        for(String neighboor : graph.get(node))
            recursiveSearch(graph, neighboor);

    }

}