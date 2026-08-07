package external.sdk.pendo.io.mozilla.javascript.ast;

/* JADX INFO: loaded from: classes4.dex */
public class ArrayComprehensionLoop extends ForInLoop {
    public ArrayComprehensionLoop() {
    }

    public ArrayComprehensionLoop(int i) {
        super(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Loop
    public AstNode getBody() {
        return null;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Loop
    public void setBody(AstNode astNode) {
        throw new UnsupportedOperationException("this node type has no body");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.ForInLoop, external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + " for " + (isForEach() ? "each " : "") + "(" + this.iterator.toSource(0) + (isForOf() ? " of " : " in ") + this.iteratedObject.toSource(0) + ")";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.ForInLoop, external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.iterator.visit(nodeVisitor);
            this.iteratedObject.visit(nodeVisitor);
        }
    }

    public ArrayComprehensionLoop(int i, int i2) {
        super(i, i2);
    }
}
