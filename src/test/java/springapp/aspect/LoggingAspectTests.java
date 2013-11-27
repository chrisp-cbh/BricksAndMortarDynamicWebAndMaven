package springapp.aspect;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.commons.logging.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from
// "classpath:/springapp/aspect/AllAspectsTests-context.xml"
@ContextConfiguration
public class LoggingAspectTests {

	// @Autowired
	private LoggingAspect loggingAspect;

	private Log mockLogger;
	private JoinPoint mockJoinPoint;
	private Signature mockSignature;

	@Autowired
	BookService bookService;
	private ProceedingJoinPoint mockProceedingJoinPoint;

	@Before
	public void setup() {
		loggingAspect = new LoggingAspect();
		mockJoinPoint = mock(JoinPoint.class);
		mockSignature = mock(Signature.class);
		mockProceedingJoinPoint = mock(ProceedingJoinPoint.class);
		// this may be excessive...
		when(mockSignature.getName()).thenReturn("aMethodName");
		when(mockJoinPoint.getSignature()).thenReturn(mockSignature);
		when(mockProceedingJoinPoint.getSignature()).thenReturn(mockSignature);

		mockLogger = mock(Log.class);
		loggingAspect.setLogger(mockLogger);
	}

	@Test
	public void beforeTellsUsSomething() {
		loggingAspect.before(mockJoinPoint);
		verify(mockLogger).info("aspect before");
	}

	@Test
	public void afterTellsUsSomething() {
		loggingAspect.after(mockJoinPoint);
		verify(mockLogger).info("aspect after");
	}

	@Test
	public void afterReturningTellsUsSomething() {
		loggingAspect.afterReturning(mockJoinPoint, "foo");
		verify(mockLogger).info("aspect after-returning");
	}

	@Test
	public void afterThrowingTellsUsSomething() {
		loggingAspect.afterThrowing(mockJoinPoint, new RuntimeException(
				"any exception"));
		verify(mockLogger).info("aspect after-throwing");
	}

	@Test
	public void aroundTellsUsSomething() throws Throwable {
		when(mockProceedingJoinPoint.getArgs()).thenReturn(
				new String[] { "foo", "bar" });

		loggingAspect.around(mockProceedingJoinPoint, "foo");
	}

	// The following test are really exploratory to exercise the AOP points
	// they could be improved to test that the logger in the LoggerAspect is
	// populating correct messages, but that would make some assumptions about
	// the instance of LoggingAspect that the Spring context is providing!!
	// More to learn here!

	@Test
	public void doAddBookCallsAspect() {
		bookService.addBook();
	}

	@Test
	public void doShowBookCountCallsAspect() {
		bookService.showBookCount();
	}

	@Test
	public void doAddBookAroundCallsAspect() {
		assertThat(bookService.addBookAround("With argument"), is(true));
	}

	@Test(expected = RuntimeException.class)
	public void checkAddBadBookThrows() {
		bookService.addBadBook();
	}
}
