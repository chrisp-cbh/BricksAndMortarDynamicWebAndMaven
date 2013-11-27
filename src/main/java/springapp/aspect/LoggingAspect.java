package springapp.aspect;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Log logger = LogFactory.getLog(getClass());

	public void setLogger(Log logger) {
		this.logger = logger;
	}

	@Before("execution(* springapp.aspect.BookService.addBook(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("aspect before");
		logger.info("hijacked : " + joinPoint.getSignature().getName());
	}

	@After("execution(* springapp.aspect.BookService.addBook(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("aspect after");
		logger.info("hijacked : " + joinPoint.getSignature().getName());
	}

	@AfterReturning(pointcut = "execution(* springapp.aspect.BookService.showBookCount(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("aspect after-returning");
		logger.info("hijacked : " + joinPoint.getSignature().getName());
		logger.info("Method returned value is : " + result);
	}

	@AfterThrowing(pointcut = "execution(* springapp.aspect.BookService.addBadBook(..))", throwing = "error")
	public void afterThrowing(JoinPoint joinPoint, Throwable error) {
		logger.info("aspect after-throwing");
		logger.info("hijacked : " + joinPoint.getSignature().getName());
		logger.info("Exception : " + error);
	}

	/*
	 *  If the method being called is not void, then this method must
	 *  return an Object. Probably the result of joinPoint.proceed()
	 *  If not, a NullPointerException occurs somewhere in the AOP proxy classes!!!
	 */
	@Around("execution(* springapp.aspect.BookService.addBookAround(String)) && args(name)")
	public Object around(ProceedingJoinPoint joinPoint, String name) throws Throwable {
		logger.info("aspect around");
		logger.info("hijacked method : " + joinPoint.getSignature().getName());
		logger.info("hijacked arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.info("argument from args()" + name);
		logger.info("aspect around before");
		Object returnValue = joinPoint.proceed();
		logger.info("aspect around after");
		return returnValue;
	}
}
