package com.papasmurfie.test3practise2;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentListener, MainActivityCallback{
    MyAdapter adapter;
    Handler handler;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, MainActivity2.class);

        RecyclerView recyclerView = findViewById(R.id.a1_recyclerView);
        adapter = new MyAdapter(MyGenerator.generateAvtobusList(20), this, this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(addNewItemRunnable, 2000);
    }
    private final Runnable addNewItemRunnable = new Runnable() {
        @Override
        public void run() {
            //bqgai !
            adapter.addNewItem(new AvtobusDataModel("every2sec", "every2sec","every2sec",
                    "every2sec","every2sec"));
            handler.postDelayed(this, 2000);
        }
    };
    @Override
    protected void onDestroy() {
        // Remove any pending callbacks to prevent memory leaks
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void updateItem(int position, AvtobusDataModel model) {
        adapter.updateItem(position, model);
    }

    @Override
    public void startA2WithIntent(Intent intent, AvtobusDataModel oneBus) {
        if (intent != null) {
            intent.putExtra("bus", oneBus);
            startActivity(intent);
        } else {
            // Log an error or handle the case where intent is null
            Log.e("MainActivity", "Intent is null in startA2WithIntent method");
        }

    }
}