package com.example.carlosjose95.calendarioudeav20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText eUsuario, eContraseña;
    private TextView tRegistrarse;
    private Button bIniciar;

    ArrayList<Usuario> Personas = new ArrayList<Usuario>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsuario = findViewById(R.id.eUsuario);
        eContraseña = findViewById(R.id.eContraseña);
        tRegistrarse = findViewById(R.id.tRegistrarse);
        bIniciar = findViewById(R.id.bIniciar);

        tRegistrarse.setText(Html.fromHtml(getResources().getString(R.string.mensaje)));

        tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                intent.putExtra("usuarios", Personas);
                startActivityForResult(intent, 1234);
            }
        });
    }

    public void iniciasesion(View view) {
        if(Personas.isEmpty()){
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        } else {
            int cont = 0;
            int ok = 0;
            int inicia = 0;
            Usuario ExplorarPersona = new Usuario();
            String usuario = eUsuario.getText().toString();
            String contraseña = eContraseña.getText().toString();
            while(ok == 0) {
                if(cont < Personas.size()) {
                    if ((Personas.get(cont).getName().equals(usuario)||(Personas.get(cont).getEmail().equals(usuario)))&&Personas.get(cont).getPassword().equals(contraseña)) {
                        ExplorarPersona = Personas.get(cont);
                        ok = 1;
                        inicia = 1;
                    } else {
                        cont++;
                    }
                } else {
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    ok = 1;
                }
            }
            if (inicia == 1){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("usuario ingresado", ExplorarPersona);
                startActivityForResult(intent, 910);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 1234) && (resultCode == RESULT_OK)){
            Toast.makeText(this, data.getExtras().getString("Llegaron"), Toast.LENGTH_SHORT).show();
            Usuario usuario = data.getParcelableExtra("nuevo usuario");
            Personas.add(usuario);
        }
        if ((requestCode == 910) && (resultCode == RESULT_OK)){
            finish();
        }
    }
}
