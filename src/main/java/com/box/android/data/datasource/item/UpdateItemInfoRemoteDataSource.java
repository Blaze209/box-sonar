package com.box.android.data.datasource.item;

import com.box.android.data.api.requests.UpdateItemInfoRequest;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.squareup.moshi.Moshi;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateItemInfoRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J:\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/datasource/item/UpdateItemInfoRemoteDataSource;", "", "updateItemInfoRequest", "Lcom/box/android/data/api/requests/UpdateItemInfoRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/UpdateItemInfoRequest;Lcom/squareup/moshi/Moshi;)V", "updateItem", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", "newItemName", "", "newDescription", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDefaultSharedLink", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdateItemInfoRemoteDataSource {
    private final Moshi moshi;
    private final UpdateItemInfoRequest updateItemInfoRequest;

    /* JADX INFO: compiled from: UpdateItemInfoRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.FOLDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemType.FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemType.WEBLINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.item.UpdateItemInfoRemoteDataSource$createDefaultSharedLink$1, reason: invalid class name */
    /* JADX INFO: compiled from: UpdateItemInfoRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.item.UpdateItemInfoRemoteDataSource", f = "UpdateItemInfoRemoteDataSource.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {55, 61, 67}, m = "createDefaultSharedLink", n = {"itemId", "$i$f$resultOf", "$i$a$-resultOf-UpdateItemInfoRemoteDataSource$createDefaultSharedLink$2", "itemId", "$i$f$resultOf", "$i$a$-resultOf-UpdateItemInfoRemoteDataSource$createDefaultSharedLink$2", "itemId", "$i$f$resultOf", "$i$a$-resultOf-UpdateItemInfoRemoteDataSource$createDefaultSharedLink$2"}, s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1"}, v = 1)
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
            return UpdateItemInfoRemoteDataSource.this.createDefaultSharedLink(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.item.UpdateItemInfoRemoteDataSource$updateItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UpdateItemInfoRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.item.UpdateItemInfoRemoteDataSource", f = "UpdateItemInfoRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {30, 36, 42}, m = "updateItem", n = {"itemId", "newItemName", "newDescription", "$i$f$resultOf", "$i$a$-resultOf-UpdateItemInfoRemoteDataSource$updateItem$2", "itemId", "newItemName", "newDescription", "$i$f$resultOf", "$i$a$-resultOf-UpdateItemInfoRemoteDataSource$updateItem$2", "itemId", "newItemName", "newDescription", "$i$f$resultOf", "$i$a$-resultOf-UpdateItemInfoRemoteDataSource$updateItem$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C11671 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11671(Continuation<? super C11671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdateItemInfoRemoteDataSource.this.updateItem(null, null, null, this);
        }
    }

    @Inject
    public UpdateItemInfoRemoteDataSource(UpdateItemInfoRequest updateItemInfoRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(updateItemInfoRequest, "updateItemInfoRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.updateItemInfoRequest = updateItemInfoRequest;
        this.moshi = moshi;
    }

    public static /* synthetic */ Object updateItem$default(UpdateItemInfoRemoteDataSource updateItemInfoRemoteDataSource, ItemId.Remote remote, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return updateItemInfoRemoteDataSource.updateItem(remote, str, str2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0143, code lost:
    
        if (r0 == r4) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateItem(com.box.android.domain.models.ItemId.Remote r24, java.lang.String r25, java.lang.String r26, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends com.box.android.data.api.models.items.IItemDTO, ? extends com.box.android.data.datasource.errors.RemoteError>> r27) {
        /*
            Method dump skipped, instruction units count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.item.UpdateItemInfoRemoteDataSource.updateItem(com.box.android.domain.models.ItemId$Remote, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0145, code lost:
    
        if (r0 == r4) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createDefaultSharedLink(com.box.android.domain.models.ItemId.Remote r25, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends com.box.android.data.api.models.items.IItemDTO, ? extends com.box.android.data.datasource.errors.RemoteError>> r26) {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.item.UpdateItemInfoRemoteDataSource.createDefaultSharedLink(com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
