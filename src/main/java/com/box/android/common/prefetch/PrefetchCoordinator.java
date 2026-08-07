package com.box.android.common.prefetch;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: PrefetchCoordinator.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fJ\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/common/prefetch/PrefetchCoordinator;", ExifInterface.GPS_DIRECTION_TRUE, "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", SemanticAttributes.DbSystemValues.CACHE, "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/box/android/common/prefetch/PrefetchCoordinator$PrefetchEntry;", "store", "", "key", "upstream", "Lkotlinx/coroutines/flow/Flow;", "consume", "cancelPrefetch", "PrefetchEntry", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PrefetchCoordinator<T> {
    private final ConcurrentHashMap<String, PrefetchEntry<T>> cache;
    private final CoroutineDispatcher dispatcher;

    public PrefetchCoordinator(CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.cache = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PrefetchCoordinator.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/common/prefetch/PrefetchCoordinator$PrefetchEntry;", ExifInterface.GPS_DIRECTION_TRUE, "", "channel", "Lkotlinx/coroutines/channels/Channel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/CoroutineScope;)V", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class PrefetchEntry<T> {
        private final Channel<T> channel;
        private final CoroutineScope scope;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PrefetchEntry copy$default(PrefetchEntry prefetchEntry, Channel channel, CoroutineScope coroutineScope, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = prefetchEntry.channel;
            }
            if ((i & 2) != 0) {
                coroutineScope = prefetchEntry.scope;
            }
            return prefetchEntry.copy(channel, coroutineScope);
        }

        public final Channel<T> component1() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CoroutineScope getScope() {
            return this.scope;
        }

        public final PrefetchEntry<T> copy(Channel<T> channel, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(scope, "scope");
            return new PrefetchEntry<>(channel, scope);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PrefetchEntry)) {
                return false;
            }
            PrefetchEntry prefetchEntry = (PrefetchEntry) other;
            return Intrinsics.areEqual(this.channel, prefetchEntry.channel) && Intrinsics.areEqual(this.scope, prefetchEntry.scope);
        }

        public int hashCode() {
            return (this.channel.hashCode() * 31) + this.scope.hashCode();
        }

        public String toString() {
            return "PrefetchEntry(channel=" + this.channel + ", scope=" + this.scope + ")";
        }

        public PrefetchEntry(Channel<T> channel, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.channel = channel;
            this.scope = scope;
        }

        public final Channel<T> getChannel() {
            return this.channel;
        }

        public final CoroutineScope getScope() {
            return this.scope;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PrefetchEntry store$lambda$1(Function1 function1, Object obj) {
        return (PrefetchEntry) function1.invoke(obj);
    }

    public final void store(String key, final Flow<? extends T> upstream) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        ConcurrentHashMap<String, PrefetchEntry<T>> concurrentHashMap = this.cache;
        final Function1 function1 = new Function1() { // from class: com.box.android.common.prefetch.PrefetchCoordinator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PrefetchCoordinator.store$lambda$0(this.f$0, upstream, (String) obj);
            }
        };
        concurrentHashMap.computeIfAbsent(key, new Function() { // from class: com.box.android.common.prefetch.PrefetchCoordinator$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return PrefetchCoordinator.store$lambda$1(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PrefetchEntry store$lambda$0(PrefetchCoordinator prefetchCoordinator, Flow flow, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(prefetchCoordinator.dispatcher));
        Channel channelChannel$default = ChannelKt.Channel$default(-1, null, null, 6, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new PrefetchCoordinator$store$1$1(flow, channelChannel$default, null), 3, null);
        return new PrefetchEntry(channelChannel$default, CoroutineScope);
    }

    /* JADX INFO: renamed from: com.box.android.common.prefetch.PrefetchCoordinator$consume$1, reason: invalid class name */
    /* JADX INFO: compiled from: PrefetchCoordinator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.common.prefetch.PrefetchCoordinator$consume$1", f = "PrefetchCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ PrefetchEntry<T> $entry;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PrefetchEntry<T> prefetchEntry, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$entry = prefetchEntry;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new AnonymousClass1(this.$entry, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.cancel$default(this.$entry.getScope(), null, 1, null);
            return Unit.INSTANCE;
        }
    }

    public final Flow<T> consume(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        PrefetchEntry<T> prefetchEntryRemove = this.cache.remove(key);
        if (prefetchEntryRemove == null) {
            return null;
        }
        return FlowKt.onCompletion(FlowKt.consumeAsFlow(prefetchEntryRemove.getChannel()), new AnonymousClass1(prefetchEntryRemove, null));
    }

    public final void cancelPrefetch(String key) {
        CoroutineScope scope;
        Intrinsics.checkNotNullParameter(key, "key");
        PrefetchEntry<T> prefetchEntryRemove = this.cache.remove(key);
        if (prefetchEntryRemove == null || (scope = prefetchEntryRemove.getScope()) == null) {
            return;
        }
        CoroutineScopeKt.cancel$default(scope, null, 1, null);
    }
}
