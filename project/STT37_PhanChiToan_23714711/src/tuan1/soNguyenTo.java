package tuan1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class soNguyenTo extends JFrame implements ActionListener {

	private JTextField txtInput;
	private JButton btnGenerate;
	private JTextArea txtArea;

	public soNguyenTo(){
		super("Số Nguyên Tố");
		
		JPanel pnlNorth = new JPanel();
		txtInput = new JTextField(25);
		btnGenerate = new JButton("Generate");	
		pnlNorth.add(txtInput);
		pnlNorth.add(btnGenerate);
		add(pnlNorth,BorderLayout.NORTH);
		
		JPanel pnlCenter = new JPanel();
		txtArea = new JTextArea(20, 40);
		
		pnlCenter.add(txtArea);
		add(pnlCenter, BorderLayout.CENTER);
		
		btnGenerate.addActionListener(this);
		
		setSize(500,500);
		setVisible(true);
	}
	
	public ArrayList<Integer> getPrimeNumbers(int n) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        int count = 0;  
        int num = 2;    

        while (count < n) {
            if (isPrime(num)) {
                primeNumbers.add(num);  
                count++;
            }
            num++;
        }
        return primeNumbers;  
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		new soNguyenTo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btnGenerate) {
			String a = txtInput.getText();
			if(a.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this,"Vui Lòng Không Để Trống Giá Trị Nhập Vào", "Lỗi!", JOptionPane.ERROR_MESSAGE);
			} else {
				int number = Integer.parseInt(txtInput.getText());
				ArrayList<Integer> ketqua = getPrimeNumbers(number);
				for (int i : ketqua) {
					txtArea.append(Integer.toString(i) + "\n");
				}
			}
		}
	}
	
}
