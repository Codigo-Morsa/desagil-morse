package br.pro.hashi.ensino.desagil.morse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.GridView;


public class activity_dicromantomorse extends AppCompatActivity {
    private String[] listaRoman;
    private String[] listaMorse;
    private RomanToMorse rtm;
    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicromantomorse);

        gridview = (GridView) findViewById(R.id.gridview);

        String letterList = "abcdefghijklmnopqrstuvwxyz1234567890+=/";
        listaRoman = new String[letterList.length()];
        for (int i=0; i < letterList.length(); i++) {
            listaRoman[i]=Character.toString(letterList.charAt(i));
        }
        rtm = new RomanToMorse();
        listaMorse = rtm.getResult();


    }

}
