package Tuan2_QuanLyNhanVien;

import java.util.ArrayList;

public class Ql_NhanVien {
	private ArrayList<Model> ds;

	public Ql_NhanVien() {
		super();
		ds = new ArrayList<Model>();
	}

	public ArrayList<Model> getDs() {
		return ds;
	}

	public void setDs(ArrayList<Model> ds) {
		this.ds = ds;
	}

	public void themNhanVien(Model new_nv) throws Exception {
		if (!ds.contains(new_nv))
			ds.add(new_nv);
		else
			throw new Exception("Mã nhân viên trùng !!!");
	}

	public void xoaNhanVienDS(Model nv_xoa) {
		ds.remove(nv_xoa);
	}

}
