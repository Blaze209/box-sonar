package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxArray;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxMetadata;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxVoid;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestsMetadata {

    public static class AddItemMetadata<T extends AddItemMetadata, R extends AddItemMetadata<T, R>> extends BoxRequest<BoxMetadata, R> {
        private static final long serialVersionUID = 8123965031279971578L;

        public AddItemMetadata(Map<String, Object> map, String str, BoxSession boxSession) {
            super(BoxMetadata.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.POST;
            setValues(map);
        }

        protected R setValues(Map<String, Object> map) {
            this.mBodyMap.putAll(map);
            return this;
        }
    }

    public static class AddFileMetadata extends AddItemMetadata {
        public AddFileMetadata(Map<String, Object> map, String str, BoxSession boxSession) {
            super(map, str, boxSession);
        }
    }

    public static class GetItemMetadata extends BoxRequest<BoxMetadata, GetItemMetadata> implements BoxCacheableRequest<BoxMetadata> {
        private static final long serialVersionUID = 8123965031279971571L;

        public GetItemMetadata(String str, BoxSession boxSession) {
            super(BoxMetadata.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxMetadata sendForCachedResult() throws BoxException {
            return (BoxMetadata) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxMetadata> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class GetFileMetadata extends GetItemMetadata {
        public GetFileMetadata(String str, BoxSession boxSession) {
            super(str, boxSession);
        }
    }

    public static class UpdateItemMetadata<T extends UpdateItemMetadata, R extends UpdateItemMetadata<T, R>> extends BoxRequest<BoxMetadata, R> {
        private static final long serialVersionUID = 8123965031279971549L;
        private BoxArray<UpdateItemMetadata<T, R>.BoxMetadataUpdateTask> mUpdateTasks;

        public enum Operations {
            ADD("add"),
            REPLACE("replace"),
            REMOVE("remove"),
            TEST("test");

            private String mName;

            Operations(String str) {
                this.mName = str;
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.mName;
            }
        }

        public UpdateItemMetadata(String str, BoxSession boxSession) {
            super(BoxMetadata.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.PUT;
            this.mContentType = BoxRequest.ContentTypes.JSON_PATCH;
            this.mUpdateTasks = new BoxArray<>();
        }

        protected R setUpdateTasks(BoxArray<UpdateItemMetadata<T, R>.BoxMetadataUpdateTask> boxArray) {
            this.mBodyMap.put(BoxRequest.JSON_OBJECT, boxArray);
            return this;
        }

        public R addUpdateTask(Operations operations, String str, String str2) {
            this.mUpdateTasks.add(new BoxMetadataUpdateTask(operations, str, str2));
            return (R) setUpdateTasks(this.mUpdateTasks);
        }

        public R addUpdateTask(Operations operations, String str) {
            return (R) addUpdateTask(operations, str, "");
        }

        private class BoxMetadataUpdateTask extends BoxJsonObject {
            public static final String OPERATION = "op";
            public static final String PATH = "path";
            public static final String VALUE = "value";

            public BoxMetadataUpdateTask(Operations operations, String str, String str2) {
                set(OPERATION, operations.toString());
                set("path", "/" + str);
                if (operations != Operations.REMOVE) {
                    set("value", str2);
                }
            }
        }
    }

    public static class UpdateFileMetadata extends UpdateItemMetadata {
        public UpdateFileMetadata(String str, BoxSession boxSession) {
            super(str, boxSession);
        }
    }

    public static class DeleteItemMetadata extends BoxRequest<BoxVoid, DeleteItemMetadata> {
        private static final long serialVersionUID = 8123965031279971546L;

        public DeleteItemMetadata(String str, BoxSession boxSession) {
            super(BoxVoid.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.DELETE;
        }
    }

    public static class DeleteFileMetadata extends DeleteItemMetadata {
        public DeleteFileMetadata(String str, BoxSession boxSession) {
            super(str, boxSession);
        }
    }

    public static class GetMetadataTemplates extends BoxRequest<BoxMetadata, GetMetadataTemplates> implements BoxCacheableRequest<BoxMetadata> {
        private static final long serialVersionUID = 8123965031279971547L;

        public GetMetadataTemplates(String str, BoxSession boxSession) {
            super(BoxMetadata.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxMetadata sendForCachedResult() throws BoxException {
            return (BoxMetadata) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxMetadata> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class GetMetadataTemplateSchema extends BoxRequest<BoxMetadata, GetMetadataTemplateSchema> implements BoxCacheableRequest<BoxMetadata> {
        private static final long serialVersionUID = 8123965031279971586L;

        public GetMetadataTemplateSchema(String str, BoxSession boxSession) {
            super(BoxMetadata.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxMetadata sendForCachedResult() throws BoxException {
            return (BoxMetadata) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxMetadata> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }
}
