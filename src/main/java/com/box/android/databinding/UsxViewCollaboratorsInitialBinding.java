package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class UsxViewCollaboratorsInitialBinding implements ViewBinding {
    public final ProgressBar boxSharesdkActivityProgressBar;
    public final LinearLayout collaboratorInitialsListSection;
    public final TextView collabsCount;
    public final LinearLayout inviteCollaboratorInitialsList;
    private final LinearLayout rootView;

    private UsxViewCollaboratorsInitialBinding(LinearLayout linearLayout, ProgressBar progressBar, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.boxSharesdkActivityProgressBar = progressBar;
        this.collaboratorInitialsListSection = linearLayout2;
        this.collabsCount = textView;
        this.inviteCollaboratorInitialsList = linearLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UsxViewCollaboratorsInitialBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UsxViewCollaboratorsInitialBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.usx_view_collaborators_initial, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UsxViewCollaboratorsInitialBinding bind(View view) {
        int i = R.id.box_sharesdk_activity_progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.box_sharesdk_activity_progress_bar);
        if (progressBar != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.collabsCount;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.collabsCount);
            if (textView != null) {
                i = R.id.invite_collaborator_initials_list;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.invite_collaborator_initials_list);
                if (linearLayout2 != null) {
                    return new UsxViewCollaboratorsInitialBinding(linearLayout, progressBar, linearLayout, textView, linearLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
