package com.example.app_pets;


import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;


import com.example.app_pets.data.AlarmReminderContract;
import com.example.app_pets.data.AlarmReminderDbHelper;
import com.github.clans.fab.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link alarma_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class alarma_fragment extends Fragment implements androidx.loader.app.LoaderManager.LoaderCallbacks<Cursor> {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View vista;

    private FloatingActionButton mAddReminderButton;
    private Toolbar mToolbar;
    AlarmCursorAdapter mCursorAdapter;
    AlarmReminderDbHelper alarmReminderDbHelper = new AlarmReminderDbHelper(getContext());
    ListView reminderListView;
    ProgressDialog prgDialog;

    private static final int VEHICLE_LOADER = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public alarma_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment alarma_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static alarma_fragment newInstance(String param1, String param2) {
        alarma_fragment fragment = new alarma_fragment();
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
        vista = inflater.inflate(R.layout.fragment_alarma, container, false);

        //mToolbar = vista.findViewById(R.id.toolbar);
        //((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        //mToolbar.setTitle(R.string.app_name);


        reminderListView = (ListView) vista.findViewById(R.id.list);
        View emptyView = vista.findViewById(R.id.empty_view);
        reminderListView.setEmptyView(emptyView);

        mCursorAdapter = new AlarmCursorAdapter(getContext(), null);
        reminderListView.setAdapter(mCursorAdapter);

        reminderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), AddReminderActivity.class);

                Uri currentVehicleUri = ContentUris.withAppendedId(AlarmReminderContract.AlarmReminderEntry.CONTENT_URI, id);

                // Set the URI on the data field of the intent
                intent.setData(currentVehicleUri);

                startActivity(intent);

            }
        });


       //mAddReminderButton = (FloatingActionButton) vista.findViewById(R.id.fab);

       /* mAddReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddReminderActivity.class);
                startActivity(intent);
            }
        });*/

        //getLoaderManager().initLoader(VEHICLE_LOADER, null,this);
        LoaderManager.getInstance(this).initLoader(VEHICLE_LOADER,null,this);
        return vista;
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        String[] projection = {
                AlarmReminderContract.AlarmReminderEntry._ID,
                AlarmReminderContract.AlarmReminderEntry.KEY_TITLE,
                AlarmReminderContract.AlarmReminderEntry.KEY_DATE,
                AlarmReminderContract.AlarmReminderEntry.KEY_TIME,
                AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT,
                AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT_NO,
                AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT_TYPE,
                AlarmReminderContract.AlarmReminderEntry.KEY_ACTIVE

        };
        return new CursorLoader(getContext(),
                AlarmReminderContract.AlarmReminderEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        mCursorAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mCursorAdapter.swapCursor(null);
    }
}