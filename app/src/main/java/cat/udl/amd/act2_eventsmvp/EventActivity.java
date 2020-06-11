package cat.udl.amd.act2_eventsmvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    private EditText etTitle;
    private EditText etDate;
    private EditText etDescriptio;
    private Spinner spinner;
    private Button btCreate;
    private Button btErase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        etTitle = findViewById(R.id.etTitle);
        etDate = findViewById(R.id.etDate);
        etDescriptio = findViewById(R.id.etDesc);
        spinner = findViewById(R.id.spinner);
        btCreate = findViewById(R.id.btCrear);
        btErase = findViewById(R.id.btErase);


        List<String> spinnerInflater = new ArrayList<String>();
        spinnerInflater.add("Cumple");
        spinnerInflater.add("Lan Party");
        spinnerInflater.add("Pool Party");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerInflater);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        btErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, MainActivity.class);

                intent.putExtra("result","-1");

                startActivity(intent);
            }
        });



        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, ConfirmActivity.class);

                intent.putExtra("title",etTitle.getText().toString());
                intent.putExtra("desc",etDescriptio.getText().toString());
                intent.putExtra("date", etDate.getText().toString());
                intent.putExtra("type", spinner.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }
}
