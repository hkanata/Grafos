package main;

import java.util.ArrayList;

public class Routers {
	
	Integer distance;
	Integer totalEnds;

	String ends;
	String firstAux = "";
	String finalValue = "";
	String originDestination;
	
	Boolean totalEndsAux = true;
	Boolean accessGranted = true;
	
	ArrayList<ArrayList<?>> global       = new ArrayList<ArrayList<?>>();
	ArrayList<ArrayList<?>> newGlobal    = new ArrayList<ArrayList<?>>();
	ArrayList<ArrayList<?>> globalPoints = new ArrayList<ArrayList<?>>();
	
	public Routers(){ }
	
	public Routers(String originDestination, Integer distance){
		this.originDestination = originDestination;
		this.distance = distance;
	}

	public String getOriginDestination() {
		return originDestination;
	}

	public void setOriginDestination(String originDestination) {
		this.originDestination = originDestination;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	/**
	 * Pega as rotas a partir de um início e um fim
	 * com um maximo de paradas
	 * @param starts - Inicio da rota
	 * @param ends - Fim da rota
	 * @param maxStops - Numero de paradas
	 * @return As rotas se existir, senão retorna mensagem de erro
	 */
	public String tripLimit(String starts, String ends, Integer maxStops){
		
		PossibleRouters possibleRouters = PossibleRouters.getInstance();
		
		for (Routers listRouters : possibleRouters.listRouters) {
			
			String oriDest = listRouters.getOriginDestination().toString();
			
			if( oriDest.indexOf(starts) == 0 ){
				
				String first = oriDest.substring( 0, 1 ).toString();
				String last  = oriDest.substring( 1 ).toString();
				
				firstAux     = first;
				
				ArrayList<String> aux = new ArrayList<String>();
				aux.add(oriDest);
				
				//recursive
				getFirstPosChildren(last, oriDest, aux);
			}
		}
		
		return checkLimit(maxStops);
	}
	
	/**
	 * Pega as rotas que pertence a inicial recursivamente
	 * @param starts - Inicio da rota
	 * @param content - Rota
	 * @param aux - Array das rotas
	 */
	public void getFirstPosChildren(String starts, String content, ArrayList<String> aux){
		
		PossibleRouters possibleRouters = PossibleRouters.getInstance();
		
		for (Routers listRouters : possibleRouters.listRouters) {
			
			String origDest = listRouters.getOriginDestination().toString();
			
			if(!aux.contains(origDest)){
				if( origDest.indexOf(starts) == 0 ){
					
					String last = origDest.substring( 1 ).toString();
					aux.add(origDest);
					
					if( !(origDest.indexOf(firstAux) == 1) )
						getFirstPosChildren(last, origDest, aux);
					 else { 
						globalPoints.add(aux);
						break;
					}
				}
			}
		}
	}

	/**
	 * Verifica o limite de paradas
	 * @param maxStops - Total paradas
	 * @return Numero de paradas e distância entre elas
	 */
	public String checkLimit(Integer maxStops){
		
		ArrayList<String> route = new ArrayList<String>();
		
		for (ArrayList<?> globPoint : globalPoints) {
			if(globPoint.size() == maxStops)
				for( int j = 0 ; j < globPoint.size() ; j++ ) 
					route.add((String) globPoint.get(j));
		}
		return "Number of Trips is: " + (route.size()-1) + " ::: " + checkDistance(route);
	}
	
	/* * */
	
	/**
	 * Menor rota
	 * @param starts - Inicio da rota
	 * @param ends - Fim da rota
	 * @return Distância entre elas
	 */
	@SuppressWarnings("unchecked")
	public String mostShortest(String starts, String ends){
		
		if(this.finalValue.length() == 0) 
			this.finalValue = ends;
		
		PossibleRouters possibleRouters = PossibleRouters.getInstance();
		
		for (Routers listRouters : possibleRouters.listRouters) {
			ArrayList<String> aux = new ArrayList<String>();
			String origDest       = listRouters.getOriginDestination().toString();
			
			if( origDest.indexOf(starts) == 0 ){
				if( !aux.contains(origDest) ) {
					aux.add(origDest);
					global.add(aux);
				}
			}
		}
		
		ArrayList<ArrayList<?>> tmp = new ArrayList<ArrayList<?>>();
		tmp                         = getAllContains(global, ends);
		
		String message = "";
		for( int i = 0 ; i < tmp.size() ; i++ ) {
			message += checkDistance((ArrayList<String>)tmp.get(i)) + "\n";
		}
		return message;
	}
	
	/**
	 * Pega todas as rotas filha
	 * @param firstLocations - Primeiras rotas achadas
	 * @param ends - Fim da rota
	 * @return Novas Rotas
	 */
	public ArrayList<ArrayList<?>> getAllContains(ArrayList<ArrayList<?>> firstLocations, String ends){
		
		PossibleRouters possibleRouters = PossibleRouters.getInstance();
		
		for( int j = 0 ; j < firstLocations.size() ; j++ ) {
			
			ArrayList<String> newAr = new ArrayList<String>();
			
			String first = firstLocations.get(j).get(0).toString();
				newAr.add(first);
			String two   = first.substring( 1 ).toString();
			
			int i = 0;
			for( ; i < possibleRouters.listRouters.size() ; i++ ) {
				
				String origDest = possibleRouters.listRouters.get(i).getOriginDestination().toString();
				
				if( !first.equals(origDest) ) {
					if( origDest.indexOf(two) == 0 ){
						if( origDest.indexOf(ends) == 1 ){
							newAr.add(origDest);
							newGlobal.add(newAr);
							break;
						} else {
							if( !newAr.contains(origDest) ) {
								newAr.add(origDest);
								first = origDest;
								two   = origDest.substring( 1 ).toString();
								i=-1;
							}
						}
					}
				}
			}
		}
		return newGlobal;
	}
	
	/* * */
	
	/**
	 * Pega a rota do inicio ao fim com numero maximo de paradas
	 * @param starts - Inicio da rota
	 * @param ends - Fim da rota
	 * @param maxStops - Maximo paradas
	 * @return Novas Rotas
	 */
	@SuppressWarnings("unchecked")
	public String tripStartsEnds(String starts, String ends, Integer maxStops){
		
		if(this.finalValue.length() == 0)
			this.finalValue = ends;
		
		PossibleRouters possibleRouters = PossibleRouters.getInstance();
		
		for (Routers listRouters : possibleRouters.listRouters) {
			
			ArrayList<String> aux = new ArrayList<String>();
			String origDest       = listRouters.getOriginDestination().toString();
			
			if( origDest.indexOf(starts) == 0 ){
				if( !aux.contains(origDest) ) {
					aux.add(origDest);
					global.add(aux);
				}
			}
		}
		
		ArrayList<ArrayList<?>> tmp = new ArrayList<ArrayList<?>>();
		tmp 					    = getAllTripContains(global, ends);
		
		String message = "";
		for( int i = 0 ; i < tmp.size() ; i++ ) 
			message += checkDistance((ArrayList<String>) tmp.get(i)) + "\n";
		
		return "Number of Trips is " + (tmp.size()) + " : \n " + message;
	}
	
	/**
	 * Pegar todas as rotas que contem viagens
	 * @param firstLocations - Rotas Postas
	 * @param ends - Fim da rota
	 * @return Novas Rotas
	 */
	public ArrayList<ArrayList<?>> getAllTripContains(ArrayList<ArrayList<?>> firstLocations, String ends){
		
		this.totalEnds                  = getCountTypeRoute(ends);
		PossibleRouters possibleRouters = PossibleRouters.getInstance();
		
		for( int j = 0 ; j < firstLocations.size() ; j++ ) {
			
			ArrayList<String> newAr = new ArrayList<String>();
			
			String first = firstLocations.get(j).get(0).toString();
			String two   = first.substring( 1 ).toString();
			
			newAr.add(first);
			
			int i = 0;
			
			for( ; i < possibleRouters.listRouters.size() ; i++ ) {
				
				String origDest = possibleRouters.listRouters.get(i).getOriginDestination().toString();
				
				int cont = 0;
				for( int p = 0 ; p < newAr.size() ; p++ ) {
					if( newAr.get(p).indexOf(ends) == 1 ) 
						cont++;
					
				}
				if( this.totalEnds == cont ){
					this.accessGranted = false;
					this.accessGranted = true;
					
					newGlobal.add(newAr);
					break;
				}
				if( !first.equals(origDest) ) {
					if( origDest.indexOf(two) == 0 ){
						if(this.accessGranted){
							newAr.add(origDest);
							two = origDest.substring( 1 ).toString();
							i = -1;
						}else break;
					}
				}
			}
		}
		return newGlobal;
	}
	
	/* * */
	
	/**
	 * @param starts - Inicio Rota
	 * @param content - Conteudo da rota
	 * @param firstRoutes - Todas rotas
	 */
	public void getAllChild(String starts, String content, ArrayList<String> firstRoutes){
		
		PossibleRouters possibleRouters = PossibleRouters.getInstance();
		int countLastAux = 0;
		for( int i = 0 ; i < possibleRouters.listRouters.size() ; i++ ) {
			
			String origDest = possibleRouters.listRouters.get(i).getOriginDestination().toString();
			
			if( origDest.indexOf(starts) == 0 ){
				
				String last = origDest.substring( 1 ).toString();

				for(int j = 0 ; j < firstRoutes.size() ; j++)
					if(firstRoutes.get(j).substring( 1 ).toString().equals(this.ends)) 
						countLastAux ++ ;
					
				if( countLastAux == this.totalEnds ) {
					this.totalEndsAux = false;
					break;
				}
				
				if(this.totalEndsAux){
					firstRoutes.add(origDest);	
					if( (origDest.indexOf(this.firstAux) == 1) ){
						getAllChild(last, origDest, firstRoutes);
					} else if( (origDest.indexOf(last) == 1) ){
						this.firstAux = last;
						getAllChild(last, origDest, firstRoutes);
					} 
				}else {
					if( !globalPoints.contains(firstRoutes) ) {
						globalPoints.add(firstRoutes);
						
						firstRoutes   = null;
						countLastAux  = 0;
						this.firstAux = starts;
						break;
					} 
				}
			}
		}
	}
	
	/* * */
	
	/**
	 * Diferentes rotas
	 * @param starts - Inicio Rota
	 * @param ends - Fim da rota
	 * @param max - Soma maxima das rotas
	 * @return Rotas somadas
	 */
	@SuppressWarnings("unchecked")
	public String getRouterLessThan(String starts, String ends, Integer max){
		
		if(this.finalValue.length() == 0) 
			this.finalValue = ends;
		
		PossibleRouters possibleRouters = PossibleRouters.getInstance();
		
		for (Routers listRouters : possibleRouters.listRouters) {
			ArrayList<String> aux = new ArrayList<String>();
			String origDest       = listRouters.getOriginDestination().toString();
			
			if( origDest.indexOf(starts) == 0 ){
				if( !aux.contains(origDest) ) {
					aux.add(origDest);
					global.add(aux);
				}
			}
		}
		
		ArrayList<ArrayList<?>> aux = new ArrayList<ArrayList<?>>();
		aux                         = getAllContains(global, ends);
		
		String message = "";
		
		ArrayList<ArrayList<?>> tmpGlob = new ArrayList<ArrayList<?>>();
		for( int i = 0 ; i < aux.size() ; i++ ) {
			
			ArrayList<String> tmp = new ArrayList<String>();
			
			Integer total = 0;
			for( int j = 0 ; j < aux.get(i).size() ; j++ ) {
				for( int k = 0 ; k < possibleRouters.listRouters.size() ; k++ ) {
					if( possibleRouters.listRouters.get(k).getOriginDestination() == aux.get(i).get(j) ) {
						total = total + possibleRouters.listRouters.get(k).getDistance();
						tmp.add((String) aux.get(i).get(j));
					}
				}
			}
			if(total < max) tmpGlob.add(tmp);
		}
		if( tmpGlob.size() > 0 ) {
			for( int i = 0 ; i < tmpGlob.size() ; i++ ) 
				message += checkDistance((ArrayList<String>) tmpGlob.get(i)) + "  less than " + max + " \n";
		} else 
			message = "Doesn't exists";
		
		return message;
	}
	
	/**
	 * Total de tipo de rotas
	 * @param ends - Fim da rota
	 * @return Quantidade de rotas que contem ENDS
	 */
	public Integer getCountTypeRoute(String ends){
		PossibleRouters possibleRouters = PossibleRouters.getInstance();
		
		Integer count = 0;
		for( int i = 0 ; i < possibleRouters.listRouters.size() ; i++ ) {
			String oriDest = possibleRouters.listRouters.get(i).getOriginDestination().toString();
			if( oriDest.indexOf(ends) == 1 ) {
				count++;
			}
		}
		return count;
	}
	
	/*
	 * CheckDistance Global
	 * Global functions that returns 
	 * The Distance between Points 
	 * */
	public String checkDistance(ArrayList<String> route){
		
		PossibleRouters possibleRouters = PossibleRouters.getInstance();
		
		String message    = "";
		int routeSize     = route.size();
		int totalDistance = 0;
		
		for( int j = 0 ; j < routeSize ; j++ ) {
			int aux = 0;
			for( int i = 0 ; i < possibleRouters.listRouters.size() ; i++ ) {
				
				if( possibleRouters.listRouters.get(i).
						getOriginDestination().toString().
							equals(route.get(j).toString()) ) {
					
					message += " ";
					message += "Rota: " + route.get(j).toString();
					message += " ";
					message += "Distance: " + possibleRouters.listRouters.get(i).getDistance().toString();
					totalDistance = totalDistance + possibleRouters.listRouters.get(i).getDistance();
					aux --;
				} else {
					aux ++;
				}
			}
			if( possibleRouters.listRouters.size() == aux )
				return "no such ROUTE";	
		}
		message += " ";
		return message + "Total: " + totalDistance;
	}
}
