package com.example.tpmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ContratActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrat);

        Bundle recu = getIntent().getBundleExtra(MainActivity.EXTRA_BUNDLE);
        if (recu == null) {
            finish();
            return;
        }

        String nom = recu.getString(MainActivity.KEY_NOM, "");
        String voiture = recu.getString(MainActivity.KEY_VOITURE, "");
        int prixJour = recu.getInt(MainActivity.KEY_PRIX_JOUR, 0);
        int jours = recu.getInt(MainActivity.KEY_JOURS, 0);
        int total = recu.getInt(MainActivity.KEY_TOTAL, 0);

        String date = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

        TextView tvClient = findViewById(R.id.tvClient);
        TextView tvDate = findViewById(R.id.tvDate);
        TextView tvVoiture = findViewById(R.id.tvVoitureContrat);
        TextView tvDuree = findViewById(R.id.tvDuree);
        TextView tvPrix = findViewById(R.id.tvPrixContrat);
        TextView tvTotal = findViewById(R.id.tvTotalContrat);
        Button btnProfil = findViewById(R.id.btnProfil);
        Button btnAccueil = findViewById(R.id.btnAccueil);

        tvClient.setText(getString(R.string.label_client, nom));
        tvDate.setText(getString(R.string.label_date, date));
        tvVoiture.setText(getString(R.string.label_voiture, voiture));
        tvDuree.setText(getString(R.string.label_duree, jours));
        tvPrix.setText(getString(R.string.label_prix_jour, prixJour));
        tvTotal.setText(getString(R.string.label_total, total));

        btnProfil.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString(MainActivity.KEY_NOM, nom);
            bundle.putInt(MainActivity.KEY_TOTAL, total);

            Intent intent = new Intent(this, ProfilActivity.class);
            intent.putExtra(MainActivity.EXTRA_BUNDLE, bundle);
            startActivity(intent);
        });

        btnAccueil.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }
}
