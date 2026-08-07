package com.box.android.preview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.presentation.views.TouchInterceptorViewGroup;
import com.box.android.preview.R;

/* JADX INFO: loaded from: classes12.dex */
public final class PdfFragmentContainerBinding implements ViewBinding {
    public final FragmentContainerView fragmentContainerView;
    private final TouchInterceptorViewGroup rootView;

    private PdfFragmentContainerBinding(TouchInterceptorViewGroup touchInterceptorViewGroup, FragmentContainerView fragmentContainerView) {
        this.rootView = touchInterceptorViewGroup;
        this.fragmentContainerView = fragmentContainerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TouchInterceptorViewGroup getRoot() {
        return this.rootView;
    }

    public static PdfFragmentContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PdfFragmentContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.pdf_fragment_container, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PdfFragmentContainerBinding bind(View view) {
        int i = R.id.fragment_container_view;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
        if (fragmentContainerView != null) {
            return new PdfFragmentContainerBinding((TouchInterceptorViewGroup) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
