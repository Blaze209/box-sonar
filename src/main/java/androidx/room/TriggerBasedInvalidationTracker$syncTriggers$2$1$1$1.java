package androidx.room;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: InvalidationTracker.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/room/TransactionScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1", f = "InvalidationTracker.kt", i = {0, 0, 1, 1}, l = {TypedValues.AttributesType.TYPE_PIVOT_TARGET, 319}, m = "invokeSuspend", n = {"$this$forEachIndexed$iv", "index$iv", "$this$forEachIndexed$iv", "index$iv"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1 extends SuspendLambda implements Function2<TransactionScope<Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Transactor $connection;
    final /* synthetic */ ObservedTableStates.ObserveOp[] $tablesToSync;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX INFO: compiled from: InvalidationTracker.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ObservedTableStates.ObserveOp.values().length];
            try {
                iArr[ObservedTableStates.ObserveOp.NO_OP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ObservedTableStates.ObserveOp.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ObservedTableStates.ObserveOp.REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1(ObservedTableStates.ObserveOp[] observeOpArr, TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Transactor transactor, Continuation<? super TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1> continuation) {
        super(2, continuation);
        this.$tablesToSync = observeOpArr;
        this.this$0 = triggerBasedInvalidationTracker;
        this.$connection = transactor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1(this.$tablesToSync, this.this$0, this.$connection, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(TransactionScope<Unit> transactionScope, Continuation<? super Unit> continuation) {
        return ((TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1) create(transactionScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003f  */
    /* JADX WARN: Code duplicated, block: B:27:0x008d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008d -> B:28:0x008e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2d
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L17:
            int r1 = r11.I$2
            int r4 = r11.I$1
            int r5 = r11.I$0
            java.lang.Object r6 = r11.L$2
            androidx.room.Transactor r6 = (androidx.room.Transactor) r6
            java.lang.Object r7 = r11.L$1
            androidx.room.TriggerBasedInvalidationTracker r7 = (androidx.room.TriggerBasedInvalidationTracker) r7
            java.lang.Object r8 = r11.L$0
            androidx.room.ObservedTableStates$ObserveOp[] r8 = (androidx.room.ObservedTableStates.ObserveOp[]) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto L8a
        L2d:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.room.ObservedTableStates$ObserveOp[] r12 = r11.$tablesToSync
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.this$0
            androidx.room.Transactor r4 = r11.$connection
            int r5 = r12.length
            r6 = 0
            r8 = r12
            r7 = r1
            r12 = r4
            r1 = r5
            r4 = r6
        L3d:
            if (r4 >= r1) goto L90
            r5 = r8[r4]
            int r9 = r6 + 1
            int[] r10 = androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r10[r5]
            if (r5 == r3) goto L8d
            if (r5 == r2) goto L70
            r10 = 3
            if (r5 != r10) goto L6a
            r5 = r12
            androidx.room.PooledConnection r5 = (androidx.room.PooledConnection) r5
            r11.L$0 = r8
            r11.L$1 = r7
            r11.L$2 = r12
            r11.I$0 = r9
            r11.I$1 = r4
            r11.I$2 = r1
            r11.label = r2
            java.lang.Object r5 = androidx.room.TriggerBasedInvalidationTracker.access$stopTrackingTable(r7, r5, r6, r11)
            if (r5 != r0) goto L88
            goto L87
        L6a:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L70:
            r5 = r12
            androidx.room.PooledConnection r5 = (androidx.room.PooledConnection) r5
            r11.L$0 = r8
            r11.L$1 = r7
            r11.L$2 = r12
            r11.I$0 = r9
            r11.I$1 = r4
            r11.I$2 = r1
            r11.label = r3
            java.lang.Object r5 = androidx.room.TriggerBasedInvalidationTracker.access$startTrackingTable(r7, r5, r6, r11)
            if (r5 != r0) goto L88
        L87:
            return r0
        L88:
            r6 = r12
            r5 = r9
        L8a:
            r12 = r6
            r6 = r5
            goto L8e
        L8d:
            r6 = r9
        L8e:
            int r4 = r4 + r3
            goto L3d
        L90:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
