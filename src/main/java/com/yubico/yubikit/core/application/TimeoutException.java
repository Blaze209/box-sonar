package com.yubico.yubikit.core.application;

/* JADX INFO: loaded from: classes3.dex */
public class TimeoutException extends CommandException {
    public TimeoutException(String str) {
        super(str);
    }

    public TimeoutException(String str, Throwable th) {
        super(str, th);
    }
}
