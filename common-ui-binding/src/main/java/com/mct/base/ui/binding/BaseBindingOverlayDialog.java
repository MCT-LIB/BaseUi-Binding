package com.mct.base.ui.binding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.mct.base.ui.BaseOverlayDialog;

public abstract class BaseBindingOverlayDialog<B extends ViewDataBinding>
        extends BaseOverlayDialog implements BindingProvider<B> {

    protected B binding;

    @Nullable
    @Override
    protected final View onCreateView(@NonNull LayoutInflater inflater) {
        binding = BindingUtils.inflate(getBindingClass(), inflater);
        return binding != null ? binding.getRoot() : null;
    }

    /* --- Constructor --- */
    public BaseBindingOverlayDialog(@NonNull Context context) {
        super(context);
    }

}
