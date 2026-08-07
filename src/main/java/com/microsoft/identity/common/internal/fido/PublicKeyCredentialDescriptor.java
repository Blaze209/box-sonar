package com.microsoft.identity.common.internal.fido;

import com.squareup.moshi.Json;

/* JADX INFO: loaded from: classes14.dex */
public class PublicKeyCredentialDescriptor {

    @Json(name = "id")
    public final String id;

    @Json(name = "type")
    public final String type;

    public String getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    PublicKeyCredentialDescriptor(String str, String str2) {
        this.type = str;
        this.id = str2;
    }
}
