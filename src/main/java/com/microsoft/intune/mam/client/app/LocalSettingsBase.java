package com.microsoft.intune.mam.client.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LocalSettingsBase extends BaseSharedPrefs {
    private static final String KEY_HAS_APPCONFIG = "isappconfigmanaged";
    private static final String KEY_IS_MAM_MANAGED = "ismanaged";
    protected static final String KEY_MANAGED_DIALOG_DISMISSED = "manageddialogdismissed";
    private static final String SHARED_PREFS_NAME = "com.microsoft.intune.mam.local";

    public LocalSettingsBase(Context context) {
        super(context, "com.microsoft.intune.mam.local", true);
    }

    public boolean getIsManaged() {
        return getIsMAMManaged() || getHasAppConfig();
    }

    public boolean getIsMAMManaged() {
        return ((Integer) getSharedPref(new BaseSharedPrefs.GetPref() { // from class: com.microsoft.intune.mam.client.app.LocalSettingsBase$$ExternalSyntheticLambda3
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetPref
            public final Object execute(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(LocalSettingsBase.KEY_IS_MAM_MANAGED, -1));
            }
        })).intValue() == 1;
    }

    public boolean getHasAppConfig() {
        return ((Integer) getSharedPref(new BaseSharedPrefs.GetPref() { // from class: com.microsoft.intune.mam.client.app.LocalSettingsBase$$ExternalSyntheticLambda2
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetPref
            public final Object execute(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(LocalSettingsBase.KEY_HAS_APPCONFIG, -1));
            }
        })).intValue() == 1;
    }

    public void clearIsManaged() {
        setIsMAMManaged(false);
        setHasAppConfig(false);
    }

    public void setIsMAMManaged(final boolean z) {
        setSharedPref(new BaseSharedPrefs.SetPref() { // from class: com.microsoft.intune.mam.client.app.LocalSettingsBase$$ExternalSyntheticLambda1
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.SetPref
            public final void execute(SharedPreferences.Editor editor) {
                editor.putInt(LocalSettingsBase.KEY_IS_MAM_MANAGED, z ? 1 : 0);
            }
        });
    }

    public void setHasAppConfig(final boolean z) {
        setSharedPref(new BaseSharedPrefs.SetPref() { // from class: com.microsoft.intune.mam.client.app.LocalSettingsBase$$ExternalSyntheticLambda5
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.SetPref
            public final void execute(SharedPreferences.Editor editor) {
                editor.putInt(LocalSettingsBase.KEY_HAS_APPCONFIG, z ? 1 : 0);
            }
        });
    }

    public boolean isManagementRecorded() {
        return isMAMManagementRecorded() || isAppConfigManagementRecorded();
    }

    public boolean isMAMManagementRecorded() {
        return ((Integer) getSharedPref(new BaseSharedPrefs.GetPref() { // from class: com.microsoft.intune.mam.client.app.LocalSettingsBase$$ExternalSyntheticLambda7
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetPref
            public final Object execute(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(LocalSettingsBase.KEY_IS_MAM_MANAGED, -1));
            }
        })).intValue() != -1;
    }

    public boolean isAppConfigManagementRecorded() {
        return ((Integer) getSharedPref(new BaseSharedPrefs.GetPref() { // from class: com.microsoft.intune.mam.client.app.LocalSettingsBase$$ExternalSyntheticLambda4
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetPref
            public final Object execute(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(LocalSettingsBase.KEY_HAS_APPCONFIG, -1));
            }
        })).intValue() != -1;
    }

    public boolean isEmpty() {
        Map map = (Map) getSharedPref(new BaseSharedPrefs.GetPref() { // from class: com.microsoft.intune.mam.client.app.LocalSettingsBase$$ExternalSyntheticLambda6
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetPref
            public final Object execute(SharedPreferences sharedPreferences) {
                return sharedPreferences.getAll();
            }
        });
        return map == null || map.isEmpty();
    }

    public void clearLocalSettings() {
        setSharedPref(new BaseSharedPrefs.SetPref() { // from class: com.microsoft.intune.mam.client.app.LocalSettingsBase$$ExternalSyntheticLambda0
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.SetPref
            public final void execute(SharedPreferences.Editor editor) {
                editor.remove(LocalSettingsBase.KEY_MANAGED_DIALOG_DISMISSED);
            }
        });
    }
}
