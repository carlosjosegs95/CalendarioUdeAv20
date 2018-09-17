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
public class InicioFragment extends Fragment {

    private TextView tTitulo;
    Usuario persona = new Usuario();

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        tTitulo = view.findViewById(R.id.tTitulo);

        Bundle args = getArguments();

        if(args != null){
            persona = args.getParcelable("usuario");
        }

        tTitulo.setText("¡ Te damos la bienvenida " + persona.getName() + " !");

        return view;
    }

}
