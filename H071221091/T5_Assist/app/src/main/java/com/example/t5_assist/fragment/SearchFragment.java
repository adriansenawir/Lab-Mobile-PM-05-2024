package com.example.t5_assist.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t5_assist.DataSource;
import com.example.t5_assist.Instagram;
import com.example.t5_assist.R;
import com.example.t5_assist.SeacrhAdapter;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private ArrayList<Instagram> instagramList;
    private SeacrhAdapter adapter;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        Mendapatkan referensi ke RecyclerView dan ProgressBar dari tampilan
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar = view.findViewById(R.id.progressBar);
// Membuat daftar Instagram dan adapter untuk RecyclerView
        instagramList = new ArrayList<>();
        adapter = new SeacrhAdapter(instagramList);
        recyclerView.setAdapter(adapter);
// Mendapatkan referensi ke SearchView dari tampilan dan menambahkan listener untuk pembaruan teks pencarian:
        androidx.appcompat.widget.SearchView searchView = view.findViewById(R.id.search_view);
        searchView.setIconifiedByDefault(false);

        // Ubah perilaku pencarian saat teks berubah
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                performSearch(newText);
                return true;
            }
        });
    }

    private void performSearch(String query) { //untuk melakukan pecanrian
        progressBar.setVisibility(View.VISIBLE); //terlihat

        new Thread(() -> {
            ArrayList<Instagram> filteredList = new ArrayList<>();
            if (!query.isEmpty()) {
                for (Instagram item : DataSource.instagrams) {
                    if (item.getUsername().toLowerCase().contains(query.toLowerCase()) ||
                            item.getName().toLowerCase().contains(query.toLowerCase())) {
                        filteredList.add(item);
                    }
                }
            }

            // Menunggu beberapa detik untuk simulasi pencarian
            try {
                Thread.sleep(1000); // Ganti angka 1000 dengan durasi yang diinginkan dalam milidetik
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            requireActivity().runOnUiThread(() -> {
                progressBar.setVisibility(View.GONE);
                instagramList.clear();
                instagramList.addAll(filteredList);
                adapter.notifyDataSetChanged();
            });
        }).start();
    }
}
