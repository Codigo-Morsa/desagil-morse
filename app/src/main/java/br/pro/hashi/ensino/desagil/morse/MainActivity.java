package br.pro.hashi.ensino.desagil.morse;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_EXAMPLE = 0;

    private EditText txt;
    private FloatingActionButton morseButton;
    private List<String> mensagens;
    private ArrayAdapter<String> listAdapter;
    private ListView listView;
    private MsgList listaDeMsgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaDeMsgs = new MsgList();
        mensagens = listaDeMsgs.getMessages();
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mensagens);
        listView = (ListView) findViewById(R.id.msgsListView);
        listView.setAdapter(listAdapter);
        txt = (EditText) findViewById(R.id.editText2);
        morseButton=(FloatingActionButton) findViewById(R.id.myButton);


        morseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                txt.setText(".");
            }
        });


        morseButton.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View V){
                txt.setText("_");
                return true;
            }
        });
    }


    public void checkPermissions(View view){
        int permission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS);
        if(permission == PackageManager.PERMISSION_GRANTED) {
            Toast toast = Toast.makeText(this, "Enviando SMS!", Toast.LENGTH_SHORT);
            toast.show();
            /// Aqui vão as chamadas das funções para propriamente enviar as mensagens para um número a ser definido.
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

}
