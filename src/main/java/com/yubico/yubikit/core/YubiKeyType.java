package com.yubico.yubikit.core;

/* JADX INFO: loaded from: classes3.dex */
public enum YubiKeyType {
    YKS("YubiKey Standard"),
    NEO("YubiKey NEO"),
    SKY("Security Key by Yubico"),
    YKP("YubiKey Plus"),
    YK4("YubiKey");

    public final String name;

    YubiKeyType(String str) {
        this.name = str;
    }
}
