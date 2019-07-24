package com.app.dto;


public class InvoiceDto {
	private Integer invoiceId;
	private String description;
	private String status;
	private double price;
	private int patientId;
	private String patientName;
	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	@Override
	public String toString() {
		return "InvoiceDto [invoiceId=" + invoiceId + ", description=" + description + ", status=" + status + ", price="
				+ price + ", patientId=" + patientId + ", patientName=" + patientName + "]";
	}
	public InvoiceDto(Integer invoiceId, String description, String status, double price, int patientId,
			String patientName) {
		super();
		this.invoiceId = invoiceId;
		this.description = description;
		this.status = status;
		this.price = price;
		this.patientId = patientId;
		this.patientName = patientName;
	}
	
	public InvoiceDto() {
		// TODO Auto-generated constructor stub
	}
	
}
