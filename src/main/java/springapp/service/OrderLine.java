package springapp.service;

public class OrderLine {

	public String sku;
	public int quantity;
	public double unitPrice;
	public double vatRate;
	public String unitOfMeasure;	
		
	public OrderLine(String sku, int quantity, double unitPrice, double vatRate, String unitOfMeasure){
		
	
		
		this.sku = sku;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.vatRate = vatRate;
		this.unitOfMeasure = unitOfMeasure;	
		
		
	}
	

}
