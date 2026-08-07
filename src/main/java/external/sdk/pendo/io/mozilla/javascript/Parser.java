package external.sdk.pendo.io.mozilla.javascript;

import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.ast.ArrayComprehension;
import external.sdk.pendo.io.mozilla.javascript.ast.ArrayComprehensionLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.ArrayLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.Assignment;
import external.sdk.pendo.io.mozilla.javascript.ast.AstNode;
import external.sdk.pendo.io.mozilla.javascript.ast.AstRoot;
import external.sdk.pendo.io.mozilla.javascript.ast.Block;
import external.sdk.pendo.io.mozilla.javascript.ast.BreakStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.CatchClause;
import external.sdk.pendo.io.mozilla.javascript.ast.Comment;
import external.sdk.pendo.io.mozilla.javascript.ast.ConditionalExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.ContinueStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.DestructuringForm;
import external.sdk.pendo.io.mozilla.javascript.ast.DoLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.ElementGet;
import external.sdk.pendo.io.mozilla.javascript.ast.EmptyExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.EmptyStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.ErrorNode;
import external.sdk.pendo.io.mozilla.javascript.ast.ExpressionStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.ForInLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.ForLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionCall;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode;
import external.sdk.pendo.io.mozilla.javascript.ast.GeneratorExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.GeneratorExpressionLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.IdeErrorReporter;
import external.sdk.pendo.io.mozilla.javascript.ast.IfStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.InfixExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.Jump;
import external.sdk.pendo.io.mozilla.javascript.ast.KeywordLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.Label;
import external.sdk.pendo.io.mozilla.javascript.ast.LabeledStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.LetNode;
import external.sdk.pendo.io.mozilla.javascript.ast.Loop;
import external.sdk.pendo.io.mozilla.javascript.ast.Name;
import external.sdk.pendo.io.mozilla.javascript.ast.NewExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.NumberLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.ObjectLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.ObjectProperty;
import external.sdk.pendo.io.mozilla.javascript.ast.ParenthesizedExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.PropertyGet;
import external.sdk.pendo.io.mozilla.javascript.ast.RegExpLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.ReturnStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.Scope;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;
import external.sdk.pendo.io.mozilla.javascript.ast.StringLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.SwitchCase;
import external.sdk.pendo.io.mozilla.javascript.ast.SwitchStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.ThrowStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.TryStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.UnaryExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.VariableDeclaration;
import external.sdk.pendo.io.mozilla.javascript.ast.VariableInitializer;
import external.sdk.pendo.io.mozilla.javascript.ast.WhileLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.WithStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlDotQuery;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlElemRef;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlMemberGet;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlPropRef;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlRef;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlString;
import external.sdk.pendo.io.mozilla.javascript.ast.Yield;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class Parser {
    public static final int ARGC_LIMIT = 65536;
    static final int CLEAR_TI_MASK = 65535;
    private static final int GET_ENTRY = 2;
    private static final int METHOD_ENTRY = 8;
    private static final int PROP_ENTRY = 1;
    private static final int SET_ENTRY = 4;
    static final int TI_AFTER_EOL = 65536;
    static final int TI_CHECK_LABEL = 131072;
    boolean calledByCompileFunction;
    CompilerEnvirons compilerEnv;
    private int currentFlaggedToken;
    private Comment currentJsDocComment;
    private LabeledStatement currentLabel;
    Scope currentScope;
    ScriptNode currentScriptOrFn;
    private int currentToken;
    private boolean defaultUseStrictDirective;
    private int endFlags;
    private IdeErrorReporter errorCollector;
    private ErrorReporter errorReporter;
    private boolean inDestructuringAssignment;
    private boolean inForInit;
    protected boolean inUseStrictDirective;
    private Map<String, LabeledStatement> labelSet;
    private List<Jump> loopAndSwitchSet;
    private List<Loop> loopSet;
    protected int nestingOfFunction;
    private boolean parseFinished;
    private int prevNameTokenLineno;
    private int prevNameTokenStart;
    private String prevNameTokenString;
    private List<Comment> scannedComments;
    private char[] sourceChars;
    private String sourceURI;
    private int syntaxErrorCount;
    private TokenStream ts;

    private static class ConditionData {
        AstNode condition;
        int lp;
        int rp;

        private ConditionData() {
            this.lp = -1;
            this.rp = -1;
        }
    }

    private static class ParserException extends RuntimeException {
        private static final long serialVersionUID = 5882582646773765630L;

        private ParserException() {
        }
    }

    protected class PerFunctionVariables {
        private Scope savedCurrentScope;
        private ScriptNode savedCurrentScriptOrFn;
        private int savedEndFlags;
        private boolean savedInForInit;
        private Map<String, LabeledStatement> savedLabelSet;
        private List<Jump> savedLoopAndSwitchSet;
        private List<Loop> savedLoopSet;

        PerFunctionVariables(FunctionNode functionNode) {
            this.savedCurrentScriptOrFn = Parser.this.currentScriptOrFn;
            Parser.this.currentScriptOrFn = functionNode;
            this.savedCurrentScope = Parser.this.currentScope;
            Parser.this.currentScope = functionNode;
            this.savedLabelSet = Parser.this.labelSet;
            Parser.this.labelSet = null;
            this.savedLoopSet = Parser.this.loopSet;
            Parser.this.loopSet = null;
            this.savedLoopAndSwitchSet = Parser.this.loopAndSwitchSet;
            Parser.this.loopAndSwitchSet = null;
            this.savedEndFlags = Parser.this.endFlags;
            Parser.this.endFlags = 0;
            this.savedInForInit = Parser.this.inForInit;
            Parser.this.inForInit = false;
        }

        void restore() {
            Parser parser = Parser.this;
            parser.currentScriptOrFn = this.savedCurrentScriptOrFn;
            parser.currentScope = this.savedCurrentScope;
            parser.labelSet = this.savedLabelSet;
            Parser.this.loopSet = this.savedLoopSet;
            Parser.this.loopAndSwitchSet = this.savedLoopAndSwitchSet;
            Parser.this.endFlags = this.savedEndFlags;
            Parser.this.inForInit = this.savedInForInit;
        }
    }

    public Parser() {
        this(new CompilerEnvirons());
    }

    private AstNode addExpr() {
        AstNode astNodeMulExpr = mulExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (iPeekToken != 21 && iPeekToken != 22) {
                return astNodeMulExpr;
            }
            consumeToken();
            astNodeMulExpr = new InfixExpression(iPeekToken, astNodeMulExpr, mulExpr(), i);
        }
    }

    private AstNode andExpr() {
        AstNode astNodeBitOrExpr = bitOrExpr();
        if (!matchToken(106, true)) {
            return astNodeBitOrExpr;
        }
        return new InfixExpression(106, astNodeBitOrExpr, andExpr(), this.ts.tokenBeg);
    }

    private List<AstNode> argumentList() {
        if (matchToken(89, true)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.inForInit;
        this.inForInit = false;
        do {
            try {
                if (peekToken() == 89) {
                    break;
                }
                if (peekToken() == 73) {
                    reportError("msg.yield.parenthesized");
                }
                AstNode astNodeAssignExpr = assignExpr();
                if (peekToken() == 120) {
                    try {
                        arrayList.add(generatorExpression(astNodeAssignExpr, 0, true));
                    } catch (IOException unused) {
                    }
                } else {
                    arrayList.add(astNodeAssignExpr);
                }
            } catch (Throwable th) {
                this.inForInit = z;
                throw th;
            }
        } while (matchToken(90, true));
        this.inForInit = z;
        mustMatchToken(89, "msg.no.paren.arg", true);
        return arrayList;
    }

    private AstNode arrayComprehension(AstNode astNode, int i) {
        int i2;
        ConditionData conditionDataCondition;
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 120) {
            arrayList.add(arrayComprehensionLoop());
        }
        if (peekToken() == 113) {
            consumeToken();
            i2 = this.ts.tokenBeg - i;
            conditionDataCondition = condition();
        } else {
            i2 = -1;
            conditionDataCondition = null;
        }
        mustMatchToken(85, "msg.no.bracket.arg", true);
        ArrayComprehension arrayComprehension = new ArrayComprehension(i, this.ts.tokenEnd - i);
        arrayComprehension.setResult(astNode);
        arrayComprehension.setLoops(arrayList);
        if (conditionDataCondition != null) {
            arrayComprehension.setIfPosition(i2);
            arrayComprehension.setFilter(conditionDataCondition.condition);
            arrayComprehension.setFilterLp(conditionDataCondition.lp - i);
            arrayComprehension.setFilterRp(conditionDataCondition.rp - i);
        }
        return arrayComprehension;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00c9 A[Catch: all -> 0x00f5, TryCatch #0 {all -> 0x00f5, blocks: (B:6:0x001a, B:9:0x0024, B:11:0x0032, B:14:0x003c, B:16:0x0044, B:18:0x004b, B:24:0x0059, B:27:0x0070, B:29:0x0076, B:30:0x0081, B:42:0x00b2, B:43:0x00ba, B:45:0x00c9, B:47:0x00d0, B:51:0x00e8, B:35:0x008d, B:37:0x0094, B:40:0x00a5, B:41:0x00ab, B:25:0x0061, B:26:0x0069, B:12:0x0038), top: B:57:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e7  */
    private ArrayComprehensionLoop arrayComprehensionLoop() {
        int i;
        AstNode astNodeCreateNameNode;
        int i2;
        boolean z;
        int i3;
        if (nextToken() != 120) {
            codeBug();
        }
        int i4 = this.ts.tokenBeg;
        ArrayComprehensionLoop arrayComprehensionLoop = new ArrayComprehensionLoop(i4);
        pushScope(arrayComprehensionLoop);
        boolean z2 = true;
        try {
            if (!matchToken(39, true)) {
                i = -1;
            } else if (this.ts.getString().equals("each")) {
                i = this.ts.tokenBeg - i4;
            } else {
                reportError("msg.no.paren.for");
                i = -1;
            }
            int i5 = mustMatchToken(88, "msg.no.paren.for", true) ? this.ts.tokenBeg - i4 : -1;
            int iPeekToken = peekToken();
            if (iPeekToken == 39) {
                consumeToken();
                astNodeCreateNameNode = createNameNode();
            } else if (iPeekToken == 84 || iPeekToken == 86) {
                astNodeCreateNameNode = destructuringPrimaryExpr();
                markDestructuring(astNodeCreateNameNode);
            } else {
                reportError("msg.bad.var");
                astNodeCreateNameNode = null;
            }
            if (astNodeCreateNameNode.getType() == 39) {
                defineSymbol(Token.LET, this.ts.getString(), true);
            }
            int iNextToken = nextToken();
            if (iNextToken != 39) {
                if (iNextToken == 52) {
                    i2 = this.ts.tokenBeg - i4;
                }
                z = false;
                AstNode astNodeExpr = expr();
                if (mustMatchToken(89, "msg.no.paren.for.ctrl", true)) {
                    i3 = this.ts.tokenBeg - i4;
                } else {
                    i3 = -1;
                }
                arrayComprehensionLoop.setLength(this.ts.tokenEnd - i4);
                arrayComprehensionLoop.setIterator(astNodeCreateNameNode);
                arrayComprehensionLoop.setIteratedObject(astNodeExpr);
                arrayComprehensionLoop.setInPosition(i2);
                arrayComprehensionLoop.setEachPosition(i);
                if (i == -1) {
                    z2 = false;
                }
                arrayComprehensionLoop.setIsForEach(z2);
                arrayComprehensionLoop.setParens(i5, i3);
                arrayComprehensionLoop.setIsForOf(z);
                return arrayComprehensionLoop;
            }
            if ("of".equals(this.ts.getString())) {
                if (i != -1) {
                    reportError("msg.invalid.for.each");
                }
                i2 = this.ts.tokenBeg - i4;
                z = true;
            }
            AstNode astNodeExpr2 = expr();
            if (mustMatchToken(89, "msg.no.paren.for.ctrl", true)) {
                i3 = this.ts.tokenBeg - i4;
            } else {
                i3 = -1;
            }
            arrayComprehensionLoop.setLength(this.ts.tokenEnd - i4);
            arrayComprehensionLoop.setIterator(astNodeCreateNameNode);
            arrayComprehensionLoop.setIteratedObject(astNodeExpr2);
            arrayComprehensionLoop.setInPosition(i2);
            arrayComprehensionLoop.setEachPosition(i);
            if (i == -1) {
                z2 = false;
            }
            arrayComprehensionLoop.setIsForEach(z2);
            arrayComprehensionLoop.setParens(i5, i3);
            arrayComprehensionLoop.setIsForOf(z);
            return arrayComprehensionLoop;
            reportError("msg.in.after.for.name");
            i2 = -1;
            z = false;
            AstNode astNodeExpr3 = expr();
            if (mustMatchToken(89, "msg.no.paren.for.ctrl", true)) {
                i3 = this.ts.tokenBeg - i4;
            } else {
                i3 = -1;
            }
            arrayComprehensionLoop.setLength(this.ts.tokenEnd - i4);
            arrayComprehensionLoop.setIterator(astNodeCreateNameNode);
            arrayComprehensionLoop.setIteratedObject(astNodeExpr3);
            arrayComprehensionLoop.setInPosition(i2);
            arrayComprehensionLoop.setEachPosition(i);
            if (i == -1) {
                z2 = false;
            }
            arrayComprehensionLoop.setIsForEach(z2);
            arrayComprehensionLoop.setParens(i5, i3);
            arrayComprehensionLoop.setIsForOf(z);
            return arrayComprehensionLoop;
        } finally {
            popScope();
        }
    }

    private AstNode arrayLiteral() {
        if (this.currentToken != 84) {
            codeBug();
        }
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        int i2 = tokenStream.tokenEnd;
        ArrayList arrayList = new ArrayList();
        ArrayLiteral arrayLiteral = new ArrayLiteral(i);
        int i3 = 0;
        int i4 = -1;
        loop0: while (true) {
            int i5 = 1;
            while (true) {
                int iPeekToken = peekToken();
                if (iPeekToken == 90) {
                    consumeToken();
                    i4 = this.ts.tokenEnd;
                    if (i5 == 0) {
                        break;
                    }
                    arrayList.add(new EmptyExpression(this.ts.tokenBeg, 1));
                    i3++;
                } else if (iPeekToken == 162) {
                    consumeToken();
                } else {
                    if (iPeekToken == 85) {
                        consumeToken();
                        i2 = this.ts.tokenEnd;
                        arrayLiteral.setDestructuringLength(arrayList.size() + i5);
                        arrayLiteral.setSkipCount(i3);
                        if (i4 == -1) {
                            break loop0;
                        }
                        warnTrailingComma(i, arrayList, i4);
                        break loop0;
                    }
                    if (iPeekToken == 120 && i5 == 0 && arrayList.size() == 1) {
                        return arrayComprehension((AstNode) arrayList.get(0), i);
                    }
                    if (iPeekToken == 0) {
                        reportError("msg.no.bracket.arg");
                        break loop0;
                    }
                    if (i5 == 0) {
                        reportError("msg.no.bracket.arg");
                    }
                    arrayList.add(assignExpr());
                    i5 = 0;
                    i4 = -1;
                }
            }
        }
        Iterator<?> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayLiteral.addElement((AstNode) it.next());
        }
        arrayLiteral.setLength(i2 - i);
        return arrayLiteral;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0041 A[Catch: all -> 0x00be, PHI: r10
      0x0041: PHI (r10v1 external.sdk.pendo.io.mozilla.javascript.ast.AstNode) = 
      (r10v0 external.sdk.pendo.io.mozilla.javascript.ast.AstNode)
      (r10v14 external.sdk.pendo.io.mozilla.javascript.ast.AstNode)
     binds: [B:8:0x002d, B:10:0x003f] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x00be, blocks: (B:7:0x002b, B:9:0x002f, B:12:0x0044, B:14:0x004a, B:15:0x0059, B:17:0x005f, B:18:0x007f, B:19:0x0084, B:11:0x0041), top: B:29:0x002b }] */
    private AstNode arrowFunction(AstNode astNode) {
        int i = this.ts.lineno;
        int position = astNode != null ? astNode.getPosition() : -1;
        FunctionNode functionNode = new FunctionNode(position);
        functionNode.setFunctionType(4);
        functionNode.setJsDocNode(getAndResetJsDoc());
        Map<String, Node> map = new HashMap<>();
        Set<String> hashSet = new HashSet<>();
        PerFunctionVariables perFunctionVariables = new PerFunctionVariables(functionNode);
        try {
            if (astNode instanceof ParenthesizedExpression) {
                functionNode.setParens(0, astNode.getLength());
                astNode = ((ParenthesizedExpression) astNode).getExpression();
                if (!(astNode instanceof EmptyExpression)) {
                    arrowFunctionParams(functionNode, astNode, map, hashSet);
                }
            } else {
                arrowFunctionParams(functionNode, astNode, map, hashSet);
            }
            if (!map.isEmpty()) {
                Node node = new Node(90);
                for (Map.Entry<String, Node> entry : map.entrySet()) {
                    node.addChildToBack(createDestructuringAssignment(123, entry.getValue(), createName(entry.getKey())));
                }
                functionNode.putProp(23, node);
            }
            functionNode.setBody(parseFunctionBody(4, functionNode));
            functionNode.setEncodedSourceBounds(position, this.ts.tokenEnd);
            functionNode.setLength(this.ts.tokenEnd - position);
            perFunctionVariables.restore();
            if (functionNode.isGenerator()) {
                reportError("msg.arrowfunction.generator");
                return makeErrorNode();
            }
            functionNode.setSourceName(this.sourceURI);
            functionNode.setBaseLineno(i);
            functionNode.setEndLineno(this.ts.lineno);
            return functionNode;
        } catch (Throwable th) {
            perFunctionVariables.restore();
            throw th;
        }
    }

    private void arrowFunctionParams(FunctionNode functionNode, AstNode astNode, Map<String, Node> map, Set<String> set) {
        if ((astNode instanceof ArrayLiteral) || (astNode instanceof ObjectLiteral)) {
            markDestructuring(astNode);
            functionNode.addParam(astNode);
            String nextTempName = this.currentScriptOrFn.getNextTempName();
            defineSymbol(88, nextTempName, false);
            map.put(nextTempName, astNode);
            return;
        }
        if ((astNode instanceof InfixExpression) && astNode.getType() == 90) {
            InfixExpression infixExpression = (InfixExpression) astNode;
            arrowFunctionParams(functionNode, infixExpression.getLeft(), map, set);
            arrowFunctionParams(functionNode, infixExpression.getRight(), map, set);
            return;
        }
        if (!(astNode instanceof Name)) {
            reportError("msg.no.parm", astNode.getPosition(), astNode.getLength());
            functionNode.addParam(makeErrorNode());
            return;
        }
        functionNode.addParam(astNode);
        String identifier = ((Name) astNode).getIdentifier();
        defineSymbol(88, identifier);
        if (this.inUseStrictDirective) {
            if ("eval".equals(identifier) || "arguments".equals(identifier)) {
                reportError("msg.bad.id.strict", identifier);
            }
            if (set.contains(identifier)) {
                addError("msg.dup.param.strict", identifier);
            }
            set.add(identifier);
        }
    }

    private AstNode assignExpr() {
        int iPeekToken = peekToken();
        boolean z = true;
        if (iPeekToken == 73) {
            return returnOrYield(iPeekToken, true);
        }
        AstNode astNodeCondExpr = condExpr();
        int iPeekTokenOrEOL = peekTokenOrEOL();
        if (iPeekTokenOrEOL == 1) {
            iPeekTokenOrEOL = peekToken();
        } else {
            z = false;
        }
        if (91 > iPeekTokenOrEOL || iPeekTokenOrEOL > 102) {
            if (iPeekTokenOrEOL == 83) {
                if (this.currentJsDocComment != null) {
                    astNodeCondExpr.setJsDocNode(getAndResetJsDoc());
                    return astNodeCondExpr;
                }
            } else if (!z && iPeekTokenOrEOL == 165) {
                consumeToken();
                return arrowFunction(astNodeCondExpr);
            }
            return astNodeCondExpr;
        }
        if (this.inDestructuringAssignment) {
            reportError("msg.destruct.default.vals");
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        markDestructuring(astNodeCondExpr);
        Assignment assignment = new Assignment(iPeekTokenOrEOL, astNodeCondExpr, assignExpr(), this.ts.tokenBeg);
        if (andResetJsDoc != null) {
            assignment.setJsDocNode(andResetJsDoc);
        }
        return assignment;
    }

    private AstNode attributeAccess() {
        int iNextToken = nextToken();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        if (iNextToken == 23) {
            saveNameTokenData(i, "*", tokenStream.lineno);
            return propertyName(i, 0);
        }
        if (iNextToken == 39) {
            return propertyName(i, 0);
        }
        if (iNextToken == 84) {
            return xmlElemRef(i, null, -1);
        }
        reportError("msg.no.name.after.xmlAttr");
        return makeErrorNode();
    }

    private void autoInsertSemicolon(AstNode astNode) {
        int iPeekFlaggedToken = peekFlaggedToken();
        int position = astNode.getPosition();
        int i = 65535 & iPeekFlaggedToken;
        if (i != -1 && i != 0) {
            if (i == 83) {
                consumeToken();
                astNode.setLength(this.ts.tokenEnd - position);
                return;
            } else if (i != 87) {
                if ((iPeekFlaggedToken & 65536) == 0) {
                    reportError("msg.no.semi.stmt");
                    return;
                } else {
                    warnMissingSemi(position, nodeEnd(astNode));
                    return;
                }
            }
        }
        warnMissingSemi(position, Math.max(position + 1, nodeEnd(astNode)));
    }

    private AstNode bitAndExpr() {
        AstNode astNodeEqExpr = eqExpr();
        while (matchToken(11, true)) {
            astNodeEqExpr = new InfixExpression(11, astNodeEqExpr, eqExpr(), this.ts.tokenBeg);
        }
        return astNodeEqExpr;
    }

    private AstNode bitOrExpr() {
        AstNode astNodeBitXorExpr = bitXorExpr();
        while (matchToken(9, true)) {
            astNodeBitXorExpr = new InfixExpression(9, astNodeBitXorExpr, bitXorExpr(), this.ts.tokenBeg);
        }
        return astNodeBitXorExpr;
    }

    private AstNode bitXorExpr() {
        AstNode astNodeBitAndExpr = bitAndExpr();
        while (matchToken(10, true)) {
            astNodeBitAndExpr = new InfixExpression(10, astNodeBitAndExpr, bitAndExpr(), this.ts.tokenBeg);
        }
        return astNodeBitAndExpr;
    }

    private AstNode block() {
        if (this.currentToken != 86) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        Scope scope = new Scope(i);
        scope.setLineno(this.ts.lineno);
        pushScope(scope);
        try {
            statements(scope);
            mustMatchToken(87, "msg.no.brace.block", true);
            scope.setLength(this.ts.tokenEnd - i);
            return scope;
        } finally {
            popScope();
        }
    }

    private BreakStatement breakStatement() {
        int nodeEnd;
        Name nameCreateNameNode;
        if (this.currentToken != 121) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        int i3 = tokenStream.tokenEnd;
        if (peekTokenOrEOL() == 39) {
            nameCreateNameNode = createNameNode();
            nodeEnd = getNodeEnd(nameCreateNameNode);
        } else {
            nodeEnd = i3;
            nameCreateNameNode = null;
        }
        LabeledStatement labeledStatementMatchJumpLabelName = matchJumpLabelName();
        Jump firstLabel = labeledStatementMatchJumpLabelName != null ? labeledStatementMatchJumpLabelName.getFirstLabel() : null;
        if (firstLabel == null && nameCreateNameNode == null) {
            List<Jump> list = this.loopAndSwitchSet;
            if (list == null || list.size() == 0) {
                reportError("msg.bad.break", i2, nodeEnd - i2);
            } else {
                List<Jump> list2 = this.loopAndSwitchSet;
                firstLabel = list2.get(list2.size() - 1);
            }
        }
        BreakStatement breakStatement = new BreakStatement(i2, nodeEnd - i2);
        breakStatement.setBreakLabel(nameCreateNameNode);
        if (firstLabel != null) {
            breakStatement.setBreakTarget(firstLabel);
        }
        breakStatement.setLineno(i);
        return breakStatement;
    }

    private void checkBadIncDec(UnaryExpression unaryExpression) {
        int type = removeParens(unaryExpression.getOperand()).getType();
        if (type == 39 || type == 33 || type == 36 || type == 68 || type == 38) {
            return;
        }
        reportError(unaryExpression.getType() == 107 ? "msg.bad.incr" : "msg.bad.decr");
    }

    private void checkCallRequiresActivation(AstNode astNode) {
        if ((astNode.getType() == 39 && "eval".equals(((Name) astNode).getIdentifier())) || (astNode.getType() == 33 && "eval".equals(((PropertyGet) astNode).getProperty().getIdentifier()))) {
            setRequiresActivation();
        }
    }

    private RuntimeException codeBug() {
        throw Kit.codeBug("ts.cursor=" + this.ts.cursor + ", ts.tokenBeg=" + this.ts.tokenBeg + ", currentToken=" + this.currentToken);
    }

    private AstNode condExpr() {
        AstNode astNodeOrExpr = orExpr();
        if (!matchToken(103, true)) {
            return astNodeOrExpr;
        }
        TokenStream tokenStream = this.ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        boolean z = this.inForInit;
        this.inForInit = false;
        try {
            AstNode astNodeAssignExpr = assignExpr();
            this.inForInit = z;
            int i3 = mustMatchToken(104, "msg.no.colon.cond", true) ? this.ts.tokenBeg : -1;
            AstNode astNodeAssignExpr2 = assignExpr();
            int position = astNodeOrExpr.getPosition();
            ConditionalExpression conditionalExpression = new ConditionalExpression(position, getNodeEnd(astNodeAssignExpr2) - position);
            conditionalExpression.setLineno(i);
            conditionalExpression.setTestExpression(astNodeOrExpr);
            conditionalExpression.setTrueExpression(astNodeAssignExpr);
            conditionalExpression.setFalseExpression(astNodeAssignExpr2);
            conditionalExpression.setQuestionMarkPosition(i2 - position);
            conditionalExpression.setColonPosition(i3 - position);
            return conditionalExpression;
        } catch (Throwable th) {
            this.inForInit = z;
            throw th;
        }
    }

    private ConditionData condition() {
        ConditionData conditionData = new ConditionData();
        if (mustMatchToken(88, "msg.no.paren.cond", true)) {
            conditionData.lp = this.ts.tokenBeg;
        }
        conditionData.condition = expr();
        if (mustMatchToken(89, "msg.no.paren.after.cond", true)) {
            conditionData.rp = this.ts.tokenBeg;
        }
        AstNode astNode = conditionData.condition;
        if (astNode instanceof Assignment) {
            addStrictWarning("msg.equal.as.assign", "", astNode.getPosition(), conditionData.condition.getLength());
        }
        return conditionData;
    }

    private void consumeToken() {
        this.currentFlaggedToken = 0;
    }

    private ContinueStatement continueStatement() {
        int nodeEnd;
        Name nameCreateNameNode;
        Object statement;
        if (this.currentToken != 122) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        int i3 = tokenStream.tokenEnd;
        Loop loop = null;
        if (peekTokenOrEOL() == 39) {
            nameCreateNameNode = createNameNode();
            nodeEnd = getNodeEnd(nameCreateNameNode);
        } else {
            nodeEnd = i3;
            nameCreateNameNode = null;
        }
        LabeledStatement labeledStatementMatchJumpLabelName = matchJumpLabelName();
        if (labeledStatementMatchJumpLabelName == null && nameCreateNameNode == null) {
            List<Loop> list = this.loopSet;
            if (list == null || list.size() == 0) {
                reportError("msg.continue.outside");
            } else {
                List<Loop> list2 = this.loopSet;
                statement = list2.get(list2.size() - 1);
                loop = (Loop) statement;
            }
        } else {
            if (labeledStatementMatchJumpLabelName == null || !(labeledStatementMatchJumpLabelName.getStatement() instanceof Loop)) {
                reportError("msg.continue.nonloop", i2, nodeEnd - i2);
            }
            if (labeledStatementMatchJumpLabelName != null) {
                statement = labeledStatementMatchJumpLabelName.getStatement();
                loop = (Loop) statement;
            }
        }
        ContinueStatement continueStatement = new ContinueStatement(i2, nodeEnd - i2);
        if (loop != null) {
            continueStatement.setTarget(loop);
        }
        continueStatement.setLabel(nameCreateNameNode);
        continueStatement.setLineno(i);
        return continueStatement;
    }

    private Name createNameNode() {
        return createNameNode(false, 39);
    }

    private StringLiteral createStringLiteral() {
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        StringLiteral stringLiteral = new StringLiteral(i, tokenStream.tokenEnd - i);
        stringLiteral.setLineno(this.ts.lineno);
        stringLiteral.setValue(this.ts.getString());
        stringLiteral.setQuoteCharacter(this.ts.getQuoteChar());
        return stringLiteral;
    }

    private AstNode defaultXmlNamespace() {
        if (this.currentToken != 117) {
            codeBug();
        }
        consumeToken();
        mustHaveXML();
        setRequiresActivation();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        if (!matchToken(39, true) || !"xml".equals(this.ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(39, true) || !"namespace".equals(this.ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(91, true)) {
            reportError("msg.bad.namespace");
        }
        AstNode astNodeExpr = expr();
        UnaryExpression unaryExpression = new UnaryExpression(i2, getNodeEnd(astNodeExpr) - i2);
        unaryExpression.setOperator(75);
        unaryExpression.setOperand(astNodeExpr);
        unaryExpression.setLineno(i);
        return new ExpressionStatement((AstNode) unaryExpression, true);
    }

    private AstNode destructuringPrimaryExpr() {
        try {
            this.inDestructuringAssignment = true;
            return primaryExpr();
        } finally {
            this.inDestructuringAssignment = false;
        }
    }

    private DoLoop doLoop() {
        if (this.currentToken != 119) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        DoLoop doLoop = new DoLoop(i);
        doLoop.setLineno(this.ts.lineno);
        enterLoop(doLoop);
        try {
            AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(doLoop);
            mustMatchToken(118, "msg.no.while.do", true);
            doLoop.setWhilePosition(this.ts.tokenBeg - i);
            ConditionData conditionDataCondition = condition();
            doLoop.setCondition(conditionDataCondition.condition);
            doLoop.setParens(conditionDataCondition.lp - i, conditionDataCondition.rp - i);
            int nodeEnd = getNodeEnd(nextStatementAfterInlineComments);
            doLoop.setBody(nextStatementAfterInlineComments);
            exitLoop();
            if (matchToken(83, true)) {
                nodeEnd = this.ts.tokenEnd;
            }
            doLoop.setLength(nodeEnd - i);
            return doLoop;
        } catch (Throwable th) {
            exitLoop();
            throw th;
        }
    }

    private void enterLoop(Loop loop) {
        if (this.loopSet == null) {
            this.loopSet = new ArrayList();
        }
        this.loopSet.add(loop);
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(loop);
        pushScope(loop);
        LabeledStatement labeledStatement = this.currentLabel;
        if (labeledStatement != null) {
            labeledStatement.setStatement(loop);
            this.currentLabel.getFirstLabel().setLoop(loop);
            loop.setRelative(-this.currentLabel.getPosition());
        }
    }

    private void enterSwitch(SwitchStatement switchStatement) {
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(switchStatement);
    }

    private AstNode eqExpr() {
        AstNode astNodeRelExpr = relExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (iPeekToken != 12 && iPeekToken != 13 && iPeekToken != 46 && iPeekToken != 47) {
                return astNodeRelExpr;
            }
            consumeToken();
            if (this.compilerEnv.getLanguageVersion() == 120) {
                if (iPeekToken == 12) {
                    iPeekToken = 46;
                } else if (iPeekToken == 13) {
                    iPeekToken = 47;
                }
            }
            astNodeRelExpr = new InfixExpression(iPeekToken, astNodeRelExpr, relExpr(), i);
        }
    }

    private void exitLoop() {
        List<Loop> list = this.loopSet;
        Loop loopRemove = list.remove(list.size() - 1);
        List<Jump> list2 = this.loopAndSwitchSet;
        list2.remove(list2.size() - 1);
        if (loopRemove.getParent() != null) {
            loopRemove.setRelative(loopRemove.getParent().getPosition());
        }
        popScope();
    }

    private void exitSwitch() {
        List<Jump> list = this.loopAndSwitchSet;
        list.remove(list.size() - 1);
    }

    private AstNode expr() {
        AstNode astNodeAssignExpr = assignExpr();
        int position = astNodeAssignExpr.getPosition();
        while (matchToken(90, true)) {
            int i = this.ts.tokenBeg;
            if (this.compilerEnv.isStrictMode() && !astNodeAssignExpr.hasSideEffects()) {
                addStrictWarning("msg.no.side.effects", "", position, nodeEnd(astNodeAssignExpr) - position);
            }
            if (peekToken() == 73) {
                reportError("msg.yield.parenthesized");
            }
            astNodeAssignExpr = new InfixExpression(90, astNodeAssignExpr, assignExpr(), i);
        }
        return astNodeAssignExpr;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00e7 A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:6:0x001f, B:9:0x0029, B:11:0x0037, B:14:0x0043, B:16:0x004b, B:18:0x0052, B:20:0x0064, B:28:0x0091, B:38:0x00de, B:40:0x00e7, B:45:0x00f3, B:55:0x013b, B:57:0x0155, B:64:0x0167, B:65:0x016a, B:46:0x0102, B:48:0x010b, B:50:0x0118, B:53:0x0122, B:54:0x0128, B:21:0x006c, B:23:0x0076, B:25:0x007c, B:27:0x008b, B:29:0x0097, B:31:0x00a5, B:33:0x00ba, B:35:0x00cb, B:36:0x00d8, B:32:0x00b6, B:12:0x003e, B:56:0x0146), top: B:73:0x001f, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:46:0x0102 A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:6:0x001f, B:9:0x0029, B:11:0x0037, B:14:0x0043, B:16:0x004b, B:18:0x0052, B:20:0x0064, B:28:0x0091, B:38:0x00de, B:40:0x00e7, B:45:0x00f3, B:55:0x013b, B:57:0x0155, B:64:0x0167, B:65:0x016a, B:46:0x0102, B:48:0x010b, B:50:0x0118, B:53:0x0122, B:54:0x0128, B:21:0x006c, B:23:0x0076, B:25:0x007c, B:27:0x008b, B:29:0x0097, B:31:0x00a5, B:33:0x00ba, B:35:0x00cb, B:36:0x00d8, B:32:0x00b6, B:12:0x003e, B:56:0x0146), top: B:73:0x001f, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x010b A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:6:0x001f, B:9:0x0029, B:11:0x0037, B:14:0x0043, B:16:0x004b, B:18:0x0052, B:20:0x0064, B:28:0x0091, B:38:0x00de, B:40:0x00e7, B:45:0x00f3, B:55:0x013b, B:57:0x0155, B:64:0x0167, B:65:0x016a, B:46:0x0102, B:48:0x010b, B:50:0x0118, B:53:0x0122, B:54:0x0128, B:21:0x006c, B:23:0x0076, B:25:0x007c, B:27:0x008b, B:29:0x0097, B:31:0x00a5, B:33:0x00ba, B:35:0x00cb, B:36:0x00d8, B:32:0x00b6, B:12:0x003e, B:56:0x0146), top: B:73:0x001f, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0120 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:60:0x015c  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private Loop forLoop() {
        boolean z;
        int i;
        AstNode astNodeExpr;
        AstNode astNodeExpr2;
        AstNode astNodeExpr3;
        boolean z2;
        int i2;
        int i3;
        Loop loop;
        if (this.currentToken != 120) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i4 = tokenStream.tokenBeg;
        int i5 = tokenStream.lineno;
        Scope scope = new Scope();
        pushScope(scope);
        try {
            boolean z3 = false;
            if (!matchToken(39, true)) {
                z = false;
                i = -1;
            } else if ("each".equals(this.ts.getString())) {
                i = this.ts.tokenBeg - i4;
                z = true;
            } else {
                reportError("msg.no.paren.for");
                z = false;
                i = -1;
            }
            int i6 = mustMatchToken(88, "msg.no.paren.for", true) ? this.ts.tokenBeg - i4 : -1;
            AstNode astNodeForLoopInit = forLoopInit(peekToken());
            try {
                if (!matchToken(52, true)) {
                    if (this.compilerEnv.getLanguageVersion() >= 200 && matchToken(39, true) && "of".equals(this.ts.getString())) {
                        i2 = this.ts.tokenBeg - i4;
                        z2 = true;
                    } else {
                        mustMatchToken(83, "msg.no.semi.for", true);
                        if (peekToken() == 83) {
                            astNodeExpr = new EmptyExpression(this.ts.tokenBeg, 1);
                            astNodeExpr.setLineno(this.ts.lineno);
                        } else {
                            astNodeExpr = expr();
                        }
                        astNodeExpr2 = astNodeExpr;
                        mustMatchToken(83, "msg.no.semi.for.cond", true);
                        int i7 = this.ts.tokenEnd;
                        if (peekToken() == 89) {
                            astNodeExpr3 = new EmptyExpression(i7, 1);
                            astNodeExpr3.setLineno(this.ts.lineno);
                        } else {
                            astNodeExpr3 = expr();
                        }
                        z2 = false;
                        i2 = -1;
                    }
                    if (mustMatchToken(89, "msg.no.paren.for.ctrl", true)) {
                        i3 = this.ts.tokenBeg - i4;
                    } else {
                        i3 = -1;
                    }
                    if (!z3 || z2) {
                        ForInLoop forInLoop = new ForInLoop(i4);
                        if ((astNodeForLoopInit instanceof VariableDeclaration) && ((VariableDeclaration) astNodeForLoopInit).getVariables().size() > 1) {
                            reportError("msg.mult.index");
                        }
                        if (z2 && z) {
                            reportError("msg.invalid.for.each");
                        }
                        forInLoop.setIterator(astNodeForLoopInit);
                        forInLoop.setIteratedObject(astNodeExpr2);
                        forInLoop.setInPosition(i2);
                        forInLoop.setIsForEach(z);
                        forInLoop.setEachPosition(i);
                        forInLoop.setIsForOf(z2);
                        loop = forInLoop;
                    } else {
                        ForLoop forLoop = new ForLoop(i4);
                        forLoop.setInitializer(astNodeForLoopInit);
                        forLoop.setCondition(astNodeExpr2);
                        forLoop.setIncrement(astNodeExpr3);
                        loop = forLoop;
                    }
                    this.currentScope.replaceWith(loop);
                    popScope();
                    enterLoop(loop);
                    AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(loop);
                    loop.setLength(getNodeEnd(nextStatementAfterInlineComments) - i4);
                    loop.setBody(nextStatementAfterInlineComments);
                    exitLoop();
                    if (this.currentScope == scope) {
                        popScope();
                    }
                    loop.setParens(i6, i3);
                    loop.setLineno(i5);
                    return loop;
                }
                i2 = this.ts.tokenBeg - i4;
                z2 = false;
                z3 = true;
                AstNode nextStatementAfterInlineComments2 = getNextStatementAfterInlineComments(loop);
                loop.setLength(getNodeEnd(nextStatementAfterInlineComments2) - i4);
                loop.setBody(nextStatementAfterInlineComments2);
                exitLoop();
                if (this.currentScope == scope) {
                    popScope();
                }
                loop.setParens(i6, i3);
                loop.setLineno(i5);
                return loop;
            } catch (Throwable th) {
                exitLoop();
                throw th;
            }
            astNodeExpr2 = expr();
            astNodeExpr3 = null;
            if (mustMatchToken(89, "msg.no.paren.for.ctrl", true)) {
                i3 = this.ts.tokenBeg - i4;
            } else {
                i3 = -1;
            }
            if (z3) {
                ForInLoop forInLoop2 = new ForInLoop(i4);
                if (astNodeForLoopInit instanceof VariableDeclaration) {
                    reportError("msg.mult.index");
                }
                if (z2) {
                    reportError("msg.invalid.for.each");
                }
                forInLoop2.setIterator(astNodeForLoopInit);
                forInLoop2.setIteratedObject(astNodeExpr2);
                forInLoop2.setInPosition(i2);
                forInLoop2.setIsForEach(z);
                forInLoop2.setEachPosition(i);
                forInLoop2.setIsForOf(z2);
                loop = forInLoop2;
            } else {
                ForInLoop forInLoop3 = new ForInLoop(i4);
                if (astNodeForLoopInit instanceof VariableDeclaration) {
                    reportError("msg.mult.index");
                }
                if (z2) {
                    reportError("msg.invalid.for.each");
                }
                forInLoop3.setIterator(astNodeForLoopInit);
                forInLoop3.setIteratedObject(astNodeExpr2);
                forInLoop3.setInPosition(i2);
                forInLoop3.setIsForEach(z);
                forInLoop3.setEachPosition(i);
                forInLoop3.setIsForOf(z2);
                loop = forInLoop3;
            }
            this.currentScope.replaceWith(loop);
            popScope();
            enterLoop(loop);
        } catch (Throwable th2) {
            if (this.currentScope == scope) {
                popScope();
            }
            throw th2;
        }
    }

    private AstNode forLoopInit(int i) {
        AstNode astNodeVariables;
        try {
            this.inForInit = true;
            if (i == 83) {
                astNodeVariables = new EmptyExpression(this.ts.tokenBeg, 1);
                astNodeVariables.setLineno(this.ts.lineno);
            } else if (i == 123 || i == 154) {
                consumeToken();
                astNodeVariables = variables(i, this.ts.tokenBeg, false);
            } else {
                astNodeVariables = expr();
                markDestructuring(astNodeVariables);
            }
            return astNodeVariables;
        } finally {
            this.inForInit = false;
        }
    }

    private FunctionNode function(int i) {
        return function(i, false);
    }

    private AstNode generatorExpression(AstNode astNode, int i) {
        return generatorExpression(astNode, i, false);
    }

    private GeneratorExpressionLoop generatorExpressionLoop() {
        AstNode astNodeCreateNameNode;
        if (nextToken() != 120) {
            codeBug();
        }
        int i = this.ts.tokenBeg;
        GeneratorExpressionLoop generatorExpressionLoop = new GeneratorExpressionLoop(i);
        pushScope(generatorExpressionLoop);
        try {
            int i2 = mustMatchToken(88, "msg.no.paren.for", true) ? this.ts.tokenBeg - i : -1;
            int iPeekToken = peekToken();
            if (iPeekToken == 39) {
                consumeToken();
                astNodeCreateNameNode = createNameNode();
            } else if (iPeekToken == 84 || iPeekToken == 86) {
                astNodeCreateNameNode = destructuringPrimaryExpr();
                markDestructuring(astNodeCreateNameNode);
            } else {
                reportError("msg.bad.var");
                astNodeCreateNameNode = null;
            }
            if (astNodeCreateNameNode.getType() == 39) {
                defineSymbol(Token.LET, this.ts.getString(), true);
            }
            int i3 = mustMatchToken(52, "msg.in.after.for.name", true) ? this.ts.tokenBeg - i : -1;
            AstNode astNodeExpr = expr();
            int i4 = mustMatchToken(89, "msg.no.paren.for.ctrl", true) ? this.ts.tokenBeg - i : -1;
            generatorExpressionLoop.setLength(this.ts.tokenEnd - i);
            generatorExpressionLoop.setIterator(astNodeCreateNameNode);
            generatorExpressionLoop.setIteratedObject(astNodeExpr);
            generatorExpressionLoop.setInPosition(i3);
            generatorExpressionLoop.setParens(i2, i4);
            return generatorExpressionLoop;
        } finally {
            popScope();
        }
    }

    private Comment getAndResetJsDoc() {
        Comment comment = this.currentJsDocComment;
        this.currentJsDocComment = null;
        return comment;
    }

    private static String getDirective(AstNode astNode) {
        if (!(astNode instanceof ExpressionStatement)) {
            return null;
        }
        AstNode expression = ((ExpressionStatement) astNode).getExpression();
        if (expression instanceof StringLiteral) {
            return ((StringLiteral) expression).getValue();
        }
        return null;
    }

    private AstNode getNextStatementAfterInlineComments(AstNode astNode) {
        AstNode astNodeStatement = statement();
        if (162 != astNodeStatement.getType()) {
            return astNodeStatement;
        }
        AstNode astNodeStatement2 = statement();
        if (astNode != null) {
            astNode.setInlineComment(astNodeStatement);
            return astNodeStatement2;
        }
        astNodeStatement2.setInlineComment(astNodeStatement);
        return astNodeStatement2;
    }

    private static int getNodeEnd(AstNode astNode) {
        return astNode.getPosition() + astNode.getLength();
    }

    private IfStatement ifStatement() {
        int i;
        AstNode astNodeStatement;
        if (this.currentToken != 113) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        int i3 = tokenStream.lineno;
        IfStatement ifStatement = new IfStatement(i2);
        ConditionData conditionDataCondition = condition();
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(ifStatement);
        if (matchToken(114, true)) {
            if (peekToken() == 162) {
                List<Comment> list = this.scannedComments;
                ifStatement.setElseKeyWordInlineComment(list.get(list.size() - 1));
                consumeToken();
            }
            i = this.ts.tokenBeg - i2;
            astNodeStatement = statement();
        } else {
            i = -1;
            astNodeStatement = null;
        }
        ifStatement.setLength(getNodeEnd(astNodeStatement != null ? astNodeStatement : nextStatementAfterInlineComments) - i2);
        ifStatement.setCondition(conditionDataCondition.condition);
        ifStatement.setParens(conditionDataCondition.lp - i2, conditionDataCondition.rp - i2);
        ifStatement.setThenPart(nextStatementAfterInlineComments);
        ifStatement.setElsePart(astNodeStatement);
        ifStatement.setElsePosition(i);
        ifStatement.setLineno(i3);
        return ifStatement;
    }

    private AstNode let(boolean z, int i) {
        LetNode letNode = new LetNode(i);
        letNode.setLineno(this.ts.lineno);
        if (mustMatchToken(88, "msg.no.paren.after.let", true)) {
            letNode.setLp(this.ts.tokenBeg - i);
        }
        pushScope(letNode);
        try {
            letNode.setVariables(variables(Token.LET, this.ts.tokenBeg, z));
            if (mustMatchToken(89, "msg.no.paren.let", true)) {
                letNode.setRp(this.ts.tokenBeg - i);
            }
            if (z && peekToken() == 86) {
                consumeToken();
                int i2 = this.ts.tokenBeg;
                AstNode astNodeStatements = statements();
                mustMatchToken(87, "msg.no.curly.let", true);
                astNodeStatements.setLength(this.ts.tokenEnd - i2);
                letNode.setLength(this.ts.tokenEnd - i);
                letNode.setBody(astNodeStatements);
                letNode.setType(Token.LET);
            } else {
                AstNode astNodeExpr = expr();
                letNode.setLength(getNodeEnd(astNodeExpr) - i);
                letNode.setBody(astNodeExpr);
                if (z) {
                    ExpressionStatement expressionStatement = new ExpressionStatement(letNode, !insideFunction());
                    expressionStatement.setLineno(letNode.getLineno());
                    return expressionStatement;
                }
            }
            return letNode;
        } finally {
            popScope();
        }
    }

    private AstNode letStatement() {
        if (this.currentToken != 154) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        AstNode astNodeLet = peekToken() == 88 ? let(true, i2) : variables(Token.LET, i2, true);
        astNodeLet.setLineno(i);
        return astNodeLet;
    }

    private int lineBeginningFor(int i) {
        char[] cArr = this.sourceChars;
        if (cArr == null) {
            return -1;
        }
        if (i <= 0) {
            return 0;
        }
        if (i >= cArr.length) {
            i = cArr.length - 1;
        }
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return 0;
            }
            if (ScriptRuntime.isJSLineTerminator(cArr[i2])) {
                return i;
            }
            i = i2;
        }
    }

    private ErrorNode makeErrorNode() {
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        ErrorNode errorNode = new ErrorNode(i, tokenStream.tokenEnd - i);
        errorNode.setLineno(this.ts.lineno);
        return errorNode;
    }

    private LabeledStatement matchJumpLabelName() {
        LabeledStatement labeledStatement = null;
        if (peekTokenOrEOL() == 39) {
            consumeToken();
            Map<String, LabeledStatement> map = this.labelSet;
            labeledStatement = map != null ? map.get(this.ts.getString()) : null;
            if (labeledStatement == null) {
                reportError("msg.undef.label");
            }
        }
        return labeledStatement;
    }

    private boolean matchToken(int i, boolean z) {
        int iPeekToken;
        while (true) {
            iPeekToken = peekToken();
            if (iPeekToken != 162 || !z) {
                break;
            }
            consumeToken();
        }
        if (iPeekToken != i) {
            return false;
        }
        consumeToken();
        return true;
    }

    private AstNode memberExpr(boolean z) {
        AstNode astNodePrimaryExpr;
        int iPeekToken = peekToken();
        int i = this.ts.lineno;
        if (iPeekToken != 30) {
            astNodePrimaryExpr = primaryExpr();
        } else {
            consumeToken();
            int i2 = this.ts.tokenBeg;
            NewExpression newExpression = new NewExpression(i2);
            AstNode astNodeMemberExpr = memberExpr(false);
            int nodeEnd = getNodeEnd(astNodeMemberExpr);
            newExpression.setTarget(astNodeMemberExpr);
            if (matchToken(88, true)) {
                int i3 = this.ts.tokenBeg;
                List<AstNode> listArgumentList = argumentList();
                if (listArgumentList != null && listArgumentList.size() > 65536) {
                    reportError("msg.too.many.constructor.args");
                }
                TokenStream tokenStream = this.ts;
                int i4 = tokenStream.tokenBeg;
                int i5 = tokenStream.tokenEnd;
                if (listArgumentList != null) {
                    newExpression.setArguments(listArgumentList);
                }
                newExpression.setParens(i3 - i2, i4 - i2);
                nodeEnd = i5;
            }
            if (matchToken(86, true)) {
                ObjectLiteral objectLiteral = objectLiteral();
                nodeEnd = getNodeEnd(objectLiteral);
                newExpression.setInitializer(objectLiteral);
            }
            newExpression.setLength(nodeEnd - i2);
            astNodePrimaryExpr = newExpression;
        }
        astNodePrimaryExpr.setLineno(i);
        return memberExprTail(z, astNodePrimaryExpr);
    }

    private AstNode memberExprTail(boolean z, AstNode astNode) {
        int i;
        AstNode astNode2;
        if (astNode == null) {
            codeBug();
        }
        int position = astNode.getPosition();
        while (true) {
            int iPeekToken = peekToken();
            int i2 = -1;
            if (iPeekToken == 84) {
                consumeToken();
                TokenStream tokenStream = this.ts;
                int i3 = tokenStream.tokenBeg;
                i = tokenStream.lineno;
                AstNode astNodeExpr = expr();
                int nodeEnd = getNodeEnd(astNodeExpr);
                if (mustMatchToken(85, "msg.no.bracket.index", true)) {
                    TokenStream tokenStream2 = this.ts;
                    i2 = tokenStream2.tokenBeg;
                    nodeEnd = tokenStream2.tokenEnd;
                }
                ElementGet elementGet = new ElementGet(position, nodeEnd - position);
                elementGet.setTarget(astNode);
                elementGet.setElement(astNodeExpr);
                elementGet.setParens(i3, i2);
                astNode2 = elementGet;
            } else if (iPeekToken != 88) {
                if (iPeekToken == 109 || iPeekToken == 144) {
                    int i4 = this.ts.lineno;
                    astNode = propertyAccess(iPeekToken, astNode);
                    astNode.setLineno(i4);
                } else if (iPeekToken == 147) {
                    consumeToken();
                    TokenStream tokenStream3 = this.ts;
                    int i5 = tokenStream3.tokenBeg;
                    i = tokenStream3.lineno;
                    mustHaveXML();
                    setRequiresActivation();
                    AstNode astNodeExpr2 = expr();
                    int nodeEnd2 = getNodeEnd(astNodeExpr2);
                    if (mustMatchToken(89, "msg.no.paren", true)) {
                        TokenStream tokenStream4 = this.ts;
                        i2 = tokenStream4.tokenBeg;
                        nodeEnd2 = tokenStream4.tokenEnd;
                    }
                    XmlDotQuery xmlDotQuery = new XmlDotQuery(position, nodeEnd2 - position);
                    xmlDotQuery.setLeft(astNode);
                    xmlDotQuery.setRight(astNodeExpr2);
                    xmlDotQuery.setOperatorPosition(i5);
                    xmlDotQuery.setRp(i2 - position);
                    astNode2 = xmlDotQuery;
                } else {
                    if (iPeekToken != 162) {
                        break;
                    }
                    int i6 = this.currentFlaggedToken;
                    peekUntilNonComment(iPeekToken);
                    int i7 = this.currentFlaggedToken;
                    if ((i7 & 65536) != 0) {
                        i6 = i7;
                    }
                    this.currentFlaggedToken = i6;
                }
            } else {
                if (!z) {
                    break;
                }
                int i8 = this.ts.lineno;
                consumeToken();
                checkCallRequiresActivation(astNode);
                FunctionCall functionCall = new FunctionCall(position);
                functionCall.setTarget(astNode);
                functionCall.setLineno(i8);
                functionCall.setLp(this.ts.tokenBeg - position);
                List<AstNode> listArgumentList = argumentList();
                if (listArgumentList != null && listArgumentList.size() > 65536) {
                    reportError("msg.too.many.function.args");
                }
                functionCall.setArguments(listArgumentList);
                functionCall.setRp(this.ts.tokenBeg - position);
                functionCall.setLength(this.ts.tokenEnd - position);
                astNode = functionCall;
            }
            astNode2.setLineno(i);
            astNode = astNode2;
        }
        return astNode;
    }

    private ObjectProperty methodDefinition(int i, AstNode astNode, int i2) {
        FunctionNode functionNodeFunction = function(2);
        Name functionName = functionNodeFunction.getFunctionName();
        if (functionName != null && functionName.length() != 0) {
            reportError("msg.bad.prop");
        }
        ObjectProperty objectProperty = new ObjectProperty(i);
        if (i2 == 2) {
            objectProperty.setIsGetterMethod();
            functionNodeFunction.setFunctionIsGetterMethod();
        } else if (i2 == 4) {
            objectProperty.setIsSetterMethod();
            functionNodeFunction.setFunctionIsSetterMethod();
        } else if (i2 == 8) {
            objectProperty.setIsNormalMethod();
            functionNodeFunction.setFunctionIsNormalMethod();
        }
        int nodeEnd = getNodeEnd(functionNodeFunction);
        objectProperty.setLeft(astNode);
        objectProperty.setRight(functionNodeFunction);
        objectProperty.setLength(nodeEnd - i);
        return objectProperty;
    }

    private AstNode mulExpr() {
        AstNode astNodeUnaryExpr = unaryExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            switch (iPeekToken) {
                case 23:
                case 24:
                case 25:
                    consumeToken();
                    astNodeUnaryExpr = new InfixExpression(iPeekToken, astNodeUnaryExpr, unaryExpr(), i);
                    break;
                default:
                    return astNodeUnaryExpr;
            }
        }
    }

    private void mustHaveXML() {
        if (this.compilerEnv.isXmlAvailable()) {
            return;
        }
        reportError("msg.XML.not.available");
    }

    private boolean mustMatchToken(int i, String str, int i2, int i3, boolean z) {
        if (matchToken(i, z)) {
            return true;
        }
        reportError(str, i2, i3);
        return false;
    }

    private AstNode name(int i, int i2) {
        String string = this.ts.getString();
        TokenStream tokenStream = this.ts;
        int i3 = tokenStream.tokenBeg;
        int i4 = tokenStream.lineno;
        if ((i & 131072) == 0 || peekToken() != 104) {
            saveNameTokenData(i3, string, i4);
            return this.compilerEnv.isXmlAvailable() ? propertyName(-1, 0) : createNameNode(true, 39);
        }
        Label label = new Label(i3, this.ts.tokenEnd - i3);
        label.setName(string);
        label.setLineno(this.ts.lineno);
        return label;
    }

    private AstNode nameOrLabel() {
        AstNode astNodeStatementHelper;
        if (this.currentToken != 39) {
            throw codeBug();
        }
        int i = this.ts.tokenBeg;
        this.currentFlaggedToken |= 131072;
        AstNode astNodeExpr = expr();
        if (astNodeExpr.getType() != 131) {
            ExpressionStatement expressionStatement = new ExpressionStatement(astNodeExpr, !insideFunction());
            expressionStatement.lineno = astNodeExpr.lineno;
            return expressionStatement;
        }
        LabeledStatement labeledStatement = new LabeledStatement(i);
        recordLabel((Label) astNodeExpr, labeledStatement);
        labeledStatement.setLineno(this.ts.lineno);
        while (true) {
            if (peekToken() != 39) {
                astNodeStatementHelper = null;
                break;
            }
            this.currentFlaggedToken |= 131072;
            AstNode astNodeExpr2 = expr();
            if (astNodeExpr2.getType() != 131) {
                astNodeStatementHelper = new ExpressionStatement(astNodeExpr2, !insideFunction());
                autoInsertSemicolon(astNodeStatementHelper);
                break;
            }
            recordLabel((Label) astNodeExpr2, labeledStatement);
        }
        try {
            this.currentLabel = labeledStatement;
            if (astNodeStatementHelper == null) {
                astNodeStatementHelper = statementHelper();
                if (peekToken() == 162) {
                    int lineno = astNodeStatementHelper.getLineno();
                    List<Comment> list = this.scannedComments;
                    if (lineno == list.get(list.size() - 1).getLineno()) {
                        List<Comment> list2 = this.scannedComments;
                        astNodeStatementHelper.setInlineComment(list2.get(list2.size() - 1));
                        consumeToken();
                    }
                }
            }
            this.currentLabel = null;
            Iterator<Label> it = labeledStatement.getLabels().iterator();
            while (it.hasNext()) {
                this.labelSet.remove(it.next().getName());
            }
            labeledStatement.setLength(astNodeStatementHelper.getParent() == null ? getNodeEnd(astNodeStatementHelper) - i : getNodeEnd(astNodeStatementHelper));
            labeledStatement.setStatement(astNodeStatementHelper);
            return labeledStatement;
        } catch (Throwable th) {
            this.currentLabel = null;
            Iterator<Label> it2 = labeledStatement.getLabels().iterator();
            while (it2.hasNext()) {
                this.labelSet.remove(it2.next().getName());
            }
            throw th;
        }
    }

    private int nextToken() {
        int iPeekToken = peekToken();
        consumeToken();
        return iPeekToken;
    }

    private static int nodeEnd(AstNode astNode) {
        return astNode.getPosition() + astNode.getLength();
    }

    private static final boolean nowAllSet(int i, int i2, int i3) {
        return (i & i3) != i3 && (i2 & i3) == i3;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00db  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:76:0x0113 A[LOOP:0: B:7:0x0024->B:76:0x0113, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x011a A[EDGE_INSN: B:83:0x011a->B:77:0x011a BREAK  A[LOOP:0: B:7:0x0024->B:76:0x0113], SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d8, code lost:
    
        if (r5 != 8) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private external.sdk.pendo.io.mozilla.javascript.ast.ObjectLiteral objectLiteral() {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Parser.objectLiteral():external.sdk.pendo.io.mozilla.javascript.ast.ObjectLiteral");
    }

    private AstNode objliteralProperty() {
        switch (peekToken()) {
            case 39:
                break;
            case 40:
                TokenStream tokenStream = this.ts;
                return new NumberLiteral(tokenStream.tokenBeg, tokenStream.getString(), this.ts.getNumber());
            case 41:
                return createStringLiteral();
            default:
                if (!this.compilerEnv.isReservedKeywordAsIdentifier() || !TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective)) {
                    return null;
                }
                break;
        }
        return createNameNode();
    }

    private AstNode orExpr() {
        AstNode astNodeAndExpr = andExpr();
        if (!matchToken(105, true)) {
            return astNodeAndExpr;
        }
        return new InfixExpression(105, astNodeAndExpr, orExpr(), this.ts.tokenBeg);
    }

    private AstNode parenExpr() {
        boolean z = this.inForInit;
        this.inForInit = false;
        try {
            Comment andResetJsDoc = getAndResetJsDoc();
            TokenStream tokenStream = this.ts;
            int i = tokenStream.lineno;
            int i2 = tokenStream.tokenBeg;
            AstNode emptyExpression = peekToken() == 89 ? new EmptyExpression(i2) : expr();
            if (peekToken() == 120) {
                return generatorExpression(emptyExpression, i2);
            }
            mustMatchToken(89, "msg.no.paren", true);
            if (emptyExpression.getType() == 129 && peekToken() != 165) {
                reportError("msg.syntax");
                return makeErrorNode();
            }
            ParenthesizedExpression parenthesizedExpression = new ParenthesizedExpression(i2, this.ts.tokenEnd - i2, emptyExpression);
            parenthesizedExpression.setLineno(i);
            if (andResetJsDoc == null) {
                andResetJsDoc = getAndResetJsDoc();
            }
            if (andResetJsDoc != null) {
                parenthesizedExpression.setJsDocNode(andResetJsDoc);
            }
            return parenthesizedExpression;
        } finally {
            this.inForInit = z;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x008a  */
    /* JADX WARN: Code duplicated, block: B:40:0x009e  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:47:0x00cf A[LOOP:1: B:45:0x00c9->B:47:0x00cf, LOOP_END] */
    private AstRoot parse() {
        int i;
        List<Comment> list;
        Iterator<Comment> it;
        String strLookupMessage;
        AstNode astNodeStatement;
        AstRoot astRoot = new AstRoot(0);
        this.currentScriptOrFn = astRoot;
        this.currentScope = astRoot;
        int i2 = this.ts.lineno;
        boolean z = this.inUseStrictDirective;
        boolean z2 = this.defaultUseStrictDirective;
        this.inUseStrictDirective = z2;
        if (z2) {
            astRoot.setInStrictMode(true);
        }
        int iMax = 0;
        boolean z3 = true;
        while (true) {
            try {
                try {
                    int iPeekToken = peekToken();
                    if (iPeekToken <= 0) {
                        break;
                    }
                    if (iPeekToken == 110) {
                        consumeToken();
                        try {
                            astNodeStatement = function(this.calledByCompileFunction ? 2 : 1);
                        } catch (ParserException unused) {
                        }
                    } else if (iPeekToken == 162) {
                        List<Comment> list2 = this.scannedComments;
                        astNodeStatement = list2.get(list2.size() - 1);
                        consumeToken();
                    } else {
                        astNodeStatement = statement();
                        if (z3) {
                            String directive = getDirective(astNodeStatement);
                            if (directive == null) {
                                z3 = false;
                            } else if (directive.equals("use strict")) {
                                this.inUseStrictDirective = true;
                                astRoot.setInStrictMode(true);
                            }
                        }
                    }
                    iMax = getNodeEnd(astNodeStatement);
                    astRoot.addChildToBack(astNodeStatement);
                    astNodeStatement.setParent(astRoot);
                } catch (Throwable th) {
                    this.inUseStrictDirective = z;
                    throw th;
                }
            } catch (StackOverflowError unused2) {
                String strLookupMessage2 = lookupMessage("msg.too.deep.parser.recursion");
                if (!this.compilerEnv.isIdeMode()) {
                    throw Context.reportRuntimeError(strLookupMessage2, this.sourceURI, this.ts.lineno, null, 0);
                }
            }
            this.inUseStrictDirective = z;
            i = this.syntaxErrorCount;
            if (i != 0) {
                strLookupMessage = lookupMessage("msg.got.syntax.errors", String.valueOf(i));
                if (!this.compilerEnv.isIdeMode()) {
                    throw this.errorReporter.runtimeError(strLookupMessage, this.sourceURI, i2, null, 0);
                }
            }
            list = this.scannedComments;
            if (list != null) {
                iMax = Math.max(iMax, getNodeEnd(this.scannedComments.get(list.size() - 1)));
                it = this.scannedComments.iterator();
                while (it.hasNext()) {
                    astRoot.addComment(it.next());
                }
            }
            astRoot.setLength(iMax);
            astRoot.setSourceName(this.sourceURI);
            astRoot.setBaseLineno(i2);
            astRoot.setEndLineno(this.ts.lineno);
            return astRoot;
        }
        this.inUseStrictDirective = z;
        i = this.syntaxErrorCount;
        if (i != 0) {
            strLookupMessage = lookupMessage("msg.got.syntax.errors", String.valueOf(i));
            if (!this.compilerEnv.isIdeMode()) {
                throw this.errorReporter.runtimeError(strLookupMessage, this.sourceURI, i2, null, 0);
            }
        }
        list = this.scannedComments;
        if (list != null) {
            iMax = Math.max(iMax, getNodeEnd(this.scannedComments.get(list.size() - 1)));
            it = this.scannedComments.iterator();
            while (it.hasNext()) {
                astRoot.addComment(it.next());
            }
        }
        astRoot.setLength(iMax);
        astRoot.setSourceName(this.sourceURI);
        astRoot.setBaseLineno(i2);
        astRoot.setEndLineno(this.ts.lineno);
        return astRoot;
    }

    private AstNode parseFunctionBody(int i, FunctionNode functionNode) {
        boolean z;
        Comment commentFunction;
        if (matchToken(86, true)) {
            z = false;
        } else if (this.compilerEnv.getLanguageVersion() >= 180 || i == 4) {
            z = true;
        } else {
            reportError("msg.no.brace.body");
            z = false;
        }
        boolean z2 = i == 4;
        this.nestingOfFunction++;
        int i2 = this.ts.tokenBeg;
        Block block = new Block(i2);
        boolean z3 = this.inUseStrictDirective;
        this.inUseStrictDirective = false;
        block.setLineno(this.ts.lineno);
        try {
            if (z) {
                AstNode astNodeAssignExpr = assignExpr();
                ReturnStatement returnStatement = new ReturnStatement(astNodeAssignExpr.getPosition(), astNodeAssignExpr.getLength(), astNodeAssignExpr);
                Boolean bool = Boolean.TRUE;
                returnStatement.putProp(25, bool);
                block.putProp(25, bool);
                if (z2) {
                    returnStatement.putProp(27, bool);
                }
                block.addStatement(returnStatement);
            } else {
                boolean z4 = true;
                while (true) {
                    int iPeekToken = peekToken();
                    if (iPeekToken == -1 || iPeekToken == 0 || iPeekToken == 87) {
                        break;
                    }
                    if (iPeekToken == 110) {
                        consumeToken();
                        commentFunction = function(1);
                    } else if (iPeekToken != 162) {
                        commentFunction = statement();
                        if (z4) {
                            String directive = getDirective(commentFunction);
                            if (directive == null) {
                                z4 = false;
                            } else if (directive.equals("use strict")) {
                                this.inUseStrictDirective = true;
                                functionNode.setInStrictMode(true);
                                if (!z3) {
                                    setRequiresActivation();
                                }
                            }
                        }
                    } else {
                        consumeToken();
                        List<Comment> list = this.scannedComments;
                        commentFunction = list.get(list.size() - 1);
                    }
                    block.addStatement(commentFunction);
                }
            }
        } catch (ParserException unused) {
        } catch (Throwable th) {
            this.nestingOfFunction--;
            this.inUseStrictDirective = z3;
            throw th;
        }
        this.nestingOfFunction--;
        this.inUseStrictDirective = z3;
        int i3 = this.ts.tokenEnd;
        getAndResetJsDoc();
        if (!z && mustMatchToken(87, "msg.no.brace.after.body", true)) {
            i3 = this.ts.tokenEnd;
        }
        block.setLength(i3 - i2);
        return block;
    }

    private void parseFunctionParams(FunctionNode functionNode) {
        if (!matchToken(89, true)) {
            HashSet hashSet = new HashSet();
            HashMap map = null;
            do {
                int iPeekToken = peekToken();
                if (iPeekToken == 84 || iPeekToken == 86) {
                    AstNode astNodeDestructuringPrimaryExpr = destructuringPrimaryExpr();
                    markDestructuring(astNodeDestructuringPrimaryExpr);
                    functionNode.addParam(astNodeDestructuringPrimaryExpr);
                    if (map == null) {
                        map = new HashMap();
                    }
                    String nextTempName = this.currentScriptOrFn.getNextTempName();
                    defineSymbol(88, nextTempName, false);
                    map.put(nextTempName, astNodeDestructuringPrimaryExpr);
                } else if (mustMatchToken(39, "msg.no.parm", true)) {
                    AstNode astNodeCreateNameNode = createNameNode();
                    Comment andResetJsDoc = getAndResetJsDoc();
                    if (andResetJsDoc != null) {
                        astNodeCreateNameNode.setJsDocNode(andResetJsDoc);
                    }
                    functionNode.addParam(astNodeCreateNameNode);
                    String string = this.ts.getString();
                    defineSymbol(88, string);
                    if (this.inUseStrictDirective) {
                        if ("eval".equals(string) || "arguments".equals(string)) {
                            reportError("msg.bad.id.strict", string);
                        }
                        if (hashSet.contains(string)) {
                            addError("msg.dup.param.strict", string);
                        }
                        hashSet.add(string);
                    }
                } else {
                    functionNode.addParam(makeErrorNode());
                }
            } while (matchToken(90, true));
            if (map != null) {
                Node node = new Node(90);
                for (Map.Entry entry : map.entrySet()) {
                    node.addChildToBack(createDestructuringAssignment(123, (Node) entry.getValue(), createName((String) entry.getKey())));
                }
                functionNode.putProp(23, node);
            }
            if (!mustMatchToken(89, "msg.no.paren.after.parms", true)) {
                return;
            }
        }
        functionNode.setRp(this.ts.tokenBeg - functionNode.getPosition());
    }

    private int peekFlaggedToken() {
        peekToken();
        return this.currentFlaggedToken;
    }

    private int peekToken() {
        if (this.currentFlaggedToken != 0) {
            return this.currentToken;
        }
        int lineno = this.ts.getLineno();
        int token = this.ts.getToken();
        boolean z = false;
        while (true) {
            if (token != 1 && token != 162) {
                break;
            }
            if (token == 1) {
                lineno++;
                token = this.ts.getToken();
                z = true;
            } else {
                if (this.compilerEnv.isRecordingComments()) {
                    recordComment(lineno, this.ts.getAndResetCurrentComment());
                    break;
                }
                token = this.ts.getToken();
            }
        }
        this.currentToken = token;
        this.currentFlaggedToken = token | (z ? 65536 : 0);
        return token;
    }

    private int peekTokenOrEOL() {
        int iPeekToken = peekToken();
        if ((this.currentFlaggedToken & 65536) != 0) {
            return 1;
        }
        return iPeekToken;
    }

    private int peekUntilNonComment(int i) {
        while (i == 162) {
            consumeToken();
            i = peekToken();
        }
        return i;
    }

    private ObjectProperty plainProperty(AstNode astNode, int i) {
        AstNode name;
        ObjectProperty objectProperty;
        int iPeekToken = peekToken();
        if ((iPeekToken == 90 || iPeekToken == 87) && i == 39 && this.compilerEnv.getLanguageVersion() >= 180) {
            if (!this.inDestructuringAssignment) {
                reportError("msg.bad.object.init");
            }
            name = new Name(astNode.getPosition(), astNode.getString());
            objectProperty = new ObjectProperty();
            objectProperty.putProp(26, Boolean.TRUE);
        } else {
            mustMatchToken(104, "msg.no.colon.prop", true);
            objectProperty = new ObjectProperty();
            objectProperty.setOperatorPosition(this.ts.tokenBeg);
            name = assignExpr();
        }
        objectProperty.setLeftAndRight(astNode, name);
        return objectProperty;
    }

    private AstNode primaryExpr() {
        String str;
        int iPeekFlaggedToken = peekFlaggedToken();
        int i = 65535 & iPeekFlaggedToken;
        if (i != -1) {
            if (i != 0) {
                if (i != 24) {
                    if (i == 84) {
                        consumeToken();
                        return arrayLiteral();
                    }
                    if (i == 86) {
                        consumeToken();
                        return objectLiteral();
                    }
                    if (i == 88) {
                        consumeToken();
                        return parenExpr();
                    }
                    if (i != 101) {
                        if (i == 110) {
                            consumeToken();
                            return function(2);
                        }
                        if (i == 128) {
                            consumeToken();
                            reportError("msg.reserved.id", this.ts.getString());
                        } else {
                            if (i == 148) {
                                consumeToken();
                                mustHaveXML();
                                return attributeAccess();
                            }
                            consumeToken();
                            if (i == 154) {
                                return let(false, this.ts.tokenBeg);
                            }
                            switch (i) {
                                case 39:
                                    return name(iPeekFlaggedToken, i);
                                case 40:
                                    String string = this.ts.getString();
                                    if (this.inUseStrictDirective && this.ts.isNumberOldOctal()) {
                                        reportError("msg.no.old.octal.strict");
                                    }
                                    if (this.ts.isNumberBinary()) {
                                        string = "0b" + string;
                                    }
                                    if (this.ts.isNumberOldOctal()) {
                                        string = "0" + string;
                                    }
                                    if (this.ts.isNumberOctal()) {
                                        string = "0o" + string;
                                    }
                                    if (this.ts.isNumberHex()) {
                                        string = "0x" + string;
                                    }
                                    TokenStream tokenStream = this.ts;
                                    return new NumberLiteral(tokenStream.tokenBeg, string, tokenStream.getNumber());
                                case 41:
                                    return createStringLiteral();
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                    TokenStream tokenStream2 = this.ts;
                                    int i2 = tokenStream2.tokenBeg;
                                    return new KeywordLiteral(i2, tokenStream2.tokenEnd - i2, i);
                                default:
                                    str = "msg.syntax";
                                    break;
                            }
                        }
                    }
                }
                consumeToken();
                this.ts.readRegExp(i);
                TokenStream tokenStream3 = this.ts;
                int i3 = tokenStream3.tokenBeg;
                RegExpLiteral regExpLiteral = new RegExpLiteral(i3, tokenStream3.tokenEnd - i3);
                regExpLiteral.setValue(this.ts.getString());
                regExpLiteral.setFlags(this.ts.readAndClearRegExpFlags());
                return regExpLiteral;
            }
            consumeToken();
            str = "msg.unexpected.eof";
            reportError(str);
        } else {
            consumeToken();
        }
        consumeToken();
        return makeErrorNode();
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c0  */
    private AstNode propertyAccess(int i, AstNode astNode) {
        int i2;
        int i3;
        int i4;
        String str;
        AstNode astNodePropertyName;
        boolean z;
        InfixExpression propertyGet;
        String string;
        if (astNode == null) {
            codeBug();
        }
        TokenStream tokenStream = this.ts;
        int i5 = tokenStream.lineno;
        int i6 = tokenStream.tokenBeg;
        consumeToken();
        if (i == 144) {
            mustHaveXML();
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (!this.compilerEnv.isXmlAvailable()) {
            if (nextToken() != 39 && (!this.compilerEnv.isReservedKeywordAsIdentifier() || !TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective))) {
                reportError("msg.no.name.after.dot");
            }
            PropertyGet propertyGet2 = new PropertyGet(astNode, createNameNode(true, 33), i6);
            propertyGet2.setLineno(i5);
            return propertyGet2;
        }
        int iNextToken = nextToken();
        if (iNextToken != 23) {
            if (iNextToken == 39) {
                astNodePropertyName = propertyName(-1, i2);
            } else if (iNextToken != 50) {
                if (iNextToken == 128) {
                    string = this.ts.getString();
                } else if (iNextToken == 148) {
                    astNodePropertyName = attributeAccess();
                } else if (!this.compilerEnv.isReservedKeywordAsIdentifier() || (string = Token.keywordToName(iNextToken)) == null) {
                    reportError("msg.no.name.after.dot");
                    return makeErrorNode();
                }
                TokenStream tokenStream2 = this.ts;
                saveNameTokenData(tokenStream2.tokenBeg, string, tokenStream2.lineno);
                astNodePropertyName = propertyName(-1, i2);
            } else {
                TokenStream tokenStream3 = this.ts;
                i3 = tokenStream3.tokenBeg;
                i4 = tokenStream3.lineno;
                str = "throw";
            }
            z = astNodePropertyName instanceof XmlRef;
            if (z) {
                propertyGet = new XmlMemberGet();
            } else {
                propertyGet = new PropertyGet();
            }
            if (z && i == 109) {
                propertyGet.setType(109);
            }
            int position = astNode.getPosition();
            propertyGet.setPosition(position);
            propertyGet.setLength(getNodeEnd(astNodePropertyName) - position);
            propertyGet.setOperatorPosition(i6 - position);
            propertyGet.setLineno(astNode.getLineno());
            propertyGet.setLeft(astNode);
            propertyGet.setRight(astNodePropertyName);
            return propertyGet;
        }
        TokenStream tokenStream4 = this.ts;
        i3 = tokenStream4.tokenBeg;
        i4 = tokenStream4.lineno;
        str = "*";
        saveNameTokenData(i3, str, i4);
        astNodePropertyName = propertyName(-1, i2);
        z = astNodePropertyName instanceof XmlRef;
        if (z) {
            propertyGet = new XmlMemberGet();
        } else {
            propertyGet = new PropertyGet();
        }
        if (z) {
            propertyGet.setType(109);
        }
        int position2 = astNode.getPosition();
        propertyGet.setPosition(position2);
        propertyGet.setLength(getNodeEnd(astNodePropertyName) - position2);
        propertyGet.setOperatorPosition(i6 - position2);
        propertyGet.setLineno(astNode.getLineno());
        propertyGet.setLeft(astNode);
        propertyGet.setRight(astNodePropertyName);
        return propertyGet;
    }

    private AstNode propertyName(int i, int i2) {
        Name nameCreateNameNode;
        int i3;
        int i4 = i != -1 ? i : this.ts.tokenBeg;
        int i5 = this.ts.lineno;
        Name nameCreateNameNode2 = createNameNode(true, this.currentToken);
        if (matchToken(Token.COLONCOLON, true)) {
            i3 = this.ts.tokenBeg;
            int iNextToken = nextToken();
            if (iNextToken == 23) {
                TokenStream tokenStream = this.ts;
                saveNameTokenData(tokenStream.tokenBeg, "*", tokenStream.lineno);
                nameCreateNameNode = createNameNode(false, -1);
            } else {
                if (iNextToken != 39) {
                    if (iNextToken == 84) {
                        return xmlElemRef(i, nameCreateNameNode2, i3);
                    }
                    reportError("msg.no.name.after.coloncolon");
                    return makeErrorNode();
                }
                nameCreateNameNode = createNameNode();
            }
        } else {
            nameCreateNameNode2 = null;
            nameCreateNameNode = nameCreateNameNode2;
            i3 = -1;
        }
        if (nameCreateNameNode2 == null && i2 == 0 && i == -1) {
            return nameCreateNameNode;
        }
        XmlPropRef xmlPropRef = new XmlPropRef(i4, getNodeEnd(nameCreateNameNode) - i4);
        xmlPropRef.setAtPos(i);
        xmlPropRef.setNamespace(nameCreateNameNode2);
        xmlPropRef.setColonPos(i3);
        xmlPropRef.setPropName(nameCreateNameNode);
        xmlPropRef.setLineno(i5);
        return xmlPropRef;
    }

    private void recordComment(int i, String str) {
        if (this.scannedComments == null) {
            this.scannedComments = new ArrayList();
        }
        TokenStream tokenStream = this.ts;
        Comment comment = new Comment(tokenStream.tokenBeg, tokenStream.getTokenLength(), this.ts.commentType, str);
        if (this.ts.commentType == Token.CommentType.JSDOC && this.compilerEnv.isRecordingLocalJsDocComments()) {
            TokenStream tokenStream2 = this.ts;
            Comment comment2 = new Comment(tokenStream2.tokenBeg, tokenStream2.getTokenLength(), this.ts.commentType, str);
            this.currentJsDocComment = comment2;
            comment2.setLineno(i);
        }
        comment.setLineno(i);
        this.scannedComments.add(comment);
    }

    private void recordLabel(Label label, LabeledStatement labeledStatement) {
        if (peekToken() != 104) {
            codeBug();
        }
        consumeToken();
        String name = label.getName();
        Map<String, LabeledStatement> map = this.labelSet;
        if (map == null) {
            this.labelSet = new HashMap();
        } else {
            LabeledStatement labeledStatement2 = map.get(name);
            if (labeledStatement2 != null) {
                if (this.compilerEnv.isIdeMode()) {
                    Label labelByName = labeledStatement2.getLabelByName(name);
                    reportError("msg.dup.label", labelByName.getAbsolutePosition(), labelByName.getLength());
                }
                reportError("msg.dup.label", label.getPosition(), label.getLength());
            }
        }
        labeledStatement.addLabel(label);
        this.labelSet.put(name, labeledStatement);
    }

    private AstNode relExpr() {
        AstNode astNodeShiftExpr = shiftExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (iPeekToken != 52) {
                if (iPeekToken != 53) {
                    switch (iPeekToken) {
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                            break;
                        default:
                            break;
                    }
                } else {
                    continue;
                }
                consumeToken();
                astNodeShiftExpr = new InfixExpression(iPeekToken, astNodeShiftExpr, shiftExpr(), i);
            } else if (!this.inForInit) {
                consumeToken();
                astNodeShiftExpr = new InfixExpression(iPeekToken, astNodeShiftExpr, shiftExpr(), i);
            }
        }
        return astNodeShiftExpr;
    }

    private AstNode returnOrYield(int i, boolean z) {
        boolean z2;
        int nodeEnd;
        AstNode astNodeExpr;
        AstNode yield;
        if (!insideFunction()) {
            reportError(i == 4 ? "msg.bad.return" : "msg.bad.yield");
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        int i4 = tokenStream.tokenEnd;
        if (i == 73 && this.compilerEnv.getLanguageVersion() >= 200 && peekToken() == 23) {
            consumeToken();
            z2 = true;
        } else {
            z2 = false;
        }
        int iPeekTokenOrEOL = peekTokenOrEOL();
        if (iPeekTokenOrEOL == -1 || iPeekTokenOrEOL == 0 || iPeekTokenOrEOL == 1 || (iPeekTokenOrEOL == 73 ? this.compilerEnv.getLanguageVersion() < 200 : iPeekTokenOrEOL == 83 || iPeekTokenOrEOL == 85 || iPeekTokenOrEOL == 87 || iPeekTokenOrEOL == 89)) {
            nodeEnd = i4;
            astNodeExpr = null;
        } else {
            astNodeExpr = expr();
            nodeEnd = getNodeEnd(astNodeExpr);
        }
        int i5 = this.endFlags;
        if (i == 4) {
            this.endFlags = i5 | (astNodeExpr == null ? 2 : 4);
            int i6 = nodeEnd - i3;
            yield = new ReturnStatement(i3, i6, astNodeExpr);
            if (nowAllSet(i5, this.endFlags, 6)) {
                addStrictWarning("msg.return.inconsistent", "", i3, i6);
            }
        } else {
            if (!insideFunction()) {
                reportError("msg.bad.yield");
            }
            this.endFlags |= 8;
            yield = new Yield(i3, nodeEnd - i3, astNodeExpr, z2);
            setRequiresActivation();
            setIsGenerator();
            if (!z) {
                yield = new ExpressionStatement(yield);
            }
        }
        if (insideFunction() && nowAllSet(i5, this.endFlags, 12) && !((FunctionNode) this.currentScriptOrFn).isES6Generator()) {
            Name functionName = ((FunctionNode) this.currentScriptOrFn).getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                addError("msg.anon.generator.returns", "");
            } else {
                addError("msg.generator.returns", functionName.getIdentifier());
            }
        }
        yield.setLineno(i2);
        return yield;
    }

    private void saveNameTokenData(int i, String str, int i2) {
        this.prevNameTokenStart = i;
        this.prevNameTokenString = str;
        this.prevNameTokenLineno = i2;
    }

    private AstNode shiftExpr() {
        AstNode astNodeAddExpr = addExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            switch (iPeekToken) {
                case 18:
                case 19:
                case 20:
                    consumeToken();
                    astNodeAddExpr = new InfixExpression(iPeekToken, astNodeAddExpr, addExpr(), i);
                    break;
                default:
                    return astNodeAddExpr;
            }
        }
    }

    private AstNode statement() {
        int iPeekTokenOrEOL;
        int i = this.ts.tokenBeg;
        try {
            AstNode astNodeStatementHelper = statementHelper();
            if (astNodeStatementHelper != null) {
                if (this.compilerEnv.isStrictMode() && !astNodeStatementHelper.hasSideEffects()) {
                    int position = astNodeStatementHelper.getPosition();
                    int iMax = Math.max(position, lineBeginningFor(position));
                    addStrictWarning(astNodeStatementHelper instanceof EmptyStatement ? "msg.extra.trailing.semi" : "msg.no.side.effects", "", iMax, nodeEnd(astNodeStatementHelper) - iMax);
                }
                if (peekToken() == 162) {
                    int lineno = astNodeStatementHelper.getLineno();
                    List<Comment> list = this.scannedComments;
                    if (lineno == list.get(list.size() - 1).getLineno()) {
                        List<Comment> list2 = this.scannedComments;
                        astNodeStatementHelper.setInlineComment(list2.get(list2.size() - 1));
                        consumeToken();
                    }
                }
                return astNodeStatementHelper;
            }
        } catch (ParserException unused) {
        }
        do {
            iPeekTokenOrEOL = peekTokenOrEOL();
            consumeToken();
            if (iPeekTokenOrEOL == -1 || iPeekTokenOrEOL == 0 || iPeekTokenOrEOL == 1) {
                break;
            }
        } while (iPeekTokenOrEOL != 83);
        return new EmptyStatement(i, this.ts.tokenBeg - i);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:81:0x0122  */
    private AstNode statementHelper() {
        AstNode astNodeReturnOrYield;
        AstNode keywordLiteral;
        int i;
        LabeledStatement labeledStatement = this.currentLabel;
        if (labeledStatement != null && labeledStatement.getStatement() != null) {
            this.currentLabel = null;
        }
        int iPeekToken = peekToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        if (iPeekToken == -1) {
            consumeToken();
            return makeErrorNode();
        }
        if (iPeekToken == 4) {
            astNodeReturnOrYield = returnOrYield(iPeekToken, false);
        } else if (iPeekToken == 39) {
            astNodeReturnOrYield = nameOrLabel();
            if (!(astNodeReturnOrYield instanceof ExpressionStatement)) {
                return astNodeReturnOrYield;
            }
        } else if (iPeekToken == 50) {
            astNodeReturnOrYield = throwStatement();
        } else if (iPeekToken == 73) {
            astNodeReturnOrYield = returnOrYield(iPeekToken, false);
        } else {
            if (iPeekToken == 86) {
                return block();
            }
            if (iPeekToken == 110) {
                consumeToken();
                return function(3);
            }
            if (iPeekToken == 113) {
                return ifStatement();
            }
            if (iPeekToken == 115) {
                return switchStatement();
            }
            if (iPeekToken == 82) {
                return tryStatement();
            }
            if (iPeekToken == 83) {
                consumeToken();
                int i3 = this.ts.tokenBeg;
                EmptyStatement emptyStatement = new EmptyStatement(i3, this.ts.tokenEnd - i3);
                emptyStatement.setLineno(this.ts.lineno);
                return emptyStatement;
            }
            if (iPeekToken == 154) {
                astNodeReturnOrYield = letStatement();
                if (!(astNodeReturnOrYield instanceof VariableDeclaration) || peekToken() != 83) {
                    return astNodeReturnOrYield;
                }
            } else if (iPeekToken == 155) {
                consumeToken();
                TokenStream tokenStream2 = this.ts;
                int i4 = tokenStream2.lineno;
                astNodeReturnOrYield = variables(this.currentToken, tokenStream2.tokenBeg, true);
                astNodeReturnOrYield.setLineno(i4);
            } else {
                if (iPeekToken == 161) {
                    consumeToken();
                    TokenStream tokenStream3 = this.ts;
                    int i5 = tokenStream3.tokenBeg;
                    keywordLiteral = new KeywordLiteral(i5, tokenStream3.tokenEnd - i5, iPeekToken);
                    i = this.ts.lineno;
                } else {
                    if (iPeekToken == 162) {
                        List<Comment> list = this.scannedComments;
                        return list.get(list.size() - 1);
                    }
                    switch (iPeekToken) {
                        case 117:
                            astNodeReturnOrYield = defaultXmlNamespace();
                            break;
                        case 118:
                            return whileLoop();
                        case 119:
                            return doLoop();
                        case 120:
                            return forLoop();
                        case 121:
                            astNodeReturnOrYield = breakStatement();
                            break;
                        case 122:
                            astNodeReturnOrYield = continueStatement();
                            break;
                        case 123:
                            consumeToken();
                            TokenStream tokenStream4 = this.ts;
                            int i6 = tokenStream4.lineno;
                            astNodeReturnOrYield = variables(this.currentToken, tokenStream4.tokenBeg, true);
                            astNodeReturnOrYield.setLineno(i6);
                            break;
                        case 124:
                            if (this.inUseStrictDirective) {
                                reportError("msg.no.with.strict");
                            }
                            return withStatement();
                        default:
                            i = tokenStream.lineno;
                            keywordLiteral = new ExpressionStatement(expr(), true ^ insideFunction());
                            break;
                    }
                }
                keywordLiteral.setLineno(i);
                astNodeReturnOrYield = keywordLiteral;
            }
        }
        autoInsertSemicolon(astNodeReturnOrYield);
        return astNodeReturnOrYield;
    }

    private AstNode statements() {
        return statements(null);
    }

    private SwitchStatement switchStatement() {
        boolean z;
        AstNode astNodeExpr;
        if (this.currentToken != 115) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        SwitchStatement switchStatement = new SwitchStatement(i);
        if (mustMatchToken(88, "msg.no.paren.switch", true)) {
            switchStatement.setLp(this.ts.tokenBeg - i);
        }
        switchStatement.setLineno(this.ts.lineno);
        switchStatement.setExpression(expr());
        enterSwitch(switchStatement);
        try {
            if (mustMatchToken(89, "msg.no.paren.after.switch", true)) {
                switchStatement.setRp(this.ts.tokenBeg - i);
            }
            mustMatchToken(86, "msg.no.brace.switch", true);
            boolean z2 = false;
            while (true) {
                int iNextToken = nextToken();
                TokenStream tokenStream = this.ts;
                int i2 = tokenStream.tokenBeg;
                int i3 = tokenStream.lineno;
                if (iNextToken == 87) {
                    switchStatement.setLength(tokenStream.tokenEnd - i);
                    break;
                }
                if (iNextToken != 162) {
                    if (iNextToken == 116) {
                        z = z2;
                        astNodeExpr = expr();
                    } else {
                        if (iNextToken != 117) {
                            reportError("msg.bad.switch");
                            break;
                        }
                        if (z2) {
                            reportError("msg.double.switch.default");
                        }
                        astNodeExpr = null;
                        z = true;
                    }
                    mustMatchToken(104, "msg.no.colon.case", true);
                    SwitchCase switchCase = new SwitchCase(i2);
                    switchCase.setExpression(astNodeExpr);
                    switchCase.setLength(this.ts.tokenEnd - i);
                    switchCase.setLineno(i3);
                    while (true) {
                        int iPeekToken = peekToken();
                        if (iPeekToken == 87 || iPeekToken == 116 || iPeekToken == 117 || iPeekToken == 0) {
                            break;
                        }
                        if (iPeekToken == 162) {
                            List<Comment> list = this.scannedComments;
                            Comment comment = list.get(list.size() - 1);
                            if (switchCase.getInlineComment() == null && comment.getLineno() == switchCase.getLineno()) {
                                switchCase.setInlineComment(comment);
                            } else {
                                switchCase.addStatement(comment);
                            }
                            consumeToken();
                        } else {
                            switchCase.addStatement(statement());
                        }
                    }
                    switchStatement.addCase(switchCase);
                    z2 = z;
                } else {
                    List<Comment> list2 = this.scannedComments;
                    switchStatement.addChild(list2.get(list2.size() - 1));
                }
            }
            exitSwitch();
            return switchStatement;
        } catch (Throwable th) {
            exitSwitch();
            throw th;
        }
    }

    private ThrowStatement throwStatement() {
        if (this.currentToken != 50) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        int i2 = tokenStream.lineno;
        if (peekTokenOrEOL() == 1) {
            reportError("msg.bad.throw.eol");
        }
        ThrowStatement throwStatement = new ThrowStatement(i, expr());
        throwStatement.setLineno(i2);
        return throwStatement;
    }

    private TryStatement tryStatement() {
        int i;
        int i2;
        ArrayList arrayList;
        int i3;
        AstNode astNodeStatement;
        int i4;
        AstNode astNodeExpr;
        if (this.currentToken != 82) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        TokenStream tokenStream = this.ts;
        int i5 = tokenStream.tokenBeg;
        int i6 = tokenStream.lineno;
        TryStatement tryStatement = new TryStatement(i5);
        int iPeekToken = peekToken();
        if (iPeekToken == 162) {
            List<Comment> list = this.scannedComments;
            tryStatement.setInlineComment(list.get(list.size() - 1));
            consumeToken();
            iPeekToken = peekToken();
        }
        if (iPeekToken != 86) {
            reportError("msg.no.brace.try");
        }
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(tryStatement);
        int nodeEnd = getNodeEnd(nextStatementAfterInlineComments);
        int iPeekToken2 = peekToken();
        if (iPeekToken2 == 125) {
            boolean z = false;
            arrayList = null;
            for (int i7 = 125; matchToken(i7, true); i7 = 125) {
                int i8 = this.ts.lineno;
                if (z) {
                    reportError("msg.catch.unreachable");
                }
                int i9 = this.ts.tokenBeg;
                int i10 = mustMatchToken(88, "msg.no.paren.catch", true) ? this.ts.tokenBeg : -1;
                mustMatchToken(39, "msg.bad.catchcond", true);
                Name nameCreateNameNode = createNameNode();
                Comment andResetJsDoc2 = getAndResetJsDoc();
                if (andResetJsDoc2 != null) {
                    nameCreateNameNode.setJsDocNode(andResetJsDoc2);
                }
                String identifier = nameCreateNameNode.getIdentifier();
                if (this.inUseStrictDirective && ("eval".equals(identifier) || "arguments".equals(identifier))) {
                    reportError("msg.bad.id.strict", identifier);
                }
                if (matchToken(113, true)) {
                    i4 = this.ts.tokenBeg;
                    astNodeExpr = expr();
                } else {
                    z = true;
                    i4 = -1;
                    astNodeExpr = null;
                }
                int i11 = i5;
                int i12 = mustMatchToken(89, "msg.bad.catchcond", true) ? this.ts.tokenBeg : -1;
                boolean z2 = z;
                mustMatchToken(86, "msg.no.brace.catchblock", true);
                Block block = (Block) statements();
                int nodeEnd2 = getNodeEnd(block);
                CatchClause catchClause = new CatchClause(i9);
                catchClause.setVarName(nameCreateNameNode);
                catchClause.setCatchCondition(astNodeExpr);
                catchClause.setBody(block);
                if (i4 != -1) {
                    catchClause.setIfPosition(i4 - i9);
                }
                catchClause.setParens(i10, i12);
                catchClause.setLineno(i8);
                nodeEnd = mustMatchToken(87, "msg.no.brace.after.body", true) ? this.ts.tokenEnd : nodeEnd2;
                catchClause.setLength(nodeEnd - i9);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(catchClause);
                i5 = i11;
                z = z2;
            }
            i = i5;
            i2 = 126;
        } else {
            i = i5;
            i2 = 126;
            if (iPeekToken2 != 126) {
                mustMatchToken(126, "msg.try.no.catchfinally", true);
            }
            arrayList = null;
        }
        if (matchToken(i2, true)) {
            i3 = this.ts.tokenBeg;
            astNodeStatement = statement();
            nodeEnd = getNodeEnd(astNodeStatement);
        } else {
            i3 = -1;
            astNodeStatement = null;
        }
        tryStatement.setLength(nodeEnd - i);
        tryStatement.setTryBlock(nextStatementAfterInlineComments);
        tryStatement.setCatchClauses(arrayList);
        tryStatement.setFinallyBlock(astNodeStatement);
        if (i3 != -1) {
            tryStatement.setFinallyPosition(i3 - i);
        }
        tryStatement.setLineno(i6);
        if (andResetJsDoc != null) {
            tryStatement.setJsDocNode(andResetJsDoc);
        }
        return tryStatement;
    }

    private AstNode unaryExpr() {
        UnaryExpression unaryExpression;
        int iPeekToken = peekToken();
        if (iPeekToken == 162) {
            consumeToken();
            iPeekToken = peekUntilNonComment(iPeekToken);
        }
        int i = this.ts.lineno;
        if (iPeekToken == -1) {
            consumeToken();
            return makeErrorNode();
        }
        if (iPeekToken != 14) {
            if (iPeekToken != 127) {
                if (iPeekToken == 21) {
                    consumeToken();
                    unaryExpression = new UnaryExpression(28, this.ts.tokenBeg, unaryExpr());
                } else if (iPeekToken == 22) {
                    consumeToken();
                    unaryExpression = new UnaryExpression(29, this.ts.tokenBeg, unaryExpr());
                } else if (iPeekToken != 26 && iPeekToken != 27) {
                    if (iPeekToken == 31) {
                        consumeToken();
                        UnaryExpression unaryExpression2 = new UnaryExpression(iPeekToken, this.ts.tokenBeg, unaryExpr());
                        unaryExpression2.setLineno(i);
                        return unaryExpression2;
                    }
                    if (iPeekToken != 32) {
                        if (iPeekToken == 107 || iPeekToken == 108) {
                            consumeToken();
                            UnaryExpression unaryExpression3 = new UnaryExpression(iPeekToken, this.ts.tokenBeg, memberExpr(true));
                            unaryExpression3.setLineno(i);
                            checkBadIncDec(unaryExpression3);
                            return unaryExpression3;
                        }
                    }
                }
                unaryExpression.setLineno(i);
                return unaryExpression;
            }
            consumeToken();
            UnaryExpression unaryExpression4 = new UnaryExpression(iPeekToken, this.ts.tokenBeg, unaryExpr());
            unaryExpression4.setLineno(i);
            return unaryExpression4;
        }
        if (this.compilerEnv.isXmlAvailable()) {
            consumeToken();
            return memberExprTail(true, xmlInitializer());
        }
        AstNode astNodeMemberExpr = memberExpr(true);
        int iPeekTokenOrEOL = peekTokenOrEOL();
        if (iPeekTokenOrEOL != 107 && iPeekTokenOrEOL != 108) {
            return astNodeMemberExpr;
        }
        consumeToken();
        UnaryExpression unaryExpression5 = new UnaryExpression(iPeekTokenOrEOL, this.ts.tokenBeg, astNodeMemberExpr, true);
        unaryExpression5.setLineno(i);
        checkBadIncDec(unaryExpression5);
        return unaryExpression5;
    }

    private VariableDeclaration variables(int i, int i2, boolean z) {
        AstNode astNodeDestructuringPrimaryExpr;
        int nodeEnd;
        Name name;
        VariableDeclaration variableDeclaration = new VariableDeclaration(i2);
        variableDeclaration.setType(i);
        variableDeclaration.setLineno(this.ts.lineno);
        Comment andResetJsDoc = getAndResetJsDoc();
        if (andResetJsDoc != null) {
            variableDeclaration.setJsDocNode(andResetJsDoc);
        }
        do {
            int iPeekToken = peekToken();
            TokenStream tokenStream = this.ts;
            int i3 = tokenStream.tokenBeg;
            int i4 = tokenStream.tokenEnd;
            AstNode astNodeAssignExpr = null;
            if (iPeekToken == 84 || iPeekToken == 86) {
                astNodeDestructuringPrimaryExpr = destructuringPrimaryExpr();
                int nodeEnd2 = getNodeEnd(astNodeDestructuringPrimaryExpr);
                if (!(astNodeDestructuringPrimaryExpr instanceof DestructuringForm)) {
                    reportError("msg.bad.assign.left", i3, nodeEnd2 - i3);
                }
                markDestructuring(astNodeDestructuringPrimaryExpr);
                nodeEnd = nodeEnd2;
                name = null;
            } else {
                mustMatchToken(39, "msg.bad.var", true);
                Name nameCreateNameNode = createNameNode();
                nameCreateNameNode.setLineno(this.ts.getLineno());
                if (this.inUseStrictDirective) {
                    String string = this.ts.getString();
                    if ("eval".equals(string) || "arguments".equals(this.ts.getString())) {
                        reportError("msg.bad.id.strict", string);
                    }
                }
                defineSymbol(i, this.ts.getString(), this.inForInit);
                nodeEnd = i4;
                name = nameCreateNameNode;
                astNodeDestructuringPrimaryExpr = null;
            }
            int i5 = this.ts.lineno;
            Comment andResetJsDoc2 = getAndResetJsDoc();
            if (matchToken(91, true)) {
                astNodeAssignExpr = assignExpr();
                nodeEnd = getNodeEnd(astNodeAssignExpr);
            }
            VariableInitializer variableInitializer = new VariableInitializer(i3, nodeEnd - i3);
            if (astNodeDestructuringPrimaryExpr != null) {
                if (astNodeAssignExpr == null && !this.inForInit) {
                    reportError("msg.destruct.assign.no.init");
                }
                variableInitializer.setTarget(astNodeDestructuringPrimaryExpr);
            } else {
                variableInitializer.setTarget(name);
            }
            variableInitializer.setInitializer(astNodeAssignExpr);
            variableInitializer.setType(i);
            variableInitializer.setJsDocNode(andResetJsDoc2);
            variableInitializer.setLineno(i5);
            variableDeclaration.addVariable(variableInitializer);
        } while (matchToken(90, true));
        variableDeclaration.setLength(nodeEnd - i2);
        variableDeclaration.setIsStatement(z);
        return variableDeclaration;
    }

    private void warnMissingSemi(int i, int i2) {
        if (this.compilerEnv.isStrictMode()) {
            int[] iArr = new int[2];
            String line = this.ts.getLine(i2, iArr);
            if (this.compilerEnv.isIdeMode()) {
                i = Math.max(i, i2 - iArr[1]);
            }
            int i3 = i;
            if (line != null) {
                addStrictWarning("msg.missing.semi", "", i3, i2 - i3, iArr[0], line, iArr[1]);
            } else {
                addStrictWarning("msg.missing.semi", "", i3, i2 - i3);
            }
        }
    }

    private void warnTrailingComma(int i, List<?> list, int i2) {
        if (this.compilerEnv.getWarnTrailingComma()) {
            if (!list.isEmpty()) {
                i = ((AstNode) list.get(0)).getPosition();
            }
            int iMax = Math.max(i, lineBeginningFor(i2));
            addWarning("msg.extra.trailing.comma", iMax, i2 - iMax);
        }
    }

    private WhileLoop whileLoop() {
        if (this.currentToken != 118) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        WhileLoop whileLoop = new WhileLoop(i);
        whileLoop.setLineno(this.ts.lineno);
        enterLoop(whileLoop);
        try {
            ConditionData conditionDataCondition = condition();
            whileLoop.setCondition(conditionDataCondition.condition);
            whileLoop.setParens(conditionDataCondition.lp - i, conditionDataCondition.rp - i);
            AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(whileLoop);
            whileLoop.setLength(getNodeEnd(nextStatementAfterInlineComments) - i);
            whileLoop.setBody(nextStatementAfterInlineComments);
            return whileLoop;
        } finally {
            exitLoop();
        }
    }

    private WithStatement withStatement() {
        if (this.currentToken != 124) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        int i3 = mustMatchToken(88, "msg.no.paren.with", true) ? this.ts.tokenBeg : -1;
        AstNode astNodeExpr = expr();
        int i4 = mustMatchToken(89, "msg.no.paren.after.with", true) ? this.ts.tokenBeg : -1;
        WithStatement withStatement = new WithStatement(i2);
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(withStatement);
        withStatement.setLength(getNodeEnd(nextStatementAfterInlineComments) - i2);
        withStatement.setJsDocNode(andResetJsDoc);
        withStatement.setExpression(astNodeExpr);
        withStatement.setStatement(nextStatementAfterInlineComments);
        withStatement.setParens(i3, i4);
        withStatement.setLineno(i);
        return withStatement;
    }

    private XmlElemRef xmlElemRef(int i, Name name, int i2) {
        int i3 = this.ts.tokenBeg;
        int i4 = -1;
        int i5 = i != -1 ? i : i3;
        AstNode astNodeExpr = expr();
        int nodeEnd = getNodeEnd(astNodeExpr);
        if (mustMatchToken(85, "msg.no.bracket.index", true)) {
            TokenStream tokenStream = this.ts;
            i4 = tokenStream.tokenBeg;
            nodeEnd = tokenStream.tokenEnd;
        }
        XmlElemRef xmlElemRef = new XmlElemRef(i5, nodeEnd - i5);
        xmlElemRef.setNamespace(name);
        xmlElemRef.setColonPos(i2);
        xmlElemRef.setAtPos(i);
        xmlElemRef.setExpression(astNodeExpr);
        xmlElemRef.setBrackets(i3, i4);
        return xmlElemRef;
    }

    private AstNode xmlInitializer() {
        if (this.currentToken != 14) {
            codeBug();
        }
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        int firstXMLToken = tokenStream.getFirstXMLToken();
        if (firstXMLToken == 146 || firstXMLToken == 149) {
            XmlLiteral xmlLiteral = new XmlLiteral(i);
            xmlLiteral.setLineno(this.ts.lineno);
            while (firstXMLToken == 146) {
                TokenStream tokenStream2 = this.ts;
                xmlLiteral.addFragment(new XmlString(tokenStream2.tokenBeg, tokenStream2.getString()));
                mustMatchToken(86, "msg.syntax", true);
                int i2 = this.ts.tokenBeg;
                AstNode emptyExpression = peekToken() == 87 ? new EmptyExpression(i2, this.ts.tokenEnd - i2) : expr();
                mustMatchToken(87, "msg.syntax", true);
                XmlExpression xmlExpression = new XmlExpression(i2, emptyExpression);
                xmlExpression.setIsXmlAttribute(this.ts.isXMLAttribute());
                xmlExpression.setLength(this.ts.tokenEnd - i2);
                xmlLiteral.addFragment(xmlExpression);
                firstXMLToken = this.ts.getNextXMLToken();
            }
            if (firstXMLToken == 149) {
                TokenStream tokenStream3 = this.ts;
                xmlLiteral.addFragment(new XmlString(tokenStream3.tokenBeg, tokenStream3.getString()));
                return xmlLiteral;
            }
        }
        reportError("msg.syntax");
        return makeErrorNode();
    }

    void addError(String str) {
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        addError(str, i, tokenStream.tokenEnd - i);
    }

    void addStrictWarning(String str, String str2) {
        int i;
        int i2;
        TokenStream tokenStream = this.ts;
        if (tokenStream != null) {
            i = tokenStream.tokenBeg;
            i2 = tokenStream.tokenEnd - i;
        } else {
            i = -1;
            i2 = -1;
        }
        addStrictWarning(str, str2, i, i2);
    }

    void addWarning(String str, int i, int i2) {
        addWarning(str, null, i, i2);
    }

    protected void checkActivationName(String str, int i) {
        if (insideFunction()) {
            if ((!"arguments".equals(str) || ((FunctionNode) this.currentScriptOrFn).getFunctionType() == 4) && ((this.compilerEnv.getActivationNames() == null || !this.compilerEnv.getActivationNames().contains(str)) && !(Analytics.Data.LENGTH.equals(str) && i == 33 && this.compilerEnv.getLanguageVersion() == 120))) {
                return;
            }
            setRequiresActivation();
        }
    }

    protected void checkMutableReference(Node node) {
        if ((node.getIntProp(16, 0) & 4) != 0) {
            reportError("msg.bad.assign.left");
        }
    }

    Node createDestructuringAssignment(int i, Node node, Node node2) {
        String nextTempName = this.currentScriptOrFn.getNextTempName();
        Node nodeDestructuringAssignmentHelper = destructuringAssignmentHelper(i, node, node2, nextTempName);
        nodeDestructuringAssignmentHelper.getLastChild().addChildToBack(createName(nextTempName));
        return nodeDestructuringAssignmentHelper;
    }

    protected Node createName(int i, String str, Node node) {
        Node nodeCreateName = createName(str);
        nodeCreateName.setType(i);
        if (node != null) {
            nodeCreateName.addChildToBack(node);
        }
        return nodeCreateName;
    }

    protected Node createNumber(double d) {
        return Node.newNumber(d);
    }

    protected Scope createScopeNode(int i, int i2) {
        Scope scope = new Scope();
        scope.setType(i);
        scope.setLineno(i2);
        return scope;
    }

    void defineSymbol(int i, String str) {
        defineSymbol(i, str, false);
    }

    boolean destructuringArray(ArrayLiteral arrayLiteral, int i, String str, Node node, List<String> list) {
        int i2 = i == 155 ? Token.SETCONST : 8;
        int i3 = 0;
        boolean z = true;
        for (AstNode astNode : arrayLiteral.getElements()) {
            if (astNode.getType() == 129) {
                i3++;
            } else {
                Node node2 = new Node(36, createName(str), createNumber(i3));
                if (astNode.getType() == 39) {
                    String string = astNode.getString();
                    node.addChildToBack(new Node(i2, createName(49, string, null), node2));
                    if (i != -1) {
                        defineSymbol(i, string, true);
                        list.add(string);
                    }
                } else {
                    node.addChildToBack(destructuringAssignmentHelper(i, astNode, node2, this.currentScriptOrFn.getNextTempName()));
                }
                i3++;
                z = false;
            }
        }
        return z;
    }

    Node destructuringAssignmentHelper(int i, Node node, Node node2, String str) {
        Parser parser;
        Scope scopeCreateScopeNode = createScopeNode(Token.LETEXPR, node.getLineno());
        scopeCreateScopeNode.addChildToFront(new Node(Token.LET, createName(39, str, node2)));
        try {
            pushScope(scopeCreateScopeNode);
            boolean zDestructuringArray = true;
            defineSymbol(Token.LET, str, true);
            popScope();
            Node node3 = new Node(90);
            scopeCreateScopeNode.addChildToBack(node3);
            ArrayList arrayList = new ArrayList();
            int type = node.getType();
            if (type == 33 || type == 36) {
                parser = this;
                if (i == 123 || i == 154 || i == 155) {
                    parser.reportError("msg.bad.assign.left");
                }
                node3.addChildToBack(parser.simpleAssignment(node, parser.createName(str)));
            } else if (type == 66) {
                parser = this;
                zDestructuringArray = parser.destructuringArray((ArrayLiteral) node, i, str, node3, arrayList);
            } else if (type != 67) {
                reportError("msg.bad.assign.left");
                parser = this;
            } else {
                parser = this;
                zDestructuringArray = parser.destructuringObject((ObjectLiteral) node, i, str, node3, arrayList);
            }
            if (zDestructuringArray) {
                node3.addChildToBack(parser.createNumber(0.0d));
            }
            scopeCreateScopeNode.putProp(22, arrayList);
            return scopeCreateScopeNode;
        } catch (Throwable th) {
            popScope();
            throw th;
        }
    }

    boolean destructuringObject(ObjectLiteral objectLiteral, int i, String str, Node node, List<String> list) {
        Node node2;
        int i2 = i == 155 ? Token.SETCONST : 8;
        boolean z = true;
        for (ObjectProperty objectProperty : objectLiteral.getElements()) {
            TokenStream tokenStream = this.ts;
            int i3 = tokenStream != null ? tokenStream.lineno : 0;
            AstNode left = objectProperty.getLeft();
            if (left instanceof Name) {
                node2 = new Node(33, createName(str), Node.newString(((Name) left).getIdentifier()));
            } else if (left instanceof StringLiteral) {
                node2 = new Node(33, createName(str), Node.newString(((StringLiteral) left).getValue()));
            } else {
                if (!(left instanceof NumberLiteral)) {
                    throw codeBug();
                }
                node2 = new Node(36, createName(str), createNumber((int) ((NumberLiteral) left).getNumber()));
            }
            node2.setLineno(i3);
            AstNode right = objectProperty.getRight();
            if (right.getType() == 39) {
                String identifier = ((Name) right).getIdentifier();
                node.addChildToBack(new Node(i2, createName(49, identifier, null), node2));
                if (i != -1) {
                    defineSymbol(i, identifier, true);
                    list.add(identifier);
                }
            } else {
                node.addChildToBack(destructuringAssignmentHelper(i, right, node2, this.currentScriptOrFn.getNextTempName()));
            }
            z = false;
        }
        return z;
    }

    public boolean eof() {
        return this.ts.eof();
    }

    public boolean inUseStrictDirective() {
        return this.inUseStrictDirective;
    }

    boolean insideFunction() {
        return this.nestingOfFunction != 0;
    }

    String lookupMessage(String str) {
        return lookupMessage(str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void markDestructuring(AstNode astNode) {
        if (astNode instanceof DestructuringForm) {
            ((DestructuringForm) astNode).setIsDestructuring(true);
        } else if (astNode instanceof ParenthesizedExpression) {
            markDestructuring(((ParenthesizedExpression) astNode).getExpression());
        }
    }

    void popScope() {
        this.currentScope = this.currentScope.getParentScope();
    }

    void pushScope(Scope scope) {
        Scope parentScope = scope.getParentScope();
        if (parentScope == null) {
            this.currentScope.addChildScope(scope);
        } else if (parentScope != this.currentScope) {
            codeBug();
        }
        this.currentScope = scope;
    }

    protected AstNode removeParens(AstNode astNode) {
        while (astNode instanceof ParenthesizedExpression) {
            astNode = ((ParenthesizedExpression) astNode).getExpression();
        }
        return astNode;
    }

    void reportError(String str) {
        reportError(str, null);
    }

    public void setDefaultUseStrictDirective(boolean z) {
        this.defaultUseStrictDirective = z;
    }

    protected void setIsGenerator() {
        if (insideFunction()) {
            ((FunctionNode) this.currentScriptOrFn).setIsGenerator();
        }
    }

    protected void setRequiresActivation() {
        if (insideFunction()) {
            ((FunctionNode) this.currentScriptOrFn).setRequiresActivation();
        }
    }

    protected Node simpleAssignment(Node node, Node node2) {
        Node firstChild;
        Node lastChild;
        int i;
        int type = node.getType();
        if (type != 33 && type != 36) {
            if (type != 39) {
                if (type != 68) {
                    throw codeBug();
                }
                Node firstChild2 = node.getFirstChild();
                checkMutableReference(firstChild2);
                return new Node(69, firstChild2, node2);
            }
            String identifier = ((Name) node).getIdentifier();
            if (this.inUseStrictDirective && ("eval".equals(identifier) || "arguments".equals(identifier))) {
                reportError("msg.bad.id.strict", identifier);
            }
            node.setType(49);
            return new Node(8, node, node2);
        }
        if (node instanceof PropertyGet) {
            PropertyGet propertyGet = (PropertyGet) node;
            firstChild = propertyGet.getTarget();
            lastChild = propertyGet.getProperty();
        } else if (node instanceof ElementGet) {
            ElementGet elementGet = (ElementGet) node;
            firstChild = elementGet.getTarget();
            lastChild = elementGet.getElement();
        } else {
            firstChild = node.getFirstChild();
            lastChild = node.getLastChild();
        }
        if (type == 33) {
            lastChild.setType(41);
            i = 35;
        } else {
            i = 37;
        }
        return new Node(i, firstChild, lastChild, node2);
    }

    public Parser(CompilerEnvirons compilerEnvirons) {
        this(compilerEnvirons, compilerEnvirons.getErrorReporter());
    }

    private Name createNameNode(boolean z, int i) {
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        String string = tokenStream.getString();
        int i3 = this.ts.lineno;
        String str = "";
        if (!"".equals(this.prevNameTokenString)) {
            i2 = this.prevNameTokenStart;
            string = this.prevNameTokenString;
            i3 = this.prevNameTokenLineno;
            this.prevNameTokenStart = 0;
            this.prevNameTokenString = "";
            this.prevNameTokenLineno = 0;
        }
        if (string != null) {
            str = string;
        } else if (!this.compilerEnv.isIdeMode()) {
            codeBug();
            str = string;
        }
        Name name = new Name(i2, str);
        name.setLineno(i3);
        if (z) {
            checkActivationName(str, i);
        }
        return name;
    }

    private FunctionNode function(int i, boolean z) {
        Name nameCreateNameNode;
        AstNode astNodeMemberExpr;
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        AstNode astNode = null;
        if (matchToken(39, true)) {
            nameCreateNameNode = createNameNode(true, 39);
            if (this.inUseStrictDirective) {
                String identifier = nameCreateNameNode.getIdentifier();
                if ("eval".equals(identifier) || "arguments".equals(identifier)) {
                    reportError("msg.bad.id.strict", identifier);
                }
            }
            if (!matchToken(88, true)) {
                if (this.compilerEnv.isAllowMemberExprAsFunctionName()) {
                    astNodeMemberExpr = memberExprTail(false, nameCreateNameNode);
                    astNode = astNodeMemberExpr;
                    nameCreateNameNode = null;
                }
                mustMatchToken(88, "msg.no.paren.parms", true);
            }
        } else if (matchToken(88, true)) {
            nameCreateNameNode = null;
        } else {
            if (matchToken(23, true) && this.compilerEnv.getLanguageVersion() >= 200) {
                return function(i, true);
            }
            if (this.compilerEnv.isAllowMemberExprAsFunctionName()) {
                astNodeMemberExpr = memberExpr(false);
                astNode = astNodeMemberExpr;
                nameCreateNameNode = null;
            } else {
                nameCreateNameNode = null;
            }
            mustMatchToken(88, "msg.no.paren.parms", true);
        }
        int i4 = this.currentToken == 88 ? this.ts.tokenBeg : -1;
        if ((astNode != null ? 2 : i) != 2 && nameCreateNameNode != null && nameCreateNameNode.length() > 0) {
            defineSymbol(110, nameCreateNameNode.getIdentifier());
        }
        FunctionNode functionNode = new FunctionNode(i3, nameCreateNameNode);
        functionNode.setFunctionType(i);
        if (z) {
            functionNode.setIsES6Generator();
        }
        if (i4 != -1) {
            functionNode.setLp(i4 - i3);
        }
        functionNode.setJsDocNode(getAndResetJsDoc());
        PerFunctionVariables perFunctionVariables = new PerFunctionVariables(functionNode);
        try {
            parseFunctionParams(functionNode);
            functionNode.setBody(parseFunctionBody(i, functionNode));
            functionNode.setEncodedSourceBounds(i3, this.ts.tokenEnd);
            functionNode.setLength(this.ts.tokenEnd - i3);
            if (this.compilerEnv.isStrictMode() && !functionNode.getBody().hasConsistentReturnUsage()) {
                addStrictWarning((nameCreateNameNode == null || nameCreateNameNode.length() <= 0) ? "msg.anon.no.return.value" : "msg.no.return.value", nameCreateNameNode == null ? "" : nameCreateNameNode.getIdentifier());
            }
            perFunctionVariables.restore();
            if (astNode != null) {
                Kit.codeBug();
                functionNode.setMemberExprNode(astNode);
            }
            functionNode.setSourceName(this.sourceURI);
            functionNode.setBaseLineno(i2);
            functionNode.setEndLineno(this.ts.lineno);
            if (this.compilerEnv.isIdeMode()) {
                functionNode.setParentScope(this.currentScope);
            }
            return functionNode;
        } catch (Throwable th) {
            perFunctionVariables.restore();
            throw th;
        }
    }

    private AstNode generatorExpression(AstNode astNode, int i, boolean z) {
        int i2;
        ConditionData conditionDataCondition;
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 120) {
            arrayList.add(generatorExpressionLoop());
        }
        if (peekToken() == 113) {
            consumeToken();
            i2 = this.ts.tokenBeg - i;
            conditionDataCondition = condition();
        } else {
            i2 = -1;
            conditionDataCondition = null;
        }
        if (!z) {
            mustMatchToken(89, "msg.no.paren.let", true);
        }
        GeneratorExpression generatorExpression = new GeneratorExpression(i, this.ts.tokenEnd - i);
        generatorExpression.setResult(astNode);
        generatorExpression.setLoops(arrayList);
        if (conditionDataCondition != null) {
            generatorExpression.setIfPosition(i2);
            generatorExpression.setFilter(conditionDataCondition.condition);
            generatorExpression.setFilterLp(conditionDataCondition.lp - i);
            generatorExpression.setFilterRp(conditionDataCondition.rp - i);
        }
        return generatorExpression;
    }

    private boolean mustMatchToken(int i, String str, boolean z) {
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        return mustMatchToken(i, str, i2, tokenStream.tokenEnd - i2, z);
    }

    private AstNode statements(AstNode astNode) {
        if (this.currentToken != 86 && !this.compilerEnv.isIdeMode()) {
            codeBug();
        }
        int i = this.ts.tokenBeg;
        if (astNode == null) {
            astNode = new Block(i);
        }
        astNode.setLineno(this.ts.lineno);
        while (true) {
            int iPeekToken = peekToken();
            if (iPeekToken <= 0 || iPeekToken == 87) {
                break;
            }
            astNode.addChild(statement());
        }
        astNode.setLength(this.ts.tokenBeg - i);
        return astNode;
    }

    void addError(String str, int i) {
        String string = Character.toString((char) i);
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        addError(str, string, i2, tokenStream.tokenEnd - i2);
    }

    void addStrictWarning(String str, String str2, int i, int i2) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i, i2);
        }
    }

    void addWarning(String str, String str2) {
        int i;
        int i2;
        TokenStream tokenStream = this.ts;
        if (tokenStream != null) {
            i = tokenStream.tokenBeg;
            i2 = tokenStream.tokenEnd - i;
        } else {
            i = -1;
            i2 = -1;
        }
        addWarning(str, str2, i, i2);
    }

    protected Node createName(String str) {
        checkActivationName(str, 39);
        return Node.newString(39, str);
    }

    void defineSymbol(int i, String str, boolean z) {
        if (str == null) {
            if (this.compilerEnv.isIdeMode()) {
                return;
            } else {
                codeBug();
            }
        }
        Scope definingScope = this.currentScope.getDefiningScope(str);
        external.sdk.pendo.io.mozilla.javascript.ast.Symbol symbol = definingScope != null ? definingScope.getSymbol(str) : null;
        int declType = symbol != null ? symbol.getDeclType() : -1;
        String str2 = "msg.var.redecl";
        if (symbol != null && (declType == 155 || i == 155 || (definingScope == this.currentScope && declType == 154))) {
            if (declType == 155) {
                str2 = "msg.const.redecl";
            } else if (declType == 154) {
                str2 = "msg.let.redecl";
            } else if (declType != 123) {
                str2 = declType == 110 ? "msg.fn.redecl" : "msg.parm.redecl";
            }
            addError(str2, str);
            return;
        }
        if (i == 88) {
            if (symbol != null) {
                addWarning("msg.dup.parms", str);
            }
            this.currentScriptOrFn.putSymbol(new external.sdk.pendo.io.mozilla.javascript.ast.Symbol(i, str));
            return;
        }
        if (i != 110 && i != 123) {
            if (i == 154) {
                if (z || !(this.currentScope.getType() == 113 || (this.currentScope instanceof Loop))) {
                    this.currentScope.putSymbol(new external.sdk.pendo.io.mozilla.javascript.ast.Symbol(i, str));
                    return;
                } else {
                    addError("msg.let.decl.not.in.block");
                    return;
                }
            }
            if (i != 155) {
                throw codeBug();
            }
        }
        if (symbol == null) {
            this.currentScriptOrFn.putSymbol(new external.sdk.pendo.io.mozilla.javascript.ast.Symbol(i, str));
        } else if (declType == 123) {
            addStrictWarning("msg.var.redecl", str);
        } else if (declType == 88) {
            addStrictWarning("msg.var.hides.arg", str);
        }
    }

    String lookupMessage(String str, String str2) {
        return str2 == null ? ScriptRuntime.getMessage0(str) : ScriptRuntime.getMessage1(str, str2);
    }

    @Deprecated
    public AstRoot parse(Reader reader, String str, int i) {
        if (this.parseFinished) {
            throw new IllegalStateException("parser reused");
        }
        if (this.compilerEnv.isIdeMode()) {
            return parse(Kit.readReader(reader), str, i);
        }
        try {
            this.sourceURI = str;
            this.ts = new TokenStream(this, reader, null, i);
            return parse();
        } finally {
            this.parseFinished = true;
        }
    }

    void reportError(String str, int i, int i2) {
        reportError(str, null, i, i2);
    }

    public Parser(CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter) {
        this.currentFlaggedToken = 0;
        this.prevNameTokenString = "";
        this.compilerEnv = compilerEnvirons;
        this.errorReporter = errorReporter;
        if (errorReporter instanceof IdeErrorReporter) {
            this.errorCollector = (IdeErrorReporter) errorReporter;
        }
    }

    private void addStrictWarning(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i, i2, i3, str3, i4);
        }
    }

    void addError(String str, int i, int i2) {
        addError(str, null, i, i2);
    }

    void addWarning(String str, String str2, int i, int i2) {
        String strLookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i, i2);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(strLookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.warning(strLookupMessage, this.sourceURI, this.ts.getLineno(), this.ts.getLine(), this.ts.getOffset());
        }
    }

    public AstRoot parse(String str, String str2, int i) {
        if (this.parseFinished) {
            throw new IllegalStateException("parser reused");
        }
        this.sourceURI = str2;
        if (this.compilerEnv.isIdeMode()) {
            this.sourceChars = str.toCharArray();
        }
        this.ts = new TokenStream(this, null, str, i);
        try {
            try {
                AstRoot astRoot = parse();
                this.parseFinished = true;
                return astRoot;
            } catch (IOException unused) {
                throw new IllegalStateException();
            }
        } catch (Throwable th) {
            this.parseFinished = true;
            throw th;
        }
    }

    void reportError(String str, String str2) {
        TokenStream tokenStream = this.ts;
        if (tokenStream == null) {
            reportError(str, str2, 1, 1);
        } else {
            int i = tokenStream.tokenBeg;
            reportError(str, str2, i, tokenStream.tokenEnd - i);
        }
    }

    private void addWarning(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        String strLookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i, i2, i3, str3, i4);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(strLookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.warning(strLookupMessage, this.sourceURI, i3, str3, i4);
        }
    }

    void addError(String str, String str2) {
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        addError(str, str2, i, tokenStream.tokenEnd - i);
    }

    void reportError(String str, String str2, int i, int i2) {
        addError(str, str2, i, i2);
        if (!this.compilerEnv.recoverFromErrors()) {
            throw new ParserException();
        }
    }

    void addError(String str, String str2, int i, int i2) {
        String line;
        int i3;
        int offset;
        this.syntaxErrorCount++;
        String strLookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(strLookupMessage, this.sourceURI, i, i2);
            return;
        }
        TokenStream tokenStream = this.ts;
        if (tokenStream != null) {
            int lineno = tokenStream.getLineno();
            line = this.ts.getLine();
            offset = this.ts.getOffset();
            i3 = lineno;
        } else {
            line = "";
            i3 = 1;
            offset = 1;
        }
        this.errorReporter.error(strLookupMessage, this.sourceURI, i3, line, offset);
    }

    private void addError(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        this.syntaxErrorCount++;
        String strLookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(strLookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.error(strLookupMessage, this.sourceURI, i3, str3, i4);
        }
    }
}
