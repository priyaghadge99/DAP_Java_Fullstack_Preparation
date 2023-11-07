package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

	@Column(name = "Customer_id")
	@Id
	int Id;
	@Column(name = "FIRST_NAME")
	String FirstName;
	@Column(name = "LAST_NAME")
	String LastName;
	@Column(name = "INCOME")
	int Income;
	@Column(name = "LOSS")
	float Loss;
	@Column(name = "ADDITIONAL")
	float Additional;
	@Column(name = "QUANTITY")
	float quantity;
	@Column(name = "LOCATION")
	String Location;
	@Column(name = "TYPE")
	String Type;
							

}
