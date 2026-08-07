package com.box.android.capture.documentscanning;

import android.app.Application;
import com.box.android.capture.R;
import com.box.android.common.extensions.FileExtensionsKt;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.DocumentScanningError;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ScannedDocumentPage;
import com.box.android.domain.models.capture.CaptureMode;
import com.box.android.domain.models.capture.FlashMode;
import com.box.android.domain.services.ICaptureThumbnailService;
import com.box.android.domain.services.IDocumentScanPageProcessor;
import com.box.android.domain.usecases.documentscanning.DocumentScanUseCase;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.domain.utils.result.Result;
import com.pspdfkit.analytics.Analytics;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScanPageReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0012\u0013\u0014B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$State;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "environment", "Lcom/box/android/capture/documentscanning/DocumentScanningEnvironment;", "<init>", "(Lcom/box/android/capture/documentscanning/DocumentScanningEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "saveDocument", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$SaveDocument;", "(Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$SaveDocument;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processPage", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$PhotoFetched;", "(Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$PhotoFetched;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "State", "ScanPageError", "Action", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScanPageReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final DocumentScanningEnvironment environment;

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ScanPageReducer$processPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScanPageReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ScanPageReducer", f = "ScanPageReducer.kt", i = {0, 1, 1, 1, 1, 1}, l = {380, 382}, m = "processPage", n = {Analytics.Data.ACTION, Analytics.Data.ACTION, "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-ScanPageReducer$processPage$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
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
            return ScanPageReducer.this.processPage(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ScanPageReducer$saveDocument$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScanPageReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ScanPageReducer", f = "ScanPageReducer.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {348, 351, 368}, m = "saveDocument", n = {Analytics.Data.ACTION, Analytics.Data.ACTION, "$this$flatMap$iv", SupportedFileExtensions.PAGES_EXTENSION, "$i$f$flatMap", "$i$a$-flatMap-ScanPageReducer$saveDocument$2", Analytics.Data.ACTION, "$this$map$iv", "it", "$i$f$map", "$i$a$-map-ScanPageReducer$saveDocument$3"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C09801 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09801(Continuation<? super C09801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScanPageReducer.this.saveDocument(null, this);
        }
    }

    public ScanPageReducer(DocumentScanningEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: ScanPageReducer.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010,\u001a\u00020\u000fHÆ\u0003Jk\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000fHÆ\u0001J\u0013\u0010.\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010!¨\u00063"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$State;", "", "flashMode", "Lcom/box/android/domain/models/capture/FlashMode;", "pageCount", "", "lastScannedPage", "Lcom/box/android/domain/models/ScannedDocumentPage;", "outputFile", "Ljava/io/File;", "processingState", "Lcom/box/android/capture/documentscanning/DocumentProcessingState;", "displayedError", "Lcom/box/android/capture/documentscanning/ScanPageReducer$ScanPageError;", "isDiscardingScans", "", "pendingScanEntryReason", "Lcom/box/android/capture/documentscanning/ScanPageEntryReason;", "isAwaitingRestoredScanDecision", "<init>", "(Lcom/box/android/domain/models/capture/FlashMode;ILcom/box/android/domain/models/ScannedDocumentPage;Ljava/io/File;Lcom/box/android/capture/documentscanning/DocumentProcessingState;Lcom/box/android/capture/documentscanning/ScanPageReducer$ScanPageError;ZLcom/box/android/capture/documentscanning/ScanPageEntryReason;Z)V", "getFlashMode", "()Lcom/box/android/domain/models/capture/FlashMode;", "getPageCount", "()I", "getLastScannedPage", "()Lcom/box/android/domain/models/ScannedDocumentPage;", "getOutputFile", "()Ljava/io/File;", "getProcessingState", "()Lcom/box/android/capture/documentscanning/DocumentProcessingState;", "getDisplayedError", "()Lcom/box/android/capture/documentscanning/ScanPageReducer$ScanPageError;", "()Z", "getPendingScanEntryReason", "()Lcom/box/android/capture/documentscanning/ScanPageEntryReason;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final ScanPageError displayedError;
        private final FlashMode flashMode;
        private final boolean isAwaitingRestoredScanDecision;
        private final boolean isDiscardingScans;
        private final ScannedDocumentPage lastScannedPage;
        private final File outputFile;
        private final int pageCount;
        private final ScanPageEntryReason pendingScanEntryReason;
        private final DocumentProcessingState processingState;

        public State() {
            this(null, 0, null, null, null, null, false, null, false, 511, null);
        }

        public static /* synthetic */ State copy$default(State state, FlashMode flashMode, int i, ScannedDocumentPage scannedDocumentPage, File file, DocumentProcessingState documentProcessingState, ScanPageError scanPageError, boolean z, ScanPageEntryReason scanPageEntryReason, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                flashMode = state.flashMode;
            }
            if ((i2 & 2) != 0) {
                i = state.pageCount;
            }
            if ((i2 & 4) != 0) {
                scannedDocumentPage = state.lastScannedPage;
            }
            if ((i2 & 8) != 0) {
                file = state.outputFile;
            }
            if ((i2 & 16) != 0) {
                documentProcessingState = state.processingState;
            }
            if ((i2 & 32) != 0) {
                scanPageError = state.displayedError;
            }
            if ((i2 & 64) != 0) {
                z = state.isDiscardingScans;
            }
            if ((i2 & 128) != 0) {
                scanPageEntryReason = state.pendingScanEntryReason;
            }
            if ((i2 & 256) != 0) {
                z2 = state.isAwaitingRestoredScanDecision;
            }
            ScanPageEntryReason scanPageEntryReason2 = scanPageEntryReason;
            boolean z3 = z2;
            ScanPageError scanPageError2 = scanPageError;
            boolean z4 = z;
            DocumentProcessingState documentProcessingState2 = documentProcessingState;
            ScannedDocumentPage scannedDocumentPage2 = scannedDocumentPage;
            return state.copy(flashMode, i, scannedDocumentPage2, file, documentProcessingState2, scanPageError2, z4, scanPageEntryReason2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FlashMode getFlashMode() {
            return this.flashMode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPageCount() {
            return this.pageCount;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ScannedDocumentPage getLastScannedPage() {
            return this.lastScannedPage;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final File getOutputFile() {
            return this.outputFile;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final DocumentProcessingState getProcessingState() {
            return this.processingState;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final ScanPageError getDisplayedError() {
            return this.displayedError;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsDiscardingScans() {
            return this.isDiscardingScans;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final ScanPageEntryReason getPendingScanEntryReason() {
            return this.pendingScanEntryReason;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getIsAwaitingRestoredScanDecision() {
            return this.isAwaitingRestoredScanDecision;
        }

        public final State copy(FlashMode flashMode, int pageCount, ScannedDocumentPage lastScannedPage, File outputFile, DocumentProcessingState processingState, ScanPageError displayedError, boolean isDiscardingScans, ScanPageEntryReason pendingScanEntryReason, boolean isAwaitingRestoredScanDecision) {
            Intrinsics.checkNotNullParameter(flashMode, "flashMode");
            Intrinsics.checkNotNullParameter(processingState, "processingState");
            return new State(flashMode, pageCount, lastScannedPage, outputFile, processingState, displayedError, isDiscardingScans, pendingScanEntryReason, isAwaitingRestoredScanDecision);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.flashMode == state.flashMode && this.pageCount == state.pageCount && Intrinsics.areEqual(this.lastScannedPage, state.lastScannedPage) && Intrinsics.areEqual(this.outputFile, state.outputFile) && Intrinsics.areEqual(this.processingState, state.processingState) && Intrinsics.areEqual(this.displayedError, state.displayedError) && this.isDiscardingScans == state.isDiscardingScans && this.pendingScanEntryReason == state.pendingScanEntryReason && this.isAwaitingRestoredScanDecision == state.isAwaitingRestoredScanDecision;
        }

        public int hashCode() {
            int iHashCode = ((this.flashMode.hashCode() * 31) + Integer.hashCode(this.pageCount)) * 31;
            ScannedDocumentPage scannedDocumentPage = this.lastScannedPage;
            int iHashCode2 = (iHashCode + (scannedDocumentPage == null ? 0 : scannedDocumentPage.hashCode())) * 31;
            File file = this.outputFile;
            int iHashCode3 = (((iHashCode2 + (file == null ? 0 : file.hashCode())) * 31) + this.processingState.hashCode()) * 31;
            ScanPageError scanPageError = this.displayedError;
            int iHashCode4 = (((iHashCode3 + (scanPageError == null ? 0 : scanPageError.hashCode())) * 31) + Boolean.hashCode(this.isDiscardingScans)) * 31;
            ScanPageEntryReason scanPageEntryReason = this.pendingScanEntryReason;
            return ((iHashCode4 + (scanPageEntryReason != null ? scanPageEntryReason.hashCode() : 0)) * 31) + Boolean.hashCode(this.isAwaitingRestoredScanDecision);
        }

        public String toString() {
            return "State(flashMode=" + this.flashMode + ", pageCount=" + this.pageCount + ", lastScannedPage=" + this.lastScannedPage + ", outputFile=" + this.outputFile + ", processingState=" + this.processingState + ", displayedError=" + this.displayedError + ", isDiscardingScans=" + this.isDiscardingScans + ", pendingScanEntryReason=" + this.pendingScanEntryReason + ", isAwaitingRestoredScanDecision=" + this.isAwaitingRestoredScanDecision + ")";
        }

        public State(FlashMode flashMode, int i, ScannedDocumentPage scannedDocumentPage, File file, DocumentProcessingState processingState, ScanPageError scanPageError, boolean z, ScanPageEntryReason scanPageEntryReason, boolean z2) {
            Intrinsics.checkNotNullParameter(flashMode, "flashMode");
            Intrinsics.checkNotNullParameter(processingState, "processingState");
            this.flashMode = flashMode;
            this.pageCount = i;
            this.lastScannedPage = scannedDocumentPage;
            this.outputFile = file;
            this.processingState = processingState;
            this.displayedError = scanPageError;
            this.isDiscardingScans = z;
            this.pendingScanEntryReason = scanPageEntryReason;
            this.isAwaitingRestoredScanDecision = z2;
        }

        public /* synthetic */ State(FlashMode flashMode, int i, ScannedDocumentPage scannedDocumentPage, File file, DocumentProcessingState.NotProcessing notProcessing, ScanPageError scanPageError, boolean z, ScanPageEntryReason scanPageEntryReason, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? FlashMode.AUTO : flashMode, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : scannedDocumentPage, (i2 & 8) != 0 ? null : file, (i2 & 16) != 0 ? DocumentProcessingState.NotProcessing.INSTANCE : notProcessing, (i2 & 32) != 0 ? null : scanPageError, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? null : scanPageEntryReason, (i2 & 256) != 0 ? false : z2);
        }

        public final FlashMode getFlashMode() {
            return this.flashMode;
        }

        public final int getPageCount() {
            return this.pageCount;
        }

        public final ScannedDocumentPage getLastScannedPage() {
            return this.lastScannedPage;
        }

        public final File getOutputFile() {
            return this.outputFile;
        }

        public final DocumentProcessingState getProcessingState() {
            return this.processingState;
        }

        public final ScanPageError getDisplayedError() {
            return this.displayedError;
        }

        public final boolean isDiscardingScans() {
            return this.isDiscardingScans;
        }

        public final ScanPageEntryReason getPendingScanEntryReason() {
            return this.pendingScanEntryReason;
        }

        public final boolean isAwaitingRestoredScanDecision() {
            return this.isAwaitingRestoredScanDecision;
        }
    }

    /* JADX INFO: compiled from: ScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$ScanPageError;", "", "<init>", "()V", "GenericError", "SkipOrRetryError", "Lcom/box/android/capture/documentscanning/ScanPageReducer$ScanPageError$GenericError;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$ScanPageError$SkipOrRetryError;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ScanPageError {
        public static final int $stable = 0;

        public /* synthetic */ ScanPageError(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$ScanPageError$GenericError;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$ScanPageError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GenericError extends ScanPageError {
            public static final int $stable = 0;
            private final String message;

            public static /* synthetic */ GenericError copy$default(GenericError genericError, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = genericError.message;
                }
                return genericError.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final GenericError copy(String message) {
                return new GenericError(message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof GenericError) && Intrinsics.areEqual(this.message, ((GenericError) other).message);
            }

            public int hashCode() {
                String str = this.message;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "GenericError(message=" + this.message + ")";
            }

            public GenericError(String str) {
                super(null);
                this.message = str;
            }

            public final String getMessage() {
                return this.message;
            }
        }

        private ScanPageError() {
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$ScanPageError$SkipOrRetryError;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$ScanPageError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SkipOrRetryError extends ScanPageError {
            public static final int $stable = 0;
            private final String message;

            public static /* synthetic */ SkipOrRetryError copy$default(SkipOrRetryError skipOrRetryError, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = skipOrRetryError.message;
                }
                return skipOrRetryError.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final SkipOrRetryError copy(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                return new SkipOrRetryError(message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SkipOrRetryError) && Intrinsics.areEqual(this.message, ((SkipOrRetryError) other).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return "SkipOrRetryError(message=" + this.message + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SkipOrRetryError(String message) {
                super(null);
                Intrinsics.checkNotNullParameter(message, "message");
                this.message = message;
            }

            public final String getMessage() {
                return this.message;
            }
        }
    }

    /* JADX INFO: compiled from: ScanPageReducer.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0012\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0012\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'¨\u0006("}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "", "<init>", "()V", "Initialize", "RestoredScanKept", "RestoredScanDiscarded", "DocumentFetched", "ClickThumbnail", "EditScans", "ManualCapturePhoto", "AutoCapturePhoto", "PhotoFetched", "PhotoProcessed", "SaveDocument", "DocumentCreated", "TryDiscardScans", "CancelDiscardScans", "DiscardScans", "Close", "ErrorDismissed", "Error", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$AutoCapturePhoto;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$CancelDiscardScans;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$ClickThumbnail;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$Close;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$DiscardScans;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$DocumentCreated;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$DocumentFetched;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$EditScans;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$Error;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$ErrorDismissed;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$Initialize;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$ManualCapturePhoto;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$PhotoFetched;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$PhotoProcessed;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$RestoredScanDiscarded;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$RestoredScanKept;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$SaveDocument;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$TryDiscardScans;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$Initialize;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "entryReason", "Lcom/box/android/capture/documentscanning/ScanPageEntryReason;", "<init>", "(Lcom/box/android/capture/documentscanning/ScanPageEntryReason;)V", "getEntryReason", "()Lcom/box/android/capture/documentscanning/ScanPageEntryReason;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initialize extends Action {
            public static final int $stable = 0;
            private final ScanPageEntryReason entryReason;

            /* JADX WARN: Multi-variable type inference failed */
            public Initialize() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Initialize copy$default(Initialize initialize, ScanPageEntryReason scanPageEntryReason, int i, Object obj) {
                if ((i & 1) != 0) {
                    scanPageEntryReason = initialize.entryReason;
                }
                return initialize.copy(scanPageEntryReason);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ScanPageEntryReason getEntryReason() {
                return this.entryReason;
            }

            public final Initialize copy(ScanPageEntryReason entryReason) {
                Intrinsics.checkNotNullParameter(entryReason, "entryReason");
                return new Initialize(entryReason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Initialize) && this.entryReason == ((Initialize) other).entryReason;
            }

            public int hashCode() {
                return this.entryReason.hashCode();
            }

            public String toString() {
                return "Initialize(entryReason=" + this.entryReason + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialize(ScanPageEntryReason entryReason) {
                super(null);
                Intrinsics.checkNotNullParameter(entryReason, "entryReason");
                this.entryReason = entryReason;
            }

            public /* synthetic */ Initialize(ScanPageEntryReason scanPageEntryReason, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? ScanPageEntryReason.NewSession : scanPageEntryReason);
            }

            public final ScanPageEntryReason getEntryReason() {
                return this.entryReason;
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$RestoredScanKept;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RestoredScanKept extends Action {
            public static final int $stable = 0;
            public static final RestoredScanKept INSTANCE = new RestoredScanKept();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RestoredScanKept)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1626937584;
            }

            public String toString() {
                return "RestoredScanKept";
            }

            private RestoredScanKept() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$RestoredScanDiscarded;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RestoredScanDiscarded extends Action {
            public static final int $stable = 0;
            public static final RestoredScanDiscarded INSTANCE = new RestoredScanDiscarded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RestoredScanDiscarded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 945896139;
            }

            public String toString() {
                return "RestoredScanDiscarded";
            }

            private RestoredScanDiscarded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$DocumentFetched;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "document", "", "Lcom/box/android/domain/models/ScannedDocumentPage;", "<init>", "(Ljava/util/List;)V", "getDocument", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DocumentFetched extends Action {
            public static final int $stable = 8;
            private final List<ScannedDocumentPage> document;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ DocumentFetched copy$default(DocumentFetched documentFetched, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = documentFetched.document;
                }
                return documentFetched.copy(list);
            }

            public final List<ScannedDocumentPage> component1() {
                return this.document;
            }

            public final DocumentFetched copy(List<ScannedDocumentPage> document) {
                Intrinsics.checkNotNullParameter(document, "document");
                return new DocumentFetched(document);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DocumentFetched) && Intrinsics.areEqual(this.document, ((DocumentFetched) other).document);
            }

            public int hashCode() {
                return this.document.hashCode();
            }

            public String toString() {
                return "DocumentFetched(document=" + this.document + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DocumentFetched(List<ScannedDocumentPage> document) {
                super(null);
                Intrinsics.checkNotNullParameter(document, "document");
                this.document = document;
            }

            public final List<ScannedDocumentPage> getDocument() {
                return this.document;
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$ClickThumbnail;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ClickThumbnail extends Action {
            public static final int $stable = 0;
            public static final ClickThumbnail INSTANCE = new ClickThumbnail();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ClickThumbnail)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1739585437;
            }

            public String toString() {
                return "ClickThumbnail";
            }

            private ClickThumbnail() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$EditScans;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", SupportedFileExtensions.PAGES_EXTENSION, "", "Lcom/box/android/domain/models/ScannedDocumentPage;", "<init>", "(Ljava/util/List;)V", "getPages", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EditScans extends Action {
            public static final int $stable = 8;
            private final List<ScannedDocumentPage> pages;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ EditScans copy$default(EditScans editScans, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = editScans.pages;
                }
                return editScans.copy(list);
            }

            public final List<ScannedDocumentPage> component1() {
                return this.pages;
            }

            public final EditScans copy(List<ScannedDocumentPage> pages) {
                Intrinsics.checkNotNullParameter(pages, "pages");
                return new EditScans(pages);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EditScans) && Intrinsics.areEqual(this.pages, ((EditScans) other).pages);
            }

            public int hashCode() {
                return this.pages.hashCode();
            }

            public String toString() {
                return "EditScans(pages=" + this.pages + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EditScans(List<ScannedDocumentPage> pages) {
                super(null);
                Intrinsics.checkNotNullParameter(pages, "pages");
                this.pages = pages;
            }

            public final List<ScannedDocumentPage> getPages() {
                return this.pages;
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$ManualCapturePhoto;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ManualCapturePhoto extends Action {
            public static final int $stable = 0;
            public static final ManualCapturePhoto INSTANCE = new ManualCapturePhoto();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ManualCapturePhoto)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1120837103;
            }

            public String toString() {
                return "ManualCapturePhoto";
            }

            private ManualCapturePhoto() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$AutoCapturePhoto;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AutoCapturePhoto extends Action {
            public static final int $stable = 0;
            public static final AutoCapturePhoto INSTANCE = new AutoCapturePhoto();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AutoCapturePhoto)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -206414278;
            }

            public String toString() {
                return "AutoCapturePhoto";
            }

            private AutoCapturePhoto() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$PhotoFetched;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "cameraOrientation", "", "outputFile", "Ljava/io/File;", "<init>", "(ILjava/io/File;)V", "getCameraOrientation", "()I", "getOutputFile", "()Ljava/io/File;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PhotoFetched extends Action {
            public static final int $stable = 8;
            private final int cameraOrientation;
            private final File outputFile;

            public static /* synthetic */ PhotoFetched copy$default(PhotoFetched photoFetched, int i, File file, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = photoFetched.cameraOrientation;
                }
                if ((i2 & 2) != 0) {
                    file = photoFetched.outputFile;
                }
                return photoFetched.copy(i, file);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getCameraOrientation() {
                return this.cameraOrientation;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final File getOutputFile() {
                return this.outputFile;
            }

            public final PhotoFetched copy(int cameraOrientation, File outputFile) {
                Intrinsics.checkNotNullParameter(outputFile, "outputFile");
                return new PhotoFetched(cameraOrientation, outputFile);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PhotoFetched)) {
                    return false;
                }
                PhotoFetched photoFetched = (PhotoFetched) other;
                return this.cameraOrientation == photoFetched.cameraOrientation && Intrinsics.areEqual(this.outputFile, photoFetched.outputFile);
            }

            public int hashCode() {
                return (Integer.hashCode(this.cameraOrientation) * 31) + this.outputFile.hashCode();
            }

            public String toString() {
                return "PhotoFetched(cameraOrientation=" + this.cameraOrientation + ", outputFile=" + this.outputFile + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PhotoFetched(int i, File outputFile) {
                super(null);
                Intrinsics.checkNotNullParameter(outputFile, "outputFile");
                this.cameraOrientation = i;
                this.outputFile = outputFile;
            }

            public final int getCameraOrientation() {
                return this.cameraOrientation;
            }

            public final File getOutputFile() {
                return this.outputFile;
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$PhotoProcessed;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "photo", "Lcom/box/android/domain/models/ScannedDocumentPage;", "<init>", "(Lcom/box/android/domain/models/ScannedDocumentPage;)V", "getPhoto", "()Lcom/box/android/domain/models/ScannedDocumentPage;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PhotoProcessed extends Action {
            public static final int $stable = 8;
            private final ScannedDocumentPage photo;

            public static /* synthetic */ PhotoProcessed copy$default(PhotoProcessed photoProcessed, ScannedDocumentPage scannedDocumentPage, int i, Object obj) {
                if ((i & 1) != 0) {
                    scannedDocumentPage = photoProcessed.photo;
                }
                return photoProcessed.copy(scannedDocumentPage);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ScannedDocumentPage getPhoto() {
                return this.photo;
            }

            public final PhotoProcessed copy(ScannedDocumentPage photo) {
                Intrinsics.checkNotNullParameter(photo, "photo");
                return new PhotoProcessed(photo);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PhotoProcessed) && Intrinsics.areEqual(this.photo, ((PhotoProcessed) other).photo);
            }

            public int hashCode() {
                return this.photo.hashCode();
            }

            public String toString() {
                return "PhotoProcessed(photo=" + this.photo + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PhotoProcessed(ScannedDocumentPage photo) {
                super(null);
                Intrinsics.checkNotNullParameter(photo, "photo");
                this.photo = photo;
            }

            public final ScannedDocumentPage getPhoto() {
                return this.photo;
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$SaveDocument;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "ocrOptional", "", "<init>", "(Z)V", "getOcrOptional", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SaveDocument extends Action {
            public static final int $stable = 0;
            private final boolean ocrOptional;

            public SaveDocument() {
                this(false, 1, null);
            }

            public static /* synthetic */ SaveDocument copy$default(SaveDocument saveDocument, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = saveDocument.ocrOptional;
                }
                return saveDocument.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getOcrOptional() {
                return this.ocrOptional;
            }

            public final SaveDocument copy(boolean ocrOptional) {
                return new SaveDocument(ocrOptional);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SaveDocument) && this.ocrOptional == ((SaveDocument) other).ocrOptional;
            }

            public int hashCode() {
                return Boolean.hashCode(this.ocrOptional);
            }

            public String toString() {
                return "SaveDocument(ocrOptional=" + this.ocrOptional + ")";
            }

            public SaveDocument(boolean z) {
                super(null);
                this.ocrOptional = z;
            }

            public /* synthetic */ SaveDocument(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z);
            }

            public final boolean getOcrOptional() {
                return this.ocrOptional;
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$DocumentCreated;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DocumentCreated extends Action {
            public static final int $stable = 8;
            private final File file;

            public static /* synthetic */ DocumentCreated copy$default(DocumentCreated documentCreated, File file, int i, Object obj) {
                if ((i & 1) != 0) {
                    file = documentCreated.file;
                }
                return documentCreated.copy(file);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final File getFile() {
                return this.file;
            }

            public final DocumentCreated copy(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new DocumentCreated(file);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DocumentCreated) && Intrinsics.areEqual(this.file, ((DocumentCreated) other).file);
            }

            public int hashCode() {
                return this.file.hashCode();
            }

            public String toString() {
                return "DocumentCreated(file=" + this.file + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DocumentCreated(File file) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
            }

            public final File getFile() {
                return this.file;
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$TryDiscardScans;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TryDiscardScans extends Action {
            public static final int $stable = 0;
            public static final TryDiscardScans INSTANCE = new TryDiscardScans();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TryDiscardScans)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 549320884;
            }

            public String toString() {
                return "TryDiscardScans";
            }

            private TryDiscardScans() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$CancelDiscardScans;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CancelDiscardScans extends Action {
            public static final int $stable = 0;
            public static final CancelDiscardScans INSTANCE = new CancelDiscardScans();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CancelDiscardScans)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -645145647;
            }

            public String toString() {
                return "CancelDiscardScans";
            }

            private CancelDiscardScans() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$DiscardScans;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DiscardScans extends Action {
            public static final int $stable = 0;
            public static final DiscardScans INSTANCE = new DiscardScans();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DiscardScans)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -705698953;
            }

            public String toString() {
                return "DiscardScans";
            }

            private DiscardScans() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$Close;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Close extends Action {
            public static final int $stable = 0;
            public static final Close INSTANCE = new Close();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Close)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -896120071;
            }

            public String toString() {
                return "Close";
            }

            private Close() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$ErrorDismissed;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ErrorDismissed extends Action {
            public static final int $stable = 0;
            public static final ErrorDismissed INSTANCE = new ErrorDismissed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ErrorDismissed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1689649248;
            }

            public String toString() {
                return "ErrorDismissed";
            }

            private ErrorDismissed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ScanPageReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/documentscanning/ScanPageReducer$Action$Error;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "error", "", "<init>", "(Ljava/lang/Object;)V", "getError", "()Ljava/lang/Object;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends Action {
            public static final int $stable = 8;
            private final Object error;

            public static /* synthetic */ Error copy$default(Error error, Object obj, int i, Object obj2) {
                if ((i & 1) != 0) {
                    obj = error.error;
                }
                return error.copy(obj);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Object getError() {
                return this.error;
            }

            public final Error copy(Object error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new Error(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.error, ((Error) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "Error(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(Object error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final Object getError() {
                return this.error;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        ScanPageError scanPageError;
        ScanPageError.GenericError genericError;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.Initialize) {
            return new ReducerResult<>(new State(this.environment.getCapturePreferencesService().getFlashModeOrDefault(FlashMode.AUTO), 0, null, null, null, null, false, ((Action.Initialize) action).getEntryReason(), false, 382, null), new Effect((Function1) new C09791(null)));
        }
        if (action instanceof Action.DocumentFetched) {
            Action.DocumentFetched documentFetched = (Action.DocumentFetched) action;
            return new ReducerResult<>(State.copy$default(state, null, documentFetched.getDocument().size(), documentFetched.getDocument().isEmpty() ? null : (ScannedDocumentPage) CollectionsKt.last((List) documentFetched.getDocument()), null, null, null, false, null, !documentFetched.getDocument().isEmpty() && state.getPendingScanEntryReason() == ScanPageEntryReason.NewSession, 121, null), null, 2, null);
        }
        if (action instanceof Action.RestoredScanKept) {
            return new ReducerResult<>(State.copy$default(state, null, 0, null, null, null, null, false, null, false, 255, null), null, 2, null);
        }
        if (action instanceof Action.RestoredScanDiscarded) {
            return new ReducerResult<>(State.copy$default(state, null, 0, null, null, null, null, false, null, false, 249, null), Effect.INSTANCE.fireAndForget(new AnonymousClass2(null)));
        }
        if (action instanceof Action.ManualCapturePhoto) {
            this.environment.getScanningHelper().logEvent(BoxAnalyticsParams.EVENT_SCAN_DOCUMENT_MANUAL_TRIGGER);
            return new ReducerResult<>(State.copy$default(state, null, 0, null, this.environment.getScanProcessor().prepareFile(), null, null, false, null, false, 503, null), null, 2, null);
        }
        if (action instanceof Action.AutoCapturePhoto) {
            this.environment.getScanningHelper().logEvent(BoxAnalyticsParams.EVENT_SCAN_DOCUMENT_AUTO_TRIGGER);
            return new ReducerResult<>(State.copy$default(state, null, 0, null, this.environment.getScanProcessor().prepareFile(), null, null, false, null, false, 503, null), null, 2, null);
        }
        if (action instanceof Action.ClickThumbnail) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass3(null)));
        }
        if (action instanceof Action.PhotoFetched) {
            return new ReducerResult<>(State.copy$default(state, null, 0, null, null, new DocumentProcessingState.Processing(this.environment.getScanningHelper().getLocalizedMessage(R.string.document_scan_processing_photo)), null, false, null, false, 495, null), new Effect((Function1) new AnonymousClass4(action, null)));
        }
        if (action instanceof Action.PhotoProcessed) {
            return new ReducerResult<>(State.copy$default(state, null, 0, null, null, DocumentProcessingState.NotProcessing.INSTANCE, null, false, null, false, 495, null), null, 2, null);
        }
        if (action instanceof Action.SaveDocument) {
            return new ReducerResult<>(State.copy$default(state, null, 0, null, null, new DocumentProcessingState.Processing(this.environment.getScanningHelper().getLocalizedMessage(R.string.document_scan_creating_document)), null, false, null, false, 495, null), new Effect((Function1) new AnonymousClass5(action, null)));
        }
        if (action instanceof Action.DocumentCreated) {
            return new ReducerResult<>(State.copy$default(state, null, 0, null, null, DocumentProcessingState.NotProcessing.INSTANCE, null, false, null, false, 233, null), Effect.INSTANCE.fireAndForget(new AnonymousClass6(null)));
        }
        if (action instanceof Action.Error) {
            Action.Error error = (Action.Error) action;
            Object error2 = error.getError();
            if (error2 instanceof DocumentScanningError.OcrNotAvailable) {
                genericError = new ScanPageError.SkipOrRetryError(this.environment.getScanningHelper().getMessageForError((DomainError) error.getError()));
            } else {
                if (error2 instanceof DomainError) {
                    genericError = new ScanPageError.GenericError(this.environment.getScanningHelper().getMessageForError((DomainError) error.getError()));
                } else {
                    scanPageError = null;
                }
                return new ReducerResult<>(State.copy$default(state, null, 0, null, null, DocumentProcessingState.NotProcessing.INSTANCE, scanPageError, false, null, false, 335, null), null, 2, null);
            }
            scanPageError = genericError;
            return new ReducerResult<>(State.copy$default(state, null, 0, null, null, DocumentProcessingState.NotProcessing.INSTANCE, scanPageError, false, null, false, 335, null), null, 2, null);
        }
        if (action instanceof Action.ErrorDismissed) {
            return new ReducerResult<>(State.copy$default(state, null, 0, null, null, null, null, false, null, false, 479, null), null, 2, null);
        }
        if (action instanceof Action.TryDiscardScans) {
            if (state.getPageCount() > 0) {
                return new ReducerResult<>(State.copy$default(state, null, 0, null, null, null, null, true, null, false, 447, null), null, 2, null);
            }
            return new ReducerResult<>(state, new Effect(Action.Close.INSTANCE));
        }
        if (action instanceof Action.CancelDiscardScans) {
            return new ReducerResult<>(State.copy$default(state, null, 0, null, null, null, null, false, null, false, 447, null), null, 2, null);
        }
        if (action instanceof Action.DiscardScans) {
            return new ReducerResult<>(State.copy$default(state, null, 0, null, null, null, null, false, null, false, 185, null), Effect.INSTANCE.fireAndForget(new AnonymousClass7(null)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ScanPageReducer$reduce$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ScanPageReducer$reduce$1", f = "ScanPageReducer.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09791 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        C09791(Continuation<? super C09791> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ScanPageReducer.this.new C09791(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C09791) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ScanPageReducer.this.environment.getDocumentScanUseCase().getScannedPages(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.Error error = (Result) obj;
            if (error instanceof Result.Success) {
                error = new Result.Success(new Action.DocumentFetched((List) ((Result.Success) error).getValue()));
            } else if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(new Action.Error((DomainError) ((Result.Error) error).getValue()));
            }
            Object obj2 = com.box.android.domain.utils.result.ResultKt.get(error);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.box.android.capture.documentscanning.ScanPageReducer.Action");
            return (Action) obj2;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ScanPageReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ScanPageReducer$reduce$2", f = "ScanPageReducer.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ScanPageReducer.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ScanPageReducer.this.environment.getDocumentScanUseCase().deleteAllPages(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ScanPageReducer.this.environment.getScanningHelper().logEvent(BoxAnalyticsParams.EVENT_SCANNED_DOCUMENT_CANCELLED);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ScanPageReducer$reduce$3, reason: invalid class name */
    /* JADX INFO: compiled from: ScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ScanPageReducer$reduce$3", f = "ScanPageReducer.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ScanPageReducer.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ScanPageReducer.this.environment.getDocumentScanUseCase().getScannedPages(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.Error error = (Result) obj;
            if (error instanceof Result.Success) {
                error = new Result.Success(new Action.EditScans((List) ((Result.Success) error).getValue()));
            } else if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(new Action.Error((DomainError) ((Result.Error) error).getValue()));
            }
            Object obj2 = com.box.android.domain.utils.result.ResultKt.get(error);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.box.android.capture.documentscanning.ScanPageReducer.Action");
            return (Action) obj2;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ScanPageReducer$reduce$4, reason: invalid class name */
    /* JADX INFO: compiled from: ScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ScanPageReducer$reduce$4", f = "ScanPageReducer.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Action action, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ScanPageReducer.this.new AnonymousClass4(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objProcessPage = ScanPageReducer.this.processPage((Action.PhotoFetched) this.$action, this);
            return objProcessPage == coroutine_suspended ? coroutine_suspended : objProcessPage;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ScanPageReducer$reduce$5, reason: invalid class name */
    /* JADX INFO: compiled from: ScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ScanPageReducer$reduce$5", f = "ScanPageReducer.kt", i = {}, l = {275}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Action action, Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ScanPageReducer.this.new AnonymousClass5(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objSaveDocument = ScanPageReducer.this.saveDocument((Action.SaveDocument) this.$action, this);
            return objSaveDocument == coroutine_suspended ? coroutine_suspended : objSaveDocument;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ScanPageReducer$reduce$6, reason: invalid class name */
    /* JADX INFO: compiled from: ScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ScanPageReducer$reduce$6", f = "ScanPageReducer.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ScanPageReducer.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ScanPageReducer.this.environment.getDocumentScanUseCase().deleteAllPages(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ScanPageReducer$reduce$7, reason: invalid class name */
    /* JADX INFO: compiled from: ScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ScanPageReducer$reduce$7", f = "ScanPageReducer.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ScanPageReducer.this.new AnonymousClass7(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ScanPageReducer.this.environment.getDocumentScanUseCase().deleteAllPages(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ScanPageReducer.this.environment.getScanningHelper().logEvent(BoxAnalyticsParams.EVENT_SCANNED_DOCUMENT_CANCELLED);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:32:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:35:0x0101  */
    /* JADX WARN: Code duplicated, block: B:42:0x0119  */
    /* JADX WARN: Code duplicated, block: B:45:0x015d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0172  */
    /* JADX WARN: Code duplicated, block: B:52:0x017b  */
    /* JADX WARN: Code duplicated, block: B:54:0x017f  */
    /* JADX WARN: Code duplicated, block: B:57:0x019e  */
    /* JADX WARN: Code duplicated, block: B:59:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object saveDocument(Action.SaveDocument saveDocument, Continuation<? super Action> continuation) {
        C09801 c09801;
        Result.Error error;
        Action.SaveDocument saveDocument2;
        List<ScannedDocumentPage> list;
        Pair pair;
        ICaptureThumbnailService captureThumbnailService;
        String enhancedImagePath;
        String strComputeFileSha1;
        Pair pair2;
        if (continuation instanceof C09801) {
            c09801 = (C09801) continuation;
            if ((c09801.label & Integer.MIN_VALUE) != 0) {
                c09801.label -= Integer.MIN_VALUE;
            } else {
                c09801 = new C09801(continuation);
            }
        } else {
            c09801 = new C09801(continuation);
        }
        C09801 c09802 = c09801;
        Object scannedPages = c09802.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09802.label;
        if (i == 0) {
            ResultKt.throwOnFailure(scannedPages);
            DocumentScanUseCase documentScanUseCase = this.environment.getDocumentScanUseCase();
            c09802.L$0 = saveDocument;
            c09802.label = 1;
            scannedPages = documentScanUseCase.getScannedPages(c09802);
            if (scannedPages != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            saveDocument = (Action.SaveDocument) c09802.L$0;
            ResultKt.throwOnFailure(scannedPages);
        } else {
            if (i == 2) {
                int i2 = c09802.I$1;
                int i3 = c09802.I$0;
                list = (List) c09802.L$2;
                saveDocument2 = (Action.SaveDocument) c09802.L$0;
                ResultKt.throwOnFailure(scannedPages);
                error = (Result) scannedPages;
                if (error instanceof Result.Success) {
                    error = new Result.Success(TuplesKt.to(list, (File) ((Result.Success) error).getValue()));
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                saveDocument = saveDocument2;
                if (error instanceof Result.Success) {
                    pair = (Pair) ((Result.Success) error).getValue();
                    captureThumbnailService = this.environment.getCaptureThumbnailService();
                    enhancedImagePath = ((ScannedDocumentPage) CollectionsKt.first((List) pair.getFirst())).getEnhancedImagePath();
                    strComputeFileSha1 = FileExtensionsKt.computeFileSha1((File) pair.getSecond());
                    c09802.L$0 = SpillingKt.nullOutSpilledVariable(saveDocument);
                    c09802.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c09802.L$2 = pair;
                    c09802.I$0 = 0;
                    c09802.I$1 = 0;
                    c09802.label = 3;
                    if (captureThumbnailService.saveThumbnail(enhancedImagePath, strComputeFileSha1, c09802) != coroutine_suspended) {
                        pair2 = pair;
                    }
                    return coroutine_suspended;
                }
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!(error instanceof Result.Success)) {
                    if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    error = new Result.Error(new Action.Error(((Result.Error) error).getValue()));
                }
                Object obj = com.box.android.domain.utils.result.ResultKt.get(error);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.box.android.capture.documentscanning.ScanPageReducer.Action");
                return (Action) obj;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c09802.I$1;
            int i5 = c09802.I$0;
            pair2 = (Pair) c09802.L$2;
            ResultKt.throwOnFailure(scannedPages);
        }
        error = new Result.Success(new Action.DocumentCreated((File) pair2.getSecond()));
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(new Action.Error(((Result.Error) error).getValue()));
        }
        Object obj2 = com.box.android.domain.utils.result.ResultKt.get(error);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.box.android.capture.documentscanning.ScanPageReducer.Action");
        return (Action) obj2;
        error = (Result) scannedPages;
        if (error instanceof Result.Success) {
            List<ScannedDocumentPage> list2 = (List) ((Result.Success) error).getValue();
            if (!list2.isEmpty()) {
                IDocumentScanPageProcessor scanProcessor = this.environment.getScanProcessor();
                String localizedMessage = this.environment.getScanningHelper().getLocalizedMessage(R.string.document_scan_title);
                File newFile = this.environment.getCaptureUploadFileManager().getNewFile(CaptureMode.SCAN);
                boolean ocrOptional = saveDocument.getOcrOptional();
                Application application = ApplicationProvider.getApplication();
                c09802.L$0 = SpillingKt.nullOutSpilledVariable(saveDocument);
                c09802.L$1 = SpillingKt.nullOutSpilledVariable(error);
                c09802.L$2 = list2;
                c09802.I$0 = 0;
                c09802.I$1 = 0;
                c09802.label = 2;
                scannedPages = scanProcessor.createDocument(list2, localizedMessage, newFile, ocrOptional, application, c09802);
                if (scannedPages != coroutine_suspended) {
                    saveDocument2 = saveDocument;
                    list = list2;
                    error = (Result) scannedPages;
                    if (error instanceof Result.Success) {
                        error = new Result.Success(TuplesKt.to(list, (File) ((Result.Success) error).getValue()));
                    } else if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    saveDocument = saveDocument2;
                }
            } else {
                error = new Result.Error(Unit.INSTANCE);
            }
            return coroutine_suspended;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error instanceof Result.Success) {
            pair = (Pair) ((Result.Success) error).getValue();
            captureThumbnailService = this.environment.getCaptureThumbnailService();
            enhancedImagePath = ((ScannedDocumentPage) CollectionsKt.first((List) pair.getFirst())).getEnhancedImagePath();
            strComputeFileSha1 = FileExtensionsKt.computeFileSha1((File) pair.getSecond());
            c09802.L$0 = SpillingKt.nullOutSpilledVariable(saveDocument);
            c09802.L$1 = SpillingKt.nullOutSpilledVariable(error);
            c09802.L$2 = pair;
            c09802.I$0 = 0;
            c09802.I$1 = 0;
            c09802.label = 3;
            if (captureThumbnailService.saveThumbnail(enhancedImagePath, strComputeFileSha1, c09802) != coroutine_suspended) {
                pair2 = pair;
                error = new Result.Success(new Action.DocumentCreated((File) pair2.getSecond()));
            }
            return coroutine_suspended;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(new Action.Error(((Result.Error) error).getValue()));
        }
        Object obj3 = com.box.android.domain.utils.result.ResultKt.get(error);
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.box.android.capture.documentscanning.ScanPageReducer.Action");
        return (Action) obj3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:30:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00db  */
    /* JADX WARN: Code duplicated, block: B:37:0x00df  */
    /* JADX WARN: Code duplicated, block: B:40:0x0100  */
    /* JADX WARN: Code duplicated, block: B:42:0x0106  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ae, code lost:
    
        if (r8 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processPage(com.box.android.capture.documentscanning.ScanPageReducer.Action.PhotoFetched r7, kotlin.coroutines.Continuation<? super com.box.android.capture.documentscanning.ScanPageReducer.Action> r8) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.documentscanning.ScanPageReducer.processPage(com.box.android.capture.documentscanning.ScanPageReducer$Action$PhotoFetched, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
