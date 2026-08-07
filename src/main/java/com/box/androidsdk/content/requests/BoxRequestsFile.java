package com.box.androidsdk.content.requests;

import android.text.TextUtils;
import android.util.Base64;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.localrepo.sqlitetables.BoxItemSQLData;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.listeners.ProgressListener;
import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.models.BoxDownload;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxExpiringEmbedLinkFile;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFileVersion;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxIteratorCollaborators;
import com.box.androidsdk.content.models.BoxIteratorComments;
import com.box.androidsdk.content.models.BoxIteratorFileVersions;
import com.box.androidsdk.content.models.BoxIteratorUploadSessionParts;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.box.androidsdk.content.models.BoxUploadSession;
import com.box.androidsdk.content.models.BoxUploadSessionPart;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.utils.ProgressOutputStream;
import com.box.boxandroidlibv2private.requests.BoxRequestCreateBoxNote;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestsFile {
    private static final String ATTRIBUTES = "attributes";

    public static class GetFileInfo extends BoxRequestItem<BoxFile, GetFileInfo> implements BoxCacheableRequest<BoxFile> {
        private static final long serialVersionUID = 8123965031279971501L;

        public GetFileInfo(String str, String str2, BoxSession boxSession) {
            super(BoxFile.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public GetFileInfo setIfNoneMatchEtag(String str) {
            return (GetFileInfo) super.setIfNoneMatchEtag(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public String getIfNoneMatchEtag() {
            return super.getIfNoneMatchEtag();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFile sendForCachedResult() throws BoxException {
            return (BoxFile) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxFile> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class GetEmbedLinkFileInfo extends BoxRequestItem<BoxExpiringEmbedLinkFile, GetEmbedLinkFileInfo> {
        private static final long serialVersionUID = 8123965031279971501L;

        public GetEmbedLinkFileInfo(String str, String str2, BoxSession boxSession) {
            super(BoxExpiringEmbedLinkFile.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
            setFields(BoxExpiringEmbedLinkFile.FIELD_EMBED_LINK);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItem
        public GetEmbedLinkFileInfo setFields(String... strArr) {
            boolean z = false;
            for (String str : strArr) {
                if (str.equalsIgnoreCase(BoxExpiringEmbedLinkFile.FIELD_EMBED_LINK)) {
                    z = true;
                }
            }
            if (!z) {
                String[] strArr2 = new String[strArr.length + 1];
                System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                strArr2[strArr.length] = BoxExpiringEmbedLinkFile.FIELD_EMBED_LINK;
                return (GetEmbedLinkFileInfo) super.setFields(strArr2);
            }
            return (GetEmbedLinkFileInfo) super.setFields(strArr);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public GetEmbedLinkFileInfo setIfNoneMatchEtag(String str) {
            return (GetEmbedLinkFileInfo) super.setIfNoneMatchEtag(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public String getIfNoneMatchEtag() {
            return super.getIfNoneMatchEtag();
        }
    }

    public static class UpdateFile extends BoxRequestItemUpdate<BoxFile, UpdateFile> {
        private static final long serialVersionUID = 8123965031279971521L;

        public UpdateFile(String str, String str2, BoxSession boxSession) {
            super(BoxFile.class, str, str2, boxSession);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItemUpdate
        public UpdatedSharedFile updateSharedLink() {
            return new UpdatedSharedFile(this);
        }
    }

    public static class UpdatedSharedFile extends BoxRequestUpdateSharedItem<BoxFile, UpdatedSharedFile> {
        private static final long serialVersionUID = 8123965031279971520L;

        public UpdatedSharedFile(String str, String str2, BoxSession boxSession) {
            super(BoxFile.class, str, str2, boxSession);
        }

        protected UpdatedSharedFile(UpdateFile updateFile) {
            super(updateFile);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestUpdateSharedItem
        public UpdatedSharedFile setPermission(BoxSharedLink.Permission permission) {
            return (UpdatedSharedFile) super.setPermission(permission);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestUpdateSharedItem
        public Boolean getCanDownload() {
            return super.getCanDownload();
        }
    }

    public static class CopyFile extends BoxRequestItemCopy<BoxFile, CopyFile> {
        private static final long serialVersionUID = 8123965031279971533L;

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

        public CopyFile(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxFile.class, str, str2, str3, boxSession);
        }
    }

    public static class DeleteFile extends BoxRequestItemDelete<DeleteFile> {
        private static final long serialVersionUID = 8123965031279971593L;

        public DeleteFile(String str, String str2, BoxSession boxSession) {
            super(str, str2, boxSession);
        }

        public DeleteFile(BoxItem boxItem, String str, BoxSession boxSession) {
            super(boxItem, str, boxSession);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxVoid> boxResponse) throws BoxException {
            super.onSendCompleted(boxResponse);
            super.handleUpdateCache(boxResponse);
        }
    }

    public static class GetTrashedFile extends BoxRequestItem<BoxFile, GetTrashedFile> implements BoxCacheableRequest<BoxFile> {
        private static final long serialVersionUID = 8123965031279971543L;

        public GetTrashedFile(String str, String str2, BoxSession boxSession) {
            super(BoxFile.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public GetTrashedFile setIfNoneMatchEtag(String str) {
            return (GetTrashedFile) super.setIfNoneMatchEtag(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public String getIfNoneMatchEtag() {
            return super.getIfNoneMatchEtag();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFile sendForCachedResult() throws BoxException {
            return (BoxFile) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxFile> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class DeleteTrashedFile extends BoxRequestItemDelete<DeleteTrashedFile> {
        private static final long serialVersionUID = 8123965031279971590L;

        public DeleteTrashedFile(String str, String str2, BoxSession boxSession) {
            super(str, str2, boxSession);
        }
    }

    public static class RestoreTrashedFile extends BoxRequestItemRestoreTrashed<BoxFile, RestoreTrashedFile> {
        private static final long serialVersionUID = 8123965031279971535L;

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

        public RestoreTrashedFile(String str, String str2, BoxSession boxSession) {
            super(BoxFile.class, str, str2, boxSession);
        }
    }

    public static class GetFileComments extends BoxRequestItem<BoxIteratorComments, GetFileComments> implements BoxCacheableRequest<BoxIteratorComments> {
        private static final String QUERY_LIMIT = "limit";
        private static final String QUERY_OFFSET = "offset";
        private static final long serialVersionUID = 8123965031279971525L;

        public GetFileComments(String str, String str2, BoxSession boxSession) {
            super(BoxIteratorComments.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
            setFields(BoxComment.ALL_FIELDS);
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorComments sendForCachedResult() throws BoxException {
            return (BoxIteratorComments) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorComments> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }

        public void setLimit(int i) {
            this.mQueryMap.put("limit", Integer.toString(i));
        }

        public void setOffset(int i) {
            this.mQueryMap.put("offset", Integer.toString(i));
        }
    }

    public static class AddCommentToFile extends BoxRequestCommentAdd<BoxComment, AddCommentToFile> {
        private static final long serialVersionUID = 8123965031279971514L;

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

        public AddCommentToFile(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxComment.class, str3, boxSession);
            setItemId(str);
            setItemType("file");
            setMessage(str2);
        }
    }

    public static class AddTaggedCommentToFile extends BoxRequestCommentAdd<BoxComment, AddTaggedCommentToFile> {
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

        public AddTaggedCommentToFile(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxComment.class, str3, boxSession);
            setItemId(str);
            setItemType("file");
            setTaggedMessage(str2);
        }
    }

    public static class GetFileVersions extends BoxRequestItem<BoxIteratorFileVersions, GetFileVersions> implements BoxCacheableRequest<BoxIteratorFileVersions> {
        private static final long serialVersionUID = 8123965031279971530L;

        public GetFileVersions(String str, String str2, BoxSession boxSession) {
            super(BoxIteratorFileVersions.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
            setFields(BoxFileVersion.ALL_FIELDS);
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorFileVersions sendForCachedResult() throws BoxException {
            return (BoxIteratorFileVersions) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorFileVersions> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class UploadFile extends BoxRequestUpload<BoxFile, UploadFile> {
        private static final long serialVersionUID = 8123965031279971502L;
        String mDestinationFolderId;

        public UploadFile(InputStream inputStream, String str, String str2, String str3, BoxSession boxSession) {
            super(BoxFile.class, inputStream, str3, boxSession);
            this.mRequestUrlString = str3;
            this.mRequestMethod = BoxRequest.Methods.POST;
            this.mFileName = str;
            this.mStream = inputStream;
            this.mDestinationFolderId = str2;
        }

        public UploadFile(File file, String str, String str2, BoxSession boxSession) {
            super(BoxFile.class, null, str2, boxSession);
            this.mRequestUrlString = str2;
            this.mRequestMethod = BoxRequest.Methods.POST;
            this.mDestinationFolderId = str;
            this.mFileName = file.getName();
            this.mFile = file;
            this.mUploadSize = file.length();
            this.mModifiedDate = new Date(file.lastModified());
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestUpload
        protected BoxRequestMultipart createMultipartRequest() throws BoxException, IOException {
            BoxRequestMultipart boxRequestMultipartCreateMultipartRequest = super.createMultipartRequest();
            boxRequestMultipartCreateMultipartRequest.putField(BoxItemSQLData.COL_PARENT_ID, this.mDestinationFolderId);
            return boxRequestMultipartCreateMultipartRequest;
        }

        public String getFileName() {
            return this.mFileName;
        }

        public UploadFile setFileName(String str) {
            this.mFileName = str;
            return this;
        }

        public String getDestinationFolderId() {
            return this.mDestinationFolderId;
        }
    }

    public static class GetCollaborations extends BoxRequestItem<BoxIteratorCollaborations, GetCollaborations> implements BoxCacheableRequest<BoxIteratorCollaborations> {
        private static final long serialVersionUID = 8123965031219971519L;

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

    public static class GetCollaborators extends BoxRequestItem<BoxIteratorCollaborators, GetCollaborators> implements BoxCacheableRequest<BoxIteratorCollaborators> {
        private static final long serialVersionUID = 8123965031219971519L;

        public GetCollaborators(String str, String str2, BoxSession boxSession) {
            super(BoxIteratorCollaborators.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorCollaborators sendForCachedResult() throws BoxException {
            return (BoxIteratorCollaborators) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorCollaborators> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class UploadNewVersion extends BoxRequestUpload<BoxFile, UploadNewVersion> {
        private static String NEW_NAME_JSON_TEMPLATE = "{\"name\": \"%s\"}";

        public UploadNewVersion(InputStream inputStream, String str, BoxSession boxSession) {
            super(BoxFile.class, inputStream, str, boxSession);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public UploadNewVersion setIfMatchEtag(String str) {
            return (UploadNewVersion) super.setIfMatchEtag(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public String getIfMatchEtag() {
            return super.getIfMatchEtag();
        }

        public void setFileName(String str) {
            this.mFileName = str;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestUpload
        protected BoxRequestMultipart createMultipartRequest() throws BoxException, IOException {
            BoxRequestMultipart boxRequestMultipartCreateMultipartRequest = super.createMultipartRequest();
            if (!TextUtils.isEmpty(this.mFileName)) {
                boxRequestMultipartCreateMultipartRequest.putField("attributes", String.format(Locale.ENGLISH, NEW_NAME_JSON_TEMPLATE, this.mFileName));
            }
            return boxRequestMultipartCreateMultipartRequest;
        }
    }

    public static class DownloadAvatar extends BoxRequestDownload<BoxDownload, DownloadFile> {
        public static final String LARGE = "large";
        public static final String PROFILE = "profile";
        private static final String QUERY_AVATAR_TYPE = "pic_type";
        public static final String SMALL = "small";

        @Retention(RetentionPolicy.SOURCE)
        public @interface AvatarType {
        }

        public DownloadAvatar(String str, File file, String str2, BoxSession boxSession) {
            super(str, BoxDownload.class, file, str2, boxSession);
        }

        public DownloadAvatar setAvatarType(String str) {
            this.mQueryMap.put(QUERY_AVATAR_TYPE, str);
            return this;
        }
    }

    public static class DownloadFile extends BoxRequestDownload<BoxDownload, DownloadFile> {
        private static final long serialVersionUID = 8123965031279971588L;

        public DownloadFile(String str, OutputStream outputStream, String str2, BoxSession boxSession) {
            super(str, BoxDownload.class, outputStream, str2, boxSession);
        }

        @Deprecated
        public DownloadFile(OutputStream outputStream, String str, BoxSession boxSession) {
            super(BoxDownload.class, outputStream, str, boxSession);
        }

        public DownloadFile(String str, File file, String str2, BoxSession boxSession) {
            super(str, BoxDownload.class, file, str2, boxSession);
        }

        @Deprecated
        public DownloadFile(File file, String str, BoxSession boxSession) {
            super(BoxDownload.class, file, str, boxSession);
        }
    }

    public static class CheckFileConsistency extends DownloadFile {
        public CheckFileConsistency(OutputStream outputStream, String str, BoxSession boxSession) {
            super(outputStream, str, boxSession);
            setRange(0L, 0L);
        }
    }

    public static class DownloadThumbnail extends BoxRequestDownload<BoxDownload, DownloadThumbnail> {
        private static final String FIELD_MAX_HEIGHT = "max_height";
        private static final String FIELD_MAX_WIDTH = "max_width";
        private static final String FIELD_MIN_HEIGHT = "min_height";
        private static final String FIELD_MIN_WIDTH = "min_width";
        public static final int SIZE_128 = 128;
        public static final int SIZE_160 = 160;
        public static final int SIZE_256 = 256;
        public static final int SIZE_32 = 32;
        public static final int SIZE_320 = 320;
        public static final int SIZE_64 = 64;
        public static final int SIZE_94 = 94;
        private static final long serialVersionUID = 8123965031279971587L;
        protected Format mFormat;

        public enum Format {
            JPG(".jpg"),
            PNG(".png");

            private final String mExt;

            Format(String str) {
                this.mExt = str;
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.mExt;
            }
        }

        public DownloadThumbnail(String str, OutputStream outputStream, String str2, BoxSession boxSession) {
            super(str, BoxDownload.class, outputStream, str2, boxSession);
            this.mFormat = null;
        }

        @Deprecated
        public DownloadThumbnail(OutputStream outputStream, String str, BoxSession boxSession) {
            super(BoxDownload.class, outputStream, str, boxSession);
            this.mFormat = null;
        }

        public DownloadThumbnail(String str, File file, String str2, BoxSession boxSession) {
            super(str, BoxDownload.class, file, str2, boxSession);
            this.mFormat = null;
        }

        @Deprecated
        public DownloadThumbnail(File file, String str, BoxSession boxSession) {
            super(BoxDownload.class, file, str, boxSession);
            this.mFormat = null;
        }

        public Integer getMinWidth() {
            if (this.mQueryMap.containsKey(FIELD_MIN_WIDTH)) {
                return Integer.valueOf(Integer.parseInt(this.mQueryMap.get(FIELD_MIN_WIDTH)));
            }
            return null;
        }

        public DownloadThumbnail setMinWidth(int i) {
            this.mQueryMap.put(FIELD_MIN_WIDTH, Integer.toString(i));
            return this;
        }

        public Integer getMaxWidth() {
            if (this.mQueryMap.containsKey(FIELD_MAX_WIDTH)) {
                return Integer.valueOf(Integer.parseInt(this.mQueryMap.get(FIELD_MAX_WIDTH)));
            }
            return null;
        }

        public DownloadThumbnail setMaxWidth(int i) {
            this.mQueryMap.put(FIELD_MAX_WIDTH, Integer.toString(i));
            return this;
        }

        public Integer getMinHeight() {
            if (this.mQueryMap.containsKey(FIELD_MIN_HEIGHT)) {
                return Integer.valueOf(Integer.parseInt(this.mQueryMap.get(FIELD_MIN_HEIGHT)));
            }
            return null;
        }

        public DownloadThumbnail setMinHeight(int i) {
            this.mQueryMap.put(FIELD_MIN_HEIGHT, Integer.toString(i));
            return this;
        }

        public Integer getMaxHeight() {
            if (this.mQueryMap.containsKey(FIELD_MAX_HEIGHT)) {
                return Integer.valueOf(Integer.parseInt(this.mQueryMap.get(FIELD_MAX_HEIGHT)));
            }
            return null;
        }

        public DownloadThumbnail setMaxHeight(int i) {
            this.mQueryMap.put(FIELD_MAX_HEIGHT, Integer.toString(i));
            return this;
        }

        public DownloadThumbnail setMinSize(int i) {
            setMinWidth(i);
            setMinHeight(i);
            return this;
        }

        public DownloadThumbnail setFormat(Format format) {
            this.mFormat = format;
            return this;
        }

        public Format getFormat() {
            return this.mFormat;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected URL buildUrl() throws MalformedURLException, UnsupportedEncodingException {
            String strCreateQuery = createQuery(this.mQueryMap);
            String str = String.format(Locale.ENGLISH, "%s%s", this.mRequestUrlString, getThumbnailExtension());
            return TextUtils.isEmpty(strCreateQuery) ? new URL(str) : new URL(String.format(Locale.ENGLISH, "%s?%s", str, strCreateQuery));
        }

        protected String getThumbnailExtension() {
            Integer maxHeight;
            Format format = this.mFormat;
            if (format != null) {
                return format.toString();
            }
            if (getMinWidth() != null) {
                maxHeight = getMinWidth();
            } else if (getMinHeight() != null) {
                maxHeight = getMinHeight();
            } else if (getMaxWidth() != null) {
                maxHeight = getMaxWidth();
            } else {
                maxHeight = getMaxHeight() != null ? getMaxHeight() : null;
            }
            if (maxHeight == null) {
                return Format.JPG.toString();
            }
            int iIntValue = maxHeight.intValue();
            if (iIntValue <= 32) {
                return Format.PNG.toString();
            }
            if (iIntValue <= 64) {
                return Format.PNG.toString();
            }
            if (iIntValue <= 94) {
                return Format.JPG.toString();
            }
            if (iIntValue <= 128) {
                return Format.PNG.toString();
            }
            if (iIntValue <= 160) {
                return Format.JPG.toString();
            }
            if (iIntValue <= 256) {
                return Format.PNG.toString();
            }
            return Format.JPG.toString();
        }
    }

    public static class AddFileToCollection extends BoxRequestCollectionUpdate<BoxFile, AddFileToCollection> {
        private static final long serialVersionUID = 8123965031279971537L;

        public AddFileToCollection(String str, String str2, String str3, BoxSession boxSession) {
            super(BoxFile.class, str, str3, boxSession);
            setCollectionId(str2);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestCollectionUpdate
        public AddFileToCollection setCollectionId(String str) {
            return (AddFileToCollection) super.setCollectionId(str);
        }
    }

    public static class DeleteFileFromCollection extends BoxRequestCollectionUpdate<BoxFile, DeleteFileFromCollection> {
        private static final long serialVersionUID = 8123965031279971538L;

        public DeleteFileFromCollection(String str, String str2, BoxSession boxSession) {
            super(BoxFile.class, str, str2, boxSession);
            setCollectionId(null);
        }
    }

    public static class FilePreviewed extends BoxRequest<BoxVoid, FilePreviewed> {
        private static final String TYPE_FILE = "file";
        private static final String TYPE_ITEM_PREVIEW = "PREVIEW";
        private String mFileId;

        public FilePreviewed(String str, String str2, BoxSession boxSession) {
            super(BoxVoid.class, str2, boxSession);
            this.mFileId = str;
            this.mRequestMethod = BoxRequest.Methods.POST;
            this.mBodyMap.put("type", "event");
            this.mBodyMap.put("event_type", TYPE_ITEM_PREVIEW);
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("type", "file");
            jsonObject.add("id", str);
            this.mBodyMap.put("source", BoxEntity.createEntityFromJson(jsonObject));
        }

        public String getFileId() {
            return this.mFileId;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxVoid> boxResponse) throws BoxException {
            super.onSendCompleted(boxResponse);
            super.handleUpdateCache(boxResponse);
        }
    }

    public static class DownloadRepresentation extends BoxRequestDownload<BoxDownload, DownloadRepresentation> {
        protected BoxRepresentation mRepresentation;
        protected int mRequestPage;

        public DownloadRepresentation(String str, File file, BoxRepresentation boxRepresentation, BoxSession boxSession) {
            super(str, BoxDownload.class, file, boxRepresentation.getContent().getUrl(), boxSession);
            this.mRequestPage = 1;
            this.mRepresentation = boxRepresentation;
        }

        public DownloadRepresentation(String str, OutputStream outputStream, BoxRepresentation boxRepresentation, BoxSession boxSession) {
            super(str, BoxDownload.class, outputStream, boxRepresentation.getContent().getUrl(), boxSession);
            this.mRequestPage = 1;
            this.mRepresentation = boxRepresentation;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected URL buildUrl() throws MalformedURLException, UnsupportedEncodingException {
            String str;
            if (!isPaged()) {
                str = "";
            } else {
                str = String.format(Locale.ENGLISH, "%d.%s", Integer.valueOf(this.mRequestPage), this.mRepresentation.getRepresentationType());
            }
            return new URL(this.mRequestUrlString.replace("{+asset_path}", str));
        }

        public boolean isPaged() {
            return this.mRepresentation.getProperties().isPaged();
        }

        public void setRequestedPage(int i) {
            this.mRequestPage = i;
        }
    }

    public static class CreateUploadSession extends BoxRequest<BoxUploadSession, CreateUploadSession> {
        private static final long serialVersionUID = 8145675031279971502L;
        private String mDestinationFolderId;
        private InputStream mFileInputStream;
        private String mFileName;
        private long mFileSize;

        public CreateUploadSession(File file, String str, String str2, BoxSession boxSession) throws FileNotFoundException {
            super(BoxUploadSession.class, str2, boxSession);
            this.mRequestUrlString = str2;
            this.mRequestMethod = BoxRequest.Methods.POST;
            this.mFileName = file.getName();
            this.mFileSize = file.length();
            this.mFileInputStream = new FileInputStream(file);
            this.mDestinationFolderId = str;
            this.mBodyMap.put("folder_id", str);
            this.mBodyMap.put(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_SIZE, Long.valueOf(this.mFileSize));
            this.mBodyMap.put(BoxRequestCreateBoxNote.FIELD_FILE_NAME, this.mFileName);
        }

        public CreateUploadSession(InputStream inputStream, String str, long j, String str2, String str3, BoxSession boxSession) {
            super(BoxUploadSession.class, str3, boxSession);
            this.mRequestUrlString = str3;
            this.mRequestMethod = BoxRequest.Methods.POST;
            this.mFileName = str;
            this.mFileSize = j;
            this.mFileInputStream = inputStream;
            this.mDestinationFolderId = str2;
            this.mBodyMap.put("folder_id", str2);
            this.mBodyMap.put(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_SIZE, Long.valueOf(this.mFileSize));
            this.mBodyMap.put(BoxRequestCreateBoxNote.FIELD_FILE_NAME, this.mFileName);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxUploadSession> boxResponse) throws BoxException {
            if (boxResponse.isSuccess()) {
                try {
                    computeSha1s(this.mFileInputStream, (BoxUploadSession) boxResponse.getResult(), this.mFileSize);
                } catch (IOException e) {
                    throw new BoxException("Can't compute sha1 for file", e);
                } catch (NoSuchAlgorithmException e2) {
                    throw new BoxException("Can't compute sha1 for file", e2);
                }
            }
            super.onSendCompleted(boxResponse);
        }

        static void computeSha1s(InputStream inputStream, BoxUploadSession boxUploadSession, long j) throws NoSuchAlgorithmException, IOException {
            int totalParts = boxUploadSession.getTotalParts();
            ArrayList arrayList = new ArrayList(totalParts);
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-1");
            for (int i = 0; i < totalParts; i++) {
                int chunkSize = BoxUploadSession.getChunkSize(boxUploadSession, i, j);
                while (chunkSize > 0) {
                    int iMin = Math.min(chunkSize, 8192);
                    int i2 = inputStream.read(bArr, 0, iMin);
                    if (i2 == -1) {
                        if (i2 == -1) {
                            break;
                        }
                    } else {
                        chunkSize -= i2;
                        messageDigest2.update(bArr, 0, iMin);
                        messageDigest.update(bArr, 0, iMin);
                    }
                }
                arrayList.add(Base64.encodeToString(messageDigest2.digest(), 0));
                messageDigest2.reset();
            }
            boxUploadSession.setPartsSha1(arrayList);
            boxUploadSession.setSha1(Base64.encodeToString(messageDigest.digest(), 0));
        }

        public void setFileName(String str) {
            this.mFileName = str;
            this.mBodyMap.put(BoxRequestCreateBoxNote.FIELD_FILE_NAME, str);
        }

        public String getFileName() {
            return this.mFileName;
        }

        public long getFileSize() {
            return this.mFileSize;
        }

        public String getDestinationFolderId() {
            return this.mDestinationFolderId;
        }
    }

    public static class UploadSessionPart extends BoxRequest<BoxUploadSessionPart, UploadSessionPart> {
        private static final String CONTENT_RANGE_HEADER = "content-range";
        static final String DIGEST_HEADER = "digest";
        static final String DIGEST_HEADER_PREFIX_SHA = "sha=";
        private static final long serialVersionUID = 8245675031279971502L;
        private int mCurrentChunkSize;
        private File mFile;
        private long mFileSize;
        private InputStream mInputStream;
        private boolean mIsAlreadyPositioned;
        private final int mPartNumber;
        private final BoxUploadSession mUploadSession;

        public UploadSessionPart setAlreadyPositioned(boolean z) {
            return this;
        }

        public UploadSessionPart(File file, BoxUploadSession boxUploadSession, int i, BoxSession boxSession) throws IOException {
            super(BoxUploadSessionPart.class, boxUploadSession.getEndpoints().getUploadPartEndpoint(), boxSession);
            this.mIsAlreadyPositioned = false;
            this.mRequestUrlString = boxUploadSession.getEndpoints().getUploadPartEndpoint();
            this.mRequestMethod = BoxRequest.Methods.PUT;
            this.mPartNumber = i;
            this.mUploadSession = boxUploadSession;
            this.mFile = file;
            this.mCurrentChunkSize = BoxUploadSession.getChunkSize(boxUploadSession, i, file.length());
            this.mFileSize = file.length();
            this.mContentType = BoxRequest.ContentTypes.APPLICATION_OCTET_STREAM;
        }

        public UploadSessionPart(InputStream inputStream, long j, BoxUploadSession boxUploadSession, int i, BoxSession boxSession) throws IOException {
            super(BoxUploadSessionPart.class, boxUploadSession.getEndpoints().getUploadPartEndpoint(), boxSession);
            this.mIsAlreadyPositioned = false;
            this.mRequestUrlString = boxUploadSession.getEndpoints().getUploadPartEndpoint();
            this.mRequestMethod = BoxRequest.Methods.PUT;
            this.mPartNumber = i;
            this.mUploadSession = boxUploadSession;
            this.mInputStream = inputStream;
            this.mCurrentChunkSize = BoxUploadSession.getChunkSize(boxUploadSession, i, j);
            this.mFileSize = j;
            this.mContentType = BoxRequest.ContentTypes.APPLICATION_OCTET_STREAM;
        }

        protected InputStream getInputStream() throws FileNotFoundException {
            InputStream inputStream = this.mInputStream;
            return inputStream != null ? inputStream : new FileInputStream(this.mFile);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void createHeaderMap() {
            super.createHeaderMap();
            long partSize = ((long) this.mPartNumber) * ((long) this.mUploadSession.getPartSize());
            this.mHeaderMap.put(CONTENT_RANGE_HEADER, "bytes " + partSize + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + ((((long) this.mCurrentChunkSize) + partSize) - 1) + "/" + this.mFileSize);
            this.mHeaderMap.put(DIGEST_HEADER, DIGEST_HEADER_PREFIX_SHA + this.mUploadSession.getFieldPartsSha1().get(this.mPartNumber));
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void setBody(BoxHttpRequest boxHttpRequest) throws IOException {
            OutputStream outputStream;
            int i;
            InputStream inputStream = getInputStream();
            if (!this.mIsAlreadyPositioned) {
                inputStream.skip(((long) this.mPartNumber) * ((long) this.mUploadSession.getPartSize()));
            }
            HttpURLConnection urlConnection = boxHttpRequest.getUrlConnection();
            urlConnection.setDoOutput(true);
            byte[] bArr = new byte[8192];
            try {
                try {
                    if (this.mListener != null) {
                        outputStream = new ProgressOutputStream(urlConnection.getOutputStream(), this.mListener, getPartSize());
                    } else {
                        outputStream = urlConnection.getOutputStream();
                    }
                    long j = 0;
                    do {
                        try {
                            if (Thread.currentThread().isInterrupted()) {
                                throw new InterruptedException();
                            }
                            long j2 = ((long) 8192) + j;
                            int i2 = this.mCurrentChunkSize;
                            if (j2 > i2) {
                                i = inputStream.read(bArr, 0, (int) (j2 - ((long) i2)));
                            } else {
                                i = inputStream.read(bArr, 0, 8192);
                            }
                            if (i != -1) {
                                outputStream.write(bArr, 0, i);
                                j += (long) i;
                            }
                            if (i == -1) {
                                break;
                            }
                        } catch (Throwable th) {
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } while (j < this.mCurrentChunkSize);
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (this.mFile == null && this.mIsAlreadyPositioned) {
                        return;
                    }
                    inputStream.close();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IOException(e);
                }
            } catch (Throwable th3) {
                if (this.mFile != null || !this.mIsAlreadyPositioned) {
                    inputStream.close();
                }
                throw th3;
            }
        }

        public UploadSessionPart setProgressListener(ProgressListener progressListener) {
            this.mListener = progressListener;
            return this;
        }

        public long getPartSize() {
            return this.mCurrentChunkSize;
        }
    }

    public static class CommitUploadSession extends BoxRequestItem<BoxFile, CommitUploadSession> {
        private static final String IF_MATCH = "If-Match";
        private static final String IF_NONE_MATCH = "If-Non-Match";
        private static final long serialVersionUID = 8245675031279972519L;
        private final String mIfMatch;
        private final String mIfNoneMatch;
        private final String mSha1;
        private final BoxUploadSession mUploadSession;

        public CommitUploadSession(List<BoxUploadSessionPart> list, Map<String, String> map, String str, String str2, BoxUploadSession boxUploadSession, BoxSession boxSession) {
            super(BoxFile.class, null, boxUploadSession.getEndpoints().getCommitEndpoint(), boxSession);
            this.mRequestMethod = BoxRequest.Methods.POST;
            this.mIfMatch = str;
            this.mIfNoneMatch = str2;
            this.mUploadSession = boxUploadSession;
            this.mSha1 = boxUploadSession.getSha1();
            this.mContentType = BoxRequest.ContentTypes.JSON;
            setCommitBody(list, map);
            setRequestHandler(new MultiputResponseHandler(this));
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestItem, com.box.androidsdk.content.requests.BoxRequest
        protected void createHeaderMap() {
            super.createHeaderMap();
            this.mHeaderMap.put("digest", "sha=" + this.mSha1);
            if (!TextUtils.isEmpty(this.mIfMatch)) {
                this.mHeaderMap.put("If-Match", this.mIfMatch);
            }
            if (TextUtils.isEmpty(IF_NONE_MATCH)) {
                return;
            }
            this.mHeaderMap.put(IF_NONE_MATCH, this.mIfNoneMatch);
        }

        private void setCommitBody(List<BoxUploadSessionPart> list, Map<String, String> map) {
            JsonArray jsonArray = new JsonArray();
            for (BoxUploadSessionPart boxUploadSessionPart : list) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.add(BoxUploadSessionPart.FIELD_PART_ID, boxUploadSessionPart.getPartId());
                jsonObject.add("offset", boxUploadSessionPart.getOffset());
                jsonObject.add("size", boxUploadSessionPart.getSize());
                jsonArray.add(jsonObject);
            }
            this.mBodyMap.put("parts", jsonArray);
            if (map != null) {
                JsonObject jsonObject2 = new JsonObject();
                for (String str : map.keySet()) {
                    jsonObject2.add(str, map.get(str));
                }
                this.mBodyMap.put("attributes", jsonObject2);
            }
        }

        public BoxUploadSession getUploadSession() {
            return this.mUploadSession;
        }
    }

    public static class ListUploadSessionParts extends BoxRequest<BoxIteratorUploadSessionParts, ListUploadSessionParts> {
        private static final String QUERY_LIMIT = "limit";
        private static final String QUERY_OFFSET = "offset";
        private static final long serialVersionUID = 8245675031255572519L;
        private final BoxUploadSession mUploadSession;

        public ListUploadSessionParts(BoxUploadSession boxUploadSession, BoxSession boxSession) {
            super(BoxIteratorUploadSessionParts.class, boxUploadSession.getEndpoints().getListPartsEndpoint(), boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
            this.mUploadSession = boxUploadSession;
        }

        public void setLimit(int i) {
            this.mQueryMap.put("limit", Integer.toString(i));
        }

        public void setOffset(int i) {
            this.mQueryMap.put("offset", Integer.toString(i));
        }

        public BoxUploadSession getUploadSession() {
            return this.mUploadSession;
        }
    }

    public static class AbortUploadSession extends BoxRequest<BoxVoid, AbortUploadSession> {
        private static final long serialVersionUID = 8123965031279972343L;
        private final BoxUploadSession mUploadSession;

        public AbortUploadSession(BoxUploadSession boxUploadSession, BoxSession boxSession) {
            super(BoxVoid.class, boxUploadSession.getEndpoints().getAbortEndpoint(), boxSession);
            this.mRequestMethod = BoxRequest.Methods.DELETE;
            this.mUploadSession = boxUploadSession;
        }

        public BoxUploadSession getUploadSession() {
            return this.mUploadSession;
        }
    }

    public static class GetUploadSession extends BoxRequest<BoxUploadSession, GetUploadSession> {
        private static final long serialVersionUID = 8124575031279972343L;
        private String mId;

        public GetUploadSession(String str, String str2, BoxSession boxSession) {
            super(BoxUploadSession.class, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
            this.mId = str;
        }

        public String getId() {
            return this.mId;
        }
    }

    public static class CreateNewVersionUploadSession extends BoxRequest<BoxUploadSession, CreateNewVersionUploadSession> {
        private static final long serialVersionUID = 8182475031279971502L;
        private String mFileName;
        private long mFileSize;
        private InputStream mInputStream;

        public CreateNewVersionUploadSession(File file, String str, BoxSession boxSession) throws FileNotFoundException {
            super(BoxUploadSession.class, str, boxSession);
            this.mRequestUrlString = str;
            this.mRequestMethod = BoxRequest.Methods.POST;
            this.mFileName = file.getName();
            this.mFileSize = file.length();
            this.mInputStream = new FileInputStream(file);
            this.mBodyMap.put(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_SIZE, Long.valueOf(this.mFileSize));
            this.mBodyMap.put(BoxRequestCreateBoxNote.FIELD_FILE_NAME, this.mFileName);
        }

        public CreateNewVersionUploadSession(InputStream inputStream, String str, long j, String str2, BoxSession boxSession) throws FileNotFoundException {
            super(BoxUploadSession.class, str2, boxSession);
            this.mRequestUrlString = str2;
            this.mRequestMethod = BoxRequest.Methods.POST;
            this.mFileName = str;
            this.mFileSize = j;
            this.mInputStream = inputStream;
            this.mBodyMap.put(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_SIZE, Long.valueOf(this.mFileSize));
            this.mBodyMap.put(BoxRequestCreateBoxNote.FIELD_FILE_NAME, this.mFileName);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxUploadSession> boxResponse) throws BoxException {
            if (boxResponse.isSuccess()) {
                try {
                    CreateUploadSession.computeSha1s(this.mInputStream, (BoxUploadSession) boxResponse.getResult(), this.mFileSize);
                } catch (IOException e) {
                    throw new BoxException("Can't compute sha1 for file", e);
                } catch (NoSuchAlgorithmException e2) {
                    throw new BoxException("Can't compute sha1 for file", e2);
                }
            }
            super.onSendCompleted(boxResponse);
        }

        public void setFileName(String str) {
            this.mFileName = str;
            this.mBodyMap.put(BoxRequestCreateBoxNote.FIELD_FILE_NAME, str);
        }

        public String getFileName() {
            return this.mFileName;
        }

        public long getFileSize() {
            return this.mFileSize;
        }
    }
}
