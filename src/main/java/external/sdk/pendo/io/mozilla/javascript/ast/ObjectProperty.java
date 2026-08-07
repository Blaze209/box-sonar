package external.sdk.pendo.io.mozilla.javascript.ast;

import external.sdk.pendo.io.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes4.dex */
public class ObjectProperty extends InfixExpression {
    public ObjectProperty() {
        this.type = 104;
    }

    public boolean isGetterMethod() {
        return this.type == 152;
    }

    public boolean isMethod() {
        return isGetterMethod() || isSetterMethod() || isNormalMethod();
    }

    public boolean isNormalMethod() {
        return this.type == 164;
    }

    public boolean isSetterMethod() {
        return this.type == 153;
    }

    public void setIsGetterMethod() {
        this.type = Token.GET;
    }

    public void setIsNormalMethod() {
        this.type = Token.METHOD;
    }

    public void setIsSetterMethod() {
        this.type = Token.SET;
    }

    public void setNodeType(int i) {
        if (i != 104 && i != 152 && i != 153 && i != 164) {
            throw new IllegalArgumentException("invalid node type: " + i);
        }
        setType(i);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0030  */
    /* JADX WARN: Code duplicated, block: B:14:0x003c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0049  */
    @Override // external.sdk.pendo.io.mozilla.javascript.ast.InfixExpression, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        String str;
        StringBuilder sb = new StringBuilder("\n");
        int i2 = i + 1;
        sb.append(makeIndent(i2));
        if (!isGetterMethod()) {
            str = isSetterMethod() ? "set " : "get ";
            AstNode astNode = this.left;
            if (getType() == 104) {
                i = 0;
            }
            sb.append(astNode.toSource(i));
            if (this.type == 104) {
                sb.append(": ");
            }
            AstNode astNode2 = this.right;
            if (getType() == 104) {
                i2 = 0;
            }
            sb.append(astNode2.toSource(i2));
            return sb.toString();
        }
        sb.append(str);
        AstNode astNode3 = this.left;
        if (getType() == 104) {
            i = 0;
        }
        sb.append(astNode3.toSource(i));
        if (this.type == 104) {
            sb.append(": ");
        }
        AstNode astNode4 = this.right;
        if (getType() == 104) {
            i2 = 0;
        }
        sb.append(astNode4.toSource(i2));
        return sb.toString();
    }

    public ObjectProperty(int i) {
        super(i);
        this.type = 104;
    }

    public ObjectProperty(int i, int i2) {
        super(i, i2);
        this.type = 104;
    }
}
