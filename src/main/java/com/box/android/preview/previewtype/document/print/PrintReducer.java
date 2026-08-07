package com.box.android.preview.previewtype.document.print;

import androidx.media3.effect.DebugTraceUtil;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.utils.result.Result;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrintReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0012\u0013\u0014\u0015B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$State;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;", "environment", "Lcom/box/android/preview/previewtype/document/print/PrintEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/document/print/PrintEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/previewtype/document/print/PrintEnvironment;", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reducePrint", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "Action", "State", "PasswordDialogState", "Error", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PrintReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final PrintEnvironment environment;

    /* JADX INFO: compiled from: PrintReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintReducer$Error;", "", "<init>", "(Ljava/lang/String;I)V", "PRINTING_ERROR", "FEATURE_DISABLED", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Error {
        PRINTING_ERROR,
        FEATURE_DISABLED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Error> getEntries() {
            return $ENTRIES;
        }
    }

    public PrintReducer(PrintEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new PrintReducer$build$1(this));
    }

    public final PrintEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: PrintReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;", "", "<init>", "()V", DebugTraceUtil.EVENT_START, "Print", "InvalidPasswordEntered", "Failed", "Finish", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action$Failed;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action$Finish;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action$InvalidPasswordEntered;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action$Print;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action$Start;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: PrintReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action$Start;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Start extends Action {
            public static final int $stable = 0;
            public static final Start INSTANCE = new Start();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Start)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1481626086;
            }

            public String toString() {
                return DebugTraceUtil.EVENT_START;
            }

            private Start() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: PrintReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action$Print;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;", "password", "", "<init>", "(Ljava/lang/String;)V", "getPassword", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Print extends Action {
            public static final int $stable = 0;
            private final String password;

            public static /* synthetic */ Print copy$default(Print print, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = print.password;
                }
                return print.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPassword() {
                return this.password;
            }

            public final Print copy(String password) {
                return new Print(password);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Print) && Intrinsics.areEqual(this.password, ((Print) other).password);
            }

            public int hashCode() {
                String str = this.password;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Print(password=" + this.password + ")";
            }

            public Print(String str) {
                super(null);
                this.password = str;
            }

            public final String getPassword() {
                return this.password;
            }
        }

        /* JADX INFO: compiled from: PrintReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action$InvalidPasswordEntered;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InvalidPasswordEntered extends Action {
            public static final int $stable = 0;
            public static final InvalidPasswordEntered INSTANCE = new InvalidPasswordEntered();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InvalidPasswordEntered)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 28011105;
            }

            public String toString() {
                return "InvalidPasswordEntered";
            }

            private InvalidPasswordEntered() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PrintReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action$Failed;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Failed extends Action {
            public static final int $stable = 0;
            public static final Failed INSTANCE = new Failed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Failed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1703725255;
            }

            public String toString() {
                return "Failed";
            }

            private Failed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PrintReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action$Finish;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Finish extends Action {
            public static final int $stable = 0;
            public static final Finish INSTANCE = new Finish();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Finish)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1696190577;
            }

            public String toString() {
                return "Finish";
            }

            private Finish() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: PrintReducer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintReducer$State;", "", "isPrinting", "", "passwordDialogState", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$PasswordDialogState;", "password", "", "error", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Error;", "<init>", "(ZLcom/box/android/preview/previewtype/document/print/PrintReducer$PasswordDialogState;Ljava/lang/String;Lcom/box/android/preview/previewtype/document/print/PrintReducer$Error;)V", "()Z", "getPasswordDialogState", "()Lcom/box/android/preview/previewtype/document/print/PrintReducer$PasswordDialogState;", "getPassword", "()Ljava/lang/String;", "getError", "()Lcom/box/android/preview/previewtype/document/print/PrintReducer$Error;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final Error error;
        private final boolean isPrinting;
        private final String password;
        private final PasswordDialogState passwordDialogState;

        public State() {
            this(false, null, null, null, 15, null);
        }

        public static /* synthetic */ State copy$default(State state, boolean z, PasswordDialogState passwordDialogState, String str, Error error, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.isPrinting;
            }
            if ((i & 2) != 0) {
                passwordDialogState = state.passwordDialogState;
            }
            if ((i & 4) != 0) {
                str = state.password;
            }
            if ((i & 8) != 0) {
                error = state.error;
            }
            return state.copy(z, passwordDialogState, str, error);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsPrinting() {
            return this.isPrinting;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PasswordDialogState getPasswordDialogState() {
            return this.passwordDialogState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPassword() {
            return this.password;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Error getError() {
            return this.error;
        }

        public final State copy(boolean isPrinting, PasswordDialogState passwordDialogState, String password, Error error) {
            return new State(isPrinting, passwordDialogState, password, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.isPrinting == state.isPrinting && Intrinsics.areEqual(this.passwordDialogState, state.passwordDialogState) && Intrinsics.areEqual(this.password, state.password) && this.error == state.error;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.isPrinting) * 31;
            PasswordDialogState passwordDialogState = this.passwordDialogState;
            int iHashCode2 = (iHashCode + (passwordDialogState == null ? 0 : passwordDialogState.hashCode())) * 31;
            String str = this.password;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Error error = this.error;
            return iHashCode3 + (error != null ? error.hashCode() : 0);
        }

        public String toString() {
            return "State(isPrinting=" + this.isPrinting + ", passwordDialogState=" + this.passwordDialogState + ", password=" + this.password + ", error=" + this.error + ")";
        }

        public State(boolean z, PasswordDialogState passwordDialogState, String str, Error error) {
            this.isPrinting = z;
            this.passwordDialogState = passwordDialogState;
            this.password = str;
            this.error = error;
        }

        public /* synthetic */ State(boolean z, PasswordDialogState passwordDialogState, String str, Error error, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : passwordDialogState, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : error);
        }

        public final boolean isPrinting() {
            return this.isPrinting;
        }

        public final PasswordDialogState getPasswordDialogState() {
            return this.passwordDialogState;
        }

        public final String getPassword() {
            return this.password;
        }

        public final Error getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: PrintReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintReducer$PasswordDialogState;", "", "invalidPassword", "", "<init>", "(Z)V", "getInvalidPassword", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PasswordDialogState {
        public static final int $stable = 0;
        private final boolean invalidPassword;

        public PasswordDialogState() {
            this(false, 1, null);
        }

        public static /* synthetic */ PasswordDialogState copy$default(PasswordDialogState passwordDialogState, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = passwordDialogState.invalidPassword;
            }
            return passwordDialogState.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getInvalidPassword() {
            return this.invalidPassword;
        }

        public final PasswordDialogState copy(boolean invalidPassword) {
            return new PasswordDialogState(invalidPassword);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PasswordDialogState) && this.invalidPassword == ((PasswordDialogState) other).invalidPassword;
        }

        public int hashCode() {
            return Boolean.hashCode(this.invalidPassword);
        }

        public String toString() {
            return "PasswordDialogState(invalidPassword=" + this.invalidPassword + ")";
        }

        public PasswordDialogState(boolean z) {
            this.invalidPassword = z;
        }

        public /* synthetic */ PasswordDialogState(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean getInvalidPassword() {
            return this.invalidPassword;
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reducePrint(State state, Action action) {
        if (action instanceof Action.Start) {
            if (this.environment.getFileActionsManager().checkPrintActionAdminSettings() instanceof Result.Error) {
                return new ReducerResult<>(State.copy$default(state, false, null, null, Error.FEATURE_DISABLED, 7, null), null, 2, null);
            }
            return new ReducerResult<>(state, new Effect(new Action.Print(null)));
        }
        if (action instanceof Action.Failed) {
            return new ReducerResult<>(state.copy(false, null, null, Error.PRINTING_ERROR), null, 2, null);
        }
        if (action instanceof Action.InvalidPasswordEntered) {
            return new ReducerResult<>(State.copy$default(state, false, new PasswordDialogState(state.getPassword() != null), null, null, 12, null), null, 2, null);
        }
        if (action instanceof Action.Finish) {
            return new ReducerResult<>(new State(false, null, null, null, 15, null), null, 2, null);
        }
        if (!(action instanceof Action.Print)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, true, null, ((Action.Print) action).getPassword(), null, 10, null), null, 2, null);
    }
}
