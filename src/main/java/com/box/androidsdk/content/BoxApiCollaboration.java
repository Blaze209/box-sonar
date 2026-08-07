package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsShare;
import com.eclipsesource.json.JsonObject;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiCollaboration extends BoxApi {
    protected String getCollaborationsUrl() {
        return String.format("%s/collaborations", getBaseUri());
    }

    protected String getCollaborationInfoUrl(String str) {
        return String.format(CommandParameters.APPLICATION_IDENTIFIER_FORMAT, getCollaborationsUrl(), str);
    }

    public BoxApiCollaboration(BoxSession boxSession) {
        super(boxSession);
    }

    public BoxRequestsShare.GetCollaborationInfo getInfoRequest(String str) {
        return new BoxRequestsShare.GetCollaborationInfo(str, getCollaborationInfoUrl(str), this.mSession);
    }

    @Deprecated
    public BoxRequestsShare.AddCollaboration getAddRequest(String str, BoxCollaboration.Role role, BoxCollaborator boxCollaborator) {
        return getAddToFolderRequest(str, role, boxCollaborator);
    }

    public BoxRequestsShare.AddCollaboration getAddToFolderRequest(String str, BoxCollaboration.Role role, BoxCollaborator boxCollaborator) {
        return new BoxRequestsShare.AddCollaboration(getCollaborationsUrl(), BoxFolder.createFromId(str), role, boxCollaborator, this.mSession);
    }

    public BoxRequestsShare.AddCollaboration getAddToFileRequest(String str, BoxCollaboration.Role role, BoxCollaborator boxCollaborator) {
        return new BoxRequestsShare.AddCollaboration(getCollaborationsUrl(), BoxFile.createFromId(str), role, boxCollaborator, this.mSession);
    }

    public BoxRequestsShare.AddCollaboration getAddRequest(BoxCollaborationItem boxCollaborationItem, BoxCollaboration.Role role, BoxCollaborator boxCollaborator) {
        return new BoxRequestsShare.AddCollaboration(getCollaborationsUrl(), createStubItem(boxCollaborationItem), role, boxCollaborator, this.mSession);
    }

    protected BoxCollaborationItem createStubItem(BoxCollaborationItem boxCollaborationItem) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", boxCollaborationItem.getUserId());
        jsonObject.add("type", boxCollaborationItem.getType());
        try {
            Object objNewInstance = boxCollaborationItem.getClass().newInstance();
            if (objNewInstance instanceof BoxCollaborationItem) {
                ((BoxCollaborationItem) objNewInstance).createFromJson(jsonObject);
            }
        } catch (IllegalAccessException | InstantiationException unused) {
        }
        return (BoxCollaborationItem) BoxItem.createEntityFromJson(jsonObject);
    }

    @Deprecated
    public BoxRequestsShare.AddCollaboration getAddRequest(String str, BoxCollaboration.Role role, String str2) {
        return getAddToFolderRequest(str, role, str2);
    }

    public BoxRequestsShare.AddCollaboration getAddToFolderRequest(String str, BoxCollaboration.Role role, String str2) {
        return new BoxRequestsShare.AddCollaboration(getCollaborationsUrl(), BoxFolder.createFromId(str), role, str2, this.mSession);
    }

    public BoxRequestsShare.AddCollaboration getAddToFileRequest(String str, BoxCollaboration.Role role, String str2) {
        return new BoxRequestsShare.AddCollaboration(getCollaborationsUrl(), BoxFile.createFromId(str), role, str2, this.mSession);
    }

    public BoxRequestsShare.AddCollaboration getAddRequest(BoxCollaborationItem boxCollaborationItem, BoxCollaboration.Role role, String str) {
        return new BoxRequestsShare.AddCollaboration(getCollaborationsUrl(), createStubItem(boxCollaborationItem), role, str, this.mSession);
    }

    public BoxRequestsShare.GetPendingCollaborations getPendingCollaborationsRequest() {
        return new BoxRequestsShare.GetPendingCollaborations(getCollaborationsUrl(), this.mSession);
    }

    public BoxRequestsShare.DeleteCollaboration getDeleteRequest(String str) {
        return new BoxRequestsShare.DeleteCollaboration(str, getCollaborationInfoUrl(str), this.mSession);
    }

    public BoxRequestsShare.UpdateCollaboration getUpdateRequest(String str) {
        return new BoxRequestsShare.UpdateCollaboration(str, getCollaborationInfoUrl(str), this.mSession);
    }

    public BoxRequestsShare.UpdateOwner getUpdateOwnerRequest(String str) {
        return new BoxRequestsShare.UpdateOwner(str, getCollaborationInfoUrl(str), this.mSession);
    }
}
