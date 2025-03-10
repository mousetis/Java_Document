package Tuan2;

import java.io.Serializable;
import java.util.ArrayList;

public class ArrayNhanVien implements Serializable{
	private ArrayList<NhanVien> ds;

	public ArrayNhanVien() {
		super();
		ds = new ArrayList<NhanVien>();
	}

	public ArrayList<NhanVien> getDs() {
		return ds;
	}

	public void setDs(ArrayList<NhanVien> ds) {
		this.ds = ds;
	}

	public void themNhanVien(NhanVien newnv) throws Exception {
		if (!ds.contains(newnv))
			ds.add(newnv);
		else
			throw new Exception("Mã nhân viên trùng !!!");
	}

	public void xoaNhanVien(NhanVien nv) {
		ds.remove(nv);
	}
	
	public NhanVien timNhanVien(int maNV){
		for(NhanVien nv : ds) {
			if(nv.getMaNV() ==  maNV) {
				return nv;
			}
		}
		//throw new Exception("Không tìm thấy nhân viên"+ maNV.toString() +"!");
		return null;
	}
}
