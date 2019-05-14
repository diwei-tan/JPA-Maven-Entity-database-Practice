package application;

public class BadBookingException extends Exception {
	static final long serialVersionUID = 1;
	public BadBookingException(String msg) {
		super(msg);
	}
}
