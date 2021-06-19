package com.example.app_pets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_pets.model.Medicamento;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link vista_medFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class vista_medFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View vista;
    RecyclerView recyclerViewMedicamentos;
    MedicamentosAdapter mAdapter;
    FirebaseFirestore mFirestore;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public vista_medFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment vista_medFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static vista_medFragment newInstance(String param1, String param2) {
        vista_medFragment fragment = new vista_medFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_vista_med, container, false);
        recyclerViewMedicamentos =  vista.findViewById(R.id.recyclerMedicamentos);
        recyclerViewMedicamentos.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFirestore=FirebaseFirestore.getInstance();

        Query query= mFirestore.collection("Medicamentos");

        FirestoreRecyclerOptions<Medicamento>firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Medicamento>()
                .setQuery(query,Medicamento.class).build();

        mAdapter = new MedicamentosAdapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        recyclerViewMedicamentos.setAdapter(mAdapter);
        return vista;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }
}