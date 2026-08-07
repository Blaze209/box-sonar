package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.box.android.browse.R;

/* JADX INFO: loaded from: classes10.dex */
public final class BoxBrowsesdkListItemProgressBarBinding implements ViewBinding {
    private final RelativeLayout rootView;

    private BoxBrowsesdkListItemProgressBarBinding(RelativeLayout relativeLayout) {
        this.rootView = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BoxBrowsesdkListItemProgressBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxBrowsesdkListItemProgressBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.box_browsesdk_list_item_progress_bar, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxBrowsesdkListItemProgressBarBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new BoxBrowsesdkListItemProgressBarBinding((RelativeLayout) view);
    }
}
