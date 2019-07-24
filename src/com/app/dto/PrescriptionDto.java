package com.app.dto;

public class PrescriptionDto {
	private int prescriptionId;
	private int appId;
	private int medID;
	private String noOfDaysTake;
	private String whenTake;
	private String whenMeal;
	private String medName;
	private String medCategory;
	private double medPrice;
	public PrescriptionDto() {
		// TODO Auto-generated constructor stub
	}
	
	



	public PrescriptionDto(int prescriptionId, int appId, int medId, String noOfDaysTake, String whenTake,
			String whenMeal, String medName, String medCategory, double medPrice) {
		super();
		this.prescriptionId = prescriptionId;
		this.appId = appId;
		this.medID = medId;
		this.noOfDaysTake = noOfDaysTake;
		this.whenTake = whenTake;
		this.whenMeal = whenMeal;
		this.medName = medName;
		this.medCategory = medCategory;
		this.medPrice = medPrice;
	}





	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getMedID() {
		return medID;
	}
	public void setMedID(int medId) {
		this.medID = medId;
	}
	public String getNoOfDaysTake() {
		return noOfDaysTake;
	}
	public void setNoOfDaysTake(String noOfDaysTake) {
		this.noOfDaysTake = noOfDaysTake;
	}
	public String getWhenTake() {
		return whenTake;
	}
	public void setWhenTake(String whenTake) {
		this.whenTake = whenTake;
	}
	public String getWhenMeal() {
		return whenMeal;
	}
	public void setWhenMeal(String whenMeal) {
		this.whenMeal = whenMeal;
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
		return "PrescriptionDto [prescriptionId=" + prescriptionId + ", appId=" + appId + ", medID=" + medID
				+ ", noOfDaysTake=" + noOfDaysTake + ", whenTake=" + whenTake + ", whenMeal=" + whenMeal + ", medName="
				+ medName + ", medCategory=" + medCategory + ", medPrice=" + medPrice + "]";
	}
	
	
}
