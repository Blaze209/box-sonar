package com.box.android.data.datasource.comment;

import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.annotations.CommentEntity;
import com.box.android.data.persistence.annotations.FileActivityEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CommentCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.comment.CommentCacheDataSource$saveComment$2$1", f = "CommentCacheDataSource.kt", i = {}, l = {60, 61}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CommentCacheDataSource$saveComment$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ BoxDatabase $boxDatabase;
    final /* synthetic */ CommentEntity $commentEntity;
    final /* synthetic */ FileActivityEntity $fileActivityEntity;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommentCacheDataSource$saveComment$2$1(BoxDatabase boxDatabase, FileActivityEntity fileActivityEntity, CommentEntity commentEntity, Continuation<? super CommentCacheDataSource$saveComment$2$1> continuation) {
        super(1, continuation);
        this.$boxDatabase = boxDatabase;
        this.$fileActivityEntity = fileActivityEntity;
        this.$commentEntity = commentEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new CommentCacheDataSource$saveComment$2$1(this.$boxDatabase, this.$fileActivityEntity, this.$commentEntity, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((CommentCacheDataSource$saveComment$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if (r5.$boxDatabase.commentDao().insertComment(r5.$commentEntity, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r6)
            goto L49
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L35
        L1e:
            kotlin.ResultKt.throwOnFailure(r6)
            com.box.android.data.persistence.BoxDatabase r6 = r5.$boxDatabase
            com.box.android.data.persistence.annotations.FileActivityDao r6 = r6.fileActivityDao()
            com.box.android.data.persistence.annotations.FileActivityEntity r1 = r5.$fileActivityEntity
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r3
            java.lang.Object r6 = r6.insertActivity(r1, r4)
            if (r6 != r0) goto L35
            goto L48
        L35:
            com.box.android.data.persistence.BoxDatabase r6 = r5.$boxDatabase
            com.box.android.data.persistence.comment.CommentDao r6 = r6.commentDao()
            com.box.android.data.persistence.annotations.CommentEntity r1 = r5.$commentEntity
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.label = r2
            java.lang.Object r5 = r6.insertComment(r1, r3)
            if (r5 != r0) goto L49
        L48:
            return r0
        L49:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.comment.CommentCacheDataSource$saveComment$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
