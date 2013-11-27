package springapp.aspect;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AspectTraceLogger {

	private Log logger = LogFactory.getLog(getClass());

	public void setLogger(Log logger) {
		this.logger = logger;
	}

	@Before("execution(* *(*))")
	public void beforeEntry(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("enter -> " + methodName + "( " + args + " )");
	}

//	@After("execution(* springapp.aspect.BookService.addBook(..))")
//	public void after(JoinPoint joinPoint) {
//		logger.info("aspect after");
//		logger.info("hijacked : " + joinPoint.getSignature().getName());
//	}
//
//	@AfterReturning(pointcut = "execution(* springapp.aspect.BookService.showBookCount(..))", returning = "result")
//	public void afterReturning(JoinPoint joinPoint, Object result) {
//		logger.info("aspect after-returning");
//		logger.info("hijacked : " + joinPoint.getSignature().getName());
//		logger.info("Method returned value is : " + result);
//	}
//
//	@AfterThrowing(pointcut = "execution(* springapp.aspect.BookService.addBadBook(..))", throwing = "error")
//	public void afterThrowing(JoinPoint joinPoint, Throwable error) {
//		logger.info("aspect after-throwing");
//		logger.info("hijacked : " + joinPoint.getSignature().getName());
//		logger.info("Exception : " + error);
//	}
}
