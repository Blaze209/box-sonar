package com.box.android.domain.configuration;

import android.content.Context;
import android.content.SharedPreferences;
import com.box.android.domain.R;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Pair;

/* JADX INFO: loaded from: classes11.dex */
@Singleton
public class ConfigManager {
    private static final String CONFIG_MANAGER_SHARED_PREFS = "configManagerSharedPrefs";
    private static final HashMap<String, Object> mConfMap = new HashMap<>();
    private final String DEFAULT_CLIENT_ID;
    private final String DEFAULT_CLIENT_SECRET;
    private final String DEFAULT_TABLET_CLIENT_ID;
    private final String DEFAULT_TABLET_CLIENT_SECRET;
    private final SharedPreferences mConfigManagerSharedPrefs;
    private final Context mContext;
    private final SharedPreferences mGlobalSharedPrefs;

    public String getDefaultClientId() {
        return this.DEFAULT_CLIENT_ID;
    }

    public String getDefaultClientSecret() {
        return this.DEFAULT_CLIENT_SECRET;
    }

    public String getDefaultTabletClientId() {
        return this.DEFAULT_TABLET_CLIENT_ID;
    }

    public String getDefaultTabletClientSecret() {
        return this.DEFAULT_TABLET_CLIENT_SECRET;
    }

    @Inject
    public ConfigManager(Context context, @Named("global-shared-preference") SharedPreferences sharedPreferences, IProductFlavorConfig iProductFlavorConfig) {
        this.mContext = context.getApplicationContext();
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(CONFIG_MANAGER_SHARED_PREFS, 0);
        this.mConfigManagerSharedPrefs = sharedPreferences2;
        this.mGlobalSharedPrefs = sharedPreferences;
        for (Map.Entry<String, ?> entry : sharedPreferences2.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                mConfMap.put(entry.getKey(), ((Set) entry.getValue()).toArray());
            } else {
                mConfMap.put(entry.getKey(), entry.getValue());
            }
        }
        Pair<String, String> pairProvideClientId = iProductFlavorConfig.provideClientId();
        BoxConfigConstants.DEFAULT_CONFIG_MAP.put(BoxConfigConstants.CONFIG_KEY_CLIENT_ID, pairProvideClientId.component1());
        this.DEFAULT_CLIENT_ID = pairProvideClientId.component1();
        this.DEFAULT_TABLET_CLIENT_ID = pairProvideClientId.component2();
        Pair<String, String> pairProvideClientSecret = iProductFlavorConfig.provideClientSecret();
        BoxConfigConstants.DEFAULT_CONFIG_MAP.put(BoxConfigConstants.CONFIG_KEY_CLIENT_SECRET, pairProvideClientSecret.component1());
        this.DEFAULT_CLIENT_SECRET = pairProvideClientSecret.component1();
        this.DEFAULT_TABLET_CLIENT_SECRET = pairProvideClientSecret.component2();
        BoxConfigConstants.DEFAULT_CONFIG_MAP.put(BoxConfigConstants.CONFIG_KEY_APP_NAME, iProductFlavorConfig.provideAppName());
        BoxConfigConstants.DEFAULT_CONFIG_MAP.put(BoxConfigConstants.CONFIG_KEY_KILL_APP_ON_LOGOUT_BOOL, Boolean.valueOf(iProductFlavorConfig.shouldKillAppOnLogout()));
        BoxConfigConstants.DEFAULT_CONFIG_MAP.put(BoxConfigConstants.CONFIG_KEY_ACCOUNT_SWITCHING_ENABLED_BOOL, Boolean.valueOf(iProductFlavorConfig.isAccountSwitchingEnabled()));
        BoxLogUtils.v("AndroidForWork", "Configuration values loaded from Shared Prefs: " + mConfMap);
    }

    public void setCustomConfigValue(String str, Object obj) {
        mConfMap.put(str, obj);
    }

    public void removeConfigValue(String str) {
        mConfMap.remove(str);
    }

    public void clearCustomConfigValues() {
        mConfMap.clear();
        this.mConfigManagerSharedPrefs.edit().clear().apply();
        BoxLogUtils.d("AndroidForWork", "Configuration settings have been cleared.");
    }

    public String getString(String str) {
        if (!BoxConfigConstants.DEFAULT_CONFIG_MAP.containsKey(str)) {
            BoxLogUtils.e("CONFIG MANAGER", "MISSING CONFIG VALUE! FIX: " + str);
        }
        HashMap<String, Object> map = mConfMap;
        if (!map.containsKey(str)) {
            map = BoxConfigConstants.DEFAULT_CONFIG_MAP;
        }
        return (String) map.get(str);
    }

    public Boolean getBoolean(String str) {
        if (!BoxConfigConstants.DEFAULT_CONFIG_MAP.containsKey(str)) {
            BoxLogUtils.e("CONFIG MANAGER", "MISSING CONFIG VALUE! FIX: " + str);
        }
        HashMap<String, Object> map = mConfMap;
        if (!map.containsKey(str)) {
            map = BoxConfigConstants.DEFAULT_CONFIG_MAP;
        }
        return (Boolean) map.get(str);
    }

    public String[] getArray(String str) {
        if (!BoxConfigConstants.DEFAULT_CONFIG_MAP.containsKey(str)) {
            BoxLogUtils.e("CONFIG MANAGER", "MISSING CONFIG VALUE! FIX: " + str);
        }
        HashMap<String, Object> map = mConfMap;
        if (!map.containsKey(str)) {
            map = BoxConfigConstants.DEFAULT_CONFIG_MAP;
        }
        return (String[]) map.get(str);
    }

    public boolean containsKey(String str) {
        return mConfMap.containsKey(str);
    }

    public boolean isConfigSet() {
        HashMap<String, Object> map = mConfMap;
        return map.containsKey(BoxConfigConstants.CONFIG_KEY_CLIENT_ID) && map.containsKey(BoxConfigConstants.CONFIG_KEY_CLIENT_SECRET);
    }

    public void commitConfigurations() {
        SharedPreferences.Editor editorEdit = this.mConfigManagerSharedPrefs.edit();
        for (Map.Entry<String, Object> entry : mConfMap.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (value instanceof Integer) {
                editorEdit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Boolean) {
                editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Array) {
                editorEdit.putStringSet(entry.getKey(), new HashSet(Arrays.asList((String[]) entry.getValue())));
            } else {
                editorEdit.putString(entry.getKey(), (String) value);
            }
        }
        editorEdit.apply();
        BoxLogUtils.d("AndroidForWork", "Persisted configuration settings to Shared Prefs.");
    }

    public boolean isDeviceTypeTablet() {
        boolean z = this.mGlobalSharedPrefs.getBoolean(BoxConfigConstants.CONFIG_CLIENT_TYPE, this.mContext.getResources().getBoolean(R.bool.is7inchOrLarger));
        if (!this.mGlobalSharedPrefs.contains(BoxConfigConstants.CONFIG_CLIENT_TYPE)) {
            SharedPreferences.Editor editorEdit = this.mGlobalSharedPrefs.edit();
            editorEdit.putBoolean(BoxConfigConstants.CONFIG_CLIENT_TYPE, z);
            editorEdit.apply();
        }
        return z;
    }

    public boolean isDevpodEnvironment() {
        return getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_HOSTNAME).contains(BoxConfigConstants.DEVPOD_HOST_NAME_SUBSTRING);
    }
}
