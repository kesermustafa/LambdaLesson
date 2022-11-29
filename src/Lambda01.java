import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {
/*
      1)  Lambda --> method create  etme değil mevcut method'ları(library) secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.
      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir
          ancak "map"'lerde kullanılmaz.
*/

     List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printElStructured(sayi);
        System.out.println("\n*--------------------*");
        printElFunctioal(sayi);
        System.out.println("\n*--------------------*");
        printElFunctioal1(sayi);
        System.out.println("\n*--------------------*");
        printElFunctioal2(sayi);
        System.out.println("\n*--------------------*");
        printCiftElFunctional(sayi);
        System.out.println("\n*--------------------*");
        printCiftElStructured(sayi);
        System.out.println("\n*--------------------*");
        printCiftOtucKckFunctional1(sayi);
        System.out.println("\n*--------------------*");
        printCiftVeyaOtucBykFunctional(sayi);

        System.out.println("\n*-----********---------------*");
        System.out.println("\n*--------------------*");
        printCiftElFunctional1(sayi);
    }


    //TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElStructured( List<Integer> sayi){
        for(Integer w : sayi){
            System.out.print(w + " ");
        }
    }

    //TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElFunctioal( List<Integer> sayi){
        sayi.
                stream().
                forEach((w) -> System.out.print(w + " ")); // lambda expression
    }


    public static void printElFunctioal1( List<Integer> sayi){
        sayi.
                stream().
                forEach(System.out::print); // metod referans   342216113520632165446664813815
    }

    public static void yazdir(int a){
        System.out.print(a + " ");
    }

    public static void yazdir(String a){
        System.out.print(a + " ");
    }

    public static void printElFunctioal2( List<Integer> sayi){
        sayi.
                stream().
                forEach(Lambda01::yazdir); // metod referans  34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
    }


    //TASK  : functional Programming ile list elemanlarinin cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(w -> w%2 == 0).
                forEach(Lambda01::yazdir);
    }

    // yukaridaki task'i filter() kismini ,ethod referance ile yapalim

    public static boolean ciftBul(int a){
        return a%2 == 0;
    }

    public static void printCiftElFunctional1(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).  // method referance
                forEach(Lambda01::yazdir);
    }



    //TASK  : Structured Programming ile list elemanlarinin cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElStructured(List<Integer> sayi){

        for (Integer w : sayi){
            if(w%2 == 0){
                System.out.print(w + " ");
            }
        }
    }


    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftOtucKckFunctional1(List<Integer> sayi){
        sayi.
                stream().
                filter(w -> w<34 && w % 2 == 0).
                forEach(Lambda01::yazdir);
    }



    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftVeyaOtucBykFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(w -> w>34 || w % 2 == 0).
                forEach(Lambda01::yazdir);
    }






}
