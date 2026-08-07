package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class ScannedPageBinding implements ViewBinding {
    public final ImageView pageImage;
    private final ImageView rootView;

    private ScannedPageBinding(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.pageImage = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }

    public static ScannedPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ScannedPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.scanned_page, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ScannedPageBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ImageView imageView = (ImageView) view;
        return new ScannedPageBinding(imageView, imageView);
    }
}
