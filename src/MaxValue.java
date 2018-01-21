import java.util.List;

/**
 * Created by Вадим on 20.01.2018.
 */
public class MaxValue implements Result {

    Double[] values;

    public MaxValue(String values){
        String[] strings = values.split(",");
        this.values = new Double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            this.values[i] = Double.parseDouble(strings[i]);
        }
    }

    public MaxValue(Double[] values){
        this.values = values;
    }

    public MaxValue(List<Double> values){
        this.values = (Double[]) values.toArray();
    }

    public String getResult(){
        Double max = -100000D;
        Boolean flag = true;

        while (flag){
            flag = false;
            for(Double d: this.values){
                if(max < d){
                    flag = true;
                    max = d;
                }
            }
        }

        return max.toString();
    }
}
