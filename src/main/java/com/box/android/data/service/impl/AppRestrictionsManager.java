package com.box.android.data.service.impl;

import android.content.Context;
import android.content.RestrictionEntry;
import android.content.RestrictionsManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.utilities.intune.IntuneKeysConfigUtils;
import com.box.android.data.R;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes11.dex */
public class AppRestrictionsManager implements IAppRestrictionsManager {
    private static final String APP_RESTRICTIONS_SHARED_PREFS = "appRestrictionsSharedPrefs";
    private final SharedPreferences mAppRestrictionsSharedPrefs;
    private final String[] mMandatoryRestrictionKeys;
    private RestrictionsManager mRestrictionsManager;
    private Bundle mAppRestrictionsBundle = new Bundle();
    private final HashMap<String, Integer> mRestrictionTypes = new HashMap<>();

    @Inject
    public AppRestrictionsManager(final Context context) {
        this.mAppRestrictionsSharedPrefs = context.getSharedPreferences(APP_RESTRICTIONS_SHARED_PREFS, 0);
        if (context.getResources() != null) {
            this.mMandatoryRestrictionKeys = context.getResources().getStringArray(R.array.mandatory_restriction_keys);
        } else {
            this.mMandatoryRestrictionKeys = null;
        }
        RestrictionsManager restrictionsManager = (RestrictionsManager) context.getSystemService("restrictions");
        this.mRestrictionsManager = restrictionsManager;
        for (RestrictionEntry restrictionEntry : restrictionsManager.getManifestRestrictions(context.getPackageName())) {
            this.mRestrictionTypes.put(restrictionEntry.getKey(), Integer.valueOf(restrictionEntry.getType()));
        }
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public boolean isRestrictionsSet() {
        return !this.mAppRestrictionsBundle.isEmpty();
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public ArrayList<String> getMandatoryFieldsNotSet(final Bundle appRestrictionsBundle) throws RuntimeException {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = this.mMandatoryRestrictionKeys;
        if (strArr == null) {
            throw new RuntimeException("Application not fully initialized");
        }
        for (String str : strArr) {
            if (!appRestrictionsBundle.containsKey(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public Bundle getSavedAppRestrictions() {
        Bundle bundle = new Bundle();
        Map<String, ?> all = this.mAppRestrictionsSharedPrefs.getAll();
        BoxLogUtils.v("AndroidForWork", "Loaded app restrictions from shared prefs: " + all);
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            boolean zContainsKey = this.mRestrictionTypes.containsKey(key);
            Integer num = this.mRestrictionTypes.get(key);
            if (num == null) {
                BoxLogUtils.logException("AppRestrictionsManager.getSavedAppRestrictions", "invalid key type " + num + " for key " + key, new RuntimeException("key type null"));
            }
            int iIntValue = (!zContainsKey || num == null) ? 6 : num.intValue();
            if (iIntValue == 1) {
                bundle.putBoolean(key, ((Boolean) entry.getValue()).booleanValue());
            } else if (iIntValue == 4) {
                HashSet hashSet = (HashSet) entry.getValue();
                if (hashSet != null) {
                    bundle.putStringArray(key, (String[]) hashSet.toArray(new String[hashSet.size()]));
                }
            } else if (iIntValue == 5) {
                bundle.putInt(key, ((Integer) entry.getValue()).intValue());
            } else {
                bundle.putString(entry.getKey(), (String) entry.getValue());
            }
        }
        return bundle;
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public String getString(String appRestrictionsKey) {
        return this.mAppRestrictionsBundle.getString(appRestrictionsKey);
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public Boolean getBoolean(String appRestrictionsKey) {
        return Boolean.valueOf(this.mAppRestrictionsBundle.getBoolean(appRestrictionsKey));
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public Bundle getLatestAppRestrictions() {
        Bundle applicationRestrictions = this.mRestrictionsManager.getApplicationRestrictions();
        return applicationRestrictions == null ? new Bundle() : applicationRestrictions;
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public void setAppRestrictions() {
        this.mAppRestrictionsBundle = getSavedAppRestrictions();
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public void commitAppRestrictions(Bundle appRestrictionsBundle) {
        SharedPreferences.Editor editorClear = this.mAppRestrictionsSharedPrefs.edit().clear();
        for (String str : appRestrictionsBundle.keySet()) {
            int iIntValue = this.mRestrictionTypes.getOrDefault(str, 6).intValue();
            if (iIntValue == 1) {
                editorClear.putBoolean(str, appRestrictionsBundle.getBoolean(str));
            } else if (iIntValue == 4) {
                editorClear.putStringSet(str, new HashSet(Arrays.asList(appRestrictionsBundle.getStringArray(str))));
            } else if (iIntValue == 5) {
                editorClear.putInt(str, appRestrictionsBundle.getInt(str));
            } else {
                editorClear.putString(str, appRestrictionsBundle.getString(str));
            }
        }
        IntuneKeysConfigUtils.saveNewValues(appRestrictionsBundle.getString(CommonBoxUtil.LS(R.string.restriction_key_IntuneEnterprise)), appRestrictionsBundle.getString(CommonBoxUtil.LS(R.string.restriction_key_userprincipalname)));
        editorClear.apply();
        BoxLogUtils.v("AndroidForWork", "Persisted app restrictions to shared prefs.");
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public void clearAppRestrictions() {
        this.mAppRestrictionsBundle.clear();
        this.mAppRestrictionsSharedPrefs.edit().clear().apply();
        BoxLogUtils.v("AndroidForWork", "App restrictions have been cleared.");
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public ArrayList<String> getAlteredAppRestrictionKeys(Bundle latest) {
        Bundle savedAppRestrictions = getSavedAppRestrictions();
        if (latest == null) {
            latest = new Bundle();
        }
        if (savedAppRestrictions.size() > latest.size()) {
            return getDifferentKeys(savedAppRestrictions, latest);
        }
        return getDifferentKeys(latest, savedAppRestrictions);
    }

    private ArrayList<String> getDifferentKeys(Bundle larger, Bundle smaller) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : larger.keySet()) {
            if (this.mRestrictionTypes.get(str) != null && this.mRestrictionTypes.get(str).intValue() != 4 && !larger.get(str).equals(smaller.get(str))) {
                arrayList.add(str);
            }
        }
        BoxLogUtils.v("AndroidForWork", "Altered keys: " + arrayList);
        return arrayList;
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public boolean containsMandatoryKey(ArrayList<String> keys) throws RuntimeException {
        String[] strArr = this.mMandatoryRestrictionKeys;
        if (strArr == null) {
            throw new RuntimeException("Application not fully initialized");
        }
        for (String str : strArr) {
            if (this.mRestrictionTypes.get(str) != null && this.mRestrictionTypes.get(str).intValue() != 4 && keys.contains(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public boolean isRestrictionsValid(Bundle restrictions) throws RuntimeException {
        if (restrictions.isEmpty()) {
            return true;
        }
        String[] strArr = this.mMandatoryRestrictionKeys;
        if (strArr == null) {
            throw new RuntimeException("Application not fully initialized");
        }
        for (String str : strArr) {
            if (!restrictions.keySet().contains(str)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.box.android.domain.services.IAppRestrictionsManager
    public boolean isAppFedrampHighCompliant() {
        return getLatestAppRestrictions().getBoolean(CommonBoxUtil.LS(R.string.restriction_key_FedrampHigh));
    }
}
