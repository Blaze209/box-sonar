package com.box.android.base.presentation.components;

import com.box.android.base.cpl.IClipboardService;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopyTextReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/box/android/base/presentation/components/CopyTextReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/presentation/components/CopyTextReducer$State;", "Lcom/box/android/base/presentation/components/CopyTextReducer$Action;", "clipboardService", "Lcom/box/android/base/cpl/IClipboardService;", "<init>", "(Lcom/box/android/base/cpl/IClipboardService;)V", "getClipboardService", "()Lcom/box/android/base/cpl/IClipboardService;", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CopyTextReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final IClipboardService clipboardService;

    public CopyTextReducer(IClipboardService clipboardService) {
        Intrinsics.checkNotNullParameter(clipboardService, "clipboardService");
        this.clipboardService = clipboardService;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    public final IClipboardService getClipboardService() {
        return this.clipboardService;
    }

    /* JADX INFO: compiled from: CopyTextReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/base/presentation/components/CopyTextReducer$State;", "", "showCopyNotification", "", "showSelectedTextPopup", "<init>", "(ZZ)V", "getShowCopyNotification", "()Z", "getShowSelectedTextPopup", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final boolean showCopyNotification;
        private final boolean showSelectedTextPopup;

        /* JADX WARN: Illegal instructions before constructor call */
        public State() {
            boolean z = false;
            this(z, z, 3, null);
        }

        public static /* synthetic */ State copy$default(State state, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.showCopyNotification;
            }
            if ((i & 2) != 0) {
                z2 = state.showSelectedTextPopup;
            }
            return state.copy(z, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShowCopyNotification() {
            return this.showCopyNotification;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShowSelectedTextPopup() {
            return this.showSelectedTextPopup;
        }

        public final State copy(boolean showCopyNotification, boolean showSelectedTextPopup) {
            return new State(showCopyNotification, showSelectedTextPopup);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.showCopyNotification == state.showCopyNotification && this.showSelectedTextPopup == state.showSelectedTextPopup;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.showCopyNotification) * 31) + Boolean.hashCode(this.showSelectedTextPopup);
        }

        public String toString() {
            return "State(showCopyNotification=" + this.showCopyNotification + ", showSelectedTextPopup=" + this.showSelectedTextPopup + ")";
        }

        public State(boolean z, boolean z2) {
            this.showCopyNotification = z;
            this.showSelectedTextPopup = z2;
        }

        public /* synthetic */ State(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
        }

        public final boolean getShowCopyNotification() {
            return this.showCopyNotification;
        }

        public final boolean getShowSelectedTextPopup() {
            return this.showSelectedTextPopup;
        }
    }

    /* JADX INFO: compiled from: CopyTextReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/base/presentation/components/CopyTextReducer$Action;", "", "<init>", "()V", "CopyText", "CopiedToClipboardNotificationShown", "Lcom/box/android/base/presentation/components/CopyTextReducer$Action$CopiedToClipboardNotificationShown;", "Lcom/box/android/base/presentation/components/CopyTextReducer$Action$CopyText;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CopyTextReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/components/CopyTextReducer$Action$CopyText;", "Lcom/box/android/base/presentation/components/CopyTextReducer$Action;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CopyText extends Action {
            public static final int $stable = 0;
            private final String text;

            public static /* synthetic */ CopyText copy$default(CopyText copyText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = copyText.text;
                }
                return copyText.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final CopyText copy(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                return new CopyText(text);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CopyText) && Intrinsics.areEqual(this.text, ((CopyText) other).text);
            }

            public int hashCode() {
                return this.text.hashCode();
            }

            public String toString() {
                return "CopyText(text=" + this.text + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CopyText(String text) {
                super(null);
                Intrinsics.checkNotNullParameter(text, "text");
                this.text = text;
            }

            public final String getText() {
                return this.text;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CopyTextReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/CopyTextReducer$Action$CopiedToClipboardNotificationShown;", "Lcom/box/android/base/presentation/components/CopyTextReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CopiedToClipboardNotificationShown extends Action {
            public static final int $stable = 0;
            public static final CopiedToClipboardNotificationShown INSTANCE = new CopiedToClipboardNotificationShown();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CopiedToClipboardNotificationShown)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -588951919;
            }

            public String toString() {
                return "CopiedToClipboardNotificationShown";
            }

            private CopiedToClipboardNotificationShown() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.CopyText) {
            IClipboardService.copyTextToClipboard$default(this.clipboardService, ((Action.CopyText) action).getText(), null, 2, null);
            return new ReducerResult<>(State.copy$default(state, this.clipboardService.shouldShowCopyNotification(), false, 2, null), null, 2, null);
        }
        if (!Intrinsics.areEqual(action, Action.CopiedToClipboardNotificationShown.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, false, false, 2, null), null, 2, null);
    }
}
