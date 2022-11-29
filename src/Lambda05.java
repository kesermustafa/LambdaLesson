import java.util.Scanner;
import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {


        System.out.println("topla(5) = " + topla(5));
        System.out.println("toplaCincix = " + toplaCincix(5));
        System.out.println("toplaCiftIse = " + toplaCiftIse(6));
        System.out.println("toplaIlkxCiftSayi(6) = " + toplaIlkxCiftSayi(6));
        System.out.println("toplaIlkXCiftSayi(4) = " + toplaIlkXCiftSayi(4));
        System.out.println("toplaIlkXTekSayi(4) = " + toplaIlkXTekSayi(4));
        ikiIlkXKuvvetiYazdir(5);
        System.out.println();
        istenilenSayiXKuvveti(3, 2);
        System.out.println();
        System.out.println("istenenSayiFaktoriyel(5) = " + istenenSayiFaktoriyel(5));
    }

        //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
        // tamsayilari toplayan bir program create ediniz.
    public static int topla(int x){  //Structured ile cozum
        int toplam =0;
        for (int i =0; i<=x; i++){
            toplam += i;
        }
        return toplam;
    }

        //Functional ile cozum
    public static int toplaCincix(int x){
        return IntStream.           // int degerine akis saglar...
                range(1, x+1).       // a'dan b'ye kadar int degerler akisa alindi.
                sum();              // akistan gelen degerler toplandi..
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCiftIse(int x){
        return IntStream.
                rangeClosed(1, x).
                filter(Lambda01::ciftBul).
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaIlkxCiftSayi(int x){
        return IntStream.
                range(1, x * 2).
                filter(Lambda01::ciftBul).
                sum();
    }

    public static int toplaIlkXCiftSayi(int x){
        return IntStream.
                iterate(2, t->t+2).  // 2 den sonsuza kadar elemanlari artirarak akisa alir. : 2,4,6,8,.......>>
                limit(x).    // x ile sinirliyorummm
                sum();          // akistan x'e kadar gelen degerleri topla
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int toplaIlkXTekSayi(int x){
        return IntStream.
                iterate(1, t->t+2).  // // 1 den sonsuza kadar elemanlari artirarak akisa alir. : 1,3,5,7,.......>>
                        limit(x).
                        sum();
    }

    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikiIlkXKuvvetiYazdir(int x){
        IntStream.
                iterate(2, t->t*2).  // // 1 den sonsuza kadar elemanlari artirarak akisa alir. : 1,3,5,7,.......>>
                limit(x).
                forEach(Lambda01::yazdir);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi create ediniz.
    public static void istenilenSayiXKuvveti(int istenenSayi, int y){
        IntStream.
                iterate(istenenSayi, t->t*istenenSayi).
                limit(y).
                forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
        public static int istenenSayiFaktoriyel(int x){
       return IntStream.
               rangeClosed(1, x).     // 1,2,3,4,5   akis bu hale geldiiii
               reduce(1, (t,u)->t*u);
    }






}
