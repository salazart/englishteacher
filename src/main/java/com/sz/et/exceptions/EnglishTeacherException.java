package com.sz.et.exceptions;

public class EnglishTeacherException extends Exception{
	  private static final long serialVersionUID = 1L;
	  public EnglishTeacherException() { super(); }
	  public EnglishTeacherException(String message) { super(message); }
	  public EnglishTeacherException(String message, Throwable cause) { super(message, cause); }
	  public EnglishTeacherException(Throwable cause) { super(cause); }
}
