package com.box.android.utilities;

import android.app.Application;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.provider.Settings;
import com.box.android.domain.identity.IDeviceIdStorage;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.localrepo.LocalSharedPreferences;
import java.io.IOException;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class DeviceIdStorage implements IDeviceIdStorage {
    public static final String ANDROID_ID_SHARED_PREFS_KEY = "android_id";
    public static final String INSTALLATION_ID_PATH = ".boxinstall/install";
    public static final String INSTALLATION_ID_SHARED_PREFS_KEY = "installation_id";
    private final ContentResolver mContentResolver;
    private final SharedPreferences mSharedPrefs = new LocalSharedPreferences().getSharedPreferences(ILocalSharedPreferences.PreferenceName.device);
    private final IStorage mStorage;

    @Inject
    public DeviceIdStorage(Application application, IStorage iStorage) {
        this.mStorage = iStorage;
        this.mContentResolver = application.getContentResolver();
    }

    @Override // com.box.android.domain.identity.IDeviceIdStorage
    public String getInstallationId() throws IOException {
        String installationIdFromSharedPrefs = readInstallationIdFromSharedPrefs();
        if (installationIdFromSharedPrefs != null) {
            return installationIdFromSharedPrefs;
        }
        String installationIdFromExternalStorage = readInstallationIdFromExternalStorage();
        saveInstallationIdToSharedPrefs(installationIdFromExternalStorage);
        return installationIdFromExternalStorage;
    }

    @Override // com.box.android.domain.identity.IDeviceIdStorage
    public void setInstallationId(String str) throws IOException {
        saveInstallationIdToSharedPrefs(str);
    }

    @Override // com.box.android.domain.identity.IDeviceIdStorage
    public String getAndroidId() {
        String androidIdFromSharedPrefs = readAndroidIdFromSharedPrefs();
        if (androidIdFromSharedPrefs != null) {
            return androidIdFromSharedPrefs;
        }
        String androidIdFromSecureSettings = readAndroidIdFromSecureSettings();
        saveAndroidIdToSharedPrefs(androidIdFromSecureSettings);
        return androidIdFromSecureSettings;
    }

    @Override // com.box.android.domain.identity.IDeviceIdStorage
    public void setAndroidId(String str) {
        saveAndroidIdToSharedPrefs(str);
    }

    private String readInstallationIdFromExternalStorage() throws IOException {
        return this.mStorage.readStringFromFile(INSTALLATION_ID_PATH);
    }

    private void saveInstallationIdToSharedPrefs(String str) {
        SharedPreferences.Editor editorEdit = this.mSharedPrefs.edit();
        editorEdit.putString(INSTALLATION_ID_SHARED_PREFS_KEY, str);
        editorEdit.commit();
    }

    private String readInstallationIdFromSharedPrefs() {
        return this.mSharedPrefs.getString(INSTALLATION_ID_SHARED_PREFS_KEY, null);
    }

    private void saveAndroidIdToSharedPrefs(String str) {
        SharedPreferences.Editor editorEdit = this.mSharedPrefs.edit();
        editorEdit.putString(ANDROID_ID_SHARED_PREFS_KEY, str);
        editorEdit.commit();
    }

    private String readAndroidIdFromSharedPrefs() {
        return this.mSharedPrefs.getString(ANDROID_ID_SHARED_PREFS_KEY, null);
    }

    private String readAndroidIdFromSecureSettings() {
        try {
            return Settings.Secure.getString(this.mContentResolver, ANDROID_ID_SHARED_PREFS_KEY);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
