package acs.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.impl.Log4JLogger;

import com.fasterxml.jackson.databind.ObjectMapper;

import acs.construct.ConstructMsg;
import acs.dao.DAO;
import acs.message.AReqMes;
import acs.message.AResMes;
import acs.message.CReqMes;
import acs.message.CResMes;
import acs.message.CResMesF;
import acs.message.RReqMes;
import acs.modal.ACSMessage;
import acs.tools.RequestTimeListener;
import acs.tools.SendRReq;

public class ChallengeFlowSDK extends HttpServlet  {
	  
		private static final long serialVersionUID = 3286511472945328526L;
		private static HttpServletResponse httpResponse;
		ObjectMapper mapper = new ObjectMapper();
		private static HttpSession httpSession;
      private RReqMes rReqMes = new RReqMes() ;
      private CReqMes cReqMes = new CReqMes() ;
      private CResMesF cResMesF = new CResMesF() ;
      private CResMes cResMes = new CResMes() ;

      private DAO dao = new DAO();
      private ACSMessage acsmsg = new ACSMessage();
  	public final Log4JLogger logger = new Log4JLogger(this.getClass().getName());

		protected void doPost(HttpServletRequest request,
				HttpServletResponse response ) throws ServletException, IOException {
			
			System.out.println("doPost  " );

			setHttpResponse(response);
			String url = request.getRequestURL().toString();
			System.out.println("url " + url);
			httpSession=request.getSession(true);
			httpSession.setMaxInactiveInterval(10);

			AReqMes areqMes = (AReqMes) httpSession.getAttribute("AReqMes");
			AResMes aResMes = (AResMes) httpSession.getAttribute("AResMes");
			System.out.println("session areqMes " + areqMes);

			String receivedMessage = readRequestBuffer(request.getReader());

			System.out.println("Creq receivedMessage  " + receivedMessage);

	        String CReq = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cReqMes);

	        rReqMes = ConstructMsg.constructRReqMes(aResMes , areqMes ,rReqMes);

	        String RReq =mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rReqMes);
			cReqMes = mapper.readValue(receivedMessage, CReqMes.class); 

			// check time out of creq
			if(aResMes.getTransStatus().equals("C")) {
				
				Long startTime = System.currentTimeMillis();//t1
				logger.info(" startTime " +startTime);
				request.setAttribute( "startTime", startTime );
		        Timer timer = new Timer();
		        
		        Runnable r = new RequestTimeListener( request, response, timer,  RReq );

		        
		        new Thread(r).start();
		         // chain.doFilter( request, response );				
		        timer.cancel();
		        
			}
						
			
			// Json ---> java object 
			else 
			{		
			
			navigateTo("pages/ACSAuth2.xhtml");
						
			SendRReq.sendRReqMes(rReqMes, areqMes.getDsURL());

			cResMes = ConstructMsg.constructCResMes(aResMes , areqMes ,cResMes);
			
			cResMesF = ConstructMsg.constructCResMesF(aResMes , cResMes ,cResMesF);

	        //String CResF = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cResMesF);
	        String CRes = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cResMesF);

			response.setContentType("text/html ; charset = UTF-8 ");
			response.getWriter().write(CRes);
			}
	        
			
	        constructMessage(receivedMessage , CReq);
	        dao.save(acsmsg);
	        System.out.println(" success" +dao.successOperation);				
			
		}
		
		
		
		private void navigateTo(String url) {
			try {
				logger.info(" navigateTo " + url);
				httpResponse.sendRedirect(url);
			} catch (Exception e) {
				e.getMessage();
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



		public static HttpServletResponse getHttpResponse() {
			return httpResponse;
		}



		public static void setHttpResponse(HttpServletResponse httpResponse) {
			ChallengeFlowSDK.httpResponse = httpResponse;
		}
		
		
		@Override
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doGet  " );

			navigateTo("pages/ACSAuth2.xhtml");
			
		        request.getRequestDispatcher("pages/ACSAuth2.xhtml").forward(request, response);
			
			    System.out.println("doGet  <---" );			
		}
		
		public ACSMessage constructMessage(String AreqM , String AresM){			
			this.acsmsg.setId(ThreadLocalRandom.current().nextInt());
			
			this.acsmsg.setAreqMessage(AreqM);
			this.acsmsg.setAresMessage(AresM);
			this.acsmsg.setOperationDate(new Date());			
			return acsmsg;
		}



		public RReqMes getrReqMes() {
			return rReqMes;
		}



		public void setrReqMes(RReqMes rReqMes) {
			this.rReqMes = rReqMes;
		}



		public CReqMes getcReqMes() {
			return cReqMes;
		}



		public void setcReqMes(CReqMes cReqMes) {
			this.cReqMes = cReqMes;
		}



		public ACSMessage getAcsmsg() {
			return acsmsg;
		}



		public void setAcsmsg(ACSMessage acsmsg) {
			this.acsmsg = acsmsg;
		}
		
		
		
}
