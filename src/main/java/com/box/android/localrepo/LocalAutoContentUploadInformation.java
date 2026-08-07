package com.box.android.localrepo;

import android.content.Context;
import android.content.SharedPreferences;
import com.box.android.domain.localrepo.ILocalAutoContentUploadInformation;
import com.box.android.domain.localrepo.ILocalSharedPreferences;

/* JADX INFO: loaded from: classes12.dex */
public class LocalAutoContentUploadInformation extends LocalSharedPreferences implements ILocalAutoContentUploadInformation {
    private static final String LAST_AUTO_UPLOAD_SYNC_TIME = "last_auto_upload_sync_time";
    private static final String SYNC_ENABLED_TIME = "sync_enabled_time";

    @Override // com.box.android.localrepo.LocalSharedPreferences, com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onHardDestroy() {
    }

    public LocalAutoContentUploadInformation(Context context) {
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public String getUploadFolder() {
        return getUploadSyncSharedPrefs().getString(ILocalAutoContentUploadInformation.LOCAL_SYNC_FOLDER_PATH_KEY, "");
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public void setUploadFolder(String str) {
        getUploadSyncSharedPrefs().edit().putString(ILocalAutoContentUploadInformation.LOCAL_SYNC_FOLDER_PATH_KEY, str).apply();
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public SharedPreferences getUploadSyncSharedPrefs() {
        return getSharedPreferences(ILocalSharedPreferences.PreferenceName.UPLOAD_SYNC_FOLDER);
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public String getUploadFolderId() {
        return getUploadSyncSharedPrefs().getString(ILocalAutoContentUploadInformation.REMOTE_SYNC_FOLDER_ID_KEY, null);
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public void setUploadFolderId(String str) {
        getUploadSyncSharedPrefs().edit().putString(ILocalAutoContentUploadInformation.REMOTE_SYNC_FOLDER_ID_KEY, str).apply();
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public boolean shouldUploadOverWifiOnly() {
        return getUploadSyncSharedPrefs().getBoolean(ILocalAutoContentUploadInformation.UPLOAD_OVER_WIFI_ONLY_KEY, true);
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public void setShouldUploadOverWifiOnly(boolean z) {
        getUploadSyncSharedPrefs().edit().putBoolean(ILocalAutoContentUploadInformation.UPLOAD_OVER_WIFI_ONLY_KEY, z).apply();
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public void setShouldNotifyWhenUploading(boolean z) {
        getUploadSyncSharedPrefs().edit().putBoolean(ILocalAutoContentUploadInformation.SHOULD_NOTIFY, z).apply();
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public boolean isShouldNotify() {
        return getUploadSyncSharedPrefs().getBoolean(ILocalAutoContentUploadInformation.SHOULD_NOTIFY, false);
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public boolean isSyncEnabled() {
        return getUploadSyncSharedPrefs().getBoolean(ILocalAutoContentUploadInformation.IS_SYNC_ENABLED_KEY, false);
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public void setSyncEnabled(boolean z) {
        getUploadSyncSharedPrefs().edit().putBoolean(ILocalAutoContentUploadInformation.IS_SYNC_ENABLED_KEY, z).putLong(SYNC_ENABLED_TIME, System.currentTimeMillis()).apply();
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public long getSyncEnabledTime() {
        return getUploadSyncSharedPrefs().getLong(SYNC_ENABLED_TIME, System.currentTimeMillis());
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public void setLastAutoUploadSyncTime() {
        getUploadSyncSharedPrefs().edit().putLong(LAST_AUTO_UPLOAD_SYNC_TIME, System.currentTimeMillis()).apply();
    }

    @Override // com.box.android.domain.localrepo.ILocalAutoContentUploadInformation
    public long getLastAutoUploadSyncTime() {
        return getUploadSyncSharedPrefs().getLong(LAST_AUTO_UPLOAD_SYNC_TIME, 0L);
    }
}
