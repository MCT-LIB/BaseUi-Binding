package com.mct.base.demo.fragment.test.dialog;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mct.base.demo.databinding.BtsTestBinding;
import com.mct.base.ui.binding.BaseBindingOverlayDialog;

public class RoundedCornerBottomSheet extends BaseBindingOverlayDialog<BtsTestBinding> {

    public RoundedCornerBottomSheet(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    protected Class<BtsTestBinding> getBindingClass() {
        return BtsTestBinding.class;
    }

    @Override
    protected AppCompatDialog onCreateDialog(Context context) {
        return new BottomSheetDialog(context);
    }

    @Override
    protected void onDialogCreated(@NonNull AppCompatDialog dialog, @NonNull View view) {
        binding.tvTitle.setText(getClass().getSimpleName());
    }

    @Nullable
    @Override
    protected DialogOption onCreateDialogOption() {
        return new DialogOption.Builder()
                .setCornerRadius(16)
                .build();
    }

}
