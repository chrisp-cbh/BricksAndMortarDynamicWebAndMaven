package springapp.aspect;

import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService {
 
    private int bookCount;

    public void printErrorBook(){
		throw new ArithmeticException("just for testing");
    }

	@Override
	public int getNumberOfBooks() {
		return bookCount;
	}

	@Override
	public void addBook() {
		bookCount = bookCount + 1;
	}

	@Override
	public String showBookCount() {
		return Integer.toString(bookCount);
	}

	@Override
	public void addBadBook() {
		throw new RuntimeException("Bad Book Added");
	}

	@Override
	public boolean addBookAround(String name) {
		return true;
	}
}
