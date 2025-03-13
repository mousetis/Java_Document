package tuan3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class view extends JFrame implements ActionListener,MouseListener {
	public ArrayBook list = new ArrayBook();
	private JTextField txtBookID;
	private JTextField txtBookName;
	private JTextField txtAuthor;
	private JTextField txtYearOfPublication;
	private JTextField txtProducer;
	private JTextField txtPages;
	private JTextField txtUnitPrice;
	private JTextField txtBookISBN;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnEmptyDelete;
	private JButton btnUpdate;
	private JButton btnSave;
	private JComboBox cbbFind;
	private DefaultTableModel mdlTable;
	private JTable tblTable;
	private TableRowSorter<TableModel> tbrsorter;
	private Boolean isCheck = true;
	private String filename = "bookData.txt";
	private ArrayBook li;
	//int rowSelected;
	private static final long serialVersionUID = 1L;
	
	public view() {
		super("Quản Lý Sách");
		
//===================================Khai báo Panel chính============================================================		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));
		pnlNorth.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Records Editor",TitledBorder.LEFT,TitledBorder.TOP),new EmptyBorder(20,20,20,20)));
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.X_AXIS));
		JPanel pnlSouth = new JPanel();
		Dimension lblSize = new Dimension(110,25);
		
//======================================North=========================================================
		
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
		pnl3.add(Box.createHorizontalStrut(13));
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
		
//======================================Center=========================================================
		btnAdd = new JButton("Thêm");
		btnDelete = new JButton("Xoá");
		btnEmptyDelete = new JButton("Xoá Rỗng");
		btnUpdate = new JButton("Sửa");
		btnSave = new JButton("Lưu");
		JLabel lblFind = new JLabel("Tìm theo mã sách:");
		cbbFind = new JComboBox<>();
		cbbFind.addItem("");
		cbbFind.setMaximumSize(new Dimension(130,25));
		pnlCenter.add(Box.createHorizontalStrut(150));
		pnlCenter.add(btnAdd);
		pnlCenter.add(Box.createHorizontalStrut(10));
		pnlCenter.add(btnEmptyDelete);
		pnlCenter.add(Box.createHorizontalStrut(10));
		pnlCenter.add(btnDelete);
		pnlCenter.add(Box.createHorizontalStrut(10));
		pnlCenter.add(btnUpdate);
		pnlCenter.add(Box.createHorizontalStrut(10));
		pnlCenter.add(btnSave);
		pnlCenter.add(Box.createHorizontalStrut(50));
		pnlCenter.add(lblFind);
		pnlCenter.add(Box.createHorizontalStrut(10));
		pnlCenter.add(cbbFind);
		pnlCenter.add(Box.createHorizontalStrut(80));

		
//======================================South=========================================================		
		pnlSouth.setPreferredSize(new Dimension(1,420));
		pnlSouth.setLayout(null);
		pnlSouth.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Danh Sách Các Cuốn Sách",TitledBorder.LEFT,TitledBorder.TOP),new EmptyBorder(20,20,20,20)));
		String[] title = {"Mã Sách","Tựa Sách","Tác Giả","Năm Xuất Bản","Nhà Xuất Bản","Số Trang","Đơn Giá","ISBN"};
		mdlTable = new DefaultTableModel(title,0);
		tblTable = new JTable(mdlTable);
		tblTable.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
		tbrsorter = new TableRowSorter<TableModel>(mdlTable);
		tblTable.setAutoCreateRowSorter(true);
		tblTable.setRowSorter(tbrsorter);
		tblTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JScrollPane scrTable = new JScrollPane(tblTable);
		scrTable.setBounds(new Rectangle(8, 15, 970, 700));
		
		pnlSouth.add(scrTable);
		
//======================================Add Panel=========================================================		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter,BorderLayout.CENTER);
		add(pnlSouth,BorderLayout.SOUTH);
		
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.loadData();
		this.setVisible(true);
		
		btnAdd.addActionListener(this);
		btnEmptyDelete.addActionListener(this);
		btnDelete.addActionListener(this);
		cbbFind.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnSave.addActionListener(this);
		tblTable.addMouseListener(this);
		
		
		addEnterKeyListener(txtBookID, txtBookName);
		addEnterKeyListener(txtBookName, txtAuthor);
		addEnterKeyListener(txtAuthor, txtYearOfPublication);
		addEnterKeyListener(txtYearOfPublication, txtProducer);
		addEnterKeyListener(txtProducer, txtPages);
		addEnterKeyListener(txtPages, txtUnitPrice);
		addEnterKeyListener(txtUnitPrice, txtBookISBN);
	}
//======================================Function=========================================================	
	public void loadData() {
		BufferedReader br = null;
		li = new ArrayBook();
		try {
			if(new File(filename ).exists()) {
				br = new BufferedReader(new FileReader(filename));
				br.readLine();
				
				while (br.ready()) {
					String line = br.readLine();
					if(line != null && !line.trim().equals("")) {
						String[] str = line.split(";");
						Book bk = new Book(str[0],str[1],str[2],Integer.parseInt(str[3]),str[4],Integer.parseInt(str[5]),Double.parseDouble(str[6]),str[7]);
						li.addBook(bk);
						mdlTable.addRow(str);
					}
				}
			}
			br.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy file!","Lỗi",JOptionPane.ERROR_MESSAGE);
		}
	}
//=======================================================================================
	public void saveData(ArrayList<Book> listB) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(filename));
			bw.write("MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN");
			for(Book bk : listB) {
				bw.write(bk.toString()+"\n");
			}
			bw.close();
			JOptionPane.showMessageDialog(this, "Lưu thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Không thể lưu!","Lỗi",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void deleteData() {
		txtBookID.setText("");
		txtBookName.setText("");
		txtAuthor.setText("");
		txtYearOfPublication.setText("");	 
		txtProducer.setText("");
		txtPages.setText("");
		txtUnitPrice.setText("");
		txtBookISBN.setText("");
	}
	
//==============================================================================================
	
	public void addBookTable() {
		if(this.txtBookID.getText().equalsIgnoreCase("") || txtBookID.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Mã sách không được để trống!","Lỗi",JOptionPane.ERROR_MESSAGE);
			return;
		}
		else {
			if(!txtYearOfPublication.getText().matches("\\d+")) {
				JOptionPane.showMessageDialog(this, "Sai định dạng dữ liệu của năm xuất bản vui lòng nhập số","Lỗi",JOptionPane.ERROR_MESSAGE);
			} else
			if(!txtPages.getText().matches("\\d+")) {
				JOptionPane.showMessageDialog(this, "sai định dạng dữ liệu của số trang vui lòng nhập số","Lỗi",JOptionPane.ERROR_MESSAGE);
			} else
			if(!txtUnitPrice.getText().matches("\\d*\\.\\d+")) {
				JOptionPane.showMessageDialog(this,"Sai định dạng dữ liệu của đơn giá vui lòng nhập đúng đơn giá với dấu '.' ","Lỗi",JOptionPane.ERROR_MESSAGE);
			} else
			{
				try {
					String id = this.txtBookID.getText();
					String bkName = this.txtBookName.getText();
					String autName = this.txtAuthor.getText();
					Integer year = Integer.valueOf(this.txtYearOfPublication.getText());
					String prName = this.txtProducer.getText();
					Integer page = Integer.valueOf(this.txtPages.getText());
					Double uniPrice = Double.valueOf(this.txtUnitPrice.getText());
					String isbn = this.txtBookISBN.getText();
					
					Book newBook = new Book();
					newBook.setBookID(id);
					newBook.setBookName(bkName);
				    newBook.setAuthor(autName);
				    newBook.setYearOfPublication(year);
				    newBook.setProducer(prName);
				    newBook.setPages(page);
				    newBook.setUnitPrice(uniPrice);
				    newBook.setISBN(isbn);
				    
				    this.list.addBook(newBook);
					this.mdlTable.addRow(new Object[] {id, bkName, autName, year, prName,page, uniPrice, isbn});
					cbbFind.addItem(id);
					this.tblTable.clearSelection();
					deleteData();
					txtBookID.requestFocus();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, e.getMessage(),"Lỗi!",JOptionPane.ERROR_MESSAGE);	
			} 
			}
			
		}
	}
	
//==============================================================================================
	
	public void deleteBook() {
		int rowSelected = tblTable.convertRowIndexToModel(tblTable.getSelectedRow());
		String bkID = txtBookID.getText();
		Book bkDelete = this.list.findBook(bkID);
		this.list.removeBook(bkDelete);
		this.mdlTable.removeRow(rowSelected);
		this.tblTable.clearSelection();
		this.cbbFind.removeItem(bkID);
		this.deleteData();
	}
//==============================================================================================
	
	public void findBook() {
		String comboBoxSelected = cbbFind.getSelectedItem().toString();
		if(!comboBoxSelected.equalsIgnoreCase("")) {
			tbrsorter.setRowFilter(RowFilter.regexFilter(comboBoxSelected, 0));
		}else {
			tbrsorter.setRowFilter(null);
		}
	}
//==============================================================================================
	
	public void updateBook() {
		int rowSelected = tblTable.getSelectedRow();
		int modelRow = tblTable.convertRowIndexToModel(rowSelected);
		if(isCheck) {
			if(rowSelected  == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa!","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				txtBookID.selectAll();
				txtBookID.requestFocus();
				btnUpdate.setText("Xong");
			}
			isCheck = false;
		} else {
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn có xác nhận thay đổi thông tin của cuốn sách này?","Xác nhận",JOptionPane.YES_NO_OPTION);
			if(confirm == JOptionPane.YES_OPTION) {
				mdlTable.setValueAt(txtBookID.getText(), modelRow, 0);
				mdlTable.setValueAt(txtBookName.getText(), modelRow, 1);
				mdlTable.setValueAt(txtAuthor.getText(), modelRow, 2);
				mdlTable.setValueAt(txtYearOfPublication.getText(), modelRow, 3);
				mdlTable.setValueAt(txtProducer.getText(), modelRow, 4);
				mdlTable.setValueAt(txtPages.getText(), modelRow, 5);
				mdlTable.setValueAt(txtUnitPrice.getText(), modelRow, 6);
				mdlTable.setValueAt(txtBookISBN.getText(), modelRow, 7);
				btnUpdate.setText("Sửa");
			}
			isCheck = true;
		}
		cbbFind.removeItemAt(modelRow);
		cbbFind.insertItemAt(txtBookID.getText(), modelRow);
	}
	
//==============================================================================================
	
	public void getDataBook() {
		int rowSelected = tblTable.convertRowIndexToModel(tblTable.getSelectedRow());
		this.txtBookID.setText(this.mdlTable.getValueAt(rowSelected, 0).toString());
		this.txtBookName.setText(this.mdlTable.getValueAt(rowSelected, 1).toString());
		this.txtAuthor.setText(this.mdlTable.getValueAt(rowSelected, 2).toString());
		this.txtYearOfPublication.setText(this.mdlTable.getValueAt(rowSelected, 3).toString());
		this.txtProducer.setText(this.mdlTable.getValueAt(rowSelected, 4).toString());
		this.txtPages.setText(this.mdlTable.getValueAt(rowSelected, 5).toString());
		this.txtUnitPrice.setText(this.mdlTable.getValueAt(rowSelected, 6).toString());
		this.txtBookISBN.setText(this.mdlTable.getValueAt(rowSelected, 7).toString());
		
	}
	
//==============================================================================================
	public static void main(String[] args) {
	
		new view();
	}
	
//==============================================================================================
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o =e.getSource();
		
		if(o == btnAdd) {
			addBookTable();
		} else
		if(o == btnEmptyDelete) {
			deleteData();
		} else
		if(o == btnDelete) {
			int rowSelected = tblTable.getSelectedRow();
			if(rowSelected == -1) {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn dòng cần xóa!","Lỗi",JOptionPane.ERROR_MESSAGE);
			} else {
				int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dữ liệu cuốn sách này?","Xác nhận xóa",JOptionPane.YES_NO_OPTION);
					if(check == JOptionPane.YES_OPTION)
					deleteBook();
			}
			
		} else
		if(o == cbbFind) {
			findBook();
		} else 
		if(o == btnUpdate){
			updateBook();
		} else 
		if(o == btnSave) {
			saveData(list.getList());
		}
	}
//==============================================================================================	
	private void addEnterKeyListener(JTextField currentField, JTextField nextField) {
		currentField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nextField.requestFocus();
				
			}
		});
	}
//==============================================================================================	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.getDataBook();
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
