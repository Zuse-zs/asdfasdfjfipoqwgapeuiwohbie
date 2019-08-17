package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 登录页面
 * */
public class Login extends JFrame {

	JLabel JLName, JLpass, displayArea;/*显示名称，和动态时间显示  */
	JTextField JTName;/*文本框  */
	JPasswordField JTpass;/*密码框  */
	JButton JBName, JBquit;/*按钮  */
	String time;/*时间  */

	/* TODO 程序入口 */
	public static void main(String[] args) {
		new Login();
	}

	/* 登录页 */
	public Login() {
		super("登录入口");/* 窗口标题  */
		ImageIcon ico=new ImageIcon("img/ico.png");
		this.setIconImage(ico.getImage());
		Container c = this.getContentPane();/* 添加内容面板  */
		c.setLayout(null);
		JLName = new JLabel("用户名");
		JLName.setFont(new Font("微软雅黑", 4, 15));
		JLName.setBounds(40, 50, 60, 30);
		JTName = new JTextField();
		JTName.setBounds(100, 50, 150, 30);
		JLpass = new JLabel("密    码");
		JLpass.setFont(new Font("微软雅黑", 4, 15));
		JLpass.setBounds(40, 100, 60, 30);
		JTpass = new JPasswordField();
		JTpass.setBounds(100, 100, 150, 30);
		JBName = new JButton("登录");
		JBName.setFont(new Font("微软雅黑", 4, 15));
		JBName.setBounds(60, 160, 70, 35);
		JBquit = new JButton("退出");
		JBquit.setFont(new Font("微软雅黑", 4, 15));
		JBquit.setBounds(170, 160, 70, 35);
		displayArea = new JLabel();
		displayArea.setBounds(130, 220, 150, 30);

		c.add(JLName);
		c.add(JLpass);
		c.add(JTName);
		c.add(JTpass);
		c.add(JBName);
		c.add(JBquit);
		c.add(displayArea);
		configTimerea();


		/* 登录按钮事件 */
		JBName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = new String(JTName.getText());/* 获得“用户名”文本框中的内容  */
				String PassWord = new String(JTpass.getPassword());/* 获得“密码”文本框中的内容  */
				if("".equals(Name)&&"".equals(PassWord)){
					setVisible(false);/* 隐藏登录窗口 */
					new Index();/* 显示主页 */
				}else{
					JOptionPane.showMessageDialog(null, "账号或密码错误！", "提示",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});

		/* 退出开始 */
		JBquit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		/* 回车事件开始 */
		JTpass.addKeyListener(new KeyAdapter() {/* 为“密码”文本框添加键盘时间的监听  */
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n') {/* 按下的按键是回车时  */
					JBName.doClick();/* “登录”按钮执行点击事件  */
				}
			}
		});
		JTName.addKeyListener(new KeyAdapter() {/* 为“用户名”文本框添加键盘时间的监听  */
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n') {/* 按下的按键是回车时  */
					JBName.doClick();/* “登录”按钮执行点击事件  */
				}
			}
		});



        JOptionPane.showMessageDialog(null, "兄台！有没有好的源码贡献拉", "by：1371576853", JOptionPane.PLAIN_MESSAGE);
        this.setVisible(true);/* 窗口可见性  */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/* 关闭方式  */
		this.setSize(300, 280);/* 窗口大小  */
		this.setLocationRelativeTo(null);/* 窗口居中  */
		this.setResizable(false);/* 固定窗口  */
	}

	/* 登录页面动态时间  */
	private void configTimerea() {
		Timer tmr = new Timer();
		tmr.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), 1000);
	}
	protected class JLabelTimerTask extends TimerTask {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(
				"yyyy年MM月dd日  HH:mm:ss");
		@Override
		public void run() {
			time = dateFormatter.format(Calendar.getInstance().getTime());
			displayArea.setText(time);
		}
	}

}
