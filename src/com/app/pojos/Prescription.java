package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="prescription")
public class Prescription {
	private Integer id;
	private String noOfDaysToTake;
	private String whenTake;
	private String beforeAfterMeal;
	private AppointmentTable appointment;
	private Medicines medicines;
	
	public Prescription() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Prescription(String noOfDaysToTake, String whenTake, String beforeAfterMeal) {
		super();
		this.noOfDaysToTake = noOfDaysToTake;
		this.whenTake = whenTake;
		this.beforeAfterMeal = beforeAfterMeal;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="presc_id")
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="no_of_days_to_take",length=20)
	public String getNoOfDaysToTake() {
		return noOfDaysToTake;
	}


	public void setNoOfDaysToTake(String noOfDaysToTake) {
		this.noOfDaysToTake = noOfDaysToTake;
	}

	@Column(name="when_take",length=20)
	public String getWhenTake() {
		return whenTake;
	}


	public void setWhenTake(String whenTake) {
		this.whenTake = whenTake;
	}


	@Column(name="before_after_meal",length=20)
	public String getBeforeAfterMeal() {
		return beforeAfterMeal;
	}


	public void setBeforeAfterMeal(String beforeAfterMeal) {
		this.beforeAfterMeal = beforeAfterMeal;
	}

	
	@ManyToOne
	@JoinColumn(name="app_fk_id")
	public AppointmentTable getAppointment() {
		return appointment;
	}


	public void setAppointment(AppointmentTable appointment) {
		this.appointment = appointment;
	}

	
	@ManyToOne
	@JoinColumn(name="med_fk_id")
	public Medicines getMedicines() {
		return medicines;
	}


	public void setMedicines(Medicines medicines) {
		this.medicines = medicines;
	}


	@Override
	public String toString() {
		return "Prescription [id=" + id + ", noOfDaysToTake=" + noOfDaysToTake + ", whenTake=" + whenTake
				+ ", beforeAfterMeal=" + beforeAfterMeal + "]";
	}
	
	
}
