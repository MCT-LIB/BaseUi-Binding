package com.mct.base.demo.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.mct.base.demo.databinding.FragmentMainBinding;
import com.mct.base.demo.fragment.test.animation.TestAnimFragment;
import com.mct.base.demo.fragment.test.dialog.TestDialogFragment;
import com.mct.base.demo.fragment.test.transaction.TestTransactionFragment;
import com.mct.base.demo.utils.Utils;
import com.mct.base.ui.binding.BaseBindingFragment;
import com.mct.base.ui.transition.FragmentTransitionFactory;
import com.mct.base.ui.transition.annotation.AnimationStyle;
import com.mct.base.ui.transition.options.AnimOptions;

public class MainFragment extends BaseBindingFragment<FragmentMainBinding> {

    int color = Utils.generateBrightColor();

    @NonNull
    @Override
    public Class<FragmentMainBinding> getBindingClass() {
        return FragmentMainBinding.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(color);
        binding.btnTestBackstack.setOnClickListener(v -> extraTransaction().addFragmentToStack(
                new TestTransactionFragment(),
                //FragmentTransitionFactory.createTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE))
                FragmentTransitionFactory.createTransition(
                        AnimOptions.animation(AnimationStyle.MOVE).overlay().left().build(),
                        AnimOptions.animation(AnimationStyle.NONE).build(),
                        AnimOptions.animation(AnimationStyle.NONE).build(),
                        AnimOptions.animation(AnimationStyle.MOVE).overlay().right().build()
                )
        ));
        binding.btnTestAnimation.setOnClickListener(v -> extraTransaction().replaceFragmentToStack(
                new TestAnimFragment(),
                FragmentTransitionFactory.createTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        ));
        binding.btnTestDialog.setOnClickListener(v -> extraTransaction().replaceFragmentToStack(
                new TestDialogFragment(),
                FragmentTransitionFactory.createTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        ));
    }
}
