package com.microsoft.identity.common.java.jwt;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes14.dex */
public final class JwtRequestHeader extends AbstractJwtRequest {
    public static final String ALG_VALUE_HS256 = "HS256";
    public static final String ALG_VALUE_RS256 = "RS256";
    private static final String JWT_VALUE = "JWT";

    @SerializedName("alg")
    private String mAlg;

    @SerializedName(AbstractJwtRequest.ClaimNames.CTX)
    private String mCtx;

    @SerializedName("kid")
    private String mKId;

    @SerializedName(AbstractJwtRequest.ClaimNames.KDF_VER)
    private int mKdfVersion = 1;

    @SerializedName("typ")
    private String mType;

    public void setAlg(String str) {
        this.mAlg = str;
    }

    public void setCtx(String str) {
        this.mCtx = str;
    }

    public void setKId(String str) {
        this.mKId = str;
    }

    public void setKdfVersion(int i) {
        this.mKdfVersion = i;
    }

    public String getType() {
        return this.mType;
    }

    public String getCtx() {
        return this.mCtx;
    }

    public String getAlg() {
        return this.mAlg;
    }

    public String getKId() {
        return this.mKId;
    }

    public int getKdfVersion() {
        return this.mKdfVersion;
    }

    public void setType() {
        this.mType = "JWT";
    }
}
