package com.navigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentSlideshow extends Fragment {


    public FragmentSlideshow() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_slideshow, container, false);
        container.removeAllViews(); //ESTA LINEA DE CODIGO
        return view;
    }

}
