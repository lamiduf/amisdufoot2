package gdes.amisdufoot;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogHttpRequestInterceptor extends HandlerInterceptorAdapter {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	
	public static final Logger LOG = LoggerFactory
			.getLogger(LogHttpRequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
    	LOG.trace("--------------- IN -----------------------");
    	showCommonTraces(request);
    	LOG.trace("--------------- IN -----------------------");
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    	LOG.trace("--------------- OUT -----------------------");
    	showCommonTraces(request);
    	LOG.trace("--------------- OUT -----------------------");
    }
    
    private void showCommonTraces(HttpServletRequest request) {
    	LOG.trace("date :" + sdf.format(Calendar.getInstance().getTime()));
        LOG.trace(request.getMethod() + " " + request.getRequestURL().toString());
        for (String parameterName : request.getParameterMap().keySet()) {
        	LOG.trace("param [" + parameterName+"] :"+Arrays.asList(request.getParameterMap().get(parameterName)));
        }
    }
}
