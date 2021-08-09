package ir.maktab56.ToDo.domain;

import java.util.Date;
import ir.maktab56.ToDo.base.domain.BaseEntity;
import ir.maktab56.ToDo.domain.enumeration.Mode;
import ir.maktab56.ToDo.domain.enumeration.State;

public class Activity extends BaseEntity<Long> implements Comparable<Activity> {
	
	private State state;
	private Mode mode;
	private String title;
	private Date date;
	
	public Activity(Long id, Boolean isDeleted, State state, Mode mode, String title, Date date) {
		super(id, isDeleted);
		this.setState(state);
		this.setMode(mode);
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

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	@Override
	public int compareTo(Activity o) {
		if(mode == Mode.INCREASE)
			return (int)(this.getId() - o.getId());
		return (int)(o.getId() - this.getId());
	}
}
