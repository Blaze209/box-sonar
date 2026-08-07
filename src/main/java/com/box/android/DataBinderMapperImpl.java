package com.box.android;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.box.android.databinding.UsxAccessRadioGroupBindingImpl;
import com.box.android.databinding.UsxFragmentCollaborationRolesBindingImpl;
import com.box.android.databinding.UsxFragmentCollaborationsBindingImpl;
import com.box.android.databinding.UsxFragmentInviteCollaboratorsBindingImpl;
import com.box.android.databinding.UsxFragmentSharedLinkAccessBindingImpl;
import com.box.android.databinding.UsxFragmentSharedLinkBindingImpl;
import com.box.android.databinding.UsxListItemCollaborationBindingImpl;
import com.box.android.databinding.UsxListItemCollaborationInviteeBindingImpl;
import com.box.android.databinding.UsxPermissionsRadioGroupBindingImpl;
import com.box.android.databinding.UsxRadioItemRolesBindingImpl;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_USXACCESSRADIOGROUP = 1;
    private static final int LAYOUT_USXFRAGMENTCOLLABORATIONROLES = 2;
    private static final int LAYOUT_USXFRAGMENTCOLLABORATIONS = 3;
    private static final int LAYOUT_USXFRAGMENTINVITECOLLABORATORS = 4;
    private static final int LAYOUT_USXFRAGMENTSHAREDLINK = 5;
    private static final int LAYOUT_USXFRAGMENTSHAREDLINKACCESS = 6;
    private static final int LAYOUT_USXLISTITEMCOLLABORATION = 7;
    private static final int LAYOUT_USXLISTITEMCOLLABORATIONINVITEE = 8;
    private static final int LAYOUT_USXPERMISSIONSRADIOGROUP = 9;
    private static final int LAYOUT_USXRADIOITEMROLES = 10;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(10);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.usx_access_radio_group, 1);
        sparseIntArray.put(R.layout.usx_fragment_collaboration_roles, 2);
        sparseIntArray.put(R.layout.usx_fragment_collaborations, 3);
        sparseIntArray.put(R.layout.usx_fragment_invite_collaborators, 4);
        sparseIntArray.put(R.layout.usx_fragment_shared_link, 5);
        sparseIntArray.put(R.layout.usx_fragment_shared_link_access, 6);
        sparseIntArray.put(R.layout.usx_list_item_collaboration, 7);
        sparseIntArray.put(R.layout.usx_list_item_collaboration_invitee, 8);
        sparseIntArray.put(R.layout.usx_permissions_radio_group, 9);
        sparseIntArray.put(R.layout.usx_radio_item_roles, 10);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/usx_access_radio_group_0".equals(tag)) {
                    return new UsxAccessRadioGroupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for usx_access_radio_group is invalid. Received: " + tag);
            case 2:
                if ("layout/usx_fragment_collaboration_roles_0".equals(tag)) {
                    return new UsxFragmentCollaborationRolesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for usx_fragment_collaboration_roles is invalid. Received: " + tag);
            case 3:
                if ("layout/usx_fragment_collaborations_0".equals(tag)) {
                    return new UsxFragmentCollaborationsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for usx_fragment_collaborations is invalid. Received: " + tag);
            case 4:
                if ("layout/usx_fragment_invite_collaborators_0".equals(tag)) {
                    return new UsxFragmentInviteCollaboratorsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for usx_fragment_invite_collaborators is invalid. Received: " + tag);
            case 5:
                if ("layout/usx_fragment_shared_link_0".equals(tag)) {
                    return new UsxFragmentSharedLinkBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for usx_fragment_shared_link is invalid. Received: " + tag);
            case 6:
                if ("layout/usx_fragment_shared_link_access_0".equals(tag)) {
                    return new UsxFragmentSharedLinkAccessBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for usx_fragment_shared_link_access is invalid. Received: " + tag);
            case 7:
                if ("layout/usx_list_item_collaboration_0".equals(tag)) {
                    return new UsxListItemCollaborationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for usx_list_item_collaboration is invalid. Received: " + tag);
            case 8:
                if ("layout/usx_list_item_collaboration_invitee_0".equals(tag)) {
                    return new UsxListItemCollaborationInviteeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for usx_list_item_collaboration_invitee is invalid. Received: " + tag);
            case 9:
                if ("layout/usx_permissions_radio_group_0".equals(tag)) {
                    return new UsxPermissionsRadioGroupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for usx_permissions_radio_group is invalid. Received: " + tag);
            case 10:
                if ("layout/usx_radio_item_roles_0".equals(tag)) {
                    return new UsxRadioItemRolesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for usx_radio_item_roles is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(33);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "activeRadioButtons");
            sparseArray.put(2, "adapter");
            sparseArray.put(3, "checkRole");
            sparseArray.put(4, "inviteeEmail");
            sparseArray.put(5, "inviteeName");
            sparseArray.put(6, "isAllowedToInviteCollaborator");
            sparseArray.put(7, "isAllowedToShare");
            sparseArray.put(8, "isLastDivider");
            sparseArray.put(9, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            sparseArray.put(10, "onCollabsListener");
            sparseArray.put(11, "onCopyLinkListener");
            sparseArray.put(12, "onDateListener");
            sparseArray.put(13, "onEditAccessClickListener");
            sparseArray.put(14, "onInviteCollabsClickListener");
            sparseArray.put(15, "onPasswordListener");
            sparseArray.put(16, "onRoleClickedListener");
            sparseArray.put(17, "onShareViaListener");
            sparseArray.put(18, "role");
            sparseArray.put(19, "roleDescription");
            sparseArray.put(20, "roleName");
            sparseArray.put(21, "roleOptions");
            sparseArray.put(22, "roleTag");
            sparseArray.put(23, "roleUpdateNotifier");
            sparseArray.put(24, "shareItem");
            sparseArray.put(25, "sharedLinkAccessNotifier");
            sparseArray.put(26, "shouldShowDownloadOption");
            sparseArray.put(27, "shouldShowEditOption");
            sparseArray.put(28, "tokenListener");
            sparseArray.put(29, "tokenizer");
            sparseArray.put(30, "userRole");
            sparseArray.put(31, "usxNotifier");
            sparseArray.put(32, "viewModel");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> map = new HashMap<>(10);
            sKeys = map;
            map.put("layout/usx_access_radio_group_0", Integer.valueOf(R.layout.usx_access_radio_group));
            map.put("layout/usx_fragment_collaboration_roles_0", Integer.valueOf(R.layout.usx_fragment_collaboration_roles));
            map.put("layout/usx_fragment_collaborations_0", Integer.valueOf(R.layout.usx_fragment_collaborations));
            map.put("layout/usx_fragment_invite_collaborators_0", Integer.valueOf(R.layout.usx_fragment_invite_collaborators));
            map.put("layout/usx_fragment_shared_link_0", Integer.valueOf(R.layout.usx_fragment_shared_link));
            map.put("layout/usx_fragment_shared_link_access_0", Integer.valueOf(R.layout.usx_fragment_shared_link_access));
            map.put("layout/usx_list_item_collaboration_0", Integer.valueOf(R.layout.usx_list_item_collaboration));
            map.put("layout/usx_list_item_collaboration_invitee_0", Integer.valueOf(R.layout.usx_list_item_collaboration_invitee));
            map.put("layout/usx_permissions_radio_group_0", Integer.valueOf(R.layout.usx_permissions_radio_group));
            map.put("layout/usx_radio_item_roles_0", Integer.valueOf(R.layout.usx_radio_item_roles));
        }
    }
}
