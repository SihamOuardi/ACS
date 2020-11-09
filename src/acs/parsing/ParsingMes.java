package acs.parsing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import acs.message.AReqMes;
import acs.message.ErrorCode;
import acs.message.ErrorMes;
import security.ConstScurity;

public class ParsingMes {
    public static Boolean isError = false ;
    public static Boolean requierElm =false;
	private ErrorMes errorMes = new ErrorMes();
	 ObjectMapper mapper = new ObjectMapper();
	 public static boolean typeError = false ;
	public static boolean deviceChanelError = false ; 
	private ArrayList<String> notExist = new ArrayList<String>();
	public static boolean ElemDuplicat = false ;
	private String listAreq= "";
	public static boolean msgVersion = false;
	
	public ParsingMes() {
		super();
	}

	// error Areq 
	public  ErrorMes errorMsgAReq(AReqMes aReqMes) {
		
		errorMes.setAcsTransID(aReqMes.getAcsTransID());
		errorMes.setDsTransID(aReqMes.getDsTransID());		
		errorMes.setMessageType(ConstScurity.messageTypeErro);
		errorMes.setErrorComponent(ErrorCode.errorComponentA);		
		errorMes.setThreeDSServerTransID(aReqMes.getThreeDSServerTransID());
		errorMes.setSdkTransID(aReqMes.getSdkTransID());		
		errorMes.setErrorDescription(listAreq);
		errorMes.setMessageVersion(aReqMes.getMessageVersion());
				
		return errorMes ;
	}

	// check ACS msg type that it receive ,it will be only this msg 
	public  boolean  MSGtype(String typemsg , String ExpectValue) {
		if(!typemsg.equals(ExpectValue)) {
		     typeError  = true ;
		}

		return typeError ;
	}

	// check consumer device 
	public  boolean  DeviceChenel(AReqMes areqMes) {
		String device = areqMes.getDeviceChannel(); // 01 or 02
		System.out.println("device " + device );

        if (device.equals("02")) {

        }
		
		return deviceChanelError ;
	}
	
	
	 // 4- check account number to determine transaction status and trx statu reason
		public  boolean  checkAccountNbr(AReqMes areqMes) {
			String account = areqMes.getAcctNumber(); // 01 or 02
	        
			//search in data base 
			 
			return deviceChanelError ;
		}
	
	
	public void parse(String json)  {
	       JsonFactory factory = new JsonFactory();
		   ArrayList<String> list1duplic = new ArrayList<String>();

	         ObjectMapper mapper = new ObjectMapper(factory);
			 JsonNode rootNode;
			 Set list = new HashSet();
		try {
			// System.out.println("json " +json.toString() );
			
			rootNode = mapper.readTree(json);
			
			Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
	       
			System.out.println("rootNode.toString().length() " + rootNode.toString().length());
			System.out.println("json.length() " + json.length());

			if(rootNode.toString().length() != json.length()) {
				System.out.println("**** True  **** ");

				ElemDuplicat = true ; 
				
			}
			
			while (fieldsIterator.hasNext()) {

		           Map.Entry<String,JsonNode> field = fieldsIterator.next();
//		           System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
			}
						
		} catch (JsonMappingException e) {
			e.getMessage();
		} catch (JsonProcessingException e) {
			e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}  

		

	}
	
	public Boolean requiredElement(String message) {
		listAreq="";
		try {
			JsonNode node = mapper.readTree(message);
		if(!node.has("threeDSRequestorURL")) {			
			listAreq ="threeDSRequestorURL, ";			
			requierElm =true;
		}		
		if(!node.has("threeDSRequestorID")) {			
			listAreq +="threeDSRequestorID, ";
			requierElm =true;
		}
		if(!node.has("threeDSRequestorName")) {			
			listAreq +="threeDSRequestorName, ";
			requierElm =true;
		}
		if(!node.has("threeDSServerRefNumber")) {
			
			listAreq +="threeDSServerRefNumber, ";
			requierElm =true;
		}
		if(!node.has("threeDSRequestorURL")) {
			
			listAreq +="threeDSRequestorURL, ";
			requierElm =true;
		}
		if(!node.has("threeDSServerTransID")) {
			
			listAreq +="threeDSServerTransID, ";
			requierElm =true;
		}
		if(!node.has("threeDSServerURL")) {
			
			listAreq +="threeDSServerURL, ";
			requierElm =true;
		}
		
		if(!node.has("acquirerBIN")) {
					
			listAreq +="acquirerBIN, ";
			requierElm =true;
		}
		
		if(!node.has("acquirerMerchantID")) {
			
			listAreq +="acquirerMerchantID, ";
			requierElm =true;
		}
		
		if(!node.has("acctNumber")) {
			
			listAreq +="acctNumber, ";
			requierElm =true;
		}
		
		} catch (JsonMappingException e) {
			e.getMessage();
		} catch (JsonProcessingException e) {
			e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		
		return requierElm ;
	}
	
	
	public Boolean getIsError() {
		return isError;
	}

	
	public ErrorMes getErrorMes() {
		return errorMes;
	}

	public void setErrorMes(ErrorMes errorMes) {
		this.errorMes = errorMes;
	}
	
	
	
}
