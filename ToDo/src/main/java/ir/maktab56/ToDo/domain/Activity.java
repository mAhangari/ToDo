package ir.maktab56.ToDo.domain;

import java.util.Date;
import javax.persistence.*;
import ir.maktab56.ToDo.base.domain.BaseEntity;
import ir.maktab56.ToDo.domain.enumeration.State;

@Entity
@Table(name = "activity")
public class Activity extends BaseEntity<Long> implements Comparable<Activity> {
	
	@Column(name = "state", nullable = false)
	private State state;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer; 
	
	public Activity() {
		super();
	}
	
	public Activity(Boolean isDeleted, State state, String title, Date date) {
		super(isDeleted);
		this.setState(state);
		this.setTitle(title);
		this.setDate(date);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int compareTo(Activity o) {
		return (int)(this.getId() - o.getId());
	}
	
	@Override
	public String toString() {
		String str = String.format("\n%5s %-4d%2s", "|", getId(), "|");
    	str += String.format("  %-14s %2s", title, "|");
    	str += String.format("  %-23s %2s", date, "|");
    	str += String.format("  %-11s %2s\n", state, "|");
    	str += 		 "    +---------------------------------------------------------------------+";
		return str;
	}
}
