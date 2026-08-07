package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItem;
import com.box.boxandroidlibv2private.model.BoxFileMute;

/* JADX INFO: loaded from: classes13.dex */
public class BoxFileNotificationMute {

    public static class GetFileMute extends BoxRequestItem<BoxFileMute, GetFileMute> implements BoxCacheableRequest<BoxFileMute> {
        public GetFileMute(String str, String str2, BoxSession boxSession) {
            super(BoxFileMute.class, str, str2, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public GetFileMute setIfNoneMatchEtag(String str) {
            return (GetFileMute) super.setIfNoneMatchEtag(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public String getIfNoneMatchEtag() {
            return super.getIfNoneMatchEtag();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFileMute sendForCachedResult() throws BoxException {
            return (BoxFileMute) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxFileMute> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class RemoveFileMute extends BoxRequest<BoxVoid, RemoveFileMute> implements BoxCacheableRequest<BoxVoid> {
        private final String mFileId;
        private String mMuteCategory;

        public RemoveFileMute(String str, String str2, BoxSession boxSession, String str3) {
            super(BoxVoid.class, str2, boxSession);
            this.mMuteCategory = str3;
            this.mFileId = str;
        }

        public String getMuteCategory() {
            return this.mMuteCategory;
        }

        public String getId() {
            return this.mFileId;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxVoid sendForCachedResult() throws BoxException {
            return (BoxVoid) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxVoid> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class AddFileMute extends BoxRequest<BoxVoid, RemoveFileMute> implements BoxCacheableRequest<BoxVoid> {
        private final String mFileId;
        private String mMuteCategory;

        public AddFileMute(String str, String str2, BoxSession boxSession, String str3) {
            super(BoxVoid.class, str2, boxSession);
            this.mMuteCategory = str3;
            this.mFileId = str;
        }

        public String getId() {
            return this.mFileId;
        }

        public String getMuteCategory() {
            return this.mMuteCategory;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxVoid sendForCachedResult() throws BoxException {
            return (BoxVoid) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxVoid> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }
}
