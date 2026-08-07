package com.box.android.data.datasource.localItems;

import androidx.room.RoomDatabaseKt;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.localItems.LocalIdToServerIdRelationEntity;
import com.box.android.data.persistence.localItems.LocalItemEntity;
import com.box.android.data.persistence.localItems.LocalItemsDao;
import com.box.android.data.user.UserData;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: LocalItemsDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001*B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\"\u0010 \u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0!\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\"\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0#\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010$J*\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H\u0086@¢\u0006\u0002\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/box/android/data/datasource/localItems/LocalItemsDataSource;", "", "userData", "Lcom/box/android/data/user/UserData;", "<init>", "(Lcom/box/android/data/user/UserData;)V", "insertOrUpdateLocalItem", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/CacheError$SaveError;", "localItemEntity", "Lcom/box/android/data/persistence/localItems/LocalItemEntity;", "(Lcom/box/android/data/persistence/localItems/LocalItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLocalItem", "Lcom/box/android/data/datasource/CacheError$DeleteError;", "itemId", "Lcom/box/android/domain/models/ItemId$Local;", "(Lcom/box/android/domain/models/ItemId$Local;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalItemById", "Lcom/box/android/data/datasource/CacheError;", "localItemId", "getLocalItemByName", "name", "", IdentificationData.FIELD_PARENT_ID, "Lcom/box/android/domain/models/ItemId;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOrUpdateLocalIdToServerIdRelation", "localIdToServerIdRelationEntity", "Lcom/box/android/data/persistence/localItems/LocalIdToServerIdRelationEntity;", "(Lcom/box/android/data/persistence/localItems/LocalIdToServerIdRelationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServerId", "observeLocalIdToServerIdRelation", "Lkotlinx/coroutines/flow/Flow;", "getLocalItemsByParentId", "", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalIdToServerIdRelation", "serverId", "type", "Lcom/box/android/domain/models/item/ItemType;", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NoResultFoundException", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocalItemsDataSource {
    private UserData userData;

    /* JADX INFO: renamed from: com.box.android.data.datasource.localItems.LocalItemsDataSource$deleteLocalItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: LocalItemsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.localItems.LocalItemsDataSource", f = "LocalItemsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {49}, m = "deleteLocalItem", n = {"itemId", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-LocalItemsDataSource$deleteLocalItem$2", "$i$f$resultOf", "$i$a$-resultOf-LocalItemsDataSource$deleteLocalItem$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
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
            return LocalItemsDataSource.this.deleteLocalItem(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.localItems.LocalItemsDataSource$getLocalIdToServerIdRelation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.localItems.LocalItemsDataSource", f = "LocalItemsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {220}, m = "getLocalIdToServerIdRelation", n = {"serverId", "type", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-LocalItemsDataSource$getLocalIdToServerIdRelation$2", "$i$f$resultOf", "$i$a$-resultOf-LocalItemsDataSource$getLocalIdToServerIdRelation$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11991 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C11991(Continuation<? super C11991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemsDataSource.this.getLocalIdToServerIdRelation(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.localItems.LocalItemsDataSource$getLocalItemById$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.localItems.LocalItemsDataSource", f = "LocalItemsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {67}, m = "getLocalItemById", n = {"localItemId", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-LocalItemsDataSource$getLocalItemById$2", "$i$f$resultOf", "$i$a$-resultOf-LocalItemsDataSource$getLocalItemById$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C12001 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12001(Continuation<? super C12001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemsDataSource.this.getLocalItemById(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.localItems.LocalItemsDataSource$getLocalItemByName$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.localItems.LocalItemsDataSource", f = "LocalItemsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {98}, m = "getLocalItemByName", n = {"name", IdentificationData.FIELD_PARENT_ID, "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-LocalItemsDataSource$getLocalItemByName$2", "$i$f$resultOf", "$i$a$-resultOf-LocalItemsDataSource$getLocalItemByName$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C12011 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C12011(Continuation<? super C12011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemsDataSource.this.getLocalItemByName(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.localItems.LocalItemsDataSource$getLocalItemsByParentId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.localItems.LocalItemsDataSource", f = "LocalItemsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {206}, m = "getLocalItemsByParentId", n = {IdentificationData.FIELD_PARENT_ID, "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-LocalItemsDataSource$getLocalItemsByParentId$2", "$i$f$resultOf", "$i$a$-resultOf-LocalItemsDataSource$getLocalItemsByParentId$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C12021 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12021(Continuation<? super C12021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemsDataSource.this.getLocalItemsByParentId(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.localItems.LocalItemsDataSource$getServerId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.localItems.LocalItemsDataSource", f = "LocalItemsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {Token.SETCONSTVAR}, m = "getServerId", n = {"itemId", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-LocalItemsDataSource$getServerId$2", "$i$f$resultOf", "$i$a$-resultOf-LocalItemsDataSource$getServerId$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C12031 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12031(Continuation<? super C12031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemsDataSource.this.getServerId(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.localItems.LocalItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.localItems.LocalItemsDataSource", f = "LocalItemsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {Token.TARGET}, m = "insertOrUpdateLocalIdToServerIdRelation", n = {"localIdToServerIdRelationEntity", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-LocalItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$2", "$i$f$resultOf", "$i$a$-resultOf-LocalItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C12041 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12041(Continuation<? super C12041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemsDataSource.this.insertOrUpdateLocalIdToServerIdRelation(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.localItems.LocalItemsDataSource$insertOrUpdateLocalItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.localItems.LocalItemsDataSource", f = "LocalItemsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {31}, m = "insertOrUpdateLocalItem", n = {"localItemEntity", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-LocalItemsDataSource$insertOrUpdateLocalItem$2", "$i$f$resultOf", "$i$a$-resultOf-LocalItemsDataSource$insertOrUpdateLocalItem$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C12051 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12051(Continuation<? super C12051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemsDataSource.this.insertOrUpdateLocalItem(null, this);
        }
    }

    @Inject
    public LocalItemsDataSource(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        this.userData = userData;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object insertOrUpdateLocalItem(LocalItemEntity localItemEntity, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
        C12051 c12051;
        Result.Error error;
        if (continuation instanceof C12051) {
            c12051 = (C12051) continuation;
            if ((c12051.label & Integer.MIN_VALUE) != 0) {
                c12051.label -= Integer.MIN_VALUE;
            } else {
                c12051 = new C12051(continuation);
            }
        } else {
            c12051 = new C12051(continuation);
        }
        Object obj = c12051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12051.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    LocalItemsDataSource$insertOrUpdateLocalItem$2$1$1 localItemsDataSource$insertOrUpdateLocalItem$2$1$1 = new LocalItemsDataSource$insertOrUpdateLocalItem$2$1$1(boxDatabase, localItemEntity, null);
                    c12051.L$0 = SpillingKt.nullOutSpilledVariable(localItemEntity);
                    c12051.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c12051.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c12051.I$0 = 0;
                    c12051.I$1 = 0;
                    c12051.I$2 = 0;
                    c12051.I$3 = 0;
                    c12051.label = 1;
                    if (RoomDatabaseKt.withTransaction(boxDatabase, localItemsDataSource$insertOrUpdateLocalItem$2$1$1, c12051) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while inserting/updating local Item: " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.SaveError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c12051.I$3;
            int i3 = c12051.I$2;
            int i4 = c12051.I$1;
            int i5 = c12051.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while inserting/updating local Item: " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteLocalItem(ItemId.Local local, Continuation<? super Result<Unit, CacheError.DeleteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    LocalItemsDataSource$deleteLocalItem$2$1$1 localItemsDataSource$deleteLocalItem$2$1$1 = new LocalItemsDataSource$deleteLocalItem$2$1$1(boxDatabase, local, null);
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(local);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.I$3 = 0;
                    anonymousClass1.label = 1;
                    if (RoomDatabaseKt.withTransaction(boxDatabase, localItemsDataSource$deleteLocalItem$2$1$1, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while deleting local Item: " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.DeleteError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$3;
            int i3 = anonymousClass1.I$2;
            int i4 = anonymousClass1.I$1;
            int i5 = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while deleting local Item: " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.DeleteError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:40:0x00de  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object getLocalItemById(ItemId.Local local, Continuation<? super Result<LocalItemEntity, ? extends CacheError>> continuation) {
        C12001 c12001;
        Result.Error error;
        Object value;
        CacheError.ReadError readError;
        if (continuation instanceof C12001) {
            c12001 = (C12001) continuation;
            if ((c12001.label & Integer.MIN_VALUE) != 0) {
                c12001.label -= Integer.MIN_VALUE;
            } else {
                c12001 = new C12001(continuation);
            }
        } else {
            c12001 = new C12001(continuation);
        }
        Object localItemById = c12001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12001.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(localItemById);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    LocalItemsDao localItemsDao = boxDatabase.localItemsDao();
                    c12001.L$0 = local;
                    c12001.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c12001.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c12001.I$0 = 0;
                    c12001.I$1 = 0;
                    c12001.I$2 = 0;
                    c12001.I$3 = 0;
                    c12001.label = 1;
                    localItemById = localItemsDao.getLocalItemById(local, c12001);
                    if (localItemById == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    value = ((Result.Error) error).getValue();
                    if (value instanceof NoResultFoundException) {
                        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting LocalItem: " + value);
                        readError = CacheError.NoResultFound.INSTANCE;
                    } else {
                        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting LocalItem: " + value);
                        readError = CacheError.ReadError.INSTANCE;
                    }
                    return new Result.Error(readError);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c12001.I$3;
            int i3 = c12001.I$2;
            int i4 = c12001.I$1;
            int i5 = c12001.I$0;
            local = (ItemId.Local) c12001.L$0;
            ResultKt.throwOnFailure(localItemById);
            LocalItemEntity localItemEntity = (LocalItemEntity) localItemById;
            if (localItemEntity == null) {
                throw new NoResultFoundException("LocalItemEntity not found for id " + local);
            }
            error = new Result.Success(localItemEntity);
            if (error instanceof Result.Success) {
                return error;
            }
            if (error instanceof Result.Error) {
                value = ((Result.Error) error).getValue();
                if (value instanceof NoResultFoundException) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting LocalItem: " + value);
                    readError = CacheError.NoResultFound.INSTANCE;
                } else {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting LocalItem: " + value);
                    readError = CacheError.ReadError.INSTANCE;
                }
                return new Result.Error(readError);
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            error = new Result.Error(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:43:0x010a  */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object getLocalItemByName(String str, ItemId itemId, Continuation<? super Result<LocalItemEntity, ? extends CacheError>> continuation) {
        C12011 c12011;
        Result<BoxDatabase, CacheError> error;
        Object value;
        CacheError.ReadError readError;
        if (continuation instanceof C12011) {
            c12011 = (C12011) continuation;
            if ((c12011.label & Integer.MIN_VALUE) != 0) {
                c12011.label -= Integer.MIN_VALUE;
            } else {
                c12011 = new C12011(continuation);
            }
        } else {
            c12011 = new C12011(continuation);
        }
        Object localItemByName = c12011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12011.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(localItemByName);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    LocalItemsDao localItemsDao = boxDatabase.localItemsDao();
                    c12011.L$0 = str;
                    c12011.L$1 = SpillingKt.nullOutSpilledVariable(itemId);
                    c12011.L$2 = SpillingKt.nullOutSpilledVariable(error);
                    c12011.L$3 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c12011.I$0 = 0;
                    c12011.I$1 = 0;
                    c12011.I$2 = 0;
                    c12011.I$3 = 0;
                    c12011.label = 1;
                    localItemByName = localItemsDao.getLocalItemByName(str, itemId, c12011);
                    if (localItemByName == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    value = ((Result.Error) error).getValue();
                    if (value instanceof NoResultFoundException) {
                        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting LocalItem: " + value);
                        readError = CacheError.NoResultFound.INSTANCE;
                    } else {
                        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting LocalItem: " + value);
                        readError = CacheError.ReadError.INSTANCE;
                    }
                    return new Result.Error(readError);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c12011.I$3;
            int i3 = c12011.I$2;
            int i4 = c12011.I$1;
            int i5 = c12011.I$0;
            str = (String) c12011.L$0;
            ResultKt.throwOnFailure(localItemByName);
            LocalItemEntity localItemEntity = (LocalItemEntity) localItemByName;
            if (localItemEntity == null) {
                throw new NoResultFoundException("LocalItemEntity not found for name " + str);
            }
            error = new Result.Success(localItemEntity);
            if (error instanceof Result.Success) {
                return error;
            }
            if (error instanceof Result.Error) {
                value = ((Result.Error) error).getValue();
                if (value instanceof NoResultFoundException) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting LocalItem: " + value);
                    readError = CacheError.NoResultFound.INSTANCE;
                } else {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting LocalItem: " + value);
                    readError = CacheError.ReadError.INSTANCE;
                }
                return new Result.Error(readError);
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            error = new Result.Error(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object insertOrUpdateLocalIdToServerIdRelation(LocalIdToServerIdRelationEntity localIdToServerIdRelationEntity, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
        C12041 c12041;
        Result.Error error;
        if (continuation instanceof C12041) {
            c12041 = (C12041) continuation;
            if ((c12041.label & Integer.MIN_VALUE) != 0) {
                c12041.label -= Integer.MIN_VALUE;
            } else {
                c12041 = new C12041(continuation);
            }
        } else {
            c12041 = new C12041(continuation);
        }
        Object obj = c12041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12041.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    LocalItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$2$1$1 localItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$2$1$1 = new LocalItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$2$1$1(boxDatabase, localIdToServerIdRelationEntity, null);
                    c12041.L$0 = SpillingKt.nullOutSpilledVariable(localIdToServerIdRelationEntity);
                    c12041.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c12041.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c12041.I$0 = 0;
                    c12041.I$1 = 0;
                    c12041.I$2 = 0;
                    c12041.I$3 = 0;
                    c12041.label = 1;
                    if (RoomDatabaseKt.withTransaction(boxDatabase, localItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$2$1$1, c12041) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while inserting/Updating LocalIdToServerIdRelation: " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.SaveError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c12041.I$3;
            int i3 = c12041.I$2;
            int i4 = c12041.I$1;
            int i5 = c12041.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while inserting/Updating LocalIdToServerIdRelation: " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:40:0x00de  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object getServerId(ItemId.Local local, Continuation<? super Result<String, ? extends CacheError>> continuation) {
        C12031 c12031;
        Result.Error error;
        Object value;
        CacheError.ReadError readError;
        if (continuation instanceof C12031) {
            c12031 = (C12031) continuation;
            if ((c12031.label & Integer.MIN_VALUE) != 0) {
                c12031.label -= Integer.MIN_VALUE;
            } else {
                c12031 = new C12031(continuation);
            }
        } else {
            c12031 = new C12031(continuation);
        }
        Object serverId = c12031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12031.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(serverId);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    LocalItemsDao localItemsDao = boxDatabase.localItemsDao();
                    c12031.L$0 = local;
                    c12031.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c12031.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c12031.I$0 = 0;
                    c12031.I$1 = 0;
                    c12031.I$2 = 0;
                    c12031.I$3 = 0;
                    c12031.label = 1;
                    serverId = localItemsDao.getServerId(local, c12031);
                    if (serverId == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    value = ((Result.Error) error).getValue();
                    if (value instanceof NoResultFoundException) {
                        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting ServerId " + value);
                        readError = CacheError.NoResultFound.INSTANCE;
                    } else {
                        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting ServerId " + value);
                        readError = CacheError.ReadError.INSTANCE;
                    }
                    return new Result.Error(readError);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c12031.I$3;
            int i3 = c12031.I$2;
            int i4 = c12031.I$1;
            int i5 = c12031.I$0;
            local = (ItemId.Local) c12031.L$0;
            ResultKt.throwOnFailure(serverId);
            String str = (String) serverId;
            if (str == null) {
                throw new NoResultFoundException("ServerId not found for " + local);
            }
            error = new Result.Success(str);
            if (error instanceof Result.Success) {
                return error;
            }
            if (error instanceof Result.Error) {
                value = ((Result.Error) error).getValue();
                if (value instanceof NoResultFoundException) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting ServerId " + value);
                    readError = CacheError.NoResultFound.INSTANCE;
                } else {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting ServerId " + value);
                    readError = CacheError.ReadError.INSTANCE;
                }
                return new Result.Error(readError);
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            error = new Result.Error(e);
        }
    }

    public final Result<Flow<LocalIdToServerIdRelationEntity>, CacheError> observeLocalIdToServerIdRelation(ItemId.Local itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Result boxDatabase = this.userData.getBoxDatabase();
        if (boxDatabase instanceof Result.Success) {
            try {
                boxDatabase = new Result.Success(((BoxDatabase) ((Result.Success) boxDatabase).getValue()).localItemsDao().observeLocalIdToServerIdRelation(itemId));
            } catch (Exception e) {
                boxDatabase = new Result.Error(e);
            }
        } else if (!(boxDatabase instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting LocalIdToServerIdRelation " + ((Result.Error) boxDatabase).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x009e  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getLocalItemsByParentId(ItemId itemId, Continuation<? super Result<? extends List<LocalItemEntity>, ? extends CacheError>> continuation) {
        C12021 c12021;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C12021) {
            c12021 = (C12021) continuation;
            if ((c12021.label & Integer.MIN_VALUE) != 0) {
                c12021.label -= Integer.MIN_VALUE;
            } else {
                c12021 = new C12021(continuation);
            }
        } else {
            c12021 = new C12021(continuation);
        }
        Object localItemsByParentId = c12021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12021.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(localItemsByParentId);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    LocalItemsDao localItemsDao = boxDatabase2.localItemsDao();
                    c12021.L$0 = itemId;
                    c12021.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c12021.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c12021.I$0 = 0;
                    c12021.I$1 = 0;
                    c12021.I$2 = 0;
                    c12021.I$3 = 0;
                    c12021.label = 1;
                    localItemsByParentId = localItemsDao.getLocalItemsByParentId(itemId, c12021);
                    if (localItemsByParentId == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting LocalItems by parentId: " + itemId + " Error: " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c12021.I$3;
            int i3 = c12021.I$2;
            int i4 = c12021.I$1;
            int i5 = c12021.I$0;
            itemId = (ItemId) c12021.L$0;
            ResultKt.throwOnFailure(localItemsByParentId);
            error = new Result.Success((List) localItemsByParentId);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting LocalItems by parentId: " + itemId + " Error: " + ((Result.Error) boxDatabase).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getLocalIdToServerIdRelation(String str, ItemType itemType, Continuation<? super Result<LocalIdToServerIdRelationEntity, ? extends CacheError>> continuation) {
        C11991 c11991;
        Result.Error error;
        if (continuation instanceof C11991) {
            c11991 = (C11991) continuation;
            if ((c11991.label & Integer.MIN_VALUE) != 0) {
                c11991.label -= Integer.MIN_VALUE;
            } else {
                c11991 = new C11991(continuation);
            }
        } else {
            c11991 = new C11991(continuation);
        }
        Object localIdToServerIdRelation = c11991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11991.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(localIdToServerIdRelation);
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    LocalItemsDao localItemsDao = boxDatabase2.localItemsDao();
                    c11991.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    c11991.L$1 = SpillingKt.nullOutSpilledVariable(itemType);
                    c11991.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11991.L$3 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11991.I$0 = 0;
                    c11991.I$1 = 0;
                    c11991.I$2 = 0;
                    c11991.I$3 = 0;
                    c11991.label = 1;
                    localIdToServerIdRelation = localItemsDao.getLocalIdToServerIdRelation(str, itemType, c11991);
                    if (localIdToServerIdRelation == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (boxDatabase instanceof Result.Error) {
                        return boxDatabase;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11991.I$3;
                int i3 = c11991.I$2;
                int i4 = c11991.I$1;
                int i5 = c11991.I$0;
                ResultKt.throwOnFailure(localIdToServerIdRelation);
            }
            LocalIdToServerIdRelationEntity localIdToServerIdRelationEntity = (LocalIdToServerIdRelationEntity) localIdToServerIdRelation;
            if (localIdToServerIdRelationEntity == null) {
                throw new NoResultFoundException("LocalIdToServerIdRelation not found");
            }
            error = new Result.Success(localIdToServerIdRelationEntity);
            if (error instanceof Result.Success) {
                return error;
            }
            if (error instanceof Result.Error) {
                Exception exc = (Exception) ((Result.Error) error).getValue();
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting LocalIdToServerIdRelation " + exc);
                return new Result.Error(exc instanceof NoResultFoundException ? CacheError.NoResultFound.INSTANCE : CacheError.ReadError.INSTANCE);
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            error = new Result.Error(e);
        }
    }

    /* JADX INFO: compiled from: LocalItemsDataSource.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/box/android/data/datasource/localItems/LocalItemsDataSource$NoResultFoundException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NoResultFoundException extends Exception {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoResultFoundException(String message) {
            super(message);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }
}
