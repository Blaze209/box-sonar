package com.box.android.preview.annotations.cpl;

import android.graphics.PointF;
import androidx.media3.effect.DebugTraceUtil;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.preview.annotations.managers.BoxPdfAnnotationManager;
import com.box.android.preview.annotations.model.Annotation;
import com.box.android.preview.annotations.model.AnnotationWithLocation;
import com.box.android.preview.annotations.model.DocumentSize;
import com.google.common.net.HttpHeaders;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AnnotationsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u001b\u001c\u001d\u001e\u001fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\n0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nH\u0002J*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nH\u0002J*\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "environment", "Lcom/box/android/preview/annotations/cpl/AnnotationsEnvironment;", "<init>", "(Lcom/box/android/preview/annotations/cpl/AnnotationsEnvironment;)V", "toFlowOfAnnotationWithLocation", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/box/android/preview/annotations/model/AnnotationWithLocation;", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "documentSizes", "Lcom/box/android/preview/annotations/model/DocumentSize;", "handleFetch", "Lcom/box/android/cpl/ReducerResult;", "state", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reselectSelectedAnnotation", "annotationManager", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "selectedAnnotation", "newAnnotations", "Companion", "DeleteAnnotationState", "State", "AnnotationPopupLocation", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationsReducer implements Reducable<State, Action> {
    public static final String ANNOT_FETCH_KEY_PREFIX = "ANNOT_FETCH_KEY";
    private final Reduce<State, Action> build;
    private final AnnotationsEnvironment environment;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: AnnotationsReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$DeleteAnnotationState;", "", "<init>", "(Ljava/lang/String;I)V", "ConfirmationRequired", "InProgress", "Error", "Success", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum DeleteAnnotationState {
        ConfirmationRequired,
        InProgress,
        Error,
        Success;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<DeleteAnnotationState> getEntries() {
            return $ENTRIES;
        }
    }

    public AnnotationsReducer(AnnotationsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new Function2() { // from class: com.box.android.preview.annotations.cpl.AnnotationsReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AnnotationsReducer.build$lambda$0(this.f$0, (AnnotationsReducer.State) obj, (AnnotationsReducer.Action) obj2);
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: AnnotationsReducer.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010+\u001a\u00020\u0011HÆ\u0003Jg\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00062"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "", "fileId", "Lcom/box/android/domain/models/ItemId;", "fileVersionId", "", "error", "Lcom/box/android/domain/models/DomainError;", "annotations", "", "Lcom/box/android/preview/annotations/model/AnnotationWithLocation;", "selectedAnnotation", "deleteAnnotationState", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$DeleteAnnotationState;", "annotationPopUpLocation", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$AnnotationPopupLocation;", "deleteAnnotationsEnabled", "", "<init>", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Ljava/util/List;Lcom/box/android/preview/annotations/model/AnnotationWithLocation;Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$DeleteAnnotationState;Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$AnnotationPopupLocation;Z)V", "getFileId", "()Lcom/box/android/domain/models/ItemId;", "getFileVersionId", "()Ljava/lang/String;", "getError", "()Lcom/box/android/domain/models/DomainError;", "getAnnotations", "()Ljava/util/List;", "getSelectedAnnotation", "()Lcom/box/android/preview/annotations/model/AnnotationWithLocation;", "getDeleteAnnotationState", "()Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$DeleteAnnotationState;", "getAnnotationPopUpLocation", "()Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$AnnotationPopupLocation;", "getDeleteAnnotationsEnabled", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final AnnotationPopupLocation annotationPopUpLocation;
        private final List<AnnotationWithLocation> annotations;
        private final DeleteAnnotationState deleteAnnotationState;
        private final boolean deleteAnnotationsEnabled;
        private final DomainError error;
        private final ItemId fileId;
        private final String fileVersionId;
        private final AnnotationWithLocation selectedAnnotation;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, ItemId itemId, String str, DomainError domainError, List list, AnnotationWithLocation annotationWithLocation, DeleteAnnotationState deleteAnnotationState, AnnotationPopupLocation annotationPopupLocation, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                itemId = state.fileId;
            }
            if ((i & 2) != 0) {
                str = state.fileVersionId;
            }
            if ((i & 4) != 0) {
                domainError = state.error;
            }
            if ((i & 8) != 0) {
                list = state.annotations;
            }
            if ((i & 16) != 0) {
                annotationWithLocation = state.selectedAnnotation;
            }
            if ((i & 32) != 0) {
                deleteAnnotationState = state.deleteAnnotationState;
            }
            if ((i & 64) != 0) {
                annotationPopupLocation = state.annotationPopUpLocation;
            }
            if ((i & 128) != 0) {
                z = state.deleteAnnotationsEnabled;
            }
            AnnotationPopupLocation annotationPopupLocation2 = annotationPopupLocation;
            boolean z2 = z;
            AnnotationWithLocation annotationWithLocation2 = annotationWithLocation;
            DeleteAnnotationState deleteAnnotationState2 = deleteAnnotationState;
            return state.copy(itemId, str, domainError, list, annotationWithLocation2, deleteAnnotationState2, annotationPopupLocation2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemId getFileId() {
            return this.fileId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFileVersionId() {
            return this.fileVersionId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final DomainError getError() {
            return this.error;
        }

        public final List<AnnotationWithLocation> component4() {
            return this.annotations;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final AnnotationWithLocation getSelectedAnnotation() {
            return this.selectedAnnotation;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final DeleteAnnotationState getDeleteAnnotationState() {
            return this.deleteAnnotationState;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final AnnotationPopupLocation getAnnotationPopUpLocation() {
            return this.annotationPopUpLocation;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getDeleteAnnotationsEnabled() {
            return this.deleteAnnotationsEnabled;
        }

        public final State copy(ItemId fileId, String fileVersionId, DomainError error, List<AnnotationWithLocation> annotations, AnnotationWithLocation selectedAnnotation, DeleteAnnotationState deleteAnnotationState, AnnotationPopupLocation annotationPopUpLocation, boolean deleteAnnotationsEnabled) {
            Intrinsics.checkNotNullParameter(fileId, "fileId");
            Intrinsics.checkNotNullParameter(fileVersionId, "fileVersionId");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            return new State(fileId, fileVersionId, error, annotations, selectedAnnotation, deleteAnnotationState, annotationPopUpLocation, deleteAnnotationsEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.fileId, state.fileId) && Intrinsics.areEqual(this.fileVersionId, state.fileVersionId) && Intrinsics.areEqual(this.error, state.error) && Intrinsics.areEqual(this.annotations, state.annotations) && Intrinsics.areEqual(this.selectedAnnotation, state.selectedAnnotation) && this.deleteAnnotationState == state.deleteAnnotationState && Intrinsics.areEqual(this.annotationPopUpLocation, state.annotationPopUpLocation) && this.deleteAnnotationsEnabled == state.deleteAnnotationsEnabled;
        }

        public int hashCode() {
            int iHashCode = ((this.fileId.hashCode() * 31) + this.fileVersionId.hashCode()) * 31;
            DomainError domainError = this.error;
            int iHashCode2 = (((iHashCode + (domainError == null ? 0 : domainError.hashCode())) * 31) + this.annotations.hashCode()) * 31;
            AnnotationWithLocation annotationWithLocation = this.selectedAnnotation;
            int iHashCode3 = (iHashCode2 + (annotationWithLocation == null ? 0 : annotationWithLocation.hashCode())) * 31;
            DeleteAnnotationState deleteAnnotationState = this.deleteAnnotationState;
            int iHashCode4 = (iHashCode3 + (deleteAnnotationState == null ? 0 : deleteAnnotationState.hashCode())) * 31;
            AnnotationPopupLocation annotationPopupLocation = this.annotationPopUpLocation;
            return ((iHashCode4 + (annotationPopupLocation != null ? annotationPopupLocation.hashCode() : 0)) * 31) + Boolean.hashCode(this.deleteAnnotationsEnabled);
        }

        public String toString() {
            return "State(fileId=" + this.fileId + ", fileVersionId=" + this.fileVersionId + ", error=" + this.error + ", annotations=" + this.annotations + ", selectedAnnotation=" + this.selectedAnnotation + ", deleteAnnotationState=" + this.deleteAnnotationState + ", annotationPopUpLocation=" + this.annotationPopUpLocation + ", deleteAnnotationsEnabled=" + this.deleteAnnotationsEnabled + ")";
        }

        public State(ItemId fileId, String fileVersionId, DomainError domainError, List<AnnotationWithLocation> annotations, AnnotationWithLocation annotationWithLocation, DeleteAnnotationState deleteAnnotationState, AnnotationPopupLocation annotationPopupLocation, boolean z) {
            Intrinsics.checkNotNullParameter(fileId, "fileId");
            Intrinsics.checkNotNullParameter(fileVersionId, "fileVersionId");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            this.fileId = fileId;
            this.fileVersionId = fileVersionId;
            this.error = domainError;
            this.annotations = annotations;
            this.selectedAnnotation = annotationWithLocation;
            this.deleteAnnotationState = deleteAnnotationState;
            this.annotationPopUpLocation = annotationPopupLocation;
            this.deleteAnnotationsEnabled = z;
        }

        public final ItemId getFileId() {
            return this.fileId;
        }

        public final String getFileVersionId() {
            return this.fileVersionId;
        }

        public final DomainError getError() {
            return this.error;
        }

        public /* synthetic */ State(ItemId itemId, String str, DomainError domainError, List list, AnnotationWithLocation annotationWithLocation, DeleteAnnotationState deleteAnnotationState, AnnotationPopupLocation annotationPopupLocation, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(itemId, str, (i & 4) != 0 ? null : domainError, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? null : annotationWithLocation, (i & 32) != 0 ? null : deleteAnnotationState, (i & 64) != 0 ? null : annotationPopupLocation, (i & 128) != 0 ? false : z);
        }

        public final List<AnnotationWithLocation> getAnnotations() {
            return this.annotations;
        }

        public final AnnotationWithLocation getSelectedAnnotation() {
            return this.selectedAnnotation;
        }

        public final DeleteAnnotationState getDeleteAnnotationState() {
            return this.deleteAnnotationState;
        }

        public final AnnotationPopupLocation getAnnotationPopUpLocation() {
            return this.annotationPopUpLocation;
        }

        public final boolean getDeleteAnnotationsEnabled() {
            return this.deleteAnnotationsEnabled;
        }
    }

    /* JADX INFO: compiled from: AnnotationsReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$AnnotationPopupLocation;", "", "point", "Landroid/graphics/PointF;", "pageIndex", "", "<init>", "(Landroid/graphics/PointF;I)V", "getPoint", "()Landroid/graphics/PointF;", "getPageIndex", "()I", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AnnotationPopupLocation {
        public static final int $stable = 8;
        private final int pageIndex;
        private final PointF point;

        public static /* synthetic */ AnnotationPopupLocation copy$default(AnnotationPopupLocation annotationPopupLocation, PointF pointF, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                pointF = annotationPopupLocation.point;
            }
            if ((i2 & 2) != 0) {
                i = annotationPopupLocation.pageIndex;
            }
            return annotationPopupLocation.copy(pointF, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PointF getPoint() {
            return this.point;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final AnnotationPopupLocation copy(PointF point, int pageIndex) {
            Intrinsics.checkNotNullParameter(point, "point");
            return new AnnotationPopupLocation(point, pageIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnnotationPopupLocation)) {
                return false;
            }
            AnnotationPopupLocation annotationPopupLocation = (AnnotationPopupLocation) other;
            return Intrinsics.areEqual(this.point, annotationPopupLocation.point) && this.pageIndex == annotationPopupLocation.pageIndex;
        }

        public int hashCode() {
            return (this.point.hashCode() * 31) + Integer.hashCode(this.pageIndex);
        }

        public String toString() {
            return "AnnotationPopupLocation(point=" + this.point + ", pageIndex=" + this.pageIndex + ")";
        }

        public AnnotationPopupLocation(PointF point, int i) {
            Intrinsics.checkNotNullParameter(point, "point");
            this.point = point;
            this.pageIndex = i;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final PointF getPoint() {
            return this.point;
        }
    }

    /* JADX INFO: compiled from: AnnotationsReducer.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u000f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000f\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !¨\u0006\""}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "", "<init>", "()V", "Fetch", HttpHeaders.REFRESH, "Error", "AnnotationSelected", "UnselectAnnotation", "AnnotationsVisibilityChanged", "UpdateAnnotations", "ShowDeletionConfirmationDialog", "AnnotationDeletedUserConfirmed", "AnnotationDeletionCompleted", "ResetDeleteAnnotationState", "AnnotationPopUpDismissed", "ViewComments", "NavigateToAnnotation", DebugTraceUtil.EVENT_RELEASE, "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$AnnotationDeletedUserConfirmed;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$AnnotationDeletionCompleted;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$AnnotationPopUpDismissed;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$AnnotationSelected;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$AnnotationsVisibilityChanged;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$Error;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$Fetch;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$NavigateToAnnotation;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$Refresh;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$Release;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$ResetDeleteAnnotationState;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$ShowDeletionConfirmationDialog;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$UnselectAnnotation;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$UpdateAnnotations;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$ViewComments;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$Fetch;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "documentSizes", "", "Lcom/box/android/preview/annotations/model/DocumentSize;", "<init>", "(Ljava/util/List;)V", "getDocumentSizes", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Fetch extends Action {
            public static final int $stable = 8;
            private final List<DocumentSize> documentSizes;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Fetch copy$default(Fetch fetch, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = fetch.documentSizes;
                }
                return fetch.copy(list);
            }

            public final List<DocumentSize> component1() {
                return this.documentSizes;
            }

            public final Fetch copy(List<DocumentSize> documentSizes) {
                Intrinsics.checkNotNullParameter(documentSizes, "documentSizes");
                return new Fetch(documentSizes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Fetch) && Intrinsics.areEqual(this.documentSizes, ((Fetch) other).documentSizes);
            }

            public int hashCode() {
                return this.documentSizes.hashCode();
            }

            public String toString() {
                return "Fetch(documentSizes=" + this.documentSizes + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Fetch(List<DocumentSize> documentSizes) {
                super(null);
                Intrinsics.checkNotNullParameter(documentSizes, "documentSizes");
                this.documentSizes = documentSizes;
            }

            public final List<DocumentSize> getDocumentSizes() {
                return this.documentSizes;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$Refresh;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Refresh extends Action {
            public static final int $stable = 0;
            public static final Refresh INSTANCE = new Refresh();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Refresh)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -924380069;
            }

            public String toString() {
                return HttpHeaders.REFRESH;
            }

            private Refresh() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$Error;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$AnnotationSelected;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "annotation", "Lcom/box/android/preview/annotations/model/Annotation;", "popupLocation", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$AnnotationPopupLocation;", "<init>", "(Lcom/box/android/preview/annotations/model/Annotation;Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$AnnotationPopupLocation;)V", "getAnnotation", "()Lcom/box/android/preview/annotations/model/Annotation;", "getPopupLocation", "()Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$AnnotationPopupLocation;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AnnotationSelected extends Action {
            public static final int $stable = 8;
            private final Annotation annotation;
            private final AnnotationPopupLocation popupLocation;

            public static /* synthetic */ AnnotationSelected copy$default(AnnotationSelected annotationSelected, Annotation annotation, AnnotationPopupLocation annotationPopupLocation, int i, Object obj) {
                if ((i & 1) != 0) {
                    annotation = annotationSelected.annotation;
                }
                if ((i & 2) != 0) {
                    annotationPopupLocation = annotationSelected.popupLocation;
                }
                return annotationSelected.copy(annotation, annotationPopupLocation);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Annotation getAnnotation() {
                return this.annotation;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final AnnotationPopupLocation getPopupLocation() {
                return this.popupLocation;
            }

            public final AnnotationSelected copy(Annotation annotation, AnnotationPopupLocation popupLocation) {
                Intrinsics.checkNotNullParameter(annotation, "annotation");
                return new AnnotationSelected(annotation, popupLocation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AnnotationSelected)) {
                    return false;
                }
                AnnotationSelected annotationSelected = (AnnotationSelected) other;
                return Intrinsics.areEqual(this.annotation, annotationSelected.annotation) && Intrinsics.areEqual(this.popupLocation, annotationSelected.popupLocation);
            }

            public int hashCode() {
                int iHashCode = this.annotation.hashCode() * 31;
                AnnotationPopupLocation annotationPopupLocation = this.popupLocation;
                return iHashCode + (annotationPopupLocation == null ? 0 : annotationPopupLocation.hashCode());
            }

            public String toString() {
                return "AnnotationSelected(annotation=" + this.annotation + ", popupLocation=" + this.popupLocation + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnnotationSelected(Annotation annotation, AnnotationPopupLocation annotationPopupLocation) {
                super(null);
                Intrinsics.checkNotNullParameter(annotation, "annotation");
                this.annotation = annotation;
                this.popupLocation = annotationPopupLocation;
            }

            public final Annotation getAnnotation() {
                return this.annotation;
            }

            public final AnnotationPopupLocation getPopupLocation() {
                return this.popupLocation;
            }
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$UnselectAnnotation;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UnselectAnnotation extends Action {
            public static final int $stable = 0;
            public static final UnselectAnnotation INSTANCE = new UnselectAnnotation();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UnselectAnnotation)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1561510812;
            }

            public String toString() {
                return "UnselectAnnotation";
            }

            private UnselectAnnotation() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$AnnotationsVisibilityChanged;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "isVisible", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AnnotationsVisibilityChanged extends Action {
            public static final int $stable = 0;
            private final boolean isVisible;

            public static /* synthetic */ AnnotationsVisibilityChanged copy$default(AnnotationsVisibilityChanged annotationsVisibilityChanged, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = annotationsVisibilityChanged.isVisible;
                }
                return annotationsVisibilityChanged.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsVisible() {
                return this.isVisible;
            }

            public final AnnotationsVisibilityChanged copy(boolean isVisible) {
                return new AnnotationsVisibilityChanged(isVisible);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AnnotationsVisibilityChanged) && this.isVisible == ((AnnotationsVisibilityChanged) other).isVisible;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isVisible);
            }

            public String toString() {
                return "AnnotationsVisibilityChanged(isVisible=" + this.isVisible + ")";
            }

            public AnnotationsVisibilityChanged(boolean z) {
                super(null);
                this.isVisible = z;
            }

            public final boolean isVisible() {
                return this.isVisible;
            }
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$UpdateAnnotations;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "annotations", "", "Lcom/box/android/preview/annotations/model/AnnotationWithLocation;", "<init>", "(Ljava/util/List;)V", "getAnnotations", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateAnnotations extends Action {
            public static final int $stable = 8;
            private final List<AnnotationWithLocation> annotations;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UpdateAnnotations copy$default(UpdateAnnotations updateAnnotations, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = updateAnnotations.annotations;
                }
                return updateAnnotations.copy(list);
            }

            public final List<AnnotationWithLocation> component1() {
                return this.annotations;
            }

            public final UpdateAnnotations copy(List<AnnotationWithLocation> annotations) {
                Intrinsics.checkNotNullParameter(annotations, "annotations");
                return new UpdateAnnotations(annotations);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateAnnotations) && Intrinsics.areEqual(this.annotations, ((UpdateAnnotations) other).annotations);
            }

            public int hashCode() {
                return this.annotations.hashCode();
            }

            public String toString() {
                return "UpdateAnnotations(annotations=" + this.annotations + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateAnnotations(List<AnnotationWithLocation> annotations) {
                super(null);
                Intrinsics.checkNotNullParameter(annotations, "annotations");
                this.annotations = annotations;
            }

            public final List<AnnotationWithLocation> getAnnotations() {
                return this.annotations;
            }
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$ShowDeletionConfirmationDialog;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowDeletionConfirmationDialog extends Action {
            public static final int $stable = 0;
            public static final ShowDeletionConfirmationDialog INSTANCE = new ShowDeletionConfirmationDialog();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowDeletionConfirmationDialog)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 127178152;
            }

            public String toString() {
                return "ShowDeletionConfirmationDialog";
            }

            private ShowDeletionConfirmationDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$AnnotationDeletedUserConfirmed;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AnnotationDeletedUserConfirmed extends Action {
            public static final int $stable = 0;
            public static final AnnotationDeletedUserConfirmed INSTANCE = new AnnotationDeletedUserConfirmed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AnnotationDeletedUserConfirmed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1423524726;
            }

            public String toString() {
                return "AnnotationDeletedUserConfirmed";
            }

            private AnnotationDeletedUserConfirmed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$AnnotationDeletionCompleted;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "isSuccess", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AnnotationDeletionCompleted extends Action {
            public static final int $stable = 0;
            private final boolean isSuccess;

            public AnnotationDeletionCompleted() {
                this(false, 1, null);
            }

            public static /* synthetic */ AnnotationDeletionCompleted copy$default(AnnotationDeletionCompleted annotationDeletionCompleted, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = annotationDeletionCompleted.isSuccess;
                }
                return annotationDeletionCompleted.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsSuccess() {
                return this.isSuccess;
            }

            public final AnnotationDeletionCompleted copy(boolean isSuccess) {
                return new AnnotationDeletionCompleted(isSuccess);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AnnotationDeletionCompleted) && this.isSuccess == ((AnnotationDeletionCompleted) other).isSuccess;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isSuccess);
            }

            public String toString() {
                return "AnnotationDeletionCompleted(isSuccess=" + this.isSuccess + ")";
            }

            public AnnotationDeletionCompleted(boolean z) {
                super(null);
                this.isSuccess = z;
            }

            public /* synthetic */ AnnotationDeletionCompleted(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z);
            }

            public final boolean isSuccess() {
                return this.isSuccess;
            }
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$ResetDeleteAnnotationState;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ResetDeleteAnnotationState extends Action {
            public static final int $stable = 0;
            public static final ResetDeleteAnnotationState INSTANCE = new ResetDeleteAnnotationState();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ResetDeleteAnnotationState)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1797763608;
            }

            public String toString() {
                return "ResetDeleteAnnotationState";
            }

            private ResetDeleteAnnotationState() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$AnnotationPopUpDismissed;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AnnotationPopUpDismissed extends Action {
            public static final int $stable = 0;
            public static final AnnotationPopUpDismissed INSTANCE = new AnnotationPopUpDismissed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AnnotationPopUpDismissed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2011907276;
            }

            public String toString() {
                return "AnnotationPopUpDismissed";
            }

            private AnnotationPopUpDismissed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$ViewComments;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "annotationId", "", "<init>", "(Ljava/lang/String;)V", "getAnnotationId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ViewComments extends Action {
            public static final int $stable = 0;
            private final String annotationId;

            public static /* synthetic */ ViewComments copy$default(ViewComments viewComments, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = viewComments.annotationId;
                }
                return viewComments.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getAnnotationId() {
                return this.annotationId;
            }

            public final ViewComments copy(String annotationId) {
                Intrinsics.checkNotNullParameter(annotationId, "annotationId");
                return new ViewComments(annotationId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ViewComments) && Intrinsics.areEqual(this.annotationId, ((ViewComments) other).annotationId);
            }

            public int hashCode() {
                return this.annotationId.hashCode();
            }

            public String toString() {
                return "ViewComments(annotationId=" + this.annotationId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewComments(String annotationId) {
                super(null);
                Intrinsics.checkNotNullParameter(annotationId, "annotationId");
                this.annotationId = annotationId;
            }

            public final String getAnnotationId() {
                return this.annotationId;
            }
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$NavigateToAnnotation;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "annotationId", "", "<init>", "(Ljava/lang/String;)V", "getAnnotationId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigateToAnnotation extends Action {
            public static final int $stable = 0;
            private final String annotationId;

            public static /* synthetic */ NavigateToAnnotation copy$default(NavigateToAnnotation navigateToAnnotation, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = navigateToAnnotation.annotationId;
                }
                return navigateToAnnotation.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getAnnotationId() {
                return this.annotationId;
            }

            public final NavigateToAnnotation copy(String annotationId) {
                Intrinsics.checkNotNullParameter(annotationId, "annotationId");
                return new NavigateToAnnotation(annotationId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToAnnotation) && Intrinsics.areEqual(this.annotationId, ((NavigateToAnnotation) other).annotationId);
            }

            public int hashCode() {
                return this.annotationId.hashCode();
            }

            public String toString() {
                return "NavigateToAnnotation(annotationId=" + this.annotationId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToAnnotation(String annotationId) {
                super(null);
                Intrinsics.checkNotNullParameter(annotationId, "annotationId");
                this.annotationId = annotationId;
            }

            public final String getAnnotationId() {
                return this.annotationId;
            }
        }

        /* JADX INFO: compiled from: AnnotationsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$Release;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Release extends Action {
            public static final int $stable = 0;
            public static final Release INSTANCE = new Release();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Release)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -919230073;
            }

            public String toString() {
                return DebugTraceUtil.EVENT_RELEASE;
            }

            private Release() {
                super(null);
            }
        }
    }

    private final ReducerResult<State, Action> handleFetch(State state, List<DocumentSize> documentSizes) {
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, null, this.environment.getFeatureFlips().getCreateAnnotations().getEnabled(), 127, null), Effect.INSTANCE.merge(new Effect(Action.Refresh.INSTANCE), EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(state, documentSizes, null))).cancellable(AnnotationsReducerKt.createAnnotFetchKey(state.getFileId(), state.getFileVersionId()), true)));
    }

    /* JADX INFO: renamed from: com.box.android.preview.annotations.cpl.AnnotationsReducer$handleFetch$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnnotationsReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.annotations.cpl.AnnotationsReducer$handleFetch$1", f = "AnnotationsReducer.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {110, 114, 122}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-AnnotationsReducer$handleFetch$1$1", "$this$flow", "$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-AnnotationsReducer$handleFetch$1$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<DocumentSize> $documentSizes;
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, List<DocumentSize> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = state;
            this.$documentSizes = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = AnnotationsReducer.this.new AnonymousClass1(this.$state, this.$documentSizes, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:26:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:29:0x00cf  */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00cc, code lost:
        
            if (r0.emit(r4, r9) == r1) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 222
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.annotations.cpl.AnnotationsReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(AnnotationsReducer annotationsReducer, State state, Action action) {
        DeleteAnnotationState deleteAnnotationState;
        Object next;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.Refresh) {
            return new ReducerResult(state, EffectKt.toEffect(FlowKt.flow(new AnnotationsReducer$build$1$1(annotationsReducer, state, null))));
        }
        if (action instanceof Action.Fetch) {
            return annotationsReducer.handleFetch(state, ((Action.Fetch) action).getDocumentSizes());
        }
        if (action instanceof Action.Error) {
            return new ReducerResult(State.copy$default(state, null, null, ((Action.Error) action).getError(), null, null, null, null, false, 251, null), null, 2, null);
        }
        if (action instanceof Action.AnnotationsVisibilityChanged) {
            annotationsReducer.environment.getPdfAnnotationManager(state.getFileId()).setAnnotationVisibility(((Action.AnnotationsVisibilityChanged) action).isVisible());
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.UpdateAnnotations) {
            Action.UpdateAnnotations updateAnnotations = (Action.UpdateAnnotations) action;
            annotationsReducer.environment.getPdfAnnotationManager(state.getFileId()).replaceAnnotationsFromServer(updateAnnotations.getAnnotations());
            return new ReducerResult(State.copy$default(state, null, null, null, updateAnnotations.getAnnotations(), annotationsReducer.reselectSelectedAnnotation(annotationsReducer.environment.getPdfAnnotationManager(state.getFileId()), state.getSelectedAnnotation(), updateAnnotations.getAnnotations()), null, null, false, 231, null), null, 2, null);
        }
        if (action instanceof Action.Release) {
            return new ReducerResult(state, Effect.INSTANCE.merge(Effect.INSTANCE.cancel(AnnotationsReducerKt.createAnnotFetchKey(state.getFileId(), state.getFileVersionId())), Effect.INSTANCE.fireAndForget(new AnnotationsReducer$build$1$2(annotationsReducer, state, null))));
        }
        if (action instanceof Action.AnnotationSelected) {
            Iterator<T> it = state.getAnnotations().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((Action.AnnotationSelected) action).getAnnotation().getAnnotationId(), ((AnnotationWithLocation) next).getAnnotation().getAnnotationId()));
            AnnotationWithLocation annotationWithLocation = (AnnotationWithLocation) next;
            if (annotationWithLocation != null) {
                return new ReducerResult(State.copy$default(state, null, null, null, null, annotationWithLocation, null, ((Action.AnnotationSelected) action).getPopupLocation(), false, 175, null), null, 2, null);
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.AnnotationDeletedUserConfirmed) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, DeleteAnnotationState.InProgress, null, false, 223, null), EffectKt.toEffect(FlowKt.flow(new AnnotationsReducer$build$1$4(state, annotationsReducer, null))));
        }
        if (action instanceof Action.ShowDeletionConfirmationDialog) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, DeleteAnnotationState.ConfirmationRequired, null, false, Token.LETEXPR, null), null, 2, null);
        }
        if (action instanceof Action.UnselectAnnotation) {
            annotationsReducer.environment.getPdfAnnotationManager(state.getFileId()).unselectAllAnnotations();
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, false, 239, null), null, 2, null);
        }
        if (action instanceof Action.AnnotationDeletionCompleted) {
            if (((Action.AnnotationDeletionCompleted) action).isSuccess()) {
                deleteAnnotationState = DeleteAnnotationState.Success;
            } else {
                deleteAnnotationState = DeleteAnnotationState.Error;
            }
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, deleteAnnotationState, null, false, 223, null), null, 2, null);
        }
        if (action instanceof Action.ResetDeleteAnnotationState) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, false, 223, null), null, 2, null);
        }
        if ((action instanceof Action.ViewComments) || Intrinsics.areEqual(action, Action.AnnotationPopUpDismissed.INSTANCE)) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, false, 191, null), null, 2, null);
        }
        if (!(action instanceof Action.NavigateToAnnotation)) {
            throw new NoWhenBranchMatchedException();
        }
        Action.NavigateToAnnotation navigateToAnnotation = (Action.NavigateToAnnotation) action;
        if (!annotationsReducer.environment.getPdfAnnotationManager(state.getFileId()).navigateToAnnotation(navigateToAnnotation.getAnnotationId())) {
            return new ReducerResult(state, null, 2, null);
        }
        for (AnnotationWithLocation annotationWithLocation2 : state.getAnnotations()) {
            if (Intrinsics.areEqual(annotationWithLocation2.getAnnotation().getAnnotationId(), navigateToAnnotation.getAnnotationId())) {
                return new ReducerResult(state, new Effect(new Action.AnnotationSelected(annotationWithLocation2.getAnnotation(), null)));
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final AnnotationWithLocation reselectSelectedAnnotation(BoxPdfAnnotationManager annotationManager, AnnotationWithLocation selectedAnnotation, List<AnnotationWithLocation> newAnnotations) {
        Object next;
        if (selectedAnnotation != null) {
            Iterator<T> it = newAnnotations.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((AnnotationWithLocation) next).getAnnotation().getAnnotationId(), selectedAnnotation.getAnnotation().getAnnotationId()));
            AnnotationWithLocation annotationWithLocation = (AnnotationWithLocation) next;
            if (annotationWithLocation != null) {
                annotationManager.selectAnnotationWithId(annotationWithLocation.getAnnotation().getAnnotationId(), annotationWithLocation.getLocationModel());
                return annotationWithLocation;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<List<AnnotationWithLocation>> toFlowOfAnnotationWithLocation(final Flow<? extends List<FileActivityModel.AnnotationModel>> flow, final List<DocumentSize> list) {
        return FlowKt.distinctUntilChanged(new Flow<List<? extends AnnotationWithLocation>>() { // from class: com.box.android.preview.annotations.cpl.AnnotationsReducer$toFlowOfAnnotationWithLocation$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.preview.annotations.cpl.AnnotationsReducer$toFlowOfAnnotationWithLocation$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ List $documentSizes$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ AnnotationsReducer this$0;

                /* JADX INFO: renamed from: com.box.android.preview.annotations.cpl.AnnotationsReducer$toFlowOfAnnotationWithLocation$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.preview.annotations.cpl.AnnotationsReducer$toFlowOfAnnotationWithLocation$$inlined$map$1$2", f = "AnnotationsReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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

                public AnonymousClass2(FlowCollector flowCollector, List list, AnnotationsReducer annotationsReducer) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$documentSizes$inlined = list;
                    this.this$0 = annotationsReducer;
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
                        ArrayList arrayList = new ArrayList();
                        Iterator<T> it = ((List) obj).iterator();
                        while (it.hasNext()) {
                            AnnotationWithLocation annotationWithLocation = AnnotationsReducerKt.toAnnotationWithLocation((FileActivityModel.AnnotationModel) it.next(), this.$documentSizes$inlined, this.this$0.environment.getAnnotationModelMapper());
                            if (annotationWithLocation != null) {
                                arrayList.add(annotationWithLocation);
                            }
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(FlowCollector<? super List<? extends AnnotationWithLocation>> flowCollector, Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, list, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        });
    }
}
