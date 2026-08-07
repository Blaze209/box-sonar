package com.microsoft.identity.common.internal.logging;

import com.google.gson.Gson;
import java.util.HashMap;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class RequestContext extends HashMap<String, String> implements IRequestContext {
    private static final String TAG = "RequestContext";
    private static final Gson mGson = new Gson();
    private static boolean sLogDeprecationWarning = true;

    @Override // com.microsoft.identity.common.java.logging.IRequestContext
    public String toJsonString() {
        if (sLogDeprecationWarning) {
            sLogDeprecationWarning = false;
            com.microsoft.identity.common.logging.Logger.warn(TAG + ":toJsonString", "This class is deprecated. Migrate usage to: com.microsoft.identity.common.logging.RequestContext");
        }
        return mGson.toJson(this);
    }
}
