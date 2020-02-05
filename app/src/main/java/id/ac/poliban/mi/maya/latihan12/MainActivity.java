package id.ac.poliban.mi.maya.latihan12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etLastName = findViewById(R.id.etLastName);
        EditText etFirstName = findViewById(R.id.etFirstName);
        Button btLoad = findViewById(R.id.btLoad);
        Button btSave = findViewById(R.id.btSave);
        TextView tvResult = findViewById(R.id.tvResult);

        btSave.setOnClickListener(v -> {
            SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();

            String Iname, fname;
            Iname = etLastName.getText().toString();
            fname = etLastName.getText().toString();

            edit.putString("Iname", Iname);
            edit.putString("fname", fname);
            edit.apply();

            Toast.makeText(this, "data has been saved it", Toast.LENGTH_SHORT);
        });

        btLoad.setOnClickListener(v -> {
            SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
            String Iname = sp.getString("Iname", "na");
            String fname = sp.getString("Iname", "na");
            tvResult.setText(String.format("%s %s", fname, Iname));
        });
    }
}
