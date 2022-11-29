import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList( "trilece", "havucDilim", "guvec", "kokorec","küşleme","arabAşi","waffle","künefe", "guvec" ));

        alfabetikSirala(menu);
        System.out.println("\n-----------------------");

        krkSayisiTersSiraliPrint(menu);
        System.out.println("\n-----------------------");
        krkSayisiSiraliPrint1(menu);
        System.out.println("\n-----------------------");
        harfSayisi7denAzKontrol(menu);

        wIlebaslayan(menu);
        xIlebitenn(menu);

        krkSayisiEnBykEleman(menu);
        sonHarfSiralaIlkHaricKalaniYazdir(menu);


    }

    // Task - 1 : List elemanlarini alfabetik buyuk harf ve tekrarsiz print ediniz..
    public static void alfabetikSirala(List<String> menu){
        menu.
                stream().           // akis basladi
                map(String::toUpperCase).   // Muyuk harf cevirdik akisi gundelledik
                sorted().           // dogal silama yapti
                distinct().        // Tekrarsiz eleman verir.
                forEach(t-> System.out.print(t+" "));  // print
    }


    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    public static void krkSayisiTersSiraliPrint(List<String> menu){
        menu.
                stream().               // akis basladi
                map(String::length).    // kelime uzunluklari alarak akisi guncelledi....
                sorted(Comparator.reverseOrder()).  // ters cevir
                distinct().                 // tekrarsiz..
                forEach(t-> System.out.print(t+" "));   //print
    }

    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void krkSayisiSiraliPrint1(List<String> menu){
        menu.
                stream().               // akis basladi
                sorted(Comparator.comparing(String::length)).  // sirali
                forEach(Lambda01::yazdir);   //print
    }



    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    // Task-4 : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKontrol(List<String> menu){
        System.out.println(menu.
                stream().
                allMatch(t -> t.length() <= 7) ? "List elemanlari 7 ve daha az harften olusuyor" :
                "List elemanlari 7 harften buyuk");
    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIlebaslayan(List<String> menu){
        System.out.println(menu.
                stream().
                noneMatch(t-> t.startsWith("w")) ? "w ile yemek ismimi olur" :
                "w ile yemek icat ettik");
    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIlebitenn(List<String> menu){
        System.out.println(menu.
                stream().
                anyMatch(t-> t.endsWith("x")) ? "x ile biten var" :
                "x ile biten yok");
    }

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void krkSayisiEnBykEleman(List<String> menu){
      Stream<String> sonIsim = menu.stream().
                sorted(Comparator.comparing(t->t.toString().length()).
                reversed()).  // katakter sayisina gore tersden siraladi.
                limit(1);  // limit methodu kullanilarak ilk eleman cagrildi...
        System.out.println(Arrays.toString(sonIsim.toArray()));
    }

    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void sonHarfSiralaIlkHaricKalaniYazdir(List<String> menu){
        menu.stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
                skip(1).     // ilk eleman haric tut
                forEach(Lambda01::yazdir);
    }




}
