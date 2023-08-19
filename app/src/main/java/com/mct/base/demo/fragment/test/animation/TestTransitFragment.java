package com.mct.base.demo.fragment.test.animation;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mct.base.demo.R;
import com.mct.base.demo.databinding.FragmentTestTransitBinding;
import com.mct.base.ui.binding.BaseBindingFragment;

public class TestTransitFragment extends BaseBindingFragment<FragmentTestTransitBinding> {

    @NonNull
    @Override
    protected Class<FragmentTestTransitBinding> getBindingClass() {
        return FragmentTestTransitBinding.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbar.setNavigationOnClickListener(v -> extraTransaction().popFragment());
        childExtraTransaction().replaceFragment(new TestTransitBodyFragment());
    }

    @Override
    public int getContainerId() {
        return R.id.test_container;
    }
}
