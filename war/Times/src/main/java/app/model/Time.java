package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "times")
public class Time {

	String time1Date;
	String time1;
	String time2;
	String time3;
	String time4;
	String time5;
	String timeTotal;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	public Time(String time1Date, String time1, String time2, String time3, String time4, String time5,
			String timeTotal) {
		super();
		this.time1Date = time1Date;
		this.time1 = time1;
		this.time2 = time2;
		this.time3 = time3;
		this.time4 = time4;
		this.time5 = time5;
		this.timeTotal = timeTotal;
	}

	public Time() {
	}

	public String getTime1Date() {
		return time1Date;
	}

	public void setTime1Date(String time1Date) {
		this.time1Date = time1Date;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getTime3() {
		return time3;
	}

	public void setTime3(String time3) {
		this.time3 = time3;
	}

	public String getTime4() {
		return time4;
	}

	public void setTime4(String time4) {
		this.time4 = time4;
	}

	public String getTime5() {
		return time5;
	}

	public void setTime5(String time5) {
		this.time5 = time5;
	}

	public String getTimeTotal() {
		return timeTotal;
	}

	public void setTimeTotal(String timeTotal) {
		this.timeTotal = timeTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
