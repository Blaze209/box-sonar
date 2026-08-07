package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsPreview;
import java.io.OutputStream;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiPreview extends BoxApiFile {
    public static final String FIELD_AUTHENTICATED_DOWNLOAD_URL = "authenticated_download_url";
    protected static final String LOG_CONTENT_ACCESS_PARAM = "?log_content_access=true";
    public static final String METADATA_DOCUMENT_TAG = "doc";
    public static final String METADATA_FILE_INFO_TAG = "file_info";
    public static final String METADATA_FOLDER_INFO_TAG = "folder_info";
    protected static final String PREVIEW_AUTHENTICATED_DOWNLOAD_PARAM = "?preview=true";

    public enum Extensions {
        PNG(BoxRepresentation.TYPE_PNG),
        MP4(BoxRepresentation.TYPE_MP4),
        MP3(BoxRepresentation.TYPE_MP3),
        PDF("pdf");

        String mExt;

        Extensions(String str) {
            this.mExt = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mExt;
        }
    }

    public BoxApiPreview(BoxSession boxSession) {
        super(boxSession);
    }

    public String getPreviewUrl(String str, Extensions extensions) {
        return String.format(Locale.ENGLISH, "%s/preview.%s", getFileInfoUrl(str), extensions.toString());
    }

    public String getPreviewUrlNoAccess(String str, Extensions extensions) {
        return getPreviewUrl(str, extensions) + LOG_CONTENT_ACCESS_PARAM;
    }

    public String getContentUrl(String str) {
        return getFileDownloadUrl(str);
    }

    public String getContentUrlNoAccess(String str) {
        return getContentUrl(str) + LOG_CONTENT_ACCESS_PARAM;
    }

    public String getAuthenticatedDownloadUrl(BoxFile boxFile) {
        if (boxFile.getPropertyValue(FIELD_AUTHENTICATED_DOWNLOAD_URL) == null) {
            return null;
        }
        return boxFile.getPropertyValue(FIELD_AUTHENTICATED_DOWNLOAD_URL).asString() + PREVIEW_AUTHENTICATED_DOWNLOAD_PARAM;
    }

    public BoxRequestsPreview.DownloadPreview getDownloadPreviewRequest(OutputStream outputStream, String str, String str2, Extensions extensions) {
        return new BoxRequestsPreview.DownloadPreview(str, outputStream, getPreviewUrl(str, extensions), this.mSession, extensions).setFileVersion(str2);
    }
}
