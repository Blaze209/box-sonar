package com.box.android.domain.localrepo;

import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.preview.PreviewContentType;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.views.DefaultAvatarController;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes11.dex */
public interface IBoxStorage {
    public static final String METADATA_FOLDER_INTENT_INFO_TAG = "intent_folder_info";

    void cacheMetadata(BoxItem boxItem, String str);

    void cacheMetadata(BoxItem boxItem, String str, PreviewContentType previewContentType);

    void clearCacheForFile(BoxFile boxFile);

    void clearPreviewCache();

    void clearPreviewCacheForFile(FileModel fileModel);

    OutputStream createPreviewOutputStream(FileModel fileModel);

    OutputStream createPreviewOutputStream(FileModel fileModel, String str, PreviewContentType previewContentType);

    @Deprecated
    OutputStream createPreviewOutputStream(BoxFile boxFile);

    @Deprecated
    OutputStream createPreviewOutputStream(BoxFile boxFile, String str, PreviewContentType previewContentType);

    File createTemporaryPendingUploadFile() throws IOException;

    OutputStream createThumbnailOutputStream(BoxFile boxFile, String str);

    DefaultAvatarController getAvatarController();

    File getCachedHubAssetsDirectory();

    InputStream getCachedPreview(BoxFile boxFile, String str);

    File getCachedPreviewFile(FileModel fileModel, String str);

    File getCachedPreviewFile(FileModel fileModel, String str, PreviewContentType previewContentType);

    @Deprecated
    File getCachedPreviewFile(BoxFile boxFile, String str);

    @Deprecated
    File getCachedPreviewFile(BoxFile boxFile, String str, PreviewContentType previewContentType);

    File getCachedPreviewOnlyFile(FileModel fileModel, String str, PreviewContentType previewContentType);

    @Deprecated
    File getCachedPreviewOnlyFile(BoxFile boxFile, String str, PreviewContentType previewContentType);

    InputStream getCachedThumbnail(BoxFile boxFile, String str);

    File getCachedThumbnailFile(BoxFile boxFile, String str);

    File getMediaProcessingDirectory();

    <T extends ItemModel> T getMetadata(ItemModel itemModel, String str);

    <T extends ItemModel> T getMetadata(ItemModel itemModel, String str, PreviewContentType previewContentType);

    @Deprecated
    <T extends BoxItem> T getMetadata(BoxItem boxItem, String str);

    @Deprecated
    <T extends BoxItem> T getMetadata(BoxItem boxItem, String str, PreviewContentType previewContentType);

    File getOfflineFile(BoxFile boxFile, String str);

    File getPendingDownloadsDirectory();

    File getPendingUploadDirectory();

    long getStorageSize();

    File getTempUploadDirectory();

    String getUserId();

    boolean isFileCached(BoxFile boxFile, String str);

    boolean isPreviewCacheEmpty();
}
