package sdk.pendo.io.l5;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes4.dex */
public class a implements Executor {
    private Executor a = Executors.newSingleThreadExecutor();

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }
}
