package acs.tools;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.impl.Log4JLogger;


public class RequestTimeListener extends TimerTask
{
	public final Log4JLogger logger = new Log4JLogger(this.getClass().getName());

    HttpServletResponse response;
    HttpServletRequest request;
    Timer timer;
    String creq;
    public RequestTimeListener( HttpServletRequest request, HttpServletResponse response, Timer timer ,String cReq )
    {
        this.response = response;
        this.request = request;
        this.timer = timer;
        this.creq = cReq;
    }
  
    @Override
    public void run()
    {
        try
        {
			logger.info( "In Run" );
			
            Long startTime = (Long)request.getAttribute( "startTime" );
            Long endTime = System.currentTimeMillis()*60;
			logger.info( "endTime " + endTime + " startTime "+ startTime );

            if ( endTime - startTime > 1000 )
            {
            	logger.info( "Diff...=" + ( endTime - startTime ) );
                 response.setContentType("text/html ; charset = UTF-8 ");
    			 response.getWriter().write(creq);               
    			Thread.currentThread().run();
            }
        }
        catch ( Exception e ){}
    }
}