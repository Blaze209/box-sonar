package com.microsoft.intune.mam.policy;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.intune.mam.client.app.DirectBootUtils;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class MAMEnrollmentStatusCache {
    private static final String KEY_COMPANY_PORTAL_REQUIRED = "companyportalrequired";
    private static final String KEY_CURRENT_CERT_VERSION = "currentcertversion";
    private static final String KEY_IDENTITY = "identity";
    private static final String KEY_IMPLICIT_WIPE_HAPPENED = "implicitwipehappened";
    private static final String KEY_MAMSERVICE_UNLICENSED_RETRY_INTERVAL = "mamserviceurlrequeryinterval";
    private static final String KEY_MAMSERVICE_URL = "mamserviceurl";
    private static final String KEY_MAMSERVICE_URL_IDENTITY = "mamserviceurlidentity";
    private static final String KEY_MAMSERVICE_URL_PREFIX = "mamserviceurl_";
    private static final String KEY_MAMSERVICE_URL_TIMESTAMP = "mamserviceurltime";
    private static final String KEY_SYSTEM_WIPE = "requiresystemwipe";
    private static final String KEY_WAS_MANAGED = "wasmanaged";
    private static final int LATEST_CERT_VERSION = 1;
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMEnrollmentStatusCache.class);
    private static final String SHARED_PREFS_NAME = "com.microsoft.intune.mam.enrollmentStatus";
    private final Context mContext;
    private final MAMLogPIIFactory mMAMLogPIIFactory;

    public MAMEnrollmentStatusCache(Context context, MAMLogPIIFactory mAMLogPIIFactory) {
        this.mContext = context;
        this.mMAMLogPIIFactory = mAMLogPIIFactory;
    }

    @Deprecated
    public String getEnrolledIdentity() {
        String string = getPrefs().getString("identity", null);
        if (string == null) {
            LOGGER.info("No MAM enrollment status found.", new Object[0]);
            return string;
        }
        LOGGER.info("MAM enrollment status found for identity {0}", this.mMAMLogPIIFactory.getPIIUPN(string));
        return string;
    }

    @Deprecated
    public boolean getWasManaged() {
        boolean z = getPrefs().getBoolean(KEY_WAS_MANAGED, false);
        LOGGER.info("app was managed: " + String.valueOf(z), new Object[0]);
        return z;
    }

    @Deprecated
    public void setEnrolledIdentity(String str, boolean z) {
        LOGGER.info("Recording MAM enrollment for identity {0}, isManaged: {1}", this.mMAMLogPIIFactory.getPIIUPN(str), String.valueOf(z));
        SharedPreferences.Editor editor = getEditor();
        editor.putString("identity", str);
        editor.putBoolean(KEY_WAS_MANAGED, z);
        editor.commit();
        clearCompanyPortalRequired();
    }

    @Deprecated
    public void setWasManaged() {
        SharedPreferences prefs = getPrefs();
        if (prefs.getBoolean(KEY_WAS_MANAGED, false)) {
            return;
        }
        LOGGER.info("Recording transition from unmanaged to managed.", new Object[0]);
        SharedPreferences.Editor editorEdit = prefs.edit();
        editorEdit.putBoolean(KEY_WAS_MANAGED, true);
        editorEdit.commit();
    }

    @Deprecated
    public void clearEnrolledIdentity(String str) {
        SharedPreferences prefs = getPrefs();
        String string = prefs.getString("identity", null);
        if (string == null || !string.equalsIgnoreCase(str)) {
            return;
        }
        LOGGER.info("Clearing MAM enrollment status for identity {0}", this.mMAMLogPIIFactory.getPIIUPN(str));
        SharedPreferences.Editor editorEdit = prefs.edit();
        editorEdit.remove("identity");
        editorEdit.remove(KEY_WAS_MANAGED);
        editorEdit.commit();
        clearCompanyPortalRequired();
    }

    @Deprecated
    public Map<String, String> getMAMServiceUrls() {
        String string;
        String mamServiceUrlMapKey;
        SharedPreferences prefs = getPrefs();
        if (prefs.getInt(KEY_CURRENT_CERT_VERSION, 0) < 1) {
            LOGGER.info("Cached MAM Service URLs are not using latest certs, clearing them.", new Object[0]);
            clearMAMServiceUrls();
            return null;
        }
        HashMap map = new HashMap();
        for (String str : getMamServiceUrlKeys()) {
            String string2 = prefs.getString(str, null);
            if (string2 != null && (mamServiceUrlMapKey = getMamServiceUrlMapKey(str)) != null) {
                map.put(mamServiceUrlMapKey, string2);
            }
        }
        if (!map.containsKey(MAMServiceLookupThread.MAMSERVICE_URL_KEY) && (string = prefs.getString(KEY_MAMSERVICE_URL, null)) != null) {
            map.put(MAMServiceLookupThread.MAMSERVICE_URL_KEY, string);
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    @Deprecated
    public String getMAMServiceUrlIdentity() {
        return getPrefs().getString(KEY_MAMSERVICE_URL_IDENTITY, null);
    }

    @Deprecated
    public long getMAMServiceUrlTimestamp() {
        return getPrefs().getLong(KEY_MAMSERVICE_URL_TIMESTAMP, 0L);
    }

    @Deprecated
    public long getMAMServiceUnlicensedRetryInterval() {
        return getPrefs().getLong(KEY_MAMSERVICE_UNLICENSED_RETRY_INTERVAL, MAMWERetryScheduler.DEFAULT_UNLICENSED_RETRY_INTERVAL_MS);
    }

    @Deprecated
    public void setMAMServiceUrls(String str, Map<String, String> map, long j) {
        SharedPreferences.Editor editor = getEditor();
        deleteMAMServiceUrls(editor);
        if (map != null) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                LOGGER.info("Recording MAM service URL: {0}: {1} for: {2}", str2, str3, this.mMAMLogPIIFactory.getPIIUPN(str));
                editor.putString(getMamServiceUrlPrefsKey(str2), str3);
            }
        }
        editor.putString(KEY_MAMSERVICE_URL_IDENTITY, str);
        editor.putLong(KEY_MAMSERVICE_URL_TIMESTAMP, System.currentTimeMillis());
        editor.putLong(KEY_MAMSERVICE_UNLICENSED_RETRY_INTERVAL, j);
        editor.putInt(KEY_CURRENT_CERT_VERSION, 1);
        editor.commit();
    }

    @Deprecated
    public void clearMAMServiceUrls() {
        LOGGER.info("Clearing cached MAM service URLs", new Object[0]);
        SharedPreferences.Editor editor = getEditor();
        deleteMAMServiceUrls(editor);
        editor.remove(KEY_MAMSERVICE_URL_IDENTITY);
        editor.remove(KEY_MAMSERVICE_URL_TIMESTAMP);
        editor.remove(KEY_MAMSERVICE_UNLICENSED_RETRY_INTERVAL);
        editor.commit();
    }

    private void deleteMAMServiceUrls(SharedPreferences.Editor editor) {
        Iterator<String> it = getMamServiceUrlKeys().iterator();
        while (it.hasNext()) {
            editor.remove(it.next());
        }
    }

    private Set<String> getMamServiceUrlKeys() {
        HashSet hashSet = new HashSet();
        for (String str : getPrefs().getAll().keySet()) {
            if (str.startsWith(KEY_MAMSERVICE_URL_PREFIX)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    private String getMamServiceUrlPrefsKey(String str) {
        return KEY_MAMSERVICE_URL_PREFIX + str;
    }

    private String getMamServiceUrlMapKey(String str) {
        if (!str.startsWith(KEY_MAMSERVICE_URL_PREFIX)) {
            return null;
        }
        String strSubstring = str.substring(KEY_MAMSERVICE_URL_PREFIX.length());
        if (strSubstring.isEmpty()) {
            return null;
        }
        return strSubstring;
    }

    @Deprecated
    public boolean isCompanyPortalRequired() {
        return getPrefs().getBoolean(KEY_COMPANY_PORTAL_REQUIRED, false);
    }

    @Deprecated
    public void clearCompanyPortalRequired() {
        LOGGER.info("Clearing Company Portal required.", new Object[0]);
        SharedPreferences.Editor editor = getEditor();
        editor.remove(KEY_COMPANY_PORTAL_REQUIRED);
        editor.commit();
    }

    private SharedPreferences getPrefs() {
        return DirectBootUtils.getDirectBootAwareContext(this.mContext).getSharedPreferences("com.microsoft.intune.mam.enrollmentStatus", 0);
    }

    private SharedPreferences.Editor getEditor() {
        return getPrefs().edit();
    }

    public void setImplicitWipeNotice() {
        SharedPreferences prefs = getPrefs();
        if (prefs.getBoolean(KEY_IMPLICIT_WIPE_HAPPENED, false)) {
            return;
        }
        LOGGER.info("Implicit wipe just happened and need to notify user", new Object[0]);
        SharedPreferences.Editor editorEdit = prefs.edit();
        editorEdit.putBoolean(KEY_IMPLICIT_WIPE_HAPPENED, true);
        editorEdit.commit();
    }

    public boolean getImplicitWipeNotice() {
        return getPrefs().getBoolean(KEY_IMPLICIT_WIPE_HAPPENED, false);
    }

    public void clearImplicitWipeNotice() {
        SharedPreferences prefs = getPrefs();
        if (prefs.getBoolean(KEY_IMPLICIT_WIPE_HAPPENED, false)) {
            LOGGER.info("Clear Implicit Wipe Type", new Object[0]);
            SharedPreferences.Editor editorEdit = prefs.edit();
            editorEdit.remove(KEY_IMPLICIT_WIPE_HAPPENED);
            editorEdit.commit();
        }
    }

    public void setSystemWipeNotice() {
        SharedPreferences prefs = getPrefs();
        if (prefs.getBoolean(KEY_SYSTEM_WIPE, false)) {
            return;
        }
        LOGGER.info("Setting flag for System Wipe Notification.", new Object[0]);
        SharedPreferences.Editor editorEdit = prefs.edit();
        editorEdit.putBoolean(KEY_SYSTEM_WIPE, true);
        editorEdit.commit();
    }

    public boolean getSystemWipeNotice() {
        return getPrefs().getBoolean(KEY_SYSTEM_WIPE, false);
    }

    public void clearCacheAndSetImplicitWipeNotice() {
        if (clearCacheAndSetNotice(KEY_IMPLICIT_WIPE_HAPPENED)) {
            LOGGER.info("Cleared MAM enrollment status cache and set implicit wipe notice.", new Object[0]);
        } else {
            LOGGER.info("Failed to clear MAM enrollment status cache and set implicit wipe notice.", new Object[0]);
        }
    }

    public void clearCacheAndSetSystemWipeNotice() {
        if (clearCacheAndSetNotice(KEY_SYSTEM_WIPE)) {
            LOGGER.info("Cleared MAM enrollment status cache and set system wipe notice.", new Object[0]);
        } else {
            LOGGER.info("Failed to clear MAM enrollment status cache and set system wipe notice.", new Object[0]);
        }
    }

    private boolean clearCacheAndSetNotice(String str) {
        return getEditor().clear().putBoolean(str, true).commit();
    }
}
