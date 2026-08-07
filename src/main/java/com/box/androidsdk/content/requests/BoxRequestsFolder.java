package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.box.androidsdk.content.models.BoxUploadEmail;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.utils.SdkUtils;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestsFolder {

    public static class GetFolderInfo extends BoxRequestItem<BoxFolder, GetFolderInfo> implements BoxCacheableRequest<BoxFolder> {
        private static final long serialVersionUID = 8123965031279971529L;

        public GetFolderInfo(String str, String str2, BoxSession boxSession) {
            super(BoxFolder.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public GetFolderInfo setIfNoneMatchEtag(String str) {
            return (GetFolderInfo) super.setIfNoneMatchEtag(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public String getIfNoneMatchEtag() {
            return super.getIfNoneMatchEtag();
        }

        public GetFolderInfo setLimit(int i) {
            this.mQueryMap.put(BoxIterator.FIELD_LIMIT, String.valueOf(i));
            return this;
        }

        public GetFolderInfo setOffset(int i) {
            this.mQueryMap.put("offset", String.valueOf(i));
            return this;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFolder sendForCachedResult() throws BoxException {
            return (BoxFolder) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxFolder> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class GetCollaborations extends BoxRequestItem<BoxIteratorCollaborations, GetCollaborations> implements BoxCacheableRequest<BoxIteratorCollaborations> {
        private static final long serialVersionUID = 8123965031279971515L;

        public GetCollaborations(String str, String str2, BoxSession boxSession) {
            super(BoxIteratorCollaborations.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorCollaborations sendForCachedResult() throws BoxException {
            return (BoxIteratorCollaborations) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorCollaborations> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class UpdateFolder extends BoxRequestItemUpdate<BoxFolder, UpdateFolder> {
        private static final long serialVersionUID = 8123965031279971522L;

        public UpdateFolder(String str, String str2, BoxSession boxSession) {
            super(BoxFolder.class, str, str2, boxSession);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItemUpdate
        public UpdateSharedFolder updateSharedLink() {
            return new UpdateSharedFolder(this);
        }

        public BoxFolder.SyncState getSyncState() {
            if (this.mBodyMap.containsKey(BoxFolder.FIELD_SYNC_STATE)) {
                return (BoxFolder.SyncState) this.mBodyMap.get(BoxFolder.FIELD_SYNC_STATE);
            }
            return null;
        }

        public UpdateFolder setSyncState(BoxFolder.SyncState syncState) {
            this.mBodyMap.put(BoxFolder.FIELD_SYNC_STATE, syncState);
            return this;
        }

        public BoxUploadEmail.Access getUploadEmailAccess() {
            if (this.mBodyMap.containsKey(BoxFolder.FIELD_FOLDER_UPLOAD_EMAIL)) {
                return ((BoxUploadEmail) this.mBodyMap.get(BoxFolder.FIELD_FOLDER_UPLOAD_EMAIL)).getAccess();
            }
            return null;
        }

        public UpdateFolder setFolderUploadEmailAccess(BoxUploadEmail.Access access) {
            this.mBodyMap.put(BoxFolder.FIELD_FOLDER_UPLOAD_EMAIL, BoxUploadEmail.createFromAccess(access));
            return this;
        }

        public String getOwnedById() {
            if (this.mBodyMap.containsKey(BoxItem.FIELD_OWNED_BY)) {
                return ((BoxUser) this.mBodyMap.get(BoxItem.FIELD_OWNED_BY)).getUserId();
            }
            return null;
        }

        public UpdateFolder setOwnedById(String str) {
            this.mBodyMap.put(BoxItem.FIELD_OWNED_BY, BoxUser.createFromId(str));
            return this;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItemUpdate, com.box.androidsdk.content.requests.BoxRequest
        protected void parseHashMapEntry(JsonObject jsonObject, Map.Entry<String, Object> entry) {
            if (entry.getKey().equals(BoxFolder.FIELD_FOLDER_UPLOAD_EMAIL)) {
                jsonObject.add(entry.getKey(), parseJsonObject(entry.getValue()));
                return;
            }
            if (entry.getKey().equals(BoxItem.FIELD_OWNED_BY)) {
                jsonObject.add(entry.getKey(), parseJsonObject(entry.getValue()));
            } else if (entry.getKey().equals(BoxFolder.FIELD_SYNC_STATE)) {
                jsonObject.add(entry.getKey(), ((BoxFolder.SyncState) entry.getValue()).toString());
            } else {
                super.parseHashMapEntry(jsonObject, entry);
            }
        }
    }

    public static class UpdateSharedFolder extends BoxRequestUpdateSharedItem<BoxFolder, UpdateSharedFolder> {
        private static final long serialVersionUID = 8123965031279971519L;

        public UpdateSharedFolder(String str, String str2, BoxSession boxSession) {
            super(BoxFolder.class, str, str2, boxSession);
        }

        protected UpdateSharedFolder(UpdateFolder updateFolder) {
            super(updateFolder);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestUpdateSharedItem
        public UpdateSharedFolder setPermission(BoxSharedLink.Permission permission) {
            return (UpdateSharedFolder) super.setPermission(permission);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestUpdateSharedItem
        public Boolean getCanDownload() {
            return super.getCanDownload();
        }
    }

    public static class CopyFolder extends BoxRequestItemCopy<BoxFolder, CopyFolder> {
        private static final long serialVersionUID = 8123965031279971532L;

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

        public CopyFolder(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxFolder.class, str, str2, str3, boxSession);
        }
    }

    public static class CreateFolder extends BoxRequestItem<BoxFolder, CreateFolder> {
        private static final long serialVersionUID = 8123965031279971505L;

        public CreateFolder(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxFolder.class, null, str3, boxSession);
            this.mRequestMethod = BoxRequest.Methods.POST;
            setParentId(str);
            setName(str2);
        }

        public String getParentId() {
            if (this.mBodyMap.containsKey("parent")) {
                return (String) this.mBodyMap.get("id");
            }
            return null;
        }

        public CreateFolder setParentId(String str) {
            this.mBodyMap.put("parent", BoxFolder.createFromId(str));
            return this;
        }

        public String getName() {
            return (String) this.mBodyMap.get("name");
        }

        public CreateFolder setName(String str) {
            this.mBodyMap.put("name", str);
            return this;
        }
    }

    public static class DeleteFolder extends BoxRequestItemDelete<DeleteFolder> {
        private static final String FALSE = "false";
        private static final String FIELD_RECURSIVE = "recursive";
        private static final String TRUE = "true";
        private static final long serialVersionUID = 8123965031279971594L;

        public DeleteFolder(String str, String str2, BoxSession boxSession) {
            super(str, str2, boxSession);
            setRecursive(true);
        }

        public DeleteFolder(BoxItem boxItem, String str, BoxSession boxSession) {
            super(boxItem, str, boxSession);
            setRecursive(true);
        }

        public DeleteFolder setRecursive(boolean z) {
            this.mQueryMap.put(FIELD_RECURSIVE, z ? "true" : "false");
            return this;
        }

        public Boolean getRecursive() {
            return Boolean.valueOf("true".equals(this.mQueryMap.get(FIELD_RECURSIVE)));
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxVoid> boxResponse) throws BoxException {
            super.onSendCompleted(boxResponse);
            super.handleUpdateCache(boxResponse);
        }
    }

    public static class GetTrashedFolder extends BoxRequestItem<BoxFolder, GetTrashedFolder> implements BoxCacheableRequest<BoxFolder> {
        private static final long serialVersionUID = 8123965031279971509L;

        public GetTrashedFolder(String str, String str2, BoxSession boxSession) {
            super(BoxFolder.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public GetTrashedFolder setIfNoneMatchEtag(String str) {
            return (GetTrashedFolder) super.setIfNoneMatchEtag(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public String getIfNoneMatchEtag() {
            return super.getIfNoneMatchEtag();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFolder sendForCachedResult() throws BoxException {
            return (BoxFolder) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxFolder> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class DeleteTrashedFolder extends BoxRequestItemDelete<DeleteTrashedFolder> {
        private static final long serialVersionUID = 8123965031279971592L;

        public DeleteTrashedFolder(String str, String str2, BoxSession boxSession) {
            super(str, str2, boxSession);
        }
    }

    public static class RestoreTrashedFolder extends BoxRequestItemRestoreTrashed<BoxFolder, RestoreTrashedFolder> {
        private static final long serialVersionUID = 8123965031279971534L;

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

        public RestoreTrashedFolder(String str, String str2, BoxSession boxSession) {
            super(BoxFolder.class, str, str2, boxSession);
        }
    }

    public static class GetFolderItems extends BoxRequestItem<BoxIteratorItems, GetFolderItems> implements BoxCacheableRequest<BoxIteratorItems> {
        private static final String DEFAULT_LIMIT = "1000";
        private static final String DEFAULT_OFFSET = "0";
        private static final String LIMIT = "limit";
        private static final String OFFSET = "offset";
        private static final String USE_MARKER = "usemarker";
        private static final long serialVersionUID = 8123965031279971524L;

        public GetFolderItems(String str, String str2, BoxSession boxSession) {
            super(BoxIteratorItems.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
            this.mQueryMap.put("limit", DEFAULT_LIMIT);
            this.mQueryMap.put("offset", "0");
        }

        public GetFolderItems setLimit(int i) {
            this.mQueryMap.put("limit", String.valueOf(i));
            return this;
        }

        public GetFolderItems setOffset(int i) {
            this.mQueryMap.put("offset", String.valueOf(i));
            return this;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorItems sendForCachedResult() throws BoxException {
            return (BoxIteratorItems) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorItems> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }

        public GetFolderItems setUserMarker(boolean z) {
            this.mQueryMap.put(USE_MARKER, Boolean.toString(z));
            return this;
        }

        public GetFolderItems setSort(String str) {
            this.mQueryMap.put("sort", str);
            return this;
        }

        public GetFolderItems setDirection(String str) {
            this.mQueryMap.put("direction", str);
            return this;
        }
    }

    public static class AddFolderToCollection extends BoxRequestCollectionUpdate<BoxFolder, AddFolderToCollection> {
        private static final long serialVersionUID = 8123965031279971539L;

        public AddFolderToCollection(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxFolder.class, str, str3, boxSession);
            setCollectionId(str2);
            this.mRequestMethod = BoxRequest.Methods.PUT;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestCollectionUpdate
        public AddFolderToCollection setCollectionId(String str) {
            return (AddFolderToCollection) super.setCollectionId(str);
        }
    }

    public static class DeleteFolderFromCollection extends BoxRequestCollectionUpdate<BoxFolder, AddFolderToCollection> {
        private static final long serialVersionUID = 8123965031279971540L;

        public DeleteFolderFromCollection(String str, String str2, BoxSession boxSession) {
            super(BoxFolder.class, str, str2, boxSession);
            setCollectionId(null);
        }
    }

    public static class GetTrashedItems extends BoxRequest<BoxIteratorItems, GetTrashedItems> implements BoxCacheableRequest<BoxIteratorItems> {
        private static final long serialVersionUID = 8123965031279971576L;

        public GetTrashedItems(String str, BoxSession boxSession) {
            super(BoxIteratorItems.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorItems sendForCachedResult() throws BoxException {
            return (BoxIteratorItems) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorItems> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class GetFolderWithAllItems extends BoxRequestItem<BoxFolder, GetFolderWithAllItems> implements BoxCacheableRequest<BoxFolder> {
        public static final int DEFAULT_MAX_LIMIT = 4000;
        public static final int INITIAL_PAGE_LIMIT = 30;
        public static final int LIMIT = 100;
        public static final String QUERY_DIRECTION = "direction";
        public static final String QUERY_SORT = "sort";
        private static final long serialVersionUID = -146995041590363404L;
        private String mFolderId;
        private String mItemsUrl;
        private int mMaxLimit;

        public GetFolderWithAllItems(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxFolder.class, str, str2, boxSession);
            this.mMaxLimit = -1;
            this.mRequestMethod = BoxRequest.Methods.GET;
            this.mFolderId = str;
            this.mItemsUrl = str3;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public BoxFolder onSend() throws BoxException {
            BoxRequestBatch boxRequestBatch;
            String str = this.mQueryMap.get(QUERY_FIELDS);
            String str2 = this.mQueryMap.get("sort");
            String str3 = this.mQueryMap.get("direction");
            boolean z = false;
            String strRemoveFields = SdkUtils.removeFields(str, new String[]{BoxFolder.FIELD_ITEM_COLLECTION});
            BoxRequestBatch executor = new BoxRequestBatch().setExecutor(SdkUtils.createDefaultThreadPoolExecutor(10, 10, 3600L, TimeUnit.SECONDS));
            BoxRequestBatch executor2 = new BoxRequestBatch().setExecutor(SdkUtils.createDefaultThreadPoolExecutor(10, 10, 3600L, TimeUnit.SECONDS));
            GetFolderInfo fields = new GetFolderInfo(this.mFolderId, this.mRequestUrlString, this.mSession) { // from class: com.box.androidsdk.content.requests.BoxRequestsFolder.GetFolderWithAllItems.1
                @Override // com.box.androidsdk.content.requests.BoxRequestItem, com.box.androidsdk.content.requests.BoxRequest
                protected void onSendCompleted(BoxResponse<BoxFolder> boxResponse) throws BoxException {
                }
            }.setFields(strRemoveFields);
            if (!SdkUtils.isBlank(getIfNoneMatchEtag())) {
                fields.setIfNoneMatchEtag(getIfNoneMatchEtag());
            }
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            GetFolderItems direction = new GetFolderItems(this.mFolderId, this.mItemsUrl, this.mSession) { // from class: com.box.androidsdk.content.requests.BoxRequestsFolder.GetFolderWithAllItems.2
                @Override // com.box.androidsdk.content.requests.BoxRequestItem, com.box.androidsdk.content.requests.BoxRequest
                protected void onSendCompleted(BoxResponse<BoxIteratorItems> boxResponse) throws BoxException {
                }
            }.setFields(str).setLimit(30).setSort(str2).setDirection(str3);
            executor.addRequest(fields);
            executor.addRequest(direction);
            JsonObject jsonObject2 = null;
            for (BoxResponse boxResponse : executor.send().getResponses()) {
                if (boxResponse.isSuccess()) {
                    boolean z2 = z;
                    if (boxResponse.getRequest() instanceof GetFolderItems) {
                        BoxIteratorItems boxIteratorItems = (BoxIteratorItems) boxResponse.getResult();
                        Iterator<E> it = boxIteratorItems.iterator();
                        while (it.hasNext()) {
                            jsonArray.add(((BoxItem) it.next()).toJsonObject());
                        }
                        Long lFullSize = boxIteratorItems.fullSize();
                        boxRequestBatch = executor2;
                        jsonObject.add(BoxIterator.FIELD_TOTAL_COUNT, lFullSize.longValue());
                        jsonObject.add("entries", jsonArray);
                    } else {
                        boxRequestBatch = executor2;
                        if (boxResponse.getRequest() instanceof GetFolderInfo) {
                            jsonObject2 = ((BoxFolder) boxResponse.getResult()).toJsonObject();
                            jsonObject2.add(BoxFolder.FIELD_ITEM_COLLECTION, jsonObject);
                        }
                    }
                    executor2 = boxRequestBatch;
                    z = z2;
                    jsonObject2 = jsonObject2;
                } else {
                    throw ((BoxException) boxResponse.getException());
                }
            }
            boolean z3 = z;
            BoxRequestBatch boxRequestBatch2 = executor2;
            long jAsLong = jsonObject.get(BoxIterator.FIELD_TOTAL_COUNT).asLong();
            int i = this.mMaxLimit;
            if (i > 0 && i < jAsLong) {
                jAsLong = i;
            }
            if (30 >= jAsLong) {
                return new BoxFolder(jsonObject2);
            }
            super.handleUpdateCache(new BoxResponsePartial(new BoxFolder(jsonObject2), null, this));
            for (int i2 = 30; i2 < jAsLong; i2 += 100) {
                GetFolderItems getFolderItems = new GetFolderItems(this.mFolderId, this.mItemsUrl, this.mSession) { // from class: com.box.androidsdk.content.requests.BoxRequestsFolder.GetFolderWithAllItems.3
                    @Override // com.box.androidsdk.content.requests.BoxRequestItem, com.box.androidsdk.content.requests.BoxRequest
                    protected void onSendCompleted(BoxResponse<BoxIteratorItems> boxResponse2) throws BoxException {
                    }
                };
                String[] strArr = new String[1];
                strArr[z3 ? 1 : 0] = str;
                boxRequestBatch2.addRequest(getFolderItems.setFields(strArr).setOffset(i2).setLimit(100).setSort(str2).setDirection(str3));
            }
            for (BoxResponse boxResponse2 : boxRequestBatch2.send().getResponses()) {
                if (boxResponse2.isSuccess()) {
                    Iterator<E> it2 = ((BoxIteratorItems) boxResponse2.getResult()).iterator();
                    while (it2.hasNext()) {
                        jsonArray.add(((BoxItem) it2.next()).toJsonObject());
                    }
                } else {
                    throw ((BoxException) boxResponse2.getException());
                }
            }
            return new BoxFolder(jsonObject2);
        }

        public void setSort(String str) {
            this.mQueryMap.put("sort", str);
        }

        public void setDirection(String str) {
            this.mQueryMap.put("direction", str);
        }

        public GetFolderWithAllItems setMaximumLimit(int i) {
            this.mMaxLimit = i;
            return this;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public GetFolderWithAllItems setIfNoneMatchEtag(String str) {
            return (GetFolderWithAllItems) super.setIfNoneMatchEtag(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public String getIfNoneMatchEtag() {
            return super.getIfNoneMatchEtag();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFolder sendForCachedResult() throws BoxException {
            return (BoxFolder) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxFolder> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItem, com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxFolder> boxResponse) throws BoxException {
            super.onSendCompleted(boxResponse);
            super.handleUpdateCache(boxResponse);
        }
    }
}
