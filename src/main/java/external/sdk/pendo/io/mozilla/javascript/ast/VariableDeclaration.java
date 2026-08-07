package external.sdk.pendo.io.mozilla.javascript.ast;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import external.sdk.pendo.io.mozilla.javascript.Node;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class VariableDeclaration extends AstNode {
    private boolean isStatement;
    private List<VariableInitializer> variables;

    public VariableDeclaration() {
        this.variables = new ArrayList();
        this.type = 123;
    }

    private String declTypeName() {
        return Token.typeToName(this.type).toLowerCase();
    }

    public void addVariable(VariableInitializer variableInitializer) {
        assertNotNull(variableInitializer);
        this.variables.add(variableInitializer);
        variableInitializer.setParent(this);
    }

    public List<VariableInitializer> getVariables() {
        return this.variables;
    }

    public boolean isConst() {
        return this.type == 155;
    }

    public boolean isLet() {
        return this.type == 154;
    }

    public boolean isStatement() {
        return this.isStatement;
    }

    public boolean isVar() {
        return this.type == 123;
    }

    public void setIsStatement(boolean z) {
        this.isStatement = z;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Node
    public Node setType(int i) {
        if (i == 123 || i == 155 || i == 154) {
            return super.setType(i);
        }
        throw new IllegalArgumentException("invalid decl type: " + i);
    }

    public void setVariables(List<VariableInitializer> list) {
        assertNotNull(list);
        this.variables.clear();
        Iterator<VariableInitializer> it = list.iterator();
        while (it.hasNext()) {
            addVariable(it.next());
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append(declTypeName());
        sb.append(" ");
        printList(this.variables, sb);
        if (isStatement()) {
            sb.append(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
        }
        if (getInlineComment() != null) {
            sb.append(getInlineComment().toSource(i)).append("\n");
        } else if (isStatement()) {
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            Iterator<VariableInitializer> it = this.variables.iterator();
            while (it.hasNext()) {
                it.next().visit(nodeVisitor);
            }
        }
    }

    public VariableDeclaration(int i) {
        super(i);
        this.variables = new ArrayList();
        this.type = 123;
    }

    public VariableDeclaration(int i, int i2) {
        super(i, i2);
        this.variables = new ArrayList();
        this.type = 123;
    }
}
