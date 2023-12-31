package j20230612;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class ButtonDemo implements ActionListener{
	int redScoreAmount = 0;
	int blueScoreAmount = 0;
	JPanel titlePanel, scorePanel, buttonPanel;
	JLabel redLabel, blueLabel, redScore, blueScore;
	JButton redButton, blueButton, resetButton;
	
	public JPanel createContentPane() {
		//total panel
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null); //배치관리자 제거
		
		//title panel
		titlePanel = new JPanel();
		titlePanel.setLayout(null); //배치관리자 제거
		titlePanel.setLocation(10, 0); //제목패널 위치 지정
		titlePanel.setSize(250,30); //제목패널 크기 지정
		totalGUI.add(titlePanel); //전체패널에 제목패널 컴포넌트 추가
		
		redLabel = new JLabel("Red Team");
		redLabel.setLocation(0,0);
		redLabel.setSize(100,30);
		redLabel.setHorizontalAlignment(0);
		redLabel.setForeground(Color.red);
		titlePanel.add(redLabel); //제목패널에 레드라벨 컴포넌트 추가
		
		blueLabel = new JLabel("Blue Team");
		blueLabel.setLocation(120,0);
		blueLabel.setSize(100,30);
		blueLabel.setHorizontalAlignment(0);
		blueLabel.setForeground(Color.blue);
		titlePanel.add(blueLabel); //제목패널에 블루라벨 컴포넌트 추가
		
		//score panel
		scorePanel = new JPanel();
		scorePanel.setLayout(null);
		scorePanel.setLocation(10,40);
		scorePanel.setSize(250,30);
		totalGUI.add(scorePanel); //전체패널에 점수패널 컴포넌트 추가
		
		redScore = new JLabel("0");
		redScore.setLocation(0,0);
		redScore.setSize(100,30);
		redScore.setHorizontalAlignment(0);
		scorePanel.add(redScore); //점수패널에 레드점수 컴포넌트 추가
		
		blueScore = new JLabel("0");
		blueScore.setLocation(120,0);
		blueScore.setSize(100,30);
		blueScore.setHorizontalAlignment(0);
		scorePanel.add(blueScore); //점수패널에 블루점수 컴포넌트 추가
		
		//button panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(10,80);
		buttonPanel.setSize(250,70);
		totalGUI.add(buttonPanel); //전체패널에 버튼패널 컴포넌트 추가
		
		redButton = new JButton("Red Score!");
		redButton.setLocation(0,0);
		redButton.setSize(100,30);
		redButton.addActionListener(this); //??
		buttonPanel.add(redButton); //버튼패널에 레드버튼 추가
		
		blueButton = new JButton("Blue Score!");
		blueButton.setLocation(120,0);
		blueButton.setSize(100,30);
		blueButton.addActionListener(this); //??
		buttonPanel.add(blueButton); //버튼패널에 블루버튼 추가
		
		resetButton = new JButton("Reset Score");
		resetButton.setLocation(0,40);
		resetButton.setSize(220,30);
		resetButton.addActionListener(this); //??
		buttonPanel.add(resetButton); //버튼패널에 리셋버튼 추가
		
		totalGUI.setOpaque(true); //??
		return totalGUI;
	}
	
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("[=]JButton Score![=]");
		ButtonDemo demo = new ButtonDemo();
		
		frame.setContentPane(demo.createContentPane());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(250,190);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() { 
				createAndShowGUI();
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == redButton) {
			++redScoreAmount;
			redScore.setText("" + redScoreAmount);
		} else if (obj==blueButton) {
			++blueScoreAmount;
			blueScore.setText("" + blueScoreAmount);
		}else if(obj==resetButton) {
			redScoreAmount=0;
			blueScoreAmount=0;
			redScore.setText("" + redScoreAmount);
			blueScore.setText("" + blueScoreAmount);
		}
	}
}
