package com.papasmurfie.test3practise2;

import android.content.Intent;

public interface MainActivityCallback {
    void startA2WithIntent(Intent intent, AvtobusDataModel oneBus, int pos);
    void startFragmentForCallback(Intent intent, AvtobusDataModel oneBus, int pos);
}
