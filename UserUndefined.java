package com.ty.userapplication.exception;

public class UserUndefined extends RuntimeException {

	@Override
	public String getMessage() {
		return "User is not Defined";
	}
}
