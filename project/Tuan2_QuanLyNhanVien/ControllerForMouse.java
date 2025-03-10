package Tuan2_QuanLyNhanVien;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerForMouse implements MouseListener {
	private View view;
	
	public ControllerForMouse(View view) {
		super();
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.view.layDataNhanVien();
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
