package external.sdk.pendo.io.mozilla.javascript.ast;

import external.sdk.pendo.io.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes4.dex */
public class InfixExpression extends AstNode {
    protected AstNode left;
    protected int operatorPosition;
    protected AstNode right;

    public InfixExpression() {
        this.operatorPosition = -1;
    }

    public AstNode getLeft() {
        return this.left;
    }

    public int getOperator() {
        return getType();
    }

    public int getOperatorPosition() {
        return this.operatorPosition;
    }

    public AstNode getRight() {
        return this.right;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode, external.sdk.pendo.io.mozilla.javascript.Node
    public boolean hasSideEffects() {
        AstNode astNode;
        int type = getType();
        if (type == 90) {
            AstNode astNode2 = this.right;
            return astNode2 != null && astNode2.hasSideEffects();
        }
        if (type != 105 && type != 106) {
            return super.hasSideEffects();
        }
        AstNode astNode3 = this.left;
        return (astNode3 != null && astNode3.hasSideEffects()) || ((astNode = this.right) != null && astNode.hasSideEffects());
    }

    public void setLeft(AstNode astNode) {
        assertNotNull(astNode);
        this.left = astNode;
        setLineno(astNode.getLineno());
        astNode.setParent(this);
    }

    public void setLeftAndRight(AstNode astNode, AstNode astNode2) {
        assertNotNull(astNode);
        assertNotNull(astNode2);
        setBounds(astNode.getPosition(), astNode2.getPosition() + astNode2.getLength());
        setLeft(astNode);
        setRight(astNode2);
    }

    public void setOperator(int i) {
        if (!Token.isValidToken(i)) {
            throw new IllegalArgumentException("Invalid token: " + i);
        }
        setType(i);
    }

    public void setOperatorPosition(int i) {
        this.operatorPosition = i;
    }

    public void setRight(AstNode astNode) {
        assertNotNull(astNode);
        this.right = astNode;
        astNode.setParent(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + this.left.toSource() + " " + AstNode.operatorToString(getType()) + " " + this.right.toSource();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.left.visit(nodeVisitor);
            this.right.visit(nodeVisitor);
        }
    }

    public InfixExpression(int i) {
        super(i);
        this.operatorPosition = -1;
    }

    public InfixExpression(int i, int i2) {
        super(i, i2);
        this.operatorPosition = -1;
    }

    public InfixExpression(int i, int i2, AstNode astNode, AstNode astNode2) {
        super(i, i2);
        this.operatorPosition = -1;
        setLeft(astNode);
        setRight(astNode2);
    }

    public InfixExpression(int i, AstNode astNode, AstNode astNode2, int i2) {
        this.operatorPosition = -1;
        setType(i);
        setOperatorPosition(i2 - astNode.getPosition());
        setLeftAndRight(astNode, astNode2);
    }

    public InfixExpression(AstNode astNode, AstNode astNode2) {
        this.operatorPosition = -1;
        setLeftAndRight(astNode, astNode2);
    }
}
