package com.example.book.buttomfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.book.R;

public class BookRackFragment extends Fragment {
    private Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bookrackfragment,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        toolbar=view.findViewById(R.id.toolbar_bookrackfragment);
        toolbar.setTitle("书架");
    }
}
