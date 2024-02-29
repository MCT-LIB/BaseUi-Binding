package com.mct.base.ui.binding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.mct.base.ui.BaseActivity;

public abstract class BaseBindingActivity<B extends ViewDataBinding>
        extends BaseActivity implements BindingProvider<B> {

    protected B binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = BindingUtils.inflate(getBindingClass(), getLayoutInflater());
        if (binding != null) {
            setContentView(binding.getRoot());
        }
    }

}
