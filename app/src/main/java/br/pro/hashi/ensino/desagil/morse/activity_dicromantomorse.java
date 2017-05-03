package br.pro.hashi.ensino.desagil.morse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridLayout;


public class activity_dicromantomorse extends AppCompatActivity {
    private String[] listaRoman;
    private String[] listaMorse;
    private RomanToMorse rtm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicromantomorse);
        //String letterList = "abcdefghijklmnopqrstuvwxyz1234567890+=/";
        //listaRoman = new String[letterList.length()];
        //for (int i=0; i < letterList.length(); i++) {
          //  listaRoman[i]=Character.toString(letterList.charAt(i));
        //}
        //rtm = new RomanToMorse();



    }

}
