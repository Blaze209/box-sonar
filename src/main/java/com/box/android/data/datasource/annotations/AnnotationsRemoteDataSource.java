package com.box.android.data.datasource.annotations;

import com.box.android.data.api.models.annotations.AnnotationDTO;
import com.box.android.data.api.models.annotations.CreateAnnotationDTO;
import com.box.android.data.api.models.annotations.DescriptionDTO;
import com.box.android.data.api.models.annotations.ReferenceDTO;
import com.box.android.data.api.models.annotations.Status;
import com.box.android.data.api.models.annotations.TargetDTO;
import com.box.android.data.api.models.annotations.UpdateAnnotationDTO;
import com.box.android.data.api.requests.AnnotationsRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AnnotationsRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ2\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\f2\u0006\u0010\u0015\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0016J2\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ6\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f2\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0086@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/data/datasource/annotations/AnnotationsRemoteDataSource;", "", "annotationsRequest", "Lcom/box/android/data/api/requests/AnnotationsRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/data/api/requests/AnnotationsRequest;Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/configuration/FeatureFlips;)V", "getAnnotations", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/annotations/AnnotationDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "fileId", "", "fileVersionId", "deleteAnnotation", "", "annotationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAnnotation", "message", "targetDTO", "Lcom/box/android/data/api/models/annotations/TargetDTO;", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/annotations/TargetDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAnnotation", "status", "Lcom/box/android/data/api/models/annotations/Status;", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/annotations/Status;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationsRemoteDataSource {
    private static final String LOGTAG = "AnnotationsRemoteDataSource";
    private final AnnotationsRequest annotationsRequest;
    private final FeatureFlips featureFlips;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource$createAnnotation$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnnotationsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource", f = "AnnotationsRemoteDataSource.kt", i = {0, 0, 0, 0, 0}, l = {78}, m = "createAnnotation", n = {"fileVersionId", "message", "targetDTO", "$i$f$resultOf", "$i$a$-resultOf-AnnotationsRemoteDataSource$createAnnotation$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return AnnotationsRemoteDataSource.this.createAnnotation(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource$deleteAnnotation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotationsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource", f = "AnnotationsRemoteDataSource.kt", i = {0, 0, 0}, l = {64}, m = "deleteAnnotation", n = {"annotationId", "$i$f$resultOf", "$i$a$-resultOf-AnnotationsRemoteDataSource$deleteAnnotation$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C11081 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11081(Continuation<? super C11081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnnotationsRemoteDataSource.this.deleteAnnotation(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource$updateAnnotation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotationsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource", f = "AnnotationsRemoteDataSource.kt", i = {0, 0, 0, 0, 0}, l = {101}, m = "updateAnnotation", n = {"annotationId", "message", "status", "$i$f$resultOf", "$i$a$-resultOf-AnnotationsRemoteDataSource$updateAnnotation$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C11101 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11101(Continuation<? super C11101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnnotationsRemoteDataSource.this.updateAnnotation(null, null, null, this);
        }
    }

    @Inject
    public AnnotationsRemoteDataSource(AnnotationsRequest annotationsRequest, Moshi moshi, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(annotationsRequest, "annotationsRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.annotationsRequest = annotationsRequest;
        this.moshi = moshi;
        this.featureFlips = featureFlips;
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource$getAnnotations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotationsRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/annotations/AnnotationDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource$getAnnotations$1", f = "AnnotationsRemoteDataSource.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {36, 52}, m = "invokeSuspend", n = {"$this$flow", "marker", "$i$f$resultOf", "$i$a$-resultOf-AnnotationsRemoteDataSource$getAnnotations$1$annotationsResult$1", "$this$flow", "marker", "annotationsResult"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class C11091 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends AnnotationDTO>, ? extends RemoteError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileId;
        final /* synthetic */ String $fileVersionId;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11091(String str, String str2, Continuation<? super C11091> continuation) {
            super(2, continuation);
            this.$fileId = str;
            this.$fileVersionId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11091 c11091 = AnnotationsRemoteDataSource.this.new C11091(this.$fileId, this.$fileVersionId, continuation);
            c11091.L$0 = obj;
            return c11091;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends List<? extends AnnotationDTO>, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<? extends List<AnnotationDTO>, ? extends RemoteError>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<? extends List<AnnotationDTO>, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C11091) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:14|15|69|16|17|71|18|(1:20)(7:21|29|(2:32|(2:67|68))(1:31)|(2:36|(2:65|66))(1:35)|38|(2:41|(1:43)(2:63|64))(1:40)|44)|46) */
        /* JADX WARN: Code duplicated, block: B:20:0x0068  */
        /* JADX WARN: Code duplicated, block: B:21:0x006a A[Catch: Exception -> 0x0074, PHI: r5 r11 r15
          0x006a: PHI (r5v3 kotlin.jvm.internal.Ref$ObjectRef) = (r5v4 kotlin.jvm.internal.Ref$ObjectRef), (r5v7 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:19:0x0066, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE]
          0x006a: PHI (r11v2 com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource$getAnnotations$1) = 
          (r11v5 com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource$getAnnotations$1)
          (r11v8 com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource$getAnnotations$1)
         binds: [B:19:0x0066, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE]
          0x006a: PHI (r15v10 java.lang.Object) = (r15v17 java.lang.Object), (r15v0 java.lang.Object) binds: [B:19:0x0066, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {Exception -> 0x0074, blocks: (B:18:0x0062, B:21:0x006a), top: B:71:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x0084  */
        /* JADX WARN: Code duplicated, block: B:32:0x0094  */
        /* JADX WARN: Code duplicated, block: B:35:0x009a  */
        /* JADX WARN: Code duplicated, block: B:36:0x00af  */
        /* JADX WARN: Code duplicated, block: B:40:0x00b9  */
        /* JADX WARN: Code duplicated, block: B:41:0x00bb  */
        /* JADX WARN: Code duplicated, block: B:43:0x00bf  */
        /* JADX WARN: Code duplicated, block: B:63:0x0127  */
        /* JADX WARN: Code duplicated, block: B:65:0x012d  */
        /* JADX WARN: Code duplicated, block: B:67:0x0133  */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
        
            r11 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
        
            r15 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00f8, code lost:
        
            if (r1.emit(r0, r11) == r2) goto L46;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v15, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00f8 -> B:47:0x00fb). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 313
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource.C11091.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static /* synthetic */ Flow getAnnotations$default(AnnotationsRemoteDataSource annotationsRemoteDataSource, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return annotationsRemoteDataSource.getAnnotations(str, str2);
    }

    public final Flow<Result<List<AnnotationDTO>, RemoteError>> getAnnotations(String fileId, String fileVersionId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        return FlowKt.flow(new C11091(fileId, fileVersionId, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteAnnotation(String str, Continuation<? super Result<Unit, ? extends RemoteError>> continuation) {
        C11081 c11081;
        Result.Error error;
        if (continuation instanceof C11081) {
            c11081 = (C11081) continuation;
            if ((c11081.label & Integer.MIN_VALUE) != 0) {
                c11081.label -= Integer.MIN_VALUE;
            } else {
                c11081 = new C11081(continuation);
            }
        } else {
            c11081 = new C11081(continuation);
        }
        Object obj = c11081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11081.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnnotationsRequest annotationsRequest = this.annotationsRequest;
                c11081.L$0 = str;
                c11081.I$0 = 0;
                c11081.I$1 = 0;
                c11081.label = 1;
                if (annotationsRequest.deleteAnnotation(str, c11081) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11081.I$1;
                int i3 = c11081.I$0;
                str = (String) c11081.L$0;
                ResultKt.throwOnFailure(obj);
            }
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception while deleting annotation for " + str, exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createAnnotation(String str, String str2, TargetDTO targetDTO, Continuation<? super Result<AnnotationDTO, ? extends RemoteError>> continuation) {
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
        Object objCreateAnnotation = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateAnnotation);
                AnnotationsRequest annotationsRequest = this.annotationsRequest;
                CreateAnnotationDTO createAnnotationDTO = new CreateAnnotationDTO(new ReferenceDTO(str, "file_version"), new DescriptionDTO(str2), targetDTO);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(targetDTO);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                objCreateAnnotation = annotationsRequest.createAnnotation(createAnnotationDTO, anonymousClass1);
                if (objCreateAnnotation == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(objCreateAnnotation);
            }
            error = new Result.Success((AnnotationDTO) objCreateAnnotation);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception while creating annotation ", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateAnnotation(String str, String str2, Status status, Continuation<? super Result<AnnotationDTO, ? extends RemoteError>> continuation) {
        C11101 c11101;
        Result.Error error;
        if (continuation instanceof C11101) {
            c11101 = (C11101) continuation;
            if ((c11101.label & Integer.MIN_VALUE) != 0) {
                c11101.label -= Integer.MIN_VALUE;
            } else {
                c11101 = new C11101(continuation);
            }
        } else {
            c11101 = new C11101(continuation);
        }
        Object objUpdateAnnotation = c11101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11101.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUpdateAnnotation);
                AnnotationsRequest annotationsRequest = this.annotationsRequest;
                UpdateAnnotationDTO updateAnnotationDTO = new UpdateAnnotationDTO(str2 != null ? new DescriptionDTO(str2) : null, status != null ? status.getValue() : null);
                boolean enabled = this.featureFlips.getFileActivitiesModernization().getEnabled();
                c11101.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11101.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c11101.L$2 = SpillingKt.nullOutSpilledVariable(status);
                c11101.I$0 = 0;
                c11101.I$1 = 0;
                c11101.label = 1;
                objUpdateAnnotation = annotationsRequest.updateAnnotation(str, updateAnnotationDTO, enabled, c11101);
                if (objUpdateAnnotation == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11101.I$1;
                int i3 = c11101.I$0;
                ResultKt.throwOnFailure(objUpdateAnnotation);
            }
            error = new Result.Success((AnnotationDTO) objUpdateAnnotation);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception while updating a comment", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }
}
