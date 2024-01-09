package com.papasmurfie.test3practise2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVHolder extends RecyclerView.ViewHolder {
//tuk sa TV ot recyclerView v mainActivity... imat getters & setters za Vs edin ot tqh
    private TextView napravlenieTV;
    private TextView chasTV;
    private TextView statusTV;
    public RVHolder(@NonNull View itemView) {
        super(itemView);
        napravlenieTV =itemView.findViewById(R.id.L_tvNapravl);
        chasTV = itemView.findViewById(R.id.L_tvChas);
        statusTV = itemView.findViewById(R.id.L_tvStatus);
    }

    public TextView getNapravlenieTV() {
        return napravlenieTV;
    }

    public void setNapravlenieTV(String napravlenieTV) {
        this.napravlenieTV.setText(napravlenieTV);
    }

    public TextView getChasTV() {
        return chasTV;
    }

    public void setChasTV(String chasTV) {
        this.chasTV.setText(chasTV);
    }

    public TextView getStatusTV() {
        return statusTV;
    }

    public void setStatusTV(String  statusTV) {
        this.statusTV.setText(statusTV);
    }
}
