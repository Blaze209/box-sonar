package external.sdk.pendo.io.mozilla.javascript.regexp;

import com.google.firebase.analytics.FirebaseAnalytics;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Function;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.ScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.Symbol;
import external.sdk.pendo.io.mozilla.javascript.SymbolKey;
import external.sdk.pendo.io.mozilla.javascript.TopLevel;
import external.sdk.pendo.io.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes4.dex */
public class NativeRegExp extends IdScriptableObject implements Function {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ANCHOR_BOL = -2;
    private static final int INDEX_LEN = 2;
    private static final int Id_compile = 1;
    private static final int Id_exec = 4;
    private static final int Id_global = 3;
    private static final int Id_ignoreCase = 4;
    private static final int Id_lastIndex = 1;
    private static final int Id_multiline = 5;
    private static final int Id_prefix = 6;
    private static final int Id_source = 2;
    private static final int Id_test = 5;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    public static final int JSREG_FOLD = 2;
    public static final int JSREG_GLOB = 1;
    public static final int JSREG_MULTILINE = 4;
    public static final int MATCH = 1;
    private static final int MAX_INSTANCE_ID = 5;
    private static final int MAX_PROTOTYPE_ID = 8;
    public static final int PREFIX = 2;
    private static final Object REGEXP_TAG = new Object();
    private static final byte REOP_ALNUM = 9;
    private static final byte REOP_ALT = 31;
    private static final byte REOP_ALTPREREQ = 53;
    private static final byte REOP_ALTPREREQ2 = 55;
    private static final byte REOP_ALTPREREQi = 54;
    private static final byte REOP_ASSERT = 41;
    private static final byte REOP_ASSERTNOTTEST = 44;
    private static final byte REOP_ASSERTTEST = 43;
    private static final byte REOP_ASSERT_NOT = 42;
    private static final byte REOP_BACKREF = 13;
    private static final byte REOP_BOL = 2;
    private static final byte REOP_CLASS = 22;
    private static final byte REOP_DIGIT = 7;
    private static final byte REOP_DOT = 6;
    private static final byte REOP_EMPTY = 1;
    private static final byte REOP_END = 57;
    private static final byte REOP_ENDCHILD = 49;
    private static final byte REOP_EOL = 3;
    private static final byte REOP_FLAT = 14;
    private static final byte REOP_FLAT1 = 15;
    private static final byte REOP_FLAT1i = 17;
    private static final byte REOP_FLATi = 16;
    private static final byte REOP_JUMP = 32;
    private static final byte REOP_LPAREN = 29;
    private static final byte REOP_MINIMALOPT = 47;
    private static final byte REOP_MINIMALPLUS = 46;
    private static final byte REOP_MINIMALQUANT = 48;
    private static final byte REOP_MINIMALREPEAT = 52;
    private static final byte REOP_MINIMALSTAR = 45;
    private static final byte REOP_NCLASS = 23;
    private static final byte REOP_NONALNUM = 10;
    private static final byte REOP_NONDIGIT = 8;
    private static final byte REOP_NONSPACE = 12;
    private static final byte REOP_OPT = 28;
    private static final byte REOP_PLUS = 27;
    private static final byte REOP_QUANT = 25;
    private static final byte REOP_REPEAT = 51;
    private static final byte REOP_RPAREN = 30;
    private static final byte REOP_SIMPLE_END = 23;
    private static final byte REOP_SIMPLE_START = 1;
    private static final byte REOP_SPACE = 11;
    private static final byte REOP_STAR = 26;
    private static final byte REOP_UCFLAT1 = 18;
    private static final byte REOP_UCFLAT1i = 19;
    private static final byte REOP_WBDRY = 4;
    private static final byte REOP_WNONBDRY = 5;
    private static final int SymbolId_match = 7;
    private static final int SymbolId_search = 8;
    public static final int TEST = 0;
    private static final boolean debug = false;
    private static final long serialVersionUID = 4965263491464903264L;
    Object lastIndex;
    private int lastIndexAttr;
    private RECompiled re;

    NativeRegExp() {
        this.lastIndex = ScriptRuntime.zeroObj;
        this.lastIndexAttr = 6;
    }

    private static void addCharacterRangeToCharSet(RECharSet rECharSet, char c, char c2) {
        int i = c / '\b';
        int i2 = c2 / '\b';
        if (c2 >= rECharSet.length || c > c2) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        char c3 = (char) (c & 7);
        char c4 = (char) (c2 & 7);
        if (i == i2) {
            byte[] bArr = rECharSet.bits;
            bArr[i] = (byte) (((255 >> (7 - (c4 - c3))) << c3) | bArr[i]);
            return;
        }
        byte[] bArr2 = rECharSet.bits;
        bArr2[i] = (byte) ((255 << c3) | bArr2[i]);
        while (true) {
            i++;
            if (i >= i2) {
                byte[] bArr3 = rECharSet.bits;
                bArr3[i2] = (byte) (bArr3[i2] | (255 >> (7 - c4)));
                return;
            }
            rECharSet.bits[i] = -1;
        }
    }

    private static void addCharacterToCharSet(RECharSet rECharSet, char c) {
        int i = c / '\b';
        if (c >= rECharSet.length) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        byte[] bArr = rECharSet.bits;
        bArr[i] = (byte) ((1 << (c & 7)) | bArr[i]);
    }

    private static int addIndex(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw Kit.codeBug();
        }
        if (i2 > 65535) {
            throw Context.reportRuntimeError("Too complex regexp");
        }
        bArr[i] = (byte) (i2 >> 8);
        bArr[i + 1] = (byte) i2;
        return i + 2;
    }

    private static boolean backrefMatcher(REGlobalData rEGlobalData, int i, String str, int i2) {
        long[] jArr = rEGlobalData.parens;
        if (jArr == null || i >= jArr.length) {
            return false;
        }
        int iParensIndex = rEGlobalData.parensIndex(i);
        if (iParensIndex == -1) {
            return true;
        }
        int iParensLength = rEGlobalData.parensLength(i);
        int i3 = rEGlobalData.cp;
        if (i3 + iParensLength > i2) {
            return false;
        }
        if ((rEGlobalData.regexp.flags & 2) != 0) {
            for (int i4 = 0; i4 < iParensLength; i4++) {
                char cCharAt = str.charAt(iParensIndex + i4);
                char cCharAt2 = str.charAt(rEGlobalData.cp + i4);
                if (cCharAt != cCharAt2 && upcase(cCharAt) != upcase(cCharAt2)) {
                    return false;
                }
            }
        } else if (!str.regionMatches(iParensIndex, str, i3, iParensLength)) {
            return false;
        }
        rEGlobalData.cp += iParensLength;
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:53:0x0099
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static boolean calculateBitmapSize(external.sdk.pendo.io.mozilla.javascript.regexp.CompilerState r11, external.sdk.pendo.io.mozilla.javascript.regexp.RENode r12, char[] r13, int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.calculateBitmapSize(external.sdk.pendo.io.mozilla.javascript.regexp.CompilerState, external.sdk.pendo.io.mozilla.javascript.regexp.RENode, char[], int, int):boolean");
    }

    private static boolean classMatcher(REGlobalData rEGlobalData, RECharSet rECharSet, char c) {
        if (!rECharSet.converted) {
            processCharSet(rEGlobalData, rECharSet);
        }
        int i = c >> 3;
        int i2 = rECharSet.length;
        boolean z = true;
        if (i2 != 0 && c < i2 && (rECharSet.bits[i] & (1 << (c & 7))) != 0) {
            z = false;
        }
        return rECharSet.sense ^ z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00dd, code lost:
    
        if (r10.kid2.op == 2) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static external.sdk.pendo.io.mozilla.javascript.regexp.RECompiled compileRE(external.sdk.pendo.io.mozilla.javascript.Context r10, java.lang.String r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.compileRE(external.sdk.pendo.io.mozilla.javascript.Context, java.lang.String, java.lang.String, boolean):external.sdk.pendo.io.mozilla.javascript.regexp.RECompiled");
    }

    private static void doFlat(CompilerState compilerState, char c) {
        RENode rENode = new RENode((byte) 14);
        compilerState.result = rENode;
        rENode.chr = c;
        rENode.length = 1;
        rENode.flatIndex = -1;
        compilerState.progLength += 3;
    }

    private static char downcase(char c) {
        if (c >= 128) {
            char lowerCase = Character.toLowerCase(c);
            if (lowerCase >= 128) {
                return lowerCase;
            }
        } else if ('A' <= c && c <= 'Z') {
            return (char) (c + ' ');
        }
        return c;
    }

    /* JADX WARN: Switch 'out' block B:70:0x00f3 for B:22:0x002e already processed. Defaulting to fallback option. */
    private static int emitREBytecode(CompilerState compilerState, RECompiled rECompiled, int i, RENode rENode) {
        int i2;
        byte[] bArr = rECompiled.program;
        while (rENode != null) {
            int iAddIndex = i + 1;
            byte b = rENode.op;
            bArr[i] = b;
            if (b != 1) {
                if (b != 22) {
                    if (b != 25) {
                        if (b == 29) {
                            int iEmitREBytecode = emitREBytecode(compilerState, rECompiled, addIndex(bArr, iAddIndex, rENode.parenIndex), rENode.kid);
                            iAddIndex = iEmitREBytecode + 1;
                            bArr[iEmitREBytecode] = 30;
                        } else if (b == 31) {
                            RENode rENode2 = rENode.kid2;
                            int iEmitREBytecode2 = emitREBytecode(compilerState, rECompiled, iAddIndex + 2, rENode.kid);
                            int i3 = iEmitREBytecode2 + 1;
                            bArr[iEmitREBytecode2] = 32;
                            int i4 = iEmitREBytecode2 + 3;
                            resolveForwardJump(bArr, iAddIndex, i4);
                            int iEmitREBytecode3 = emitREBytecode(compilerState, rECompiled, i4, rENode2);
                            int i5 = iEmitREBytecode3 + 1;
                            bArr[iEmitREBytecode3] = 32;
                            i = iEmitREBytecode3 + 3;
                            resolveForwardJump(bArr, i3, i);
                            resolveForwardJump(bArr, i5, i);
                        } else if (b != 13) {
                            if (b != 14) {
                                if (b == 41) {
                                    int iEmitREBytecode4 = emitREBytecode(compilerState, rECompiled, i + 3, rENode.kid);
                                    i2 = iEmitREBytecode4 + 1;
                                    bArr[iEmitREBytecode4] = 43;
                                } else if (b != 42) {
                                    switch (b) {
                                        case 53:
                                        case 54:
                                        case 55:
                                            boolean z = b == 54;
                                            char cUpcase = rENode.chr;
                                            if (z) {
                                                cUpcase = upcase(cUpcase);
                                            }
                                            addIndex(bArr, iAddIndex, cUpcase);
                                            int i6 = i + 3;
                                            int iUpcase = rENode.index;
                                            if (z) {
                                                iUpcase = upcase((char) iUpcase);
                                            }
                                            addIndex(bArr, i6, iUpcase);
                                            iAddIndex = i + 5;
                                            RENode rENode3 = rENode.kid2;
                                            int iEmitREBytecode5 = emitREBytecode(compilerState, rECompiled, iAddIndex + 2, rENode.kid);
                                            int i7 = iEmitREBytecode5 + 1;
                                            bArr[iEmitREBytecode5] = 32;
                                            int i8 = iEmitREBytecode5 + 3;
                                            resolveForwardJump(bArr, iAddIndex, i8);
                                            int iEmitREBytecode6 = emitREBytecode(compilerState, rECompiled, i8, rENode3);
                                            int i9 = iEmitREBytecode6 + 1;
                                            bArr[iEmitREBytecode6] = 32;
                                            i = iEmitREBytecode6 + 3;
                                            resolveForwardJump(bArr, i7, i);
                                            resolveForwardJump(bArr, i9, i);
                                            break;
                                        default:
                                            i = iAddIndex;
                                            continue;
                                    }
                                } else {
                                    int iEmitREBytecode7 = emitREBytecode(compilerState, rECompiled, i + 3, rENode.kid);
                                    i2 = iEmitREBytecode7 + 1;
                                    bArr[iEmitREBytecode7] = 44;
                                }
                                resolveForwardJump(bArr, iAddIndex, i2);
                            } else {
                                if (rENode.flatIndex != -1) {
                                    while (true) {
                                        RENode rENode4 = rENode.next;
                                        if (rENode4 != null && rENode4.op == 14) {
                                            int i10 = rENode.flatIndex;
                                            int i11 = rENode.length;
                                            if (i10 + i11 == rENode4.flatIndex) {
                                                rENode.length = i11 + rENode4.length;
                                                rENode.next = rENode4.next;
                                            }
                                        }
                                    }
                                }
                                int i12 = rENode.flatIndex;
                                if (i12 == -1 || rENode.length <= 1) {
                                    char c = rENode.chr;
                                    if (c < 256) {
                                        if ((compilerState.flags & 2) != 0) {
                                            bArr[i] = 17;
                                        } else {
                                            bArr[i] = 15;
                                        }
                                        i += 2;
                                        bArr[iAddIndex] = (byte) c;
                                    } else {
                                        if ((compilerState.flags & 2) != 0) {
                                            bArr[i] = 19;
                                        } else {
                                            bArr[i] = 18;
                                        }
                                        i = addIndex(bArr, iAddIndex, c);
                                    }
                                } else {
                                    if ((compilerState.flags & 2) != 0) {
                                        bArr[i] = 16;
                                    } else {
                                        bArr[i] = 14;
                                    }
                                    i = addIndex(bArr, addIndex(bArr, iAddIndex, i12), rENode.length);
                                }
                            }
                        }
                        i = addIndex(bArr, iAddIndex, rENode.parenIndex);
                    } else {
                        int i13 = rENode.min;
                        if (i13 == 0 && rENode.max == -1) {
                            bArr[i] = rENode.greedy ? (byte) 26 : (byte) 45;
                        } else if (i13 == 0 && rENode.max == 1) {
                            bArr[i] = rENode.greedy ? (byte) 28 : (byte) 47;
                        } else if (i13 == 1 && rENode.max == -1) {
                            bArr[i] = rENode.greedy ? (byte) 27 : (byte) 46;
                        } else {
                            if (!rENode.greedy) {
                                bArr[i] = 48;
                            }
                            iAddIndex = addIndex(bArr, addIndex(bArr, iAddIndex, i13), rENode.max + 1);
                        }
                        int iAddIndex2 = addIndex(bArr, addIndex(bArr, iAddIndex, rENode.parenCount), rENode.parenIndex);
                        int iEmitREBytecode8 = emitREBytecode(compilerState, rECompiled, iAddIndex2 + 2, rENode.kid);
                        i2 = iEmitREBytecode8 + 1;
                        bArr[iEmitREBytecode8] = 49;
                        resolveForwardJump(bArr, iAddIndex2, i2);
                    }
                    i = i2;
                } else {
                    if (!rENode.sense) {
                        bArr[i] = 23;
                    }
                    i = addIndex(bArr, iAddIndex, rENode.index);
                    rECompiled.classList[rENode.index] = new RECharSet(rENode.bmsize, rENode.startIndex, rENode.kidlen, rENode.sense);
                }
            }
            rENode = rENode.next;
        }
        return i;
    }

    private static String escapeRegExp(Object obj) {
        String string = ScriptRuntime.toString(obj);
        StringBuilder sb = null;
        int i = 0;
        for (int iIndexOf = string.indexOf(47); iIndexOf > -1; iIndexOf = string.indexOf(47, iIndexOf + 1)) {
            if (iIndexOf == i || string.charAt(iIndexOf - 1) != '\\') {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) string, i, iIndexOf);
                sb.append("\\/");
                i = iIndexOf + 1;
            }
        }
        if (sb == null) {
            return string;
        }
        sb.append((CharSequence) string, i, string.length());
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    /* JADX WARN: Code duplicated, block: B:12:0x0027  */
    private Object execSub(Context context, Scriptable scriptable, Object[] objArr, int i) {
        Object obj;
        String string;
        double integer;
        RegExpImpl impl = getImpl(context);
        if (objArr.length == 0) {
            string = impl.input;
            if (string == null) {
                obj = Undefined.instance;
            }
            String str = string;
            if ((this.re.flags & 1) != 0) {
                integer = ScriptRuntime.toInteger(this.lastIndex);
            } else {
                integer = 0.0d;
            }
            if (integer >= 0.0d || str.length() < integer) {
                setLastIndex(ScriptRuntime.zeroObj);
                return null;
            }
            int[] iArr = {(int) integer};
            Object objExecuteRegExp = executeRegExp(context, scriptable, impl, str, iArr, i);
            if ((this.re.flags & 1) != 0) {
                if (objExecuteRegExp != null && objExecuteRegExp != Undefined.instance) {
                    setLastIndex(Double.valueOf(iArr[0]));
                    return objExecuteRegExp;
                }
                setLastIndex(ScriptRuntime.zeroObj);
            }
            return objExecuteRegExp;
        }
        obj = objArr[0];
        string = ScriptRuntime.toString(obj);
        String str2 = string;
        if ((this.re.flags & 1) != 0) {
            integer = ScriptRuntime.toInteger(this.lastIndex);
        } else {
            integer = 0.0d;
        }
        if (integer >= 0.0d) {
        }
        setLastIndex(ScriptRuntime.zeroObj);
        return null;
    }

    /* JADX WARN: Failed to calculate best type for var: r2v44 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v44 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v44 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v44 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v46 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v46 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v48 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v48 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v54 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v54 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v41 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v41 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v68 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v68 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v44 ??, new type: char
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    private static boolean executeREBytecode(external.sdk.pendo.io.mozilla.javascript.regexp.REGlobalData r20, java.lang.String r21, int r22) {
        /*
            Method dump skipped, instruction units count: 1188
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.executeREBytecode(external.sdk.pendo.io.mozilla.javascript.regexp.REGlobalData, java.lang.String, int):boolean");
    }

    private static boolean flatNIMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.cp + i2 > i3) {
            return false;
        }
        char[] cArr = rEGlobalData.regexp.source;
        for (int i4 = 0; i4 < i2; i4++) {
            char c = cArr[i + i4];
            char cCharAt = str.charAt(rEGlobalData.cp + i4);
            if (c != cCharAt && upcase(c) != upcase(cCharAt)) {
                return false;
            }
        }
        rEGlobalData.cp += i2;
        return true;
    }

    private static boolean flatNMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.cp + i2 > i3) {
            return false;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (rEGlobalData.regexp.source[i + i4] != str.charAt(rEGlobalData.cp + i4)) {
                return false;
            }
        }
        rEGlobalData.cp += i2;
        return true;
    }

    private static int getDecimalValue(char c, CompilerState compilerState, int i, String str) {
        int i2 = compilerState.cp;
        char[] cArr = compilerState.cpbegin;
        int i3 = c - 48;
        boolean z = false;
        while (true) {
            int i4 = compilerState.cp;
            if (i4 == compilerState.cpend) {
                break;
            }
            char c2 = cArr[i4];
            if (!isDigit(c2)) {
                break;
            }
            if (!z && (i3 = (i3 * 10) + (c2 - '0')) >= i) {
                i3 = i;
                z = true;
            }
            compilerState.cp++;
        }
        if (z) {
            reportError(str, String.valueOf(cArr, i2, compilerState.cp - i2));
        }
        return i3;
    }

    private static RegExpImpl getImpl(Context context) {
        return (RegExpImpl) ScriptRuntime.getRegExpProxy(context);
    }

    private static int getIndex(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    private static int getOffset(byte[] bArr, int i) {
        return getIndex(bArr, i);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeRegExp nativeRegExp = new NativeRegExp();
        nativeRegExp.re = compileRE(context, "", null, false);
        nativeRegExp.activatePrototypeMap(8);
        nativeRegExp.setParentScope(scriptable);
        nativeRegExp.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        NativeRegExpCtor nativeRegExpCtor = new NativeRegExpCtor();
        nativeRegExp.defineProperty("constructor", nativeRegExpCtor, 2);
        ScriptRuntime.setFunctionProtoAndParent(nativeRegExpCtor, scriptable);
        nativeRegExpCtor.setImmunePrototypeProperty(nativeRegExp);
        if (z) {
            nativeRegExp.sealObject();
            nativeRegExpCtor.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, "RegExp", nativeRegExpCtor, 2);
    }

    private static boolean isControlLetter(char c) {
        if ('a' > c || c > 'z') {
            return 'A' <= c && c <= 'Z';
        }
        return true;
    }

    static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private static boolean isLineTerm(char c) {
        return ScriptRuntime.isJSLineTerminator(c);
    }

    private static boolean isREWhiteSpace(int i) {
        return ScriptRuntime.isJSWhitespaceOrLineTerminator(i);
    }

    private static boolean isWord(char c) {
        if ('a' > c || c > 'z') {
            return ('A' <= c && c <= 'Z') || isDigit(c) || c == '_';
        }
        return true;
    }

    private static boolean matchRegExp(REGlobalData rEGlobalData, RECompiled rECompiled, String str, int i, int i2, boolean z) {
        int i3 = rECompiled.parenCount;
        if (i3 != 0) {
            rEGlobalData.parens = new long[i3];
        } else {
            rEGlobalData.parens = null;
        }
        rEGlobalData.backTrackStackTop = null;
        rEGlobalData.stateStackTop = null;
        rEGlobalData.multiline = z || (rECompiled.flags & 4) != 0;
        rEGlobalData.regexp = rECompiled;
        int i4 = rECompiled.anchorCh;
        int i5 = i;
        while (i5 <= i2) {
            if (i4 >= 0) {
                while (i5 != i2) {
                    char cCharAt = str.charAt(i5);
                    if (cCharAt != i4 && ((rEGlobalData.regexp.flags & 2) == 0 || upcase(cCharAt) != upcase((char) i4))) {
                        i5++;
                    }
                }
                return false;
            }
            rEGlobalData.cp = i5;
            rEGlobalData.skipped = i5 - i;
            for (int i6 = 0; i6 < rECompiled.parenCount; i6++) {
                rEGlobalData.parens[i6] = -1;
            }
            boolean zExecuteREBytecode = executeREBytecode(rEGlobalData, str, i2);
            rEGlobalData.backTrackStackTop = null;
            rEGlobalData.stateStackTop = null;
            if (zExecuteREBytecode) {
                return true;
            }
            if (i4 == -2 && !rEGlobalData.multiline) {
                rEGlobalData.skipped = i2;
                return false;
            }
            i5 = rEGlobalData.skipped + i + 1;
        }
        return false;
    }

    private static boolean parseAlternative(CompilerState compilerState) {
        char c;
        char[] cArr = compilerState.cpbegin;
        RENode rENode = null;
        RENode rENode2 = null;
        while (true) {
            int i = compilerState.cp;
            if (i == compilerState.cpend || (c = cArr[i]) == '|' || (compilerState.parenNesting != 0 && c == ')')) {
                break;
            }
            if (!parseTerm(compilerState)) {
                return false;
            }
            if (rENode == null) {
                rENode = compilerState.result;
                rENode2 = rENode;
            } else {
                rENode2.next = compilerState.result;
            }
            while (true) {
                RENode rENode3 = rENode2.next;
                if (rENode3 != null) {
                    rENode2 = rENode3;
                }
            }
        }
        if (rENode == null) {
            rENode = new RENode((byte) 1);
        }
        compilerState.result = rENode;
        return true;
    }

    private static boolean parseDisjunction(CompilerState compilerState) {
        int i;
        int i2;
        int i3;
        if (!parseAlternative(compilerState)) {
            return false;
        }
        char[] cArr = compilerState.cpbegin;
        int i4 = compilerState.cp;
        if (i4 != cArr.length && cArr[i4] == '|') {
            compilerState.cp = i4 + 1;
            RENode rENode = new RENode((byte) 31);
            rENode.kid = compilerState.result;
            if (!parseDisjunction(compilerState)) {
                return false;
            }
            RENode rENode2 = compilerState.result;
            rENode.kid2 = rENode2;
            compilerState.result = rENode;
            RENode rENode3 = rENode.kid;
            byte b = rENode3.op;
            if (b == 14 && rENode2.op == 14) {
                rENode.op = (compilerState.flags & 2) == 0 ? (byte) 53 : (byte) 54;
                rENode.chr = rENode3.chr;
                i2 = rENode2.chr;
            } else {
                if (b == 22 && (i3 = rENode3.index) < 256 && rENode2.op == 14 && (compilerState.flags & 2) == 0) {
                    rENode.op = (byte) 55;
                    rENode.chr = rENode2.chr;
                    rENode.index = i3;
                    i = compilerState.progLength + 13;
                } else if (b == 14 && rENode2.op == 22 && (i2 = rENode2.index) < 256 && (compilerState.flags & 2) == 0) {
                    rENode.op = (byte) 55;
                    rENode.chr = rENode3.chr;
                } else {
                    i = compilerState.progLength + 9;
                }
                compilerState.progLength = i;
            }
            rENode.index = i2;
            i = compilerState.progLength + 13;
            compilerState.progLength = i;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:114:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:116:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:119:0x01fa A[LOOP:0: B:113:0x01da->B:119:0x01fa, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:156:0x02be A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:157:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:159:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:161:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:163:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:165:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:166:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:168:0x02df  */
    /* JADX WARN: Code duplicated, block: B:170:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:172:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:174:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:176:0x0304  */
    /* JADX WARN: Code duplicated, block: B:178:0x030c  */
    /* JADX WARN: Code duplicated, block: B:180:0x0314  */
    /* JADX WARN: Code duplicated, block: B:182:0x0321  */
    /* JADX WARN: Code duplicated, block: B:184:0x032c  */
    /* JADX WARN: Code duplicated, block: B:187:0x0331  */
    /* JADX WARN: Code duplicated, block: B:188:0x0343  */
    /* JADX WARN: Code duplicated, block: B:190:0x0347  */
    /* JADX WARN: Code duplicated, block: B:191:0x034a  */
    /* JADX WARN: Code duplicated, block: B:192:0x035c  */
    /* JADX WARN: Code duplicated, block: B:193:0x0368  */
    /* JADX WARN: Code duplicated, block: B:197:0x037f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:198:0x0380  */
    /* JADX WARN: Code duplicated, block: B:200:0x0395  */
    /* JADX WARN: Code duplicated, block: B:203:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:207:0x01fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:0x01ee A[SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:66:0x0104. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v24, types: [int] */
    /* JADX WARN: Type inference failed for: r3v27, types: [int] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36, types: [char] */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r3v58 */
    private static boolean parseTerm(CompilerState compilerState) {
        RENode rENode;
        boolean z;
        RENode rENode2;
        int i;
        int i2;
        RENode rENode3;
        int i3;
        char c;
        int decimalValue;
        RENode rENode4;
        int i4;
        boolean z2;
        int i5;
        RENode rENode5;
        int i6;
        char c2;
        int decimalValue2;
        int i7;
        char c3;
        int i8;
        int i9;
        char c4;
        int i10;
        char c5;
        int i11;
        char c6;
        char c7;
        int i12;
        int i13;
        int iXDigitToInt;
        RENode rENode6;
        RENode rENode7;
        char c8;
        char[] cArr = compilerState.cpbegin;
        int i14 = compilerState.cp;
        int i15 = i14 + 1;
        compilerState.cp = i15;
        char c9 = cArr[i14];
        int i16 = compilerState.parenCount;
        if (c9 != '$') {
            if (c9 != '.') {
                if (c9 == '?') {
                    z = false;
                } else {
                    if (c9 != '^') {
                        z = false;
                        char c10 = '\\';
                        if (c9 != '[') {
                            int i17 = 4;
                            if (c9 != '\\') {
                                switch (c9) {
                                    case '(':
                                        int i18 = i14 + 2;
                                        if (i18 < compilerState.cpend && cArr[i15] == '?' && ((c8 = cArr[i18]) == '=' || c8 == '!' || c8 == ':')) {
                                            compilerState.cp = i14 + 3;
                                            if (c8 == '=') {
                                                rENode7 = new RENode((byte) 41);
                                            } else if (c8 == '!') {
                                                rENode7 = new RENode((byte) 42);
                                            } else {
                                                rENode7 = null;
                                            }
                                            compilerState.progLength += 4;
                                        } else {
                                            rENode7 = new RENode((byte) 29);
                                            compilerState.progLength += 6;
                                            int i19 = compilerState.parenCount;
                                            compilerState.parenCount = i19 + 1;
                                            rENode7.parenIndex = i19;
                                        }
                                        compilerState.parenNesting++;
                                        if (!parseDisjunction(compilerState)) {
                                            return false;
                                        }
                                        int i20 = compilerState.cp;
                                        if (i20 == compilerState.cpend || cArr[i20] != ')') {
                                            reportError("msg.unterm.paren", "");
                                            return false;
                                        }
                                        compilerState.cp = i20 + 1;
                                        compilerState.parenNesting--;
                                        if (rENode7 != null) {
                                            rENode7.kid = compilerState.result;
                                            compilerState.result = rENode7;
                                        }
                                        break;
                                        break;
                                    case ')':
                                        reportError("msg.re.unmatched.right.paren", "");
                                        return false;
                                    case '*':
                                    case '+':
                                        break;
                                    default:
                                        rENode6 = new RENode((byte) 14);
                                        compilerState.result = rENode6;
                                        rENode6.chr = c9;
                                        rENode6.length = 1;
                                        rENode6.flatIndex = compilerState.cp - 1;
                                        break;
                                }
                            } else {
                                int i21 = compilerState.cpend;
                                if (i15 >= i21) {
                                    reportError("msg.trail.backslash", "");
                                    return false;
                                }
                                int i22 = i14 + 2;
                                compilerState.cp = i22;
                                char c11 = cArr[i15];
                                if (c11 == 'B') {
                                    rENode = new RENode((byte) 5);
                                } else if (c11 == 'D') {
                                    rENode2 = new RENode((byte) 8);
                                } else if (c11 == 'S') {
                                    rENode2 = new RENode((byte) 12);
                                } else if (c11 == 'W') {
                                    rENode2 = new RENode((byte) 10);
                                } else if (c11 == 'f') {
                                    doFlat(compilerState, '\f');
                                } else if (c11 != 'n') {
                                    switch (c11) {
                                        case '0':
                                            reportWarning(compilerState.cx, "msg.bad.backref", "");
                                            int i23 = 0;
                                            while (i23 < 32 && (i10 = compilerState.cp) < compilerState.cpend && (c5 = cArr[i10]) >= '0' && c5 <= '7') {
                                                compilerState.cp = i10 + 1;
                                                i23 = (i23 * 8) + (c5 - '0');
                                            }
                                            c4 = i23;
                                            c7 = (char) c4;
                                            doFlat(compilerState, c7);
                                            break;
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            int i24 = i14 + 1;
                                            int decimalValue3 = getDecimalValue(c11, compilerState, 65535, "msg.overlarge.backref");
                                            if (decimalValue3 > compilerState.backReferenceLimit) {
                                                reportWarning(compilerState.cx, "msg.bad.backref", "");
                                            }
                                            if (decimalValue3 <= compilerState.backReferenceLimit) {
                                                RENode rENode8 = new RENode((byte) 13);
                                                compilerState.result = rENode8;
                                                rENode8.parenIndex = decimalValue3 - 1;
                                                compilerState.progLength += 3;
                                                if (compilerState.maxBackReference < decimalValue3) {
                                                    compilerState.maxBackReference = decimalValue3;
                                                }
                                            } else {
                                                compilerState.cp = i24;
                                                if (c11 < '8') {
                                                    compilerState.cp = i14 + 2;
                                                    c4 = c11 - '0';
                                                    while (c4 < 32 && (i11 = compilerState.cp) < compilerState.cpend && (c6 = cArr[i11]) >= '0' && c6 <= '7') {
                                                        compilerState.cp = i11 + 1;
                                                        c4 = (c4 * 8) + (c6 - '0');
                                                    }
                                                    c7 = (char) c4;
                                                    doFlat(compilerState, c7);
                                                } else {
                                                    doFlat(compilerState, c10);
                                                }
                                            }
                                            break;
                                        default:
                                            switch (c11) {
                                                case 'b':
                                                    rENode = new RENode((byte) 4);
                                                    break;
                                                case 'c':
                                                    if (i22 >= i21 || !isControlLetter(cArr[i22])) {
                                                        compilerState.cp--;
                                                    } else {
                                                        int i25 = compilerState.cp;
                                                        compilerState.cp = i25 + 1;
                                                        c10 = (char) (cArr[i25] & 31);
                                                    }
                                                    doFlat(compilerState, c10);
                                                    break;
                                                case 'd':
                                                    rENode2 = new RENode((byte) 7);
                                                    break;
                                                default:
                                                    switch (c11) {
                                                        case 'r':
                                                            c7 = '\r';
                                                            doFlat(compilerState, c7);
                                                            break;
                                                        case 's':
                                                            rENode2 = new RENode((byte) 11);
                                                            break;
                                                        case 't':
                                                            c7 = '\t';
                                                            doFlat(compilerState, c7);
                                                            break;
                                                        case 'u':
                                                            i12 = 0;
                                                            c4 = 0;
                                                            while (i12 < i17) {
                                                                i13 = compilerState.cp;
                                                                if (i13 < compilerState.cpend) {
                                                                    compilerState.cp = i13 + 1;
                                                                    iXDigitToInt = Kit.xDigitToInt(cArr[i13], c4);
                                                                    if (iXDigitToInt < 0) {
                                                                        int i26 = compilerState.cp - (i12 + 2);
                                                                        compilerState.cp = i26 + 1;
                                                                        c4 = cArr[i26];
                                                                    } else {
                                                                        i12++;
                                                                        c4 = iXDigitToInt;
                                                                    }
                                                                }
                                                                c7 = (char) c4;
                                                                doFlat(compilerState, c7);
                                                                break;
                                                            }
                                                            c7 = (char) c4;
                                                            doFlat(compilerState, c7);
                                                            break;
                                                        case 'v':
                                                            c7 = 11;
                                                            doFlat(compilerState, c7);
                                                            break;
                                                        case 'w':
                                                            rENode2 = new RENode((byte) 9);
                                                            break;
                                                        case 'x':
                                                            i17 = 2;
                                                            i12 = 0;
                                                            c4 = 0;
                                                            while (i12 < i17) {
                                                                i13 = compilerState.cp;
                                                                if (i13 < compilerState.cpend) {
                                                                    compilerState.cp = i13 + 1;
                                                                    iXDigitToInt = Kit.xDigitToInt(cArr[i13], c4);
                                                                    if (iXDigitToInt < 0) {
                                                                        int i27 = compilerState.cp - (i12 + 2);
                                                                        compilerState.cp = i27 + 1;
                                                                        c4 = cArr[i27];
                                                                    } else {
                                                                        i12++;
                                                                        c4 = iXDigitToInt;
                                                                    }
                                                                }
                                                                c7 = (char) c4;
                                                                doFlat(compilerState, c7);
                                                                break;
                                                            }
                                                            c7 = (char) c4;
                                                            doFlat(compilerState, c7);
                                                            break;
                                                        default:
                                                            rENode6 = new RENode((byte) 14);
                                                            compilerState.result = rENode6;
                                                            rENode6.chr = c11;
                                                            rENode6.length = 1;
                                                            rENode6.flatIndex = compilerState.cp - 1;
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                } else {
                                    doFlat(compilerState, '\n');
                                }
                            }
                            rENode3 = compilerState.result;
                            i3 = compilerState.cp;
                            if (i3 == compilerState.cpend) {
                                return true;
                            }
                            c = cArr[i3];
                            decimalValue = -1;
                            if (c != '*') {
                                if (c == '+') {
                                    rENode4 = new RENode((byte) 25);
                                    compilerState.result = rENode4;
                                    rENode4.min = 1;
                                } else if (c == '?') {
                                    RENode rENode9 = new RENode((byte) 25);
                                    compilerState.result = rENode9;
                                    rENode9.min = z ? 1 : 0;
                                    rENode9.max = 1;
                                    i4 = compilerState.progLength;
                                    compilerState.progLength = i4 + 8;
                                    z2 = true;
                                } else if (c != '{') {
                                    z2 = z;
                                } else {
                                    i6 = i3 + 1;
                                    compilerState.cp = i6;
                                    if (i6 < cArr.length) {
                                        c2 = cArr[i6];
                                        if (isDigit(c2)) {
                                            compilerState.cp++;
                                            decimalValue2 = getDecimalValue(c2, compilerState, 65535, "msg.overlarge.min");
                                            i7 = compilerState.cp;
                                            if (i7 >= cArr.length) {
                                                z2 = z;
                                            } else {
                                                c3 = cArr[i7];
                                                if (c3 == ',') {
                                                    i8 = i7 + 1;
                                                    compilerState.cp = i8;
                                                    if (i8 < cArr.length) {
                                                        c3 = cArr[i8];
                                                        if (isDigit(c3)) {
                                                            i9 = compilerState.cp + 1;
                                                            compilerState.cp = i9;
                                                            if (i9 < cArr.length) {
                                                                decimalValue = getDecimalValue(c3, compilerState, 65535, "msg.overlarge.max");
                                                                c3 = cArr[compilerState.cp];
                                                                if (decimalValue2 > decimalValue) {
                                                                    reportError("msg.max.lt.min", String.valueOf(c3));
                                                                    return z;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        decimalValue = decimalValue2;
                                                    }
                                                } else {
                                                    decimalValue = decimalValue2;
                                                }
                                                if (c3 == '}') {
                                                    RENode rENode10 = new RENode((byte) 25);
                                                    compilerState.result = rENode10;
                                                    rENode10.min = decimalValue2;
                                                    rENode10.max = decimalValue;
                                                    compilerState.progLength += 12;
                                                    z2 = true;
                                                } else {
                                                    z2 = z;
                                                }
                                            }
                                        } else {
                                            z2 = z;
                                        }
                                    } else {
                                        z2 = z;
                                    }
                                    if (!z2) {
                                        compilerState.cp = i3;
                                    }
                                }
                                if (!z2) {
                                    return true;
                                }
                                int i28 = compilerState.cp;
                                i5 = i28 + 1;
                                compilerState.cp = i5;
                                rENode5 = compilerState.result;
                                rENode5.kid = rENode3;
                                rENode5.parenIndex = i16;
                                rENode5.parenCount = compilerState.parenCount - i16;
                                if (i5 < compilerState.cpend || cArr[i5] != '?') {
                                    rENode5.greedy = true;
                                } else {
                                    compilerState.cp = i28 + 2;
                                    rENode5.greedy = false;
                                }
                                return true;
                            }
                            rENode4 = new RENode((byte) 25);
                            compilerState.result = rENode4;
                            rENode4.min = 0;
                            rENode4.max = -1;
                            i4 = compilerState.progLength;
                            compilerState.progLength = i4 + 8;
                            z2 = true;
                            if (!z2) {
                                return true;
                            }
                            int i29 = compilerState.cp;
                            i5 = i29 + 1;
                            compilerState.cp = i5;
                            rENode5 = compilerState.result;
                            rENode5.kid = rENode3;
                            rENode5.parenIndex = i16;
                            rENode5.parenCount = compilerState.parenCount - i16;
                            if (i5 < compilerState.cpend) {
                                rENode5.greedy = true;
                            } else {
                                rENode5.greedy = true;
                            }
                            return true;
                        }
                        RENode rENode11 = new RENode((byte) 22);
                        compilerState.result = rENode11;
                        int i30 = compilerState.cp;
                        rENode11.startIndex = i30;
                        while (true) {
                            int i31 = compilerState.cp;
                            if (i31 == compilerState.cpend) {
                                reportError("msg.unterm.class", "");
                                return false;
                            }
                            char c12 = cArr[i31];
                            if (c12 == '\\') {
                                compilerState.cp = i31 + 1;
                            } else if (c12 == ']') {
                                RENode rENode12 = compilerState.result;
                                rENode12.kidlen = i31 - i30;
                                int i32 = compilerState.classCount;
                                compilerState.classCount = i32 + 1;
                                rENode12.index = i32;
                                compilerState.cp = i31 + 1;
                                if (calculateBitmapSize(compilerState, rENode12, cArr, i30, i31)) {
                                    break;
                                }
                                return false;
                            }
                            compilerState.cp++;
                        }
                        i = compilerState.progLength;
                        i2 = 3;
                        compilerState.progLength = i + i2;
                        rENode3 = compilerState.result;
                        i3 = compilerState.cp;
                        if (i3 == compilerState.cpend) {
                            return true;
                        }
                        c = cArr[i3];
                        decimalValue = -1;
                        if (c != '*') {
                            if (c == '+') {
                                rENode4 = new RENode((byte) 25);
                                compilerState.result = rENode4;
                                rENode4.min = 1;
                            } else if (c == '?') {
                                RENode rENode13 = new RENode((byte) 25);
                                compilerState.result = rENode13;
                                rENode13.min = z ? 1 : 0;
                                rENode13.max = 1;
                                i4 = compilerState.progLength;
                                compilerState.progLength = i4 + 8;
                                z2 = true;
                            } else if (c != '{') {
                                z2 = z;
                            } else {
                                i6 = i3 + 1;
                                compilerState.cp = i6;
                                if (i6 < cArr.length) {
                                    c2 = cArr[i6];
                                    if (isDigit(c2)) {
                                        compilerState.cp++;
                                        decimalValue2 = getDecimalValue(c2, compilerState, 65535, "msg.overlarge.min");
                                        i7 = compilerState.cp;
                                        if (i7 >= cArr.length) {
                                            z2 = z;
                                        } else {
                                            c3 = cArr[i7];
                                            if (c3 == ',') {
                                                i8 = i7 + 1;
                                                compilerState.cp = i8;
                                                if (i8 < cArr.length) {
                                                    c3 = cArr[i8];
                                                    if (isDigit(c3)) {
                                                        i9 = compilerState.cp + 1;
                                                        compilerState.cp = i9;
                                                        if (i9 < cArr.length) {
                                                            decimalValue = getDecimalValue(c3, compilerState, 65535, "msg.overlarge.max");
                                                            c3 = cArr[compilerState.cp];
                                                            if (decimalValue2 > decimalValue) {
                                                                reportError("msg.max.lt.min", String.valueOf(c3));
                                                                return z;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    decimalValue = decimalValue2;
                                                }
                                            } else {
                                                decimalValue = decimalValue2;
                                            }
                                            if (c3 == '}') {
                                                RENode rENode14 = new RENode((byte) 25);
                                                compilerState.result = rENode14;
                                                rENode14.min = decimalValue2;
                                                rENode14.max = decimalValue;
                                                compilerState.progLength += 12;
                                                z2 = true;
                                            } else {
                                                z2 = z;
                                            }
                                        }
                                    } else {
                                        z2 = z;
                                    }
                                } else {
                                    z2 = z;
                                }
                                if (!z2) {
                                    compilerState.cp = i3;
                                }
                            }
                            if (!z2) {
                                return true;
                            }
                            int i210 = compilerState.cp;
                            i5 = i210 + 1;
                            compilerState.cp = i5;
                            rENode5 = compilerState.result;
                            rENode5.kid = rENode3;
                            rENode5.parenIndex = i16;
                            rENode5.parenCount = compilerState.parenCount - i16;
                            if (i5 < compilerState.cpend) {
                                rENode5.greedy = true;
                            } else {
                                rENode5.greedy = true;
                            }
                            return true;
                        }
                        rENode4 = new RENode((byte) 25);
                        compilerState.result = rENode4;
                        rENode4.min = 0;
                        rENode4.max = -1;
                        i4 = compilerState.progLength;
                        compilerState.progLength = i4 + 8;
                        z2 = true;
                        if (!z2) {
                            return true;
                        }
                        int i211 = compilerState.cp;
                        i5 = i211 + 1;
                        compilerState.cp = i5;
                        rENode5 = compilerState.result;
                        rENode5.kid = rENode3;
                        rENode5.parenIndex = i16;
                        rENode5.parenCount = compilerState.parenCount - i16;
                        if (i5 < compilerState.cpend) {
                            rENode5.greedy = true;
                        } else {
                            rENode5.greedy = true;
                        }
                        return true;
                    }
                    rENode = new RENode((byte) 2);
                }
                reportError("msg.bad.quant", String.valueOf(cArr[i14]));
                return z;
            }
            z = false;
            rENode2 = new RENode((byte) 6);
            compilerState.result = rENode2;
            i = compilerState.progLength;
            i2 = 1;
            compilerState.progLength = i + i2;
            rENode3 = compilerState.result;
            i3 = compilerState.cp;
            if (i3 == compilerState.cpend) {
                return true;
            }
            c = cArr[i3];
            decimalValue = -1;
            if (c != '*') {
                if (c == '+') {
                    rENode4 = new RENode((byte) 25);
                    compilerState.result = rENode4;
                    rENode4.min = 1;
                } else if (c == '?') {
                    RENode rENode15 = new RENode((byte) 25);
                    compilerState.result = rENode15;
                    rENode15.min = z ? 1 : 0;
                    rENode15.max = 1;
                    i4 = compilerState.progLength;
                    compilerState.progLength = i4 + 8;
                    z2 = true;
                } else if (c != '{') {
                    z2 = z;
                } else {
                    i6 = i3 + 1;
                    compilerState.cp = i6;
                    if (i6 < cArr.length) {
                        c2 = cArr[i6];
                        if (isDigit(c2)) {
                            compilerState.cp++;
                            decimalValue2 = getDecimalValue(c2, compilerState, 65535, "msg.overlarge.min");
                            i7 = compilerState.cp;
                            if (i7 >= cArr.length) {
                                z2 = z;
                            } else {
                                c3 = cArr[i7];
                                if (c3 == ',') {
                                    i8 = i7 + 1;
                                    compilerState.cp = i8;
                                    if (i8 < cArr.length) {
                                        c3 = cArr[i8];
                                        if (isDigit(c3)) {
                                            i9 = compilerState.cp + 1;
                                            compilerState.cp = i9;
                                            if (i9 < cArr.length) {
                                                decimalValue = getDecimalValue(c3, compilerState, 65535, "msg.overlarge.max");
                                                c3 = cArr[compilerState.cp];
                                                if (decimalValue2 > decimalValue) {
                                                    reportError("msg.max.lt.min", String.valueOf(c3));
                                                    return z;
                                                }
                                            }
                                        }
                                    } else {
                                        decimalValue = decimalValue2;
                                    }
                                } else {
                                    decimalValue = decimalValue2;
                                }
                                if (c3 == '}') {
                                    RENode rENode16 = new RENode((byte) 25);
                                    compilerState.result = rENode16;
                                    rENode16.min = decimalValue2;
                                    rENode16.max = decimalValue;
                                    compilerState.progLength += 12;
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                            }
                        } else {
                            z2 = z;
                        }
                    } else {
                        z2 = z;
                    }
                    if (!z2) {
                        compilerState.cp = i3;
                    }
                }
                if (!z2) {
                    return true;
                }
                int i212 = compilerState.cp;
                i5 = i212 + 1;
                compilerState.cp = i5;
                rENode5 = compilerState.result;
                rENode5.kid = rENode3;
                rENode5.parenIndex = i16;
                rENode5.parenCount = compilerState.parenCount - i16;
                if (i5 < compilerState.cpend) {
                    rENode5.greedy = true;
                } else {
                    rENode5.greedy = true;
                }
                return true;
            }
            rENode4 = new RENode((byte) 25);
            compilerState.result = rENode4;
            rENode4.min = 0;
            rENode4.max = -1;
            i4 = compilerState.progLength;
            compilerState.progLength = i4 + 8;
            z2 = true;
            if (!z2) {
                return true;
            }
            int i213 = compilerState.cp;
            i5 = i213 + 1;
            compilerState.cp = i5;
            rENode5 = compilerState.result;
            rENode5.kid = rENode3;
            rENode5.parenIndex = i16;
            rENode5.parenCount = compilerState.parenCount - i16;
            if (i5 < compilerState.cpend) {
                rENode5.greedy = true;
            } else {
                rENode5.greedy = true;
            }
            return true;
        }
        rENode = new RENode((byte) 3);
        compilerState.result = rENode;
        compilerState.progLength++;
        return true;
    }

    private static REProgState popProgState(REGlobalData rEGlobalData) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.stateStackTop = rEProgState.previous;
        return rEProgState;
    }

    private static void processCharSet(REGlobalData rEGlobalData, RECharSet rECharSet) {
        synchronized (rECharSet) {
            if (!rECharSet.converted) {
                processCharSetImpl(rEGlobalData, rECharSet);
                rECharSet.converted = true;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0057. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x005a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x005d. Please report as an issue. */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:60:0x00d9
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static void processCharSetImpl(external.sdk.pendo.io.mozilla.javascript.regexp.REGlobalData r16, external.sdk.pendo.io.mozilla.javascript.regexp.RECharSet r17) {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.processCharSetImpl(external.sdk.pendo.io.mozilla.javascript.regexp.REGlobalData, external.sdk.pendo.io.mozilla.javascript.regexp.RECharSet):void");
    }

    private static void pushBackTrackState(REGlobalData rEGlobalData, byte b, int i) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b, i, rEGlobalData.cp, rEProgState.continuationOp, rEProgState.continuationPc);
    }

    private static void pushProgState(REGlobalData rEGlobalData, int i, int i2, int i3, REBackTrackData rEBackTrackData, int i4, int i5) {
        rEGlobalData.stateStackTop = new REProgState(rEGlobalData.stateStackTop, i, i2, i3, rEBackTrackData, i4, i5);
    }

    private static NativeRegExp realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeRegExp) {
            return (NativeRegExp) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    private static boolean reopIsSimple(int i) {
        return i >= 1 && i <= 23;
    }

    private static void reportError(String str, String str2) {
        throw ScriptRuntime.constructError("SyntaxError", ScriptRuntime.getMessage1(str, str2));
    }

    private static void reportWarning(Context context, String str, String str2) {
        if (context.hasFeature(11)) {
            Context.reportWarning(ScriptRuntime.getMessage1(str, str2));
        }
    }

    private static void resolveForwardJump(byte[] bArr, int i, int i2) {
        if (i > i2) {
            throw Kit.codeBug();
        }
        addIndex(bArr, i, i2 - i);
    }

    private void setLastIndex(Object obj) {
        if ((this.lastIndexAttr & 1) != 0) {
            throw ScriptRuntime.typeError1("msg.modify.readonly", "lastIndex");
        }
        this.lastIndex = obj;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:102:0x0180 A[PHI: r7
      0x0180: PHI (r7v9 int) = 
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v5 int)
      (r7v7 int)
      (r7v7 int)
      (r7v8 int)
      (r7v8 int)
      (r7v11 int)
      (r7v11 int)
     binds: [B:99:0x0172, B:101:0x017e, B:93:0x0161, B:95:0x016b, B:63:0x0105, B:65:0x010f, B:59:0x00f8, B:61:0x0102, B:55:0x00eb, B:57:0x00f5, B:51:0x00de, B:53:0x00e8, B:47:0x00d1, B:49:0x00db, B:43:0x00c4, B:45:0x00ce, B:39:0x00b7, B:41:0x00c1, B:36:0x0096, B:19:0x004e, B:21:0x0054, B:12:0x0031, B:16:0x0041, B:7:0x0014, B:9:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:104:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x0185  */
    /* JADX WARN: Code duplicated, block: B:107:0x0188  */
    /* JADX WARN: Code duplicated, block: B:66:0x0111 A[PHI: r7
      0x0111: PHI (r7v10 int) = 
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v6 int)
      (r7v7 int)
      (r7v8 int)
      (r7v8 int)
      (r7v11 int)
     binds: [B:65:0x010f, B:61:0x0102, B:57:0x00f5, B:53:0x00e8, B:49:0x00db, B:45:0x00ce, B:41:0x00c1, B:29:0x0071, B:21:0x0054, B:14:0x0037, B:16:0x0041, B:9:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x015a A[PHI: r5
      0x015a: PHI (r5v10 boolean) = (r5v5 boolean), (r5v13 boolean), (r5v13 boolean) binds: [B:87:0x0157, B:74:0x012c, B:76:0x0136] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
    
        if (upcase(r6) == upcase(r4)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0093, code lost:
    
        if (r4.charAt(r0) == r6) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int simpleMatch(external.sdk.pendo.io.mozilla.javascript.regexp.REGlobalData r3, java.lang.String r4, int r5, byte[] r6, int r7, int r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.simpleMatch(external.sdk.pendo.io.mozilla.javascript.regexp.REGlobalData, java.lang.String, int, byte[], int, int, boolean):int");
    }

    private static int toASCIIHexDigit(int i) {
        if (i < 48) {
            return -1;
        }
        if (i <= 57) {
            return i - 48;
        }
        int i2 = i | 32;
        if (97 > i2 || i2 > 102) {
            return -1;
        }
        return i2 - 87;
    }

    private static char upcase(char c) {
        if (c >= 128) {
            char upperCase = Character.toUpperCase(c);
            if (upperCase >= 128) {
                return upperCase;
            }
        } else if ('a' <= c && c <= 'z') {
            return (char) (c - ' ');
        }
        return c;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Function, external.sdk.pendo.io.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (context.getLanguageVersion() < 200) {
            return execSub(context, scriptable, objArr, 1);
        }
        throw ScriptRuntime.notFunctionError(scriptable2);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0029  */
    /* JADX WARN: Code duplicated, block: B:18:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0033  */
    /* JADX WARN: Code duplicated, block: B:22:0x0038  */
    /* JADX WARN: Code duplicated, block: B:28:0x0048  */
    Scriptable compile(Context context, Scriptable scriptable, Object[] objArr) {
        String strEscapeRegExp;
        String string;
        Object obj;
        Object obj2;
        Object obj3;
        if (objArr.length > 0) {
            Object obj4 = objArr[0];
            if (!(obj4 instanceof NativeRegExp)) {
                if (objArr.length != 0) {
                    obj3 = objArr[0];
                    if (obj3 instanceof Undefined) {
                        strEscapeRegExp = "";
                    } else {
                        strEscapeRegExp = escapeRegExp(obj3);
                    }
                } else {
                    strEscapeRegExp = "";
                }
                if (objArr.length > 1 || (obj2 = objArr[1]) == Undefined.instance) {
                    string = null;
                } else {
                    string = ScriptRuntime.toString(obj2);
                }
                this.re = compileRE(context, strEscapeRegExp, string, false);
                obj = ScriptRuntime.zeroObj;
            } else {
                if (objArr.length > 1 && objArr[1] != Undefined.instance) {
                    throw ScriptRuntime.typeError0("msg.bad.regexp.compile");
                }
                NativeRegExp nativeRegExp = (NativeRegExp) obj4;
                this.re = nativeRegExp.re;
                obj = nativeRegExp.lastIndex;
            }
        } else {
            if (objArr.length != 0) {
                obj3 = objArr[0];
                if (obj3 instanceof Undefined) {
                    strEscapeRegExp = "";
                } else {
                    strEscapeRegExp = escapeRegExp(obj3);
                }
            } else {
                strEscapeRegExp = "";
            }
            if (objArr.length > 1) {
                string = null;
            } else {
                string = null;
            }
            this.re = compileRE(context, strEscapeRegExp, string, false);
            obj = ScriptRuntime.zeroObj;
        }
        setLastIndex(obj);
        return this;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        if (context.getLanguageVersion() < 200) {
            return (Scriptable) execSub(context, scriptable, objArr, 1);
        }
        throw ScriptRuntime.notFunctionError(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(REGEXP_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        switch (iMethodId) {
            case 1:
                return realThis(scriptable2, idFunctionObject).compile(context, scriptable, objArr);
            case 2:
            case 3:
                return realThis(scriptable2, idFunctionObject).toString();
            case 4:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 1);
            case 5:
                Object objExecSub = realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 0);
                Boolean bool = Boolean.TRUE;
                return bool.equals(objExecSub) ? bool : Boolean.FALSE;
            case 6:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 2);
            case 7:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 1);
            case 8:
                Scriptable scriptable3 = (Scriptable) realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 1);
                return scriptable3.get(FirebaseAnalytics.Param.INDEX, scriptable3);
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    Object executeRegExp(Context context, Scriptable scriptable, RegExpImpl regExpImpl, String str, int[] iArr, int i) {
        Context context2;
        Scriptable scriptable2;
        Object obj;
        int i2;
        Object string;
        NativeRegExp nativeRegExp = this;
        REGlobalData rEGlobalData = new REGlobalData();
        int i3 = iArr[0];
        int length = str.length();
        int i4 = i3 > length ? length : i3;
        SubString subString = null;
        if (!matchRegExp(rEGlobalData, nativeRegExp.re, str, i4, length, regExpImpl.multiline)) {
            if (i != 2) {
                return null;
            }
            return Undefined.instance;
        }
        int i5 = rEGlobalData.cp;
        iArr[0] = i5;
        int i6 = i5 - (rEGlobalData.skipped + i4);
        int i7 = i5 - i6;
        if (i == 0) {
            scriptable2 = null;
            obj = Boolean.TRUE;
            context2 = context;
        } else {
            context2 = context;
            Scriptable scriptableNewArray = context2.newArray(scriptable, 0);
            scriptableNewArray.put(0, scriptableNewArray, str.substring(i7, i7 + i6));
            scriptable2 = scriptableNewArray;
            obj = scriptableNewArray;
        }
        int i8 = nativeRegExp.re.parenCount;
        if (i8 == 0) {
            regExpImpl.parens = null;
            regExpImpl.lastParen = new SubString();
        } else {
            regExpImpl.parens = new SubString[i8];
            int i9 = 0;
            while (i9 < nativeRegExp.re.parenCount) {
                int iParensIndex = rEGlobalData.parensIndex(i9);
                if (iParensIndex != -1) {
                    subString = new SubString(str, iParensIndex, rEGlobalData.parensLength(i9));
                    regExpImpl.parens[i9] = subString;
                    if (i != 0) {
                        i2 = i9 + 1;
                        string = subString.toString();
                        scriptable2.put(i2, scriptable2, string);
                    }
                } else if (i != 0) {
                    i2 = i9 + 1;
                    string = Undefined.instance;
                    scriptable2.put(i2, scriptable2, string);
                }
                i9++;
                nativeRegExp = this;
            }
            regExpImpl.lastParen = subString;
        }
        if (i != 0) {
            scriptable2.put(FirebaseAnalytics.Param.INDEX, scriptable2, Integer.valueOf(rEGlobalData.skipped + i4));
            scriptable2.put("input", scriptable2, str);
        }
        if (regExpImpl.lastMatch == null) {
            regExpImpl.lastMatch = new SubString();
            regExpImpl.leftContext = new SubString();
            regExpImpl.rightContext = new SubString();
        }
        SubString subString2 = regExpImpl.lastMatch;
        subString2.str = str;
        subString2.index = i7;
        subString2.length = i6;
        regExpImpl.leftContext.str = str;
        if (context2.getLanguageVersion() == 120) {
            SubString subString3 = regExpImpl.leftContext;
            subString3.index = i4;
            subString3.length = rEGlobalData.skipped;
        } else {
            SubString subString4 = regExpImpl.leftContext;
            subString4.index = 0;
            subString4.length = i4 + rEGlobalData.skipped;
        }
        SubString subString5 = regExpImpl.rightContext;
        subString5.str = str;
        subString5.index = i5;
        subString5.length = length - i5;
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0044  */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int i2;
        int length = str.length();
        if (length == 6) {
            char cCharAt = str.charAt(0);
            if (cCharAt == 'g') {
                str2 = "global";
                i = 3;
            } else if (cCharAt == 's') {
                str2 = "source";
                i = 2;
            } else {
                str2 = null;
                i = 0;
            }
        } else if (length == 9) {
            char cCharAt2 = str.charAt(0);
            if (cCharAt2 == 'l') {
                str2 = "lastIndex";
                i = 1;
            } else if (cCharAt2 == 'm') {
                str2 = "multiline";
                i = 5;
            } else {
                str2 = null;
                i = 0;
            }
        } else if (length == 10) {
            str2 = "ignoreCase";
            i = 4;
        } else {
            str2 = null;
            i = 0;
        }
        int i3 = (str2 == null || str2 == str || str2.equals(str)) ? i : 0;
        if (i3 == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i3 == 1) {
            i2 = this.lastIndexAttr;
        } else {
            if (i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5) {
                throw new IllegalStateException();
            }
            i2 = 7;
        }
        return IdScriptableObject.instanceIdInfo(i2, i3);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(Symbol symbol) {
        if (SymbolKey.MATCH.equals(symbol)) {
            return 7;
        }
        return SymbolKey.SEARCH.equals(symbol) ? 8 : 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "RegExp";
    }

    int getFlags() {
        return this.re.flags;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        if (i == 1) {
            return "lastIndex";
        }
        if (i == 2) {
            return "source";
        }
        if (i == 3) {
            return "global";
        }
        if (i != 4) {
            return i != 5 ? super.getInstanceIdName(i) : "multiline";
        }
        return "ignoreCase";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        if (i == 1) {
            return this.lastIndex;
        }
        if (i == 2) {
            return new String(this.re.source);
        }
        if (i == 3) {
            return ScriptRuntime.wrapBoolean((this.re.flags & 1) != 0);
        }
        if (i == 4) {
            return ScriptRuntime.wrapBoolean((this.re.flags & 2) != 0);
        }
        if (i != 5) {
            return super.getInstanceIdValue(i);
        }
        return ScriptRuntime.wrapBoolean((this.re.flags & 4) != 0);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 5;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    public String getTypeOf() {
        return "object";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        if (i == 7) {
            initPrototypeMethod(REGEXP_TAG, i, SymbolKey.MATCH, "[Symbol.match]", 1);
            return;
        }
        if (i == 8) {
            initPrototypeMethod(REGEXP_TAG, i, SymbolKey.SEARCH, "[Symbol.search]", 1);
            return;
        }
        int i2 = 0;
        int i3 = 1;
        switch (i) {
            case 1:
                i2 = 2;
                str = "compile";
                String str3 = str;
                i3 = i2;
                str2 = str3;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 2:
                str = "toString";
                String str4 = str;
                i3 = i2;
                str2 = str4;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 3:
                str = "toSource";
                String str5 = str;
                i3 = i2;
                str2 = str5;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 4:
                str2 = "exec";
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 5:
                str2 = "test";
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 6:
                str2 = "prefix";
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdAttributes(int i, int i2) {
        if (i != 1) {
            super.setInstanceIdAttributes(i, i2);
        } else {
            this.lastIndexAttr = i2;
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            setLastIndex(obj);
        } else {
            if (i == 2 || i == 3 || i == 4 || i == 5) {
                return;
            }
            super.setInstanceIdValue(i, obj);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("/");
        char[] cArr = this.re.source;
        if (cArr.length != 0) {
            sb.append(cArr);
        } else {
            sb.append("(?:)");
        }
        sb.append('/');
        if ((this.re.flags & 1) != 0) {
            sb.append('g');
        }
        if ((this.re.flags & 2) != 0) {
            sb.append('i');
        }
        if ((this.re.flags & 4) != 0) {
            sb.append('m');
        }
        return sb.toString();
    }

    NativeRegExp(Scriptable scriptable, RECompiled rECompiled) {
        Double d = ScriptRuntime.zeroObj;
        this.lastIndex = d;
        this.lastIndexAttr = 6;
        this.re = rECompiled;
        setLastIndex(d);
        ScriptRuntime.setBuiltinProtoAndParent(this, scriptable, TopLevel.Builtins.RegExp);
    }

    private static void pushBackTrackState(REGlobalData rEGlobalData, byte b, int i, int i2, int i3, int i4) {
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b, i, i2, i3, i4);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 4;
        if (length != 4) {
            i = 6;
            if (length == 6) {
                str2 = "prefix";
            } else if (length == 7) {
                str2 = "compile";
                i = 1;
            } else if (length != 8) {
                str2 = null;
                i = 0;
            } else {
                i = 3;
                char cCharAt = str.charAt(3);
                if (cCharAt == 'o') {
                    str2 = "toSource";
                } else if (cCharAt == 't') {
                    str2 = "toString";
                    i = 2;
                } else {
                    str2 = null;
                    i = 0;
                }
            }
        } else {
            char cCharAt2 = str.charAt(0);
            if (cCharAt2 == 'e') {
                str2 = "exec";
            } else if (cCharAt2 == 't') {
                str2 = "test";
                i = 5;
            } else {
                str2 = null;
                i = 0;
            }
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
