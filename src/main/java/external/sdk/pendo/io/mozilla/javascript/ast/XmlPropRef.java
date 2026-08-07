package external.sdk.pendo.io.mozilla.javascript.ast;

import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;

/* JADX INFO: loaded from: classes4.dex */
public class XmlPropRef extends XmlRef {
    private Name propName;

    public XmlPropRef() {
        this.type = 80;
    }

    public Name getPropName() {
        return this.propName;
    }

    public void setPropName(Name name) {
        assertNotNull(name);
        this.propName = name;
        name.setParent(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        if (isAttributeAccess()) {
            sb.append(CommentEntityDomainMapper.MENTIONS_SYMBOL);
        }
        Name name = this.namespace;
        if (name != null) {
            sb.append(name.toSource(0));
            sb.append("::");
        }
        sb.append(this.propName.toSource(0));
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            Name name = this.namespace;
            if (name != null) {
                name.visit(nodeVisitor);
            }
            this.propName.visit(nodeVisitor);
        }
    }

    public XmlPropRef(int i) {
        super(i);
        this.type = 80;
    }

    public XmlPropRef(int i, int i2) {
        super(i, i2);
        this.type = 80;
    }
}
