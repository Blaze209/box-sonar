package com.box.android.preview.fileactions.openin;

import androidx.media3.effect.DebugTraceUtil;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.wopi.WopiConfiguration;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OpenInReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0012\u0013\u0014B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/box/android/preview/fileactions/openin/OpenInReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$State;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;", "environment", "Lcom/box/android/preview/fileactions/openin/OpenInEnvironment;", "<init>", "(Lcom/box/android/preview/fileactions/openin/OpenInEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/fileactions/openin/OpenInEnvironment;", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reduceOpenIn", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Error", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OpenInReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final OpenInEnvironment environment;

    /* JADX INFO: compiled from: OpenInReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/box/android/preview/fileactions/openin/OpenInReducer$Error;", "", "<init>", "(Ljava/lang/String;I)V", "FEATURE_DISABLED", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Error {
        FEATURE_DISABLED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Error> getEntries() {
            return $ENTRIES;
        }
    }

    public OpenInReducer(OpenInEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new OpenInReducer$build$1(this));
    }

    public final OpenInEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: OpenInReducer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/fileactions/openin/OpenInReducer$State;", "", "error", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Error;", "wopiConfiguration", "Lcom/box/android/preview/wopi/WopiConfiguration;", "<init>", "(Lcom/box/android/preview/fileactions/openin/OpenInReducer$Error;Lcom/box/android/preview/wopi/WopiConfiguration;)V", "getError", "()Lcom/box/android/preview/fileactions/openin/OpenInReducer$Error;", "getWopiConfiguration", "()Lcom/box/android/preview/wopi/WopiConfiguration;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final Error error;
        private final WopiConfiguration wopiConfiguration;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, Error error, WopiConfiguration wopiConfiguration, int i, Object obj) {
            if ((i & 1) != 0) {
                error = state.error;
            }
            if ((i & 2) != 0) {
                wopiConfiguration = state.wopiConfiguration;
            }
            return state.copy(error, wopiConfiguration);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Error getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final WopiConfiguration getWopiConfiguration() {
            return this.wopiConfiguration;
        }

        public final State copy(Error error, WopiConfiguration wopiConfiguration) {
            return new State(error, wopiConfiguration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.error == state.error && Intrinsics.areEqual(this.wopiConfiguration, state.wopiConfiguration);
        }

        public int hashCode() {
            Error error = this.error;
            int iHashCode = (error == null ? 0 : error.hashCode()) * 31;
            WopiConfiguration wopiConfiguration = this.wopiConfiguration;
            return iHashCode + (wopiConfiguration != null ? wopiConfiguration.hashCode() : 0);
        }

        public String toString() {
            return "State(error=" + this.error + ", wopiConfiguration=" + this.wopiConfiguration + ")";
        }

        public State(Error error, WopiConfiguration wopiConfiguration) {
            this.error = error;
            this.wopiConfiguration = wopiConfiguration;
        }

        public /* synthetic */ State(Error error, WopiConfiguration wopiConfiguration, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : error, (i & 2) != 0 ? null : wopiConfiguration);
        }

        public final Error getError() {
            return this.error;
        }

        public final WopiConfiguration getWopiConfiguration() {
            return this.wopiConfiguration;
        }
    }

    /* JADX INFO: compiled from: OpenInReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;", "", "<init>", "()V", DebugTraceUtil.EVENT_START, "OpenInExternalApp", "OpenWopiUrl", "StartWopi", "RejectWopi", "Finish", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action$Finish;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action$OpenInExternalApp;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action$OpenWopiUrl;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action$RejectWopi;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action$Start;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action$StartWopi;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: OpenInReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action$Start;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Start extends Action {
            public static final int $stable = 8;
            private final FileModel fileModel;

            public static /* synthetic */ Start copy$default(Start start, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = start.fileModel;
                }
                return start.copy(fileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final Start copy(FileModel fileModel) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new Start(fileModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Start) && Intrinsics.areEqual(this.fileModel, ((Start) other).fileModel);
            }

            public int hashCode() {
                return this.fileModel.hashCode();
            }

            public String toString() {
                return "Start(fileModel=" + this.fileModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Start(FileModel fileModel) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: OpenInReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action$OpenInExternalApp;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenInExternalApp extends Action {
            public static final int $stable = 0;
            public static final OpenInExternalApp INSTANCE = new OpenInExternalApp();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OpenInExternalApp)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1852148605;
            }

            public String toString() {
                return "OpenInExternalApp";
            }

            private OpenInExternalApp() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: OpenInReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action$OpenWopiUrl;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;", "wopiConfiguration", "Lcom/box/android/preview/wopi/WopiConfiguration;", "<init>", "(Lcom/box/android/preview/wopi/WopiConfiguration;)V", "getWopiConfiguration", "()Lcom/box/android/preview/wopi/WopiConfiguration;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenWopiUrl extends Action {
            public static final int $stable = 0;
            private final WopiConfiguration wopiConfiguration;

            public static /* synthetic */ OpenWopiUrl copy$default(OpenWopiUrl openWopiUrl, WopiConfiguration wopiConfiguration, int i, Object obj) {
                if ((i & 1) != 0) {
                    wopiConfiguration = openWopiUrl.wopiConfiguration;
                }
                return openWopiUrl.copy(wopiConfiguration);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final WopiConfiguration getWopiConfiguration() {
                return this.wopiConfiguration;
            }

            public final OpenWopiUrl copy(WopiConfiguration wopiConfiguration) {
                Intrinsics.checkNotNullParameter(wopiConfiguration, "wopiConfiguration");
                return new OpenWopiUrl(wopiConfiguration);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OpenWopiUrl) && Intrinsics.areEqual(this.wopiConfiguration, ((OpenWopiUrl) other).wopiConfiguration);
            }

            public int hashCode() {
                return this.wopiConfiguration.hashCode();
            }

            public String toString() {
                return "OpenWopiUrl(wopiConfiguration=" + this.wopiConfiguration + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenWopiUrl(WopiConfiguration wopiConfiguration) {
                super(null);
                Intrinsics.checkNotNullParameter(wopiConfiguration, "wopiConfiguration");
                this.wopiConfiguration = wopiConfiguration;
            }

            public final WopiConfiguration getWopiConfiguration() {
                return this.wopiConfiguration;
            }
        }

        /* JADX INFO: compiled from: OpenInReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action$StartWopi;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StartWopi extends Action {
            public static final int $stable = 0;
            public static final StartWopi INSTANCE = new StartWopi();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StartWopi)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 238429705;
            }

            public String toString() {
                return "StartWopi";
            }

            private StartWopi() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: OpenInReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action$RejectWopi;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RejectWopi extends Action {
            public static final int $stable = 0;
            public static final RejectWopi INSTANCE = new RejectWopi();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RejectWopi)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -267938278;
            }

            public String toString() {
                return "RejectWopi";
            }

            private RejectWopi() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: OpenInReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action$Finish;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1918136477;
            }

            public String toString() {
                return "Finish";
            }

            private Finish() {
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
    public final ReducerResult<State, Action> reduceOpenIn(State state, Action action) {
        Error error = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (action instanceof Action.Start) {
            if (this.environment.getFileActionsManager().checkOpenInActionAdminSettings() instanceof Result.Error) {
                return new ReducerResult<>(State.copy$default(state, Error.FEATURE_DISABLED, null, 2, null), null, 2, null);
            }
            WopiConfiguration wopiConfiguration = this.environment.getWopiService().getWopiConfiguration(((Action.Start) action).getFileModel());
            if (wopiConfiguration != null) {
                return new ReducerResult<>(State.copy$default(state, null, wopiConfiguration, 1, null), null, 2, null);
            }
            return new ReducerResult<>(state, new Effect(Action.OpenInExternalApp.INSTANCE));
        }
        if (action instanceof Action.RejectWopi) {
            return new ReducerResult<>(State.copy$default(state, null, null, 1, null), new Effect(Action.OpenInExternalApp.INSTANCE));
        }
        if (action instanceof Action.StartWopi) {
            if (state.getWopiConfiguration() == null) {
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Unexpected state: wopiConfiguration is null");
                return new ReducerResult<>(state, null, 2, null);
            }
            return new ReducerResult<>(State.copy$default(state, null, null, 1, null), new Effect(new Action.OpenWopiUrl(state.getWopiConfiguration())));
        }
        if (!(action instanceof Action.OpenWopiUrl) && !(action instanceof Action.OpenInExternalApp)) {
            if (!(action instanceof Action.Finish)) {
                throw new NoWhenBranchMatchedException();
            }
            return new ReducerResult<>(new State(error, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0), null, 2, null);
        }
        return new ReducerResult<>(state, new Effect(Action.Finish.INSTANCE));
    }
}
