/*˫ɫ����Ϸ
1�û�ѡ���ѡ������ѡ
2�����û�ѡ�ţ��죬����
3����ϵͳ���루�죬����
4�Ƚ�ϵͳ������û�����
5��֤�Ƿ��н�
6ϵͳ��������
7�������
*/
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class Test1{
	public static void main(String[] args){
		//?������ر���
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
		//Ready go!!��Ϸ��ʼ
		System.out.println("�쵤��˫ɫ��good luck!");
		System.out.println("��ѡ���ѡ������ѡ,(1:��ѡ,2:��ѡ)");
		
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
					System.out.println("�������(1-33):");
					for(int i=0;i<userRedBall.length;i++){
						userRedBall[i]=input.nextInt();
					}
					System.out.println("�������(1-16):");
					userBlueBall=input.nextInt();
					
					flag=false;
					break;
				default:
					System.out.println("��ѡ���ѡ������ѡ,(1:��ѡ,2:��ѡ)");
					break;
			}
		}
		//����computerselection����,
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
			System.out.println("�쵤�󱿵�û���н�,�ٽ�����!");
		}else if(blueCount==1&&redCount<3){
			System.out.println("���Ƚ�,5��Ǯ!");	
		}else if(blueCount==1&&redCount==3||(blueCount==0&&redCount==4)){
			System.out.println("��Ƚ�,10��Ǯ!");
		}else if(blueCount==1&&redCount==4||(blueCount==0&&redCount==5)){
			System.out.println("�ĵȽ�,1000��Ǯ!");
		}else if(blueCount==1&&redCount==5){
			System.out.println("���Ƚ�,10000��Ǯ!");
		}else if(blueCount==0&&redCount==6){
			System.out.println("���Ƚ�,10000��Ǯ!");
		}else if(blueCount==1&&redCount==6){
			System.out.println("һ�Ƚ�,1000000��Ǯ!");
		}else{
			System.out.println("���쵤��˫ɫ��,�쵤��ɵ��!");
		}//����ϵͳ����
		System.out.println("�����н��������:"+sysRedBall);
		sort(sysRedBall);
		System.out.println(Arrays.toString(sysRedBall));
		System.out.println("�����н��������:"+sysBlueBall);
		
		//??????
		System.out.println("��ѡ��ĺ�����:"+userRedBall);
		sort(userRedBall);
		System.out.println(Arrays.toString(sysRedBall));
		System.out.println("��ѡ���������:"+userBlueBall);
		System.out.println("�쵤�󱦱�,�н���Ч!");
	}//ð������
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
	
	//��ѡ
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
