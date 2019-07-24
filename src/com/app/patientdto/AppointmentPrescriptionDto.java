package com.app.patientdto;

public class AppointmentPrescriptionDto {
	private Integer prescId;
	private String noOfDaysToTake;
	private String whenTake;
	private String beforeAfterMeal;
	
	private Integer medID;
	private String medName;
	private String medCategory;
	private double medPrice;
	
	
	public AppointmentPrescriptionDto() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getPrescId() {
		return prescId;
	}
	public void setPrescId(Integer prescId) {
		this.prescId = prescId;
	}
	public String getNoOfDaysToTake() {
		return noOfDaysToTake;
	}
	public void setNoOfDaysToTake(String noOfDaysToTake) {
		this.noOfDaysToTake = noOfDaysToTake;
	}
	public String getWhenTake() {
		return whenTake;
	}
	public void setWhenTake(String whenTake) {
		this.whenTake = whenTake;
	}
	public String getBeforeAfterMeal() {
		return beforeAfterMeal;
	}
	public void setBeforeAfterMeal(String beforeAfterMeal) {
		this.beforeAfterMeal = beforeAfterMeal;
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

	public AppointmentPrescriptionDto(Integer prescId, String noOfDaysToTake, String whenTake, String beforeAfterMeal,
			Integer medID, String medName, String medCategory, double medPrice) {
		super();
		this.prescId = prescId;
		this.noOfDaysToTake = noOfDaysToTake;
		this.whenTake = whenTake;
		this.beforeAfterMeal = beforeAfterMeal;
		this.medID = medID;
		this.medName = medName;
		this.medCategory = medCategory;
		this.medPrice = medPrice;
	}

	@Override
	public String toString() {
		return "AppointmentPrescriptionDto [prescId=" + prescId + ", noOfDaysToTake=" + noOfDaysToTake + ", whenTake="
				+ whenTake + ", beforeAfterMeal=" + beforeAfterMeal + ", medID=" + medID + ", medName=" + medName
				+ ", medCategory=" + medCategory + ", medPrice=" + medPrice + "]";
	}
	
	
	
	
}
