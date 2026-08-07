package com.box.android.base.presentation.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.box.android.base.R;
import com.box.android.coreservices.models.BoxInvitee;
import com.box.androidsdk.content.utils.SdkUtils;
import com.eclipsesource.json.JsonObject;
import com.tokenautocomplete.TokenCompleteTextView;

/* JADX INFO: loaded from: classes9.dex */
public class ChipCollaborationView extends TokenCompleteTextView<BoxInvitee> {
    public ChipCollaborationView(Context context) {
        super(context);
        setLongClickable(true);
    }

    public ChipCollaborationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLongClickable(true);
    }

    public ChipCollaborationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLongClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tokenautocomplete.TokenCompleteTextView
    public View getViewForObject(BoxInvitee boxInvitee) {
        RelativeLayout relativeLayout = (RelativeLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.view_chip_collaboration, (ViewGroup) getParent(), false);
        ((TextView) relativeLayout.findViewById(R.id.name)).setText(boxInvitee.getName());
        SdkUtils.setInitialsThumb(getContext(), (TextView) relativeLayout.findViewById(R.id.collaborator_initials), boxInvitee.getName());
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tokenautocomplete.TokenCompleteTextView
    public BoxInvitee defaultObject(String str) {
        String strReplace = str.replace(" ", "");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("name", strReplace);
        jsonObject.add("email", strReplace);
        BoxInvitee boxInvitee = new BoxInvitee();
        boxInvitee.createFromJson(jsonObject);
        return boxInvitee;
    }
}
