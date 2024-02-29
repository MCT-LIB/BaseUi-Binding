package com.mct.base.demo.fragment.test.animation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.mct.base.demo.R;
import com.mct.base.demo.databinding.FragmentTestAnimBinding;
import com.mct.base.demo.utils.Utils;
import com.mct.base.ui.binding.BaseBindingFragment;
import com.mct.base.ui.transition.FragmentTransitionFactory;

public class TestAnimFragment extends BaseBindingFragment<FragmentTestAnimBinding> implements View.OnClickListener {

    int color = Utils.generateBrightColor();

    @NonNull
    @Override
    public Class<FragmentTestAnimBinding> getBindingClass() {
        return FragmentTestAnimBinding.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(color);

        binding.toolbar.setNavigationOnClickListener(v -> extraTransaction().popFragment());

        binding.btnTransit.setOnClickListener(this);
        binding.btn3dAnim.setOnClickListener(this);
        binding.btnCircular.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(@NonNull View v) {
        switch (v.getId()) {
            case R.id.btn_transit:
                extraTransaction().replaceFragmentToStack(
                        new TestTransitFragment(),
                        FragmentTransitionFactory.createTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                );
                break;
            case R.id.btn_3d_anim:
                extraTransaction().replaceFragmentToStack(
                        new Test3DAnimationFragment(),
                        FragmentTransitionFactory.createTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                );
                break;
            case R.id.btn_circular:
                extraTransaction().replaceFragmentToStack(
                        new TestCircularRevealFragment(),
                        FragmentTransitionFactory.createTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                );
                break;
        }
    }
}
