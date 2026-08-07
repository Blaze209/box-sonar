package io.split.android.client.shared;

/* JADX INFO: loaded from: classes4.dex */
public enum UserConsent {
    GRANTED,
    DECLINED,
    UNKNOWN;

    /* JADX INFO: renamed from: io.split.android.client.shared.UserConsent$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$shared$UserConsent;

        static {
            int[] iArr = new int[UserConsent.values().length];
            $SwitchMap$io$split$android$client$shared$UserConsent = iArr;
            try {
                iArr[UserConsent.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$shared$UserConsent[UserConsent.GRANTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$shared$UserConsent[UserConsent.DECLINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public int intValue() {
        int i = AnonymousClass1.$SwitchMap$io$split$android$client$shared$UserConsent[ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }
}
