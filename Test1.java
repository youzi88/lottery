/*双色球游戏
1用户选择机选还是手选
2接收用户选号（红，蓝）
3生成系统号码（红，蓝）
4比较系统号码和用户号码
5验证是否中奖
6系统号码排序
7公布结果
*/
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class Test1{
	public static void main(String[] args){
		//?定义相关变量
		int[] userRedBall=new int[6];//user's red ball;
		int[] sysRedBall=new int [6];//system's red ball;
		int userBlueBall=0;//user's blue ball
		int sysBlueBall=0;//system's blue ball;
		int redCount=0;//user's red ball right count
		int blueCount=0;//user's blue ball right count
		int[] redBall=new int[33];
		//Random six num from(1-33) not same with each other
		for(int i=0;i<redBall.length;i++){
			redBall[i]=i+1;
		}
		//Ready go!!游戏开始
		System.out.println("徐丹牌双色球，good luck!");
		System.out.println("请选择机选还是手选,(1:机选,2:手选)");
		
		Scanner input=new Scanner(System.in);
		Random r = new Random();
		boolean flag=true;//????????????1
		while(flag){
			int isAuto=input.nextInt();
			switch(isAuto){
				
				case 1:
					//	computerselection
					computerSelection(redBall,userRedBall);//computer redball
					userBlueBall=r.nextInt(16)+1;//computer blueball
					flag=false;
					break;
				case 2:
					//handselextion
					System.out.println("红球号码(1-33):");
					for(int i=0;i<userRedBall.length;i++){
						userRedBall[i]=input.nextInt();
					}
					System.out.println("蓝球号码(1-16):");
					userBlueBall=input.nextInt();
					
					flag=false;
					break;
				default:
					System.out.println("请选择机选还是手选,(1:机选,2:手选)");
					break;
			}
		}
		//调用computerselection函数,
		//red ball
		computerSelection(redBall,sysRedBall);
		//blue ball
		sysBlueBall=r.nextInt(16)+1;
		
		//????
		//????
		for(int i=1;i<userRedBall.length-redCount;i++){
			for(int j=0;j<sysRedBall.length;j++){
				if(userRedBall[i]==sysRedBall[j]){
					int temp=sysRedBall[j];
					sysRedBall[j]=sysRedBall[sysRedBall.length-1-redCount];
					sysRedBall[sysRedBall.length-1-redCount]=temp;
					redCount++;
					break;
				}
			}
		}
		//count blue  ball
		if(userBlueBall==sysBlueBall){
			blueCount=1;
			
		}
		//open price
		if(blueCount==0&&redCount<=3){
			System.out.println("徐丹大笨蛋没有中奖,再接再厉!");
		}else if(blueCount==1&&redCount<3){
			System.out.println("六等奖,5块钱!");	
		}else if(blueCount==1&&redCount==3||(blueCount==0&&redCount==4)){
			System.out.println("五等奖,10块钱!");
		}else if(blueCount==1&&redCount==4||(blueCount==0&&redCount==5)){
			System.out.println("四等奖,1000块钱!");
		}else if(blueCount==1&&redCount==5){
			System.out.println("三等奖,10000块钱!");
		}else if(blueCount==0&&redCount==6){
			System.out.println("二等奖,10000块钱!");
		}else if(blueCount==1&&redCount==6){
			System.out.println("一等奖,1000000块钱!");
		}else{
			System.out.println("买徐丹牌双色球,徐丹大傻子!");
		}//公布系统号码
		System.out.println("本期中奖红球号码:"+sysRedBall);
		sort(sysRedBall);
		System.out.println(Arrays.toString(sysRedBall));
		System.out.println("本期中奖蓝球号码:"+sysBlueBall);
		
		//??????
		System.out.println("您选择的红球是:"+userRedBall);
		sort(userRedBall);
		System.out.println(Arrays.toString(sysRedBall));
		System.out.println("您选择的蓝球是:"+userBlueBall);
		System.out.println("徐丹大宝贝,中奖无效!");
	}//冒泡排序
	public static void sort(int[] ball){
		for(int i=0;i<ball.length-1;i++){
			for(int j=0;j<ball.length-1;j++){
				if(ball[j]>ball[j+1]){
					ball[j]=ball[j]+ball[j+1];
					ball[j+1]=ball[j]-ball[j+1];
					ball[j]=ball[j]-ball[j+1];
				}
			}
		}
	}
	
	//机选
	public static void computerSelection(int[] redBall,int[] userRedBall){
		Random r = new Random();
		int index = -1;
		for(int i=0;i<userRedBall.length;i++){
			index = r.nextInt(redBall.length-i);  //Random number
			userRedBall[i]=redBall[index];
			
			int temp = redBall[index];
			redBall[index] = redBall[redBall.length-1-i];
			redBall[redBall.length-1-i]=temp;
		}
	}
	
}
