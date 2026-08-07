package external.sdk.pendo.io.mozilla.javascript.tools.debugger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/* JADX INFO: loaded from: classes4.dex */
class Menubar extends JMenuBar implements ActionListener {
    private static final long serialVersionUID = 3217170497245911461L;
    private JCheckBoxMenuItem breakOnEnter;
    private JCheckBoxMenuItem breakOnExceptions;
    private JCheckBoxMenuItem breakOnReturn;
    private SwingGui debugGui;
    private List<JMenuItem> interruptOnlyItems = Collections.synchronizedList(new ArrayList());
    private List<JMenuItem> runOnlyItems = Collections.synchronizedList(new ArrayList());
    private JMenu windowMenu;

    Menubar(SwingGui swingGui) {
        int i;
        char[] cArr;
        this.debugGui = swingGui;
        String[] strArr = {"Open...", "Run...", "", "Exit"};
        String[] strArr2 = {"Open", "Load", "", "Exit"};
        char[] cArr2 = {'0', 'N', 0, 'X'};
        int[] iArr = {79, 78, 0, 81};
        String[] strArr3 = {"Cut", "Copy", "Paste", "Go to function...", "Go to line..."};
        char[] cArr3 = {'T', 'C', 'P', 'F', 'L'};
        int[] iArr2 = {0, 0, 0, 0, 76};
        String[] strArr4 = {"Break", "Go", "Step Into", "Step Over", "Step Out"};
        char[] cArr4 = {'B', 'G', 'I', 'O', 'T'};
        String[] strArr5 = {"Metal", "Windows", "Motif"};
        char[] cArr5 = {'M', 'W', 'F'};
        int[] iArr3 = {19, 116, 122, 118, 119, 0, 0};
        JMenu jMenu = new JMenu("File");
        jMenu.setMnemonic('F');
        JMenu jMenu2 = new JMenu("Edit");
        jMenu2.setMnemonic('E');
        JMenu jMenu3 = new JMenu("Platform");
        jMenu3.setMnemonic('P');
        JMenu jMenu4 = new JMenu("Debug");
        jMenu4.setMnemonic('D');
        JMenu jMenu5 = new JMenu("Window");
        this.windowMenu = jMenu5;
        jMenu5.setMnemonic('W');
        int i2 = 0;
        while (i2 < 4) {
            if (strArr[i2].length() == 0) {
                jMenu.addSeparator();
                i = i2;
                cArr = cArr2;
            } else {
                i = i2;
                cArr = cArr2;
                JMenuItem jMenuItem = new JMenuItem(strArr[i], cArr[i]);
                jMenuItem.setActionCommand(strArr2[i]);
                jMenuItem.addActionListener(this);
                jMenu.add(jMenuItem);
                int i3 = iArr[i];
                if (i3 != 0) {
                    jMenuItem.setAccelerator(KeyStroke.getKeyStroke(i3, 2));
                }
            }
            i2 = i + 1;
            cArr2 = cArr;
        }
        for (int i4 = 0; i4 < 5; i4++) {
            JMenuItem jMenuItem2 = new JMenuItem(strArr3[i4], cArr3[i4]);
            jMenuItem2.addActionListener(this);
            jMenu2.add(jMenuItem2);
            int i5 = iArr2[i4];
            if (i5 != 0) {
                jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(i5, 2));
            }
        }
        for (int i6 = 0; i6 < 3; i6++) {
            JMenuItem jMenuItem3 = new JMenuItem(strArr5[i6], cArr5[i6]);
            jMenuItem3.addActionListener(this);
            jMenu3.add(jMenuItem3);
        }
        int i7 = 0;
        while (i7 < 5) {
            JMenuItem jMenuItem4 = new JMenuItem(strArr4[i7], cArr4[i7]);
            jMenuItem4.addActionListener(this);
            int i8 = iArr3[i7];
            if (i8 != 0) {
                jMenuItem4.setAccelerator(KeyStroke.getKeyStroke(i8, 0));
            }
            (i7 != 0 ? this.interruptOnlyItems : this.runOnlyItems).add(jMenuItem4);
            jMenu4.add(jMenuItem4);
            i7++;
        }
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem("Break on Exceptions");
        this.breakOnExceptions = jCheckBoxMenuItem;
        jCheckBoxMenuItem.setMnemonic('X');
        this.breakOnExceptions.addActionListener(this);
        this.breakOnExceptions.setSelected(false);
        jMenu4.add(this.breakOnExceptions);
        JCheckBoxMenuItem jCheckBoxMenuItem2 = new JCheckBoxMenuItem("Break on Function Enter");
        this.breakOnEnter = jCheckBoxMenuItem2;
        jCheckBoxMenuItem2.setMnemonic('E');
        this.breakOnEnter.addActionListener(this);
        this.breakOnEnter.setSelected(false);
        jMenu4.add(this.breakOnEnter);
        JCheckBoxMenuItem jCheckBoxMenuItem3 = new JCheckBoxMenuItem("Break on Function Return");
        this.breakOnReturn = jCheckBoxMenuItem3;
        jCheckBoxMenuItem3.setMnemonic('R');
        this.breakOnReturn.addActionListener(this);
        this.breakOnReturn.setSelected(false);
        jMenu4.add(this.breakOnReturn);
        add(jMenu);
        add(jMenu2);
        add(jMenu4);
        JMenu jMenu6 = this.windowMenu;
        JMenuItem jMenuItem5 = new JMenuItem("Cascade", 65);
        jMenu6.add(jMenuItem5);
        jMenuItem5.addActionListener(this);
        JMenu jMenu7 = this.windowMenu;
        JMenuItem jMenuItem6 = new JMenuItem("Tile", 84);
        jMenu7.add(jMenuItem6);
        jMenuItem6.addActionListener(this);
        this.windowMenu.addSeparator();
        JMenu jMenu8 = this.windowMenu;
        JMenuItem jMenuItem7 = new JMenuItem("Console", 67);
        jMenu8.add(jMenuItem7);
        jMenuItem7.addActionListener(this);
        add(this.windowMenu);
        updateEnabled(false);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String str;
        String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("Metal")) {
            str = "javax.swing.plaf.metal.MetalLookAndFeel";
        } else if (actionCommand.equals("Windows")) {
            str = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        } else {
            if (!actionCommand.equals("Motif")) {
                Object source = actionEvent.getSource();
                JCheckBoxMenuItem jCheckBoxMenuItem = this.breakOnExceptions;
                if (source == jCheckBoxMenuItem) {
                    this.debugGui.dim.setBreakOnExceptions(jCheckBoxMenuItem.isSelected());
                    return;
                }
                JCheckBoxMenuItem jCheckBoxMenuItem2 = this.breakOnEnter;
                if (source == jCheckBoxMenuItem2) {
                    this.debugGui.dim.setBreakOnEnter(jCheckBoxMenuItem2.isSelected());
                    return;
                }
                JCheckBoxMenuItem jCheckBoxMenuItem3 = this.breakOnReturn;
                SwingGui swingGui = this.debugGui;
                if (source == jCheckBoxMenuItem3) {
                    swingGui.dim.setBreakOnReturn(jCheckBoxMenuItem3.isSelected());
                    return;
                } else {
                    swingGui.actionPerformed(actionEvent);
                    return;
                }
            }
            str = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        }
        try {
            UIManager.setLookAndFeel(str);
            SwingUtilities.updateComponentTreeUI(this.debugGui);
            SwingUtilities.updateComponentTreeUI(this.debugGui.dlg);
        } catch (Exception unused) {
        }
    }

    public void addFile(String str) {
        boolean z;
        int i;
        int itemCount = this.windowMenu.getItemCount();
        if (itemCount == 4) {
            this.windowMenu.addSeparator();
            itemCount++;
        }
        JMenuItem item = this.windowMenu.getItem(itemCount - 1);
        if (item == null || !item.getText().equals("More Windows...")) {
            z = false;
            i = 5;
        } else {
            z = true;
            i = 6;
        }
        if (!z && itemCount - 4 == 5) {
            JMenu jMenu = this.windowMenu;
            JMenuItem jMenuItem = new JMenuItem("More Windows...", 77);
            jMenu.add(jMenuItem);
            jMenuItem.setActionCommand("More Windows...");
            jMenuItem.addActionListener(this);
            return;
        }
        if (itemCount - 4 <= i) {
            if (z) {
                itemCount--;
                this.windowMenu.remove(item);
            }
            String shortName = SwingGui.getShortName(str);
            JMenu jMenu2 = this.windowMenu;
            int i2 = itemCount + 44;
            JMenuItem jMenuItem2 = new JMenuItem(((char) i2) + " " + shortName, i2);
            jMenu2.add(jMenuItem2);
            if (z) {
                this.windowMenu.add(item);
            }
            jMenuItem2.setActionCommand(str);
            jMenuItem2.addActionListener(this);
        }
    }

    public JCheckBoxMenuItem getBreakOnEnter() {
        return this.breakOnEnter;
    }

    public JCheckBoxMenuItem getBreakOnExceptions() {
        return this.breakOnExceptions;
    }

    public JCheckBoxMenuItem getBreakOnReturn() {
        return this.breakOnReturn;
    }

    public JMenu getDebugMenu() {
        return getMenu(2);
    }

    public void updateEnabled(boolean z) {
        for (int i = 0; i != this.interruptOnlyItems.size(); i++) {
            this.interruptOnlyItems.get(i).setEnabled(z);
        }
        for (int i2 = 0; i2 != this.runOnlyItems.size(); i2++) {
            this.runOnlyItems.get(i2).setEnabled(!z);
        }
    }
}
