package com.netent.bookstore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="myOrder")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @Version
	    @Column(name = "version")
	    private int version;

	    @OneToMany(fetch = FetchType.EAGER)
	    private List<OrderLine> orderLines = new ArrayList<>();

	    private Float totalOrder = 0F;

	    @Column
	    private String name;

	    @Column
	    private String address;

	    @Column
	    private Date creationDate;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getVersion() {
			return version;
		}

		public void setVersion(int version) {
			this.version = version;
		}

		public List<OrderLine> getOrderLines() {
			return orderLines;
		}

		public void setOrderLines(List<OrderLine> orderLines) {
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
