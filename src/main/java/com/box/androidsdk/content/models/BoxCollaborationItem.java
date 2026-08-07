package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxCollaborationItem extends BoxItem {
    public static final String FIELD_ALLOWED_INVITEE_ROLES = "allowed_invitee_roles";
    public static final String FIELD_CAN_NON_OWNERS_INVITE = "can_non_owners_invite";
    public static final String FIELD_DEFAULT_INVITEE_ROLE = "default_invitee_role";
    public static final String FIELD_HAS_COLLABORATIONS = "has_collaborations";
    public static final String FIELD_IS_EXTERNALLY_OWNED = "is_externally_owned";
    private static final long serialVersionUID = 4876182952114609430L;
    private transient ArrayList<BoxCollaboration.Role> mCachedAllowedInviteeRoles;

    protected BoxCollaborationItem() {
    }

    protected BoxCollaborationItem(JsonObject jsonObject) {
        super(jsonObject);
    }

    public Boolean getHasCollaborations() {
        return getPropertyAsBoolean(FIELD_HAS_COLLABORATIONS);
    }

    public ArrayList<BoxCollaboration.Role> getAllowedInviteeRoles() {
        ArrayList<BoxCollaboration.Role> arrayList = this.mCachedAllowedInviteeRoles;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList<String> propertyAsStringArray = getPropertyAsStringArray(FIELD_ALLOWED_INVITEE_ROLES);
        if (propertyAsStringArray == null) {
            return null;
        }
        this.mCachedAllowedInviteeRoles = new ArrayList<>(propertyAsStringArray.size());
        Iterator<String> it = propertyAsStringArray.iterator();
        while (it.hasNext()) {
            this.mCachedAllowedInviteeRoles.add(BoxCollaboration.Role.fromString(it.next()));
        }
        return this.mCachedAllowedInviteeRoles;
    }

    public String getDefaultInviteeRole() {
        return getPropertyAsString(FIELD_DEFAULT_INVITEE_ROLE);
    }

    public Boolean getIsExternallyOwned() {
        return getPropertyAsBoolean(FIELD_IS_EXTERNALLY_OWNED);
    }

    public Boolean getCanNonOwnersInvite() {
        return getPropertyAsBoolean(FIELD_CAN_NON_OWNERS_INVITE);
    }
}
