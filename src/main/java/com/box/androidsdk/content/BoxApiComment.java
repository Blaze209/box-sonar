package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsComment;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiComment extends BoxApi {
    public static final String COMMENTS_ENDPOINT = "/comments";

    public BoxApiComment(BoxSession boxSession) {
        super(boxSession);
    }

    protected String getCommentsUrl() {
        return getBaseUri() + COMMENTS_ENDPOINT;
    }

    protected String getCommentInfoUrl(String str) {
        return String.format(CommandParameters.APPLICATION_IDENTIFIER_FORMAT, getCommentsUrl(), str);
    }

    public BoxRequestsComment.GetCommentInfo getInfoRequest(String str) {
        return new BoxRequestsComment.GetCommentInfo(str, getCommentInfoUrl(str), this.mSession);
    }

    public BoxRequestsComment.AddReplyComment getAddCommentReplyRequest(String str, String str2) {
        return new BoxRequestsComment.AddReplyComment(str, str2, getCommentsUrl(), this.mSession);
    }

    public BoxRequestsComment.UpdateComment getUpdateRequest(String str, String str2) {
        return new BoxRequestsComment.UpdateComment(str, str2, getCommentInfoUrl(str), this.mSession);
    }

    public BoxRequestsComment.DeleteComment getDeleteRequest(String str) {
        return new BoxRequestsComment.DeleteComment(str, getCommentInfoUrl(str), this.mSession);
    }
}
