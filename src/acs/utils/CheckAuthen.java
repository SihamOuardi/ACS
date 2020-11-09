package acs.utils;

import org.apache.commons.logging.impl.Log4JLogger;

import acs.dao.DAO;
import acs.message.AResMes;
import acs.modal.AcsCardData;
import acs.modal.RangeParameters;

public class CheckAuthen {
	static Log4JLogger logger = new Log4JLogger(CheckAuthen.class.getName());
	DAO dao = new DAO();
    public static String statusAuth="N";
	
    
    
	public CheckAuthen() {
		super();
	}

	public RangeParameters getRange(String carNumber) {
		logger.debug("getRange ->" + carNumber);
		
		String creteria = " as model where model.id.lowRange<'" + carNumber + "'  and model.id.highRange>'" + carNumber + "' ";
		RangeParameters range = (RangeParameters) dao.findByGenCriteriaUniqueResult(RangeParameters.class, creteria);
		
		logger.debug("<- getRange" + range );
		return range;
	}
	
	public String  authentification( String accountNumber , AResMes aResMes) {
		
		RangeParameters range = getRange(accountNumber);
		if(range!=null) {
			AcsCardData acsCard = (AcsCardData) dao.findByIdObject(AcsCardData.class, accountNumber);
               if (acsCard != null ) {
       			statusAuth="Y" ;
               }else 
            	   statusAuth="C" ; // D
		     }			
		return statusAuth;
	}
	
}
