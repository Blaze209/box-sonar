package com.box.android.data.service.impl;

import com.box.android.data.api.models.annotations.Location;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.DocumentScanCacheDataSource;
import com.box.android.data.mappers.ScannedDocumentPageEntityMapper;
import com.box.android.data.persistence.ScannedDocumentPageEntity;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ScannedDocumentPage;
import com.box.android.domain.services.IDocumentScanService;
import com.box.android.domain.utils.result.Result;
import java.io.File;
import java.util.ArrayList;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: DocumentScanService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\b0\u0007H\u0016J \u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bH\u0096@¢\u0006\u0002\u0010\rJ\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u000f\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\bH\u0096@¢\u0006\u0002\u0010\rJ*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/service/impl/DocumentScanService;", "Lcom/box/android/domain/services/IDocumentScanService;", "dataSource", "Lcom/box/android/data/datasource/DocumentScanCacheDataSource;", "<init>", "(Lcom/box/android/data/datasource/DocumentScanCacheDataSource;)V", "observePages", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/ScannedDocumentPage;", "Lcom/box/android/domain/models/DomainError;", "getPages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addPageToDocument", Location.TYPE_PAGE, "(Lcom/box/android/domain/models/ScannedDocumentPage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllPages", "", "deletePage", "workingDirectory", "Ljava/io/File;", "(Ljava/io/File;Lcom/box/android/domain/models/ScannedDocumentPage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAssociatedFiles", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentScanService implements IDocumentScanService {
    private final DocumentScanCacheDataSource dataSource;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.DocumentScanService$addPageToDocument$1, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentScanService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.DocumentScanService", f = "DocumentScanService.kt", i = {0, 0}, l = {41}, m = "addPageToDocument", n = {Location.TYPE_PAGE, "pageEntity"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanService.this.addPageToDocument(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.DocumentScanService$deleteAllPages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DocumentScanService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.DocumentScanService", f = "DocumentScanService.kt", i = {}, l = {49}, m = "deleteAllPages", n = {}, s = {}, v = 1)
    static final class C14201 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C14201(Continuation<? super C14201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanService.this.deleteAllPages(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.DocumentScanService$deletePage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DocumentScanService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.DocumentScanService", f = "DocumentScanService.kt", i = {0, 0}, l = {53}, m = "deletePage", n = {"workingDirectory", Location.TYPE_PAGE}, s = {"L$0", "L$1"}, v = 1)
    static final class C14211 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14211(Continuation<? super C14211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanService.this.deletePage(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.DocumentScanService$getPages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DocumentScanService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.DocumentScanService", f = "DocumentScanService.kt", i = {}, l = {33}, m = "getPages", n = {}, s = {}, v = 1)
    static final class C14221 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C14221(Continuation<? super C14221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanService.this.getPages(this);
        }
    }

    @Inject
    public DocumentScanService(DocumentScanCacheDataSource dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.dataSource = dataSource;
    }

    @Override // com.box.android.domain.services.IDocumentScanService
    public Flow<Result<List<ScannedDocumentPage>, DomainError>> observePages() {
        final Flow<Result<List<ScannedDocumentPageEntity>, CacheError>> flowObserveScannedDocumentPages = this.dataSource.observeScannedDocumentPages();
        return (Flow) new Flow<Result<? extends List<? extends ScannedDocumentPage>, ? extends DomainError>>() { // from class: com.box.android.data.service.impl.DocumentScanService$observePages$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.data.service.impl.DocumentScanService$observePages$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.DocumentScanService$observePages$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.DocumentScanService$observePages$$inlined$map$1$2", f = "DocumentScanService.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
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
                        Result.Error error = (Result) obj;
                        if (error instanceof Result.Success) {
                            List list = (List) ((Result.Success) error).getValue();
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(ScannedDocumentPageEntityMapper.INSTANCE.toDomain((ScannedDocumentPageEntity) it.next()));
                            }
                            error = new Result.Success(arrayList);
                        } else if (!(error instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (!(error instanceof Result.Success)) {
                            if (!(error instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) error).getValue(), null, 2, null));
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(error, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(FlowCollector<? super Result<? extends List<? extends ScannedDocumentPage>, ? extends DomainError>> flowCollector, Continuation continuation) {
                Object objCollect = flowObserveScannedDocumentPages.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IDocumentScanService
    public Object getPages(Continuation<? super Result<? extends List<ScannedDocumentPage>, ? extends DomainError>> continuation) {
        C14221 c14221;
        if (continuation instanceof C14221) {
            c14221 = (C14221) continuation;
            if ((c14221.label & Integer.MIN_VALUE) != 0) {
                c14221.label -= Integer.MIN_VALUE;
            } else {
                c14221 = new C14221(continuation);
            }
        } else {
            c14221 = new C14221(continuation);
        }
        Object scannedDocumentPages = c14221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14221.label;
        if (i == 0) {
            ResultKt.throwOnFailure(scannedDocumentPages);
            DocumentScanCacheDataSource documentScanCacheDataSource = this.dataSource;
            c14221.label = 1;
            scannedDocumentPages = documentScanCacheDataSource.getScannedDocumentPages(c14221);
            if (scannedDocumentPages == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(scannedDocumentPages);
        }
        Result.Success success = (Result) scannedDocumentPages;
        if (success instanceof Result.Success) {
            List list = (List) ((Result.Success) success).getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ScannedDocumentPageEntityMapper.INSTANCE.toDomain((ScannedDocumentPageEntity) it.next()));
            }
            success = new Result.Success(arrayList);
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) success).getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Override // com.box.android.domain.services.IDocumentScanService
    public Object addPageToDocument(ScannedDocumentPage scannedDocumentPage, Continuation<? super Result<ScannedDocumentPage, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        ScannedDocumentPage scannedDocumentPage2;
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
        Object objSaveDocumentPage = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSaveDocumentPage);
            ScannedDocumentPageEntity scannedDocumentPageEntityFromDomain = ScannedDocumentPageEntityMapper.INSTANCE.fromDomain(scannedDocumentPage);
            DocumentScanCacheDataSource documentScanCacheDataSource = this.dataSource;
            anonymousClass1.L$0 = scannedDocumentPage;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(scannedDocumentPageEntityFromDomain);
            anonymousClass1.label = 1;
            objSaveDocumentPage = documentScanCacheDataSource.saveDocumentPage(scannedDocumentPageEntityFromDomain, anonymousClass1);
            if (objSaveDocumentPage == coroutine_suspended) {
                return coroutine_suspended;
            }
            scannedDocumentPage2 = scannedDocumentPage;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ScannedDocumentPage scannedDocumentPage3 = (ScannedDocumentPage) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objSaveDocumentPage);
            scannedDocumentPage2 = scannedDocumentPage3;
        }
        Result.Success success = (Result) objSaveDocumentPage;
        if (success instanceof Result.Success) {
            success = new Result.Success(ScannedDocumentPage.copy$default(scannedDocumentPage2, Boxing.boxInt(((Number) ((Result.Success) success).getValue()).intValue()), null, null, null, null, false, 0, 0, null, 510, null));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) success).getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IDocumentScanService
    public Object deleteAllPages(Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C14201 c14201;
        if (continuation instanceof C14201) {
            c14201 = (C14201) continuation;
            if ((c14201.label & Integer.MIN_VALUE) != 0) {
                c14201.label -= Integer.MIN_VALUE;
            } else {
                c14201 = new C14201(continuation);
            }
        } else {
            c14201 = new C14201(continuation);
        }
        Object objDeleteAllScannedDocumentPages = c14201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14201.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeleteAllScannedDocumentPages);
            DocumentScanCacheDataSource documentScanCacheDataSource = this.dataSource;
            c14201.label = 1;
            objDeleteAllScannedDocumentPages = documentScanCacheDataSource.deleteAllScannedDocumentPages(c14201);
            if (objDeleteAllScannedDocumentPages == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objDeleteAllScannedDocumentPages);
        }
        Result result = (Result) objDeleteAllScannedDocumentPages;
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IDocumentScanService
    public Object deletePage(File file, ScannedDocumentPage scannedDocumentPage, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C14211 c14211;
        if (continuation instanceof C14211) {
            c14211 = (C14211) continuation;
            if ((c14211.label & Integer.MIN_VALUE) != 0) {
                c14211.label -= Integer.MIN_VALUE;
            } else {
                c14211 = new C14211(continuation);
            }
        } else {
            c14211 = new C14211(continuation);
        }
        Object objDeleteDocumentPage = c14211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14211.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeleteDocumentPage);
            DocumentScanCacheDataSource documentScanCacheDataSource = this.dataSource;
            Integer id = scannedDocumentPage.getId();
            Intrinsics.checkNotNull(id);
            int iIntValue = id.intValue();
            c14211.L$0 = SpillingKt.nullOutSpilledVariable(file);
            c14211.L$1 = scannedDocumentPage;
            c14211.label = 1;
            objDeleteDocumentPage = documentScanCacheDataSource.deleteDocumentPage(iIntValue, c14211);
            if (objDeleteDocumentPage == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            scannedDocumentPage = (ScannedDocumentPage) c14211.L$1;
            ResultKt.throwOnFailure(objDeleteDocumentPage);
        }
        Result.Success success = (Result) objDeleteDocumentPage;
        if (success instanceof Result.Success) {
            removeAssociatedFiles(scannedDocumentPage);
            success = new Result.Success(Unit.INSTANCE);
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) success).getValue(), null, 2, null));
    }

    private final void removeAssociatedFiles(ScannedDocumentPage page) {
        new File(page.getOriginalImagePath()).delete();
        new File(page.getEnhancedImagePath()).delete();
    }
}
