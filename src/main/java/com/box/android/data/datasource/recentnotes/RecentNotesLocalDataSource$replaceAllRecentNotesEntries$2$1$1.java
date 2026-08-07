package com.box.android.data.datasource.recentnotes;

import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.recentnotes.RecentNoteEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RecentNotesLocalDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource$replaceAllRecentNotesEntries$2$1$1", f = "RecentNotesLocalDataSource.kt", i = {}, l = {40, 41}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RecentNotesLocalDataSource$replaceAllRecentNotesEntries$2$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ BoxDatabase $db;
    final /* synthetic */ List<RecentNoteEntity> $notes;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RecentNotesLocalDataSource$replaceAllRecentNotesEntries$2$1$1(BoxDatabase boxDatabase, List<RecentNoteEntity> list, Continuation<? super RecentNotesLocalDataSource$replaceAllRecentNotesEntries$2$1$1> continuation) {
        super(1, continuation);
        this.$db = boxDatabase;
        this.$notes = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new RecentNotesLocalDataSource$replaceAllRecentNotesEntries$2$1$1(this.$db, this.$notes, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((RecentNotesLocalDataSource$replaceAllRecentNotesEntries$2$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
    
        if (r4.$db.recentNoteDao().upsertAll(r4.$notes, r4) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r5)
            goto L47
        L12:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L1a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L33
        L1e:
            kotlin.ResultKt.throwOnFailure(r5)
            com.box.android.data.persistence.BoxDatabase r5 = r4.$db
            com.box.android.data.persistence.recentnotes.RecentNoteDao r5 = r5.recentNoteDao()
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r3
            java.lang.Object r5 = r5.deleteAll(r1)
            if (r5 != r0) goto L33
            goto L46
        L33:
            com.box.android.data.persistence.BoxDatabase r5 = r4.$db
            com.box.android.data.persistence.recentnotes.RecentNoteDao r5 = r5.recentNoteDao()
            java.util.List<com.box.android.data.persistence.recentnotes.RecentNoteEntity> r1 = r4.$notes
            r3 = r4
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4.label = r2
            java.lang.Object r4 = r5.upsertAll(r1, r3)
            if (r4 != r0) goto L47
        L46:
            return r0
        L47:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource$replaceAllRecentNotesEntries$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
