package external.sdk.pendo.io.mozilla.javascript;

import external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode;
import external.sdk.pendo.io.mozilla.javascript.ast.Jump;
import external.sdk.pendo.io.mozilla.javascript.ast.Scope;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class NodeTransformer {
    private boolean hasFinally;
    private ObjArray loopEnds;
    private ObjArray loops;

    private static Node addBeforeCurrent(Node node, Node node2, Node node3, Node node4) {
        if (node2 == null) {
            if (node3 != node.getFirstChild()) {
                Kit.codeBug();
            }
            node.addChildToFront(node4);
            return node4;
        }
        if (node3 != node2.getNext()) {
            Kit.codeBug();
        }
        node.addChildAfter(node4, node2);
        return node4;
    }

    private static Node replaceCurrent(Node node, Node node2, Node node3, Node node4) {
        if (node2 == null) {
            if (node3 != node.getFirstChild()) {
                Kit.codeBug();
            }
        } else if (node2.next == node3) {
            node.replaceChildAfter(node2, node4);
            return node4;
        }
        node.replaceChild(node3, node4);
        return node4;
    }

    private void transformCompilationUnit(ScriptNode scriptNode, boolean z) {
        this.loops = new ObjArray();
        this.loopEnds = new ObjArray();
        this.hasFinally = false;
        boolean z2 = scriptNode.getType() != 110 || ((FunctionNode) scriptNode).requiresActivation();
        scriptNode.flattenSymbolTable(!z2);
        transformCompilationUnit_r(scriptNode, scriptNode, scriptNode, z2, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:109:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:114:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:151:0x026f  */
    /* JADX WARN: Code duplicated, block: B:153:0x0276 A[LOOP:4: B:153:0x0276->B:155:0x027e, LOOP_START, PHI: r4
      0x0276: PHI (r4v9 external.sdk.pendo.io.mozilla.javascript.Node) = (r4v7 external.sdk.pendo.io.mozilla.javascript.Node), (r4v12 external.sdk.pendo.io.mozilla.javascript.Node) binds: [B:152:0x0274, B:155:0x027e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:155:0x027e A[LOOP:4: B:153:0x0276->B:155:0x027e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:160:0x0293  */
    /* JADX WARN: Code duplicated, block: B:162:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:165:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:167:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:172:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:207:0x0370  */
    /* JADX WARN: Code duplicated, block: B:214:0x038e  */
    /* JADX WARN: Code duplicated, block: B:215:0x0392  */
    /* JADX WARN: Code duplicated, block: B:220:0x01ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:236:0x01ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0139  */
    /* JADX WARN: Code duplicated, block: B:79:0x0143  */
    /* JADX WARN: Code duplicated, block: B:85:0x0158  */
    /* JADX WARN: Code duplicated, block: B:87:0x015f  */
    /* JADX WARN: Code duplicated, block: B:89:0x016c  */
    /* JADX WARN: Code duplicated, block: B:91:0x0176  */
    /* JADX WARN: Code duplicated, block: B:94:0x017d  */
    /* JADX WARN: Code duplicated, block: B:96:0x018d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0190  */
    /* JADX WARN: Code duplicated, block: B:99:0x0197  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [external.sdk.pendo.io.mozilla.javascript.NodeTransformer] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [external.sdk.pendo.io.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r4v27, types: [external.sdk.pendo.io.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r4v33, types: [external.sdk.pendo.io.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35, types: [external.sdk.pendo.io.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r4v38 */
    private void transformCompilationUnit_r(ScriptNode scriptNode, Node node, Scope scope, boolean z, boolean z2) {
        ?? AddBeforeCurrent;
        Scope scope2;
        int i;
        Node node2;
        Node node3;
        Jump jump;
        Node firstChild;
        Node firstChild2;
        Node lastChild;
        Node firstChild3;
        Scope definingScope;
        int i2;
        Node next;
        boolean z3;
        Node node4;
        Node firstChild4;
        int i3;
        ?? r0 = this;
        scriptNode = scriptNode;
        scope = scope;
        Map<String, external.sdk.pendo.io.mozilla.javascript.ast.Symbol> map = null;
        Node next2 = null;
        while (true) {
            if (next2 == null) {
                next2 = node.getFirstChild();
                AddBeforeCurrent = map;
            } else {
                AddBeforeCurrent = next2;
                next2 = next2.getNext();
            }
            if (next2 == null) {
                return;
            }
            int type = next2.getType();
            if (z && ((type == 130 || type == 133 || type == 158) && (next2 instanceof Scope))) {
                Scope scope3 = (Scope) next2;
                if (scope3.getSymbolTable() != null) {
                    Node node5 = new Node(type == 158 ? 159 : 154);
                    Node node6 = new Node(Token.LET);
                    node5.addChildToBack(node6);
                    Iterator<String> it = scope3.getSymbolTable().keySet().iterator();
                    while (it.hasNext()) {
                        node6.addChildToBack(Node.newString(39, it.next()));
                    }
                    scope3.setSymbolTable(map);
                    Node nodeReplaceCurrent = replaceCurrent(node, AddBeforeCurrent, next2, node5);
                    int type2 = nodeReplaceCurrent.getType();
                    node5.addChildToBack(next2);
                    next2 = nodeReplaceCurrent;
                    type = type2;
                }
            }
            if (type != 3) {
                boolean z4 = false;
                if (type == 4) {
                    if (scriptNode.getType() == 110 && ((FunctionNode) scriptNode).isGenerator()) {
                        z4 = true;
                    }
                    if (z4) {
                        i = 1;
                        next2.putIntProp(20, 1);
                    } else {
                        i = 1;
                    }
                    if (r0.hasFinally) {
                        int size = r0.loops.size() - i;
                        Node node7 = null;
                        while (size >= 0) {
                            Node node8 = (Node) r0.loops.get(size);
                            int type3 = node8.getType();
                            if (type3 == 82 || type3 == 124) {
                                if (type3 == 82) {
                                    jump = new Jump(136);
                                    jump.target = ((Jump) node8).getFinally();
                                } else {
                                    node2 = new Node(3);
                                }
                                if (node7 == null) {
                                    node3 = node2;
                                    node3 = jump;
                                    node7 = new Node(130, next2.getLineno());
                                } else {
                                    node3 = node2;
                                    node3 = jump;
                                    node7 = node7;
                                }
                                node7.addChildToBack(node3);
                            }
                            size--;
                            node7 = node7;
                        }
                        if (node7 != null) {
                            Node firstChild5 = next2.getFirstChild();
                            Node nodeReplaceCurrent2 = replaceCurrent(node, AddBeforeCurrent, next2, node7);
                            if (firstChild5 == null || z4) {
                                node7.addChildToBack(next2);
                            } else {
                                Node node9 = new Node(135, firstChild5);
                                node7.addChildToFront(node9);
                                node7.addChildToBack(new Node(65));
                                r0.transformCompilationUnit_r(scriptNode, node9, scope, z, z2);
                            }
                            next2 = nodeReplaceCurrent2;
                        }
                    }
                } else if (type == 7) {
                    firstChild = next2.getFirstChild();
                    if (type == 7) {
                        while (firstChild.getType() == 26) {
                            firstChild = firstChild.getFirstChild();
                        }
                        if (firstChild.getType() != 12 || firstChild.getType() == 13) {
                            firstChild2 = firstChild.getFirstChild();
                            lastChild = firstChild.getLastChild();
                            if (firstChild2.getType() != 39 && firstChild2.getString().equals("undefined")) {
                                firstChild = lastChild;
                            } else if (lastChild.getType() == 39 && lastChild.getString().equals("undefined")) {
                                firstChild = firstChild2;
                            }
                        }
                    }
                    if (firstChild.getType() == 33) {
                        firstChild.setType(34);
                    }
                } else {
                    if (type != 8) {
                        if (type == 38) {
                            r0.visitCall(next2, scriptNode);
                        } else if (type != 39) {
                            if (type == 73) {
                                ((FunctionNode) scriptNode).addResumptionPoint(next2);
                            } else if (type == 82) {
                                next = ((Jump) next2).getFinally();
                                if (next != null) {
                                    r0.hasFinally = true;
                                    r0.loops.push(next2);
                                    r0.loopEnds.push(next);
                                }
                            } else if (type == 115) {
                                r0.loops.push(next2);
                                r0.loopEnds.push(((Jump) next2).target);
                            } else if (type == 138) {
                                Scope definingScope2 = scope.getDefiningScope(next2.getString());
                                if (definingScope2 != null) {
                                    next2.setScope(definingScope2);
                                }
                            } else if (type == 159) {
                                if (next2.getFirstChild().getType() != 154) {
                                    if (scriptNode.getType() == 110 || ((FunctionNode) scriptNode).requiresActivation()) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    next2 = r0.visitLet(z3, node, AddBeforeCurrent, next2);
                                } else {
                                    node4 = new Node(130);
                                    firstChild4 = next2.getFirstChild();
                                    while (firstChild4 != null) {
                                        Node next3 = firstChild4.getNext();
                                        if (firstChild4.getType() == 39) {
                                            if (!firstChild4.hasChildren()) {
                                                Node firstChild6 = firstChild4.getFirstChild();
                                                firstChild4.removeChild(firstChild6);
                                                firstChild4.setType(49);
                                                if (type == 155) {
                                                    i3 = Token.SETCONST;
                                                } else {
                                                    i3 = 8;
                                                }
                                                firstChild4 = new Node(i3, firstChild4, firstChild6);
                                            }
                                            firstChild4 = next3;
                                        } else if (firstChild4.getType() != 159) {
                                            throw Kit.codeBug();
                                        }
                                        node4.addChildToBack(new Node(134, firstChild4, next2.getLineno()));
                                        firstChild4 = next3;
                                    }
                                    next2 = replaceCurrent(node, AddBeforeCurrent, next2, node4);
                                }
                            } else if (type != 166) {
                                switch (type) {
                                    case 30:
                                        r0.visitNew(next2, scriptNode);
                                        break;
                                    case 31:
                                        break;
                                    case 32:
                                        firstChild = next2.getFirstChild();
                                        if (type == 7) {
                                            while (firstChild.getType() == 26) {
                                                firstChild = firstChild.getFirstChild();
                                            }
                                            if (firstChild.getType() != 12) {
                                                firstChild2 = firstChild.getFirstChild();
                                                lastChild = firstChild.getLastChild();
                                                if (firstChild2.getType() != 39) {
                                                    if (lastChild.getType() == 39) {
                                                        firstChild = firstChild2;
                                                    }
                                                } else if (lastChild.getType() == 39) {
                                                    firstChild = firstChild2;
                                                }
                                            } else {
                                                firstChild2 = firstChild.getFirstChild();
                                                lastChild = firstChild.getLastChild();
                                                if (firstChild2.getType() != 39) {
                                                    if (lastChild.getType() == 39) {
                                                        firstChild = firstChild2;
                                                    }
                                                } else if (lastChild.getType() == 39) {
                                                    firstChild = firstChild2;
                                                }
                                            }
                                        }
                                        if (firstChild.getType() == 33) {
                                            firstChild.setType(34);
                                        }
                                        break;
                                    default:
                                        switch (type) {
                                            case 121:
                                            case 122:
                                                Jump jump2 = (Jump) next2;
                                                Jump jumpStatement = jump2.getJumpStatement();
                                                if (jumpStatement == null) {
                                                    Kit.codeBug();
                                                }
                                                int size2 = r0.loops.size();
                                                while (true) {
                                                    if (size2 == 0) {
                                                        throw Kit.codeBug();
                                                    }
                                                    size2--;
                                                    Node node10 = (Node) r0.loops.get(size2);
                                                    if (node10 == jumpStatement) {
                                                        jump2.target = type == 121 ? jumpStatement.target : jumpStatement.getContinue();
                                                        jump2.setType(5);
                                                        break;
                                                    } else {
                                                        int type4 = node10.getType();
                                                        if (type4 == 124) {
                                                            AddBeforeCurrent = addBeforeCurrent(node, AddBeforeCurrent, next2, new Node(3));
                                                        } else if (type4 == 82) {
                                                            Jump jump3 = new Jump(136);
                                                            jump3.target = ((Jump) node10).getFinally();
                                                            AddBeforeCurrent = addBeforeCurrent(node, AddBeforeCurrent, next2, jump3);
                                                        }
                                                    }
                                                }
                                                break;
                                            case 123:
                                                node4 = new Node(130);
                                                firstChild4 = next2.getFirstChild();
                                                while (firstChild4 != null) {
                                                    Node next4 = firstChild4.getNext();
                                                    if (firstChild4.getType() == 39) {
                                                        if (!firstChild4.hasChildren()) {
                                                            Node firstChild7 = firstChild4.getFirstChild();
                                                            firstChild4.removeChild(firstChild7);
                                                            firstChild4.setType(49);
                                                            if (type == 155) {
                                                                i3 = Token.SETCONST;
                                                            } else {
                                                                i3 = 8;
                                                            }
                                                            firstChild4 = new Node(i3, firstChild4, firstChild7);
                                                        }
                                                        firstChild4 = next4;
                                                    } else if (firstChild4.getType() != 159) {
                                                        throw Kit.codeBug();
                                                    }
                                                    node4.addChildToBack(new Node(134, firstChild4, next2.getLineno()));
                                                    firstChild4 = next4;
                                                }
                                                next2 = replaceCurrent(node, AddBeforeCurrent, next2, node4);
                                                break;
                                            case 124:
                                                r0.loops.push(next2);
                                                next = next2.getNext();
                                                if (next.getType() != 3) {
                                                    Kit.codeBug();
                                                }
                                                r0.loopEnds.push(next);
                                                break;
                                            default:
                                                switch (type) {
                                                    case Token.LABEL /* 131 */:
                                                    case Token.LOOP /* 133 */:
                                                        r0.loops.push(next2);
                                                        r0.loopEnds.push(((Jump) next2).target);
                                                        break;
                                                    case Token.TARGET /* 132 */:
                                                        if (!r0.loopEnds.isEmpty() && r0.loopEnds.peek() == next2) {
                                                            r0.loopEnds.pop();
                                                            r0.loops.pop();
                                                        }
                                                        break;
                                                    default:
                                                        switch (type) {
                                                            case Token.LET /* 154 */:
                                                                if (next2.getFirstChild().getType() != 154) {
                                                                    node4 = new Node(130);
                                                                    firstChild4 = next2.getFirstChild();
                                                                    while (firstChild4 != null) {
                                                                        Node next5 = firstChild4.getNext();
                                                                        if (firstChild4.getType() == 39) {
                                                                            if (!firstChild4.hasChildren()) {
                                                                                Node firstChild8 = firstChild4.getFirstChild();
                                                                                firstChild4.removeChild(firstChild8);
                                                                                firstChild4.setType(49);
                                                                                if (type == 155) {
                                                                                    i3 = Token.SETCONST;
                                                                                } else {
                                                                                    i3 = 8;
                                                                                }
                                                                                firstChild4 = new Node(i3, firstChild4, firstChild8);
                                                                            }
                                                                            firstChild4 = next5;
                                                                        } else if (firstChild4.getType() != 159) {
                                                                            throw Kit.codeBug();
                                                                        }
                                                                        node4.addChildToBack(new Node(134, firstChild4, next2.getLineno()));
                                                                        firstChild4 = next5;
                                                                    }
                                                                    next2 = replaceCurrent(node, AddBeforeCurrent, next2, node4);
                                                                } else {
                                                                    if (scriptNode.getType() == 110) {
                                                                        z3 = true;
                                                                    } else {
                                                                        z3 = true;
                                                                    }
                                                                    next2 = r0.visitLet(z3, node, AddBeforeCurrent, next2);
                                                                }
                                                                break;
                                                            case Token.CONST /* 155 */:
                                                                node4 = new Node(130);
                                                                firstChild4 = next2.getFirstChild();
                                                                while (firstChild4 != null) {
                                                                    Node next6 = firstChild4.getNext();
                                                                    if (firstChild4.getType() == 39) {
                                                                        if (!firstChild4.hasChildren()) {
                                                                            Node firstChild9 = firstChild4.getFirstChild();
                                                                            firstChild4.removeChild(firstChild9);
                                                                            firstChild4.setType(49);
                                                                            if (type == 155) {
                                                                                i3 = Token.SETCONST;
                                                                            } else {
                                                                                i3 = 8;
                                                                            }
                                                                            firstChild4 = new Node(i3, firstChild4, firstChild9);
                                                                        }
                                                                        firstChild4 = next6;
                                                                    } else if (firstChild4.getType() != 159) {
                                                                        throw Kit.codeBug();
                                                                    }
                                                                    node4.addChildToBack(new Node(134, firstChild4, next2.getLineno()));
                                                                    firstChild4 = next6;
                                                                }
                                                                next2 = replaceCurrent(node, AddBeforeCurrent, next2, node4);
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                            } else {
                                ((FunctionNode) scriptNode).addResumptionPoint(next2);
                            }
                        }
                    } else if (z2) {
                        next2.setType(74);
                    }
                    if (!z) {
                        if (type == 39) {
                            firstChild3 = next2;
                        } else {
                            firstChild3 = next2.getFirstChild();
                            if (firstChild3.getType() != 49) {
                                if (type != 31) {
                                    throw Kit.codeBug();
                                }
                            }
                        }
                        if (firstChild3.getScope() == null && (definingScope = scope.getDefiningScope(firstChild3.getString())) != null) {
                            firstChild3.setScope(definingScope);
                            if (type == 39) {
                                next2.setType(55);
                            } else {
                                if (type == 8 || type == 74) {
                                    i2 = 56;
                                } else if (type == 156) {
                                    i2 = Token.SETCONSTVAR;
                                } else {
                                    if (type != 31) {
                                        throw Kit.codeBug();
                                    }
                                    next2 = replaceCurrent(node, AddBeforeCurrent, next2, new Node(44));
                                }
                                next2.setType(i2);
                                firstChild3.setType(41);
                            }
                        }
                    }
                }
                if (next2 instanceof Scope) {
                    scope2 = (Scope) next2;
                } else {
                    scope2 = scope;
                }
                r0.transformCompilationUnit_r(scriptNode, next2, scope2, z, z2);
                r0 = this;
            } else {
                if (!r0.loopEnds.isEmpty()) {
                    r0.loopEnds.pop();
                    r0.loops.pop();
                }
                if (next2 instanceof Scope) {
                    scope2 = (Scope) next2;
                } else {
                    scope2 = scope;
                }
                r0.transformCompilationUnit_r(scriptNode, next2, scope2, z, z2);
                r0 = this;
            }
            map = null;
            r0 = r0;
        }
    }

    public final void transform(ScriptNode scriptNode, CompilerEnvirons compilerEnvirons) {
        transform(scriptNode, false, compilerEnvirons);
    }

    protected void visitCall(Node node, ScriptNode scriptNode) {
    }

    /* JADX WARN: Code duplicated, block: B:73:0x01c0  */
    protected Node visitLet(boolean z, Node node, Node node2, Node node3) {
        Node node4;
        Node firstChild;
        Node node5;
        Node firstChild2;
        Node firstChild3 = node3.getFirstChild();
        Node next = firstChild3.getNext();
        node3.removeChild(firstChild3);
        node3.removeChild(next);
        int type = node3.getType();
        int i = Token.LETEXPR;
        boolean z2 = type == 159;
        int i2 = Token.LET;
        if (z) {
            Node nodeReplaceCurrent = replaceCurrent(node, node2, node3, new Node(z2 ? 160 : 130));
            ArrayList arrayList = new ArrayList();
            Node node6 = new Node(67);
            Node firstChild4 = firstChild3.getFirstChild();
            while (firstChild4 != null) {
                if (firstChild4.getType() == i) {
                    List list = (List) firstChild4.getProp(22);
                    Node firstChild5 = firstChild4.getFirstChild();
                    if (firstChild5.getType() != i2) {
                        throw Kit.codeBug();
                    }
                    node5 = z2 ? new Node(90, firstChild5.getNext(), next) : new Node(130, new Node(134, firstChild5.getNext()), next);
                    if (list != null) {
                        arrayList.addAll(list);
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            node6.addChildToBack(new Node(127, Node.newNumber(0.0d)));
                        }
                    }
                    firstChild2 = firstChild5.getFirstChild();
                } else {
                    node5 = next;
                    firstChild2 = firstChild4;
                }
                if (firstChild2.getType() != 39) {
                    throw Kit.codeBug();
                }
                arrayList.add(ScriptRuntime.getIndexObject(firstChild2.getString()));
                Node firstChild6 = firstChild2.getFirstChild();
                if (firstChild6 == null) {
                    firstChild6 = new Node(127, Node.newNumber(0.0d));
                }
                node6.addChildToBack(firstChild6);
                firstChild4 = firstChild4.getNext();
                next = node5;
                i = Token.LETEXPR;
                i2 = Token.LET;
            }
            node6.putProp(12, arrayList.toArray());
            nodeReplaceCurrent.addChildToBack(new Node(2, node6));
            nodeReplaceCurrent.addChildToBack(new Node(124, next));
            nodeReplaceCurrent.addChildToBack(new Node(3));
            return nodeReplaceCurrent;
        }
        Node nodeReplaceCurrent2 = replaceCurrent(node, node2, node3, new Node(z2 ? 90 : 130));
        Node node7 = new Node(90);
        Node firstChild7 = firstChild3.getFirstChild();
        while (firstChild7 != null) {
            if (firstChild7.getType() == 159) {
                Node firstChild8 = firstChild7.getFirstChild();
                if (firstChild8.getType() != 154) {
                    throw Kit.codeBug();
                }
                node4 = z2 ? new Node(90, firstChild8.getNext(), next) : new Node(130, new Node(134, firstChild8.getNext()), next);
                Scope.joinScopes((Scope) firstChild7, (Scope) node3);
                firstChild = firstChild8.getFirstChild();
            } else {
                node4 = next;
                firstChild = firstChild7;
            }
            if (firstChild.getType() != 39) {
                throw Kit.codeBug();
            }
            Node nodeNewString = Node.newString(firstChild.getString());
            nodeNewString.setScope((Scope) node3);
            Node firstChild9 = firstChild.getFirstChild();
            if (firstChild9 == null) {
                firstChild9 = new Node(127, Node.newNumber(0.0d));
            }
            node7.addChildToBack(new Node(56, nodeNewString, firstChild9));
            firstChild7 = firstChild7.getNext();
            next = node4;
        }
        if (z2) {
            nodeReplaceCurrent2.addChildToBack(node7);
            node3.setType(90);
            nodeReplaceCurrent2.addChildToBack(node3);
            node3.addChildToBack(next);
            if (next instanceof Scope) {
                Scope scope = (Scope) next;
                Scope parentScope = scope.getParentScope();
                Scope scope2 = (Scope) node3;
                scope.setParentScope(scope2);
                scope2.setParentScope(parentScope);
            }
        } else {
            nodeReplaceCurrent2.addChildToBack(new Node(134, node7));
            node3.setType(130);
            nodeReplaceCurrent2.addChildToBack(node3);
            node3.addChildrenToBack(next);
            if (next instanceof Scope) {
                Scope scope3 = (Scope) next;
                Scope parentScope2 = scope3.getParentScope();
                Scope scope4 = (Scope) node3;
                scope3.setParentScope(scope4);
                scope4.setParentScope(parentScope2);
            }
        }
        return nodeReplaceCurrent2;
    }

    protected void visitNew(Node node, ScriptNode scriptNode) {
    }

    public final void transform(ScriptNode scriptNode, boolean z, CompilerEnvirons compilerEnvirons) {
        if (compilerEnvirons.getLanguageVersion() >= 200 && scriptNode.isInStrictMode()) {
            z = true;
        }
        transformCompilationUnit(scriptNode, z);
        for (int i = 0; i != scriptNode.getFunctionCount(); i++) {
            transform(scriptNode.getFunctionNode(i), z, compilerEnvirons);
        }
    }
}
