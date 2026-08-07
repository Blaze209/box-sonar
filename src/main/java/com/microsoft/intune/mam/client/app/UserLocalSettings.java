package com.microsoft.intune.mam.client.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class UserLocalSettings extends BaseSharedPrefs {
    public UserLocalSettings(Context context) {
        super(context, OfflineSharedPreferencesConstants.USER_LOCAL_SETTINGS_SHARED_PREFS_NAME, true);
    }

    public void clear(MAMIdentity mAMIdentity) {
        if (MAMIdentity.isValid(mAMIdentity)) {
            final ArrayList arrayList = new ArrayList();
            for (String str : (Set) getSharedPref(new BaseSharedPrefs.GetPref() { // from class: com.microsoft.intune.mam.client.app.UserLocalSettings$$ExternalSyntheticLambda0
                @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetPref
                public final Object execute(SharedPreferences sharedPreferences) {
                    return sharedPreferences.getAll().keySet();
                }
            })) {
                if (str.contains(mAMIdentity.aadId())) {
                    arrayList.add(str);
                }
            }
            setSharedPref(new BaseSharedPrefs.SetPref() { // from class: com.microsoft.intune.mam.client.app.UserLocalSettings$$ExternalSyntheticLambda1
                @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.SetPref
                public final void execute(SharedPreferences.Editor editor) {
                    UserLocalSettings.lambda$clear$1(arrayList, editor);
                }
            });
        }
    }

    static /* synthetic */ void lambda$clear$1(List list, SharedPreferences.Editor editor) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            editor.remove((String) it.next());
        }
    }

    protected String getKeyForIdentity(String str, MAMIdentity mAMIdentity) {
        return str + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + mAMIdentity.aadId();
    }
}
