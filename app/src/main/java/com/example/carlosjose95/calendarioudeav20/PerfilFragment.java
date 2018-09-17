package com.example.carlosjose95.calendarioudeav20;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private TextView tNombre, tCorreo;
    Usuario persona = new Usuario();

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        tNombre = view.findViewById(R.id.tNombre);
        tCorreo = view.findViewById(R.id.tCorreo);

        Bundle args = getArguments();

        if(args != null){
            persona = args.getParcelable("usuario");
        }

        tNombre.setText(persona.getName());
        tCorreo.setText(persona.getEmail());

        return view;
    }

}
