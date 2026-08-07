package kotlinx.coroutines.rx3;

import androidx.exifinterface.media.ExifInterface;
import com.pspdfkit.analytics.Analytics;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.ObservableSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: compiled from: RxChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u0003H\u0001ø\u0001\u0000\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u0004H\u0001ø\u0001\u0000\u001a7\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\bH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\t\u001a7\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\bH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b9¨\u0006\u000b"}, d2 = {"openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/reactivex/rxjava3/core/MaybeSource;", "Lio/reactivex/rxjava3/core/ObservableSource;", "collect", "", Analytics.Data.ACTION, "Lkotlin/Function1;", "(Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/reactivex/rxjava3/core/ObservableSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-rx3"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RxChannelKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.rx3.RxChannelKt$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: RxChannel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "kotlinx.coroutines.rx3.RxChannelKt", f = "RxChannel.kt", i = {0, 0}, l = {92}, m = "collect", n = {Analytics.Data.ACTION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RxChannelKt.collect((MaybeSource) null, (Function1) null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.rx3.RxChannelKt$collect$2, reason: invalid class name */
    /* JADX INFO: compiled from: RxChannel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "kotlinx.coroutines.rx3.RxChannelKt", f = "RxChannel.kt", i = {0, 0}, l = {92}, m = "collect", n = {Analytics.Data.ACTION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass2<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RxChannelKt.collect((ObservableSource) null, (Function1) null, this);
        }
    }

    public static final <T> ReceiveChannel<T> openSubscription(MaybeSource<T> maybeSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        maybeSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    public static final <T> ReceiveChannel<T> openSubscription(ObservableSource<T> observableSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        observableSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0061 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    /* JADX WARN: Code duplicated, block: B:28:0x006e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0078), top: B:42:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final <T> java.lang.Object collect(io.reactivex.rxjava3.core.MaybeSource<T> r6, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.rx3.RxChannelKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            kotlinx.coroutines.rx3.RxChannelKt$collect$1 r0 = (kotlinx.coroutines.rx3.RxChannelKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            kotlinx.coroutines.rx3.RxChannelKt$collect$1 r0 = new kotlinx.coroutines.rx3.RxChannelKt$collect$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 != r4) goto L3d
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L3b
            r5 = r0
            r0 = r7
            r7 = r2
        L39:
            r2 = r5
            goto L66
        L3b:
            r6 = move-exception
            goto L8a
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.ReceiveChannel r6 = openSubscription(r6)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch: java.lang.Throwable -> L86
            r5 = r8
            r8 = r6
            r6 = r5
        L53:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L83
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L83
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L83
            r0.label = r4     // Catch: java.lang.Throwable -> L83
            java.lang.Object r2 = r6.hasNext(r0)     // Catch: java.lang.Throwable -> L83
            if (r2 != r1) goto L62
            return r1
        L62:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L39
        L66:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L80
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L80
            if (r8 == 0) goto L78
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L80
            r7.invoke(r8)     // Catch: java.lang.Throwable -> L80
            r8 = r0
            r0 = r2
            goto L53
        L78:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L80
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L80:
            r6 = move-exception
            r7 = r0
            goto L8a
        L83:
            r6 = move-exception
            r7 = r8
            goto L8a
        L86:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L8a:
            throw r6     // Catch: java.lang.Throwable -> L8b
        L8b:
            r8 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxChannelKt.collect(io.reactivex.rxjava3.core.MaybeSource, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final <T> Object collect$$forInline(MaybeSource<T> maybeSource, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel receiveChannelOpenSubscription = openSubscription(maybeSource);
        try {
            ReceiveChannel receiveChannel = receiveChannelOpenSubscription;
            ChannelIterator it = receiveChannelOpenSubscription.iterator();
            while (((Boolean) it.hasNext(null)).booleanValue()) {
                function1.invoke((Object) it.next());
            }
            Unit unit = Unit.INSTANCE;
            ChannelsKt.cancelConsumed(receiveChannelOpenSubscription, null);
            Unit unit2 = Unit.INSTANCE;
            return Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ChannelsKt.cancelConsumed(receiveChannelOpenSubscription, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0061 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    /* JADX WARN: Code duplicated, block: B:28:0x006e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0078), top: B:42:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final <T> java.lang.Object collect(io.reactivex.rxjava3.core.ObservableSource<T> r6, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.rx3.RxChannelKt.AnonymousClass2
            if (r0 == 0) goto L14
            r0 = r8
            kotlinx.coroutines.rx3.RxChannelKt$collect$2 r0 = (kotlinx.coroutines.rx3.RxChannelKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            kotlinx.coroutines.rx3.RxChannelKt$collect$2 r0 = new kotlinx.coroutines.rx3.RxChannelKt$collect$2
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 != r4) goto L3d
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L3b
            r5 = r0
            r0 = r7
            r7 = r2
        L39:
            r2 = r5
            goto L66
        L3b:
            r6 = move-exception
            goto L8a
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.ReceiveChannel r6 = openSubscription(r6)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch: java.lang.Throwable -> L86
            r5 = r8
            r8 = r6
            r6 = r5
        L53:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L83
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L83
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L83
            r0.label = r4     // Catch: java.lang.Throwable -> L83
            java.lang.Object r2 = r6.hasNext(r0)     // Catch: java.lang.Throwable -> L83
            if (r2 != r1) goto L62
            return r1
        L62:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L39
        L66:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L80
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L80
            if (r8 == 0) goto L78
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L80
            r7.invoke(r8)     // Catch: java.lang.Throwable -> L80
            r8 = r0
            r0 = r2
            goto L53
        L78:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L80
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L80:
            r6 = move-exception
            r7 = r0
            goto L8a
        L83:
            r6 = move-exception
            r7 = r8
            goto L8a
        L86:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L8a:
            throw r6     // Catch: java.lang.Throwable -> L8b
        L8b:
            r8 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxChannelKt.collect(io.reactivex.rxjava3.core.ObservableSource, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final <T> Object collect$$forInline(ObservableSource<T> observableSource, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel receiveChannelOpenSubscription = openSubscription(observableSource);
        try {
            ReceiveChannel receiveChannel = receiveChannelOpenSubscription;
            ChannelIterator it = receiveChannelOpenSubscription.iterator();
            while (((Boolean) it.hasNext(null)).booleanValue()) {
                function1.invoke((Object) it.next());
            }
            Unit unit = Unit.INSTANCE;
            ChannelsKt.cancelConsumed(receiveChannelOpenSubscription, null);
            Unit unit2 = Unit.INSTANCE;
            return Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ChannelsKt.cancelConsumed(receiveChannelOpenSubscription, th);
                throw th2;
            }
        }
    }
}
