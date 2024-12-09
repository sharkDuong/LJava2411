package buoi6;

public class ho extends Animal {
    private String loaiThit;

    public  void sanMoi(){
        System.out.println("ho san moi");
    }

    @Override
    public void diChuyen() {
        System.out.println("HO di chuyen nhanh");
    }
}
