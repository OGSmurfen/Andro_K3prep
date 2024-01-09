package com.papasmurfie.test3practise2;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.annotation.Nullable;
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
    private static final int REQUEST_CODE_ACTIVITY_B = 1001;

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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == REQUEST_CODE_ACTIVITY_B && resultCode == RESULT_OK && data != null) {
           AvtobusDataModel modifiedObject = (AvtobusDataModel) data.getParcelableExtra("modifiedBus");
           int pos = data.getIntExtra("posReturn", 0);
            updateItem(pos, modifiedObject);

        }
    }
    @Override
    public void updateItem(int position, AvtobusDataModel model) {
        adapter.updateItem(position, model);
    }

    @Override
    public void startA2WithIntent(Intent intent, AvtobusDataModel oneBus, int pos) {
        if (intent != null) {
            intent.putExtra("bus", oneBus);
            intent.putExtra("pos", pos);
            startActivityForResult(intent, REQUEST_CODE_ACTIVITY_B);
        } else {
            // Log an error or handle the case where intent is null
            Log.e("MainActivity", "Intent is null in startA2WithIntent method");
        }

    }

    @Override
    public void startFragmentForCallback(Intent intent, AvtobusDataModel oneBus, int pos) {

    }
}