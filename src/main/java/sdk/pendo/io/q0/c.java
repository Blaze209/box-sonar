package sdk.pendo.io.q0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static final c c;
    public static final c d;
    public static final c e;
    private final b a;
    private final Set<String> b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.PERMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.WHITELIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.BLOCK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.BLACKLIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum b {
        WHITELIST,
        BLACKLIST,
        PERMIT,
        BLOCK
    }

    static {
        b bVar = b.BLOCK;
        c = new c(bVar, new String[0]);
        d = new c(bVar, "none");
        e = new c(b.PERMIT, "none");
    }

    public c(b bVar, String... strArr) {
        if (bVar == null) {
            throw new NullPointerException("ConstraintType cannot be null");
        }
        this.a = bVar;
        this.b = new HashSet(Arrays.asList(strArr));
    }

    public void a(String str) throws sdk.pendo.io.a1.e {
        int i = a.a[this.a.ordinal()];
        if (i == 1 || i == 2) {
            if (!this.b.contains(str)) {
                throw new sdk.pendo.io.a1.e("'" + str + "' is not a permitted algorithm.");
            }
        } else if ((i == 3 || i == 4) && this.b.contains(str)) {
            throw new sdk.pendo.io.a1.e("'" + str + "' is a blocked algorithm.");
        }
    }
}
