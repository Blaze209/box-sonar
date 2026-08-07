package com.yubico.yubikit.core.smartcard;

import com.yubico.yubikit.core.application.CommandException;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class ApduException extends CommandException {
    private static final long serialVersionUID = 1;
    private final short sw;

    public ApduException(short s) {
        this(s, String.format(Locale.ROOT, "APDU error: 0x%04x", Short.valueOf(s)));
    }

    public ApduException(short s, String str) {
        super(str);
        this.sw = s;
    }

    public short getSw() {
        return this.sw;
    }
}
