package View;
import Domain.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Display {
    //citire------------------------------------------------------------------------------------------------------------
    public static String readString(String sir){	             //pentru citire unui sir de caractere
        try{									                //adica pentru citirea nume
            System.out.print(sir);
            Scanner S= new Scanner(System.in);
            return S.nextLine();
        }
        catch(Exception E){
            System.out.println("Ai gresit, mai incearca");
            return readString(sir);
        }}

    public static long readLong(String sir) {                 //metoda de citire de la tastaura a unui numar intreg
        System.out.print(sir);
        try {                                               //try pt. prinderea unor erori
            Scanner scn = new Scanner(System.in);
            long intregL = scn.nextLong();
            return intregL;

        } catch (Exception exp) {
            System.out.println("ai gresit!!, da numar intreg");
            return readLong(sir);                        //apel recursiv pt. orice eroare
        }

    }

    public static Mountain[] readFromFile(){
        int n;								//numarul de linii din fisier
        Mountain m[]=null;					//declarare tablou de tip Munte

        try { BufferedReader fileIn =
                new BufferedReader(new FileReader("D:\\Info\\MAP\\Laborator\\lab3\\Laborator3-munte\\src\\Mountain.txt"));
            String s;
            s=fileIn.readLine();
            n=Integer.parseInt(s);
            m = new Mountain[n];				                //aloca n referinte pentru fiecare

            //System.out.println("n="+m.length);
            int i=0;							                //contor al tabloului m
            while((s = fileIn.readLine())!= null){
                String felii[]=s.split(",");
                String name=felii[0];
                long height=Long.parseLong(felii[1]);
                m[i]=new Mountain(name,height);                 //alocarea efectiva pentru comp. m
                i++;
            }
            //System.out.println("lungimea tabelului="+m.length);
            fileIn.close();

        } // try
        catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } // catch //citiri valorile vectorului
        return m;
    }

    public static Mountain[] readKeyboard()
    {
        Mountain m[]=null;					//declarare tablou de tip Munte
        System.out.println("Dati muntii si inaltimile (munte,inaltime,): ");
        Scanner scn = new Scanner(System.in);
        String sir;                                     //declar sirul care reprezinta muntii si inaltimile
        sir = scn.nextLine();
        String[] linie = sir.split(",");       //in linie se afla muntii si inaltimile

        m = new Mountain[linie.length/2];
        int index = 0;
        for(int i=0;i< linie.length ;i=i+2)
        {
            Mountain M = new Mountain(linie[i], Long.parseLong(linie[i+1]));
            m[index++] = M;
        }
        return m;
    }


    //afisare------------------------------------------------------------------------------------------------------------
    public static void showAll(Mountain[] m) {                                              //afisarea tuturor studentilor
        Tabels.tabel1();
        int i = 0;                                                                          // print("|%-10s|%-13s|%6d|" %(nume,materie,nota))
                                                                                            // in python
        while (i < m.length) {
            System.out.format("|%-15s|%8d|\n", m[i].getName(), m[i].getHeight());           //afisare formatata
            i++; } }

    public static void showByHeight(Mountain[] m) {                                         //caut munti dupa h
        long h = readLong("Dati inaltimea muntelui pe care il cautati: ");
        int nr=0;                                                                             //numar cati munti au inaltimea h
        for (Mountain mountain : m)
            if (mountain.getHeight() == h) {
                nr++;
                if(nr==1)
                    Tabels.tabel2(h);
                System.out.format("|%30s|\n", mountain.getName());
            }
        if(nr==0)
            System.out.println("Nu exista munti cu aceasta inaltime!");
    }

    public static void showByName(Mountain[] m) {                                         //caut munti dupa h
        String n = readString("Dati numele muntilor pe care ii cautati: ");
        int nr=0;                                                                         //numar cati munti au numele n
        for (Mountain mountain : m)
            if (mountain.getName().indexOf(n)>=0 && mountain.getName().indexOf(n)<=mountain.getName().length()) {
                nr++;
                if(nr==1)
                    Tabels.tabel3(n);
                System.out.format("|%-15s|%8d|\n", mountain.getName(),mountain.getHeight());
            }
        if(nr==0)
            System.out.println("Nu exista munti cu aceast nume!");
    }

    public static void showAlphabeticalSort(Mountain[] m) {
        Domain.Sort.alphabeticSort(m);
        showAll(m); }

    public static void showSortByHeght(Mountain[] m){
        Domain.Sort.sortByHeight(m);
        showAll(m); }
    //procentaj--------------------------------------------------------------------------------------------------------
     public static void showByPercent(Mountain[] m)
     {
        showAlphabeticalSort(m);                                //afisarea tabelului cu procente va fi afisat in
                                                                // ordine alfabetica

         Tabels.tabel4();
         double maxH = maxHeight(m);
         for(Mountain mountain:m)
        {
            double percent = mountain.getHeight() * (100/maxH);
            double finalPercent=(int)(percent*100);
            finalPercent=finalPercent/100.0;
            System.out.format("|%-15s|%8d|%18.2f|\n", mountain.getName(), mountain.getHeight(),finalPercent);
        }
         System.out.println("=============================================");
         System.out.println("| Inaltimea maxima = "+ (int)maxH + "                   |");

         System.out.println("=============================================");

     }

    public static long maxHeight(Mountain[] m)
    {
        long maxh=0;
        for(Mountain M:m) {
            if(M.getHeight()>maxh)
                maxh = M.getHeight();
        }
        return maxh;
    }


    //meniu-----------------------------------------------------------------------------------------------------------------
    public static long menu()
    {
        System.out.println();
        System.out.println("Meniu");
        System.out.println("1.Citire date din fisier");
        System.out.println("2.Citire date de la tastatura");
        System.out.println("3.Afisarea tuturor muntilor");
        System.out.println("4.Afisarea muntilor cu o inaltime data");
        System.out.println("5.Afisarea muntilor dupa un substring dat");
        System.out.println("6.Afisare alfabetica");
        System.out.println("7.Afisare descrescatoare dupa inaltime");
        System.out.println("8.Afisare procent din inaltimea maxima");
        System.out.println("0.Terminare program");
        return(readLong("da optiunea ta:"));
    }

}
