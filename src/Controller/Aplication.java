package Controller;
import Domain.*;
import View.*;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Comparator;

import static Domain.Sort.*;
import static View.Tabels.tabel1;

public class Aplication {
    public static void testMountain()
    {
        Mountain m = new Mountain("Negoiu", 2535);
        Mountain m2 = new Mountain("Moldoveanu", 2544);
        Mountain m3 = new Mountain("Parangu; Mare",2518 );
        assert(m.getName().equals("Negoiu"));
        assert(m2.getHeight() == 2544);
        assert(m3.getHeight() == 2518);
        m3.setHeight(2519);
        assert(m3.getHeight() == 2519);
        assert(!m.compareName(m2));
        assert(m.compareName(m3));
        assert m2.compareName(m3);
        System.out.println("Test trecut!");
    }

    public static void testSort()
    {                                                           //teste pentru sortarile alfabetica si dupa inaltime
        Mountain[] m2 = new Mountain[4];
        m2[0] = new Mountain("Negoiu",2535);        //folosind bubble sort
        m2[1] = new Mountain("Moldoveanu",2544);
        m2[2] = new Mountain("Parangul Mare",2519); //si vector pentru a retine obiectele de tip munte
        m2[3] = new Mountain("Vistea Mare",2527);
        System.out.println("Lista initila:");
        for(int i=0;i< m2.length;i++)
            System.out.println(m2[i].getName() +" "+ m2[i].getHeight());
        sortByHeight(m2);
        System.out.println("Lista sortata dupa inaltime cu bubbleSort:");
        for(int i=0;i< m2.length;i++)
            System.out.println(m2[i].getName()+" "+ m2[i].getHeight());
        alphabeticSort(m2);
        System.out.println("Lista sortata alfabetic cu bubbleSort:");
        for(int i=0;i< m2.length;i++)
            System.out.println(m2[i].getName() +" "+ m2[i].getHeight());
        System.out.println("");


        ArrayList<Mountain> m = new ArrayList<>();                  //sortare cu comparator
        m.add(new Mountain("Negoiu",2535));             //si functie lambda
        m.add(new Mountain("Vistea Mare",2527));        //elemente salvate in array
        m.add(new Mountain("Moldoveanu",2544));
        System.out.println("Array initil:");
        for(int i=0;i<m.size();i++)                                 //nu merge inca
            System.out.println(m.get(i).getName() + " "+ m.get(i).getHeight());
        sortByHeightComp(m);
        System.out.println("Array sortat dupa inaltime cu comparator");
        for(int i=0;i<m.size();i++)
            System.out.println(m.get(i).getName() + " "+ m.get(i).getHeight());

    }

    public static void testView()
    {
        Mountain[] m2 = new Mountain[6];
        m2[0] = new Mountain("Negoiu",2535);        //folosind bubble sort
        m2[1] = new Mountain("Moldoveanu",2544);
        m2[2] = new Mountain("Parangul Mare",2519); //si vector pentru a retine obiectele de tip munte
        m2[3] = new Mountain("Vistea Mare",2527);
        m2[4] = new Mountain("Scarisoara Mare",2495);
        m2[5] = new Mountain("Musetescu",2495);
        //View.Display.showAll(m2);
        //View.Display.showAlphabeticalSort(m2);
        //View.Display.showSortByHeght(m2);
        //View.Display.showByHeight(m2);
        Display.showByName(m2);
    }

    public static  void main(String[] args)
    {
        //testMountain();
        //testSort();
        //testView();

        Mountain[] m = null;
        long opt = Display.menu();
        while(opt!=0){
            switch((int) opt){
                case 1:{ m = Display.readFromFile();
                        System.out.println("am citit corect datele din fisier");
                        break;}
                case 2:{ m = Display.readKeyboard();break;}
                case 3:{Display.showAll(m);break;}
                case 4:{Display.showByHeight(m);break;}
                case 5:{Display.showByName(m);break;}
                case 6:{Display.showAlphabeticalSort(m);break;}
                case 7:{Display.showSortByHeght(m);break;}
                case 8:{Display.showByPercent(m);break;}
                default: System.out.println("ai gresit optiunea, mai incearca!!!");
            }
            opt=Display.menu();
        }
        System.out.println("Program terminat");
    }
}
