package com.pspdfkit.internal;

import android.os.Process;
import android.os.SystemClock;
import androidx.collection.SieveCacheKt;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.schedulers.ScheduledRunnable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class bx {
    public final ExecutorService b;
    public final Future[] c;
    public boolean d = true;
    public final PriorityBlockingQueue<b> a = new PriorityBlockingQueue<>();

    public class a extends Scheduler {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler
        public final Scheduler.Worker createWorker() {
            return new c(bx.this.a, this.a);
        }
    }

    public static class b implements Runnable, Comparable<b> {
        public final Runnable a;
        public final int b;
        public final long c = SystemClock.elapsedRealtimeNanos();

        public b(Runnable runnable, int i) {
            this.a = runnable;
            this.b = i;
        }

        @Override // java.lang.Comparable
        public final int compareTo(b bVar) {
            b bVar2 = bVar;
            int i = bVar2.b;
            int i2 = this.b;
            if (i != i2) {
                return i - i2;
            }
            long j = this.c - bVar2.c;
            if (j >= SieveCacheKt.NodeLinkMask) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.c == bVar.c && this.a.equals(bVar.a);
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.run();
        }
    }

    public static class c extends Scheduler.Worker {
        public final CompositeDisposable a = new CompositeDisposable();
        public final PriorityBlockingQueue<b> b;
        public final int c;

        public c(PriorityBlockingQueue<b> priorityBlockingQueue, int i) {
            this.b = priorityBlockingQueue;
            this.c = i;
        }

        public final /* synthetic */ void a(b bVar) throws Throwable {
            this.b.remove(bVar);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public final void dispose() {
            this.a.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public final boolean isDisposed() {
            return this.a.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            final b bVar = new b(runnable, this.c);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(runnable, this.a);
            this.a.add(Disposable.fromAction(new Action() { // from class: com.pspdfkit.internal.bx$c$$ExternalSyntheticLambda0
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() throws Throwable {
                    this.f$0.a(bVar);
                }
            }));
            this.b.offer(bVar, j, timeUnit);
            return scheduledRunnable;
        }
    }

    public bx(final String str, int i) {
        this.b = Executors.newFixedThreadPool(i, new ThreadFactory() { // from class: com.pspdfkit.internal.bx$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return bx.a(str, runnable);
            }
        });
        this.c = new Future[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.c[i2] = this.b.submit(new Runnable() { // from class: com.pspdfkit.internal.bx$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() throws Exception {
                    this.f$0.a();
                }
            });
        }
    }

    public static /* synthetic */ Thread a(String str, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }

    public final void b() {
        this.d = false;
        for (Future future : this.c) {
            future.cancel(true);
        }
        this.b.shutdownNow();
    }

    public final void a() throws Exception {
        while (this.d) {
            Process.setThreadPriority(10);
            try {
                this.a.take().a.run();
            } catch (InterruptedException unused) {
                return;
            } catch (Exception e) {
                PdfLog.e("Nutri.PriorityScheduler", e, "Unhandled exception on priority scheduler", new Object[0]);
                throw e;
            }
        }
    }
}
