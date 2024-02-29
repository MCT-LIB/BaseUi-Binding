package com.mct.base.demo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.mct.base.demo.fragment.MainFragment;
import com.mct.base.ui.binding.BaseBindingActivity;

public class MainActivity extends BaseBindingActivity<ViewDataBinding> {

    @NonNull
    @Override
    public Class<ViewDataBinding> getBindingClass() {
        return ViewDataBinding.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extraTransaction().replaceFragment(new MainFragment());
    }

}