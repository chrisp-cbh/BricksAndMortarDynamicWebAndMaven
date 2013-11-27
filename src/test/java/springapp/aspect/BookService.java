package springapp.aspect;

public interface BookService {
	public void printErrorBook();

	public int getNumberOfBooks();

	public void addBook();

	public String showBookCount();

	public void addBadBook();

	public boolean addBookAround(String name);
}
