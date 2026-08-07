package external.sdk.pendo.io.mozilla.javascript.tools.debugger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/* JADX INFO: loaded from: classes4.dex */
class MyTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 2971618907207577000L;
    private SwingGui debugGui;
    private List<String> expressions = Collections.synchronizedList(new ArrayList());
    private List<String> values = Collections.synchronizedList(new ArrayList());

    public MyTableModel(SwingGui swingGui) {
        this.debugGui = swingGui;
        this.expressions.add("");
        this.values.add("");
    }

    public int getColumnCount() {
        return 2;
    }

    public String getColumnName(int i) {
        if (i == 0) {
            return "Expression";
        }
        if (i != 1) {
            return null;
        }
        return "Value";
    }

    public int getRowCount() {
        return this.expressions.size();
    }

    public Object getValueAt(int i, int i2) {
        List<String> list;
        if (i2 == 0) {
            list = this.expressions;
        } else {
            if (i2 != 1) {
                return "";
            }
            list = this.values;
        }
        return list.get(i);
    }

    public boolean isCellEditable(int i, int i2) {
        return true;
    }

    public void setValueAt(Object obj, int i, int i2) {
        String strEval;
        if (i2 != 0) {
            if (i2 != 1) {
                return;
            }
            fireTableDataChanged();
            return;
        }
        String string = obj.toString();
        this.expressions.set(i, string);
        if (string.length() <= 0 || (strEval = this.debugGui.dim.eval(string)) == null) {
            strEval = "";
        }
        this.values.set(i, strEval);
        updateModel();
        int i3 = i + 1;
        if (i3 == this.expressions.size()) {
            this.expressions.add("");
            this.values.add("");
            fireTableRowsInserted(i3, i3);
        }
    }

    void updateModel() {
        String strEval;
        for (int i = 0; i < this.expressions.size(); i++) {
            String str = this.expressions.get(i);
            if (str.length() <= 0 || (strEval = this.debugGui.dim.eval(str)) == null) {
                strEval = "";
            }
            this.values.set(i, strEval.replace('\n', ' '));
        }
        fireTableDataChanged();
    }
}
