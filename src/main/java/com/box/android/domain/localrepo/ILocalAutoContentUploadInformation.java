package com.box.android.domain.localrepo;

import android.content.SharedPreferences;
import com.box.android.domain.identity.IUserContextComponent;

/* JADX INFO: loaded from: classes11.dex */
public interface ILocalAutoContentUploadInformation extends IUserContextComponent, ILocalSharedPreferences {
    public static final String IS_SYNC_ENABLED_KEY = "is_sync_enabled";
    public static final String LOCAL_SYNC_FOLDER_PATH_KEY = "local_sync_folder";
    public static final String REMOTE_SYNC_FOLDER_ID_KEY = "remote_sync_folder";
    public static final String SHOULD_NOTIFY = "should_notify";
    public static final String UPLOAD_OVER_WIFI_ONLY_KEY = "upload_over_wifi_only";

    long getLastAutoUploadSyncTime();

    long getSyncEnabledTime();

    String getUploadFolder();

    String getUploadFolderId();

    SharedPreferences getUploadSyncSharedPrefs();

    boolean isShouldNotify();

    boolean isSyncEnabled();

    @Override // com.box.android.domain.identity.IUserContextComponent
    void onHardDestroy();

    void setLastAutoUploadSyncTime();

    void setShouldNotifyWhenUploading(boolean z);

    void setShouldUploadOverWifiOnly(boolean z);

    void setSyncEnabled(boolean z);

    void setUploadFolder(String str);

    void setUploadFolderId(String str);

    boolean shouldUploadOverWifiOnly();
}
