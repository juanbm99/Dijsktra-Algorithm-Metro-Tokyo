import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Node {
	private String estacion;
	private List<Edge> edges;
	private double lat;
	private double longitud;
	private int linea;
	
	
	
	public Node (String estacion, double lat, double longitud,int linea) {
		this.estacion=estacion;
		this.lat=lat;
		this.longitud=longitud;
		this.linea=linea;
	}
	
	public String getEstacion() {
        return estacion;
    }
 
    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }
    
    public double getLatitud() {
    	return lat;
    }
    
    public double getLongitud() {
    	return longitud;
    }
 
    public List<Edge> getEdges() {
        return edges;
    }
    public int getLinea() {
    	return linea;
    }
 
    public void addEdge(Edge edge) {
        if (edges == null) {
            edges = new ArrayList<>();
        }
        edges.add(edge);
    }
 
    
    
  
    
    
    @Override
    public String toString() {
        return "\n \tNode [estacion=" + estacion + ", edges=" + edges + "]";
    }
}
