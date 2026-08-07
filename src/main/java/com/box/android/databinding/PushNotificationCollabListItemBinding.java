package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.box.androidsdk.content.views.BoxAvatarView;

/* JADX INFO: loaded from: classes11.dex */
public final class PushNotificationCollabListItemBinding implements ViewBinding {
    public final AppCompatImageView badgeMuted;
    public final TextView description;
    public final BoxAvatarView initials;
    private final RelativeLayout rootView;
    public final AppCompatImageButton secondaryAction;
    public final TextView timestamp;

    private PushNotificationCollabListItemBinding(RelativeLayout relativeLayout, AppCompatImageView appCompatImageView, TextView textView, BoxAvatarView boxAvatarView, AppCompatImageButton appCompatImageButton, TextView textView2) {
        this.rootView = relativeLayout;
        this.badgeMuted = appCompatImageView;
        this.description = textView;
        this.initials = boxAvatarView;
        this.secondaryAction = appCompatImageButton;
        this.timestamp = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PushNotificationCollabListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PushNotificationCollabListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.push_notification_collab_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PushNotificationCollabListItemBinding bind(View view) {
        int i = R.id.badge_muted;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, R.id.badge_muted);
        if (appCompatImageView != null) {
            i = R.id.description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.description);
            if (textView != null) {
                i = R.id.initials;
                BoxAvatarView boxAvatarView = (BoxAvatarView) ViewBindings.findChildViewById(view, R.id.initials);
                if (boxAvatarView != null) {
                    i = R.id.secondaryAction;
                    AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, R.id.secondaryAction);
                    if (appCompatImageButton != null) {
                        i = R.id.timestamp;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.timestamp);
                        if (textView2 != null) {
                            return new PushNotificationCollabListItemBinding((RelativeLayout) view, appCompatImageView, textView, boxAvatarView, appCompatImageButton, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
