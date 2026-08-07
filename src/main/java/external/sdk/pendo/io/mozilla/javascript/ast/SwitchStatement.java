package external.sdk.pendo.io.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SwitchStatement extends Jump {
    private static final List<SwitchCase> NO_CASES = Collections.unmodifiableList(new ArrayList());
    private List<SwitchCase> cases;
    private AstNode expression;
    private int lp = -1;
    private int rp = -1;

    public SwitchStatement() {
        this.type = 115;
    }

    public void addCase(SwitchCase switchCase) {
        assertNotNull(switchCase);
        if (this.cases == null) {
            this.cases = new ArrayList();
        }
        this.cases.add(switchCase);
        switchCase.setParent(this);
    }

    public List<SwitchCase> getCases() {
        List<SwitchCase> list = this.cases;
        return list != null ? list : NO_CASES;
    }

    public AstNode getExpression() {
        return this.expression;
    }

    public int getLp() {
        return this.lp;
    }

    public int getRp() {
        return this.rp;
    }

    public void setCases(List<SwitchCase> list) {
        if (list == null) {
            this.cases = null;
            return;
        }
        List<SwitchCase> list2 = this.cases;
        if (list2 != null) {
            list2.clear();
        }
        Iterator<SwitchCase> it = list.iterator();
        while (it.hasNext()) {
            addCase(it.next());
        }
    }

    public void setExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.expression = astNode;
        astNode.setParent(this);
    }

    public void setLp(int i) {
        this.lp = i;
    }

    public void setParens(int i, int i2) {
        this.lp = i;
        this.rp = i2;
    }

    public void setRp(int i) {
        this.rp = i;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        String strMakeIndent = makeIndent(i);
        StringBuilder sb = new StringBuilder();
        sb.append(strMakeIndent);
        sb.append("switch (");
        sb.append(this.expression.toSource(0));
        sb.append(") {\n");
        List<SwitchCase> list = this.cases;
        if (list != null) {
            Iterator<SwitchCase> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toSource(i + 1));
            }
        }
        sb.append(strMakeIndent);
        sb.append("}\n");
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.expression.visit(nodeVisitor);
            Iterator<SwitchCase> it = getCases().iterator();
            while (it.hasNext()) {
                it.next().visit(nodeVisitor);
            }
        }
    }

    public SwitchStatement(int i) {
        this.type = 115;
        this.position = i;
    }

    public SwitchStatement(int i, int i2) {
        this.type = 115;
        this.position = i;
        this.length = i2;
    }
}
