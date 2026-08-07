package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;
import com.box.android.base.presentation.views.LinearLayoutWithOverlayWarning;

/* JADX INFO: loaded from: classes9.dex */
public final class MainBottomSheetRedesignedBinding implements ViewBinding {
    public final LinearLayoutWithOverlayWarning bottomSheet;
    public final RecyclerView recyclerView;
    private final LinearLayoutWithOverlayWarning rootView;

    private MainBottomSheetRedesignedBinding(LinearLayoutWithOverlayWarning linearLayoutWithOverlayWarning, LinearLayoutWithOverlayWarning linearLayoutWithOverlayWarning2, RecyclerView recyclerView) {
        this.rootView = linearLayoutWithOverlayWarning;
        this.bottomSheet = linearLayoutWithOverlayWarning2;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutWithOverlayWarning getRoot() {
        return this.rootView;
    }

    public static MainBottomSheetRedesignedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MainBottomSheetRedesignedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.main_bottom_sheet_redesigned, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MainBottomSheetRedesignedBinding bind(View view) {
        LinearLayoutWithOverlayWarning linearLayoutWithOverlayWarning = (LinearLayoutWithOverlayWarning) view;
        int i = R.id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            return new MainBottomSheetRedesignedBinding(linearLayoutWithOverlayWarning, linearLayoutWithOverlayWarning, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
