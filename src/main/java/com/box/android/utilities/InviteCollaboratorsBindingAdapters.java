package com.box.android.utilities;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.box.android.coreservices.models.BoxInvitee;
import com.box.android.usx.adapters.InviteeAdapter;
import com.box.android.usx.views.ChipCollaborationView;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.utils.SdkUtils;
import com.tokenautocomplete.CharacterTokenizer;
import com.tokenautocomplete.TokenCompleteTextView;

/* JADX INFO: loaded from: classes13.dex */
public class InviteCollaboratorsBindingAdapters {
    public static void onEmptyAndUnfocused(final EditText editText, final View view, final View view2, final View view3) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.box.android.utilities.InviteCollaboratorsBindingAdapters$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view4, boolean z) {
                InviteCollaboratorsBindingAdapters.lambda$onEmptyAndUnfocused$0(view, view2, view3, editText, view4, z);
            }
        });
    }

    static /* synthetic */ void lambda$onEmptyAndUnfocused$0(View view, View view2, View view3, EditText editText, View view4, boolean z) {
        if (z || !((EditText) view4).getText().toString().isEmpty()) {
            return;
        }
        view.setVisibility(8);
        view2.setVisibility(0);
        view3.setVisibility(8);
        editText.setVisibility(8);
    }

    public static void onAddPersonalMessageBottom(final Button button, final View view, final View view2, final View view3) {
        button.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.utilities.InviteCollaboratorsBindingAdapters$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                InviteCollaboratorsBindingAdapters.lambda$onAddPersonalMessageBottom$1(view, view2, view3, button, view4);
            }
        });
    }

    static /* synthetic */ void lambda$onAddPersonalMessageBottom$1(View view, View view2, View view3, Button button, View view4) {
        view.setVisibility(0);
        view2.setVisibility(0);
        view3.setVisibility(0);
        button.setVisibility(8);
        view.requestFocus();
    }

    public static void setRoleName(TextView textView, BoxCollaboration.Role role) {
        if (role != null) {
            textView.setText(CollaborationUtils.getRoleName(textView.getContext(), role));
        }
    }

    public static void setRoleDescription(TextView textView, BoxCollaboration.Role role) {
        if (role != null) {
            textView.setText(CollaborationUtils.getRoleDescription(textView.getContext(), role));
        }
    }

    public static void setInitialsThumnb(TextView textView, String str) {
        SdkUtils.setInitialsThumb(textView.getContext(), textView, str);
    }

    public static void setAdaptersAndListeners(ChipCollaborationView chipCollaborationView, InviteeAdapter inviteeAdapter, CharacterTokenizer characterTokenizer, TokenCompleteTextView.TokenListener<BoxInvitee> tokenListener) {
        chipCollaborationView.setAdapter(inviteeAdapter);
        chipCollaborationView.setTokenizer(characterTokenizer);
        chipCollaborationView.setTokenListener(tokenListener);
    }
}
