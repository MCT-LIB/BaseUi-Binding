package com.mct.base.demo.fragment.test.dialog;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.databinding.ViewDataBinding;

import com.mct.base.ui.binding.BaseBindingOverlayDialog;

public class RoundedCornerDialog extends BaseBindingOverlayDialog<ViewDataBinding> {

    public RoundedCornerDialog(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    protected Class<ViewDataBinding> getBindingClass() {
        return ViewDataBinding.class;
    }

    @Override
    protected AppCompatDialog onCreateDialog(Context context) {
        return new AlertDialog.Builder(context)
                .setTitle(getClass().getSimpleName())
                .setMessage("Lorem Ipsum is simply dummy text of the printing and typesetting industry.")
                .setPositiveButton("Ok", (dialog, which) -> dismiss())
                .create();
    }

    @Override
    protected void onDialogCreated(@NonNull AppCompatDialog dialog, View view) {
    }

    @Nullable
    @Override
    protected DialogOption onCreateDialogOption() {
        return new DialogOption.Builder()
                .setCornerRadius(16)
                .build();
    }

}
