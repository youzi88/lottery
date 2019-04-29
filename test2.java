/*
�����
1����ͨ����飬
2������飬�����ж���Ĵ���顢�ڴ�������ʱ�����ã����ڹ��췽��ִ��
3��������ʹ��satatic�����Ĵ�����Ϊ��̬�����
	�ڵ�һ��ʹ�õ�ʱ�򱻵��ã�ֻ��ִ��һ�Σ����ڹ����ִ��
	��������Ŀ�����У�ͨ����ʹ�þ�̬���������ʼ��ֻ����һ�ε����ݡ�����˵��
*/
import java.util.Arrays;
public class test2{
	public static void main(String[] args){
		ChickenManager cm=new ChickenManager(5);
		cm.add(new Chicken(1,"СС",10));
		cm.add(new Chicken(1,"Сһ",10));
		cm.add(new Chicken(1,"С��",10));
		cm.add(new Chicken(1,"С��",10));
		cm.add(new Chicken(1,"С��",10));
		cm.add(new Chicken(1,"С��",10));
		
		System.out.println("����ĳ���"+cm.length());
		System.out.println("......printAll.....");
		cm.printAll();
		System.out.println("......find.....");
		Chicken c=cm.find(5);
		c.print();
		
		System.out.println(".....update....");
		cm.update(new Chicken(1,"�µ�����",20));
	}
}
class ChickenManager{
	private Chicken[] cs=null;
	private int count=0;//��¼��ǰ�����Ԫ�ظ���
	
	public ChickenManager(int size){
		if(size>0){
			cs=new Chicken[size];
		}else{
			cs=new Chicken[5];
		}
	}
	public int length(){
		return cs.length;
	}
	//��Ӷ�̬����
	public void add(Chicken c){
		if(count>=cs.length){//������������Ҫ����
			//�㷨1������ԭ�������С��һ��cs.length*3/2+1
			//�㷨2������ԭ�������С��һ��cs.length*2
			int newLen=cs.length*2;
			cs=Arrays.copyOf(cs,newLen);
		}else{
			cs[count]=c;
			count++;
		}
	}
	public void delete(){
		for(int i=0;i<count;i++){
			if(cs[i].getid()==id){
				//�ҵ�Ҫɾ���Ķ��󣬰Ѹö���֮��Ķ�����ǰ�ƶ�һλ
				for(int j=i;j<count-1;j++){
					cs[j]=cs[j+1];
				}
				cs[count-1]=null;
				count--;
					break;
			}
		}
	}
	public void update(Chicken c){
		Chicken temp=find(c.getId());
		if(temp!=null){
			temp.setName(c.getName());
			temp.setAge(c.getAge());
		}
	}
	public Chicken find(int id){
		for(int i=0;i<count;i++){
			if(cs[i].getId()==id){
				return cs[i];
			}
		}
		return null;
	}
	public void printAll(){
		for(int i=0;i<count;i++){
			cs[i].print();
		}
	}
}
//С����(��������)
class Chicken{
	private int id;
	private String name;
	private int age;
	public Chicken(){}
	public Chicken(int id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void getName(String name){
		this.name=name;
}	
	public String getName(){
		return name;
}
	public void setAge(int age){
		this.age=age;
}
	public void print(){
		System.out.println("id+"+id+",   name="+name+"��  age="+age);
	}
}