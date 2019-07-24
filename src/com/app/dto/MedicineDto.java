package com.app.dto;

public class MedicineDto {
	private Integer medID;
	private String medName;
	private String medCategory;
	private double medPrice;
	
	public MedicineDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MedicineDto(Integer medID, String medName, String medCategory, double medPrice) {
		super();
		this.medID = medID;
		this.medName = medName;
		this.medCategory = medCategory;
		this.medPrice = medPrice;
	}


	public Integer getMedID() {
		return medID;
	}
	public void setMedID(Integer medID) {
		this.medID = medID;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public String getMedCategory() {
		return medCategory;
	}
	public void setMedCategory(String medCategory) {
		this.medCategory = medCategory;
	}
	public double getMedPrice() {
		return medPrice;
	}
	public void setMedPrice(double medPrice) {
		this.medPrice = medPrice;
	}
	@Override
	public String toString() {
		return "MedicineDto [medID=" + medID + ", MedName=" + medName + ", medCategory=" + medCategory + ", medPrice="
				+ medPrice + "]";
	}
	
	
}
