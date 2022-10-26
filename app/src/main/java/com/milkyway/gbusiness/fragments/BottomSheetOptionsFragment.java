package com.milkyway.gbusiness.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.milkyway.gbusiness.R;
import com.milkyway.gbusiness.adaptor.BottomSheetOptionsAdapter;
import com.milkyway.gbusiness.models.BottomSheetOption;

import java.util.ArrayList;


public class BottomSheetOptionsFragment extends BottomSheetDialogFragment implements BottomSheetOptionsAdapter.OnOptionsSelectedListener {
    private static final String TAG = BottomSheetOptionsFragment.class.getSimpleName();
    private ArrayList<BottomSheetOption> mListOptions;
    private OnOptionSelectedListener mListener;

    public BottomSheetOptionsFragment() {
        // Required empty public constructor
    }

    public interface OnOptionSelectedListener {
        void onOptionSelected(int option);
    }

    public static BottomSheetOptionsFragment getInstance(ArrayList<BottomSheetOption> optionList) {
        // Log.i(TAG,"bottom sheet options size, in getInstance  = "+optionList.size());

        BottomSheetOptionsFragment fragmentBottomSheetOptions = new BottomSheetOptionsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("OPTIONS_LIST", optionList);
        fragmentBottomSheetOptions.setArguments(bundle);
        return fragmentBottomSheetOptions;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mListOptions = bundle.getParcelableArrayList("OPTIONS_LIST");
            // Log.i(TAG,"bottom sheet options size = "+mListOptions.size());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_bottom_sheet_options, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Log.i(TAG,"bottom sheet options size, in onViewCreated  = "+mListOptions.size());

        BottomSheetOptionsAdapter adapterBottomSheetOptions = new BottomSheetOptionsAdapter(requireActivity(), mListOptions, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity());
        RecyclerView recyclerView = view.findViewById(R.id.rvOptionSheet);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterBottomSheetOptions);
    }

    @Override
    public void onOptionSelected(int option) {
        if (mListener != null) {
            mListener.onOptionSelected(option);
            dismiss();
        } else
            Log.e(TAG, "mListener is null in onOptionSelected");
    }


    public void setOnBottomSheetOptionSelectedListener(OnOptionSelectedListener onOptionSelectedListener) {
        this.mListener = onOptionSelectedListener;
    }

}
