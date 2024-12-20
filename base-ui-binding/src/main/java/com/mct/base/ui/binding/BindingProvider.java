package com.mct.base.ui.binding;

import androidx.databinding.ViewDataBinding;

public interface BindingProvider<B extends ViewDataBinding> {
    Class<B> getBindingClass();
}
