package com.box.android.capture.documentscanning;

import android.app.Application;
import com.box.android.capture.R;
import com.box.android.capture.documentscanning.logic.EditScannedPageUtilsKt;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.DocumentPageFilterType;
import com.box.android.domain.models.DocumentPosition;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ScannedDocumentPage;
import com.box.android.domain.usecases.documentscanning.DocumentScanUseCase;
import com.box.android.domain.utils.result.Result;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Token;
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
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReviewScanPageReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0019\u001aB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016JX\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\u0016H\u0082@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$State;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "environment", "Lcom/box/android/capture/documentscanning/DocumentScanningEnvironment;", "<init>", "(Lcom/box/android/capture/documentscanning/DocumentScanningEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "updatePage", "analyticsParam", "", "newAngle", "", "newFilterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "newDocumentPosition", "Lcom/box/android/domain/models/DocumentPosition;", "mapSuccess", "Lkotlin/Function1;", "Lcom/box/android/domain/models/ScannedDocumentPage;", "(Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$State;Ljava/lang/String;Ljava/lang/Integer;Lcom/box/android/domain/models/DocumentPageFilterType;Lcom/box/android/domain/models/DocumentPosition;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "State", "Action", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReviewScanPageReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final DocumentScanningEnvironment environment;

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ReviewScanPageReducer$updatePage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ReviewScanPageReducer", f = "ReviewScanPageReducer.kt", i = {0, 0, 0, 0, 0, 0}, l = {209}, m = "updatePage", n = {"state", "analyticsParam", "newAngle", "newFilterType", "newDocumentPosition", "mapSuccess"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class C09771 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C09771(Continuation<? super C09771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReviewScanPageReducer.this.updatePage(null, null, null, null, null, null, this);
        }
    }

    public ReviewScanPageReducer(DocumentScanningEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$State;", "", "scannedPage", "Lcom/box/android/domain/models/ScannedDocumentPage;", "processingState", "Lcom/box/android/capture/documentscanning/DocumentProcessingState;", "displayedError", "", "isCropping", "", "<init>", "(Lcom/box/android/domain/models/ScannedDocumentPage;Lcom/box/android/capture/documentscanning/DocumentProcessingState;Ljava/lang/String;Z)V", "getScannedPage", "()Lcom/box/android/domain/models/ScannedDocumentPage;", "getProcessingState", "()Lcom/box/android/capture/documentscanning/DocumentProcessingState;", "getDisplayedError", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final String displayedError;
        private final boolean isCropping;
        private final DocumentProcessingState processingState;
        private final ScannedDocumentPage scannedPage;

        public static /* synthetic */ State copy$default(State state, ScannedDocumentPage scannedDocumentPage, DocumentProcessingState documentProcessingState, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                scannedDocumentPage = state.scannedPage;
            }
            if ((i & 2) != 0) {
                documentProcessingState = state.processingState;
            }
            if ((i & 4) != 0) {
                str = state.displayedError;
            }
            if ((i & 8) != 0) {
                z = state.isCropping;
            }
            return state.copy(scannedDocumentPage, documentProcessingState, str, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ScannedDocumentPage getScannedPage() {
            return this.scannedPage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DocumentProcessingState getProcessingState() {
            return this.processingState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDisplayedError() {
            return this.displayedError;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsCropping() {
            return this.isCropping;
        }

        public final State copy(ScannedDocumentPage scannedPage, DocumentProcessingState processingState, String displayedError, boolean isCropping) {
            Intrinsics.checkNotNullParameter(scannedPage, "scannedPage");
            Intrinsics.checkNotNullParameter(processingState, "processingState");
            return new State(scannedPage, processingState, displayedError, isCropping);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.scannedPage, state.scannedPage) && Intrinsics.areEqual(this.processingState, state.processingState) && Intrinsics.areEqual(this.displayedError, state.displayedError) && this.isCropping == state.isCropping;
        }

        public int hashCode() {
            int iHashCode = ((this.scannedPage.hashCode() * 31) + this.processingState.hashCode()) * 31;
            String str = this.displayedError;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isCropping);
        }

        public String toString() {
            return "State(scannedPage=" + this.scannedPage + ", processingState=" + this.processingState + ", displayedError=" + this.displayedError + ", isCropping=" + this.isCropping + ")";
        }

        public State(ScannedDocumentPage scannedPage, DocumentProcessingState processingState, String str, boolean z) {
            Intrinsics.checkNotNullParameter(scannedPage, "scannedPage");
            Intrinsics.checkNotNullParameter(processingState, "processingState");
            this.scannedPage = scannedPage;
            this.processingState = processingState;
            this.displayedError = str;
            this.isCropping = z;
        }

        public final ScannedDocumentPage getScannedPage() {
            return this.scannedPage;
        }

        public /* synthetic */ State(ScannedDocumentPage scannedDocumentPage, DocumentProcessingState.NotProcessing notProcessing, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(scannedDocumentPage, (i & 2) != 0 ? DocumentProcessingState.NotProcessing.INSTANCE : notProcessing, (i & 4) != 0 ? null : str, (i & 8) != 0 ? false : z);
        }

        public final DocumentProcessingState getProcessingState() {
            return this.processingState;
        }

        public final String getDisplayedError() {
            return this.displayedError;
        }

        public final boolean isCropping() {
            return this.isCropping;
        }
    }

    /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "", "<init>", "()V", "UserAcceptedPhoto", "UserRejectedPhoto", "PhotoDeleted", "PhotoAdded", "Error", "RotateImage", "CropImage", "CancelCropping", "Cropped", "FilterImage", "ImageUpdated", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$CancelCropping;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$CropImage;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$Cropped;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$Error;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$FilterImage;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$ImageUpdated;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$PhotoAdded;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$PhotoDeleted;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$RotateImage;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$UserAcceptedPhoto;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$UserRejectedPhoto;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$UserAcceptedPhoto;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "documentPosition", "Lcom/box/android/domain/models/DocumentPosition;", "<init>", "(Lcom/box/android/domain/models/DocumentPosition;)V", "getDocumentPosition", "()Lcom/box/android/domain/models/DocumentPosition;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UserAcceptedPhoto extends Action {
            public static final int $stable = 8;
            private final DocumentPosition documentPosition;

            public static /* synthetic */ UserAcceptedPhoto copy$default(UserAcceptedPhoto userAcceptedPhoto, DocumentPosition documentPosition, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentPosition = userAcceptedPhoto.documentPosition;
                }
                return userAcceptedPhoto.copy(documentPosition);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentPosition getDocumentPosition() {
                return this.documentPosition;
            }

            public final UserAcceptedPhoto copy(DocumentPosition documentPosition) {
                Intrinsics.checkNotNullParameter(documentPosition, "documentPosition");
                return new UserAcceptedPhoto(documentPosition);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UserAcceptedPhoto) && Intrinsics.areEqual(this.documentPosition, ((UserAcceptedPhoto) other).documentPosition);
            }

            public int hashCode() {
                return this.documentPosition.hashCode();
            }

            public String toString() {
                return "UserAcceptedPhoto(documentPosition=" + this.documentPosition + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UserAcceptedPhoto(DocumentPosition documentPosition) {
                super(null);
                Intrinsics.checkNotNullParameter(documentPosition, "documentPosition");
                this.documentPosition = documentPosition;
            }

            public final DocumentPosition getDocumentPosition() {
                return this.documentPosition;
            }
        }

        /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$UserRejectedPhoto;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UserRejectedPhoto extends Action {
            public static final int $stable = 0;
            public static final UserRejectedPhoto INSTANCE = new UserRejectedPhoto();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UserRejectedPhoto)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1488494850;
            }

            public String toString() {
                return "UserRejectedPhoto";
            }

            private UserRejectedPhoto() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$PhotoDeleted;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PhotoDeleted extends Action {
            public static final int $stable = 0;
            public static final PhotoDeleted INSTANCE = new PhotoDeleted();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PhotoDeleted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -794903762;
            }

            public String toString() {
                return "PhotoDeleted";
            }

            private PhotoDeleted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$PhotoAdded;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PhotoAdded extends Action {
            public static final int $stable = 0;
            public static final PhotoAdded INSTANCE = new PhotoAdded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PhotoAdded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1176251733;
            }

            public String toString() {
                return "PhotoAdded";
            }

            private PhotoAdded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$Error;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ Error copy$default(Error error, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = error.error;
                }
                return error.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final Error copy(DomainError error) {
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
            public Error(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$RotateImage;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RotateImage extends Action {
            public static final int $stable = 0;
            public static final RotateImage INSTANCE = new RotateImage();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RotateImage)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -917897671;
            }

            public String toString() {
                return "RotateImage";
            }

            private RotateImage() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$CropImage;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CropImage extends Action {
            public static final int $stable = 0;
            public static final CropImage INSTANCE = new CropImage();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CropImage)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -56810396;
            }

            public String toString() {
                return "CropImage";
            }

            private CropImage() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$CancelCropping;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CancelCropping extends Action {
            public static final int $stable = 0;
            public static final CancelCropping INSTANCE = new CancelCropping();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CancelCropping)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1565543555;
            }

            public String toString() {
                return "CancelCropping";
            }

            private CancelCropping() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$Cropped;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "documentPosition", "Lcom/box/android/domain/models/DocumentPosition;", "<init>", "(Lcom/box/android/domain/models/DocumentPosition;)V", "getDocumentPosition", "()Lcom/box/android/domain/models/DocumentPosition;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Cropped extends Action {
            public static final int $stable = 8;
            private final DocumentPosition documentPosition;

            public static /* synthetic */ Cropped copy$default(Cropped cropped, DocumentPosition documentPosition, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentPosition = cropped.documentPosition;
                }
                return cropped.copy(documentPosition);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentPosition getDocumentPosition() {
                return this.documentPosition;
            }

            public final Cropped copy(DocumentPosition documentPosition) {
                Intrinsics.checkNotNullParameter(documentPosition, "documentPosition");
                return new Cropped(documentPosition);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Cropped) && Intrinsics.areEqual(this.documentPosition, ((Cropped) other).documentPosition);
            }

            public int hashCode() {
                return this.documentPosition.hashCode();
            }

            public String toString() {
                return "Cropped(documentPosition=" + this.documentPosition + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Cropped(DocumentPosition documentPosition) {
                super(null);
                Intrinsics.checkNotNullParameter(documentPosition, "documentPosition");
                this.documentPosition = documentPosition;
            }

            public final DocumentPosition getDocumentPosition() {
                return this.documentPosition;
            }
        }

        /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$FilterImage;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "filterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "<init>", "(Lcom/box/android/domain/models/DocumentPageFilterType;)V", "getFilterType", "()Lcom/box/android/domain/models/DocumentPageFilterType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FilterImage extends Action {
            public static final int $stable = 0;
            private final DocumentPageFilterType filterType;

            public static /* synthetic */ FilterImage copy$default(FilterImage filterImage, DocumentPageFilterType documentPageFilterType, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentPageFilterType = filterImage.filterType;
                }
                return filterImage.copy(documentPageFilterType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentPageFilterType getFilterType() {
                return this.filterType;
            }

            public final FilterImage copy(DocumentPageFilterType filterType) {
                Intrinsics.checkNotNullParameter(filterType, "filterType");
                return new FilterImage(filterType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FilterImage) && this.filterType == ((FilterImage) other).filterType;
            }

            public int hashCode() {
                return this.filterType.hashCode();
            }

            public String toString() {
                return "FilterImage(filterType=" + this.filterType + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FilterImage(DocumentPageFilterType filterType) {
                super(null);
                Intrinsics.checkNotNullParameter(filterType, "filterType");
                this.filterType = filterType;
            }

            public final DocumentPageFilterType getFilterType() {
                return this.filterType;
            }
        }

        /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action$ImageUpdated;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "updatedPage", "Lcom/box/android/domain/models/ScannedDocumentPage;", "<init>", "(Lcom/box/android/domain/models/ScannedDocumentPage;)V", "getUpdatedPage", "()Lcom/box/android/domain/models/ScannedDocumentPage;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ImageUpdated extends Action {
            public static final int $stable = 8;
            private final ScannedDocumentPage updatedPage;

            public static /* synthetic */ ImageUpdated copy$default(ImageUpdated imageUpdated, ScannedDocumentPage scannedDocumentPage, int i, Object obj) {
                if ((i & 1) != 0) {
                    scannedDocumentPage = imageUpdated.updatedPage;
                }
                return imageUpdated.copy(scannedDocumentPage);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ScannedDocumentPage getUpdatedPage() {
                return this.updatedPage;
            }

            public final ImageUpdated copy(ScannedDocumentPage updatedPage) {
                Intrinsics.checkNotNullParameter(updatedPage, "updatedPage");
                return new ImageUpdated(updatedPage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ImageUpdated) && Intrinsics.areEqual(this.updatedPage, ((ImageUpdated) other).updatedPage);
            }

            public int hashCode() {
                return this.updatedPage.hashCode();
            }

            public String toString() {
                return "ImageUpdated(updatedPage=" + this.updatedPage + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ImageUpdated(ScannedDocumentPage updatedPage) {
                super(null);
                Intrinsics.checkNotNullParameter(updatedPage, "updatedPage");
                this.updatedPage = updatedPage;
            }

            public final ScannedDocumentPage getUpdatedPage() {
                return this.updatedPage;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.UserAcceptedPhoto) {
            return new ReducerResult<>(State.copy$default(state, null, new DocumentProcessingState.Processing(this.environment.getScanningHelper().getLocalizedMessage(R.string.saving_image)), null, false, 13, null), new Effect((Function1) new AnonymousClass1(state, action, null)));
        }
        if (action instanceof Action.UserRejectedPhoto) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass2(state, null)));
        }
        if (action instanceof Action.Error) {
            return new ReducerResult<>(State.copy$default(state, null, DocumentProcessingState.NotProcessing.INSTANCE, this.environment.getScanningHelper().getMessageForError(((Action.Error) action).getError()), false, 9, null), null, 2, null);
        }
        if (action instanceof Action.RotateImage) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass3(state, this, null)));
        }
        if (action instanceof Action.FilterImage) {
            if (state.getScannedPage().getFilterType() != ((Action.FilterImage) action).getFilterType()) {
                return new ReducerResult<>(State.copy$default(state, null, new DocumentProcessingState.Processing(null), null, false, 13, null), new Effect((Function1) new AnonymousClass4(state, action, null)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.CropImage) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, true, 7, null), null, 2, null);
        }
        if (action instanceof Action.CancelCropping) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, 7, null), null, 2, null);
        }
        if (action instanceof Action.Cropped) {
            if (!Intrinsics.areEqual(state.getScannedPage().getQuadrangle(), ((Action.Cropped) action).getDocumentPosition())) {
                return new ReducerResult<>(State.copy$default(state, null, new DocumentProcessingState.Processing(null), null, false, 13, null), new Effect((Function1) new AnonymousClass5(state, action, null)));
            }
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, 7, null), null, 2, null);
        }
        if (action instanceof Action.ImageUpdated) {
            return new ReducerResult<>(State.copy$default(state, ((Action.ImageUpdated) action).getUpdatedPage(), DocumentProcessingState.NotProcessing.INSTANCE, null, false, 4, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ReviewScanPageReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ReviewScanPageReducer$reduce$1", f = "ReviewScanPageReducer.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Action action, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ReviewScanPageReducer.this.new AnonymousClass1(this.$state, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            Object objUpdatePage$default = ReviewScanPageReducer.updatePage$default(ReviewScanPageReducer.this, this.$state, BoxAnalyticsParams.EVENT_SCAN_DOCUMENT_USE_PHOTO, null, null, ((Action.UserAcceptedPhoto) this.$action).getDocumentPosition(), new Function1() { // from class: com.box.android.capture.documentscanning.ReviewScanPageReducer$reduce$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ReviewScanPageReducer.AnonymousClass1.invokeSuspend$lambda$0((ScannedDocumentPage) obj2);
                }
            }, this, 12, null);
            return objUpdatePage$default == coroutine_suspended ? coroutine_suspended : objUpdatePage$default;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Action invokeSuspend$lambda$0(ScannedDocumentPage scannedDocumentPage) {
            return Action.PhotoAdded.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ReviewScanPageReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ReviewScanPageReducer$reduce$2", f = "ReviewScanPageReducer.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(State state, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ReviewScanPageReducer.this.new AnonymousClass2(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ReviewScanPageReducer.this.environment.getDocumentScanUseCase().deletePage(this.$state.getScannedPage(), this);
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
                error = new Result.Success(Action.PhotoDeleted.INSTANCE);
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
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.box.android.capture.documentscanning.ReviewScanPageReducer.Action");
            return (Action) obj2;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ReviewScanPageReducer$reduce$3, reason: invalid class name */
    /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ReviewScanPageReducer$reduce$3", f = "ReviewScanPageReducer.kt", i = {0}, l = {Token.SET_REF_OP}, m = "invokeSuspend", n = {"newAngle"}, s = {"I$0"}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int I$0;
        int label;
        final /* synthetic */ ReviewScanPageReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(State state, ReviewScanPageReducer reviewScanPageReducer, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$state = state;
            this.this$0 = reviewScanPageReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass3(this.$state, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            int angleForRotating90CCW = EditScannedPageUtilsKt.getAngleForRotating90CCW(this.$state.getScannedPage().getRotationAngle());
            this.I$0 = angleForRotating90CCW;
            this.label = 1;
            Object objUpdatePage$default = ReviewScanPageReducer.updatePage$default(this.this$0, this.$state, BoxAnalyticsParams.EVENT_SCAN_DOCUMENT_CHANGE_ROTATION, Boxing.boxInt(angleForRotating90CCW), null, null, null, this, 56, null);
            return objUpdatePage$default == coroutine_suspended ? coroutine_suspended : objUpdatePage$default;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ReviewScanPageReducer$reduce$4, reason: invalid class name */
    /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ReviewScanPageReducer$reduce$4", f = "ReviewScanPageReducer.kt", i = {}, l = {Token.SETCONST}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(State state, Action action, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ReviewScanPageReducer.this.new AnonymousClass4(this.$state, this.$action, continuation);
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
            Object objUpdatePage$default = ReviewScanPageReducer.updatePage$default(ReviewScanPageReducer.this, this.$state, BoxAnalyticsParams.EVENT_SCAN_DOCUMENT_CHANGE_FILTER, null, ((Action.FilterImage) this.$action).getFilterType(), null, null, this, 52, null);
            return objUpdatePage$default == coroutine_suspended ? coroutine_suspended : objUpdatePage$default;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ReviewScanPageReducer$reduce$5, reason: invalid class name */
    /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.ReviewScanPageReducer$reduce$5", f = "ReviewScanPageReducer.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(State state, Action action, Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ReviewScanPageReducer.this.new AnonymousClass5(this.$state, this.$action, continuation);
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
            Object objUpdatePage$default = ReviewScanPageReducer.updatePage$default(ReviewScanPageReducer.this, this.$state, BoxAnalyticsParams.EVENT_SCAN_DOCUMENT_CHANGE_CROP, null, null, ((Action.Cropped) this.$action).getDocumentPosition(), null, this, 44, null);
            return objUpdatePage$default == coroutine_suspended ? coroutine_suspended : objUpdatePage$default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updatePage(State state, String str, Integer num, DocumentPageFilterType documentPageFilterType, DocumentPosition documentPosition, Function1<? super ScannedDocumentPage, ? extends Action> function1, Continuation<? super Action> continuation) {
        C09771 c09771;
        if (continuation instanceof C09771) {
            c09771 = (C09771) continuation;
            if ((c09771.label & Integer.MIN_VALUE) != 0) {
                c09771.label -= Integer.MIN_VALUE;
            } else {
                c09771 = new C09771(continuation);
            }
        } else {
            c09771 = new C09771(continuation);
        }
        C09771 c09772 = c09771;
        Object objUpdateScannedPage = c09772.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09772.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUpdateScannedPage);
            this.environment.getScanningHelper().logEvent(str);
            DocumentScanUseCase documentScanUseCase = this.environment.getDocumentScanUseCase();
            Application application = ApplicationProvider.getApplication();
            ScannedDocumentPage scannedPage = state.getScannedPage();
            c09772.L$0 = SpillingKt.nullOutSpilledVariable(state);
            c09772.L$1 = SpillingKt.nullOutSpilledVariable(str);
            c09772.L$2 = SpillingKt.nullOutSpilledVariable(num);
            c09772.L$3 = SpillingKt.nullOutSpilledVariable(documentPageFilterType);
            c09772.L$4 = SpillingKt.nullOutSpilledVariable(documentPosition);
            c09772.L$5 = function1;
            c09772.label = 1;
            objUpdateScannedPage = documentScanUseCase.updateScannedPage(application, scannedPage, documentPosition, documentPageFilterType, num, c09772);
            if (objUpdateScannedPage == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1 = (Function1) c09772.L$5;
            ResultKt.throwOnFailure(objUpdateScannedPage);
        }
        Result.Error error = (Result) objUpdateScannedPage;
        if (error instanceof Result.Success) {
            error = new Result.Success(function1.invoke((ScannedDocumentPage) ((Result.Success) error).getValue()));
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(new Action.Error((DomainError) ((Result.Error) error).getValue()));
        }
        Object obj = com.box.android.domain.utils.result.ResultKt.get(error);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.box.android.capture.documentscanning.ReviewScanPageReducer.Action");
        return (Action) obj;
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.ReviewScanPageReducer$updatePage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReviewScanPageReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C09782 extends FunctionReferenceImpl implements Function1<ScannedDocumentPage, Action.ImageUpdated> {
        public static final C09782 INSTANCE = new C09782();

        C09782() {
            super(1, Action.ImageUpdated.class, "<init>", "<init>(Lcom/box/android/domain/models/ScannedDocumentPage;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Action.ImageUpdated invoke(ScannedDocumentPage p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new Action.ImageUpdated(p0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object updatePage$default(ReviewScanPageReducer reviewScanPageReducer, State state, String str, Integer num, DocumentPageFilterType documentPageFilterType, DocumentPosition documentPosition, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            documentPageFilterType = null;
        }
        if ((i & 16) != 0) {
            documentPosition = null;
        }
        if ((i & 32) != 0) {
            function1 = C09782.INSTANCE;
        }
        return reviewScanPageReducer.updatePage(state, str, num, documentPageFilterType, documentPosition, function1, continuation);
    }
}
