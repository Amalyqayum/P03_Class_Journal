package sg.edu.rp.c346.p03_class_journal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {

    RadioGroup rg;
    Button submit;
    TextView week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);

        // Get the intent
        Intent i = getIntent();
        submit = findViewById(R.id.buttonSubmit);
        rg = findViewById(R.id.rg);
        DailyCA finale = (DailyCA) i.getSerializableExtra("ending");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selected);
                Intent i = new Intent();
                i.putExtra("chooses",rb.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
