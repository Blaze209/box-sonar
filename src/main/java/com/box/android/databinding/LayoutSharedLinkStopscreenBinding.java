package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class LayoutSharedLinkStopscreenBinding implements ViewBinding {
    private final ScrollView rootView;
    public final Button stopScreenRedirect;
    public final Button stopScreenTryDifferentAccount;
    public final TextView stopScreenTxt;

    private LayoutSharedLinkStopscreenBinding(ScrollView scrollView, Button button, Button button2, TextView textView) {
        this.rootView = scrollView;
        this.stopScreenRedirect = button;
        this.stopScreenTryDifferentAccount = button2;
        this.stopScreenTxt = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static LayoutSharedLinkStopscreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutSharedLinkStopscreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_shared_link_stopscreen, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutSharedLinkStopscreenBinding bind(View view) {
        int i = R.id.stop_screen_redirect;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.stop_screen_redirect);
        if (button != null) {
            i = R.id.stop_screen_try_different_account;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.stop_screen_try_different_account);
            if (button2 != null) {
                i = R.id.stop_screen_txt;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.stop_screen_txt);
                if (textView != null) {
                    return new LayoutSharedLinkStopscreenBinding((ScrollView) view, button, button2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
