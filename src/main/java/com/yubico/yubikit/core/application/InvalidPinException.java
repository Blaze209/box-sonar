package com.yubico.yubikit.core.application;

/* JADX INFO: loaded from: classes3.dex */
public class InvalidPinException extends CommandException {
    private final int attemptsRemaining;

    public InvalidPinException(int i, String str) {
        super(str);
        this.attemptsRemaining = i;
    }

    public InvalidPinException(int i) {
        this(i, "Invalid PIN/PUK. Remaining attempts: " + i);
    }

    public int getAttemptsRemaining() {
        return this.attemptsRemaining;
    }
}
