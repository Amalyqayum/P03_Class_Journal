package sg.edu.rp.c346.p03_class_journal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    TextView tvday, tvgrade;
    Button btnInfo, btnAdd, btnEmail;
    ListView lv;
    ArrayList<DailyCA> al;
    ArrayAdapter aa;
    int responsive = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dailylv);

        tvday = findViewById(R.id.tvDay);
        tvgrade = findViewById(R.id.tvDaily);
        lv = findViewById(R.id.lvDaily);
        btnInfo = findViewById(R.id.btnInfo);
        btnAdd = findViewById(R.id.btnAdd);
        btnEmail = findViewById(R.id.btnEmail);

        al = new ArrayList<DailyCA>();
        al.add(new DailyCA("B", "C347", 1));
        al.add(new DailyCA("A", "C347", 2));
        al.add(new DailyCA("C", "C347", 3));

        aa = new DailyAdapter(this, R.layout.row, al);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DailyCA DG = new DailyCA("", "C347", al.size() + 1);
                Intent i = new Intent(SecondActivity.this, FinalActivity.class);
                i.putExtra("ending", DG);
                startActivityForResult(i, responsive);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });
    }
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            // Only handle when 2nd activity closed normally
            //  and data contains something
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    // Get data passed back from 2nd activity
                    String like = data.getStringExtra("chooses");
                    // If it is activity started by clicking
                    if (requestCode == responsive) {
                       al.add(new DailyCA(like,"C347",al.size() + 1));
                    }
                    aa = new DailyAdapter(this, R.layout.row, al);
                    lv.setAdapter(aa);
                }
            }
        }
    }