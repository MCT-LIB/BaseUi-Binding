package com.mct.base.demo.fragment.test.dialog;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.databinding.ViewDataBinding;

import com.mct.base.ui.binding.BaseBindingOverlayDialog;

public class NormalDialog extends BaseBindingOverlayDialog<ViewDataBinding> {

    public NormalDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public Class<ViewDataBinding> getBindingClass() {
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

    @Nullable
    @Override
    protected DialogOption onCreateDialogOption() {
        return new DialogOption.Builder()
                .setBackgroundColor(Color.WHITE)
                .build();
    }

}
