package salt.movil.imcproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

import salt.movil.imcproject.R;
import salt.movil.imcproject.adapters.ImcAdapter;
import salt.movil.imcproject.models.ImcItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistorialFragment extends Fragment {

    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    public HistorialFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historial, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_list_imc);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        Iterator<ImcItem> data = ImcItem.findAll(ImcItem.class);
        List<ImcItem> data1 = Lists.newArrayList(data);

        ImcAdapter imcAdapter = new ImcAdapter(data1);
        mRecyclerView.setAdapter(imcAdapter);

        return view;
    }

}
