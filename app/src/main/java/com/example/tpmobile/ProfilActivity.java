package com.example.tpmobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ProfilActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Bundle recu = getIntent().getBundleExtra(MainActivity.EXTRA_BUNDLE);
        TextView tvNom = findViewById(R.id.tvNomProfil);
        TextView tvDerniere = findViewById(R.id.tvDerniere);
        Button btnRetour = findViewById(R.id.btnRetour);

        String nom = "";
        int total = 0;

        if (recu != null) {
            nom = recu.getString(MainActivity.KEY_NOM, "");
            total = recu.getInt(MainActivity.KEY_TOTAL, 0);
        }

        tvNom.setText(getString(R.string.label_nom_profil, nom));

        if (total > 0) {
            tvDerniere.setText(getString(R.string.label_derniere, total));
        } else {
            tvDerniere.setText(R.string.aucune_location);
        }

        btnRetour.setOnClickListener(v -> finish());
    }
}
