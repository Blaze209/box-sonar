package com.box.android.data.service.impl.preview.helpers;

import androidx.core.app.NotificationCompat;
import com.box.android.domain.metrics.preview.units.FileWithRepresentationsFetchObservability;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.RepresentationType;
import com.box.android.domain.services.FileWithRepresentationsResult;
import com.box.android.domain.services.IFileWithRepresentationsService;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.ArrayList;
import java.util.List;
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

/* JADX INFO: compiled from: PreviewFileWithRepresentationsWrapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsWrapper;", "", "observability", "Lcom/box/android/domain/metrics/preview/units/FileWithRepresentationsFetchObservability;", NotificationCompat.CATEGORY_SERVICE, "Lcom/box/android/domain/services/IFileWithRepresentationsService;", "<init>", "(Lcom/box/android/domain/metrics/preview/units/FileWithRepresentationsFetchObservability;Lcom/box/android/domain/services/IFileWithRepresentationsService;)V", RemoteConfigComponent.FETCH_FILE_NAME, "Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsResult;", "itemId", "Lcom/box/android/domain/models/ItemId;", "observabilityId", "", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterNotRequiredNetworkConnection", "", "Lcom/box/android/domain/models/RepresentationModel;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewFileWithRepresentationsWrapper {
    private final FileWithRepresentationsFetchObservability observability;
    private final IFileWithRepresentationsService service;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.helpers.PreviewFileWithRepresentationsWrapper$fetch$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewFileWithRepresentationsWrapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.helpers.PreviewFileWithRepresentationsWrapper", f = "PreviewFileWithRepresentationsWrapper.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5}, l = {29, 30, 34, 39, 44, 60}, m = RemoteConfigComponent.FETCH_FILE_NAME, n = {"itemId", "observabilityId", "itemId", "observabilityId", "itemId", "observabilityId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "remoteFetchError", "itemId", "observabilityId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "remoteFetchError", "itemId", "observabilityId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "remoteFetchError", "itemId", "observabilityId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "remoteFetchError"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewFileWithRepresentationsWrapper.this.fetch(null, null, this);
        }
    }

    @Inject
    public PreviewFileWithRepresentationsWrapper(FileWithRepresentationsFetchObservability observability, IFileWithRepresentationsService service) {
        Intrinsics.checkNotNullParameter(observability, "observability");
        Intrinsics.checkNotNullParameter(service, "service");
        this.observability = observability;
        this.service = service;
    }

    public static /* synthetic */ Object fetch$default(PreviewFileWithRepresentationsWrapper previewFileWithRepresentationsWrapper, ItemId itemId, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return previewFileWithRepresentationsWrapper.fetch(itemId, str, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:27:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:30:0x00d8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:41:0x010c  */
    /* JADX WARN: Code duplicated, block: B:44:0x012d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0143  */
    /* JADX WARN: Code duplicated, block: B:49:0x0147  */
    /* JADX WARN: Code duplicated, block: B:52:0x0167  */
    /* JADX WARN: Code duplicated, block: B:55:0x0174  */
    /* JADX WARN: Code duplicated, block: B:56:0x017d  */
    /* JADX WARN: Code duplicated, block: B:59:0x0191  */
    /* JADX WARN: Code duplicated, block: B:61:0x0195  */
    /* JADX WARN: Code duplicated, block: B:64:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:67:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetch(ItemId itemId, String str, Continuation<? super PreviewFileWithRepresentationsResult> continuation) {
        AnonymousClass1 anonymousClass1;
        ItemId itemId2;
        String str2;
        ItemId itemId3;
        FileWithRepresentationsResult fileWithRepresentationsResult;
        DomainError remoteError;
        FileWithRepresentationsFetchObservability fileWithRepresentationsFetchObservability;
        DomainError remoteFetchError;
        FileWithRepresentationsResult fileWithRepresentationsResult2;
        FileWithRepresentationsFetchObservability fileWithRepresentationsFetchObservability2;
        FileWithRepresentationsResult fileWithRepresentationsResult3;
        FileWithRepresentationsFetchObservability fileWithRepresentationsFetchObservability3;
        FileWithRepresentationsResult fileWithRepresentationsResult4;
        DomainError domainError;
        FileWithRepresentationsResult.Cached cached;
        List<RepresentationModel> cachedRepresentations;
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
        Object objFetchFileWithRepresentations$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = 2;
        switch (anonymousClass2.label) {
            case 0:
                ResultKt.throwOnFailure(objFetchFileWithRepresentations$default);
                FileWithRepresentationsFetchObservability fileWithRepresentationsFetchObservability4 = this.observability;
                anonymousClass2.L$0 = itemId;
                anonymousClass2.L$1 = str;
                anonymousClass2.label = 1;
                if (fileWithRepresentationsFetchObservability4.fileWithRepresentationsFetchStarted(str, anonymousClass2) != coroutine_suspended) {
                    itemId2 = itemId;
                    IFileWithRepresentationsService iFileWithRepresentationsService = this.service;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                    anonymousClass2.L$1 = str;
                    anonymousClass2.label = 2;
                    objFetchFileWithRepresentations$default = IFileWithRepresentationsService.fetchFileWithRepresentations$default(iFileWithRepresentationsService, itemId2, false, anonymousClass2, 2, null);
                    if (objFetchFileWithRepresentations$default != coroutine_suspended) {
                        str2 = str;
                        itemId3 = itemId2;
                        fileWithRepresentationsResult = (FileWithRepresentationsResult) objFetchFileWithRepresentations$default;
                        remoteError = PreviewFileWithRepresentationsWrapperKt.getRemoteError(fileWithRepresentationsResult);
                        if ((remoteError == null && DomainErrorKt.isItemNotFoundError(remoteError)) || (remoteError != null && DomainErrorKt.isAuthError(remoteError))) {
                            FileWithRepresentationsFetchObservability fileWithRepresentationsFetchObservability5 = this.observability;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(fileWithRepresentationsResult);
                            anonymousClass2.L$3 = remoteError;
                            anonymousClass2.label = 3;
                            if (fileWithRepresentationsFetchObservability5.fileWithRepresentationsFetchError(str2, remoteError, anonymousClass2) != coroutine_suspended) {
                                domainError = remoteError;
                                return new PreviewFileWithRepresentationsResult.Error(domainError, true);
                            }
                        } else if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Success) {
                            fileWithRepresentationsFetchObservability3 = this.observability;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                            anonymousClass2.L$2 = fileWithRepresentationsResult;
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                            anonymousClass2.label = 4;
                            if (fileWithRepresentationsFetchObservability3.fileWithRepresentationsFetchSuccessRemote(str2, anonymousClass2) != coroutine_suspended) {
                                fileWithRepresentationsResult4 = fileWithRepresentationsResult;
                                FileWithRepresentationsResult.Success success = (FileWithRepresentationsResult.Success) fileWithRepresentationsResult4;
                                return new PreviewFileWithRepresentationsResult.Success(success.getFileModel(), success.getRepresentations(), null, 4, null);
                            }
                        } else if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Cached) {
                            fileWithRepresentationsFetchObservability2 = this.observability;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                            anonymousClass2.L$2 = fileWithRepresentationsResult;
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                            anonymousClass2.label = 5;
                            if (fileWithRepresentationsFetchObservability2.fileWithRepresentationsFetchSuccessCache(str2, anonymousClass2) != coroutine_suspended) {
                                fileWithRepresentationsResult3 = fileWithRepresentationsResult;
                                cached = (FileWithRepresentationsResult.Cached) fileWithRepresentationsResult3;
                                if (DomainErrorKt.isNetworkConnectionError(cached.getRemoteFetchError())) {
                                    cachedRepresentations = filterNotRequiredNetworkConnection(cached.getCachedRepresentations());
                                } else {
                                    cachedRepresentations = cached.getCachedRepresentations();
                                }
                                return new PreviewFileWithRepresentationsResult.Success(cached.getCachedFileModel(), cachedRepresentations, cached.getRemoteFetchError());
                            }
                        } else {
                            if (!(fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            fileWithRepresentationsFetchObservability = this.observability;
                            remoteFetchError = ((FileWithRepresentationsResult.Error) fileWithRepresentationsResult).getRemoteFetchError();
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                            anonymousClass2.L$2 = fileWithRepresentationsResult;
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                            anonymousClass2.label = 6;
                            if (fileWithRepresentationsFetchObservability.fileWithRepresentationsFetchError(str2, remoteFetchError, anonymousClass2) != coroutine_suspended) {
                                fileWithRepresentationsResult2 = fileWithRepresentationsResult;
                                return new PreviewFileWithRepresentationsResult.Error(((FileWithRepresentationsResult.Error) fileWithRepresentationsResult2).getRemoteFetchError(), false, i, null);
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                str = (String) anonymousClass2.L$1;
                itemId = (ItemId) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objFetchFileWithRepresentations$default);
                itemId2 = itemId;
                IFileWithRepresentationsService iFileWithRepresentationsService2 = this.service;
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                anonymousClass2.L$1 = str;
                anonymousClass2.label = 2;
                objFetchFileWithRepresentations$default = IFileWithRepresentationsService.fetchFileWithRepresentations$default(iFileWithRepresentationsService2, itemId2, false, anonymousClass2, 2, null);
                if (objFetchFileWithRepresentations$default != coroutine_suspended) {
                    str2 = str;
                    itemId3 = itemId2;
                    fileWithRepresentationsResult = (FileWithRepresentationsResult) objFetchFileWithRepresentations$default;
                    remoteError = PreviewFileWithRepresentationsWrapperKt.getRemoteError(fileWithRepresentationsResult);
                    if (remoteError == null) {
                        if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Success) {
                            fileWithRepresentationsFetchObservability3 = this.observability;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                            anonymousClass2.L$2 = fileWithRepresentationsResult;
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                            anonymousClass2.label = 4;
                            if (fileWithRepresentationsFetchObservability3.fileWithRepresentationsFetchSuccessRemote(str2, anonymousClass2) != coroutine_suspended) {
                                fileWithRepresentationsResult4 = fileWithRepresentationsResult;
                                FileWithRepresentationsResult.Success success2 = (FileWithRepresentationsResult.Success) fileWithRepresentationsResult4;
                                return new PreviewFileWithRepresentationsResult.Success(success2.getFileModel(), success2.getRepresentations(), null, 4, null);
                            }
                        } else if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Cached) {
                            fileWithRepresentationsFetchObservability2 = this.observability;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                            anonymousClass2.L$2 = fileWithRepresentationsResult;
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                            anonymousClass2.label = 5;
                            if (fileWithRepresentationsFetchObservability2.fileWithRepresentationsFetchSuccessCache(str2, anonymousClass2) != coroutine_suspended) {
                                fileWithRepresentationsResult3 = fileWithRepresentationsResult;
                                cached = (FileWithRepresentationsResult.Cached) fileWithRepresentationsResult3;
                                if (DomainErrorKt.isNetworkConnectionError(cached.getRemoteFetchError())) {
                                    cachedRepresentations = filterNotRequiredNetworkConnection(cached.getCachedRepresentations());
                                } else {
                                    cachedRepresentations = cached.getCachedRepresentations();
                                }
                                return new PreviewFileWithRepresentationsResult.Success(cached.getCachedFileModel(), cachedRepresentations, cached.getRemoteFetchError());
                            }
                        } else {
                            if (!(fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            fileWithRepresentationsFetchObservability = this.observability;
                            remoteFetchError = ((FileWithRepresentationsResult.Error) fileWithRepresentationsResult).getRemoteFetchError();
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                            anonymousClass2.L$2 = fileWithRepresentationsResult;
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                            anonymousClass2.label = 6;
                            if (fileWithRepresentationsFetchObservability.fileWithRepresentationsFetchError(str2, remoteFetchError, anonymousClass2) != coroutine_suspended) {
                                fileWithRepresentationsResult2 = fileWithRepresentationsResult;
                                return new PreviewFileWithRepresentationsResult.Error(((FileWithRepresentationsResult.Error) fileWithRepresentationsResult2).getRemoteFetchError(), false, i, null);
                            }
                        }
                    } else if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Success) {
                        fileWithRepresentationsFetchObservability3 = this.observability;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                        anonymousClass2.L$2 = fileWithRepresentationsResult;
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                        anonymousClass2.label = 4;
                        if (fileWithRepresentationsFetchObservability3.fileWithRepresentationsFetchSuccessRemote(str2, anonymousClass2) != coroutine_suspended) {
                            fileWithRepresentationsResult4 = fileWithRepresentationsResult;
                            FileWithRepresentationsResult.Success success3 = (FileWithRepresentationsResult.Success) fileWithRepresentationsResult4;
                            return new PreviewFileWithRepresentationsResult.Success(success3.getFileModel(), success3.getRepresentations(), null, 4, null);
                        }
                    } else if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Cached) {
                        fileWithRepresentationsFetchObservability2 = this.observability;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                        anonymousClass2.L$2 = fileWithRepresentationsResult;
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                        anonymousClass2.label = 5;
                        if (fileWithRepresentationsFetchObservability2.fileWithRepresentationsFetchSuccessCache(str2, anonymousClass2) != coroutine_suspended) {
                            fileWithRepresentationsResult3 = fileWithRepresentationsResult;
                            cached = (FileWithRepresentationsResult.Cached) fileWithRepresentationsResult3;
                            if (DomainErrorKt.isNetworkConnectionError(cached.getRemoteFetchError())) {
                                cachedRepresentations = filterNotRequiredNetworkConnection(cached.getCachedRepresentations());
                            } else {
                                cachedRepresentations = cached.getCachedRepresentations();
                            }
                            return new PreviewFileWithRepresentationsResult.Success(cached.getCachedFileModel(), cachedRepresentations, cached.getRemoteFetchError());
                        }
                    } else {
                        if (!(fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        fileWithRepresentationsFetchObservability = this.observability;
                        remoteFetchError = ((FileWithRepresentationsResult.Error) fileWithRepresentationsResult).getRemoteFetchError();
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                        anonymousClass2.L$2 = fileWithRepresentationsResult;
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                        anonymousClass2.label = 6;
                        if (fileWithRepresentationsFetchObservability.fileWithRepresentationsFetchError(str2, remoteFetchError, anonymousClass2) != coroutine_suspended) {
                            fileWithRepresentationsResult2 = fileWithRepresentationsResult;
                            return new PreviewFileWithRepresentationsResult.Error(((FileWithRepresentationsResult.Error) fileWithRepresentationsResult2).getRemoteFetchError(), false, i, null);
                        }
                    }
                }
                return coroutine_suspended;
            case 2:
                str2 = (String) anonymousClass2.L$1;
                itemId3 = (ItemId) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objFetchFileWithRepresentations$default);
                fileWithRepresentationsResult = (FileWithRepresentationsResult) objFetchFileWithRepresentations$default;
                remoteError = PreviewFileWithRepresentationsWrapperKt.getRemoteError(fileWithRepresentationsResult);
                if (remoteError == null) {
                    if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Success) {
                        fileWithRepresentationsFetchObservability3 = this.observability;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                        anonymousClass2.L$2 = fileWithRepresentationsResult;
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                        anonymousClass2.label = 4;
                        if (fileWithRepresentationsFetchObservability3.fileWithRepresentationsFetchSuccessRemote(str2, anonymousClass2) != coroutine_suspended) {
                            fileWithRepresentationsResult4 = fileWithRepresentationsResult;
                            FileWithRepresentationsResult.Success success4 = (FileWithRepresentationsResult.Success) fileWithRepresentationsResult4;
                            return new PreviewFileWithRepresentationsResult.Success(success4.getFileModel(), success4.getRepresentations(), null, 4, null);
                        }
                    } else if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Cached) {
                        fileWithRepresentationsFetchObservability2 = this.observability;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                        anonymousClass2.L$2 = fileWithRepresentationsResult;
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                        anonymousClass2.label = 5;
                        if (fileWithRepresentationsFetchObservability2.fileWithRepresentationsFetchSuccessCache(str2, anonymousClass2) != coroutine_suspended) {
                            fileWithRepresentationsResult3 = fileWithRepresentationsResult;
                            cached = (FileWithRepresentationsResult.Cached) fileWithRepresentationsResult3;
                            if (DomainErrorKt.isNetworkConnectionError(cached.getRemoteFetchError())) {
                                cachedRepresentations = filterNotRequiredNetworkConnection(cached.getCachedRepresentations());
                            } else {
                                cachedRepresentations = cached.getCachedRepresentations();
                            }
                            return new PreviewFileWithRepresentationsResult.Success(cached.getCachedFileModel(), cachedRepresentations, cached.getRemoteFetchError());
                        }
                    } else {
                        if (!(fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        fileWithRepresentationsFetchObservability = this.observability;
                        remoteFetchError = ((FileWithRepresentationsResult.Error) fileWithRepresentationsResult).getRemoteFetchError();
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                        anonymousClass2.L$2 = fileWithRepresentationsResult;
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                        anonymousClass2.label = 6;
                        if (fileWithRepresentationsFetchObservability.fileWithRepresentationsFetchError(str2, remoteFetchError, anonymousClass2) != coroutine_suspended) {
                            fileWithRepresentationsResult2 = fileWithRepresentationsResult;
                            return new PreviewFileWithRepresentationsResult.Error(((FileWithRepresentationsResult.Error) fileWithRepresentationsResult2).getRemoteFetchError(), false, i, null);
                        }
                    }
                } else if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Success) {
                    fileWithRepresentationsFetchObservability3 = this.observability;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass2.L$2 = fileWithRepresentationsResult;
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                    anonymousClass2.label = 4;
                    if (fileWithRepresentationsFetchObservability3.fileWithRepresentationsFetchSuccessRemote(str2, anonymousClass2) != coroutine_suspended) {
                        fileWithRepresentationsResult4 = fileWithRepresentationsResult;
                        FileWithRepresentationsResult.Success success5 = (FileWithRepresentationsResult.Success) fileWithRepresentationsResult4;
                        return new PreviewFileWithRepresentationsResult.Success(success5.getFileModel(), success5.getRepresentations(), null, 4, null);
                    }
                } else if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Cached) {
                    fileWithRepresentationsFetchObservability2 = this.observability;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass2.L$2 = fileWithRepresentationsResult;
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                    anonymousClass2.label = 5;
                    if (fileWithRepresentationsFetchObservability2.fileWithRepresentationsFetchSuccessCache(str2, anonymousClass2) != coroutine_suspended) {
                        fileWithRepresentationsResult3 = fileWithRepresentationsResult;
                        cached = (FileWithRepresentationsResult.Cached) fileWithRepresentationsResult3;
                        if (DomainErrorKt.isNetworkConnectionError(cached.getRemoteFetchError())) {
                            cachedRepresentations = filterNotRequiredNetworkConnection(cached.getCachedRepresentations());
                        } else {
                            cachedRepresentations = cached.getCachedRepresentations();
                        }
                        return new PreviewFileWithRepresentationsResult.Success(cached.getCachedFileModel(), cachedRepresentations, cached.getRemoteFetchError());
                    }
                } else {
                    if (!(fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    fileWithRepresentationsFetchObservability = this.observability;
                    remoteFetchError = ((FileWithRepresentationsResult.Error) fileWithRepresentationsResult).getRemoteFetchError();
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId3);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass2.L$2 = fileWithRepresentationsResult;
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(remoteError);
                    anonymousClass2.label = 6;
                    if (fileWithRepresentationsFetchObservability.fileWithRepresentationsFetchError(str2, remoteFetchError, anonymousClass2) != coroutine_suspended) {
                        fileWithRepresentationsResult2 = fileWithRepresentationsResult;
                        return new PreviewFileWithRepresentationsResult.Error(((FileWithRepresentationsResult.Error) fileWithRepresentationsResult2).getRemoteFetchError(), false, i, null);
                    }
                }
                return coroutine_suspended;
            case 3:
                domainError = (DomainError) anonymousClass2.L$3;
                ResultKt.throwOnFailure(objFetchFileWithRepresentations$default);
                return new PreviewFileWithRepresentationsResult.Error(domainError, true);
            case 4:
                fileWithRepresentationsResult4 = (FileWithRepresentationsResult) anonymousClass2.L$2;
                ResultKt.throwOnFailure(objFetchFileWithRepresentations$default);
                FileWithRepresentationsResult.Success success6 = (FileWithRepresentationsResult.Success) fileWithRepresentationsResult4;
                return new PreviewFileWithRepresentationsResult.Success(success6.getFileModel(), success6.getRepresentations(), null, 4, null);
            case 5:
                fileWithRepresentationsResult3 = (FileWithRepresentationsResult) anonymousClass2.L$2;
                ResultKt.throwOnFailure(objFetchFileWithRepresentations$default);
                cached = (FileWithRepresentationsResult.Cached) fileWithRepresentationsResult3;
                if (DomainErrorKt.isNetworkConnectionError(cached.getRemoteFetchError())) {
                    cachedRepresentations = filterNotRequiredNetworkConnection(cached.getCachedRepresentations());
                } else {
                    cachedRepresentations = cached.getCachedRepresentations();
                }
                return new PreviewFileWithRepresentationsResult.Success(cached.getCachedFileModel(), cachedRepresentations, cached.getRemoteFetchError());
            case 6:
                fileWithRepresentationsResult2 = (FileWithRepresentationsResult) anonymousClass2.L$2;
                ResultKt.throwOnFailure(objFetchFileWithRepresentations$default);
                return new PreviewFileWithRepresentationsResult.Error(((FileWithRepresentationsResult.Error) fileWithRepresentationsResult2).getRemoteFetchError(), false, i, null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final List<RepresentationModel> filterNotRequiredNetworkConnection(List<RepresentationModel> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((RepresentationModel) obj).getRepresentationType() != RepresentationType.DASH) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
