package palmettodrones.com.troubleticketing;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by angrant on 6/30/2016.
 */
public class DataModel {

    private ArrayList<ItemModel> itemsArray = new ArrayList<ItemModel>();
    private Context ctx;

    // Initializer to read a text file into an array of golfcourse objects
    public DataModel(Context ctx, String itemsFilename) {
        String line;
        BufferedReader br;

        try {
            br = new BufferedReader(new InputStreamReader(ctx.getAssets().open(itemsFilename)));

            while ((line = br.readLine()) != null) {
                StringTokenizer sTok = new StringTokenizer(line, ":");
                ItemModel gc = new ItemModel(sTok.nextToken());
                gc.name = sTok.nextToken();
                itemsArray.add(gc);
            }
        } catch (IOException e) {
            return;
        }
}

    // Method to retrieve courses
    public ArrayList<ItemModel> getItems() {
        return itemsArray;
    }
}


