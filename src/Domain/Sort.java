package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort {
    public static void alphabeticSort(Mountain[] m){            //sortarea alfabetica
        boolean flag;			                                // sortarea vectorului bublesort
        int i,poz,pozInter;		                                // optimizat
        poz  = pozInter = m.length-1;
        do {
            flag=true;
            for (i=0;i<poz;i++)	                                //poz=ultima pozitie de interschimbare
                if (m[i+1].compareName(m[i]))
                { Mountain aux = m[i];	                        //interschimbare cu referinte
                    m[i] = m[i+1];
                    m[i+1] = aux;
                    pozInter = i;
                    flag     = false;
                }
            poz=pozInter;
        }
        while (!flag);
    }
    public static void sortByHeight(Mountain[] m)                          //sortare dupa inaltime
    {
        boolean flag;			                                           // sortarea vectorului bublesort
        int i,poz,pozInter;		                                           // optimizat
        poz  = pozInter = m.length-1;
        do {
            flag=true;
            for (i=0;i<poz;i++)	                                           //poz=ultima pozitie de interschimbare
                if (m[i+1].compareHeight(m[i]) == 1)
                { Mountain aux = m[i];	                                   //interschimbare cu referinte
                    m[i] = m[i+1];
                    m[i+1] = aux;
                    pozInter = i;
                    flag     = false;
                }
            poz=pozInter;
        }
        while (!flag);
    }

    public static void sortByHeightComp(ArrayList<Mountain> m)               //sortarea dupa inaltime folosind comparator
    {
       /* Comparator<Mountain> compareByHeight = new Comparator<Mountain>() {  //creez un comparator intre obiecte de tip munte
            @Override
            public int compare(Mountain m1, Mountain m2) {                    //creez metoda de comparare a
                if (m1.getHeight() < m2.getHeight())                          //inaltimii a doi munti
                    return 1;                                                 //care returneaza int
                return 0; }
        };*/

        /*Comparator<Mountain> compareByHeight = (Mountain m1, Mountain m2) -> m2.compareHeight(m1);
                //trebuie sa
                //fac comapreHeight de tip int
        m.sort(compareByHeight);*/
        Collections.sort(m);
    }

}
