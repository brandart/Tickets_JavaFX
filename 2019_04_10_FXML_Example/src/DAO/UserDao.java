package DAO;

import java.util.ArrayList;
import java.util.List;

import org.restlet.ext.odata.Query;

import Service.MyService;
import ticketdbmodel.Ticket;
import ticketdbmodel.User;

public class UserDao {

	private MyService service;
	
	public UserDao() {
		service = MyService.getInstance();
	}
	
	public List<User> findAll(){
		List<User> l = new ArrayList<>();
		
		Query<User> q = service.createUserQuery("/Users");
		for(User t: q) {
			l.add(t);
		}
		
		return l;
	}
	
}
