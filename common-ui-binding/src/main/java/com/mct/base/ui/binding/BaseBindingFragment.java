package com.mct.base.ui.binding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.mct.base.ui.BaseFragment;

public abstract class BaseBindingFragment<B extends ViewDataBinding>
        extends BaseFragment implements BindingProvider<B> {

    protected B binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BindingUtils.inflate(getBindingClass(), inflater, container, false);
        return binding != null ? binding.getRoot() : null;
    }
}
