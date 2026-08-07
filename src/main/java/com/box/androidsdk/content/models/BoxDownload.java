package com.box.androidsdk.content.models;

import com.box.androidsdk.content.utils.SdkUtils;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.io.File;

/* JADX INFO: loaded from: classes13.dex */
public class BoxDownload extends BoxJsonObject {
    private static final String FIELD_CONTENT_LENGTH = "content_length";
    private static final String FIELD_CONTENT_TYPE = "content_type";
    private static final String FIELD_DATE = "date";
    private static final String FIELD_END_RANGE = "end_range";
    private static final String FIELD_EXPIRATION = "expiration";
    private static final String FIELD_FILE_NAME = "file_name";
    private static final String FIELD_START_RANGE = "start_range";
    private static final String FIELD_TOTAL_RANGE = "total_range";

    public File getOutputFile() {
        return null;
    }

    public BoxDownload(String str, long j, String str2, String str3, String str4, String str5) {
        if (!SdkUtils.isEmptyString(str)) {
            setFileName(str);
        }
        set(FIELD_CONTENT_LENGTH, Long.valueOf(j));
        if (!SdkUtils.isEmptyString(str2)) {
            set("content_type", str2);
        }
        if (!SdkUtils.isEmptyString(str3)) {
            setContentRange(str3);
        }
        if (!SdkUtils.isEmptyString(str4)) {
            set("date", str4);
        }
        if (SdkUtils.isEmptyString(str5)) {
            return;
        }
        set("expiration", str5);
    }

    protected void setFileName(String str) {
        String strSubstring;
        for (String str2 : str.split(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER)) {
            String strTrim = str2.trim();
            if (strTrim.startsWith("filename=")) {
                if (strTrim.endsWith("\"")) {
                    strSubstring = strTrim.substring(strTrim.indexOf("\"") + 1, strTrim.length() - 1);
                } else {
                    strSubstring = strTrim.substring(9);
                }
                set("file_name", strSubstring);
            }
        }
    }

    protected void setContentRange(String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        int iIndexOf = str.indexOf(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        set(FIELD_START_RANGE, Long.valueOf(Long.parseLong(str.substring(str.indexOf("bytes") + 6, iIndexOf))));
        set(FIELD_END_RANGE, Long.valueOf(Long.parseLong(str.substring(iIndexOf + 1, iLastIndexOf))));
        set(FIELD_TOTAL_RANGE, Long.valueOf(Long.parseLong(str.substring(iLastIndexOf + 1))));
    }

    public String getFileName() {
        return getPropertyAsString("file_name");
    }

    public Long getContentLength() {
        return getPropertyAsLong(FIELD_CONTENT_LENGTH);
    }

    public String getContentType() {
        return getPropertyAsString("content_type");
    }

    public Long getTotalRange() {
        return getPropertyAsLong(FIELD_TOTAL_RANGE);
    }
}
