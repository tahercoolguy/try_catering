package com.infovass.catering.activities.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.infovass.catering.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetInfoFragment extends BottomSheetDialogFragment {

    public static BottomSheetInfoFragment newInstance() {
        BottomSheetInfoFragment fragment = new BottomSheetInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        View contentView = View.inflate(getContext(), R.layout.fragment_bottomsheet_info, null);
        dialog.setContentView(contentView);
        ((View) contentView.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }

}
