package cat.udl.amd.act2_eventsmvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cat.udl.amd.act2_eventsmvp.presenter.EventPresenter;

public class ConfirmActivity extends AppCompatActivity implements EventViewActions {

    private EventPresenter presenter;
    private Button btCreate;
    private Button btCancel;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        btCreate = findViewById(R.id.btCreateC);
        btCancel = findViewById(R.id.btCancelC);
        tvResult = findViewById(R.id.tvResultC);

        presenter = new EventPresenter( this);
        String title, desc, date, type;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                title= null;
                desc= null;
                date = null;
                type = null;
            } else {
                title= extras.getString("title");
                desc= extras.getString("desc");
                date= extras.getString("date");
                type= extras.getString("type");
            }
        } else {
            title= (String) savedInstanceState.getSerializable("title");
            desc= (String) savedInstanceState.getSerializable("desc");
            date= (String) savedInstanceState.getSerializable("date");
            type= (String) savedInstanceState.getSerializable("type");
        }
        presenter.setEvent(title,desc,date,type);
        presenter.getEvent();

        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmActivity.this, MainActivity.class);
                intent.putExtra("result","0");
                startActivity(intent);
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmActivity.this, MainActivity.class);
                intent.putExtra("result","-1");
                startActivity(intent);
            }
        });
    }

    @Override
    public void updateUI(String message) {
        tvResult.setText(message);

    }
}
