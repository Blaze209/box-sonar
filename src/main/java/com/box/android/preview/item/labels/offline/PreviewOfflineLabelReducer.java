package com.box.android.preview.item.labels.offline;

import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.utils.result.Result;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0013\u0014\u0015B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$State;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;", "environment", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelEnvironment;", "<init>", "(Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelEnvironment;", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "isFileOfflined", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "State", "OfflineLabel", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewOfflineLabelReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final PreviewOfflineLabelEnvironment environment;

    /* JADX INFO: renamed from: com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer$isFileOfflined$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer", f = "PreviewOfflineLabelReducer.kt", i = {0, 1}, l = {89, 90}, m = "isFileOfflined", n = {"fileModel", "fileModel"}, s = {"L$0", "L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewOfflineLabelReducer.this.isFileOfflined(null, this);
        }
    }

    public PreviewOfflineLabelReducer(PreviewOfflineLabelEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new Function2() { // from class: com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PreviewOfflineLabelReducer.build$lambda$0(this.f$0, (PreviewOfflineLabelReducer.State) obj, (PreviewOfflineLabelReducer.Action) obj2);
            }
        });
    }

    public final PreviewOfflineLabelEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$State;", "", "label", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$OfflineLabel;", "<init>", "(Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$OfflineLabel;)V", "getLabel", "()Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$OfflineLabel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final OfflineLabel label;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, OfflineLabel offlineLabel, int i, Object obj) {
            if ((i & 1) != 0) {
                offlineLabel = state.label;
            }
            return state.copy(offlineLabel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final OfflineLabel getLabel() {
            return this.label;
        }

        public final State copy(OfflineLabel label) {
            return new State(label);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof State) && Intrinsics.areEqual(this.label, ((State) other).label);
        }

        public int hashCode() {
            OfflineLabel offlineLabel = this.label;
            if (offlineLabel == null) {
                return 0;
            }
            return offlineLabel.hashCode();
        }

        public String toString() {
            return "State(label=" + this.label + ")";
        }

        public State(OfflineLabel offlineLabel) {
            this.label = offlineLabel;
        }

        public /* synthetic */ State(OfflineLabel offlineLabel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : offlineLabel);
        }

        public final OfflineLabel getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$OfflineLabel;", "", "isTooltipVisible", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OfflineLabel {
        public static final int $stable = 0;
        private final boolean isTooltipVisible;

        public OfflineLabel() {
            this(false, 1, null);
        }

        public static /* synthetic */ OfflineLabel copy$default(OfflineLabel offlineLabel, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = offlineLabel.isTooltipVisible;
            }
            return offlineLabel.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsTooltipVisible() {
            return this.isTooltipVisible;
        }

        public final OfflineLabel copy(boolean isTooltipVisible) {
            return new OfflineLabel(isTooltipVisible);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OfflineLabel) && this.isTooltipVisible == ((OfflineLabel) other).isTooltipVisible;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isTooltipVisible);
        }

        public String toString() {
            return "OfflineLabel(isTooltipVisible=" + this.isTooltipVisible + ")";
        }

        public OfflineLabel(boolean z) {
            this.isTooltipVisible = z;
        }

        public /* synthetic */ OfflineLabel(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean isTooltipVisible() {
            return this.isTooltipVisible;
        }
    }

    /* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;", "", "<init>", "()V", "UpdateLabel", "ObserveOfflineJob", "ObserveOfflineState", "LabelClicked", "TooltipDismissed", "SetLabel", "RemoveLabel", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$LabelClicked;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$ObserveOfflineJob;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$ObserveOfflineState;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$RemoveLabel;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$SetLabel;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$TooltipDismissed;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$UpdateLabel;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$UpdateLabel;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateLabel extends Action {
            public static final int $stable = 8;
            private final FileModel fileModel;

            public static /* synthetic */ UpdateLabel copy$default(UpdateLabel updateLabel, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = updateLabel.fileModel;
                }
                return updateLabel.copy(fileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final UpdateLabel copy(FileModel fileModel) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new UpdateLabel(fileModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateLabel) && Intrinsics.areEqual(this.fileModel, ((UpdateLabel) other).fileModel);
            }

            public int hashCode() {
                return this.fileModel.hashCode();
            }

            public String toString() {
                return "UpdateLabel(fileModel=" + this.fileModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateLabel(FileModel fileModel) {
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

        /* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$ObserveOfflineJob;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ObserveOfflineJob extends Action {
            public static final int $stable = 8;
            private final FileModel fileModel;

            public static /* synthetic */ ObserveOfflineJob copy$default(ObserveOfflineJob observeOfflineJob, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = observeOfflineJob.fileModel;
                }
                return observeOfflineJob.copy(fileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final ObserveOfflineJob copy(FileModel fileModel) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new ObserveOfflineJob(fileModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ObserveOfflineJob) && Intrinsics.areEqual(this.fileModel, ((ObserveOfflineJob) other).fileModel);
            }

            public int hashCode() {
                return this.fileModel.hashCode();
            }

            public String toString() {
                return "ObserveOfflineJob(fileModel=" + this.fileModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ObserveOfflineJob(FileModel fileModel) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }

        /* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$ObserveOfflineState;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ObserveOfflineState extends Action {
            public static final int $stable = 8;
            private final FileModel fileModel;

            public static /* synthetic */ ObserveOfflineState copy$default(ObserveOfflineState observeOfflineState, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = observeOfflineState.fileModel;
                }
                return observeOfflineState.copy(fileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final ObserveOfflineState copy(FileModel fileModel) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new ObserveOfflineState(fileModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ObserveOfflineState) && Intrinsics.areEqual(this.fileModel, ((ObserveOfflineState) other).fileModel);
            }

            public int hashCode() {
                return this.fileModel.hashCode();
            }

            public String toString() {
                return "ObserveOfflineState(fileModel=" + this.fileModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ObserveOfflineState(FileModel fileModel) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }

        /* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$LabelClicked;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LabelClicked extends Action {
            public static final int $stable = 0;
            public static final LabelClicked INSTANCE = new LabelClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LabelClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -686507708;
            }

            public String toString() {
                return "LabelClicked";
            }

            private LabelClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$TooltipDismissed;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TooltipDismissed extends Action {
            public static final int $stable = 0;
            public static final TooltipDismissed INSTANCE = new TooltipDismissed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TooltipDismissed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 865284631;
            }

            public String toString() {
                return "TooltipDismissed";
            }

            private TooltipDismissed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$SetLabel;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SetLabel extends Action {
            public static final int $stable = 0;
            public static final SetLabel INSTANCE = new SetLabel();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SetLabel)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 569527011;
            }

            public String toString() {
                return "SetLabel";
            }

            private SetLabel() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action$RemoveLabel;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RemoveLabel extends Action {
            public static final int $stable = 0;
            public static final RemoveLabel INSTANCE = new RemoveLabel();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RemoveLabel)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1316725759;
            }

            public String toString() {
                return "RemoveLabel";
            }

            private RemoveLabel() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(PreviewOfflineLabelReducer previewOfflineLabelReducer, State state, final Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (action instanceof Action.UpdateLabel) {
            return new ReducerResult(state, new Effect((Function1) new PreviewOfflineLabelReducer$build$1$1(previewOfflineLabelReducer, action, null)));
        }
        int i = 1;
        if (action instanceof Action.ObserveOfflineState) {
            final Flow<BoxModelOfflineManager.State> stateFlow = previewOfflineLabelReducer.environment.getBoxModelOfflineManagerWrapper().getStateFlow(((Action.ObserveOfflineState) action).getFileModel().getItemId());
            return new ReducerResult(state, EffectKt.toEffect(new Flow<Action>() { // from class: com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer$build$lambda$0$$inlined$map$1

                /* JADX INFO: renamed from: com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer$build$lambda$0$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer$build$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer$build$lambda$0$$inlined$map$1$2", f = "PreviewOfflineLabelReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        Object obj2;
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
                        Object obj3 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj3);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            if (((BoxModelOfflineManager.State) obj) == BoxModelOfflineManager.State.OFFLINE) {
                                obj2 = (PreviewOfflineLabelReducer.Action) PreviewOfflineLabelReducer.Action.SetLabel.INSTANCE;
                            } else {
                                obj2 = (PreviewOfflineLabelReducer.Action) PreviewOfflineLabelReducer.Action.RemoveLabel.INSTANCE;
                            }
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj4 = anonymousClass1.L$2;
                            Object obj5 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj3);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super PreviewOfflineLabelReducer.Action> flowCollector, Continuation continuation) {
                    Object objCollect = stateFlow.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }).cancellable("ObserveOfflineStateForLabels", true));
        }
        boolean z = false;
        if (action instanceof Action.SetLabel) {
            return new ReducerResult(state.copy(new OfflineLabel(z, i, defaultConstructorMarker)), null, 2, null);
        }
        if (action instanceof Action.RemoveLabel) {
            return new ReducerResult(state.copy(null), null, 2, null);
        }
        if (action instanceof Action.ObserveOfflineJob) {
            final Flow<Result<JobInfo.Status, DomainError>> statusOfJob = previewOfflineLabelReducer.environment.getOfflineService().getStatusOfJob(((Action.ObserveOfflineJob) action).getFileModel().getItemId());
            return new ReducerResult(state, EffectKt.toEffect(new Flow<Action.UpdateLabel>() { // from class: com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer$build$lambda$0$$inlined$mapNotNull$1

                /* JADX INFO: renamed from: com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer$build$lambda$0$$inlined$mapNotNull$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ PreviewOfflineLabelReducer.Action $action$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer$build$lambda$0$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer$build$lambda$0$$inlined$mapNotNull$1$2", f = "PreviewOfflineLabelReducer.kt", i = {0, 0, 0, 0, 0, 0}, l = {52}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
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

                    public AnonymousClass2(FlowCollector flowCollector, PreviewOfflineLabelReducer.Action action) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$action$inlined = action;
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
                            PreviewOfflineLabelReducer.Action.UpdateLabel updateLabel = new PreviewOfflineLabelReducer.Action.UpdateLabel(((PreviewOfflineLabelReducer.Action.ObserveOfflineJob) this.$action$inlined).getFileModel());
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(updateLabel);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(updateLabel, anonymousClass1) == coroutine_suspended) {
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

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super PreviewOfflineLabelReducer.Action.UpdateLabel> flowCollector, Continuation continuation) {
                    Object objCollect = statusOfJob.collect(new AnonymousClass2(flowCollector, action), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }).cancellable("ObserveOfflineJobForLabels", true));
        }
        if (Intrinsics.areEqual(action, Action.TooltipDismissed.INSTANCE)) {
            OfflineLabel label = state.getLabel();
            return new ReducerResult(state.copy(label != null ? label.copy(false) : null), null, 2, null);
        }
        if (!Intrinsics.areEqual(action, Action.LabelClicked.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        OfflineLabel label2 = state.getLabel();
        return new ReducerResult(state.copy(label2 != null ? label2.copy(true) : null), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isFileOfflined(FileModel fileModel, Continuation<? super Boolean> continuation) {
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
        Object objIsOfflineActionEnabled = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsOfflineActionEnabled);
            FileActionsManager fileActionsManager = this.environment.getFileActionsManager();
            anonymousClass1.L$0 = fileModel;
            anonymousClass1.label = 1;
            objIsOfflineActionEnabled = fileActionsManager.isOfflineActionEnabled(fileModel, anonymousClass1);
            if (objIsOfflineActionEnabled != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objIsOfflineActionEnabled);
            return objIsOfflineActionEnabled;
        }
        fileModel = (FileModel) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objIsOfflineActionEnabled);
        if (!((Boolean) objIsOfflineActionEnabled).booleanValue()) {
            return Boxing.boxBoolean(false);
        }
        IOfflineService offlineService = this.environment.getOfflineService();
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
        anonymousClass1.label = 2;
        Object objIsFileOfflined = offlineService.isFileOfflined(fileModel, anonymousClass1);
        return objIsFileOfflined == coroutine_suspended ? coroutine_suspended : objIsFileOfflined;
    }
}
