package springapp.aspect;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BookServiceImplTest {
	
	private BookService bookService;
	
	@Before
	public void setup(){
		bookService = new BookServiceImpl();
	}
	
	@Test(expected=ArithmeticException.class)
	public void printErrorBookThrowsException(){
		bookService.printErrorBook();
	}

	@Test
	public void bookServiceHasNoBooksWhenNew(){
		assertThat(bookService.getNumberOfBooks(), is(equalTo(0)));
	}
	
	@Test
	public void addBookIncrementsBookCountByOne(){
		int originalNumberOfBooks = bookService.getNumberOfBooks();
		bookService.addBook();
		assertThat(bookService.getNumberOfBooks(), is(equalTo(originalNumberOfBooks+1)));
	}
	
	@Test
	public void showBookCountWithReturnValueReturnsStringTotalOfBooks(){
		bookService.addBook();
		assertThat(bookService.showBookCount(), is(equalTo("1")));
	}
	
	@Test(expected=RuntimeException.class)
	public void addBadBookThrowsException(){
		bookService.addBadBook();
	}

	@Test
	public void addBookArroundRunsWithoutException(){
		assertThat(bookService.addBookAround("a book"), is(true));
	}
}
