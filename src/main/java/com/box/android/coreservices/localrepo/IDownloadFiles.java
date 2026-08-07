package com.box.android.coreservices.localrepo;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.models.BoxFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import java.io.File;

/* JADX INFO: loaded from: classes9.dex */
public interface IDownloadFiles {
    void cleanOutStaleEncryptedFiles(BoxFile boxFile, File file);

    void clearEncryptionSalts(IUserContextManager iUserContextManager);

    void deleteAllDecryptedWorkingFiles();

    void deleteAllEncryptedCachedFiles();

    void deleteAllEncryptedOfflineFiles();

    void deleteAllTempFiles();

    void deleteCachedVersionsOfFile(BoxFile boxFile);

    boolean deleteEncryptedOfflineFile(BoxFile boxFile);

    File getDecryptedWorkingDir();

    File getDecryptedWorkingFile(BoxFile boxFile);

    File getEncryptedCacheDir();

    File getEncryptedCacheFile(BoxFile boxFile);

    File getEncryptedOfflineDir();

    File getEncryptedOfflineFile(BoxFile boxFile);

    File getTempDownloadDir();

    boolean isFileAvailableOffline(BoxFile boxFile);

    boolean isFileCached(BoxFile boxFile);

    boolean isFileInDecryptedWorkingDir(BoxFile boxFile);

    void registerFileObserver(BoxFile boxFile, IMoCoBoxTransfers iMoCoBoxTransfers, IBaseModelController iBaseModelController, BoxExtendedApiFile boxExtendedApiFile);

    boolean userHasOfflineFiles();
}
