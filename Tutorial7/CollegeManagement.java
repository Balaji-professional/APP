class Student { String name; int id; Student(String n,int i){name=n;id=i;} void display(){System.out.println(name+" "+id);} }
class Course { String course; Course(String c){course=c;} void display(){System.out.println(course);} }
public class CollegeManagement { public static void main(String[] a){ Student s=new Student("Balaji",1); Course c=new Course("Java"); s.display(); c.display(); } }