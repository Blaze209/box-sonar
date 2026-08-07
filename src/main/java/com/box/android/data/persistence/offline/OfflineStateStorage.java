package com.box.android.data.persistence.offline;

import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.offline.IOfflineStateStorage;
import com.box.android.domain.offline.OfflineStateModel;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: OfflineStateStorage.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u001e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ&\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u0013J\u001e\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0#H\u0096@¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0#H\u0096@¢\u0006\u0002\u0010$J\u000e\u0010&\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010$J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/box/android/data/persistence/offline/OfflineStateStorage;", "Lcom/box/android/domain/offline/IOfflineStateStorage;", "dataSource", "Lcom/box/android/data/persistence/offline/OfflineServiceLocalDataSource;", "<init>", "(Lcom/box/android/data/persistence/offline/OfflineServiceLocalDataSource;)V", "isUserSaved", "", "itemId", "", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileSha1", "fileId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFileOfflineUserSaved", "", "userSaved", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFileOfflineSavedCompleted", "sha1", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompletedDate", "", "removeOfflinedItem", "setFolderOfflineSavedStarted", "folderId", "savedForOffline", "startedDate", "(Ljava/lang/String;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFolderOfflineSavedCompleted", "savedOffline", "isUserRemoved", "fetchUserOfflinedFileIds", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchUserOfflinedFolderIds", "clearOfflineInformation", "observeState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/offline/OfflineStateModel;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflineStateStorage implements IOfflineStateStorage {
    private final OfflineServiceLocalDataSource dataSource;

    @Inject
    public OfflineStateStorage(OfflineServiceLocalDataSource dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.dataSource = dataSource;
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Object isUserSaved(String str, ItemType itemType, Continuation<? super Boolean> continuation) {
        return this.dataSource.existsAndUserSaved(str, itemType, continuation);
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Object getFileSha1(String str, Continuation<? super String> continuation) {
        return this.dataSource.getFileSha1(str, continuation);
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Object setFileOfflineUserSaved(String str, boolean z, Continuation<? super Unit> continuation) {
        Object fileOfflineUserSaved = this.dataSource.setFileOfflineUserSaved(str, z, continuation);
        return fileOfflineUserSaved == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fileOfflineUserSaved : Unit.INSTANCE;
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Object setFileOfflineSavedCompleted(String str, String str2, Continuation<? super Unit> continuation) {
        Object fileOfflineSavedCompleted = this.dataSource.setFileOfflineSavedCompleted(str, str2, System.currentTimeMillis(), continuation);
        return fileOfflineSavedCompleted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fileOfflineSavedCompleted : Unit.INSTANCE;
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Object getCompletedDate(String str, ItemType itemType, Continuation<? super Long> continuation) {
        return this.dataSource.getCompletedDate(str, itemType, continuation);
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Object removeOfflinedItem(String str, ItemType itemType, Continuation<? super Unit> continuation) {
        Object objDeleteOfflinedItem = this.dataSource.deleteOfflinedItem(str, itemType, continuation);
        return objDeleteOfflinedItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteOfflinedItem : Unit.INSTANCE;
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Object setFolderOfflineSavedStarted(String str, boolean z, long j, Continuation<? super Unit> continuation) {
        Object folderOfflineSavedStarted = this.dataSource.setFolderOfflineSavedStarted(str, z, j, continuation);
        return folderOfflineSavedStarted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? folderOfflineSavedStarted : Unit.INSTANCE;
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Object setFolderOfflineSavedCompleted(String str, boolean z, Continuation<? super Boolean> continuation) {
        return this.dataSource.setFolderOfflineSavedCompleted(str, z, continuation);
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Object isUserRemoved(String str, ItemType itemType, Continuation<? super Boolean> continuation) {
        return this.dataSource.existsAndUserRemoved(str, itemType, continuation);
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Object fetchUserOfflinedFileIds(Continuation<? super List<String>> continuation) {
        return this.dataSource.getOfflinedFileIds(continuation);
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Object fetchUserOfflinedFolderIds(Continuation<? super List<String>> continuation) {
        return this.dataSource.getOfflinedFolderIds(continuation);
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Object clearOfflineInformation(Continuation<? super Unit> continuation) {
        Object objClearOfflineInformation = this.dataSource.clearOfflineInformation(continuation);
        return objClearOfflineInformation == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objClearOfflineInformation : Unit.INSTANCE;
    }

    @Override // com.box.android.domain.offline.IOfflineStateStorage
    public Flow<OfflineStateModel> observeState(final String itemId, final ItemType itemType) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        final Flow<OfflineStateEntity> flowObserveState = this.dataSource.observeState(itemId, itemType);
        return FlowKt.distinctUntilChanged(new Flow<OfflineStateModel>() { // from class: com.box.android.data.persistence.offline.OfflineStateStorage$observeState$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineStateStorage$observeState$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ String $itemId$inlined;
                final /* synthetic */ ItemType $itemType$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineStateStorage$observeState$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineStateStorage$observeState$$inlined$map$1$2", f = "OfflineStateStorage.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, String str, ItemType itemType) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$itemId$inlined = str;
                    this.$itemType$inlined = itemType;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0018  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    OfflineStateModel offlineStateModel;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        OfflineStateEntity offlineStateEntity = (OfflineStateEntity) obj;
                        if (offlineStateEntity == null || (offlineStateModel = OfflineStateMapper.INSTANCE.toDomainModel(offlineStateEntity)) == null) {
                            offlineStateModel = new OfflineStateModel(this.$itemId$inlined, this.$itemType$inlined, false, false, null, null, null, 120, null);
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(offlineStateModel, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super OfflineStateModel> flowCollector, Continuation continuation) {
                Object objCollect = flowObserveState.collect(new AnonymousClass2(flowCollector, itemId, itemType), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        });
    }
}
