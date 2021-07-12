package com.infy.infyallocation.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.infy.infyallocation.exception.ManagerException;




@Component
@Aspect
public class LoggingAspect
{

    private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

    @AfterThrowing(pointcut="execution(* com.infy.infyallocation.service.*Impl.*(..))",throwing = "exception")
    public void logServiceException(ManagerException exception)
    {
	// code
    	LOGGER.error(exception.getMessage(),exception);
    }

}
