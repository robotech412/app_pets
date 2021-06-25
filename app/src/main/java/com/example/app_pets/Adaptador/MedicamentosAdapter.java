package com.example.app_pets.Adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_pets.R;
import com.example.app_pets.model.Medicamento;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class MedicamentosAdapter extends FirestoreRecyclerAdapter<Medicamento,MedicamentosAdapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MedicamentosAdapter(@NonNull FirestoreRecyclerOptions<Medicamento> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int position, @NonNull Medicamento medicamento) {
        viewHolder.textViewMarca.setText(medicamento.getMarca());
        viewHolder.textViewNombre.setText(medicamento.getNombre());
        viewHolder.textViewCantidad.setText(medicamento.getCantidad());
        viewHolder.textViewUso.setText(medicamento.getUso());
        viewHolder.textViewDescripcion.setText(medicamento.getDescripcion());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_medicamentos,viewGroup,false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewMarca,textViewNombre,textViewCantidad,textViewUso,textViewDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewMarca=itemView.findViewById(R.id.textViewMarca);
            textViewNombre=itemView.findViewById(R.id.textViewNombre);
            textViewCantidad=itemView.findViewById(R.id.textViewCantidad);
            textViewUso=itemView.findViewById(R.id.textViewUso);
            textViewDescripcion=itemView.findViewById(R.id.textViewDescripcion);
        }
    }

}
