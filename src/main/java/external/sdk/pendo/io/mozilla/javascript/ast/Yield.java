package external.sdk.pendo.io.mozilla.javascript.ast;

import external.sdk.pendo.io.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes4.dex */
public class Yield extends AstNode {
    private AstNode value;

    public Yield() {
        this.type = 73;
    }

    public AstNode getValue() {
        return this.value;
    }

    public void setValue(AstNode astNode) {
        this.value = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return this.value == null ? "yield" : "yield " + this.value.toSource(0);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        AstNode astNode;
        if (!nodeVisitor.visit(this) || (astNode = this.value) == null) {
            return;
        }
        astNode.visit(nodeVisitor);
    }

    public Yield(int i) {
        super(i);
        this.type = 73;
    }

    public Yield(int i, int i2) {
        super(i, i2);
        this.type = 73;
    }

    public Yield(int i, int i2, AstNode astNode, boolean z) {
        super(i, i2);
        this.type = z ? Token.YIELD_STAR : 73;
        setValue(astNode);
    }
}
