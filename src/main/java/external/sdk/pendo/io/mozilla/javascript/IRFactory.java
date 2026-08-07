package external.sdk.pendo.io.mozilla.javascript;

import com.j256.ormlite.stmt.query.SimpleComparison;
import external.sdk.pendo.io.mozilla.javascript.ast.ArrayComprehension;
import external.sdk.pendo.io.mozilla.javascript.ast.ArrayComprehensionLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.ArrayLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.Assignment;
import external.sdk.pendo.io.mozilla.javascript.ast.AstNode;
import external.sdk.pendo.io.mozilla.javascript.ast.AstRoot;
import external.sdk.pendo.io.mozilla.javascript.ast.Block;
import external.sdk.pendo.io.mozilla.javascript.ast.BreakStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.CatchClause;
import external.sdk.pendo.io.mozilla.javascript.ast.ConditionalExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.ContinueStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.DestructuringForm;
import external.sdk.pendo.io.mozilla.javascript.ast.DoLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.ElementGet;
import external.sdk.pendo.io.mozilla.javascript.ast.EmptyExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.ExpressionStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.ForInLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.ForLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionCall;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode;
import external.sdk.pendo.io.mozilla.javascript.ast.GeneratorExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.GeneratorExpressionLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.IfStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.InfixExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.Jump;
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
import external.sdk.pendo.io.mozilla.javascript.ast.XmlFragment;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlMemberGet;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlPropRef;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlRef;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlString;
import external.sdk.pendo.io.mozilla.javascript.ast.Yield;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class IRFactory extends Parser {
    private static final int ALWAYS_FALSE_BOOLEAN = -1;
    private static final int ALWAYS_TRUE_BOOLEAN = 1;
    private static final int LOOP_DO_WHILE = 0;
    private static final int LOOP_FOR = 2;
    private static final int LOOP_WHILE = 1;
    private Decompiler decompiler;

    public IRFactory() {
        this.decompiler = new Decompiler();
    }

    private static void addSwitchCase(Node node, Node node2, Node node3) {
        if (node.getType() != 130) {
            throw Kit.codeBug();
        }
        Jump jump = (Jump) node.getFirstChild();
        if (jump.getType() != 115) {
            throw Kit.codeBug();
        }
        Node nodeNewTarget = Node.newTarget();
        if (node2 != null) {
            Jump jump2 = new Jump(116, node2);
            jump2.target = nodeNewTarget;
            jump.addChildToBack(jump2);
        } else {
            jump.setDefault(nodeNewTarget);
        }
        node.addChildToBack(nodeNewTarget);
        node.addChildToBack(node3);
    }

    private Node arrayCompTransformHelper(ArrayComprehension arrayComprehension, String str) throws Throwable {
        String string;
        this.decompiler.addToken(84);
        int lineno = arrayComprehension.getLineno();
        Node nodeTransform = transform(arrayComprehension.getResult());
        List<ArrayComprehensionLoop> loops = arrayComprehension.getLoops();
        int size = loops.size();
        Node[] nodeArr = new Node[size];
        Node[] nodeArr2 = new Node[size];
        int i = 0;
        Node nodeCreateBinary = nodeTransform;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayComprehensionLoop arrayComprehensionLoop = loops.get(i2);
            this.decompiler.addName(" ");
            this.decompiler.addToken(120);
            if (arrayComprehensionLoop.isForEach()) {
                this.decompiler.addName("each ");
            }
            this.decompiler.addToken(88);
            AstNode iterator = arrayComprehensionLoop.getIterator();
            if (iterator.getType() == 39) {
                string = iterator.getString();
                this.decompiler.addName(string);
            } else {
                decompile(iterator);
                String nextTempName = this.currentScriptOrFn.getNextTempName();
                defineSymbol(88, nextTempName, false);
                nodeCreateBinary = createBinary(90, createAssignment(91, iterator, createName(nextTempName)), nodeCreateBinary);
                string = nextTempName;
            }
            Node nodeCreateName = createName(string);
            defineSymbol(Token.LET, string, false);
            nodeArr[i2] = nodeCreateName;
            if (arrayComprehensionLoop.isForOf()) {
                this.decompiler.addName("of ");
            } else {
                this.decompiler.addToken(52);
            }
            nodeArr2[i2] = transform(arrayComprehensionLoop.getIteratedObject());
            this.decompiler.addToken(89);
        }
        Node nodeCreateCallOrNew = createCallOrNew(38, createPropertyGet(createName(str), null, "push", 0));
        Node node = new Node(134, nodeCreateCallOrNew, lineno);
        if (arrayComprehension.getFilter() != null) {
            this.decompiler.addName(" ");
            this.decompiler.addToken(113);
            this.decompiler.addToken(88);
            node = createIf(transform(arrayComprehension.getFilter()), node, null, lineno);
            this.decompiler.addToken(89);
        }
        Node nodeCreateForIn = node;
        int i3 = size - 1;
        int i4 = 0;
        while (i3 >= 0) {
            try {
                ArrayComprehensionLoop arrayComprehensionLoop2 = loops.get(i3);
                Scope scopeCreateLoopNode = createLoopNode(null, arrayComprehensionLoop2.getLineno());
                pushScope(scopeCreateLoopNode);
                int i5 = i4 + 1;
                try {
                    nodeCreateForIn = createForIn(Token.LET, scopeCreateLoopNode, nodeArr[i3], nodeArr2[i3], nodeCreateForIn, arrayComprehensionLoop2.isForEach(), arrayComprehensionLoop2.isForOf());
                    i3--;
                    i4 = i5;
                } catch (Throwable th) {
                    th = th;
                    i4 = i5;
                    while (i < i4) {
                        popScope();
                        i++;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        while (i < i4) {
            popScope();
            i++;
        }
        this.decompiler.addToken(85);
        nodeCreateCallOrNew.addChildToBack(nodeCreateBinary);
        return nodeCreateForIn;
    }

    private static void closeSwitch(Node node) {
        if (node.getType() != 130) {
            throw Kit.codeBug();
        }
        Jump jump = (Jump) node.getFirstChild();
        if (jump.getType() != 115) {
            throw Kit.codeBug();
        }
        Node nodeNewTarget = Node.newTarget();
        jump.target = nodeNewTarget;
        Node node2 = jump.getDefault();
        if (node2 == null) {
            node2 = nodeNewTarget;
        }
        node.addChildAfter(makeJump(5, node2), jump);
        node.addChildToBack(nodeNewTarget);
    }

    private Node createAssignment(int i, Node node, Node node2) {
        int i2;
        String str;
        Node nodeMakeReference = makeReference(node);
        if (nodeMakeReference == null) {
            if (node.getType() != 66 && node.getType() != 67) {
                str = "msg.bad.assign.left";
            } else {
                if (i == 91) {
                    return createDestructuringAssignment(-1, node, node2);
                }
                str = "msg.bad.destruct.op";
            }
            reportError(str);
            return node2;
        }
        switch (i) {
            case 91:
                return simpleAssignment(nodeMakeReference, node2);
            case 92:
                i2 = 9;
                break;
            case 93:
                i2 = 10;
                break;
            case 94:
                i2 = 11;
                break;
            case 95:
                i2 = 18;
                break;
            case 96:
                i2 = 19;
                break;
            case 97:
                i2 = 20;
                break;
            case 98:
                i2 = 21;
                break;
            case 99:
                i2 = 22;
                break;
            case 100:
                i2 = 23;
                break;
            case 101:
                i2 = 24;
                break;
            case 102:
                i2 = 25;
                break;
            default:
                throw Kit.codeBug();
        }
        int type = nodeMakeReference.getType();
        if (type == 33 || type == 36) {
            return new Node(type == 33 ? 140 : Token.SETELEM_OP, nodeMakeReference.getFirstChild(), nodeMakeReference.getLastChild(), new Node(i2, new Node(139), node2));
        }
        if (type == 39) {
            return new Node(8, Node.newString(49, nodeMakeReference.getString()), new Node(i2, nodeMakeReference, node2));
        }
        if (type != 68) {
            throw Kit.codeBug();
        }
        Node firstChild = nodeMakeReference.getFirstChild();
        checkMutableReference(firstChild);
        return new Node(Token.SET_REF_OP, firstChild, new Node(i2, new Node(139), node2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f1, code lost:
    
        if (r0 == 1) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00fb, code lost:
    
        if (r0 == (-1)) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00fd, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static external.sdk.pendo.io.mozilla.javascript.Node createBinary(int r7, external.sdk.pendo.io.mozilla.javascript.Node r8, external.sdk.pendo.io.mozilla.javascript.Node r9) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.IRFactory.createBinary(int, external.sdk.pendo.io.mozilla.javascript.Node, external.sdk.pendo.io.mozilla.javascript.Node):external.sdk.pendo.io.mozilla.javascript.Node");
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    /* JADX WARN: Code duplicated, block: B:15:0x0037  */
    private Node createCallOrNew(int i, Node node) {
        int i2;
        if (node.getType() == 39) {
            String string = node.getString();
            if (string.equals("eval")) {
                i2 = 1;
            } else if (string.equals("With")) {
                i2 = 2;
            } else {
                i2 = 0;
            }
        } else if (node.getType() == 33 && node.getLastChild().getString().equals("eval")) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        Node node2 = new Node(i, node);
        if (i2 != 0) {
            setRequiresActivation();
            node2.putIntProp(10, i2);
        }
        return node2;
    }

    private Node createCatch(String str, Node node, Node node2, int i) {
        if (node == null) {
            node = new Node(129);
        }
        return new Node(125, createName(str), node, node2, i);
    }

    private static Node createCondExpr(Node node, Node node2, Node node3) {
        int iIsAlwaysDefinedBoolean = isAlwaysDefinedBoolean(node);
        if (iIsAlwaysDefinedBoolean == 1) {
            return node2;
        }
        return iIsAlwaysDefinedBoolean == -1 ? node3 : new Node(103, node, node2, node3);
    }

    private Node createElementGet(Node node, String str, Node node2, int i) {
        if (str != null || i != 0) {
            return createMemberRefGet(node, str, node2, i);
        }
        if (node != null) {
            return new Node(36, node, node2);
        }
        throw Kit.codeBug();
    }

    private static Node createExprStatementNoReturn(Node node, int i) {
        return new Node(134, node, i);
    }

    private static Node createFor(Scope scope, Node node, Node node2, Node node3, Node node4) {
        if (node.getType() != 154) {
            return createLoop(scope, 2, node4, node2, node, node3);
        }
        Scope scopeSplitScope = Scope.splitScope(scope);
        scopeSplitScope.setType(Token.LET);
        scopeSplitScope.addChildrenToBack(node);
        scopeSplitScope.addChildToBack(createLoop(scope, 2, node4, node2, new Node(129), node3));
        return scopeSplitScope;
    }

    private Node createForIn(int i, Node node, Node node2, Node node3, Node node4, boolean z, boolean z2) {
        int type;
        Node nodeNewString;
        int i2;
        Node nodeSimpleAssignment;
        int type2 = node2.getType();
        int destructuringLength = 0;
        if (type2 == 123 || type2 == 154) {
            Node lastChild = node2.getLastChild();
            type = lastChild.getType();
            if (type == 66 || type == 67) {
                destructuringLength = lastChild instanceof ArrayLiteral ? ((ArrayLiteral) lastChild).getDestructuringLength() : 0;
                nodeNewString = lastChild;
                type2 = type;
            } else {
                if (type != 39) {
                    reportError("msg.bad.for.in.lhs");
                    return null;
                }
                nodeNewString = Node.newString(39, lastChild.getString());
                type = type2;
                type2 = -1;
            }
        } else if (type2 == 66 || type2 == 67) {
            destructuringLength = node2 instanceof ArrayLiteral ? ((ArrayLiteral) node2).getDestructuringLength() : 0;
            nodeNewString = node2;
            type = type2;
        } else {
            nodeNewString = makeReference(node2);
            if (nodeNewString == null) {
                reportError("msg.bad.for.in.lhs");
                return null;
            }
            type = type2;
            type2 = -1;
        }
        Node node5 = new Node(Token.LOCAL_BLOCK);
        if (z) {
            i2 = 59;
        } else if (z2) {
            i2 = 61;
        } else {
            i2 = type2 != -1 ? 60 : 58;
        }
        Node node6 = new Node(i2, node3);
        node6.putProp(3, node5);
        Node node7 = new Node(62);
        node7.putProp(3, node5);
        Node node8 = new Node(63);
        node8.putProp(3, node5);
        Node node9 = new Node(130);
        if (type2 != -1) {
            nodeSimpleAssignment = createDestructuringAssignment(i, nodeNewString, node8);
            if (!z && !z2 && (type2 == 67 || destructuringLength != 2)) {
                reportError("msg.bad.for.in.destruct");
            }
        } else {
            nodeSimpleAssignment = simpleAssignment(nodeNewString, node8);
        }
        node9.addChildToBack(new Node(134, nodeSimpleAssignment));
        node9.addChildToBack(node4);
        Node nodeCreateLoop = createLoop((Jump) node, 1, node9, node7, null, null);
        nodeCreateLoop.addChildToFront(node6);
        if (type == 123 || type == 154) {
            nodeCreateLoop.addChildToFront(node2);
        }
        node5.addChildToBack(nodeCreateLoop);
        return node5;
    }

    private static Node createIf(Node node, Node node2, Node node3, int i) {
        int iIsAlwaysDefinedBoolean = isAlwaysDefinedBoolean(node);
        if (iIsAlwaysDefinedBoolean == 1) {
            return node2;
        }
        if (iIsAlwaysDefinedBoolean == -1) {
            return node3 != null ? node3 : new Node(130, i);
        }
        Node node4 = new Node(130, i);
        Node nodeNewTarget = Node.newTarget();
        Jump jump = new Jump(7, node);
        jump.target = nodeNewTarget;
        node4.addChildToBack(jump);
        node4.addChildrenToBack(node2);
        if (node3 == null) {
            node4.addChildToBack(nodeNewTarget);
            return node4;
        }
        Node nodeNewTarget2 = Node.newTarget();
        node4.addChildToBack(makeJump(5, nodeNewTarget2));
        node4.addChildToBack(nodeNewTarget);
        node4.addChildrenToBack(node3);
        node4.addChildToBack(nodeNewTarget2);
        return node4;
    }

    private static Node createIncDec(int i, boolean z, Node node) {
        Node nodeMakeReference = makeReference(node);
        int type = nodeMakeReference.getType();
        if (type != 33 && type != 36 && type != 39 && type != 68) {
            throw Kit.codeBug();
        }
        Node node2 = new Node(i, nodeMakeReference);
        int i2 = i == 108 ? 1 : 0;
        if (z) {
            i2 |= 2;
        }
        node2.putIntProp(13, i2);
        return node2;
    }

    private static Node createLoop(Jump jump, int i, Node node, Node node2, Node node3, Node node4) {
        Node nodeNewTarget = Node.newTarget();
        Node nodeNewTarget2 = Node.newTarget();
        if (i == 2 && node2.getType() == 129) {
            node2 = new Node(45);
        }
        Jump jump2 = new Jump(6, node2);
        jump2.target = nodeNewTarget;
        Node nodeNewTarget3 = Node.newTarget();
        jump.addChildToBack(nodeNewTarget);
        jump.addChildrenToBack(node);
        if (i == 1 || i == 2) {
            jump.addChildrenToBack(new Node(129, jump.getLineno()));
        }
        jump.addChildToBack(nodeNewTarget2);
        jump.addChildToBack(jump2);
        jump.addChildToBack(nodeNewTarget3);
        jump.target = nodeNewTarget3;
        if (i == 1 || i == 2) {
            jump.addChildToFront(makeJump(5, nodeNewTarget2));
            if (i == 2) {
                int type = node3.getType();
                if (type != 129) {
                    if (type != 123 && type != 154) {
                        node3 = new Node(134, node3);
                    }
                    jump.addChildToFront(node3);
                }
                nodeNewTarget2 = Node.newTarget();
                jump.addChildAfter(nodeNewTarget2, node);
                if (node4.getType() != 129) {
                    jump.addChildAfter(new Node(134, node4), nodeNewTarget2);
                }
            }
        }
        jump.setContinue(nodeNewTarget2);
        return jump;
    }

    private Scope createLoopNode(Node node, int i) {
        Scope scopeCreateScopeNode = createScopeNode(Token.LOOP, i);
        if (node != null) {
            ((Jump) node).setLoop(scopeCreateScopeNode);
        }
        return scopeCreateScopeNode;
    }

    private Node createMemberRefGet(Node node, String str, Node node2, int i) {
        Node node3;
        Node node4;
        if (str != null) {
            node3 = str.equals("*") ? new Node(42) : createName(str);
        } else {
            node3 = null;
        }
        if (node == null) {
            node4 = str == null ? new Node(80, node2) : new Node(81, node3, node2);
        } else {
            node4 = str == null ? new Node(78, node, node2) : new Node(79, node, node3, node2);
        }
        if (i != 0) {
            node4.putIntProp(16, i);
        }
        return new Node(68, node4);
    }

    private Node createPropertyGet(Node node, String str, String str2, int i) {
        if (str != null || i != 0) {
            return createMemberRefGet(node, str, Node.newString(str2), i | 1);
        }
        if (node == null) {
            return createName(str2);
        }
        checkActivationName(str2, 33);
        if (!ScriptRuntime.isSpecialProperty(str2)) {
            return new Node(33, node, Node.newString(str2));
        }
        Node node2 = new Node(72, node);
        node2.putProp(17, str2);
        return new Node(68, node2);
    }

    private static Node createString(String str) {
        return Node.newString(str);
    }

    private Node createTryCatchFinally(Node node, Node node2, Node node3, int i) {
        boolean z = false;
        boolean z2 = node3 != null && (node3.getType() != 130 || node3.hasChildren());
        if (node.getType() != 130 || node.hasChildren() || z2) {
            boolean zHasChildren = node2.hasChildren();
            if (z2 || zHasChildren) {
                Node node4 = new Node(Token.LOCAL_BLOCK);
                Jump jump = new Jump(82, node, i);
                jump.putProp(3, node4);
                int i2 = 5;
                if (zHasChildren) {
                    Node nodeNewTarget = Node.newTarget();
                    jump.addChildToBack(makeJump(5, nodeNewTarget));
                    Node nodeNewTarget2 = Node.newTarget();
                    jump.target = nodeNewTarget2;
                    jump.addChildToBack(nodeNewTarget2);
                    Node node5 = new Node(Token.LOCAL_BLOCK);
                    Node firstChild = node2.getFirstChild();
                    int i3 = 0;
                    while (firstChild != null) {
                        int lineno = firstChild.getLineno();
                        Node firstChild2 = firstChild.getFirstChild();
                        Node next = firstChild2.getNext();
                        Node next2 = next.getNext();
                        firstChild.removeChild(firstChild2);
                        firstChild.removeChild(next);
                        firstChild.removeChild(next2);
                        next2.addChildToBack(new Node(3));
                        next2.addChildToBack(makeJump(i2, nodeNewTarget));
                        if (next.getType() == 129) {
                            z = true;
                        } else {
                            next2 = createIf(next, next2, null, lineno);
                        }
                        Node node6 = new Node(57, firstChild2, createUseLocal(node4));
                        node6.putProp(3, node5);
                        node6.putIntProp(14, i3);
                        node5.addChildToBack(node6);
                        node5.addChildToBack(createWith(createUseLocal(node5), next2, lineno));
                        firstChild = firstChild.getNext();
                        i3++;
                        i2 = 5;
                    }
                    jump.addChildToBack(node5);
                    if (!z) {
                        Node node7 = new Node(51);
                        node7.putProp(3, node4);
                        jump.addChildToBack(node7);
                    }
                    jump.addChildToBack(nodeNewTarget);
                }
                if (z2) {
                    Node nodeNewTarget3 = Node.newTarget();
                    jump.setFinally(nodeNewTarget3);
                    jump.addChildToBack(makeJump(136, nodeNewTarget3));
                    Node nodeNewTarget4 = Node.newTarget();
                    jump.addChildToBack(makeJump(5, nodeNewTarget4));
                    jump.addChildToBack(nodeNewTarget3);
                    Node node8 = new Node(126, node3);
                    node8.putProp(3, node4);
                    jump.addChildToBack(node8);
                    jump.addChildToBack(nodeNewTarget4);
                }
                node4.addChildToBack(jump);
                return node4;
            }
        }
        return node;
    }

    private static Node createUnary(int i, Node node) {
        int type = node.getType();
        switch (i) {
            case 26:
                int iIsAlwaysDefinedBoolean = isAlwaysDefinedBoolean(node);
                if (iIsAlwaysDefinedBoolean != 0) {
                    int i2 = iIsAlwaysDefinedBoolean == 1 ? 44 : 45;
                    if (type != 45 && type != 44) {
                        return new Node(i2);
                    }
                    node.setType(i2);
                    return node;
                }
                break;
            case 27:
                if (type == 40) {
                    node.setDouble(~ScriptRuntime.toInt32(node.getDouble()));
                    return node;
                }
                break;
            case 29:
                if (type == 40) {
                    node.setDouble(-node.getDouble());
                    return node;
                }
                break;
            case 31:
                if (type == 39) {
                    node.setType(49);
                    return new Node(i, node, Node.newString(node.getString()));
                }
                if (type == 33 || type == 36) {
                    Node firstChild = node.getFirstChild();
                    Node lastChild = node.getLastChild();
                    node.removeChild(firstChild);
                    node.removeChild(lastChild);
                    return new Node(i, firstChild, lastChild);
                }
                if (type != 68) {
                    return new Node(i, new Node(45), node);
                }
                Node firstChild2 = node.getFirstChild();
                node.removeChild(firstChild2);
                return new Node(70, firstChild2);
            case 32:
                if (type == 39) {
                    node.setType(138);
                    return node;
                }
                break;
        }
        return new Node(i, node);
    }

    private static Node createUseLocal(Node node) {
        if (142 != node.getType()) {
            throw Kit.codeBug();
        }
        Node node2 = new Node(54);
        node2.putProp(3, node);
        return node2;
    }

    private Node createWith(Node node, Node node2, int i) {
        setRequiresActivation();
        Node node3 = new Node(130, i);
        node3.addChildToBack(new Node(2, node));
        node3.addChildrenToBack(new Node(124, node2, i));
        node3.addChildToBack(new Node(3));
        return node3;
    }

    private Node genExprTransformHelper(GeneratorExpression generatorExpression) throws Throwable {
        String string;
        this.decompiler.addToken(88);
        int lineno = generatorExpression.getLineno();
        Node nodeTransform = transform(generatorExpression.getResult());
        List<GeneratorExpressionLoop> loops = generatorExpression.getLoops();
        int size = loops.size();
        Node[] nodeArr = new Node[size];
        Node[] nodeArr2 = new Node[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            GeneratorExpressionLoop generatorExpressionLoop = loops.get(i2);
            this.decompiler.addName(" ");
            this.decompiler.addToken(120);
            this.decompiler.addToken(88);
            AstNode iterator = generatorExpressionLoop.getIterator();
            if (iterator.getType() == 39) {
                string = iterator.getString();
                this.decompiler.addName(string);
            } else {
                decompile(iterator);
                String nextTempName = this.currentScriptOrFn.getNextTempName();
                defineSymbol(88, nextTempName, false);
                nodeTransform = createBinary(90, createAssignment(91, iterator, createName(nextTempName)), nodeTransform);
                string = nextTempName;
            }
            Node nodeCreateName = createName(string);
            defineSymbol(Token.LET, string, false);
            nodeArr[i2] = nodeCreateName;
            if (generatorExpressionLoop.isForOf()) {
                this.decompiler.addName("of ");
            } else {
                this.decompiler.addToken(52);
            }
            nodeArr2[i2] = transform(generatorExpressionLoop.getIteratedObject());
            this.decompiler.addToken(89);
        }
        Node node = new Node(134, new Node(73, nodeTransform, generatorExpression.getLineno()), lineno);
        if (generatorExpression.getFilter() != null) {
            this.decompiler.addName(" ");
            this.decompiler.addToken(113);
            this.decompiler.addToken(88);
            node = createIf(transform(generatorExpression.getFilter()), node, null, lineno);
            this.decompiler.addToken(89);
        }
        Node nodeCreateForIn = node;
        int i3 = size - 1;
        int i4 = 0;
        while (i3 >= 0) {
            try {
                GeneratorExpressionLoop generatorExpressionLoop2 = loops.get(i3);
                Scope scopeCreateLoopNode = createLoopNode(null, generatorExpressionLoop2.getLineno());
                pushScope(scopeCreateLoopNode);
                int i5 = i4 + 1;
                try {
                    nodeCreateForIn = createForIn(Token.LET, scopeCreateLoopNode, nodeArr[i3], nodeArr2[i3], nodeCreateForIn, generatorExpressionLoop2.isForEach(), generatorExpressionLoop2.isForOf());
                    i3--;
                    i4 = i5;
                } catch (Throwable th) {
                    th = th;
                    i4 = i5;
                    while (i < i4) {
                        popScope();
                        i++;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        while (i < i4) {
            popScope();
            i++;
        }
        this.decompiler.addToken(89);
        return nodeCreateForIn;
    }

    private Object getPropKey(Node node) {
        if (node instanceof Name) {
            String identifier = ((Name) node).getIdentifier();
            this.decompiler.addName(identifier);
            return ScriptRuntime.getIndexObject(identifier);
        }
        if (node instanceof StringLiteral) {
            String value = ((StringLiteral) node).getValue();
            this.decompiler.addString(value);
            return ScriptRuntime.getIndexObject(value);
        }
        if (!(node instanceof NumberLiteral)) {
            throw Kit.codeBug();
        }
        double number = ((NumberLiteral) node).getNumber();
        this.decompiler.addNumber(number);
        return ScriptRuntime.getIndexObject(number);
    }

    private static Node initFunction(FunctionNode functionNode, int i, Node node, int i2) {
        Name functionName;
        functionNode.setFunctionType(i2);
        functionNode.addChildToBack(node);
        if (functionNode.getFunctionCount() != 0) {
            functionNode.setRequiresActivation();
        }
        if (i2 == 2 && (functionName = functionNode.getFunctionName()) != null && functionName.length() != 0 && functionNode.getSymbol(functionName.getIdentifier()) == null) {
            functionNode.putSymbol(new external.sdk.pendo.io.mozilla.javascript.ast.Symbol(110, functionName.getIdentifier()));
            node.addChildrenToFront(new Node(134, new Node(8, Node.newString(49, functionName.getIdentifier()), new Node(64))));
        }
        Node lastChild = node.getLastChild();
        if (lastChild == null || lastChild.getType() != 4) {
            node.addChildToBack(new Node(4));
        }
        Node nodeNewString = Node.newString(110, functionNode.getName());
        nodeNewString.putIntProp(1, i);
        return nodeNewString;
    }

    private static int isAlwaysDefinedBoolean(Node node) {
        int type = node.getType();
        if (type == 40) {
            double d = node.getDouble();
            return (Double.isNaN(d) || d == 0.0d) ? -1 : 1;
        }
        if (type == 42 || type == 44) {
            return -1;
        }
        return type != 45 ? 0 : 1;
    }

    private static Jump makeJump(int i, Node node) {
        Jump jump = new Jump(i);
        jump.target = node;
        return jump;
    }

    private static Node makeReference(Node node) {
        int type = node.getType();
        if (type != 33 && type != 36 && type != 68) {
            if (type == 38) {
                node.setType(71);
                return new Node(68, node);
            }
            if (type != 39) {
                return null;
            }
        }
        return node;
    }

    private Node transformArrayComp(ArrayComprehension arrayComprehension) {
        int lineno = arrayComprehension.getLineno();
        Scope scopeCreateScopeNode = createScopeNode(Token.ARRAYCOMP, lineno);
        String nextTempName = this.currentScriptOrFn.getNextTempName();
        pushScope(scopeCreateScopeNode);
        try {
            defineSymbol(Token.LET, nextTempName, false);
            Node node = new Node(130, lineno);
            node.addChildToBack(new Node(134, createAssignment(91, createName(nextTempName), createCallOrNew(30, createName("Array"))), lineno));
            node.addChildToBack(arrayCompTransformHelper(arrayComprehension, nextTempName));
            scopeCreateScopeNode.addChildToBack(node);
            scopeCreateScopeNode.addChildToBack(createName(nextTempName));
            return scopeCreateScopeNode;
        } finally {
            popScope();
        }
    }

    private Node transformArrayLiteral(ArrayLiteral arrayLiteral) {
        if (arrayLiteral.isDestructuring()) {
            return arrayLiteral;
        }
        this.decompiler.addToken(84);
        List<AstNode> elements = arrayLiteral.getElements();
        Node node = new Node(66);
        ArrayList arrayList = null;
        for (int i = 0; i < elements.size(); i++) {
            AstNode astNode = elements.get(i);
            if (astNode.getType() != 129) {
                node.addChildToBack(transform(astNode));
            } else {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(Integer.valueOf(i));
            }
            if (i < elements.size() - 1) {
                this.decompiler.addToken(90);
            }
        }
        this.decompiler.addToken(85);
        node.putIntProp(21, arrayLiteral.getDestructuringLength());
        if (arrayList != null) {
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            node.putProp(11, iArr);
        }
        return node;
    }

    private Node transformAssignment(Assignment assignment) {
        Node nodeTransform;
        AstNode astNodeRemoveParens = removeParens(assignment.getLeft());
        if (isDestructuring(astNodeRemoveParens)) {
            decompile(astNodeRemoveParens);
            nodeTransform = astNodeRemoveParens;
        } else {
            nodeTransform = transform(astNodeRemoveParens);
        }
        this.decompiler.addToken(assignment.getType());
        return createAssignment(assignment.getType(), nodeTransform, transform(assignment.getRight()));
    }

    private Node transformBlock(AstNode astNode) {
        boolean z = astNode instanceof Scope;
        if (z) {
            pushScope((Scope) astNode);
        }
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<Node> it = astNode.iterator();
            while (it.hasNext()) {
                arrayList.add(transform((AstNode) it.next()));
            }
            astNode.removeChildren();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                astNode.addChildToBack((Node) it2.next());
            }
            return astNode;
        } finally {
            if (z) {
                popScope();
            }
        }
    }

    private Node transformBreak(BreakStatement breakStatement) {
        this.decompiler.addToken(121);
        if (breakStatement.getBreakLabel() != null) {
            this.decompiler.addName(breakStatement.getBreakLabel().getIdentifier());
        }
        this.decompiler.addEOL(83);
        return breakStatement;
    }

    private Node transformCondExpr(ConditionalExpression conditionalExpression) {
        Node nodeTransform = transform(conditionalExpression.getTestExpression());
        this.decompiler.addToken(103);
        Node nodeTransform2 = transform(conditionalExpression.getTrueExpression());
        this.decompiler.addToken(104);
        return createCondExpr(nodeTransform, nodeTransform2, transform(conditionalExpression.getFalseExpression()));
    }

    private Node transformContinue(ContinueStatement continueStatement) {
        this.decompiler.addToken(122);
        if (continueStatement.getLabel() != null) {
            this.decompiler.addName(continueStatement.getLabel().getIdentifier());
        }
        this.decompiler.addEOL(83);
        return continueStatement;
    }

    private Node transformDefaultXmlNamepace(UnaryExpression unaryExpression) {
        this.decompiler.addToken(117);
        this.decompiler.addName(" xml");
        this.decompiler.addName(" namespace");
        this.decompiler.addToken(91);
        return createUnary(75, transform(unaryExpression.getOperand()));
    }

    private Node transformDoLoop(DoLoop doLoop) {
        doLoop.setType(Token.LOOP);
        pushScope(doLoop);
        try {
            this.decompiler.addToken(119);
            this.decompiler.addEOL(86);
            Node nodeTransform = transform(doLoop.getBody());
            this.decompiler.addToken(87);
            this.decompiler.addToken(118);
            this.decompiler.addToken(88);
            Node nodeTransform2 = transform(doLoop.getCondition());
            this.decompiler.addToken(89);
            this.decompiler.addEOL(83);
            return createLoop(doLoop, 0, nodeTransform, nodeTransform2, null, null);
        } finally {
            popScope();
        }
    }

    private Node transformElementGet(ElementGet elementGet) {
        Node nodeTransform = transform(elementGet.getTarget());
        this.decompiler.addToken(84);
        Node nodeTransform2 = transform(elementGet.getElement());
        this.decompiler.addToken(85);
        return new Node(36, nodeTransform, nodeTransform2);
    }

    private Node transformExprStmt(ExpressionStatement expressionStatement) {
        Node nodeTransform = transform(expressionStatement.getExpression());
        this.decompiler.addEOL(83);
        return new Node(expressionStatement.getType(), nodeTransform, expressionStatement.getLineno());
    }

    private Node transformForInLoop(ForInLoop forInLoop) throws Throwable {
        IRFactory iRFactory;
        Throwable th;
        int type;
        this.decompiler.addToken(120);
        if (forInLoop.isForEach()) {
            this.decompiler.addName("each ");
        }
        this.decompiler.addToken(88);
        forInLoop.setType(Token.LOOP);
        pushScope(forInLoop);
        try {
            AstNode iterator = forInLoop.getIterator();
            if (iterator instanceof VariableDeclaration) {
                try {
                    type = ((VariableDeclaration) iterator).getType();
                } catch (Throwable th2) {
                    th = th2;
                    iRFactory = this;
                    iRFactory.popScope();
                    throw th;
                }
            } else {
                type = -1;
            }
            int i = type;
            Node nodeTransform = transform(iterator);
            if (forInLoop.isForOf()) {
                this.decompiler.addName("of ");
            } else {
                this.decompiler.addToken(52);
            }
            Node nodeTransform2 = transform(forInLoop.getIteratedObject());
            this.decompiler.addToken(89);
            this.decompiler.addEOL(86);
            Node nodeTransform3 = transform(forInLoop.getBody());
            this.decompiler.addEOL(87);
            iRFactory = this;
            try {
                Node nodeCreateForIn = iRFactory.createForIn(i, forInLoop, nodeTransform, nodeTransform2, nodeTransform3, forInLoop.isForEach(), forInLoop.isForOf());
                iRFactory.popScope();
                return nodeCreateForIn;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                iRFactory.popScope();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            iRFactory = this;
        }
    }

    private Node transformForLoop(ForLoop forLoop) {
        this.decompiler.addToken(120);
        this.decompiler.addToken(88);
        forLoop.setType(Token.LOOP);
        Scope scope = this.currentScope;
        this.currentScope = forLoop;
        try {
            Node nodeTransform = transform(forLoop.getInitializer());
            this.decompiler.addToken(83);
            Node nodeTransform2 = transform(forLoop.getCondition());
            this.decompiler.addToken(83);
            Node nodeTransform3 = transform(forLoop.getIncrement());
            this.decompiler.addToken(89);
            this.decompiler.addEOL(86);
            Node nodeTransform4 = transform(forLoop.getBody());
            this.decompiler.addEOL(87);
            return createFor(forLoop, nodeTransform, nodeTransform2, nodeTransform3, nodeTransform4);
        } finally {
            this.currentScope = scope;
        }
    }

    private Node transformFunction(FunctionNode functionNode) {
        int functionType = functionNode.getFunctionType();
        int iMarkFunctionStart = this.decompiler.markFunctionStart(functionType);
        Node nodeDecompileFunctionHeader = decompileFunctionHeader(functionNode);
        int iAddFunction = this.currentScriptOrFn.addFunction(functionNode);
        Parser.PerFunctionVariables perFunctionVariables = new Parser.PerFunctionVariables(functionNode);
        try {
            Node node = (Node) functionNode.getProp(23);
            functionNode.removeProp(23);
            int lineno = functionNode.getBody().getLineno();
            this.nestingOfFunction++;
            Node nodeTransform = transform(functionNode.getBody());
            if (!functionNode.isExpressionClosure()) {
                this.decompiler.addToken(87);
            }
            functionNode.setEncodedSourceBounds(iMarkFunctionStart, this.decompiler.markFunctionEnd(iMarkFunctionStart));
            if (functionType != 2 && !functionNode.isExpressionClosure()) {
                this.decompiler.addToken(1);
            }
            if (node != null) {
                nodeTransform.addChildToFront(new Node(134, node, lineno));
            }
            int functionType2 = functionNode.getFunctionType();
            Node nodeInitFunction = initFunction(functionNode, iAddFunction, nodeTransform, functionType2);
            if (nodeDecompileFunctionHeader != null) {
                nodeInitFunction = createAssignment(91, nodeDecompileFunctionHeader, nodeInitFunction);
                if (functionType2 != 2) {
                    nodeInitFunction = createExprStatementNoReturn(nodeInitFunction, functionNode.getLineno());
                }
            }
            return nodeInitFunction;
        } finally {
            this.nestingOfFunction--;
            perFunctionVariables.restore();
        }
    }

    private Node transformFunctionCall(FunctionCall functionCall) {
        Node nodeCreateCallOrNew = createCallOrNew(38, transform(functionCall.getTarget()));
        nodeCreateCallOrNew.setLineno(functionCall.getLineno());
        this.decompiler.addToken(88);
        List<AstNode> arguments = functionCall.getArguments();
        for (int i = 0; i < arguments.size(); i++) {
            nodeCreateCallOrNew.addChildToBack(transform(arguments.get(i)));
            if (i < arguments.size() - 1) {
                this.decompiler.addToken(90);
            }
        }
        this.decompiler.addToken(89);
        return nodeCreateCallOrNew;
    }

    private Node transformGenExpr(GeneratorExpression generatorExpression) {
        FunctionNode functionNode = new FunctionNode();
        functionNode.setSourceName(this.currentScriptOrFn.getNextTempName());
        functionNode.setIsGenerator();
        functionNode.setFunctionType(2);
        functionNode.setRequiresActivation();
        int functionType = functionNode.getFunctionType();
        int iMarkFunctionStart = this.decompiler.markFunctionStart(functionType);
        Node nodeDecompileFunctionHeader = decompileFunctionHeader(functionNode);
        int iAddFunction = this.currentScriptOrFn.addFunction(functionNode);
        Parser.PerFunctionVariables perFunctionVariables = new Parser.PerFunctionVariables(functionNode);
        try {
            Node node = (Node) functionNode.getProp(23);
            functionNode.removeProp(23);
            int i = generatorExpression.lineno;
            this.nestingOfFunction++;
            Node nodeGenExprTransformHelper = genExprTransformHelper(generatorExpression);
            if (!functionNode.isExpressionClosure()) {
                this.decompiler.addToken(87);
            }
            functionNode.setEncodedSourceBounds(iMarkFunctionStart, this.decompiler.markFunctionEnd(iMarkFunctionStart));
            if (functionType != 2 && !functionNode.isExpressionClosure()) {
                this.decompiler.addToken(1);
            }
            if (node != null) {
                nodeGenExprTransformHelper.addChildToFront(new Node(134, node, i));
            }
            int functionType2 = functionNode.getFunctionType();
            Node nodeInitFunction = initFunction(functionNode, iAddFunction, nodeGenExprTransformHelper, functionType2);
            if (nodeDecompileFunctionHeader != null) {
                nodeInitFunction = createAssignment(91, nodeDecompileFunctionHeader, nodeInitFunction);
                if (functionType2 != 2) {
                    nodeInitFunction = createExprStatementNoReturn(nodeInitFunction, functionNode.getLineno());
                }
            }
            this.nestingOfFunction--;
            perFunctionVariables.restore();
            Node nodeCreateCallOrNew = createCallOrNew(38, nodeInitFunction);
            nodeCreateCallOrNew.setLineno(generatorExpression.getLineno());
            this.decompiler.addToken(88);
            this.decompiler.addToken(89);
            return nodeCreateCallOrNew;
        } catch (Throwable th) {
            this.nestingOfFunction--;
            perFunctionVariables.restore();
            throw th;
        }
    }

    private Node transformIf(IfStatement ifStatement) {
        Node nodeTransform;
        this.decompiler.addToken(113);
        this.decompiler.addToken(88);
        Node nodeTransform2 = transform(ifStatement.getCondition());
        this.decompiler.addToken(89);
        this.decompiler.addEOL(86);
        Node nodeTransform3 = transform(ifStatement.getThenPart());
        if (ifStatement.getElsePart() != null) {
            this.decompiler.addToken(87);
            this.decompiler.addToken(114);
            this.decompiler.addEOL(86);
            nodeTransform = transform(ifStatement.getElsePart());
        } else {
            nodeTransform = null;
        }
        this.decompiler.addEOL(87);
        return createIf(nodeTransform2, nodeTransform3, nodeTransform, ifStatement.getLineno());
    }

    private Node transformInfix(InfixExpression infixExpression) {
        Node nodeTransform = transform(infixExpression.getLeft());
        this.decompiler.addToken(infixExpression.getType());
        Node nodeTransform2 = transform(infixExpression.getRight());
        if (infixExpression instanceof XmlDotQuery) {
            this.decompiler.addToken(89);
        }
        return createBinary(infixExpression.getType(), nodeTransform, nodeTransform2);
    }

    private Node transformLabeledStatement(LabeledStatement labeledStatement) {
        Decompiler decompiler;
        Label firstLabel = labeledStatement.getFirstLabel();
        List<Label> labels = labeledStatement.getLabels();
        this.decompiler.addName(firstLabel.getName());
        int i = 104;
        if (labels.size() > 1) {
            for (Label label : labels.subList(1, labels.size())) {
                this.decompiler.addEOL(104);
                this.decompiler.addName(label.getName());
            }
        }
        if (labeledStatement.getStatement().getType() == 130) {
            this.decompiler.addToken(67);
            decompiler = this.decompiler;
            i = 86;
        } else {
            decompiler = this.decompiler;
        }
        decompiler.addEOL(i);
        Node nodeTransform = transform(labeledStatement.getStatement());
        if (labeledStatement.getStatement().getType() == 130) {
            this.decompiler.addEOL(87);
        }
        Node nodeNewTarget = Node.newTarget();
        Node node = new Node(130, firstLabel, nodeTransform, nodeNewTarget);
        firstLabel.target = nodeNewTarget;
        return node;
    }

    private Node transformLetNode(LetNode letNode) {
        pushScope(letNode);
        try {
            this.decompiler.addToken(Token.LET);
            this.decompiler.addToken(88);
            Node nodeTransformVariableInitializers = transformVariableInitializers(letNode.getVariables());
            this.decompiler.addToken(89);
            letNode.addChildToBack(nodeTransformVariableInitializers);
            boolean z = letNode.getType() == 159;
            if (letNode.getBody() != null) {
                if (z) {
                    this.decompiler.addName(" ");
                } else {
                    this.decompiler.addEOL(86);
                }
                letNode.addChildToBack(transform(letNode.getBody()));
                if (!z) {
                    this.decompiler.addEOL(87);
                }
            }
            return letNode;
        } finally {
            popScope();
        }
    }

    private Node transformLiteral(AstNode astNode) {
        this.decompiler.addToken(astNode.getType());
        return astNode;
    }

    private Node transformName(Name name) {
        this.decompiler.addName(name.getIdentifier());
        return name;
    }

    private Node transformNewExpr(NewExpression newExpression) {
        this.decompiler.addToken(30);
        Node nodeCreateCallOrNew = createCallOrNew(30, transform(newExpression.getTarget()));
        nodeCreateCallOrNew.setLineno(newExpression.getLineno());
        List<AstNode> arguments = newExpression.getArguments();
        this.decompiler.addToken(88);
        for (int i = 0; i < arguments.size(); i++) {
            nodeCreateCallOrNew.addChildToBack(transform(arguments.get(i)));
            if (i < arguments.size() - 1) {
                this.decompiler.addToken(90);
            }
        }
        this.decompiler.addToken(89);
        if (newExpression.getInitializer() != null) {
            nodeCreateCallOrNew.addChildToBack(transformObjectLiteral(newExpression.getInitializer()));
        }
        return nodeCreateCallOrNew;
    }

    private Node transformNumber(NumberLiteral numberLiteral) {
        this.decompiler.addNumber(numberLiteral.getNumber());
        return numberLiteral;
    }

    private Node transformObjectLiteral(ObjectLiteral objectLiteral) {
        Object[] objArr;
        if (objectLiteral.isDestructuring()) {
            return objectLiteral;
        }
        this.decompiler.addToken(86);
        List<ObjectProperty> elements = objectLiteral.getElements();
        Node node = new Node(67);
        if (elements.isEmpty()) {
            objArr = ScriptRuntime.emptyArgs;
        } else {
            int size = elements.size();
            Object[] objArr2 = new Object[size];
            int i = 0;
            for (ObjectProperty objectProperty : elements) {
                if (objectProperty.isGetterMethod()) {
                    this.decompiler.addToken(Token.GET);
                } else if (objectProperty.isSetterMethod()) {
                    this.decompiler.addToken(Token.SET);
                } else if (objectProperty.isNormalMethod()) {
                    this.decompiler.addToken(Token.METHOD);
                }
                int i2 = i + 1;
                objArr2[i] = getPropKey(objectProperty.getLeft());
                if (!objectProperty.isMethod()) {
                    this.decompiler.addToken(67);
                }
                Node nodeTransform = transform(objectProperty.getRight());
                if (objectProperty.isGetterMethod()) {
                    nodeTransform = createUnary(Token.GET, nodeTransform);
                } else if (objectProperty.isSetterMethod()) {
                    nodeTransform = createUnary(Token.SET, nodeTransform);
                } else if (objectProperty.isNormalMethod()) {
                    nodeTransform = createUnary(Token.METHOD, nodeTransform);
                }
                node.addChildToBack(nodeTransform);
                if (i2 < size) {
                    this.decompiler.addToken(90);
                }
                i = i2;
            }
            objArr = objArr2;
        }
        this.decompiler.addToken(87);
        node.putProp(12, objArr);
        return node;
    }

    private Node transformParenExpr(ParenthesizedExpression parenthesizedExpression) {
        AstNode expression = parenthesizedExpression.getExpression();
        this.decompiler.addToken(88);
        int i = 1;
        while (expression instanceof ParenthesizedExpression) {
            this.decompiler.addToken(88);
            i++;
            expression = ((ParenthesizedExpression) expression).getExpression();
        }
        Node nodeTransform = transform(expression);
        for (int i2 = 0; i2 < i; i2++) {
            this.decompiler.addToken(89);
        }
        nodeTransform.putProp(19, Boolean.TRUE);
        return nodeTransform;
    }

    private Node transformPropertyGet(PropertyGet propertyGet) {
        Node nodeTransform = transform(propertyGet.getTarget());
        String identifier = propertyGet.getProperty().getIdentifier();
        this.decompiler.addToken(109);
        this.decompiler.addName(identifier);
        return createPropertyGet(nodeTransform, null, identifier, 0);
    }

    private Node transformRegExp(RegExpLiteral regExpLiteral) {
        this.decompiler.addRegexp(regExpLiteral.getValue(), regExpLiteral.getFlags());
        this.currentScriptOrFn.addRegExp(regExpLiteral);
        return regExpLiteral;
    }

    private Node transformReturn(ReturnStatement returnStatement) {
        Boolean bool = Boolean.TRUE;
        boolean zEquals = bool.equals(returnStatement.getProp(25));
        boolean zEquals2 = bool.equals(returnStatement.getProp(27));
        if (!zEquals) {
            this.decompiler.addToken(4);
        } else if (!zEquals2) {
            this.decompiler.addName(" ");
        }
        AstNode returnValue = returnStatement.getReturnValue();
        Node nodeTransform = returnValue == null ? null : transform(returnValue);
        if (!zEquals) {
            this.decompiler.addEOL(83);
        }
        int lineno = returnStatement.getLineno();
        return returnValue == null ? new Node(4, lineno) : new Node(4, nodeTransform, lineno);
    }

    private Node transformScript(ScriptNode scriptNode) {
        this.decompiler.addToken(Token.SCRIPT);
        if (this.currentScope != null) {
            Kit.codeBug();
        }
        this.currentScope = scriptNode;
        Node node = new Node(130);
        Iterator<Node> it = scriptNode.iterator();
        while (it.hasNext()) {
            node.addChildToBack(transform((AstNode) it.next()));
        }
        scriptNode.removeChildren();
        Node firstChild = node.getFirstChild();
        if (firstChild != null) {
            scriptNode.addChildrenToBack(firstChild);
        }
        return scriptNode;
    }

    private Node transformString(StringLiteral stringLiteral) {
        this.decompiler.addString(stringLiteral.getValue());
        return Node.newString(stringLiteral.getValue());
    }

    private Node transformSwitch(SwitchStatement switchStatement) {
        Node nodeTransform;
        this.decompiler.addToken(115);
        this.decompiler.addToken(88);
        Node nodeTransform2 = transform(switchStatement.getExpression());
        this.decompiler.addToken(89);
        switchStatement.addChildToBack(nodeTransform2);
        Node node = new Node(130, switchStatement, switchStatement.getLineno());
        this.decompiler.addEOL(86);
        for (SwitchCase switchCase : switchStatement.getCases()) {
            AstNode expression = switchCase.getExpression();
            if (expression != null) {
                this.decompiler.addToken(116);
                nodeTransform = transform(expression);
            } else {
                this.decompiler.addToken(117);
                nodeTransform = null;
            }
            this.decompiler.addEOL(104);
            List<AstNode> statements = switchCase.getStatements();
            Block block = new Block();
            if (statements != null) {
                Iterator<AstNode> it = statements.iterator();
                while (it.hasNext()) {
                    block.addChildToBack(transform(it.next()));
                }
            }
            addSwitchCase(node, nodeTransform, block);
        }
        this.decompiler.addEOL(87);
        closeSwitch(node);
        return node;
    }

    private Node transformThrow(ThrowStatement throwStatement) {
        this.decompiler.addToken(50);
        Node nodeTransform = transform(throwStatement.getExpression());
        this.decompiler.addEOL(83);
        return new Node(50, nodeTransform, throwStatement.getLineno());
    }

    private Node transformTry(TryStatement tryStatement) {
        Node nodeTransform;
        Node emptyExpression;
        this.decompiler.addToken(82);
        this.decompiler.addEOL(86);
        Node nodeTransform2 = transform(tryStatement.getTryBlock());
        this.decompiler.addEOL(87);
        Block block = new Block();
        for (CatchClause catchClause : tryStatement.getCatchClauses()) {
            this.decompiler.addToken(125);
            this.decompiler.addToken(88);
            String identifier = catchClause.getVarName().getIdentifier();
            this.decompiler.addName(identifier);
            AstNode catchCondition = catchClause.getCatchCondition();
            if (catchCondition != null) {
                this.decompiler.addName(" ");
                this.decompiler.addToken(113);
                emptyExpression = transform(catchCondition);
            } else {
                emptyExpression = new EmptyExpression();
            }
            this.decompiler.addToken(89);
            this.decompiler.addEOL(86);
            Node nodeTransform3 = transform(catchClause.getBody());
            this.decompiler.addEOL(87);
            block.addChildToBack(createCatch(identifier, emptyExpression, nodeTransform3, catchClause.getLineno()));
        }
        if (tryStatement.getFinallyBlock() != null) {
            this.decompiler.addToken(126);
            this.decompiler.addEOL(86);
            nodeTransform = transform(tryStatement.getFinallyBlock());
            this.decompiler.addEOL(87);
        } else {
            nodeTransform = null;
        }
        return createTryCatchFinally(nodeTransform2, block, nodeTransform, tryStatement.getLineno());
    }

    private Node transformUnary(UnaryExpression unaryExpression) {
        int type = unaryExpression.getType();
        if (type == 75) {
            return transformDefaultXmlNamepace(unaryExpression);
        }
        if (unaryExpression.isPrefix()) {
            this.decompiler.addToken(type);
        }
        Node nodeTransform = transform(unaryExpression.getOperand());
        if (unaryExpression.isPostfix()) {
            this.decompiler.addToken(type);
        }
        return (type == 107 || type == 108) ? createIncDec(type, unaryExpression.isPostfix(), nodeTransform) : createUnary(type, nodeTransform);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0061  */
    /* JADX WARN: Code duplicated, block: B:27:0x0068 A[SYNTHETIC] */
    private Node transformVariableInitializers(VariableDeclaration variableDeclaration) {
        Node nodeTransform;
        Node node;
        Node nodeTransform2;
        List<VariableInitializer> variables = variableDeclaration.getVariables();
        int size = variables.size();
        int i = 0;
        for (VariableInitializer variableInitializer : variables) {
            AstNode target = variableInitializer.getTarget();
            AstNode initializer = variableInitializer.getInitializer();
            if (variableInitializer.isDestructuring()) {
                decompile(target);
            } else {
                nodeTransform = transform(target);
            }
            if (initializer != null) {
                node = nodeTransform;
                node = target;
                this.decompiler.addToken(91);
                nodeTransform2 = transform(initializer);
            } else {
                node = nodeTransform;
                node = target;
                nodeTransform2 = null;
            }
            if (variableInitializer.isDestructuring()) {
                if (nodeTransform2 != null) {
                    variableDeclaration.addChildToBack(createDestructuringAssignment(variableDeclaration.getType(), node, nodeTransform2));
                }
                int i2 = i + 1;
                if (i < size - 1) {
                    this.decompiler.addToken(90);
                }
                i = i2;
            } else if (nodeTransform2 != null) {
                node.addChildToBack(nodeTransform2);
            }
            variableDeclaration.addChildToBack(node);
            int i3 = i + 1;
            if (i < size - 1) {
                this.decompiler.addToken(90);
            }
            i = i3;
        }
        return variableDeclaration;
    }

    private Node transformVariables(VariableDeclaration variableDeclaration) {
        this.decompiler.addToken(variableDeclaration.getType());
        transformVariableInitializers(variableDeclaration);
        AstNode parent = variableDeclaration.getParent();
        if (!(parent instanceof Loop) && !(parent instanceof LetNode)) {
            this.decompiler.addEOL(83);
        }
        return variableDeclaration;
    }

    private Node transformWhileLoop(WhileLoop whileLoop) {
        this.decompiler.addToken(118);
        whileLoop.setType(Token.LOOP);
        pushScope(whileLoop);
        try {
            this.decompiler.addToken(88);
            Node nodeTransform = transform(whileLoop.getCondition());
            this.decompiler.addToken(89);
            this.decompiler.addEOL(86);
            Node nodeTransform2 = transform(whileLoop.getBody());
            this.decompiler.addEOL(87);
            return createLoop(whileLoop, 1, nodeTransform2, nodeTransform, null, null);
        } finally {
            popScope();
        }
    }

    private Node transformWith(WithStatement withStatement) {
        this.decompiler.addToken(124);
        this.decompiler.addToken(88);
        Node nodeTransform = transform(withStatement.getExpression());
        this.decompiler.addToken(89);
        this.decompiler.addEOL(86);
        Node nodeTransform2 = transform(withStatement.getStatement());
        this.decompiler.addEOL(87);
        return createWith(nodeTransform, nodeTransform2, withStatement.getLineno());
    }

    private Node transformXmlLiteral(XmlLiteral xmlLiteral) {
        Node nodeCreateBinary;
        Node node = new Node(30, xmlLiteral.getLineno());
        List<XmlFragment> fragments = xmlLiteral.getFragments();
        node.addChildToBack(createName(((XmlString) fragments.get(0)).getXml().trim().startsWith(SimpleComparison.NOT_EQUAL_TO_OPERATION) ? "XMLList" : "XML"));
        Node nodeCreateBinary2 = null;
        for (XmlFragment xmlFragment : fragments) {
            if (xmlFragment instanceof XmlString) {
                String xml = ((XmlString) xmlFragment).getXml();
                this.decompiler.addName(xml);
                if (nodeCreateBinary2 == null) {
                    nodeCreateBinary2 = createString(xml);
                } else {
                    nodeCreateBinary = createString(xml);
                }
            } else {
                XmlExpression xmlExpression = (XmlExpression) xmlFragment;
                boolean zIsXmlAttribute = xmlExpression.isXmlAttribute();
                this.decompiler.addToken(86);
                Node nodeCreateString = xmlExpression.getExpression() instanceof EmptyExpression ? createString("") : transform(xmlExpression.getExpression());
                this.decompiler.addToken(87);
                nodeCreateBinary = zIsXmlAttribute ? createBinary(21, createBinary(21, createString("\""), createUnary(76, nodeCreateString)), createString("\"")) : createUnary(77, nodeCreateString);
            }
            nodeCreateBinary2 = createBinary(21, nodeCreateBinary2, nodeCreateBinary);
        }
        node.addChildToBack(nodeCreateBinary2);
        return node;
    }

    private Node transformXmlMemberGet(XmlMemberGet xmlMemberGet) {
        Decompiler decompiler;
        XmlRef memberRef = xmlMemberGet.getMemberRef();
        Node nodeTransform = transform(xmlMemberGet.getLeft());
        int i = memberRef.isAttributeAccess() ? 2 : 0;
        int type = xmlMemberGet.getType();
        int i2 = Token.DOTDOT;
        if (type == 144) {
            i |= 4;
            decompiler = this.decompiler;
        } else {
            decompiler = this.decompiler;
            i2 = 109;
        }
        decompiler.addToken(i2);
        return transformXmlRef(nodeTransform, memberRef, i);
    }

    private Node transformXmlRef(Node node, XmlRef xmlRef, int i) {
        if ((i & 2) != 0) {
            this.decompiler.addToken(Token.XMLATTR);
        }
        Name namespace = xmlRef.getNamespace();
        String identifier = namespace != null ? namespace.getIdentifier() : null;
        if (identifier != null) {
            this.decompiler.addName(identifier);
            this.decompiler.addToken(Token.COLONCOLON);
        }
        if (xmlRef instanceof XmlPropRef) {
            String identifier2 = ((XmlPropRef) xmlRef).getPropName().getIdentifier();
            this.decompiler.addName(identifier2);
            return createPropertyGet(node, identifier, identifier2, i);
        }
        this.decompiler.addToken(84);
        Node nodeTransform = transform(((XmlElemRef) xmlRef).getExpression());
        this.decompiler.addToken(85);
        return createElementGet(node, identifier, nodeTransform, i);
    }

    private Node transformYield(Yield yield) {
        this.decompiler.addToken(yield.getType());
        Node nodeTransform = yield.getValue() == null ? null : transform(yield.getValue());
        return nodeTransform != null ? new Node(yield.getType(), nodeTransform, yield.getLineno()) : new Node(yield.getType(), yield.getLineno());
    }

    void decompile(AstNode astNode) {
        int type = astNode.getType();
        if (type == 33) {
            decompilePropertyGet((PropertyGet) astNode);
            return;
        }
        if (type == 36) {
            decompileElementGet((ElementGet) astNode);
            return;
        }
        if (type == 43) {
            this.decompiler.addToken(astNode.getType());
            return;
        }
        if (type != 129) {
            if (type == 66) {
                decompileArrayLiteral((ArrayLiteral) astNode);
                return;
            }
            if (type == 67) {
                decompileObjectLiteral((ObjectLiteral) astNode);
                return;
            }
            switch (type) {
                case 39:
                    this.decompiler.addName(((Name) astNode).getIdentifier());
                    break;
                case 40:
                    this.decompiler.addNumber(((NumberLiteral) astNode).getNumber());
                    break;
                case 41:
                    this.decompiler.addString(((StringLiteral) astNode).getValue());
                    break;
                default:
                    Kit.codeBug("unexpected token: " + Token.typeToName(astNode.getType()));
                    break;
            }
        }
    }

    void decompileArrayLiteral(ArrayLiteral arrayLiteral) {
        this.decompiler.addToken(84);
        List<AstNode> elements = arrayLiteral.getElements();
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            decompile(elements.get(i));
            if (i < size - 1) {
                this.decompiler.addToken(90);
            }
        }
        this.decompiler.addToken(85);
    }

    void decompileElementGet(ElementGet elementGet) {
        decompile(elementGet.getTarget());
        this.decompiler.addToken(84);
        decompile(elementGet.getElement());
        this.decompiler.addToken(85);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Code duplicated, block: B:17:0x0037  */
    /* JADX WARN: Code duplicated, block: B:19:0x003a  */
    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:25:0x005b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0067  */
    /* JADX WARN: Code duplicated, block: B:30:0x0070  */
    /* JADX WARN: Code duplicated, block: B:33:0x007d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0062 A[SYNTHETIC] */
    Node decompileFunctionHeader(FunctionNode functionNode) {
        int i;
        boolean z;
        boolean z2;
        List<AstNode> params;
        if (functionNode.getFunctionName() == null) {
            Node nodeTransform = functionNode.getMemberExprNode() != null ? transform(functionNode.getMemberExprNode()) : null;
            if (functionNode.getFunctionType() == 4) {
                z = true;
            } else {
                z = false;
            }
            if (z || functionNode.getLp() != -1) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                this.decompiler.addToken(88);
            }
            params = functionNode.getParams();
            for (i = 0; i < params.size(); i++) {
                decompile(params.get(i));
                if (i < params.size() - 1) {
                    this.decompiler.addToken(90);
                }
            }
            if (!z2) {
                this.decompiler.addToken(89);
            }
            if (z) {
                this.decompiler.addToken(Token.ARROW);
            }
            if (!functionNode.isExpressionClosure()) {
                this.decompiler.addEOL(86);
            }
            return nodeTransform;
        }
        this.decompiler.addName(functionNode.getName());
        if (functionNode.getFunctionType() == 4) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            z2 = false;
        } else {
            z2 = false;
        }
        if (!z2) {
            this.decompiler.addToken(88);
        }
        params = functionNode.getParams();
        while (i < params.size()) {
            decompile(params.get(i));
            if (i < params.size() - 1) {
                this.decompiler.addToken(90);
            }
        }
        if (!z2) {
            this.decompiler.addToken(89);
        }
        if (z) {
            this.decompiler.addToken(Token.ARROW);
        }
        if (!functionNode.isExpressionClosure()) {
            this.decompiler.addEOL(86);
        }
        return nodeTransform;
    }

    void decompileObjectLiteral(ObjectLiteral objectLiteral) {
        this.decompiler.addToken(86);
        List<ObjectProperty> elements = objectLiteral.getElements();
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            ObjectProperty objectProperty = elements.get(i);
            boolean zEquals = Boolean.TRUE.equals(objectProperty.getProp(26));
            decompile(objectProperty.getLeft());
            if (!zEquals) {
                this.decompiler.addToken(104);
                decompile(objectProperty.getRight());
            }
            if (i < size - 1) {
                this.decompiler.addToken(90);
            }
        }
        this.decompiler.addToken(87);
    }

    void decompilePropertyGet(PropertyGet propertyGet) {
        decompile(propertyGet.getTarget());
        this.decompiler.addToken(109);
        decompile(propertyGet.getProperty());
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean isDestructuring(Node node) {
        return (node instanceof DestructuringForm) && ((DestructuringForm) node).isDestructuring();
    }

    public Node transform(AstNode astNode) {
        int type = astNode.getType();
        if (type == 66) {
            return transformArrayLiteral((ArrayLiteral) astNode);
        }
        if (type == 67) {
            return transformObjectLiteral((ObjectLiteral) astNode);
        }
        if (type == 129) {
            return astNode;
        }
        if (type == 130) {
            return transformBlock(astNode);
        }
        switch (type) {
            case 4:
                return transformReturn((ReturnStatement) astNode);
            case 30:
                return transformNewExpr((NewExpression) astNode);
            case 33:
                return transformPropertyGet((PropertyGet) astNode);
            case 36:
                return transformElementGet((ElementGet) astNode);
            case 48:
                return transformRegExp((RegExpLiteral) astNode);
            case 50:
                return transformThrow((ThrowStatement) astNode);
            case 73:
            case Token.YIELD_STAR /* 166 */:
                return transformYield((Yield) astNode);
            case 82:
                return transformTry((TryStatement) astNode);
            case 103:
                return transformCondExpr((ConditionalExpression) astNode);
            case 110:
                return transformFunction((FunctionNode) astNode);
            case 113:
                return transformIf((IfStatement) astNode);
            case 115:
                return transformSwitch((SwitchStatement) astNode);
            case 124:
                return transformWith((WithStatement) astNode);
            case Token.SCRIPT /* 137 */:
                return transformScript((ScriptNode) astNode);
            case Token.ARRAYCOMP /* 158 */:
                return transformArrayComp((ArrayComprehension) astNode);
            case Token.DEBUGGER /* 161 */:
                break;
            case Token.GENEXPR /* 163 */:
                return transformGenExpr((GeneratorExpression) astNode);
            default:
                switch (type) {
                    case 38:
                        return transformFunctionCall((FunctionCall) astNode);
                    case 39:
                        return transformName((Name) astNode);
                    case 40:
                        return transformNumber((NumberLiteral) astNode);
                    case 41:
                        return transformString((StringLiteral) astNode);
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                        break;
                    default:
                        switch (type) {
                            case 118:
                                return transformWhileLoop((WhileLoop) astNode);
                            case 119:
                                return transformDoLoop((DoLoop) astNode);
                            case 120:
                                return astNode instanceof ForInLoop ? transformForInLoop((ForInLoop) astNode) : transformForLoop((ForLoop) astNode);
                            case 121:
                                return transformBreak((BreakStatement) astNode);
                            case 122:
                                return transformContinue((ContinueStatement) astNode);
                            default:
                                if (astNode instanceof ExpressionStatement) {
                                    return transformExprStmt((ExpressionStatement) astNode);
                                }
                                if (astNode instanceof Assignment) {
                                    return transformAssignment((Assignment) astNode);
                                }
                                if (astNode instanceof UnaryExpression) {
                                    return transformUnary((UnaryExpression) astNode);
                                }
                                if (astNode instanceof XmlMemberGet) {
                                    return transformXmlMemberGet((XmlMemberGet) astNode);
                                }
                                if (astNode instanceof InfixExpression) {
                                    return transformInfix((InfixExpression) astNode);
                                }
                                if (astNode instanceof VariableDeclaration) {
                                    return transformVariables((VariableDeclaration) astNode);
                                }
                                if (astNode instanceof ParenthesizedExpression) {
                                    return transformParenExpr((ParenthesizedExpression) astNode);
                                }
                                if (astNode instanceof LabeledStatement) {
                                    return transformLabeledStatement((LabeledStatement) astNode);
                                }
                                if (astNode instanceof LetNode) {
                                    return transformLetNode((LetNode) astNode);
                                }
                                if (astNode instanceof XmlRef) {
                                    return transformXmlRef((XmlRef) astNode);
                                }
                                if (astNode instanceof XmlLiteral) {
                                    return transformXmlLiteral((XmlLiteral) astNode);
                                }
                                throw new IllegalArgumentException("Can't transform: " + astNode);
                        }
                }
                break;
        }
        return transformLiteral(astNode);
    }

    public ScriptNode transformTree(AstRoot astRoot) {
        this.currentScriptOrFn = astRoot;
        this.inUseStrictDirective = astRoot.isInStrictMode();
        int currentOffset = this.decompiler.getCurrentOffset();
        ScriptNode scriptNode = (ScriptNode) transform(astRoot);
        scriptNode.setEncodedSourceBounds(currentOffset, this.decompiler.getCurrentOffset());
        if (this.compilerEnv.isGeneratingSource()) {
            scriptNode.setEncodedSource(this.decompiler.getEncodedSource());
        }
        this.decompiler = null;
        return scriptNode;
    }

    public IRFactory(CompilerEnvirons compilerEnvirons) {
        this(compilerEnvirons, compilerEnvirons.getErrorReporter());
    }

    private Node transformXmlRef(XmlRef xmlRef) {
        return transformXmlRef(null, xmlRef, xmlRef.isAttributeAccess() ? 2 : 0);
    }

    public IRFactory(CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter) {
        super(compilerEnvirons, errorReporter);
        this.decompiler = new Decompiler();
    }
}
