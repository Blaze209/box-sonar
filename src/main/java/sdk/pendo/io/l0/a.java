package sdk.pendo.io.l0;

import com.google.common.base.Ascii;
import com.yubico.yubikit.core.fido.CtapException;
import sdk.pendo.io.a1.j;

/* JADX INFO: loaded from: classes4.dex */
public class a extends b {
    static final byte[] k = {Ascii.CR, 10};
    private static final byte[] l = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, CtapException.ERR_NOT_ALLOWED, CtapException.ERR_PIN_INVALID, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, CtapException.ERR_UNSUPPORTED_OPTION, CtapException.ERR_USER_ACTION_TIMEOUT};
    private static final byte[] m = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, CtapException.ERR_NOT_ALLOWED, CtapException.ERR_PIN_INVALID, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, CtapException.ERR_KEEPALIVE_CANCEL, 95};
    private static final byte[] n = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, CtapException.ERR_INVALID_SUBCOMMAND, -1, CtapException.ERR_INVALID_SUBCOMMAND, -1, 63, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, CtapException.ERR_ACTION_TIMEOUT, CtapException.ERR_UP_REQUIRED, CtapException.ERR_UV_BLOCKED, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, 25, -1, -1, -1, -1, 63, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, CtapException.ERR_PROCESSING, CtapException.ERR_INVALID_CREDENTIAL, CtapException.ERR_USER_ACTION_PENDING, CtapException.ERR_OPERATION_PENDING, CtapException.ERR_NO_OPERATIONS, CtapException.ERR_UNSUPPORTED_ALGORITHM, CtapException.ERR_OPERATION_DENIED, CtapException.ERR_KEY_STORE_FULL, CtapException.ERR_NOT_BUSY, CtapException.ERR_NO_OPERATION_PENDING, CtapException.ERR_UNSUPPORTED_OPTION, CtapException.ERR_INVALID_OPTION, CtapException.ERR_KEEPALIVE_CANCEL, CtapException.ERR_NO_CREDENTIALS, CtapException.ERR_USER_ACTION_TIMEOUT, CtapException.ERR_NOT_ALLOWED, CtapException.ERR_PIN_INVALID, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID};
    private final byte[] f;
    private final byte[] g;
    private final byte[] h;
    private final int i;
    private final int j;

    public a() {
        this(0);
    }

    @Override // sdk.pendo.io.l0.b
    void a(byte[] bArr, int i, int i2, b.a aVar) {
        byte b;
        if (aVar.f) {
            return;
        }
        if (i2 < 0) {
            aVar.f = true;
        }
        int i3 = 0;
        while (i3 < i2) {
            byte[] bArrA = a(this.i, aVar);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                aVar.f = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = n;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i5 = (aVar.h + 1) % 4;
                    aVar.h = i5;
                    int i6 = (aVar.a << 6) + b;
                    aVar.a = i6;
                    if (i5 == 0) {
                        int i7 = aVar.d;
                        bArrA[i7] = (byte) ((i6 >> 16) & 255);
                        bArrA[i7 + 1] = (byte) ((i6 >> 8) & 255);
                        aVar.d = i7 + 3;
                        bArrA[i7 + 2] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!aVar.f || aVar.h == 0) {
            return;
        }
        byte[] bArrA2 = a(this.i, aVar);
        int i8 = aVar.h;
        if (i8 != 1) {
            if (i8 == 2) {
                int i9 = aVar.a >> 4;
                aVar.a = i9;
                int i10 = aVar.d;
                aVar.d = i10 + 1;
                bArrA2[i10] = (byte) (i9 & 255);
                return;
            }
            if (i8 != 3) {
                throw new IllegalStateException("Impossible modulus " + aVar.h);
            }
            int i11 = aVar.a;
            int i12 = i11 >> 2;
            aVar.a = i12;
            int i13 = aVar.d;
            bArrA2[i13] = (byte) ((i11 >> 10) & 255);
            aVar.d = i13 + 2;
            bArrA2[i13 + 1] = (byte) (i12 & 255);
        }
    }

    @Override // sdk.pendo.io.l0.b
    void b(byte[] bArr, int i, int i2, b.a aVar) {
        if (aVar.f) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                byte[] bArrA = a(this.j, aVar);
                int i4 = (aVar.h + 1) % 3;
                aVar.h = i4;
                int i5 = i + 1;
                int i6 = bArr[i];
                if (i6 < 0) {
                    i6 += 256;
                }
                int i7 = (aVar.a << 8) + i6;
                aVar.a = i7;
                if (i4 == 0) {
                    int i8 = aVar.d;
                    byte[] bArr2 = this.f;
                    bArrA[i8] = bArr2[(i7 >> 18) & 63];
                    bArrA[i8 + 1] = bArr2[(i7 >> 12) & 63];
                    int i9 = i8 + 3;
                    bArrA[i8 + 2] = bArr2[(i7 >> 6) & 63];
                    int i10 = i8 + 4;
                    aVar.d = i10;
                    bArrA[i9] = bArr2[i7 & 63];
                    int i11 = aVar.g + 4;
                    aVar.g = i11;
                    int i12 = this.d;
                    if (i12 > 0 && i12 <= i11) {
                        byte[] bArr3 = this.h;
                        System.arraycopy(bArr3, 0, bArrA, i10, bArr3.length);
                        aVar.d += this.h.length;
                        aVar.g = 0;
                    }
                }
                i3++;
                i = i5;
            }
            return;
        }
        aVar.f = true;
        if (aVar.h == 0 && this.d == 0) {
            return;
        }
        byte[] bArrA2 = a(this.j, aVar);
        int i13 = aVar.d;
        int i14 = aVar.h;
        if (i14 != 0) {
            if (i14 == 1) {
                byte[] bArr4 = this.f;
                int i15 = aVar.a;
                bArrA2[i13] = bArr4[(i15 >> 2) & 63];
                int i16 = i13 + 2;
                aVar.d = i16;
                bArrA2[i13 + 1] = bArr4[(i15 << 4) & 63];
                if (bArr4 == l) {
                    bArrA2[i16] = 61;
                    aVar.d = i13 + 4;
                    bArrA2[i13 + 3] = 61;
                }
            } else {
                if (i14 != 2) {
                    throw new IllegalStateException("Impossible modulus " + aVar.h);
                }
                byte[] bArr5 = this.f;
                int i17 = aVar.a;
                bArrA2[i13] = bArr5[(i17 >> 10) & 63];
                bArrA2[i13 + 1] = bArr5[(i17 >> 4) & 63];
                int i18 = i13 + 3;
                aVar.d = i18;
                bArrA2[i13 + 2] = bArr5[(i17 << 2) & 63];
                if (bArr5 == l) {
                    aVar.d = i13 + 4;
                    bArrA2[i18] = 61;
                }
            }
        }
        int i19 = aVar.g;
        int i20 = aVar.d;
        int i21 = i19 + (i20 - i13);
        aVar.g = i21;
        if (this.d <= 0 || i21 <= 0) {
            return;
        }
        byte[] bArr6 = this.h;
        System.arraycopy(bArr6, 0, bArrA2, i20, bArr6.length);
        aVar.d += this.h.length;
    }

    public a(int i) {
        this(i, k);
    }

    @Override // sdk.pendo.io.l0.b
    protected boolean a(byte b) {
        if (b < 0) {
            return false;
        }
        byte[] bArr = this.g;
        return b < bArr.length && bArr[b] != -1;
    }

    public a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0046  */
    public a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.g = n;
        if (bArr == null) {
            this.j = 4;
            this.h = null;
        } else {
            if (a(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + j.a(bArr) + "]");
            }
            if (i > 0) {
                this.j = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.h = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.j = 4;
                this.h = null;
            }
        }
        this.i = this.j - 1;
        this.f = z ? m : l;
    }
}
