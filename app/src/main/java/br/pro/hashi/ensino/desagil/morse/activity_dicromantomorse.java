package br.pro.hashi.ensino.desagil.morse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class activity_dicromantomorse extends AppCompatActivity {
    private String[] listaRoman;
    private String[] listaMorse;
    private String[] intercalados;
    private RomanToMorse rtm;
    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicromantomorse);

        grid = (GridView) findViewById(R.id.gridview);

        String letterList = "abcdefghijklmnopqrstuvwxyz1234567890+=/";
        listaRoman = new String[letterList.length()];
        for (int i=0; i < letterList.length(); i++) {
            listaRoman[i]=Character.toString(letterList.charAt(i));
        }
        rtm = new RomanToMorse();
        listaMorse = rtm.getResult();

        int dobro = letterList.length()*2;

        intercalados = new String[dobro];
        int j=0;
        int k=0;
        for (int i=0; i < dobro; i++) {
            if ((i%2) != 0){
                intercalados[i] = listaMorse[j];
                j++;
            }
            else{
                intercalados[i] = Character.toString(letterList.charAt(k));
                k++;
            }

        }



        final List<String> dici = new ArrayList<String>(Arrays.asList(intercalados));
        final ArrayAdapter<String> gridViewArrayAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1, dici);
        grid.setAdapter(gridViewArrayAdapter);



    }

}
