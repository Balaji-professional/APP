import java.util.*;
class Product {
    int id, quantity;
    String name;
    double price;
    Product(int id,String name,double price,int quantity){this.id=id;this.name=name;this.price=price;this.quantity=quantity;}
}
public class ProductBilling {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Product[] p=new Product[5];
        for(int i=0;i<5;i++){
            p[i]=new Product(sc.nextInt(),sc.next(),sc.nextDouble(),sc.nextInt());
        }
        for(Product x:p){
            double total=x.price*x.quantity;
            double discount= total>=5000?total*0.10:total*0.05;
            System.out.println(x.id+" "+x.name+" Total: "+total+" Discount: "+discount+" Final: "+(total-discount));
        }
    }
}