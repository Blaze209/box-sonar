package com.yubico.yubikit.core.application;

/* JADX INFO: loaded from: classes3.dex */
public class BadResponseException extends CommandException {
    public BadResponseException(String str) {
        super(str);
    }

    public BadResponseException(String str, Throwable th) {
        super(str, th);
    }
}
