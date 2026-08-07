package com.box.android.data.service.impl;

import com.box.android.data.api.models.annotations.AnnotationDTO;
import com.box.android.data.api.models.annotations.Status;
import com.box.android.data.api.models.annotations.TargetDTO;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.annotations.AnnotationsCacheDataSource;
import com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.mappers.annotation.AnnotationDTOEntityMapper;
import com.box.android.data.mappers.annotation.AnnotationEntityDomainMapper;
import com.box.android.data.mappers.annotation.TargetDTOToTargetModelMapper;
import com.box.android.data.persistence.annotations.AnnotationEntity;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.annotations.AnnotationTargetModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.models.annotations.FileVersionIdModel;
import com.box.android.domain.services.IAnnotationsService;
import com.box.android.domain.utils.exceptions.AbortFlowCollectionException;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.squareup.moshi.Moshi;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okio.Utf8;

/* JADX INFO: compiled from: AnnotationsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 92\u00020\u0001:\u00019B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0018JB\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J>\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010$\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fH\u0016J\"\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010$\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130.2\u0006\u0010/\u001a\u000200H\u0002J\u001e\u00101\u001a\u00020)2\u0006\u00102\u001a\u0002032\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u00104J\u001c\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00112\f\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/box/android/data/service/impl/AnnotationsService;", "Lcom/box/android/domain/services/IAnnotationsService;", "annotationsRemoteDataSource", "Lcom/box/android/data/datasource/annotations/AnnotationsRemoteDataSource;", "annotationsCacheDataSource", "Lcom/box/android/data/datasource/annotations/AnnotationsCacheDataSource;", "annotationsDTOEntityMapper", "Lcom/box/android/data/mappers/annotation/AnnotationDTOEntityMapper;", "annotationEntityDomainMapper", "Lcom/box/android/data/mappers/annotation/AnnotationEntityDomainMapper;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/datasource/annotations/AnnotationsRemoteDataSource;Lcom/box/android/data/datasource/annotations/AnnotationsCacheDataSource;Lcom/box/android/data/mappers/annotation/AnnotationDTOEntityMapper;Lcom/box/android/data/mappers/annotation/AnnotationEntityDomainMapper;Lcom/squareup/moshi/Moshi;)V", "annotations", "Lcom/box/android/domain/utils/result/Result;", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "Lcom/box/android/domain/models/DomainError;", "fileVersionIdModel", "Lcom/box/android/domain/models/annotations/FileVersionIdModel;", "fetchAnnotationsFromRemote", "", "(Lcom/box/android/domain/models/annotations/FileVersionIdModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAnnotation", "fileVersionId", "", "fileId", "message", "target", "Lcom/box/android/domain/models/annotations/AnnotationTargetModel;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/annotations/AnnotationTargetModel;Lcom/box/android/domain/models/annotations/AnnotationLocationModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAnnotation", "annotationId", "status", "Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/annotations/FileActivityModel$Status;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAnnotationPayloadSizeNotAboveLimit", "", "annotationTargetModel", "deleteAnnotation", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleException", "Lcom/box/android/domain/utils/result/Result$Error;", "cause", "", "deleteOldAnnotations", "fetchedBefore", "Ljava/util/Date;", "(Ljava/util/Date;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapToAnnotationEntityList", "Lcom/box/android/data/persistence/annotations/AnnotationEntity;", "apiModels", "Lcom/box/android/data/api/models/annotations/AnnotationDTO;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationsService implements IAnnotationsService {
    public static final int ANNOTATION_DRAW_LIMIT = 56320;
    public static final String LOGTAG = "AnnotationsService";
    private final AnnotationEntityDomainMapper annotationEntityDomainMapper;
    private final AnnotationsCacheDataSource annotationsCacheDataSource;
    private final AnnotationDTOEntityMapper annotationsDTOEntityMapper;
    private final AnnotationsRemoteDataSource annotationsRemoteDataSource;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.AnnotationsService$createAnnotation$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnnotationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.AnnotationsService", f = "AnnotationsService.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {103, 109}, m = "createAnnotation", n = {"fileVersionId", "fileId", "message", "target", FirebaseAnalytics.Param.LOCATION, "fileVersionId", "fileId", "message", "target", FirebaseAnalytics.Param.LOCATION, "$this$flatMap$iv", "annotationDTO", "entity", "$i$f$flatMap", "$i$a$-flatMap-AnnotationsService$createAnnotation$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnnotationsService.this.createAnnotation(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.AnnotationsService$deleteAnnotation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.AnnotationsService", f = "AnnotationsService.kt", i = {0, 1, 1, 1, 1, 1}, l = {Token.DEBUGGER, Token.COMMENT}, m = "deleteAnnotation", n = {"annotationId", "annotationId", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-AnnotationsService$deleteAnnotation$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C13931 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13931(Continuation<? super C13931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnnotationsService.this.deleteAnnotation(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.AnnotationsService$deleteOldAnnotations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.AnnotationsService", f = "AnnotationsService.kt", i = {0, 0}, l = {177}, m = "deleteOldAnnotations", n = {"fetchedBefore", "fileVersionId"}, s = {"L$0", "L$1"}, v = 1)
    static final class C13941 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13941(Continuation<? super C13941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnnotationsService.this.deleteOldAnnotations(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.AnnotationsService$fetchAnnotationsFromRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.AnnotationsService", f = "AnnotationsService.kt", i = {0, 0, 0}, l = {92}, m = "fetchAnnotationsFromRemote", n = {"fileVersionIdModel", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "networkOpStartTime"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C13951 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13951(Continuation<? super C13951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnnotationsService.this.fetchAnnotationsFromRemote(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.AnnotationsService$updateAnnotation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.AnnotationsService", f = "AnnotationsService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {123, Token.TARGET}, m = "updateAnnotation", n = {"annotationId", "message", "status", "fileId", "annotationId", "message", "status", "fileId", "$this$map$iv", "annotationDTO", "entity", "$i$f$map", "$i$a$-map-AnnotationsService$updateAnnotation$3"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C13961 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C13961(Continuation<? super C13961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnnotationsService.this.updateAnnotation(null, null, null, null, this);
        }
    }

    @Inject
    public AnnotationsService(AnnotationsRemoteDataSource annotationsRemoteDataSource, AnnotationsCacheDataSource annotationsCacheDataSource, AnnotationDTOEntityMapper annotationsDTOEntityMapper, AnnotationEntityDomainMapper annotationEntityDomainMapper, Moshi moshi) {
        Intrinsics.checkNotNullParameter(annotationsRemoteDataSource, "annotationsRemoteDataSource");
        Intrinsics.checkNotNullParameter(annotationsCacheDataSource, "annotationsCacheDataSource");
        Intrinsics.checkNotNullParameter(annotationsDTOEntityMapper, "annotationsDTOEntityMapper");
        Intrinsics.checkNotNullParameter(annotationEntityDomainMapper, "annotationEntityDomainMapper");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.annotationsRemoteDataSource = annotationsRemoteDataSource;
        this.annotationsCacheDataSource = annotationsCacheDataSource;
        this.annotationsDTOEntityMapper = annotationsDTOEntityMapper;
        this.annotationEntityDomainMapper = annotationEntityDomainMapper;
        this.moshi = moshi;
    }

    @Override // com.box.android.domain.services.IAnnotationsService
    public Result<Flow<List<FileActivityModel.AnnotationModel>>, DomainError> annotations(final FileVersionIdModel fileVersionIdModel) {
        Intrinsics.checkNotNullParameter(fileVersionIdModel, "fileVersionIdModel");
        Result resultAnnotations = this.annotationsCacheDataSource.annotations(fileVersionIdModel.getId());
        if (resultAnnotations instanceof Result.Success) {
            final Flow flow = (Flow) ((Result.Success) resultAnnotations).getValue();
            resultAnnotations = new Result.Success(new Flow<List<? extends FileActivityModel.AnnotationModel>>() { // from class: com.box.android.data.service.impl.AnnotationsService$annotations$lambda$0$$inlined$map$1

                /* JADX INFO: renamed from: com.box.android.data.service.impl.AnnotationsService$annotations$lambda$0$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FileVersionIdModel $fileVersionIdModel$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ AnnotationsService this$0;

                    /* JADX INFO: renamed from: com.box.android.data.service.impl.AnnotationsService$annotations$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.data.service.impl.AnnotationsService$annotations$lambda$0$$inlined$map$1$2", f = "AnnotationsService.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, AnnotationsService annotationsService, FileVersionIdModel fileVersionIdModel) {
                        this.$this_unsafeFlow = flowCollector;
                        this.this$0 = annotationsService;
                        this.$fileVersionIdModel$inlined = fileVersionIdModel;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            ArrayList arrayList = new ArrayList();
                            Iterator<T> it = ((List) obj).iterator();
                            while (it.hasNext()) {
                                FileActivityModel.AnnotationModel domain$default = AnnotationEntityDomainMapper.toDomain$default(this.this$0.annotationEntityDomainMapper, (AnnotationEntity) it.next(), this.$fileVersionIdModel$inlined.getFileId(), null, 4, null);
                                if (domain$default != null) {
                                    arrayList.add(domain$default);
                                }
                            }
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super List<? extends FileActivityModel.AnnotationModel>> flowCollector, Continuation continuation) {
                    Object objCollect = flow.collect(new AnonymousClass2(flowCollector, this, fileVersionIdModel), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            });
        } else if (!(resultAnnotations instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (resultAnnotations instanceof Result.Success) {
            return resultAnnotations;
        }
        if (!(resultAnnotations instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) resultAnnotations).getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IAnnotationsService
    public Object fetchAnnotationsFromRemote(FileVersionIdModel fileVersionIdModel, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C13951 c13951;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C13951) {
            c13951 = (C13951) continuation;
            if ((c13951.label & Integer.MIN_VALUE) != 0) {
                c13951.label -= Integer.MIN_VALUE;
            } else {
                c13951 = new C13951(continuation);
            }
        } else {
            c13951 = new C13951(continuation);
        }
        Object obj = c13951.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13951.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Date date = new Date();
            Flow flowM16356catch = FlowKt.m16356catch(FlowKt.onCompletion(FlowKt.onEach(this.annotationsRemoteDataSource.getAnnotations(fileVersionIdModel.getFileId(), fileVersionIdModel.getId()), new AnonymousClass2(objectRef2, null)), new AnonymousClass3(objectRef2, this, date, fileVersionIdModel, null)), new AnonymousClass4(objectRef2, this, null));
            c13951.L$0 = SpillingKt.nullOutSpilledVariable(fileVersionIdModel);
            c13951.L$1 = objectRef2;
            c13951.L$2 = SpillingKt.nullOutSpilledVariable(date);
            c13951.label = 1;
            if (FlowKt.collect(flowM16356catch, c13951) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c13951.L$1;
            ResultKt.throwOnFailure(obj);
        }
        T t = objectRef.element;
        Intrinsics.checkNotNull(t);
        return t;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.AnnotationsService$fetchAnnotationsFromRemote$2, reason: invalid class name */
    /* JADX INFO: compiled from: AnnotationsService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003H\n"}, d2 = {"<anonymous>", "", "remoteCallResult", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/annotations/AnnotationDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.AnnotationsService$fetchAnnotationsFromRemote$2", f = "AnnotationsService.kt", i = {0, 0, 0, 0, 0}, l = {66}, m = "invokeSuspend", n = {"remoteCallResult", "$this$flatMap$iv", "entities", "$i$f$flatMap", "$i$a$-flatMap-AnnotationsService$fetchAnnotationsFromRemote$2$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Result<? extends List<? extends AnnotationDTO>, ? extends RemoteError>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Result<Unit, DomainError>> $result;
        int I$0;
        int I$1;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<Result<Unit, DomainError>> objectRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$result = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = AnnotationsService.this.new AnonymousClass2(this.$result, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Result<? extends List<AnnotationDTO>, ? extends RemoteError> result, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(result, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Result<? extends List<? extends AnnotationDTO>, ? extends RemoteError> result, Continuation<? super Unit> continuation) {
            return invoke2((Result<? extends List<AnnotationDTO>, ? extends RemoteError>) result, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0086  */
        /* JADX WARN: Code duplicated, block: B:27:0x008a  */
        /* JADX WARN: Code duplicated, block: B:30:0x00ad  */
        /* JADX WARN: Code duplicated, block: B:32:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:34:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:36:0x00cb  */
        /* JADX WARN: Code duplicated, block: B:38:0x00ce  */
        /* JADX WARN: Type inference failed for: r6v12, types: [T, com.box.android.domain.utils.result.Result$Error] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws AbortFlowCollectionException {
            Result.Success success;
            Ref.ObjectRef<Result<Unit, DomainError>> objectRef;
            Result result = (Result) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnnotationsService annotationsService = AnnotationsService.this;
                if (result instanceof Result.Success) {
                    success = new Result.Success(annotationsService.mapToAnnotationEntityList((List) ((Result.Success) result).getValue()));
                } else {
                    if (!(result instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    success = result;
                }
                AnnotationsService annotationsService2 = AnnotationsService.this;
                if (success instanceof Result.Success) {
                    List<AnnotationEntity> list = (List) ((Result.Success) success).getValue();
                    AnnotationsCacheDataSource annotationsCacheDataSource = annotationsService2.annotationsCacheDataSource;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(success);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(list);
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    obj = annotationsCacheDataSource.saveAnnotation(list, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(success instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!(success instanceof Result.Success)) {
                    if (success instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    success = new Result.Error(new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((IGenericError) ((Result.Error) success).getValue(), "Unknown error while fetching annotations")));
                }
                objectRef = this.$result;
                if (!(success instanceof Result.Success)) {
                    return Unit.INSTANCE;
                }
                if (success instanceof Result.Error) {
                    objectRef.element = (Result.Error) ((Result.Error) success).getValue();
                    throw new AbortFlowCollectionException("Abort flow processing", null, 2, null);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            success = (Result) obj;
            if (!(success instanceof Result.Success)) {
                if (success instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                success = new Result.Error(new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((IGenericError) ((Result.Error) success).getValue(), "Unknown error while fetching annotations")));
            }
            objectRef = this.$result;
            if (!(success instanceof Result.Success)) {
                return Unit.INSTANCE;
            }
            if (success instanceof Result.Error) {
                objectRef.element = (Result.Error) ((Result.Error) success).getValue();
                throw new AbortFlowCollectionException("Abort flow processing", null, 2, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.AnnotationsService$fetchAnnotationsFromRemote$3, reason: invalid class name */
    /* JADX INFO: compiled from: AnnotationsService.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/annotations/AnnotationDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "cause", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.AnnotationsService$fetchAnnotationsFromRemote$3", f = "AnnotationsService.kt", i = {0}, l = {85}, m = "invokeSuspend", n = {"cause"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends AnnotationDTO>, ? extends RemoteError>>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ FileVersionIdModel $fileVersionIdModel;
        final /* synthetic */ Date $networkOpStartTime;
        final /* synthetic */ Ref.ObjectRef<Result<Unit, DomainError>> $result;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnnotationsService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Ref.ObjectRef<Result<Unit, DomainError>> objectRef, AnnotationsService annotationsService, Date date, FileVersionIdModel fileVersionIdModel, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.$result = objectRef;
            this.this$0 = annotationsService;
            this.$networkOpStartTime = date;
            this.$fileVersionIdModel = fileVersionIdModel;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends List<? extends AnnotationDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<? extends List<AnnotationDTO>, ? extends RemoteError>>) flowCollector, th, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<? extends List<AnnotationDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$result, this.this$0, this.$networkOpStartTime, this.$fileVersionIdModel, continuation);
            anonymousClass3.L$0 = th;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r7v5, types: [T, com.box.android.domain.utils.result.Result$Success] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th = (Throwable) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (th == null && this.$result.element == null) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(th);
                    this.label = 1;
                    if (this.this$0.deleteOldAnnotations(this.$networkOpStartTime, this.$fileVersionIdModel.getId(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$result.element = new Result.Success(Unit.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.AnnotationsService$fetchAnnotationsFromRemote$4, reason: invalid class name */
    /* JADX INFO: compiled from: AnnotationsService.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/annotations/AnnotationDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "cause", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.AnnotationsService$fetchAnnotationsFromRemote$4", f = "AnnotationsService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends AnnotationDTO>, ? extends RemoteError>>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Result<Unit, DomainError>> $result;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnnotationsService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Ref.ObjectRef<Result<Unit, DomainError>> objectRef, AnnotationsService annotationsService, Continuation<? super AnonymousClass4> continuation) {
            super(3, continuation);
            this.$result = objectRef;
            this.this$0 = annotationsService;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends List<? extends AnnotationDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<? extends List<AnnotationDTO>, ? extends RemoteError>>) flowCollector, th, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<? extends List<AnnotationDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$result, this.this$0, continuation);
            anonymousClass4.L$0 = th;
            return anonymousClass4.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            T tHandleException;
            Throwable th = (Throwable) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<Result<Unit, DomainError>> objectRef = this.$result;
            Result<Unit, DomainError> result = objectRef.element;
            if (result == null) {
                tHandleException = result;
                tHandleException = this.this$0.handleException(th);
            }
            tHandleException = result;
            objectRef.element = tHandleException;
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0106  */
    /* JADX WARN: Code duplicated, block: B:29:0x0127  */
    /* JADX WARN: Code duplicated, block: B:32:0x012c  */
    /* JADX WARN: Code duplicated, block: B:38:0x013a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x013b  */
    /* JADX WARN: Code duplicated, block: B:41:0x013f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0157  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Override // com.box.android.domain.services.IAnnotationsService
    public Object createAnnotation(String str, String str2, String str3, AnnotationTargetModel annotationTargetModel, AnnotationLocationModel annotationLocationModel, Continuation<? super Result<FileActivityModel.AnnotationModel, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        AnnotationLocationModel annotationLocationModel2;
        String str4;
        AnnotationTargetModel annotationTargetModel2;
        String str5;
        Result success;
        String str6;
        AnnotationEntity annotationEntity;
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
        if (i != 0) {
            if (i == 1) {
                AnnotationLocationModel annotationLocationModel3 = (AnnotationLocationModel) anonymousClass1.L$4;
                annotationTargetModel2 = (AnnotationTargetModel) anonymousClass1.L$3;
                str4 = (String) anonymousClass1.L$2;
                str5 = (String) anonymousClass1.L$1;
                String str7 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objCreateAnnotation);
                annotationLocationModel2 = annotationLocationModel3;
                str = str7;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                annotationEntity = (AnnotationEntity) anonymousClass1.L$7;
                str6 = (String) anonymousClass1.L$1;
                ResultKt.throwOnFailure(objCreateAnnotation);
            }
            success = (Result) objCreateAnnotation;
            if (success instanceof Result.Success) {
                success = new Result.Success(AnnotationEntityDomainMapper.toDomain$default(this.annotationEntityDomainMapper, annotationEntity, str6, null, 4, null));
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (success instanceof Result.Success) {
                return success;
            }
            if (success instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((IGenericError) ((Result.Error) success).getValue(), "Unknown error while creating annotation!"));
        }
        ResultKt.throwOnFailure(objCreateAnnotation);
        AnnotationsRemoteDataSource annotationsRemoteDataSource = this.annotationsRemoteDataSource;
        annotationLocationModel2 = annotationLocationModel;
        TargetDTO targetDTOFromDomain = TargetDTOToTargetModelMapper.INSTANCE.fromDomain(annotationTargetModel, annotationLocationModel2);
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
        anonymousClass1.L$1 = str2;
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str3);
        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(annotationTargetModel);
        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(annotationLocationModel2);
        anonymousClass1.label = 1;
        str4 = str3;
        objCreateAnnotation = annotationsRemoteDataSource.createAnnotation(str, str4, targetDTOFromDomain, anonymousClass1);
        if (objCreateAnnotation != coroutine_suspended) {
            annotationTargetModel2 = annotationTargetModel;
            str5 = str2;
        }
        return coroutine_suspended;
        success = (Result) objCreateAnnotation;
        if (success instanceof Result.Success) {
            AnnotationDTO annotationDTO = (AnnotationDTO) ((Result.Success) success).getValue();
            AnnotationEntity entity = this.annotationsDTOEntityMapper.toEntity(annotationDTO);
            AnnotationsCacheDataSource annotationsCacheDataSource = this.annotationsCacheDataSource;
            List<AnnotationEntity> listListOf = CollectionsKt.listOf(entity);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$1 = str5;
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str4);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(annotationTargetModel2);
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(annotationLocationModel2);
            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(success);
            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(annotationDTO);
            anonymousClass1.L$7 = entity;
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 2;
            objCreateAnnotation = annotationsCacheDataSource.saveAnnotation(listListOf, anonymousClass1);
            if (objCreateAnnotation != coroutine_suspended) {
                str6 = str5;
                annotationEntity = entity;
                success = (Result) objCreateAnnotation;
                if (success instanceof Result.Success) {
                    success = new Result.Success(AnnotationEntityDomainMapper.toDomain$default(this.annotationEntityDomainMapper, annotationEntity, str6, null, 4, null));
                } else if (!(success instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return coroutine_suspended;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((IGenericError) ((Result.Error) success).getValue(), "Unknown error while creating annotation!"));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x010f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0110  */
    /* JADX WARN: Code duplicated, block: B:38:0x0114  */
    /* JADX WARN: Code duplicated, block: B:40:0x013b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Override // com.box.android.domain.services.IAnnotationsService
    public Object updateAnnotation(String str, String str2, FileActivityModel.Status status, String str3, Continuation<? super Result<FileActivityModel.AnnotationModel, ? extends DomainError>> continuation) {
        C13961 c13961;
        String str4;
        String str5;
        String str6;
        FileActivityModel.Status status2;
        Result.Success success;
        String str7;
        String str8;
        AnnotationEntity annotationEntity;
        if (continuation instanceof C13961) {
            c13961 = (C13961) continuation;
            if ((c13961.label & Integer.MIN_VALUE) != 0) {
                c13961.label -= Integer.MIN_VALUE;
            } else {
                c13961 = new C13961(continuation);
            }
        } else {
            c13961 = new C13961(continuation);
        }
        Object objUpdateAnnotation = c13961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13961.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUpdateAnnotation);
            AnnotationsRemoteDataSource annotationsRemoteDataSource = this.annotationsRemoteDataSource;
            Status statusValueOf = status != null ? Status.valueOf(status.toString()) : null;
            c13961.L$0 = str;
            c13961.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c13961.L$2 = SpillingKt.nullOutSpilledVariable(status);
            str4 = str3;
            c13961.L$3 = str4;
            c13961.label = 1;
            str5 = str2;
            objUpdateAnnotation = annotationsRemoteDataSource.updateAnnotation(str, str5, statusValueOf, c13961);
            if (objUpdateAnnotation != coroutine_suspended) {
                str6 = str;
                status2 = status;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            String str9 = (String) c13961.L$3;
            status2 = (FileActivityModel.Status) c13961.L$2;
            str5 = (String) c13961.L$1;
            String str10 = (String) c13961.L$0;
            ResultKt.throwOnFailure(objUpdateAnnotation);
            str4 = str9;
            str6 = str10;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c13961.I$1;
            int i3 = c13961.I$0;
            annotationEntity = (AnnotationEntity) c13961.L$6;
            str8 = (String) c13961.L$3;
            str7 = (String) c13961.L$0;
            ResultKt.throwOnFailure(objUpdateAnnotation);
        }
        success = new Result.Success(AnnotationEntityDomainMapper.toDomain$default(this.annotationEntityDomainMapper, annotationEntity, str8, null, 4, null));
        str6 = str7;
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while updating annotation " + str6));
        success = (Result) objUpdateAnnotation;
        if (success instanceof Result.Success) {
            AnnotationDTO annotationDTO = (AnnotationDTO) ((Result.Success) success).getValue();
            AnnotationEntity entity = this.annotationsDTOEntityMapper.toEntity(annotationDTO);
            AnnotationsCacheDataSource annotationsCacheDataSource = this.annotationsCacheDataSource;
            List<AnnotationEntity> listListOf = CollectionsKt.listOf(entity);
            c13961.L$0 = str6;
            c13961.L$1 = SpillingKt.nullOutSpilledVariable(str5);
            c13961.L$2 = SpillingKt.nullOutSpilledVariable(status2);
            c13961.L$3 = str4;
            c13961.L$4 = SpillingKt.nullOutSpilledVariable(success);
            c13961.L$5 = SpillingKt.nullOutSpilledVariable(annotationDTO);
            c13961.L$6 = entity;
            c13961.I$0 = 0;
            c13961.I$1 = 0;
            c13961.label = 2;
            if (annotationsCacheDataSource.saveAnnotation(listListOf, c13961) != coroutine_suspended) {
                str7 = str6;
                str8 = str4;
                annotationEntity = entity;
                success = new Result.Success(AnnotationEntityDomainMapper.toDomain$default(this.annotationEntityDomainMapper, annotationEntity, str8, null, 4, null));
                str6 = str7;
            }
            return coroutine_suspended;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while updating annotation " + str6));
    }

    @Override // com.box.android.domain.services.IAnnotationsService
    public boolean isAnnotationPayloadSizeNotAboveLimit(AnnotationTargetModel annotationTargetModel) throws UnsupportedEncodingException {
        Intrinsics.checkNotNullParameter(annotationTargetModel, "annotationTargetModel");
        String strEncode = URLEncoder.encode(this.moshi.adapter(TargetDTO.class).toJson(TargetDTOToTargetModelMapper.INSTANCE.fromDomain(annotationTargetModel, new AnnotationLocationModel.Page(1))), "UTF-8");
        Intrinsics.checkNotNull(strEncode);
        return Utf8.size$default(strEncode, 0, 0, 3, null) < 56320;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0091 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0092  */
    /* JADX WARN: Code duplicated, block: B:33:0x0096  */
    /* JADX WARN: Code duplicated, block: B:35:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IAnnotationsService
    public Object deleteAnnotation(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C13931 c13931;
        Result result;
        Result result2;
        if (continuation instanceof C13931) {
            c13931 = (C13931) continuation;
            if ((c13931.label & Integer.MIN_VALUE) != 0) {
                c13931.label -= Integer.MIN_VALUE;
            } else {
                c13931 = new C13931(continuation);
            }
        } else {
            c13931 = new C13931(continuation);
        }
        Object objDeleteAnnotation = c13931.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13931.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeleteAnnotation);
            AnnotationsRemoteDataSource annotationsRemoteDataSource = this.annotationsRemoteDataSource;
            c13931.L$0 = str;
            c13931.label = 1;
            objDeleteAnnotation = annotationsRemoteDataSource.deleteAnnotation(str, c13931);
            if (objDeleteAnnotation != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            str = (String) c13931.L$0;
            ResultKt.throwOnFailure(objDeleteAnnotation);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c13931.I$1;
            int i3 = c13931.I$0;
            result2 = (Result) c13931.L$1;
            str = (String) c13931.L$0;
            ResultKt.throwOnFailure(objDeleteAnnotation);
        }
        result = result2;
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) result).getValue(), "Unknown error while deleting annotation " + str));
        result = (Result) objDeleteAnnotation;
        if (result instanceof Result.Success) {
            Unit unit = (Unit) ((Result.Success) result).getValue();
            AnnotationsCacheDataSource annotationsCacheDataSource = this.annotationsCacheDataSource;
            c13931.L$0 = str;
            c13931.L$1 = result;
            c13931.L$2 = SpillingKt.nullOutSpilledVariable(unit);
            c13931.I$0 = 0;
            c13931.I$1 = 0;
            c13931.label = 2;
            if (annotationsCacheDataSource.deleteAnnotation(str, c13931) != coroutine_suspended) {
                result2 = result;
                result = result2;
            }
            return coroutine_suspended;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) result).getValue(), "Unknown error while deleting annotation " + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result.Error<DomainError> handleException(Throwable cause) {
        BoxLogUtils.e(LOGTAG, cause);
        String message = cause.getMessage();
        if (message == null) {
            message = MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR;
        }
        return new Result.Error<>(new DomainError.UnknownError(message));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteOldAnnotations(Date date, String str, Continuation<? super Boolean> continuation) {
        C13941 c13941;
        if (continuation instanceof C13941) {
            c13941 = (C13941) continuation;
            if ((c13941.label & Integer.MIN_VALUE) != 0) {
                c13941.label -= Integer.MIN_VALUE;
            } else {
                c13941 = new C13941(continuation);
            }
        } else {
            c13941 = new C13941(continuation);
        }
        Object objDeleteAnnotations = c13941.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13941.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeleteAnnotations);
            AnnotationsCacheDataSource annotationsCacheDataSource = this.annotationsCacheDataSource;
            c13941.L$0 = SpillingKt.nullOutSpilledVariable(date);
            c13941.L$1 = SpillingKt.nullOutSpilledVariable(str);
            c13941.label = 1;
            objDeleteAnnotations = annotationsCacheDataSource.deleteAnnotations(date, str, c13941);
            if (objDeleteAnnotations == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objDeleteAnnotations);
        }
        return Boxing.boxBoolean(((Number) objDeleteAnnotations).intValue() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AnnotationEntity> mapToAnnotationEntityList(List<AnnotationDTO> apiModels) {
        List<AnnotationDTO> list = apiModels;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.annotationsDTOEntityMapper.toEntity((AnnotationDTO) it.next()));
        }
        return arrayList;
    }
}
