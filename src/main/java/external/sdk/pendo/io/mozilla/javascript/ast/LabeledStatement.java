package external.sdk.pendo.io.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LabeledStatement extends AstNode {
    private List<Label> labels;
    private AstNode statement;

    public LabeledStatement() {
        this.labels = new ArrayList();
        this.type = 134;
    }

    public void addLabel(Label label) {
        assertNotNull(label);
        this.labels.add(label);
        label.setParent(this);
    }

    public Label getFirstLabel() {
        return this.labels.get(0);
    }

    public Label getLabelByName(String str) {
        for (Label label : this.labels) {
            if (str.equals(label.getName())) {
                return label;
            }
        }
        return null;
    }

    public List<Label> getLabels() {
        return this.labels;
    }

    public AstNode getStatement() {
        return this.statement;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode, external.sdk.pendo.io.mozilla.javascript.Node
    public boolean hasSideEffects() {
        return true;
    }

    public void setLabels(List<Label> list) {
        assertNotNull(list);
        List<Label> list2 = this.labels;
        if (list2 != null) {
            list2.clear();
        }
        Iterator<Label> it = list.iterator();
        while (it.hasNext()) {
            addLabel(it.next());
        }
    }

    public void setStatement(AstNode astNode) {
        assertNotNull(astNode);
        this.statement = astNode;
        astNode.setParent(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        Iterator<Label> it = this.labels.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toSource(i));
        }
        sb.append(this.statement.toSource(i + 1));
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            Iterator<Label> it = this.labels.iterator();
            while (it.hasNext()) {
                it.next().visit(nodeVisitor);
            }
            this.statement.visit(nodeVisitor);
        }
    }

    public LabeledStatement(int i) {
        super(i);
        this.labels = new ArrayList();
        this.type = 134;
    }

    public LabeledStatement(int i, int i2) {
        super(i, i2);
        this.labels = new ArrayList();
        this.type = 134;
    }
}
