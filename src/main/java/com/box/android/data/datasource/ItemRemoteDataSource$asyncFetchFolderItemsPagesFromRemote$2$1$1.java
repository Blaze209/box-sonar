package com.box.android.data.datasource;

import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: ItemRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.ItemRemoteDataSource$asyncFetchFolderItemsPagesFromRemote$2$1$1", f = "ItemRemoteDataSource.kt", i = {0}, l = {Token.DEBUGGER}, m = "invokeSuspend", n = {"pageOffset"}, s = {"J$0"}, v = 1)
final class ItemRemoteDataSource$asyncFetchFolderItemsPagesFromRemote$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $folderId;
    final /* synthetic */ int $index;
    final /* synthetic */ int $limit;
    final /* synthetic */ long $maxLimit;
    final /* synthetic */ long $offset;
    final /* synthetic */ List<Result<ItemRemoteDataSource.PageResult, RemoteError>> $pageResults;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ ItemRemoteDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ItemRemoteDataSource$asyncFetchFolderItemsPagesFromRemote$2$1$1(long j, int i, int i2, long j2, List<Result<ItemRemoteDataSource.PageResult, RemoteError>> list, ItemRemoteDataSource itemRemoteDataSource, String str, Continuation<? super ItemRemoteDataSource$asyncFetchFolderItemsPagesFromRemote$2$1$1> continuation) {
        super(2, continuation);
        this.$offset = j;
        this.$index = i;
        this.$limit = i2;
        this.$maxLimit = j2;
        this.$pageResults = list;
        this.this$0 = itemRemoteDataSource;
        this.$folderId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ItemRemoteDataSource$asyncFetchFolderItemsPagesFromRemote$2$1$1(this.$offset, this.$index, this.$limit, this.$maxLimit, this.$pageResults, this.this$0, this.$folderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ItemRemoteDataSource$asyncFetchFolderItemsPagesFromRemote$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.$offset + ((long) (this.$index * this.$limit));
            if (j < this.$maxLimit && JobKt.isActive(getContext())) {
                List<Result<ItemRemoteDataSource.PageResult, RemoteError>> list2 = this.$pageResults;
                this.L$0 = list2;
                this.J$0 = j;
                this.label = 1;
                Object objFetchFolderItemsPageFromRemote = this.this$0.fetchFolderItemsPageFromRemote(this.$folderId, j, this.$limit, this);
                if (objFetchFolderItemsPageFromRemote == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objFetchFolderItemsPageFromRemote;
                list = list2;
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        list = (List) this.L$0;
        ResultKt.throwOnFailure(obj);
        list.add(obj);
        return Unit.INSTANCE;
    }
}
