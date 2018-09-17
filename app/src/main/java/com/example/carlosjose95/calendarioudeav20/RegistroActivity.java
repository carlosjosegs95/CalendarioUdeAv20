package com.example.carlosjose95.calendarioudeav20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {

    private EditText eNombre, eCorreo, eContraseña, eRepetir;

    ArrayList<Usuario> Personas = new ArrayList<Usuario>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eNombre = findViewById(R.id.eNombre);
        eCorreo = findViewById(R.id.eCorreo);
        eContraseña = findViewById(R.id.eContraseña);
        eRepetir = findViewById(R.id.eRepetir);

        Bundle args = getIntent().getExtras();

        if (args != null) {
            Personas = args.getParcelableArrayList("usuarios");
        }
    }

    public void regresar(View view) {
        finish();
    }

    public void guardar(View view) {
        if ((eNombre.getText().toString().isEmpty()) || (eContraseña.getText().toString().isEmpty()) || (eRepetir.getText().toString().isEmpty()) || (eCorreo.getText().toString().isEmpty())) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        } else if (!(eContraseña.getText().toString().equals(eRepetir.getText().toString()))) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        } else {
            int cont = 0;
            int ok = 0;
            int st = 0;
            String nombre = eNombre.getText().toString();
            String correo = eCorreo.getText().toString();
            String contraseña = eContraseña.getText().toString();
            while (ok == 0){
                if(cont < Personas.size()) {
                    if (Personas.get(cont).getName().equals(nombre)) {
                        Toast.makeText(this, "Nombre de usuario no válido, por favor cámbielo", Toast.LENGTH_SHORT).show();
                        ok = 1;
                        st = 1;
                    } else if(Personas.get(cont).getEmail().equals(correo)){
                        Toast.makeText(this, "Correo electrónico no válido, por favor cámbiela", Toast.LENGTH_SHORT).show();
                        ok = 1;
                        st = 1;
                    } else if(Personas.get(cont).getPassword().equals(contraseña)){
                        Toast.makeText(this, "Contraseña no válida, por favor cámbiela", Toast.LENGTH_SHORT).show();
                        ok = 1;
                        st = 1;
                    } else {
                        cont++;
                    }
                } else {
                    ok = 1;
                }
            }
            if(st == 0){
                Usuario NuevoUsuario = new Usuario();
                NuevoUsuario.setName(nombre);
                NuevoUsuario.setEmail(correo);
                NuevoUsuario.setPassword(contraseña);
                Intent intent = new Intent();
                intent.putExtra("nuevo usuario", NuevoUsuario);
                intent.putExtra("Llegaron", "Usuario registrado");
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}
