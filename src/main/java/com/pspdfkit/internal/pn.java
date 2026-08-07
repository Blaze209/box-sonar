package com.pspdfkit.internal;

import android.os.Looper;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableMaybeObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class pn<T> {
    public ReplaySubject<T> a;
    public final Scheduler b;
    public T c;
    public final CompositeDisposable d;

    public interface a<T> {
        void apply(T t);
    }

    public static final class b extends DisposableMaybeObserver<T> {
        public final /* synthetic */ a<T> a;

        public b(a aVar) {
            this.a = aVar;
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public final void onComplete() {
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public final void onError(Throwable th) {
            th.getClass();
            PdfLog.e("Nutri.LazyObjectHolder", th, th.getMessage(), new Object[0]);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public final void onSuccess(T t) {
            t.getClass();
            this.a.apply(t);
        }
    }

    public pn() {
        ReplaySubject<T> replaySubjectCreate = ReplaySubject.create(1);
        replaySubjectCreate.getClass();
        this.a = replaySubjectCreate;
        Scheduler schedulerFrom = Schedulers.from(Executors.newSingleThreadExecutor());
        schedulerFrom.getClass();
        this.b = schedulerFrom;
        this.d = new CompositeDisposable();
    }

    public final T a() {
        T t = this.c;
        uw.b(t != null, "lazy object was null");
        t.getClass();
        return t;
    }

    public final boolean b() {
        return this.c != null;
    }

    public final void a(T t) {
        t.getClass();
        if (this.c != null) {
            return;
        }
        this.c = t;
        if (this.a.hasComplete()) {
            return;
        }
        this.a.onNext(t);
        this.a.onComplete();
    }

    public final void a(a<T> aVar, boolean z) {
        aVar.getClass();
        T t = this.c;
        if (t != null && !z && !this.a.hasObservers() && Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            aVar.apply(t);
        } else {
            this.d.add((Disposable) this.a.firstElement().subscribeOn(this.b).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new b(aVar)));
        }
    }
}
