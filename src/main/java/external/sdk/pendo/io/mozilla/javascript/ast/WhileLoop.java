package external.sdk.pendo.io.mozilla.javascript.ast;

/* JADX INFO: loaded from: classes4.dex */
public class WhileLoop extends Loop {
    private AstNode condition;

    public WhileLoop() {
        this.type = 118;
    }

    public AstNode getCondition() {
        return this.condition;
    }

    public void setCondition(AstNode astNode) {
        assertNotNull(astNode);
        this.condition = astNode;
        astNode.setParent(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("while (");
        sb.append(this.condition.toSource(0));
        sb.append(") ");
        if (getInlineComment() != null) {
            sb.append(getInlineComment().toSource(i + 1)).append("\n");
        }
        if (this.body.getType() == 130) {
            sb.append(this.body.toSource(i).trim());
            sb.append("\n");
        } else {
            if (getInlineComment() == null) {
                sb.append("\n");
            }
            sb.append(this.body.toSource(i + 1));
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.condition.visit(nodeVisitor);
            this.body.visit(nodeVisitor);
        }
    }

    public WhileLoop(int i) {
        super(i);
        this.type = 118;
    }

    public WhileLoop(int i, int i2) {
        super(i, i2);
        this.type = 118;
    }
}
