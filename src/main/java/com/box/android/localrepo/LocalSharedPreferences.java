package com.box.android.localrepo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.fragments.BaseFTUX;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.usercontext.UserContextComponent;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes12.dex */
public class LocalSharedPreferences extends UserContextComponent implements ILocalSharedPreferences {
    @Inject
    public LocalSharedPreferences() {
    }

    private void logRetainedSharedPref(ILocalSharedPreferences.PreferenceName preferenceName) {
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            SharedPreferences sharedPreferences = getSharedPreferences(preferenceName);
            if (sharedPreferences.getAll().size() > 0) {
                Log.i("BOX", "Following Shared Prefs Retained for: " + preferenceName.name());
            }
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                Log.i("BOX Shared Pref: ", ((Object) entry.getKey()) + " -> " + entry.getValue());
            }
        }
    }

    public SharedPreferences getSharedPreferences() {
        return getSharedPreferences(ILocalSharedPreferences.PreferenceName.myPreference);
    }

    @Override // com.box.android.domain.localrepo.ILocalSharedPreferences
    public SharedPreferences getSharedPreferences(String str) {
        return getSharedPreferences(ILocalSharedPreferences.PreferenceName.valueOf(str));
    }

    @Override // com.box.android.domain.localrepo.ILocalSharedPreferences
    public SharedPreferences getSharedPreferences(ILocalSharedPreferences.PreferenceName preferenceName) {
        if (isGlobal(preferenceName)) {
            return getContext().getSharedPreferences(preferenceName.name(), 0);
        }
        return getContext().getSharedPreferences(preferenceName.name() + getContextId(), 0);
    }

    @Override // com.box.android.domain.localrepo.ILocalSharedPreferences
    public SharedPreferences getEncryptedSharedPrefs(ILocalSharedPreferences.PreferenceName preferenceName) {
        try {
            String strName = preferenceName.name();
            if (!isGlobal(preferenceName)) {
                strName = strName + getContextId();
            }
            return EncryptedSharedPreferences.create(strName, getKeyForEncryption(), ApplicationProvider.application, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getKeyForEncryption() throws GeneralSecurityException, IOException {
        return MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
    }

    private boolean isGlobal(ILocalSharedPreferences.PreferenceName preferenceName) {
        return preferenceName == ILocalSharedPreferences.PreferenceName.GLOBAL || preferenceName == ILocalSharedPreferences.PreferenceName.device || preferenceName == ILocalSharedPreferences.PreferenceName.EMM || preferenceName == ILocalSharedPreferences.PreferenceName.PUSH_NOTIFICATION_GLOBAL || preferenceName == ILocalSharedPreferences.PreferenceName.FTUX || preferenceName == ILocalSharedPreferences.PreferenceName.ANALYTICS || preferenceName == ILocalSharedPreferences.PreferenceName.FEATURE_FLIP_DEBUG_OVERRIDE || preferenceName == ILocalSharedPreferences.PreferenceName.OBSERVABILITY || preferenceName == ILocalSharedPreferences.PreferenceName.SPLIT_ENVIRONMENT_OVERRIDE || preferenceName == ILocalSharedPreferences.PreferenceName.GENIUS_SCAN_SDK_LICENSE || preferenceName == ILocalSharedPreferences.PreferenceName.APP_UPDATES || preferenceName == ILocalSharedPreferences.PreferenceName.INTUNE_AUTH_ENCRYPTED;
    }

    private Context getContext() {
        return BoxBaseApplication.getInstance();
    }

    private void removeAllInSharedPrefs(SharedPreferences sharedPreferences, String... strArr) {
        Set<String> setKeySet = sharedPreferences.getAll().keySet();
        HashSet hashSet = new HashSet();
        if (strArr != null) {
            for (String str : strArr) {
                hashSet.add(str);
            }
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (String str2 : setKeySet) {
            if (!hashSet.contains(str2)) {
                editorEdit.remove(str2);
            }
        }
        editorEdit.commit();
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onHardDestroy() {
        File file = new File(BoxBaseApplication.getInstance().getApplicationInfo().dataDir, "shared_prefs");
        for (ILocalSharedPreferences.PreferenceName preferenceName : ILocalSharedPreferences.PreferenceName.values()) {
            if (!isGlobal(preferenceName)) {
                getSharedPreferences(preferenceName).edit().clear().commit();
                try {
                    if (!SdkUtils.isBlank(getContextId())) {
                        File file2 = new File(file, preferenceName + getContextId() + ".xml");
                        if (file2.exists()) {
                            file2.delete();
                        }
                    }
                } catch (Exception e) {
                    BoxLogUtils.logException(e);
                }
            }
        }
        removeFtuxSharedPrefs();
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            for (ILocalSharedPreferences.PreferenceName preferenceName2 : ILocalSharedPreferences.PreferenceName.values()) {
                logRetainedSharedPref(preferenceName2);
            }
        }
        super.onHardDestroy();
    }

    private void removeFtuxSharedPrefs() {
        ArrayList arrayList = new ArrayList();
        for (BaseFTUX.FTUXType fTUXType : BaseFTUX.FTUXType.values()) {
            arrayList.add(String.format(BaseFTUX.SHARED_PREF_KEY_FTUX_COMPLETE, fTUXType.name().substring(0, 1) + fTUXType.name().substring(1).toLowerCase()));
        }
        removeAllInSharedPrefs(getSharedPreferences(ILocalSharedPreferences.PreferenceName.FTUX), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public void removeAllSharedPrefs() {
        for (ILocalSharedPreferences.PreferenceName preferenceName : ILocalSharedPreferences.PreferenceName.values()) {
            getSharedPreferences(preferenceName).edit().clear().apply();
        }
    }
}
