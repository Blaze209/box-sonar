package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxVoid;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestsComment {

    public static class GetCommentInfo extends BoxRequestItem<BoxComment, GetCommentInfo> implements BoxCacheableRequest<BoxComment> {
        private static final long serialVersionUID = 8123965031279971517L;

        public GetCommentInfo(String str, String str2, BoxSession boxSession) {
            super(BoxComment.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxComment sendForCachedResult() throws BoxException {
            return (BoxComment) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxComment> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class AddReplyComment extends BoxRequestCommentAdd<BoxComment, AddReplyComment> {
        private static final long serialVersionUID = 8123965031279971513L;

        @Override // com.box.androidsdk.content.requests.BoxRequestCommentAdd
        public /* bridge */ /* synthetic */ String getItemId() {
            return super.getItemId();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestCommentAdd
        public /* bridge */ /* synthetic */ String getItemType() {
            return super.getItemType();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestCommentAdd
        public /* bridge */ /* synthetic */ String getMessage() {
            return super.getMessage();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestCommentAdd
        public /* bridge */ /* synthetic */ BoxRequest setMessage(String str) {
            return super.setMessage(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestCommentAdd
        public /* bridge */ /* synthetic */ BoxRequest setTaggedMessage(String str) {
            return super.setTaggedMessage(str);
        }

        public AddReplyComment(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxComment.class, str3, boxSession);
            setItemId(str);
            setItemType("comment");
            setMessage(str2);
        }
    }

    public static class UpdateComment extends BoxRequest<BoxComment, UpdateComment> {
        private static final long serialVersionUID = 8123965031279971579L;
        String mId;

        public UpdateComment(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxComment.class, str3, boxSession);
            this.mId = str;
            this.mRequestMethod = BoxRequest.Methods.PUT;
            setMessage(str2);
        }

        public String getId() {
            return this.mId;
        }

        public String getMessage() {
            return (String) this.mBodyMap.get("message");
        }

        public UpdateComment setMessage(String str) {
            this.mBodyMap.put("message", str);
            return this;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxComment> boxResponse) throws BoxException {
            super.onSendCompleted(boxResponse);
            super.handleUpdateCache(boxResponse);
        }
    }

    public static class DeleteComment extends BoxRequest<BoxVoid, DeleteComment> {
        private static final long serialVersionUID = 8123965031279971588L;
        private final String mId;

        public DeleteComment(String str, String str2, BoxSession boxSession) {
            super(BoxVoid.class, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.DELETE;
            this.mId = str;
        }

        public String getId() {
            return this.mId;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxVoid> boxResponse) throws BoxException {
            super.onSendCompleted(boxResponse);
            super.handleUpdateCache(boxResponse);
        }
    }
}
