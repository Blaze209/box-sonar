package com.box.android.preview.document.copytext;

import android.graphics.RectF;
import com.box.android.base.presentation.components.CopyTextReducer;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.errorprone.annotations.Immutable;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: CopySelectedTextReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000f\u0010\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/document/copytext/CopySelectedTextReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$State;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;", "environment", "Lcom/box/android/preview/document/copytext/CopySelectedTextEnvironment;", "<init>", "(Lcom/box/android/preview/document/copytext/CopySelectedTextEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceCopySelectedText", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "TextSelection", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CopySelectedTextReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final CopySelectedTextEnvironment environment;

    public CopySelectedTextReducer(CopySelectedTextEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new CopySelectedTextReducer$build$1(this));
        final CopySelectedTextReducer$build$2 copySelectedTextReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.document.copytext.CopySelectedTextReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CopySelectedTextReducer.State) obj).getCopyTextState();
            }
        };
        final CopySelectedTextReducer$build$3 copySelectedTextReducer$build$3 = CopySelectedTextReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new CopyTextReducer(environment.getClipboardService()), new Function1<State, CopyTextReducer.State>() { // from class: com.box.android.preview.document.copytext.CopySelectedTextReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.CopyTextReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CopyTextReducer.State invoke(CopySelectedTextReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return copySelectedTextReducer$build$2.invoke(it);
            }
        }, new Function1<Action, CopyTextReducer.Action>() { // from class: com.box.android.preview.document.copytext.CopySelectedTextReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final CopyTextReducer.Action invoke(CopySelectedTextReducer.Action action) {
                if (!(action instanceof CopySelectedTextReducer.Action.CopyTextAction)) {
                    action = null;
                }
                CopySelectedTextReducer.Action.CopyTextAction copyTextAction = (CopySelectedTextReducer.Action.CopyTextAction) action;
                if (copyTextAction != null) {
                    return copyTextAction.getAction();
                }
                return null;
            }
        }, new Function2<State, CopyTextReducer.State, State>() { // from class: com.box.android.preview.document.copytext.CopySelectedTextReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CopySelectedTextReducer.State invoke(CopySelectedTextReducer.State parentState, CopyTextReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = copySelectedTextReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CopySelectedTextReducer.State.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                KFunction kFunction = (KFunction) next;
                if (kFunction == null) {
                    throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
                }
                KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                Intrinsics.checkNotNull(instanceParameter);
                for (KParameter kParameter : kFunction.getParameters()) {
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty1.getName())) {
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, state)));
                        if (rCallBy != 0) {
                            return (CopySelectedTextReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.document.copytext.CopySelectedTextReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CopyTextReducer.Action, Action>() { // from class: com.box.android.preview.document.copytext.CopySelectedTextReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CopySelectedTextReducer.Action invoke(CopyTextReducer.Action action) {
                Object objInvoke = copySelectedTextReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (CopySelectedTextReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.document.copytext.CopySelectedTextReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CopySelectedTextReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$State;", "", "copyTextState", "Lcom/box/android/base/presentation/components/CopyTextReducer$State;", "selectedText", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$TextSelection;", "showSelectedTextPopup", "", "<init>", "(Lcom/box/android/base/presentation/components/CopyTextReducer$State;Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$TextSelection;Z)V", "getCopyTextState", "()Lcom/box/android/base/presentation/components/CopyTextReducer$State;", "getSelectedText", "()Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$TextSelection;", "getShowSelectedTextPopup", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final CopyTextReducer.State copyTextState;
        private final TextSelection selectedText;
        private final boolean showSelectedTextPopup;

        public State() {
            this(null, null, false, 7, null);
        }

        public static /* synthetic */ State copy$default(State state, CopyTextReducer.State state2, TextSelection textSelection, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.copyTextState;
            }
            if ((i & 2) != 0) {
                textSelection = state.selectedText;
            }
            if ((i & 4) != 0) {
                z = state.showSelectedTextPopup;
            }
            return state.copy(state2, textSelection, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CopyTextReducer.State getCopyTextState() {
            return this.copyTextState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final TextSelection getSelectedText() {
            return this.selectedText;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getShowSelectedTextPopup() {
            return this.showSelectedTextPopup;
        }

        public final State copy(CopyTextReducer.State copyTextState, TextSelection selectedText, boolean showSelectedTextPopup) {
            Intrinsics.checkNotNullParameter(copyTextState, "copyTextState");
            return new State(copyTextState, selectedText, showSelectedTextPopup);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.copyTextState, state.copyTextState) && Intrinsics.areEqual(this.selectedText, state.selectedText) && this.showSelectedTextPopup == state.showSelectedTextPopup;
        }

        public int hashCode() {
            int iHashCode = this.copyTextState.hashCode() * 31;
            TextSelection textSelection = this.selectedText;
            return ((iHashCode + (textSelection == null ? 0 : textSelection.hashCode())) * 31) + Boolean.hashCode(this.showSelectedTextPopup);
        }

        public String toString() {
            return "State(copyTextState=" + this.copyTextState + ", selectedText=" + this.selectedText + ", showSelectedTextPopup=" + this.showSelectedTextPopup + ")";
        }

        public State(CopyTextReducer.State copyTextState, TextSelection textSelection, boolean z) {
            Intrinsics.checkNotNullParameter(copyTextState, "copyTextState");
            this.copyTextState = copyTextState;
            this.selectedText = textSelection;
            this.showSelectedTextPopup = z;
        }

        public /* synthetic */ State(CopyTextReducer.State state, TextSelection textSelection, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new CopyTextReducer.State(false, false, 3, null) : state, (i & 2) != 0 ? null : textSelection, (i & 4) != 0 ? false : z);
        }

        public final CopyTextReducer.State getCopyTextState() {
            return this.copyTextState;
        }

        public final TextSelection getSelectedText() {
            return this.selectedText;
        }

        public final boolean getShowSelectedTextPopup() {
            return this.showSelectedTextPopup;
        }
    }

    /* JADX INFO: compiled from: CopySelectedTextReducer.kt */
    @Immutable
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$TextSelection;", "", "text", "", "boundingBox", "Landroid/graphics/RectF;", "pageIndex", "", "<init>", "(Ljava/lang/String;Landroid/graphics/RectF;I)V", "getText", "()Ljava/lang/String;", "getBoundingBox", "()Landroid/graphics/RectF;", "getPageIndex", "()I", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TextSelection {
        public static final int $stable = 8;
        private final RectF boundingBox;
        private final int pageIndex;
        private final String text;

        public static /* synthetic */ TextSelection copy$default(TextSelection textSelection, String str, RectF rectF, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = textSelection.text;
            }
            if ((i2 & 2) != 0) {
                rectF = textSelection.boundingBox;
            }
            if ((i2 & 4) != 0) {
                i = textSelection.pageIndex;
            }
            return textSelection.copy(str, rectF, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final RectF getBoundingBox() {
            return this.boundingBox;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final TextSelection copy(String text, RectF boundingBox, int pageIndex) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(boundingBox, "boundingBox");
            return new TextSelection(text, boundingBox, pageIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextSelection)) {
                return false;
            }
            TextSelection textSelection = (TextSelection) other;
            return Intrinsics.areEqual(this.text, textSelection.text) && Intrinsics.areEqual(this.boundingBox, textSelection.boundingBox) && this.pageIndex == textSelection.pageIndex;
        }

        public int hashCode() {
            return (((this.text.hashCode() * 31) + this.boundingBox.hashCode()) * 31) + Integer.hashCode(this.pageIndex);
        }

        public String toString() {
            return "TextSelection(text=" + this.text + ", boundingBox=" + this.boundingBox + ", pageIndex=" + this.pageIndex + ")";
        }

        public TextSelection(String text, RectF boundingBox, int i) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(boundingBox, "boundingBox");
            this.text = text;
            this.boundingBox = boundingBox;
            this.pageIndex = i;
        }

        public final RectF getBoundingBox() {
            return this.boundingBox;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* JADX INFO: compiled from: CopySelectedTextReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;", "", "<init>", "()V", "TextSelected", "CopySelectedText", "CopyTextAction", "HidePopup", "ShowPopup", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action$CopySelectedText;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action$CopyTextAction;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action$HidePopup;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action$ShowPopup;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action$TextSelected;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CopySelectedTextReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action$TextSelected;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;", "textSelection", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$TextSelection;", "<init>", "(Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$TextSelection;)V", "getTextSelection", "()Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$TextSelection;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TextSelected extends Action {
            public static final int $stable = 8;
            private final TextSelection textSelection;

            public static /* synthetic */ TextSelected copy$default(TextSelected textSelected, TextSelection textSelection, int i, Object obj) {
                if ((i & 1) != 0) {
                    textSelection = textSelected.textSelection;
                }
                return textSelected.copy(textSelection);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final TextSelection getTextSelection() {
                return this.textSelection;
            }

            public final TextSelected copy(TextSelection textSelection) {
                return new TextSelected(textSelection);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TextSelected) && Intrinsics.areEqual(this.textSelection, ((TextSelected) other).textSelection);
            }

            public int hashCode() {
                TextSelection textSelection = this.textSelection;
                if (textSelection == null) {
                    return 0;
                }
                return textSelection.hashCode();
            }

            public String toString() {
                return "TextSelected(textSelection=" + this.textSelection + ")";
            }

            public TextSelected(TextSelection textSelection) {
                super(null);
                this.textSelection = textSelection;
            }

            public final TextSelection getTextSelection() {
                return this.textSelection;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CopySelectedTextReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action$CopySelectedText;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CopySelectedText extends Action {
            public static final int $stable = 0;
            public static final CopySelectedText INSTANCE = new CopySelectedText();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CopySelectedText)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 520855272;
            }

            public String toString() {
                return "CopySelectedText";
            }

            private CopySelectedText() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CopySelectedTextReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action$CopyTextAction;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/CopyTextReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/CopyTextReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/CopyTextReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CopyTextAction extends Action implements Embedded<CopyTextReducer.Action> {
            public static final int $stable = CopyTextReducer.Action.$stable;
            private final CopyTextReducer.Action action;

            public static /* synthetic */ CopyTextAction copy$default(CopyTextAction copyTextAction, CopyTextReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = copyTextAction.action;
                }
                return copyTextAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CopyTextReducer.Action getAction() {
                return this.action;
            }

            public final CopyTextAction copy(CopyTextReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CopyTextAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CopyTextAction) && Intrinsics.areEqual(this.action, ((CopyTextAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CopyTextAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CopyTextAction(CopyTextReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CopyTextReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: CopySelectedTextReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action$HidePopup;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HidePopup extends Action {
            public static final int $stable = 0;
            public static final HidePopup INSTANCE = new HidePopup();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HidePopup)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1732883071;
            }

            public String toString() {
                return "HidePopup";
            }

            private HidePopup() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CopySelectedTextReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action$ShowPopup;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowPopup extends Action {
            public static final int $stable = 0;
            public static final ShowPopup INSTANCE = new ShowPopup();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowPopup)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1024126556;
            }

            public String toString() {
                return "ShowPopup";
            }

            private ShowPopup() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceCopySelectedText(State state, Action action) {
        String text;
        if (action instanceof Action.TextSelected) {
            return new ReducerResult<>(State.copy$default(state, null, ((Action.TextSelected) action).getTextSelection(), false, 5, null), null, 2, null);
        }
        if (action instanceof Action.CopySelectedText) {
            TextSelection selectedText = state.getSelectedText();
            if (selectedText != null && (text = selectedText.getText()) != null) {
                this.environment.getTextSelectionManager().exitTextSelection();
                return new ReducerResult<>(state, new Effect(new Action.CopyTextAction(new CopyTextReducer.Action.CopyText(text))));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.HidePopup.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, false, 3, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.ShowPopup.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, state.getSelectedText() != null, 3, null), null, 2, null);
        }
        if (action instanceof Action.CopyTextAction) {
            return new ReducerResult<>(state, null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
