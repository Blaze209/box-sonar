package com.pspdfkit.internal;

import android.os.Bundle;
import android.util.Pair;
import com.pspdfkit.analytics.AnalyticsClient;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.PublishProcessor;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 {
    public final ConcurrentHashMap a = new ConcurrentHashMap();
    public final FlowableProcessor<Pair<String, Bundle>> b = PublishProcessor.create().toSerialized();

    public final boolean a(final AnalyticsClient analyticsClient) {
        uw.a(analyticsClient, "client", null);
        if (this.a.containsKey(analyticsClient)) {
            return false;
        }
        final ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Flowable<Pair<String, Bundle>> flowableObserveOn = this.b.onBackpressureBuffer().observeOn(Schedulers.from(executorServiceNewSingleThreadExecutor));
        Objects.requireNonNull(executorServiceNewSingleThreadExecutor);
        this.a.put(analyticsClient, flowableObserveOn.doOnCancel(new Action() { // from class: com.pspdfkit.internal.i0$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                executorServiceNewSingleThreadExecutor.shutdownNow();
            }
        }).subscribe(new Consumer() { // from class: com.pspdfkit.internal.i0$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                i0.a(analyticsClient, (Pair) obj);
            }
        }));
        return true;
    }

    public static /* synthetic */ void a(AnalyticsClient analyticsClient, Pair pair) throws Throwable {
        try {
            analyticsClient.onEvent((String) pair.first, new Bundle((Bundle) pair.second));
        } catch (Throwable th) {
            PdfLog.e("Nutri.AnalyticsDispatch", th, "Analytics client " + analyticsClient.toString() + " threw an exception.", new Object[0]);
        }
    }

    public final void a(String str, Bundle bundle) {
        this.b.onNext(new Pair<>(str, bundle));
    }
}
