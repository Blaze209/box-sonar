package com.box.android.preview.item.labels.classification;

import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ClassificationModel;
import com.box.android.domain.models.item.FileModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewClassificationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$State;", "Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action;", "<init>", "()V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "State", "ClassificationLabel", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewClassificationReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build = new Reduce<>(new Function2() { // from class: com.box.android.preview.item.labels.classification.PreviewClassificationReducer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return PreviewClassificationReducer.build$lambda$0((PreviewClassificationReducer.State) obj, (PreviewClassificationReducer.Action) obj2);
        }
    });

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: PreviewClassificationReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$State;", "", "label", "Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$ClassificationLabel;", "<init>", "(Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$ClassificationLabel;)V", "getLabel", "()Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$ClassificationLabel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final ClassificationLabel label;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, ClassificationLabel classificationLabel, int i, Object obj) {
            if ((i & 1) != 0) {
                classificationLabel = state.label;
            }
            return state.copy(classificationLabel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ClassificationLabel getLabel() {
            return this.label;
        }

        public final State copy(ClassificationLabel label) {
            return new State(label);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof State) && Intrinsics.areEqual(this.label, ((State) other).label);
        }

        public int hashCode() {
            ClassificationLabel classificationLabel = this.label;
            if (classificationLabel == null) {
                return 0;
            }
            return classificationLabel.hashCode();
        }

        public String toString() {
            return "State(label=" + this.label + ")";
        }

        public State(ClassificationLabel classificationLabel) {
            this.label = classificationLabel;
        }

        public /* synthetic */ State(ClassificationLabel classificationLabel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : classificationLabel);
        }

        public final ClassificationLabel getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: compiled from: PreviewClassificationReducer.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$ClassificationLabel;", "", "text", "", "color", "", "<init>", "(Ljava/lang/String;J)V", "getText", "()Ljava/lang/String;", "getColor", "()J", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ClassificationLabel {
        public static final int $stable = 0;
        private final long color;
        private final String text;

        public static /* synthetic */ ClassificationLabel copy$default(ClassificationLabel classificationLabel, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = classificationLabel.text;
            }
            if ((i & 2) != 0) {
                j = classificationLabel.color;
            }
            return classificationLabel.copy(str, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getColor() {
            return this.color;
        }

        public final ClassificationLabel copy(String text, long color) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new ClassificationLabel(text, color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClassificationLabel)) {
                return false;
            }
            ClassificationLabel classificationLabel = (ClassificationLabel) other;
            return Intrinsics.areEqual(this.text, classificationLabel.text) && this.color == classificationLabel.color;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + Long.hashCode(this.color);
        }

        public String toString() {
            return "ClassificationLabel(text=" + this.text + ", color=" + this.color + ")";
        }

        public ClassificationLabel(String text, long j) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.color = j;
        }

        public final long getColor() {
            return this.color;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* JADX INFO: compiled from: PreviewClassificationReducer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action;", "", "<init>", "()V", "UpdateLabel", "Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action$UpdateLabel;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: PreviewClassificationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action$UpdateLabel;", "Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (!(action instanceof Action.UpdateLabel)) {
            throw new NoWhenBranchMatchedException();
        }
        Action.UpdateLabel updateLabel = (Action.UpdateLabel) action;
        ClassificationModel classification = updateLabel.getFileModel().getClassification();
        String name = classification != null ? classification.getName() : null;
        ClassificationModel classification2 = updateLabel.getFileModel().getClassification();
        Long lColorAsLong = classification2 != null ? classification2.colorAsLong() : null;
        return new ReducerResult(state.copy((name == null || lColorAsLong == null) ? null : new ClassificationLabel(name, lColorAsLong.longValue())), null, 2, null);
    }
}
