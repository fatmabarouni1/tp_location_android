package com.example.tpmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LocationActivity extends Activity {

    private EditText editJours;
    private TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        Bundle recu = getIntent().getBundleExtra(MainActivity.EXTRA_BUNDLE);
        if (recu == null) {
            finish();
            return;
        }

        String nom = recu.getString(MainActivity.KEY_NOM, "");
        String voiture = recu.getString(MainActivity.KEY_VOITURE, "");
        int prixJour = recu.getInt(MainActivity.KEY_PRIX_JOUR, 0);

        TextView tvVoiture = findViewById(R.id.tvVoiture);
        TextView tvPrixJour = findViewById(R.id.tvPrixJour);
        editJours = findViewById(R.id.editJours);
        tvTotal = findViewById(R.id.tvTotal);
        Button btnCalculer = findViewById(R.id.btnCalculer);
        Button btnValider = findViewById(R.id.btnValider);
        Button btnRetour = findViewById(R.id.btnRetour);

        tvVoiture.setText(voiture);
        tvPrixJour.setText(getString(R.string.label_prix_jour, prixJour));
        tvTotal.setText(getString(R.string.label_total, 0));

        btnRetour.setOnClickListener(v -> finish());

        btnCalculer.setOnClickListener(v -> {
            int jours = lireJours();
            if (jours > 0) {
                tvTotal.setText(getString(R.string.label_total, jours * prixJour));
            }
        });

        btnValider.setOnClickListener(v -> {
            int jours = lireJours();
            if (jours <= 0) {
                return;
            }

            int total = jours * prixJour;

            Bundle bundle = new Bundle();
            bundle.putString(MainActivity.KEY_NOM, nom);
            bundle.putString(MainActivity.KEY_VOITURE, voiture);
            bundle.putInt(MainActivity.KEY_PRIX_JOUR, prixJour);
            bundle.putInt(MainActivity.KEY_JOURS, jours);
            bundle.putInt(MainActivity.KEY_TOTAL, total);

            Intent intent = new Intent(this, ContratActivity.class);
            intent.putExtra(MainActivity.EXTRA_BUNDLE, bundle);
            startActivity(intent);
        });
    }

    private int lireJours() {
        String valeur = editJours.getText().toString().trim();
        try {
            int jours = Integer.parseInt(valeur);
            if (jours > 0) {
                return jours;
            }
        } catch (NumberFormatException ignored) {
        }

        Toast.makeText(this, R.string.jours_invalides, Toast.LENGTH_SHORT).show();
        return -1;
    }
}
