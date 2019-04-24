package DAO;

import java.util.ArrayList;
import java.util.List;

import org.restlet.ext.odata.Query;

import Service.MyService;
import ticketdbmodel.Ticket;

public class TicketDao {

	private MyService service;
	
	public TicketDao() {
		service = MyService.getInstance();
	}
	
	public List<Ticket> findAll(){
		List<Ticket> l = new ArrayList<>();
		
		Query<Ticket> q = service.createTicketQuery("/Tickets");
		for(Ticket t: q) {
			l.add(t);
		}
		
		return l;
	}
	
	public void addTicket(Ticket t) {
		try {
			service.addEntity(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
