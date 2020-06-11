package cat.udl.amd.act2_eventsmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btCreate;
    private TextView tvCont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCreate= findViewById(R.id.btCreateMain);
        tvCont = findViewById(R.id.tvCont);

        String result;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                result= null;
            } else {
                result= extras.getString("result");
            }
        } else {
            result= (String) savedInstanceState.getSerializable("result");
        }

        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });



        if( !(result == null) && result.equals("0")){
            String resultado = tvCont.getText().toString() ;
            int num = Integer.parseInt(resultado) + 1;
            tvCont.setText("" +num );
        }
    }
}
