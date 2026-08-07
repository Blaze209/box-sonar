package sdk.pendo.io.a0;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
public abstract class s implements t {
    private static final /* synthetic */ s[] $VALUES;
    public static final s BIG_DECIMAL;
    public static final s DOUBLE;
    public static final s LAZILY_PARSED_NUMBER;
    public static final s LONG_OR_DOUBLE;

    final enum a extends s {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // sdk.pendo.io.a0.t
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(sdk.pendo.io.h0.a aVar) {
            return Double.valueOf(aVar.m());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        DOUBLE = aVar;
        s sVar = new s("LAZILY_PARSED_NUMBER", 1) { // from class: sdk.pendo.io.a0.s.b
            {
                a aVar2 = null;
            }

            @Override // sdk.pendo.io.a0.t
            public Number a(sdk.pendo.io.h0.a aVar2) {
                return new sdk.pendo.io.c0.f(aVar2.r());
            }
        };
        LAZILY_PARSED_NUMBER = sVar;
        s sVar2 = new s("LONG_OR_DOUBLE", 2) { // from class: sdk.pendo.io.a0.s.c
            {
                a aVar2 = null;
            }

            @Override // sdk.pendo.io.a0.t
            public Number a(sdk.pendo.io.h0.a aVar2) throws IOException {
                String strR = aVar2.r();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(strR));
                    } catch (NumberFormatException e) {
                        throw new m("Cannot parse " + strR + "; at path " + aVar2.h(), e);
                    }
                } catch (NumberFormatException unused) {
                    Double dValueOf = Double.valueOf(strR);
                    if ((dValueOf.isInfinite() || dValueOf.isNaN()) && !aVar2.j()) {
                        throw new sdk.pendo.io.h0.d("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar2.h());
                    }
                    return dValueOf;
                }
            }
        };
        LONG_OR_DOUBLE = sVar2;
        s sVar3 = new s("BIG_DECIMAL", 3) { // from class: sdk.pendo.io.a0.s.d
            {
                a aVar2 = null;
            }

            @Override // sdk.pendo.io.a0.t
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(sdk.pendo.io.h0.a aVar2) throws IOException {
                String strR = aVar2.r();
                try {
                    return new BigDecimal(strR);
                } catch (NumberFormatException e) {
                    throw new m("Cannot parse " + strR + "; at path " + aVar2.h(), e);
                }
            }
        };
        BIG_DECIMAL = sVar3;
        $VALUES = new s[]{aVar, sVar, sVar2, sVar3};
    }

    private s(String str, int i) {
        super(str, i);
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) $VALUES.clone();
    }

    /* synthetic */ s(String str, int i, a aVar) {
        this(str, i);
    }
}
