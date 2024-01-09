package com.papasmurfie.test3practise2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class BlankFragment extends DialogFragment {

    private FragmentListener listener;
    public BlankFragment(){
    }
    public static BlankFragment newInstance(Bundle bundle){
        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        view.findViewById(R.id.F_buttonBack).setOnClickListener(view1 -> dismiss());
        if(bundle != null){
            AvtobusDataModel newBus = bundle.getParcelable("bus");
            if(newBus != null){//ime, marka, napravleni, chas, status
                EditText ime = view.findViewById(R.id.F_etName);
                EditText marka = view.findViewById(R.id.F_etMarka);
                TextView napravleni = view.findViewById(R.id.F_tvNapravlenie);
                TextView chas = view.findViewById(R.id.F_tvChas);
                TextView status = view.findViewById(R.id.F_tvStatus);
                ime.setText(newBus.getImeShof());
                marka.setText(newBus.getMarkaAvtobus());
                napravleni.setText(newBus.getNapravlenie());
                chas.setText(newBus.getChasTrugvane());
                status.setText(newBus.getStatus());

                view.findViewById(R.id.F_saveBtn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        newBus.setImeShof(ime.getText().toString());
                        newBus.setMarkaAvtobus(marka.getText().toString());
                        newBus.setNapravlenie(napravleni.getText().toString());
                        newBus.setChasTrugvane(chas.getText().toString());
                        newBus.setStatus(status.getText().toString());
                        listener.updateItem(bundle.getInt("newNew"), newBus);
                        dismiss();
                    }
                });
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void setListener(FragmentListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

}