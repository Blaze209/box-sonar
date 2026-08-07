package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class ViewCollaboratorsInitialBinding implements ViewBinding {
    public final ProgressBar boxSharesdkActivityProgressBar;
    public final LinearLayout collaboratorInitialsListSection;
    public final LinearLayout inviteCollaboratorInitialsList;
    public final TextView inviteCollaboratorInitialsListHeader;
    public final TextView noCollaboratorsText;
    private final LinearLayout rootView;

    private ViewCollaboratorsInitialBinding(LinearLayout linearLayout, ProgressBar progressBar, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.boxSharesdkActivityProgressBar = progressBar;
        this.collaboratorInitialsListSection = linearLayout2;
        this.inviteCollaboratorInitialsList = linearLayout3;
        this.inviteCollaboratorInitialsListHeader = textView;
        this.noCollaboratorsText = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewCollaboratorsInitialBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCollaboratorsInitialBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_collaborators_initial, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewCollaboratorsInitialBinding bind(View view) {
        int i = R.id.box_sharesdk_activity_progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
        if (progressBar != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.invite_collaborator_initials_list;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.invite_collaborator_initials_list_header;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.no_collaborators_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new ViewCollaboratorsInitialBinding(linearLayout, progressBar, linearLayout, linearLayout2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
