import java.util.*;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));


        ciftKarePrint(sayi);  // 16 4 36
        System.out.println("\n*---------------*");
        tekKupBirFazlaPrint(sayi);
        System.out.println("\n*---------------*");
        ciftKarekokPrint(sayi);
        System.out.println("\n*---------------*");
        maxElBul(sayi);
        System.out.println("\n*---------------*");
        structureMaxElBul(sayi);
        System.out.println("\n*---------------*");
        ciftKarekokMaxEl(sayi);

        elTopla(sayi);

        ciftElCarp(sayi);

        minElBul(sayi);

        besBuyukTekSayiBul(sayi);

        ciftElKareSorted(sayi);
    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi){

        sayi.
                stream().
                filter(Lambda01::ciftBul).  // akisdaki cift sayilari filtreledim..
                map(t -> t*t)               // 16, 4, 36 -- Stream icerisindeki baska degerlere donusturur.
                .forEach(Lambda01::yazdir); //

    }

    // Task 2: Functional Programming ile listin tek elemanlarinin kuplerinin bir fazlasini
    // ayni satirda aralarina bosluk birakarak print edi


    public static void tekKupBirFazlaPrint(List<Integer> sayi){

        sayi.                   // (4,2,6,11,-5,7,3,15)
                stream().
                filter(t-> t%2 != 0). // 11, -5, 7, 3, 15
                map(t -> (t*t*t)+1 ). // 1332 -124 344 28 3376
                forEach(Lambda01::yazdir); // ekrana yazddir....
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKarekokPrint(List<Integer> sayi){

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(t -> System.out.print(String.format("%.2f", t) + ", "));
    }

        // Task-4 : list'in en buyuk elemanini yazdiriniz

    public static void maxElBul(List<Integer> sayi) {
    //Optional ==> CompileTime'da java bunu tahmin ettiginde Java bunu zorlar. bunu onlemek icin optional yapisi geldi
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max); // eger benim result'im tek bir deger ise reduce() terminal operator kullanilir.
        System.out.println(maxSayi);
    }


    // Task-4 : list'in en buyuk elemanini yazdiriniz structure yapi ile cozelim

    public static void structureMaxElBul(List<Integer> sayi) {
        int max = Integer.MIN_VALUE;
        System.out.println("max = " + max);
        for (int i =0; i<sayi.size(); i++){
            if(sayi.get(i)>max) max=sayi.get(i);
        }
        System.out.println("en buyuk sayi : " + max);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftKarekokMaxEl(List<Integer> sayi){

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(a -> a * a).
                reduce(Integer::max)); // Math::max'a gore daha hizli calisir...
    }


    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

    public static void elTopla(List<Integer> sayi){

        int toplam = sayi.
                stream().
                reduce(0, (a,b) -> a+b);
        System.out.println(toplam);
    }

        /*
        * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
            bu örnekte 0 oluyor
        * b degerini her zamana  stream()'dan akısdan alır
        * a ilk degerinden sonraki her değeri action(işlem)'dan alır

        */

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftElCarp(List<Integer> sayi){

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact)); // method reference

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> a * b)); // Lambda expression
    }


    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    public static void minElBul(List<Integer> sayi) {

        // 1. yol
        System.out.println(sayi.
                stream().
                reduce(Integer::min)); // eger benim result'im tek bir deger ise reduce() terminal operator kullanilir.

        //2. yol
        System.out.println(sayi.
                stream().
                reduce(Lambda02::byMiracMin));
    }

    public static int byMiracMin(int a, int b){
        return a<b ? a : b;
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void besBuyukTekSayiBul(List<Integer> sayi){

        System.out.println(sayi.
                stream().
                filter(t -> t > 5 && t % 2 != 0).
                reduce(Lambda02::byMiracMin));
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.

    public static void ciftElKareSorted(List<Integer> sayi){

        sayi.stream().
                filter(Lambda01::ciftBul).
                map(t -> t*t).
                sorted().                   // sorted(Comparator.reverseOrder) buyukten kucuge siralar.
                forEach(Lambda01::yazdir);
    }








}
