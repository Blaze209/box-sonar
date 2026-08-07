package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorComments;
import com.box.androidsdk.content.models.BoxSession;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestsBookmark {

    public static class GetBookmarkInfo extends BoxRequestItem<BoxBookmark, GetBookmarkInfo> implements BoxCacheableRequest<BoxBookmark> {
        private static final long serialVersionUID = 8123965031279971508L;

        public GetBookmarkInfo(String str, String str2, BoxSession boxSession) {
            super(BoxBookmark.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public GetBookmarkInfo setIfNoneMatchEtag(String str) {
            return (GetBookmarkInfo) super.setIfNoneMatchEtag(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public String getIfNoneMatchEtag() {
            return super.getIfNoneMatchEtag();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxBookmark sendForCachedResult() throws BoxException {
            return (BoxBookmark) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxBookmark> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class CreateBookmark extends BoxRequestItem<BoxBookmark, CreateBookmark> {
        private static final long serialVersionUID = 8123965031279971526L;

        public CreateBookmark(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxBookmark.class, null, str3, boxSession);
            this.mRequestMethod = BoxRequest.Methods.POST;
            setParentId(str);
            setUrl(str2);
        }

        public String getParentId() {
            if (this.mBodyMap.containsKey("parent")) {
                return (String) this.mBodyMap.get("id");
            }
            return null;
        }

        public CreateBookmark setParentId(String str) {
            this.mBodyMap.put("parent", BoxFolder.createFromId(str));
            return this;
        }

        public String getUrl() {
            return (String) this.mBodyMap.get("url");
        }

        public CreateBookmark setUrl(String str) {
            this.mBodyMap.put("url", str);
            return this;
        }

        public String getName() {
            return (String) this.mBodyMap.get("name");
        }

        public CreateBookmark setName(String str) {
            this.mBodyMap.put("name", str);
            return this;
        }
    }

    public static class UpdateBookmark extends BoxRequestItemUpdate<BoxBookmark, UpdateBookmark> {
        private static final long serialVersionUID = 8123965031279971523L;

        public UpdateBookmark(String str, String str2, BoxSession boxSession) {
            super(BoxBookmark.class, str, str2, boxSession);
        }

        public String getUrl() {
            return (String) this.mBodyMap.get("url");
        }

        public UpdateBookmark setUrl(String str) {
            this.mBodyMap.put("url", str);
            return this;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItemUpdate
        public UpdateSharedBookmark updateSharedLink() {
            return new UpdateSharedBookmark(this);
        }
    }

    public static class UpdateSharedBookmark extends BoxRequestUpdateSharedItem<BoxBookmark, UpdateSharedBookmark> {
        private static final long serialVersionUID = 8123965031279971518L;

        public UpdateSharedBookmark(String str, String str2, BoxSession boxSession) {
            super(BoxBookmark.class, str, str2, boxSession);
        }

        public UpdateSharedBookmark(UpdateBookmark updateBookmark) {
            super(updateBookmark);
        }
    }

    public static class CopyBookmark extends BoxRequestItemCopy<BoxBookmark, CopyBookmark> {
        private static final long serialVersionUID = 8123965031279971531L;

        @Override // com.box.androidsdk.content.requests.BoxRequestItemCopy
        public /* bridge */ /* synthetic */ String getName() {
            return super.getName();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItemCopy
        public /* bridge */ /* synthetic */ String getParentId() {
            return super.getParentId();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItemCopy
        public /* bridge */ /* synthetic */ BoxRequest setName(String str) {
            return super.setName(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItemCopy
        public /* bridge */ /* synthetic */ BoxRequest setParentId(String str) {
            return super.setParentId(str);
        }

        public CopyBookmark(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxBookmark.class, str, str2, str3, boxSession);
        }
    }

    public static class DeleteBookmark extends BoxRequestItemDelete<DeleteBookmark> {
        private static final long serialVersionUID = 8123965031279971595L;

        public DeleteBookmark(String str, String str2, BoxSession boxSession) {
            super(str, str2, boxSession);
        }

        public DeleteBookmark(BoxItem boxItem, String str, BoxSession boxSession) {
            super(boxItem, str, boxSession);
        }
    }

    public static class GetTrashedBookmark extends BoxRequestItem<BoxBookmark, GetTrashedBookmark> implements BoxCacheableRequest<BoxBookmark> {
        private static final long serialVersionUID = 8123965031279971542L;

        public GetTrashedBookmark(String str, String str2, BoxSession boxSession) {
            super(BoxBookmark.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public GetTrashedBookmark setIfNoneMatchEtag(String str) {
            return (GetTrashedBookmark) super.setIfNoneMatchEtag(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public String getIfNoneMatchEtag() {
            return super.getIfNoneMatchEtag();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxBookmark sendForCachedResult() throws BoxException {
            return (BoxBookmark) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxBookmark> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class DeleteTrashedBookmark extends BoxRequestItemDelete<DeleteTrashedBookmark> {
        private static final long serialVersionUID = 8123965031279971591L;

        public DeleteTrashedBookmark(String str, String str2, BoxSession boxSession) {
            super(str, str2, boxSession);
        }
    }

    public static class RestoreTrashedBookmark extends BoxRequestItemRestoreTrashed<BoxBookmark, RestoreTrashedBookmark> {
        private static final long serialVersionUID = 8123965031279971536L;

        @Override // com.box.androidsdk.content.requests.BoxRequestItemRestoreTrashed
        public /* bridge */ /* synthetic */ String getName() {
            return super.getName();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItemRestoreTrashed
        public /* bridge */ /* synthetic */ String getParentId() {
            return super.getParentId();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItemRestoreTrashed
        public /* bridge */ /* synthetic */ BoxRequest setName(String str) {
            return super.setName(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItemRestoreTrashed
        public /* bridge */ /* synthetic */ BoxRequest setParentId(String str) {
            return super.setParentId(str);
        }

        public RestoreTrashedBookmark(String str, String str2, BoxSession boxSession) {
            super(BoxBookmark.class, str, str2, boxSession);
        }
    }

    public static class GetBookmarkComments extends BoxRequestItem<BoxIteratorComments, GetBookmarkComments> implements BoxCacheableRequest<BoxIteratorComments> {
        private static final long serialVersionUID = 8123965031279971516L;

        public GetBookmarkComments(String str, String str2, BoxSession boxSession) {
            super(BoxIteratorComments.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorComments sendForCachedResult() throws BoxException {
            return (BoxIteratorComments) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorComments> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class AddCommentToBookmark extends BoxRequestCommentAdd<BoxComment, AddCommentToBookmark> {
        private static final long serialVersionUID = 8123965031279971512L;

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

        public AddCommentToBookmark(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxComment.class, str3, boxSession);
            setItemId(str);
            setItemType(BoxBookmark.TYPE);
            setMessage(str2);
        }
    }

    public static class AddBookmarkToCollection extends BoxRequestCollectionUpdate<BoxBookmark, AddBookmarkToCollection> {
        private static final long serialVersionUID = 8123965031279971541L;

        public AddBookmarkToCollection(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxBookmark.class, str, str3, boxSession);
            setCollectionId(str2);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestCollectionUpdate
        public AddBookmarkToCollection setCollectionId(String str) {
            return (AddBookmarkToCollection) super.setCollectionId(str);
        }
    }

    public static class DeleteBookmarkFromCollection extends BoxRequestCollectionUpdate<BoxBookmark, DeleteBookmarkFromCollection> {
        private static final long serialVersionUID = 8123965031279971541L;

        public DeleteBookmarkFromCollection(String str, String str2, BoxSession boxSession) {
            super(BoxBookmark.class, str, str2, boxSession);
            setCollectionId(null);
        }
    }
}
