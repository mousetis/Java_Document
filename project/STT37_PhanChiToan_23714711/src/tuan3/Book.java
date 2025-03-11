package tuan3;

import java.io.Serializable;
import java.sql.Date;
import java.time.Year;
import java.util.Objects;
import java.util.regex.Pattern;

public class Book implements Serializable {
	private String bookID;
	private String bookName;
	private String author;
	private int yearOfPublication;
	private String producer;
	private int pages;
	private double unitPrice;
	private int ISBN;
	
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) throws Exception{
		String regexID = "[A-Z]\\d{3}";
		if(bookID.trim().isEmpty()) {
			throw new Exception("Mã sách không được để trống");
		}
		if(!Pattern.matches(regexID, bookID)) {
			throw new Exception("Định dạng mã sách sai. Mã sách gồm 4 ký tự bắt đầu bằng chữ cái in hoa và 3 ký tự số theo sau!");
		}
		
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) throws Exception {
		String regexName = "[\\p{L}\\d\\s\\-()]+";
		if(bookName.trim().isEmpty()) {
			throw new Exception("Tựa sách không được để trống");
		}
		if(!Pattern.matches(regexName, bookName)) {
			throw new Exception("Định dạng tựa sách sai. Tựa sách không được chứa ký tự đặc biệt nào khác ngoài \"- và ()");
		}
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) throws Exception{
		String regexAuthor = "[a-zA-Z']";
		if(author.trim().isEmpty()) {
			throw new Exception("Tên tác giả không được để trống");
		}
		if(Pattern.matches(regexAuthor, author)) {
			throw new Exception("Định dạng tên tác giả sai.Không chứa chữ số và ký tự đặc biệt ngoại trừ \"'");
		}
		this.author = author;
	}
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(int yearOfPublication) throws Exception{
		int currentYear = Year.now().getValue();
		if(yearOfPublication < 1900 || yearOfPublication > currentYear ) {
			throw new Exception("Năm xuất bản phải nằm trong khoảng từ 1900 đến nay!");
		}
		this.yearOfPublication = yearOfPublication;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) throws Exception{
		if(unitPrice < 0) {
			throw new Exception("Đơn giá không được nhỏ hơn 0");
		}
		this.unitPrice = unitPrice;
	}
	
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		this.ISBN = iSBN;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookID, String bookName, String author, int yearOfPublication, String producer, int pages,
			double unitPrice, int iSBN) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.author = author;
		this.yearOfPublication = yearOfPublication;
		this.producer = producer;
		this.pages = pages;
		this.unitPrice = unitPrice;
		this.ISBN = iSBN;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ISBN, bookID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return ISBN == other.ISBN && Objects.equals(bookID, other.bookID);
	}
	
}
