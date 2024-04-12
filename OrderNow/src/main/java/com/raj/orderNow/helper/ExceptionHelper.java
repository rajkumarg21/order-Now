package com.raj.orderNow.helper;

public class ExceptionHelper {
	public static RuntimeException throwResourceNotFoundException() {
		return new RuntimeException("Resource not found");
	}

}
