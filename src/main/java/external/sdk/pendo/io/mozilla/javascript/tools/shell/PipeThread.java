package external.sdk.pendo.io.mozilla.javascript.tools.shell;

import external.sdk.pendo.io.mozilla.javascript.Context;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
class PipeThread extends Thread {
    private InputStream from;
    private boolean fromProcess;
    private OutputStream to;

    PipeThread(boolean z, InputStream inputStream, OutputStream outputStream) {
        setDaemon(true);
        this.fromProcess = z;
        this.from = inputStream;
        this.to = outputStream;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            Global.pipe(this.fromProcess, this.from, this.to);
        } catch (IOException e) {
            throw Context.throwAsScriptRuntimeEx(e);
        }
    }
}
