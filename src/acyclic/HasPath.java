import java.util.*;

public class HasPath{
    
    public static void main(String[] args){
        HashMap<String,String[]> graph = new HashMap<>();
        graph.put( "a" , new String[]{"b", "c"} );
        graph.put( "b" , new String[]{"c"} );
        graph.put( "c" , new String[]{"e"} );
        graph.put( "d" , new String[]{} );
        graph.put( "e" , new String[]{} );
        graph.put( "f" , new String[]{"d"} );
    
        System.out.println(hasPathDFS(graph, "a", "d"));

    
    }

    public static boolean hasPathBFS (HashMap<String, String[]> graph, String startNode, String endNode){

        Queue<String> queue = new LinkedList<String>();
        queue.add(startNode);

        while(!queue.isEmpty()){
            String current = queue.poll();

            for(String neighboor : graph.get(current)){
                queue.add(neighboor);
                if(neighboor.equals(endNode)) return true;
            }
        }

        
        return false;
    }


    public static boolean hasPathDFS(HashMap<String, String[]> graph, String startNode, String endNode){

        Stack<String> stack = new Stack<>();
        stack.push(startNode);

        while(!stack.isEmpty()){
            String current = stack.pop();
            
            for(String neighboor : graph.get(current))
            {
                stack.push(neighboor);
                if(neighboor.equals(endNode)) return true;
            }
                
        }
        
        return false;
    }




}