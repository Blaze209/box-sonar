package com.box.android.data.persistence.localItems;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: LocalItemsDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ \u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u0011\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0018\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001f2\u0006\u0010\u001d\u001a\u00020\u000bH'J \u0010 \u001a\u0004\u0018\u00010\u001a2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H§@¢\u0006\u0002\u0010$¨\u0006%À\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/localItems/LocalItemsDao;", "", "insertOrUpdateLocalItem", "", "localItemEntity", "Lcom/box/android/data/persistence/localItems/LocalItemEntity;", "(Lcom/box/android/data/persistence/localItems/LocalItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLocalItem", "updateLocalItem", "deleteLocalItem", "itemId", "Lcom/box/android/domain/models/ItemId$Local;", "(Lcom/box/android/domain/models/ItemId$Local;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalItemById", "getLocalItemByName", "name", "", "parentID", "Lcom/box/android/domain/models/ItemId;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalItemsByParentId", "", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOrUpdateLocalIdToServerId", "", "localIdToServerIdRelationEntity", "Lcom/box/android/data/persistence/localItems/LocalIdToServerIdRelationEntity;", "(Lcom/box/android/data/persistence/localItems/LocalIdToServerIdRelationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServerId", "localId", "observeLocalIdToServerIdRelation", "Lkotlinx/coroutines/flow/Flow;", "getLocalIdToServerIdRelation", "serverId", "type", "Lcom/box/android/domain/models/item/ItemType;", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface LocalItemsDao {

    /* JADX INFO: renamed from: com.box.android.data.persistence.localItems.LocalItemsDao$insertOrUpdateLocalItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: LocalItemsDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.localItems.LocalItemsDao", f = "LocalItemsDao.kt", i = {0, 0, 1, 1, 2, 2}, l = {16, 17, 19}, m = "insertOrUpdateLocalItem$suspendImpl", n = {"$this", "localItemEntity", "$this", "localItemEntity", "$this", "localItemEntity"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemsDao.insertOrUpdateLocalItem$suspendImpl(LocalItemsDao.this, null, this);
        }
    }

    Object deleteLocalItem(ItemId.Local local, Continuation<? super Unit> continuation);

    Object getLocalIdToServerIdRelation(String str, ItemType itemType, Continuation<? super LocalIdToServerIdRelationEntity> continuation);

    Object getLocalItemById(ItemId.Local local, Continuation<? super LocalItemEntity> continuation);

    Object getLocalItemByName(String str, ItemId itemId, Continuation<? super LocalItemEntity> continuation);

    Object getLocalItemsByParentId(ItemId itemId, Continuation<? super List<LocalItemEntity>> continuation);

    Object getServerId(ItemId.Local local, Continuation<? super String> continuation);

    Object insertLocalItem(LocalItemEntity localItemEntity, Continuation<? super Unit> continuation);

    Object insertOrUpdateLocalIdToServerId(LocalIdToServerIdRelationEntity localIdToServerIdRelationEntity, Continuation<? super Long> continuation);

    default Object insertOrUpdateLocalItem(LocalItemEntity localItemEntity, Continuation<? super Unit> continuation) {
        return insertOrUpdateLocalItem$suspendImpl(this, localItemEntity, continuation);
    }

    Flow<LocalIdToServerIdRelationEntity> observeLocalIdToServerIdRelation(ItemId.Local localId);

    Object updateLocalItem(LocalItemEntity localItemEntity, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: LocalItemsDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object insertOrUpdateLocalItem(LocalItemsDao localItemsDao, LocalItemEntity localItemEntity, Continuation<? super Unit> continuation) {
            return LocalItemsDao.super.insertOrUpdateLocalItem(localItemEntity, continuation);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
    
        if (r6.updateLocalItem(r7, r0) == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0099, code lost:
    
        if (r6.insertLocalItem(r7, r0) == r1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object insertOrUpdateLocalItem$suspendImpl(com.box.android.data.persistence.localItems.LocalItemsDao r6, com.box.android.data.persistence.localItems.LocalItemEntity r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof com.box.android.data.persistence.localItems.LocalItemsDao.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            com.box.android.data.persistence.localItems.LocalItemsDao$insertOrUpdateLocalItem$1 r0 = (com.box.android.data.persistence.localItems.LocalItemsDao.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.box.android.data.persistence.localItems.LocalItemsDao$insertOrUpdateLocalItem$1 r0 = new com.box.android.data.persistence.localItems.LocalItemsDao$insertOrUpdateLocalItem$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L59
            if (r2 == r5) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.L$1
            com.box.android.data.persistence.localItems.LocalItemEntity r6 = (com.box.android.data.persistence.localItems.LocalItemEntity) r6
            java.lang.Object r6 = r0.L$0
            com.box.android.data.persistence.localItems.LocalItemsDao r6 = (com.box.android.data.persistence.localItems.LocalItemsDao) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L9c
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            java.lang.Object r6 = r0.L$1
            com.box.android.data.persistence.localItems.LocalItemEntity r6 = (com.box.android.data.persistence.localItems.LocalItemEntity) r6
            java.lang.Object r6 = r0.L$0
            com.box.android.data.persistence.localItems.LocalItemsDao r6 = (com.box.android.data.persistence.localItems.LocalItemsDao) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L84
        L4c:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            com.box.android.data.persistence.localItems.LocalItemEntity r7 = (com.box.android.data.persistence.localItems.LocalItemEntity) r7
            java.lang.Object r6 = r0.L$0
            com.box.android.data.persistence.localItems.LocalItemsDao r6 = (com.box.android.data.persistence.localItems.LocalItemsDao) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6d
        L59:
            kotlin.ResultKt.throwOnFailure(r8)
            com.box.android.domain.models.ItemId$Local r8 = r7.getItemId()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r6.getLocalItemById(r8, r0)
            if (r8 != r1) goto L6d
            goto L9b
        L6d:
            if (r8 == 0) goto L87
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r6 = r6.updateLocalItem(r7, r0)
            if (r6 != r1) goto L84
            goto L9b
        L84:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L87:
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r6 = r6.insertLocalItem(r7, r0)
            if (r6 != r1) goto L9c
        L9b:
            return r1
        L9c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.persistence.localItems.LocalItemsDao.insertOrUpdateLocalItem$suspendImpl(com.box.android.data.persistence.localItems.LocalItemsDao, com.box.android.data.persistence.localItems.LocalItemEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
