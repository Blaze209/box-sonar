package io.split.android.engine.scheduler;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public interface PausableThreadPoolExecutor extends ExecutorService {
    void pause();

    void resume();
}
