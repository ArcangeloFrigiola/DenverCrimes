package it.polito.tdp.crimes.model;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	
	private EventsDao dao;
	private Graph<String, DefaultWeightedEdge> grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
	private Map<Long, Event> idMap;
	
	public Model() {
		this.dao = new EventsDao();
		this.idMap = new HashMap<>();
		//this.dao.listAllEvents(this.idMap);
	}
	
	public List<String> getAllCategoryCrimes(){
		
		return this.dao.getAllCategories();
	}
	
	public List<Month> getAllMonths(){
		return this.dao.getAllMonths();
	}
	
	//CREAZIONE DEL GRAFO
	public List<Adiacenze> generateGraph(String categoryCrime, Month mese) {
		
		List<String> vertici = new ArrayList<>(this.dao.getAllVertices(categoryCrime, mese));
		List<Adiacenze> adiacenze = new ArrayList<>();
		List<Adiacenze> result = new ArrayList<>();
		int peso = 0;
		for(String v1: vertici) {
			for(String v2: vertici) {
				
				if(v1.compareTo(v2)!=0 && !grafo.containsEdge(v1, v2)) {
					int quartieri = this.dao.getNumeroQuartieri(v1, v2);
					if(quartieri>0) {
						Graphs.addEdgeWithVertices(grafo, v1, v2, quartieri);
						adiacenze.add(new Adiacenze(v1, v2, quartieri));
						peso += quartieri;
					}
				}
				
			}
		}
		
		for(Adiacenze a: adiacenze) {
			if(a.getPeso()>(peso/adiacenze.size())) {
				result.add(a);
			}
		}
		System.out.println("Peso medio: "+peso/adiacenze.size());
		return result;
		
	}

	public int getNvertex() {
		return this.grafo.vertexSet().size();
	}
	public int getNedges() {
		return this.grafo.edgeSet().size();
	}
	
}
