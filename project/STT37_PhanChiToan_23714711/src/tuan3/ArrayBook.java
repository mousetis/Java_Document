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
	
	public void setList(ArrayList<Book> list) {
		this.listBook = list;
	}
	
	public void addBook(Book newBook) throws Exception{
		if(!listBook.contains(newBook)) {
			listBook.add(newBook);
		} else {
			throw new Exception("Mã sách bị trùng!");
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
	
	
}
