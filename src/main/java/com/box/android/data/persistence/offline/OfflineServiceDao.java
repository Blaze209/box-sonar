package com.box.android.data.persistence.offline;

import com.box.android.domain.models.item.ItemType;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: OfflineServiceDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\u000fH'J \u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\nH§@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0097@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u001a\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ \u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ \u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u0018\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u001e\u0010$\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\b¨\u0006%À\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/offline/OfflineServiceDao;", "", "getState", "Lcom/box/android/data/persistence/offline/OfflineStateEntity;", "itemId", "", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfflinedItemIds", "", "(Lcom/box/android/domain/models/item/ItemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countOfflinedItems", "", "observeOfflinedItems", "Lkotlinx/coroutines/flow/Flow;", "observeState", SemanticAttributes.FaasDocumentOperationValues.INSERT, "", "entity", "(Lcom/box/android/data/persistence/offline/OfflineStateEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "entities", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "upsert", "deleteAllStates", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByItemIdAndType", "getCompletedDate", "", "getStartedDate", "getFileSha1", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "existsAndUserRemoved", "", "existsAndUserSaved", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OfflineServiceDao {

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceDao$upsert$1, reason: invalid class name */
    /* JADX INFO: compiled from: OfflineServiceDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceDao", f = "OfflineServiceDao.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {69, 71, 73}, m = "upsert$suspendImpl", n = {"$this", "entity", "$this", "entity", "existing", "$this", "entity", "existing"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
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
            return OfflineServiceDao.upsert$suspendImpl(OfflineServiceDao.this, null, this);
        }
    }

    Object countOfflinedItems(ItemType itemType, Continuation<? super Integer> continuation);

    Object deleteAllStates(Continuation<? super Unit> continuation);

    Object deleteByItemIdAndType(String str, ItemType itemType, Continuation<? super Unit> continuation);

    Object existsAndUserRemoved(String str, ItemType itemType, Continuation<? super Boolean> continuation);

    Object existsAndUserSaved(String str, ItemType itemType, Continuation<? super Boolean> continuation);

    Object getCompletedDate(String str, ItemType itemType, Continuation<? super Long> continuation);

    Object getFileSha1(String str, Continuation<? super String> continuation);

    Object getOfflinedItemIds(ItemType itemType, Continuation<? super List<String>> continuation);

    Object getStartedDate(String str, ItemType itemType, Continuation<? super Long> continuation);

    Object getState(String str, ItemType itemType, Continuation<? super OfflineStateEntity> continuation);

    Object insert(OfflineStateEntity offlineStateEntity, Continuation<? super Unit> continuation);

    Object insertAll(List<OfflineStateEntity> list, Continuation<? super Unit> continuation);

    Flow<List<OfflineStateEntity>> observeOfflinedItems();

    Flow<OfflineStateEntity> observeState(String itemId, ItemType itemType);

    Object update(OfflineStateEntity offlineStateEntity, Continuation<? super Unit> continuation);

    default Object upsert(OfflineStateEntity offlineStateEntity, Continuation<? super Unit> continuation) {
        return upsert$suspendImpl(this, offlineStateEntity, continuation);
    }

    /* JADX INFO: compiled from: OfflineServiceDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object upsert(OfflineServiceDao offlineServiceDao, OfflineStateEntity offlineStateEntity, Continuation<? super Unit> continuation) {
            return OfflineServiceDao.super.upsert(offlineStateEntity, continuation);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0096, code lost:
    
        if (r6.update(r7, r0) == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b4, code lost:
    
        if (r6.insert(r7, r0) == r1) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object upsert$suspendImpl(com.box.android.data.persistence.offline.OfflineServiceDao r6, com.box.android.data.persistence.offline.OfflineStateEntity r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof com.box.android.data.persistence.offline.OfflineServiceDao.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            com.box.android.data.persistence.offline.OfflineServiceDao$upsert$1 r0 = (com.box.android.data.persistence.offline.OfflineServiceDao.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.box.android.data.persistence.offline.OfflineServiceDao$upsert$1 r0 = new com.box.android.data.persistence.offline.OfflineServiceDao$upsert$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L62
            if (r2 == r5) goto L55
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r6 = r0.L$2
            com.box.android.data.persistence.offline.OfflineStateEntity r6 = (com.box.android.data.persistence.offline.OfflineStateEntity) r6
            java.lang.Object r6 = r0.L$1
            com.box.android.data.persistence.offline.OfflineStateEntity r6 = (com.box.android.data.persistence.offline.OfflineStateEntity) r6
            java.lang.Object r6 = r0.L$0
            com.box.android.data.persistence.offline.OfflineServiceDao r6 = (com.box.android.data.persistence.offline.OfflineServiceDao) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto Lb7
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            java.lang.Object r6 = r0.L$2
            com.box.android.data.persistence.offline.OfflineStateEntity r6 = (com.box.android.data.persistence.offline.OfflineStateEntity) r6
            java.lang.Object r6 = r0.L$1
            com.box.android.data.persistence.offline.OfflineStateEntity r6 = (com.box.android.data.persistence.offline.OfflineStateEntity) r6
            java.lang.Object r6 = r0.L$0
            com.box.android.data.persistence.offline.OfflineServiceDao r6 = (com.box.android.data.persistence.offline.OfflineServiceDao) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L99
        L55:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            com.box.android.data.persistence.offline.OfflineStateEntity r7 = (com.box.android.data.persistence.offline.OfflineStateEntity) r7
            java.lang.Object r6 = r0.L$0
            com.box.android.data.persistence.offline.OfflineServiceDao r6 = (com.box.android.data.persistence.offline.OfflineServiceDao) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7a
        L62:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = r7.getItemId()
            com.box.android.domain.models.item.ItemType r2 = r7.getItemType()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r6.getState(r8, r2, r0)
            if (r8 != r1) goto L7a
            goto Lb6
        L7a:
            com.box.android.data.persistence.offline.OfflineStateEntity r8 = (com.box.android.data.persistence.offline.OfflineStateEntity) r8
            if (r8 == 0) goto L9c
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r2
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$2 = r8
            r0.label = r4
            java.lang.Object r6 = r6.update(r7, r0)
            if (r6 != r1) goto L99
            goto Lb6
        L99:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L9c:
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r2
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r6 = r6.insert(r7, r0)
            if (r6 != r1) goto Lb7
        Lb6:
            return r1
        Lb7:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.persistence.offline.OfflineServiceDao.upsert$suspendImpl(com.box.android.data.persistence.offline.OfflineServiceDao, com.box.android.data.persistence.offline.OfflineStateEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
