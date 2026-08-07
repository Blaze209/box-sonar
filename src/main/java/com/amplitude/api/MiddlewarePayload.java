package com.amplitude.api;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class MiddlewarePayload {
    public JSONObject event;
    public MiddlewareExtra extra;

    public MiddlewarePayload(JSONObject jSONObject, MiddlewareExtra middlewareExtra) {
        this.event = jSONObject;
        this.extra = middlewareExtra;
    }

    public MiddlewarePayload(JSONObject jSONObject) {
        this(jSONObject, null);
    }
}
