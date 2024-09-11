package com.springBoot.Developing.Restful.API.entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
public class ErrorMessage {

	private HttpStatus stauts;
	private String message;

	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(HttpStatus stauts, String message) {
		super();
		this.stauts = stauts;
		this.message = message;
	}

	public HttpStatus getStauts() {
		return stauts;
	}

	public void setStauts(HttpStatus stauts) {
		this.stauts = stauts;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
