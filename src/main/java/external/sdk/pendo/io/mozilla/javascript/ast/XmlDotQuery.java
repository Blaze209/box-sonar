package external.sdk.pendo.io.mozilla.javascript.ast;

import external.sdk.pendo.io.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes4.dex */
public class XmlDotQuery extends InfixExpression {
    private int rp;

    public XmlDotQuery() {
        this.rp = -1;
        this.type = Token.DOTQUERY;
    }

    public int getRp() {
        return this.rp;
    }

    public void setRp(int i) {
        this.rp = i;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.InfixExpression, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + getLeft().toSource(0) + ".(" + getRight().toSource(0) + ")";
    }

    public XmlDotQuery(int i) {
        super(i);
        this.rp = -1;
        this.type = Token.DOTQUERY;
    }

    public XmlDotQuery(int i, int i2) {
        super(i, i2);
        this.rp = -1;
        this.type = Token.DOTQUERY;
    }
}
