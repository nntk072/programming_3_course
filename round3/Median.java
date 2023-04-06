
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Median {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        List<Double> values = new ArrayList<>();
        for (String arg : args) {
          values.add(Double.parseDouble(arg));
        }
        Collections.sort(values);
        double number_need_to_find = 0.0;
        if (values.size() % 2 !=0)
            number_need_to_find = values.get(values.size()/2);
        else
            number_need_to_find = (values.get(values.size()/2-1) + values.get(values.size()/2))/2;
        //System.out.println(values.get(values.size()/2)-1);
        //System.out.println(values.get(values.size()/2));
        System.out.println("Median: " + number_need_to_find);
    }
}
