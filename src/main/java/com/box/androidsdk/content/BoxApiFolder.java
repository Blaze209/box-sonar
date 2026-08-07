package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiFolder extends BoxApi {
    public BoxApiFolder(BoxSession boxSession) {
        super(boxSession);
    }

    protected String getFoldersUrl() {
        return String.format("%s/folders", getBaseUri());
    }

    protected String getFolderInfoUrl(String str) {
        return String.format(CommandParameters.APPLICATION_IDENTIFIER_FORMAT, getFoldersUrl(), str);
    }

    protected String getFolderItemsUrl(String str) {
        return getFolderInfoUrl(str) + "/items";
    }

    protected String getFolderCollaborationsUrl(String str) {
        return getFolderInfoUrl(str) + "/collaborations";
    }

    protected String getFolderCopyUrl(String str) {
        return getFolderInfoUrl(str) + "/copy";
    }

    protected String getTrashedFolderUrl(String str) {
        return getFolderInfoUrl(str) + "/trash";
    }

    protected String getTrashedItemsUrl() {
        return getFoldersUrl() + "/trash/items";
    }

    public BoxRequestsFolder.GetFolderInfo getInfoRequest(String str) {
        return new BoxRequestsFolder.GetFolderInfo(str, getFolderInfoUrl(str), this.mSession);
    }

    public BoxRequestsFolder.GetFolderItems getItemsRequest(String str) {
        return new BoxRequestsFolder.GetFolderItems(str, getFolderItemsUrl(str), this.mSession);
    }

    public BoxRequestsFolder.GetFolderWithAllItems getFolderWithAllItems(String str) {
        BoxRequestsFolder.GetFolderWithAllItems getFolderWithAllItems = new BoxRequestsFolder.GetFolderWithAllItems(str, getFolderInfoUrl(str), getFolderItemsUrl(str), this.mSession);
        getFolderWithAllItems.setMaximumLimit(4000);
        return getFolderWithAllItems;
    }

    public BoxRequestsFolder.CreateFolder getCreateRequest(String str, String str2) {
        return new BoxRequestsFolder.CreateFolder(str, str2, getFoldersUrl(), this.mSession);
    }

    public BoxRequestsFolder.UpdateFolder getUpdateRequest(String str) {
        return new BoxRequestsFolder.UpdateFolder(str, getFolderInfoUrl(str), this.mSession);
    }

    public BoxRequestsFolder.UpdateFolder getMoveRequest(String str, String str2) {
        return new BoxRequestsFolder.UpdateFolder(str, getFolderInfoUrl(str), this.mSession).setParentId(str2);
    }

    public BoxRequestsFolder.CopyFolder getCopyRequest(String str, String str2) {
        return new BoxRequestsFolder.CopyFolder(str, str2, getFolderCopyUrl(str), this.mSession);
    }

    public BoxRequestsFolder.DeleteFolder getDeleteRequest(String str) {
        return new BoxRequestsFolder.DeleteFolder(str, getFolderInfoUrl(str), this.mSession);
    }

    public BoxRequestsFolder.DeleteFolder getDeleteRequest(BoxItem boxItem) {
        return new BoxRequestsFolder.DeleteFolder(boxItem, getFolderInfoUrl(boxItem.getUserId()), this.mSession);
    }

    public BoxRequestsFolder.GetCollaborations getCollaborationsRequest(String str) {
        return new BoxRequestsFolder.GetCollaborations(str, getFolderCollaborationsUrl(str), this.mSession);
    }

    public BoxRequestsFolder.UpdateSharedFolder getCreateSharedLinkRequest(String str) {
        return new BoxRequestsFolder.UpdateSharedFolder(str, getFolderInfoUrl(str), this.mSession).setAccess(null);
    }

    public BoxRequestsFolder.UpdateFolder getDisableSharedLinkRequest(String str) {
        return new BoxRequestsFolder.UpdateFolder(str, getFolderInfoUrl(str), this.mSession).setSharedLink(null);
    }

    public BoxRequestsFolder.AddFolderToCollection getAddToCollectionRequest(String str, String str2) {
        return new BoxRequestsFolder.AddFolderToCollection(str, str2, getFolderInfoUrl(str), this.mSession);
    }

    public BoxRequestsFolder.DeleteFolderFromCollection getDeleteFromCollectionRequest(String str) {
        return new BoxRequestsFolder.DeleteFolderFromCollection(str, getFolderInfoUrl(str), this.mSession);
    }

    public BoxRequestsFolder.GetTrashedItems getTrashedItemsRequest() {
        return new BoxRequestsFolder.GetTrashedItems(getTrashedItemsUrl(), this.mSession);
    }

    public BoxRequestsFolder.GetTrashedFolder getTrashedFolderRequest(String str) {
        return new BoxRequestsFolder.GetTrashedFolder(str, getTrashedFolderUrl(str), this.mSession);
    }

    public BoxRequestsFolder.DeleteTrashedFolder getDeleteTrashedFolderRequest(String str) {
        return new BoxRequestsFolder.DeleteTrashedFolder(str, getTrashedFolderUrl(str), this.mSession);
    }

    public BoxRequestsFolder.RestoreTrashedFolder getRestoreTrashedFolderRequest(String str) {
        return new BoxRequestsFolder.RestoreTrashedFolder(str, getFolderInfoUrl(str), this.mSession);
    }
}
