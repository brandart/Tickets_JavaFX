package code;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.TicketDao;
import DAO.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import ticketdbmodel.Ticket;
import ticketdbmodel.User;

public class Statistik {

	@FXML
	DatePicker fromDate;
	
	@FXML
	DatePicker toDate;
	
	@FXML
	PieChart ticketChart;
	
	private UserDao userDao;
	private TicketDao ticketDao;
	
	public List<User> users;
	public List<Ticket> tickets;
	
	private ObservableList<PieChart.Data> pieChartData;
	
	public Statistik() {
		userDao = new UserDao();
		ticketDao = new TicketDao();
		
		users = userDao.findAll();
		tickets = ticketDao.findAll();
	}
	
	@FXML
	public void calculate() {
		ArrayList<PieChart.Data> list = new ArrayList();
		
		
		for(User u: users) {
			int count = 0;
			for(Ticket t: tickets) {
				LocalDate to = toDate.getValue();
				Date dateTo = Date.from(to.atStartOfDay(ZoneId.systemDefault()).toInstant());
				LocalDate from = fromDate.getValue();
				Date dateFrom = Date.from(from.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				if(t.getUserId() == u.getId() && t.getCreatedAt().before(dateTo) && t.getCreatedAt().after(dateFrom) ) {
					count++;
				}

			}
			if(count > 0) {
				list.add(new PieChart.Data(u.getName(), count));
			}
			
		}
		
		pieChartData = FXCollections.observableArrayList(list);
		ticketChart.setData(pieChartData);
	}
}
