package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsBookmark;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiBookmark extends BoxApi {
    public BoxApiBookmark(BoxSession boxSession) {
        super(boxSession);
    }

    protected String getBookmarksUrl() {
        return String.format("%s/web_links", getBaseUri());
    }

    protected String getBookmarkInfoUrl(String str) {
        return String.format(CommandParameters.APPLICATION_IDENTIFIER_FORMAT, getBookmarksUrl(), str);
    }

    protected String getBookmarkCopyUrl(String str) {
        return String.format(getBookmarkInfoUrl(str) + "/copy", new Object[0]);
    }

    protected String getTrashedBookmarkUrl(String str) {
        return getBookmarkInfoUrl(str) + "/trash";
    }

    protected String getBookmarkCommentsUrl(String str) {
        return getBookmarkInfoUrl(str) + BoxApiComment.COMMENTS_ENDPOINT;
    }

    protected String getCommentUrl() {
        return getBaseUri() + BoxApiComment.COMMENTS_ENDPOINT;
    }

    public BoxRequestsBookmark.GetBookmarkInfo getInfoRequest(String str) {
        return new BoxRequestsBookmark.GetBookmarkInfo(str, getBookmarkInfoUrl(str), this.mSession);
    }

    public BoxRequestsBookmark.CreateBookmark getCreateRequest(String str, String str2) {
        return new BoxRequestsBookmark.CreateBookmark(str, str2, getBookmarksUrl(), this.mSession);
    }

    public BoxRequestsBookmark.UpdateBookmark getUpdateRequest(String str) {
        return new BoxRequestsBookmark.UpdateBookmark(str, getBookmarkInfoUrl(str), this.mSession);
    }

    public BoxRequestsBookmark.CopyBookmark getCopyRequest(String str, String str2) {
        return new BoxRequestsBookmark.CopyBookmark(str, str2, getBookmarkCopyUrl(str), this.mSession);
    }

    public BoxRequestsBookmark.UpdateBookmark getMoveRequest(String str, String str2) {
        BoxRequestsBookmark.UpdateBookmark updateBookmark = new BoxRequestsBookmark.UpdateBookmark(str, getBookmarkInfoUrl(str), this.mSession);
        updateBookmark.setParentId(str2);
        return updateBookmark;
    }

    public BoxRequestsBookmark.DeleteBookmark getDeleteRequest(BoxItem boxItem) {
        return new BoxRequestsBookmark.DeleteBookmark(boxItem, getBookmarkInfoUrl(boxItem.getUserId()), this.mSession);
    }

    public BoxRequestsBookmark.UpdateSharedBookmark getCreateSharedLinkRequest(String str) {
        return new BoxRequestsBookmark.UpdateSharedBookmark(str, getBookmarkInfoUrl(str), this.mSession).setAccess(null);
    }

    public BoxRequestsBookmark.UpdateBookmark getDisableSharedLinkRequest(String str) {
        return new BoxRequestsBookmark.UpdateBookmark(str, getBookmarkInfoUrl(str), this.mSession).setSharedLink(null);
    }

    public BoxRequestsBookmark.AddCommentToBookmark getAddCommentRequest(String str, String str2) {
        return new BoxRequestsBookmark.AddCommentToBookmark(str, str2, getCommentUrl(), this.mSession);
    }

    public BoxRequestsBookmark.GetTrashedBookmark getTrashedBookmarkRequest(String str) {
        return new BoxRequestsBookmark.GetTrashedBookmark(str, getTrashedBookmarkUrl(str), this.mSession);
    }

    public BoxRequestsBookmark.DeleteTrashedBookmark getDeleteTrashedBookmarkRequest(String str) {
        return new BoxRequestsBookmark.DeleteTrashedBookmark(str, getTrashedBookmarkUrl(str), this.mSession);
    }

    public BoxRequestsBookmark.RestoreTrashedBookmark getRestoreTrashedBookmarkRequest(String str) {
        return new BoxRequestsBookmark.RestoreTrashedBookmark(str, getBookmarkInfoUrl(str), this.mSession);
    }

    public BoxRequestsBookmark.GetBookmarkComments getCommentsRequest(String str) {
        return new BoxRequestsBookmark.GetBookmarkComments(str, getBookmarkCommentsUrl(str), this.mSession);
    }

    public BoxRequestsBookmark.AddBookmarkToCollection getAddToCollectionRequest(String str, String str2) {
        return new BoxRequestsBookmark.AddBookmarkToCollection(str, str2, getBookmarkInfoUrl(str), this.mSession);
    }

    public BoxRequestsBookmark.DeleteBookmarkFromCollection getDeleteFromCollectionRequest(String str) {
        return new BoxRequestsBookmark.DeleteBookmarkFromCollection(str, getBookmarkInfoUrl(str), this.mSession);
    }
}
