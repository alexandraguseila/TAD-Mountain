package Domain;

public class Mountain implements Comparable<Mountain>{
    private String name = null;             //atribute private ale muntelui
    private long height = 0;                //nume si inaltime initializate cu valori nule

    Mountain(){};                            //constructor fara parametrii
    public Mountain(String name, long height){this.name = name; this.height = height;}

                                            //getteri si setteri pentru atributele private
    public String getName(){return name;}
    public long getHeight(){return height;}
    public void setName(String n){name = n;}
    public void setHeight(long h){height = h;}

    public boolean compareName(Mountain M){               //comapara numele muntelui actual cu numele muntelui dat ca param{
        if(this.name.compareTo( M.name)<0) return true;   //returnez adevarat daca this.name se afla inaintea
        return false; }                                   // lui M.name in dictionar

    public int compareHeight(Mountain M) {
        if(this.height > M.height)return 1;
        return 0; }

    @Override
    public int compareTo(Mountain o) {
        if(this.height > o.height)return 1;
        return 0;
    }
}
