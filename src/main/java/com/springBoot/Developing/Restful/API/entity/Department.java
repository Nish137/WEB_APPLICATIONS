package com.springBoot.Developing.Restful.API.entity;

import org.springframework.stereotype.Component;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "department_table")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long depID;

	@Nonnull()
	private String depName;
	private String depAddress;
	private String depCode;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Long depID, String depName, String depAddress, String depCode) {
		this.depID = depID;
		this.depName = depName;
		this.depAddress = depAddress;
		this.depCode = depCode;
	}

	public Long getDepID() {
		return depID;
	}

	public void setDepID(Long depID) {
		this.depID = depID;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepAddress() {
		return depAddress;
	}

	public void setDepAddress(String depAddress) {
		this.depAddress = depAddress;
	}

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	@Override
	public String toString() {
		return "Department [depID=" + depID + ", depName=" + depName + ", depAddress=" + depAddress + ", depCode="
				+ depCode + "]";
	}

}
