package com.mct.base.ui.binding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;

import com.mct.base.ui.BaseOverlayDialog;

public abstract class BaseBindingOverlayDialog<B extends ViewDataBinding> extends BaseOverlayDialog {

    protected B binding;

    public BaseBindingOverlayDialog(@NonNull Context context) {
        this(context, null);
    }

    public BaseBindingOverlayDialog(@NonNull Context context, Lifecycle lifecycle) {
        super(context, lifecycle);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Abstract
    ///////////////////////////////////////////////////////////////////////////

    @NonNull
    protected abstract Class<B> getBindingClass();

    ///////////////////////////////////////////////////////////////////////////
    // Override
    ///////////////////////////////////////////////////////////////////////////

    @Nullable
    @Override
    protected final View onCreateView(@NonNull LayoutInflater inflater) {
        binding = BindingUtils.inflate(getBindingClass(), inflater);
        return binding != null ? binding.getRoot() : null;
    }
}
