package external.sdk.pendo.io.mozilla.javascript.ast;

/* JADX INFO: loaded from: classes4.dex */
public class XmlString extends XmlFragment {
    private String xml;

    public XmlString() {
    }

    public XmlString(int i) {
        super(i);
    }

    public String getXml() {
        return this.xml;
    }

    public void setXml(String str) {
        assertNotNull(str);
        this.xml = str;
        setLength(str.length());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + this.xml;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public XmlString(int i, String str) {
        super(i);
        setXml(str);
    }
}
