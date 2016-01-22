package projectrcp.model;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.databinding.observable.list.WritableList;

import projectrcp.restClient.RestClient;

public enum ModelProvider {
	INSTANCE;
	
	private RestClient restClient = new RestClient();
	
	private WritableList writableList = new WritableList(new ArrayList<>(), BookTo.class);
	
	public void setBooks(String title) {
		this.writableList.clear();
		Collection<BookTo> books = restClient.search(title);
		this.writableList.addAll(books);
	}
	
	public void addBook(BookTo book, String title) {
		restClient.add(book);
		setBooks(title);
	}
	public void deleteBook(Long id, String title) {
		restClient.delete(id);
		setBooks(title);
	}
	
	public void updateBook(BookTo book) {
		restClient.update(book);
		
	}
	
	public WritableList getBooks() {
		return writableList;
	}
	

}
