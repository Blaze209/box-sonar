package sdk.pendo.io.a1;

/* JADX INFO: loaded from: classes4.dex */
public class i {
    public static long a(long j, long j2) {
        long j3 = j + j2;
        if (0 <= ((j ^ j3) & (j2 ^ j3))) {
            return j3;
        }
        throw new ArithmeticException("long overflow adding: " + j + " + " + j2 + " = " + j3);
    }

    public static long b(long j, long j2) {
        long j3 = j - j2;
        if (0 <= ((j ^ j2) & (j ^ j3))) {
            return j3;
        }
        throw new ArithmeticException("long overflow subtracting: " + j + " - " + j2 + " = " + j3);
    }
}
