package test;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import jxl.Sheet;
import jxl.Workbook;

public class test extends JFrame implements ActionListener {
	//��������ʼ���������
	private JButton jb1 = new JButton("01");
	private JButton jb2 = new JButton("02");
	private JTextArea jta = new JTextArea();
	
	//���幹�췽��
	public test(){
		launchFrame();
		jb1.addActionListener(this);
		jb2.addActionListener(this);
	}
	//������ط���
	private void  launchFrame(){
		JScrollPane jsp = new JScrollPane(jta);
		this.add(jsp);
		this.add(jb1,BorderLayout.SOUTH);
		this.add(jb2,BorderLayout.SOUTH);
		this.setTitle("��ҵ���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(150, 150, 600, 300);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			String results1="";
			for(int i=0;i<15;i++){
				int resultNum = (int)(Math.random()*100+1);//����һ�������
				String result=String.valueOf(resultNum);//�������ת����string����
				results1= results1+result+"\t";//��ӵ�����ַ����У��м���tab����
				results1+="\n \r";//����
				jta.append(results1);//�����׷�ӵ�jta��
			}
		if(e.getSource()==jb2){
				String results2="";
				for(int i=0;i<15;i++){
					int resultNum = (int)(Math.random()*100+1);//����һ�������
					String result=String.valueOf(resultNum);//�������ת����string����
					results2= results2+result+"\t";//��ӵ�����ַ����У��м���tab����\
					results2+="\n \r";//����
					jta.append(results2);//�����׷�ӵ�jta��
				}
		}
	}
  }
	public static void main(String[] args) throws Exception{
		new test();
        Workbook workbook1 = Workbook.getWorkbook(new File("E:\\j1.xls"));
        Workbook workbook2 = Workbook.getWorkbook(new File("E:\\j1.xls"));
        Sheet sheet1[] = workbook1.getSheets();
        Sheet sheet2[] = workbook2.getSheets();
        String lab = null;
        String lab1 = null;
        String lab2 = null;
        for(int a=0;a<sheet1.length;a++){
            for(int i=0;i<sheet1[a].getRows();i++){
                for(int j=0;j<sheet1[a].getColumns();j++){
                    lab = sheet1[a].getCell(j,i).getContents();
                       System.out.print(lab+"��");

                }
         System.out.println();
            }
        }
      /*   for(int a=0;a<sheet2.length;a++){
            for(int i=0;i<sheet2[a].getRows();i++){
                for(int j=0;j<sheet2[a].getColumns();j++){
                    lab2 = sheet2[a].getCell(j,i).getContents();
                    System.out.print(lab2+"��");
                }
                System.out.println();
            }
        } 
         */
    }
}
