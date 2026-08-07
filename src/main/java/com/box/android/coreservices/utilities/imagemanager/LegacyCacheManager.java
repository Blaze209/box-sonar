package com.box.android.coreservices.utilities.imagemanager;

import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.localrepo.ILocalFiles;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import java.io.File;

/* JADX INFO: loaded from: classes9.dex */
public class LegacyCacheManager {
    public static File getLegacyThumbnailDir() {
        File file = new File(ApplicationProvider.application.getFilesDir(), "thumbnails");
        file.mkdirs();
        return file;
    }

    public static void deleteLegacyThumbnailDir() {
        getLegacyThumbnailDir().delete();
    }

    public static void deleteAllPreviewInfo(IUserContextManager iUserContextManager) {
        deleteAllInternalPreviews();
        deleteExternalPreviews(iUserContextManager);
    }

    public static void deleteAllInternalPreviews() {
        CommonBoxUtil.deleteFolderRecursive(CommonBoxUtil.getInternalPreviewDirectory());
    }

    public static void deleteExternalPreviews(IUserContextManager iUserContextManager) {
        ((ILocalFiles) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_FILES)).getPreviews().deleteAllEncryptedPreviews();
        clearEncryptedPreviewSalts(iUserContextManager);
        clearPreviewInfo(iUserContextManager);
    }

    public static void clearEncryptedPreviewSalts(IUserContextManager iUserContextManager) {
        iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.PREVIEW_SALTS).edit().clear().commit();
    }

    public static void clearPreviewInfo(IUserContextManager iUserContextManager) {
        iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.PREVIEW_NUM_PAGES).edit().clear().commit();
    }
}
