package com.rauldev.springservices.entities.enums;

public enum OrderStatus {

	Waiting_payment(1),
	Paid(2),
	shipped(3),
	delivered(4),
	canceled(5);

	private int code;
	
	OrderStatus(int code) {
		
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public  static OrderStatus valueOf(int code) {
		for(OrderStatus status: OrderStatus.values()) {
			if(status.getCode() == code) {
				return status;
			}
			
		}throw new IllegalArgumentException("code inserted is not valid!");
	}
}
