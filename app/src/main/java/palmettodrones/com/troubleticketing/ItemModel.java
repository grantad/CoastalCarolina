package palmettodrones.com.troubleticketing;

/**
 * Created by angrant on 6/30/2016.
 */
public class ItemModel {
    String name = "None";
    String asset = "N/A";
    String owner = "IT";


    // constructor
    ItemModel(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
