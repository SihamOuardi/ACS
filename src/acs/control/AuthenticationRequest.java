package acs.control;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.impl.Log4JLogger;

import com.fasterxml.jackson.databind.ObjectMapper;

import acs.construct.ConstructMsg;
import acs.message.AReqMes;
import acs.message.AResMes;
import acs.message.ErrorMes;
import acs.parsing.ParsingMes;
import acs.utils.CheckAuthen;
/*
 * 
 */
@WebServlet("/authenticationRequest")
public class AuthenticationRequest extends HttpServlet  {

	
	private static final long serialVersionUID = 3286511472945328526L;
	AReqMes areqMes = new AReqMes();
	ParsingMes parsingMes =new ParsingMes();	
	private ErrorMes errorMes = new ErrorMes();
	ObjectMapper mapper = new ObjectMapper();
	private static HttpSession httpSession;
	public final Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	AResMes aResMes = new AResMes();

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("AuthenticationRequest " );
		httpSession= request.getSession();
		httpSession.setMaxInactiveInterval(100);
		
		String receivedMessage = readRequestBuffer(request.getReader());
		System.out.println("receivedMessage " + receivedMessage);
		// Json ---> java object 
		areqMes = mapper.readValue(receivedMessage, AReqMes.class);
		
		httpSession.setAttribute("receivedMessage",receivedMessage);

		// check Areq 
		// 0- duplicat elem 
		parsingMes.parse(receivedMessage);
		
		logger.info(" testt " + areqMes.getThreeDSRequestorPriorAuthenticationInfo().getThreeDSReqPriorAuthMethod());
				
		// required element 
        // 1- type element 
		
		parsingMes.MSGtype(areqMes.getMessageType(),"Areq");
		
		// 2- required element 
	
		parsingMes.requiredElement(receivedMessage);
			
		 // 3-  check consumer device 
		 
		 parsingMes.DeviceChenel(areqMes);
		 
	
		 // 4- check account number to determine transaction status and trx statu reason
		 
		 CheckAuthen checkAuthen = new CheckAuthen();
		 checkAuthen.authentification(areqMes.getAcctNumber(),  aResMes);
		 
		 // 5- generate ACS ID 
		 String ACSID= ConstructMsg.generateACSID();
		 
		 // error syntax
		 if(ParsingMes.msgVersion) {
			 
			 logger.info(" ParsingMes.requierElm "+ ParsingMes.requierElm);
			 errorMes.setAcsTransID(ACSID);
			 errorMes.setErrorCode("102");
			 errorMes = parsingMes.errorMsgAReq(areqMes);
	         String Error = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorMes);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(Error); 
			
		}
		 else if(ParsingMes.requierElm) {
			 
			 logger.info(" ParsingMes.requierElm "+ ParsingMes.requierElm);
			 errorMes.setAcsTransID(ACSID);
			 errorMes.setErrorCode("201");
			 errorMes = parsingMes.errorMsgAReq(areqMes);
	         String Error = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorMes);
			 response.setContentType("application/json;charset=utf-8");
			 response.getWriter().write(Error); 
			
		}
		 else  if(ParsingMes.deviceChanelError) {
			logger.info(" ParsingMes.deviceChanelError "+ ParsingMes.deviceChanelError);

		    errorMes.setAcsTransID(ACSID);	
			errorMes = parsingMes.errorMsgAReq(areqMes);
		    String Error = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorMes);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(Error); 
			
		}else  if(ParsingMes.ElemDuplicat) {
			logger.info(" ParsingMes.ElemDuplicat "+ ParsingMes.ElemDuplicat);
		    errorMes.setAcsTransID(ACSID);	 
		    errorMes.setErrorCode("204");
		    
			errorMes = parsingMes.errorMsgAReq(areqMes);
		    String Error = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorMes);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(Error); 
			
		}
		
		else {
			
			/*if(CheckAuthen.statusAuth.equals("Y")) {				
				
			}*/
			aResMes.setAcsTransID(ACSID);
			aResMes.setTransStatus(CheckAuthen.statusAuth);
			httpSession.setAttribute("AReqMes",areqMes);		
			aResMes = ConstructMsg.constructAresMes(aResMes, areqMes);		
			httpSession.setAttribute("AResMes",aResMes);
			
			// java object ---> Json
	        String aRes = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aResMes);
		        
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(aRes); 
			
			System.out.println("AuthenticationRequest END  do post  " );

	    	}
		 
	}

	
	private String readRequestBuffer(BufferedReader bufferedReader) {
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				jb.append(line.trim());
			}

		} catch (Exception e) {
			e.getMessage();
		} finally {
			
		}
		return jb.toString();
	}


	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("****  DoGET *****");
//		HttpSession session = request.getSession();
//	     
//	    session.setMaxInactiveInterval(300);    // session timeout in seconds
	     		
	}
	
}
