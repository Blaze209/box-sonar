package com.box.android.data.persistence.legacy;

import com.box.android.coreservices.utilities.PreviewStorageExtension;
import com.box.android.data.service.impl.thumbnail.ThumbnailService;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.preview.PreviewContentType;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes11.dex */
public class PreviewStorage implements Serializable, LRUStorageManagedDirectory.DeleteHandler {
    private static final String LOG_TAG = "PreviewStorage";
    public static final int MAX_CACHE_AGE = 90;
    public static final long MAX_CACHE_SIZE = 524288000;
    private static final long METADATA_CACHE_SIZE_MULTIPLIER = 0;
    private static final String METADATA_EXTENSION = ".metadata";
    private static final long PREVIEW_CACHE_SIZE_MULTIPLIER = 0;
    private static final String PREVIEW_EXTENSION = ".preview";
    private static final int PREVIEW_MIN_WIDTH = 1024;
    protected static final String TEMP_EXTENSION = ".temp";
    private static final long THUMBNAIL_CACHE_SIZE_MULTIPLIER = 0;
    private static final int THUMBNAIL_MIN_WIDTH = 256;
    static final long serialVersionUID = 5157064006L;
    private final int mExpirationDays;
    private final long mMaxCacheSize;
    protected File mMetadataDirectory;
    transient LRUStorageManagedDirectory mMetadataStorage;
    public File mPreviewDirectory;
    transient LRUStorageManagedDirectory mPreviewStorage;
    public ConcurrentHashMap<String, Long> mRecentlyWrittenFiles = new ConcurrentHashMap<>();
    protected File mThumbnailDirectory;
    transient LRUStorageManagedDirectory mThumbnailStorage;
    protected static final AtomicLong TEMP_COUNTER = new AtomicLong();
    private static final String TAG = PreviewStorage.class.getName();

    enum StorageFileType {
        FILE_TYPE_THUMBNAIL,
        FILE_TYPE_PREVIEW,
        FILE_TYPE_METADATA
    }

    public PreviewStorage(BoxSession session, long maxCacheSize, int expirationDays) {
        this.mMaxCacheSize = maxCacheSize;
        this.mExpirationDays = expirationDays;
        init(session);
    }

    protected void init(BoxSession session) {
        File cacheDir = session.getCacheDir();
        if (!cacheDir.exists()) {
            cacheDir.mkdir();
        }
        File file = new File(cacheDir, "BoxPreviews");
        this.mPreviewDirectory = file;
        if (!file.exists()) {
            this.mPreviewDirectory.mkdir();
        }
        File file2 = new File(cacheDir, "BoxThumbnails");
        this.mThumbnailDirectory = file2;
        if (!file2.exists()) {
            this.mThumbnailDirectory.mkdir();
        }
        File file3 = new File(cacheDir, "BoxMetadata");
        this.mMetadataDirectory = file3;
        if (!file3.exists()) {
            this.mMetadataDirectory.mkdir();
        }
        createLRUStorageManagedDirectories();
    }

    private void createLRUStorageManagedDirectories() {
        this.mPreviewStorage = new LRUStorageManagedDirectory(this.mPreviewDirectory, 0L, this.mExpirationDays, this);
        this.mThumbnailStorage = new LRUStorageManagedDirectory(this.mThumbnailDirectory, 0L, this.mExpirationDays, this);
        this.mMetadataStorage = new LRUStorageManagedDirectory(this.mMetadataDirectory, 0L, this.mExpirationDays, this);
    }

    @Override // com.box.android.data.persistence.legacy.LRUStorageManagedDirectory.DeleteHandler
    public boolean shouldDelete(File file) {
        return file.getParent().equals(this.mThumbnailDirectory.getAbsolutePath()) || this.mRecentlyWrittenFiles.get(file.getAbsolutePath()) == null;
    }

    @Override // com.box.android.data.persistence.legacy.LRUStorageManagedDirectory.DeleteHandler
    public void onFileDeleted(File file, boolean deleteSuccessful) {
        if (deleteSuccessful) {
            this.mRecentlyWrittenFiles.remove(file.getAbsolutePath());
        }
    }

    public InputStream getCachedPreview(final BoxFile boxFile, final String tag) {
        try {
            File previewFile = getPreviewFile(boxFile, tag, null);
            previewFile.setLastModified(System.currentTimeMillis());
            return new FileInputStream(previewFile);
        } catch (Exception unused) {
            return null;
        }
    }

    public File getCachedPreviewFile(final BoxFile boxFile, String tag, PreviewContentType previewContentType) {
        return getPreviewFile(boxFile, tag, previewContentType);
    }

    @Deprecated
    public InputStream getCachedThumbnail(final BoxFile boxFile) {
        return getCachedThumbnail(boxFile, null);
    }

    public boolean isThumbnailFilePresent(BoxFile boxFile) {
        return isThumbnailFilePresent(boxFile, null) || isThumbnailFilePresent(boxFile, String.valueOf(1024)) || isThumbnailFilePresent(boxFile, String.valueOf(256));
    }

    public boolean isThumbnailFilePresent(BoxFile boxFile, String tag) {
        File thumbnailFile = getThumbnailFile(boxFile, tag);
        return thumbnailFile != null && thumbnailFile.exists() && thumbnailFile.length() > 0;
    }

    public InputStream getCachedThumbnail(final BoxFile boxFile, final String tag) {
        try {
            return new FileInputStream(getCachedThumbnailFile(boxFile, tag));
        } catch (Exception unused) {
            return null;
        }
    }

    public File getCachedThumbnailFile(final BoxFile boxFile, final String tag) {
        File thumbnailFile = getThumbnailFile(boxFile, tag);
        thumbnailFile.setLastModified(System.currentTimeMillis());
        return thumbnailFile;
    }

    public File getPreviewFile(final BoxFile boxFile, String tag, PreviewContentType previewContentType) {
        return getCacheFile(this.mPreviewDirectory, boxFile, tag, PREVIEW_EXTENSION, previewContentType);
    }

    protected File createPreviewFile(final BoxFile boxFile, String tag, PreviewContentType previewContentType) {
        return createCacheFile(this.mPreviewDirectory, boxFile, tag, PREVIEW_EXTENSION, previewContentType);
    }

    protected File getThumbnailFile(final BoxFile boxFile, String tag) {
        return new File(this.mThumbnailDirectory, getCacheName(boxFile, tag, ThumbnailService.THUMBNAIL_FILE_EXTENSION));
    }

    public File createMetadataFile(final BoxFile boxFile, final String tag, PreviewContentType previewContentType) {
        return createCacheFile(this.mMetadataDirectory, boxFile, tag, METADATA_EXTENSION, previewContentType);
    }

    public File getMetadataFile(final BoxFile boxFile, final String tag, PreviewContentType previewContentType) {
        return getCacheFile(this.mMetadataDirectory, boxFile, tag, METADATA_EXTENSION, previewContentType);
    }

    protected File getMetadataFile(final BoxFolder boxFolder, final String tag) {
        return new File(this.mMetadataDirectory, getCacheName(boxFolder, tag, METADATA_EXTENSION));
    }

    protected File createCacheFile(File directory, BoxFile boxFile, String tag, String ext, PreviewContentType previewContentType) {
        String cacheName;
        if (previewContentType != null) {
            cacheName = PreviewStorageExtension.INSTANCE.createCacheName(FileModelMapper.INSTANCE.toFileModel(boxFile, false), previewContentType, tag, ext);
        } else {
            cacheName = getCacheName(boxFile, tag, ext);
        }
        return createFile(directory, cacheName);
    }

    protected File getCacheFile(File directory, BoxFile boxFile, String tag, String ext, PreviewContentType previewContentType) {
        File file;
        String str;
        String str2;
        PreviewContentType previewContentType2;
        String cacheName;
        try {
            file = directory;
            str = tag;
            str2 = ext;
            previewContentType2 = previewContentType;
            try {
                cacheName = PreviewStorageExtension.INSTANCE.getCacheName(FileModelMapper.INSTANCE.toFileModel(boxFile, false), previewContentType2, str, str2, file);
            } catch (Exception e) {
                e = e;
                BoxLogUtils.e(LOG_TAG, "Error finding or creating a cache name for PreviewContentType: " + previewContentType2, e);
                cacheName = null;
            }
        } catch (Exception e2) {
            e = e2;
            file = directory;
            str = tag;
            str2 = ext;
            previewContentType2 = previewContentType;
        }
        if (cacheName == null) {
            cacheName = getCacheName(boxFile, str, str2);
        }
        return createFile(file, cacheName);
    }

    public String getCacheName(BoxItem boxItem, String tag, String ext) {
        String string;
        if (boxItem == null || SdkUtils.isBlank(boxItem.getUserId())) {
            throw new IllegalArgumentException("BoxItem argument must not be null and must contain an id");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.ENGLISH, "%s_", boxItem.getUserId()));
        if (boxItem instanceof BoxFile) {
            BoxFile boxFile = (BoxFile) boxItem;
            if (SdkUtils.isBlank(boxFile.getSha1())) {
                throw new IllegalArgumentException("BoxFile must contain a non-null and non-blank sha1");
            }
            sb.append(boxFile.getSha1());
        } else if (boxItem instanceof BoxFolder) {
            if (boxItem.getModifiedAt() == null) {
                string = "0";
            } else {
                string = boxItem.getModifiedAt().toString();
            }
            sb.append(string);
        } else {
            throw new IllegalArgumentException("BoxItem must be of the type BoxFile or BoxFolder");
        }
        if (!SdkUtils.isBlank(tag)) {
            sb.append(String.format(Locale.ENGLISH, "_%s", tag));
        }
        if (!SdkUtils.isBlank(ext)) {
            sb.append(ext);
        }
        return sb.toString();
    }

    @Deprecated
    public OutputStream createThumbnailOutputStream(final BoxFile boxFile) {
        return createThumbnailOutputStream(boxFile, null);
    }

    public OutputStream createThumbnailOutputStream(final BoxFile boxFile, final String tag) {
        try {
            String str = TEMP_EXTENSION + TEMP_COUNTER.addAndGet(1L);
            File file = new File(getThumbnailFile(boxFile, tag).getAbsolutePath() + str);
            this.mRecentlyWrittenFiles.put(file.getAbsolutePath(), Long.valueOf(System.currentTimeMillis()));
            return new NotifyingFileOutputStream(file, str, boxFile, StorageFileType.FILE_TYPE_THUMBNAIL);
        } catch (Exception unused) {
            return null;
        }
    }

    public OutputStream createPreviewOutputStream(final BoxFile boxFile) {
        return createPreviewOutputStream(boxFile, (String) null, (PreviewContentType) null);
    }

    public OutputStream createPreviewOutputStream(final FileModel fileModel) {
        return createPreviewOutputStream(FileModelMapper.INSTANCE.toBoxFile(fileModel, false));
    }

    public OutputStream createPreviewOutputStream(final BoxFile boxFile, final String tag, PreviewContentType previewContentType) {
        try {
            String str = TEMP_EXTENSION + TEMP_COUNTER.addAndGet(1L);
            File file = new File(createPreviewFile(boxFile, tag, previewContentType).getAbsolutePath() + str);
            this.mRecentlyWrittenFiles.put(file.getAbsolutePath(), Long.valueOf(System.currentTimeMillis()));
            return new NotifyingFileOutputStream(file, str, null, StorageFileType.FILE_TYPE_PREVIEW);
        } catch (Exception unused) {
            return null;
        }
    }

    public OutputStream createPreviewOutputStream(final FileModel fileModel, final String tag, PreviewContentType previewContentType) {
        return createPreviewOutputStream(FileModelMapper.INSTANCE.toBoxFile(fileModel, false), tag, previewContentType);
    }

    public void cacheMetadata(BoxItem boxItem, String tag, PreviewContentType previewContentType) {
        File metadataFile;
        if (boxItem instanceof BoxFile) {
            metadataFile = createMetadataFile((BoxFile) boxItem, tag, previewContentType);
        } else if (!(boxItem instanceof BoxFolder)) {
            return;
        } else {
            metadataFile = getMetadataFile((BoxFolder) boxItem, tag);
        }
        this.mRecentlyWrittenFiles.put(metadataFile.getAbsolutePath(), Long.valueOf(System.currentTimeMillis()));
        writeFileOnDisk(boxItem, metadataFile);
    }

    public void writeFileOnDisk(BoxItem boxItem, File file) {
        File file2;
        try {
            file2 = file;
            try {
                NotifyingFileOutputStream notifyingFileOutputStream = new NotifyingFileOutputStream(file2, null, null, StorageFileType.FILE_TYPE_METADATA);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(notifyingFileOutputStream);
                objectOutputStream.writeObject(boxItem);
                objectOutputStream.close();
                notifyingFileOutputStream.close();
            } catch (IOException e) {
                e = e;
                file2.delete();
                BoxLogUtils.e(LOG_TAG, "cacheMetadata", e);
            }
        } catch (IOException e2) {
            e = e2;
            file2 = file;
        }
    }

    public <T extends BoxItem> T getMetadata(BoxItem boxItem, String str, PreviewContentType previewContentType) {
        File metadataFile;
        if (boxItem instanceof BoxFile) {
            metadataFile = getMetadataFile((BoxFile) boxItem, str, previewContentType);
        } else {
            if (!(boxItem instanceof BoxFolder)) {
                return null;
            }
            metadataFile = getMetadataFile((BoxFolder) boxItem, str);
        }
        metadataFile.setLastModified(System.currentTimeMillis());
        return (T) readBoxItem(metadataFile);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0032: MOVE (r3 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:26:0x0032 */
    public <T extends BoxItem> T readBoxItem(File file) {
        Throwable e;
        T t;
        Throwable th;
        T t2 = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                        try {
                            T t3 = (T) objectInputStream.readObject();
                            try {
                                objectInputStream.close();
                                fileInputStream.close();
                                return t3;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            try {
                                objectInputStream.close();
                            } catch (Throwable th5) {
                                th4.addSuppressed(th5);
                            }
                            throw th4;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (FileNotFoundException unused) {
                    t2 = t;
                    BoxLogUtils.v(TAG, "Metadata does not exist " + file.getAbsolutePath());
                    return t2;
                }
            } catch (IOException | ClassNotFoundException e2) {
                e = e2;
                BoxLogUtils.e(LOG_TAG, "getMetadata", e);
                return null;
            }
        } catch (FileNotFoundException unused2) {
            BoxLogUtils.v(TAG, "Metadata does not exist " + file.getAbsolutePath());
            return t2;
        } catch (IOException | ClassNotFoundException e3) {
            e = e3;
            BoxLogUtils.e(LOG_TAG, "getMetadata", e);
            return null;
        }
    }

    public void clearCacheForFile(final BoxFile fileInfo) {
        FilenameFilter filenameFilter = new FilenameFilter() { // from class: com.box.android.data.persistence.legacy.PreviewStorage.1
            @Override // java.io.FilenameFilter
            public boolean accept(File dir, String filename) {
                return filename.startsWith(fileInfo.getUserId());
            }
        };
        for (File file : this.mPreviewDirectory.listFiles(filenameFilter)) {
            file.delete();
        }
        for (File file2 : this.mThumbnailDirectory.listFiles(filenameFilter)) {
            file2.delete();
        }
        for (File file3 : this.mMetadataDirectory.listFiles(filenameFilter)) {
            file3.delete();
        }
    }

    protected void clearPreviewCacheForFile(BoxFile boxFile) {
        if (this.mPreviewDirectory.listFiles() != null) {
            for (File file : this.mPreviewDirectory.listFiles()) {
                if (file.getName().startsWith(boxFile.getUserId())) {
                    file.delete();
                }
            }
        }
        if (this.mMetadataDirectory.listFiles() != null) {
            for (File file2 : this.mMetadataDirectory.listFiles()) {
                if (file2.getName().startsWith(boxFile.getUserId())) {
                    file2.delete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeRoomIfNecessary(final long spaceChanged, final File fileAdded) {
        this.mRecentlyWrittenFiles.putIfAbsent(fileAdded.getAbsolutePath(), Long.valueOf(System.currentTimeMillis()));
        if (fileAdded.getParentFile().getAbsolutePath().equals(this.mPreviewDirectory.getAbsolutePath())) {
            this.mPreviewStorage.makeRoomIfNecessary(spaceChanged);
        } else if (fileAdded.getParentFile().getAbsolutePath().equals(this.mThumbnailDirectory.getAbsolutePath())) {
            this.mThumbnailStorage.makeRoomIfNecessary(spaceChanged);
        }
    }

    private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        in.defaultReadObject();
        createLRUStorageManagedDirectories();
    }

    File createFile(File directory, String cacheName) {
        return new File(directory, cacheName);
    }

    public class NotifyingFileOutputStream extends FileOutputStream {
        final File mFile;
        private long mStartSize;
        private final String mTempExtension;

        public NotifyingFileOutputStream(final File file, String tempExtension, BoxFile boxFile, StorageFileType fileType) throws FileNotFoundException {
            super(file);
            this.mStartSize = 0L;
            this.mFile = file;
            if (file.exists()) {
                this.mStartSize = file.length();
            }
            this.mTempExtension = tempExtension;
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            File file = this.mFile;
            if (file != null) {
                BoxLogUtils.v("IBoxStorage close", String.format("File length = %d. Path = %s", Long.valueOf(file.length()), this.mFile.getAbsolutePath()));
                PreviewStorage.this.makeRoomIfNecessary(this.mFile.length() - this.mStartSize, this.mFile);
            }
            super.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            File file = this.mFile;
            if (file != null) {
                BoxLogUtils.v("IBoxStorage flush", String.format("File length = %d. Path = %s", Long.valueOf(file.length()), this.mFile.getAbsolutePath()));
                String absolutePath = this.mFile.getAbsolutePath();
                String str = this.mTempExtension;
                if (str != null && absolutePath.endsWith(str)) {
                    this.mFile.renameTo(new File(absolutePath.substring(0, absolutePath.length() - this.mTempExtension.length())));
                }
            }
            super.flush();
        }

        public boolean delete() {
            return this.mFile.delete();
        }
    }
}
