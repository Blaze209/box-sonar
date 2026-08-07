package com.box.android.data.persistence.offline;

import com.box.android.data.datasource.CacheError;
import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.user.UserData;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.facebook.imageutils.JfifUtil;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ,\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001fJ&\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010$J\u001e\u0010%\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u001aJ\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0(H\u0086@¢\u0006\u0002\u0010)J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0(H\u0086@¢\u0006\u0002\u0010)J\u000e\u0010+\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010)J\u001e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0-2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010.\u001a\u00020\u00182\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0(H\u0086@¢\u0006\u0002\u00100J\u000e\u00101\u001a\u000202H\u0086@¢\u0006\u0002\u0010)J\u000e\u00103\u001a\u000202H\u0086@¢\u0006\u0002\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/box/android/data/persistence/offline/OfflineServiceLocalDataSource;", "", "userData", "Lcom/box/android/data/user/UserData;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/user/UserData;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getState", "Lcom/box/android/data/persistence/offline/OfflineStateEntity;", "itemId", "", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "existsAndUserRemoved", "", "existsAndUserSaved", "getCompletedDate", "", "getFileSha1", "fileId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFileOfflineUserSaved", "", "userSaved", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOfflinedItem", "setFileOfflineSavedCompleted", "sha1", "completedDate", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFolderOfflineSavedStarted", "folderId", "savedForOffline", "startedDate", "(Ljava/lang/String;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFolderOfflineSavedCompleted", "savedOffline", "getOfflinedFileIds", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfflinedFolderIds", "clearOfflineInformation", "observeState", "Lkotlinx/coroutines/flow/Flow;", "bulkInsert", "entities", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countOfflinedFiles", "", "countOfflinedFolders", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflineServiceLocalDataSource {
    private final CoroutineDispatcher ioDispatcher;
    private final UserData userData;

    @Inject
    public OfflineServiceLocalDataSource(UserData userData, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.userData = userData;
        this.ioDispatcher = ioDispatcher;
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$getState$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/box/android/data/persistence/offline/OfflineStateEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$getState$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0}, l = {32}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class C13882 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OfflineStateEntity>, Object> {
        final /* synthetic */ String $itemId;
        final /* synthetic */ ItemType $itemType;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13882(String str, ItemType itemType, Continuation<? super C13882> continuation) {
            super(2, continuation);
            this.$itemId = str;
            this.$itemType = itemType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13882 c13882 = OfflineServiceLocalDataSource.this.new C13882(this.$itemId, this.$itemType, continuation);
            c13882.L$0 = obj;
            return c13882;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OfflineStateEntity> continuation) {
            return ((C13882) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = OfflineServiceLocalDataSource.this.userData.getBoxDatabase();
                if (!(boxDatabase instanceof Result.Success)) {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error getting offline state for " + this.$itemId + ": " + ((Result.Error) boxDatabase).getValue());
                    return null;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                this.label = 1;
                obj = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao().getState(this.$itemId, this.$itemType, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (OfflineStateEntity) obj;
        }
    }

    public final Object getState(String str, ItemType itemType, Continuation<? super OfflineStateEntity> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C13882(str, itemType, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$existsAndUserRemoved$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$existsAndUserRemoved$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0}, l = {43}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class C13822 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $itemId;
        final /* synthetic */ ItemType $itemType;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13822(String str, ItemType itemType, Continuation<? super C13822> continuation) {
            super(2, continuation);
            this.$itemId = str;
            this.$itemType = itemType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13822 c13822 = OfflineServiceLocalDataSource.this.new C13822(this.$itemId, this.$itemType, continuation);
            c13822.L$0 = obj;
            return c13822;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C13822) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean zBooleanValue;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = OfflineServiceLocalDataSource.this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    this.label = 1;
                    obj = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao().existsAndUserRemoved(this.$itemId, this.$itemType, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error checking if item exists and is user removed: " + ((Result.Error) boxDatabase).getValue());
                    zBooleanValue = false;
                }
                return Boxing.boxBoolean(zBooleanValue);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            zBooleanValue = ((Boolean) obj).booleanValue();
            return Boxing.boxBoolean(zBooleanValue);
        }
    }

    public final Object existsAndUserRemoved(String str, ItemType itemType, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C13822(str, itemType, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$existsAndUserSaved$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$existsAndUserSaved$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0}, l = {54}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class C13832 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $itemId;
        final /* synthetic */ ItemType $itemType;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13832(String str, ItemType itemType, Continuation<? super C13832> continuation) {
            super(2, continuation);
            this.$itemId = str;
            this.$itemType = itemType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13832 c13832 = OfflineServiceLocalDataSource.this.new C13832(this.$itemId, this.$itemType, continuation);
            c13832.L$0 = obj;
            return c13832;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C13832) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean zBooleanValue;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = OfflineServiceLocalDataSource.this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    this.label = 1;
                    obj = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao().existsAndUserSaved(this.$itemId, this.$itemType, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error checking if item is specifically user saved: " + ((Result.Error) boxDatabase).getValue());
                    zBooleanValue = false;
                }
                return Boxing.boxBoolean(zBooleanValue);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            zBooleanValue = ((Boolean) obj).booleanValue();
            return Boxing.boxBoolean(zBooleanValue);
        }
    }

    public final Object existsAndUserSaved(String str, ItemType itemType, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C13832(str, itemType, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$getCompletedDate$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$getCompletedDate$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0}, l = {65}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class C13842 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        final /* synthetic */ String $itemId;
        final /* synthetic */ ItemType $itemType;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13842(String str, ItemType itemType, Continuation<? super C13842> continuation) {
            super(2, continuation);
            this.$itemId = str;
            this.$itemType = itemType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13842 c13842 = OfflineServiceLocalDataSource.this.new C13842(this.$itemId, this.$itemType, continuation);
            c13842.L$0 = obj;
            return c13842;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((C13842) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            long jLongValue = -1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = OfflineServiceLocalDataSource.this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    this.label = 1;
                    obj = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao().getCompletedDate(this.$itemId, this.$itemType, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error getting file completed date: " + ((Result.Error) boxDatabase).getValue());
                }
                return Boxing.boxLong(jLongValue);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Long l = (Long) obj;
            if (l != null) {
                jLongValue = l.longValue();
            }
            return Boxing.boxLong(jLongValue);
        }
    }

    public final Object getCompletedDate(String str, ItemType itemType, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C13842(str, itemType, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$getFileSha1$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$getFileSha1$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0}, l = {76}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class C13852 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $fileId;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13852(String str, Continuation<? super C13852> continuation) {
            super(2, continuation);
            this.$fileId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13852 c13852 = OfflineServiceLocalDataSource.this.new C13852(this.$fileId, continuation);
            c13852.L$0 = obj;
            return c13852;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C13852) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = OfflineServiceLocalDataSource.this.userData.getBoxDatabase();
                if (!(boxDatabase instanceof Result.Success)) {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error getting file SHA1: " + ((Result.Error) boxDatabase).getValue());
                    return null;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                this.label = 1;
                obj = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao().getFileSha1(this.$fileId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (String) obj;
        }
    }

    public final Object getFileSha1(String str, Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C13852(str, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$setFileOfflineUserSaved$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$setFileOfflineUserSaved$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2}, l = {90, 99, 102}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao", "$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao", "$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao", "existing", "entity"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class C13902 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileId;
        final /* synthetic */ boolean $userSaved;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13902(boolean z, String str, Continuation<? super C13902> continuation) {
            super(2, continuation);
            this.$userSaved = z;
            this.$fileId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13902 c13902 = OfflineServiceLocalDataSource.this.new C13902(this.$userSaved, this.$fileId, continuation);
            c13902.L$0 = obj;
            return c13902;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C13902) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:26:0x00d1  */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0095, code lost:
        
            if (r7.upsert(new com.box.android.data.persistence.offline.OfflineStateEntity(r19.$fileId, com.box.android.domain.models.item.ItemType.FILE, true, false, null, null, null, 112, null), r19) == r2) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0108, code lost:
        
            if (r3.upsert(r7, r19) == r2) goto L29;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 308
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource.C13902.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object setFileOfflineUserSaved(String str, boolean z, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C13902(z, str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$deleteOfflinedItem$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$deleteOfflinedItem$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0, 0}, l = {116}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C13812 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $itemId;
        final /* synthetic */ ItemType $itemType;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13812(String str, ItemType itemType, Continuation<? super C13812> continuation) {
            super(2, continuation);
            this.$itemId = str;
            this.$itemType = itemType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13812 c13812 = OfflineServiceLocalDataSource.this.new C13812(this.$itemId, this.$itemType, continuation);
            c13812.L$0 = obj;
            return c13812;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C13812) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = OfflineServiceLocalDataSource.this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    OfflineServiceDao offlineServiceDao = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(offlineServiceDao);
                    this.label = 1;
                    if (offlineServiceDao.deleteByItemIdAndType(this.$itemId, this.$itemType, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error deleting offlined item: " + ((Result.Error) boxDatabase).getValue());
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

    public final Object deleteOfflinedItem(String str, ItemType itemType, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C13812(str, itemType, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$setFileOfflineSavedCompleted$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$setFileOfflineSavedCompleted$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {130, Token.TARGET, 134}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao", "$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao", "existing", "$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao", "existing"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C13892 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $completedDate;
        final /* synthetic */ String $fileId;
        final /* synthetic */ String $sha1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13892(String str, long j, String str2, Continuation<? super C13892> continuation) {
            super(2, continuation);
            this.$fileId = str;
            this.$completedDate = j;
            this.$sha1 = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13892 c13892 = OfflineServiceLocalDataSource.this.new C13892(this.$fileId, this.$completedDate, this.$sha1, continuation);
            c13892.L$0 = obj;
            return c13892;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C13892) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0087  */
        /* JADX WARN: Code duplicated, block: B:22:0x0091  */
        /* JADX WARN: Code duplicated, block: B:26:0x00c7  */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00c4, code lost:
        
            if (r3.update(com.box.android.data.persistence.offline.OfflineStateEntity.copy$default(r8, null, null, false, false, null, r14, r4, 31, null), r20) == r2) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0102, code lost:
        
            if (r3.insert(new com.box.android.data.persistence.offline.OfflineStateEntity(r20.$fileId, com.box.android.domain.models.item.ItemType.FILE, true, false, null, kotlin.coroutines.jvm.internal.Boxing.boxLong(r20.$completedDate), r20.$sha1, 24, null), r20) == r2) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 302
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource.C13892.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static /* synthetic */ Object setFileOfflineSavedCompleted$default(OfflineServiceLocalDataSource offlineServiceLocalDataSource, String str, String str2, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            j = System.currentTimeMillis();
        }
        return offlineServiceLocalDataSource.setFileOfflineSavedCompleted(str, str3, j, continuation);
    }

    public final Object setFileOfflineSavedCompleted(String str, String str2, long j, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C13892(str, j, str2, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$setFolderOfflineSavedStarted$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$setFolderOfflineSavedStarted$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {Token.DEBUGGER, 171, 173}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao", "$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao", "$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao", "existing"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C13922 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $folderId;
        final /* synthetic */ boolean $savedForOffline;
        final /* synthetic */ long $startedDate;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13922(boolean z, String str, long j, Continuation<? super C13922> continuation) {
            super(2, continuation);
            this.$savedForOffline = z;
            this.$folderId = str;
            this.$startedDate = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13922 c13922 = OfflineServiceLocalDataSource.this.new C13922(this.$savedForOffline, this.$folderId, this.$startedDate, continuation);
            c13922.L$0 = obj;
            return c13922;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C13922) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00be  */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0096, code lost:
        
            if (r7.upsert(new com.box.android.data.persistence.offline.OfflineStateEntity(r19.$folderId, com.box.android.domain.models.item.ItemType.FOLDER, true, false, kotlin.coroutines.jvm.internal.Boxing.boxLong(r19.$startedDate), null, null, 96, null), r19) == r2) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00ee, code lost:
        
            if (r3.update(com.box.android.data.persistence.offline.OfflineStateEntity.copy$default(r7, null, null, false, false, null, null, null, 67, null), r19) == r2) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 282
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource.C13922.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object setFolderOfflineSavedStarted(String str, boolean z, long j, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C13922(z, str, j, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$setFolderOfflineSavedCompleted$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$setFolderOfflineSavedCompleted$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2}, l = {195, 202, 206}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao", "$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao", "existing", "startedDate", "$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "dao", "existing"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C13912 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $itemId;
        final /* synthetic */ boolean $savedOffline;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13912(String str, boolean z, Continuation<? super C13912> continuation) {
            super(2, continuation);
            this.$itemId = str;
            this.$savedOffline = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13912 c13912 = OfflineServiceLocalDataSource.this.new C13912(this.$itemId, this.$savedOffline, continuation);
            c13912.L$0 = obj;
            return c13912;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C13912) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00d5, code lost:
        
            if (r3.update(com.box.android.data.persistence.offline.OfflineStateEntity.copy$default(r10, null, null, false, false, null, r16, null, 95, null), r20) == r2) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0113, code lost:
        
            if (r3.update(com.box.android.data.persistence.offline.OfflineStateEntity.copy$default(r10, null, null, false, false, null, null, null, 95, null), r20) == r2) goto L37;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 321
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource.C13912.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object setFolderOfflineSavedCompleted(String str, boolean z, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C13912(str, z, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$getOfflinedFileIds$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$getOfflinedFileIds$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0}, l = {JfifUtil.MARKER_APP1}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class C13862 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C13862(Continuation<? super C13862> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13862 c13862 = OfflineServiceLocalDataSource.this.new C13862(continuation);
            c13862.L$0 = obj;
            return c13862;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends String>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<String>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<String>> continuation) {
            return ((C13862) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = OfflineServiceLocalDataSource.this.userData.getBoxDatabase();
                if (!(boxDatabase instanceof Result.Success)) {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error getting offlined file IDs: " + ((Result.Error) boxDatabase).getValue());
                    return CollectionsKt.emptyList();
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                this.label = 1;
                obj = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao().getOfflinedItemIds(ItemType.FILE, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (List) obj;
        }
    }

    public final Object getOfflinedFileIds(Continuation<? super List<String>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C13862(null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$getOfflinedFolderIds$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$getOfflinedFolderIds$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0}, l = {236}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class C13872 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C13872(Continuation<? super C13872> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13872 c13872 = OfflineServiceLocalDataSource.this.new C13872(continuation);
            c13872.L$0 = obj;
            return c13872;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends String>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<String>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<String>> continuation) {
            return ((C13872) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = OfflineServiceLocalDataSource.this.userData.getBoxDatabase();
                if (!(boxDatabase instanceof Result.Success)) {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error getting offlined folder IDs: " + ((Result.Error) boxDatabase).getValue());
                    return CollectionsKt.emptyList();
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                this.label = 1;
                obj = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao().getOfflinedItemIds(ItemType.FOLDER, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (List) obj;
        }
    }

    public final Object getOfflinedFolderIds(Continuation<? super List<String>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C13872(null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$clearOfflineInformation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$clearOfflineInformation$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0}, l = {247}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class C13782 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C13782(Continuation<? super C13782> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13782 c13782 = OfflineServiceLocalDataSource.this.new C13782(continuation);
            c13782.L$0 = obj;
            return c13782;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C13782) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = OfflineServiceLocalDataSource.this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    this.label = 1;
                    if (((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao().deleteAllStates(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error clearing offline information: " + ((Result.Error) boxDatabase).getValue());
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

    public final Object clearOfflineInformation(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C13782(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final Flow<OfflineStateEntity> observeState(String itemId, ItemType itemType) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
        if (boxDatabase instanceof Result.Success) {
            return ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao().observeState(itemId, itemType);
        }
        if (!(boxDatabase instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error observing state for " + itemId + ": " + ((Result.Error) boxDatabase).getValue());
        return FlowKt.flowOf((Object) null);
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$bulkInsert$2, reason: invalid class name */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$bulkInsert$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0}, l = {270}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<OfflineStateEntity> $entities;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<OfflineStateEntity> list, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$entities = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = OfflineServiceLocalDataSource.this.new AnonymousClass2(this.$entities, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = OfflineServiceLocalDataSource.this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    this.label = 1;
                    if (((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao().insertAll(this.$entities, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error bulk inserting offline states: " + ((Result.Error) boxDatabase).getValue());
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

    public final Object bulkInsert(List<OfflineStateEntity> list, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new AnonymousClass2(list, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$countOfflinedFiles$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$countOfflinedFiles$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0}, l = {280}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class C13792 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C13792(Continuation<? super C13792> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13792 c13792 = OfflineServiceLocalDataSource.this.new C13792(continuation);
            c13792.L$0 = obj;
            return c13792;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C13792) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int iIntValue;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = OfflineServiceLocalDataSource.this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    this.label = 1;
                    obj = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao().countOfflinedItems(ItemType.FILE, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error counting offlined files: " + ((Result.Error) boxDatabase).getValue());
                    iIntValue = 0;
                }
                return Boxing.boxInt(iIntValue);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            iIntValue = ((Number) obj).intValue();
            return Boxing.boxInt(iIntValue);
        }
    }

    public final Object countOfflinedFiles(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C13792(null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$countOfflinedFolders$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceLocalDataSource$countOfflinedFolders$2", f = "OfflineServiceLocalDataSource.kt", i = {0, 0}, l = {291}, m = "invokeSuspend", n = {"$this$withContext", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class C13802 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C13802(Continuation<? super C13802> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13802 c13802 = OfflineServiceLocalDataSource.this.new C13802(continuation);
            c13802.L$0 = obj;
            return c13802;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C13802) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int iIntValue;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = OfflineServiceLocalDataSource.this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    this.label = 1;
                    obj = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).offlineServiceDao().countOfflinedItems(ItemType.FOLDER, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error counting offlined folders: " + ((Result.Error) boxDatabase).getValue());
                    iIntValue = 0;
                }
                return Boxing.boxInt(iIntValue);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            iIntValue = ((Number) obj).intValue();
            return Boxing.boxInt(iIntValue);
        }
    }

    public final Object countOfflinedFolders(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C13802(null), continuation);
    }
}
