package com.mct.base.demo;

import android.os.Bundle;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.mct.base.demo.fragment.MainFragment;
import com.mct.base.ui.binding.BaseBindingActivity;

public class MainActivity extends BaseBindingActivity<ViewDataBinding> {

    @NonNull
    @Override
    protected Class<ViewDataBinding> getBindingClass() {
        return ViewDataBinding.class;
    }

    @Override
    protected int getContainerId() {
        return Window.ID_ANDROID_CONTENT;
    }

    @Override
    protected boolean showToastOnBackPressed() {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extraTransaction().replaceFragment(new MainFragment());
    }

}