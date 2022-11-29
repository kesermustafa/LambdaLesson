import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Practice02 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");

        System.out.println("ilkHarfBykSirala(list) = " + ilkHarfBykSirala(list));
        ilkHarfBykSirala1(list);
        System.out.println("\n------------------");
        System.out.println("ilkHarfecList(list) = " + ilkHarfecList(list));

        basVeSonYildizEkle(list);
        System.out.println("\n------------------");
        System.out.println("eOlanList(list) = " + eOlanList(list));

        System.out.println("\n------------------");
        System.out.println("tumlsil(list) = " + tumlsil(list));

        el2siralaIlk5KrkSayiniYaz(list);




    }

    //S1: list elemanlarını ilk harf buyuk gerisi kucuk sekılde listeleyelim

    public static List<String> ilkHarfBykSirala(List<String> list){
        return
        list.stream().
                map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).
                collect(Collectors.toList());
    }

    public static void ilkHarfBykSirala1(List<String> list){
                list.stream().
                        map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).
                        forEach(Lambda01::yazdir);
    }

    // S2: ilk harfi e ve ya c olanlari listeleyelim
    public static List<String> ilkHarfecList(List<String> list){
        return
        list.stream().filter(t->t.toLowerCase().startsWith("e") || t.toLowerCase().startsWith("c")).
                collect(Collectors.toList());
    }

    //S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim

    public static void basVeSonYildizEkle(List<String> list){
        list.
                stream().
                map(t-> "*"+t+"*").
                forEach(Utils::yazString);
    }

    //S4 : icinde e olanlardan yeni bir list olusturunuz
    public static List<String> eOlanList(List<String> list){
        return
                list.stream().filter(t->t.toLowerCase().contains("e")).
                        collect(Collectors.toList());
    }

    //S5: tum 'l' leri silelim yazdiralim
    public static List<String> tumlsil(List<String> list){
        return
                list.stream().map(t->t.replaceAll("l", "")).
                        collect(Collectors.toList());
    }

    //S6: List elemanarını 2.harfe gore sıralayıp
    //ilk 5 elemandan char sayısı en buyuk elemanı print
    public static void el2siralaIlk5KrkSayiniYaz(List<String> list){
        System.out.println(list.stream().
                sorted(Comparator.comparing(t -> t.charAt(1))).limit(5).
                sorted(Comparator.comparing(String::length).reversed()).
                findFirst()); // akistan gelen ilk elemani aldik....
    }




}
