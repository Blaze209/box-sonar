package com.pspdfkit.internal;

import android.content.Context;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class qv {
    /* JADX WARN: Code duplicated, block: B:21:0x008b  */
    /* JADX WARN: Code duplicated, block: B:23:0x00c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:27:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c7 -> B:25:0x00cc). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(com.pspdfkit.internal.lm r17, java.util.List r18, android.content.Context r19, int r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.qv.a(com.pspdfkit.internal.lm, java.util.List, android.content.Context, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final Single a(final lm lmVar, final ArrayList arrayList, final Context context, final int i) {
        arrayList.getClass();
        context.getClass();
        if (lmVar == null) {
            Single singleJust = Single.just(CollectionsKt.emptyList());
            singleJust.getClass();
            return singleJust;
        }
        Single singleCreate = Single.create(new SingleOnSubscribe() { // from class: com.pspdfkit.internal.qv$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                qv.a(lmVar, arrayList, context, i, singleEmitter);
            }
        });
        singleCreate.getClass();
        return singleCreate;
    }

    public static final void a(lm lmVar, List list, Context context, int i, SingleEmitter singleEmitter) {
        singleEmitter.getClass();
        final Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new pv(lmVar, list, context, i, singleEmitter, null), 3, null);
        singleEmitter.setCancellable(new Cancellable() { // from class: com.pspdfkit.internal.qv$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                qv.a(jobLaunch$default);
            }
        });
    }

    public static final void a(Job job) {
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
    }
}
