package com.google.firebase.remoteconfig;

/* JADX INFO: loaded from: classes14.dex */
public class FirebaseRemoteConfigClientException extends FirebaseRemoteConfigException {
    public FirebaseRemoteConfigClientException(String str) {
        super(str);
    }

    public FirebaseRemoteConfigClientException(String str, Throwable th) {
        super(str, th);
    }

    public FirebaseRemoteConfigClientException(String str, FirebaseRemoteConfigException.Code code) {
        super(str, code);
    }

    public FirebaseRemoteConfigClientException(String str, Throwable th, FirebaseRemoteConfigException.Code code) {
        super(str, th, code);
    }
}
