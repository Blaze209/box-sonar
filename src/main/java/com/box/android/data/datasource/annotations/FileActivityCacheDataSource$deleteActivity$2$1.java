package com.box.android.data.datasource.annotations;

import com.box.android.data.persistence.BoxDatabase;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FileActivityCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.annotations.FileActivityCacheDataSource$deleteActivity$2$1", f = "FileActivityCacheDataSource.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, l = {125, 126, 127, 128, 129}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240", "$i$a$-with-FileActivityCacheDataSource$deleteActivity$2$1$1", "$this$invokeSuspend_u24lambda_u240", "$i$a$-with-FileActivityCacheDataSource$deleteActivity$2$1$1", "$this$invokeSuspend_u24lambda_u240", "$i$a$-with-FileActivityCacheDataSource$deleteActivity$2$1$1", "$this$invokeSuspend_u24lambda_u240", "$i$a$-with-FileActivityCacheDataSource$deleteActivity$2$1$1", "$this$invokeSuspend_u24lambda_u240", "$i$a$-with-FileActivityCacheDataSource$deleteActivity$2$1$1"}, s = {"L$2", "I$0", "L$2", "I$0", "L$2", "I$0", "L$2", "I$0", "L$0", "I$0"}, v = 1)
final class FileActivityCacheDataSource$deleteActivity$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ BoxDatabase $database;
    final /* synthetic */ Date $fetchedBefore;
    final /* synthetic */ String $fileId;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileActivityCacheDataSource$deleteActivity$2$1(BoxDatabase boxDatabase, String str, Date date, Continuation<? super FileActivityCacheDataSource$deleteActivity$2$1> continuation) {
        super(1, continuation);
        this.$database = boxDatabase;
        this.$fileId = str;
        this.$fetchedBefore = date;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new FileActivityCacheDataSource$deleteActivity$2$1(this.$database, this.$fileId, this.$fetchedBefore, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((FileActivityCacheDataSource$deleteActivity$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ce  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e4, code lost:
    
        if (r3.deleteFileActivities(r5, r4, r9) == r0) goto L34;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.annotations.FileActivityCacheDataSource$deleteActivity$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
