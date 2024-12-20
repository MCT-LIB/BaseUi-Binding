package com.mct.base.ui.binding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.mct.base.ui.BaseActivity;

import java.util.Optional;

public abstract class BaseBindingActivity<B extends ViewDataBinding>
        extends BaseActivity implements BindingProvider<B> {

    protected B binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Optional.ofNullable(binding = BindingUtils.inflate(getBindingClass(), getLayoutInflater()))
                .map(ViewDataBinding::getRoot)
                .ifPresent(this::setContentView);
    }

}
