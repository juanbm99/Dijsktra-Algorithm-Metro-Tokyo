import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Panel mainPanel = new Panel();
	BufferedImage img;
	
	public ImagePanel() {
		try {
			img=ImageIO.read(getClass().getClassLoader().getResource("metro.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		this.setTitle("Proyecto IA 2019 - Metro Tokio");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		this.prepareImage(img, mainPanel);
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);

		this.setSize(new Dimension(575, 541));
		this.setLocationRelativeTo(null);	//	Si se le pasa el valor null se posiciona en el centro de la pantalla

		//	Posible soluciÃ³n para coger origen y destino
		this.add(mainPanel);
		mainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX() + "," + e.getY());
			}
		});

	}

	class Panel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private ArrayList<Station> allStations;
		private ArrayList<String> minimumPath;
		private ArrayList<String> minimumPathResumido;

		public void setMinimumPath(ArrayList<String> minimumPath) {
			this.minimumPath = minimumPath;
			allStations = new ArrayList<Station>();
		}
		
		public void setMinimumPathResumido(ArrayList<String> minimumPathResumido) {
			this.minimumPath = minimumPathResumido;
			allStations = new ArrayList<Station>();
		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			int circleSize = 17;

			Station ikebukuro = new Station("Ikebukuro", 213-10, 73-10, circleSize, circleSize);
			allStations.add(ikebukuro);
			Station otsuka = new Station("Otsuka", 279-10, 73-10, circleSize, circleSize);
			allStations.add(otsuka);
			Station sugamo = new Station("Sugamo", 313-10, 73-10, circleSize, circleSize);
			allStations.add(sugamo);
			Station komagome = new Station("Komagome", 345-10, 73-10, circleSize, circleSize);
			allStations.add(komagome);
			Station tabata = new Station("Tabata", 383-10, 88-10, circleSize, circleSize);
			allStations.add(tabata);
			Station nishiNippori = new Station("Nishi-Nippori", 403-10, 105-10, circleSize, circleSize);
			allStations.add(nishiNippori);
			Station nippori = new Station("Nippori", 405-10, 135-10, circleSize, circleSize);
			allStations.add(nippori);
			Station uguisudani = new Station("Uguisudani", 405-10, 161-10, circleSize, circleSize);
			allStations.add(uguisudani);
			Station ueno = new Station("Ueno", 405-10, 183-10, circleSize, circleSize);
			allStations.add(ueno);
			Station okachimachi = new Station("Okachimachi", 405-10, 211-10, circleSize, circleSize);
			allStations.add(okachimachi);
			Station akihabara = new Station("Akihabara", 405-10, 235-10, circleSize, circleSize);
			allStations.add(akihabara);
			Station akihabaraA = new Station("AkihabaraA", 405-10, 235-10, circleSize, circleSize);
			allStations.add(akihabaraA);
			Station akihabaraV = new Station("AkihabaraV", 405-10, 235-10, circleSize, circleSize);
			allStations.add(akihabaraV);
			Station kanda = new Station("Kanda", 405-10, 274-10, circleSize, circleSize);
			allStations.add(kanda);
			Station tokyo = new Station("Tokyo", 405-10, 310-10, circleSize, circleSize);
			allStations.add(tokyo);
			Station tokyoV = new Station("TokyoV", 405-10, 310-10, circleSize, circleSize);
			allStations.add(tokyoV);
			Station tokyoR = new Station("TokyoR", 405-10, 310-10, circleSize, circleSize);
			allStations.add(tokyoR);
			Station yurakucho = new Station("Yurakucho", 404-10, 341-10, circleSize, circleSize);
			allStations.add(yurakucho);
			Station shimbashi = new Station("Shimbashi", 377-10, 365-10, circleSize, circleSize);
			allStations.add(shimbashi);
			Station hamamatsucho = new Station("Hamamatsucho", 351-10, 390-10, circleSize, circleSize);
			allStations.add(hamamatsucho);
			Station tamachi = new Station("Tamachi", 322-10, 419-10, circleSize, circleSize);
			allStations.add(tamachi);
			Station shinagawa = new Station("Shinagawa", 290-10, 450-10, circleSize, circleSize);
			allStations.add(shinagawa);
			Station osaki = new Station("Osaki", 234-10, 455-10, circleSize, circleSize);
			allStations.add(osaki);
			Station gotanda = new Station("Gotanda", 197-10, 455-10, circleSize, circleSize);
			allStations.add(gotanda);
			Station meguro = new Station("Meguro", 163-10, 455-10, circleSize, circleSize);
			allStations.add(meguro);
			Station ebisu = new Station("Ebisu", 118-10, 435-10, circleSize, circleSize);
			allStations.add(ebisu);
			Station shibuya = new Station("Shibuya", 117-10, 387-10, circleSize, circleSize);
			allStations.add(shibuya);
			Station harajuku = new Station("Harajuku", 117-10, 343-10, circleSize, circleSize);
			allStations.add(harajuku);
			Station yoyogiV = new Station("YoyogiV", 117-10, 277-10, circleSize, circleSize);
			allStations.add(yoyogiV);
			Station shinjukuV = new Station("ShinjukuV", 117-10, 245-10, circleSize, circleSize);
			allStations.add(shinjukuV);
			Station shinOkubo = new Station("Shin-Okubo", 117-10, 178-10, circleSize, circleSize);
			allStations.add(shinOkubo);
			Station takadanobaba = new Station("Takadanobaba", 122-10, 140-10, circleSize, circleSize);
			allStations.add(takadanobaba);
			Station mejiro = new Station("Mejiro", 157-10, 107-10, circleSize, circleSize);
			allStations.add(mejiro);
			Station shinjuku = new Station("Shinjuku", 118-10, 245-10, circleSize, circleSize);
			allStations.add(shinjuku);
			Station yoyogi = new Station("Yoyogi", 118-10, 277-10, circleSize, circleSize);
			allStations.add(yoyogi);


			//	LÃ�NEA VERDE
			//	Instancias de los objetos (cÃ­rculos) a dibujar
			Graphics2D g2 = (Graphics2D) g;
			/*float[] hsb = Color.RGBtoHSB(102, 152, 51, null);
			float hue = hsb[0]; 
			float saturation = hsb[1];
			float brightness = hsb[2];
			g2.setColor(Color.getHSBColor(hue, saturation, brightness));*/
			g2.setColor(Color.DARK_GRAY);

			//	Dibujar cÃ­rculos
			g2.draw(ikebukuro.getEllipseStation());			
			g2.draw(otsuka.getEllipseStation());
			g2.draw(sugamo.getEllipseStation());
			g2.draw(komagome.getEllipseStation());
			g2.draw(tabata.getEllipseStation());
			g2.draw(nishiNippori.getEllipseStation());
			g2.draw(nippori.getEllipseStation());
			g2.draw(uguisudani.getEllipseStation());
			g2.draw(ueno.getEllipseStation());
			g2.draw(okachimachi.getEllipseStation());
			g2.draw(akihabaraV.getEllipseStation());
			g2.draw(akihabaraA.getEllipseStation());
			g2.draw(kanda.getEllipseStation());
			g2.draw(tokyoR.getEllipseStation());
			g2.draw(tokyoV.getEllipseStation());
			g2.draw(yurakucho.getEllipseStation());
			g2.draw(shimbashi.getEllipseStation());
			g2.draw(hamamatsucho.getEllipseStation());
			g2.draw(tamachi.getEllipseStation());
			g2.draw(shinagawa.getEllipseStation());
			g2.draw(osaki.getEllipseStation());
			g2.draw(gotanda.getEllipseStation());
			g2.draw(meguro.getEllipseStation());
			g2.draw(ebisu.getEllipseStation());
			g2.draw(shibuya.getEllipseStation());
			g2.draw(harajuku.getEllipseStation());
			g2.draw(yoyogiV.getEllipseStation());
			g2.draw(shinjukuV.getEllipseStation());
			g2.draw(shinOkubo.getEllipseStation());
			g2.draw(takadanobaba.getEllipseStation());
			g2.draw(mejiro.getEllipseStation());

			//	Rellenar cÃ­rculos
			g2.fill(ikebukuro.getEllipseStation());			
			g2.fill(otsuka.getEllipseStation());
			g2.fill(sugamo.getEllipseStation());
			g2.fill(komagome.getEllipseStation());
			g2.fill(tabata.getEllipseStation());
			g2.fill(nishiNippori.getEllipseStation());
			g2.fill(nippori.getEllipseStation());
			g2.fill(uguisudani.getEllipseStation());
			g2.fill(ueno.getEllipseStation());
			g2.fill(okachimachi.getEllipseStation());
			g2.fill(akihabaraA.getEllipseStation());
			g2.fill(akihabaraV.getEllipseStation());
			g2.fill(kanda.getEllipseStation());
			g2.fill(tokyoV.getEllipseStation());
			g2.fill(tokyoR.getEllipseStation());
			g2.fill(yurakucho.getEllipseStation());
			g2.fill(shimbashi.getEllipseStation());
			g2.fill(hamamatsucho.getEllipseStation());
			g2.fill(tamachi.getEllipseStation());
			g2.fill(shinagawa.getEllipseStation());
			g2.fill(osaki.getEllipseStation());
			g2.fill(gotanda.getEllipseStation());
			g2.fill(meguro.getEllipseStation());
			g2.fill(ebisu.getEllipseStation());
			g2.fill(shibuya.getEllipseStation());
			g2.fill(harajuku.getEllipseStation());
			g2.fill(yoyogiV.getEllipseStation());
			g2.fill(shinjukuV.getEllipseStation());
			g2.fill(shinOkubo.getEllipseStation());
			g2.fill(takadanobaba.getEllipseStation());
			g2.fill(mejiro.getEllipseStation());


			//	LÃ�NEA AMARILLA
			Graphics2D g3 = (Graphics2D) g;
			//	g3.setColor(Color.ORANGE);
			g3.setColor(Color.DARK_GRAY);
			
			Station shinjukuA = new Station("ShinjukuA", 75-10, 245-10, circleSize, circleSize);
			allStations.add(shinjukuA);
			Station yoyogiA = new Station("YoyogiA", 75-10, 277-10, circleSize, circleSize);			
			allStations.add(yoyogiA);
			Station sendagaya = new Station("Sendagaya", 138-10, 318-10, circleSize, circleSize);
			allStations.add(sendagaya);
			Station shinanomachi = new Station("Shinanomachi", 183-10, 318-10, circleSize, circleSize);
			allStations.add(shinanomachi);
			Station yotsuya = new Station("Yotsuya", 202-10, 300-10, circleSize, circleSize);
			allStations.add(yotsuya);
			Station ichidagaya = new Station("Ichigaya", 219-10, 284-10, circleSize, circleSize);
			allStations.add(ichidagaya);
			Station iidabashi = new Station("Iidabashi", 236-10, 268-10, circleSize, circleSize);
			allStations.add(iidabashi);
			Station suidobashi = new Station("Suidobashi", 253-10, 252-10, circleSize, circleSize);
			allStations.add(suidobashi);
			Station ochanomizuA = new Station("OchanomizuA", 280-10, 234-10, circleSize, circleSize);
			allStations.add(ochanomizuA);
			Station ochanomizu = new Station("Ochanomizu", 280-10, 234-10, circleSize, circleSize);
			allStations.add(ochanomizu);

			g3.draw(shinjukuA.getEllipseStation());
			g3.draw(yoyogiA.getEllipseStation());
			g3.draw(sendagaya.getEllipseStation());
			g3.draw(shinanomachi.getEllipseStation());
			g3.draw(yotsuya.getEllipseStation());
			g3.draw(ichidagaya.getEllipseStation());
			g3.draw(iidabashi.getEllipseStation());
			g3.draw(suidobashi.getEllipseStation());
			g3.draw(ochanomizuA.getEllipseStation());

			g3.fill(shinjukuA.getEllipseStation());
			g3.fill(yoyogiA.getEllipseStation());
			g3.fill(sendagaya.getEllipseStation());
			g3.fill(shinanomachi.getEllipseStation());
			g3.fill(yotsuya.getEllipseStation());
			g3.fill(ichidagaya.getEllipseStation());
			g3.fill(iidabashi.getEllipseStation());
			g3.fill(suidobashi.getEllipseStation());
			g3.fill(ochanomizuA.getEllipseStation());


			//	LÃ�NEA ROJA
			Graphics2D g4 = (Graphics2D) g;
			//g4.setColor(Color.red);
			g4.setColor(Color.DARK_GRAY);

			Station shinjukuR = new Station("ShinjukuR", 95-10, 245-10, circleSize, circleSize);
			allStations.add(shinjukuR);
			Station ochanomizuR = new Station("OchanomizuR", 299-10, 216-10, circleSize, circleSize);
			allStations.add(ochanomizuR);

			g4.draw(shinjukuR.getEllipseStation());
			g4.draw(ochanomizuR.getEllipseStation());

			g4.fill(shinjukuR.getEllipseStation());
			g4.fill(ochanomizuR.getEllipseStation());


			Graphics2D g5 = (Graphics2D) g;

			/*float[] hsb1 = Color.RGBtoHSB(0, 128, 255, null);
			float hue1 = hsb1[0]; 
			float saturation1 = hsb1[1];
			float brightness1 = hsb1[2];
			g5.setColor(Color.getHSBColor(hue1, saturation1, brightness1));*/
			g5.setColor(Color.BLUE);

			ArrayList<Ellipse2D.Double> minimumPathEllipse = new ArrayList<Ellipse2D.Double>();

			for(int i=0; i<minimumPath.size(); i++) {
				for(int j=0; j<allStations.size(); j++) {
					if(minimumPath.get(i).equals(allStations.get(j).getName())) {
						minimumPathEllipse.add(allStations.get(j).getEllipseStation());
						
						//System.out.println(minimumPath.get(i) + " == " + allStations.get(j).getName());
						//System.out.println(minimumPath.get(i).equals(allStations.get(j).getName()));
						
						//	Si no hay diferencia entre las lÃ­neas de una misma estaciÃ³n se iluminan todas
						if(allStations.get(j).getName().equals("TokyoV") || allStations.get(j).getName().equals("TokyoR") || allStations.get(j).getName().equals("Tokyo")) {
							g5.draw(tokyoV.getEllipseStation());
							g5.fill(tokyoV.getEllipseStation());
						}else if(allStations.get(j).getName().equals("AkihabaraV") || allStations.get(j).getName().equals("AkihabaraA") || allStations.get(j).getName().equals("Akihabara")) {
							g5.draw(akihabaraA.getEllipseStation());
							g5.fill(akihabaraA.getEllipseStation());
						}else if(allStations.get(j).getName().equals("Shinjuku")) {
							g5.draw(shinjukuA.getEllipseStation());
							g5.fill(shinjukuA.getEllipseStation());
							g5.draw(shinjukuV.getEllipseStation());
							g5.fill(shinjukuV.getEllipseStation());
							g5.draw(shinjukuR.getEllipseStation());
							g5.fill(shinjukuR.getEllipseStation());
						}else if(allStations.get(j).getName().equals("Yoyogi")) {
							g5.draw(yoyogiA.getEllipseStation());
							g5.fill(yoyogiA.getEllipseStation());
							g5.draw(yoyogiV.getEllipseStation());
							g5.fill(yoyogiV.getEllipseStation());
						}else if(allStations.get(j).getName().equals("Ochanomizu")){
							g5.draw(ochanomizuA.getEllipseStation());
							g5.fill(ochanomizuA.getEllipseStation());
							g5.draw(ochanomizuR.getEllipseStation());
							g5.fill(ochanomizuR.getEllipseStation());
						}else {
							g5.draw(allStations.get(j).getEllipseStation());
							g5.fill(allStations.get(j).getEllipseStation());
						}
					}
				}
			}
			
			/*Graphics2D g6 = (Graphics2D) g;
			g6.setColor(Color.PINK);

			ArrayList<Ellipse2D.Double> minimumPathEllipseResumido = new ArrayList<Ellipse2D.Double>();

			for(int i=0; i<minimumPathResumido.size(); i++) {
				for(int j=0; j<allStations.size(); j++) {
					if(minimumPathResumido.get(i).equals(allStations.get(j).getName())) {
						minimumPathEllipseResumido.add(allStations.get(j).getEllipseStation());
						
						//System.out.println(minimumPath.get(i) + " == " + allStations.get(j).getName());
						//System.out.println(minimumPath.get(i).equals(allStations.get(j).getName()));
						
						//	Si no hay diferencia entre las lÃ­neas de una misma estaciÃ³n se iluminan todas
						if(allStations.get(j).getName().equals("TokyoV") || allStations.get(j).getName().equals("TokyoR") || allStations.get(j).getName().equals("Tokyo")) {
							g6.draw(tokyoV.getEllipseStation());
							g6.fill(tokyoV.getEllipseStation());
						}else if(allStations.get(j).getName().equals("AkihabaraV") || allStations.get(j).getName().equals("AkihabaraA") || allStations.get(j).getName().equals("Akihabara")) {
							g6.draw(akihabaraA.getEllipseStation());
							g6.fill(akihabaraA.getEllipseStation());
						}else if(allStations.get(j).getName().equals("Shinjuku")) {
							g6.draw(shinjukuA.getEllipseStation());
							g6.fill(shinjukuA.getEllipseStation());
							g6.draw(shinjukuV.getEllipseStation());
							g6.fill(shinjukuV.getEllipseStation());
							g6.draw(shinjukuR.getEllipseStation());
							g6.fill(shinjukuR.getEllipseStation());
						}else if(allStations.get(j).getName().equals("Yoyogi")) {
							g6.draw(yoyogiA.getEllipseStation());
							g6.fill(yoyogiA.getEllipseStation());
							g6.draw(yoyogiV.getEllipseStation());
							g6.fill(yoyogiV.getEllipseStation());
						}else if(allStations.get(j).getName().equals("Ochanomizu")){
							g6.draw(ochanomizuA.getEllipseStation());
							g6.fill(ochanomizuA.getEllipseStation());
							g6.draw(ochanomizuR.getEllipseStation());
							g6.fill(ochanomizuR.getEllipseStation());
						}else {
							g6.draw(allStations.get(j).getEllipseStation());
							g6.fill(allStations.get(j).getEllipseStation());
						}
					}
				}
			}*/
		}

		/*
		//	No estoy seguro de si es necesario quitar el cÃ³digo a continuaciÃ³n 
		/*@Override
		public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
			if((infoflags & ImageObserver.ALLBITS) != 0) {
				repaint();
				return false;
			}
			return true;
		}*/
	}
	public static void main(String[] args) throws InterruptedException {
		String origenS = JOptionPane.showInputDialog("Introducir origen (primera letra en mayúscula):");
		String destinoS = JOptionPane.showInputDialog("Introducir destino (primera letra en mayúscula):");
		MapRepresentation mapita=new MapRepresentation();
		Graph graph = MapRepresentation.getEstaciones();
		Node origen=graph.getNode(origenS);
		Node destino=graph.getNode(destinoS);
		mapita.getF(origen, destino);

		ImagePanel ip = new ImagePanel();
		
		//ArrayList<String> minimumPath = mapita.getCaminoMinimo();
		//ip.mainPanel.setMinimumPath(minimumPath);
		//System.out.println(minimumPath);

		ArrayList<String> minimumPathResumido = mapita.getCaminoMinimoResumido();
		ip.mainPanel.setMinimumPath(minimumPathResumido);
		System.out.println(minimumPathResumido);
	}
	

}