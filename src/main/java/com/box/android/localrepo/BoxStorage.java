package com.box.android.localrepo;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import androidx.collection.SieveCacheKt;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.data.persistence.legacy.LRUStorageManagedDirectory;
import com.box.android.data.persistence.legacy.PreviewStorage;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.preview.PreviewContentType;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.BoxApiPreview;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.views.DefaultAvatarController;
import com.eclipsesource.json.JsonObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import kotlin.io.FilesKt;

/* JADX INFO: loaded from: classes12.dex */
public class BoxStorage extends PreviewStorage implements IBoxStorage {
    public static final long HUBS_ASSETS_MAX_CACHE_SIZE = 104857600;
    private static int cacheMaxSize;
    private static transient LruCache<String, Drawable> mInMemoryCache;
    private static long maxMemory;
    private DefaultAvatarController mAvatarController;
    private File mCachedHubAssetsDirectory;
    transient LRUStorageManagedDirectory mHubAssetsStorage;
    private transient IKeyValueStore mKeyValueStore;
    HashMap<String, String> mLegacyPreviewPaths;
    private File mMediaProcessingDirectory;
    private File mOfflineDirectory;
    private File mPendingDownloadDirectory;
    private File mPendingUploadDirectory;
    private final BoxSession mSession;
    private File mTempUploadDirectory;
    private final transient IUserContextManager mUserContextManager;
    private String mUserId;

    static {
        long jMaxMemory = Runtime.getRuntime().maxMemory();
        maxMemory = jMaxMemory;
        cacheMaxSize = jMaxMemory > SieveCacheKt.NodeLinkMask ? 357913941 : (int) jMaxMemory;
        mInMemoryCache = new LruCache<String, Drawable>(cacheMaxSize) { // from class: com.box.android.localrepo.BoxStorage.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String str, Drawable drawable) {
                if (drawable instanceof BitmapDrawable) {
                    return ((BitmapDrawable) drawable).getBitmap().getByteCount();
                }
                return super.sizeOf(str, drawable);
            }
        };
    }

    public BoxStorage(BoxSession boxSession, IUserContextManager iUserContextManager) {
        super(boxSession, Long.MAX_VALUE, 90);
        this.mLegacyPreviewPaths = null;
        this.mSession = boxSession;
        this.mKeyValueStore = iUserContextManager.getCurrentContext().getKVStore();
        this.mUserContextManager = iUserContextManager;
    }

    @Override // com.box.android.data.persistence.legacy.PreviewStorage
    protected void init(BoxSession boxSession) {
        super.init(boxSession);
        this.mAvatarController = new DefaultAvatarController(boxSession);
        this.mUserId = boxSession.getUserId();
        File cacheDir = boxSession.getCacheDir();
        this.mOfflineDirectory = new File(cacheDir, "BoxOffline");
        this.mTempUploadDirectory = new File(cacheDir, "BoxTempUploads");
        this.mMediaProcessingDirectory = new File(cacheDir, "BoxWorking");
        this.mPendingUploadDirectory = new File(cacheDir, "BoxPendingUploads");
        this.mPendingDownloadDirectory = new File(cacheDir, "BoxPendingDownloads");
        this.mCachedHubAssetsDirectory = new File(cacheDir, "BoxHubAssets");
        if (!this.mOfflineDirectory.exists()) {
            this.mOfflineDirectory.mkdir();
        }
        if (!this.mTempUploadDirectory.exists()) {
            this.mTempUploadDirectory.mkdir();
        }
        if (!this.mPendingUploadDirectory.exists()) {
            this.mPendingUploadDirectory.mkdir();
        }
        if (!this.mPendingDownloadDirectory.exists()) {
            this.mPendingDownloadDirectory.mkdir();
        }
        if (!this.mMediaProcessingDirectory.exists()) {
            this.mMediaProcessingDirectory.mkdir();
        }
        if (!this.mCachedHubAssetsDirectory.exists()) {
            this.mCachedHubAssetsDirectory.mkdir();
        }
        this.mHubAssetsStorage = new LRUStorageManagedDirectory(this.mCachedHubAssetsDirectory, 104857600L, 90, null);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public DefaultAvatarController getAvatarController() {
        return this.mAvatarController;
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public String getUserId() {
        return this.mUserId;
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public File getOfflineFile(BoxFile boxFile, String str) {
        return new File(this.mOfflineDirectory, getCacheName(boxFile, str, "." + CommonBoxUtil.getFileExtension(boxFile.getName(), "")));
    }

    @Override // com.box.android.data.persistence.legacy.PreviewStorage, com.box.android.domain.localrepo.IBoxStorage
    public InputStream getCachedPreview(BoxFile boxFile, String str) {
        try {
            if (!getPreviewFile(boxFile, str, null).exists()) {
                return new FileInputStream(getCachedPreviewFile(boxFile, str));
            }
        } catch (Exception e) {
            BoxLogUtils.logException(e);
        }
        return super.getCachedPreview(boxFile, str);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public File getCachedPreviewOnlyFile(BoxFile boxFile, String str, PreviewContentType previewContentType) {
        return getPreviewFile(boxFile, str, previewContentType);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public File getCachedPreviewOnlyFile(FileModel fileModel, String str, PreviewContentType previewContentType) {
        if (fileModel == null) {
            return null;
        }
        return getCachedPreviewOnlyFile(FileModelMapper.INSTANCE.toBoxFile(fileModel, false), str, previewContentType);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public File getCachedPreviewFile(BoxFile boxFile, String str) {
        return getCachedPreviewFile(boxFile, str, (PreviewContentType) null);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public File getCachedPreviewFile(FileModel fileModel, String str) {
        if (fileModel == null) {
            return null;
        }
        return getCachedPreviewFile(FileModelMapper.INSTANCE.toBoxFile(fileModel, false), str);
    }

    @Override // com.box.android.data.persistence.legacy.PreviewStorage, com.box.android.domain.localrepo.IBoxStorage
    public File getCachedPreviewFile(BoxFile boxFile, String str, PreviewContentType previewContentType) {
        File previewFile = getPreviewFile(boxFile, str, previewContentType);
        if (str == null && (!previewFile.exists() || previewFile.length() <= 0)) {
            File offlineFile = getOfflineFile(boxFile, null);
            if (canUseOfflineForPreview(boxFile) && offlineFile.exists()) {
                return offlineFile;
            }
        }
        return super.getCachedPreviewFile(boxFile, str, previewContentType);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public File getCachedPreviewFile(FileModel fileModel, String str, PreviewContentType previewContentType) {
        if (fileModel == null) {
            return null;
        }
        return getCachedPreviewFile(FileModelMapper.INSTANCE.toBoxFile(fileModel, false), str, previewContentType);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public File createTemporaryPendingUploadFile() throws IOException {
        return File.createTempFile("uploadV2_", null, this.mUserContextManager.getPreviewStorage().getPendingUploadDirectory());
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public File getTempUploadDirectory() {
        return this.mTempUploadDirectory;
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public File getPendingUploadDirectory() {
        return this.mPendingUploadDirectory;
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public File getPendingDownloadsDirectory() {
        return this.mPendingDownloadDirectory;
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public File getCachedHubAssetsDirectory() {
        return this.mCachedHubAssetsDirectory;
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public File getMediaProcessingDirectory() {
        return this.mMediaProcessingDirectory;
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public boolean isPreviewCacheEmpty() {
        return this.mPreviewDirectory.isDirectory() && this.mPreviewDirectory.list().length == 0;
    }

    protected boolean canUseOfflineForPreview(BoxFile boxFile) {
        String lowerCase = CommonBoxUtil.getFileExtension(boxFile.getName(), "").toLowerCase(Locale.US);
        if (SdkUtils.isBlank(lowerCase)) {
            return false;
        }
        return SupportedFileExtensions.INSTANCE.isOriginalFilePreviewable(lowerCase);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public boolean isFileCached(BoxFile boxFile, String str) {
        File encryptedLegacyPreviewFile = getEncryptedLegacyPreviewFile(boxFile);
        File previewFile = getPreviewFile(boxFile, str, null);
        File offlineFile = getOfflineFile(boxFile, str);
        if (encryptedLegacyPreviewFile != null && encryptedLegacyPreviewFile.exists()) {
            return true;
        }
        if (previewFile == null || !previewFile.exists()) {
            return offlineFile != null && offlineFile.exists();
        }
        return true;
    }

    private File getEncryptedLegacyPreviewFile(BoxFile boxFile) {
        LocalFiles.PreviewFiles previews;
        HashMap<String, String> map = this.mLegacyPreviewPaths;
        if (map != null) {
            String str = map.get(boxFile.getSha1());
            if (str == null) {
                return null;
            }
            return new File(((LocalFiles) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_FILES)).getPreviews().getExternalPreviewDirectory(), str);
        }
        LocalFiles localFiles = (LocalFiles) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_FILES);
        if (localFiles == null || (previews = localFiles.getPreviews()) == null) {
            return null;
        }
        String[] list = previews.getExternalPreviewDirectory().list();
        this.mLegacyPreviewPaths = new HashMap<>();
        if (list != null) {
            for (String str2 : list) {
                int iLastIndexOf = str2.lastIndexOf("_") + 1;
                int iLastIndexOf2 = str2.lastIndexOf(".");
                if (iLastIndexOf > 0 && iLastIndexOf2 > iLastIndexOf) {
                    this.mLegacyPreviewPaths.put(str2.substring(iLastIndexOf, iLastIndexOf2), str2);
                }
            }
        }
        String str3 = this.mLegacyPreviewPaths.get(boxFile.getSha1());
        if (str3 == null) {
            return null;
        }
        return new File(((LocalFiles) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_FILES)).getPreviews().getExternalPreviewDirectory(), str3);
    }

    @Override // com.box.android.data.persistence.legacy.PreviewStorage, com.box.android.data.persistence.legacy.LRUStorageManagedDirectory.DeleteHandler
    public boolean shouldDelete(File file) {
        IKeyValueStore iKeyValueStore;
        if (super.shouldDelete(file) && (iKeyValueStore = this.mKeyValueStore) != null && ((LevelDBKeyValueStore) iKeyValueStore).hasDB()) {
            return !BoxModelOfflineManager.isOfflineUserSavedBlocking(getBoxFileFromFile(file), this.mUserContextManager);
        }
        return false;
    }

    private BoxFile getBoxFileFromFile(File file) {
        String strSubstring;
        String[] strArrSplit = file.getName().split("_");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", strArrSplit[0]);
        if (strArrSplit[1].contains(".")) {
            String str = strArrSplit[1];
            strSubstring = str.substring(0, str.indexOf("."));
        } else {
            strSubstring = strArrSplit[1];
        }
        jsonObject.add("sha1", strSubstring);
        jsonObject.add("type", "file");
        return (BoxFile) getMetadata(new BoxFile(jsonObject), BoxApiPreview.METADATA_FILE_INFO_TAG);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public <T extends BoxItem> T getMetadata(BoxItem boxItem, String str) {
        return (T) getMetadata(boxItem, str, (PreviewContentType) null);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public <T extends ItemModel> T getMetadata(ItemModel itemModel, String str) {
        BoxItem metadata;
        if (itemModel == null || (metadata = getMetadata(ItemModelMapper.INSTANCE.toBoxItem(itemModel, false), str)) == null) {
            return null;
        }
        return (T) ItemModelMapper.INSTANCE.toItemModel(metadata);
    }

    @Override // com.box.android.data.persistence.legacy.PreviewStorage, com.box.android.domain.localrepo.IBoxStorage
    public <T extends BoxItem> T getMetadata(BoxItem boxItem, String str, PreviewContentType previewContentType) {
        if (str.equals(BoxApiPreview.METADATA_FILE_INFO_TAG)) {
            return (T) this.mKeyValueStore.getBoxJsonObject(boxItem.getType(), boxItem.getUserId());
        }
        return (T) super.getMetadata(boxItem, str, previewContentType);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public <T extends ItemModel> T getMetadata(ItemModel itemModel, String str, PreviewContentType previewContentType) {
        BoxItem metadata;
        if (itemModel == null || (metadata = getMetadata(ItemModelMapper.INSTANCE.toBoxItem(itemModel, false), str, previewContentType)) == null) {
            return null;
        }
        return (T) ItemModelMapper.INSTANCE.toItemModel(metadata);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public void cacheMetadata(BoxItem boxItem, String str) {
        cacheMetadata(boxItem, str, null);
    }

    @Override // com.box.android.data.persistence.legacy.PreviewStorage, com.box.android.domain.localrepo.IBoxStorage
    public void cacheMetadata(BoxItem boxItem, String str, PreviewContentType previewContentType) {
        if (str.equals(BoxApiPreview.METADATA_FILE_INFO_TAG)) {
            return;
        }
        super.cacheMetadata(boxItem, str, previewContentType);
    }

    @Override // com.box.android.data.persistence.legacy.PreviewStorage, com.box.android.domain.localrepo.IBoxStorage
    public void clearCacheForFile(BoxFile boxFile) {
        super.clearCacheForFile(boxFile);
        File offlineFile = getOfflineFile(boxFile, null);
        if (offlineFile != null && offlineFile.exists()) {
            offlineFile.delete();
        }
        File previewFile = getPreviewFile(boxFile, null, null);
        if (previewFile == null || !previewFile.exists()) {
            return;
        }
        previewFile.delete();
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public void clearPreviewCacheForFile(FileModel fileModel) {
        if (fileModel == null) {
            return;
        }
        super.clearPreviewCacheForFile(FileModelMapper.INSTANCE.toBoxFile(fileModel, false));
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public long getStorageSize() {
        return CommonBoxUtil.getDirSize(this.mOfflineDirectory) + CommonBoxUtil.getDirSize(this.mMetadataDirectory) + CommonBoxUtil.getDirSize(this.mPreviewDirectory) + CommonBoxUtil.getDirSize(this.mThumbnailDirectory) + CommonBoxUtil.getDirSize(this.mCachedHubAssetsDirectory);
    }

    @Override // com.box.android.domain.localrepo.IBoxStorage
    public void clearPreviewCache() {
        FilesKt.deleteRecursively(this.mOfflineDirectory);
        FilesKt.deleteRecursively(this.mMetadataDirectory);
        FilesKt.deleteRecursively(this.mPreviewDirectory);
        FilesKt.deleteRecursively(this.mThumbnailDirectory);
        FilesKt.deleteRecursively(this.mCachedHubAssetsDirectory);
        init(this.mSession);
    }
}
