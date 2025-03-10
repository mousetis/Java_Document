package Tuan2_QuanLyNhanVien;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class View extends JFrame {
	public Ql_NhanVien ds;
	private static final long serialVersionUID = 1L;
	public JTextField text_maNV;
	public JTextField text_ho;
	public JTextField text_ten;
	public JTextField text_tuoi;
	public JTextField text_luong;
	public JTextField text_timKiem;
	public ButtonGroup group_button;
	public DefaultTableModel model_table;
	public JTable table;
	public JRadioButton btnRa_nam;
	public JRadioButton btnRa_nu;
	public TableRowSorter<TableModel> sorter;
	public JFileChooser fc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new View();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public View() {
		super("Quản Lý Nhân Viên ");
		this.ds = new Ql_NhanVien();
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		Controller ctrl_action = new Controller(this);
		ControllerForMouse mouse_ctrl = new ControllerForMouse(this);

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

		text_maNV = new JTextField();
		text_maNV.setBounds(96, 10, 680, 28);
		text_maNV.requestFocusInWindow();
		panel_1.add(text_maNV);
		text_maNV.setColumns(10);

		JLabel lb_ho = new JLabel("Họ:");
		lb_ho.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_ho.setBounds(10, 46, 82, 28);
		panel_1.add(lb_ho);

		text_ho = new JTextField();
		text_ho.setColumns(10);
		text_ho.setBounds(96, 48, 261, 28);
		panel_1.add(text_ho);

		text_ten = new JTextField();
		text_ten.setColumns(10);
		text_ten.setBounds(460, 48, 316, 30);
		panel_1.add(text_ten);

		JLabel lb_tenNV = new JLabel("Tên nhân viên:");
		lb_tenNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_tenNV.setBounds(371, 48, 91, 28);
		panel_1.add(lb_tenNV);

		JLabel lb_tuoi = new JLabel("Tuổi:");
		lb_tuoi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_tuoi.setBounds(10, 84, 82, 28);
		panel_1.add(lb_tuoi);

		text_tuoi = new JTextField();
		text_tuoi.setColumns(10);
		text_tuoi.setBounds(96, 86, 505, 28);
		panel_1.add(text_tuoi);

		JLabel lb_phai = new JLabel("Phái:");
		lb_phai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_phai.setBounds(611, 88, 38, 28);
		panel_1.add(lb_phai);

		btnRa_nam = new JRadioButton("Nam");
		btnRa_nam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnRa_nam.setBounds(642, 92, 53, 21);
		panel_1.add(btnRa_nam);

		btnRa_nu = new JRadioButton("Nữ");
		btnRa_nu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnRa_nu.setBounds(712, 92, 53, 21);
		panel_1.add(btnRa_nu);

		group_button = new ButtonGroup();
		group_button.add(btnRa_nam);
		group_button.add(btnRa_nu);

		JLabel lb_luong = new JLabel("Tiền lương:");
		lb_luong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_luong.setBounds(10, 122, 82, 28);
		panel_1.add(lb_luong);

		text_luong = new JTextField();
		text_luong.setColumns(10);
		text_luong.setBounds(96, 124, 680, 28);
		panel_1.add(text_luong);

		String[] tieuDe = { "Mã nhân viên", "Họ", "Tên", "Giới Tính", "Tuổi", "Tiền lương" };
		model_table = new DefaultTableModel(tieuDe, 0);
		table = new JTable(model_table);
		sorter = new TableRowSorter<TableModel>(model_table);
		table.setRowSorter(sorter);
		table.addMouseListener(mouse_ctrl);
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

		text_timKiem = new JTextField();
		text_timKiem.setBounds(132, 11, 150, 19);
		panel_2.add(text_timKiem);
		text_timKiem.setColumns(10);

		JButton btn_timKiem = new JButton("Tìm");
		btn_timKiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_timKiem.addActionListener(ctrl_action);
		btn_timKiem.setActionCommand("Tìm");
		btn_timKiem.setBounds(292, 10, 64, 21);
		panel_2.add(btn_timKiem);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(386, 476, 390, 37);
		panel_2_1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);

		JButton btn_them = new JButton("Thêm");
		btn_them.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_them.addActionListener(ctrl_action);
		btn_them.setActionCommand("Thêm");
		btn_them.setBounds(21, 8, 80, 21);
		panel_2_1.add(btn_them);

		JButton btn_xoaTrang = new JButton("Xóa trắng");
		btn_xoaTrang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_xoaTrang.setBounds(105, 8, 99, 21);
		btn_xoaTrang.addActionListener(ctrl_action);
		btn_xoaTrang.setActionCommand("Xóa trắng");
		panel_2_1.add(btn_xoaTrang);

		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_xoa.addActionListener(ctrl_action);
		btn_xoa.setActionCommand("Xóa");
		btn_xoa.setBounds(210, 8, 80, 21);
		panel_2_1.add(btn_xoa);

		JButton btn_luu = new JButton("Lưu");
		btn_luu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_luu.addActionListener(ctrl_action);
		btn_luu.setActionCommand("Lưu");
		btn_luu.setBounds(297, 8, 80, 21);
		panel_2_1.add(btn_luu);

		this.setVisible(true);
	}

	public void xoaForm() {
		text_maNV.setText("");
		text_ho.setText("");
		text_ten.setText("");
		text_luong.setText("");
		text_tuoi.setText("");
		text_timKiem.setText("");
		group_button.clearSelection();
		table.clearSelection();
	}

	public void themNhanVien() {
		int maNV = Integer.valueOf(this.text_maNV.getText());
		String ho = this.text_ho.getText();
		String ten = this.text_ten.getText();
		boolean gioiTinh;
		String gender = "";
		if (this.btnRa_nam.isSelected()) {
			gioiTinh = true;
			gender = "Nam";
		} else {
			gioiTinh = false;
			gender = "Nữ";
		}
		int tuoi = Integer.valueOf(this.text_tuoi.getText());
		double luong = Double.valueOf(this.text_luong.getText());

		Model new_nv = new Model(maNV, ho, ten, gioiTinh, tuoi, luong);
		try {
			this.ds.themNhanVien(new_nv);
			this.model_table.addRow(new Object[] { maNV + "", ho, ten, gender, tuoi + "", luong + "" });
			this.table.clearSelection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Mã nhân viên trùng !!!");
		}

	}

	public void layDataNhanVien() {
		int rowSelected = table.convertRowIndexToModel(table.getSelectedRow());
		this.text_maNV.setText(this.model_table.getValueAt(rowSelected, 0).toString());
		this.text_ho.setText(this.model_table.getValueAt(rowSelected, 1).toString());
		this.text_ten.setText(this.model_table.getValueAt(rowSelected, 2).toString());
		this.text_tuoi.setText(this.model_table.getValueAt(rowSelected, 4).toString());
		this.text_luong.setText(this.model_table.getValueAt(rowSelected, 5).toString());
		String gioiTinh = this.model_table.getValueAt(rowSelected, 3).toString();
		if (gioiTinh.equalsIgnoreCase("nam")) {
			this.btnRa_nam.setSelected(true);
		} else
			this.btnRa_nu.setSelected(true);
	}

	public void xoaNhanVien() {
		int rowSelected = table.getSelectedRow();
		int maNV = Integer.valueOf(this.model_table.getValueAt(rowSelected, 0).toString());
		String ho = this.model_table.getValueAt(rowSelected, 1).toString();
		String ten = this.model_table.getValueAt(rowSelected, 2).toString();
		boolean gioiTinh;
		String gender = this.model_table.getValueAt(rowSelected, 3).toString();
		if (gender.equalsIgnoreCase("nam")) {
			gioiTinh = true;
		} else {
			gioiTinh = false;
		}
		int tuoi = Integer.valueOf(this.model_table.getValueAt(rowSelected, 4).toString());
		double luong = Double.valueOf(this.model_table.getValueAt(rowSelected, 5).toString());

		this.ds.xoaNhanVienDS(new Model(maNV, ho, ten, gioiTinh, tuoi, luong));
		this.model_table.removeRow(rowSelected);
		this.table.clearSelection();
		this.xoaForm();

	}

	public void timNhanVien() {
		try {
			@SuppressWarnings("unused")
			int check = Integer.valueOf(this.text_timKiem.getText());
			String manv = (this.text_timKiem.getText());
			sorter.setRowFilter(RowFilter.regexFilter(manv, 0));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng mã nhân viên!!!");
			this.text_timKiem.setText("");
			this.text_timKiem.requestFocusInWindow();
		}
	}

	public void saveFile() {
		fc = new JFileChooser();
		int option = fc.showSaveDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(this.ds.getDs());
				oos.close();
			} catch (Exception e) {
				return;
			}
		}
	}

}
