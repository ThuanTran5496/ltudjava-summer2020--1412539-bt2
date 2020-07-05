package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subject", schema = "public")
public class Subject implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Schedule scheduleObj;
	private int schedule_id;
	private String ma_mh;
	private String name;
	private String room;

	public Subject() {

	}

	public Subject(String ma_mh, String name, String room, Schedule scheduleObj) {
		this.ma_mh = ma_mh;
		this.name = name;
		this.room = room;
		this.scheduleObj = scheduleObj;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
	public Schedule getSchedule() {
		return scheduleObj;
	}

	public void setSchedule(Schedule scheduleObj) {
		this.scheduleObj = scheduleObj;
	}
	public String getMa_mh() {
		return ma_mh;
	}

	public void setMa_mh(String ma_mh) {
		this.ma_mh = ma_mh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
}
