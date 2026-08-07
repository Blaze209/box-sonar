package com.yubico.yubikit.core;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbInterface {
    public static final int CCID = 4;
    public static final int FIDO = 2;
    public static final int OTP = 1;

    private UsbInterface() {
    }

    public enum Mode {
        OTP((byte) 0, 1),
        CCID((byte) 1, 4),
        OTP_CCID((byte) 2, 5),
        FIDO((byte) 3, 2),
        OTP_FIDO((byte) 4, 3),
        FIDO_CCID((byte) 5, 6),
        OTP_FIDO_CCID((byte) 6, 7);

        public final int interfaces;
        public final byte value;

        Mode(byte b, int i) {
            this.value = b;
            this.interfaces = i;
        }

        public static Mode getMode(int i) {
            for (Mode mode : values()) {
                if (mode.interfaces == i) {
                    return mode;
                }
            }
            throw new IllegalArgumentException("Invalid interfaces for Mode");
        }
    }
}
