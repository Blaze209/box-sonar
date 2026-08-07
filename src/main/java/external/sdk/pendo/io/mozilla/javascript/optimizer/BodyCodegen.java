package external.sdk.pendo.io.mozilla.javascript.optimizer;

import androidx.core.app.NotificationCompat;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import com.j256.ormlite.field.FieldType;
import external.sdk.pendo.io.mozilla.javascript.CompilerEnvirons;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.Node;
import external.sdk.pendo.io.mozilla.javascript.Token;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode;
import external.sdk.pendo.io.mozilla.javascript.ast.Jump;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import sdk.pendo.io.d2.c;

/* JADX INFO: loaded from: classes4.dex */
class BodyCodegen {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ECMAERROR_EXCEPTION = 2;
    private static final int EVALUATOR_EXCEPTION = 1;
    private static final int EXCEPTION_MAX = 5;
    private static final int FINALLY_EXCEPTION = 4;
    static final int GENERATOR_START = 0;
    static final int GENERATOR_TERMINATE = -1;
    static final int GENERATOR_YIELD_START = 1;
    private static final int JAVASCRIPT_EXCEPTION = 0;
    private static final int MAX_LOCALS = 1024;
    private static final int THROWABLE_EXCEPTION = 3;
    private short argsLocal;
    c cfw;
    Codegen codegen;
    CompilerEnvirons compilerEnv;
    private short contextLocal;
    private int enterAreaStartLabel;
    private int epilogueLabel;
    private Map<Node, FinallyReturnPoint> finallys;
    private short firstFreeLocal;
    private OptFunctionNode fnCurrent;
    private short funObjLocal;
    private short generatorStateLocal;
    private int generatorSwitch;
    private boolean hasVarsInRegs;
    private boolean inDirectCallFunction;
    private boolean inLocalBlock;
    private boolean isGenerator;
    private boolean itsForcedObjectParameters;
    private int itsLineNumber;
    private short itsOneArgArray;
    private short itsZeroArgArray;
    private List<Node> literals;
    private int[] locals;
    private short localsMax;
    private short operationLocal;
    private short popvLocal;
    private int savedCodeOffset;
    ScriptNode scriptOrFn;
    public int scriptOrFnIndex;
    private short thisObjLocal;
    private short[] varRegisters;
    private short variableObjectLocal;
    private ExceptionManager exceptionManager = new ExceptionManager();
    private int maxLocals = 0;
    private int maxStack = 0;
    private int unnestedYieldCount = 0;
    private IdentityHashMap<Node, String> unnestedYields = new IdentityHashMap<>();

    private class ExceptionManager {
        private LinkedList<ExceptionInfo> exceptionInfo = new LinkedList<>();

        private class ExceptionInfo {
            Node finallyBlock;
            int[] handlerLabels = new int[5];
            int[] exceptionStarts = new int[5];
            Node currentFinally = null;

            ExceptionInfo(Jump jump, Node node) {
                this.finallyBlock = node;
            }
        }

        ExceptionManager() {
        }

        private void endCatch(ExceptionInfo exceptionInfo, int i, int i2) {
            int i3 = exceptionInfo.exceptionStarts[i];
            if (i3 == 0) {
                throw new IllegalStateException("bad exception start");
            }
            if (BodyCodegen.this.cfw.u(i3) != BodyCodegen.this.cfw.u(i2)) {
                BodyCodegen.this.cfw.a(exceptionInfo.exceptionStarts[i], i2, exceptionInfo.handlerLabels[i], BodyCodegen.exceptionTypeToName(i));
            }
        }

        private ExceptionInfo getTop() {
            return this.exceptionInfo.getLast();
        }

        void addHandler(int i, int i2, int i3) {
            ExceptionInfo top = getTop();
            top.handlerLabels[i] = i2;
            top.exceptionStarts[i] = i3;
        }

        void markInlineFinallyEnd(Node node, int i) {
            LinkedList<ExceptionInfo> linkedList = this.exceptionInfo;
            ListIterator<ExceptionInfo> listIterator = linkedList.listIterator(linkedList.size());
            while (listIterator.hasPrevious()) {
                ExceptionInfo exceptionInfoPrevious = listIterator.previous();
                for (int i2 = 0; i2 < 5; i2++) {
                    if (exceptionInfoPrevious.handlerLabels[i2] != 0 && exceptionInfoPrevious.currentFinally == node) {
                        exceptionInfoPrevious.exceptionStarts[i2] = i;
                        exceptionInfoPrevious.currentFinally = null;
                    }
                }
                if (exceptionInfoPrevious.finallyBlock == node) {
                    return;
                }
            }
        }

        void markInlineFinallyStart(Node node, int i) {
            LinkedList<ExceptionInfo> linkedList = this.exceptionInfo;
            ListIterator<ExceptionInfo> listIterator = linkedList.listIterator(linkedList.size());
            while (listIterator.hasPrevious()) {
                ExceptionInfo exceptionInfoPrevious = listIterator.previous();
                for (int i2 = 0; i2 < 5; i2++) {
                    if (exceptionInfoPrevious.handlerLabels[i2] != 0 && exceptionInfoPrevious.currentFinally == null) {
                        endCatch(exceptionInfoPrevious, i2, i);
                        exceptionInfoPrevious.exceptionStarts[i2] = 0;
                        exceptionInfoPrevious.currentFinally = node;
                    }
                }
                if (exceptionInfoPrevious.finallyBlock == node) {
                    return;
                }
            }
        }

        void popExceptionInfo() {
            this.exceptionInfo.removeLast();
        }

        void pushExceptionInfo(Jump jump) {
            this.exceptionInfo.add(new ExceptionInfo(jump, BodyCodegen.getFinallyAtTarget(jump.getFinally())));
        }

        int removeHandler(int i, int i2) {
            ExceptionInfo top = getTop();
            int i3 = top.handlerLabels[i];
            if (i3 == 0) {
                return 0;
            }
            endCatch(top, i, i2);
            top.handlerLabels[i] = 0;
            return i3;
        }

        void setHandlers(int[] iArr, int i) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                if (i3 != 0) {
                    addHandler(i2, i3, i);
                }
            }
        }
    }

    static class FinallyReturnPoint {
        public List<Integer> jsrPoints = new ArrayList();
        public int tableLabel = 0;

        FinallyReturnPoint() {
        }
    }

    BodyCodegen() {
    }

    private void addDoubleWrap() {
        addOptRuntimeInvoke("wrapDouble", "(D)Ljava/lang/Double;");
    }

    private void addGoto(Node node, int i) {
        this.cfw.a(i, getTargetLabel(node));
    }

    private void addGotoWithReturn(Node node) {
        FinallyReturnPoint finallyReturnPoint = this.finallys.get(node);
        this.cfw.k(finallyReturnPoint.jsrPoints.size());
        addGoto(node, Token.LAST_TOKEN);
        this.cfw.b(87);
        int iA = this.cfw.a();
        this.cfw.w(iA);
        finallyReturnPoint.jsrPoints.add(Integer.valueOf(iA));
    }

    private void addInstructionCount() {
        addInstructionCount(Math.max(this.cfw.g() - this.savedCodeOffset, 1));
    }

    private void addJumpedBooleanWrap(int i, int i2) {
        this.cfw.w(i2);
        int iA = this.cfw.a();
        this.cfw.a(178, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
        this.cfw.a(Token.LAST_TOKEN, iA);
        this.cfw.w(i);
        this.cfw.a(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
        this.cfw.w(iA);
        this.cfw.q(-1);
    }

    private void addLoadPropertyIds(Object[] objArr, int i) {
        addNewObjectArray(i);
        for (int i2 = 0; i2 != i; i2++) {
            this.cfw.b(89);
            this.cfw.l(i2);
            Object obj = objArr[i2];
            if (obj instanceof String) {
                this.cfw.e((String) obj);
            } else {
                this.cfw.l(((Integer) obj).intValue());
                addScriptRuntimeInvoke("wrapInt", "(I)Ljava/lang/Integer;");
            }
            this.cfw.b(83);
        }
    }

    private void addLoadPropertyValues(Node node, Node node2, int i) {
        int i2 = 0;
        if (!this.isGenerator) {
            addNewObjectArray(i);
            while (i2 != i) {
                this.cfw.b(89);
                this.cfw.l(i2);
                int type = node2.getType();
                if (type == 152 || type == 153 || type == 164) {
                    generateExpression(node2.getFirstChild(), node);
                } else {
                    generateExpression(node2, node);
                }
                this.cfw.b(83);
                node2 = node2.getNext();
                i2++;
            }
            return;
        }
        for (int i3 = 0; i3 != i; i3++) {
            int type2 = node2.getType();
            if (type2 == 152 || type2 == 153 || type2 == 164) {
                generateExpression(node2.getFirstChild(), node);
            } else {
                generateExpression(node2, node);
            }
            node2 = node2.getNext();
        }
        addNewObjectArray(i);
        while (i2 != i) {
            this.cfw.b(90);
            this.cfw.b(95);
            this.cfw.l((i - i2) - 1);
            this.cfw.b(95);
            this.cfw.b(83);
            i2++;
        }
    }

    private void addNewObjectArray(int i) {
        if (i != 0) {
            this.cfw.l(i);
            this.cfw.a(PsExtractor.PRIVATE_STREAM_1, "java/lang/Object");
            return;
        }
        short s = this.itsZeroArgArray;
        c cVar = this.cfw;
        if (s >= 0) {
            cVar.c((int) s);
        } else {
            cVar.a(178, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
        }
    }

    private void addObjectToDouble() {
        addScriptRuntimeInvoke("toNumber", "(Ljava/lang/Object;)D");
    }

    private void addOptRuntimeInvoke(String str, String str2) {
        this.cfw.b(184, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime", str, str2);
    }

    private void addScriptRuntimeInvoke(String str, String str2) {
        this.cfw.b(184, "external.sdk.pendo.io.mozilla.javascript.ScriptRuntime", str, str2);
    }

    private void dcpLoadAsNumber(int i) {
        this.cfw.c(i);
        this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
        int iA = this.cfw.a();
        this.cfw.a(Token.ARROW, iA);
        short sH = this.cfw.h();
        this.cfw.c(i);
        addObjectToDouble();
        int iA2 = this.cfw.a();
        this.cfw.a(Token.LAST_TOKEN, iA2);
        this.cfw.a(iA, sH);
        this.cfw.e(i + 1);
        this.cfw.w(iA2);
    }

    private void dcpLoadAsObject(int i) {
        this.cfw.c(i);
        this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
        int iA = this.cfw.a();
        this.cfw.a(Token.ARROW, iA);
        short sH = this.cfw.h();
        this.cfw.c(i);
        int iA2 = this.cfw.a();
        this.cfw.a(Token.LAST_TOKEN, iA2);
        this.cfw.a(iA, sH);
        this.cfw.e(i + 1);
        addDoubleWrap();
        this.cfw.w(iA2);
    }

    private void decReferenceWordLocal(short s) {
        int[] iArr = this.locals;
        iArr[s] = iArr[s] - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String exceptionTypeToName(int i) {
        if (i == 0) {
            return "external/sdk/pendo/io/mozilla/javascript/JavaScriptException";
        }
        if (i == 1) {
            return "external/sdk/pendo/io/mozilla/javascript/EvaluatorException";
        }
        if (i == 2) {
            return "external/sdk/pendo/io/mozilla/javascript/EcmaError";
        }
        if (i == 3) {
            return "java/lang/Throwable";
        }
        if (i == 4) {
            return null;
        }
        throw Kit.codeBug();
    }

    private Node findNestedYield(Node node) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            if (firstChild.getType() == 73 || firstChild.getType() == 166) {
                return firstChild;
            }
            Node nodeFindNestedYield = findNestedYield(firstChild);
            if (nodeFindNestedYield != null) {
                return nodeFindNestedYield;
            }
        }
        return null;
    }

    private void genSimpleCompare(int i, int i2, int i3) {
        c cVar;
        int i4;
        if (i2 == -1) {
            throw Codegen.badTree();
        }
        switch (i) {
            case 14:
                this.cfw.b(Token.GET);
                cVar = this.cfw;
                i4 = Token.CONST;
                break;
            case 15:
                this.cfw.b(Token.GET);
                cVar = this.cfw;
                i4 = Token.ARRAYCOMP;
                break;
            case 16:
                this.cfw.b(Token.TO_DOUBLE);
                cVar = this.cfw;
                i4 = Token.SETCONSTVAR;
                break;
            case 17:
                this.cfw.b(Token.TO_DOUBLE);
                cVar = this.cfw;
                i4 = Token.SETCONST;
                break;
            default:
                throw Codegen.badTree();
        }
        cVar.a(i4, i2);
        if (i3 != -1) {
            this.cfw.a(Token.LAST_TOKEN, i3);
        }
    }

    private void generateActivationExit() {
        if (this.fnCurrent == null || this.hasVarsInRegs) {
            throw Kit.codeBug();
        }
        this.cfw.c((int) this.contextLocal);
        addScriptRuntimeInvoke("exitActivationFunction", "(Lorg/mozilla/javascript/Context;)V");
    }

    private void generateArrayLiteralFactory(Node node, int i) {
        String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + i;
        initBodyGeneration();
        short s = this.firstFreeLocal;
        short s2 = (short) (s + 1);
        this.firstFreeLocal = s2;
        this.argsLocal = s;
        this.localsMax = s2;
        this.cfw.b(str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short) 2);
        visitArrayLiteral(node, node.getFirstChild(), true);
        this.cfw.b(176);
        this.cfw.c((short) (this.localsMax + 1));
    }

    private void generateCallArgArray(Node node, Node node2, boolean z) {
        short s;
        int i = 0;
        for (Node next = node2; next != null; next = next.getNext()) {
            i++;
        }
        if (i != 1 || (s = this.itsOneArgArray) < 0) {
            addNewObjectArray(i);
        } else {
            this.cfw.c((int) s);
        }
        for (int i2 = 0; i2 != i; i2++) {
            if (!this.isGenerator) {
                this.cfw.b(89);
                this.cfw.l(i2);
            }
            if (z) {
                int iNodeIsDirectCallParameter = nodeIsDirectCallParameter(node2);
                if (iNodeIsDirectCallParameter >= 0) {
                    dcpLoadAsObject(iNodeIsDirectCallParameter);
                } else {
                    generateExpression(node2, node);
                    if (node2.getIntProp(8, -1) == 0) {
                        addDoubleWrap();
                    }
                }
            } else {
                generateExpression(node2, node);
            }
            if (this.isGenerator) {
                short newWordLocal = getNewWordLocal();
                this.cfw.d(newWordLocal);
                this.cfw.a(192, "[Ljava/lang/Object;");
                this.cfw.b(89);
                this.cfw.l(i2);
                this.cfw.c((int) newWordLocal);
                releaseWordLocal(newWordLocal);
            }
            this.cfw.b(83);
            node2 = node2.getNext();
        }
    }

    private void generateCatchBlock(int i, short s, int i2, int i3, int i4) {
        if (i4 == 0) {
            i4 = this.cfw.a();
        }
        this.cfw.v(i4);
        this.cfw.d(i3);
        this.cfw.c((int) s);
        this.cfw.d(this.variableObjectLocal);
        this.cfw.a(Token.LAST_TOKEN, i2);
    }

    private void generateCheckForThrowOrClose(int i, boolean z, int i2) {
        int iA = this.cfw.a();
        int iA2 = this.cfw.a();
        this.cfw.w(iA);
        this.cfw.c((int) this.argsLocal);
        generateThrowJavaScriptException();
        this.cfw.w(iA2);
        this.cfw.c((int) this.argsLocal);
        this.cfw.a(192, "java/lang/Throwable");
        this.cfw.b(191);
        if (i != -1) {
            this.cfw.w(i);
        }
        if (!z) {
            this.cfw.d(this.generatorSwitch, i2);
        }
        this.cfw.h(this.operationLocal);
        this.cfw.k(2);
        this.cfw.a(Token.LETEXPR, iA2);
        this.cfw.h(this.operationLocal);
        this.cfw.k(1);
        this.cfw.a(Token.LETEXPR, iA);
    }

    private void generateEpilogue() {
        if (this.compilerEnv.isGenerateObserverCount()) {
            addInstructionCount();
        }
        if (this.isGenerator) {
            Map<Node, int[]> liveLocals = ((FunctionNode) this.scriptOrFn).getLiveLocals();
            if (liveLocals != null) {
                List<Node> resumptionPoints = ((FunctionNode) this.scriptOrFn).getResumptionPoints();
                for (int i = 0; i < resumptionPoints.size(); i++) {
                    Node node = resumptionPoints.get(i);
                    int[] iArr = liveLocals.get(node);
                    if (iArr != null) {
                        this.cfw.d(this.generatorSwitch, getNextGeneratorState(node));
                        generateGetGeneratorLocalsState();
                        for (int i2 = 0; i2 < iArr.length; i2++) {
                            this.cfw.b(89);
                            this.cfw.k(i2);
                            this.cfw.b(50);
                            this.cfw.d(iArr[i2]);
                        }
                        this.cfw.b(87);
                        this.cfw.a(Token.LAST_TOKEN, getTargetLabel(node));
                    }
                }
            }
            Map<Node, FinallyReturnPoint> map = this.finallys;
            if (map != null) {
                for (Map.Entry<Node, FinallyReturnPoint> entry : map.entrySet()) {
                    if (entry.getKey().getType() == 126) {
                        FinallyReturnPoint value = entry.getValue();
                        this.cfw.a(value.tableLabel, (short) 1);
                        int iC = this.cfw.c(0, value.jsrPoints.size() - 1);
                        this.cfw.x(iC);
                        int i3 = 0;
                        for (int i4 = 0; i4 < value.jsrPoints.size(); i4++) {
                            this.cfw.d(iC, i3);
                            this.cfw.a(Token.LAST_TOKEN, value.jsrPoints.get(i4).intValue());
                            i3++;
                        }
                    }
                }
            }
        }
        int i5 = this.epilogueLabel;
        if (i5 != -1) {
            this.cfw.w(i5);
        }
        if (this.isGenerator) {
            if (((FunctionNode) this.scriptOrFn).getResumptionPoints() != null) {
                this.cfw.x(this.generatorSwitch);
            }
            generateSetGeneratorResumptionPoint(-1);
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.c((int) this.generatorStateLocal);
            addOptRuntimeInvoke("throwStopIteration", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            Codegen.pushUndefined(this.cfw);
            this.cfw.b(176);
            return;
        }
        if (this.hasVarsInRegs) {
            this.cfw.b(176);
            return;
        }
        if (this.fnCurrent == null) {
            this.cfw.c((int) this.popvLocal);
            this.cfw.b(176);
            return;
        }
        generateActivationExit();
        this.cfw.b(176);
        int iA = this.cfw.a();
        this.cfw.v(iA);
        short newWordLocal = getNewWordLocal();
        this.cfw.d(newWordLocal);
        generateActivationExit();
        this.cfw.c((int) newWordLocal);
        releaseWordLocal(newWordLocal);
        this.cfw.b(191);
        this.cfw.a(this.enterAreaStartLabel, this.epilogueLabel, iA, (String) null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:131:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:175:0x0400  */
    /* JADX WARN: Code duplicated, block: B:177:0x0404  */
    /* JADX WARN: Code duplicated, block: B:195:0x0446  */
    private void generateExpression(Node node, Node node2) {
        String str;
        String str2;
        String str3;
        String str4;
        c cVar;
        int i;
        int type = node.getType();
        Node firstChild = node.getFirstChild();
        if (type == 150) {
            int intProp = firstChild.getType() == 40 ? firstChild.getIntProp(8, -1) : -1;
            if (intProp == -1) {
                generateExpression(firstChild, node);
                addDoubleWrap();
                return;
            } else {
                firstChild.removeProp(8);
                generateExpression(firstChild, node);
                firstChild.putIntProp(8, intProp);
                return;
            }
        }
        if (type == 151) {
            generateExpression(firstChild, node);
            addObjectToDouble();
            return;
        }
        switch (type) {
            case 8:
                visitSetName(node, firstChild);
                return;
            case 9:
            case 10:
            case 11:
            case 18:
            case 19:
            case 20:
                visitBitOp(node, type, firstChild);
                return;
            case 12:
            case 13:
            case 46:
            case 47:
                int iA = this.cfw.a();
                int iA2 = this.cfw.a();
                visitIfJumpEqOp(node, firstChild, iA, iA2);
                addJumpedBooleanWrap(iA, iA2);
                return;
            case 14:
            case 15:
            case 16:
            case 17:
                int iA3 = this.cfw.a();
                int iA4 = this.cfw.a();
                visitIfJumpRelOp(node, firstChild, iA3, iA4);
                addJumpedBooleanWrap(iA3, iA4);
                return;
            case 21:
                generateExpression(firstChild, node);
                generateExpression(firstChild.getNext(), node);
                int intProp2 = node.getIntProp(8, -1);
                if (intProp2 == 0) {
                    this.cfw.b(99);
                    return;
                }
                if (intProp2 == 1) {
                    addOptRuntimeInvoke("add", "(DLjava/lang/Object;)Ljava/lang/Object;");
                    return;
                }
                if (intProp2 == 2) {
                    addOptRuntimeInvoke("add", "(Ljava/lang/Object;D)Ljava/lang/Object;");
                    return;
                }
                if (firstChild.getType() == 41) {
                    str = "(Ljava/lang/CharSequence;Ljava/lang/Object;)Ljava/lang/CharSequence;";
                } else if (firstChild.getNext().getType() == 41) {
                    str = "(Ljava/lang/Object;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;";
                } else {
                    this.cfw.c((int) this.contextLocal);
                    str = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;";
                }
                str2 = str;
                str3 = "add";
                addScriptRuntimeInvoke(str3, str2);
                return;
            case 22:
                visitArithmetic(node, 103, firstChild, node2);
                return;
            case 23:
                visitArithmetic(node, 107, firstChild, node2);
                return;
            case 24:
            case 25:
                visitArithmetic(node, type == 24 ? 111 : 115, firstChild, node2);
                return;
            case 26:
                int iA5 = this.cfw.a();
                int iA6 = this.cfw.a();
                int iA7 = this.cfw.a();
                generateIfJump(firstChild, node, iA5, iA6);
                this.cfw.w(iA5);
                this.cfw.a(178, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
                this.cfw.a(Token.LAST_TOKEN, iA7);
                this.cfw.w(iA6);
                this.cfw.a(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
                this.cfw.w(iA7);
                this.cfw.q(-1);
                return;
            case 27:
                generateExpression(firstChild, node);
                addScriptRuntimeInvoke("toInt32", "(Ljava/lang/Object;)I");
                this.cfw.l(-1);
                this.cfw.b(130);
                this.cfw.b(135);
                addDoubleWrap();
                return;
            case 28:
            case 29:
                generateExpression(firstChild, node);
                addObjectToDouble();
                if (type == 29) {
                    this.cfw.b(119);
                }
                addDoubleWrap();
                return;
            case 30:
            case 38:
                int intProp3 = node.getIntProp(10, 0);
                if (intProp3 != 0) {
                    visitSpecialCall(node, type, intProp3, firstChild);
                    return;
                }
                OptFunctionNode optFunctionNode = (OptFunctionNode) node.getProp(9);
                if (optFunctionNode != null) {
                    visitOptimizedCall(node, optFunctionNode, type, firstChild);
                    return;
                } else if (type == 38) {
                    visitStandardCall(node, firstChild);
                    return;
                } else {
                    visitStandardNew(node, firstChild);
                    return;
                }
            case 31:
                boolean z = firstChild.getType() == 49;
                generateExpression(firstChild, node);
                generateExpression(firstChild.getNext(), node);
                this.cfw.c((int) this.contextLocal);
                this.cfw.a(z);
                str3 = "delete";
                str2 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Z)Ljava/lang/Object;";
                addScriptRuntimeInvoke(str3, str2);
                return;
            case 32:
                generateExpression(firstChild, node);
                str3 = "typeof";
                str2 = "(Ljava/lang/Object;)Ljava/lang/String;";
                addScriptRuntimeInvoke(str3, str2);
                return;
            case 33:
            case 34:
                visitGetProp(node, firstChild);
                return;
            case 35:
                visitSetProp(type, node, firstChild);
                return;
            case 36:
                generateExpression(firstChild, node);
                generateExpression(firstChild.getNext(), node);
                this.cfw.c((int) this.contextLocal);
                if (node.getIntProp(8, -1) != -1) {
                    str3 = "getObjectIndex";
                    str2 = "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;)Ljava/lang/Object;";
                } else {
                    this.cfw.c((int) this.variableObjectLocal);
                    str3 = "getObjectElem";
                    str2 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
                }
                addScriptRuntimeInvoke(str3, str2);
                return;
            case 37:
                visitSetElem(type, node, firstChild);
                return;
            case 39:
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                this.cfw.e(node.getString());
                str3 = "name";
                str2 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/Object;";
                addScriptRuntimeInvoke(str3, str2);
                return;
            case 40:
                double d = node.getDouble();
                if (node.getIntProp(8, -1) != -1) {
                    this.cfw.b(d);
                    return;
                } else {
                    this.codegen.pushNumberAsObject(this.cfw, d);
                    return;
                }
            case 41:
                this.cfw.e(node.getString());
                return;
            case 42:
                this.cfw.b(1);
                return;
            case 43:
                this.cfw.c((int) this.thisObjLocal);
                return;
            case 44:
                this.cfw.a(178, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
                return;
            case 45:
                this.cfw.a(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
                return;
            case 48:
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                int existingIntProp = node.getExistingIntProp(4);
                c cVar2 = this.cfw;
                Codegen codegen = this.codegen;
                cVar2.a(178, codegen.mainClassName, codegen.getCompiledRegexpName(this.scriptOrFn, existingIntProp), "Ljava/lang/Object;");
                this.cfw.b(184, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "wrapRegExp", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
                return;
            case 49:
                while (firstChild != null) {
                    generateExpression(firstChild, node);
                    firstChild = firstChild.getNext();
                }
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                this.cfw.e(node.getString());
                str3 = "bind";
                str2 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Lorg/mozilla/javascript/Scriptable;";
                addScriptRuntimeInvoke(str3, str2);
                return;
            default:
                switch (type) {
                    case 52:
                    case 53:
                        int iA8 = this.cfw.a();
                        int iA9 = this.cfw.a();
                        visitIfJumpRelOp(node, firstChild, iA8, iA9);
                        addJumpedBooleanWrap(iA8, iA9);
                        return;
                    case 54:
                        this.cfw.c(getLocalBlockRegister(node));
                        return;
                    case 55:
                        visitGetVar(node);
                        return;
                    case 56:
                        visitSetVar(node, firstChild, true);
                        return;
                    default:
                        switch (type) {
                            case 62:
                            case 63:
                                this.cfw.c(getLocalBlockRegister(node));
                                if (type == 62) {
                                    str3 = "enumNext";
                                    str2 = "(Ljava/lang/Object;)Ljava/lang/Boolean;";
                                } else {
                                    this.cfw.c((int) this.contextLocal);
                                    str3 = "enumId";
                                    str2 = "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;";
                                }
                                addScriptRuntimeInvoke(str3, str2);
                                return;
                            case 64:
                                this.cfw.b(42);
                                return;
                            default:
                                switch (type) {
                                    case 66:
                                        visitArrayLiteral(node, firstChild, false);
                                        return;
                                    case 67:
                                        visitObjectLiteral(node, firstChild, false);
                                        return;
                                    case 68:
                                        generateExpression(firstChild, node);
                                        this.cfw.c((int) this.contextLocal);
                                        str3 = "refGet";
                                        str2 = "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;";
                                        addScriptRuntimeInvoke(str3, str2);
                                        return;
                                    case 69:
                                        generateExpression(firstChild, node);
                                        Node next = firstChild.getNext();
                                        if (type == 143) {
                                            this.cfw.b(89);
                                            this.cfw.c((int) this.contextLocal);
                                            addScriptRuntimeInvoke("refGet", "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
                                        }
                                        generateExpression(next, node);
                                        this.cfw.c((int) this.contextLocal);
                                        this.cfw.c((int) this.variableObjectLocal);
                                        str3 = "refSet";
                                        str2 = "(Lorg/mozilla/javascript/Ref;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
                                        addScriptRuntimeInvoke(str3, str2);
                                        return;
                                    case 70:
                                        generateExpression(firstChild, node);
                                        this.cfw.c((int) this.contextLocal);
                                        str3 = "refDel";
                                        str2 = "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;";
                                        addScriptRuntimeInvoke(str3, str2);
                                        return;
                                    case 71:
                                        generateFunctionAndThisObj(firstChild, node);
                                        generateCallArgArray(node, firstChild.getNext(), false);
                                        this.cfw.c((int) this.contextLocal);
                                        str3 = "callRef";
                                        str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Ref;";
                                        addScriptRuntimeInvoke(str3, str2);
                                        return;
                                    case 72:
                                        String str5 = (String) node.getProp(17);
                                        generateExpression(firstChild, node);
                                        this.cfw.e(str5);
                                        this.cfw.c((int) this.contextLocal);
                                        this.cfw.c((int) this.variableObjectLocal);
                                        str3 = "specialRef";
                                        str2 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Ref;";
                                        addScriptRuntimeInvoke(str3, str2);
                                        return;
                                    case 73:
                                        generateYieldPoint(node, true);
                                        return;
                                    case 74:
                                        visitStrictSetName(node, firstChild);
                                        return;
                                    case 75:
                                        generateExpression(firstChild, node);
                                        this.cfw.c((int) this.contextLocal);
                                        str3 = "setDefaultNamespace";
                                        str2 = "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;";
                                        addScriptRuntimeInvoke(str3, str2);
                                        return;
                                    case 76:
                                        generateExpression(firstChild, node);
                                        this.cfw.c((int) this.contextLocal);
                                        str3 = "escapeAttributeValue";
                                        str2 = "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/String;";
                                        addScriptRuntimeInvoke(str3, str2);
                                        return;
                                    case 77:
                                        generateExpression(firstChild, node);
                                        this.cfw.c((int) this.contextLocal);
                                        str3 = "escapeTextValue";
                                        str2 = "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/String;";
                                        addScriptRuntimeInvoke(str3, str2);
                                        return;
                                    case 78:
                                    case 79:
                                    case 80:
                                    case 81:
                                        int intProp4 = node.getIntProp(16, 0);
                                        do {
                                            generateExpression(firstChild, node);
                                            firstChild = firstChild.getNext();
                                        } while (firstChild != null);
                                        this.cfw.c((int) this.contextLocal);
                                        switch (type) {
                                            case 78:
                                                str3 = "memberRef";
                                                str4 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;I)Lorg/mozilla/javascript/Ref;";
                                                break;
                                            case 79:
                                                str3 = "memberRef";
                                                str4 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;I)Lorg/mozilla/javascript/Ref;";
                                                break;
                                            case 80:
                                                this.cfw.c((int) this.variableObjectLocal);
                                                str3 = "nameRef";
                                                str4 = "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Lorg/mozilla/javascript/Ref;";
                                                break;
                                            case 81:
                                                this.cfw.c((int) this.variableObjectLocal);
                                                str3 = "nameRef";
                                                str4 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Lorg/mozilla/javascript/Ref;";
                                                break;
                                            default:
                                                throw Kit.codeBug();
                                        }
                                        this.cfw.l(intProp4);
                                        str2 = str4;
                                        addScriptRuntimeInvoke(str3, str2);
                                        return;
                                    default:
                                        if (type != 90) {
                                            if (type == 103) {
                                                Node next2 = firstChild.getNext();
                                                Node next3 = next2.getNext();
                                                generateExpression(firstChild, node);
                                                addScriptRuntimeInvoke("toBoolean", "(Ljava/lang/Object;)Z");
                                                int iA10 = this.cfw.a();
                                                this.cfw.a(Token.SET, iA10);
                                                short sH = this.cfw.h();
                                                generateExpression(next2, node);
                                                int iA11 = this.cfw.a();
                                                this.cfw.a(Token.LAST_TOKEN, iA11);
                                                this.cfw.a(iA10, sH);
                                                generateExpression(next3, node);
                                                this.cfw.w(iA11);
                                                return;
                                            }
                                            if (type == 110) {
                                                if (this.fnCurrent == null && node2.getType() == 137) {
                                                    return;
                                                }
                                                OptFunctionNode optFunctionNode2 = OptFunctionNode.get(this.scriptOrFn, node.getExistingIntProp(1));
                                                int functionType = optFunctionNode2.fnode.getFunctionType();
                                                if (functionType != 2 && functionType != 4) {
                                                    throw Codegen.badTree();
                                                }
                                                visitFunction(optFunctionNode2, functionType);
                                                return;
                                            }
                                            if (type == 127) {
                                                generateExpression(firstChild, node);
                                                this.cfw.b(87);
                                                Codegen.pushUndefined(this.cfw);
                                                return;
                                            }
                                            if (type != 143) {
                                                if (type == 147) {
                                                    visitDotQuery(node, firstChild);
                                                    return;
                                                }
                                                if (type == 160) {
                                                    Node next4 = firstChild.getNext();
                                                    Node next5 = next4.getNext();
                                                    generateStatement(firstChild);
                                                    generateExpression(next4.getFirstChild(), next4);
                                                    generateStatement(next5);
                                                    return;
                                                }
                                                if (type != 166) {
                                                    switch (type) {
                                                        case 105:
                                                        case 106:
                                                            generateExpression(firstChild, node);
                                                            this.cfw.b(89);
                                                            addScriptRuntimeInvoke("toBoolean", "(Ljava/lang/Object;)Z");
                                                            int iA12 = this.cfw.a();
                                                            if (type == 106) {
                                                                cVar = this.cfw;
                                                                i = Token.SET;
                                                            } else {
                                                                cVar = this.cfw;
                                                                i = Token.LET;
                                                            }
                                                            cVar.a(i, iA12);
                                                            this.cfw.b(87);
                                                            generateExpression(firstChild.getNext(), node);
                                                            this.cfw.w(iA12);
                                                            return;
                                                        case 107:
                                                        case 108:
                                                            visitIncDec(node);
                                                            return;
                                                        default:
                                                            switch (type) {
                                                                case 138:
                                                                    visitTypeofname(node);
                                                                    return;
                                                                case 139:
                                                                    return;
                                                                case 140:
                                                                    visitSetProp(type, node, firstChild);
                                                                    return;
                                                                case Token.SETELEM_OP /* 141 */:
                                                                    visitSetElem(type, node, firstChild);
                                                                    return;
                                                                default:
                                                                    switch (type) {
                                                                        case Token.SETCONST /* 156 */:
                                                                            visitSetConst(node, firstChild);
                                                                            return;
                                                                        case Token.SETCONSTVAR /* 157 */:
                                                                            visitSetConstVar(node, firstChild, true);
                                                                            return;
                                                                        case Token.ARRAYCOMP /* 158 */:
                                                                            Node next6 = firstChild.getNext();
                                                                            generateStatement(firstChild);
                                                                            generateExpression(next6, node);
                                                                            return;
                                                                        default:
                                                                            throw new RuntimeException("Unexpected node type " + type);
                                                                    }
                                                            }
                                                    }
                                                }
                                                generateYieldPoint(node, true);
                                                return;
                                            }
                                            generateExpression(firstChild, node);
                                            Node next7 = firstChild.getNext();
                                            if (type == 143) {
                                                this.cfw.b(89);
                                                this.cfw.c((int) this.contextLocal);
                                                addScriptRuntimeInvoke("refGet", "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
                                            }
                                            generateExpression(next7, node);
                                            this.cfw.c((int) this.contextLocal);
                                            this.cfw.c((int) this.variableObjectLocal);
                                            str3 = "refSet";
                                            str2 = "(Lorg/mozilla/javascript/Ref;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
                                            addScriptRuntimeInvoke(str3, str2);
                                            return;
                                        }
                                        while (true) {
                                            Node node3 = firstChild;
                                            firstChild = firstChild.getNext();
                                            generateExpression(node3, node);
                                            if (firstChild == null) {
                                                return;
                                            } else {
                                                this.cfw.b(87);
                                            }
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0048  */
    /* JADX WARN: Code duplicated, block: B:16:0x0055  */
    /* JADX WARN: Code duplicated, block: B:18:0x0074  */
    /* JADX WARN: Code duplicated, block: B:20:0x0080  */
    private void generateFunctionAndThisObj(Node node, Node node2) {
        Node next;
        String str;
        String str2;
        int type = node.getType();
        int type2 = node.getType();
        if (type2 == 33) {
            Node firstChild = node.getFirstChild();
            generateExpression(firstChild, node);
            next = firstChild.getNext();
            if (type == 33) {
                this.cfw.e(next.getString());
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                str = "getPropFunctionAndThis";
                str2 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;";
            } else {
                generateExpression(next, node);
                if (node.getIntProp(8, -1) != -1) {
                    addDoubleWrap();
                }
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                str = "getElemFunctionAndThis";
                str2 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;";
            }
        } else {
            if (type2 == 34) {
                throw Kit.codeBug();
            }
            if (type2 == 36) {
                Node firstChild2 = node.getFirstChild();
                generateExpression(firstChild2, node);
                next = firstChild2.getNext();
                if (type == 33) {
                    this.cfw.e(next.getString());
                    this.cfw.c((int) this.contextLocal);
                    this.cfw.c((int) this.variableObjectLocal);
                    str = "getPropFunctionAndThis";
                    str2 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;";
                } else {
                    generateExpression(next, node);
                    if (node.getIntProp(8, -1) != -1) {
                        addDoubleWrap();
                    }
                    this.cfw.c((int) this.contextLocal);
                    this.cfw.c((int) this.variableObjectLocal);
                    str = "getElemFunctionAndThis";
                    str2 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;";
                }
            } else if (type2 != 39) {
                generateExpression(node, node2);
                this.cfw.c((int) this.contextLocal);
                str = "getValueFunctionAndThis";
                str2 = "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Callable;";
            } else {
                this.cfw.e(node.getString());
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                str = "getNameFunctionAndThis";
                str2 = "(Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;";
            }
        }
        addScriptRuntimeInvoke(str, str2);
        this.cfw.c((int) this.contextLocal);
        addScriptRuntimeInvoke("lastStoredScriptable", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void generateGenerator() {
        this.cfw.b(this.codegen.getBodyMethodName(this.scriptOrFn), this.codegen.getBodyMethodSignature(this.scriptOrFn), (short) 10);
        initBodyGeneration();
        short s = this.firstFreeLocal;
        short s2 = (short) (s + 1);
        this.firstFreeLocal = s2;
        this.argsLocal = s;
        this.localsMax = s2;
        if (this.fnCurrent != null) {
            this.cfw.c((int) this.funObjLocal);
            this.cfw.b(185, "external/sdk/pendo/io/mozilla/javascript/Scriptable", "getParentScope", "()Lorg/mozilla/javascript/Scriptable;");
            this.cfw.d(this.variableObjectLocal);
        }
        this.cfw.c((int) this.funObjLocal);
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.c((int) this.argsLocal);
        this.cfw.a(this.scriptOrFn.isInStrictMode());
        addScriptRuntimeInvoke("createFunctionActivation", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.d(this.variableObjectLocal);
        this.cfw.a(187, this.codegen.mainClassName);
        this.cfw.b(89);
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.c((int) this.contextLocal);
        this.cfw.l(this.scriptOrFnIndex);
        this.cfw.b(183, this.codegen.mainClassName, "<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V");
        generateNestedFunctionInits();
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.c((int) this.thisObjLocal);
        this.cfw.k(this.maxLocals);
        this.cfw.k(this.maxStack);
        addOptRuntimeInvoke("createNativeGenerator", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;II)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.b(176);
        this.cfw.c((short) (this.localsMax + 1));
    }

    private void generateGetGeneratorLocalsState() {
        this.cfw.c((int) this.generatorStateLocal);
        addOptRuntimeInvoke("getGeneratorLocalsState", "(Ljava/lang/Object;)[Ljava/lang/Object;");
    }

    private void generateGetGeneratorResumptionPoint() {
        this.cfw.c((int) this.generatorStateLocal);
        this.cfw.a(180, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime$GeneratorState", "resumptionPoint", "I");
    }

    private void generateGetGeneratorStackState() {
        this.cfw.c((int) this.generatorStateLocal);
        addOptRuntimeInvoke("getGeneratorStackState", "(Ljava/lang/Object;)[Ljava/lang/Object;");
    }

    private void generateIfJump(Node node, Node node2, int i, int i2) {
        int type = node.getType();
        Node firstChild = node.getFirstChild();
        if (type == 26) {
            generateIfJump(firstChild, node, i2, i);
            return;
        }
        if (type != 46 && type != 47) {
            if (type != 52 && type != 53) {
                if (type == 105 || type == 106) {
                    int iA = this.cfw.a();
                    if (type == 106) {
                        generateIfJump(firstChild, node, iA, i2);
                    } else {
                        generateIfJump(firstChild, node, i, iA);
                    }
                    this.cfw.w(iA);
                    generateIfJump(firstChild.getNext(), node, i, i2);
                    return;
                }
                switch (type) {
                    case 12:
                    case 13:
                        break;
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        break;
                    default:
                        generateExpression(node, node2);
                        addScriptRuntimeInvoke("toBoolean", "(Ljava/lang/Object;)Z");
                        this.cfw.a(Token.LET, i);
                        this.cfw.a(Token.LAST_TOKEN, i2);
                        break;
                }
                return;
            }
            visitIfJumpRelOp(node, firstChild, i, i2);
            return;
        }
        visitIfJumpEqOp(node, firstChild, i, i2);
    }

    private void generateIntegerUnwrap() {
        this.cfw.b(182, "java/lang/Integer", "intValue", "()I");
    }

    private void generateIntegerWrap() {
        this.cfw.b(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    }

    private void generateLocalYieldPoint(Node node, boolean z) {
        c cVar;
        int iH = this.cfw.h();
        int i = this.maxStack;
        if (i <= iH) {
            i = iH;
        }
        this.maxStack = i;
        if (iH != 0) {
            generateGetGeneratorStackState();
            for (int i2 = 0; i2 < iH; i2++) {
                this.cfw.b(90);
                this.cfw.b(95);
                this.cfw.k(i2);
                this.cfw.b(95);
                this.cfw.b(83);
            }
            this.cfw.b(87);
        }
        Node firstChild = node.getFirstChild();
        if (firstChild != null) {
            generateExpression(firstChild, node);
        } else {
            Codegen.pushUndefined(this.cfw);
        }
        if (node.getType() == 166) {
            this.cfw.a(187, "external/sdk/pendo/io/mozilla/javascript/ES6Generator$YieldStarResult");
            this.cfw.b(90);
            this.cfw.b(95);
            this.cfw.b(183, "external/sdk/pendo/io/mozilla/javascript/ES6Generator$YieldStarResult", "<init>", "(Ljava/lang/Object;)V");
        }
        int nextGeneratorState = getNextGeneratorState(node);
        generateSetGeneratorResumptionPoint(nextGeneratorState);
        boolean zGenerateSaveLocals = generateSaveLocals(node);
        this.cfw.b(176);
        generateCheckForThrowOrClose(getTargetLabel(node), zGenerateSaveLocals, nextGeneratorState);
        if (iH != 0) {
            generateGetGeneratorStackState();
            while (true) {
                iH--;
                cVar = this.cfw;
                if (iH < 0) {
                    break;
                }
                cVar.b(89);
                this.cfw.k(iH);
                this.cfw.b(50);
                this.cfw.b(95);
            }
            cVar.b(87);
        }
        if (z) {
            this.cfw.c((int) this.argsLocal);
        }
    }

    private void generateNestedFunctionInits() {
        int functionCount = this.scriptOrFn.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn, i);
            if (optFunctionNode.fnode.getFunctionType() == 1) {
                visitFunction(optFunctionNode, 1);
            }
        }
    }

    private void generateObjectLiteralFactory(Node node, int i) {
        String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + i;
        initBodyGeneration();
        short s = this.firstFreeLocal;
        short s2 = (short) (s + 1);
        this.firstFreeLocal = s2;
        this.argsLocal = s;
        this.localsMax = s2;
        this.cfw.b(str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short) 2);
        visitObjectLiteral(node, node.getFirstChild(), true);
        this.cfw.b(176);
        this.cfw.c((short) (this.localsMax + 1));
    }

    private void generatePrologue() {
        String str;
        short newWordLocal;
        if (this.inDirectCallFunction) {
            int paramCount = this.scriptOrFn.getParamCount();
            if (this.firstFreeLocal != 4) {
                Kit.codeBug();
            }
            for (int i = 0; i != paramCount; i++) {
                short[] sArr = this.varRegisters;
                short s = this.firstFreeLocal;
                sArr[i] = s;
                this.firstFreeLocal = (short) (s + 3);
            }
            if (!this.fnCurrent.getParameterNumberContext()) {
                this.itsForcedObjectParameters = true;
                for (int i2 = 0; i2 != paramCount; i2++) {
                    short s2 = this.varRegisters[i2];
                    this.cfw.c((int) s2);
                    this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
                    int iA = this.cfw.a();
                    this.cfw.a(Token.YIELD_STAR, iA);
                    this.cfw.e(s2 + 1);
                    addDoubleWrap();
                    this.cfw.d(s2);
                    this.cfw.w(iA);
                }
            }
        }
        if (this.fnCurrent != null) {
            this.cfw.c((int) this.funObjLocal);
            this.cfw.b(185, "external/sdk/pendo/io/mozilla/javascript/Scriptable", "getParentScope", "()Lorg/mozilla/javascript/Scriptable;");
            this.cfw.d(this.variableObjectLocal);
        }
        short s3 = this.firstFreeLocal;
        short s4 = (short) (s3 + 1);
        this.firstFreeLocal = s4;
        this.argsLocal = s3;
        this.localsMax = s4;
        if (this.isGenerator) {
            short s5 = (short) (s4 + 1);
            this.firstFreeLocal = s5;
            this.operationLocal = s4;
            this.localsMax = s5;
            this.cfw.c((int) this.thisObjLocal);
            short s6 = this.firstFreeLocal;
            short s7 = (short) (s6 + 1);
            this.firstFreeLocal = s7;
            this.generatorStateLocal = s6;
            this.localsMax = s7;
            this.cfw.a(192, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime$GeneratorState");
            this.cfw.b(89);
            this.cfw.d(this.generatorStateLocal);
            this.cfw.a(180, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime$GeneratorState", "thisObj", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
            this.cfw.d(this.thisObjLocal);
            if (this.epilogueLabel == -1) {
                this.epilogueLabel = this.cfw.a();
            }
            List<Node> resumptionPoints = ((FunctionNode) this.scriptOrFn).getResumptionPoints();
            if (resumptionPoints != null) {
                generateGetGeneratorResumptionPoint();
                this.generatorSwitch = this.cfw.c(0, resumptionPoints.size());
                generateCheckForThrowOrClose(-1, false, 0);
            }
        }
        if (this.fnCurrent == null && this.scriptOrFn.getRegexpCount() != 0) {
            this.cfw.c((int) this.contextLocal);
            this.cfw.b(184, this.codegen.mainClassName, "_reInit", "(Lorg/mozilla/javascript/Context;)V");
        }
        if (this.compilerEnv.isGenerateObserverCount()) {
            saveCurrentCodeOffset();
        }
        if (this.isGenerator) {
            return;
        }
        if (!this.hasVarsInRegs) {
            ScriptNode scriptNode = this.scriptOrFn;
            boolean z = (scriptNode instanceof FunctionNode) && ((FunctionNode) scriptNode).getFunctionType() == 4;
            if (this.fnCurrent != null) {
                this.cfw.c((int) this.funObjLocal);
                this.cfw.c((int) this.variableObjectLocal);
                this.cfw.c((int) this.argsLocal);
                String str2 = z ? "createArrowFunctionActivation" : "createFunctionActivation";
                this.cfw.a(this.scriptOrFn.isInStrictMode());
                addScriptRuntimeInvoke(str2, "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Lorg/mozilla/javascript/Scriptable;");
                this.cfw.d(this.variableObjectLocal);
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                addScriptRuntimeInvoke("enterActivationFunction", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V");
                str = "activation";
            } else {
                this.cfw.c((int) this.funObjLocal);
                this.cfw.c((int) this.thisObjLocal);
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                this.cfw.l(0);
                addScriptRuntimeInvoke("initScript", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Z)V");
                str = "global";
            }
            this.enterAreaStartLabel = this.cfw.a();
            this.epilogueLabel = this.cfw.a();
            this.cfw.w(this.enterAreaStartLabel);
            generateNestedFunctionInits();
            if (this.compilerEnv.isGenerateDebugInfo()) {
                c cVar = this.cfw;
                cVar.a(str, "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;", cVar.g(), this.variableObjectLocal);
            }
            OptFunctionNode optFunctionNode = this.fnCurrent;
            if (optFunctionNode == null) {
                this.popvLocal = getNewWordLocal();
                Codegen.pushUndefined(this.cfw);
                this.cfw.d(this.popvLocal);
                int endLineno = this.scriptOrFn.getEndLineno();
                if (endLineno != -1) {
                    this.cfw.a((short) endLineno);
                    return;
                }
                return;
            }
            if (optFunctionNode.itsContainsCalls0) {
                this.itsZeroArgArray = getNewWordLocal();
                this.cfw.a(178, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
                this.cfw.d(this.itsZeroArgArray);
            }
            if (this.fnCurrent.itsContainsCalls1) {
                this.itsOneArgArray = getNewWordLocal();
                this.cfw.l(1);
                this.cfw.a(PsExtractor.PRIVATE_STREAM_1, "java/lang/Object");
                this.cfw.d(this.itsOneArgArray);
                return;
            }
            return;
        }
        int paramCount2 = this.scriptOrFn.getParamCount();
        if (paramCount2 > 0 && !this.inDirectCallFunction) {
            this.cfw.c((int) this.argsLocal);
            this.cfw.b(190);
            this.cfw.l(paramCount2);
            int iA2 = this.cfw.a();
            this.cfw.a(Token.COMMENT, iA2);
            this.cfw.c((int) this.argsLocal);
            this.cfw.l(paramCount2);
            addScriptRuntimeInvoke("padArguments", "([Ljava/lang/Object;I)[Ljava/lang/Object;");
            this.cfw.d(this.argsLocal);
            this.cfw.w(iA2);
        }
        int paramCount3 = this.fnCurrent.fnode.getParamCount();
        int paramAndVarCount = this.fnCurrent.fnode.getParamAndVarCount();
        boolean[] paramAndVarConst = this.fnCurrent.fnode.getParamAndVarConst();
        short s8 = -1;
        for (int i3 = 0; i3 != paramAndVarCount; i3++) {
            if (i3 < paramCount3) {
                if (this.inDirectCallFunction) {
                    newWordLocal = -1;
                } else {
                    newWordLocal = getNewWordLocal();
                    this.cfw.c((int) this.argsLocal);
                    this.cfw.l(i3);
                    this.cfw.b(50);
                    this.cfw.d(newWordLocal);
                }
            } else if (this.fnCurrent.isNumberVar(i3)) {
                newWordLocal = getNewWordPairLocal(paramAndVarConst[i3]);
                this.cfw.b(0.0d);
                this.cfw.f(newWordLocal);
            } else {
                newWordLocal = getNewWordLocal(paramAndVarConst[i3]);
                if (s8 == -1) {
                    Codegen.pushUndefined(this.cfw);
                    s8 = newWordLocal;
                } else {
                    this.cfw.c((int) s8);
                }
                this.cfw.d(newWordLocal);
            }
            if (newWordLocal >= 0) {
                if (paramAndVarConst[i3]) {
                    this.cfw.l(0);
                    this.cfw.i((this.fnCurrent.isNumberVar(i3) ? (short) 2 : (short) 1) + newWordLocal);
                }
                this.varRegisters[i3] = newWordLocal;
            }
            if (this.compilerEnv.isGenerateDebugInfo()) {
                String paramOrVarName = this.fnCurrent.fnode.getParamOrVarName(i3);
                String str3 = this.fnCurrent.isNumberVar(i3) ? "D" : "Ljava/lang/Object;";
                int iG = this.cfw.g();
                if (newWordLocal < 0) {
                    newWordLocal = this.varRegisters[i3];
                }
                this.cfw.a(paramOrVarName, str3, iG, newWordLocal);
            }
        }
    }

    private boolean generateSaveLocals(Node node) {
        int i = 0;
        for (int i2 = 0; i2 < this.firstFreeLocal; i2++) {
            if (this.locals[i2] != 0) {
                i++;
            }
        }
        if (i == 0) {
            ((FunctionNode) this.scriptOrFn).addLiveLocals(node, null);
            return false;
        }
        int i3 = this.maxLocals;
        if (i3 <= i) {
            i3 = i;
        }
        this.maxLocals = i3;
        int[] iArr = new int[i];
        int i4 = 0;
        for (int i5 = 0; i5 < this.firstFreeLocal; i5++) {
            if (this.locals[i5] != 0) {
                iArr[i4] = i5;
                i4++;
            }
        }
        ((FunctionNode) this.scriptOrFn).addLiveLocals(node, iArr);
        generateGetGeneratorLocalsState();
        for (int i6 = 0; i6 < i; i6++) {
            this.cfw.b(89);
            this.cfw.k(i6);
            this.cfw.c(iArr[i6]);
            this.cfw.b(83);
        }
        this.cfw.b(87);
        return true;
    }

    private void generateSetGeneratorResumptionPoint(int i) {
        this.cfw.c((int) this.generatorStateLocal);
        this.cfw.k(i);
        this.cfw.a(181, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime$GeneratorState", "resumptionPoint", "I");
    }

    private void generateSetGeneratorReturnValue() {
        this.cfw.c((int) this.generatorStateLocal);
        this.cfw.b(95);
        addOptRuntimeInvoke("setGeneratorReturnValue", "(Ljava/lang/Object;Ljava/lang/Object;)V");
    }

    /* JADX WARN: Code duplicated, block: B:128:0x0284  */
    /* JADX WARN: Code duplicated, block: B:129:0x0288  */
    /* JADX WARN: Code duplicated, block: B:131:0x028b  */
    /* JADX WARN: Code duplicated, block: B:132:0x0291  */
    /* JADX WARN: Code duplicated, block: B:134:0x0295  */
    /* JADX WARN: Code duplicated, block: B:137:0x029e  */
    /* JADX WARN: Code duplicated, block: B:140:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:143:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:145:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:146:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:150:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:50:0x0104  */
    /* JADX WARN: Code duplicated, block: B:52:0x010c  */
    private void generateStatement(Node node) {
        short s;
        updateLineNumber(node);
        int type = node.getType();
        Node firstChild = node.getFirstChild();
        if (type == 50) {
            generateExpression(firstChild, node);
            if (this.compilerEnv.isGenerateObserverCount()) {
                addInstructionCount();
            }
            generateThrowJavaScriptException();
            return;
        }
        if (type == 51) {
            if (this.compilerEnv.isGenerateObserverCount()) {
                addInstructionCount();
            }
            this.cfw.c(getLocalBlockRegister(node));
            this.cfw.b(191);
            return;
        }
        switch (type) {
            case 2:
                generateExpression(firstChild, node);
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                addScriptRuntimeInvoke("enterWith", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
                this.cfw.d(this.variableObjectLocal);
                incReferenceWordLocal(this.variableObjectLocal);
                return;
            case 3:
                this.cfw.c((int) this.variableObjectLocal);
                addScriptRuntimeInvoke("leaveWith", "(Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
                this.cfw.d(this.variableObjectLocal);
                decReferenceWordLocal(this.variableObjectLocal);
                return;
            case 4:
                if (firstChild != null) {
                    generateExpression(firstChild, node);
                } else if (type == 4) {
                    Codegen.pushUndefined(this.cfw);
                } else {
                    s = this.popvLocal;
                    if (s >= 0) {
                        throw Codegen.badTree();
                    }
                    this.cfw.c((int) s);
                }
                if (this.isGenerator) {
                    generateSetGeneratorReturnValue();
                }
                if (this.compilerEnv.isGenerateObserverCount()) {
                    addInstructionCount();
                }
                if (this.epilogueLabel == -1) {
                    if (this.hasVarsInRegs) {
                        throw Codegen.badTree();
                    }
                    this.epilogueLabel = this.cfw.a();
                }
                this.cfw.a(Token.LAST_TOKEN, this.epilogueLabel);
                return;
            case 5:
            case 6:
            case 7:
                if (this.compilerEnv.isGenerateObserverCount()) {
                    addInstructionCount();
                }
                visitGoto((Jump) node, type, firstChild);
                return;
            default:
                int i = 2;
                switch (type) {
                    case 57:
                        this.cfw.b((short) 0);
                        int localBlockRegister = getLocalBlockRegister(node);
                        int existingIntProp = node.getExistingIntProp(14);
                        String string = firstChild.getString();
                        generateExpression(firstChild.getNext(), node);
                        c cVar = this.cfw;
                        if (existingIntProp == 0) {
                            cVar.b(1);
                        } else {
                            cVar.c(localBlockRegister);
                        }
                        this.cfw.e(string);
                        this.cfw.c((int) this.contextLocal);
                        this.cfw.c((int) this.variableObjectLocal);
                        addScriptRuntimeInvoke("newCatchScope", "(Ljava/lang/Throwable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
                        this.cfw.d(localBlockRegister);
                        return;
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                        generateExpression(firstChild, node);
                        this.cfw.c((int) this.contextLocal);
                        this.cfw.c((int) this.variableObjectLocal);
                        if (type == 58) {
                            i = 0;
                        } else if (type == 59) {
                            i = 1;
                        } else if (type == 61) {
                            i = 6;
                        }
                        this.cfw.l(i);
                        addScriptRuntimeInvoke("enumInit", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                        this.cfw.d(getLocalBlockRegister(node));
                        return;
                    default:
                        if (type != 65) {
                            if (type == 82) {
                                visitTryCatchFinally((Jump) node, firstChild);
                                return;
                            }
                            if (type == 110) {
                                OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn, node.getExistingIntProp(1));
                                int functionType = optFunctionNode.fnode.getFunctionType();
                                if (functionType == 3) {
                                    visitFunction(optFunctionNode, functionType);
                                    return;
                                } else {
                                    if (functionType != 1) {
                                        throw Codegen.badTree();
                                    }
                                    return;
                                }
                            }
                            if (type == 115) {
                                if (this.compilerEnv.isGenerateObserverCount()) {
                                    addInstructionCount();
                                }
                                visitSwitch((Jump) node, firstChild);
                                return;
                            }
                            if (type != 124) {
                                if (type == 126) {
                                    if (this.isGenerator) {
                                        if (this.compilerEnv.isGenerateObserverCount()) {
                                            saveCurrentCodeOffset();
                                        }
                                        this.cfw.b((short) 1);
                                        short newWordLocal = getNewWordLocal();
                                        int iA = this.cfw.a();
                                        int iA2 = this.cfw.a();
                                        this.cfw.w(iA);
                                        generateIntegerWrap();
                                        this.cfw.d(newWordLocal);
                                        while (firstChild != null) {
                                            generateStatement(firstChild);
                                            firstChild = firstChild.getNext();
                                        }
                                        this.cfw.c((int) newWordLocal);
                                        this.cfw.a(192, "java/lang/Integer");
                                        generateIntegerUnwrap();
                                        FinallyReturnPoint finallyReturnPoint = this.finallys.get(node);
                                        int iA3 = this.cfw.a();
                                        finallyReturnPoint.tableLabel = iA3;
                                        this.cfw.a(Token.LAST_TOKEN, iA3);
                                        this.cfw.b((short) 0);
                                        releaseWordLocal(newWordLocal);
                                        this.cfw.w(iA2);
                                        return;
                                    }
                                    return;
                                }
                                if (type == 142) {
                                    boolean z = this.inLocalBlock;
                                    this.inLocalBlock = true;
                                    short newWordLocal2 = getNewWordLocal();
                                    if (this.isGenerator) {
                                        this.cfw.b(1);
                                        this.cfw.d(newWordLocal2);
                                    }
                                    node.putIntProp(2, newWordLocal2);
                                    while (firstChild != null) {
                                        generateStatement(firstChild);
                                        firstChild = firstChild.getNext();
                                    }
                                    releaseWordLocal(newWordLocal2);
                                    node.removeProp(2);
                                    this.inLocalBlock = z;
                                    return;
                                }
                                if (type != 161) {
                                    switch (type) {
                                        case 129:
                                        case 130:
                                        case Token.LABEL /* 131 */:
                                        case Token.LOOP /* 133 */:
                                        case Token.SCRIPT /* 137 */:
                                            break;
                                        case Token.TARGET /* 132 */:
                                            if (this.compilerEnv.isGenerateObserverCount()) {
                                                addInstructionCount();
                                            }
                                            this.cfw.w(getTargetLabel(node));
                                            if (this.compilerEnv.isGenerateObserverCount()) {
                                                saveCurrentCodeOffset();
                                                return;
                                            }
                                            return;
                                        case 134:
                                            if (firstChild.getType() == 56) {
                                                visitSetVar(firstChild, firstChild.getFirstChild(), false);
                                                return;
                                            }
                                            if (firstChild.getType() == 157) {
                                                visitSetConstVar(firstChild, firstChild.getFirstChild(), false);
                                                return;
                                            }
                                            if (firstChild.getType() == 73 || firstChild.getType() == 166) {
                                                generateYieldPoint(firstChild, false);
                                                return;
                                            }
                                            generateExpression(firstChild, node);
                                            int intProp = node.getIntProp(8, -1);
                                            c cVar2 = this.cfw;
                                            if (intProp != -1) {
                                                cVar2.b(88);
                                                return;
                                            } else {
                                                cVar2.b(87);
                                                return;
                                            }
                                        case 135:
                                            generateExpression(firstChild, node);
                                            if (this.popvLocal < 0) {
                                                this.popvLocal = getNewWordLocal();
                                            }
                                            this.cfw.d(this.popvLocal);
                                            return;
                                        case 136:
                                            if (this.compilerEnv.isGenerateObserverCount()) {
                                                addInstructionCount();
                                            }
                                            visitGoto((Jump) node, type, firstChild);
                                            return;
                                        default:
                                            throw Codegen.badTree();
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (this.compilerEnv.isGenerateObserverCount()) {
                                addInstructionCount(1);
                            }
                            while (firstChild != null) {
                                generateStatement(firstChild);
                                firstChild = firstChild.getNext();
                            }
                            return;
                        }
                        if (firstChild != null) {
                            generateExpression(firstChild, node);
                        } else if (type == 4) {
                            Codegen.pushUndefined(this.cfw);
                        } else {
                            s = this.popvLocal;
                            if (s >= 0) {
                                throw Codegen.badTree();
                            }
                            this.cfw.c((int) s);
                        }
                        if (this.isGenerator) {
                            generateSetGeneratorReturnValue();
                        }
                        if (this.compilerEnv.isGenerateObserverCount()) {
                            addInstructionCount();
                        }
                        if (this.epilogueLabel == -1) {
                            if (this.hasVarsInRegs) {
                                throw Codegen.badTree();
                            }
                            this.epilogueLabel = this.cfw.a();
                        }
                        this.cfw.a(Token.LAST_TOKEN, this.epilogueLabel);
                        return;
                }
        }
    }

    private void generateThrowJavaScriptException() {
        this.cfw.a(187, "external/sdk/pendo/io/mozilla/javascript/JavaScriptException");
        this.cfw.b(90);
        this.cfw.b(95);
        this.cfw.e(this.scriptOrFn.getSourceName());
        this.cfw.l(this.itsLineNumber);
        this.cfw.b(183, "external/sdk/pendo/io/mozilla/javascript/JavaScriptException", "<init>", "(Ljava/lang/Object;Ljava/lang/String;I)V");
        this.cfw.b(191);
    }

    private void generateYieldPoint(Node node, boolean z) {
        if (this.unnestedYields.containsKey(node)) {
            if (z) {
                this.cfw.c((int) this.variableObjectLocal);
                this.cfw.d(this.unnestedYields.get(node));
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                addScriptRuntimeInvoke("getObjectPropNoWarn", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
                return;
            }
            return;
        }
        Node nodeFindNestedYield = findNestedYield(node);
        if (nodeFindNestedYield != null) {
            generateYieldPoint(nodeFindNestedYield, true);
            String str = "__nested__yield__" + this.unnestedYieldCount;
            this.unnestedYieldCount++;
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.b(95);
            this.cfw.d(str);
            this.cfw.b(95);
            this.cfw.c((int) this.contextLocal);
            addScriptRuntimeInvoke("setObjectProp", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
            this.cfw.b(87);
            this.unnestedYields.put(nodeFindNestedYield, str);
        }
        generateLocalYieldPoint(node, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Node getFinallyAtTarget(Node node) {
        Node next;
        if (node == null) {
            return null;
        }
        if (node.getType() == 126) {
            return node;
        }
        if (node.getType() == 132 && (next = node.getNext()) != null && next.getType() == 126) {
            return next;
        }
        throw Kit.codeBug("bad finally target");
    }

    private static int getLocalBlockRegister(Node node) {
        return ((Node) node.getProp(3)).getExistingIntProp(2);
    }

    private short getNewWordIntern(int i) {
        int i2;
        int[] iArr = this.locals;
        int i3 = this.firstFreeLocal;
        if (i > 1) {
            loop0: while (true) {
                if (i3 + i > 1024) {
                    i3 = -1;
                    break;
                }
                int i4 = 0;
                do {
                    if (i4 >= i) {
                        break loop0;
                    }
                    i2 = iArr[i3 + i4];
                    i4++;
                } while (i2 == 0);
                i3 += i4;
            }
        }
        if (i3 != -1) {
            iArr[i3] = 1;
            if (i > 1) {
                iArr[i3 + 1] = 1;
            }
            if (i > 2) {
                iArr[i3 + 2] = 1;
            }
            if (i3 != this.firstFreeLocal) {
                return (short) i3;
            }
            for (int i5 = i + i3; i5 < 1024; i5++) {
                if (iArr[i5] == 0) {
                    short s = (short) i5;
                    this.firstFreeLocal = s;
                    if (this.localsMax < s) {
                        this.localsMax = s;
                    }
                    return (short) i3;
                }
            }
        }
        throw Context.reportRuntimeError("Program too complex (out of locals)");
    }

    private short getNewWordLocal() {
        return getNewWordIntern(1);
    }

    private short getNewWordPairLocal(boolean z) {
        return getNewWordIntern(z ? 3 : 2);
    }

    private int getNextGeneratorState(Node node) {
        return ((FunctionNode) this.scriptOrFn).getResumptionPoints().indexOf(node) + 1;
    }

    private int getTargetLabel(Node node) {
        int iLabelId = node.labelId();
        if (iLabelId != -1) {
            return iLabelId;
        }
        int iA = this.cfw.a();
        node.labelId(iA);
        return iA;
    }

    private void incReferenceWordLocal(short s) {
        int[] iArr = this.locals;
        iArr[s] = iArr[s] + 1;
    }

    private void initBodyGeneration() {
        int paramAndVarCount;
        this.varRegisters = null;
        if (this.scriptOrFn.getType() == 110) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn);
            this.fnCurrent = optFunctionNode;
            boolean zRequiresActivation = optFunctionNode.fnode.requiresActivation();
            this.hasVarsInRegs = !zRequiresActivation;
            if (!zRequiresActivation && (paramAndVarCount = this.fnCurrent.fnode.getParamAndVarCount()) != 0) {
                this.varRegisters = new short[paramAndVarCount];
            }
            boolean zIsTargetOfDirectCall = this.fnCurrent.isTargetOfDirectCall();
            this.inDirectCallFunction = zIsTargetOfDirectCall;
            if (zIsTargetOfDirectCall && !this.hasVarsInRegs) {
                Codegen.badTree();
            }
        } else {
            this.fnCurrent = null;
            this.hasVarsInRegs = false;
            this.inDirectCallFunction = false;
        }
        this.locals = new int[1024];
        this.funObjLocal = (short) 0;
        this.contextLocal = (short) 1;
        this.variableObjectLocal = (short) 2;
        this.thisObjLocal = (short) 3;
        this.localsMax = (short) 4;
        this.firstFreeLocal = (short) 4;
        this.popvLocal = (short) -1;
        this.argsLocal = (short) -1;
        this.itsZeroArgArray = (short) -1;
        this.itsOneArgArray = (short) -1;
        this.epilogueLabel = -1;
        this.enterAreaStartLabel = -1;
        this.generatorStateLocal = (short) -1;
    }

    private void inlineFinally(Node node) {
        int iA = this.cfw.a();
        int iA2 = this.cfw.a();
        this.cfw.w(iA);
        inlineFinally(node, iA, iA2);
        this.cfw.w(iA2);
    }

    private static boolean isArithmeticNode(Node node) {
        int type = node.getType();
        return type == 22 || type == 25 || type == 24 || type == 23;
    }

    private int nodeIsDirectCallParameter(Node node) {
        if (node.getType() != 55 || !this.inDirectCallFunction || this.itsForcedObjectParameters) {
            return -1;
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        if (this.fnCurrent.isParameter(varIndex)) {
            return this.varRegisters[varIndex];
        }
        return -1;
    }

    private void releaseWordLocal(short s) {
        if (s < this.firstFreeLocal) {
            this.firstFreeLocal = s;
        }
        this.locals[s] = 0;
    }

    private void saveCurrentCodeOffset() {
        this.savedCodeOffset = this.cfw.g();
    }

    private void updateLineNumber(Node node) {
        int lineno = node.getLineno();
        this.itsLineNumber = lineno;
        if (lineno == -1) {
            return;
        }
        this.cfw.a((short) lineno);
    }

    private boolean varIsDirectCallParameter(int i) {
        return this.fnCurrent.isParameter(i) && this.inDirectCallFunction && !this.itsForcedObjectParameters;
    }

    private void visitArithmetic(Node node, int i, Node node2, Node node3) {
        if (node.getIntProp(8, -1) != -1) {
            generateExpression(node2, node);
            generateExpression(node2.getNext(), node);
            this.cfw.b(i);
            return;
        }
        boolean zIsArithmeticNode = isArithmeticNode(node3);
        generateExpression(node2, node);
        if (!isArithmeticNode(node2)) {
            addObjectToDouble();
        }
        generateExpression(node2.getNext(), node);
        if (!isArithmeticNode(node2.getNext())) {
            addObjectToDouble();
        }
        this.cfw.b(i);
        if (zIsArithmeticNode) {
            return;
        }
        addDoubleWrap();
    }

    private void visitArrayLiteral(Node node, Node node2, boolean z) {
        int i = 0;
        int i2 = 0;
        for (Node next = node2; next != null; next = next.getNext()) {
            i2++;
        }
        if (!z && ((i2 > 10 || this.cfw.g() > 30000) && !this.hasVarsInRegs && !this.isGenerator && !this.inLocalBlock)) {
            if (this.literals == null) {
                this.literals = new LinkedList();
            }
            this.literals.add(node);
            String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + this.literals.size();
            this.cfw.c((int) this.funObjLocal);
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.c((int) this.thisObjLocal);
            this.cfw.c((int) this.argsLocal);
            this.cfw.b(182, this.codegen.mainClassName, str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        if (this.isGenerator) {
            for (int i3 = 0; i3 != i2; i3++) {
                generateExpression(node2, node);
                node2 = node2.getNext();
            }
            addNewObjectArray(i2);
            while (i != i2) {
                this.cfw.b(90);
                this.cfw.b(95);
                this.cfw.l((i2 - i) - 1);
                this.cfw.b(95);
                this.cfw.b(83);
                i++;
            }
        } else {
            addNewObjectArray(i2);
            while (i != i2) {
                this.cfw.b(89);
                this.cfw.l(i);
                generateExpression(node2, node);
                this.cfw.b(83);
                node2 = node2.getNext();
                i++;
            }
        }
        int[] iArr = (int[]) node.getProp(11);
        if (iArr == null) {
            this.cfw.b(1);
            this.cfw.b(3);
        } else {
            this.cfw.e(OptRuntime.encodeIntArray(iArr));
            this.cfw.l(iArr.length);
        }
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        addOptRuntimeInvoke("newArrayLiteral", "([Ljava/lang/Object;Ljava/lang/String;ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0097  */
    /* JADX WARN: Code duplicated, block: B:26:? A[RETURN, SYNTHETIC] */
    private void visitBitOp(Node node, int i, Node node2) {
        c cVar;
        int i2;
        int intProp = node.getIntProp(8, -1);
        generateExpression(node2, node);
        if (i == 20) {
            addScriptRuntimeInvoke("toUint32", "(Ljava/lang/Object;)J");
            generateExpression(node2.getNext(), node);
            addScriptRuntimeInvoke("toInt32", "(Ljava/lang/Object;)I");
            this.cfw.l(31);
            this.cfw.b(126);
            this.cfw.b(125);
            this.cfw.b(138);
            addDoubleWrap();
            return;
        }
        if (intProp == -1) {
            addScriptRuntimeInvoke("toInt32", "(Ljava/lang/Object;)I");
            generateExpression(node2.getNext(), node);
            addScriptRuntimeInvoke("toInt32", "(Ljava/lang/Object;)I");
        } else {
            addScriptRuntimeInvoke("toInt32", "(D)I");
            generateExpression(node2.getNext(), node);
            addScriptRuntimeInvoke("toInt32", "(D)I");
        }
        if (i == 18) {
            cVar = this.cfw;
            i2 = 120;
        } else if (i != 19) {
            switch (i) {
                case 9:
                    cVar = this.cfw;
                    i2 = 128;
                    break;
                case 10:
                    cVar = this.cfw;
                    i2 = 130;
                    break;
                case 11:
                    this.cfw.b(126);
                    this.cfw.b(135);
                    if (intProp == -1) {
                        addDoubleWrap();
                    }
                default:
                    throw Codegen.badTree();
            }
        } else {
            cVar = this.cfw;
            i2 = 122;
        }
        cVar.b(i2);
        this.cfw.b(135);
        if (intProp == -1) {
            addDoubleWrap();
        }
    }

    private void visitDotQuery(Node node, Node node2) {
        updateLineNumber(node);
        generateExpression(node2, node);
        this.cfw.c((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("enterDotQuery", "(Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.d(this.variableObjectLocal);
        this.cfw.b(1);
        int iA = this.cfw.a();
        this.cfw.w(iA);
        this.cfw.b(87);
        generateExpression(node2.getNext(), node);
        addScriptRuntimeInvoke("toBoolean", "(Ljava/lang/Object;)Z");
        this.cfw.c((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("updateDotQuery", "(ZLorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        this.cfw.b(89);
        this.cfw.a(198, iA);
        this.cfw.c((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("leaveDotQuery", "(Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.d(this.variableObjectLocal);
    }

    private void visitFunction(OptFunctionNode optFunctionNode, int i) {
        int index = this.codegen.getIndex(optFunctionNode.fnode);
        this.cfw.a(187, this.codegen.mainClassName);
        this.cfw.b(89);
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.c((int) this.contextLocal);
        this.cfw.l(index);
        this.cfw.b(183, this.codegen.mainClassName, "<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V");
        if (i == 4) {
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.c((int) this.thisObjLocal);
            addOptRuntimeInvoke("bindThis", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Function;");
        }
        if (i == 2 || i == 4) {
            return;
        }
        this.cfw.l(i);
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.c((int) this.contextLocal);
        addOptRuntimeInvoke("initFunction", "(Lorg/mozilla/javascript/NativeFunction;ILorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;)V");
    }

    private void visitGetProp(Node node, Node node2) {
        generateExpression(node2, node);
        Node next = node2.getNext();
        generateExpression(next, node);
        if (node.getType() == 34) {
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            addScriptRuntimeInvoke("getObjectPropNoWarn", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        } else if (node2.getType() == 43 && next.getType() == 41) {
            this.cfw.c((int) this.contextLocal);
            addScriptRuntimeInvoke("getObjectProp", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
        } else {
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            addScriptRuntimeInvoke("getObjectProp", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        }
    }

    private void visitGetVar(Node node) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        short s = this.varRegisters[varIndex];
        if (varIsDirectCallParameter(varIndex)) {
            if (node.getIntProp(8, -1) != -1) {
                dcpLoadAsNumber(s);
                return;
            } else {
                dcpLoadAsObject(s);
                return;
            }
        }
        boolean zIsNumberVar = this.fnCurrent.isNumberVar(varIndex);
        c cVar = this.cfw;
        if (zIsNumberVar) {
            cVar.e(s);
        } else {
            cVar.c((int) s);
        }
    }

    private void visitGoto(Jump jump, int i, Node node) {
        Node node2 = jump.target;
        if (i != 6 && i != 7) {
            if (i != 136) {
                addGoto(node2, Token.LAST_TOKEN);
                return;
            } else if (this.isGenerator) {
                addGotoWithReturn(node2);
                return;
            } else {
                inlineFinally(node2);
                return;
            }
        }
        if (node == null) {
            throw Codegen.badTree();
        }
        int targetLabel = getTargetLabel(node2);
        int iA = this.cfw.a();
        if (i == 6) {
            generateIfJump(node, jump, targetLabel, iA);
        } else {
            generateIfJump(node, jump, iA, targetLabel);
        }
        this.cfw.w(iA);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c5 A[PHI: r1
      0x00c5: PHI (r1v10 java.lang.String) = (r1v9 java.lang.String), (r1v14 java.lang.String) binds: [B:23:0x00ad, B:27:0x00b7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:53:0x013b  */
    private void visitIfJumpEqOp(Node node, Node node2, int i, int i2) {
        int i3;
        int i4;
        int i5;
        Node node3 = node2;
        int i6 = i;
        int i7 = i2;
        if (i6 == -1 || i7 == -1) {
            throw Codegen.badTree();
        }
        short sH = this.cfw.h();
        int type = node.getType();
        Node next = node3.getNext();
        if (node3.getType() == 42 || next.getType() == 42) {
            if (node3.getType() == 42) {
                node3 = next;
            }
            generateExpression(node3, node);
            int i8 = 46;
            if (type == 46) {
                this.cfw.a(type == i8 ? 198 : 199, i6);
            } else if (type == 47) {
                i8 = 46;
                this.cfw.a(type == i8 ? 198 : 199, i6);
            } else {
                if (type != 12) {
                    if (type != 13) {
                        throw Codegen.badTree();
                    }
                    i7 = i6;
                    i6 = i7;
                }
                this.cfw.b(89);
                int iA = this.cfw.a();
                this.cfw.a(199, iA);
                short sH2 = this.cfw.h();
                this.cfw.b(87);
                this.cfw.a(Token.LAST_TOKEN, i6);
                this.cfw.a(iA, sH2);
                Codegen.pushUndefined(this.cfw);
                this.cfw.a(Token.ARROW, i6);
            }
        } else {
            int iNodeIsDirectCallParameter = nodeIsDirectCallParameter(node3);
            if (iNodeIsDirectCallParameter == -1 || next.getType() != 150) {
                i3 = Token.SET;
                i4 = Token.LET;
            } else {
                Node firstChild = next.getFirstChild();
                if (firstChild.getType() == 40) {
                    this.cfw.c(iNodeIsDirectCallParameter);
                    this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
                    int iA2 = this.cfw.a();
                    this.cfw.a(Token.YIELD_STAR, iA2);
                    this.cfw.e(iNodeIsDirectCallParameter + 1);
                    this.cfw.b(firstChild.getDouble());
                    this.cfw.b(Token.TO_DOUBLE);
                    if (type == 12) {
                        c cVar = this.cfw;
                        i3 = Token.SET;
                        cVar.a(Token.SET, i6);
                        i4 = Token.LET;
                    } else {
                        i3 = Token.SET;
                        c cVar2 = this.cfw;
                        i4 = Token.LET;
                        cVar2.a(Token.LET, i6);
                    }
                    this.cfw.a(Token.LAST_TOKEN, i7);
                    this.cfw.w(iA2);
                } else {
                    i3 = Token.SET;
                    i4 = Token.LET;
                }
            }
            generateExpression(node3, node);
            generateExpression(next, node);
            String str = "eq";
            if (type == 12) {
                i5 = i4;
            } else {
                if (type != 13) {
                    str = "shallowEq";
                    if (type == 46) {
                        i5 = i4;
                    } else if (type != 47) {
                        throw Codegen.badTree();
                    }
                }
                i5 = i3;
            }
            addScriptRuntimeInvoke(str, "(Ljava/lang/Object;Ljava/lang/Object;)Z");
            this.cfw.a(i5, i6);
        }
        this.cfw.a(Token.LAST_TOKEN, i7);
        if (sH != this.cfw.h()) {
            throw Codegen.badTree();
        }
    }

    private void visitIfJumpRelOp(Node node, Node node2, int i, int i2) {
        String str;
        String str2;
        if (i == -1 || i2 == -1) {
            throw Codegen.badTree();
        }
        int type = node.getType();
        Node next = node2.getNext();
        if (type == 53 || type == 52) {
            generateExpression(node2, node);
            generateExpression(next, node);
            this.cfw.c((int) this.contextLocal);
            str = type == 53 ? "instanceOf" : "in";
            str2 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Z";
        } else {
            int intProp = node.getIntProp(8, -1);
            int iNodeIsDirectCallParameter = nodeIsDirectCallParameter(node2);
            int iNodeIsDirectCallParameter2 = nodeIsDirectCallParameter(next);
            if (intProp != -1) {
                if (intProp != 2) {
                    generateExpression(node2, node);
                } else if (iNodeIsDirectCallParameter != -1) {
                    dcpLoadAsNumber(iNodeIsDirectCallParameter);
                } else {
                    generateExpression(node2, node);
                    addObjectToDouble();
                }
                if (intProp != 1) {
                    generateExpression(next, node);
                } else if (iNodeIsDirectCallParameter2 != -1) {
                    dcpLoadAsNumber(iNodeIsDirectCallParameter2);
                } else {
                    generateExpression(next, node);
                    addObjectToDouble();
                }
                genSimpleCompare(type, i, i2);
                return;
            }
            if (iNodeIsDirectCallParameter == -1 || iNodeIsDirectCallParameter2 == -1) {
                generateExpression(node2, node);
                generateExpression(next, node);
            } else {
                short sH = this.cfw.h();
                int iA = this.cfw.a();
                this.cfw.c(iNodeIsDirectCallParameter);
                this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
                this.cfw.a(Token.YIELD_STAR, iA);
                this.cfw.e(iNodeIsDirectCallParameter + 1);
                dcpLoadAsNumber(iNodeIsDirectCallParameter2);
                genSimpleCompare(type, i, i2);
                if (sH != this.cfw.h()) {
                    throw Codegen.badTree();
                }
                this.cfw.w(iA);
                int iA2 = this.cfw.a();
                this.cfw.c(iNodeIsDirectCallParameter2);
                this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
                this.cfw.a(Token.YIELD_STAR, iA2);
                this.cfw.c(iNodeIsDirectCallParameter);
                addObjectToDouble();
                this.cfw.e(iNodeIsDirectCallParameter2 + 1);
                genSimpleCompare(type, i, i2);
                if (sH != this.cfw.h()) {
                    throw Codegen.badTree();
                }
                this.cfw.w(iA2);
                this.cfw.c(iNodeIsDirectCallParameter);
                this.cfw.c(iNodeIsDirectCallParameter2);
            }
            if (type == 17 || type == 16) {
                this.cfw.b(95);
            }
            str = (type == 14 || type == 16) ? "cmp_LT" : "cmp_LE";
            str2 = "(Ljava/lang/Object;Ljava/lang/Object;)Z";
        }
        addScriptRuntimeInvoke(str, str2);
        this.cfw.a(Token.LET, i);
        this.cfw.a(Token.LAST_TOKEN, i2);
    }

    private void visitIncDec(Node node) {
        int existingIntProp = node.getExistingIntProp(13);
        Node firstChild = node.getFirstChild();
        int type = firstChild.getType();
        if (type == 33) {
            Node firstChild2 = firstChild.getFirstChild();
            generateExpression(firstChild2, node);
            generateExpression(firstChild2.getNext(), node);
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.l(existingIntProp);
            addScriptRuntimeInvoke("propIncrDecr", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
            return;
        }
        if (type == 34) {
            throw Kit.codeBug();
        }
        if (type == 36) {
            Node firstChild3 = firstChild.getFirstChild();
            generateExpression(firstChild3, node);
            generateExpression(firstChild3.getNext(), node);
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.l(existingIntProp);
            if (firstChild3.getNext().getIntProp(8, -1) != -1) {
                addOptRuntimeInvoke("elemIncrDecr", "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                return;
            } else {
                addScriptRuntimeInvoke("elemIncrDecr", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                return;
            }
        }
        if (type == 39) {
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.e(firstChild.getString());
            this.cfw.c((int) this.contextLocal);
            this.cfw.l(existingIntProp);
            addScriptRuntimeInvoke("nameIncrDecr", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;I)Ljava/lang/Object;");
            return;
        }
        if (type != 55) {
            if (type != 68) {
                Codegen.badTree();
                return;
            }
            generateExpression(firstChild.getFirstChild(), node);
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.l(existingIntProp);
            addScriptRuntimeInvoke("refIncrDecr", "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
            return;
        }
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        boolean z = (existingIntProp & 2) != 0;
        int varIndex = this.fnCurrent.getVarIndex(firstChild);
        short s = this.varRegisters[varIndex];
        boolean z2 = this.fnCurrent.fnode.getParamAndVarConst()[varIndex];
        int intProp = node.getIntProp(8, -1);
        if (z2) {
            if (intProp != -1) {
                this.cfw.e(s + (varIsDirectCallParameter(varIndex) ? 1 : 0));
                if (z) {
                    return;
                }
                this.cfw.b(1.0d);
                int i = existingIntProp & 1;
                c cVar = this.cfw;
                if (i == 0) {
                    cVar.b(99);
                    return;
                } else {
                    cVar.b(103);
                    return;
                }
            }
            if (varIsDirectCallParameter(varIndex)) {
                dcpLoadAsObject(s);
            } else {
                this.cfw.c((int) s);
            }
            if (z) {
                this.cfw.b(89);
                addObjectToDouble();
                this.cfw.b(88);
                return;
            } else {
                addObjectToDouble();
                this.cfw.b(1.0d);
                if ((existingIntProp & 1) == 0) {
                    this.cfw.b(99);
                } else {
                    this.cfw.b(103);
                }
            }
        } else {
            if (intProp != -1) {
                boolean zVarIsDirectCallParameter = varIsDirectCallParameter(varIndex);
                c cVar2 = this.cfw;
                int i2 = s + (zVarIsDirectCallParameter ? 1 : 0);
                cVar2.e(i2);
                if (z) {
                    this.cfw.b(92);
                }
                this.cfw.b(1.0d);
                if ((existingIntProp & 1) == 0) {
                    this.cfw.b(99);
                } else {
                    this.cfw.b(103);
                }
                if (!z) {
                    this.cfw.b(92);
                }
                this.cfw.f(i2);
                return;
            }
            if (varIsDirectCallParameter(varIndex)) {
                dcpLoadAsObject(s);
            } else {
                this.cfw.c((int) s);
            }
            addObjectToDouble();
            if (z) {
                this.cfw.b(92);
            }
            this.cfw.b(1.0d);
            if ((existingIntProp & 1) == 0) {
                this.cfw.b(99);
            } else {
                this.cfw.b(103);
            }
            addDoubleWrap();
            if (!z) {
                this.cfw.b(89);
            }
            this.cfw.d(s);
            if (!z) {
                return;
            }
        }
        addDoubleWrap();
    }

    private void visitObjectLiteral(Node node, Node node2, boolean z) {
        c cVar;
        int i;
        Object[] objArr = (Object[]) node.getProp(12);
        int length = objArr.length;
        if (!z && ((length > 10 || this.cfw.g() > 30000) && !this.hasVarsInRegs && !this.isGenerator && !this.inLocalBlock)) {
            if (this.literals == null) {
                this.literals = new LinkedList();
            }
            this.literals.add(node);
            String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + this.literals.size();
            this.cfw.c((int) this.funObjLocal);
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.c((int) this.thisObjLocal);
            this.cfw.c((int) this.argsLocal);
            this.cfw.b(182, this.codegen.mainClassName, str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        if (this.isGenerator) {
            addLoadPropertyValues(node, node2, length);
            addLoadPropertyIds(objArr, length);
            this.cfw.b(95);
        } else {
            addLoadPropertyIds(objArr, length);
            addLoadPropertyValues(node, node2, length);
        }
        Node next = node2;
        for (int i2 = 0; i2 != length; i2++) {
            int type = next.getType();
            if (type == 152 || type == 153) {
                this.cfw.l(length);
                this.cfw.a(TsExtractor.TS_PACKET_SIZE, 10);
                for (int i3 = 0; i3 != length; i3++) {
                    this.cfw.b(89);
                    this.cfw.l(i3);
                    int type2 = node2.getType();
                    if (type2 == 152) {
                        cVar = this.cfw;
                        i = 2;
                    } else if (type2 == 153) {
                        cVar = this.cfw;
                        i = 4;
                    } else {
                        cVar = this.cfw;
                        i = 3;
                    }
                    cVar.b(i);
                    this.cfw.b(79);
                    node2 = node2.getNext();
                }
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                addScriptRuntimeInvoke("newObjectLiteral", "([Ljava/lang/Object;[Ljava/lang/Object;[ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
            }
            next = next.getNext();
        }
        this.cfw.b(1);
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("newObjectLiteral", "([Ljava/lang/Object;[Ljava/lang/Object;[ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void visitOptimizedCall(Node node, OptFunctionNode optFunctionNode, int i, Node node2) {
        short newWordLocal;
        Node next = node2.getNext();
        String str = this.codegen.mainClassName;
        if (i == 30) {
            generateExpression(node2, node);
            newWordLocal = 0;
        } else {
            generateFunctionAndThisObj(node2, node);
            newWordLocal = getNewWordLocal();
            this.cfw.d(newWordLocal);
        }
        int iA = this.cfw.a();
        int iA2 = this.cfw.a();
        this.cfw.b(89);
        this.cfw.a(193, str);
        this.cfw.a(Token.SET, iA2);
        this.cfw.a(192, str);
        this.cfw.b(89);
        this.cfw.a(180, str, FieldType.FOREIGN_ID_FIELD_SUFFIX, "I");
        this.cfw.l(this.codegen.getIndex(optFunctionNode.fnode));
        this.cfw.a(160, iA2);
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        c cVar = this.cfw;
        if (i == 30) {
            cVar.b(1);
        } else {
            cVar.c((int) newWordLocal);
        }
        for (Node next2 = next; next2 != null; next2 = next2.getNext()) {
            int iNodeIsDirectCallParameter = nodeIsDirectCallParameter(next2);
            if (iNodeIsDirectCallParameter >= 0) {
                this.cfw.c(iNodeIsDirectCallParameter);
                this.cfw.e(iNodeIsDirectCallParameter + 1);
            } else if (next2.getIntProp(8, -1) == 0) {
                this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
                generateExpression(next2, node);
            } else {
                generateExpression(next2, node);
                this.cfw.b(0.0d);
            }
        }
        this.cfw.a(178, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
        c cVar2 = this.cfw;
        Codegen codegen = this.codegen;
        String str2 = codegen.mainClassName;
        FunctionNode functionNode = optFunctionNode.fnode;
        cVar2.b(184, str2, i == 30 ? codegen.getDirectCtorName(functionNode) : codegen.getBodyMethodName(functionNode), this.codegen.getBodyMethodSignature(optFunctionNode.fnode));
        this.cfw.a(Token.LAST_TOKEN, iA);
        this.cfw.w(iA2);
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        if (i != 30) {
            this.cfw.c((int) newWordLocal);
            releaseWordLocal(newWordLocal);
        }
        generateCallArgArray(node, next, true);
        if (i == 30) {
            addScriptRuntimeInvoke("newObject", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        } else {
            this.cfw.b(185, "external/sdk/pendo/io/mozilla/javascript/Callable", NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        }
        this.cfw.w(iA);
    }

    private void visitSetConst(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.c((int) this.contextLocal);
        this.cfw.e(string);
        addScriptRuntimeInvoke("setConst", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Ljava/lang/String;)Ljava/lang/Object;");
    }

    private void visitSetConstVar(Node node, Node node2, boolean z) {
        short sH;
        c cVar;
        int i;
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        generateExpression(node2.getNext(), node);
        boolean z2 = node.getIntProp(8, -1) != -1;
        short s = this.varRegisters[varIndex];
        int iA = this.cfw.a();
        int iA2 = this.cfw.a();
        if (z2) {
            int i2 = s + 2;
            this.cfw.h(i2);
            this.cfw.a(Token.LET, iA2);
            sH = this.cfw.h();
            this.cfw.l(1);
            this.cfw.i(i2);
            this.cfw.f(s);
            c cVar2 = this.cfw;
            if (z) {
                cVar2.e(s);
                this.cfw.a(iA2, sH);
            } else {
                cVar2.a(Token.LAST_TOKEN, iA);
                this.cfw.a(iA2, sH);
                cVar = this.cfw;
                i = 88;
                cVar.b(i);
            }
        } else {
            int i3 = s + 1;
            this.cfw.h(i3);
            this.cfw.a(Token.LET, iA2);
            sH = this.cfw.h();
            this.cfw.l(1);
            this.cfw.i(i3);
            this.cfw.d(s);
            c cVar3 = this.cfw;
            if (z) {
                cVar3.c((int) s);
                this.cfw.a(iA2, sH);
            } else {
                cVar3.a(Token.LAST_TOKEN, iA);
                this.cfw.a(iA2, sH);
                cVar = this.cfw;
                i = 87;
                cVar.b(i);
            }
        }
        this.cfw.w(iA);
    }

    private void visitSetElem(int i, Node node, Node node2) {
        String str;
        String str2;
        String str3;
        String str4;
        generateExpression(node2, node);
        Node next = node2.getNext();
        if (i == 141) {
            this.cfw.b(89);
        }
        generateExpression(next, node);
        Node next2 = next.getNext();
        boolean z = node.getIntProp(8, -1) != -1;
        if (i == 141) {
            c cVar = this.cfw;
            if (z) {
                cVar.b(93);
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                str3 = "getObjectIndex";
                str4 = "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else {
                cVar.b(90);
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                str3 = "getObjectElem";
                str4 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            }
            addScriptRuntimeInvoke(str3, str4);
        }
        generateExpression(next2, node);
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        if (z) {
            str = "setObjectIndex";
            str2 = "(Ljava/lang/Object;DLjava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
        } else {
            str = "setObjectElem";
            str2 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
        }
        addScriptRuntimeInvoke(str, str2);
    }

    private void visitSetName(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.e(string);
        addScriptRuntimeInvoke("setName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/Object;");
    }

    private void visitSetProp(int i, Node node, Node node2) {
        String str;
        generateExpression(node2, node);
        Node next = node2.getNext();
        if (i == 140) {
            this.cfw.b(89);
        }
        generateExpression(next, node);
        Node next2 = next.getNext();
        if (i == 140) {
            this.cfw.b(90);
            if (node2.getType() == 43 && next.getType() == 41) {
                this.cfw.c((int) this.contextLocal);
                str = "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;";
            } else {
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                str = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            }
            addScriptRuntimeInvoke("getObjectProp", str);
        }
        generateExpression(next2, node);
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("setObjectProp", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
    }

    private void visitSetVar(Node node, Node node2, boolean z) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        generateExpression(node2.getNext(), node);
        boolean z2 = node.getIntProp(8, -1) != -1;
        short s = this.varRegisters[varIndex];
        if (this.fnCurrent.fnode.getParamAndVarConst()[varIndex]) {
            if (z) {
                return;
            }
            c cVar = this.cfw;
            if (z2) {
                cVar.b(88);
                return;
            } else {
                cVar.b(87);
                return;
            }
        }
        if (varIsDirectCallParameter(varIndex)) {
            if (!z2) {
                if (z) {
                    this.cfw.b(89);
                }
                this.cfw.d(s);
                return;
            }
            if (z) {
                this.cfw.b(92);
            }
            this.cfw.c((int) s);
            this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
            int iA = this.cfw.a();
            int iA2 = this.cfw.a();
            this.cfw.a(Token.ARROW, iA);
            short sH = this.cfw.h();
            addDoubleWrap();
            this.cfw.d(s);
            this.cfw.a(Token.LAST_TOKEN, iA2);
            this.cfw.a(iA, sH);
            this.cfw.f(s + 1);
            this.cfw.w(iA2);
            return;
        }
        boolean zIsNumberVar = this.fnCurrent.isNumberVar(varIndex);
        if (!z2) {
            if (zIsNumberVar) {
                Kit.codeBug();
            }
            this.cfw.d(s);
            if (z) {
                this.cfw.c((int) s);
                return;
            }
            return;
        }
        if (zIsNumberVar) {
            this.cfw.f(s);
            if (z) {
                this.cfw.e(s);
                return;
            }
            return;
        }
        if (z) {
            this.cfw.b(92);
        }
        addDoubleWrap();
        this.cfw.d(s);
    }

    private void visitSpecialCall(Node node, int i, int i2, Node node2) {
        String str;
        String str2;
        this.cfw.c((int) this.contextLocal);
        if (i == 30) {
            generateExpression(node2, node);
        } else {
            generateFunctionAndThisObj(node2, node);
        }
        generateCallArgArray(node, node2.getNext(), false);
        c cVar = this.cfw;
        if (i == 30) {
            cVar.c((int) this.variableObjectLocal);
            this.cfw.c((int) this.thisObjLocal);
            this.cfw.l(i2);
            str = "newObjectSpecial";
            str2 = "(Lorg/mozilla/javascript/Context;Ljava/lang/Object;[Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;";
        } else {
            cVar.c((int) this.variableObjectLocal);
            this.cfw.c((int) this.thisObjLocal);
            this.cfw.l(i2);
            String sourceName = this.scriptOrFn.getSourceName();
            c cVar2 = this.cfw;
            if (sourceName == null) {
                sourceName = "";
            }
            cVar2.e(sourceName);
            this.cfw.l(this.itsLineNumber);
            str = "callSpecial";
            str2 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;ILjava/lang/String;I)Ljava/lang/Object;";
        }
        addOptRuntimeInvoke(str, str2);
    }

    private void visitStandardCall(Node node, Node node2) {
        String str;
        String str2;
        if (node.getType() != 38) {
            throw Codegen.badTree();
        }
        Node next = node2.getNext();
        int type = node2.getType();
        if (next == null) {
            if (type == 39) {
                this.cfw.e(node2.getString());
                str = "callName0";
                str2 = "(Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else if (type == 33) {
                Node firstChild = node2.getFirstChild();
                generateExpression(firstChild, node);
                this.cfw.e(firstChild.getNext().getString());
                str = "callProp0";
                str2 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else {
                if (type == 34) {
                    throw Kit.codeBug();
                }
                generateFunctionAndThisObj(node2, node);
                str = "call0";
                str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            }
        } else if (type == 39) {
            String string = node2.getString();
            generateCallArgArray(node, next, false);
            this.cfw.e(string);
            str = "callName";
            str2 = "([Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
        } else {
            int i = 0;
            for (Node next2 = next; next2 != null; next2 = next2.getNext()) {
                i++;
            }
            generateFunctionAndThisObj(node2, node);
            if (i == 1) {
                generateExpression(next, node);
                str = "call1";
                str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else if (i == 2) {
                generateExpression(next, node);
                generateExpression(next.getNext(), node);
                str = "call2";
                str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else {
                generateCallArgArray(node, next, false);
                str = "callN";
                str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            }
        }
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        addOptRuntimeInvoke(str, str2);
    }

    private void visitStandardNew(Node node, Node node2) {
        if (node.getType() != 30) {
            throw Codegen.badTree();
        }
        Node next = node2.getNext();
        generateExpression(node2, node);
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        generateCallArgArray(node, next, false);
        addScriptRuntimeInvoke("newObject", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void visitStrictSetName(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.e(string);
        addScriptRuntimeInvoke("strictSetName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/Object;");
    }

    private void visitSwitch(Jump jump, Node node) {
        generateExpression(node, jump);
        short newWordLocal = getNewWordLocal();
        this.cfw.d(newWordLocal);
        Node node2 = node;
        while (true) {
            Jump jump2 = (Jump) node2.getNext();
            if (jump2 == null) {
                releaseWordLocal(newWordLocal);
                return;
            } else {
                if (jump2.getType() != 116) {
                    throw Codegen.badTree();
                }
                generateExpression(jump2.getFirstChild(), jump2);
                this.cfw.c((int) newWordLocal);
                addScriptRuntimeInvoke("shallowEq", "(Ljava/lang/Object;Ljava/lang/Object;)Z");
                addGoto(jump2.target, Token.LET);
                node2 = jump2;
            }
        }
    }

    private void visitTryCatchFinally(Jump jump, Node node) {
        int i;
        BodyCodegen bodyCodegen = this;
        short newWordLocal = bodyCodegen.getNewWordLocal();
        bodyCodegen.cfw.c((int) bodyCodegen.variableObjectLocal);
        bodyCodegen.cfw.d(newWordLocal);
        int iA = bodyCodegen.cfw.a();
        bodyCodegen.cfw.a(iA, (short) 0);
        Node node2 = jump.target;
        Node node3 = jump.getFinally();
        int[] iArr = new int[5];
        bodyCodegen.exceptionManager.pushExceptionInfo(jump);
        if (node2 != null) {
            iArr[0] = bodyCodegen.cfw.a();
            iArr[1] = bodyCodegen.cfw.a();
            iArr[2] = bodyCodegen.cfw.a();
            Context currentContext = Context.getCurrentContext();
            if (currentContext != null && currentContext.hasFeature(13)) {
                iArr[3] = bodyCodegen.cfw.a();
            }
        }
        if (node3 != null) {
            iArr[4] = bodyCodegen.cfw.a();
        }
        bodyCodegen.exceptionManager.setHandlers(iArr, iA);
        if (bodyCodegen.isGenerator && node3 != null) {
            FinallyReturnPoint finallyReturnPoint = new FinallyReturnPoint();
            if (bodyCodegen.finallys == null) {
                bodyCodegen.finallys = new HashMap();
            }
            bodyCodegen.finallys.put(node3, finallyReturnPoint);
            bodyCodegen.finallys.put(node3.getNext(), finallyReturnPoint);
        }
        for (Node next = node; next != null; next = next.getNext()) {
            if (next == node2) {
                int targetLabel = bodyCodegen.getTargetLabel(node2);
                bodyCodegen.exceptionManager.removeHandler(0, targetLabel);
                bodyCodegen.exceptionManager.removeHandler(1, targetLabel);
                bodyCodegen.exceptionManager.removeHandler(2, targetLabel);
                bodyCodegen.exceptionManager.removeHandler(3, targetLabel);
            }
            bodyCodegen.generateStatement(next);
        }
        int iA2 = bodyCodegen.cfw.a();
        bodyCodegen.cfw.a(Token.LAST_TOKEN, iA2);
        int localBlockRegister = getLocalBlockRegister(jump);
        if (node2 != null) {
            int iLabelId = node2.labelId();
            i = localBlockRegister;
            bodyCodegen.generateCatchBlock(0, newWordLocal, iLabelId, i, iArr[0]);
            generateCatchBlock(1, newWordLocal, iLabelId, i, iArr[1]);
            generateCatchBlock(2, newWordLocal, iLabelId, i, iArr[2]);
            Context currentContext2 = Context.getCurrentContext();
            if (currentContext2 == null || !currentContext2.hasFeature(13)) {
                bodyCodegen = this;
            } else {
                bodyCodegen = this;
                bodyCodegen.generateCatchBlock(3, newWordLocal, iLabelId, i, iArr[3]);
            }
        } else {
            i = localBlockRegister;
        }
        if (node3 != null) {
            int iA3 = bodyCodegen.cfw.a();
            int iA4 = bodyCodegen.cfw.a();
            bodyCodegen.cfw.v(iA3);
            if (!bodyCodegen.isGenerator) {
                bodyCodegen.cfw.w(iArr[4]);
            }
            bodyCodegen.cfw.d(i);
            bodyCodegen.cfw.c((int) newWordLocal);
            bodyCodegen.cfw.d(bodyCodegen.variableObjectLocal);
            int iLabelId2 = node3.labelId();
            if (bodyCodegen.isGenerator) {
                bodyCodegen.addGotoWithReturn(node3);
            } else {
                bodyCodegen.inlineFinally(node3, iArr[4], iA4);
            }
            bodyCodegen.cfw.c(i);
            if (bodyCodegen.isGenerator) {
                bodyCodegen.cfw.a(192, "java/lang/Throwable");
            }
            bodyCodegen.cfw.b(191);
            bodyCodegen.cfw.w(iA4);
            if (bodyCodegen.isGenerator) {
                bodyCodegen.cfw.a(iA, iLabelId2, iA3, (String) null);
            }
        }
        bodyCodegen.releaseWordLocal(newWordLocal);
        bodyCodegen.cfw.w(iA2);
        if (bodyCodegen.isGenerator) {
            return;
        }
        bodyCodegen.exceptionManager.popExceptionInfo();
    }

    private void visitTypeofname(Node node) {
        int indexForNameNode;
        if (!this.hasVarsInRegs || (indexForNameNode = this.fnCurrent.fnode.getIndexForNameNode(node)) < 0) {
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.e(node.getString());
            addScriptRuntimeInvoke("typeofName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/String;");
            return;
        }
        if (this.fnCurrent.isNumberVar(indexForNameNode)) {
            this.cfw.e("number");
            return;
        }
        if (!varIsDirectCallParameter(indexForNameNode)) {
            this.cfw.c((int) this.varRegisters[indexForNameNode]);
            addScriptRuntimeInvoke("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
            return;
        }
        short s = this.varRegisters[indexForNameNode];
        this.cfw.c((int) s);
        this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
        int iA = this.cfw.a();
        this.cfw.a(Token.ARROW, iA);
        short sH = this.cfw.h();
        this.cfw.c((int) s);
        addScriptRuntimeInvoke("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
        int iA2 = this.cfw.a();
        this.cfw.a(Token.LAST_TOKEN, iA2);
        this.cfw.a(iA, sH);
        this.cfw.e("number");
        this.cfw.w(iA2);
    }

    void generateBodyCode() {
        this.isGenerator = Codegen.isGenerator(this.scriptOrFn);
        initBodyGeneration();
        if (this.isGenerator) {
            this.cfw.b(this.codegen.getBodyMethodName(this.scriptOrFn) + "_gen", "(" + this.codegen.mainClassSignature + "Lexternal/sdk/pendo/io/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;", (short) 10);
        } else {
            this.cfw.b(this.codegen.getBodyMethodName(this.scriptOrFn), this.codegen.getBodyMethodSignature(this.scriptOrFn), (short) 10);
        }
        generatePrologue();
        generateStatement(this.fnCurrent != null ? this.scriptOrFn.getLastChild() : this.scriptOrFn);
        generateEpilogue();
        this.cfw.c((short) (this.localsMax + 1));
        if (this.isGenerator) {
            generateGenerator();
        }
        if (this.literals != null) {
            for (int i = 0; i < this.literals.size(); i++) {
                Node node = this.literals.get(i);
                int type = node.getType();
                if (type == 66) {
                    generateArrayLiteralFactory(node, i + 1);
                } else if (type != 67) {
                    Kit.codeBug(Token.typeToName(type));
                } else {
                    generateObjectLiteralFactory(node, i + 1);
                }
            }
        }
    }

    private void addInstructionCount(int i) {
        this.cfw.c((int) this.contextLocal);
        this.cfw.l(i);
        addScriptRuntimeInvoke("addInstructionCount", "(Lorg/mozilla/javascript/Context;I)V");
    }

    private short getNewWordLocal(boolean z) {
        return getNewWordIntern(z ? 2 : 1);
    }

    private void inlineFinally(Node node, int i, int i2) {
        Node finallyAtTarget = getFinallyAtTarget(node);
        finallyAtTarget.resetTargets();
        this.exceptionManager.markInlineFinallyStart(finallyAtTarget, i);
        for (Node firstChild = finallyAtTarget.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            generateStatement(firstChild);
        }
        this.exceptionManager.markInlineFinallyEnd(finallyAtTarget, i2);
    }
}
