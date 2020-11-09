package acs.Json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import acs.message.AReqMes;
import acs.message.AResMes;


public class AReqJson {
	
	static ObjectMapper mapper = new ObjectMapper();

	public static AReqMes JsonToAReq( ) {
		
		AReqMes aReqMes = new AReqMes(); 
		try {
			System.out.print(" AresMeq " +"\n" );

			aReqMes = mapper.readValue(new File("c:\\BITS\\ACS2.2.2\\AReqMes.json"), AReqMes.class);

		} catch (IOException e) {
			
			e.getMessage();
		}
		System.out.print(" AresMeq " +"\n"  + aReqMes.getThreeDSCompInd());

		return aReqMes;
	}
	
	public static  String AReqtoJson(AReqMes aReqMes) {
		System.out.print(" AReqtoJson ---> " );
	/*	
		{
			"messageVersion":"2.1.0",
			"dsTransID":"f25084f0-5b16-4c0a-ae5d-b24808a95e4b",
			"messageType":"ARes",
			"threeDSServerTransID":"8a880dc0-d2d2-4067-bcb1-b08d1690b26e",
			"acsTransID":"d7c1ee99-9478-44a6-b1f2-391e29c6b340",
			"acsReferenceNumber":"3DS_LOA_ACS_PPFU_020100_00009",
			"acsOperatorID":"AcsOpId 4138359541",
			"dsReferenceNumber":"DS_LOA_DIS_PPFU_020100_00010",
			"transStatus":"C",
			"acsChallengeMandated":"Y",
			"acsURL":"https://test.com",
			"authenticationType":"01"
			}
		*/
		
		String jsonToAreq = null;
			try {
				jsonToAreq = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aReqMes);
			} catch (JsonProcessingException e) {
				e.getMessage();
			}

		
		return jsonToAreq;
	}
	
	public  String ARestoJson(AResMes aResMes) {
		System.out.print(" ARestoJson ---> " );
	/*	
		{
			"messageVersion":"2.1.0",
			"dsTransID":"f25084f0-5b16-4c0a-ae5d-b24808a95e4b",
			"messageType":"ARes",
			"threeDSServerTransID":"8a880dc0-d2d2-4067-bcb1-b08d1690b26e",
			"acsTransID":"d7c1ee99-9478-44a6-b1f2-391e29c6b340",
			"acsReferenceNumber":"3DS_LOA_ACS_PPFU_020100_00009",
			"acsOperatorID":"AcsOpId 4138359541",
			"dsReferenceNumber":"DS_LOA_DIS_PPFU_020100_00010",
			"transStatus":"C",
			"acsChallengeMandated":"Y",
			"acsURL":"https://test.com",
			"authenticationType":"01"
			}
		*/
		
		String jsonToAres = null;
			try {
				jsonToAres = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aResMes);
			} catch (JsonProcessingException e) {
				e.getMessage();
			}

	         System.out.println(jsonToAres);
		
		return jsonToAres;
	}

	
	public static void main(String[] args) {
	
		AReqMes aReqMes =JsonToAReq();
        System.out.println(aReqMes.toString());

      
	}
	
	public static AResMes JsonToARes( ) {
		
		AResMes aResMes = new AResMes(); 
		try {
			System.out.print(" AresMes /n" );

			aResMes = mapper.readValue(new File("c:\\BITS\\ACS2.2.2\\AResMes.json"), AResMes.class);

		} catch (IOException e) {
			
			e.getMessage();
		}
		
		return aResMes;
	}
	
	
	
}
