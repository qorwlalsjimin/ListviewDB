package kr.hs.s2104.listviewdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    Button add_data;
    EditText add_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        add_data = findViewById(R.id.add_data);
        add_name = findViewById(R.id.add_name);

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = add_name.getText().toString();
                if(!name.equals("") && db.insertData(name)) {
                    Toast.makeText(MainActivity.this, "Data added", Toast.LENGTH_SHORT).show();
                    add_name.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "Data not added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}