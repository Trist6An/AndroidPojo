package upjv.lprgi.projetpojo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //création des actions lié au bouton
        Button button_pojo = findViewById(R.id.button_pojo);
        button_pojo.setOnClickListener(view -> LanceActivityPojo());

        Button button_actualiser = findViewById(R.id.button_actualiser);
        button_actualiser.setOnClickListener(view -> AffichageVoiture());

        Button button_quitter = findViewById(R.id.button_quitter);
        button_quitter.setOnClickListener(view -> Quitter());
    }

    private void Quitter() {
        finishAffinity(); //ferme les activité et quitte l'application
    }

    private void LanceActivityPojo() {
        Intent i = new Intent(this, activity_pojo.class);
        startActivity(i);
    }

    private void AffichageVoiture(){
        List<String> liste_voiture = new ArrayList<String>();

        Button button_actualiser = findViewById(R.id.button_actualiser);
        //definit les textview
        TextView textView_marque = findViewById(R.id.textViewMain_marque);
        TextView textView_modele = findViewById(R.id.textViewMain_modele);
        TextView textView_annee = findViewById(R.id.textViewMain_annee);

        //recupération des données envoyées de l'activité pojo
        liste_voiture = getIntent().getStringArrayListExtra("liste_voiture");
        int valide = getIntent().getIntExtra("vide", 0);

        if (valide == 0){ //en cas de valeur null envoyé
            textView_marque.setText("aucune donnée");
            textView_modele.setText("aucune donnée");
            textView_annee.setText("aucune donnée");
        }else{
            String marque = liste_voiture.get(0);
            String modele = liste_voiture.get(1);
            String annee = liste_voiture.get(2);

            textView_marque.setText(marque);
            textView_modele.setText(modele);
            textView_annee.setText(annee);
        }
    }
}