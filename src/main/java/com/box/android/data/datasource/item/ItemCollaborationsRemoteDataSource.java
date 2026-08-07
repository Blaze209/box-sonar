package com.box.android.data.datasource.item;

import com.box.android.data.api.requests.ItemCollaborationsRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxIterator;
import com.squareup.moshi.Moshi;
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

/* JADX INFO: compiled from: ItemCollaborationsRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/datasource/item/ItemCollaborationsRemoteDataSource;", "", "itemCollaborationsRequest", "Lcom/box/android/data/api/requests/ItemCollaborationsRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/ItemCollaborationsRequest;Lcom/squareup/moshi/Moshi;)V", "getItemCollaborations", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/ItemCollaborationsDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", BoxIterator.FIELD_LIMIT, "", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCollaborations", "", "collaborationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemCollaborationsRemoteDataSource {
    private final ItemCollaborationsRequest itemCollaborationsRequest;
    private final Moshi moshi;

    /* JADX INFO: compiled from: ItemCollaborationsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemType.FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemType.WEBLINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.item.ItemCollaborationsRemoteDataSource$deleteCollaborations$1, reason: invalid class name */
    /* JADX INFO: compiled from: ItemCollaborationsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.item.ItemCollaborationsRemoteDataSource", f = "ItemCollaborationsRemoteDataSource.kt", i = {0, 0, 0}, l = {48}, m = "deleteCollaborations", n = {"collaborationId", "$i$f$resultOf", "$i$a$-resultOf-ItemCollaborationsRemoteDataSource$deleteCollaborations$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemCollaborationsRemoteDataSource.this.deleteCollaborations(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.item.ItemCollaborationsRemoteDataSource$getItemCollaborations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemCollaborationsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.item.ItemCollaborationsRemoteDataSource", f = "ItemCollaborationsRemoteDataSource.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {24, 30}, m = "getItemCollaborations", n = {"itemId", BoxIterator.FIELD_LIMIT, "$i$f$resultOf", "$i$a$-resultOf-ItemCollaborationsRemoteDataSource$getItemCollaborations$2", "itemId", BoxIterator.FIELD_LIMIT, "$i$f$resultOf", "$i$a$-resultOf-ItemCollaborationsRemoteDataSource$getItemCollaborations$2"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C11661 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11661(Continuation<? super C11661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemCollaborationsRemoteDataSource.this.getItemCollaborations(null, null, this);
        }
    }

    @Inject
    public ItemCollaborationsRemoteDataSource(ItemCollaborationsRequest itemCollaborationsRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(itemCollaborationsRequest, "itemCollaborationsRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.itemCollaborationsRequest = itemCollaborationsRequest;
        this.moshi = moshi;
    }

    public static /* synthetic */ Object getItemCollaborations$default(ItemCollaborationsRemoteDataSource itemCollaborationsRemoteDataSource, ItemId.Remote remote, Integer num, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return itemCollaborationsRemoteDataSource.getItemCollaborations(remote, num, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ae, code lost:
    
        if (r10 == r1) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getItemCollaborations(com.box.android.domain.models.ItemId.Remote r8, java.lang.Integer r9, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.data.api.ItemCollaborationsDTO, ? extends com.box.android.data.datasource.errors.RemoteError>> r10) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.item.ItemCollaborationsRemoteDataSource.getItemCollaborations(com.box.android.domain.models.ItemId$Remote, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteCollaborations(String str, Continuation<? super Result<Unit, ? extends RemoteError>> continuation) {
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
                ItemCollaborationsRequest itemCollaborationsRequest = this.itemCollaborationsRequest;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                if (itemCollaborationsRequest.deleteCollaboration(str, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(obj);
            }
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }
}
