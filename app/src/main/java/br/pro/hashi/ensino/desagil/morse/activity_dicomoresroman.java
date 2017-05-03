package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.os.Bundle;
import android.app.Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class activity_dicomoresroman extends AppCompatActivity {
    private MorseToRoman mtr;
    private HashMap mtrMap;
    private GridView grid;
    private LinkedList chaves;
    private LinkedList valores;
    private String[] chavesString;
    private String[] valoresString;
    private String[] intercalados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicomoresroman);

        mtr = new MorseToRoman();
        mtrMap = mtr.getmtsTree();
        grid = (GridView) findViewById(R.id.gridview);
        chaves = mtr.getChaves();
        valores = mtr.getValor();
        chavesString = new String[chaves.size()];
        valoresString = new String[valores.size()];
        Log.i("alo", chaves.toString());
        Log.i("alo", valores.toString());

        for(int i =0; i<chavesString.length; i++){
            chavesString[i] = chaves.get(i).toString();
            valoresString[i] = valores.get(i).toString();
        }

        intercalados = new String[chavesString.length + valoresString.length];

        int j=0;
        int k=0;
        for (int i=0; i < intercalados.length; i++) {
            if ((i%2) != 0){
                intercalados[i] = chavesString[j];
                j++;
            }
            else{
                intercalados[i] = valoresString[k];
                k++;
            }

        }



        final List<String> alo = new ArrayList<>(Arrays.asList(intercalados));

        final ArrayAdapter<String> gridViewArrayAdapter = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1, alo);
        Log.i("final", gridViewArrayAdapter.toString());
        grid.setAdapter(gridViewArrayAdapter);

    }
}
