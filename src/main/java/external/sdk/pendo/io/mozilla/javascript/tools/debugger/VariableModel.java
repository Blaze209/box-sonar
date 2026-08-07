package external.sdk.pendo.io.mozilla.javascript.tools.debugger;

import external.sdk.pendo.io.mozilla.javascript.tools.debugger.treetable.TreeTableModel;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: classes4.dex */
class VariableModel implements TreeTableModel {
    private Dim debugger;
    private VariableNode root;
    private static final String[] cNames = {" Name", " Value"};
    private static final Class<?>[] cTypes = {TreeTableModel.class, String.class};
    private static final VariableNode[] CHILDLESS = new VariableNode[0];

    private static class VariableNode {
        private VariableNode[] children;
        private Object id;
        private Object object;

        public VariableNode(Object obj, Object obj2) {
            this.object = obj;
            this.id = obj2;
        }

        public String toString() {
            Object obj = this.id;
            return obj instanceof String ? (String) obj : "[" + ((Integer) this.id).intValue() + "]";
        }
    }

    public VariableModel() {
    }

    public VariableModel(Dim dim, Object obj) {
        this.debugger = dim;
        this.root = new VariableNode(obj, "this");
    }

    private VariableNode[] children(VariableNode variableNode) {
        VariableNode[] variableNodeArr;
        if (variableNode.children != null) {
            return variableNode.children;
        }
        Object value = getValue(variableNode);
        Object[] objectIds = this.debugger.getObjectIds(value);
        if (objectIds == null || objectIds.length == 0) {
            variableNodeArr = CHILDLESS;
        } else {
            Arrays.sort(objectIds, new Comparator<Object>() { // from class: external.sdk.pendo.io.mozilla.javascript.tools.debugger.VariableModel.1
                @Override // java.util.Comparator
                public int compare(Object obj, Object obj2) {
                    if (obj instanceof String) {
                        if (obj2 instanceof Integer) {
                            return -1;
                        }
                        return ((String) obj).compareToIgnoreCase((String) obj2);
                    }
                    if (obj2 instanceof String) {
                        return 1;
                    }
                    return ((Integer) obj).intValue() - ((Integer) obj2).intValue();
                }
            });
            variableNodeArr = new VariableNode[objectIds.length];
            for (int i = 0; i != objectIds.length; i++) {
                variableNodeArr[i] = new VariableNode(value, objectIds[i]);
            }
        }
        variableNode.children = variableNodeArr;
        return variableNodeArr;
    }

    public void addTreeModelListener(TreeModelListener treeModelListener) {
    }

    public Object getChild(Object obj, int i) {
        if (this.debugger == null) {
            return null;
        }
        return children((VariableNode) obj)[i];
    }

    public int getChildCount(Object obj) {
        if (this.debugger == null) {
            return 0;
        }
        return children((VariableNode) obj).length;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public Class<?> getColumnClass(int i) {
        return cTypes[i];
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public int getColumnCount() {
        return cNames.length;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public String getColumnName(int i) {
        return cNames[i];
    }

    public int getIndexOfChild(Object obj, Object obj2) {
        if (this.debugger == null) {
            return -1;
        }
        VariableNode variableNode = (VariableNode) obj2;
        VariableNode[] variableNodeArrChildren = children((VariableNode) obj);
        for (int i = 0; i != variableNodeArrChildren.length; i++) {
            if (variableNodeArrChildren[i] == variableNode) {
                return i;
            }
        }
        return -1;
    }

    public Object getRoot() {
        if (this.debugger == null) {
            return null;
        }
        return this.root;
    }

    public Object getValue(VariableNode variableNode) {
        try {
            return this.debugger.getObjectProperty(variableNode.object, variableNode.id);
        } catch (Exception unused) {
            return "undefined";
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public Object getValueAt(Object obj, int i) {
        String string;
        Dim dim = this.debugger;
        if (dim == null) {
            return null;
        }
        VariableNode variableNode = (VariableNode) obj;
        if (i == 0) {
            return variableNode.toString();
        }
        if (i != 1) {
            return null;
        }
        try {
            string = dim.objectToString(getValue(variableNode));
        } catch (RuntimeException e) {
            String message = e.getMessage();
            string = message == null ? e.toString() : message;
        }
        StringBuilder sb = new StringBuilder();
        int length = string.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = string.charAt(i2);
            if (Character.isISOControl(cCharAt)) {
                cCharAt = ' ';
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public boolean isCellEditable(Object obj, int i) {
        return i == 0;
    }

    public boolean isLeaf(Object obj) {
        return this.debugger == null || children((VariableNode) obj).length == 0;
    }

    public void removeTreeModelListener(TreeModelListener treeModelListener) {
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public void setValueAt(Object obj, Object obj2, int i) {
    }

    public void valueForPathChanged(TreePath treePath, Object obj) {
    }
}
