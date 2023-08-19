package com.mct.base.ui.binding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.mct.base.ui.BaseActivity;

public abstract class BaseBindingActivity<B extends ViewDataBinding> extends BaseActivity {

    protected B binding;

    ///////////////////////////////////////////////////////////////////////////
    // Abstract
    ///////////////////////////////////////////////////////////////////////////

    @NonNull
    protected abstract Class<B> getBindingClass();

    ///////////////////////////////////////////////////////////////////////////
    // LifeCircle
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = BindingUtils.inflate(getBindingClass(), getLayoutInflater());
        if (binding != null) {
            setContentView(binding.getRoot());
        }
    }

}
