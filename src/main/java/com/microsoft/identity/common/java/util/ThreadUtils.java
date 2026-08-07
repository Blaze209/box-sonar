package com.microsoft.identity.common.java.util;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.microsoft.identity.common.java.logging.Logger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes14.dex */
public class ThreadUtils {
    public static void sleepSafely(int i, String str, String str2) {
        if (str == null) {
            throw new NullPointerException("tag is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("message is marked non-null but is null");
        }
        if (i > 0) {
            try {
                Thread.sleep(i);
            } catch (InterruptedException unused) {
                Logger.info(str, str2);
                Thread.currentThread().interrupt();
            }
        }
    }

    public static ExecutorService getNamedThreadPoolExecutor(int i, int i2, int i3, long j, TimeUnit timeUnit, String str) {
        if (timeUnit == null) {
            throw new NullPointerException("keepAliveUnit is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("poolName is marked non-null but is null");
        }
        if (i3 > 0) {
            return new ThreadPoolExecutor(i, i2, j, timeUnit, new ArrayBlockingQueue(i3), getNamedThreadFactory(str, System.getSecurityManager()));
        }
        if (i3 == 0) {
            return new ThreadPoolExecutor(i, i2, j, timeUnit, new SynchronousQueue(), getNamedThreadFactory(str, System.getSecurityManager()));
        }
        return new ThreadPoolExecutor(i, i2, j, timeUnit, new LinkedBlockingQueue(), getNamedThreadFactory(str, System.getSecurityManager()));
    }

    private static ThreadFactory getNamedThreadFactory(String str, SecurityManager securityManager) {
        if (str == null) {
            throw new NullPointerException("poolName is marked non-null but is null");
        }
        return new ThreadFactory(str, securityManager) { // from class: com.microsoft.identity.common.java.util.ThreadUtils.1
            private final ThreadGroup group;
            private final String poolPrefix;
            private final AtomicLong threadNumber = new AtomicLong(1);
            final /* synthetic */ String val$poolName;
            final /* synthetic */ SecurityManager val$securityManager;

            {
                ThreadGroup threadGroup;
                this.val$poolName = str;
                this.val$securityManager = securityManager;
                this.poolPrefix = str + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR;
                if (securityManager == null) {
                    threadGroup = Thread.currentThread().getThreadGroup();
                } else {
                    threadGroup = securityManager.getThreadGroup();
                }
                this.group = threadGroup;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(this.group, runnable, this.poolPrefix + this.threadNumber.getAndIncrement(), 0L);
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.microsoft.identity.common.java.util.ThreadUtils.1.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread thread2, Throwable th) {
                        if (thread2 == null) {
                            throw new NullPointerException("t is marked non-null but is null");
                        }
                        if (th == null) {
                            throw new NullPointerException("e is marked non-null but is null");
                        }
                        if (th instanceof ThreadDeath) {
                            Logger.info("ThreadPool[" + AnonymousClass1.this.val$poolName + "]", null, "Thread Death Exception in thread pool " + AnonymousClass1.this.val$poolName);
                        } else {
                            Logger.error("ThreadPool[" + AnonymousClass1.this.val$poolName + "]", null, "Uncaught Exception in thread pool " + AnonymousClass1.this.val$poolName, th);
                        }
                    }
                });
                return thread;
            }
        };
    }
}
