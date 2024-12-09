package buoi6;

public class main {
    public static void main(String[] args) {
     voi voi = new voi();
     voi.diChuyen();

     ho ho = new ho();
     ho.diChuyen();
     //khoi tao doi tuong con
     Animal animal = new voi();
     animal.diChuyen();
     Animal ho2 = new ho();
     if (ho2 instanceof  ho){
         ((ho) ho2).sanMoi();
     }
     ho2.diChuyen();
    }
}
