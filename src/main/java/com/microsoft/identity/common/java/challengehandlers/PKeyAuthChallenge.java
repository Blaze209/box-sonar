package com.microsoft.identity.common.java.challengehandlers;

import com.microsoft.identity.common.java.AuthenticationSettings;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.JWSBuilder;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class PKeyAuthChallenge {
    private static final String TAG = "PKeyAuthChallenge";
    private final List<String> mCertAuthorities;
    private final String mContext;
    private final JWSBuilder mJwsBuilder;
    private final String mNonce;
    private final String mSubmitUrl;
    private final String mTenantId;
    private final String mThumbprint;
    private final String mVersion;

    enum RequestField {
        Nonce,
        CertAuthorities,
        Version,
        SubmitUrl,
        Context,
        CertThumbprint,
        TenantId
    }

    public static class PKeyAuthChallengeBuilder {
        private List<String> certAuthorities;
        private String context;
        private boolean jwsBuilder$set;
        private JWSBuilder jwsBuilder$value;
        private String nonce;
        private String submitUrl;
        private String tenantId;
        private String thumbprint;
        private String version;

        PKeyAuthChallengeBuilder() {
        }

        public PKeyAuthChallenge build() {
            JWSBuilder jWSBuilder$default$jwsBuilder = this.jwsBuilder$value;
            if (!this.jwsBuilder$set) {
                jWSBuilder$default$jwsBuilder = PKeyAuthChallenge.$default$jwsBuilder();
            }
            return new PKeyAuthChallenge(this.nonce, this.context, this.certAuthorities, this.thumbprint, this.version, this.submitUrl, jWSBuilder$default$jwsBuilder, this.tenantId);
        }

        public PKeyAuthChallengeBuilder certAuthorities(List<String> list) {
            this.certAuthorities = list;
            return this;
        }

        public PKeyAuthChallengeBuilder context(String str) {
            this.context = str;
            return this;
        }

        public PKeyAuthChallengeBuilder jwsBuilder(JWSBuilder jWSBuilder) {
            this.jwsBuilder$value = jWSBuilder;
            this.jwsBuilder$set = true;
            return this;
        }

        public PKeyAuthChallengeBuilder nonce(String str) {
            this.nonce = str;
            return this;
        }

        public PKeyAuthChallengeBuilder submitUrl(String str) {
            this.submitUrl = str;
            return this;
        }

        public PKeyAuthChallengeBuilder tenantId(String str) {
            this.tenantId = str;
            return this;
        }

        public PKeyAuthChallengeBuilder thumbprint(String str) {
            this.thumbprint = str;
            return this;
        }

        public String toString() {
            return "PKeyAuthChallenge.PKeyAuthChallengeBuilder(nonce=" + this.nonce + ", context=" + this.context + ", certAuthorities=" + this.certAuthorities + ", thumbprint=" + this.thumbprint + ", version=" + this.version + ", submitUrl=" + this.submitUrl + ", jwsBuilder$value=" + this.jwsBuilder$value + ", tenantId=" + this.tenantId + ")";
        }

        public PKeyAuthChallengeBuilder version(String str) {
            this.version = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JWSBuilder $default$jwsBuilder() {
        return new JWSBuilder();
    }

    PKeyAuthChallenge(String str, String str2, List<String> list, String str3, String str4, String str5, JWSBuilder jWSBuilder, String str6) {
        this.mNonce = str;
        this.mContext = str2;
        this.mCertAuthorities = list;
        this.mThumbprint = str3;
        this.mVersion = str4;
        this.mSubmitUrl = str5;
        this.mJwsBuilder = jWSBuilder;
        this.mTenantId = str6;
    }

    public static PKeyAuthChallengeBuilder builder() {
        return new PKeyAuthChallengeBuilder();
    }

    public String getNonce() {
        return this.mNonce;
    }

    public String getContext() {
        return this.mContext;
    }

    public List<String> getCertAuthorities() {
        return this.mCertAuthorities;
    }

    public String getThumbprint() {
        return this.mThumbprint;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public String getSubmitUrl() {
        return this.mSubmitUrl;
    }

    public JWSBuilder getJwsBuilder() {
        return this.mJwsBuilder;
    }

    public String getTenantId() {
        return this.mTenantId;
    }

    public Map<String, String> getChallengeHeader() throws ClientException {
        List<String> list = this.mCertAuthorities;
        if ((list == null || list.size() == 0) && StringUtil.isNullOrEmpty(this.mThumbprint)) {
            Logger.info(TAG + ":getChallengeHeader", "Both cert Authorities and Thumbprint are not provided.Sending a response which is equivalent to no certificate present on client.");
            return getChallengeHeaderWithoutSignedJwt();
        }
        IDeviceCertificateLoader certificateLoader = AuthenticationSettings.INSTANCE.getCertificateLoader();
        if (certificateLoader == null) {
            Logger.warn(TAG + ":getChallengeHeader", "Device Certificate loader is not initialized.");
            return getChallengeHeaderWithoutSignedJwt();
        }
        IDeviceCertificate iDeviceCertificateLoadCertificate = certificateLoader.loadCertificate(this.mTenantId);
        if (iDeviceCertificateLoadCertificate == null) {
            Logger.warn(TAG + ":getChallengeHeader", "Device Certificate not found.");
            return getChallengeHeaderWithoutSignedJwt();
        }
        if (iDeviceCertificateLoadCertificate.isValidIssuer(this.mCertAuthorities)) {
            Logger.info(TAG + ":getChallengeHeader", "Found a certificate matching the provided authority.");
            return getChallengeHeaderWithSignedJwt(iDeviceCertificateLoadCertificate);
        }
        return getChallengeHeaderWithoutSignedJwt();
    }

    private Map<String, String> getChallengeHeaderWithoutSignedJwt() {
        HashMap map = new HashMap();
        map.put("Authorization", String.format("%s Context=\"%s\",Version=\"%s\"", "PKeyAuth", this.mContext, "1.0"));
        return map;
    }

    private Map<String, String> getChallengeHeaderWithSignedJwt(IDeviceCertificate iDeviceCertificate) throws ClientException {
        if (!StringUtil.equalsIgnoreCase(this.mVersion, "1.0")) {
            Logger.warn(TAG + ":getChallengeHeaderWithSignedJwt", "PKeyAuth version mismatch, server provides: " + this.mVersion + "We support: 1.0Proceed anyway with 1.0");
        }
        String strGenerateSignedJWT = this.mJwsBuilder.generateSignedJWT(this.mNonce, this.mSubmitUrl, iDeviceCertificate);
        Logger.info(TAG + ":getChallengeHeaderWithSignedJwt", "Generated a signed challenge response.");
        HashMap map = new HashMap();
        map.put("Authorization", String.format("%s AuthToken=\"%s\",Context=\"%s\",Version=\"%s\"", "PKeyAuth", strGenerateSignedJWT, this.mContext, "1.0"));
        return map;
    }
}
