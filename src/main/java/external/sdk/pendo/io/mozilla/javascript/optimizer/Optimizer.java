package external.sdk.pendo.io.mozilla.javascript.optimizer;

import external.sdk.pendo.io.mozilla.javascript.Node;
import external.sdk.pendo.io.mozilla.javascript.ObjArray;
import external.sdk.pendo.io.mozilla.javascript.Token;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;

/* JADX INFO: loaded from: classes4.dex */
class Optimizer {
    static final int AnyType = 3;
    static final int NoType = 0;
    static final int NumberType = 1;
    private boolean inDirectCallFunction;
    private boolean parameterUsedInNumberContext;
    OptFunctionNode theFunction;

    Optimizer() {
    }

    private static void buildStatementList_r(Node node, ObjArray objArray) {
        int type = node.getType();
        if (type != 130 && type != 142 && type != 133 && type != 110) {
            objArray.add(node);
            return;
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            buildStatementList_r(firstChild, objArray);
        }
    }

    private boolean convertParameter(Node node) {
        if (!this.inDirectCallFunction || node.getType() != 55) {
            return false;
        }
        if (!this.theFunction.isParameter(this.theFunction.getVarIndex(node))) {
            return false;
        }
        node.removeProp(8);
        return true;
    }

    private void markDCPNumberContext(Node node) {
        if (this.inDirectCallFunction && node.getType() == 55) {
            if (this.theFunction.isParameter(this.theFunction.getVarIndex(node))) {
                this.parameterUsedInNumberContext = true;
            }
        }
    }

    private void optimizeFunction(OptFunctionNode optFunctionNode) {
        if (optFunctionNode.fnode.requiresActivation()) {
            return;
        }
        this.inDirectCallFunction = optFunctionNode.isTargetOfDirectCall();
        this.theFunction = optFunctionNode;
        ObjArray objArray = new ObjArray();
        buildStatementList_r(optFunctionNode.fnode, objArray);
        int size = objArray.size();
        Node[] nodeArr = new Node[size];
        objArray.toArray(nodeArr);
        Block.runFlowAnalyzes(optFunctionNode, nodeArr);
        if (optFunctionNode.fnode.requiresActivation()) {
            return;
        }
        this.parameterUsedInNumberContext = false;
        for (int i = 0; i < size; i++) {
            rewriteForNumberVariables(nodeArr[i], 1);
        }
        optFunctionNode.setParameterNumberContext(this.parameterUsedInNumberContext);
    }

    private void rewriteAsObjectChildren(Node node, Node node2) {
        while (node2 != null) {
            Node next = node2.getNext();
            if (rewriteForNumberVariables(node2, 0) == 1 && !convertParameter(node2)) {
                node.removeChild(node2);
                Node node3 = new Node(150, node2);
                if (next == null) {
                    node.addChildToBack(node3);
                } else {
                    node.addChildBefore(node3, next);
                }
            }
            node2 = next;
        }
    }

    /* JADX WARN: Code duplicated, block: B:127:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:141:0x020e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:142:0x0210  */
    /* JADX WARN: Code duplicated, block: B:143:0x021d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:0x007a  */
    /* JADX WARN: Code duplicated, block: B:41:0x007e A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:43:0x0096 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x0098  */
    /* JADX WARN: Code duplicated, block: B:46:0x009c  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:60:0x00df  */
    /* JADX WARN: Code duplicated, block: B:78:0x0121  */
    private int rewriteForNumberVariables(Node node, int i) {
        Node next;
        int iRewriteForNumberVariables;
        int varIndex;
        Node firstChild;
        Node next2;
        int iRewriteForNumberVariables2;
        int iRewriteForNumberVariables3;
        int type = node.getType();
        if (type == 40) {
            node.putIntProp(8, 0);
            return 1;
        }
        if (type == 134) {
            if (rewriteForNumberVariables(node.getFirstChild(), 1) == 1) {
                node.putIntProp(8, 0);
            }
            return 0;
        }
        if (type != 141) {
            if (type == 157) {
                next = node.getFirstChild().getNext();
                iRewriteForNumberVariables = rewriteForNumberVariables(next, 1);
                varIndex = this.theFunction.getVarIndex(node);
                if (!this.inDirectCallFunction && this.theFunction.isParameter(varIndex)) {
                    if (iRewriteForNumberVariables != 1) {
                        return iRewriteForNumberVariables;
                    }
                    if (convertParameter(next)) {
                        markDCPNumberContext(next);
                        return 0;
                    }
                    node.putIntProp(8, 0);
                    return 1;
                }
                if (this.theFunction.isNumberVar(varIndex)) {
                    if (iRewriteForNumberVariables == 1 && !convertParameter(next)) {
                        node.removeChild(next);
                        node.addChildToBack(new Node(150, next));
                    }
                    return 0;
                }
                if (iRewriteForNumberVariables != 1) {
                    node.removeChild(next);
                    node.addChildToBack(new Node(Token.TO_DOUBLE, next));
                }
            } else {
                if (type == 55) {
                    int varIndex2 = this.theFunction.getVarIndex(node);
                    if (this.inDirectCallFunction && this.theFunction.isParameter(varIndex2) && i == 1) {
                        node.putIntProp(8, 0);
                        return 1;
                    }
                    if (!this.theFunction.isNumberVar(varIndex2)) {
                        return 0;
                    }
                    node.putIntProp(8, 0);
                    return 1;
                }
                if (type == 56) {
                    next = node.getFirstChild().getNext();
                    iRewriteForNumberVariables = rewriteForNumberVariables(next, 1);
                    varIndex = this.theFunction.getVarIndex(node);
                    if (!this.inDirectCallFunction) {
                    }
                    if (this.theFunction.isNumberVar(varIndex)) {
                        if (iRewriteForNumberVariables == 1) {
                            node.removeChild(next);
                            node.addChildToBack(new Node(150, next));
                        }
                        return 0;
                    }
                    if (iRewriteForNumberVariables != 1) {
                        node.removeChild(next);
                        node.addChildToBack(new Node(Token.TO_DOUBLE, next));
                    }
                } else if (type == 107 || type == 108) {
                    next = node.getFirstChild();
                    int iRewriteForNumberVariables4 = rewriteForNumberVariables(next, 1);
                    if (next.getType() != 55) {
                        if (next.getType() == 36 || next.getType() == 33) {
                            return iRewriteForNumberVariables4;
                        }
                        return 0;
                    }
                    if (iRewriteForNumberVariables4 != 1 || convertParameter(next)) {
                        return 0;
                    }
                } else {
                    switch (type) {
                        default:
                            switch (type) {
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    Node firstChild2 = node.getFirstChild();
                                    Node next3 = firstChild2.getNext();
                                    int iRewriteForNumberVariables5 = rewriteForNumberVariables(firstChild2, 1);
                                    int iRewriteForNumberVariables6 = rewriteForNumberVariables(next3, 1);
                                    markDCPNumberContext(firstChild2);
                                    markDCPNumberContext(next3);
                                    boolean zConvertParameter = convertParameter(firstChild2);
                                    boolean zConvertParameter2 = convertParameter(next3);
                                    if (zConvertParameter) {
                                        if (!zConvertParameter2 && iRewriteForNumberVariables6 == 1) {
                                            node.putIntProp(8, 2);
                                        }
                                    } else if (zConvertParameter2) {
                                        if (iRewriteForNumberVariables5 == 1) {
                                            node.putIntProp(8, 1);
                                        }
                                    } else if (iRewriteForNumberVariables5 == 1) {
                                        if (iRewriteForNumberVariables6 == 1) {
                                            node.putIntProp(8, 0);
                                        } else {
                                            node.putIntProp(8, 1);
                                        }
                                    } else if (iRewriteForNumberVariables6 == 1) {
                                        node.putIntProp(8, 2);
                                    }
                                    return 0;
                                default:
                                    switch (type) {
                                        case 21:
                                            Node firstChild3 = node.getFirstChild();
                                            Node next4 = firstChild3.getNext();
                                            int iRewriteForNumberVariables7 = rewriteForNumberVariables(firstChild3, 1);
                                            int iRewriteForNumberVariables8 = rewriteForNumberVariables(next4, 1);
                                            boolean zConvertParameter3 = convertParameter(firstChild3);
                                            boolean zConvertParameter4 = convertParameter(next4);
                                            if (zConvertParameter3) {
                                                if (!zConvertParameter4 && iRewriteForNumberVariables8 == 1) {
                                                    node.putIntProp(8, 2);
                                                }
                                            } else if (zConvertParameter4) {
                                                if (iRewriteForNumberVariables7 == 1) {
                                                    node.putIntProp(8, 1);
                                                }
                                            } else if (iRewriteForNumberVariables7 == 1) {
                                                if (iRewriteForNumberVariables8 == 1) {
                                                    node.putIntProp(8, 0);
                                                    return 1;
                                                }
                                                node.putIntProp(8, 1);
                                            } else if (iRewriteForNumberVariables8 == 1) {
                                                node.putIntProp(8, 2);
                                            }
                                            return 0;
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 25:
                                            break;
                                        default:
                                            switch (type) {
                                                case 36:
                                                    Node firstChild4 = node.getFirstChild();
                                                    Node next5 = firstChild4.getNext();
                                                    if (rewriteForNumberVariables(firstChild4, 1) == 1 && !convertParameter(firstChild4)) {
                                                        node.removeChild(firstChild4);
                                                        node.addChildToFront(new Node(150, firstChild4));
                                                    }
                                                    if (rewriteForNumberVariables(next5, 1) == 1 && !convertParameter(next5)) {
                                                        node.putIntProp(8, 2);
                                                    }
                                                    return 0;
                                                case 37:
                                                    break;
                                                case 38:
                                                    Node firstChild5 = node.getFirstChild();
                                                    rewriteAsObjectChildren(firstChild5, firstChild5.getFirstChild());
                                                    Node next6 = firstChild5.getNext();
                                                    if (((OptFunctionNode) node.getProp(9)) != null) {
                                                        while (next6 != null) {
                                                            if (rewriteForNumberVariables(next6, 1) == 1) {
                                                                markDCPNumberContext(next6);
                                                            }
                                                            next6 = next6.getNext();
                                                        }
                                                    } else {
                                                        rewriteAsObjectChildren(node, next6);
                                                    }
                                                    return 0;
                                                default:
                                                    rewriteAsObjectChildren(node, node.getFirstChild());
                                                    return 0;
                                            }
                                            break;
                                    }
                                case 18:
                                case 19:
                                    firstChild = node.getFirstChild();
                                    next2 = firstChild.getNext();
                                    iRewriteForNumberVariables2 = rewriteForNumberVariables(firstChild, 1);
                                    iRewriteForNumberVariables3 = rewriteForNumberVariables(next2, 1);
                                    markDCPNumberContext(firstChild);
                                    markDCPNumberContext(next2);
                                    if (iRewriteForNumberVariables2 == 1) {
                                        if (iRewriteForNumberVariables3 == 1) {
                                            node.putIntProp(8, 0);
                                            return 1;
                                        }
                                        if (!convertParameter(next2)) {
                                            node.removeChild(next2);
                                            node.addChildToBack(new Node(Token.TO_DOUBLE, next2));
                                            node.putIntProp(8, 0);
                                        }
                                        return 1;
                                    }
                                    if (iRewriteForNumberVariables3 == 1) {
                                        if (!convertParameter(firstChild)) {
                                            node.removeChild(firstChild);
                                            node.addChildToFront(new Node(Token.TO_DOUBLE, firstChild));
                                            node.putIntProp(8, 0);
                                        }
                                        return 1;
                                    }
                                    if (!convertParameter(firstChild)) {
                                        node.removeChild(firstChild);
                                        node.addChildToFront(new Node(Token.TO_DOUBLE, firstChild));
                                    }
                                    if (!convertParameter(next2)) {
                                        node.removeChild(next2);
                                        node.addChildToBack(new Node(Token.TO_DOUBLE, next2));
                                    }
                                    node.putIntProp(8, 0);
                                    return 1;
                            }
                        case 9:
                        case 10:
                        case 11:
                            firstChild = node.getFirstChild();
                            next2 = firstChild.getNext();
                            iRewriteForNumberVariables2 = rewriteForNumberVariables(firstChild, 1);
                            iRewriteForNumberVariables3 = rewriteForNumberVariables(next2, 1);
                            markDCPNumberContext(firstChild);
                            markDCPNumberContext(next2);
                            if (iRewriteForNumberVariables2 == 1) {
                                if (iRewriteForNumberVariables3 == 1) {
                                    node.putIntProp(8, 0);
                                    return 1;
                                }
                                if (!convertParameter(next2)) {
                                    node.removeChild(next2);
                                    node.addChildToBack(new Node(Token.TO_DOUBLE, next2));
                                    node.putIntProp(8, 0);
                                }
                                return 1;
                            }
                            if (iRewriteForNumberVariables3 == 1) {
                                if (!convertParameter(firstChild)) {
                                    node.removeChild(firstChild);
                                    node.addChildToFront(new Node(Token.TO_DOUBLE, firstChild));
                                    node.putIntProp(8, 0);
                                }
                                return 1;
                            }
                            if (!convertParameter(firstChild)) {
                                node.removeChild(firstChild);
                                node.addChildToFront(new Node(Token.TO_DOUBLE, firstChild));
                            }
                            if (!convertParameter(next2)) {
                                node.removeChild(next2);
                                node.addChildToBack(new Node(Token.TO_DOUBLE, next2));
                            }
                            node.putIntProp(8, 0);
                            return 1;
                    }
                }
            }
            node.putIntProp(8, 0);
            markDCPNumberContext(next);
            return 1;
        }
        Node firstChild6 = node.getFirstChild();
        Node next7 = firstChild6.getNext();
        Node next8 = next7.getNext();
        if (rewriteForNumberVariables(firstChild6, 1) == 1 && !convertParameter(firstChild6)) {
            node.removeChild(firstChild6);
            node.addChildToFront(new Node(150, firstChild6));
        }
        if (rewriteForNumberVariables(next7, 1) == 1 && !convertParameter(next7)) {
            node.putIntProp(8, 1);
        }
        if (rewriteForNumberVariables(next8, 1) == 1 && !convertParameter(next8)) {
            node.removeChild(next8);
            node.addChildToBack(new Node(150, next8));
        }
        return 0;
    }

    void optimize(ScriptNode scriptNode) {
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            optimizeFunction(OptFunctionNode.get(scriptNode, i));
        }
    }
}
