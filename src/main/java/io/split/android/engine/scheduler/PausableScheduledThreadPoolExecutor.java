package io.split.android.engine.scheduler;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public interface PausableScheduledThreadPoolExecutor extends ScheduledExecutorService {
    void pause();

    void resume();
}
