package Tuan2;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.View;

import org.w3c.dom.events.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.RowFilter;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.ModuleLayer.Controller;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class view extends JFrame implements ActionListener, MouseListener{
	public ArrayNhanVien ds = new ArrayNhanVien();
	private static final long serialVersionUID = 1L;
	public JTextField txtMaNV;
	public JTextField txtHo;
	public JTextField txtTen;
	public JTextField txtTuoi;
	public JTextField txtLuong;
	public JTextField txtTimKiem;
	public ButtonGroup grButton;
	public DefaultTableModel mdlTable;
	public JTable table;
	public JRadioButton btnNam;
	public JRadioButton btnNu;
	public TableRowSorter<TableModel> sorter;
	public JFileChooser fc;
	private JButton btnTimKiem;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnLuu;
	private boolean isSearch = true;
	ghiDocFile fi;
	private static final String fileName = "data//dsNhanVien";
//===================================================================================================================================

	public view() {
		super("Quản Lý Nhân Viên ");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lb_tieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");
		lb_tieuDe.setForeground(new Color(0, 0, 255));
		lb_tieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lb_tieuDe);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lb_maNV = new JLabel("Mã nhân viên:");
		lb_maNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_maNV.setBounds(10, 8, 82, 28);
		panel_1.add(lb_maNV);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(96, 10, 680, 28);
		txtMaNV.requestFocusInWindow();
		panel_1.add(txtMaNV);
		txtMaNV.setColumns(10);

		JLabel lb_ho = new JLabel("Họ:");
		lb_ho.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_ho.setBounds(10, 46, 82, 28);
		panel_1.add(lb_ho);

		txtHo = new JTextField();
		txtHo.setColumns(10);
		txtHo.setBounds(96, 48, 261, 28);
		panel_1.add(txtHo);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(460, 48, 316, 30);
		panel_1.add(txtTen);

		JLabel lb_tenNV = new JLabel("Tên nhân viên:");
		lb_tenNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_tenNV.setBounds(371, 48, 91, 28);
		panel_1.add(lb_tenNV);

		JLabel lb_tuoi = new JLabel("Tuổi:");
		lb_tuoi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_tuoi.setBounds(10, 84, 82, 28);
		panel_1.add(lb_tuoi);

		txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(96, 86, 505, 28);
		panel_1.add(txtTuoi);

		JLabel lb_phai = new JLabel("Phái:");
		lb_phai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_phai.setBounds(611, 88, 38, 28);
		panel_1.add(lb_phai);

		btnNam = new JRadioButton("Nam");
		btnNam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNam.setBounds(642, 92, 53, 21);
		panel_1.add(btnNam);

		btnNu = new JRadioButton("Nữ");
		btnNu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNu.setBounds(712, 92, 53, 21);
		panel_1.add(btnNu);

		grButton = new ButtonGroup();
		grButton.add(btnNam);
		grButton.add(btnNu);

		JLabel lb_luong = new JLabel("Tiền lương:");
		lb_luong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_luong.setBounds(10, 122, 82, 28);
		panel_1.add(lb_luong);

		txtLuong = new JTextField();
		txtLuong.setColumns(10);
		txtLuong.setBounds(96, 124, 680, 28);
		panel_1.add(txtLuong);

		String[] tieuDe = { "Mã nhân viên", "Họ", "Tên", "Giới Tính", "Tuổi", "Tiền lương" };
		mdlTable = new DefaultTableModel(tieuDe,0);
		table = new JTable(mdlTable);
		sorter = new TableRowSorter<TableModel>(mdlTable);
		table.setRowSorter(sorter);
		table.setBorder(BorderFactory.createLineBorder(Color.black));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(new Rectangle(10, 160, 766, 280));
		panel_1.add(scrollPane);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 460, 766, 21);
		panel_1.add(separator);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 476, 366, 37);
		panel_2.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lb_timKiem = new JLabel("Nhập mã số cần tìm:");
		lb_timKiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_timKiem.setBounds(10, 5, 129, 28);
		panel_2.add(lb_timKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(132, 11, 150, 19);
		panel_2.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		btnTimKiem = new JButton("Tìm");
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnTimKiem.setBounds(292, 10, 64, 21);
		panel_2.add(btnTimKiem);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(386, 476, 390, 37);
		panel_2_1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnThem.setBounds(21, 8, 80, 21);
		panel_2_1.add(btnThem);

		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnXoaTrang.setBounds(105, 8, 99, 21);
		panel_2_1.add(btnXoaTrang);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		btnXoa.setBounds(210, 8, 80, 21);
		panel_2_1.add(btnXoa);

		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnLuu.setBounds(297, 8, 80, 21);
		panel_2_1.add(btnLuu);

		this.setVisible(true);
		btnXoaTrang.addActionListener(this);
		btnThem.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(this);
		
		addEnterKeyListener(txtMaNV, txtHo);
		addEnterKeyListener(txtHo, txtTen);
		addEnterKeyListener(txtTen, txtTuoi);
		addEnterKeyListener(txtTuoi, txtLuong);
		
		fi = new ghiDocFile();
		try {
			ds = (ArrayNhanVien)fi.readFromFile(fileName);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Không tìm thấy file!","Lỗi",JOptionPane.ERROR_MESSAGE);
		}
		printTable();
	}
//===================================================================================================================================
	public void printTable() {
		mdlTable.setRowCount(0);
		ArrayList<NhanVien> dsnv = this.ds.getDs();
		for(NhanVien nv : dsnv) {
			String gt = "";
			if(nv.isGioiTinh())
				gt = "Nam";
			else
				gt = "Nữ";
			this.mdlTable.addRow(new Object[] {nv.getMaNV() + "", nv.getHoNV(), nv.getTenNV(), gt, nv.getTuoi() + "", nv.getTienLuong() + ""});
		}
	}
//===================================================================================================================================

	public void themNhanVien() {
		int maNV = Integer.valueOf(this.txtMaNV.getText());
		String ho = this.txtHo.getText();
		String ten = this.txtTen.getText();
		boolean gioiTinh;
		String gender = "";
		if (this.btnNam.isSelected()) {
			gioiTinh = true;
			gender = "Nam";
		} else {
			gioiTinh = false;
			gender = "Nữ";
		}
		int tuoi = Integer.valueOf(this.txtTuoi.getText());
		double luong = Double.valueOf(this.txtLuong.getText());

		NhanVien new_nv = new NhanVien(maNV, ho, ten, gioiTinh, tuoi, luong);

			try {
				this.ds.themNhanVien(new_nv);
				this.mdlTable.addRow(new Object[] { maNV + "", ho, ten, gender, tuoi + "", luong + "" });
				this.table.clearSelection();
				xoaData();
				txtMaNV.requestFocus();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên bị trùng","Lỗi",JOptionPane.ERROR_MESSAGE);
				txtMaNV.setText("");
				txtMaNV.requestFocus();
			}
	}
//===================================================================================================================================

	public void xoaData() {
		txtMaNV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtLuong.setText("");
		txtTuoi.setText("");
		txtTimKiem.setText("");
		grButton.clearSelection();
		table.clearSelection();
	}
//===================================================================================================================================

	public void layDataNhanVien() {
		int rowSelected = table.convertRowIndexToModel(table.getSelectedRow());
		this.txtMaNV.setText(this.mdlTable.getValueAt(rowSelected, 0).toString());
		this.txtHo.setText(this.mdlTable.getValueAt(rowSelected, 1).toString());
		this.txtTen.setText(this.mdlTable.getValueAt(rowSelected, 2).toString());
		this.txtTuoi.setText(this.mdlTable.getValueAt(rowSelected, 4).toString());
		this.txtLuong.setText(this.mdlTable.getValueAt(rowSelected, 5).toString());
		String gioiTinh = this.mdlTable.getValueAt(rowSelected, 3).toString();
		if (gioiTinh.equalsIgnoreCase("nam")) {
			this.btnNam.setSelected(true);
		} else
			this.btnNu.setSelected(true);
	}
//===================================================================================================================================

	public void xoaNhanVien() {
		int rowSelected = table.getSelectedRow();
		if(rowSelected == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xoá","Lỗi!",JOptionPane.ERROR_MESSAGE);
		} else {
			int maNV = Integer.valueOf(this.mdlTable.getValueAt(rowSelected, 0).toString());
			NhanVien nv = this.ds.timNhanVien(maNV);
				this.ds.xoaNhanVien(nv);
				this.mdlTable.removeRow(rowSelected);
				this.table.clearSelection();
				this.xoaData();
		}

	}
//===================================================================================================================================
	public void timNhanVien() {
		if(txtTimKiem.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sinh viên cần tìm","Lỗi!",JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				@SuppressWarnings("unused")
				int maNV = Integer.valueOf(this.txtTimKiem.getText());
				String strMaNV = (this.txtTimKiem.getText());
				sorter.setRowFilter(RowFilter.regexFilter(strMaNV, 0));
				if(sorter.getViewRowCount() == 0) {
					JOptionPane.showMessageDialog(this,"Không tìm thấy mã nhân viên","Lỗi!",JOptionPane.ERROR_MESSAGE);
					sorter.setRowFilter(null);
					this.txtTimKiem.setText("");
					this.txtTimKiem.requestFocusInWindow();
				}
			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Sai định dạng mã nhân viên!","Lỗi",JOptionPane.ERROR_MESSAGE);
				this.txtTimKiem.setText("");
				this.txtTimKiem.requestFocusInWindow();
			}
		}	
	}
//===================================================================================================================================

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btnThem) {
			if(txtMaNV.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this,"Mã nhân viên không được để trống!","Lỗi!",JOptionPane.ERROR_MESSAGE);
				txtMaNV.requestFocus();
			}
			else if(txtHo.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this,"Họ nhân viên không được để trống!","Lỗi!",JOptionPane.ERROR_MESSAGE);
				txtHo.requestFocus();
			}
			else if(txtTen.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this,"Tên nhân viên không được để trống!","Lỗi!",JOptionPane.ERROR_MESSAGE);
				txtHo.requestFocus();
			}
			else
			{
				themNhanVien();
			}
		
		} 
		else if(o == btnXoaTrang) {
			xoaData();
		}
		else if(o == btnTimKiem)
		{
			if(isSearch) {
				timNhanVien();
				btnTimKiem.setText("Huỷ");
				isSearch = false;
			} else {
				sorter.setRowFilter(null);
				txtTimKiem.setText("");
				txtTimKiem.requestFocus();
				btnTimKiem.setText("Tìm");
				isSearch = true;
			}
			
		}
		else if(o == btnXoa) {
			int confirm = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn xoá?","Xác nhận xoá",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(confirm == JOptionPane.YES_OPTION) {
				xoaNhanVien();
			}
		}
		else if(o == btnLuu) {
			fi = new ghiDocFile();
			try {
				fi.writeToFile(ds, fileName);
				JOptionPane.showMessageDialog(this,"Lưu thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this,"Lưu không thành công!","Lỗi",JOptionPane.ERROR_MESSAGE);
				e2.printStackTrace();
			}
		}
		
	
	}
//===================================================================================================================================

	private void addEnterKeyListener(JTextField currentField, JTextField nextField) {
		currentField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nextField.requestFocus();
				
			}
		});
		
	}
//===================================================================================================================================

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new view();
		} catch (Exception e) {
		}
	}


	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		this.layDataNhanVien();
	}


	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
