package com.microsoft.identity.common.internal.broker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.util.LruCache;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.telemetry.events.ContentProviderCallEvent;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;

/* JADX INFO: loaded from: classes14.dex */
public class IntuneMAMEnrollmentIdGateway {
    private static final int CACHE_SIZE = 10;
    private static final long CACHE_TTL_FOR_NULLS_MS = 1500;
    private static final long CACHE_TTL_MS = 2000;
    private static String CONTENT_URI = "content://com.microsoft.intune.mam.policy/mamserviceenrollments";
    private static String[] PROJECTION = {"EnrollmentId"};
    private static String SELECTION = "WHERE PackageName = ? AND Identity = ?";
    private static final String TAG = "IntuneMAMEnrollmentIdGateway";
    static IntuneMAMEnrollmentIdGateway sInstance;
    private final LruCache<CacheKey, CacheEntry> mIdCache = new LruCache<>(10);

    private static final class CacheKey {
        public final String packageName;
        public final String userId;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) obj;
            String str = this.userId;
            String str2 = cacheKey.userId;
            if (str != null ? !str.equals(str2) : str2 != null) {
                return false;
            }
            String str3 = this.packageName;
            String str4 = cacheKey.packageName;
            return str3 != null ? str3.equals(str4) : str4 == null;
        }

        public int hashCode() {
            String str = this.userId;
            int iHashCode = str == null ? 43 : str.hashCode();
            String str2 = this.packageName;
            return ((iHashCode + 59) * 59) + (str2 != null ? str2.hashCode() : 43);
        }

        public CacheKey(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("userId is marked non-null but is null");
            }
            if (str2 == null) {
                throw new NullPointerException("packageName is marked non-null but is null");
            }
            this.userId = str.toLowerCase();
            this.packageName = str2.toLowerCase();
        }
    }

    private static final class CacheEntry {
        public final String enrollmentId;
        public final long timestampMs = SystemClock.elapsedRealtime();

        public CacheEntry(String str) {
            this.enrollmentId = str;
        }

        public boolean expired() {
            return SystemClock.elapsedRealtime() - this.timestampMs > (this.enrollmentId == null ? 1500L : 2000L);
        }
    }

    public static synchronized IntuneMAMEnrollmentIdGateway getInstance() {
        if (sInstance == null) {
            sInstance = new IntuneMAMEnrollmentIdGateway();
        }
        return sInstance;
    }

    private IntuneMAMEnrollmentIdGateway() {
    }

    public synchronized String getEnrollmentId(Context context, String str, String str2) {
        CacheEntry cacheEntry;
        CacheKey cacheKey = new CacheKey(str, str2);
        cacheEntry = this.mIdCache.get(cacheKey);
        if (cacheEntry == null || cacheEntry.expired()) {
            cacheEntry = new CacheEntry(callContentProvider(context, str, str2));
            this.mIdCache.put(cacheKey, cacheEntry);
        }
        return cacheEntry.enrollmentId;
    }

    private String callContentProvider(Context context, String str, String str2) {
        String[] strArr = {str2, str};
        Uri uri = Uri.parse(CONTENT_URI);
        ContentProviderCallEvent contentProviderCallEvent = new ContentProviderCallEvent(CONTENT_URI);
        String string = null;
        try {
            Cursor cursorQuery = MAMContentResolverManagement.query(context.getContentResolver(), uri, PROJECTION, SELECTION, strArr, null);
            if (cursorQuery == null) {
                Logger.verbose("IntuneMAMEnrollmentIdGateway:callContentProvider", "Cursor was null.  The content provider may not be available. ");
            } else {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
                cursorQuery.close();
            }
        } catch (Exception e) {
            Logger.warn("IntuneMAMEnrollmentIdGateway:callContentProvider", "Unable to query enrollment id: " + e.getMessage());
        }
        contentProviderCallEvent.put(TelemetryEventStrings.Key.ENROLLMENT_ID_NULL, String.valueOf(StringUtil.isNullOrEmpty(string)));
        contentProviderCallEvent.put(TelemetryEventStrings.Key.END_TIME, String.valueOf(System.currentTimeMillis()));
        Telemetry.emit(contentProviderCallEvent);
        return string;
    }
}
