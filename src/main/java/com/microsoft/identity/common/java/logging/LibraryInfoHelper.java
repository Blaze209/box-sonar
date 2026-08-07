package com.microsoft.identity.common.java.logging;

import com.microsoft.identity.common.java.util.StringUtil;

/* JADX INFO: loaded from: classes14.dex */
public class LibraryInfoHelper {
    protected static final String NOT_SET = "NOT_SET";
    private static final String TAG = "LibraryInfoHelper";

    public static String getLibraryName() {
        String str = DiagnosticContext.INSTANCE.getRequestContext().get("x-client-SKU");
        if (!StringUtil.isNullOrEmpty(str)) {
            return str;
        }
        Logger.warn(TAG + ":getLibraryName", "Product is not set.", null);
        return NOT_SET;
    }

    public static String getLibraryVersion() {
        String str = DiagnosticContext.INSTANCE.getRequestContext().get("x-client-Ver");
        if (!StringUtil.isNullOrEmpty(str)) {
            return str;
        }
        Logger.warn(TAG + ":getLibraryVersion", "Product version is not set.", null);
        return "1.5.9-default";
    }
}
