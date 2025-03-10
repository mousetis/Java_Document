package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GiaiPTB2 extends JFrame implements ActionListener {
	
	private JPanel pnlNorth;
	private JPanel pnlCenter;
	private JPanel pnlSouth;
	private JButton btnAc;
	private JButton btnDel;
	private JButton btnExit;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtRes;

	public GiaiPTB2() {
		
		int col = 35;
		pnlNorth = new JPanel();
		JLabel lblTop = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		lblTop.setFont(new Font("Time New Roman",Font.BOLD, 20));
		pnlNorth.add(lblTop);
		pnlNorth.setBackground(Color.CYAN);
		pnlNorth.setPreferredSize(new Dimension(500, 50));
		add(pnlNorth, BorderLayout.NORTH);
		
		pnlCenter = new JPanel(new GridLayout(4,2, 0, 80));
		JLabel lblA = new JLabel("Nhập a: ");
		JLabel lblB = new JLabel("Nhập b: ");
		JLabel lblC = new JLabel("Nhập c: ");
		JLabel lblRes = new JLabel("Kết Quả: ");
		 txtA = new JTextField(col);
		 txtB = new JTextField(col);
		 txtC = new JTextField(col);
		 txtRes = new JTextField(col);
		txtRes.setEditable(false);
		pnlCenter.add(lblA);
		pnlCenter.add(txtA);
		pnlCenter.add(lblB);
		pnlCenter.add(txtB);
		pnlCenter.add(lblC);
		pnlCenter.add(txtC);
		pnlCenter.add(lblRes);
		pnlCenter.add(txtRes);
		pnlCenter.setLayout(new FlowLayout(FlowLayout.CENTER,20,40));
		add(pnlCenter, BorderLayout.CENTER);
		
		pnlSouth = new JPanel();
		btnAc = new JButton("Giải");
		btnDel = new JButton("Xóa Rỗng");
		btnExit = new JButton("Thoát");
		TitledBorder border = BorderFactory.createTitledBorder("Chọn Tác Vụ");	
		pnlSouth.add(btnAc);
		pnlSouth.add(btnDel);
		pnlSouth.add(btnExit);
		pnlSouth.setBorder(border);
		pnlSouth.setPreferredSize(new Dimension(600,100));
		add(pnlSouth, BorderLayout.SOUTH);
		
		btnExit.addActionListener(this);
		btnAc.addActionListener(this);
		btnDel.addActionListener(this);
		addEnterKeyListener(txtA, txtB);
		addEnterKeyListener(txtB, txtC);
		setSize(500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GiaiPTB2();
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
			String c1 = txtC.getText();
			if(a1.equalsIgnoreCase("") || b1.equalsIgnoreCase("") || c1.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ giá trị a,b,c!","Lỗi!",JOptionPane.ERROR_MESSAGE);
			}
			else {
			int a, b, c;
			a = Integer.parseInt(txtA.getText());
			b = Integer.parseInt(txtB.getText());
			c = Integer.parseInt(txtC.getText());
			if (a == 0) {
	            if (b == 0) {
	                if (c == 0) {
	                   txtRes.setText("Phương trình vô số nghiệm");
	                } else {
	                    txtRes.setText("Phương trình vô nghiệm");
	                }
	            } else {
	                double x = -c / b;
	                txtRes.setText(Double.toString(x));
	            }
	        }
	        double delta = b * b - 4 * a * c;

	        if (delta > 0) {
	            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
	            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
	            txtRes.setText("Phương trình có 2 nghiệm phân biệt: " + "x1 = "  + Double.toString(x1) + ";  x2 = " + Double.toString(x2));
	        } else if (delta == 0) {
	            double x = -b / (2 * a);
	            txtRes.setText("Phương trình có nghiệm kép " + Double.toString(x));
	        } else {
	            txtRes.setText("Phương trình vô nghiệm ");
	        }
			}
		}
		else if(o == btnDel) {
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
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
