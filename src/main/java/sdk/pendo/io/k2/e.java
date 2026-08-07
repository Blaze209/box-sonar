package sdk.pendo.io.k2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.m;
import sdk.pendo.io.e2.n;
import sdk.pendo.io.e2.u;
import sdk.pendo.io.e2.v;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001a\u0010\u0005\u001a\u00020\t*\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\u0006H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\n*\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0006H\u0002\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u0006H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\t*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\n*\u00020\u0013\u001a\u0010\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007\"\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016\"\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/e2/u;", "", "headerName", "", "Lsdk/pendo/io/e2/h;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/d;", "", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "", "", "c", "", "prefix", "b", "Lsdk/pendo/io/e2/n;", "Lsdk/pendo/io/e2/v;", "url", "headers", "Lsdk/pendo/io/e2/d0;", "response", "Lsdk/pendo/io/s2/g;", "Lsdk/pendo/io/s2/g;", "QUOTED_STRING_DELIMITERS", "TOKEN_DELIMITERS", "okhttp"}, k = 2, mv = {1, 8, 0})
public final class e {
    private static final sdk.pendo.io.s2.g a;
    private static final sdk.pendo.io.s2.g b;

    static {
        sdk.pendo.io.s2.g.Companion companion = sdk.pendo.io.s2.g.INSTANCE;
        a = companion.b("\"\\");
        b = companion.b("\t ,=");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "No longer supported", replaceWith = @ReplaceWith(expression = "response.promisesBody()", imports = {}))
    public static final boolean a(d0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return b(response);
    }

    public static final boolean b(d0 d0Var) {
        Intrinsics.checkNotNullParameter(d0Var, "<this>");
        if (Intrinsics.areEqual(d0Var.getRequest().getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String(), "HEAD")) {
            return false;
        }
        int code = d0Var.getCode();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && sdk.pendo.io.f2.b.a(d0Var) == -1 && !StringsKt.equals("chunked", d0.a(d0Var, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    private static final boolean c(sdk.pendo.io.s2.d dVar) throws EOFException {
        boolean z = false;
        while (!dVar.exhausted()) {
            byte bA = dVar.a(0L);
            if (bA == 44) {
                dVar.readByte();
                z = true;
            } else {
                if (bA != 32 && bA != 9) {
                    break;
                }
                dVar.readByte();
            }
        }
        return z;
    }

    public static final List<sdk.pendo.io.e2.h> a(u uVar, String headerName) {
        Intrinsics.checkNotNullParameter(uVar, "<this>");
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = uVar.size();
        for (int i = 0; i < size; i++) {
            if (StringsKt.equals(headerName, uVar.a(i), true)) {
                try {
                    a(new sdk.pendo.io.s2.d().writeUtf8(uVar.b(i)), arrayList);
                } catch (EOFException e) {
                    sdk.pendo.io.n2.h.INSTANCE.d().a("Unable to parse challenge", 5, e);
                }
            }
        }
        return arrayList;
    }

    private static final String b(sdk.pendo.io.s2.d dVar) {
        long jB = dVar.b(b);
        if (jB == -1) {
            jB = dVar.getSize();
        }
        if (jB != 0) {
            return dVar.readUtf8(jB);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0088  */
    /* JADX WARN: Code duplicated, block: B:35:0x009b  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bf A[EDGE_INSN: B:59:0x00bf->B:48:0x00bf BREAK  A[LOOP:2: B:22:0x0076->B:47:0x00bd], SYNTHETIC] */
    private static final void a(sdk.pendo.io.s2.d dVar, List<sdk.pendo.io.e2.h> list) throws EOFException {
        String strB;
        while (true) {
            String strB2 = null;
            while (true) {
                if (strB2 == null) {
                    c(dVar);
                    strB2 = b(dVar);
                    if (strB2 == null) {
                        return;
                    }
                }
                boolean zC = c(dVar);
                String strB3 = b(dVar);
                if (strB3 == null) {
                    if (dVar.exhausted()) {
                        list.add(new sdk.pendo.io.e2.h(strB2, MapsKt.emptyMap()));
                        return;
                    }
                    return;
                }
                int iA = sdk.pendo.io.f2.b.a(dVar, (byte) 61);
                boolean zC2 = c(dVar);
                if (zC || !(zC2 || dVar.exhausted())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iA2 = iA + sdk.pendo.io.f2.b.a(dVar, (byte) 61);
                    while (true) {
                        if (strB3 != null) {
                            if (iA2 != 0) {
                                break;
                                break;
                            }
                            if (iA2 <= 1) {
                                return;
                            }
                            if (a(dVar, CtapException.ERR_INVALID_CREDENTIAL)) {
                                strB = a(dVar);
                            } else {
                                strB = b(dVar);
                            }
                            if (strB != null) {
                                return;
                            }
                            if (c(dVar)) {
                            }
                            strB3 = null;
                        } else {
                            strB3 = b(dVar);
                            if (!c(dVar)) {
                                iA2 = sdk.pendo.io.f2.b.a(dVar, (byte) 61);
                                if (iA2 != 0) {
                                    break;
                                }
                                if (iA2 <= 1 || c(dVar)) {
                                    return;
                                }
                                if (a(dVar, CtapException.ERR_INVALID_CREDENTIAL)) {
                                    strB = a(dVar);
                                } else {
                                    strB = b(dVar);
                                }
                                if (strB != null || ((String) linkedHashMap.put(strB3, strB)) != null) {
                                    return;
                                }
                                if (c(dVar) && !dVar.exhausted()) {
                                    return;
                                } else {
                                    strB3 = null;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    list.add(new sdk.pendo.io.e2.h(strB2, linkedHashMap));
                    strB2 = strB3;
                } else {
                    Map mapSingletonMap = Collections.singletonMap(null, strB3 + StringsKt.repeat(SimpleComparison.EQUAL_TO_OPERATION, iA));
                    Intrinsics.checkNotNullExpressionValue(mapSingletonMap, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
                    list.add(new sdk.pendo.io.e2.h(strB2, mapSingletonMap));
                }
            }
        }
    }

    private static final String a(sdk.pendo.io.s2.d dVar) throws EOFException {
        if (dVar.readByte() != 34) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        sdk.pendo.io.s2.d dVar2 = new sdk.pendo.io.s2.d();
        while (true) {
            long jB = dVar.b(a);
            if (jB == -1) {
                return null;
            }
            if (dVar.a(jB) == 34) {
                dVar2.a(dVar, jB);
                dVar.readByte();
                return dVar2.readUtf8();
            }
            if (dVar.getSize() == jB + 1) {
                return null;
            }
            dVar2.a(dVar, jB);
            dVar.readByte();
            dVar2.a(dVar, 1L);
        }
    }

    public static final void a(n nVar, v url, u headers) {
        Intrinsics.checkNotNullParameter(nVar, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (nVar == n.b) {
            return;
        }
        List<m> listA = m.INSTANCE.a(url, headers);
        if (listA.isEmpty()) {
            return;
        }
        nVar.a(url, listA);
    }

    private static final boolean a(sdk.pendo.io.s2.d dVar, byte b2) {
        return !dVar.exhausted() && dVar.a(0L) == b2;
    }
}
