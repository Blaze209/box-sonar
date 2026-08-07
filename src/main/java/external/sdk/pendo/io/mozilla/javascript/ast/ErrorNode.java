package external.sdk.pendo.io.mozilla.javascript.ast;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorNode extends AstNode {
    private String message;

    public ErrorNode() {
        this.type = -1;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return "";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public ErrorNode(int i) {
        super(i);
        this.type = -1;
    }

    public ErrorNode(int i, int i2) {
        super(i, i2);
        this.type = -1;
    }
}
