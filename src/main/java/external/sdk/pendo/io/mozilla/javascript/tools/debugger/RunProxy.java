package external.sdk.pendo.io.mozilla.javascript.tools.debugger;

/* JADX INFO: loaded from: classes4.dex */
class RunProxy implements Runnable {
    static final int ENTER_INTERRUPT = 4;
    static final int LOAD_FILE = 2;
    static final int OPEN_FILE = 1;
    static final int UPDATE_SOURCE_TEXT = 3;
    String alertMessage;
    private SwingGui debugGui;
    String fileName;
    Dim.StackFrame lastFrame;
    Dim.SourceInfo sourceInfo;
    String text;
    String threadTitle;
    private int type;

    public RunProxy(SwingGui swingGui, int i) {
        this.debugGui = swingGui;
        this.type = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        SwingGui swingGui;
        String message;
        StringBuilder sb;
        int i = this.type;
        if (i == 1) {
            try {
                this.debugGui.dim.compileScript(this.fileName, this.text);
                return;
            } catch (RuntimeException e) {
                swingGui = this.debugGui;
                message = e.getMessage();
                sb = new StringBuilder("Error Compiling ");
            }
        } else {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalArgumentException(String.valueOf(this.type));
                    }
                    this.debugGui.enterInterruptImpl(this.lastFrame, this.threadTitle, this.alertMessage);
                    return;
                } else {
                    String strUrl = this.sourceInfo.url();
                    if (this.debugGui.updateFileWindow(this.sourceInfo) || strUrl.equals("<stdin>")) {
                        return;
                    }
                    this.debugGui.createFileWindow(this.sourceInfo, -1);
                    return;
                }
            }
            try {
                this.debugGui.dim.evalScript(this.fileName, this.text);
                return;
            } catch (RuntimeException e2) {
                swingGui = this.debugGui;
                message = e2.getMessage();
                sb = new StringBuilder("Run error for ");
            }
        }
        MessageDialogWrapper.showMessageDialog(swingGui, message, sb.append(this.fileName).toString(), 0);
    }
}
