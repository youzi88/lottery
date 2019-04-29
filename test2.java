/*
代码块
1、普通代码块，
2、构造块，在类中定义的代码块、在创建对象时被调用，优于构造方法执行
3、在类中使用satatic声明的代码块称为静态代码块
	在第一次使用的时候被调用，只会执行一次，优于构造块执行
	我们在项目开发中，通常会使用静态代码块来初始化只调用一次的数据。比如说：
*/
import java.util.Arrays;
public class test2{
	public static void main(String[] args){
		ChickenManager cm=new ChickenManager(5);
		cm.add(new Chicken(1,"小小",10));
		cm.add(new Chicken(1,"小一",10));
		cm.add(new Chicken(1,"小二",10));
		cm.add(new Chicken(1,"小三",10));
		cm.add(new Chicken(1,"小四",10));
		cm.add(new Chicken(1,"小五",10));
		
		System.out.println("数组的长度"+cm.length());
		System.out.println("......printAll.....");
		cm.printAll();
		System.out.println("......find.....");
		Chicken c=cm.find(5);
		c.print();
		
		System.out.println(".....update....");
		cm.update(new Chicken(1,"下蛋公鸡",20));
	}
}
class ChickenManager{
	private Chicken[] cs=null;
	private int count=0;//记录当前数组的元素个数
	
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
	//添加动态数组
	public void add(Chicken c){
		if(count>=cs.length){//数组已满，需要扩充
			//算法1：扩充原来数组大小的一半cs.length*3/2+1
			//算法2：扩充原来数组大小的一倍cs.length*2
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
				//找到要删除的对象，把该对象之后的对象向前移动一位
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
//小鸡类(数据类型)
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
		System.out.println("id+"+id+",   name="+name+"，  age="+age);
	}
}