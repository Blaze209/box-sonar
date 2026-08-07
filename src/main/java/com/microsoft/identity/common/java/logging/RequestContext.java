package com.microsoft.identity.common.java.logging;

import com.google.gson.Gson;
import java.util.HashMap;

/* JADX INFO: loaded from: classes14.dex */
public class RequestContext extends HashMap<String, String> implements IRequestContext {
    private static final Gson mGson = new Gson();
    private static final long serialVersionUID = -2239604897244277047L;

    @Override // com.microsoft.identity.common.java.logging.IRequestContext
    public String toJsonString() {
        return mGson.toJson(this);
    }
}
