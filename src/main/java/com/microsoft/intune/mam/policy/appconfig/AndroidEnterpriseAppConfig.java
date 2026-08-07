package com.microsoft.intune.mam.policy.appconfig;

import android.content.Context;
import android.content.RestrictionsManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidEnterpriseAppConfig implements MAMAppConfig {
    private static Bundle mRestrictions;

    @Override // com.microsoft.intune.mam.policy.appconfig.MAMAppConfigBase
    public boolean hasConflict(String str) {
        return false;
    }

    protected AndroidEnterpriseAppConfig(Bundle bundle) {
        mRestrictions = bundle;
    }

    public static AndroidEnterpriseAppConfig create(Context context) {
        return create(context, new HashSet());
    }

    public static AndroidEnterpriseAppConfig create(Context context, Set<String> set) {
        return new AndroidEnterpriseAppConfig(AndroidEnterpriseAppConfigUtil.removeMAMAppConfigOnlyKeys(((RestrictionsManager) context.getSystemService("restrictions")).getApplicationRestrictions(), context, set));
    }

    @Override // com.microsoft.intune.mam.policy.appconfig.MAMAppConfigBase
    public List<Map<String, String>> getFullData() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (String str : mRestrictions.keySet()) {
            map.put(str, mRestrictions.get(str).toString());
        }
        arrayList.add(map);
        return arrayList;
    }

    @Override // com.microsoft.intune.mam.policy.appconfig.MAMAppConfig
    public Boolean getBooleanForKey(String str, MAMAppConfig.BooleanQueryType booleanQueryType) {
        List<Boolean> allBooleansForKey = getAllBooleansForKey(str);
        if (allBooleansForKey.size() == 0) {
            return null;
        }
        return allBooleansForKey.get(0);
    }

    @Override // com.microsoft.intune.mam.policy.appconfig.MAMAppConfig
    public Long getIntegerForKey(String str, MAMAppConfig.NumberQueryType numberQueryType) {
        List<Long> allIntegersForKey = getAllIntegersForKey(str);
        if (allIntegersForKey.size() == 0) {
            return null;
        }
        return allIntegersForKey.get(0);
    }

    @Override // com.microsoft.intune.mam.policy.appconfig.MAMAppConfig
    public Double getDoubleForKey(String str, MAMAppConfig.NumberQueryType numberQueryType) {
        List<Double> allDoublesForKey = getAllDoublesForKey(str);
        if (allDoublesForKey.size() == 0) {
            return null;
        }
        return allDoublesForKey.get(0);
    }

    @Override // com.microsoft.intune.mam.policy.appconfig.MAMAppConfig
    public String getStringForKey(String str, MAMAppConfig.StringQueryType stringQueryType) {
        List<String> allStringsForKey = getAllStringsForKey(str);
        if (allStringsForKey.size() == 0) {
            return null;
        }
        return allStringsForKey.get(0);
    }

    @Override // com.microsoft.intune.mam.policy.appconfig.MAMAppConfigBase
    public List<Boolean> getAllBooleansForKey(String str) {
        ArrayList arrayList = new ArrayList();
        if (mRestrictions.containsKey(str) && (mRestrictions.get(str) instanceof Boolean)) {
            arrayList.add(Boolean.valueOf(mRestrictions.getBoolean(str)));
        }
        return arrayList;
    }

    @Override // com.microsoft.intune.mam.policy.appconfig.MAMAppConfigBase
    public List<Long> getAllIntegersForKey(String str) {
        ArrayList arrayList = new ArrayList();
        if (mRestrictions.containsKey(str)) {
            Object obj = mRestrictions.get(str);
            if (obj instanceof Long) {
                arrayList.add(Long.valueOf(mRestrictions.getLong(str)));
                return arrayList;
            }
            if (obj instanceof Integer) {
                arrayList.add(Long.valueOf(mRestrictions.getInt(str)));
                return arrayList;
            }
            if (obj instanceof Short) {
                arrayList.add(Long.valueOf(mRestrictions.getShort(str)));
            }
        }
        return arrayList;
    }

    @Override // com.microsoft.intune.mam.policy.appconfig.MAMAppConfigBase
    public List<Double> getAllDoublesForKey(String str) {
        ArrayList arrayList = new ArrayList();
        if (mRestrictions.containsKey(str)) {
            Object obj = mRestrictions.get(str);
            if (obj instanceof Double) {
                arrayList.add(Double.valueOf(mRestrictions.getDouble(str)));
                return arrayList;
            }
            if (obj instanceof Float) {
                arrayList.add(Double.valueOf(mRestrictions.getFloat(str)));
            }
        }
        return arrayList;
    }

    @Override // com.microsoft.intune.mam.policy.appconfig.MAMAppConfigBase
    public List<String> getAllStringsForKey(String str) {
        ArrayList arrayList = new ArrayList();
        if (mRestrictions.containsKey(str) && (mRestrictions.get(str) instanceof String)) {
            arrayList.add(mRestrictions.getString(str));
        }
        return arrayList;
    }
}
