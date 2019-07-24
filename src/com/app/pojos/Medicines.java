package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="medicines")
public class Medicines {
	private Integer medID;
	private String medName;
	private String medCategory;
	private double medPrice;
	private List<Prescription> prescriptions;
	public Medicines() {
		// TODO Auto-generated constructor stub
	}

	public Medicines(String medName, String medCategory, double medPrice) {
		super();
		this.medName = medName;
		this.medCategory = medCategory;
		this.medPrice = medPrice;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="med_id")
	public Integer getMedID() {
		return medID;
	}

	public void setMedID(Integer medID) {
		this.medID = medID;
	}

	@Column(name="med_name",length=20)
	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	@Column(name="med_cat",length=20)
	public String getMedCategory() {
		return medCategory;
	}

	public void setMedCategory(String medCategory) {
		this.medCategory = medCategory;
	}

	@Column(name="med_price")
	public double getMedPrice() {
		return medPrice;
	}

	public void setMedPrice(double medPrice) {
		this.medPrice = medPrice;
	}

	@Override
	public String toString() {
		return "Medicines [medID=" + medID + ", MedName=" + medName + ", medCategory=" + medCategory + ", medPrice="
				+ medPrice + "]";
	}

	
	
	@JsonIgnore
	@OneToMany(mappedBy="medicines",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	
	public void addPrescriptionToMedicine(Prescription prescription) {
		this.prescriptions.add(prescription);
		prescription.setMedicines(this);
	}
	
	public void removePrescriptionToMedicine(Prescription prescription) {
		this.prescriptions.remove(prescription);
		prescription.setMedicines(null);
	}
}
