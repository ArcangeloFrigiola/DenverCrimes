package it.polito.tdp.crimes.db;

import it.polito.tdp.crimes.model.Event;

public class TestDao {

	public static void main(String[] args) {
		EventsDao dao = new EventsDao();
		/*for(Event e : dao.listAllEvents())
			System.out.println(e);*/
		
		System.out.println("Numero di quartieri per i reati introdotti:\n"+
				dao.getNumeroQuartieri("traffic-accident", "disturbing-the-peace")+"\n");
		
	}

}
