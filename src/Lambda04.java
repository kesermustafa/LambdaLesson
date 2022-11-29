import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

        /*
        TASK :
        fields --> Universite (String)
                   bolum (String)
                   ogrcSayisi (int)
                   notOrt (int)
                   olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */

    public static void main(String[] args) {

        Universite u01 = new Universite("Bogazici", "Matematik", 571, 93);
        Universite u02 = new Universite("Istanbul Tk", "Matematik", 600, 81);
        Universite u03 = new Universite("Istanbul", "Hukuk", 1400, 71);
        Universite u04 = new Universite("Marmara", "Bilgisayar Muh.", 1080, 77);
        Universite u05 = new Universite("Odtu", "Gemi Muh.", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));


        System.out.println(unv);

        System.out.println(notOrt74BykUnv(unv));
        System.out.println(matBolumVarMi(unv));
        System.out.println(ogrSayisiBykSirala(unv));
        System.out.println("matematikBolumu(unv) = " + matematikBolumu(unv));
        System.out.println("ogrnSayisi550FazlaEnBykNot() = " + ogrnSayisi550FazlaEnBykNot(unv));

        System.out.println("ogrnSayisi550FazlaEnKckNot() = " + ogrnSayisi1050FazlaEnKckNot(unv));


    }

    //task 01--> butun universitelerin notOrt'larinin 74' den buyuk oldgunu kontrol eden pr create ediniz.

        public static boolean notOrt74BykUnv(List<Universite> unv){

        return unv.
                stream().
                allMatch(t-> t.getNotOrt()>74);
        }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarMi(List<Universite> unv){

        return unv.
                stream().
                anyMatch(t-> t.getBolum().// objelerin bolum isimleri alindi
                        toLowerCase(). // bolum isimlerindeki karakterler kucuk harfer cevrildi
                        contains("matematik")); // mat kelimesi var mi kontrol
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayisiBykSirala(List<Universite> unv){

        return unv.stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi).
                        reversed()).
                collect(Collectors.toList());
    }

    // task matematik bolumlerinin sayisini print ediniz..


    public static int matematikBolumu(List<Universite> unv){

      return (int) unv.
              stream().
              filter(t->t.getBolum().equalsIgnoreCase("matematik")).
              count();
    }


    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrnSayisi550FazlaEnBykNot(List<Universite> unv){
         return unv.
                stream().
                filter(t->t.getOgrSayisi()>550).
                   mapToInt(t->t.getNotOrt()).
                   max();
    }

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrnSayisi1050FazlaEnKckNot(List<Universite> unv){
        return unv.
                stream().
                filter(t->t.getOgrSayisi()<1050).
                mapToInt(t->t.getNotOrt()).
                min();
    }



}
