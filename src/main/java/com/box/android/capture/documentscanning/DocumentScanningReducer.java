package com.box.android.capture.documentscanning;

import com.box.android.capture.cpl.CaptureModeState;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.capture.CaptureMode;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentScanningReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "environment", "Lcom/box/android/capture/documentscanning/DocumentScanningEnvironment;", "<init>", "(Lcom/box/android/capture/documentscanning/DocumentScanningEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceDocScanning", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reducePageEdit", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$Edit;", "reducePageReview", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$Review;", "reducePageScanning", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$Scanning;", "State", "Action", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentScanningReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final DocumentScanningEnvironment environment;

    public DocumentScanningReducer(DocumentScanningEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new DocumentScanningReducer$build$1(this));
        final DocumentScanningReducer$build$2 documentScanningReducer$build$2 = DocumentScanningReducer$build$2.INSTANCE;
        final DocumentScanningReducer$build$3 documentScanningReducer$build$3 = DocumentScanningReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new ScanPageReducer(environment), new Function1<State, ScanPageReducer.State>() { // from class: com.box.android.capture.documentscanning.DocumentScanningReducer$special$$inlined$ifCaseLet$1
            @Override // kotlin.jvm.functions.Function1
            public final ScanPageReducer.State invoke(DocumentScanningReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!(it instanceof DocumentScanningReducer.State.ScanPage)) {
                    it = null;
                }
                DocumentScanningReducer.State.ScanPage scanPage = (DocumentScanningReducer.State.ScanPage) it;
                if (scanPage != null) {
                    return scanPage.getAction();
                }
                return null;
            }
        }, new Function1<Action, ScanPageReducer.Action>() { // from class: com.box.android.capture.documentscanning.DocumentScanningReducer$special$$inlined$ifCaseLet$2
            @Override // kotlin.jvm.functions.Function1
            public final ScanPageReducer.Action invoke(DocumentScanningReducer.Action action) {
                if (!(action instanceof DocumentScanningReducer.Action.Scanning)) {
                    action = null;
                }
                DocumentScanningReducer.Action.Scanning scanning = (DocumentScanningReducer.Action.Scanning) action;
                if (scanning != null) {
                    return scanning.getAction();
                }
                return null;
            }
        }, new Function2<State, ScanPageReducer.State, State>() { // from class: com.box.android.capture.documentscanning.DocumentScanningReducer$special$$inlined$ifCaseLet$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final DocumentScanningReducer.State invoke(DocumentScanningReducer.State state, ScanPageReducer.State state2) {
                Intrinsics.checkNotNullParameter(state, "<anonymous parameter 0>");
                Object objInvoke = documentScanningReducer$build$2.invoke(state2);
                if (objInvoke != null) {
                    return (DocumentScanningReducer.State) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.documentscanning.DocumentScanningReducer.State");
            }
        }, new Function1<ScanPageReducer.Action, Action>() { // from class: com.box.android.capture.documentscanning.DocumentScanningReducer$special$$inlined$ifCaseLet$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DocumentScanningReducer.Action invoke(ScanPageReducer.Action action) {
                Object objInvoke = documentScanningReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (DocumentScanningReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.documentscanning.DocumentScanningReducer.Action");
            }
        });
        final DocumentScanningReducer$build$5 documentScanningReducer$build$5 = DocumentScanningReducer$build$5.INSTANCE;
        final DocumentScanningReducer$build$6 documentScanningReducer$build$6 = DocumentScanningReducer$build$6.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new EditScanPageReducer(environment), new Function1<State, EditScanPageReducer.State>() { // from class: com.box.android.capture.documentscanning.DocumentScanningReducer$special$$inlined$ifCaseLet$5
            @Override // kotlin.jvm.functions.Function1
            public final EditScanPageReducer.State invoke(DocumentScanningReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!(it instanceof DocumentScanningReducer.State.Edit)) {
                    it = null;
                }
                DocumentScanningReducer.State.Edit edit = (DocumentScanningReducer.State.Edit) it;
                if (edit != null) {
                    return edit.getAction();
                }
                return null;
            }
        }, new Function1<Action, EditScanPageReducer.Action>() { // from class: com.box.android.capture.documentscanning.DocumentScanningReducer$special$$inlined$ifCaseLet$6
            @Override // kotlin.jvm.functions.Function1
            public final EditScanPageReducer.Action invoke(DocumentScanningReducer.Action action) {
                if (!(action instanceof DocumentScanningReducer.Action.Edit)) {
                    action = null;
                }
                DocumentScanningReducer.Action.Edit edit = (DocumentScanningReducer.Action.Edit) action;
                if (edit != null) {
                    return edit.getAction();
                }
                return null;
            }
        }, new Function2<State, EditScanPageReducer.State, State>() { // from class: com.box.android.capture.documentscanning.DocumentScanningReducer$special$$inlined$ifCaseLet$7
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final DocumentScanningReducer.State invoke(DocumentScanningReducer.State state, EditScanPageReducer.State state2) {
                Intrinsics.checkNotNullParameter(state, "<anonymous parameter 0>");
                Object objInvoke = documentScanningReducer$build$5.invoke(state2);
                if (objInvoke != null) {
                    return (DocumentScanningReducer.State) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.documentscanning.DocumentScanningReducer.State");
            }
        }, new Function1<EditScanPageReducer.Action, Action>() { // from class: com.box.android.capture.documentscanning.DocumentScanningReducer$special$$inlined$ifCaseLet$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DocumentScanningReducer.Action invoke(EditScanPageReducer.Action action) {
                Object objInvoke = documentScanningReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (DocumentScanningReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.documentscanning.DocumentScanningReducer.Action");
            }
        });
        final DocumentScanningReducer$build$8 documentScanningReducer$build$8 = DocumentScanningReducer$build$8.INSTANCE;
        final DocumentScanningReducer$build$9 documentScanningReducer$build$9 = DocumentScanningReducer$build$9.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer2, new ReviewScanPageReducer(environment), new Function1<State, ReviewScanPageReducer.State>() { // from class: com.box.android.capture.documentscanning.DocumentScanningReducer$special$$inlined$ifCaseLet$9
            @Override // kotlin.jvm.functions.Function1
            public final ReviewScanPageReducer.State invoke(DocumentScanningReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!(it instanceof DocumentScanningReducer.State.Review)) {
                    it = null;
                }
                DocumentScanningReducer.State.Review review = (DocumentScanningReducer.State.Review) it;
                if (review != null) {
                    return review.getAction();
                }
                return null;
            }
        }, new Function1<Action, ReviewScanPageReducer.Action>() { // from class: com.box.android.capture.documentscanning.DocumentScanningReducer$special$$inlined$ifCaseLet$10
            @Override // kotlin.jvm.functions.Function1
            public final ReviewScanPageReducer.Action invoke(DocumentScanningReducer.Action action) {
                if (!(action instanceof DocumentScanningReducer.Action.Review)) {
                    action = null;
                }
                DocumentScanningReducer.Action.Review review = (DocumentScanningReducer.Action.Review) action;
                if (review != null) {
                    return review.getAction();
                }
                return null;
            }
        }, new Function2<State, ReviewScanPageReducer.State, State>() { // from class: com.box.android.capture.documentscanning.DocumentScanningReducer$special$$inlined$ifCaseLet$11
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final DocumentScanningReducer.State invoke(DocumentScanningReducer.State state, ReviewScanPageReducer.State state2) {
                Intrinsics.checkNotNullParameter(state, "<anonymous parameter 0>");
                Object objInvoke = documentScanningReducer$build$8.invoke(state2);
                if (objInvoke != null) {
                    return (DocumentScanningReducer.State) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.documentscanning.DocumentScanningReducer.State");
            }
        }, new Function1<ReviewScanPageReducer.Action, Action>() { // from class: com.box.android.capture.documentscanning.DocumentScanningReducer$special$$inlined$ifCaseLet$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DocumentScanningReducer.Action invoke(ReviewScanPageReducer.Action action) {
                Object objInvoke = documentScanningReducer$build$9.invoke(action);
                if (objInvoke != null) {
                    return (DocumentScanningReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.documentscanning.DocumentScanningReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: DocumentScanningReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State;", "Lcom/box/android/capture/cpl/CaptureModeState;", "<init>", "()V", "Initializing", "PermissionRequired", "LicenseExpired", "ScanPage", "Review", "Edit", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State$Edit;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State$Initializing;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State$LicenseExpired;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State$PermissionRequired;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State$Review;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State$ScanPage;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class State extends CaptureModeState {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private State() {
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State$Initializing;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initializing extends State {
            public static final int $stable = 0;
            public static final Initializing INSTANCE = new Initializing();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initializing)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2122137603;
            }

            public String toString() {
                return "Initializing";
            }

            private Initializing() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State$PermissionRequired;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PermissionRequired extends State {
            public static final int $stable = 0;
            public static final PermissionRequired INSTANCE = new PermissionRequired();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PermissionRequired)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2142106052;
            }

            public String toString() {
                return "PermissionRequired";
            }

            private PermissionRequired() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State$LicenseExpired;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LicenseExpired extends State {
            public static final int $stable = 0;
            public static final LicenseExpired INSTANCE = new LicenseExpired();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LicenseExpired)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -782989862;
            }

            public String toString() {
                return "LicenseExpired";
            }

            private LicenseExpired() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State$ScanPage;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$State;", "state", "<init>", "(Lcom/box/android/capture/documentscanning/ScanPageReducer$State;)V", "getState", "()Lcom/box/android/capture/documentscanning/ScanPageReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ScanPage extends State implements Embedded<ScanPageReducer.State> {
            public static final int $stable = 8;
            private final ScanPageReducer.State state;

            /* JADX WARN: Multi-variable type inference failed */
            public ScanPage() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ ScanPage copy$default(ScanPage scanPage, ScanPageReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = scanPage.state;
                }
                return scanPage.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ScanPageReducer.State getAction() {
                return this.state;
            }

            public final ScanPage copy(ScanPageReducer.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new ScanPage(state);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ScanPage) && Intrinsics.areEqual(this.state, ((ScanPage) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "ScanPage(state=" + this.state + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ScanPage(ScanPageReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public /* synthetic */ ScanPage(ScanPageReducer.State state, int i, DefaultConstructorMarker defaultConstructorMarker) {
                if ((i & 1) != 0) {
                    state = new ScanPageReducer.State(null, 0, null, null, null, null, false, null, false, 511, null);
                }
                this(state);
            }

            public final ScanPageReducer.State getState() {
                return this.state;
            }
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State$Review;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$State;", "state", "<init>", "(Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$State;)V", "getState", "()Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Review extends State implements Embedded<ReviewScanPageReducer.State> {
            public static final int $stable = 8;
            private final ReviewScanPageReducer.State state;

            public static /* synthetic */ Review copy$default(Review review, ReviewScanPageReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = review.state;
                }
                return review.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ReviewScanPageReducer.State getAction() {
                return this.state;
            }

            public final Review copy(ReviewScanPageReducer.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new Review(state);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Review) && Intrinsics.areEqual(this.state, ((Review) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "Review(state=" + this.state + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Review(ReviewScanPageReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final ReviewScanPageReducer.State getState() {
                return this.state;
            }
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State$Edit;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$State;", "state", "<init>", "(Lcom/box/android/capture/documentscanning/EditScanPageReducer$State;)V", "getState", "()Lcom/box/android/capture/documentscanning/EditScanPageReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Edit extends State implements Embedded<EditScanPageReducer.State> {
            public static final int $stable = 8;
            private final EditScanPageReducer.State state;

            public static /* synthetic */ Edit copy$default(Edit edit, EditScanPageReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = edit.state;
                }
                return edit.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final EditScanPageReducer.State getAction() {
                return this.state;
            }

            public final Edit copy(EditScanPageReducer.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new Edit(state);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Edit) && Intrinsics.areEqual(this.state, ((Edit) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "Edit(state=" + this.state + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Edit(EditScanPageReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final EditScanPageReducer.State getState() {
                return this.state;
            }
        }
    }

    /* JADX INFO: compiled from: DocumentScanningReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "", "<init>", "()V", "Initialize", "GeniusScanInitialized", "GeniusScanInitFailure", "GrantPermission", "Scanning", "Review", "Edit", "ErrorDismissed", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$Edit;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$ErrorDismissed;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$GeniusScanInitFailure;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$GeniusScanInitialized;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$GrantPermission;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$Initialize;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$Review;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$Scanning;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Action() {
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$Initialize;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 936660463;
            }

            public String toString() {
                return "Initialize";
            }

            private Initialize() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$GeniusScanInitialized;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GeniusScanInitialized extends Action {
            public static final int $stable = 0;
            public static final GeniusScanInitialized INSTANCE = new GeniusScanInitialized();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GeniusScanInitialized)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2022565919;
            }

            public String toString() {
                return "GeniusScanInitialized";
            }

            private GeniusScanInitialized() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$GeniusScanInitFailure;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GeniusScanInitFailure extends Action {
            public static final int $stable = 0;
            public static final GeniusScanInitFailure INSTANCE = new GeniusScanInitFailure();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GeniusScanInitFailure)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1271858023;
            }

            public String toString() {
                return "GeniusScanInitFailure";
            }

            private GeniusScanInitFailure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$GrantPermission;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GrantPermission extends Action {
            public static final int $stable = 0;
            public static final GrantPermission INSTANCE = new GrantPermission();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GrantPermission)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -556543732;
            }

            public String toString() {
                return "GrantPermission";
            }

            private GrantPermission() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$Scanning;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;)V", "getAction", "()Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Scanning extends Action implements Embedded<ScanPageReducer.Action> {
            public static final int $stable = 0;
            private final ScanPageReducer.Action action;

            public static /* synthetic */ Scanning copy$default(Scanning scanning, ScanPageReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = scanning.action;
                }
                return scanning.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ScanPageReducer.Action getAction() {
                return this.action;
            }

            public final Scanning copy(ScanPageReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Scanning(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Scanning) && Intrinsics.areEqual(this.action, ((Scanning) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Scanning(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Scanning(ScanPageReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ScanPageReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$Review;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;)V", "getAction", "()Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Review extends Action implements Embedded<ReviewScanPageReducer.Action> {
            public static final int $stable = 0;
            private final ReviewScanPageReducer.Action action;

            public static /* synthetic */ Review copy$default(Review review, ReviewScanPageReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = review.action;
                }
                return review.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ReviewScanPageReducer.Action getAction() {
                return this.action;
            }

            public final Review copy(ReviewScanPageReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Review(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Review) && Intrinsics.areEqual(this.action, ((Review) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Review(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Review(ReviewScanPageReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ReviewScanPageReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$Edit;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;)V", "getAction", "()Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Edit extends Action implements Embedded<EditScanPageReducer.Action> {
            public static final int $stable = 0;
            private final EditScanPageReducer.Action action;

            public static /* synthetic */ Edit copy$default(Edit edit, EditScanPageReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = edit.action;
                }
                return edit.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final EditScanPageReducer.Action getAction() {
                return this.action;
            }

            public final Edit copy(EditScanPageReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Edit(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Edit) && Intrinsics.areEqual(this.action, ((Edit) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Edit(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Edit(EditScanPageReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final EditScanPageReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: DocumentScanningReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action$ErrorDismissed;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -1780967840;
            }

            public String toString() {
                return "ErrorDismissed";
            }

            private ErrorDismissed() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceDocScanning(State state, Action action) {
        ScanPageReducer.State state2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (action instanceof Action.Initialize) {
            return new ReducerResult<>(State.Initializing.INSTANCE, new Effect((Function1) new AnonymousClass1(null)));
        }
        int i = 1;
        if (action instanceof Action.GeniusScanInitialized) {
            if (!this.environment.getPermissionsHandler().areAllPermissionsGranted(CaptureMode.PHOTO.getRequiredPermissions())) {
                return new ReducerResult<>(State.PermissionRequired.INSTANCE, null, 2, null);
            }
            return new ReducerResult<>(new State.ScanPage(state2, i, objArr3 == true ? 1 : 0), new Effect(new Action.Scanning(new ScanPageReducer.Action.Initialize(ScanPageEntryReason.NewSession))));
        }
        if (action instanceof Action.GeniusScanInitFailure) {
            return new ReducerResult<>(State.LicenseExpired.INSTANCE, null, 2, null);
        }
        if (action instanceof Action.GrantPermission) {
            return new ReducerResult<>(new State.ScanPage(objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0), new Effect(new Action.Scanning(new ScanPageReducer.Action.Initialize(ScanPageEntryReason.NewSession))));
        }
        if (action instanceof Action.Scanning) {
            return reducePageScanning((Action.Scanning) action, state);
        }
        if (action instanceof Action.Review) {
            return reducePageReview((Action.Review) action, state);
        }
        if (action instanceof Action.Edit) {
            return reducePageEdit((Action.Edit) action, state);
        }
        if (!(action instanceof Action.ErrorDismissed)) {
            throw new NoWhenBranchMatchedException();
        }
        if (state instanceof State.ScanPage) {
            return new ReducerResult<>(new State.ScanPage(ScanPageReducer.State.copy$default(((State.ScanPage) state).getState(), null, 0, null, null, null, null, false, null, false, 479, null)), null, 2, null);
        }
        if (state instanceof State.Review) {
            return new ReducerResult<>(new State.Review(ReviewScanPageReducer.State.copy$default(((State.Review) state).getState(), null, null, null, false, 11, null)), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.DocumentScanningReducer$reduceDocScanning$1, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentScanningReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.DocumentScanningReducer$reduceDocScanning$1", f = "DocumentScanningReducer.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return DocumentScanningReducer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = DocumentScanningReducer.this.environment.getGeniusScanLicenseInitializer().initialize(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                return Action.GeniusScanInitialized.INSTANCE;
            }
            return Action.GeniusScanInitFailure.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> reducePageEdit(Action.Edit action, State state) {
        boolean z = action.getAction() instanceof EditScanPageReducer.Action.FinishEditing;
        ScanPageReducer.State state2 = null;
        Object[] objArr = 0;
        if (z) {
            return new ReducerResult<>(new State.ScanPage(state2, 1, objArr == true ? 1 : 0), new Effect(new Action.Scanning(new ScanPageReducer.Action.Initialize(ScanPageEntryReason.ReturningFromReviewOrEdit))));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> reducePageReview(Action.Review action, State state) {
        ReviewScanPageReducer.Action action2 = action.getAction();
        ScanPageReducer.State state2 = null;
        Object[] objArr = 0;
        if ((action2 instanceof ReviewScanPageReducer.Action.PhotoDeleted) || (action2 instanceof ReviewScanPageReducer.Action.PhotoAdded)) {
            return new ReducerResult<>(new State.ScanPage(state2, 1, objArr == true ? 1 : 0), new Effect(new Action.Scanning(new ScanPageReducer.Action.Initialize(ScanPageEntryReason.ReturningFromReviewOrEdit))));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reducePageScanning(Action.Scanning action, State state) {
        ScanPageReducer.Action action2 = action.getAction();
        if (action2 instanceof ScanPageReducer.Action.EditScans) {
            return new ReducerResult<>(new State.Edit(new EditScanPageReducer.State(((ScanPageReducer.Action.EditScans) action2).getPages(), 0, false, null, null, 30, null)), null, 2, null);
        }
        if (action2 instanceof ScanPageReducer.Action.PhotoProcessed) {
            return new ReducerResult<>(new State.Review(new ReviewScanPageReducer.State(((ScanPageReducer.Action.PhotoProcessed) action2).getPhoto(), null, null, false, 14, null)), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }
}
