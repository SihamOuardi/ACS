package acs.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.impl.Log4JLogger;

import com.fasterxml.jackson.databind.ObjectMapper;

import acs.message.ThreeDSMethodData;


public class ThreeDSmethod extends HttpServlet  {

	private static final long serialVersionUID = 1L;
	private String	threeDSMethod,threeDSMethodData ;
	private static HttpServletResponse httpResponse;

	ObjectMapper mapper = new ObjectMapper();
    ThreeDSMethodData var3DSdata =  new ThreeDSMethodData();
	public final Log4JLogger logger = new Log4JLogger(this.getClass().getName());

    @Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost  " );
		
		setHttpResponse(response);
		
		String url = request.getRequestURL().toString();
		System.out.println("url " + url);
		threeDSMethod = request.getParameter("threeDSMethodData");		

		System.out.println("threeDSMethod  " + threeDSMethod);
		
        byte[] data = Base64.getDecoder().decode(threeDSMethod) ;
        
		System.out.println("data " + data);
		
		threeDSMethodData=new String(data, "UTF-8");
		
		System.out.println("threeDSMethodData= " + new String(data, "UTF-8"));
		
		var3DSdata = mapper.readValue(threeDSMethodData, ThreeDSMethodData.class);        

		System.out.println("notification url " + var3DSdata.getThreeDSMethodNotificationURL());
		System.out.println(" TransID " + var3DSdata.getThreeDSServerTransID());
			
		
		String json = "{\"threeDSServerTransID\":\"" + var3DSdata.getThreeDSServerTransID() + "\"}";
		String EncodedTransID = Base64.getEncoder().encodeToString(json.getBytes("utf-8"));
	
		String html = null ;
		html = "<html xmlns=\"http://www.w3.org/1999/xhtml\">";
		html += "<head>";
		html += "<script language=\"javascript\">	function onLoadHandler() {	document.threeDSServerTransID.submit();	}	</script>";
		html += "</head>";
		html += "<body>";
		html += "<form name=\"threeDSServerTransID\" action=\""+var3DSdata.getThreeDSMethodNotificationURL()+"\" method=\"POST\">";
		html += "			<input type=\"hidden\" name=\"threeDSServerTransID\" value=\""+EncodedTransID+ "\" />";
		
		html += "			<input type=\"submit\" name=\"ok\" value=\"Go Authen\" />";
		html += "</form></body></html>";

		
		System.out.println("html " + html);
		httpResponse.setContentType("text/html");
		response.getWriter().write(html);
		
 	 }
 
 
	
	 @SuppressWarnings("unused")
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
		System.out.println("doGet  " );
		
	}

	public String getThreeDSMethodData() {
		return threeDSMethodData;
	}
	
	public void setThreeDSMethodData(String threeDSMethodData) {
		this.threeDSMethodData = threeDSMethodData;
	}



	public String getThreeDSMethod() {
		return threeDSMethod;
	}



	public void setThreeDSMethod(String threeDSMethod) {
		this.threeDSMethod = threeDSMethod;
	}



	public static HttpServletResponse getHttpResponse() {
		return httpResponse;
	}



	public static void setHttpResponse(HttpServletResponse httpResponse) {
		ThreeDSmethod.httpResponse = httpResponse;
	}



	public ThreeDSMethodData getVar3DSdata() {
		return var3DSdata;
	}



	public void setVar3DSdata(ThreeDSMethodData var3dSdata) {
		var3DSdata = var3dSdata;
	}
	
	
	 
}
