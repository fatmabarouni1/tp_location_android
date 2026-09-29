package com.example.tpmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String EXTRA_BUNDLE = "data_bundle";
    public static final String KEY_NOM = "nom";
    public static final String KEY_VOITURE = "voiture";
    public static final String KEY_PRIX_JOUR = "prix_jour";
    public static final String KEY_JOURS = "jours";
    public static final String KEY_TOTAL = "total";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editNom = findViewById(R.id.editNom);
        Button btnLouer = findViewById(R.id.btnLouer);
        Button btnProfil = findViewById(R.id.btnProfil);

        btnLouer.setOnClickListener(v -> ouvrir(CatalogueActivity.class, editNom));
        btnProfil.setOnClickListener(v -> ouvrir(ProfilActivity.class, editNom));
    }

    private void ouvrir(Class<?> cible, EditText editNom) {
        String nom = editNom.getText().toString().trim();
        if (nom.isEmpty()) {
            Toast.makeText(this, R.string.nom_vide, Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putString(KEY_NOM, nom);

        Intent intent = new Intent(this, cible);
        intent.putExtra(EXTRA_BUNDLE, bundle);
        startActivity(intent);
    }
}
