package com.box.android.domain.usecases.fileactivities.annotation;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.annotations.AnnotationTargetModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.services.IAnnotationsService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateAnnotationInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JB\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/domain/usecases/fileactivities/annotation/CreateAnnotationInteractor;", "", "annotationService", "Lcom/box/android/domain/services/IAnnotationsService;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "<init>", "(Lcom/box/android/domain/services/IAnnotationsService;Lcom/box/android/domain/services/IRemoteItemService;)V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "Lcom/box/android/domain/models/DomainError;", "fileVersionId", "", "fileId", "Lcom/box/android/domain/models/ItemId;", "message", "targetModel", "Lcom/box/android/domain/models/annotations/AnnotationTargetModel;", "locationModel", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lcom/box/android/domain/models/annotations/AnnotationTargetModel;Lcom/box/android/domain/models/annotations/AnnotationLocationModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSizeNotAboveLimit", "", "annotationTargetModel", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateAnnotationInteractor {
    private final IAnnotationsService annotationService;
    private final IRemoteItemService itemService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.fileactivities.annotation.CreateAnnotationInteractor$create$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateAnnotationInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.fileactivities.annotation.CreateAnnotationInteractor", f = "CreateAnnotationInteractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {24, 34}, m = PasskeyWebListener.CREATE_UNIQUE_KEY, n = {"fileVersionId", "fileId", "message", "targetModel", "locationModel", "fileVersionId", "fileId", "message", "targetModel", "locationModel", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$create_u24lambda_u240", "$i$a$-runCatching-CreateAnnotationInteractor$create$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateAnnotationInteractor.this.create(null, null, null, null, null, this);
        }
    }

    @Inject
    public CreateAnnotationInteractor(IAnnotationsService annotationService, IRemoteItemService itemService) {
        Intrinsics.checkNotNullParameter(annotationService, "annotationService");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        this.annotationService = annotationService;
        this.itemService = itemService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object create(String str, ItemId itemId, String str2, AnnotationTargetModel annotationTargetModel, AnnotationLocationModel annotationLocationModel, Continuation<? super Result<FileActivityModel.AnnotationModel, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        AnnotationLocationModel annotationLocationModel2;
        Object obj;
        AnnotationTargetModel annotationTargetModel2;
        Throwable th;
        Result result;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objUpdateCacheItemFromRemote = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUpdateCacheItemFromRemote);
            IAnnotationsService iAnnotationsService = this.annotationService;
            String string = itemId.toString();
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass2.L$1 = itemId;
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(annotationTargetModel);
            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(annotationLocationModel);
            anonymousClass2.label = 1;
            Object objCreateAnnotation = iAnnotationsService.createAnnotation(str, string, str2, annotationTargetModel, annotationLocationModel, anonymousClass2);
            if (objCreateAnnotation != coroutine_suspended) {
                annotationLocationModel2 = annotationLocationModel;
                obj = objCreateAnnotation;
                annotationTargetModel2 = annotationTargetModel;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass2.I$0;
            result = (Result) anonymousClass2.L$5;
            try {
                ResultKt.throwOnFailure(objUpdateCacheItemFromRemote);
                kotlin.Result.m14780constructorimpl((Result) objUpdateCacheItemFromRemote);
            } catch (Throwable th2) {
                th = th2;
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                kotlin.Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
            return new Result.Success(((Result.Success) result).getValue());
        }
        AnnotationLocationModel annotationLocationModel3 = (AnnotationLocationModel) anonymousClass2.L$4;
        AnnotationTargetModel annotationTargetModel3 = (AnnotationTargetModel) anonymousClass2.L$3;
        str2 = (String) anonymousClass2.L$2;
        ItemId itemId2 = (ItemId) anonymousClass2.L$1;
        String str3 = (String) anonymousClass2.L$0;
        ResultKt.throwOnFailure(objUpdateCacheItemFromRemote);
        annotationLocationModel2 = annotationLocationModel3;
        str = str3;
        obj = objUpdateCacheItemFromRemote;
        annotationTargetModel2 = annotationTargetModel3;
        itemId = itemId2;
        Result result2 = (Result) obj;
        if (result2 instanceof Result.Success) {
            try {
                kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
                CreateAnnotationInteractor createAnnotationInteractor = this;
                IRemoteItemService iRemoteItemService = this.itemService;
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(itemId);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(annotationTargetModel2);
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(annotationLocationModel2);
                anonymousClass2.L$5 = result2;
                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(this);
                anonymousClass2.I$0 = 0;
                anonymousClass2.label = 2;
                objUpdateCacheItemFromRemote = iRemoteItemService.updateCacheItemFromRemote(itemId, anonymousClass2);
                if (objUpdateCacheItemFromRemote != coroutine_suspended) {
                    result = result2;
                    kotlin.Result.m14780constructorimpl((Result) objUpdateCacheItemFromRemote);
                    return new Result.Success(((Result.Success) result).getValue());
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                th = th3;
                result = result2;
                kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
                kotlin.Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            if (result2 instanceof Result.Error) {
                return new Result.Error(((Result.Error) result2).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isSizeNotAboveLimit(AnnotationTargetModel annotationTargetModel) {
        Intrinsics.checkNotNullParameter(annotationTargetModel, "annotationTargetModel");
        return this.annotationService.isAnnotationPayloadSizeNotAboveLimit(annotationTargetModel);
    }
}
