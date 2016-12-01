package salt.movil.imcproject.fragments;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.orm.SugarContext;

import java.util.Date;

import salt.movil.imcproject.R;
import salt.movil.imcproject.models.ImcItem;


public class IMCFragment extends Fragment implements View.OnClickListener {

    Button btnCalcular;
    TextInputLayout tilPeso;
    TextInputLayout tilEstatura;

    public IMCFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_imc, container, false);

        btnCalcular = (Button) v.findViewById(R.id.btn_calcular);
        tilPeso = (TextInputLayout) v.findViewById(R.id.til_peso);
        tilEstatura = (TextInputLayout) v.findViewById(R.id.til_estatura);

        btnCalcular.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String peso = tilPeso.getEditText().getText().toString();
        String estatura = tilEstatura.getEditText().getText().toString();

        float pesoNum = Float.parseFloat(peso);
        float estaturaNum = Float.parseFloat(estatura);

        float imc = pesoNum / (estaturaNum*estaturaNum);
        ImcItem imcItem = new ImcItem();

        imcItem.setEstatura(estaturaNum);
        imcItem.setPase(pesoNum);
        imcItem.setResultado(getEstado(imc));
        imcItem.setDate(new Date());
        imcItem.setImg(R.drawable.ic_menu_camera);
        imcItem.save();

        builder.setTitle("Tu IMC es:")
                .setMessage("Resultado: "+imc+"\n"+"Estado: "+ getEstado(imc))
                .setPositiveButton("OK",null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private String getEstado(float imc){
        String resultado;
        if (imc<16)
            resultado = "Delgadez Severa";
        else if (16<imc && imc<16.99)
            resultado = "Delgadez moderada";
        else if (17<imc && imc<18.49)
            resultado = "Delgadez aceptable";
        else if (18.50<imc && imc<24.99)
            resultado = "Normal";
        else if (25<imc && imc<29.99)
            resultado = "Sobrepeso";
        else if (30<imc && imc<34.99)
            resultado = "Obeso: Tipo I";
        else if (35<imc && imc<40)
            resultado = "Obeso: Tipo II";
        else
            resultado = "Obeso: Tipo III";

        return resultado;
    }
}
