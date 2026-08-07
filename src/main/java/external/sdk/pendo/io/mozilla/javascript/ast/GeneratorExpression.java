package external.sdk.pendo.io.mozilla.javascript.ast;

import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GeneratorExpression extends Scope {
    private AstNode filter;
    private int ifPosition;
    private List<GeneratorExpressionLoop> loops;
    private int lp;
    private AstNode result;
    private int rp;

    public GeneratorExpression() {
        this.loops = new ArrayList();
        this.ifPosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = Token.GENEXPR;
    }

    public void addLoop(GeneratorExpressionLoop generatorExpressionLoop) {
        assertNotNull(generatorExpressionLoop);
        this.loops.add(generatorExpressionLoop);
        generatorExpressionLoop.setParent(this);
    }

    public AstNode getFilter() {
        return this.filter;
    }

    public int getFilterLp() {
        return this.lp;
    }

    public int getFilterRp() {
        return this.rp;
    }

    public int getIfPosition() {
        return this.ifPosition;
    }

    public List<GeneratorExpressionLoop> getLoops() {
        return this.loops;
    }

    public AstNode getResult() {
        return this.result;
    }

    public void setFilter(AstNode astNode) {
        this.filter = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public void setFilterLp(int i) {
        this.lp = i;
    }

    public void setFilterRp(int i) {
        this.rp = i;
    }

    public void setIfPosition(int i) {
        this.ifPosition = i;
    }

    public void setLoops(List<GeneratorExpressionLoop> list) {
        assertNotNull(list);
        this.loops.clear();
        Iterator<GeneratorExpressionLoop> it = list.iterator();
        while (it.hasNext()) {
            addLoop(it.next());
        }
    }

    public void setResult(AstNode astNode) {
        assertNotNull(astNode);
        this.result = astNode;
        astNode.setParent(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder(250);
        sb.append("(");
        sb.append(this.result.toSource(0));
        Iterator<GeneratorExpressionLoop> it = this.loops.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toSource(0));
        }
        if (this.filter != null) {
            sb.append(" if (");
            sb.append(this.filter.toSource(0));
            sb.append(")");
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.result.visit(nodeVisitor);
            Iterator<GeneratorExpressionLoop> it = this.loops.iterator();
            while (it.hasNext()) {
                it.next().visit(nodeVisitor);
            }
            AstNode astNode = this.filter;
            if (astNode != null) {
                astNode.visit(nodeVisitor);
            }
        }
    }

    public GeneratorExpression(int i) {
        super(i);
        this.loops = new ArrayList();
        this.ifPosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = Token.GENEXPR;
    }

    public GeneratorExpression(int i, int i2) {
        super(i, i2);
        this.loops = new ArrayList();
        this.ifPosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = Token.GENEXPR;
    }
}
