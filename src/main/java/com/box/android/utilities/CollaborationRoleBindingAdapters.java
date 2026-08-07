package com.box.android.utilities;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.box.android.R;
import com.box.android.databinding.UsxRadioItemRolesBinding;
import com.box.android.usx.fragments.CollaboratorsRolesFragment;
import com.box.androidsdk.content.models.BoxCollaboration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class CollaborationRoleBindingAdapters {
    /* JADX WARN: Code duplicated, block: B:12:0x004b  */
    /* JADX WARN: Code duplicated, block: B:14:0x007c  */
    /* JADX WARN: Code duplicated, block: B:15:0x007e  */
    public static void populateRadioGroup(RadioGroup radioGroup, List list, boolean z, boolean z2, final LiveData<BoxCollaboration.Role> liveData, TextView textView, final CollaboratorsRolesFragment.RoleUpdateNotifier roleUpdateNotifier) {
        boolean z3;
        Context context = radioGroup.getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        radioGroup.addView(linearLayout);
        final HashSet hashSet = new HashSet();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.box.android.utilities.CollaborationRoleBindingAdapters$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollaborationRoleBindingAdapters.lambda$populateRadioGroup$0(roleUpdateNotifier, liveData, hashSet, view);
            }
        };
        BoxCollaboration.Role[] roleArrValues = BoxCollaboration.Role.values();
        int length = roleArrValues.length;
        ViewGroup viewGroup = null;
        UsxRadioItemRolesBinding usxRadioItemRolesBinding = null;
        int i = 0;
        while (i < length) {
            BoxCollaboration.Role role = roleArrValues[i];
            if (role == BoxCollaboration.Role.OWNER) {
                if (z) {
                    View viewInflate = ((Activity) context).getLayoutInflater().inflate(R.layout.usx_radio_item_roles, viewGroup);
                    usxRadioItemRolesBinding = (UsxRadioItemRolesBinding) DataBindingUtil.bind(viewInflate);
                    usxRadioItemRolesBinding.setRoleName(CollaborationUtils.getRoleName(context, role));
                    usxRadioItemRolesBinding.setRoleDescription(CollaborationUtils.getRoleDescription(context, role));
                    usxRadioItemRolesBinding.setRoleTag(role);
                    usxRadioItemRolesBinding.setListener(onClickListener);
                    usxRadioItemRolesBinding.setRoleOptions(hashSet);
                    if (role == liveData.getValue()) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    usxRadioItemRolesBinding.setCheckRole(z3);
                    linearLayout.addView(viewInflate);
                    usxRadioItemRolesBinding.setIsLastDivider(false);
                }
            } else if (list.contains(role)) {
                View viewInflate2 = ((Activity) context).getLayoutInflater().inflate(R.layout.usx_radio_item_roles, viewGroup);
                usxRadioItemRolesBinding = (UsxRadioItemRolesBinding) DataBindingUtil.bind(viewInflate2);
                usxRadioItemRolesBinding.setRoleName(CollaborationUtils.getRoleName(context, role));
                usxRadioItemRolesBinding.setRoleDescription(CollaborationUtils.getRoleDescription(context, role));
                usxRadioItemRolesBinding.setRoleTag(role);
                usxRadioItemRolesBinding.setListener(onClickListener);
                usxRadioItemRolesBinding.setRoleOptions(hashSet);
                if (role == liveData.getValue()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                usxRadioItemRolesBinding.setCheckRole(z3);
                linearLayout.addView(viewInflate2);
                usxRadioItemRolesBinding.setIsLastDivider(false);
            }
            i++;
            viewGroup = null;
        }
        if (usxRadioItemRolesBinding != null) {
            usxRadioItemRolesBinding.setIsLastDivider(true);
        }
        if (z2) {
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.utilities.CollaborationRoleBindingAdapters$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    roleUpdateNotifier.notifyRemove();
                }
            });
        }
    }

    static /* synthetic */ void lambda$populateRadioGroup$0(CollaboratorsRolesFragment.RoleUpdateNotifier roleUpdateNotifier, LiveData liveData, HashSet hashSet, View view) {
        BoxCollaboration.Role role = (BoxCollaboration.Role) view.getTag();
        roleUpdateNotifier.setRole(role);
        ((MutableLiveData) liveData).postValue(role);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            RadioButton radioButton = (RadioButton) it.next();
            radioButton.setChecked(role == ((BoxCollaboration.Role) radioButton.getTag()));
        }
    }

    public static void addRoleOption(RadioButton radioButton, HashSet hashSet) {
        hashSet.add(radioButton);
    }

    public static void setNoPermissionTextForShareLink(TextView textView, BoxCollaboration.Role role, String str) {
        String string;
        Context context = textView.getContext();
        String string2 = context.getResources().getString(translatedType(str));
        String roleName = role != null ? CollaborationUtils.getRoleName(context, role) : "";
        if (roleName.isEmpty()) {
            string = context.getResources().getString(R.string.box_share_sdk_no_permission_share_link_no_role);
        } else {
            string = context.getResources().getString(R.string.box_share_sdk_no_permission_share_link, roleName, string2);
        }
        textView.setText(string);
    }

    public static void setNoInviteTextForShareLink(TextView textView, BoxCollaboration.Role role, String str) {
        String string;
        Context context = textView.getContext();
        String string2 = context.getResources().getString(translatedType(str));
        String roleName = role != null ? CollaborationUtils.getRoleName(context, role) : "";
        if (roleName.isEmpty()) {
            string = context.getResources().getString(R.string.box_share_sdk_no_permission_invite_people_no_role);
        } else {
            string = context.getResources().getString(R.string.box_share_sdk_no_permission_invite_people, roleName, string2);
        }
        textView.setText(string);
    }

    private static int translatedType(String str) {
        if (str.equals("folder")) {
            return R.string.box_sharesdk_item_type_folder;
        }
        return str.equals("file") ? R.string.box_sharesdk_item_type_file : R.string.box_sharesdk_item_type_default;
    }
}
