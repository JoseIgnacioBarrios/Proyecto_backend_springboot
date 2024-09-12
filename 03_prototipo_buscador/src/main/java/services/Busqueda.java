package services;

import java.util.ArrayList;
import java.util.List;

import model.Resultado;

public class Busqueda {
	static List<Resultado> resultados=new ArrayList<>(List.of(
			new Resultado("http://www.fnac.es/","libros","Libros y más"),
			new Resultado("http://www.mybook.com/","libros","librería de temas varios"),
			new Resultado("http://www.game.es/","juegos","Juegos variados"),
			new Resultado("http://www.music.es/","música","Lamejor música"),
			new Resultado("http://www.tech.com/","libros","Libros técnicos"),
			new Resultado("http://www.eljuego.es/","juegos","Juegos on-line")
			));
	
	
	
//	public boolean existe(String tematica) {
//		Resultado res= resultados.stream()
//				.filter(r->r.getTematica().equals(tematica))
//				.findFirst()
//				.orElse(null);
//		 
//		 return (res != null)? true:false;
//	}
	
	public List<Resultado> encontrado(String tematica) {
		return resultados.stream()
				.filter(r->r.getTematica().equals(tematica)).toList();
		
	}
	
	public List<Resultado> buscarByUrl(String url) {
		return resultados.stream()
				.filter(r->r.getUrl().equals(url)).toList();
		
	}
	
	public void alta(Resultado resultado) {
		resultados.add(resultado);
	}
	
	
	public List<Resultado> eliminar(String url){
		
		//opcion 1 larga
//		List listaResultado =buscarByUrl(url);
//		if(!listaResultado.isEmpty()) {
//			for(Object res:listaResultado) {
//				resultados.remove(res);
//			}
//		}
		
		//opcion 2 corta
		resultados.removeIf(r->r.getUrl().equals(url));
		
		
		return resultados;
	}

}
