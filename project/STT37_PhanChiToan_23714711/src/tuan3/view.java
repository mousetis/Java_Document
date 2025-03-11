package tuan3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class view extends JFrame {
	public ArrayBook list = new ArrayBook();
	private JTextField txtBookID;
	private JTextField txtBookName;
	private JTextField txtAuthor;
	private JTextField txtYearOfPublication;
	private JTextField txtProducer;
	private JTextField txtPages;
	private JTextField txtUnitPrice;
	private JTextField txtBookISBN; 
	private static final long serialVersionUID = 1L;
	
	public view() {
		super("Quản Lý Sách");
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));
		pnlNorth.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Records Editor",TitledBorder.LEFT,TitledBorder.TOP),new EmptyBorder(20,20,20,20)));
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.X_AXIS));
		JPanel pnlSouth = new JPanel();
		Dimension lblSize = new Dimension(110,25);
		
		JPanel pnl1 = new JPanel();
		pnl1.setLayout(new BoxLayout(pnl1, BoxLayout.X_AXIS));
		JLabel lblBookID = new JLabel("Mã Sách:");
		pnl1.add(Box.createHorizontalStrut(20));
		txtBookID = new JTextField();
		pnl1.add(lblBookID);
		pnl1.add(Box.createHorizontalStrut(40));
		pnl1.add(txtBookID);
		pnl1.add(Box.createHorizontalStrut(600));
		
		JPanel pnl2 = new JPanel();
		pnl2.setLayout(new BoxLayout(pnl2, BoxLayout.X_AXIS));
		JLabel lblBookName = new JLabel("Tựa Sách:");
		pnl2.add(Box.createHorizontalStrut(20));
		txtBookName = new JTextField();
		JLabel lblAuthor = new JLabel("Tác giả:");
		txtAuthor = new JTextField();
		pnl2.add(lblBookName);
		pnl2.add(Box.createHorizontalStrut(34));
		pnl2.add(txtBookName);
		pnl2.add(Box.createHorizontalStrut(20));
		pnl2.add(lblAuthor);
		pnl2.add(Box.createHorizontalStrut(40));
		pnl2.add(txtAuthor);
		pnl2.add(Box.createHorizontalStrut(20));
		
		JPanel pnl3 = new JPanel();
		pnl3.setLayout(new BoxLayout(pnl3, BoxLayout.X_AXIS));
		JLabel lblYearOfPublication = new JLabel("Năm xuất bản:");
		pnl3.add(Box.createHorizontalStrut(20));
		txtYearOfPublication = new JTextField();
		JLabel lblProducer = new JLabel("Nhà xuất bản:");
		txtProducer = new JTextField();
		pnl3.add(lblYearOfPublication);
		pnl3.add(Box.createHorizontalStrut(11));
		pnl3.add(txtYearOfPublication);
		pnl3.add(Box.createHorizontalStrut(20));
		pnl3.add(lblProducer);
		pnl3.add(Box.createHorizontalStrut(10));
		pnl3.add(txtProducer);
		pnl3.add(Box.createHorizontalStrut(20));
		
		JPanel pnl4 = new JPanel();
		pnl4.setLayout(new BoxLayout(pnl4, BoxLayout.X_AXIS));
		JLabel lbPages = new JLabel("Số trang:");
		pnl4.add(Box.createHorizontalStrut(20));
		txtPages = new JTextField();
		JLabel lblUnitPrice = new JLabel("Đơn giá:");
		txtUnitPrice = new JTextField();
		pnl4.add(lbPages);
		pnl4.add(Box.createHorizontalStrut(40));
		pnl4.add(txtPages);
		pnl4.add(Box.createHorizontalStrut(20));
		pnl4.add(lblUnitPrice);
		pnl4.add(Box.createHorizontalStrut(40));
		pnl4.add(txtUnitPrice);
		pnl4.add(Box.createHorizontalStrut(20));
		
		JPanel pnl5 = new JPanel();
		pnl5.setLayout(new BoxLayout(pnl5, BoxLayout.X_AXIS));
		JLabel lblISBN = new JLabel("International Standard Book Number:");
		pnl5.add(Box.createHorizontalStrut(20));
		txtBookISBN = new JTextField();
		pnl5.add(lblISBN);
		pnl5.add(Box.createHorizontalStrut(20));
		pnl5.add(txtBookISBN);
		pnl5.add(Box.createHorizontalStrut(475));
		
		pnlNorth.add(pnl1);
		pnlNorth.add(Box.createVerticalStrut(7));
		pnlNorth.add(pnl2);
		pnlNorth.add(Box.createVerticalStrut(7));
		pnlNorth.add(pnl3);
		pnlNorth.add(Box.createVerticalStrut(7));
		pnlNorth.add(pnl4);
		pnlNorth.add(Box.createVerticalStrut(7));
		pnlNorth.add(pnl5);
		add(pnlNorth, BorderLayout.NORTH);
		
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new view();
	}


}
