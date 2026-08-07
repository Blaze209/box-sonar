package sdk.pendo.io.a0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
public abstract class r {
    private static final /* synthetic */ r[] $VALUES;
    public static final r DEFAULT;
    public static final r STRING;

    final enum a extends r {
        a(String str, int i) {
            super(str, i, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        DEFAULT = aVar;
        r rVar = new r("STRING", 1) { // from class: sdk.pendo.io.a0.r.b
            {
                a aVar2 = null;
            }
        };
        STRING = rVar;
        $VALUES = new r[]{aVar, rVar};
    }

    private r(String str, int i) {
        super(str, i);
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) $VALUES.clone();
    }

    /* synthetic */ r(String str, int i, a aVar) {
        this(str, i);
    }
}
