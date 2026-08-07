package external.sdk.pendo.io.mozilla.javascript.optimizer;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.ts.TsExtractor;
import external.sdk.pendo.io.mozilla.javascript.CompilerEnvirons;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Evaluator;
import external.sdk.pendo.io.mozilla.javascript.Function;
import external.sdk.pendo.io.mozilla.javascript.GeneratedClassLoader;
import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.NativeFunction;
import external.sdk.pendo.io.mozilla.javascript.ObjArray;
import external.sdk.pendo.io.mozilla.javascript.ObjToIntMap;
import external.sdk.pendo.io.mozilla.javascript.RhinoException;
import external.sdk.pendo.io.mozilla.javascript.Script;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.SecurityController;
import external.sdk.pendo.io.mozilla.javascript.Token;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode;
import external.sdk.pendo.io.mozilla.javascript.ast.Name;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;
import java.util.HashMap;
import java.util.List;
import sdk.pendo.io.d2.c;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: loaded from: classes4.dex */
public class Codegen implements Evaluator {
    static final String DEFAULT_MAIN_METHOD_CLASS = "external.sdk.pendo.io.mozilla.javascript.optimizer.OptRuntime";
    static final String FUNCTION_CONSTRUCTOR_SIGNATURE = "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V";
    static final String FUNCTION_INIT_SIGNATURE = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V";
    static final String ID_FIELD_NAME = "_id";
    static final String REGEXP_INIT_METHOD_NAME = "_reInit";
    static final String REGEXP_INIT_METHOD_SIGNATURE = "(Lorg/mozilla/javascript/Context;)V";
    private static final String SUPER_CLASS_NAME = "external.sdk.pendo.io.mozilla.javascript.NativeFunction";
    private static final Object globalLock = new Object();
    private static int globalSerialClassCounter;
    private CompilerEnvirons compilerEnv;
    private ObjArray directCallTargets;
    private double[] itsConstantList;
    private int itsConstantListSize;
    String mainClassName;
    String mainClassSignature;
    private String mainMethodClass = DEFAULT_MAIN_METHOD_CLASS;
    private ObjToIntMap scriptOrFnIndexes;
    ScriptNode[] scriptOrFnNodes;

    private static void addDoubleWrap(c cVar) {
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime", "wrapDouble", "(D)Ljava/lang/Double;");
    }

    static RuntimeException badTree() {
        throw new RuntimeException("Bad tree in codegen");
    }

    private static void collectScriptNodes_r(ScriptNode scriptNode, ObjArray objArray) {
        objArray.add(scriptNode);
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            collectScriptNodes_r(scriptNode.getFunctionNode(i), objArray);
        }
    }

    private Class<?> defineClass(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        String str = (String) objArr[0];
        byte[] bArr = (byte[]) objArr[1];
        GeneratedClassLoader generatedClassLoaderCreateLoader = SecurityController.createLoader(getClass().getClassLoader(), obj2);
        try {
            Class<?> clsDefineClass = generatedClassLoaderCreateLoader.defineClass(str, bArr);
            generatedClassLoaderCreateLoader.linkClass(clsDefineClass);
            return clsDefineClass;
        } catch (IllegalArgumentException | SecurityException e) {
            throw new RuntimeException("Malformed optimizer package " + e);
        }
    }

    private void emitConstantDudeInitializers(c cVar) {
        int i = this.itsConstantListSize;
        if (i == 0) {
            return;
        }
        cVar.b("<clinit>", "()V", (short) 24);
        double[] dArr = this.itsConstantList;
        for (int i2 = 0; i2 != i; i2++) {
            double d = dArr[i2];
            String str = "_k" + i2;
            String staticConstantWrapperType = getStaticConstantWrapperType(d);
            cVar.a(str, staticConstantWrapperType, (short) 10);
            int i3 = (int) d;
            if (i3 == d) {
                cVar.l(i3);
                cVar.b(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else {
                cVar.b(d);
                addDoubleWrap(cVar);
            }
            cVar.a(179, this.mainClassName, str, staticConstantWrapperType);
        }
        cVar.b(177);
        cVar.c((short) 0);
    }

    private void emitDirectConstructor(c cVar, OptFunctionNode optFunctionNode) {
        cVar.b(getDirectCtorName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode), (short) 10);
        int paramCount = optFunctionNode.fnode.getParamCount();
        int i = paramCount * 3;
        int i2 = i + 4;
        int i3 = i + 5;
        cVar.c(0);
        cVar.c(1);
        cVar.c(2);
        cVar.b(182, "external/sdk/pendo/io/mozilla/javascript/BaseFunction", "createObject", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        cVar.d(i3);
        cVar.c(0);
        cVar.c(1);
        cVar.c(2);
        cVar.c(i3);
        for (int i4 = 0; i4 < paramCount; i4++) {
            int i5 = i4 * 3;
            cVar.c(i5 + 4);
            cVar.e(i5 + 5);
        }
        cVar.c(i2);
        cVar.b(184, this.mainClassName, getBodyMethodName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode));
        int iA = cVar.a();
        cVar.b(89);
        cVar.a(193, "external/sdk/pendo/io/mozilla/javascript/Scriptable");
        cVar.a(Token.SET, iA);
        cVar.a(192, "external/sdk/pendo/io/mozilla/javascript/Scriptable");
        cVar.b(176);
        cVar.w(iA);
        cVar.c(i3);
        cVar.b(176);
        cVar.c((short) (i + 6));
    }

    private void emitRegExpInit(c cVar) {
        int i = 0;
        int i2 = 0;
        int regexpCount = 0;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i2 == scriptNodeArr.length) {
                break;
            }
            regexpCount += scriptNodeArr[i2].getRegexpCount();
            i2++;
        }
        if (regexpCount == 0) {
            return;
        }
        short s = 10;
        cVar.b(REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE, (short) 10);
        cVar.a("_reInitDone", "Z", (short) 74);
        cVar.a(178, this.mainClassName, "_reInitDone", "Z");
        int iA = cVar.a();
        cVar.a(Token.SET, iA);
        cVar.b(177);
        cVar.w(iA);
        cVar.c(0);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "checkRegExpProxy", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/RegExpProxy;");
        cVar.d(1);
        int i3 = 0;
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i3 == scriptNodeArr2.length) {
                cVar.l(1);
                cVar.a(179, this.mainClassName, "_reInitDone", "Z");
                cVar.b(177);
                cVar.c((short) 2);
                return;
            }
            ScriptNode scriptNode = scriptNodeArr2[i3];
            int regexpCount2 = scriptNode.getRegexpCount();
            int i4 = i;
            while (i4 != regexpCount2) {
                String compiledRegexpName = getCompiledRegexpName(scriptNode, i4);
                String regexpString = scriptNode.getRegexpString(i4);
                String regexpFlags = scriptNode.getRegexpFlags(i4);
                cVar.a(compiledRegexpName, "Ljava/lang/Object;", s);
                cVar.c(1);
                cVar.c(i);
                cVar.e(regexpString);
                if (regexpFlags == null) {
                    cVar.b(1);
                } else {
                    cVar.e(regexpFlags);
                }
                cVar.b(185, "external/sdk/pendo/io/mozilla/javascript/RegExpProxy", "compileRegExp", "(Lorg/mozilla/javascript/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;");
                cVar.a(179, this.mainClassName, compiledRegexpName, "Ljava/lang/Object;");
                i4++;
                i = 0;
                s = 10;
            }
            i3++;
            i = 0;
            s = 10;
        }
    }

    private void generateCallMethod(c cVar, boolean z) {
        int iC;
        int paramCount;
        cVar.b(NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        int iA = cVar.a();
        cVar.c(1);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "hasTopCall", "(Lorg/mozilla/javascript/Context;)Z");
        cVar.a(Token.LET, iA);
        int i = 0;
        cVar.c(0);
        cVar.c(1);
        cVar.c(2);
        cVar.c(3);
        cVar.c(4);
        cVar.a(z);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "doTopCall", "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Ljava/lang/Object;");
        cVar.b(176);
        cVar.w(iA);
        cVar.c(0);
        cVar.c(1);
        cVar.c(2);
        cVar.c(3);
        cVar.c(4);
        int length = this.scriptOrFnNodes.length;
        boolean z2 = 2 <= length;
        if (z2) {
            cVar.b();
            cVar.a(180, cVar.f(), "_id", "I");
            iC = cVar.c(1, length - 1);
        } else {
            iC = 0;
        }
        int i2 = 0;
        short sH = 0;
        while (i2 != length) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i2];
            if (z2) {
                if (i2 == 0) {
                    cVar.x(iC);
                    sH = cVar.h();
                } else {
                    cVar.a(iC, i2 - 1, sH);
                }
            }
            if (scriptNode.getType() == 110) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                if (optFunctionNode.isTargetOfDirectCall() && (paramCount = optFunctionNode.fnode.getParamCount()) != 0) {
                    for (int i3 = i; i3 != paramCount; i3++) {
                        cVar.b(190);
                        cVar.l(i3);
                        int iA2 = cVar.a();
                        int iA3 = cVar.a();
                        cVar.a(Token.METHOD, iA2);
                        cVar.c(4);
                        cVar.l(i3);
                        cVar.b(50);
                        cVar.a(Token.LAST_TOKEN, iA3);
                        cVar.w(iA2);
                        pushUndefined(cVar);
                        cVar.w(iA3);
                        cVar.q(-1);
                        cVar.b(0.0d);
                        cVar.c(4);
                    }
                }
            }
            cVar.b(184, this.mainClassName, getBodyMethodName(scriptNode), getBodyMethodSignature(scriptNode));
            cVar.b(176);
            i2++;
            i = 0;
        }
        cVar.c((short) 5);
    }

    private byte[] generateCode(String str) {
        boolean z = true;
        boolean z2 = this.scriptOrFnNodes[0].getType() == 137;
        ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
        if (scriptNodeArr.length <= 1 && z2) {
            z = false;
        }
        boolean zIsInStrictMode = scriptNodeArr[0].isInStrictMode();
        c cVar = new c(this.mainClassName, SUPER_CLASS_NAME, this.compilerEnv.isGenerateDebugInfo() ? this.scriptOrFnNodes[0].getSourceName() : null);
        cVar.a("_id", "I", (short) 2);
        if (z) {
            generateFunctionConstructor(cVar);
        }
        if (z2) {
            cVar.c("external/sdk/pendo/io/mozilla/javascript/Script");
            generateScriptCtor(cVar);
            generateMain(cVar);
            generateExecute(cVar);
        }
        generateCallMethod(cVar, zIsInStrictMode);
        generateResumeGenerator(cVar);
        generateNativeFunctionOverrides(cVar, str);
        int length = this.scriptOrFnNodes.length;
        for (int i = 0; i != length; i++) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i];
            BodyCodegen bodyCodegen = new BodyCodegen();
            bodyCodegen.cfw = cVar;
            bodyCodegen.codegen = this;
            bodyCodegen.compilerEnv = this.compilerEnv;
            bodyCodegen.scriptOrFn = scriptNode;
            bodyCodegen.scriptOrFnIndex = i;
            bodyCodegen.generateBodyCode();
            if (scriptNode.getType() == 110) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                generateFunctionInit(cVar, optFunctionNode);
                if (optFunctionNode.isTargetOfDirectCall()) {
                    emitDirectConstructor(cVar, optFunctionNode);
                }
            }
        }
        emitRegExpInit(cVar);
        emitConstantDudeInitializers(cVar);
        return cVar.j();
    }

    private static void generateExecute(c cVar) {
        cVar.b("exec", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;", (short) 17);
        cVar.b();
        cVar.c(1);
        cVar.c(2);
        cVar.b(89);
        cVar.b(1);
        cVar.b(182, cVar.f(), NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        cVar.b(176);
        cVar.c((short) 3);
    }

    private void generateFunctionConstructor(c cVar) {
        int iC;
        cVar.b("<init>", FUNCTION_CONSTRUCTOR_SIGNATURE, (short) 1);
        short sH = 0;
        cVar.c(0);
        cVar.b(183, SUPER_CLASS_NAME, "<init>", "()V");
        cVar.b();
        cVar.h(3);
        cVar.a(181, cVar.f(), "_id", "I");
        cVar.b();
        cVar.c(2);
        cVar.c(1);
        int i = this.scriptOrFnNodes[0].getType() == 137 ? 1 : 0;
        int length = this.scriptOrFnNodes.length;
        if (i == length) {
            throw badTree();
        }
        boolean z = 2 <= length - i;
        if (z) {
            cVar.h(3);
            iC = cVar.c(i + 1, length - 1);
        } else {
            iC = 0;
        }
        for (int i2 = i; i2 != length; i2++) {
            if (z) {
                if (i2 == i) {
                    cVar.x(iC);
                    sH = cVar.h();
                } else {
                    cVar.a(iC, (i2 - 1) - i, sH);
                }
            }
            cVar.b(183, this.mainClassName, getFunctionInitMethodName(OptFunctionNode.get(this.scriptOrFnNodes[i2])), FUNCTION_INIT_SIGNATURE);
            cVar.b(177);
        }
        cVar.c((short) 4);
    }

    private void generateFunctionInit(c cVar, OptFunctionNode optFunctionNode) {
        cVar.b(getFunctionInitMethodName(optFunctionNode), FUNCTION_INIT_SIGNATURE, (short) 18);
        cVar.b();
        cVar.c(1);
        cVar.c(2);
        cVar.b(182, "external/sdk/pendo/io/mozilla/javascript/NativeFunction", "initScriptFunction", FUNCTION_INIT_SIGNATURE);
        if (optFunctionNode.fnode.getRegexpCount() != 0) {
            cVar.c(1);
            cVar.b(184, this.mainClassName, REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE);
        }
        cVar.b(177);
        cVar.c((short) 3);
    }

    private void generateMain(c cVar) {
        cVar.b("main", "([Ljava/lang/String;)V", (short) 9);
        cVar.a(187, cVar.f());
        cVar.b(89);
        cVar.b(183, cVar.f(), "<init>", "()V");
        cVar.b(42);
        cVar.b(184, this.mainMethodClass, "main", "(Lorg/mozilla/javascript/Script;[Ljava/lang/String;)V");
        cVar.b(177);
        cVar.c((short) 1);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0082  */
    /* JADX WARN: Code duplicated, block: B:28:0x0087  */
    /* JADX WARN: Code duplicated, block: B:30:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x008f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0097  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:39:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:49:0x00da  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:58:0x0118  */
    /* JADX WARN: Code duplicated, block: B:60:0x011f  */
    /* JADX WARN: Code duplicated, block: B:61:0x0123 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x0125  */
    /* JADX WARN: Code duplicated, block: B:63:0x012d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0139  */
    /* JADX WARN: Code duplicated, block: B:67:0x013f  */
    /* JADX WARN: Code duplicated, block: B:70:0x0148  */
    /* JADX WARN: Code duplicated, block: B:71:0x014c  */
    /* JADX WARN: Code duplicated, block: B:73:0x0160  */
    /* JADX WARN: Code duplicated, block: B:74:0x016a  */
    /* JADX WARN: Code duplicated, block: B:76:0x0175  */
    /* JADX WARN: Code duplicated, block: B:78:0x017d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0180  */
    /* JADX WARN: Code duplicated, block: B:87:0x00a1 A[SYNTHETIC] */
    private void generateNativeFunctionOverrides(c cVar, String str) {
        String str2;
        short s;
        int length;
        int iC;
        int i;
        short sH;
        ScriptNode scriptNode;
        String name;
        int paramAndVarCount;
        int iC2;
        int i2;
        int paramAndVarCount2;
        boolean[] paramAndVarConst;
        int iC3;
        int i3;
        boolean zIsES6Generator;
        short s2 = 1;
        cVar.b("getLanguageVersion", "()I", (short) 1);
        cVar.l(this.compilerEnv.getLanguageVersion());
        int i4 = TsExtractor.TS_STREAM_TYPE_AC4;
        cVar.b(TsExtractor.TS_STREAM_TYPE_AC4);
        cVar.c((short) 1);
        int i5 = 0;
        while (i5 != 7) {
            if (i5 != 4 || str != null) {
                int i6 = 3;
                switch (i5) {
                    case 0:
                        cVar.b("getFunctionName", "()Ljava/lang/String;", s2);
                        s = s2;
                        length = this.scriptOrFnNodes.length;
                        if (length > s2) {
                            cVar.b();
                            cVar.a(180, cVar.f(), "_id", "I");
                            iC = cVar.c(s2, length - 1);
                        } else {
                            iC = 0;
                        }
                        i = 0;
                        sH = 0;
                        while (i != length) {
                            scriptNode = this.scriptOrFnNodes[i];
                            if (i != 0) {
                                cVar.a(iC, i - 1, sH);
                            } else if (length > s2) {
                                cVar.x(iC);
                                sH = cVar.h();
                            }
                            switch (i5) {
                                case 0:
                                    if (scriptNode.getType() == 137) {
                                        name = "";
                                    } else {
                                        name = ((FunctionNode) scriptNode).getName();
                                    }
                                    cVar.e(name);
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 1:
                                    cVar.l(scriptNode.getParamCount());
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 2:
                                    cVar.l(scriptNode.getParamAndVarCount());
                                    i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 3:
                                    paramAndVarCount = scriptNode.getParamAndVarCount();
                                    if (paramAndVarCount != 0) {
                                        if (paramAndVarCount == 1) {
                                            cVar.e(scriptNode.getParamOrVarName(0));
                                        } else {
                                            cVar.h(1);
                                            iC2 = cVar.c(1, paramAndVarCount - 1);
                                            i2 = 0;
                                            while (i2 != paramAndVarCount) {
                                                if (cVar.h() != 0) {
                                                    Kit.codeBug();
                                                }
                                                String paramOrVarName = scriptNode.getParamOrVarName(i2);
                                                if (i2 == 0) {
                                                    cVar.x(iC2);
                                                } else {
                                                    cVar.a(iC2, i2 - 1, 0);
                                                }
                                                cVar.e(paramOrVarName);
                                                cVar.b(176);
                                                i2++;
                                                i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                            }
                                        }
                                        i++;
                                        s2 = 1;
                                        i6 = 3;
                                    } else {
                                        cVar.b(1);
                                    }
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 4:
                                    cVar.l(scriptNode.getEncodedSourceStart());
                                    cVar.l(scriptNode.getEncodedSourceEnd());
                                    cVar.b(182, "java/lang/String", "substring", "(II)Ljava/lang/String;");
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 5:
                                    paramAndVarCount2 = scriptNode.getParamAndVarCount();
                                    paramAndVarConst = scriptNode.getParamAndVarConst();
                                    if (paramAndVarCount2 == 0) {
                                        cVar.b(i6);
                                        cVar.b(i4);
                                    } else if (paramAndVarCount2 == s2) {
                                        zIsES6Generator = paramAndVarConst[0];
                                        cVar.a(zIsES6Generator);
                                        cVar.b(i4);
                                    } else {
                                        cVar.h(s2);
                                        iC3 = cVar.c(s2, paramAndVarCount2 - 1);
                                        for (i3 = 0; i3 != paramAndVarCount2; i3++) {
                                            if (cVar.h() != 0) {
                                                Kit.codeBug();
                                            }
                                            if (i3 == 0) {
                                                cVar.x(iC3);
                                            } else {
                                                cVar.a(iC3, i3 - 1, 0);
                                            }
                                            cVar.a(paramAndVarConst[i3]);
                                            cVar.b(i4);
                                        }
                                    }
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 6:
                                    if (scriptNode instanceof FunctionNode) {
                                        zIsES6Generator = ((FunctionNode) scriptNode).isES6Generator();
                                        cVar.a(zIsES6Generator);
                                    } else {
                                        cVar.a(false);
                                    }
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                default:
                                    throw Kit.codeBug();
                            }
                        }
                        cVar.c(s);
                        break;
                    case 1:
                        str2 = "getParamCount";
                        cVar.b(str2, "()I", s2);
                        s = s2;
                        length = this.scriptOrFnNodes.length;
                        if (length > s2) {
                            cVar.b();
                            cVar.a(180, cVar.f(), "_id", "I");
                            iC = cVar.c(s2, length - 1);
                        } else {
                            iC = 0;
                        }
                        i = 0;
                        sH = 0;
                        while (i != length) {
                            scriptNode = this.scriptOrFnNodes[i];
                            if (i != 0) {
                                cVar.a(iC, i - 1, sH);
                            } else if (length > s2) {
                                cVar.x(iC);
                                sH = cVar.h();
                            }
                            switch (i5) {
                                case 0:
                                    if (scriptNode.getType() == 137) {
                                        name = "";
                                    } else {
                                        name = ((FunctionNode) scriptNode).getName();
                                    }
                                    cVar.e(name);
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 1:
                                    cVar.l(scriptNode.getParamCount());
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 2:
                                    cVar.l(scriptNode.getParamAndVarCount());
                                    i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 3:
                                    paramAndVarCount = scriptNode.getParamAndVarCount();
                                    if (paramAndVarCount != 0) {
                                        if (paramAndVarCount == 1) {
                                            cVar.e(scriptNode.getParamOrVarName(0));
                                        } else {
                                            cVar.h(1);
                                            iC2 = cVar.c(1, paramAndVarCount - 1);
                                            i2 = 0;
                                            while (i2 != paramAndVarCount) {
                                                if (cVar.h() != 0) {
                                                    Kit.codeBug();
                                                }
                                                String paramOrVarName2 = scriptNode.getParamOrVarName(i2);
                                                if (i2 == 0) {
                                                    cVar.x(iC2);
                                                } else {
                                                    cVar.a(iC2, i2 - 1, 0);
                                                }
                                                cVar.e(paramOrVarName2);
                                                cVar.b(176);
                                                i2++;
                                                i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                            }
                                        }
                                        i++;
                                        s2 = 1;
                                        i6 = 3;
                                    } else {
                                        cVar.b(1);
                                    }
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 4:
                                    cVar.l(scriptNode.getEncodedSourceStart());
                                    cVar.l(scriptNode.getEncodedSourceEnd());
                                    cVar.b(182, "java/lang/String", "substring", "(II)Ljava/lang/String;");
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 5:
                                    paramAndVarCount2 = scriptNode.getParamAndVarCount();
                                    paramAndVarConst = scriptNode.getParamAndVarConst();
                                    if (paramAndVarCount2 == 0) {
                                        cVar.b(i6);
                                        cVar.b(i4);
                                    } else if (paramAndVarCount2 == s2) {
                                        zIsES6Generator = paramAndVarConst[0];
                                        cVar.a(zIsES6Generator);
                                        cVar.b(i4);
                                    } else {
                                        cVar.h(s2);
                                        iC3 = cVar.c(s2, paramAndVarCount2 - 1);
                                        while (i3 != paramAndVarCount2) {
                                            if (cVar.h() != 0) {
                                                Kit.codeBug();
                                            }
                                            if (i3 == 0) {
                                                cVar.x(iC3);
                                            } else {
                                                cVar.a(iC3, i3 - 1, 0);
                                            }
                                            cVar.a(paramAndVarConst[i3]);
                                            cVar.b(i4);
                                        }
                                    }
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 6:
                                    if (scriptNode instanceof FunctionNode) {
                                        zIsES6Generator = ((FunctionNode) scriptNode).isES6Generator();
                                        cVar.a(zIsES6Generator);
                                    } else {
                                        cVar.a(false);
                                    }
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                default:
                                    throw Kit.codeBug();
                            }
                        }
                        cVar.c(s);
                        break;
                    case 2:
                        str2 = "getParamAndVarCount";
                        cVar.b(str2, "()I", s2);
                        s = s2;
                        length = this.scriptOrFnNodes.length;
                        if (length > s2) {
                            cVar.b();
                            cVar.a(180, cVar.f(), "_id", "I");
                            iC = cVar.c(s2, length - 1);
                        } else {
                            iC = 0;
                        }
                        i = 0;
                        sH = 0;
                        while (i != length) {
                            scriptNode = this.scriptOrFnNodes[i];
                            if (i != 0) {
                                cVar.a(iC, i - 1, sH);
                            } else if (length > s2) {
                                cVar.x(iC);
                                sH = cVar.h();
                            }
                            switch (i5) {
                                case 0:
                                    if (scriptNode.getType() == 137) {
                                        name = "";
                                    } else {
                                        name = ((FunctionNode) scriptNode).getName();
                                    }
                                    cVar.e(name);
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 1:
                                    cVar.l(scriptNode.getParamCount());
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 2:
                                    cVar.l(scriptNode.getParamAndVarCount());
                                    i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 3:
                                    paramAndVarCount = scriptNode.getParamAndVarCount();
                                    if (paramAndVarCount != 0) {
                                        if (paramAndVarCount == 1) {
                                            cVar.e(scriptNode.getParamOrVarName(0));
                                        } else {
                                            cVar.h(1);
                                            iC2 = cVar.c(1, paramAndVarCount - 1);
                                            i2 = 0;
                                            while (i2 != paramAndVarCount) {
                                                if (cVar.h() != 0) {
                                                    Kit.codeBug();
                                                }
                                                String paramOrVarName3 = scriptNode.getParamOrVarName(i2);
                                                if (i2 == 0) {
                                                    cVar.x(iC2);
                                                } else {
                                                    cVar.a(iC2, i2 - 1, 0);
                                                }
                                                cVar.e(paramOrVarName3);
                                                cVar.b(176);
                                                i2++;
                                                i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                            }
                                        }
                                        i++;
                                        s2 = 1;
                                        i6 = 3;
                                    } else {
                                        cVar.b(1);
                                    }
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 4:
                                    cVar.l(scriptNode.getEncodedSourceStart());
                                    cVar.l(scriptNode.getEncodedSourceEnd());
                                    cVar.b(182, "java/lang/String", "substring", "(II)Ljava/lang/String;");
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 5:
                                    paramAndVarCount2 = scriptNode.getParamAndVarCount();
                                    paramAndVarConst = scriptNode.getParamAndVarConst();
                                    if (paramAndVarCount2 == 0) {
                                        cVar.b(i6);
                                        cVar.b(i4);
                                    } else if (paramAndVarCount2 == s2) {
                                        zIsES6Generator = paramAndVarConst[0];
                                        cVar.a(zIsES6Generator);
                                        cVar.b(i4);
                                    } else {
                                        cVar.h(s2);
                                        iC3 = cVar.c(s2, paramAndVarCount2 - 1);
                                        while (i3 != paramAndVarCount2) {
                                            if (cVar.h() != 0) {
                                                Kit.codeBug();
                                            }
                                            if (i3 == 0) {
                                                cVar.x(iC3);
                                            } else {
                                                cVar.a(iC3, i3 - 1, 0);
                                            }
                                            cVar.a(paramAndVarConst[i3]);
                                            cVar.b(i4);
                                        }
                                    }
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 6:
                                    if (scriptNode instanceof FunctionNode) {
                                        zIsES6Generator = ((FunctionNode) scriptNode).isES6Generator();
                                        cVar.a(zIsES6Generator);
                                    } else {
                                        cVar.a(false);
                                    }
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                default:
                                    throw Kit.codeBug();
                            }
                        }
                        cVar.c(s);
                        break;
                    case 3:
                        cVar.b("getParamOrVarName", "(I)Ljava/lang/String;", s2);
                        s = 2;
                        length = this.scriptOrFnNodes.length;
                        if (length > s2) {
                            cVar.b();
                            cVar.a(180, cVar.f(), "_id", "I");
                            iC = cVar.c(s2, length - 1);
                        } else {
                            iC = 0;
                        }
                        i = 0;
                        sH = 0;
                        while (i != length) {
                            scriptNode = this.scriptOrFnNodes[i];
                            if (i != 0) {
                                cVar.a(iC, i - 1, sH);
                            } else if (length > s2) {
                                cVar.x(iC);
                                sH = cVar.h();
                            }
                            switch (i5) {
                                case 0:
                                    if (scriptNode.getType() == 137) {
                                        name = "";
                                    } else {
                                        name = ((FunctionNode) scriptNode).getName();
                                    }
                                    cVar.e(name);
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 1:
                                    cVar.l(scriptNode.getParamCount());
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 2:
                                    cVar.l(scriptNode.getParamAndVarCount());
                                    i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 3:
                                    paramAndVarCount = scriptNode.getParamAndVarCount();
                                    if (paramAndVarCount != 0) {
                                        if (paramAndVarCount == 1) {
                                            cVar.e(scriptNode.getParamOrVarName(0));
                                        } else {
                                            cVar.h(1);
                                            iC2 = cVar.c(1, paramAndVarCount - 1);
                                            i2 = 0;
                                            while (i2 != paramAndVarCount) {
                                                if (cVar.h() != 0) {
                                                    Kit.codeBug();
                                                }
                                                String paramOrVarName4 = scriptNode.getParamOrVarName(i2);
                                                if (i2 == 0) {
                                                    cVar.x(iC2);
                                                } else {
                                                    cVar.a(iC2, i2 - 1, 0);
                                                }
                                                cVar.e(paramOrVarName4);
                                                cVar.b(176);
                                                i2++;
                                                i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                            }
                                        }
                                        i++;
                                        s2 = 1;
                                        i6 = 3;
                                    } else {
                                        cVar.b(1);
                                    }
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 4:
                                    cVar.l(scriptNode.getEncodedSourceStart());
                                    cVar.l(scriptNode.getEncodedSourceEnd());
                                    cVar.b(182, "java/lang/String", "substring", "(II)Ljava/lang/String;");
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 5:
                                    paramAndVarCount2 = scriptNode.getParamAndVarCount();
                                    paramAndVarConst = scriptNode.getParamAndVarConst();
                                    if (paramAndVarCount2 == 0) {
                                        cVar.b(i6);
                                        cVar.b(i4);
                                    } else if (paramAndVarCount2 == s2) {
                                        zIsES6Generator = paramAndVarConst[0];
                                        cVar.a(zIsES6Generator);
                                        cVar.b(i4);
                                    } else {
                                        cVar.h(s2);
                                        iC3 = cVar.c(s2, paramAndVarCount2 - 1);
                                        while (i3 != paramAndVarCount2) {
                                            if (cVar.h() != 0) {
                                                Kit.codeBug();
                                            }
                                            if (i3 == 0) {
                                                cVar.x(iC3);
                                            } else {
                                                cVar.a(iC3, i3 - 1, 0);
                                            }
                                            cVar.a(paramAndVarConst[i3]);
                                            cVar.b(i4);
                                        }
                                    }
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 6:
                                    if (scriptNode instanceof FunctionNode) {
                                        zIsES6Generator = ((FunctionNode) scriptNode).isES6Generator();
                                        cVar.a(zIsES6Generator);
                                    } else {
                                        cVar.a(false);
                                    }
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                default:
                                    throw Kit.codeBug();
                            }
                        }
                        cVar.c(s);
                        break;
                    case 4:
                        cVar.b("getEncodedSource", "()Ljava/lang/String;", s2);
                        cVar.e(str);
                        s = s2;
                        length = this.scriptOrFnNodes.length;
                        if (length > s2) {
                            cVar.b();
                            cVar.a(180, cVar.f(), "_id", "I");
                            iC = cVar.c(s2, length - 1);
                        } else {
                            iC = 0;
                        }
                        i = 0;
                        sH = 0;
                        while (i != length) {
                            scriptNode = this.scriptOrFnNodes[i];
                            if (i != 0) {
                                cVar.a(iC, i - 1, sH);
                            } else if (length > s2) {
                                cVar.x(iC);
                                sH = cVar.h();
                            }
                            switch (i5) {
                                case 0:
                                    if (scriptNode.getType() == 137) {
                                        name = "";
                                    } else {
                                        name = ((FunctionNode) scriptNode).getName();
                                    }
                                    cVar.e(name);
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 1:
                                    cVar.l(scriptNode.getParamCount());
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 2:
                                    cVar.l(scriptNode.getParamAndVarCount());
                                    i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 3:
                                    paramAndVarCount = scriptNode.getParamAndVarCount();
                                    if (paramAndVarCount != 0) {
                                        if (paramAndVarCount == 1) {
                                            cVar.e(scriptNode.getParamOrVarName(0));
                                        } else {
                                            cVar.h(1);
                                            iC2 = cVar.c(1, paramAndVarCount - 1);
                                            i2 = 0;
                                            while (i2 != paramAndVarCount) {
                                                if (cVar.h() != 0) {
                                                    Kit.codeBug();
                                                }
                                                String paramOrVarName5 = scriptNode.getParamOrVarName(i2);
                                                if (i2 == 0) {
                                                    cVar.x(iC2);
                                                } else {
                                                    cVar.a(iC2, i2 - 1, 0);
                                                }
                                                cVar.e(paramOrVarName5);
                                                cVar.b(176);
                                                i2++;
                                                i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                            }
                                        }
                                        i++;
                                        s2 = 1;
                                        i6 = 3;
                                    } else {
                                        cVar.b(1);
                                    }
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 4:
                                    cVar.l(scriptNode.getEncodedSourceStart());
                                    cVar.l(scriptNode.getEncodedSourceEnd());
                                    cVar.b(182, "java/lang/String", "substring", "(II)Ljava/lang/String;");
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 5:
                                    paramAndVarCount2 = scriptNode.getParamAndVarCount();
                                    paramAndVarConst = scriptNode.getParamAndVarConst();
                                    if (paramAndVarCount2 == 0) {
                                        cVar.b(i6);
                                        cVar.b(i4);
                                    } else if (paramAndVarCount2 == s2) {
                                        zIsES6Generator = paramAndVarConst[0];
                                        cVar.a(zIsES6Generator);
                                        cVar.b(i4);
                                    } else {
                                        cVar.h(s2);
                                        iC3 = cVar.c(s2, paramAndVarCount2 - 1);
                                        while (i3 != paramAndVarCount2) {
                                            if (cVar.h() != 0) {
                                                Kit.codeBug();
                                            }
                                            if (i3 == 0) {
                                                cVar.x(iC3);
                                            } else {
                                                cVar.a(iC3, i3 - 1, 0);
                                            }
                                            cVar.a(paramAndVarConst[i3]);
                                            cVar.b(i4);
                                        }
                                    }
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 6:
                                    if (scriptNode instanceof FunctionNode) {
                                        zIsES6Generator = ((FunctionNode) scriptNode).isES6Generator();
                                        cVar.a(zIsES6Generator);
                                    } else {
                                        cVar.a(false);
                                    }
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                default:
                                    throw Kit.codeBug();
                            }
                        }
                        cVar.c(s);
                        break;
                    case 5:
                        cVar.b("getParamOrVarConst", "(I)Z", s2);
                        s = 3;
                        length = this.scriptOrFnNodes.length;
                        if (length > s2) {
                            cVar.b();
                            cVar.a(180, cVar.f(), "_id", "I");
                            iC = cVar.c(s2, length - 1);
                        } else {
                            iC = 0;
                        }
                        i = 0;
                        sH = 0;
                        while (i != length) {
                            scriptNode = this.scriptOrFnNodes[i];
                            if (i != 0) {
                                cVar.a(iC, i - 1, sH);
                            } else if (length > s2) {
                                cVar.x(iC);
                                sH = cVar.h();
                            }
                            switch (i5) {
                                case 0:
                                    if (scriptNode.getType() == 137) {
                                        name = "";
                                    } else {
                                        name = ((FunctionNode) scriptNode).getName();
                                    }
                                    cVar.e(name);
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 1:
                                    cVar.l(scriptNode.getParamCount());
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 2:
                                    cVar.l(scriptNode.getParamAndVarCount());
                                    i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 3:
                                    paramAndVarCount = scriptNode.getParamAndVarCount();
                                    if (paramAndVarCount != 0) {
                                        if (paramAndVarCount == 1) {
                                            cVar.e(scriptNode.getParamOrVarName(0));
                                        } else {
                                            cVar.h(1);
                                            iC2 = cVar.c(1, paramAndVarCount - 1);
                                            i2 = 0;
                                            while (i2 != paramAndVarCount) {
                                                if (cVar.h() != 0) {
                                                    Kit.codeBug();
                                                }
                                                String paramOrVarName6 = scriptNode.getParamOrVarName(i2);
                                                if (i2 == 0) {
                                                    cVar.x(iC2);
                                                } else {
                                                    cVar.a(iC2, i2 - 1, 0);
                                                }
                                                cVar.e(paramOrVarName6);
                                                cVar.b(176);
                                                i2++;
                                                i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                            }
                                        }
                                        i++;
                                        s2 = 1;
                                        i6 = 3;
                                    } else {
                                        cVar.b(1);
                                    }
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 4:
                                    cVar.l(scriptNode.getEncodedSourceStart());
                                    cVar.l(scriptNode.getEncodedSourceEnd());
                                    cVar.b(182, "java/lang/String", "substring", "(II)Ljava/lang/String;");
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 5:
                                    paramAndVarCount2 = scriptNode.getParamAndVarCount();
                                    paramAndVarConst = scriptNode.getParamAndVarConst();
                                    if (paramAndVarCount2 == 0) {
                                        cVar.b(i6);
                                        cVar.b(i4);
                                    } else if (paramAndVarCount2 == s2) {
                                        zIsES6Generator = paramAndVarConst[0];
                                        cVar.a(zIsES6Generator);
                                        cVar.b(i4);
                                    } else {
                                        cVar.h(s2);
                                        iC3 = cVar.c(s2, paramAndVarCount2 - 1);
                                        while (i3 != paramAndVarCount2) {
                                            if (cVar.h() != 0) {
                                                Kit.codeBug();
                                            }
                                            if (i3 == 0) {
                                                cVar.x(iC3);
                                            } else {
                                                cVar.a(iC3, i3 - 1, 0);
                                            }
                                            cVar.a(paramAndVarConst[i3]);
                                            cVar.b(i4);
                                        }
                                    }
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 6:
                                    if (scriptNode instanceof FunctionNode) {
                                        zIsES6Generator = ((FunctionNode) scriptNode).isES6Generator();
                                        cVar.a(zIsES6Generator);
                                    } else {
                                        cVar.a(false);
                                    }
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                default:
                                    throw Kit.codeBug();
                            }
                        }
                        cVar.c(s);
                        break;
                    case 6:
                        cVar.b("isGeneratorFunction", "()Z", (short) 4);
                        s = s2;
                        length = this.scriptOrFnNodes.length;
                        if (length > s2) {
                            cVar.b();
                            cVar.a(180, cVar.f(), "_id", "I");
                            iC = cVar.c(s2, length - 1);
                        } else {
                            iC = 0;
                        }
                        i = 0;
                        sH = 0;
                        while (i != length) {
                            scriptNode = this.scriptOrFnNodes[i];
                            if (i != 0) {
                                cVar.a(iC, i - 1, sH);
                            } else if (length > s2) {
                                cVar.x(iC);
                                sH = cVar.h();
                            }
                            switch (i5) {
                                case 0:
                                    if (scriptNode.getType() == 137) {
                                        name = "";
                                    } else {
                                        name = ((FunctionNode) scriptNode).getName();
                                    }
                                    cVar.e(name);
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 1:
                                    cVar.l(scriptNode.getParamCount());
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 2:
                                    cVar.l(scriptNode.getParamAndVarCount());
                                    i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 3:
                                    paramAndVarCount = scriptNode.getParamAndVarCount();
                                    if (paramAndVarCount != 0) {
                                        if (paramAndVarCount == 1) {
                                            cVar.e(scriptNode.getParamOrVarName(0));
                                        } else {
                                            cVar.h(1);
                                            iC2 = cVar.c(1, paramAndVarCount - 1);
                                            i2 = 0;
                                            while (i2 != paramAndVarCount) {
                                                if (cVar.h() != 0) {
                                                    Kit.codeBug();
                                                }
                                                String paramOrVarName7 = scriptNode.getParamOrVarName(i2);
                                                if (i2 == 0) {
                                                    cVar.x(iC2);
                                                } else {
                                                    cVar.a(iC2, i2 - 1, 0);
                                                }
                                                cVar.e(paramOrVarName7);
                                                cVar.b(176);
                                                i2++;
                                                i4 = TsExtractor.TS_STREAM_TYPE_AC4;
                                            }
                                        }
                                        i++;
                                        s2 = 1;
                                        i6 = 3;
                                    } else {
                                        cVar.b(1);
                                    }
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 4:
                                    cVar.l(scriptNode.getEncodedSourceStart());
                                    cVar.l(scriptNode.getEncodedSourceEnd());
                                    cVar.b(182, "java/lang/String", "substring", "(II)Ljava/lang/String;");
                                    cVar.b(176);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 5:
                                    paramAndVarCount2 = scriptNode.getParamAndVarCount();
                                    paramAndVarConst = scriptNode.getParamAndVarConst();
                                    if (paramAndVarCount2 == 0) {
                                        cVar.b(i6);
                                        cVar.b(i4);
                                    } else if (paramAndVarCount2 == s2) {
                                        zIsES6Generator = paramAndVarConst[0];
                                        cVar.a(zIsES6Generator);
                                        cVar.b(i4);
                                    } else {
                                        cVar.h(s2);
                                        iC3 = cVar.c(s2, paramAndVarCount2 - 1);
                                        while (i3 != paramAndVarCount2) {
                                            if (cVar.h() != 0) {
                                                Kit.codeBug();
                                            }
                                            if (i3 == 0) {
                                                cVar.x(iC3);
                                            } else {
                                                cVar.a(iC3, i3 - 1, 0);
                                            }
                                            cVar.a(paramAndVarConst[i3]);
                                            cVar.b(i4);
                                        }
                                    }
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                case 6:
                                    if (scriptNode instanceof FunctionNode) {
                                        zIsES6Generator = ((FunctionNode) scriptNode).isES6Generator();
                                        cVar.a(zIsES6Generator);
                                    } else {
                                        cVar.a(false);
                                    }
                                    cVar.b(i4);
                                    i++;
                                    s2 = 1;
                                    i6 = 3;
                                    break;
                                default:
                                    throw Kit.codeBug();
                            }
                        }
                        cVar.c(s);
                        break;
                    default:
                        throw Kit.codeBug();
                }
            }
            i5++;
            s2 = 1;
        }
    }

    private void generateResumeGenerator(c cVar) {
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i2 >= scriptNodeArr.length) {
                break;
            }
            if (isGenerator(scriptNodeArr[i2])) {
                z = true;
            }
            i2++;
        }
        if (!z) {
            return;
        }
        cVar.b("resumeGenerator", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        cVar.c(0);
        cVar.c(1);
        cVar.c(2);
        cVar.c(4);
        cVar.c(5);
        cVar.h(3);
        cVar.b();
        cVar.a(180, cVar.f(), "_id", "I");
        int iC = cVar.c(0, this.scriptOrFnNodes.length - 1);
        cVar.x(iC);
        int iA = cVar.a();
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i >= scriptNodeArr2.length) {
                cVar.w(iA);
                pushUndefined(cVar);
                cVar.b(176);
                cVar.c((short) 6);
                return;
            }
            ScriptNode scriptNode = scriptNodeArr2[i];
            cVar.a(iC, i, 6);
            if (isGenerator(scriptNode)) {
                cVar.b(184, this.mainClassName, getBodyMethodName(scriptNode) + "_gen", "(" + this.mainClassSignature + "Lexternal/sdk/pendo/io/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;");
                cVar.b(176);
            } else {
                cVar.a(Token.LAST_TOKEN, iA);
            }
            i++;
        }
    }

    private static void generateScriptCtor(c cVar) {
        cVar.b("<init>", "()V", (short) 1);
        cVar.b();
        cVar.b(183, SUPER_CLASS_NAME, "<init>", "()V");
        cVar.b();
        cVar.l(0);
        cVar.a(181, cVar.f(), "_id", "I");
        cVar.b(177);
        cVar.c((short) 1);
    }

    private static String getStaticConstantWrapperType(double d) {
        return ((double) ((int) d)) == d ? "Ljava/lang/Integer;" : "Ljava/lang/Double;";
    }

    private static void initOptFunctions_r(ScriptNode scriptNode) {
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            FunctionNode functionNode = scriptNode.getFunctionNode(i);
            new OptFunctionNode(functionNode);
            initOptFunctions_r(functionNode);
        }
    }

    private void initScriptNodesData(ScriptNode scriptNode) {
        ObjArray objArray = new ObjArray();
        collectScriptNodes_r(scriptNode, objArray);
        int size = objArray.size();
        ScriptNode[] scriptNodeArr = new ScriptNode[size];
        this.scriptOrFnNodes = scriptNodeArr;
        objArray.toArray(scriptNodeArr);
        this.scriptOrFnIndexes = new ObjToIntMap(size);
        for (int i = 0; i != size; i++) {
            this.scriptOrFnIndexes.put(this.scriptOrFnNodes[i], i);
        }
    }

    static boolean isGenerator(ScriptNode scriptNode) {
        return scriptNode.getType() == 110 && ((FunctionNode) scriptNode).isGenerator();
    }

    static void pushUndefined(c cVar) {
        cVar.a(178, "external/sdk/pendo/io/mozilla/javascript/Undefined", "instance", "Ljava/lang/Object;");
    }

    private void transform(ScriptNode scriptNode) {
        initOptFunctions_r(scriptNode);
        int optimizationLevel = this.compilerEnv.getOptimizationLevel();
        HashMap map = null;
        if (optimizationLevel > 0 && scriptNode.getType() == 137) {
            int functionCount = scriptNode.getFunctionCount();
            for (int i = 0; i != functionCount; i++) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode, i);
                if (optFunctionNode.fnode.getFunctionType() == 1) {
                    String name = optFunctionNode.fnode.getName();
                    if (name.length() != 0) {
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(name, optFunctionNode);
                    }
                }
            }
        }
        if (map != null) {
            this.directCallTargets = new ObjArray();
        }
        new OptTransformer(map, this.directCallTargets).transform(scriptNode, this.compilerEnv);
        if (optimizationLevel > 0) {
            new Optimizer().optimize(scriptNode);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public void captureStackInfo(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    String cleanName(ScriptNode scriptNode) {
        if (!(scriptNode instanceof FunctionNode)) {
            return JavascriptRunner.SCRIPT_NAME;
        }
        Name functionName = ((FunctionNode) scriptNode).getFunctionName();
        return functionName == null ? "anonymous" : functionName.getIdentifier();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public Object compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        int i;
        synchronized (globalLock) {
            i = globalSerialClassCounter + 1;
            globalSerialClassCounter = i;
        }
        String strReplaceAll = "c";
        if (scriptNode.getSourceName().length() > 0) {
            strReplaceAll = scriptNode.getSourceName().replaceAll("\\W", "_");
            if (!Character.isJavaIdentifierStart(strReplaceAll.charAt(0))) {
                strReplaceAll = "_" + strReplaceAll;
            }
        }
        String str2 = "external.sdk.pendo.io.mozilla.javascript.gen." + strReplaceAll + "_" + i;
        return new Object[]{str2, compileToClassFile(compilerEnvirons, str2, scriptNode, str, z)};
    }

    public byte[] compileToClassFile(CompilerEnvirons compilerEnvirons, String str, ScriptNode scriptNode, String str2, boolean z) {
        this.compilerEnv = compilerEnvirons;
        transform(scriptNode);
        if (z) {
            scriptNode = scriptNode.getFunctionNode(0);
        }
        initScriptNodesData(scriptNode);
        this.mainClassName = str;
        this.mainClassSignature = c.g(str);
        return generateCode(str2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public Function createFunctionObject(Context context, Scriptable scriptable, Object obj, Object obj2) {
        try {
            return (NativeFunction) defineClass(obj, obj2).getConstructors()[0].newInstance(scriptable, context, 0);
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate compiled class:" + e.toString());
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public Script createScriptObject(Object obj, Object obj2) {
        try {
            return (Script) defineClass(obj, obj2).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate compiled class:" + e.toString());
        }
    }

    String getBodyMethodName(ScriptNode scriptNode) {
        return "_c_" + cleanName(scriptNode) + "_" + getIndex(scriptNode);
    }

    String getBodyMethodSignature(ScriptNode scriptNode) {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.mainClassSignature);
        sb.append("Lexternal/sdk/pendo/io/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;");
        if (scriptNode.getType() == 110) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
            if (optFunctionNode.isTargetOfDirectCall()) {
                int paramCount = optFunctionNode.fnode.getParamCount();
                for (int i = 0; i != paramCount; i++) {
                    sb.append("Ljava/lang/Object;D");
                }
            }
        }
        sb.append("[Ljava/lang/Object;)Ljava/lang/Object;");
        return sb.toString();
    }

    String getCompiledRegexpName(ScriptNode scriptNode, int i) {
        return "_re" + getIndex(scriptNode) + "_" + i;
    }

    String getDirectCtorName(ScriptNode scriptNode) {
        return "_n" + getIndex(scriptNode);
    }

    String getFunctionInitMethodName(OptFunctionNode optFunctionNode) {
        return "_i" + getIndex(optFunctionNode.fnode);
    }

    int getIndex(ScriptNode scriptNode) {
        return this.scriptOrFnIndexes.getExisting(scriptNode);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public String getPatchedStack(RhinoException rhinoException, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public List<String> getScriptStack(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public String getSourcePositionFromStack(Context context, int[] iArr) {
        throw new UnsupportedOperationException();
    }

    void pushNumberAsObject(c cVar, double d) {
        if (d == 0.0d) {
            if (1.0d / d > 0.0d) {
                cVar.a(178, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "zeroObj", "Ljava/lang/Double;");
                return;
            }
        } else {
            if (d == 1.0d) {
                cVar.a(178, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime", "oneObj", "Ljava/lang/Double;");
                return;
            }
            if (d == -1.0d) {
                cVar.a(178, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime", "minusOneObj", "Ljava/lang/Double;");
                return;
            }
            if (Double.isNaN(d)) {
                cVar.a(178, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "NaNobj", "Ljava/lang/Double;");
                return;
            }
            int i = this.itsConstantListSize;
            if (i < 2000) {
                int i2 = 0;
                if (i == 0) {
                    this.itsConstantList = new double[64];
                } else {
                    double[] dArr = this.itsConstantList;
                    int i3 = 0;
                    while (i3 != i && dArr[i3] != d) {
                        i3++;
                    }
                    if (i == dArr.length) {
                        double[] dArr2 = new double[i * 2];
                        System.arraycopy(this.itsConstantList, 0, dArr2, 0, i);
                        this.itsConstantList = dArr2;
                    }
                    i2 = i3;
                }
                if (i2 == i) {
                    this.itsConstantList[i] = d;
                    this.itsConstantListSize = i + 1;
                }
                cVar.a(178, this.mainClassName, "_k" + i2, getStaticConstantWrapperType(d));
                return;
            }
        }
        cVar.b(d);
        addDoubleWrap(cVar);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public void setEvalScriptFlag(Script script) {
        throw new UnsupportedOperationException();
    }

    public void setMainMethodClass(String str) {
        this.mainMethodClass = str;
    }
}
