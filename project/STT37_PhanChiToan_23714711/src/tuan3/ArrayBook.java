package tuan3;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;

public class ArrayBook implements Serializable {
	ArrayList<Book> listBook = new ArrayList<Book>();

	public ArrayBook() {
		super();
		// TODO Auto-generated constructor stub
		listBook = new ArrayList<Book>();
	}
	
	public ArrayList<Book> getList() {
		return listBook;
	}
	
	public void addBook(Book newBook) throws Exception{
		for(Book bk : listBook) {
			if(bk.getISBN().equalsIgnoreCase(newBook.getISBN())) {
				throw new Exception("Trùng mã ISBN");
			}
			if(bk.getBookID().equalsIgnoreCase(newBook.getBookID())) {
				throw new Exception("Trùng mã sách");
			}
		}
		listBook.add(newBook);		
	}
	
	public void removeBook(Book bk) {
		listBook.remove(bk);
	}
	
	public Book findBook(String bookid) {
		for(Book bk : listBook) {
			if(bk.getBookID().equalsIgnoreCase(bookid)) {
				return bk;
			}		
		}
		return null;
	}
	
	public int findIndexBook(Book bk) {
		int index = 0;
		if(listBook.contains(bk))
			index = listBook.indexOf(bk);
		return index;
	}
	
	public void updateBook(Book bk) {
		int idxBook = findIndexBook(bk);
		listBook.set(idxBook, bk);
	}
	
	public Book getBook(String bookID) {
		for(Book bk : listBook) {
			if(bk.getBookID().equalsIgnoreCase(bookID)) {
				return bk;
			}
		}
		return null;
	}
}
