package scr.lab9.example28_1;

public class example28_2 {
    public static void main(String[] args) {
        m(1);
    }

    public static void m(int x){

        if((2 * x + 1)< 20 ){
            m(2 * x + 1);
        }
        System.out.print("x=" + x + "\n");
    }
}