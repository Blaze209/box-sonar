package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class UsxViewActionBarBinding implements ViewBinding {
    public final Toolbar boxActionBar;
    private final Toolbar rootView;

    private UsxViewActionBarBinding(Toolbar toolbar, Toolbar toolbar2) {
        this.rootView = toolbar;
        this.boxActionBar = toolbar2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public Toolbar getRoot() {
        return this.rootView;
    }

    public static UsxViewActionBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UsxViewActionBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.usx_view_action_bar, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UsxViewActionBarBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        Toolbar toolbar = (Toolbar) view;
        return new UsxViewActionBarBinding(toolbar, toolbar);
    }
}
