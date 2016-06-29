package palmettodrones.com.troubleticketing;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listenter
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> departments = new ArrayList<String>();
        departments.add("--");
        departments.add("AFE");
        departments.add("Mezz");
        departments.add("Pick");
        departments.add("Receive");
        departments.add("Stow");
        departments.add("ICQA");
        departments.add("Learning");
        departments.add("Safety");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, departments);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        if(!(item.equalsIgnoreCase("--"))) {
            // Showing selected spinner item
            Toast.makeText(parent.getContext(), "  " + item, Toast.LENGTH_LONG).show();
        }

        if(item.equalsIgnoreCase("AFE")){
            Intent afeIntent = new Intent(MainActivity.this, AFEActivity.class);
            afeIntent.putExtra("AFE", 1);
            MainActivity.this.startActivity(afeIntent);
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO nothing
    }
}
