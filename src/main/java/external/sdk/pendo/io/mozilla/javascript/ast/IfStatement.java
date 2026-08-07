package external.sdk.pendo.io.mozilla.javascript.ast;

/* JADX INFO: loaded from: classes4.dex */
public class IfStatement extends AstNode {
    private AstNode condition;
    private AstNode elseKeyWordInlineComment;
    private AstNode elsePart;
    private int elsePosition;
    private int lp;
    private int rp;
    private AstNode thenPart;

    public IfStatement() {
        this.elsePosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = 113;
    }

    public AstNode getCondition() {
        return this.condition;
    }

    public AstNode getElseKeyWordInlineComment() {
        return this.elseKeyWordInlineComment;
    }

    public AstNode getElsePart() {
        return this.elsePart;
    }

    public int getElsePosition() {
        return this.elsePosition;
    }

    public int getLp() {
        return this.lp;
    }

    public int getRp() {
        return this.rp;
    }

    public AstNode getThenPart() {
        return this.thenPart;
    }

    public void setCondition(AstNode astNode) {
        assertNotNull(astNode);
        this.condition = astNode;
        astNode.setParent(this);
    }

    public void setElseKeyWordInlineComment(AstNode astNode) {
        this.elseKeyWordInlineComment = astNode;
    }

    public void setElsePart(AstNode astNode) {
        this.elsePart = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public void setElsePosition(int i) {
        this.elsePosition = i;
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

    public void setThenPart(AstNode astNode) {
        assertNotNull(astNode);
        this.thenPart = astNode;
        astNode.setParent(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        String strMakeIndent = makeIndent(i);
        StringBuilder sb = new StringBuilder(32);
        sb.append(strMakeIndent);
        sb.append("if (");
        sb.append(this.condition.toSource(0));
        sb.append(") ");
        if (getInlineComment() != null) {
            sb.append("    ").append(getInlineComment().toSource()).append("\n");
        }
        if (this.thenPart.getType() != 130) {
            if (getInlineComment() == null) {
                sb.append("\n");
            }
            sb.append(makeIndent(i + 1));
        }
        sb.append(this.thenPart.toSource(i).trim());
        if (this.elsePart != null) {
            if (this.thenPart.getType() != 130) {
                sb.append("\n").append(strMakeIndent).append("else ");
            } else {
                sb.append(" else ");
            }
            if (getElseKeyWordInlineComment() != null) {
                sb.append("    ").append(getElseKeyWordInlineComment().toSource()).append("\n");
            }
            if (this.elsePart.getType() != 130 && this.elsePart.getType() != 113) {
                if (getElseKeyWordInlineComment() == null) {
                    sb.append("\n");
                }
                sb.append(makeIndent(i + 1));
            }
            sb.append(this.elsePart.toSource(i).trim());
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.condition.visit(nodeVisitor);
            this.thenPart.visit(nodeVisitor);
            AstNode astNode = this.elsePart;
            if (astNode != null) {
                astNode.visit(nodeVisitor);
            }
        }
    }

    public IfStatement(int i) {
        super(i);
        this.elsePosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = 113;
    }

    public IfStatement(int i, int i2) {
        super(i, i2);
        this.elsePosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = 113;
    }
}
