package com.mct.base.demo.fragment.test.animation;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mct.base.demo.R;
import com.mct.base.demo.databinding.FragmentTestCircularRevealBinding;
import com.mct.base.ui.binding.BaseBindingFragment;

public class TestCircularRevealFragment extends BaseBindingFragment<FragmentTestCircularRevealBinding> {

    @NonNull
    @Override
    public Class<FragmentTestCircularRevealBinding> getBindingClass() {
        return FragmentTestCircularRevealBinding.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbar.setNavigationOnClickListener(v -> extraTransaction().popFragment());
        childExtraTransaction().replaceFragment(new TestCircularRevealBodyFragment());
    }

    @Override
    public int getContainerId() {
        return R.id.test_container;
    }
}
