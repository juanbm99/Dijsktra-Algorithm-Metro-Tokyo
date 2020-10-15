import java.awt.geom.Ellipse2D;

public class Station {

	private String name;
	private Ellipse2D.Double station;
	
	public Station(String name, double arg0, double arg1, double arg2, double arg3) {
		this.name = name;
		station = new Ellipse2D.Double(arg0, arg1, arg2, arg3);
	}
	
	public String getName() {
		return name;
	}
	
	public Ellipse2D.Double getEllipseStation(){
		return station;
	}
	
	public Station getStation() {
		return this;
	}
	
}
