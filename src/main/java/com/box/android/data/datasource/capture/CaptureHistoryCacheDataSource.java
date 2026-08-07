package com.box.android.data.datasource.capture;

import androidx.media3.extractor.ts.TsExtractor;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.capture.CaptureHistoryDao;
import com.box.android.data.persistence.capture.CaptureHistoryItemEntity;
import com.box.android.data.user.UserData;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CaptureHistoryCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0019\u0012\u0004\u0012\u00020\u00110\u00100\u0018J\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/datasource/capture/CaptureHistoryCacheDataSource;", "", "userData", "Lcom/box/android/data/user/UserData;", "<init>", "(Lcom/box/android/data/user/UserData;)V", "hasAttemptedTruncate", "", "addHistoricalCapture", "", "captureHistoryItemEntity", "Lcom/box/android/data/persistence/capture/CaptureHistoryItemEntity;", "(Lcom/box/android/data/persistence/capture/CaptureHistoryItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "truncateDb", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastUpdatedDate", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/datasource/CacheError;", "itemId", "Lcom/box/android/domain/models/ItemId$Local;", "(Lcom/box/android/domain/models/ItemId$Local;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHistoricalCapture", "deleteHistoricalCapture", "getHistoricalCaptureIds", "Lkotlinx/coroutines/flow/Flow;", "", "serverId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureHistoryCacheDataSource {
    private boolean hasAttemptedTruncate;
    private final UserData userData;

    /* JADX INFO: renamed from: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$addHistoricalCapture$1, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureHistoryCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource", f = "CaptureHistoryCacheDataSource.kt", i = {0, 0, 1}, l = {28, 41}, m = "addHistoricalCapture", n = {"captureHistoryItemEntity", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "captureHistoryItemEntity"}, s = {"L$0", "L$1", "L$0"}, v = 1)
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
            return CaptureHistoryCacheDataSource.this.addHistoricalCapture(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$deleteHistoricalCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureHistoryCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource", f = "CaptureHistoryCacheDataSource.kt", i = {0, 0}, l = {113}, m = "deleteHistoricalCapture", n = {"itemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class C11201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11201(Continuation<? super C11201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CaptureHistoryCacheDataSource.this.deleteHistoricalCapture((ItemId.Local) null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$deleteHistoricalCapture$2, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureHistoryCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource", f = "CaptureHistoryCacheDataSource.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {TsExtractor.TS_STREAM_TYPE_AC4, 173}, m = "deleteHistoricalCapture", n = {"serverId", "$this$onSuccess$iv", "boxDatabase", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryCacheDataSource$deleteHistoricalCapture$3", "serverId", "$this$onSuccess$iv", "boxDatabase", "it", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryCacheDataSource$deleteHistoricalCapture$3", "$i$a$-let-CaptureHistoryCacheDataSource$deleteHistoricalCapture$3$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass2 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CaptureHistoryCacheDataSource.this.deleteHistoricalCapture((String) null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$truncateDb$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureHistoryCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource", f = "CaptureHistoryCacheDataSource.kt", i = {0}, l = {53}, m = "truncateDb", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0"}, v = 1)
    static final class C11211 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11211(Continuation<? super C11211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CaptureHistoryCacheDataSource.this.truncateDb(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$updateHistoricalCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureHistoryCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource", f = "CaptureHistoryCacheDataSource.kt", i = {0, 0}, l = {91}, m = "updateHistoricalCapture", n = {"captureHistoryItemEntity", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class C11221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11221(Continuation<? super C11221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CaptureHistoryCacheDataSource.this.updateHistoricalCapture(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$updateLastUpdatedDate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureHistoryCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource", f = "CaptureHistoryCacheDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {71}, m = "updateLastUpdatedDate", n = {"itemId", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-CaptureHistoryCacheDataSource$updateLastUpdatedDate$2", "$i$f$resultOf", "$i$a$-resultOf-CaptureHistoryCacheDataSource$updateLastUpdatedDate$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11231 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11231(Continuation<? super C11231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CaptureHistoryCacheDataSource.this.updateLastUpdatedDate((ItemId.Local) null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$updateLastUpdatedDate$4, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureHistoryCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource", f = "CaptureHistoryCacheDataSource.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {Token.ARRAYCOMP, Token.LETEXPR}, m = "updateLastUpdatedDate", n = {"serverId", "$this$onSuccess$iv", "boxDatabase", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryCacheDataSource$updateLastUpdatedDate$5", "serverId", "$this$onSuccess$iv", "boxDatabase", "it", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryCacheDataSource$updateLastUpdatedDate$5", "$i$a$-let-CaptureHistoryCacheDataSource$updateLastUpdatedDate$5$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass4 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CaptureHistoryCacheDataSource.this.updateLastUpdatedDate((String) null, this);
        }
    }

    @Inject
    public CaptureHistoryCacheDataSource(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        this.userData = userData;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bb, code lost:
    
        if (truncateDb(r1) == r2) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object addHistoricalCapture(com.box.android.data.persistence.capture.CaptureHistoryItemEntity r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Error inserting capture history item: "
            boolean r1 = r8 instanceof com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource.AnonymousClass1
            if (r1 == 0) goto L16
            r1 = r8
            com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$addHistoricalCapture$1 r1 = (com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r8 = r1.label
            int r8 = r8 - r3
            r1.label = r8
            goto L1b
        L16:
            com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$addHistoricalCapture$1 r1 = new com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$addHistoricalCapture$1
            r1.<init>(r8)
        L1b:
            java.lang.Object r8 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L48
            if (r3 == r5) goto L3c
            if (r3 != r4) goto L34
            java.lang.Object r6 = r1.L$0
            com.box.android.data.persistence.capture.CaptureHistoryItemEntity r6 = (com.box.android.data.persistence.capture.CaptureHistoryItemEntity) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto Lbe
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r7 = r1.L$1
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            java.lang.Object r7 = r1.L$0
            com.box.android.data.persistence.capture.CaptureHistoryItemEntity r7 = (com.box.android.data.persistence.capture.CaptureHistoryItemEntity) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L9c
            goto La8
        L48:
            kotlin.ResultKt.throwOnFailure(r8)
            com.box.android.data.user.UserData r8 = r6.userData     // Catch: java.lang.Exception -> L9c
            com.box.android.domain.utils.result.Result r8 = r8.getBoxDatabase()     // Catch: java.lang.Exception -> L9c
            boolean r3 = r8 instanceof com.box.android.domain.utils.result.Result.Success     // Catch: java.lang.Exception -> L9c
            if (r3 == 0) goto L77
            r0 = r8
            com.box.android.domain.utils.result.Result$Success r0 = (com.box.android.domain.utils.result.Result.Success) r0     // Catch: java.lang.Exception -> L9c
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Exception -> L9c
            com.box.android.data.persistence.BoxDatabase r0 = (com.box.android.data.persistence.BoxDatabase) r0     // Catch: java.lang.Exception -> L9c
            com.box.android.data.persistence.capture.CaptureHistoryDao r0 = r0.captureHistoryDao()     // Catch: java.lang.Exception -> L9c
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch: java.lang.Exception -> L9c
            r1.L$0 = r3     // Catch: java.lang.Exception -> L9c
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)     // Catch: java.lang.Exception -> L9c
            r1.L$1 = r8     // Catch: java.lang.Exception -> L9c
            r1.label = r5     // Catch: java.lang.Exception -> L9c
            java.lang.Object r8 = r0.insertCaptureHistoryItem(r7, r1)     // Catch: java.lang.Exception -> L9c
            if (r8 != r2) goto La8
            goto Lbd
        L77:
            boolean r3 = r8 instanceof com.box.android.domain.utils.result.Result.Error     // Catch: java.lang.Exception -> L9c
            if (r3 == 0) goto L96
            java.lang.String r3 = com.box.android.domain.utils.ExtensionsKt.getTAG(r6)     // Catch: java.lang.Exception -> L9c
            com.box.android.domain.utils.result.Result$Error r8 = (com.box.android.domain.utils.result.Result.Error) r8     // Catch: java.lang.Exception -> L9c
            java.lang.Object r8 = r8.getValue()     // Catch: java.lang.Exception -> L9c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9c
            r5.<init>(r0)     // Catch: java.lang.Exception -> L9c
            java.lang.StringBuilder r8 = r5.append(r8)     // Catch: java.lang.Exception -> L9c
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L9c
            com.box.androidsdk.content.utils.BoxLogUtils.e(r3, r8)     // Catch: java.lang.Exception -> L9c
            goto La8
        L96:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Exception -> L9c
            r8.<init>()     // Catch: java.lang.Exception -> L9c
            throw r8     // Catch: java.lang.Exception -> L9c
        L9c:
            r8 = move-exception
            java.lang.String r0 = com.box.android.domain.utils.ExtensionsKt.getTAG(r6)
            java.lang.String r3 = "Error inserting capture history item"
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            com.box.androidsdk.content.utils.BoxLogUtils.e(r0, r3, r8)
        La8:
            boolean r8 = r6.hasAttemptedTruncate
            if (r8 != 0) goto Lc1
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r1.L$0 = r7
            r7 = 0
            r1.L$1 = r7
            r1.label = r4
            java.lang.Object r6 = r6.truncateDb(r1)
            if (r6 != r2) goto Lbe
        Lbd:
            return r2
        Lbe:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        Lc1:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource.addHistoricalCapture(com.box.android.data.persistence.capture.CaptureHistoryItemEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object truncateDb(Continuation<? super Unit> continuation) {
        C11211 c11211;
        if (continuation instanceof C11211) {
            c11211 = (C11211) continuation;
            if ((c11211.label & Integer.MIN_VALUE) != 0) {
                c11211.label -= Integer.MIN_VALUE;
            } else {
                c11211 = new C11211(continuation);
            }
        } else {
            c11211 = new C11211(continuation);
        }
        Object obj = c11211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11211.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.hasAttemptedTruncate = true;
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    CaptureHistoryDao captureHistoryDao = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).captureHistoryDao();
                    c11211.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11211.label = 1;
                    if (captureHistoryDao.truncateDb(c11211) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error truncating capture history db: " + ((Result.Error) boxDatabase).getValue());
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error truncating capture history db", e);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateLastUpdatedDate(ItemId.Local local, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C11231 c11231;
        Result.Error error;
        if (continuation instanceof C11231) {
            c11231 = (C11231) continuation;
            if ((c11231.label & Integer.MIN_VALUE) != 0) {
                c11231.label -= Integer.MIN_VALUE;
            } else {
                c11231 = new C11231(continuation);
            }
        } else {
            c11231 = new C11231(continuation);
        }
        C11231 c11232 = c11231;
        Object obj = c11232.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11232.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    CaptureHistoryDao captureHistoryDao = boxDatabase.captureHistoryDao();
                    c11232.L$0 = SpillingKt.nullOutSpilledVariable(local);
                    c11232.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11232.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11232.I$0 = 0;
                    c11232.I$1 = 0;
                    c11232.I$2 = 0;
                    c11232.I$3 = 0;
                    c11232.label = 1;
                    if (CaptureHistoryDao.updateLastUpdatedDate$default(captureHistoryDao, local, null, c11232, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error updating last updated date of capture history item: " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.SaveError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11232.I$3;
            int i3 = c11232.I$2;
            int i4 = c11232.I$1;
            int i5 = c11232.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error updating last updated date of capture history item: " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object updateHistoricalCapture(CaptureHistoryItemEntity captureHistoryItemEntity, Continuation<? super Unit> continuation) {
        C11221 c11221;
        if (continuation instanceof C11221) {
            c11221 = (C11221) continuation;
            if ((c11221.label & Integer.MIN_VALUE) != 0) {
                c11221.label -= Integer.MIN_VALUE;
            } else {
                c11221 = new C11221(continuation);
            }
        } else {
            c11221 = new C11221(continuation);
        }
        Object obj = c11221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11221.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    CaptureHistoryDao captureHistoryDao = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).captureHistoryDao();
                    c11221.L$0 = SpillingKt.nullOutSpilledVariable(captureHistoryItemEntity);
                    c11221.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11221.label = 1;
                    if (captureHistoryDao.updateCaptureHistoryItem(captureHistoryItemEntity, c11221) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error updating capture history item: " + ((Result.Error) boxDatabase).getValue());
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error updating capture history item", e);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object deleteHistoricalCapture(ItemId.Local local, Continuation<? super Unit> continuation) {
        C11201 c11201;
        if (continuation instanceof C11201) {
            c11201 = (C11201) continuation;
            if ((c11201.label & Integer.MIN_VALUE) != 0) {
                c11201.label -= Integer.MIN_VALUE;
            } else {
                c11201 = new C11201(continuation);
            }
        } else {
            c11201 = new C11201(continuation);
        }
        Object obj = c11201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11201.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    CaptureHistoryDao captureHistoryDao = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).captureHistoryDao();
                    c11201.L$0 = SpillingKt.nullOutSpilledVariable(local);
                    c11201.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11201.label = 1;
                    if (captureHistoryDao.deleteCaptureHistoryForId(local, c11201) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error deleting capture history item: " + ((Result.Error) boxDatabase).getValue());
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error updating capture history item", e);
        }
        return Unit.INSTANCE;
    }

    public final Flow<Result<List<ItemId.Local>, CacheError>> getHistoricalCaptureIds() {
        try {
            Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
            if (boxDatabase instanceof Result.Success) {
                final Flow<List<CaptureHistoryItemEntity>> captureHistory = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).captureHistoryDao().getCaptureHistory();
                return new Flow<Result.Success<? extends List<? extends ItemId.Local>>>() { // from class: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$getHistoricalCaptureIds$$inlined$map$1
                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Result.Success<? extends List<? extends ItemId.Local>>> flowCollector, Continuation continuation) {
                        Object objCollect = captureHistory.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$getHistoricalCaptureIds$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$getHistoricalCaptureIds$$inlined$map$1$2$1, reason: invalid class name */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource$getHistoricalCaptureIds$$inlined$map$1$2", f = "CaptureHistoryCacheDataSource.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                                List list = (List) obj;
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                                Iterator<T> it = list.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((CaptureHistoryItemEntity) it.next()).getLocalItemId());
                                }
                                Result.Success success = new Result.Success(arrayList);
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
                };
            }
            if (!(boxDatabase instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error reading capture history: " + ((Result.Error) boxDatabase).getValue());
            return FlowKt.flowOf(new Result.Error(CacheError.ReadError.INSTANCE));
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error reading capture history", e);
            return FlowKt.flowOf(new Result.Error(CacheError.ReadError.INSTANCE));
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c5, code lost:
    
        if (updateLastUpdatedDate(r2, r0) == r1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateLastUpdatedDate(java.lang.String r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource.updateLastUpdatedDate(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c5, code lost:
    
        if (deleteHistoricalCapture(r2, r0) == r1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deleteHistoricalCapture(java.lang.String r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource.deleteHistoricalCapture(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
