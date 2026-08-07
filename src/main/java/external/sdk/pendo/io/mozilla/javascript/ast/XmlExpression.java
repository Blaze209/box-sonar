package external.sdk.pendo.io.mozilla.javascript.ast;

/* JADX INFO: loaded from: classes4.dex */
public class XmlExpression extends XmlFragment {
    private AstNode expression;
    private boolean isXmlAttribute;

    public XmlExpression() {
    }

    public XmlExpression(int i) {
        super(i);
    }

    public AstNode getExpression() {
        return this.expression;
    }

    public boolean isXmlAttribute() {
        return this.isXmlAttribute;
    }

    public void setExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.expression = astNode;
        astNode.setParent(this);
    }

    public void setIsXmlAttribute(boolean z) {
        this.isXmlAttribute = z;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + "{" + this.expression.toSource(i) + "}";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.expression.visit(nodeVisitor);
        }
    }

    public XmlExpression(int i, int i2) {
        super(i, i2);
    }

    public XmlExpression(int i, AstNode astNode) {
        super(i);
        setExpression(astNode);
    }
}
