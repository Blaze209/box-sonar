package external.sdk.pendo.io.mozilla.javascript.ast;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import external.sdk.pendo.io.mozilla.javascript.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class FunctionNode extends ScriptNode {
    public static final int ARROW_FUNCTION = 4;
    public static final int FUNCTION_EXPRESSION = 2;
    public static final int FUNCTION_EXPRESSION_STATEMENT = 3;
    public static final int FUNCTION_STATEMENT = 1;
    private static final List<AstNode> NO_PARAMS = Collections.unmodifiableList(new ArrayList());
    private AstNode body;
    private Form functionForm;
    private Name functionName;
    private int functionType;
    private List<Node> generatorResumePoints;
    private boolean isES6Generator;
    private boolean isExpressionClosure;
    private boolean isGenerator;
    private Map<Node, int[]> liveLocals;
    private int lp;
    private AstNode memberExprNode;
    private boolean needsActivation;
    private List<AstNode> params;
    private int rp;

    public enum Form {
        FUNCTION,
        GETTER,
        SETTER,
        METHOD
    }

    public FunctionNode() {
        this.functionForm = Form.FUNCTION;
        this.lp = -1;
        this.rp = -1;
        this.type = 110;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode
    public int addFunction(FunctionNode functionNode) {
        int iAddFunction = super.addFunction(functionNode);
        if (getFunctionCount() > 0) {
            this.needsActivation = true;
        }
        return iAddFunction;
    }

    public void addLiveLocals(Node node, int[] iArr) {
        if (this.liveLocals == null) {
            this.liveLocals = new HashMap();
        }
        this.liveLocals.put(node, iArr);
    }

    public void addParam(AstNode astNode) {
        assertNotNull(astNode);
        if (this.params == null) {
            this.params = new ArrayList();
        }
        this.params.add(astNode);
        astNode.setParent(this);
    }

    public void addResumptionPoint(Node node) {
        if (this.generatorResumePoints == null) {
            this.generatorResumePoints = new ArrayList();
        }
        this.generatorResumePoints.add(node);
    }

    public AstNode getBody() {
        return this.body;
    }

    public Name getFunctionName() {
        return this.functionName;
    }

    public int getFunctionType() {
        return this.functionType;
    }

    public Map<Node, int[]> getLiveLocals() {
        return this.liveLocals;
    }

    public int getLp() {
        return this.lp;
    }

    public AstNode getMemberExprNode() {
        return this.memberExprNode;
    }

    public String getName() {
        Name name = this.functionName;
        return name != null ? name.getIdentifier() : "";
    }

    public List<AstNode> getParams() {
        List<AstNode> list = this.params;
        return list != null ? list : NO_PARAMS;
    }

    public List<Node> getResumptionPoints() {
        return this.generatorResumePoints;
    }

    public int getRp() {
        return this.rp;
    }

    public boolean isES6Generator() {
        return this.isES6Generator;
    }

    public boolean isExpressionClosure() {
        return this.isExpressionClosure;
    }

    public boolean isGenerator() {
        return this.isGenerator;
    }

    public boolean isGetterMethod() {
        return this.functionForm == Form.GETTER;
    }

    public boolean isMethod() {
        Form form = this.functionForm;
        return form == Form.GETTER || form == Form.SETTER || form == Form.METHOD;
    }

    public boolean isNormalMethod() {
        return this.functionForm == Form.METHOD;
    }

    public boolean isParam(AstNode astNode) {
        List<AstNode> list = this.params;
        if (list == null) {
            return false;
        }
        return list.contains(astNode);
    }

    public boolean isSetterMethod() {
        return this.functionForm == Form.SETTER;
    }

    public boolean requiresActivation() {
        return this.needsActivation;
    }

    public void setBody(AstNode astNode) {
        assertNotNull(astNode);
        this.body = astNode;
        if (Boolean.TRUE.equals(astNode.getProp(25))) {
            setIsExpressionClosure(true);
        }
        int position = astNode.getPosition() + astNode.getLength();
        astNode.setParent(this);
        setLength(position - this.position);
        setEncodedSourceBounds(this.position, position);
    }

    public void setFunctionIsGetterMethod() {
        this.functionForm = Form.GETTER;
    }

    public void setFunctionIsNormalMethod() {
        this.functionForm = Form.METHOD;
    }

    public void setFunctionIsSetterMethod() {
        this.functionForm = Form.SETTER;
    }

    public void setFunctionName(Name name) {
        this.functionName = name;
        if (name != null) {
            name.setParent(this);
        }
    }

    public void setFunctionType(int i) {
        this.functionType = i;
    }

    public void setIsES6Generator() {
        this.isES6Generator = true;
        this.isGenerator = true;
    }

    public void setIsExpressionClosure(boolean z) {
        this.isExpressionClosure = z;
    }

    public void setIsGenerator() {
        this.isGenerator = true;
    }

    public void setLp(int i) {
        this.lp = i;
    }

    public void setMemberExprNode(AstNode astNode) {
        this.memberExprNode = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public void setParams(List<AstNode> list) {
        if (list == null) {
            this.params = null;
            return;
        }
        List<AstNode> list2 = this.params;
        if (list2 != null) {
            list2.clear();
        }
        Iterator<AstNode> it = list.iterator();
        while (it.hasNext()) {
            addParam(it.next());
        }
    }

    public void setParens(int i, int i2) {
        this.lp = i;
        this.rp = i2;
    }

    public void setRequiresActivation() {
        this.needsActivation = true;
    }

    public void setRp(int i) {
        this.rp = i;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0065  */
    /* JADX WARN: Code duplicated, block: B:29:0x0071  */
    /* JADX WARN: Code duplicated, block: B:31:0x0086  */
    /* JADX WARN: Code duplicated, block: B:32:0x0089  */
    /* JADX WARN: Code duplicated, block: B:33:0x0091  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00aa  */
    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        String str;
        String strTrim;
        AstNode body;
        StringBuilder sb = new StringBuilder();
        boolean z = this.functionType == 4;
        if (!isMethod()) {
            sb.append(makeIndent(i));
            if (!z) {
                sb.append("function");
            }
        }
        if (this.functionName != null) {
            sb.append(" ");
            sb.append(this.functionName.toSource(0));
        }
        List<AstNode> list = this.params;
        if (list != null) {
            if (z && this.lp == -1) {
                printList(list, sb);
                sb.append(" ");
            } else {
                sb.append("(");
                printList(this.params, sb);
                str = ") ";
            }
            if (z) {
                sb.append("=> ");
            }
            if (this.isExpressionClosure) {
                body = getBody();
                if (body.getLastChild() instanceof ReturnStatement) {
                    sb.append(((ReturnStatement) body.getLastChild()).getReturnValue().toSource(0));
                    if (this.functionType == 1) {
                        strTrim = AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER;
                    }
                    if (this.functionType != 1 || isMethod()) {
                        sb.append("\n");
                    }
                    return sb.toString();
                }
                sb.append(" ");
                strTrim = body.toSource(0);
            } else {
                strTrim = getBody().toSource(i).trim();
            }
            sb.append(strTrim);
            if (this.functionType != 1) {
                sb.append("\n");
            } else {
                sb.append("\n");
            }
            return sb.toString();
        }
        str = "() ";
        sb.append(str);
        if (z) {
            sb.append("=> ");
        }
        if (this.isExpressionClosure) {
            body = getBody();
            if (body.getLastChild() instanceof ReturnStatement) {
                sb.append(((ReturnStatement) body.getLastChild()).getReturnValue().toSource(0));
                if (this.functionType == 1) {
                    strTrim = AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER;
                }
                if (this.functionType != 1) {
                    sb.append("\n");
                } else {
                    sb.append("\n");
                }
                return sb.toString();
            }
            sb.append(" ");
            strTrim = body.toSource(0);
        } else {
            strTrim = getBody().toSource(i).trim();
        }
        sb.append(strTrim);
        if (this.functionType != 1) {
            sb.append("\n");
        } else {
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode, external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        AstNode astNode;
        if (nodeVisitor.visit(this)) {
            Name name = this.functionName;
            if (name != null) {
                name.visit(nodeVisitor);
            }
            Iterator<AstNode> it = getParams().iterator();
            while (it.hasNext()) {
                it.next().visit(nodeVisitor);
            }
            getBody().visit(nodeVisitor);
            if (this.isExpressionClosure || (astNode = this.memberExprNode) == null) {
                return;
            }
            astNode.visit(nodeVisitor);
        }
    }

    public FunctionNode(int i) {
        super(i);
        this.functionForm = Form.FUNCTION;
        this.lp = -1;
        this.rp = -1;
        this.type = 110;
    }

    public FunctionNode(int i, Name name) {
        super(i);
        this.functionForm = Form.FUNCTION;
        this.lp = -1;
        this.rp = -1;
        this.type = 110;
        setFunctionName(name);
    }
}
