package acs.dao;



import org.apache.commons.logging.impl.Log4JLogger;

import acs.modal.RangeParameters;

public class Dbquiery {

	private DAO dao = new DAO();
	public static Log4JLogger logger = new Log4JLogger(DAO.class.toString());

	public RangeParameters getRange(String carNumber) {
		logger.debug("getRange ->" + carNumber);
		
		String creteria = " as model where model.id.lowRange<'" + carNumber + "'  and model.id.highRange>'" + carNumber + "' ";
		RangeParameters range = (RangeParameters) dao.findByGenCriteriaUniqueResult(RangeParameters.class, creteria);
		
		logger.debug("<- getRange" + range.toString());
		return range;
	}
	
	
	
}
