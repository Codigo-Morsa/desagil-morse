package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.GridView;

import java.util.HashMap;
import java.util.LinkedList;

public class activity_dicomoresroman extends AppCompatActivity {
    private MorseToRoman mtr;
    private HashMap mtrMap;
    private GridLayout grid;
    private LinkedList chaves;
    private LinkedList valores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicomoresroman);

        mtr = new MorseToRoman();
        mtrMap = mtr.getmtsTree();
        grid = (GridLayout) findViewById(R.id.grid);
        chaves = mtr.getChaves();
        valores = mtr.getValor();
        Log.i("alo", chaves.toString());
        Log.i("alo", valores.toString());

        grid


    }
}
