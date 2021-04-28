package View;

public class Tabels {
    public static void tabel1(){                                    //afisarea tutror studentilor
        String sir="|Munte\t\t\t|Inaltime\t";
        String linii="==========================";
        System.out.println(linii);
        System.out.println(sir);
        System.out.println(linii);
    }

    public static void tabel2(long h){                                        //afisarea dupa o anumita inaltime
        String sir="|" + h +"\t\t\t|Munte\t";
        String linii="==========================";
        System.out.println(linii);
        System.out.println(sir);
        System.out.println(linii);
    }

    public static void tabel3(String n){                                        //afisarea dupa o anumita inaltime
        String sir="|" + n +"\t\t\t|Inaltime\t";
        String linii="==========================";
        System.out.println(linii);
        System.out.println(sir);
        System.out.println(linii);
    }

    public static void tabel4(){                                    //afisarea tutror studentilor
        String sir="|Munte\t\t\t|Inaltime|Procent din h max |";
        String linii="=============================================";
        System.out.println(linii);
        System.out.println(sir);
        System.out.println(linii);
    }
}
