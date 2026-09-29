package com.example.tpmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CatalogueActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);

        Bundle recu = getIntent().getBundleExtra(MainActivity.EXTRA_BUNDLE);
        String nom = recu != null ? recu.getString(MainActivity.KEY_NOM, "") : "";

        RadioGroup rgVoitures = findViewById(R.id.rgVoitures);
        Button btnContinuer = findViewById(R.id.btnContinuer);
        Button btnRetour = findViewById(R.id.btnRetour);

        btnRetour.setOnClickListener(v -> finish());

        btnContinuer.setOnClickListener(v -> {
            int id = rgVoitures.getCheckedRadioButtonId();
            String voiture;
            int prixJour;

            if (id == R.id.rbClio) {
                voiture = getString(R.string.voiture_clio);
                prixJour = 80;
            } else if (id == R.id.rb208) {
                voiture = getString(R.string.voiture_208);
                prixJour = 90;
            } else if (id == R.id.rbDuster) {
                voiture = getString(R.string.voiture_duster);
                prixJour = 120;
            } else {
                Toast.makeText(this, R.string.choisir_voiture, Toast.LENGTH_SHORT).show();
                return;
            }

            Bundle bundle = new Bundle();
            bundle.putString(MainActivity.KEY_NOM, nom);
            bundle.putString(MainActivity.KEY_VOITURE, voiture);
            bundle.putInt(MainActivity.KEY_PRIX_JOUR, prixJour);

            Intent intent = new Intent(this, LocationActivity.class);
            intent.putExtra(MainActivity.EXTRA_BUNDLE, bundle);
            startActivity(intent);
        });
    }
}
