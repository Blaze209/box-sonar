package io.split.android.client.network;

/* JADX INFO: loaded from: classes4.dex */
class SplitBasicAuthenticator extends SplitAuthenticator {
    private static final String PROXY_AUTHORIZATION_HEADER = "Proxy-Authorization";
    private final Base64Encoder mBase64Encoder;
    private final String mPassword;
    private final String mUsername;

    SplitBasicAuthenticator(String username, String password, Base64Encoder base64Encoder) {
        this.mUsername = username;
        this.mPassword = password;
        this.mBase64Encoder = base64Encoder;
    }

    @Override // io.split.android.client.network.Authenticator
    public SplitAuthenticatedRequest authenticate(SplitAuthenticatedRequest request) {
        request.setHeader("Proxy-Authorization", basic(this.mUsername, this.mPassword));
        return request;
    }

    private String basic(String username, String password) {
        return "Basic " + this.mBase64Encoder.encode(username + ":" + password);
    }
}
