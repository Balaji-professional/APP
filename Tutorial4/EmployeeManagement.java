import java.util.*;
class Employee{int id;String name;double salary;Employee(int i,String n,double s){id=i;name=n;salary=s;}}
public class EmployeeManagement{
 public static void main(String[] args){Scanner sc=new Scanner(System.in);Employee[] e=new Employee[5];
 for(int i=0;i<5;i++)e[i]=new Employee(sc.nextInt(),sc.next(),sc.nextDouble());
 for(Employee x:e){double annual=x.salary*12;double bonus=x.salary>=30000?annual*.10:0;System.out.println(x.id+" "+x.name+" "+annual+" "+bonus);}
 }
}