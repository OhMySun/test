package sun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LifeGame {
	JFrame jf;//GUI组件
	boolean[][] stl;//存放细胞状态
	JPanel[][] jp;//显示细胞状态
	int[][] flog;//标记
	
	public LifeGame(int m,int n){
		//GUI组件初始化
		jf=new JFrame("Life Game");//GUI组件初始化
		stl=new boolean[m][n];
		jp=new JPanel[m][n];
		flog=new int[m][n];
		jf.setLayout(new GridLayout(m,n,2,2));
		for (int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				jp[i][j]=new JPanel();
				jp[i][j].setLayout(new GridLayout(m,n,2,2));
				jf.add(jp[i][j]);
			}
		}
		jf.setSize(1000, 1000);
		jf.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			});
		randomized();
		updata();
		jf.setVisible(true);
		
		}
	//随机生成活细胞
	public void randomized(){
		for(int i=1;i<stl.length-1;i++){
			for(int j=1;j<stl[i].length-1;j++){
				if(Math.random()>0.5){
					stl[i][j]=true;
				}else{
					stl[i][j]=false;
				}
			}
		}
	
	}
	
	/*public void generation(){
		for (int i=1;i<stl.length-1;i++){
			for(int j=1;j<stl[i].length-1;j++){
			int counter=0;
			if(jp[i-1][j-1].getBackground()==Color.BLUE){
				counter++;
			}
			if(jp[i-1][j].getBackground()==Color.BLUE){
				counter++;
			}
			if(jp[i-1][j+1].getBackground()==Color.BLUE){
				counter++;
			}
			if(jp[i][j-1].getBackground()==Color.BLUE){
				counter++;
			}
			if(jp[i][j+1].getBackground()==Color.BLUE){
				counter++;
			}
			if(jp[i+1][j-1].getBackground()==Color.BLUE){
				counter++;
			}
			if(jp[i+1][j].getBackground()==Color.BLUE){
				counter++;
			}
			if(jp[i+1][j+1].getBackground()==Color.BLUE){
				counter++;
			}
			if(jp[i][j].getBackground()==Color.BLUE){
				if(counter<=1){
					stl[i][j]=false;
				}else if(counter>3){
					stl[i][j]=false;
				}
			}else{
				if(counter==3){
					stl[i][j]=true;
				}
				}
			}
		}
	}*/
	public void generation(){
	int counter=0;
	for (int i=1;i<stl.length-1;i++){
		for(int j=1;j<stl[i].length-1;j++){
		counter=flog[i-1][j-1]+flog[i-1][j]+flog[i-1][j+1]+flog[i][j-1]+flog[i][j+1]+flog[i+1][j-1]+flog[i+1][j]+flog[i+1][j+1];
		if(jp[i][j].getBackground()==Color.BLUE){
			if(counter<=1){
				stl[i][j]=false;
			}else if(counter>3){
				stl[i][j]=false;
			}
		}else{
			if(counter==3){
				stl[i][j]=true;
			   }
			 }
		 }
	   }
    }
	public void updata(){
		for(int i=1;i<stl.length-1;i++){
			for(int j=1;j<stl[i].length-1;j++){
				if(stl[i][j]){
					jp[i][j].setBackground(Color.BLUE);
					flog[i][j]=1;
				}else{
					jp[i][j].setBackground(Color.WHITE);
					flog[i][j]=0;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//创建游戏对象
		LifeGame lg=new LifeGame(8,8);
		lg.randomized();//进行初始化
		lg.updata();//显示更新
		while(true){
			//取得下一代
			lg.generation();
			try{
				Thread.sleep(100);
			}catch(Exception e){
				e.printStackTrace();
		    }
		//显示更新
		lg.updata();

	}
	}

}
