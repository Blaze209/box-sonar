package external.sdk.pendo.io.mozilla.javascript.tools.debugger;

/* JADX INFO: loaded from: classes4.dex */
public interface GuiCallback {
    void dispatchNextGuiEvent();

    void enterInterrupt(Dim.StackFrame stackFrame, String str, String str2);

    boolean isGuiEventThread();

    void updateSourceText(Dim.SourceInfo sourceInfo);
}
