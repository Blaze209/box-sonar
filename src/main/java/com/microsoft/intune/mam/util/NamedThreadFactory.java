package com.microsoft.intune.mam.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public class NamedThreadFactory implements ThreadFactory {
    ThreadGroup mGroup;
    Callable<String> mNamer;

    public NamedThreadFactory(Callable<String> callable) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            this.mGroup = securityManager.getThreadGroup();
        } else {
            this.mGroup = Thread.currentThread().getThreadGroup();
        }
        this.mNamer = callable;
    }

    public NamedThreadFactory(final String str) {
        this(new Callable<String>() { // from class: com.microsoft.intune.mam.util.NamedThreadFactory.1
            @Override // java.util.concurrent.Callable
            public String call() {
                return str;
            }
        });
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String strCall;
        try {
            strCall = this.mNamer.call();
        } catch (Exception unused) {
            strCall = "Intune MAM  thread";
        }
        Thread thread = new Thread(this.mGroup, runnable, strCall);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
