package org.tinylog.converters;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes5.dex */
final class NamedDaemonThreadFactory implements ThreadFactory {
    private final String name;

    NamedDaemonThreadFactory(String str) {
        this.name = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.name);
        thread.setPriority(1);
        thread.setDaemon(true);
        return thread;
    }
}
