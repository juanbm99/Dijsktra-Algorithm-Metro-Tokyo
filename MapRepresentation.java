import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class MapRepresentation  {
	private Map<Node,Double> map;
	private Node anterior;
	private static ArrayList<Node> visitados;
	private static ArrayList<String> caminoMinimo; 
	private static ArrayList<Node> caminoMinimoResumido;

	public MapRepresentation() {
		map = new HashMap<Node,Double>();
		visitados = new ArrayList<Node>();
		caminoMinimo = new ArrayList<String>();
		caminoMinimoResumido = new ArrayList<Node>();
	}

	public  void getF(Node origen, Node destino) {
		if(origen.equals(destino)) {
			caminoMinimo.add(origen.getEstacion());
			caminoMinimoResumido.add(origen);
		}else {
			List<Edge> aristas = origen.getEdges();
			double res = 0;
			caminoMinimo.add(0, origen.getEstacion());
			visitados.add(origen);
			for (int i=0;i<aristas.size();i++) {
				Node destinito = aristas.get(i).getDestination();
				if(!visitados.contains(destinito)) {
					res = aristas.get(i).getDistance() + distanciaCoord(aristas.get(i).getDestination().getLatitud(), 
							aristas.get(i).getDestination().getLongitud(), destino.getLatitud(), destino.getLongitud());
					if(anterior != null && !(destinito.getLinea() % 2 == 0 && anterior.getLinea() % 2 ==0 || 
							destinito.getLinea() % 3 == 0 && anterior.getLinea() % 3 == 0 || 
							destinito.getLinea() % 5 == 0 && anterior.getLinea() % 5 == 0)) {
						res += 2;
					}
					map.put(aristas.get(i).getDestination(), res);
				}
			}
			double menor = 500;
			double aux;
			Node delmenor = null;
			for(Map.Entry<Node, Double> entry : map.entrySet()) {
				aux = entry.getValue();
				if(aux < menor) {
					menor = aux;
					delmenor = entry.getKey();
				}
			}
			caminoMinimo.add(delmenor.getEstacion());
			map.remove(delmenor);
			anterior = origen;
			if(!delmenor.equals(destino)) {
				getF(delmenor,destino);
				return;
			}
			List<Edge> aristitas = new ArrayList<Edge>();
			Node ultimoDelCaminoMinimo;
			caminoMinimoResumido.add(destino);
			ultimoDelCaminoMinimo = destino;
			for(int pn = visitados.size()-1; pn >= 0; pn--) {			
				aristitas = ultimoDelCaminoMinimo.getEdges();
				for(int arg = 0; arg < aristitas.size(); arg++) {
					if(aristitas.get(arg).getDestination().equals(visitados.get(pn))) {
						ultimoDelCaminoMinimo = visitados.get(pn);
						caminoMinimoResumido.add(visitados.get(pn));
					}
				}
			}
		}
	}

	public double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {  
		double radioTierra = 6371;//en kilómetros  
		double dLat = Math.toRadians(lat2 - lat1);  
		double dLng = Math.toRadians(lng2 - lng1);  
		double sindLat = Math.sin(dLat / 2);  
		double sindLng = Math.sin(dLng / 2);  
		double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * 
				Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
		double distancia = radioTierra * va2;  

		return distancia;
	}

	public static  Graph getEstaciones() {
		// LINEA VERDE
		Node shinjuku = new Node("Shinjuku",35.689544, 139.700583,30);
		Node shinOkubo = new Node("Shin-Okubo", 35.701420, 139.700183,2);
		Node takadanobaba  = new Node("Takadanobaba", 35.712757, 139.703851,2);
		Node mejiro = new Node("Mejiro",35.721258, 139.706528,2);
		Node yoyogi = new Node("Yoyogi",35.683082, 139.702162,6);
		Node ikebukuro = new Node("Ikebukuro", 35.729668, 139.710900,2);
		Node otsuka = new Node("Otsuka",35.732075, 139.728122,2);
		Node sugamo = new Node("Sugamo",35.733541, 139.739231,2);
		Node komagome = new Node("Komagome",35.736749, 139.747042,2);
		Node tabata = new Node("Tabata",35.738228, 139.760772,2);
		Node nishiNippori = new Node("Nishi-Nippori", 35.732180, 139.766843,2);
		Node nippori = new Node("Nippori",35.728358, 139.770652,2);
		Node uguisudani = new Node("Uguisudani",35.721649, 139.777970,2);
		Node ueno = new Node("Ueno",35.714228, 139.777398,2);
		Node okachimachi = new Node("Okachimachi",35.707771, 139.774867,2);
		Node akihabara = new Node("Akihabara",35.698636, 139.773115,6);
		Node kanda = new Node("Kanda",35.691961, 139.770953,2);
		Node tokyo = new Node("Tokyo",35.681323, 139.767114,10);
		Node yurakucho = new Node("Yurakucho",35.675049, 139.762831,2);
		Node shimbashi = new Node("Shimbashi",35.666684, 139.758372,2);
		Node hamamatsucho = new Node("Hamamatsucho",35.655451, 139.757193,2);
		Node tamachi = new Node("Tamachi" ,35.645910, 139.747605,2);
		Node shinagawa = new Node("Shinagawa",35.628458, 139.738802,2);
		Node osaki = new Node("Osaki",35.619912, 139.728254,2);
		Node gotanda = new Node("Gotanda",35.626360, 139.723602,2);
		Node meguro = new Node("Meguro",35.634145, 139.715769,2);
		Node ebisu = new Node("Ebisu",35.646880, 139.710067,2);
		Node shibuya = new Node("Shibuya",35.658182, 139.701539,2);
		Node harajuku = new Node("Harajuku",35.670289, 139.702655,2);
		// LINEA AMARILLA
		Node sendagaya = new Node("Sendagaya",35.681379, 139.711334,3);
		Node shinanomachi = new Node("Shinanomachi" ,35.680121, 139.720363,3);
		Node yotsuya = new Node("Yotsuya",35.686231, 139.730218,3);
		Node ichigaya = new Node("Ichigaya" ,35.691178, 139.735567,3);
		Node iidabashi = new Node("Iidabashi",35.702284, 139.744970,3);
		Node suidobashi = new Node("Suidobashi",35.702205, 139.753502,3);
		// LINEA ROJA
		Node ochanomizu = new Node("Ochanomizu",35.699507, 139.765248,15);

		
		shinjuku.addEdge(new Edge(shinjuku, shinOkubo,1.3 ));
		shinOkubo.addEdge(new Edge(shinOkubo,shinjuku,1.3 ));

		shinjuku.addEdge(new Edge(shinjuku, yoyogi,0.650 ));
		yoyogi.addEdge(new Edge(yoyogi, shinjuku,0.650 ));

		shinjuku.addEdge(new Edge(shinjuku, ochanomizu, 6.3));
		ochanomizu.addEdge(new Edge(ochanomizu,shinjuku, 6.3));

		shinOkubo.addEdge(new Edge(shinOkubo,takadanobaba,1.3));
		takadanobaba.addEdge(new Edge(takadanobaba,shinOkubo,1.3));

		takadanobaba.addEdge(new Edge(takadanobaba,mejiro,1.1));
		mejiro.addEdge(new Edge(mejiro,takadanobaba,1.1));

		mejiro.addEdge(new Edge(mejiro,ikebukuro,1.1));
		ikebukuro.addEdge(new Edge(ikebukuro,mejiro,1.1));

		ikebukuro.addEdge(new Edge(ikebukuro,otsuka,1.5));
		otsuka.addEdge(new Edge(otsuka,ikebukuro,1.5));

		otsuka.addEdge(new Edge(otsuka,sugamo,1.2));
		sugamo.addEdge(new Edge(sugamo,otsuka,1.2));

		sugamo.addEdge(new Edge(sugamo,komagome,0.8));
		komagome.addEdge(new Edge(komagome,sugamo,0.8));

		komagome.addEdge(new Edge(komagome,tabata,1.3));
		tabata.addEdge(new Edge(tabata,komagome,1.3));

		tabata.addEdge(new Edge(tabata,nishiNippori,0.7));
		nishiNippori.addEdge(new Edge(nishiNippori,tabata,0.7));

		nishiNippori.addEdge(new Edge(nishiNippori,nippori,0.6));
		nippori.addEdge(new Edge(nippori,nishiNippori,0.6));

		nippori.addEdge(new Edge(nippori,uguisudani,1.2));
		uguisudani.addEdge(new Edge(uguisudani,nippori,1.2));

		uguisudani.addEdge(new Edge(uguisudani,ueno,0.9));
		ueno.addEdge(new Edge(ueno,uguisudani,0.9));

		ueno.addEdge(new Edge(ueno,okachimachi,0.5));
		okachimachi.addEdge(new Edge(okachimachi,ueno,0.5));

		okachimachi.addEdge(new Edge(okachimachi,akihabara,1.1));
		akihabara.addEdge(new Edge(akihabara,okachimachi,1.1));

		akihabara.addEdge(new Edge(akihabara,kanda,0.450));
		kanda.addEdge(new Edge(kanda,akihabara,0.450));

		akihabara.addEdge(new Edge(akihabara,ochanomizu,1.2));
		ochanomizu.addEdge(new Edge(ochanomizu,akihabara, 1.2));

		kanda.addEdge(new Edge(kanda,tokyo,1.4));
		tokyo.addEdge(new Edge(tokyo,kanda,1.4));

		tokyo.addEdge(new Edge(tokyo,yurakucho,0.280));
		yurakucho.addEdge(new Edge(yurakucho,tokyo,0.280));

		tokyo.addEdge(new Edge(tokyo,ochanomizu,2.1));
		ochanomizu.addEdge(new Edge(ochanomizu,tokyo, 2.1));

		yurakucho.addEdge(new Edge(yurakucho,shimbashi,1));
		shimbashi.addEdge(new Edge(shimbashi,yurakucho,1));


		shimbashi.addEdge(new Edge(shimbashi,hamamatsucho,1.3));
		hamamatsucho.addEdge(new Edge(hamamatsucho,shimbashi,1.3));


		hamamatsucho.addEdge(new Edge(hamamatsucho,tamachi,1.5));
		tamachi.addEdge(new Edge(tamachi,hamamatsucho,1.5));

		tamachi.addEdge(new Edge(tamachi,shinagawa,2.4));
		shinagawa.addEdge(new Edge(shinagawa,tamachi,2.4));

		shinagawa.addEdge(new Edge(shinagawa,osaki,1.9));
		osaki.addEdge(new Edge(osaki,shinagawa,1.9));


		osaki.addEdge(new Edge(osaki,gotanda,0.850));
		gotanda.addEdge(new Edge(gotanda,osaki,0.850));

		gotanda.addEdge(new Edge(gotanda,meguro,1.2));
		meguro.addEdge(new Edge(meguro,gotanda,1.2));

		meguro.addEdge(new Edge(meguro,ebisu,1.6));
		ebisu.addEdge(new Edge(ebisu,meguro,1.6));

		ebisu.addEdge(new Edge(ebisu,shibuya,1.2));
		shibuya.addEdge(new Edge(shibuya,ebisu,1.2));

		shibuya.addEdge(new Edge(shibuya,harajuku,1.1));
		harajuku.addEdge(new Edge(harajuku,shibuya,1.1));

		harajuku.addEdge(new Edge(harajuku,yoyogi,1.6));
		yoyogi.addEdge(new Edge(yoyogi,harajuku,1.6));

		yoyogi.addEdge(new Edge(yoyogi,sendagaya,1));
		sendagaya.addEdge(new Edge(sendagaya,yoyogi,1));

		sendagaya.addEdge(new Edge(sendagaya,shinanomachi,0.9));
		shinanomachi.addEdge(new Edge(shinanomachi,sendagaya,0.9));

		shinanomachi.addEdge(new Edge(shinanomachi,yotsuya,1.5));
		yotsuya.addEdge(new Edge(yotsuya,shinanomachi,1.5));

		yotsuya.addEdge(new Edge(yotsuya,ichigaya,0.8));
		ichigaya.addEdge(new Edge(ichigaya,yotsuya,0.8));

		ichigaya.addEdge(new Edge(ichigaya,iidabashi,1.2));
		iidabashi.addEdge(new Edge(iidabashi,ichigaya,1.2));

		iidabashi.addEdge(new Edge(iidabashi,suidobashi,0.650));
		suidobashi.addEdge(new Edge(suidobashi,iidabashi,0.650));

		suidobashi.addEdge(new Edge(suidobashi,ochanomizu,0.9));
		ochanomizu.addEdge(new Edge(ochanomizu,suidobashi,0.9));


		Graph graph = new Graph();

		graph.addNode(shinjuku);
		graph.addNode(shinOkubo);
		graph.addNode(takadanobaba);
		graph.addNode(mejiro);
		graph.addNode(ikebukuro);
		graph.addNode(otsuka);
		graph.addNode(sugamo);
		graph.addNode(komagome);
		graph.addNode(tabata);
		graph.addNode(nishiNippori);
		graph.addNode(nippori);
		graph.addNode(uguisudani);
		graph.addNode(ueno);
		graph.addNode(okachimachi);
		graph.addNode(akihabara);
		graph.addNode(kanda);
		graph.addNode(tokyo);
		graph.addNode(yurakucho);
		graph.addNode(shimbashi);
		graph.addNode(hamamatsucho);
		graph.addNode(tamachi);
		graph.addNode(shinagawa);
		graph.addNode(osaki);
		graph.addNode(gotanda);
		graph.addNode(meguro);
		graph.addNode(ebisu);
		graph.addNode(shibuya);
		graph.addNode(harajuku);
		graph.addNode(yoyogi);
		graph.addNode(ochanomizu);
		graph.addNode(sendagaya);
		graph.addNode(shinanomachi);
		graph.addNode(yotsuya);
		graph.addNode(ichigaya);
		graph.addNode(iidabashi);
		graph.addNode(suidobashi);

		return graph;
	}

	public ArrayList<String> getCaminoMinimoResumido(){
		ArrayList<String> caminoMini = new ArrayList<String>(); 
		for(int arg2 = 0; arg2 < caminoMinimoResumido.size(); arg2++) {
			caminoMini.add(caminoMinimoResumido.get(arg2).getEstacion());
		}
		return caminoMini;
	}

	public ArrayList<String> getCaminoMinimo(){
		return caminoMinimo;
	}

	/*public static void main(String[] args) {
		MapRepresentation mapita=new MapRepresentation();
		Graph graph = getEstaciones();
		Node origen=graph.getNode("Harajuku");
		Node destino=graph.getNode("Kanda");
		mapita.getF(origen, destino);
		System.out.println(caminoMinimo);
	}*/

}
