package com.microsoft.intune.mam.client.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs;

/* JADX INFO: loaded from: classes3.dex */
public class DirectBootStatusStore extends BaseSharedPrefs {
    private static final String KEY_ALL_SHARED_PREFS_ARE_MIGRATED = "allsharedprefsaremigrated";
    private static final String KEY_APP_VERSION = "appversion";
    private static final String KEY_HAS_DIRECT_BOOT_AWARE_COMPONENT = "hasdirectbootawarecomponent";
    private static final String SHARED_PREFS_NAME = "com.microsoft.intune.mam.directBootStatus";

    public enum AppContainsDirectBootAwareComponents {
        TRUE(0),
        FALSE(1),
        UNKNOWN(2);

        private final int mCode;

        AppContainsDirectBootAwareComponents(int i) {
            this.mCode = i;
        }

        public int getCode() {
            return this.mCode;
        }

        public static AppContainsDirectBootAwareComponents fromCode(int i) {
            for (int i2 = 0; i2 < values().length; i2++) {
                if (values()[i2].getCode() == i) {
                    return values()[i2];
                }
            }
            return null;
        }
    }

    public DirectBootStatusStore(Context context) {
        super(context, SHARED_PREFS_NAME, false);
    }

    public void setDirectBootStorageMigrated(final String str) {
        setSharedPref(new BaseSharedPrefs.SetPref() { // from class: com.microsoft.intune.mam.client.app.DirectBootStatusStore$$ExternalSyntheticLambda0
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.SetPref
            public final void execute(SharedPreferences.Editor editor) {
                editor.putBoolean(str, true);
            }
        });
    }

    public boolean isDirectBootStorageMigrated(final String str) {
        return ((Boolean) getSharedPref(new BaseSharedPrefs.GetPref() { // from class: com.microsoft.intune.mam.client.app.DirectBootStatusStore$$ExternalSyntheticLambda4
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetPref
            public final Object execute(SharedPreferences sharedPreferences) {
                return Boolean.valueOf(sharedPreferences.getBoolean(str, false));
            }
        })).booleanValue();
    }

    public boolean isAllDirectBootStorageMigrated() {
        return ((Boolean) getSharedPref(new BaseSharedPrefs.GetPref() { // from class: com.microsoft.intune.mam.client.app.DirectBootStatusStore$$ExternalSyntheticLambda3
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetPref
            public final Object execute(SharedPreferences sharedPreferences) {
                return Boolean.valueOf(sharedPreferences.getBoolean(DirectBootStatusStore.KEY_ALL_SHARED_PREFS_ARE_MIGRATED, false));
            }
        })).booleanValue();
    }

    public void setAllDirectBootStorageMigrated() {
        setSharedPref(new BaseSharedPrefs.SetPref() { // from class: com.microsoft.intune.mam.client.app.DirectBootStatusStore$$ExternalSyntheticLambda2
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.SetPref
            public final void execute(SharedPreferences.Editor editor) {
                editor.putBoolean(DirectBootStatusStore.KEY_ALL_SHARED_PREFS_ARE_MIGRATED, true);
            }
        });
    }

    public void setHasDirectBootAwareComponent(final AppContainsDirectBootAwareComponents appContainsDirectBootAwareComponents) {
        setSharedPref(new BaseSharedPrefs.SetPref() { // from class: com.microsoft.intune.mam.client.app.DirectBootStatusStore$$ExternalSyntheticLambda5
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.SetPref
            public final void execute(SharedPreferences.Editor editor) {
                this.f$0.m13862x5456513a(appContainsDirectBootAwareComponents, editor);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setHasDirectBootAwareComponent$4$com-microsoft-intune-mam-client-app-DirectBootStatusStore, reason: not valid java name */
    /* synthetic */ void m13862x5456513a(AppContainsDirectBootAwareComponents appContainsDirectBootAwareComponents, SharedPreferences.Editor editor) {
        editor.putInt(KEY_HAS_DIRECT_BOOT_AWARE_COMPONENT, appContainsDirectBootAwareComponents.getCode());
        editor.putLong(KEY_APP_VERSION, AppUtils.getPackageVersionCode(this.mContext));
    }

    public AppContainsDirectBootAwareComponents hasDirectBootAwareComponent() {
        AppContainsDirectBootAwareComponents appContainsDirectBootAwareComponentsFromCode = AppContainsDirectBootAwareComponents.fromCode(((Integer) getSharedPref(new BaseSharedPrefs.GetPref() { // from class: com.microsoft.intune.mam.client.app.DirectBootStatusStore$$ExternalSyntheticLambda1
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetPref
            public final Object execute(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(DirectBootStatusStore.KEY_HAS_DIRECT_BOOT_AWARE_COMPONENT, DirectBootStatusStore.AppContainsDirectBootAwareComponents.UNKNOWN.getCode()));
            }
        })).intValue());
        return (appContainsDirectBootAwareComponentsFromCode != AppContainsDirectBootAwareComponents.FALSE || ((Long) getSharedPref(new BaseSharedPrefs.GetPref<Long>() { // from class: com.microsoft.intune.mam.client.app.DirectBootStatusStore.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetPref
            public Long execute(SharedPreferences sharedPreferences) {
                return Long.valueOf(sharedPreferences.getLong(DirectBootStatusStore.KEY_APP_VERSION, 0L));
            }
        })).longValue() == AppUtils.getPackageVersionCode(this.mContext)) ? appContainsDirectBootAwareComponentsFromCode : AppContainsDirectBootAwareComponents.UNKNOWN;
    }
}
