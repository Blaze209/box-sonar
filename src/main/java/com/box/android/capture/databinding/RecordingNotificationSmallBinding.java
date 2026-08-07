package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class RecordingNotificationSmallBinding implements ViewBinding {
    public final TextView notificationTitle;
    private final RelativeLayout rootView;

    private RecordingNotificationSmallBinding(RelativeLayout relativeLayout, TextView textView) {
        this.rootView = relativeLayout;
        this.notificationTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RecordingNotificationSmallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RecordingNotificationSmallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.recording_notification_small, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RecordingNotificationSmallBinding bind(View view) {
        int i = R.id.notification_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new RecordingNotificationSmallBinding((RelativeLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
