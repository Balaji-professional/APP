class Ride{int no;String name;Ride(int n,String s){no=n;name=s;}}
public class RidePattern{
 public static void main(String[] args){Ride[] r={new Ride(1,"Roller Coaster"),new Ride(2,"Ferris Wheel"),new Ride(3,"Bumper Cars"),new Ride(4,"Water Ride"),new Ride(5,"Haunted House")};
  for(Ride x:r){System.out.print(x.name+" : ");for(int i=0;i<x.no;i++)System.out.print("*");System.out.println();}
 }
}