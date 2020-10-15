import java.util.ArrayList;
import java.util.List;
 

public class Graph {
 
    private List<Node> nodes;
 
    public void addNode(Node node) {
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(node);
    }
 
    public List<Node> getNodes() {
        return nodes;
    }
 
    public Node getNode (String estacion) {
   
    Node res=null;
    boolean found=false;
    for(int i=0;i<nodes.size() && !found;i++) {
    	if(nodes.get(i).getEstacion().equals(estacion)) {
    		res=nodes.get(i);
    		found=true;
    	}
    }
    return res;
}
    
    @Override
    public String toString() {
        return "Graph [nodes=" + nodes + "]";
    }
 
}