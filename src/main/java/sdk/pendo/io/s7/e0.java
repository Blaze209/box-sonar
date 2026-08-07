package sdk.pendo.io.s7;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class e0 {
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
