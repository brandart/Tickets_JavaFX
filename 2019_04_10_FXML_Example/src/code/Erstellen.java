package code;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import DAO.TicketDao;
import DAO.UserDao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import ticketdbmodel.Ticket;
import ticketdbmodel.User;

public class Erstellen {

	@FXML
	ComboBox comboBenutzer;
	
	@FXML
	DatePicker createdAt;
	
	@FXML
	TextField description;
	
	private UserDao dao;
	private TicketDao ticketDao;
	
	private List<User> users;
	
	public Erstellen() {
		dao = new UserDao();
		ticketDao = new TicketDao();
	}
	@FXML
	public void initialize() {
		System.out.println("Set users");
		users = dao.findAll();
		comboBenutzer.setItems(FXCollections.observableArrayList(users));
		
		comboBenutzer.setConverter(new StringConverter<User>() {

		    @Override
		    public String toString(User object) {
		        return object.getUsername();
		    }
			@Override
			public User fromString(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}


		});
		
	}
	
	@FXML
	public void Submit() {
		User u = (User)comboBenutzer.getSelectionModel().getSelectedItem();
		
		Ticket k = new Ticket();
		
		Date date = Date.from(createdAt.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		k.setCreatedAt(date);
		k.setDescription(description.getText());
		k.setUserId(u.getId());
		
		ticketDao.addTicket(k);
	}
}
