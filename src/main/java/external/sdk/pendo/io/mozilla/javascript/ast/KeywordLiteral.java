package external.sdk.pendo.io.mozilla.javascript.ast;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class KeywordLiteral extends AstNode {
    public KeywordLiteral() {
    }

    public KeywordLiteral(int i) {
        super(i);
    }

    public boolean isBooleanLiteral() {
        int i = this.type;
        return i == 45 || i == 44;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        int type = getType();
        if (type != 161) {
            switch (type) {
                case 42:
                    str = AbstractJsonLexerKt.NULL;
                    break;
                case 43:
                    str = "this";
                    break;
                case 44:
                    str = "false";
                    break;
                case 45:
                    str = TelemetryEventStrings.Value.TRUE;
                    break;
                default:
                    throw new IllegalStateException("Invalid keyword literal type: " + getType());
            }
        } else {
            str = "debugger;\n";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public KeywordLiteral(int i, int i2) {
        super(i, i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Node
    public KeywordLiteral setType(int i) {
        if (i != 43 && i != 42 && i != 45 && i != 44 && i != 161) {
            throw new IllegalArgumentException("Invalid node type: " + i);
        }
        this.type = i;
        return this;
    }

    public KeywordLiteral(int i, int i2, int i3) {
        super(i, i2);
        setType(i3);
    }
}
