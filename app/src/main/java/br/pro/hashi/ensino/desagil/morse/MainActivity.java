package br.pro.hashi.ensino.desagil.morse;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ButtonBarLayout;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final int REQUEST_EXAMPLE = 0;
    private Handler handler;
    private String tempstringmorse;
    private EditText txt;
    private FloatingActionButton morseButton;
    private List<String> mensagens;
    private ArrayAdapter<String> listAdapter;
    private Spinner dropdown;
    private MsgList listaDeMsgs;
    private String msgtosend;
    private ImageButton delete;
    private int postosend;
    private Timer myTimer;
    private TimerTask task;
    private int secondsPassed;
    private MorseToRoman morseToRoman;
    private TextView morsetxt;
    private MorseTree morsetree;
    private Vibrator vibe;
    private Button mtor;
    private Button rtom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        tempstringmorse = "";
        listaDeMsgs = new MsgList();
        mensagens = listaDeMsgs.getMessages();
        delete = (ImageButton) findViewById(R.id.deleteButton);
        msgtosend = null;
        postosend = 0;
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mensagens);
        dropdown = (Spinner)findViewById(R.id.spinner);
        dropdown.setOnItemSelectedListener(this);
        dropdown.setAdapter(listAdapter);
        txt = (EditText) findViewById(R.id.editText2);
        morseButton=(FloatingActionButton) findViewById(R.id.myButton);
        myTimer = new Timer();
        secondsPassed = 0;
        morsetxt = (TextView) findViewById(R.id.morseView);
        morsetree = new MorseTree();
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mtor = (Button) findViewById(R.id.mtor);
        rtom = (Button) findViewById(R.id.rtom);

//      HashMap mtsTree = morseToRoman.getmtsTree();
//      System.out.print(mtsTree.entrySet());



        task = new TimerTask() {
            public void run() {
                if (secondsPassed > 0){
                    secondsPassed--;
                }
                else if (secondsPassed == 0) {
                    secondsPassed = -1;
                    final String traducao = Character.toString(morsetree.translate(tempstringmorse));
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (Objects.equals(txt.getText().toString(), " ")){
                                txt.setText("");
                            }
                            if (!Objects.equals(traducao, "_")){
                                txt.append(traducao);

                            }
                            morsetxt.setText("");
                        }
                    });
                    tempstringmorse = "";
                }

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (Objects.equals(txt.getText().toString(), " ")){
                            txt.setText("");
                        }
                    }
                });

            }
        };

        myTimer.scheduleAtFixedRate(task,1000,1000);

        mtor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View V){
                goToMorseToRomanActivity();
            }
        });

        rtom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View V){
                goToRomanToMorseActivity();
            }
        });


        morseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                if (tempstringmorse.length() < 5){
                    tempstringmorse += "•";
                    morsetxt.setText(tempstringmorse);
                    secondsPassed = 1;
                }
            }
        });

        morseButton.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View V){
                if (tempstringmorse.length() < 5) {
                    tempstringmorse += "−";
                    morsetxt.setText(tempstringmorse);
                    secondsPassed = 1;
                }
                return true;
            }
        });

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                if (txt.length() != 0){
                    txt.setText(txt.getText().subSequence( 0, txt.getText().length() - 1 ));
                    txt.setSelection(txt.length());
                }
            }
        });
    }

    public void addSpaceBar(View view){
        txt.append(" ");
    }


    @RequiresApi(api = Build.VERSION_CODES.DONUT)
    public void sendMessage(View view) {
        SmsManager manager = SmsManager.getDefault();

        String number = "+5517991953199"; //colocar o numero do cuidador
        String message = msgtosend;

        try {
            manager.sendTextMessage(number, null, message, null, null);

            Toast toast = Toast.makeText(this, "ENVIADO!", Toast.LENGTH_SHORT);
            toast.show();
        }
        catch(IllegalArgumentException exception){
            Log.e("SendActivity", "number or message empty");
        }
//        listView = (ListView) findViewById(R.id.msgsListView);
//        listView.setAdapter(listAdapter);
    }


    @RequiresApi(api = Build.VERSION_CODES.DONUT)
    public void checkPermissions(View view){
        int permission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS);
        if(permission == PackageManager.PERMISSION_GRANTED) {

            if(txt.length() != 0){
                msgtosend = txt.getText().toString();
            }

            if(postosend>0 || txt.length() != 0) {
                Toast toast = Toast.makeText(this, "Enviando SMS!", Toast.LENGTH_SHORT);
                toast.show();
                sendMessage(view);
                txt.setText("");
                dropdown.setSelection(0);
                postosend = 0;
                msgtosend = "";
            }
        }
        else {
            String[] permissions = new String[1];
            permissions[0] = Manifest.permission.SEND_SMS;
            ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_EXAMPLE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == REQUEST_EXAMPLE) {
            if(grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast toast = Toast.makeText(this, "Não é possível enviar uma mensagem sem permissão!", Toast.LENGTH_SHORT);
                toast.show();
            }
            else {
                Toast toast = Toast.makeText(this, "Permissão concedida!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        msgtosend = parent.getItemAtPosition(pos).toString();
        postosend = pos;

        //Toast toast = Toast.makeText(this, msgtosend, Toast.LENGTH_SHORT);
        //toast.show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void nextItem(View view){
        vibe.vibrate(100);
        if(postosend < 6) {
            postosend += 1;
            dropdown.setSelection(postosend);
        }

    }

    public void prevItem(View view){
        vibe.vibrate(100);
        if(postosend > 0) {
            postosend -= 1;
            dropdown.setSelection(postosend);
        }

    }

    private void goToMorseToRomanActivity() {
        Intent intent = new Intent(this, activity_dicomoresroman.class);
        startActivity(intent);
    }

    private void goToRomanToMorseActivity() {
        Intent intent = new Intent(this, activity_dicromantomorse.class);
        startActivity(intent);

    }

}
