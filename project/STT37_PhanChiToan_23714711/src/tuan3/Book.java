package tuan3;

import java.io.Serializable;
import java.sql.Date;
import java.time.Year;
import java.util.Objects;
import java.util.regex.Pattern;

import javax.naming.AuthenticationException;

public class Book{
	private String bookID;
	private String bookName;
	private String author;
	private Integer yearOfPublication;
	private String producer;
	private Integer pages;
	private Double unitPrice;
	private String ISBN;
	
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) throws Exception{
		String regexID = "^[A-Z]\\d{3}$";
		if(bookID == null || !(Pattern.matches(regexID, bookID))) {
			throw new Exception("Định dạng mã sách sai. Mã sách gồm 4 ký tự bắt đầu bằng chữ cái in hoa và 3 ký tự số theo sau!");
		}
		
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) throws Exception {
		String regexName = "[a-zA-Z\\d\\s\\-()]+";
		if(bookName.trim().isEmpty()) {
			throw new Exception("Tựa sách không được để trống!");
		}
		else if(!(Pattern.matches(regexName, bookName))) {
			throw new Exception("Định dạng tựa sách sai. Tựa sách không được chứa ký tự đặc biệt nào khác ngoài \"- và ()");
		}
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) throws Exception{
		String regexAuthor = "[a-zA-Z\\s']+";
		if(author.trim().isEmpty()) {
			throw new Exception("Tên tác giả không được để trống!");
		}
		else if(!(Pattern.matches(regexAuthor, author))) {
			throw new Exception("Định dạng tên tác giả sai.Không chứa chữ số và ký tự đặc biệt ngoại trừ \"'");
		}
		this.author = author;
	}
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(Integer yearOfPublication) throws Exception{
		int currentYear = Year.now().getValue();
		if(yearOfPublication == null) {
			throw new Exception("Năm xuất bản không được để trống");
		}
		else if(yearOfPublication < 1900 || yearOfPublication > currentYear ) {
			throw new Exception("Năm xuất bản phải nằm trong khoảng từ 1900 đến nay!");
		}
		this.yearOfPublication = yearOfPublication;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) throws Exception{
		if(producer.trim().isEmpty()) {
			throw new Exception("Nhà xuất bản không được để trống");
		}
		this.producer = producer;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(Integer pages) throws Exception {
		if(pages == null) {
			throw new Exception("Số trang không được để trống");
		}else if(pages < 0) {
			throw new Exception("Số trang không được nhỏ hơn 0!");
		}
		this.pages = pages;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) throws Exception{
		if(unitPrice == null) {
			throw new Exception("Đơn giá không được để trống");
		}else if(unitPrice < 0) {
			throw new Exception("Đơn giá không được nhỏ hơn 0!");
		}
		this.unitPrice = unitPrice;
	}
	
	public String getISBN(){
		return ISBN;
	}
	public void setISBN(String ISBN) throws Exception {
		String regexISBN = "(\\d+-){3,4}\\d+";
		if(ISBN.trim().isEmpty()) {
			throw new Exception("Mã ISBN không được để trống!");
		}
		else if(!(Pattern.matches(regexISBN, ISBN))) {
			throw new Exception("Vui lòng nhập đúng định dạng ISBN!");
		}
		this.ISBN = ISBN;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookID, String bookName, String author, Integer yearOfPublication, String producer, Integer pages,
			Double unitPrice, String iSBN) {
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
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(bookID, other.bookID);
	}
	@Override
	public String toString() {
		return bookID+";"+bookName+";"+author+";"+yearOfPublication+";"+producer+";"+pages+";"+unitPrice+";"+ISBN;
	}
	
	
	
}
