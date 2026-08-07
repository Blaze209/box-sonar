package androidx.profileinstaller;

import com.yubico.yubikit.core.fido.CtapException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes9.dex */
public class ProfileVersion {
    public static final int MIN_SUPPORTED_SDK = 24;
    static final byte[] V015_S = {CtapException.ERR_NOT_ALLOWED, CtapException.ERR_PIN_INVALID, CtapException.ERR_PIN_NOT_SET, 0};
    static final byte[] V010_P = {CtapException.ERR_NOT_ALLOWED, CtapException.ERR_PIN_INVALID, CtapException.ERR_NOT_ALLOWED, 0};
    static final byte[] V009_O_MR1 = {CtapException.ERR_NOT_ALLOWED, CtapException.ERR_NOT_ALLOWED, CtapException.ERR_REQUEST_TOO_LARGE, 0};
    static final byte[] V005_O = {CtapException.ERR_NOT_ALLOWED, CtapException.ERR_NOT_ALLOWED, CtapException.ERR_PIN_NOT_SET, 0};
    static final byte[] V001_N = {CtapException.ERR_NOT_ALLOWED, CtapException.ERR_NOT_ALLOWED, CtapException.ERR_PIN_INVALID, 0};
    static final byte[] METADATA_V001_N = {CtapException.ERR_NOT_ALLOWED, CtapException.ERR_NOT_ALLOWED, CtapException.ERR_PIN_INVALID, 0};
    static final byte[] METADATA_V002 = {CtapException.ERR_NOT_ALLOWED, CtapException.ERR_NOT_ALLOWED, CtapException.ERR_PIN_BLOCKED, 0};

    private ProfileVersion() {
    }

    static String dexKeySeparator(byte[] bArr) {
        return (Arrays.equals(bArr, V001_N) || Arrays.equals(bArr, V005_O)) ? ":" : "!";
    }
}
