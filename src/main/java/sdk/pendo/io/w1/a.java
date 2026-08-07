package sdk.pendo.io.w1;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static int[] a(int[] iArr) {
        Arrays.sort(iArr);
        return iArr;
    }

    public static <T> T[] a(T[] tArr, Comparator<? super T> comparator) {
        Arrays.sort(tArr, comparator);
        return tArr;
    }
}
