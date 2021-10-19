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

public class AccountTransfer extends JFrame implements ActionListener {

	private JLabel num, money, accNum, accMoney, msg, name, blank;
	private JLabel num1, money1, accNum1, accMoney1, msg1, name1, blank1;
	private JTextField numField, moneyField, accNumField, accMoneyField, msgField;
	private JTextField numField1, moneyField1, accNumField1, accMoneyField1, msgField1;
	private JButton checkBtn, transBtn;
	private JButton checkBtn1, transBtn1;
	private JPanel panel1, panel2;
	int i = 10000;
	int j = 20000;

	public AccountTransfer() {
		//
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("계좌이체");
		setLayout(new GridLayout(0, 2));
		panel1 = new JPanel(); // 패널1
		panel1.setLayout(new GridLayout(0, 2));
		panel2 = new JPanel(); // 패널2
		panel2.setLayout(new GridLayout(0, 2));

		blank = new JLabel("");
		name = new JLabel("홍길동"); // 송금자이름
		money = new JLabel("잔액"); // 송금자잔액
		accNum = new JLabel("이체계좌번호"); // 이체할계좌번호
		accMoney = new JLabel("이체금액"); // 이체할금액
		msg = new JLabel("메시지"); // 안내메시지

		blank1 = new JLabel("");
		name1 = new JLabel("홍길순"); // 이체받는사람 
		num1 = new JLabel("계좌번호"); // 이체받는사람의 계좌번호
		money1 = new JLabel("잔액"); // 이체받은 후 잔액
		msg1 = new JLabel("메시지"); // 안내메시지


		moneyField = new JTextField(20); // 잔액필드
		accNumField = new JTextField(20); // 이체할계좌필드
		accMoneyField = new JTextField(20); // 이체할금액필드
		msgField = new JTextField(15); // 메시지필드

		numField1 = new JTextField(20); // 이체받을계좌필드
		moneyField1 = new JTextField(20); // 이체받는사람잔액필드

		msgField1 = new JTextField(15); // 안내메시지

		checkBtn = new JButton("조회"); // 조회버튼
		transBtn = new JButton("이체"); // 이체버튼

		panel1.add(blank);
		panel1.add(name);

		panel1.add(money);
		panel1.add(moneyField);
		panel1.add(accNum);
		panel1.add(accNumField);
		panel1.add(accMoney);
		panel1.add(accMoneyField);
		panel1.add(msg);
		panel1.add(msgField);
		panel1.add(checkBtn);
		panel1.add(transBtn);
		checkBtn.addActionListener(this);
		transBtn.addActionListener(this);

		panel2.add(blank1);
		panel2.add(name1);
		panel2.add(num1);
		panel2.add(numField1);
		panel2.add(money1);
		panel2.add(moneyField1);

		panel2.add(msg1);
		panel2.add(msgField1);

		checkBtn.addActionListener(this);
		transBtn.addActionListener(this);

		this.add(panel1, BorderLayout.WEST);
		this.add(panel2, BorderLayout.EAST);

		setVisible(true);

	}

	public static void main(String[] args) {
		//
		new AccountTransfer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//

		String money_ = moneyField.getText();
		String accNum_ = accNumField.getText();
		String accMoney_ = accMoneyField.getText();

		String num1_ = numField1.getText();



		int money = Integer.parseInt(money_); // 잔액
		int accNum = Integer.parseInt(accNum_); // 이체계좌
		int accMoney = Integer.parseInt(accMoney_); // 이체계좌

		int num1 = Integer.parseInt(num1_); // 이체받는사람의계좌


		if (e.getSource() == transBtn) {
			if (accNum == num1 && money >= accMoney) {
				msgField.setText("이체되었습니다.");
				msgField1.setText("입금되었습니다.");
				moneyField1.setText(accMoney_);
				String result = String.valueOf(money - accMoney);
				moneyField.setText(result);
				accMoneyField.setText("");

			} else if (money < accMoney) {
				msgField.setText("잔액이부족합니다.");
			} else {
				msgField.setText("");
			}

		}
	}
}
