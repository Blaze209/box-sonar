package external.sdk.pendo.io.mozilla.javascript.ast;

/* JADX INFO: loaded from: classes4.dex */
public class ElementGet extends AstNode {
    private AstNode element;
    private int lb;
    private int rb;
    private AstNode target;

    public ElementGet() {
        this.lb = -1;
        this.rb = -1;
        this.type = 36;
    }

    public AstNode getElement() {
        return this.element;
    }

    public int getLb() {
        return this.lb;
    }

    public int getRb() {
        return this.rb;
    }

    public AstNode getTarget() {
        return this.target;
    }

    public void setElement(AstNode astNode) {
        assertNotNull(astNode);
        this.element = astNode;
        astNode.setParent(this);
    }

    public void setLb(int i) {
        this.lb = i;
    }

    public void setParens(int i, int i2) {
        this.lb = i;
        this.rb = i2;
    }

    public void setRb(int i) {
        this.rb = i;
    }

    public void setTarget(AstNode astNode) {
        assertNotNull(astNode);
        this.target = astNode;
        astNode.setParent(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + this.target.toSource(0) + "[" + this.element.toSource(0) + "]";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.target.visit(nodeVisitor);
            this.element.visit(nodeVisitor);
        }
    }

    public ElementGet(int i) {
        super(i);
        this.lb = -1;
        this.rb = -1;
        this.type = 36;
    }

    public ElementGet(int i, int i2) {
        super(i, i2);
        this.lb = -1;
        this.rb = -1;
        this.type = 36;
    }

    public ElementGet(AstNode astNode, AstNode astNode2) {
        this.lb = -1;
        this.rb = -1;
        this.type = 36;
        setTarget(astNode);
        setElement(astNode2);
    }
}
