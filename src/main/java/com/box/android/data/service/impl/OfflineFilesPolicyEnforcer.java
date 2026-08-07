package com.box.android.data.service.impl;

import com.box.android.domain.services.IOfflineFilesPolicyEnforcer;
import com.box.android.domain.services.IOfflineService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OfflineFilesPolicyEnforcer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/service/impl/OfflineFilesPolicyEnforcer;", "Lcom/box/android/domain/services/IOfflineFilesPolicyEnforcer;", "offlineService", "Lcom/box/android/domain/services/IOfflineService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/services/IOfflineService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "enforce", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflineFilesPolicyEnforcer implements IOfflineFilesPolicyEnforcer {
    private final CoroutineDispatcher ioDispatcher;
    private final IOfflineService offlineService;

    @Inject
    public OfflineFilesPolicyEnforcer(IOfflineService offlineService, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.offlineService = offlineService;
        this.ioDispatcher = ioDispatcher;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineFilesPolicyEnforcer$enforce$2, reason: invalid class name */
    /* JADX INFO: compiled from: OfflineFilesPolicyEnforcer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OfflineFilesPolicyEnforcer$enforce$2", f = "OfflineFilesPolicyEnforcer.kt", i = {0, 1, 1, 1, 1, 1}, l = {30, 65}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "offlineItemsResult", "offlineItems", "offlineFiles", "itemsToRemove"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = OfflineFilesPolicyEnforcer.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x014b, code lost:
        
            if (r13 == r1) goto L45;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 387
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.OfflineFilesPolicyEnforcer.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IOfflineFilesPolicyEnforcer
    public Object enforce(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
