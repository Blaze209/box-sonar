package external.sdk.pendo.io.mozilla.javascript.ast;

/* JADX INFO: loaded from: classes4.dex */
public class GeneratorExpressionLoop extends ForInLoop {
    public GeneratorExpressionLoop() {
    }

    public GeneratorExpressionLoop(int i) {
        super(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.ForInLoop
    public boolean isForEach() {
        return false;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.ForInLoop
    public void setIsForEach(boolean z) {
        throw new UnsupportedOperationException("this node type does not support for each");
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

    public GeneratorExpressionLoop(int i, int i2) {
        super(i, i2);
    }
}
