package c.a122;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText name, age, phone, city;
    Button save, show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText)findViewById(R.id.name);
        age= (EditText)findViewById(R.id.age);
        phone= (EditText)findViewById(R.id.phone);
        city= (EditText)findViewById(R.id.city);
        save= (Button)findViewById(R.id.save);
        show= (Button)findViewById(R.id.show);
        save.setOnClickListener(this);
        show.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save:
                SharedPrefManager.setStringPrefVal(this, Constants.NAME, name.getText().toString().trim());
                SharedPrefManager.setIntPrefVal(this, Constants.AGE, Integer.valueOf(age.getText().toString().trim()));
                SharedPrefManager.setStringPrefVal(this, Constants.PHONE, phone.getText().toString().trim());
                SharedPrefManager.setStringPrefVal(this, Constants.CITY, city.getText().toString().trim());

                break;
            case R.id.show:
                String msg= "Name: "+ SharedPrefManager.getPrefVal(this, Constants.NAME)+ "\n"+
                        "Age: "+ SharedPrefManager.getIntPrefVal(this, Constants.AGE)+ "\n"+
                        "Phone: "+ SharedPrefManager.getPrefVal(this, Constants.PHONE)+ "\n"+
                        "City: "+SharedPrefManager.getPrefVal(this, Constants.CITY)+ "\n";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                break;
        }
    }
}
