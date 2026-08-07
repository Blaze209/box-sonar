package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxGroup;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLinkSession;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.utils.SdkUtils;
import com.eclipsesource.json.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestsShare {

    public static class GetSharedLink extends BoxRequestItem<BoxItem, GetSharedLink> implements BoxCacheableRequest<BoxItem> {
        private static final long serialVersionUID = 8123965031279971573L;

        public GetSharedLink(String str, BoxSharedLinkSession boxSharedLinkSession) {
            super(BoxItem.class, null, str, boxSharedLinkSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
            setRequestHandler(createRequestHandler(this));
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public GetSharedLink setIfNoneMatchEtag(String str) {
            return (GetSharedLink) super.setIfNoneMatchEtag(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public String getIfNoneMatchEtag() {
            return super.getIfNoneMatchEtag();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxItem sendForCachedResult() throws BoxException {
            return (BoxItem) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxItem> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }

        public static BoxRequest.BoxRequestHandler<GetSharedLink> createRequestHandler(GetSharedLink getSharedLink) {
            return new BoxRequest.BoxRequestHandler<GetSharedLink>(getSharedLink) { // from class: com.box.androidsdk.content.requests.BoxRequestsShare.GetSharedLink.1
                @Override // com.box.androidsdk.content.requests.BoxRequest.BoxRequestHandler
                public <T extends BoxObject> T onResponse(Class<T> cls, BoxHttpResponse boxHttpResponse) throws BoxException {
                    if (Thread.currentThread().isInterrupted()) {
                        disconnectForInterrupt(boxHttpResponse);
                        throw new BoxException("Request cancelled ", new InterruptedException());
                    }
                    if (boxHttpResponse.getResponseCode() == 429) {
                        return (T) retryRateLimited(boxHttpResponse);
                    }
                    String contentType = boxHttpResponse.getContentType();
                    BoxEntity boxEntity = new BoxEntity();
                    if (!contentType.contains(BoxRequest.ContentTypes.JSON.toString())) {
                        return boxEntity;
                    }
                    String stringBody = boxHttpResponse.getStringBody();
                    boxEntity.createFromJson(stringBody);
                    if (boxEntity.getType().equals("folder")) {
                        BoxFolder boxFolder = new BoxFolder();
                        boxFolder.createFromJson(stringBody);
                        return boxFolder;
                    }
                    if (boxEntity.getType().equals("file")) {
                        BoxFile boxFile = new BoxFile();
                        boxFile.createFromJson(stringBody);
                        return boxFile;
                    }
                    if (!boxEntity.getType().equals(BoxBookmark.TYPE)) {
                        return boxEntity;
                    }
                    BoxBookmark boxBookmark = new BoxBookmark();
                    boxBookmark.createFromJson(stringBody);
                    return boxBookmark;
                }
            };
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.mRequestHandler = createRequestHandler(this);
        }
    }

    public static class GetCollaborationInfo extends BoxRequest<BoxCollaboration, GetCollaborationInfo> implements BoxCacheableRequest<BoxCollaboration> {
        private static final long serialVersionUID = 8123965031279971581L;
        private final String mId;

        public GetCollaborationInfo(String str, String str2, BoxSession boxSession) {
            super(BoxCollaboration.class, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
            this.mId = str;
        }

        public String getId() {
            return this.mId;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxCollaboration> boxResponse) throws BoxException {
            super.onSendCompleted(boxResponse);
            super.handleUpdateCache(boxResponse);
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxCollaboration sendForCachedResult() throws BoxException {
            return (BoxCollaboration) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxCollaboration> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class GetPendingCollaborations extends BoxRequest<BoxIteratorCollaborations, GetPendingCollaborations> implements BoxCacheableRequest<BoxIteratorCollaborations> {
        private static final long serialVersionUID = 8123965031279971581L;

        public GetPendingCollaborations(String str, BoxSession boxSession) {
            super(BoxIteratorCollaborations.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
            this.mQueryMap.put("status", BoxCollaboration.Status.PENDING.toString());
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorCollaborations sendForCachedResult() throws BoxException {
            return (BoxIteratorCollaborations) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorCollaborations> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxIteratorCollaborations> boxResponse) throws BoxException {
            super.onSendCompleted(boxResponse);
            super.handleUpdateCache(boxResponse);
        }
    }

    public static class AddCollaboration extends BoxRequest<BoxCollaboration, AddCollaboration> {
        public static final String ERROR_CODE_FORBIDDEN_BY_POLICY = "forbidden_by_policy";
        public static final String ERROR_CODE_USER_ALREADY_COLLABORATOR = "user_already_collaborator";
        private static final long serialVersionUID = 8123965031279971574L;
        private final String mCollaborationTargetId;

        public AddCollaboration(String str, BoxCollaborationItem boxCollaborationItem, BoxCollaboration.Role role, String str2, BoxSession boxSession) {
            super(BoxCollaboration.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.POST;
            this.mCollaborationTargetId = boxCollaborationItem.getUserId();
            setCollaborationItem(boxCollaborationItem);
            setAccessibleBy(null, str2, "user");
            this.mBodyMap.put("role", role.toString());
        }

        @Deprecated
        public AddCollaboration(String str, String str2, BoxCollaboration.Role role, String str3, BoxSession boxSession) {
            this(str, BoxFolder.createFromId(str2), role, str3, boxSession);
        }

        public AddCollaboration(String str, BoxCollaborationItem boxCollaborationItem, BoxCollaboration.Role role, BoxCollaborator boxCollaborator, BoxSession boxSession) {
            super(BoxCollaboration.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.POST;
            this.mCollaborationTargetId = boxCollaborationItem.getUserId();
            setCollaborationItem(boxCollaborationItem);
            setAccessibleBy(boxCollaborator.getUserId(), null, boxCollaborator.getType());
            this.mBodyMap.put("role", role.toString());
        }

        @Deprecated
        public AddCollaboration(String str, String str2, BoxCollaboration.Role role, BoxCollaborator boxCollaborator, BoxSession boxSession) {
            this(str, BoxFolder.createFromId(str2), role, boxCollaborator, boxSession);
        }

        public AddCollaboration notifyCollaborators(boolean z) {
            this.mQueryMap.put("notify", Boolean.toString(z));
            return this;
        }

        @Deprecated
        public String getFolderId() {
            return getId();
        }

        public String getId() {
            return this.mCollaborationTargetId;
        }

        public String getType() {
            return ((BoxItem) this.mBodyMap.get("item")).getType();
        }

        private void setCollaborationItem(BoxCollaborationItem boxCollaborationItem) {
            if (SdkUtils.isBlank(this.mCollaborationTargetId) || SdkUtils.isBlank(boxCollaborationItem.getType())) {
                throw new IllegalArgumentException("invalid collaboration item");
            }
            this.mBodyMap.put("item", boxCollaborationItem);
        }

        private void setAccessibleBy(String str, String str2, String str3) {
            Object boxGroup;
            JsonObject jsonObject = new JsonObject();
            if (!SdkUtils.isEmptyString(str)) {
                jsonObject.add("id", str);
            }
            if (!SdkUtils.isEmptyString(str2)) {
                jsonObject.add("login", str2);
            }
            jsonObject.add("type", str3);
            if (str3.equals("user")) {
                boxGroup = new BoxUser(jsonObject);
            } else if (str3.equals("group")) {
                boxGroup = new BoxGroup(jsonObject);
            } else {
                throw new IllegalArgumentException("AccessibleBy property can only be set with type BoxUser.TYPE or BoxGroup.TYPE");
            }
            this.mBodyMap.put("accessible_by", boxGroup);
        }

        public BoxCollaborator getAccessibleBy() {
            if (this.mBodyMap.containsKey("accessible_by")) {
                return (BoxCollaborator) this.mBodyMap.get("accessible_by");
            }
            return null;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxCollaboration> boxResponse) throws BoxException {
            super.onSendCompleted(boxResponse);
            super.handleUpdateCache(boxResponse);
        }
    }

    public static class DeleteCollaboration extends BoxRequest<BoxVoid, DeleteCollaboration> {
        private static final long serialVersionUID = 8123965031279971504L;
        private String mId;

        public DeleteCollaboration(String str, String str2, BoxSession boxSession) {
            super(BoxVoid.class, str2, boxSession);
            this.mId = str;
            this.mRequestMethod = BoxRequest.Methods.DELETE;
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

    public static class UpdateCollaboration extends BoxRequest<BoxCollaboration, UpdateCollaboration> {
        private static final long serialVersionUID = 8123965031279971597L;
        private String mId;

        public UpdateCollaboration(String str, String str2, BoxSession boxSession) {
            super(BoxCollaboration.class, str2, boxSession);
            this.mId = str;
            this.mRequestMethod = BoxRequest.Methods.PUT;
        }

        public String getId() {
            return this.mId;
        }

        public UpdateCollaboration setNewRole(BoxCollaboration.Role role) {
            this.mBodyMap.put("role", role.toString());
            return this;
        }

        public UpdateCollaboration setNewStatus(String str) {
            this.mBodyMap.put("status", str);
            return this;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxCollaboration> boxResponse) throws BoxException {
            super.onSendCompleted(boxResponse);
            super.handleUpdateCache(boxResponse);
        }
    }

    public static class UpdateOwner extends BoxRequest<BoxVoid, UpdateOwner> {
        private static final long serialVersionUID = 8123965031239671597L;
        private String mId;

        public UpdateOwner(String str, String str2, BoxSession boxSession) {
            super(BoxVoid.class, str2, boxSession);
            this.mId = str;
            this.mRequestMethod = BoxRequest.Methods.PUT;
            this.mBodyMap.put("role", BoxCollaboration.Role.OWNER.toString());
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
