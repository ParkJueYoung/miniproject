	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Elevator extends JFrame implements ActionListener {

	JPanel panel1, panel2, panel3;
	JButton btn1, btn2, btn3, btnB1, closeBtn, openBtn; // 층별 버튼, 열림 버튼, 닫힘 버튼
	JTextField stateField, floorField; // 안내메시지
	int i = 0;
	
	public Elevator() {

		setSize(250, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("엘리베이터");

		// 패털추가
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 2));
		panel3 = new JPanel();

		floorField = new JTextField(2);
		floorField.setText(""); // 층수를 알리는 메시지 필드
		
		// 버튼추가
		btn1 = new JButton("1"); 
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btnB1 = new JButton("B1");
		closeBtn = new JButton("닫힘");
		openBtn = new JButton("열림");
		
		// 버튼을 눌렀을때의 이벤트 추가
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btnB1.addActionListener(this);
		closeBtn.addActionListener(this);
		openBtn.addActionListener(this);

		stateField = new JTextField(8);
		
		// 패널에 버튼 추가
		panel1.add(floorField);

		panel2.add(btn1);
		panel2.add(btn3);
		panel2.add(btnB1);
		panel2.add(btn2);
		panel2.add(openBtn);
		panel2.add(closeBtn);

		panel3.add(stateField);

		// BorderLayout 사용하여 패널위치 설정
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.add(panel3, BorderLayout.SOUTH);

		panel1.setBackground(Color.GRAY);
		panel3.setBackground(Color.GRAY);

		setVisible(true);

	}

	// 이벤트
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			if (i < 1) {
				stateField.setText("올라갑니다.");
			} else if (i > 1) {
				stateField.setText("내려갑니다.");
			} else {
				stateField.setText("1층입니다.");
			}

			i = 1;
		} else if (e.getSource() == btn2) {
			if (i < 2) {
				stateField.setText("올라갑니다.");
			} else if (i > 2) {
				stateField.setText("내려갑니다.");
			} else {
				stateField.setText("2층입니다.");
			}
			i = 2;
		} else if (e.getSource() == btn3) {

			if (i > 3) {
				stateField.setText("내려갑니다.");
			} else if (i == 3) {
				stateField.setText("3층입니다.");
			} else if (i < 3) {
				stateField.setText("올라갑니다");
			}
			i = 3;
		} else if (e.getSource() == btnB1) {
			if (i > -1) {
				stateField.setText("내려갑니다.");
			} else if (i == -1) {
				stateField.setText("지하 1층입니다.");
			}
			i = -1;
		} else if (e.getSource() == closeBtn) {
			stateField.setText("문이닫힙니다.");
		} else if (e.getSource() == openBtn) {
			stateField.setText("문이열립니다.");
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if (i == 1) {
			floorField.setText(" 1");
		} else if (i == 2) {
			floorField.setText(" 2");
		} else if (i == 3) {
			floorField.setText(" 3");
		} else if (i == -1) {
			floorField.setText("B1");
		}

	}

	public static void main(String[] args) {
		new Elevator();

	}
}