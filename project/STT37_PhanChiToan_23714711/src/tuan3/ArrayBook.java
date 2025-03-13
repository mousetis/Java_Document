package tuan3;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;

public class ArrayBook {
	ArrayList<Book> listBook = new ArrayList<Book>();

	public ArrayBook() {
		super();
		// TODO Auto-generated constructor stub
		listBook = new ArrayList<Book>();
	}
	
	public ArrayList<Book> getList() {
		return listBook;
	}
	
	public void setList(ArrayList<Book> list) {
		this.listBook = list;
	}
	
	public void addBook(Book newBook) throws Exception{
		for(Book bk : listBook) {
			if(bk.getISBN().equals(newBook.getISBN()))
				throw new Exception("Trùng mã ISBN");
				return;
		}
		
		for(Book bk : listBook) {
			if(bk.getBookID().equalsIgnoreCase(newBook.getBookID())) {
				listBook.add(newBook);
			} else {
				throw new Exception("Mã sách bị trùng!");
			}
		}
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
