package com.microsoft.identity.common.java.adal.cache;

import com.microsoft.identity.common.java.util.StringUtil;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public class CacheKey implements Serializable {
    static final String FRT_ENTRY_PREFIX = "foci-";
    private static final long serialVersionUID = 8067972995583126404L;
    private String mAuthority;
    private String mClientId;
    private String mFamilyClientId;
    private boolean mIsMultipleResourceRefreshToken;
    private String mResource;
    private String mUserId;

    protected CacheKey() {
    }

    public String toString() {
        if (StringUtil.isNullOrEmpty(this.mFamilyClientId)) {
            return String.format(Locale.US, "%s$%s$%s$%s$%s", this.mAuthority, this.mResource, this.mClientId, this.mIsMultipleResourceRefreshToken ? "y" : "n", this.mUserId);
        }
        return String.format(Locale.US, "%s$%s$%s$%s$%s$%s", this.mAuthority, this.mResource, this.mClientId, this.mIsMultipleResourceRefreshToken ? "y" : "n", this.mUserId, this.mFamilyClientId);
    }

    public static String createCacheKey(String str, String str2, String str3, boolean z, String str4, String str5) {
        if (str == null) {
            throw new IllegalArgumentException("authority");
        }
        if (str3 == null && str5 == null) {
            throw new IllegalArgumentException("both clientId and familyClientId are null");
        }
        CacheKey cacheKey = new CacheKey();
        if (!z) {
            if (str2 == null) {
                throw new IllegalArgumentException("resource");
            }
            cacheKey.mResource = str2;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        cacheKey.mAuthority = lowerCase;
        if (lowerCase.endsWith("/")) {
            String str6 = cacheKey.mAuthority;
            cacheKey.mAuthority = (String) str6.subSequence(0, str6.length() - 1);
        }
        if (str3 != null) {
            cacheKey.mClientId = str3.toLowerCase(Locale.US);
        }
        if (str5 != null) {
            cacheKey.mFamilyClientId = (FRT_ENTRY_PREFIX + str5).toLowerCase(Locale.US);
        }
        cacheKey.mIsMultipleResourceRefreshToken = z;
        if (!StringUtil.isNullOrEmpty(str4)) {
            cacheKey.mUserId = str4.toLowerCase(Locale.US);
        }
        return cacheKey.toString();
    }

    public static String createCacheKeyForRTEntry(String str, String str2, String str3, String str4) {
        return createCacheKey(str, str2, str3, false, str4, null);
    }

    public static String createCacheKeyForMRRT(String str, String str2, String str3) {
        return createCacheKey(str, null, str2, true, str3, null);
    }

    public static String createCacheKeyForFRT(String str, String str2, String str3) {
        return createCacheKey(str, null, null, true, str3, str2);
    }

    public String getAuthority() {
        return this.mAuthority;
    }

    public String getResource() {
        return this.mResource;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public boolean getIsMultipleResourceRefreshToken() {
        return this.mIsMultipleResourceRefreshToken;
    }
}
