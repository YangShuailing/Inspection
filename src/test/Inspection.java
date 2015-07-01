package test;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.Font;
import javax.sound.sampled.Port;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.omg.CORBA.PUBLIC_MEMBER;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
/**
 * Client
 * 
 * @author hx0272
 * 
 */
public class Inspection
{
    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
		CFrame frame = new CFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  
    }
}
@SuppressWarnings("serial")
class CFrame extends JFrame
{
    private JPanel mainPanel;
    private JPanel footPanel;
    private JTextArea showArea;
    private JButton submitBtn1;
    private JButton submitBtn2;
//    private JButton nameBtn;
//    private JButton locBtn;
    public CFrame()
    {
        init();
    }
    private void init()
    {
        //main panel Begin
        mainPanel = new JPanel();
        showArea = new JTextArea(25, 80);
        showArea.setEditable(true);
        mainPanel.add(showArea);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        //main panel End
        //head panel Begin
//        headPanel.add(locBtn);
        //head panel End
        //foot panel Begin
        footPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        submitBtn1 = new JButton("检查01班");
        submitBtn2 = new JButton("检查02班");
        footPanel.add(submitBtn1,BorderLayout.CENTER);
        submitBtn1.addActionListener(new ButtonClickAction1());
       
        getContentPane().add(footPanel, BorderLayout.SOUTH);
        footPanel.add(submitBtn2,BorderLayout.CENTER);
        submitBtn2.addActionListener(new ButtonClickAction2());
        
        getContentPane().add(footPanel, BorderLayout.NORTH);
        //foot panel End
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                 
                System.exit(0);
            }
        });
        this.setSize(300, 300);
        setLocation(100, 100);
        pack();
        setVisible(true);
    }
    /**
     * login button / submit button action listener
     * 
     * @author hx0272
     * 
     */
    class ButtonClickAction1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	 Workbook workbook1 = null;
        	 Workbook workbook2 = null;
        	 String lab = null;
             String lab1 = null;
             String lab2 = null;
             showArea.setText("恭喜你 中奖了！ "+"(*^__^*) ……"+"\n\r"+"\n\r") ;
			try {
				workbook1 = Workbook.getWorkbook(new File("E:\\j1.xls"));
			} catch (BiffException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
            Sheet sheet1[] = workbook1.getSheets();
            int a=0;
            	for(int m1=0; m1<15; m1++){
            		int i = sheet1[a].getRows();
                	int m = sheet1[a].getColumns();
                	int result  = (int)(Math.random()*i+1);
            	 for(int j=0;j<sheet1[a].getColumns();j++){
                    lab = sheet1[a].getCell(j,result ).getContents();
                    showArea.setLineWrap(true);// 设置文本区的换行策略。
                    if(j==0){
                    	showArea.append((m1+1)+":"  );
                    }
                    	showArea.append(lab + " ");
                    showArea.setFont(new Font("宋体", Font.BOLD, 26)); 
                 }
            	 showArea.append("\n\r");
            	}
            }
        }
    class ButtonClickAction2 implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		Workbook workbook2 = null;
    		String lab = null;
    		String lab2 = null;
    		showArea.setText("恭喜你 中奖了！ "+"(*^__^*) ……"+"\n\r"+"\n\r") ;
    		try {
    			workbook2 = Workbook.getWorkbook(new File("E:\\j2.xls"));
    		} catch (BiffException | IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    		Sheet sheet2[] = workbook2.getSheets();
    		int a=0;
    		for(int m1=0; m1<15; m1++){
    			int i = sheet2[a].getRows();
    			int m = sheet2[a].getColumns();
    			int result  = (int)(Math.random()*i+1);
    			for(int j=0;j<sheet2[a].getColumns();j++){
    				lab = sheet2[a].getCell(j,result ).getContents();
    				showArea.setLineWrap(true);// 设置文本区的换行策略。
    				if(j==0){
    					showArea.append((m1+1)+":"  );
    				}
    				showArea.append(lab + " ");
    				showArea.setFont(new Font("宋体", Font.BOLD, 26)); 
    			}
    			showArea.append("\n\r");
    		}
    	}
    }
    }
