package code;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import DAO.TicketDao;
import DAO.UserDao;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ticketdbmodel.Ticket;
import ticketdbmodel.User;

public class Verwalten {
	@FXML
	private Button myButton;
	
	private TicketDao dao;
	private UserDao userDao;
	
	private List<Ticket> list;
	
	@FXML
	private TableView<Ticket> ticketList;
	
	@FXML
	private TableColumn<Ticket, String> c1;
	
	@FXML
	private TableColumn<Ticket, String> c2;
	
	@FXML
	private TableColumn<Ticket, String> c3;
	
	@FXML
	private TableColumn<Ticket, String> c4;
	
	@FXML
	private DatePicker fromDate;
	
	@FXML
	private DatePicker toDate;
	
	private List<User> users;
	
	public Verwalten() {
		dao = new TicketDao();
		userDao = new UserDao();
		users = userDao.findAll();
	}
	@FXML
	public void initialize() {
		myButton.setText("Filter Tickets");
		list = dao.findAll();

		c1.setCellValueFactory(new PropertyValueFactory<>("id"));
		c2.setCellValueFactory(new PropertyValueFactory<>("description"));
		c3.setCellValueFactory(ticket -> {
		      SimpleStringProperty property = new SimpleStringProperty();
		      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		      property.setValue(dateFormat.format(ticket.getValue().getCreatedAt()));
		      return property;
		   });
		c4.setCellValueFactory(ticket -> {
			SimpleStringProperty property = new SimpleStringProperty();
			Optional<User> us = users.stream().filter(u -> u.getId() == ticket.getValue().getUserId()).findFirst();
		    if(us.isPresent()) {
		    	property.setValue(us.get().getUsername());
		    }
		    return property;
	    });
		ticketList.setItems(FXCollections.observableArrayList(list));
	}
	
	@FXML
    private void buttonListener() 
    {
		List<Ticket> list = dao.findAll();
		List<Ticket> listFiltered = new ArrayList<>();
		LocalDate from = fromDate.getValue();
		Date dateFrom = Date.from(from.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		LocalDate to = toDate.getValue();
		Date dateTo = Date.from(to.atStartOfDay(ZoneId.systemDefault()).toInstant());
		for(Ticket t: list) {
			if(t.getCreatedAt().after(dateFrom) && t.getCreatedAt().before(dateTo)) {
				listFiltered.add(t);
			}
			
		}
		
		ticketList.setItems(FXCollections.observableArrayList(listFiltered));
    }
}
