package external.sdk.pendo.io.mozilla.javascript.ast;

import external.sdk.pendo.io.mozilla.javascript.Node;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class Block extends AstNode {
    public Block() {
        this.type = 130;
    }

    public void addStatement(AstNode astNode) {
        addChild(astNode);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("{\n");
        Iterator<Node> it = iterator();
        while (it.hasNext()) {
            AstNode astNode = (AstNode) it.next();
            sb.append(astNode.toSource(i + 1));
            if (astNode.getType() == 162) {
                sb.append("\n");
            }
        }
        sb.append(makeIndent(i));
        sb.append("}");
        if (getInlineComment() != null) {
            sb.append(getInlineComment().toSource(i));
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            Iterator<Node> it = iterator();
            while (it.hasNext()) {
                ((AstNode) it.next()).visit(nodeVisitor);
            }
        }
    }

    public Block(int i) {
        super(i);
        this.type = 130;
    }

    public Block(int i, int i2) {
        super(i, i2);
        this.type = 130;
    }
}
