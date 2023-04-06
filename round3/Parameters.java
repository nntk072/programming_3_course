import java.util.ArrayList;
import java.util.Collections;

public class Parameters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer number = 0;
        ArrayList<String> list = new ArrayList<>();
        for (String i : args) {
            list.add(i);
            if (i.length()>number)
                number = i.length();
        }
        Collections.sort(list);
        //System.out.print(list);
        int how_many_country = list.size();
        //Print the top border
        printBorder(number,1,how_many_country);
        // Print the number and country
        int i = 1;
        
        for (String country : list) {
            printCountry(country,number,i,how_many_country);
            if (i != list.size())
                printBorder(number,0,how_many_country);
            else
                printBorder(number,1,how_many_country);
            i++;
        }
    }
    private static void printCountry(String country, Integer number, int i, int how_many_country) {
        int haha = 0;
        if (how_many_country>100)
            haha = 3;
        else if (how_many_country<10)
            haha = 1; 
        else
            haha = 2;
        String line = String.format("# %" + haha +"d | %-"+ (number)+"s #%n",i,country);
        System.out.print(line);
    }
    private static void printBorder(int number,int a, int how_many_country) {
        System.out.print("#");
        String character = "";
        if (a==1) {
            character = "#";
        }
        else {
            character = "-";
        }
        for (int i = 1; i < number+8; i++) {
            if (i == 5 && a==0 && how_many_country < 100)
                System.out.print("+");     
            else if (i == 6 && a==0 && how_many_country >= 100)
                System.out.print("+");
            else {
                System.out.print(character);
            }        
        }
        if (how_many_country>=100)
            System.out.print(character);
        System.out.print("#");
        System.out.println();
    }
}