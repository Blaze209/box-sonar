package com.box.android.data.datasource.annotations;

import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.annotations.CommentEntity;
import com.box.android.data.persistence.annotations.FileActivityEntities;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FileActivityCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.annotations.FileActivityCacheDataSource$saveActivitiesWithReplies$2$1", f = "FileActivityCacheDataSource.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6}, l = {85, 90, 94, 98, 102, 105, 106}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "activity", "replies", "$i$f$forEach", "$i$a$-forEach-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1", "$this$forEach$iv", "element$iv", "activity", "replies", "it", "$i$f$forEach", "$i$a$-forEach-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1", "$i$a$-let-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1$1", "$this$forEach$iv", "element$iv", "activity", "replies", "it", "$i$f$forEach", "$i$a$-forEach-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1", "$i$a$-let-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1$2", "$this$forEach$iv", "element$iv", "activity", "replies", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1", "$i$f$forEach", "$i$a$-forEach-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1$3", "$this$forEach$iv", "element$iv", "activity", "replies", "it", "$i$f$forEach", "$i$a$-forEach-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1", "$i$a$-let-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1$4", "$this$forEach$iv", "element$iv", "activity", "replies", "it", "$i$f$forEach", "$i$a$-forEach-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1", "$i$a$-let-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1$4", "$this$forEach$iv", "element$iv", "activity", "replies", "it", "$i$f$forEach", "$i$a$-forEach-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1", "$i$a$-let-FileActivityCacheDataSource$saveActivitiesWithReplies$2$1$1$4"}, s = {"L$0", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "L$0", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 1)
final class FileActivityCacheDataSource$saveActivitiesWithReplies$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Pair<FileActivityEntities, List<CommentEntity>>> $activitiesWithReplies;
    final /* synthetic */ BoxDatabase $database;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FileActivityCacheDataSource$saveActivitiesWithReplies$2$1(List<? extends Pair<FileActivityEntities, ? extends List<CommentEntity>>> list, BoxDatabase boxDatabase, Continuation<? super FileActivityCacheDataSource$saveActivitiesWithReplies$2$1> continuation) {
        super(1, continuation);
        this.$activitiesWithReplies = list;
        this.$database = boxDatabase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new FileActivityCacheDataSource$saveActivitiesWithReplies$2$1(this.$activitiesWithReplies, this.$database, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((FileActivityCacheDataSource$saveActivitiesWithReplies$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x013c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0182  */
    /* JADX WARN: Code duplicated, block: B:23:0x0191  */
    /* JADX WARN: Code duplicated, block: B:26:0x01c0 A[PHI: r2 r4 r5 r6 r7 r8 r9 r10 r11
      0x01c0: PHI (r2v19 int) = (r2v4 int), (r2v20 int), (r2v20 int) binds: [B:12:0x00e7, B:22:0x018f, B:24:0x01bc] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r4v9 int) = (r4v0 int), (r4v10 int), (r4v10 int) binds: [B:12:0x00e7, B:22:0x018f, B:24:0x01bc] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r5v14 int) = (r5v2 int), (r5v15 int), (r5v15 int) binds: [B:12:0x00e7, B:22:0x018f, B:24:0x01bc] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r6v22 java.util.List) = (r6v6 java.util.List), (r6v23 java.util.List), (r6v23 java.util.List) binds: [B:12:0x00e7, B:22:0x018f, B:24:0x01bc] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r7v34 com.box.android.data.persistence.annotations.FileActivityEntities) = 
      (r7v4 com.box.android.data.persistence.annotations.FileActivityEntities)
      (r7v35 com.box.android.data.persistence.annotations.FileActivityEntities)
      (r7v35 com.box.android.data.persistence.annotations.FileActivityEntities)
     binds: [B:12:0x00e7, B:22:0x018f, B:24:0x01bc] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r8v28 java.lang.Object) = (r8v1 java.lang.Object), (r8v29 java.lang.Object), (r8v29 java.lang.Object) binds: [B:12:0x00e7, B:22:0x018f, B:24:0x01bc] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r9v20 java.util.Iterator) = (r9v3 java.util.Iterator), (r9v21 java.util.Iterator), (r9v21 java.util.Iterator) binds: [B:12:0x00e7, B:22:0x018f, B:24:0x01bc] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r10v18 com.box.android.data.persistence.BoxDatabase) = 
      (r10v3 com.box.android.data.persistence.BoxDatabase)
      (r10v19 com.box.android.data.persistence.BoxDatabase)
      (r10v19 com.box.android.data.persistence.BoxDatabase)
     binds: [B:12:0x00e7, B:22:0x018f, B:24:0x01bc] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r11v18 java.lang.Iterable) = (r11v3 java.lang.Iterable), (r11v19 java.lang.Iterable), (r11v19 java.lang.Iterable) binds: [B:12:0x00e7, B:22:0x018f, B:24:0x01bc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:28:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:34:0x020f  */
    /* JADX WARN: Code duplicated, block: B:37:0x025c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0267  */
    /* JADX WARN: Code duplicated, block: B:44:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:48:0x02de  */
    /* JADX WARN: Code duplicated, block: B:52:0x031e  */
    /* JADX WARN: Code duplicated, block: B:60:0x031d A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x031e -> B:53:0x031f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x032a -> B:55:0x032f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 842
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.annotations.FileActivityCacheDataSource$saveActivitiesWithReplies$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
