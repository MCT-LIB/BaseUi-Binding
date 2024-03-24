package com.mct.base.ui.binding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.mct.base.ui.BaseOverlayDialog;

import java.util.Optional;

public abstract class BaseBindingOverlayDialog<B extends ViewDataBinding>
        extends BaseOverlayDialog implements BindingProvider<B> {

    protected B binding;

    @Override
    protected final View onCreateView(@NonNull LayoutInflater inflater) {
        return Optional.ofNullable(binding = BindingUtils.inflate(getBindingClass(), inflater))
                .map(ViewDataBinding::getRoot)
                .orElse(null);
    }

    /* --- Constructor --- */
    public BaseBindingOverlayDialog(@NonNull Context context) {
        super(context);
    }

}
