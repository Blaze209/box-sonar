package com.box.android.capture.documentscanning;

import android.app.Application;
import com.box.android.capture.documentscanning.logic.EditScannedPageUtilsKt;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
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
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: EditScanPageReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0018\u0019\u001aB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0082@¢\u0006\u0002\u0010\rJB\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0082@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$State;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "environment", "Lcom/box/android/capture/documentscanning/DocumentScanningEnvironment;", "<init>", "(Lcom/box/android/capture/documentscanning/DocumentScanningEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "deletePage", "(Lcom/box/android/capture/documentscanning/EditScanPageReducer$State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePage", "analyticsParam", "", "newAngle", "", "newFilterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "newDocumentPosition", "Lcom/box/android/domain/models/DocumentPosition;", "(Lcom/box/android/capture/documentscanning/EditScanPageReducer$State;Ljava/lang/String;Ljava/lang/Integer;Lcom/box/android/domain/models/DocumentPageFilterType;Lcom/box/android/domain/models/DocumentPosition;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "State", "Action", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EditScanPageReducer implements Reducable<State, Action> {
    private static final String PAGES_UPDATE_ID = "pages_update_id";
    private final DocumentScanningEnvironment environment;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.EditScanPageReducer$deletePage$1, reason: invalid class name */
    /* JADX INFO: compiled from: EditScanPageReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.EditScanPageReducer", f = "EditScanPageReducer.kt", i = {0, 0}, l = {200}, m = "deletePage", n = {"state", "currentPage"}, s = {"L$0", "L$1"}, v = 1)
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
            return EditScanPageReducer.this.deletePage(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.EditScanPageReducer$updatePage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EditScanPageReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.EditScanPageReducer", f = "EditScanPageReducer.kt", i = {0, 0, 0, 0, 0}, l = {220}, m = "updatePage", n = {"state", "analyticsParam", "newAngle", "newFilterType", "newDocumentPosition"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class C09761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C09761(Continuation<? super C09761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EditScanPageReducer.this.updatePage(null, null, null, null, null, this);
        }
    }

    public EditScanPageReducer(DocumentScanningEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: EditScanPageReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003JC\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020\fHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$State;", "", "scannedPages", "", "Lcom/box/android/domain/models/ScannedDocumentPage;", "currentlySelectedPage", "", "isCropping", "", "processingState", "Lcom/box/android/capture/documentscanning/DocumentProcessingState;", "displayedError", "", "<init>", "(Ljava/util/List;IZLcom/box/android/capture/documentscanning/DocumentProcessingState;Ljava/lang/String;)V", "getScannedPages", "()Ljava/util/List;", "getCurrentlySelectedPage", "()I", "()Z", "getProcessingState", "()Lcom/box/android/capture/documentscanning/DocumentProcessingState;", "getDisplayedError", "()Ljava/lang/String;", "currentPage", "getCurrentPage", "()Lcom/box/android/domain/models/ScannedDocumentPage;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final ScannedDocumentPage currentPage;
        private final int currentlySelectedPage;
        private final String displayedError;
        private final boolean isCropping;
        private final DocumentProcessingState processingState;
        private final List<ScannedDocumentPage> scannedPages;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, int i, boolean z, DocumentProcessingState documentProcessingState, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = state.scannedPages;
            }
            if ((i2 & 2) != 0) {
                i = state.currentlySelectedPage;
            }
            if ((i2 & 4) != 0) {
                z = state.isCropping;
            }
            if ((i2 & 8) != 0) {
                documentProcessingState = state.processingState;
            }
            if ((i2 & 16) != 0) {
                str = state.displayedError;
            }
            String str2 = str;
            boolean z2 = z;
            return state.copy(list, i, z2, documentProcessingState, str2);
        }

        public final List<ScannedDocumentPage> component1() {
            return this.scannedPages;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCurrentlySelectedPage() {
            return this.currentlySelectedPage;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsCropping() {
            return this.isCropping;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final DocumentProcessingState getProcessingState() {
            return this.processingState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDisplayedError() {
            return this.displayedError;
        }

        public final State copy(List<ScannedDocumentPage> scannedPages, int currentlySelectedPage, boolean isCropping, DocumentProcessingState processingState, String displayedError) {
            Intrinsics.checkNotNullParameter(scannedPages, "scannedPages");
            Intrinsics.checkNotNullParameter(processingState, "processingState");
            return new State(scannedPages, currentlySelectedPage, isCropping, processingState, displayedError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.scannedPages, state.scannedPages) && this.currentlySelectedPage == state.currentlySelectedPage && this.isCropping == state.isCropping && Intrinsics.areEqual(this.processingState, state.processingState) && Intrinsics.areEqual(this.displayedError, state.displayedError);
        }

        public int hashCode() {
            int iHashCode = ((((((this.scannedPages.hashCode() * 31) + Integer.hashCode(this.currentlySelectedPage)) * 31) + Boolean.hashCode(this.isCropping)) * 31) + this.processingState.hashCode()) * 31;
            String str = this.displayedError;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "State(scannedPages=" + this.scannedPages + ", currentlySelectedPage=" + this.currentlySelectedPage + ", isCropping=" + this.isCropping + ", processingState=" + this.processingState + ", displayedError=" + this.displayedError + ")";
        }

        public State(List<ScannedDocumentPage> scannedPages, int i, boolean z, DocumentProcessingState processingState, String str) {
            Intrinsics.checkNotNullParameter(scannedPages, "scannedPages");
            Intrinsics.checkNotNullParameter(processingState, "processingState");
            this.scannedPages = scannedPages;
            this.currentlySelectedPage = i;
            this.isCropping = z;
            this.processingState = processingState;
            this.displayedError = str;
            this.currentPage = scannedPages.get(Integer.min(i, scannedPages.size() - 1));
        }

        public final List<ScannedDocumentPage> getScannedPages() {
            return this.scannedPages;
        }

        public final int getCurrentlySelectedPage() {
            return this.currentlySelectedPage;
        }

        public final boolean isCropping() {
            return this.isCropping;
        }

        public /* synthetic */ State(List list, int i, boolean z, DocumentProcessingState.NotProcessing notProcessing, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? DocumentProcessingState.NotProcessing.INSTANCE : notProcessing, (i2 & 16) != 0 ? null : str);
        }

        public final DocumentProcessingState getProcessingState() {
            return this.processingState;
        }

        public final String getDisplayedError() {
            return this.displayedError;
        }

        public final ScannedDocumentPage getCurrentPage() {
            return this.currentPage;
        }
    }

    /* JADX INFO: compiled from: EditScanPageReducer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "", "<init>", "()V", "Initialize", "PageSelected", "PagesUpdated", "ImageUpdated", "RotateImage", "DeletePage", "CropImage", "CancelCropping", "CroppedImage", "FilterImage", "Error", "FinishEditing", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$CancelCropping;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$CropImage;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$CroppedImage;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$DeletePage;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$Error;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$FilterImage;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$FinishEditing;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$ImageUpdated;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$Initialize;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$PageSelected;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$PagesUpdated;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$RotateImage;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: EditScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$Initialize;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initialize extends Action {
            public static final int $stable = 0;
            public static final Initialize INSTANCE = new Initialize();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialize)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 113565637;
            }

            public String toString() {
                return "Initialize";
            }

            private Initialize() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: EditScanPageReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$PageSelected;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "selectedPage", "", "<init>", "(I)V", "getSelectedPage", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PageSelected extends Action {
            public static final int $stable = 0;
            private final int selectedPage;

            public static /* synthetic */ PageSelected copy$default(PageSelected pageSelected, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = pageSelected.selectedPage;
                }
                return pageSelected.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getSelectedPage() {
                return this.selectedPage;
            }

            public final PageSelected copy(int selectedPage) {
                return new PageSelected(selectedPage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PageSelected) && this.selectedPage == ((PageSelected) other).selectedPage;
            }

            public int hashCode() {
                return Integer.hashCode(this.selectedPage);
            }

            public String toString() {
                return "PageSelected(selectedPage=" + this.selectedPage + ")";
            }

            public PageSelected(int i) {
                super(null);
                this.selectedPage = i;
            }

            public final int getSelectedPage() {
                return this.selectedPage;
            }
        }

        /* JADX INFO: compiled from: EditScanPageReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$PagesUpdated;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "scannedPages", "", "Lcom/box/android/domain/models/ScannedDocumentPage;", "<init>", "(Ljava/util/List;)V", "getScannedPages", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PagesUpdated extends Action {
            public static final int $stable = 8;
            private final List<ScannedDocumentPage> scannedPages;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ PagesUpdated copy$default(PagesUpdated pagesUpdated, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = pagesUpdated.scannedPages;
                }
                return pagesUpdated.copy(list);
            }

            public final List<ScannedDocumentPage> component1() {
                return this.scannedPages;
            }

            public final PagesUpdated copy(List<ScannedDocumentPage> scannedPages) {
                Intrinsics.checkNotNullParameter(scannedPages, "scannedPages");
                return new PagesUpdated(scannedPages);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PagesUpdated) && Intrinsics.areEqual(this.scannedPages, ((PagesUpdated) other).scannedPages);
            }

            public int hashCode() {
                return this.scannedPages.hashCode();
            }

            public String toString() {
                return "PagesUpdated(scannedPages=" + this.scannedPages + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PagesUpdated(List<ScannedDocumentPage> scannedPages) {
                super(null);
                Intrinsics.checkNotNullParameter(scannedPages, "scannedPages");
                this.scannedPages = scannedPages;
            }

            public final List<ScannedDocumentPage> getScannedPages() {
                return this.scannedPages;
            }
        }

        /* JADX INFO: compiled from: EditScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$ImageUpdated;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ImageUpdated extends Action {
            public static final int $stable = 0;
            public static final ImageUpdated INSTANCE = new ImageUpdated();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ImageUpdated)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1768653355;
            }

            public String toString() {
                return "ImageUpdated";
            }

            private ImageUpdated() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: EditScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$RotateImage;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -164532437;
            }

            public String toString() {
                return "RotateImage";
            }

            private RotateImage() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: EditScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$DeletePage;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DeletePage extends Action {
            public static final int $stable = 0;
            public static final DeletePage INSTANCE = new DeletePage();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DeletePage)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1006936847;
            }

            public String toString() {
                return "DeletePage";
            }

            private DeletePage() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: EditScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$CropImage;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1110452694;
            }

            public String toString() {
                return "CropImage";
            }

            private CropImage() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: EditScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$CancelCropping;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -429859247;
            }

            public String toString() {
                return "CancelCropping";
            }

            private CancelCropping() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: EditScanPageReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$CroppedImage;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "documentPosition", "Lcom/box/android/domain/models/DocumentPosition;", "<init>", "(Lcom/box/android/domain/models/DocumentPosition;)V", "getDocumentPosition", "()Lcom/box/android/domain/models/DocumentPosition;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CroppedImage extends Action {
            public static final int $stable = 8;
            private final DocumentPosition documentPosition;

            public static /* synthetic */ CroppedImage copy$default(CroppedImage croppedImage, DocumentPosition documentPosition, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentPosition = croppedImage.documentPosition;
                }
                return croppedImage.copy(documentPosition);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentPosition getDocumentPosition() {
                return this.documentPosition;
            }

            public final CroppedImage copy(DocumentPosition documentPosition) {
                Intrinsics.checkNotNullParameter(documentPosition, "documentPosition");
                return new CroppedImage(documentPosition);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CroppedImage) && Intrinsics.areEqual(this.documentPosition, ((CroppedImage) other).documentPosition);
            }

            public int hashCode() {
                return this.documentPosition.hashCode();
            }

            public String toString() {
                return "CroppedImage(documentPosition=" + this.documentPosition + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CroppedImage(DocumentPosition documentPosition) {
                super(null);
                Intrinsics.checkNotNullParameter(documentPosition, "documentPosition");
                this.documentPosition = documentPosition;
            }

            public final DocumentPosition getDocumentPosition() {
                return this.documentPosition;
            }
        }

        /* JADX INFO: compiled from: EditScanPageReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$FilterImage;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "filterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "<init>", "(Lcom/box/android/domain/models/DocumentPageFilterType;)V", "getFilterType", "()Lcom/box/android/domain/models/DocumentPageFilterType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: EditScanPageReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$Error;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: EditScanPageReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action$FinishEditing;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FinishEditing extends Action {
            public static final int $stable = 0;
            public static final FinishEditing INSTANCE = new FinishEditing();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FinishEditing)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1189820112;
            }

            public String toString() {
                return "FinishEditing";
            }

            private FinishEditing() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.Initialize) {
            final Flow<Result<List<ScannedDocumentPage>, DomainError>> flowObserveScannedPages = this.environment.getDocumentScanUseCase().observeScannedPages();
            return new ReducerResult<>(state, Effect.cancellable$default(EffectKt.toEffect(new Flow<Action>() { // from class: com.box.android.capture.documentscanning.EditScanPageReducer$reduce$$inlined$map$1

                /* JADX INFO: renamed from: com.box.android.capture.documentscanning.EditScanPageReducer$reduce$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.EditScanPageReducer$reduce$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.capture.documentscanning.EditScanPageReducer$reduce$$inlined$map$1$2", f = "EditScanPageReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                                error = new Result.Success(new EditScanPageReducer.Action.PagesUpdated((List) ((Result.Success) error).getValue()));
                            } else if (!(error instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (!(error instanceof Result.Success)) {
                                if (!(error instanceof Result.Error)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                error = new Result.Error(new EditScanPageReducer.Action.Error((DomainError) ((Result.Error) error).getValue()));
                            }
                            Object obj3 = com.box.android.domain.utils.result.ResultKt.get(error);
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.box.android.capture.documentscanning.EditScanPageReducer.Action");
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit((EditScanPageReducer.Action) obj3, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj4 = anonymousClass1.L$2;
                            Object obj5 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super EditScanPageReducer.Action> flowCollector, Continuation continuation) {
                    Object objCollect = flowObserveScannedPages.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }), PAGES_UPDATE_ID, false, 2, null));
        }
        if (action instanceof Action.PageSelected) {
            return new ReducerResult<>(State.copy$default(state, null, ((Action.PageSelected) action).getSelectedPage(), false, null, null, 29, null), null, 2, null);
        }
        if (action instanceof Action.RotateImage) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass2(state, this, null)));
        }
        if (action instanceof Action.FilterImage) {
            if (state.getCurrentPage().getFilterType() != ((Action.FilterImage) action).getFilterType()) {
                return new ReducerResult<>(State.copy$default(state, null, 0, false, new DocumentProcessingState.Processing(null), null, 23, null), new Effect((Function1) new AnonymousClass3(state, action, null)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.CropImage) {
            return new ReducerResult<>(State.copy$default(state, null, 0, true, null, null, 27, null), null, 2, null);
        }
        if (action instanceof Action.CancelCropping) {
            return new ReducerResult<>(State.copy$default(state, null, 0, false, null, null, 27, null), null, 2, null);
        }
        if (action instanceof Action.CroppedImage) {
            if (!Intrinsics.areEqual(state.getCurrentPage().getQuadrangle(), ((Action.CroppedImage) action).getDocumentPosition())) {
                return new ReducerResult<>(State.copy$default(state, null, 0, false, new DocumentProcessingState.Processing(null), null, 23, null), new Effect((Function1) new AnonymousClass4(state, action, null)));
            }
            return new ReducerResult<>(State.copy$default(state, null, 0, false, null, null, 27, null), null, 2, null);
        }
        if (action instanceof Action.DeletePage) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass5(state, null)));
        }
        if (action instanceof Action.ImageUpdated) {
            return new ReducerResult<>(State.copy$default(state, null, 0, false, DocumentProcessingState.NotProcessing.INSTANCE, null, 19, null), null, 2, null);
        }
        if (action instanceof Action.PagesUpdated) {
            return new ReducerResult<>(State.copy$default(state, ((Action.PagesUpdated) action).getScannedPages(), 0, false, null, null, 30, null), null, 2, null);
        }
        if (action instanceof Action.FinishEditing) {
            return new ReducerResult<>(state, Effect.INSTANCE.cancel(PAGES_UPDATE_ID));
        }
        if (!(action instanceof Action.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Action.Error error = (Action.Error) action;
        DomainError error2 = error.getError();
        if (!(error2 instanceof DomainError)) {
            error2 = null;
        }
        return new ReducerResult<>(State.copy$default(state, null, 0, false, DocumentProcessingState.NotProcessing.INSTANCE, error2 != null ? this.environment.getScanningHelper().getMessageForError(error.getError()) : null, 7, null), null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.EditScanPageReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: EditScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.EditScanPageReducer$reduce$2", f = "EditScanPageReducer.kt", i = {0}, l = {120}, m = "invokeSuspend", n = {"newAngle"}, s = {"I$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int I$0;
        int label;
        final /* synthetic */ EditScanPageReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(State state, EditScanPageReducer editScanPageReducer, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$state = state;
            this.this$0 = editScanPageReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$state, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            int angleForRotating90CCW = EditScannedPageUtilsKt.getAngleForRotating90CCW(this.$state.getCurrentPage().getRotationAngle());
            this.I$0 = angleForRotating90CCW;
            this.label = 1;
            Object objUpdatePage$default = EditScanPageReducer.updatePage$default(this.this$0, this.$state, BoxAnalyticsParams.EVENT_SCAN_DOCUMENT_CHANGE_ROTATION, Boxing.boxInt(angleForRotating90CCW), null, null, this, 24, null);
            return objUpdatePage$default == coroutine_suspended ? coroutine_suspended : objUpdatePage$default;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.EditScanPageReducer$reduce$3, reason: invalid class name */
    /* JADX INFO: compiled from: EditScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.EditScanPageReducer$reduce$3", f = "EditScanPageReducer.kt", i = {}, l = {Token.LOOP}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(State state, Action action, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EditScanPageReducer.this.new AnonymousClass3(this.$state, this.$action, continuation);
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
            this.label = 1;
            Object objUpdatePage$default = EditScanPageReducer.updatePage$default(EditScanPageReducer.this, this.$state, BoxAnalyticsParams.EVENT_SCAN_DOCUMENT_CHANGE_FILTER, null, ((Action.FilterImage) this.$action).getFilterType(), null, this, 20, null);
            return objUpdatePage$default == coroutine_suspended ? coroutine_suspended : objUpdatePage$default;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.EditScanPageReducer$reduce$4, reason: invalid class name */
    /* JADX INFO: compiled from: EditScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.EditScanPageReducer$reduce$4", f = "EditScanPageReducer.kt", i = {}, l = {Token.LET}, m = "invokeSuspend", n = {}, s = {}, v = 1)
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
            return EditScanPageReducer.this.new AnonymousClass4(this.$state, this.$action, continuation);
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
            Object objUpdatePage$default = EditScanPageReducer.updatePage$default(EditScanPageReducer.this, this.$state, BoxAnalyticsParams.EVENT_SCAN_DOCUMENT_CHANGE_CROP, null, null, ((Action.CroppedImage) this.$action).getDocumentPosition(), this, 12, null);
            return objUpdatePage$default == coroutine_suspended ? coroutine_suspended : objUpdatePage$default;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.EditScanPageReducer$reduce$5, reason: invalid class name */
    /* JADX INFO: compiled from: EditScanPageReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.EditScanPageReducer$reduce$5", f = "EditScanPageReducer.kt", i = {}, l = {Context.VERSION_1_7}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(State state, Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EditScanPageReducer.this.new AnonymousClass5(this.$state, continuation);
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
            Object objDeletePage = EditScanPageReducer.this.deletePage(this.$state, this);
            return objDeletePage == coroutine_suspended ? coroutine_suspended : objDeletePage;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deletePage(State state, Continuation<? super Action> continuation) {
        AnonymousClass1 anonymousClass1;
        Action.ImageUpdated imageUpdated;
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
        Object objDeletePage = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeletePage);
            ScannedDocumentPage scannedDocumentPage = state.getScannedPages().get(state.getCurrentlySelectedPage());
            this.environment.getScanningHelper().logEvent(BoxAnalyticsParams.EVENT_SCAN_DOCUMENT_DELETE_PAGE);
            DocumentScanUseCase documentScanUseCase = this.environment.getDocumentScanUseCase();
            anonymousClass1.L$0 = state;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(scannedDocumentPage);
            anonymousClass1.label = 1;
            objDeletePage = documentScanUseCase.deletePage(scannedDocumentPage, anonymousClass1);
            if (objDeletePage == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            state = (State) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objDeletePage);
        }
        Result.Error error = (Result) objDeletePage;
        if (error instanceof Result.Success) {
            if (state.getScannedPages().size() == 1) {
                imageUpdated = Action.FinishEditing.INSTANCE;
            } else {
                imageUpdated = Action.ImageUpdated.INSTANCE;
            }
            error = new Result.Success(imageUpdated);
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
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.box.android.capture.documentscanning.EditScanPageReducer.Action");
        return (Action) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updatePage(State state, String str, Integer num, DocumentPageFilterType documentPageFilterType, DocumentPosition documentPosition, Continuation<? super Action> continuation) {
        C09761 c09761;
        if (continuation instanceof C09761) {
            c09761 = (C09761) continuation;
            if ((c09761.label & Integer.MIN_VALUE) != 0) {
                c09761.label -= Integer.MIN_VALUE;
            } else {
                c09761 = new C09761(continuation);
            }
        } else {
            c09761 = new C09761(continuation);
        }
        C09761 c09762 = c09761;
        Object objUpdateScannedPage = c09762.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09762.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUpdateScannedPage);
            this.environment.getScanningHelper().logEvent(str);
            DocumentScanUseCase documentScanUseCase = this.environment.getDocumentScanUseCase();
            Application application = ApplicationProvider.getApplication();
            ScannedDocumentPage currentPage = state.getCurrentPage();
            c09762.L$0 = SpillingKt.nullOutSpilledVariable(state);
            c09762.L$1 = SpillingKt.nullOutSpilledVariable(str);
            c09762.L$2 = SpillingKt.nullOutSpilledVariable(num);
            c09762.L$3 = SpillingKt.nullOutSpilledVariable(documentPageFilterType);
            c09762.L$4 = SpillingKt.nullOutSpilledVariable(documentPosition);
            c09762.label = 1;
            objUpdateScannedPage = documentScanUseCase.updateScannedPage(application, currentPage, documentPosition, documentPageFilterType, num, c09762);
            if (objUpdateScannedPage == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateScannedPage);
        }
        Result.Error error = (Result) objUpdateScannedPage;
        if (error instanceof Result.Success) {
            error = new Result.Success(Action.ImageUpdated.INSTANCE);
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
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.box.android.capture.documentscanning.EditScanPageReducer.Action");
        return (Action) obj;
    }

    static /* synthetic */ Object updatePage$default(EditScanPageReducer editScanPageReducer, State state, String str, Integer num, DocumentPageFilterType documentPageFilterType, DocumentPosition documentPosition, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            documentPageFilterType = null;
        }
        if ((i & 16) != 0) {
            documentPosition = null;
        }
        return editScanPageReducer.updatePage(state, str, num, documentPageFilterType, documentPosition, continuation);
    }
}
