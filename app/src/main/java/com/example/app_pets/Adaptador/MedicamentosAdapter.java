package com.example.app_pets.Adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_pets.R;
import com.example.app_pets.model.Medicamento;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MedicamentosAdapter extends FirestoreRecyclerAdapter<Medicamento, MedicamentosAdapter.ViewHolder> {

    Activity activity;
    FirebaseFirestore db;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MedicamentosAdapter(@NonNull FirestoreRecyclerOptions<Medicamento> options) {
        super(options);
        db = FirebaseFirestore.getInstance();
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int position, @NonNull Medicamento medicamento) {
        viewHolder.textViewMarca.setText(medicamento.getMarca());
        viewHolder.textViewNombre.setText(medicamento.getNombre());
        viewHolder.textViewCantidad.setText(medicamento.getCantidad());
        viewHolder.textViewUso.setText(medicamento.getUso());
        viewHolder.textViewDescripcion.setText(medicamento.getDescripcion());

        DocumentSnapshot MedicamentoDocument = getSnapshots().getSnapshot(viewHolder.getAdapterPosition());

        final String id = MedicamentoDocument.getId();

        viewHolder.btnElininar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("Medicamentos").document(id).delete();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_medicamentos, viewGroup, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewMarca, textViewNombre, textViewCantidad, textViewUso, textViewDescripcion;
        Button btnElininar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewMarca = itemView.findViewById(R.id.textViewMarca);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewCantidad = itemView.findViewById(R.id.textViewCantidad);
            textViewUso = itemView.findViewById(R.id.textViewUso);
            textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);
            btnElininar = itemView.findViewById(R.id.btn_eliminar_med);
        }
    }

}
