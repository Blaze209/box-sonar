package sdk.pendo.io;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\n"}, d2 = {"Lsdk/pendo/io/JWT;", "", "()V", "setAccountData", "", "jwt", "", "signingKeyName", "setVisitorData", "startSession", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class JWT {
    public final void setAccountData(String jwt, String signingKeyName) {
        PendoInternal.b(jwt, signingKeyName);
    }

    public final void setVisitorData(String jwt, String signingKeyName) {
        PendoInternal.c(jwt, signingKeyName);
    }

    public final void startSession(String jwt, String signingKeyName) {
        PendoInternal.e(jwt, signingKeyName);
    }
}
