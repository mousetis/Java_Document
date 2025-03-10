package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class CongTruNhanChia extends JFrame implements ActionListener{

	private JButton btnAc;
	private JButton btnDel;
	private JButton btnExit;
	private JTextField txtA;
	private JTextField txtB;
	private JRadioButton btnCong;
	private JRadioButton btnTru;
	private JRadioButton btnNhan;
	private JRadioButton btnChia;
	private JTextField txtRes;

	public CongTruNhanChia(){
		super("Cộng-Trừ-Nhân-Chia");
		
		JPanel pNorth = new JPanel();
		JLabel lblTitle = new JLabel("Cộng Trừ Nhân Chia");
		lblTitle.setFont(new Font ("Arial", Font.BOLD, 40));
		pNorth.add(lblTitle);
		add(pNorth, BorderLayout.NORTH);
		
//-------------------------------------------------------------
		
		JPanel pWest = new JPanel();
		pWest.setLayout(new BoxLayout(pWest, BoxLayout.Y_AXIS));
		btnAc = new JButton("Giải");
		btnDel = new JButton("Xoá");
		btnExit = new JButton("Thoát");
		pWest.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pWest.setBackground(Color.GRAY);
		pWest.add(btnAc);
		pWest.add(btnDel);
		pWest.add(btnExit);
		pWest.setPreferredSize(new Dimension(100,100));
		add(pWest, BorderLayout.WEST);
		
//-------------------------------------------------------------
		
		JPanel pSouth = new JPanel();
		pSouth.setBackground(Color.GRAY);
		JTextField txtRed = new JTextField(2);
		JTextField txtBlue = new JTextField(2);
		JTextField txtWhite = new JTextField(2);
		txtRed.setBackground(Color.RED);
		txtBlue.setBackground(Color.BLUE);
		txtWhite.setBackground(Color.WHITE);
		pSouth.add(txtRed);
		pSouth.add(txtBlue);
		pSouth.add(txtWhite);
		add(pSouth, BorderLayout.SOUTH);
		
//-------------------------------------------------------------
		
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BorderLayout());
		pCenter.setBorder(BorderFactory.createTitledBorder("Tính Toán"));
		
		JPanel pButton = new JPanel();
		JPanel pField = new JPanel();
		JPanel pResult = new JPanel();
		
		JLabel lblA = new JLabel("Nhập a: ");
		JLabel lblB = new JLabel("Nhập b: ");
		txtA = new JTextField(40);
		txtB = new JTextField(40);
		pField.add(lblA);
		pField.add(txtA);
		pField.add(lblB);
		pField.add(txtB);
		
		pButton.setLayout(new GridLayout(2,2));
		pButton.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		ButtonGroup phepToan =  new ButtonGroup();
		btnCong = new JRadioButton("Cộng");
		btnTru  = new JRadioButton("Trừ");
		btnNhan = new JRadioButton("Nhân");
		btnChia = new JRadioButton("Chia");
		phepToan.add(btnCong);
		phepToan.add(btnTru);
		phepToan.add(btnNhan);
		phepToan.add(btnChia);
		pButton.add(btnCong);
		pButton.add(btnTru);
		pButton.add(btnNhan);
		pButton.add(btnChia);
		
		JLabel lblRes = new JLabel("Kết quả: ");
		txtRes = new JTextField(40);
		txtRes.setEditable(false);
		pResult.add(lblRes);
		pResult.add(txtRes);
		
		pButton.setPreferredSize(new Dimension(200,200));
		pField.setPreferredSize(new Dimension(100,100));
		pCenter.add(pField, BorderLayout.NORTH);
		pCenter.add(pButton, BorderLayout.CENTER);
		pCenter.add(pResult, BorderLayout.SOUTH);
		add(pCenter, BorderLayout.CENTER);
		
		btnDel.addActionListener(this);
		btnAc.addActionListener(this);
		btnExit.addActionListener(this);
		addEnterKeyListener(txtA, txtB);
		
		setSize(600,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CongTruNhanChia();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btnExit) {
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát?",
					"Xác nhận thoát!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(confirm == JOptionPane.YES_OPTION)
				dispose();
		}
		else if(o == btnAc) {
			String a1 = txtA.getText();
			String b1 = txtB.getText();
			
			if(a1.equalsIgnoreCase("") || b1.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ giá trị a,b!","Lỗi!",JOptionPane.ERROR_MESSAGE);
			} else {
				
				int a, b;
				a = Integer.parseInt(txtA.getText());
				b = Integer.parseInt(txtB.getText());
				
				if(btnCong.isSelected()) {
					int res = a+b;
					txtRes.setText(Integer.toString(res));
					
				} else if (btnTru.isSelected()) {
					int res1 = a-b;
					txtRes.setText(Integer.toString(res1));
					
				} else if (btnNhan.isSelected()) {
					int res2 = a*b;
					txtRes.setText(Integer.toString(res2));
					
				} else {
					float res3 = (float)a/b;
					txtRes.setText(Double.toString(res3));
				}
			}
			
		}
		else if(o == btnDel) {
			txtA.setText("");
			txtB.setText("");
			txtRes.setText("");
		}
		
	}
	private static void addEnterKeyListener(JTextField currentField, JTextField nextField) {
        currentField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextField.requestFocus();
            }
        });
    }
}
