package com.box.android.data.datasource.annotations;

import com.box.android.data.datasource.CacheError;
import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.annotations.AnnotationEntity;
import com.box.android.data.persistence.annotations.AnnotationsDao;
import com.box.android.data.user.UserData;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.Date;
import java.util.Iterator;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: AnnotationsCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J&\u0010\u0015\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0016\u0012\u0004\u0012\u00020\u00170\u00072\u0006\u0010\u0012\u001a\u00020\u0013J\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u00072\u0006\u0010\u0019\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/datasource/annotations/AnnotationsCacheDataSource;", "", "userData", "Lcom/box/android/data/user/UserData;", "<init>", "(Lcom/box/android/data/user/UserData;)V", "saveAnnotation", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/CacheError$SaveError;", "annotationEntities", "", "Lcom/box/android/data/persistence/annotations/AnnotationEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAnnotations", "", "fetchedBefore", "Ljava/util/Date;", "fileVersionId", "", "(Ljava/util/Date;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "annotations", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/data/datasource/CacheError;", "deleteAnnotation", "annotationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationsCacheDataSource {
    private static final Companion Companion = new Companion(null);
    private static final String LOGTAG = "AnnotationsCacheDataSource";
    private UserData userData;

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.AnnotationsCacheDataSource$deleteAnnotation$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnnotationsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.AnnotationsCacheDataSource", f = "AnnotationsCacheDataSource.kt", i = {0, 0}, l = {114}, m = "deleteAnnotation", n = {"annotationId", "databaseResult"}, s = {"L$0", "L$1"}, v = 1)
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
            return AnnotationsCacheDataSource.this.deleteAnnotation(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.AnnotationsCacheDataSource$deleteAnnotations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotationsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.AnnotationsCacheDataSource", f = "AnnotationsCacheDataSource.kt", i = {0, 0, 0, 0, 0}, l = {59}, m = "deleteAnnotations", n = {"fetchedBefore", "fileVersionId", "rowsDeleted", "databaseResult", "database"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class C11041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C11041(Continuation<? super C11041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnnotationsCacheDataSource.this.deleteAnnotations(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.AnnotationsCacheDataSource$saveAnnotation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotationsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.AnnotationsCacheDataSource", f = "AnnotationsCacheDataSource.kt", i = {0, 0, 0}, l = {31}, m = "saveAnnotation", n = {"annotationEntities", "databaseResult", "database"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C11061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11061(Continuation<? super C11061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnnotationsCacheDataSource.this.saveAnnotation(null, this);
        }
    }

    @Inject
    public AnnotationsCacheDataSource(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        this.userData = userData;
    }

    /* JADX INFO: compiled from: AnnotationsCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/datasource/annotations/AnnotationsCacheDataSource$Companion;", "", "<init>", "()V", "LOGTAG", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object saveAnnotation(List<AnnotationEntity> list, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
        C11061 c11061;
        if (continuation instanceof C11061) {
            c11061 = (C11061) continuation;
            if ((c11061.label & Integer.MIN_VALUE) != 0) {
                c11061.label -= Integer.MIN_VALUE;
            } else {
                c11061 = new C11061(continuation);
            }
        } else {
            c11061 = new C11061(continuation);
        }
        Object obj = c11061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11061.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    C11072 c11072 = new C11072(list, boxDatabase2, null);
                    c11061.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    c11061.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11061.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11061.label = 1;
                    if (boxDatabase2.withTransactionWrapper(c11072, c11061) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    new Result.Error(CacheError.SaveError.INSTANCE);
                }
                return new Result.Success(Unit.INSTANCE);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Unit unit = Unit.INSTANCE;
            return new Result.Success(Unit.INSTANCE);
        } catch (Exception unused) {
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.AnnotationsCacheDataSource$saveAnnotation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotationsCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.AnnotationsCacheDataSource$saveAnnotation$2", f = "AnnotationsCacheDataSource.kt", i = {0, 0, 0, 0, 0}, l = {33}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "annotation", "$i$f$forEach", "$i$a$-forEach-AnnotationsCacheDataSource$saveAnnotation$2$1"}, s = {"L$0", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class C11072 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<AnnotationEntity> $annotationEntities;
        final /* synthetic */ BoxDatabase $database;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11072(List<AnnotationEntity> list, BoxDatabase boxDatabase, Continuation<? super C11072> continuation) {
            super(1, continuation);
            this.$annotationEntities = list;
            this.$database = boxDatabase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C11072(this.$annotationEntities, this.$database, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C11072) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator it;
            Iterable iterable;
            BoxDatabase boxDatabase;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                List<AnnotationEntity> list = this.$annotationEntities;
                BoxDatabase boxDatabase2 = this.$database;
                it = list.iterator();
                iterable = list;
                boxDatabase = boxDatabase2;
                i = 0;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                it = (Iterator) this.L$2;
                boxDatabase = (BoxDatabase) this.L$1;
                iterable = (Iterable) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                AnnotationEntity annotationEntity = (AnnotationEntity) next;
                AnnotationsDao annotationsDao = boxDatabase.annotationsDao();
                this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                this.L$1 = boxDatabase;
                this.L$2 = it;
                this.L$3 = SpillingKt.nullOutSpilledVariable(next);
                this.L$4 = SpillingKt.nullOutSpilledVariable(annotationEntity);
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 1;
                if (annotationsDao.insertAnnotation(annotationEntity, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteAnnotations(Date date, String str, Continuation<? super Integer> continuation) {
        C11041 c11041;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        if (continuation instanceof C11041) {
            c11041 = (C11041) continuation;
            if ((c11041.label & Integer.MIN_VALUE) != 0) {
                c11041.label -= Integer.MIN_VALUE;
            } else {
                c11041 = new C11041(continuation);
            }
        } else {
            c11041 = new C11041(continuation);
        }
        Object obj = c11041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11041.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            intRef = new Ref.IntRef();
            Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
            if (boxDatabase instanceof Result.Success) {
                BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                C11052 c11052 = new C11052(intRef, boxDatabase2, date, str, null);
                c11041.L$0 = SpillingKt.nullOutSpilledVariable(date);
                c11041.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c11041.L$2 = intRef;
                c11041.L$3 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                c11041.L$4 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                c11041.label = 1;
                if (boxDatabase2.withTransactionWrapper(c11052, c11041) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                intRef2 = intRef;
            } else {
                if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                BoxLogUtils.e(LOGTAG, "Error while deleting old annotations " + ((Result.Error) boxDatabase).getValue());
            }
            return Boxing.boxInt(intRef.element);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        intRef2 = (Ref.IntRef) c11041.L$2;
        ResultKt.throwOnFailure(obj);
        intRef = intRef2;
        return Boxing.boxInt(intRef.element);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.AnnotationsCacheDataSource$deleteAnnotations$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotationsCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.AnnotationsCacheDataSource$deleteAnnotations$2", f = "AnnotationsCacheDataSource.kt", i = {}, l = {60, 64}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11052 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ BoxDatabase $database;
        final /* synthetic */ Date $fetchedBefore;
        final /* synthetic */ String $fileVersionId;
        final /* synthetic */ Ref.IntRef $rowsDeleted;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11052(Ref.IntRef intRef, BoxDatabase boxDatabase, Date date, String str, Continuation<? super C11052> continuation) {
            super(1, continuation);
            this.$rowsDeleted = intRef;
            this.$database = boxDatabase;
            this.$fetchedBefore = date;
            this.$fileVersionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C11052(this.$rowsDeleted, this.$database, this.$fetchedBefore, this.$fileVersionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C11052) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
        
            if (r7.$database.fileActivityDao().cleanupAnnotations(r7) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r8)
                goto L5c
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1a:
                java.lang.Object r1 = r7.L$0
                kotlin.jvm.internal.Ref$IntRef r1 = (kotlin.jvm.internal.Ref.IntRef) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L3f
            L22:
                kotlin.ResultKt.throwOnFailure(r8)
                kotlin.jvm.internal.Ref$IntRef r1 = r7.$rowsDeleted
                com.box.android.data.persistence.BoxDatabase r8 = r7.$database
                com.box.android.data.persistence.annotations.AnnotationsDao r8 = r8.annotationsDao()
                java.util.Date r4 = r7.$fetchedBefore
                java.lang.String r5 = r7.$fileVersionId
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.L$0 = r1
                r7.label = r3
                java.lang.Object r8 = r8.deleteAnnotations(r4, r5, r6)
                if (r8 != r0) goto L3f
                goto L5b
            L3f:
                java.lang.Number r8 = (java.lang.Number) r8
                int r8 = r8.intValue()
                r1.element = r8
                com.box.android.data.persistence.BoxDatabase r8 = r7.$database
                com.box.android.data.persistence.annotations.FileActivityDao r8 = r8.fileActivityDao()
                r1 = r7
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r3 = 0
                r7.L$0 = r3
                r7.label = r2
                java.lang.Object r7 = r8.cleanupAnnotations(r1)
                if (r7 != r0) goto L5c
            L5b:
                return r0
            L5c:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.annotations.AnnotationsCacheDataSource.C11052.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Result<Flow<List<AnnotationEntity>>, CacheError> annotations(String fileVersionId) {
        Intrinsics.checkNotNullParameter(fileVersionId, "fileVersionId");
        Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
        if (boxDatabase instanceof Result.Success) {
            return new Result.Success(((BoxDatabase) ((Result.Success) boxDatabase).getValue()).annotationsDao().getAnnotationForFileVersionId(fileVersionId));
        }
        if (!(boxDatabase instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Result.Error error = (Result.Error) boxDatabase;
        BoxLogUtils.e(LOGTAG, "Error while fetching annotations from cache " + error.getValue());
        return new Result.Error(error.getValue());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteAnnotation(String str, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
            if (boxDatabase instanceof Result.Success) {
                BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(boxDatabase, str, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                anonymousClass1.label = 1;
                if (boxDatabase2.withTransactionWrapper(anonymousClass2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                Result.Error error = (Result.Error) boxDatabase;
                BoxLogUtils.e(LOGTAG, "Error deleting annotation from cache " + error.getValue());
                return new Result.Error(error.getValue());
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.AnnotationsCacheDataSource$deleteAnnotation$2, reason: invalid class name */
    /* JADX INFO: compiled from: AnnotationsCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.AnnotationsCacheDataSource$deleteAnnotation$2", f = "AnnotationsCacheDataSource.kt", i = {}, l = {115, 116}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $annotationId;
        final /* synthetic */ Result<BoxDatabase, CacheError> $databaseResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Result<? extends BoxDatabase, ? extends CacheError> result, String str, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$databaseResult = result;
            this.$annotationId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$databaseResult, this.$annotationId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
        
            if (((com.box.android.data.persistence.BoxDatabase) ((com.box.android.domain.utils.result.Result.Success) r5.$databaseResult).getValue()).fileActivityDao().cleanupAnnotations(r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r6)
                goto L57
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L3d
            L1e:
                kotlin.ResultKt.throwOnFailure(r6)
                com.box.android.domain.utils.result.Result<com.box.android.data.persistence.BoxDatabase, com.box.android.data.datasource.CacheError> r6 = r5.$databaseResult
                com.box.android.domain.utils.result.Result$Success r6 = (com.box.android.domain.utils.result.Result.Success) r6
                java.lang.Object r6 = r6.getValue()
                com.box.android.data.persistence.BoxDatabase r6 = (com.box.android.data.persistence.BoxDatabase) r6
                com.box.android.data.persistence.annotations.AnnotationsDao r6 = r6.annotationsDao()
                java.lang.String r1 = r5.$annotationId
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.label = r3
                java.lang.Object r6 = r6.deleteAnnotation(r1, r4)
                if (r6 != r0) goto L3d
                goto L56
            L3d:
                com.box.android.domain.utils.result.Result<com.box.android.data.persistence.BoxDatabase, com.box.android.data.datasource.CacheError> r6 = r5.$databaseResult
                com.box.android.domain.utils.result.Result$Success r6 = (com.box.android.domain.utils.result.Result.Success) r6
                java.lang.Object r6 = r6.getValue()
                com.box.android.data.persistence.BoxDatabase r6 = (com.box.android.data.persistence.BoxDatabase) r6
                com.box.android.data.persistence.annotations.FileActivityDao r6 = r6.fileActivityDao()
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r2
                java.lang.Object r5 = r6.cleanupAnnotations(r1)
                if (r5 != r0) goto L57
            L56:
                return r0
            L57:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.annotations.AnnotationsCacheDataSource.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
