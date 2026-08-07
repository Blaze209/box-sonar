package sdk.pendo.io.l1;

import com.box.android.data.api.models.MetadataReservedKeys;
import com.microsoft.identity.client.internal.MsalUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class i {
    private final LinkedList<sdk.pendo.io.d1.l> a;
    private final sdk.pendo.io.e1.a b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[sdk.pendo.io.g1.a.values().length];
            a = iArr;
            try {
                iArr[sdk.pendo.io.g1.a.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[sdk.pendo.io.g1.a.PATH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private i(String str, LinkedList<sdk.pendo.io.d1.l> linkedList) {
        this(new sdk.pendo.io.e1.a(str), linkedList);
    }

    private sdk.pendo.io.e1.g a() {
        p pVarB = b();
        return new f(pVarB, pVarB.a().equals(MetadataReservedKeys.PREFIX));
    }

    private boolean b(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }

    private boolean c(k kVar) {
        sdk.pendo.io.e1.a aVar;
        int i;
        if (this.b.a('.') && this.b.d('.')) {
            kVar.a(l.a());
            aVar = this.b;
            i = 2;
        } else {
            if (!this.b.c()) {
                throw new sdk.pendo.io.d1.f("Path must not end with a '.");
            }
            aVar = this.b;
            i = 1;
        }
        aVar.d(i);
        if (this.b.a('.')) {
            throw new sdk.pendo.io.d1.f("Character '.' on position " + this.b.h() + " is not valid.");
        }
        return e(kVar);
    }

    private boolean d(k kVar) {
        int iA;
        int iA2;
        if (!this.b.a(AbstractJsonLexerKt.BEGIN_LIST) && !this.b.f('?')) {
            return false;
        }
        int iH = this.b.h();
        int iB = this.b.b('?');
        if (iB == -1 || (iA = this.b.a(iB, '(')) == -1 || (iA2 = this.b.a(iA, true, true)) == -1 || !this.b.d(iA2, AbstractJsonLexerKt.END_LIST)) {
            return false;
        }
        int iA3 = this.b.a(iA2, AbstractJsonLexerKt.END_LIST) + 1;
        kVar.a(l.a(sdk.pendo.io.f1.d.a(this.b.a(iH, iA3).toString())));
        this.b.k(iA3);
        return this.b.b() || e(kVar);
    }

    private boolean e(k kVar) {
        boolean zH;
        char cA = this.b.a();
        String str = "Could not parse token starting at position " + this.b.h();
        if (cA == '*') {
            zH = h(kVar);
        } else if (cA == '.') {
            zH = c(kVar);
        } else if (cA != '[') {
            zH = g(kVar);
        } else {
            str = str + ". Expected ?, ', 0-9, * ";
            zH = b(kVar) || a(kVar) || h(kVar) || d(kVar) || f(kVar);
        }
        return zH || a(str);
    }

    private boolean f(k kVar) {
        int iB;
        int iH;
        int iB2;
        if (!this.b.a(AbstractJsonLexerKt.BEGIN_LIST) || (iB = this.b.b('?')) == -1) {
            return false;
        }
        char cH = this.b.h(iB);
        if ((cH != ']' && cH != ',') || (iB2 = this.b.b((iH = this.b.h() + 1), AbstractJsonLexerKt.END_LIST)) == -1) {
            return false;
        }
        String string = this.b.a(iH, iB2).toString();
        String[] strArrSplit = string.split(",");
        if (this.a.size() < strArrSplit.length) {
            throw new sdk.pendo.io.d1.f("Not enough predicates supplied for filter [" + string + "] at position " + this.b.h());
        }
        ArrayList arrayList = new ArrayList();
        int length = strArrSplit.length;
        for (int i = 0; i < length; i++) {
            String str = strArrSplit[i];
            String strTrim = str != null ? str.trim() : null;
            if (!MsalUtils.QUERY_STRING_SYMBOL.equals(strTrim == null ? "" : strTrim)) {
                throw new sdk.pendo.io.d1.f("Expected '?' but found " + strTrim);
            }
            arrayList.add(this.a.pop());
        }
        kVar.a(l.a(arrayList));
        this.b.k(iB2 + 1);
        return this.b.b() || e(kVar);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c7  */
    private boolean g(k kVar) {
        int iF;
        boolean z;
        List<sdk.pendo.io.g1.b> listB;
        String string;
        j jVarA;
        if (this.b.a(AbstractJsonLexerKt.BEGIN_LIST) || this.b.a('*') || this.b.a('.') || this.b.a(' ')) {
            return false;
        }
        int iH = this.b.h();
        int i = iH;
        while (true) {
            if (!this.b.c(i)) {
                iF = 0;
                z = false;
                break;
            }
            char cA = this.b.a(i);
            if (cA == ' ') {
                throw new sdk.pendo.io.d1.f("Use bracket notion ['my prop'] if your property contains blank characters. position: " + this.b.h());
            }
            if (cA == '.' || cA == '[') {
                z = false;
                iF = i;
                break;
            }
            if (cA == '(') {
                iF = i;
                z = true;
                break;
            }
            i++;
        }
        if (iF == 0) {
            iF = this.b.f();
        }
        sdk.pendo.io.e1.a aVar = this.b;
        if (z) {
            int i2 = i + 1;
            if (aVar.c(i2)) {
                if (this.b.a(i2) != ')') {
                    this.b.k(iF + 1);
                    listB = b(this.b.a(iH, iF).toString());
                } else {
                    this.b.k(i2);
                }
                string = this.b.a(iH, iF).toString();
                if (z) {
                    jVarA = l.a(string, listB);
                } else {
                    jVarA = l.a(string, '\'');
                }
                kVar.a(jVarA);
                return !this.b.b() || e(kVar);
            }
            this.b.k(i);
        } else {
            aVar.k(iF);
        }
        listB = null;
        string = this.b.a(iH, iF).toString();
        if (z) {
            jVarA = l.a(string, listB);
        } else {
            jVarA = l.a(string, '\'');
        }
        kVar.a(jVarA);
        if (this.b.b()) {
        }
    }

    private boolean h(k kVar) {
        boolean zA = this.b.a(AbstractJsonLexerKt.BEGIN_LIST);
        if (zA && !this.b.f('*')) {
            return false;
        }
        if (!this.b.a('*')) {
            sdk.pendo.io.e1.a aVar = this.b;
            if (aVar.g(aVar.h() + 1)) {
                return false;
            }
        }
        if (zA) {
            int iB = this.b.b('*');
            if (!this.b.d(iB, AbstractJsonLexerKt.END_LIST)) {
                throw new sdk.pendo.io.d1.f("Expected wildcard token to end with ']' on position " + (iB + 1));
            }
            this.b.k(this.b.a(iB, AbstractJsonLexerKt.END_LIST) + 1);
        } else {
            this.b.d(1);
        }
        kVar.a(l.b());
        return this.b.b() || e(kVar);
    }

    private i(sdk.pendo.io.e1.a aVar, LinkedList<sdk.pendo.io.d1.l> linkedList) {
        this.a = linkedList;
        this.b = aVar;
    }

    public static sdk.pendo.io.e1.g a(String str, sdk.pendo.io.d1.l... lVarArr) {
        try {
            sdk.pendo.io.e1.a aVar = new sdk.pendo.io.e1.a(str);
            aVar.l();
            if (aVar.a(0) != '$' && aVar.a(0) != '@') {
                aVar = new sdk.pendo.io.e1.a("$." + str);
                aVar.l();
            }
            if (aVar.c('.')) {
                a("Path must not end with a '.' or '..'");
            }
            return new i(aVar, (LinkedList<sdk.pendo.io.d1.l>) new LinkedList(Arrays.asList(lVarArr))).a();
        } catch (Exception e) {
            if (e instanceof sdk.pendo.io.d1.f) {
                throw ((sdk.pendo.io.d1.f) e);
            }
            throw new sdk.pendo.io.d1.f(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:67:0x0123  */
    /* JADX WARN: Code duplicated, block: B:68:0x0125  */
    /* JADX WARN: Code duplicated, block: B:71:0x012c  */
    /* JADX WARN: Code duplicated, block: B:73:0x0136  */
    /* JADX WARN: Code duplicated, block: B:75:0x0139  */
    /* JADX WARN: Code duplicated, block: B:76:0x013b  */
    /* JADX WARN: Code duplicated, block: B:77:0x0153  */
    /* JADX WARN: Code duplicated, block: B:79:0x015e  */
    private List<sdk.pendo.io.g1.b> b(String str) {
        boolean z;
        int i;
        sdk.pendo.io.g1.b bVar;
        int iIntValue;
        int iIntValue2;
        Integer numValueOf = 1;
        Integer numValueOf2 = 0;
        Boolean bool = Boolean.FALSE;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char c = 0;
        Integer numValueOf3 = numValueOf2;
        Boolean boolValueOf = bool;
        sdk.pendo.io.g1.a aVar = null;
        Integer numValueOf4 = numValueOf3;
        while (this.b.d() && !boolValueOf.booleanValue()) {
            char cA = this.b.a();
            this.b.d(1);
            if (aVar == null) {
                if (b(cA)) {
                    continue;
                } else if (cA == '{' || Character.isDigit(cA) || '\"' == cA) {
                    aVar = sdk.pendo.io.g1.a.JSON;
                } else if (a(cA).booleanValue()) {
                    aVar = sdk.pendo.io.g1.a.PATH;
                }
            }
            if (cA == '\"') {
                numValueOf3 = Integer.valueOf((c == '\\' || numValueOf3.intValue() <= 0) ? numValueOf3.intValue() + 1 : numValueOf3.intValue() - 1);
            } else if (cA != ',') {
                if (cA == '[') {
                    iIntValue = numValueOf4.intValue() + 1;
                } else if (cA != ']') {
                    if (cA == '{') {
                        iIntValue2 = numValueOf2.intValue() + 1;
                    } else if (cA != '}') {
                        if (cA == '(') {
                            numValueOf = Integer.valueOf(numValueOf.intValue() + 1);
                        } else if (cA == ')') {
                            numValueOf = Integer.valueOf(numValueOf.intValue() - 1);
                            if (numValueOf.intValue() != 0) {
                                sb.append(cA);
                            }
                            if (numValueOf3.intValue() == 0) {
                                if (numValueOf.intValue() == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                boolValueOf = Boolean.valueOf(z);
                                if (aVar != null) {
                                    i = a.a[aVar.ordinal()];
                                    if (i != 1) {
                                        bVar = new sdk.pendo.io.g1.b(sb.toString());
                                    } else if (i != 2) {
                                        bVar = null;
                                    } else {
                                        bVar = new sdk.pendo.io.g1.b(new i(sb.toString(), (LinkedList<sdk.pendo.io.d1.l>) new LinkedList()).a());
                                    }
                                    if (bVar != null) {
                                        arrayList.add(bVar);
                                    }
                                    sb.delete(0, sb.length());
                                    aVar = null;
                                }
                            }
                        }
                    } else {
                        if (numValueOf2.intValue() == 0) {
                            throw new sdk.pendo.io.d1.f("Unexpected close brace '}' at character position: " + this.b.h());
                        }
                        iIntValue2 = numValueOf2.intValue() - 1;
                    }
                    numValueOf2 = Integer.valueOf(iIntValue2);
                } else {
                    if (numValueOf4.intValue() == 0) {
                        throw new sdk.pendo.io.d1.f("Unexpected close bracket ']' at character position: " + this.b.h());
                    }
                    iIntValue = numValueOf4.intValue() - 1;
                }
                numValueOf4 = Integer.valueOf(iIntValue);
            } else if (numValueOf3.intValue() == 0 && numValueOf2.intValue() == 0 && numValueOf4.intValue() == 0 && ((numValueOf.intValue() == 0 && ')' == cA) || 1 == numValueOf.intValue())) {
                if (numValueOf.intValue() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                boolValueOf = Boolean.valueOf(z);
                if (aVar != null) {
                    i = a.a[aVar.ordinal()];
                    if (i != 1) {
                        bVar = new sdk.pendo.io.g1.b(sb.toString());
                    } else if (i != 2) {
                        bVar = null;
                    } else {
                        bVar = new sdk.pendo.io.g1.b(new i(sb.toString(), (LinkedList<sdk.pendo.io.d1.l>) new LinkedList()).a());
                    }
                    if (bVar != null) {
                        arrayList.add(bVar);
                    }
                    sb.delete(0, sb.length());
                    aVar = null;
                }
            }
            if (aVar != null && (cA != ',' || numValueOf2.intValue() != 0 || numValueOf4.intValue() != 0 || 1 != numValueOf.intValue())) {
                sb.append(cA);
            }
            c = cA;
        }
        if (numValueOf2.intValue() == 0 && numValueOf.intValue() == 0 && numValueOf4.intValue() == 0) {
            return arrayList;
        }
        throw new sdk.pendo.io.d1.f("Arguments to function: '" + str + "' are not closed properly.");
    }

    private void c() {
        while (this.b.d() && b(this.b.a())) {
            this.b.d(1);
        }
    }

    public static boolean a(String str) {
        throw new sdk.pendo.io.d1.f(str);
    }

    private boolean b(k kVar) {
        if (!this.b.a(AbstractJsonLexerKt.BEGIN_LIST)) {
            return false;
        }
        char cG = this.b.g();
        if (cG != '\'' && cG != '\"') {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        int iH = this.b.h() + 1;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = iH;
        while (this.b.c(iH)) {
            char cA = this.b.a(iH);
            if (!z) {
                if ('\\' != cA) {
                    if (cA == ']' && !z2) {
                        if (!z3) {
                            break;
                        }
                        a("Found empty property at index " + iH);
                        break;
                    }
                    if (cA == cG) {
                        if (z2) {
                            char cH = this.b.h(iH);
                            if (cH != ']' && cH != ',') {
                                a("Property must be separated by comma or Property must be terminated close square bracket at index " + iH);
                            }
                            arrayList.add(sdk.pendo.io.e1.i.a(this.b.a(i2, iH).toString()));
                            z2 = false;
                            i = iH;
                        } else {
                            i2 = iH + 1;
                            z3 = false;
                            z2 = true;
                        }
                    } else if (cA == ',') {
                        if (z3) {
                            a("Found empty property at index " + iH);
                        }
                        z3 = true;
                    }
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            iH++;
        }
        if (z2) {
            a("Property has not been closed - missing closing " + cG);
        }
        this.b.k(this.b.a(i, AbstractJsonLexerKt.END_LIST) + 1);
        kVar.a(l.a(arrayList, cG));
        return this.b.b() || e(kVar);
    }

    private Boolean a(char c) {
        return Boolean.valueOf(c == '$' || c == '@');
    }

    private p b() {
        c();
        if (!a(this.b.a()).booleanValue()) {
            throw new sdk.pendo.io.d1.f("Path must start with '$' or '@'");
        }
        p pVarA = l.a(this.b.a());
        if (this.b.b()) {
            return pVarA;
        }
        this.b.d(1);
        if (this.b.a() != '.' && this.b.a() != '[') {
            a("Illegal character at position " + this.b.h() + " expected '.' or '['");
        }
        e(pVarA.h());
        return pVarA;
    }

    private boolean a(k kVar) {
        int iH;
        int iB;
        if (!this.b.a(AbstractJsonLexerKt.BEGIN_LIST)) {
            return false;
        }
        char cG = this.b.g();
        if ((!Character.isDigit(cG) && cG != '-' && cG != ':') || (iB = this.b.b((iH = this.b.h() + 1), AbstractJsonLexerKt.END_LIST)) == -1) {
            return false;
        }
        String strTrim = this.b.a(iH, iB).toString().trim();
        if ("*".equals(strTrim)) {
            return false;
        }
        for (int i = 0; i < strTrim.length(); i++) {
            char cCharAt = strTrim.charAt(i);
            if (!Character.isDigit(cCharAt) && cCharAt != ',' && cCharAt != '-' && cCharAt != ':' && cCharAt != ' ') {
                return false;
            }
        }
        kVar.a(strTrim.contains(":") ? l.a(d.a(strTrim)) : l.a(sdk.pendo.io.l1.a.a(strTrim)));
        this.b.k(iB + 1);
        return this.b.b() || e(kVar);
    }
}
