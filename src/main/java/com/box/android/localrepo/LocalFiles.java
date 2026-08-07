package com.box.android.localrepo;

import android.os.Environment;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.localrepo.IDownloadFiles;
import com.box.android.coreservices.localrepo.ILocalFiles;
import com.box.android.coreservices.localrepo.IPreviewFiles;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.models.BoxStaticUploadModel;
import com.box.android.coreservices.utilities.imagemanager.LegacyCacheManager;
import com.box.android.domain.identity.Crypto;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.observers.BoxFileObserver;
import com.box.android.usercontext.UserContextComponent;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes12.dex */
public class LocalFiles extends UserContextComponent implements ILocalFiles {
    private DownloadFiles mDownloadFiles;
    PreviewFiles mPreviewFiles;

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onCreate(String str) throws IUserContextComponent.UserContextComponentCreationException {
        this.mDownloadFiles = new DownloadFiles(str);
        this.mPreviewFiles = new PreviewFiles(str);
        super.onCreate(str);
    }

    @Override // com.box.android.coreservices.localrepo.ILocalFiles
    public File getUserExternalStorageDirectory(String str) {
        String string = new StringBuffer("/").append(str).append("/").toString();
        File externalFilesDir = BoxBaseApplication.getInstance().getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return new File(new StringBuffer(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Android/data/").append(BoxBaseApplication.getInstance().getPackageName()).append(string).toString());
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        File file = new File(new StringBuffer(absolutePath.substring(0, absolutePath.indexOf("/files"))).append(string).toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onSoftDestroy() {
        clearUserData();
        super.onSoftDestroy();
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onHardDestroy() {
        deleteUserSpecificDirectory();
        deleteUserAvatar();
        clearUserData();
        super.onHardDestroy();
    }

    void deleteUserSpecificDirectory() {
        File userExternalStorageDirectory = getUserExternalStorageDirectory(getLastKnowContextId());
        try {
            FileUtils.deleteDirectory(userExternalStorageDirectory);
        } catch (IOException | IllegalArgumentException unused) {
            BoxLogUtils.w("Failed to remove content of " + userExternalStorageDirectory);
            CommonBoxUtil.deleteFolderRecursive(userExternalStorageDirectory);
        }
    }

    void deleteUserAvatar() {
        String contextId = getLastKnowContextId();
        if (contextId == null || contextId.isEmpty()) {
            return;
        }
        File avatarFile = CommonBoxUtil.getAvatarFile(contextId);
        if (avatarFile.delete()) {
            return;
        }
        BoxLogUtils.e("Failed to remove user avatar: " + avatarFile);
    }

    void clearUserData() {
        BoxStaticUploadModel.clearUploadFolder();
        CommonBoxUtil.cancelAllNotifications();
        PreviewFiles previewFiles = this.mPreviewFiles;
        if (previewFiles != null) {
            previewFiles.deleteAllInternalPreviews();
        }
        LegacyCacheManager.deleteLegacyThumbnailDir();
    }

    @Override // com.box.android.coreservices.localrepo.ILocalFiles
    public DownloadFiles getDownloads() {
        return this.mDownloadFiles;
    }

    @Override // com.box.android.coreservices.localrepo.ILocalFiles
    public PreviewFiles getPreviews() {
        return this.mPreviewFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String convertDateToString(Date date) {
        if (date == null) {
            return "";
        }
        return Long.toString(date.getTime());
    }

    @Override // com.box.android.coreservices.localrepo.ILocalFiles
    public void recoverMemory() {
        this.mPreviewFiles.clearInMemoryCache();
    }

    public class PreviewFiles implements IPreviewFiles {
        private final File mUserExternalStorageDirectory;

        public PreviewFiles(String str) {
            this.mUserExternalStorageDirectory = LocalFiles.this.getUserExternalStorageDirectory(str);
        }

        @Override // com.box.android.coreservices.localrepo.IPreviewFiles
        public void deleteAllInternalPreviews() {
            LegacyCacheManager.deleteAllInternalPreviews();
        }

        @Override // com.box.android.coreservices.localrepo.IPreviewFiles
        public void clearInMemoryCache() {
            LegacyCacheManager.deleteAllInternalPreviews();
        }

        @Override // com.box.android.coreservices.localrepo.IPreviewFiles
        public File getExternalPreviewDirectory() {
            File file = new File(new StringBuffer(this.mUserExternalStorageDirectory.getAbsolutePath()).append("/cache/previews/").toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        @Override // com.box.android.coreservices.localrepo.IPreviewFiles
        public void deleteAllEncryptedPreviews() {
            CommonBoxUtil.deleteFolderRecursive(getExternalPreviewDirectory());
        }
    }

    public class DownloadFiles implements IDownloadFiles {
        private final File mUserExternalStorageDirectory;

        public DownloadFiles(String str) {
            this.mUserExternalStorageDirectory = LocalFiles.this.getUserExternalStorageDirectory(str);
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public boolean userHasOfflineFiles() {
            return this.mUserExternalStorageDirectory.exists() && this.mUserExternalStorageDirectory.getTotalSpace() > 0;
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public boolean isFileAvailableOffline(BoxFile boxFile) {
            File encryptedOfflineFile = getEncryptedOfflineFile(boxFile);
            return encryptedOfflineFile.exists() && encryptedOfflineFile.isFile() && encryptedOfflineFile.canRead();
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public boolean isFileCached(BoxFile boxFile) {
            File encryptedCacheFile = getEncryptedCacheFile(boxFile);
            return encryptedCacheFile.exists() && encryptedCacheFile.isFile() && encryptedCacheFile.canRead();
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public void deleteAllEncryptedCachedFiles() {
            CommonBoxUtil.deleteFolderRecursive(getEncryptedCacheDir());
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public void deleteAllDecryptedWorkingFiles() {
            CommonBoxUtil.deleteFolderRecursive(getDecryptedWorkingDir());
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public File getEncryptedCacheFile(BoxFile boxFile) {
            return new File(getEncryptedCacheDir(), boxFile.getUserId() + "_" + boxFile.getSha1());
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public File getDecryptedWorkingDir() {
            File file = new File(new StringBuffer(this.mUserExternalStorageDirectory.getAbsolutePath()).append("/cache/working/").toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public boolean isFileInDecryptedWorkingDir(BoxFile boxFile) {
            String strSha1;
            File decryptedWorkingFile = getDecryptedWorkingFile(boxFile);
            if (!decryptedWorkingFile.isFile() || decryptedWorkingFile.length() <= 0) {
                return false;
            }
            try {
                return boxFile.getSha1() == null || boxFile.getSha1().trim().length() == 0 || ((strSha1 = Crypto.sha1(new FileInputStream(decryptedWorkingFile))) != null && boxFile.getSha1().equals(strSha1));
            } catch (FileNotFoundException e) {
                BoxLogUtils.logException(e);
                return false;
            } catch (IOException e2) {
                BoxLogUtils.logException(e2);
                return false;
            }
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public File getDecryptedWorkingFile(BoxFile boxFile) {
            String name = boxFile.getName();
            if (!CommonBoxUtil.isFilenameValidForSD(name)) {
                name = CommonBoxUtil.escapeFileNameForSD(name);
            }
            if (boxFile.getSha1() == null) {
                File file = new File(getDecryptedWorkingDir().getAbsolutePath() + "/" + boxFile.getUserId() + "_" + LocalFiles.convertDateToString(boxFile.getModifiedAt()));
                file.mkdirs();
                return new File(file, name);
            }
            File file2 = new File(getDecryptedWorkingDir().getAbsolutePath() + "/" + boxFile.getUserId() + "_" + boxFile.getSha1());
            if (!file2.exists()) {
                File file3 = new File(getDecryptedWorkingDir().getAbsolutePath() + "/" + boxFile.getUserId() + "_" + LocalFiles.convertDateToString(boxFile.getModifiedAt()));
                if (file3.exists()) {
                    file3.renameTo(file2);
                }
            }
            file2.mkdirs();
            return new File(file2, name);
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public void registerFileObserver(final BoxFile boxFile, IMoCoBoxTransfers iMoCoBoxTransfers, IBaseModelController iBaseModelController, BoxExtendedApiFile boxExtendedApiFile) {
            for (File file : getDecryptedWorkingDir().listFiles(new FilenameFilter() { // from class: com.box.android.localrepo.LocalFiles.DownloadFiles.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return file2.isDirectory() && str.startsWith(new StringBuilder().append(boxFile.getUserId()).append("_").toString());
                }
            })) {
                if (!file.getAbsolutePath().equals(getDecryptedWorkingFile(boxFile).getParentFile().getAbsolutePath())) {
                    BoxFileObserver.removeObserver(file);
                    CommonBoxUtil.deleteFilesFolders(file);
                }
            }
            Iterator<Integer> it = BoxFileObserver.FILE_OPS.keySet().iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue |= it.next().intValue();
            }
            BoxFileObserver.registerObserver(getDecryptedWorkingFile(boxFile).getParentFile(), boxFile.getUserId(), boxFile.getName(), iIntValue, iMoCoBoxTransfers, iBaseModelController, boxExtendedApiFile);
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public File getEncryptedOfflineDir() {
            File file = new File(new StringBuffer(this.mUserExternalStorageDirectory.getAbsolutePath()).append("/cache/dl_offline/").toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public File getEncryptedCacheDir() {
            File file = new File(new StringBuffer(this.mUserExternalStorageDirectory.getAbsolutePath()).append("/cache/dl_cache/").toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public File getEncryptedOfflineFile(BoxFile boxFile) {
            return new File(getEncryptedOfflineDir(), String.valueOf(boxFile.getUserId()) + "_" + boxFile.getSha1());
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public boolean deleteEncryptedOfflineFile(BoxFile boxFile) {
            if (boxFile == null || getEncryptedOfflineFile(boxFile) == null) {
                return false;
            }
            return getEncryptedOfflineFile(boxFile).delete();
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public File getTempDownloadDir() {
            File file = new File(BoxBaseApplication.getInstance().getCacheDir(), LocalFiles.this.getLastKnowContextId());
            if (!file.exists()) {
                file.mkdir();
            }
            return file;
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public void deleteAllEncryptedOfflineFiles() {
            CommonBoxUtil.deleteFolderRecursive(getEncryptedOfflineDir());
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public void deleteAllTempFiles() {
            CommonBoxUtil.deleteFolderRecursive(getTempDownloadDir());
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public void cleanOutStaleEncryptedFiles(final BoxFile boxFile, File file) {
            if (file == null || !file.getName().startsWith(boxFile.getUserId() + "_")) {
                return;
            }
            File[] fileArr = {getEncryptedCacheDir(), getEncryptedOfflineDir()};
            for (int i = 0; i < 2; i++) {
                for (File file2 : fileArr[i].listFiles(new FilenameFilter() { // from class: com.box.android.localrepo.LocalFiles.DownloadFiles.2
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file3, String str) {
                        return str.startsWith(boxFile.getUserId() + "_");
                    }
                })) {
                    if (!file2.getName().equals(file.getName())) {
                        file2.delete();
                    }
                }
            }
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public void deleteCachedVersionsOfFile(BoxFile boxFile) {
            if (boxFile == null) {
                return;
            }
            File[] fileArr = {getEncryptedCacheDir(), getEncryptedOfflineDir(), getDecryptedWorkingDir()};
            for (int i = 0; i < 3; i++) {
                CommonBoxUtil.deleteFilesFromDirectoryWithPrefix(fileArr[i], boxFile.getUserId() + "_");
            }
        }

        @Override // com.box.android.coreservices.localrepo.IDownloadFiles
        public void clearEncryptionSalts(IUserContextManager iUserContextManager) {
            iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.DOWNLOAD_SALTS).edit().clear().commit();
        }
    }
}
