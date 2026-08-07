package com.box.android.coreservices.executionqueue;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.browse.fragments.BoxSearchFragment;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: ExecutionPriorityQueue.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 52\u00020\u0001:\u000512345B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JD\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\u001c\u0010\u001c\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dH\u0086@¢\u0006\u0002\u0010\u001fJ8\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00190!\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190!0\"J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000fJ\u0016\u0010$\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000fJ\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0010H\u0002J\u000e\u0010(\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0016\u0010\u001c\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\u0012\u0010.\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u00010-H\u0002J\n\u00100\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\f\u001a*\u0012\u0004\u0012\u00020\u000b\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "numberOfConcurrentExecutions", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;I)V", BoxFile.FIELD_LOCK, "prioritiesWithQueue", "", "Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Priority;", "queues", "", "Ljava/util/LinkedHashMap;", "", "Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Entry;", "Lkotlin/collections/LinkedHashMap;", "runningEntries", "", "Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$RunningEntry;", "signal", "Lkotlinx/coroutines/channels/Channel;", "", "enqueue", ExifInterface.GPS_DIRECTION_TRUE, "key", LogFactory.PRIORITY_KEY, "execute", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Priority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueueFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function0;", "cancel", "reprioritize", "bumpToFrontOfPriority", "addEntry", "entry", "dispatchLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeImmediately", "(Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Entry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeExistingLocked", "Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$RemovedEntry;", "applyRemoval", "removed", "pollHighestLast", "Priority", "Entry", "RunningEntry", "RemovedEntry", "Companion", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExecutionPriorityQueue {
    private static final String TAG = "ExecutionPriorityQueue";
    private final Object lock;
    private final List<Priority> prioritiesWithQueue;
    private final Map<Priority, LinkedHashMap<String, Entry>> queues;
    private final Map<String, RunningEntry> runningEntries;
    private final CoroutineScope scope;
    private final Channel<Unit> signal;

    /* JADX INFO: compiled from: ExecutionPriorityQueue.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Priority;", "", "<init>", "(Ljava/lang/String;I)V", "IMMEDIATE", "NORMAL", "LOW", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Priority {
        IMMEDIATE,
        NORMAL,
        LOW;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Priority> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$dispatchLoop$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExecutionPriorityQueue.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.executionqueue.ExecutionPriorityQueue", f = "ExecutionPriorityQueue.kt", i = {1, 1}, l = {204, 207}, m = "dispatchLoop", n = {"_ignored", "entry"}, s = {"L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return ExecutionPriorityQueue.this.dispatchLoop(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$execute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExecutionPriorityQueue.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.executionqueue.ExecutionPriorityQueue", f = "ExecutionPriorityQueue.kt", i = {0, 0}, l = {BoxSearchFragment.REQUEST_FILTER_SEARCH_RESULTS}, m = "execute", n = {"entry", "executionJob"}, s = {"L$0", "L$1"}, v = 1)
    static final class C10061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10061(Continuation<? super C10061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExecutionPriorityQueue.this.execute(null, this);
        }
    }

    public ExecutionPriorityQueue(CoroutineScope scope, int i) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.lock = new Object();
        List<Priority> listListOf = CollectionsKt.listOf((Object[]) new Priority[]{Priority.NORMAL, Priority.LOW});
        this.prioritiesWithQueue = listListOf;
        List<Priority> list = listListOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(obj, new LinkedHashMap());
        }
        this.queues = linkedHashMap;
        this.runningEntries = new LinkedHashMap();
        this.signal = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        if (i <= 0) {
            throw new IllegalArgumentException("numberOfConcurrentExecutions must be greater then 0".toString());
        }
        for (int i2 = 0; i2 < i; i2++) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ExecutionPriorityQueue$2$1(this, null), 3, null);
        }
    }

    public /* synthetic */ ExecutionPriorityQueue(CoroutineScope coroutineScope, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, (i2 & 2) != 0 ? 1 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ExecutionPriorityQueue.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R)\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Entry;", "", "key", "", LogFactory.PRIORITY_KEY, "Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Priority;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "onCancel", "Lkotlin/Function0;", "<init>", "(Ljava/lang/String;Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Priority;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getKey", "()Ljava/lang/String;", "getPriority", "()Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Priority;", "setPriority", "(Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Priority;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "getOnCancel", "()Lkotlin/jvm/functions/Function0;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class Entry {
        private final Function1<Continuation<? super Unit>, Object> block;
        private final String key;
        private final Function0<Unit> onCancel;
        private Priority priority;

        /* JADX WARN: Multi-variable type inference failed */
        public Entry(String key, Priority priority, Function1<? super Continuation<? super Unit>, ? extends Object> block, Function0<Unit> onCancel) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(priority, "priority");
            Intrinsics.checkNotNullParameter(block, "block");
            Intrinsics.checkNotNullParameter(onCancel, "onCancel");
            this.key = key;
            this.priority = priority;
            this.block = block;
            this.onCancel = onCancel;
        }

        public final String getKey() {
            return this.key;
        }

        public final Priority getPriority() {
            return this.priority;
        }

        public final void setPriority(Priority priority) {
            Intrinsics.checkNotNullParameter(priority, "<set-?>");
            this.priority = priority;
        }

        public final Function1<Continuation<? super Unit>, Object> getBlock() {
            return this.block;
        }

        public final Function0<Unit> getOnCancel() {
            return this.onCancel;
        }
    }

    /* JADX INFO: compiled from: ExecutionPriorityQueue.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$RunningEntry;", "", "entry", "Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Entry;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Entry;Lkotlinx/coroutines/Job;)V", "getEntry", "()Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Entry;", "getJob", "()Lkotlinx/coroutines/Job;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class RunningEntry {
        private final Entry entry;
        private final Job job;

        public RunningEntry(Entry entry, Job job) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Intrinsics.checkNotNullParameter(job, "job");
            this.entry = entry;
            this.job = job;
        }

        public final Entry getEntry() {
            return this.entry;
        }

        public final Job getJob() {
            return this.job;
        }
    }

    /* JADX INFO: compiled from: ExecutionPriorityQueue.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$RemovedEntry;", "", "entry", "Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Entry;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Entry;Lkotlinx/coroutines/Job;)V", "getEntry", "()Lcom/box/android/coreservices/executionqueue/ExecutionPriorityQueue$Entry;", "getJob", "()Lkotlinx/coroutines/Job;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class RemovedEntry {
        private final Entry entry;
        private final Job job;

        public RemovedEntry(Entry entry, Job job) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.entry = entry;
            this.job = job;
        }

        public final Entry getEntry() {
            return this.entry;
        }

        public final Job getJob() {
            return this.job;
        }
    }

    public static /* synthetic */ Object enqueue$default(ExecutionPriorityQueue executionPriorityQueue, String str, Priority priority, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            priority = Priority.NORMAL;
        }
        return executionPriorityQueue.enqueue(str, priority, function1, continuation);
    }

    public final <T> Object enqueue(String str, Priority priority, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        addEntry(new Entry(str, priority, new AnonymousClass2(completableDeferredCompletableDeferred$default, function1, null), new Function0() { // from class: com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExecutionPriorityQueue.enqueue$lambda$0(completableDeferredCompletableDeferred$default);
            }
        }));
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$enqueue$2, reason: invalid class name */
    /* JADX INFO: compiled from: ExecutionPriorityQueue.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$enqueue$2", f = "ExecutionPriorityQueue.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<T> $deferred;
        final /* synthetic */ Function1<Continuation<? super T>, Object> $execute;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(CompletableDeferred<T> completableDeferred, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$deferred = completableDeferred;
            this.$execute = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$deferred, this.$execute, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$enqueue$2 for r3v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r0 = r3.L$0
                kotlinx.coroutines.CompletableDeferred r0 = (kotlinx.coroutines.CompletableDeferred) r0
                kotlin.ResultKt.throwOnFailure(r4)     // Catch: java.lang.Throwable -> L33
                goto L2f
            L13:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            L1b:
                kotlin.ResultKt.throwOnFailure(r4)
                kotlinx.coroutines.CompletableDeferred<T> r4 = r3.$deferred     // Catch: java.lang.Throwable -> L33
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super T>, java.lang.Object> r1 = r3.$execute     // Catch: java.lang.Throwable -> L33
                r3.L$0 = r4     // Catch: java.lang.Throwable -> L33
                r3.label = r2     // Catch: java.lang.Throwable -> L33
                java.lang.Object r1 = r1.invoke(r3)     // Catch: java.lang.Throwable -> L33
                if (r1 != r0) goto L2d
                return r0
            L2d:
                r0 = r4
                r4 = r1
            L2f:
                r0.complete(r4)     // Catch: java.lang.Throwable -> L33
                goto L39
            L33:
                r4 = move-exception
                kotlinx.coroutines.CompletableDeferred<T> r3 = r3.$deferred
                r3.completeExceptionally(r4)
            L39:
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.coreservices.executionqueue.ExecutionPriorityQueue.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enqueue$lambda$0(CompletableDeferred completableDeferred) {
        Job.DefaultImpls.cancel$default((Job) completableDeferred, (CancellationException) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Flow enqueueFlow$default(ExecutionPriorityQueue executionPriorityQueue, String str, Priority priority, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            priority = Priority.NORMAL;
        }
        return executionPriorityQueue.enqueueFlow(str, priority, function0);
    }

    public final <T> Flow<T> enqueueFlow(String key, Priority priority, Function0<? extends Flow<? extends T>> execute) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(execute, "execute");
        final Channel channelChannel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        addEntry(new Entry(key, priority, new C10051(execute, channelChannel$default, null), new Function0() { // from class: com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExecutionPriorityQueue.enqueueFlow$lambda$0(channelChannel$default);
            }
        }));
        return FlowKt.onCompletion(FlowKt.consumeAsFlow(channelChannel$default), new AnonymousClass3(key, null));
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$enqueueFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExecutionPriorityQueue.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$enqueueFlow$1", f = "ExecutionPriorityQueue.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10051 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<T> $emissions;
        final /* synthetic */ Function0<Flow<T>> $execute;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10051(Function0<? extends Flow<? extends T>> function0, Channel<T> channel, Continuation<? super C10051> continuation) {
            super(1, continuation);
            this.$execute = function0;
            this.$emissions = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10051(this.$execute, this.$emissions, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C10051) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow flow = (Flow) this.$execute.invoke();
                    final Channel<T> channel = this.$emissions;
                    this.label = 1;
                    if (flow.collect(new FlowCollector() { // from class: com.box.android.coreservices.executionqueue.ExecutionPriorityQueue.enqueueFlow.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(T t, Continuation<? super Unit> continuation) {
                            Object objSend = channel.send(t, continuation);
                            return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                SendChannel.DefaultImpls.close$default(this.$emissions, null, 1, null);
            } catch (Throwable th) {
                this.$emissions.close(th);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enqueueFlow$lambda$0(Channel channel) {
        channel.close(new CancellationException("Cancelled"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$enqueueFlow$3, reason: invalid class name */
    /* JADX INFO: compiled from: ExecutionPriorityQueue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$enqueueFlow$3", f = "ExecutionPriorityQueue.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.$key = str;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = ExecutionPriorityQueue.this.new AnonymousClass3(this.$key, continuation);
            anonymousClass3.L$0 = th;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th = (Throwable) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (th != null) {
                ExecutionPriorityQueue.this.cancel(this.$key);
            }
            return Unit.INSTANCE;
        }
    }

    public final void cancel(String key) {
        RemovedEntry removedEntryRemoveExistingLocked;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            removedEntryRemoveExistingLocked = removeExistingLocked(key);
        }
        applyRemoval(removedEntryRemoveExistingLocked);
    }

    public final void reprioritize(String key, Priority priority) {
        Entry entry;
        Object next;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(priority, "priority");
        synchronized (this.lock) {
            Iterator<T> it = this.queues.values().iterator();
            do {
                entry = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!((LinkedHashMap) next).containsKey(key));
            LinkedHashMap linkedHashMap = (LinkedHashMap) next;
            if (linkedHashMap == null) {
                return;
            }
            Entry entry2 = (Entry) linkedHashMap.get(key);
            if (entry2 == null) {
                return;
            }
            if (entry2.getPriority() == priority) {
                return;
            }
            linkedHashMap.remove(key);
            if (priority == Priority.IMMEDIATE) {
                BoxLogUtils.d(TAG, "Reprioritized: " + key + " → " + priority);
                this.runningEntries.put(entry2.getKey(), new RunningEntry(entry2, JobKt__JobKt.Job$default((Job) null, 1, (Object) null)));
                entry = entry2;
            } else {
                entry2.setPriority(priority);
                LinkedHashMap<String, Entry> linkedHashMap2 = this.queues.get(priority);
                Intrinsics.checkNotNull(linkedHashMap2);
                linkedHashMap2.put(key, entry2);
                BoxLogUtils.d(TAG, "Reprioritized: " + key + " → " + priority);
            }
            Unit unit = Unit.INSTANCE;
            if (entry != null) {
                executeImmediately(entry);
            }
        }
    }

    public final void bumpToFrontOfPriority(String key) {
        Object next;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            Iterator<T> it = this.queues.values().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!((LinkedHashMap) next).containsKey(key));
            LinkedHashMap linkedHashMap = (LinkedHashMap) next;
            if (linkedHashMap == null) {
                return;
            }
            Entry entry = (Entry) linkedHashMap.remove(key);
            if (entry == null) {
                return;
            }
            linkedHashMap.put(key, entry);
            BoxLogUtils.d(TAG, "Promoted: " + key);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void addEntry(Entry entry) {
        RemovedEntry removedEntryRemoveExistingLocked;
        boolean z;
        synchronized (this.lock) {
            removedEntryRemoveExistingLocked = removeExistingLocked(entry.getKey());
            if (entry.getPriority() == Priority.IMMEDIATE) {
                z = true;
                this.runningEntries.put(entry.getKey(), new RunningEntry(entry, JobKt__JobKt.Job$default((Job) null, 1, (Object) null)));
            } else {
                LinkedHashMap<String, Entry> linkedHashMap = this.queues.get(entry.getPriority());
                Intrinsics.checkNotNull(linkedHashMap);
                linkedHashMap.put(entry.getKey(), entry);
                z = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        applyRemoval(removedEntryRemoveExistingLocked);
        if (z) {
            BoxLogUtils.d(TAG, "Executing immediately: " + entry.getKey() + " [" + entry.getPriority() + "]");
            executeImmediately(entry);
            return;
        }
        BoxLogUtils.d(TAG, "Enqueued: " + entry.getKey() + " [" + entry.getPriority() + "]");
        ChannelResult.m16334boximpl(this.signal.mo11206trySendJP2dKIU(Unit.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0062  */
    /* JADX WARN: Code duplicated, block: B:23:0x006d  */
    /* JADX WARN: Code duplicated, block: B:29:0x007e  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:37:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007a -> B:28:0x007c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00be -> B:28:0x007c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object dispatchLoop(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.box.android.coreservices.executionqueue.ExecutionPriorityQueue.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r13
            com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$dispatchLoop$1 r0 = (com.box.android.coreservices.executionqueue.ExecutionPriorityQueue.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$dispatchLoop$1 r0 = new com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$dispatchLoop$1
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r2 = r0.L$2
            com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$Entry r2 = (com.box.android.coreservices.executionqueue.ExecutionPriorityQueue.Entry) r2
            java.lang.Object r2 = r0.L$1
            kotlin.Unit r2 = (kotlin.Unit) r2
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            kotlin.ResultKt.throwOnFailure(r13)
            goto L7c
        L39:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L41:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            kotlin.ResultKt.throwOnFailure(r13)
            goto L65
        L49:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r13 = r12.signal
            kotlinx.coroutines.channels.ChannelIterator r13 = r13.iterator()
        L52:
            r0.L$0 = r13
            r2 = 0
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r4
            java.lang.Object r2 = r13.hasNext(r0)
            if (r2 != r1) goto L62
            goto Lc0
        L62:
            r11 = r2
            r2 = r13
            r13 = r11
        L65:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto Lc4
            r2.next()
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            java.lang.Object r5 = r12.lock
            monitor-enter(r5)
            com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$Entry r6 = r12.pollHighestLast()     // Catch: java.lang.Throwable -> Lc1
            monitor-exit(r5)
            if (r6 != 0) goto L7e
        L7c:
            r13 = r2
            goto L52
        L7e:
            java.lang.String r5 = "ExecutionPriorityQueue"
            java.lang.String r7 = r6.getKey()
            com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$Priority r8 = r6.getPriority()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Executing normally: "
            r9.<init>(r10)
            java.lang.StringBuilder r7 = r9.append(r7)
            java.lang.String r9 = " ["
            java.lang.StringBuilder r7 = r7.append(r9)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = "]"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.box.androidsdk.content.utils.BoxLogUtils.d(r5, r7)
            r0.L$0 = r2
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r0.L$1 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$2 = r13
            r0.label = r3
            java.lang.Object r13 = r12.execute(r6, r0)
            if (r13 != r1) goto L7c
        Lc0:
            return r1
        Lc1:
            r12 = move-exception
            monitor-exit(r5)
            throw r12
        Lc4:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.coreservices.executionqueue.ExecutionPriorityQueue.dispatchLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$executeImmediately$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExecutionPriorityQueue.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.executionqueue.ExecutionPriorityQueue$executeImmediately$1", f = "ExecutionPriorityQueue.kt", i = {}, l = {213}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Entry $entry;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10071(Entry entry, Continuation<? super C10071> continuation) {
            super(2, continuation);
            this.$entry = entry;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExecutionPriorityQueue.this.new C10071(this.$entry, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ExecutionPriorityQueue.this.execute(this.$entry, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void executeImmediately(Entry entry) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C10071(entry, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, kotlinx.coroutines.Job] */
    public final Object execute(Entry entry, Continuation<? super Unit> continuation) {
        C10061 c10061;
        Job job;
        if (continuation instanceof C10061) {
            c10061 = (C10061) continuation;
            if ((c10061.label & Integer.MIN_VALUE) != 0) {
                c10061.label -= Integer.MIN_VALUE;
            } else {
                c10061 = new C10061(continuation);
            }
        } else {
            c10061 = new C10061(continuation);
        }
        Object obj = c10061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10061.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            synchronized (this.lock) {
                RunningEntry runningEntry = this.runningEntries.get(entry.getKey());
                if (runningEntry != null && runningEntry.getEntry() != entry) {
                    return Unit.INSTANCE;
                }
                if (runningEntry != null && (job = runningEntry.getJob()) != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                objectRef.element = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ExecutionPriorityQueue$execute$2$1(entry, null), 3, null);
                this.runningEntries.put(entry.getKey(), new RunningEntry(entry, (Job) objectRef.element));
                Unit unit = Unit.INSTANCE;
                Job job2 = (Job) objectRef.element;
                c10061.L$0 = entry;
                c10061.L$1 = SpillingKt.nullOutSpilledVariable(objectRef);
                c10061.label = 1;
                if (job2.join(c10061) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            entry = (Entry) c10061.L$0;
            ResultKt.throwOnFailure(obj);
        }
        synchronized (this.lock) {
            RunningEntry runningEntry2 = this.runningEntries.get(entry.getKey());
            if ((runningEntry2 != null ? runningEntry2.getEntry() : null) == entry) {
                this.runningEntries.remove(entry.getKey());
                BoxLogUtils.d(TAG, "Completed: " + entry.getKey());
            }
            Unit unit2 = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final RemovedEntry removeExistingLocked(String key) {
        Iterator<LinkedHashMap<String, Entry>> it = this.queues.values().iterator();
        while (it.hasNext()) {
            Entry entryRemove = it.next().remove(key);
            if (entryRemove != null) {
                return new RemovedEntry(entryRemove, null);
            }
        }
        RunningEntry runningEntryRemove = this.runningEntries.remove(key);
        if (runningEntryRemove != null) {
            return new RemovedEntry(runningEntryRemove.getEntry(), runningEntryRemove.getJob());
        }
        return null;
    }

    private final void applyRemoval(RemovedEntry removed) {
        if (removed == null) {
            return;
        }
        removed.getEntry().getOnCancel().invoke();
        if (removed.getJob() != null) {
            Job.DefaultImpls.cancel$default(removed.getJob(), (CancellationException) null, 1, (Object) null);
            BoxLogUtils.d(TAG, "Cancelled running: " + removed.getEntry().getKey());
        } else {
            BoxLogUtils.d(TAG, "Cancelled queued: " + removed.getEntry().getKey());
        }
    }

    private final Entry pollHighestLast() {
        Iterator<Priority> it = this.prioritiesWithQueue.iterator();
        while (it.hasNext()) {
            LinkedHashMap<String, Entry> linkedHashMap = this.queues.get(it.next());
            Intrinsics.checkNotNull(linkedHashMap);
            LinkedHashMap<String, Entry> linkedHashMap2 = linkedHashMap;
            Set<Map.Entry<String, Entry>> setEntrySet = linkedHashMap2.entrySet();
            Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
            Map.Entry entry = (Map.Entry) CollectionsKt.lastOrNull(setEntrySet);
            if (entry != null) {
                linkedHashMap2.remove(entry.getKey());
                Object value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
                Entry entry2 = (Entry) value;
                this.runningEntries.put(entry2.getKey(), new RunningEntry(entry2, JobKt__JobKt.Job$default((Job) null, 1, (Object) null)));
                return entry2;
            }
        }
        return null;
    }
}
