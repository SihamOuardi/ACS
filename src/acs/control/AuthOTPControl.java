package acs.control;

import org.apache.commons.logging.impl.Log4JLogger;



public class AuthOTPControl {
    
	public final Log4JLogger logger = new Log4JLogger(this.getClass().getName());
    
	private String otp ;
	
	
	public void resendOTP(String acctID) {
		logger.debug("sendOTP ->");

		logger.debug("<- sendOTP");
	}
     
	public void checkOTPCode() {
		
		
	}

	public void cancel() {
		
		
	}
	
}
