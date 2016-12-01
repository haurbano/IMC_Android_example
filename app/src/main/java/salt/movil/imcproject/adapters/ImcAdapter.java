package salt.movil.imcproject.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import salt.movil.imcproject.R;
import salt.movil.imcproject.models.ImcItem;

/**
 * Created by Hamilton Urbano on 01/12/2016.
 */

public class ImcAdapter extends RecyclerView.Adapter<ImcAdapter.ViewHolder> {

    List<ImcItem> data;

    public ImcAdapter(List<ImcItem> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.view_item_imc,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImcItem imcItem = data.get(position);
        holder.txtPeso.setText("Peso: "+imcItem.getPase());
        holder.txtEstatura.setText("Altura: "+imcItem.getEstatura());
        holder.txtResultado.setText("Resultado: "+imcItem.getResultado());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtPeso, txtEstatura, txtResultado;
        public ViewHolder(View itemView) {
            super(itemView);
            txtPeso = (TextView) itemView.findViewById(R.id.txt_peso_item_imc);
            txtEstatura = (TextView) itemView.findViewById(R.id.txt_estatura_item_imc);
            txtResultado = (TextView) itemView.findViewById(R.id.txt_resultado_item_imc);
        }
    }
}
