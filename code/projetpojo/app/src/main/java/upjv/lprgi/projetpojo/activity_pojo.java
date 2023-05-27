package upjv.lprgi.projetpojo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class activity_pojo extends AppCompatActivity {

    public String saisi_marque;
    public String saisi_modele;
    public String saisi_annee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pojo);

        //création des actions lié au bouton
        Button button_main = findViewById(R.id.button_main);
        button_main.setOnClickListener(view -> LanceActivityMain());

        Button button_Accueil = findViewById(R.id.button_accueil);
        button_Accueil.setOnClickListener(view -> LanceActivityAccueil());

        Button button_Quitter = findViewById(R.id.buttonPojo_quitter);
        button_Quitter.setOnClickListener(view -> LanceActivityQuitter());
    }

    private void LanceActivityQuitter() {
        finishAffinity(); //ferme toutes les activitées et quitte l'application
    }

    private void LanceActivityAccueil() {
        Intent i = new Intent(this, MainActivity.class);
        int vide = 0;
        i.putExtra("vide", vide); //retourne 0 pour l'activité main

        startActivity(i);
    }

    private void LanceActivityMain() {
        int vide = 1;

        //recuperation des données saisi par l'utilisateur
        EditText editText_marque = findViewById(R.id.editTextText_marque);
        saisi_marque = editText_marque.getText().toString();

        EditText editText_modele = findViewById(R.id.editTextText_modele);
        saisi_modele = editText_modele.getText().toString();

        EditText editText_année = findViewById(R.id.editTextDate_année);
        saisi_annee = editText_année.getText().toString();

        //création d'une liste
        List<String> listeVoiture = new ArrayList<>();
        //ajout dans la liste des variables
        listeVoiture.add(saisi_marque);
        listeVoiture.add(saisi_modele);
        listeVoiture.add(saisi_annee);

        Intent i = new Intent(this, MainActivity.class);
        //envoi des données a l'activité main
        i.putExtra("liste_voiture", (ArrayList<String>) listeVoiture);
        i.putExtra("vide", vide);

        startActivity(i);
    }
}