package com.box.android.data.datasource.recentnotes;

import com.box.android.data.api.models.recentnotes.RecentNoteDTO;
import com.box.android.data.api.requests.RecentNotesRequest;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.squareup.moshi.Moshi;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: RecentNotesRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n0\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/datasource/recentnotes/RecentNotesRemoteDataSource;", "", "recentNotesRequest", "Lcom/box/android/data/api/requests/RecentNotesRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/RecentNotesRequest;Lcom/squareup/moshi/Moshi;)V", "fetchRecentNotesPages", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/recentnotes/RecentNoteDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentNotesRemoteDataSource {
    public static final int MAX_PAGES = 4;
    public static final int PAGE_SIZE = 50;
    private final Moshi moshi;
    private final RecentNotesRequest recentNotesRequest;

    /* JADX INFO: renamed from: com.box.android.data.datasource.recentnotes.RecentNotesRemoteDataSource$fetchRecentNotesPages$1, reason: invalid class name */
    /* JADX INFO: compiled from: RecentNotesRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/recentnotes/RecentNoteDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.recentnotes.RecentNotesRemoteDataSource$fetchRecentNotesPages$1", f = "RecentNotesRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {22, 27, 33}, m = "invokeSuspend", n = {"$this$flow", "marker", "pageCount", "$i$f$resultOf", "$i$a$-resultOf-RecentNotesRemoteDataSource$fetchRecentNotesPages$1$pageResult$1", "$this$flow", "marker", "pageResult", "pageCount", "$this$flow", "marker", "pageResult", "pageCount"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends RecentNoteDTO>, ? extends RemoteError>>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = RecentNotesRemoteDataSource.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends List<? extends RecentNoteDTO>, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<? extends List<RecentNoteDTO>, ? extends RemoteError>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<? extends List<RecentNoteDTO>, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(14:10|11|44|(1:47)|48|(2:55|56)|18|70|19|20|72|21|(7:24|25|33|(2:36|(1:38)(2:66|67))|35|39|(1:41)(2:57|(1:59)(2:64|65)))|61) */
        /* JADX WARN: Code duplicated, block: B:24:0x0089  */
        /* JADX WARN: Code duplicated, block: B:36:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:38:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:41:0x00d4  */
        /* JADX WARN: Code duplicated, block: B:57:0x0127  */
        /* JADX WARN: Code duplicated, block: B:59:0x012b  */
        /* JADX WARN: Code duplicated, block: B:64:0x014e  */
        /* JADX WARN: Code duplicated, block: B:66:0x0154  */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0098, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0099, code lost:
        
            r16 = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x009b, code lost:
        
            r1 = r15;
            r2 = r16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00f7, code lost:
        
            if (r8.emit(new com.box.android.domain.utils.result.Result.Success(((com.box.android.data.api.models.recentnotes.RecentNotesIteratorDTO) ((com.box.android.domain.utils.result.Result.Success) r1).getValue()).getEntries()), r18) == r9) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0148, code lost:
        
            if (r8.emit(r1, r18) == r9) goto L61;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00f7 -> B:11:0x003c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 346
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.recentnotes.RecentNotesRemoteDataSource.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Inject
    public RecentNotesRemoteDataSource(RecentNotesRequest recentNotesRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(recentNotesRequest, "recentNotesRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.recentNotesRequest = recentNotesRequest;
        this.moshi = moshi;
    }

    public final Flow<Result<List<RecentNoteDTO>, RemoteError>> fetchRecentNotesPages() {
        return FlowKt.flow(new AnonymousClass1(null));
    }
}
