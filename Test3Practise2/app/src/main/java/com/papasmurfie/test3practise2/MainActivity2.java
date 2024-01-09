package com.papasmurfie.test3practise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        EditText markaEt = findViewById(R.id.a2_markaET);
        EditText imeShofET = findViewById(R.id.a2_imeShofiorET);
        TextView napravlenieTV = findViewById(R.id.a2_napravlenieTV);
        TextView statusTV = findViewById(R.id.a2_statusTV);
        Button a2btn = findViewById(R.id.a2_btn);

        AvtobusDataModel a2Bus = intent.getParcelableExtra("bus", AvtobusDataModel.class);
        int pos = intent.getIntExtra("pos", 0);
        if(a2Bus != null) {
            markaEt.setText(a2Bus.getMarkaAvtobus());
            imeShofET.setText(a2Bus.getImeShof());
            napravlenieTV.setText(a2Bus.getNapravlenie());
            statusTV.setText(a2Bus.getStatus());
        }
        a2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tuka shte vrushtam !
                AvtobusDataModel modifiedBus = new AvtobusDataModel(markaEt.getText().toString(),
                        imeShofET.getText().toString(), napravlenieTV.getText().toString(),
                        statusTV.getText().toString(),statusTV.getText().toString());
                intent.putExtra("modifiedBus", modifiedBus);
                intent.putExtra("posReturn", pos);
                setResult(RESULT_OK, intent);
                finish();
                Log.i("18621779", "Submitted on a2");

            }
        });
    }
}