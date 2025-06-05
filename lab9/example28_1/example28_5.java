package scr.lab9.example28_1;

public class example28_5 {
    public static void main(String[] args) {
        System.out.println(fibbonachi(6));
    }

    public static int fibbonachi(int n){
        System.out.println("n =" + n + "->");
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return fibbonachi(n-2) + fibbonachi(n -1);
        }
    }
}
