import java.util.*;
class Patient{String name;double fee;Patient(String n,double f){name=n;fee=f;}}
public class HospitalBilling{
 static double finalAmount(double f){return f-(f>=2000?f*.10:f*.05);}
 public static void main(String[] args){Scanner sc=new Scanner(System.in);Patient[] p=new Patient[5];
 for(int i=0;i<5;i++)p[i]=new Patient(sc.next(),sc.nextDouble());
 for(Patient x:p)System.out.println(x.name+" "+x.fee+" "+finalAmount(x.fee));
 }
}