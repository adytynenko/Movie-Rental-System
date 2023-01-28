package edu.wccnet.adytynenko.movieApp.controller;

public class NotFoundException extends RuntimeException {
	
	public NotFoundException(String msg) {
		super(msg);
	}
}
