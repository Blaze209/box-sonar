package external.sdk.pendo.io.mozilla.javascript.ast;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.Node;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AstNode extends Node implements Comparable<AstNode> {
    private static Map<Integer, String> operatorNames;
    protected AstNode inlineComment;
    protected int length;
    protected AstNode parent;
    protected int position;

    protected static class DebugPrintVisitor implements NodeVisitor {
        private static final int DEBUG_INDENT = 2;
        private StringBuilder buffer;

        public DebugPrintVisitor(StringBuilder sb) {
            this.buffer = sb;
        }

        private static String makeIndent(int i) {
            int i2 = i * 2;
            StringBuilder sb = new StringBuilder(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        public String toString() {
            return this.buffer.toString();
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.ast.NodeVisitor
        public boolean visit(AstNode astNode) {
            StringBuilder sbAppend;
            String value;
            int type = astNode.getType();
            String strTypeToName = Token.typeToName(type);
            this.buffer.append(astNode.getAbsolutePosition()).append("\t");
            this.buffer.append(makeIndent(astNode.depth()));
            this.buffer.append(strTypeToName).append(" ");
            this.buffer.append(astNode.getPosition()).append(" ");
            this.buffer.append(astNode.getLength());
            if (type != 39) {
                if (type == 41) {
                    sbAppend = this.buffer.append(" ");
                    value = ((StringLiteral) astNode).getValue(true);
                }
                this.buffer.append("\n");
                return true;
            }
            sbAppend = this.buffer.append(" ");
            value = ((Name) astNode).getIdentifier();
            sbAppend.append(value);
            this.buffer.append("\n");
            return true;
        }
    }

    public static class PositionComparator implements Comparator<AstNode>, Serializable {
        private static final long serialVersionUID = 1;

        @Override // java.util.Comparator
        public int compare(AstNode astNode, AstNode astNode2) {
            return astNode.position - astNode2.position;
        }
    }

    static {
        HashMap map = new HashMap();
        operatorNames = map;
        map.put(52, "in");
        operatorNames.put(32, "typeof");
        operatorNames.put(53, "instanceof");
        operatorNames.put(31, "delete");
        operatorNames.put(90, ",");
        operatorNames.put(104, ":");
        operatorNames.put(105, "||");
        operatorNames.put(106, "&&");
        operatorNames.put(107, "++");
        operatorNames.put(108, "--");
        operatorNames.put(9, "|");
        operatorNames.put(10, "^");
        operatorNames.put(11, MsalUtils.QUERY_STRING_DELIMITER);
        operatorNames.put(12, "==");
        operatorNames.put(13, "!=");
        operatorNames.put(14, SimpleComparison.LESS_THAN_OPERATION);
        operatorNames.put(16, SimpleComparison.GREATER_THAN_OPERATION);
        operatorNames.put(15, SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION);
        operatorNames.put(17, SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION);
        operatorNames.put(18, "<<");
        operatorNames.put(19, ">>");
        operatorNames.put(20, ">>>");
        operatorNames.put(21, Marker.ANY_NON_NULL_MARKER);
        operatorNames.put(22, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        operatorNames.put(23, "*");
        operatorNames.put(24, "/");
        operatorNames.put(25, "%");
        operatorNames.put(26, "!");
        operatorNames.put(27, "~");
        operatorNames.put(28, Marker.ANY_NON_NULL_MARKER);
        operatorNames.put(29, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        operatorNames.put(46, "===");
        operatorNames.put(47, "!==");
        operatorNames.put(91, SimpleComparison.EQUAL_TO_OPERATION);
        operatorNames.put(92, "|=");
        operatorNames.put(94, "&=");
        operatorNames.put(95, "<<=");
        operatorNames.put(96, ">>=");
        operatorNames.put(97, ">>>=");
        operatorNames.put(98, "+=");
        operatorNames.put(99, "-=");
        operatorNames.put(100, "*=");
        operatorNames.put(101, "/=");
        operatorNames.put(102, "%=");
        operatorNames.put(93, "^=");
        operatorNames.put(127, "void");
    }

    public AstNode() {
        super(-1);
        this.position = -1;
        this.length = 1;
    }

    public static RuntimeException codeBug() {
        throw Kit.codeBug();
    }

    public static String operatorToString(int i) {
        String str = operatorNames.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Invalid operator: " + i);
    }

    public void addChild(AstNode astNode) {
        assertNotNull(astNode);
        setLength((astNode.getPosition() + astNode.getLength()) - getPosition());
        addChildToBack(astNode);
        astNode.setParent(this);
    }

    protected void assertNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("arg cannot be null");
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(AstNode astNode) {
        if (equals(astNode)) {
            return 0;
        }
        int absolutePosition = getAbsolutePosition();
        int absolutePosition2 = astNode.getAbsolutePosition();
        if (absolutePosition < absolutePosition2) {
            return -1;
        }
        if (absolutePosition2 < absolutePosition) {
            return 1;
        }
        int length = getLength();
        int length2 = astNode.getLength();
        if (length < length2) {
            return -1;
        }
        if (length2 < length) {
            return 1;
        }
        return hashCode() - astNode.hashCode();
    }

    public String debugPrint() {
        DebugPrintVisitor debugPrintVisitor = new DebugPrintVisitor(new StringBuilder(1000));
        visit(debugPrintVisitor);
        return debugPrintVisitor.toString();
    }

    public int depth() {
        AstNode astNode = this.parent;
        if (astNode == null) {
            return 0;
        }
        return astNode.depth() + 1;
    }

    public int getAbsolutePosition() {
        int position = this.position;
        for (AstNode parent = this.parent; parent != null; parent = parent.getParent()) {
            position += parent.getPosition();
        }
        return position;
    }

    public AstRoot getAstRoot() {
        while (this != null && !(this instanceof AstRoot)) {
            this = this.getParent();
        }
        return (AstRoot) this;
    }

    public FunctionNode getEnclosingFunction() {
        do {
            this = this.getParent();
            if (this == null) {
                break;
            }
        } while (!(this instanceof FunctionNode));
        return (FunctionNode) this;
    }

    public Scope getEnclosingScope() {
        do {
            this = this.getParent();
            if (this == null) {
                break;
            }
        } while (!(this instanceof Scope));
        return (Scope) this;
    }

    public AstNode getInlineComment() {
        return this.inlineComment;
    }

    public int getLength() {
        return this.length;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Node
    public int getLineno() {
        int i = this.lineno;
        if (i != -1) {
            return i;
        }
        AstNode astNode = this.parent;
        if (astNode != null) {
            return astNode.getLineno();
        }
        return -1;
    }

    public AstNode getParent() {
        return this.parent;
    }

    public int getPosition() {
        return this.position;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Node
    public boolean hasSideEffects() {
        int type = getType();
        if (type == 30 || type == 31 || type == 37 || type == 38 || type == 50 || type == 51 || type == 56 || type == 57 || type == 82 || type == 83 || type == 107 || type == 108 || type == -1 || type == 35 || type == 65 || type == 73 || type == 166 || type == 135 || type == 136 || type == 154 || type == 155 || type == 159 || type == 160) {
            return true;
        }
        switch (type) {
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
                return true;
            default:
                switch (type) {
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 123:
                    case 124:
                    case 125:
                    case 126:
                        return true;
                    default:
                        switch (type) {
                            case 130:
                            case Token.LABEL /* 131 */:
                            case Token.TARGET /* 132 */:
                            case Token.LOOP /* 133 */:
                                return true;
                            default:
                                switch (type) {
                                    case 140:
                                    case Token.SETELEM_OP /* 141 */:
                                    case Token.LOCAL_BLOCK /* 142 */:
                                    case Token.SET_REF_OP /* 143 */:
                                        return true;
                                    default:
                                        switch (type) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                            case 7:
                                            case 8:
                                                return true;
                                            default:
                                                switch (type) {
                                                    case 69:
                                                    case 70:
                                                    case 71:
                                                        return true;
                                                    default:
                                                        switch (type) {
                                                            case 110:
                                                            case 111:
                                                            case 112:
                                                            case 113:
                                                            case 114:
                                                            case 115:
                                                                return true;
                                                            default:
                                                                return false;
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public String makeIndent(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        return sb.toString();
    }

    protected <T extends AstNode> void printList(List<T> list, StringBuilder sb) {
        String str;
        int size = list.size();
        int i = 0;
        for (T t : list) {
            sb.append(t.toSource(0));
            int i2 = i + 1;
            if (i < size - 1) {
                str = ", ";
            } else {
                if (t instanceof EmptyExpression) {
                    str = ",";
                }
                i = i2;
            }
            sb.append(str);
            i = i2;
        }
    }

    public void setBounds(int i, int i2) {
        setPosition(i);
        setLength(i2 - i);
    }

    public void setInlineComment(AstNode astNode) {
        this.inlineComment = astNode;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setParent(AstNode astNode) {
        AstNode astNode2 = this.parent;
        if (astNode == astNode2) {
            return;
        }
        if (astNode2 != null) {
            setRelative(-astNode2.getAbsolutePosition());
        }
        this.parent = astNode;
        if (astNode != null) {
            setRelative(astNode.getAbsolutePosition());
        }
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setRelative(int i) {
        this.position -= i;
    }

    public String shortName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }

    public String toSource() {
        return toSource(0);
    }

    public abstract String toSource(int i);

    public abstract void visit(NodeVisitor nodeVisitor);

    public AstNode(int i) {
        this();
        this.position = i;
    }

    public AstNode(int i, int i2) {
        this();
        this.position = i;
        this.length = i2;
    }
}
