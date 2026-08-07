package com.box.android.data.datasource.annotations;

import com.box.android.data.api.models.annotations.ActivityType;
import com.box.android.data.api.models.annotations.FileActivityDTO;
import com.box.android.data.api.requests.FileActivitiesRequest;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.configuration.FeatureFlips;
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

/* JADX INFO: compiled from: FileActivityRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ4\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/datasource/annotations/FileActivityRemoteDataSource;", "", "fileActivitiesRequest", "Lcom/box/android/data/api/requests/FileActivitiesRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/data/api/requests/FileActivitiesRequest;Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/configuration/FeatureFlips;)V", "getFileActivity", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "fileId", "", "types", "Lcom/box/android/data/api/models/annotations/ActivityType;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivityRemoteDataSource {
    public static final String LOGTAG = "FileActivityRemoteDataSource";
    public static final int REPLY_LIMIT = 1000;
    private final FeatureFlips featureFlips;
    private final FileActivitiesRequest fileActivitiesRequest;
    private final Moshi moshi;

    @Inject
    public FileActivityRemoteDataSource(FileActivitiesRequest fileActivitiesRequest, Moshi moshi, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(fileActivitiesRequest, "fileActivitiesRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.fileActivitiesRequest = fileActivitiesRequest;
        this.moshi = moshi;
        this.featureFlips = featureFlips;
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.FileActivityRemoteDataSource$getFileActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileActivityRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.FileActivityRemoteDataSource$getFileActivity$1", f = "FileActivityRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {39, 62, 66, 72, 76}, m = "invokeSuspend", n = {"$this$flow", "marker", "fetchErrors", "replyLimit", "enableReplies", "$i$f$resultOf", "$i$a$-resultOf-FileActivityRemoteDataSource$getFileActivity$1$fileActivitiesGetResult$1", "$this$flow", "marker", "fetchErrors", "replyLimit", "fileActivitiesGetResult", "enableReplies", "$this$flow", "marker", "fetchErrors", "replyLimit", "fileActivitiesGetResult", "$this$forEach$iv", "element$iv", "error", "enableReplies", "$i$f$forEach", "$i$a$-forEach-FileActivityRemoteDataSource$getFileActivity$1$1", "$this$flow", "marker", "fetchErrors", "replyLimit", "fileActivitiesGetResult", "$this$forEach$iv", "element$iv", "error", "enableReplies", "$i$f$forEach", "$i$a$-forEach-FileActivityRemoteDataSource$getFileActivity$1$1", "$this$flow", "marker", "fetchErrors", "replyLimit", "fileActivitiesGetResult", "$this$forEach$iv", "element$iv", "error", "enableReplies", "$i$f$forEach", "$i$a$-forEach-FileActivityRemoteDataSource$getFileActivity$1$1"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "Z$0", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends FileActivityDTO>, ? extends RemoteError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileId;
        final /* synthetic */ List<ActivityType> $types;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(List<? extends ActivityType> list, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$types = list;
            this.$fileId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = FileActivityRemoteDataSource.this.new AnonymousClass1(this.$types, this.$fileId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends List<? extends FileActivityDTO>, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:65:0x024e  */
        /* JADX WARN: Code duplicated, block: B:86:0x030f A[PHI: r2 r4 r5 r6 r8 r9 r13 r14 r18
          0x030f: PHI (r2v17 int) = (r2v13 int), (r2v13 int), (r2v18 int) binds: [B:88:0x0319, B:71:0x026c, B:85:0x030e] A[DONT_GENERATE, DONT_INLINE]
          0x030f: PHI (r4v22 boolean) = (r4v20 boolean), (r4v20 boolean), (r4v23 boolean) binds: [B:88:0x0319, B:71:0x026c, B:85:0x030e] A[DONT_GENERATE, DONT_INLINE]
          0x030f: PHI (r5v11 java.util.Iterator) = (r5v9 java.util.Iterator), (r5v9 java.util.Iterator), (r5v12 java.util.Iterator) binds: [B:88:0x0319, B:71:0x026c, B:85:0x030e] A[DONT_GENERATE, DONT_INLINE]
          0x030f: PHI (r6v9 java.lang.Iterable) = (r6v7 java.lang.Iterable), (r6v7 java.lang.Iterable), (r6v10 java.lang.Iterable) binds: [B:88:0x0319, B:71:0x026c, B:85:0x030e] A[DONT_GENERATE, DONT_INLINE]
          0x030f: PHI (r8v11 com.box.android.domain.utils.result.Result) = 
          (r8v8 com.box.android.domain.utils.result.Result)
          (r8v8 com.box.android.domain.utils.result.Result)
          (r8v12 com.box.android.domain.utils.result.Result)
         binds: [B:88:0x0319, B:71:0x026c, B:85:0x030e] A[DONT_GENERATE, DONT_INLINE]
          0x030f: PHI (r9v7 java.lang.Integer) = (r9v5 java.lang.Integer), (r9v5 java.lang.Integer), (r9v8 java.lang.Integer) binds: [B:88:0x0319, B:71:0x026c, B:85:0x030e] A[DONT_GENERATE, DONT_INLINE]
          0x030f: PHI (r13v6 java.util.List) = (r13v4 java.util.List), (r13v4 java.util.List), (r13v7 java.util.List) binds: [B:88:0x0319, B:71:0x026c, B:85:0x030e] A[DONT_GENERATE, DONT_INLINE]
          0x030f: PHI (r14v6 kotlin.jvm.internal.Ref$ObjectRef) = 
          (r14v4 kotlin.jvm.internal.Ref$ObjectRef)
          (r14v4 kotlin.jvm.internal.Ref$ObjectRef)
          (r14v7 kotlin.jvm.internal.Ref$ObjectRef)
         binds: [B:88:0x0319, B:71:0x026c, B:85:0x030e] A[DONT_GENERATE, DONT_INLINE]
          0x030f: PHI (r18v10 ??) = (r18v19 ??), (r18v20 ??), (r18v21 ??) binds: [B:88:0x0319, B:71:0x026c, B:85:0x030e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:87:0x0312  */
        /* JADX WARN: Code duplicated, block: B:90:0x031c  */
        /* JADX WARN: Code duplicated, block: B:93:0x0361  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v7 */
        /* JADX WARN: Type inference failed for: r18v0 */
        /* JADX WARN: Type inference failed for: r18v1 */
        /* JADX WARN: Type inference failed for: r18v10 */
        /* JADX WARN: Type inference failed for: r18v11 */
        /* JADX WARN: Type inference failed for: r18v12 */
        /* JADX WARN: Type inference failed for: r18v13 */
        /* JADX WARN: Type inference failed for: r18v14 */
        /* JADX WARN: Type inference failed for: r18v15 */
        /* JADX WARN: Type inference failed for: r18v16 */
        /* JADX WARN: Type inference failed for: r18v17 */
        /* JADX WARN: Type inference failed for: r18v19 */
        /* JADX WARN: Type inference failed for: r18v2 */
        /* JADX WARN: Type inference failed for: r18v20 */
        /* JADX WARN: Type inference failed for: r18v21 */
        /* JADX WARN: Type inference failed for: r18v22 */
        /* JADX WARN: Type inference failed for: r18v23 */
        /* JADX WARN: Type inference failed for: r18v24 */
        /* JADX WARN: Type inference failed for: r18v3 */
        /* JADX WARN: Type inference failed for: r18v4 */
        /* JADX WARN: Type inference failed for: r18v7 */
        /* JADX WARN: Type inference failed for: r18v8 */
        /* JADX WARN: Type inference failed for: r18v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v22, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v11, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r4v10, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x026c -> B:86:0x030f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0319 -> B:86:0x030f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r27) {
            /*
                Method dump skipped, instruction units count: 943
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.annotations.FileActivityRemoteDataSource.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Flow<Result<List<FileActivityDTO>, RemoteError>> getFileActivity(String fileId, List<? extends ActivityType> types) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(types, "types");
        return FlowKt.flow(new AnonymousClass1(types, fileId, null));
    }
}
