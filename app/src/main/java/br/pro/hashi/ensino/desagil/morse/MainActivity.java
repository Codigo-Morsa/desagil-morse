package br.pro.hashi.ensino.desagil.morse;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final int REQUEST_EXAMPLE = 0;

    private EditText txt;
    private FloatingActionButton morseButton;
    private List<String> mensagens;
    private ArrayAdapter<String> listAdapter;
    private Spinner dropdown;
    private MsgList listaDeMsgs;
    private String msgtosend;
    private int postosend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaDeMsgs = new MsgList();
        mensagens = listaDeMsgs.getMessages();
        msgtosend = null;
        postosend = 0;
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mensagens);
        dropdown = (Spinner)findViewById(R.id.spinner);
        dropdown.setOnItemSelectedListener(this);

        dropdown.setAdapter(listAdapter);

    }

    public void sendMessage(View view) {
        SmsManager manager = SmsManager.getDefault();

        String number = "011999331669"; //colocar o numero do cuidador
        String message = msgtosend;

        try {
            manager.sendTextMessage(number, null, message, null, null);

            Toast toast = Toast.makeText(this, "ENVIADO!", Toast.LENGTH_SHORT);
            toast.show();
        }
        catch(IllegalArgumentException exception){
            Log.e("SendActivity", "number or message empty");
        }
        listView = (ListView) findViewById(R.id.msgsListView);
        listView.setAdapter(listAdapter);
        txt = (EditText) findViewById(R.id.editText2);
        morseButton=(FloatingActionButton) findViewById(R.id.myButton);


        morseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                txt.append(".");
            }
        });


        morseButton.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View V){
                txt.append("_");
                return true;
            }
        });
    }


    public void checkPermissions(View view){
        int permission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS);
        if(permission == PackageManager.PERMISSION_GRANTED) {
            Toast toast = Toast.makeText(this, "Enviando SMS!", Toast.LENGTH_SHORT);
            toast.show();
            /// Aqui vão as chamadas das funções para propriamente enviar as mensagens para um número a ser definido
            sendMessage(view);
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

        if(postosend < 5) {
            postosend += 1;
            dropdown.setSelection(postosend);
        }

    }

    public void prevItem(View view){

        if(postosend > 0) {
            postosend -= 1;
            dropdown.setSelection(postosend);
        }

    }
}
