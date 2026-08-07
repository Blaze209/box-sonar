package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class RecordingNotificationBigBinding implements ViewBinding {
    public final TextView notificationTitle;
    public final Button recordingAction;
    private final RelativeLayout rootView;

    private RecordingNotificationBigBinding(RelativeLayout relativeLayout, TextView textView, Button button) {
        this.rootView = relativeLayout;
        this.notificationTitle = textView;
        this.recordingAction = button;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RecordingNotificationBigBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RecordingNotificationBigBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.recording_notification_big, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RecordingNotificationBigBinding bind(View view) {
        int i = R.id.notification_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.recording_action;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                return new RecordingNotificationBigBinding((RelativeLayout) view, textView, button);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
