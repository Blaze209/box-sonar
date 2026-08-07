package com.box.android.data.datasource;

import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.ScannedDocumentPageDao;
import com.box.android.data.persistence.ScannedDocumentPageEntity;
import com.box.android.data.user.UserData;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: DocumentScanCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000f\u0012\u0004\u0012\u00020\t0\u00070\u000eJ \u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000f\u0012\u0004\u0012\u00020\t0\u0007H\u0086@¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u0007H\u0086@¢\u0006\u0002\u0010\u0011J\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0015\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/datasource/DocumentScanCacheDataSource;", "", "userData", "Lcom/box/android/data/user/UserData;", "<init>", "(Lcom/box/android/data/user/UserData;)V", "saveDocumentPage", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/CacheError;", "entity", "Lcom/box/android/data/persistence/ScannedDocumentPageEntity;", "(Lcom/box/android/data/persistence/ScannedDocumentPageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeScannedDocumentPages", "Lkotlinx/coroutines/flow/Flow;", "", "getScannedDocumentPages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllScannedDocumentPages", "", "deleteDocumentPage", "pageId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentScanCacheDataSource {
    private static final Companion Companion = new Companion(null);
    private static final String LOGTAG = "DocumentScanDataSource";
    private UserData userData;

    /* JADX INFO: renamed from: com.box.android.data.datasource.DocumentScanCacheDataSource$deleteAllScannedDocumentPages$1, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentScanCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.DocumentScanCacheDataSource", f = "DocumentScanCacheDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {97}, m = "deleteAllScannedDocumentPages", n = {"$this$flatMap$iv", "database", "$i$f$flatMap", "$i$a$-flatMap-DocumentScanCacheDataSource$deleteAllScannedDocumentPages$2", "$i$f$resultOf", "$i$a$-resultOf-DocumentScanCacheDataSource$deleteAllScannedDocumentPages$2$1"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
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
            return DocumentScanCacheDataSource.this.deleteAllScannedDocumentPages(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.DocumentScanCacheDataSource$deleteDocumentPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DocumentScanCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.DocumentScanCacheDataSource", f = "DocumentScanCacheDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {107}, m = "deleteDocumentPage", n = {"$this$flatMap$iv", "database", "pageId", "$i$f$flatMap", "$i$a$-flatMap-DocumentScanCacheDataSource$deleteDocumentPage$2", "$i$f$resultOf", "$i$a$-resultOf-DocumentScanCacheDataSource$deleteDocumentPage$2$1"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class C10851 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10851(Continuation<? super C10851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanCacheDataSource.this.deleteDocumentPage(0, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.DocumentScanCacheDataSource$getScannedDocumentPages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DocumentScanCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.DocumentScanCacheDataSource", f = "DocumentScanCacheDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {81}, m = "getScannedDocumentPages", n = {"$this$flatMap$iv", "database", "$i$f$flatMap", "$i$a$-flatMap-DocumentScanCacheDataSource$getScannedDocumentPages$2", "$i$f$resultOf", "$i$a$-resultOf-DocumentScanCacheDataSource$getScannedDocumentPages$2$1"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C10861 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10861(Continuation<? super C10861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanCacheDataSource.this.getScannedDocumentPages(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.DocumentScanCacheDataSource$saveDocumentPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DocumentScanCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.DocumentScanCacheDataSource", f = "DocumentScanCacheDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {29}, m = "saveDocumentPage", n = {"entity", "$this$flatMap$iv", "database", "$i$f$flatMap", "$i$a$-flatMap-DocumentScanCacheDataSource$saveDocumentPage$2", "$i$f$resultOf", "$i$a$-resultOf-DocumentScanCacheDataSource$saveDocumentPage$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C10871 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10871(Continuation<? super C10871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanCacheDataSource.this.saveDocumentPage(null, this);
        }
    }

    @Inject
    public DocumentScanCacheDataSource(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        this.userData = userData;
    }

    /* JADX INFO: compiled from: DocumentScanCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/datasource/DocumentScanCacheDataSource$Companion;", "", "<init>", "()V", "LOGTAG", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:50:0x0112  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object saveDocumentPage(ScannedDocumentPageEntity scannedDocumentPageEntity, Continuation<? super Result<Integer, ? extends CacheError>> continuation) {
        C10871 c10871;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C10871) {
            c10871 = (C10871) continuation;
            if ((c10871.label & Integer.MIN_VALUE) != 0) {
                c10871.label -= Integer.MIN_VALUE;
            } else {
                c10871 = new C10871(continuation);
            }
        } else {
            c10871 = new C10871(continuation);
        }
        Object objInsertOrUpdateScannedDocumentPage = c10871.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10871.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objInsertOrUpdateScannedDocumentPage);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    ScannedDocumentPageDao scannedDocumentPageDaoScannedDocumentPagesDao = boxDatabase2.scannedDocumentPagesDao();
                    c10871.L$0 = SpillingKt.nullOutSpilledVariable(scannedDocumentPageEntity);
                    c10871.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c10871.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c10871.I$0 = 0;
                    c10871.I$1 = 0;
                    c10871.I$2 = 0;
                    c10871.I$3 = 0;
                    c10871.label = 1;
                    objInsertOrUpdateScannedDocumentPage = scannedDocumentPageDaoScannedDocumentPagesDao.insertOrUpdateScannedDocumentPage(scannedDocumentPageEntity, c10871);
                    if (objInsertOrUpdateScannedDocumentPage == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!(boxDatabase instanceof Result.Success)) {
                    if (boxDatabase instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(LOGTAG, "Error while saving scanned document page " + ((CacheError) ((Result.Error) boxDatabase).getValue()));
                }
                return boxDatabase;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c10871.I$3;
            int i3 = c10871.I$2;
            int i4 = c10871.I$1;
            int i5 = c10871.I$0;
            ResultKt.throwOnFailure(objInsertOrUpdateScannedDocumentPage);
            error = new Result.Success(Boxing.boxLong(((Number) objInsertOrUpdateScannedDocumentPage).longValue()));
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            error = new Result.Success(Boxing.boxInt((int) ((Number) ((Result.Success) error).getValue()).longValue()));
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(CacheError.SaveError.INSTANCE);
        }
        boxDatabase = error;
        if (!(boxDatabase instanceof Result.Success)) {
            if (boxDatabase instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(LOGTAG, "Error while saving scanned document page " + ((CacheError) ((Result.Error) boxDatabase).getValue()));
        }
        return boxDatabase;
    }

    public final Flow<Result<List<ScannedDocumentPageEntity>, CacheError>> observeScannedDocumentPages() {
        Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
        if (boxDatabase instanceof Result.Success) {
            final Flow<List<ScannedDocumentPageEntity>> flowObserveScannedDocumentPages = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).scannedDocumentPagesDao().observeScannedDocumentPages();
            return FlowKt.m16356catch(new Flow<Result<? extends List<? extends ScannedDocumentPageEntity>, ? extends CacheError>>() { // from class: com.box.android.data.datasource.DocumentScanCacheDataSource$observeScannedDocumentPages$$inlined$map$1

                /* JADX INFO: renamed from: com.box.android.data.datasource.DocumentScanCacheDataSource$observeScannedDocumentPages$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.data.datasource.DocumentScanCacheDataSource$observeScannedDocumentPages$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.data.datasource.DocumentScanCacheDataSource$observeScannedDocumentPages$$inlined$map$1$2", f = "DocumentScanCacheDataSource.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                            Result.Success success = new Result.Success((List) obj);
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(success, anonymousClass1) == coroutine_suspended) {
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
                public Object collect(FlowCollector<? super Result<? extends List<? extends ScannedDocumentPageEntity>, ? extends CacheError>> flowCollector, Continuation continuation) {
                    Object objCollect = flowObserveScannedDocumentPages.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }, new AnonymousClass2(null));
        }
        if (!(boxDatabase instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error accessing db for scanned document: " + ((Result.Error) boxDatabase).getValue());
        return FlowKt.flowOf(new Result.Error(CacheError.ReadError.INSTANCE));
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.DocumentScanCacheDataSource$observeScannedDocumentPages$2, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentScanCacheDataSource.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/persistence/ScannedDocumentPageEntity;", "Lcom/box/android/data/datasource/CacheError;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.DocumentScanCacheDataSource$observeScannedDocumentPages$2", f = "DocumentScanCacheDataSource.kt", i = {0, 0}, l = {60}, m = "invokeSuspend", n = {"$this$catch", "it"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends ScannedDocumentPageEntity>, ? extends CacheError>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends List<? extends ScannedDocumentPageEntity>, ? extends CacheError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<? extends List<ScannedDocumentPageEntity>, ? extends CacheError>>) flowCollector, th, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<? extends List<ScannedDocumentPageEntity>, ? extends CacheError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = flowCollector;
            anonymousClass2.L$1 = th;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BoxLogUtils.e(ExtensionsKt.getTAG(flowCollector), "Error reading scanned document: " + th);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(th);
                this.label = 1;
                if (flowCollector.emit(new Result.Error(CacheError.ReadError.INSTANCE), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getScannedDocumentPages(Continuation<? super Result<? extends List<ScannedDocumentPageEntity>, ? extends CacheError>> continuation) {
        C10861 c10861;
        Result.Error error;
        if (continuation instanceof C10861) {
            c10861 = (C10861) continuation;
            if ((c10861.label & Integer.MIN_VALUE) != 0) {
                c10861.label -= Integer.MIN_VALUE;
            } else {
                c10861 = new C10861(continuation);
            }
        } else {
            c10861 = new C10861(continuation);
        }
        Object scannedDocumentPages = c10861.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10861.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(scannedDocumentPages);
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    ScannedDocumentPageDao scannedDocumentPageDaoScannedDocumentPagesDao = boxDatabase2.scannedDocumentPagesDao();
                    c10861.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c10861.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c10861.I$0 = 0;
                    c10861.I$1 = 0;
                    c10861.I$2 = 0;
                    c10861.I$3 = 0;
                    c10861.label = 1;
                    scannedDocumentPages = scannedDocumentPageDaoScannedDocumentPagesDao.getScannedDocumentPages(c10861);
                    if (scannedDocumentPages == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (boxDatabase instanceof Result.Error) {
                        return boxDatabase;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c10861.I$3;
                int i3 = c10861.I$2;
                int i4 = c10861.I$1;
                int i5 = c10861.I$0;
                ResultKt.throwOnFailure(scannedDocumentPages);
            }
            error = new Result.Success((List) scannedDocumentPages);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while reading stored document pages: " + ((Exception) ((Result.Error) error).getValue()));
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteAllScannedDocumentPages(Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    ScannedDocumentPageDao scannedDocumentPageDaoScannedDocumentPagesDao = boxDatabase2.scannedDocumentPagesDao();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.I$3 = 0;
                    anonymousClass1.label = 1;
                    if (scannedDocumentPageDaoScannedDocumentPagesDao.deleteAllDocumentPages(anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (boxDatabase instanceof Result.Error) {
                        return boxDatabase;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$3;
                int i3 = anonymousClass1.I$2;
                int i4 = anonymousClass1.I$1;
                int i5 = anonymousClass1.I$0;
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
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while deleting stored document pages: " + ((Exception) ((Result.Error) error).getValue()));
            return new Result.Error(CacheError.DeleteError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteDocumentPage(int i, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C10851 c10851;
        Result.Error error;
        if (continuation instanceof C10851) {
            c10851 = (C10851) continuation;
            if ((c10851.label & Integer.MIN_VALUE) != 0) {
                c10851.label -= Integer.MIN_VALUE;
            } else {
                c10851 = new C10851(continuation);
            }
        } else {
            c10851 = new C10851(continuation);
        }
        Object obj = c10851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10851.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    ScannedDocumentPageDao scannedDocumentPageDaoScannedDocumentPagesDao = boxDatabase2.scannedDocumentPagesDao();
                    c10851.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c10851.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c10851.I$0 = i;
                    c10851.I$1 = 0;
                    c10851.I$2 = 0;
                    c10851.I$3 = 0;
                    c10851.I$4 = 0;
                    c10851.label = 1;
                    if (scannedDocumentPageDaoScannedDocumentPagesDao.deletePage(i, c10851) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (boxDatabase instanceof Result.Error) {
                        return boxDatabase;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c10851.I$4;
                int i4 = c10851.I$3;
                int i5 = c10851.I$2;
                int i6 = c10851.I$1;
                int i7 = c10851.I$0;
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
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while deleting stored document page: " + ((Exception) ((Result.Error) error).getValue()));
            return new Result.Error(CacheError.DeleteError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
