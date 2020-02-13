package com.netent.bookstore.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

public class OrderDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	    private Long id;
		 @NotEmpty(message = "order line must not be empty")
	    private List<OrderLineDTO> orderLines = new ArrayList<>();

	    private Float totalOrder = 0F;

	    private String name;

	    private String address;

	    private Date creationDate;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public List<OrderLineDTO> getOrderLines() {
			return orderLines;
		}

		public void setOrderLines(List<OrderLineDTO> orderLines) {
			this.orderLines = orderLines;
		}

		public Float getTotalOrder() {
			return totalOrder;
		}

		public void setTotalOrder(Float totalOrder) {
			this.totalOrder = totalOrder;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Date getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    
}
