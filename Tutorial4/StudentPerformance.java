import java.util.*;
class Student{
 int roll; String name; int[] marks; double att;
 Student(int r,String n,int[] m,double a){roll=r;name=n;marks=m;att=a;}
}
public class StudentPerformance{
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in); Student[] s=new Student[5];
  for(int i=0;i<5;i++){int[] m={sc.nextInt(),sc.nextInt(),sc.nextInt()};s[i]=new Student(sc.nextInt(),sc.next(),m,sc.nextDouble());}
  double high=0; String top="";
  for(Student x:s){int total=0;for(int m:x.marks)total+=m;double avg=total/3.0;
   if(avg>high){high=avg;top=x.name;}
   System.out.println(x.name+" "+(avg>=50?"Pass":"Fail")+" "+(avg>=75&&x.att>=80?"Eligible":"Not Eligible")+" "+(avg>=85?"Excellent":"Good"));}
  System.out.println("Highest Average: "+top);
 }
}