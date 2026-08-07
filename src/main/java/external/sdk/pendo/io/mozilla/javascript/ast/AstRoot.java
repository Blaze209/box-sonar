package external.sdk.pendo.io.mozilla.javascript.ast;

import external.sdk.pendo.io.mozilla.javascript.Node;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes4.dex */
public class AstRoot extends ScriptNode {
    private SortedSet<Comment> comments;

    public AstRoot() {
        this.type = Token.SCRIPT;
    }

    public void addComment(Comment comment) {
        assertNotNull(comment);
        if (this.comments == null) {
            this.comments = new TreeSet(new AstNode.PositionComparator());
        }
        this.comments.add(comment);
        comment.setParent(this);
    }

    public void checkParentLinks() {
        visit(new NodeVisitor() { // from class: external.sdk.pendo.io.mozilla.javascript.ast.AstRoot.1
            @Override // external.sdk.pendo.io.mozilla.javascript.ast.NodeVisitor
            public boolean visit(AstNode astNode) {
                if (astNode.getType() != 137 && astNode.getParent() == null) {
                    throw new IllegalStateException("No parent for node: " + astNode + "\n" + astNode.toSource(0));
                }
                return true;
            }
        });
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String debugPrint() {
        AstNode.DebugPrintVisitor debugPrintVisitor = new AstNode.DebugPrintVisitor(new StringBuilder(1000));
        visitAll(debugPrintVisitor);
        return debugPrintVisitor.toString();
    }

    public SortedSet<Comment> getComments() {
        return this.comments;
    }

    public void setComments(SortedSet<Comment> sortedSet) {
        if (sortedSet == null) {
            this.comments = null;
            return;
        }
        SortedSet<Comment> sortedSet2 = this.comments;
        if (sortedSet2 != null) {
            sortedSet2.clear();
        }
        Iterator<Comment> it = sortedSet.iterator();
        while (it.hasNext()) {
            addComment(it.next());
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        for (Node node : this) {
            sb.append(((AstNode) node).toSource(i));
            if (node.getType() == 162) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void visitAll(NodeVisitor nodeVisitor) {
        visit(nodeVisitor);
        visitComments(nodeVisitor);
    }

    public void visitComments(NodeVisitor nodeVisitor) {
        SortedSet<Comment> sortedSet = this.comments;
        if (sortedSet != null) {
            Iterator<Comment> it = sortedSet.iterator();
            while (it.hasNext()) {
                nodeVisitor.visit(it.next());
            }
        }
    }

    public AstRoot(int i) {
        super(i);
        this.type = Token.SCRIPT;
    }
}
