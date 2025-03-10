package Tuan2_QuanLyNhanVien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controller implements ActionListener {
	private View view;

	public Controller(View view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();

		if (str.equalsIgnoreCase("thêm")) {
			try {
				this.view.themNhanVien();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (str.equalsIgnoreCase("xóa trắng")) {
			this.view.xoaForm();
		} else if (str.equalsIgnoreCase("xóa")) {
			int row = this.view.table.getSelectedRow();
			if (row == -1)
				JOptionPane.showMessageDialog(this.view, "Vui lòng chọn dòng để xóa!!!");
			else
				this.view.xoaNhanVien();
		} else if (str.equalsIgnoreCase("lưu")) {
			this.view.saveFile();
		} else if (str.equalsIgnoreCase("tìm")) {
			this.view.timNhanVien();
		}

	}
}
