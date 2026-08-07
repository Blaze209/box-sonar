package external.sdk.pendo.io.mozilla.javascript;

import external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
final class InterpreterData implements Serializable, DebuggableScript {
    static final int INITIAL_MAX_ICODE_LENGTH = 1024;
    static final int INITIAL_NUMBERTABLE_SIZE = 64;
    static final int INITIAL_STRINGTABLE_SIZE = 64;
    private static final long serialVersionUID = 5067677351589230234L;
    int argCount;
    boolean[] argIsConst;
    String[] argNames;
    boolean declaredAsFunctionExpression;
    boolean declaredAsVar;
    String encodedSource;
    int encodedSourceEnd;
    int encodedSourceStart;
    boolean evalScriptFlag;
    int firstLinePC = -1;
    private int icodeHashCode = 0;
    boolean isES6Generator;
    boolean isStrict;
    double[] itsDoubleTable;
    int[] itsExceptionTable;
    int itsFunctionType;
    byte[] itsICode;
    int itsMaxCalleeArgs;
    int itsMaxFrameArray;
    int itsMaxLocals;
    int itsMaxStack;
    int itsMaxVars;
    String itsName;
    boolean itsNeedsActivation;
    InterpreterData[] itsNestedFunctions;
    Object[] itsRegExpLiterals;
    String itsSourceFile;
    String[] itsStringTable;
    int languageVersion;
    Object[] literalIds;
    UintMap longJumps;
    InterpreterData parentData;
    boolean topLevel;

    InterpreterData(int i, String str, String str2, boolean z) {
        this.languageVersion = i;
        this.itsSourceFile = str;
        this.encodedSource = str2;
        this.isStrict = z;
        init();
    }

    private void init() {
        this.itsICode = new byte[1024];
        this.itsStringTable = new String[64];
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript
    public DebuggableScript getFunction(int i) {
        return this.itsNestedFunctions[i];
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript
    public int getFunctionCount() {
        InterpreterData[] interpreterDataArr = this.itsNestedFunctions;
        if (interpreterDataArr == null) {
            return 0;
        }
        return interpreterDataArr.length;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript
    public String getFunctionName() {
        return this.itsName;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript
    public int[] getLineNumbers() {
        return Interpreter.getLineNumbers(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript
    public int getParamAndVarCount() {
        return this.argNames.length;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript
    public int getParamCount() {
        return this.argCount;
    }

    public boolean getParamOrVarConst(int i) {
        return this.argIsConst[i];
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript
    public String getParamOrVarName(int i) {
        return this.argNames[i];
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript
    public DebuggableScript getParent() {
        return this.parentData;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript
    public String getSourceName() {
        return this.itsSourceFile;
    }

    public int icodeHashCode() {
        int i = this.icodeHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.itsICode);
        this.icodeHashCode = iHashCode;
        return iHashCode;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript
    public boolean isFunction() {
        return this.itsFunctionType != 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript
    public boolean isGeneratedScript() {
        return ScriptRuntime.isGeneratedScript(this.itsSourceFile);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript
    public boolean isTopLevel() {
        return this.topLevel;
    }

    InterpreterData(InterpreterData interpreterData) {
        this.parentData = interpreterData;
        this.languageVersion = interpreterData.languageVersion;
        this.itsSourceFile = interpreterData.itsSourceFile;
        this.encodedSource = interpreterData.encodedSource;
        this.isStrict = interpreterData.isStrict;
        init();
    }
}
