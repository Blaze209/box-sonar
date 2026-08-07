package com.box.android.fileactivity.presentation;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.amplitude.api.Constants;
import com.box.android.base.presentation.components.commentbar.TimestampedCommentConfig;
import com.box.android.base.presentation.components.inputbar.InputBoxValue;
import com.box.android.base.routing.preview.PreviewRouter;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.annotations.FileActivityIdModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.models.annotations.FileActivityPermissionsModel;
import com.box.android.domain.models.annotations.FileActivityType;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.fileactivity.R;
import com.box.android.fileactivity.model.AnnotationLocationModelMapper;
import com.box.android.fileactivity.model.AnnotationLocationUIModel;
import com.box.android.fileactivity.model.AnnotationUIModelV2;
import com.box.android.fileactivity.model.CommentUIModelV2;
import com.box.android.fileactivity.model.FileActivityUIModelV2;
import com.box.android.fileactivity.model.FileActivityUIModelsV2Kt;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.pspdfkit.analytics.Analytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: FileActivitiesReducer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004()*+B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0002J4\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0002H\u0002J&\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$State;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "environment", "Lcom/box/android/fileactivity/presentation/FileActivitiesEnvironment;", "<init>", "(Lcom/box/android/fileactivity/presentation/FileActivitiesEnvironment;)V", "getEnvironment", "()Lcom/box/android/fileactivity/presentation/FileActivitiesEnvironment;", "handlePageBubbleClicked", "Lcom/box/android/cpl/ReducerResult;", "state", "context", "Landroid/content/Context;", "handleTimestampClicked", "timestampMs", "", Constants.AMP_PLAN_VERSION_ID, "", "handleFrameAnnotationClicked", "handleUpdateStatus", "status", "Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "handleSubmitModify", "timestampedCommentConfig", "Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "logSubmitModifyCta", "", "targetActivityId", "handleSubmitReply", "handleTriggerDelete", "targetId", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "logTriggerDelete", "logSingleThreadViewOpened", Analytics.Data.ACTION, "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "State", "ModifyState", "MenuButtonConfig", "Action", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivityReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final FileActivitiesEnvironment environment;

    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileActivityType.values().length];
            try {
                iArr[FileActivityType.COMMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FileActivityReducer(FileActivitiesEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivityReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FileActivityReducer.build$lambda$0(this.f$0, (FileActivityReducer.State) obj, (FileActivityReducer.Action) obj2);
            }
        });
    }

    public final FileActivitiesEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0002HÆ\u0003JS\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\u0013\u00104\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010!\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0014\u0010\"\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0%8F¢\u0006\u0006\u001a\u0004\b*\u0010'R\u0011\u0010+\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0018¨\u0006:"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$State;", "Lcom/box/android/cpl/Identifiable;", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "item", "Lcom/box/android/fileactivity/model/FileActivityUIModelV2;", "currentUserId", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "isSingleThreadView", "", "modifyState", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$ModifyState;", "replyActivity", "Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", IdentificationData.FIELD_PARENT_ID, "<init>", "(Lcom/box/android/fileactivity/model/FileActivityUIModelV2;Ljava/lang/String;Lcom/box/android/domain/models/item/FileModel;ZLcom/box/android/fileactivity/presentation/FileActivityReducer$ModifyState;Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;Lcom/box/android/domain/models/annotations/FileActivityIdModel;)V", "getItem", "()Lcom/box/android/fileactivity/model/FileActivityUIModelV2;", "getCurrentUserId", "()Ljava/lang/String;", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "()Z", "getModifyState", "()Lcom/box/android/fileactivity/presentation/FileActivityReducer$ModifyState;", "getReplyActivity", "()Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "getParentId", "()Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "modifyDescription", "getModifyDescription", "isItemOrReplyInModifyState", "id", "getId", "shownReplies", "", "getShownReplies", "()Ljava/util/List;", "enabledMenuItems", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$MenuButtonConfig;", "getEnabledMenuItems", "isEdited", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State implements Identifiable<FileActivityIdModel> {
        public static final int $stable = 8;
        private final String currentUserId;
        private final FileModel fileModel;
        private final boolean isEdited;
        private final boolean isItemOrReplyInModifyState;
        private final boolean isSingleThreadView;
        private final FileActivityUIModelV2 item;
        private final InputBoxValue modifyDescription;
        private final ModifyState modifyState;
        private final FileActivityIdModel parentId;
        private final InputBoxValue replyActivity;

        public static /* synthetic */ State copy$default(State state, FileActivityUIModelV2 fileActivityUIModelV2, String str, FileModel fileModel, boolean z, ModifyState modifyState, InputBoxValue inputBoxValue, FileActivityIdModel fileActivityIdModel, int i, Object obj) {
            if ((i & 1) != 0) {
                fileActivityUIModelV2 = state.item;
            }
            if ((i & 2) != 0) {
                str = state.currentUserId;
            }
            if ((i & 4) != 0) {
                fileModel = state.fileModel;
            }
            if ((i & 8) != 0) {
                z = state.isSingleThreadView;
            }
            if ((i & 16) != 0) {
                modifyState = state.modifyState;
            }
            if ((i & 32) != 0) {
                inputBoxValue = state.replyActivity;
            }
            if ((i & 64) != 0) {
                fileActivityIdModel = state.parentId;
            }
            InputBoxValue inputBoxValue2 = inputBoxValue;
            FileActivityIdModel fileActivityIdModel2 = fileActivityIdModel;
            ModifyState modifyState2 = modifyState;
            FileModel fileModel2 = fileModel;
            return state.copy(fileActivityUIModelV2, str, fileModel2, z, modifyState2, inputBoxValue2, fileActivityIdModel2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileActivityUIModelV2 getItem() {
            return this.item;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCurrentUserId() {
            return this.currentUserId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsSingleThreadView() {
            return this.isSingleThreadView;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ModifyState getModifyState() {
            return this.modifyState;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final InputBoxValue getReplyActivity() {
            return this.replyActivity;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final FileActivityIdModel getParentId() {
            return this.parentId;
        }

        public final State copy(FileActivityUIModelV2 item, String currentUserId, FileModel fileModel, boolean isSingleThreadView, ModifyState modifyState, InputBoxValue replyActivity, FileActivityIdModel parentId) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(currentUserId, "currentUserId");
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(replyActivity, "replyActivity");
            return new State(item, currentUserId, fileModel, isSingleThreadView, modifyState, replyActivity, parentId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.item, state.item) && Intrinsics.areEqual(this.currentUserId, state.currentUserId) && Intrinsics.areEqual(this.fileModel, state.fileModel) && this.isSingleThreadView == state.isSingleThreadView && Intrinsics.areEqual(this.modifyState, state.modifyState) && Intrinsics.areEqual(this.replyActivity, state.replyActivity) && Intrinsics.areEqual(this.parentId, state.parentId);
        }

        public int hashCode() {
            int iHashCode = ((((((this.item.hashCode() * 31) + this.currentUserId.hashCode()) * 31) + this.fileModel.hashCode()) * 31) + Boolean.hashCode(this.isSingleThreadView)) * 31;
            ModifyState modifyState = this.modifyState;
            int iHashCode2 = (((iHashCode + (modifyState == null ? 0 : modifyState.hashCode())) * 31) + this.replyActivity.hashCode()) * 31;
            FileActivityIdModel fileActivityIdModel = this.parentId;
            return iHashCode2 + (fileActivityIdModel != null ? fileActivityIdModel.hashCode() : 0);
        }

        public String toString() {
            return "State(item=" + this.item + ", currentUserId=" + this.currentUserId + ", fileModel=" + this.fileModel + ", isSingleThreadView=" + this.isSingleThreadView + ", modifyState=" + this.modifyState + ", replyActivity=" + this.replyActivity + ", parentId=" + this.parentId + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(FileActivityUIModelV2 item, String currentUserId, FileModel fileModel, boolean z, ModifyState modifyState, InputBoxValue replyActivity, FileActivityIdModel fileActivityIdModel) {
            InputBoxValue message;
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(currentUserId, "currentUserId");
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(replyActivity, "replyActivity");
            this.item = item;
            this.currentUserId = currentUserId;
            this.fileModel = fileModel;
            this.isSingleThreadView = z;
            this.modifyState = modifyState;
            this.replyActivity = replyActivity;
            this.parentId = fileActivityIdModel;
            this.modifyDescription = (modifyState == null || (message = modifyState.getMessage()) == null) ? new InputBoxValue(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0) : message;
            this.isItemOrReplyInModifyState = modifyState != null;
            this.isEdited = !Intrinsics.areEqual(FileActivityUIModelsV2Kt.getCreatedAt(item), FileActivityUIModelsV2Kt.getModifiedAt(item));
        }

        public final FileActivityUIModelV2 getItem() {
            return this.item;
        }

        public final String getCurrentUserId() {
            return this.currentUserId;
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final boolean isSingleThreadView() {
            return this.isSingleThreadView;
        }

        public final ModifyState getModifyState() {
            return this.modifyState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(FileActivityUIModelV2 fileActivityUIModelV2, String str, FileModel fileModel, boolean z, ModifyState modifyState, InputBoxValue inputBoxValue, FileActivityIdModel fileActivityIdModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileActivityUIModelV2, str, fileModel, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : modifyState, (i & 32) != 0 ? new InputBoxValue(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0) : inputBoxValue, (i & 64) != 0 ? null : fileActivityIdModel);
        }

        public final InputBoxValue getReplyActivity() {
            return this.replyActivity;
        }

        public final FileActivityIdModel getParentId() {
            return this.parentId;
        }

        public final InputBoxValue getModifyDescription() {
            return this.modifyDescription;
        }

        /* JADX INFO: renamed from: isItemOrReplyInModifyState, reason: from getter */
        public final boolean getIsItemOrReplyInModifyState() {
            return this.isItemOrReplyInModifyState;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.box.android.cpl.Identifiable
        public FileActivityIdModel getId() {
            return this.item.getId();
        }

        private static final CommentUIModelV2 _get_shownReplies_$mapReplyComment(CommentUIModelV2 commentUIModelV2, State state) {
            FileActivityPermissionsModel permissions = commentUIModelV2.getPermissions();
            return CommentUIModelV2.copy$default(commentUIModelV2, null, null, null, null, null, null, null, null, null, FileActivityUIModelsV2Kt.isResolved(state.item), FileActivityPermissionsModel.copy$default(permissions, permissions.getCanDelete() && Intrinsics.areEqual(state.currentUserId, commentUIModelV2.getCreatedByUserId()), false, false, false, false, 30, null), 511, null);
        }

        public final List<State> getShownReplies() {
            FileActivityUIModelV2 fileActivityUIModelV2 = this.item;
            if ((fileActivityUIModelV2 instanceof CommentUIModelV2) || (fileActivityUIModelV2 instanceof AnnotationUIModelV2)) {
                List<CommentUIModelV2> replies = FileActivityUIModelsV2Kt.getReplies(fileActivityUIModelV2);
                if (!this.isSingleThreadView) {
                    if (FileActivityUIModelsV2Kt.isResolved(this.item)) {
                        replies = null;
                    }
                    replies = replies != null ? CollectionsKt.takeLast(replies, 1) : null;
                    if (replies == null) {
                        replies = CollectionsKt.emptyList();
                    }
                }
                List<CommentUIModelV2> list = replies;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new State(_get_shownReplies_$mapReplyComment((CommentUIModelV2) it.next(), this), this.currentUserId, this.fileModel, this.isSingleThreadView, null, null, this.item.getId(), 48, null));
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }

        public final List<MenuButtonConfig> getEnabledMenuItems() {
            ArrayList arrayList = new ArrayList();
            FileActivityPermissionsModel permissions = FileActivityUIModelsV2Kt.getPermissions(this.item);
            if (permissions != null) {
                if (permissions.getCanChangeStatus()) {
                    if (FileActivityUIModelsV2Kt.isResolved(this.item)) {
                        arrayList.add(MenuButtonConfig.INSTANCE.getUNRESOLVE());
                    } else {
                        arrayList.add(MenuButtonConfig.INSTANCE.getRESOLVE());
                    }
                }
                if (permissions.getCanEdit()) {
                    arrayList.add(MenuButtonConfig.INSTANCE.getMODIFY());
                }
                if (permissions.getCanDelete()) {
                    arrayList.add(MenuButtonConfig.INSTANCE.getDELETE());
                }
            }
            return arrayList;
        }

        /* JADX INFO: renamed from: isEdited, reason: from getter */
        public final boolean getIsEdited() {
            return this.isEdited;
        }
    }

    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$ModifyState;", "", "targetId", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "message", "Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "<init>", "(Lcom/box/android/domain/models/annotations/FileActivityIdModel;Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;)V", "getTargetId", "()Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "getMessage", "()Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ModifyState {
        public static final int $stable = 8;
        private final InputBoxValue message;
        private final FileActivityIdModel targetId;

        public static /* synthetic */ ModifyState copy$default(ModifyState modifyState, FileActivityIdModel fileActivityIdModel, InputBoxValue inputBoxValue, int i, Object obj) {
            if ((i & 1) != 0) {
                fileActivityIdModel = modifyState.targetId;
            }
            if ((i & 2) != 0) {
                inputBoxValue = modifyState.message;
            }
            return modifyState.copy(fileActivityIdModel, inputBoxValue);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileActivityIdModel getTargetId() {
            return this.targetId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final InputBoxValue getMessage() {
            return this.message;
        }

        public final ModifyState copy(FileActivityIdModel targetId, InputBoxValue message) {
            Intrinsics.checkNotNullParameter(targetId, "targetId");
            Intrinsics.checkNotNullParameter(message, "message");
            return new ModifyState(targetId, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModifyState)) {
                return false;
            }
            ModifyState modifyState = (ModifyState) other;
            return Intrinsics.areEqual(this.targetId, modifyState.targetId) && Intrinsics.areEqual(this.message, modifyState.message);
        }

        public int hashCode() {
            return (this.targetId.hashCode() * 31) + this.message.hashCode();
        }

        public String toString() {
            return "ModifyState(targetId=" + this.targetId + ", message=" + this.message + ")";
        }

        public ModifyState(FileActivityIdModel targetId, InputBoxValue message) {
            Intrinsics.checkNotNullParameter(targetId, "targetId");
            Intrinsics.checkNotNullParameter(message, "message");
            this.targetId = targetId;
            this.message = message;
        }

        public final InputBoxValue getMessage() {
            return this.message;
        }

        public final FileActivityIdModel getTargetId() {
            return this.targetId;
        }
    }

    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$MenuButtonConfig;", "", "drawableRes", "", "stringRes", "<init>", "(II)V", "getDrawableRes", "()I", "getStringRes", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "Companion", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MenuButtonConfig {
        public static final int $stable = 0;
        private final int drawableRes;
        private final int stringRes;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final MenuButtonConfig RESOLVE = new MenuButtonConfig(R.drawable.ic_baseline_check_24, R.string.resolve);
        private static final MenuButtonConfig UNRESOLVE = new MenuButtonConfig(R.drawable.ic_close_24dp, R.string.unresolve);
        private static final MenuButtonConfig MODIFY = new MenuButtonConfig(R.drawable.file_activity_edit_icon, R.string.modify);
        private static final MenuButtonConfig DELETE = new MenuButtonConfig(R.drawable.icon_white_delete, R.string.LO_Delete);

        public static /* synthetic */ MenuButtonConfig copy$default(MenuButtonConfig menuButtonConfig, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = menuButtonConfig.drawableRes;
            }
            if ((i3 & 2) != 0) {
                i2 = menuButtonConfig.stringRes;
            }
            return menuButtonConfig.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDrawableRes() {
            return this.drawableRes;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getStringRes() {
            return this.stringRes;
        }

        public final MenuButtonConfig copy(int drawableRes, int stringRes) {
            return new MenuButtonConfig(drawableRes, stringRes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MenuButtonConfig)) {
                return false;
            }
            MenuButtonConfig menuButtonConfig = (MenuButtonConfig) other;
            return this.drawableRes == menuButtonConfig.drawableRes && this.stringRes == menuButtonConfig.stringRes;
        }

        public int hashCode() {
            return (Integer.hashCode(this.drawableRes) * 31) + Integer.hashCode(this.stringRes);
        }

        public String toString() {
            return "MenuButtonConfig(drawableRes=" + this.drawableRes + ", stringRes=" + this.stringRes + ")";
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$MenuButtonConfig$Companion;", "", "<init>", "()V", "RESOLVE", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$MenuButtonConfig;", "getRESOLVE", "()Lcom/box/android/fileactivity/presentation/FileActivityReducer$MenuButtonConfig;", "UNRESOLVE", "getUNRESOLVE", "MODIFY", "getMODIFY", "DELETE", "getDELETE", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final MenuButtonConfig getRESOLVE() {
                return MenuButtonConfig.RESOLVE;
            }

            public final MenuButtonConfig getUNRESOLVE() {
                return MenuButtonConfig.UNRESOLVE;
            }

            public final MenuButtonConfig getMODIFY() {
                return MenuButtonConfig.MODIFY;
            }

            public final MenuButtonConfig getDELETE() {
                return MenuButtonConfig.DELETE;
            }
        }

        public MenuButtonConfig(int i, int i2) {
            this.drawableRes = i;
            this.stringRes = i2;
        }

        public final int getDrawableRes() {
            return this.drawableRes;
        }

        public final int getStringRes() {
            return this.stringRes;
        }
    }

    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0011\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0011\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%¨\u0006&"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "", "<init>", "()V", "PageVersionBubbleClicked", "TimestampClicked", "FrameAnnotationClicked", "ChangeSingleThreadVisibility", "ItemClicked", "MoreRepliesClicked", "ReplyButtonClicked", "SaveReplyActivity", "SaveModifyMessage", "SubmitUpdateStatus", "TriggerDelete", "TriggerModify", "ExitModify", "CommentSubmissionCompleted", "ShowErrorMessage", "SubmitModify", "SubmitReply", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$ChangeSingleThreadVisibility;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$CommentSubmissionCompleted;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$ExitModify;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$FrameAnnotationClicked;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$ItemClicked;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$MoreRepliesClicked;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$PageVersionBubbleClicked;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$ReplyButtonClicked;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$SaveModifyMessage;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$SaveReplyActivity;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$ShowErrorMessage;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$SubmitModify;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$SubmitReply;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$SubmitUpdateStatus;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$TimestampClicked;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$TriggerDelete;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$TriggerModify;", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$PageVersionBubbleClicked;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PageVersionBubbleClicked extends Action {
            public static final int $stable = 8;
            private final Context context;

            public static /* synthetic */ PageVersionBubbleClicked copy$default(PageVersionBubbleClicked pageVersionBubbleClicked, Context context, int i, Object obj) {
                if ((i & 1) != 0) {
                    context = pageVersionBubbleClicked.context;
                }
                return pageVersionBubbleClicked.copy(context);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Context getContext() {
                return this.context;
            }

            public final PageVersionBubbleClicked copy(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new PageVersionBubbleClicked(context);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PageVersionBubbleClicked) && Intrinsics.areEqual(this.context, ((PageVersionBubbleClicked) other).context);
            }

            public int hashCode() {
                return this.context.hashCode();
            }

            public String toString() {
                return "PageVersionBubbleClicked(context=" + this.context + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PageVersionBubbleClicked(Context context) {
                super(null);
                Intrinsics.checkNotNullParameter(context, "context");
                this.context = context;
            }

            public final Context getContext() {
                return this.context;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$TimestampClicked;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "timestampMs", "", Constants.AMP_PLAN_VERSION_ID, "", "context", "Landroid/content/Context;", "<init>", "(JLjava/lang/String;Landroid/content/Context;)V", "getTimestampMs", "()J", "getVersionId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TimestampClicked extends Action {
            public static final int $stable = 8;
            private final Context context;
            private final long timestampMs;
            private final String versionId;

            public static /* synthetic */ TimestampClicked copy$default(TimestampClicked timestampClicked, long j, String str, Context context, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = timestampClicked.timestampMs;
                }
                if ((i & 2) != 0) {
                    str = timestampClicked.versionId;
                }
                if ((i & 4) != 0) {
                    context = timestampClicked.context;
                }
                return timestampClicked.copy(j, str, context);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getTimestampMs() {
                return this.timestampMs;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getVersionId() {
                return this.versionId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Context getContext() {
                return this.context;
            }

            public final TimestampClicked copy(long timestampMs, String versionId, Context context) {
                Intrinsics.checkNotNullParameter(versionId, "versionId");
                Intrinsics.checkNotNullParameter(context, "context");
                return new TimestampClicked(timestampMs, versionId, context);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TimestampClicked)) {
                    return false;
                }
                TimestampClicked timestampClicked = (TimestampClicked) other;
                return this.timestampMs == timestampClicked.timestampMs && Intrinsics.areEqual(this.versionId, timestampClicked.versionId) && Intrinsics.areEqual(this.context, timestampClicked.context);
            }

            public int hashCode() {
                return (((Long.hashCode(this.timestampMs) * 31) + this.versionId.hashCode()) * 31) + this.context.hashCode();
            }

            public String toString() {
                return "TimestampClicked(timestampMs=" + this.timestampMs + ", versionId=" + this.versionId + ", context=" + this.context + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TimestampClicked(long j, String versionId, Context context) {
                super(null);
                Intrinsics.checkNotNullParameter(versionId, "versionId");
                Intrinsics.checkNotNullParameter(context, "context");
                this.timestampMs = j;
                this.versionId = versionId;
                this.context = context;
            }

            public final Context getContext() {
                return this.context;
            }

            public final long getTimestampMs() {
                return this.timestampMs;
            }

            public final String getVersionId() {
                return this.versionId;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$FrameAnnotationClicked;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FrameAnnotationClicked extends Action {
            public static final int $stable = 8;
            private final Context context;

            public static /* synthetic */ FrameAnnotationClicked copy$default(FrameAnnotationClicked frameAnnotationClicked, Context context, int i, Object obj) {
                if ((i & 1) != 0) {
                    context = frameAnnotationClicked.context;
                }
                return frameAnnotationClicked.copy(context);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Context getContext() {
                return this.context;
            }

            public final FrameAnnotationClicked copy(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new FrameAnnotationClicked(context);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FrameAnnotationClicked) && Intrinsics.areEqual(this.context, ((FrameAnnotationClicked) other).context);
            }

            public int hashCode() {
                return this.context.hashCode();
            }

            public String toString() {
                return "FrameAnnotationClicked(context=" + this.context + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FrameAnnotationClicked(Context context) {
                super(null);
                Intrinsics.checkNotNullParameter(context, "context");
                this.context = context;
            }

            public final Context getContext() {
                return this.context;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$ChangeSingleThreadVisibility;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "value", "", "<init>", "(Z)V", "getValue", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ChangeSingleThreadVisibility extends Action {
            public static final int $stable = 0;
            private final boolean value;

            public static /* synthetic */ ChangeSingleThreadVisibility copy$default(ChangeSingleThreadVisibility changeSingleThreadVisibility, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = changeSingleThreadVisibility.value;
                }
                return changeSingleThreadVisibility.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getValue() {
                return this.value;
            }

            public final ChangeSingleThreadVisibility copy(boolean value) {
                return new ChangeSingleThreadVisibility(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChangeSingleThreadVisibility) && this.value == ((ChangeSingleThreadVisibility) other).value;
            }

            public int hashCode() {
                return Boolean.hashCode(this.value);
            }

            public String toString() {
                return "ChangeSingleThreadVisibility(value=" + this.value + ")";
            }

            public ChangeSingleThreadVisibility(boolean z) {
                super(null);
                this.value = z;
            }

            public final boolean getValue() {
                return this.value;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$ItemClicked;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemClicked extends Action {
            public static final int $stable = 0;
            public static final ItemClicked INSTANCE = new ItemClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ItemClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1829483639;
            }

            public String toString() {
                return "ItemClicked";
            }

            private ItemClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$MoreRepliesClicked;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MoreRepliesClicked extends Action {
            public static final int $stable = 0;
            public static final MoreRepliesClicked INSTANCE = new MoreRepliesClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MoreRepliesClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1826171617;
            }

            public String toString() {
                return "MoreRepliesClicked";
            }

            private MoreRepliesClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$ReplyButtonClicked;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ReplyButtonClicked extends Action {
            public static final int $stable = 0;
            public static final ReplyButtonClicked INSTANCE = new ReplyButtonClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReplyButtonClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -769280458;
            }

            public String toString() {
                return "ReplyButtonClicked";
            }

            private ReplyButtonClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$SaveReplyActivity;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "updatedInputBoxValue", "Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "<init>", "(Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;)V", "getUpdatedInputBoxValue", "()Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SaveReplyActivity extends Action {
            public static final int $stable = InputBoxValue.$stable;
            private final InputBoxValue updatedInputBoxValue;

            public static /* synthetic */ SaveReplyActivity copy$default(SaveReplyActivity saveReplyActivity, InputBoxValue inputBoxValue, int i, Object obj) {
                if ((i & 1) != 0) {
                    inputBoxValue = saveReplyActivity.updatedInputBoxValue;
                }
                return saveReplyActivity.copy(inputBoxValue);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InputBoxValue getUpdatedInputBoxValue() {
                return this.updatedInputBoxValue;
            }

            public final SaveReplyActivity copy(InputBoxValue updatedInputBoxValue) {
                Intrinsics.checkNotNullParameter(updatedInputBoxValue, "updatedInputBoxValue");
                return new SaveReplyActivity(updatedInputBoxValue);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SaveReplyActivity) && Intrinsics.areEqual(this.updatedInputBoxValue, ((SaveReplyActivity) other).updatedInputBoxValue);
            }

            public int hashCode() {
                return this.updatedInputBoxValue.hashCode();
            }

            public String toString() {
                return "SaveReplyActivity(updatedInputBoxValue=" + this.updatedInputBoxValue + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SaveReplyActivity(InputBoxValue updatedInputBoxValue) {
                super(null);
                Intrinsics.checkNotNullParameter(updatedInputBoxValue, "updatedInputBoxValue");
                this.updatedInputBoxValue = updatedInputBoxValue;
            }

            public final InputBoxValue getUpdatedInputBoxValue() {
                return this.updatedInputBoxValue;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$SaveModifyMessage;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "updatedInputBoxValue", "Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "<init>", "(Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;)V", "getUpdatedInputBoxValue", "()Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SaveModifyMessage extends Action {
            public static final int $stable = InputBoxValue.$stable;
            private final InputBoxValue updatedInputBoxValue;

            public static /* synthetic */ SaveModifyMessage copy$default(SaveModifyMessage saveModifyMessage, InputBoxValue inputBoxValue, int i, Object obj) {
                if ((i & 1) != 0) {
                    inputBoxValue = saveModifyMessage.updatedInputBoxValue;
                }
                return saveModifyMessage.copy(inputBoxValue);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InputBoxValue getUpdatedInputBoxValue() {
                return this.updatedInputBoxValue;
            }

            public final SaveModifyMessage copy(InputBoxValue updatedInputBoxValue) {
                Intrinsics.checkNotNullParameter(updatedInputBoxValue, "updatedInputBoxValue");
                return new SaveModifyMessage(updatedInputBoxValue);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SaveModifyMessage) && Intrinsics.areEqual(this.updatedInputBoxValue, ((SaveModifyMessage) other).updatedInputBoxValue);
            }

            public int hashCode() {
                return this.updatedInputBoxValue.hashCode();
            }

            public String toString() {
                return "SaveModifyMessage(updatedInputBoxValue=" + this.updatedInputBoxValue + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SaveModifyMessage(InputBoxValue updatedInputBoxValue) {
                super(null);
                Intrinsics.checkNotNullParameter(updatedInputBoxValue, "updatedInputBoxValue");
                this.updatedInputBoxValue = updatedInputBoxValue;
            }

            public final InputBoxValue getUpdatedInputBoxValue() {
                return this.updatedInputBoxValue;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$SubmitUpdateStatus;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "status", "Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "<init>", "(Lcom/box/android/domain/models/annotations/FileActivityModel$Status;)V", "getStatus", "()Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SubmitUpdateStatus extends Action {
            public static final int $stable = 0;
            private final FileActivityModel.Status status;

            public static /* synthetic */ SubmitUpdateStatus copy$default(SubmitUpdateStatus submitUpdateStatus, FileActivityModel.Status status, int i, Object obj) {
                if ((i & 1) != 0) {
                    status = submitUpdateStatus.status;
                }
                return submitUpdateStatus.copy(status);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileActivityModel.Status getStatus() {
                return this.status;
            }

            public final SubmitUpdateStatus copy(FileActivityModel.Status status) {
                Intrinsics.checkNotNullParameter(status, "status");
                return new SubmitUpdateStatus(status);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SubmitUpdateStatus) && this.status == ((SubmitUpdateStatus) other).status;
            }

            public int hashCode() {
                return this.status.hashCode();
            }

            public String toString() {
                return "SubmitUpdateStatus(status=" + this.status + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SubmitUpdateStatus(FileActivityModel.Status status) {
                super(null);
                Intrinsics.checkNotNullParameter(status, "status");
                this.status = status;
            }

            public final FileActivityModel.Status getStatus() {
                return this.status;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$TriggerDelete;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "targetId", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "<init>", "(Lcom/box/android/domain/models/annotations/FileActivityIdModel;)V", "getTargetId", "()Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TriggerDelete extends Action {
            public static final int $stable = 8;
            private final FileActivityIdModel targetId;

            public static /* synthetic */ TriggerDelete copy$default(TriggerDelete triggerDelete, FileActivityIdModel fileActivityIdModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileActivityIdModel = triggerDelete.targetId;
                }
                return triggerDelete.copy(fileActivityIdModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileActivityIdModel getTargetId() {
                return this.targetId;
            }

            public final TriggerDelete copy(FileActivityIdModel targetId) {
                Intrinsics.checkNotNullParameter(targetId, "targetId");
                return new TriggerDelete(targetId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TriggerDelete) && Intrinsics.areEqual(this.targetId, ((TriggerDelete) other).targetId);
            }

            public int hashCode() {
                return this.targetId.hashCode();
            }

            public String toString() {
                return "TriggerDelete(targetId=" + this.targetId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TriggerDelete(FileActivityIdModel targetId) {
                super(null);
                Intrinsics.checkNotNullParameter(targetId, "targetId");
                this.targetId = targetId;
            }

            public final FileActivityIdModel getTargetId() {
                return this.targetId;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$TriggerModify;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "item", "Lcom/box/android/fileactivity/model/FileActivityUIModelV2;", "<init>", "(Lcom/box/android/fileactivity/model/FileActivityUIModelV2;)V", "getItem", "()Lcom/box/android/fileactivity/model/FileActivityUIModelV2;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TriggerModify extends Action {
            public static final int $stable = 8;
            private final FileActivityUIModelV2 item;

            public static /* synthetic */ TriggerModify copy$default(TriggerModify triggerModify, FileActivityUIModelV2 fileActivityUIModelV2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileActivityUIModelV2 = triggerModify.item;
                }
                return triggerModify.copy(fileActivityUIModelV2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileActivityUIModelV2 getItem() {
                return this.item;
            }

            public final TriggerModify copy(FileActivityUIModelV2 item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new TriggerModify(item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TriggerModify) && Intrinsics.areEqual(this.item, ((TriggerModify) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            public String toString() {
                return "TriggerModify(item=" + this.item + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TriggerModify(FileActivityUIModelV2 item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            public final FileActivityUIModelV2 getItem() {
                return this.item;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$ExitModify;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ExitModify extends Action {
            public static final int $stable = 0;
            public static final ExitModify INSTANCE = new ExitModify();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ExitModify)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2120749795;
            }

            public String toString() {
                return "ExitModify";
            }

            private ExitModify() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$CommentSubmissionCompleted;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "newCommentId", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "<init>", "(Lcom/box/android/domain/models/annotations/FileActivityIdModel;)V", "getNewCommentId", "()Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CommentSubmissionCompleted extends Action {
            public static final int $stable = 8;
            private final FileActivityIdModel newCommentId;

            public static /* synthetic */ CommentSubmissionCompleted copy$default(CommentSubmissionCompleted commentSubmissionCompleted, FileActivityIdModel fileActivityIdModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileActivityIdModel = commentSubmissionCompleted.newCommentId;
                }
                return commentSubmissionCompleted.copy(fileActivityIdModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileActivityIdModel getNewCommentId() {
                return this.newCommentId;
            }

            public final CommentSubmissionCompleted copy(FileActivityIdModel newCommentId) {
                return new CommentSubmissionCompleted(newCommentId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CommentSubmissionCompleted) && Intrinsics.areEqual(this.newCommentId, ((CommentSubmissionCompleted) other).newCommentId);
            }

            public int hashCode() {
                FileActivityIdModel fileActivityIdModel = this.newCommentId;
                if (fileActivityIdModel == null) {
                    return 0;
                }
                return fileActivityIdModel.hashCode();
            }

            public String toString() {
                return "CommentSubmissionCompleted(newCommentId=" + this.newCommentId + ")";
            }

            public CommentSubmissionCompleted(FileActivityIdModel fileActivityIdModel) {
                super(null);
                this.newCommentId = fileActivityIdModel;
            }

            public final FileActivityIdModel getNewCommentId() {
                return this.newCommentId;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$ShowErrorMessage;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "errorMessageRes", "", "<init>", "(I)V", "getErrorMessageRes", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowErrorMessage extends Action {
            public static final int $stable = 0;
            private final int errorMessageRes;

            public static /* synthetic */ ShowErrorMessage copy$default(ShowErrorMessage showErrorMessage, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showErrorMessage.errorMessageRes;
                }
                return showErrorMessage.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getErrorMessageRes() {
                return this.errorMessageRes;
            }

            public final ShowErrorMessage copy(int errorMessageRes) {
                return new ShowErrorMessage(errorMessageRes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowErrorMessage) && this.errorMessageRes == ((ShowErrorMessage) other).errorMessageRes;
            }

            public int hashCode() {
                return Integer.hashCode(this.errorMessageRes);
            }

            public String toString() {
                return "ShowErrorMessage(errorMessageRes=" + this.errorMessageRes + ")";
            }

            public ShowErrorMessage(int i) {
                super(null);
                this.errorMessageRes = i;
            }

            public final int getErrorMessageRes() {
                return this.errorMessageRes;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$SubmitModify;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "timestampedCommentConfig", "Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "<init>", "(Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;)V", "getTimestampedCommentConfig", "()Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SubmitModify extends Action {
            public static final int $stable = TimestampedCommentConfig.$stable;
            private final TimestampedCommentConfig timestampedCommentConfig;

            /* JADX WARN: Multi-variable type inference failed */
            public SubmitModify() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ SubmitModify copy$default(SubmitModify submitModify, TimestampedCommentConfig timestampedCommentConfig, int i, Object obj) {
                if ((i & 1) != 0) {
                    timestampedCommentConfig = submitModify.timestampedCommentConfig;
                }
                return submitModify.copy(timestampedCommentConfig);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final TimestampedCommentConfig getTimestampedCommentConfig() {
                return this.timestampedCommentConfig;
            }

            public final SubmitModify copy(TimestampedCommentConfig timestampedCommentConfig) {
                return new SubmitModify(timestampedCommentConfig);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SubmitModify) && Intrinsics.areEqual(this.timestampedCommentConfig, ((SubmitModify) other).timestampedCommentConfig);
            }

            public int hashCode() {
                TimestampedCommentConfig timestampedCommentConfig = this.timestampedCommentConfig;
                if (timestampedCommentConfig == null) {
                    return 0;
                }
                return timestampedCommentConfig.hashCode();
            }

            public String toString() {
                return "SubmitModify(timestampedCommentConfig=" + this.timestampedCommentConfig + ")";
            }

            public SubmitModify(TimestampedCommentConfig timestampedCommentConfig) {
                super(null);
                this.timestampedCommentConfig = timestampedCommentConfig;
            }

            public /* synthetic */ SubmitModify(TimestampedCommentConfig timestampedCommentConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : timestampedCommentConfig);
            }

            public final TimestampedCommentConfig getTimestampedCommentConfig() {
                return this.timestampedCommentConfig;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action$SubmitReply;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "timestampedCommentConfig", "Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "<init>", "(Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;)V", "getTimestampedCommentConfig", "()Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SubmitReply extends Action {
            public static final int $stable = TimestampedCommentConfig.$stable;
            private final TimestampedCommentConfig timestampedCommentConfig;

            /* JADX WARN: Multi-variable type inference failed */
            public SubmitReply() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ SubmitReply copy$default(SubmitReply submitReply, TimestampedCommentConfig timestampedCommentConfig, int i, Object obj) {
                if ((i & 1) != 0) {
                    timestampedCommentConfig = submitReply.timestampedCommentConfig;
                }
                return submitReply.copy(timestampedCommentConfig);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final TimestampedCommentConfig getTimestampedCommentConfig() {
                return this.timestampedCommentConfig;
            }

            public final SubmitReply copy(TimestampedCommentConfig timestampedCommentConfig) {
                return new SubmitReply(timestampedCommentConfig);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SubmitReply) && Intrinsics.areEqual(this.timestampedCommentConfig, ((SubmitReply) other).timestampedCommentConfig);
            }

            public int hashCode() {
                TimestampedCommentConfig timestampedCommentConfig = this.timestampedCommentConfig;
                if (timestampedCommentConfig == null) {
                    return 0;
                }
                return timestampedCommentConfig.hashCode();
            }

            public String toString() {
                return "SubmitReply(timestampedCommentConfig=" + this.timestampedCommentConfig + ")";
            }

            public SubmitReply(TimestampedCommentConfig timestampedCommentConfig) {
                super(null);
                this.timestampedCommentConfig = timestampedCommentConfig;
            }

            public /* synthetic */ SubmitReply(TimestampedCommentConfig timestampedCommentConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : timestampedCommentConfig);
            }

            public final TimestampedCommentConfig getTimestampedCommentConfig() {
                return this.timestampedCommentConfig;
            }
        }
    }

    private final ReducerResult<State, Action> handlePageBubbleClicked(State state, Context context) {
        BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logPageNumberCtaTriggered(state.getFileModel().getItemId().toString());
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new C16401(state, this, context, null)));
    }

    /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivityReducer$handlePageBubbleClicked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivityReducer$handlePageBubbleClicked$1", f = "FileActivitiesReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16401 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ State $state;
        int label;
        final /* synthetic */ FileActivityReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16401(State state, FileActivityReducer fileActivityReducer, Context context, Continuation<? super C16401> continuation) {
            super(1, continuation);
            this.$state = state;
            this.this$0 = fileActivityReducer;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C16401(this.$state, this.this$0, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C16401) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FileActivityUIModelV2 item = this.$state.getItem();
            if (item instanceof AnnotationUIModelV2) {
                PreviewRouter previewRouter = this.this$0.getEnvironment().getPreviewRouter();
                AnnotationUIModelV2 annotationUIModelV2 = (AnnotationUIModelV2) item;
                Integer number = annotationUIModelV2.getVersion().getNumber();
                int iIntValue = number != null ? number.intValue() : 1;
                String id = annotationUIModelV2.getVersion().getId();
                if (annotationUIModelV2.isOnLatestVersion()) {
                    id = null;
                }
                previewRouter.onAnnotationActivityClicked(iIntValue, id, annotationUIModelV2.getActivityId(), AnnotationLocationModelMapper.INSTANCE.toAnnotationLocationModel(annotationUIModelV2.getLocation()), FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, this.$state.getFileModel(), false, 1, null), this.$context);
            }
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> handleTimestampClicked(State state, long timestampMs, String versionId, Context context) {
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new C16431(versionId, timestampMs, state, context, null)));
    }

    /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivityReducer$handleTimestampClicked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivityReducer$handleTimestampClicked$1", f = "FileActivitiesReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16431 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ State $state;
        final /* synthetic */ long $timestampMs;
        final /* synthetic */ String $versionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16431(String str, long j, State state, Context context, Continuation<? super C16431> continuation) {
            super(1, continuation);
            this.$versionId = str;
            this.$timestampMs = j;
            this.$state = state;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FileActivityReducer.this.new C16431(this.$versionId, this.$timestampMs, this.$state, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C16431) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PreviewRouter previewRouter = FileActivityReducer.this.getEnvironment().getPreviewRouter();
            String str = this.$versionId;
            FileVersionMiniModel fileVersion = this.$state.getFileModel().getFileVersion();
            previewRouter.onTimestampClicked(!Intrinsics.areEqual(fileVersion != null ? fileVersion.getId() : null, str) ? str : null, this.$timestampMs, this.$state.getFileModel(), this.$context);
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> handleFrameAnnotationClicked(State state, Context context) {
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(state, this, context, null)));
    }

    /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivityReducer$handleFrameAnnotationClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivityReducer$handleFrameAnnotationClicked$1", f = "FileActivitiesReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ State $state;
        int label;
        final /* synthetic */ FileActivityReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, FileActivityReducer fileActivityReducer, Context context, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
            this.this$0 = fileActivityReducer;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, this.this$0, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FileActivityUIModelV2 item = this.$state.getItem();
            if (item instanceof AnnotationUIModelV2) {
                AnnotationUIModelV2 annotationUIModelV2 = (AnnotationUIModelV2) item;
                if (annotationUIModelV2.getLocation() instanceof AnnotationLocationUIModel.Frame) {
                    PreviewRouter previewRouter = this.this$0.getEnvironment().getPreviewRouter();
                    Integer number = annotationUIModelV2.getVersion().getNumber();
                    int iIntValue = number != null ? number.intValue() : 1;
                    String id = annotationUIModelV2.getVersion().getId();
                    if (annotationUIModelV2.isOnLatestVersion()) {
                        id = null;
                    }
                    previewRouter.onAnnotationActivityClicked(iIntValue, id, annotationUIModelV2.getActivityId(), AnnotationLocationModelMapper.INSTANCE.toAnnotationLocationModel(annotationUIModelV2.getLocation()), FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, this.$state.getFileModel(), false, 1, null), this.$context);
                }
            }
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> handleUpdateStatus(State state, FileActivityModel.Status status) {
        return new ReducerResult<>(state, new Effect(FlowKt.flow(new C16451(status, state, this, null))));
    }

    /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivityReducer$handleUpdateStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivityReducer$handleUpdateStatus$1", f = "FileActivitiesReducer.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, l = {881, 888, 896, 899, TypedValues.Custom.TYPE_STRING}, m = "invokeSuspend", n = {"$this$flow", "loggingActionName", "errorMessage", "$this$flow", "loggingActionName", "errorMessage", "$this$flow", "loggingActionName", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onSuccess$iv", "it", "errorMessage", "$i$f$onSuccess", "$i$a$-onSuccess-FileActivityReducer$handleUpdateStatus$1$1", "$this$flow", "loggingActionName", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onError$iv", "it", "errorMessage", "$i$f$onError", "$i$a$-onError-FileActivityReducer$handleUpdateStatus$1$2", "$this$flow", "loggingActionName", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onError$iv", "it", "errorMessage", "$i$f$onError", "$i$a$-onError-FileActivityReducer$handleUpdateStatus$1$2"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, v = 1)
    static final class C16451 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        final /* synthetic */ FileActivityModel.Status $status;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ FileActivityReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16451(FileActivityModel.Status status, State state, FileActivityReducer fileActivityReducer, Continuation<? super C16451> continuation) {
            super(2, continuation);
            this.$status = status;
            this.$state = state;
            this.this$0 = fileActivityReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16451 c16451 = new C16451(this.$status, this.$state, this.this$0, continuation);
            c16451.L$0 = obj;
            return c16451;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16451) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:45:0x0190  */
        /* JADX WARN: Code duplicated, block: B:47:0x0194  */
        /* JADX WARN: Code duplicated, block: B:50:0x01ca  */
        /* JADX WARN: Code duplicated, block: B:54:0x0200  */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x010e, code lost:
        
            if (r7 == r2) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0146, code lost:
        
            if (r7 == r2) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x01fd, code lost:
        
            if (r1.emit(r11, r18) == r2) goto L53;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 527
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.fileactivity.presentation.FileActivityReducer.C16451.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final ReducerResult<State, Action> handleSubmitModify(State state, TimestampedCommentConfig timestampedCommentConfig) {
        return new ReducerResult<>(state, new Effect((Flow) EffectKt.toEffect(FlowKt.flow(new C16411(state, timestampedCommentConfig, this, null)))));
    }

    /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivityReducer$handleSubmitModify$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivityReducer$handleSubmitModify$1", f = "FileActivitiesReducer.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7}, l = {927, 929, 938, 946, 949, 953, 957, 960}, m = "invokeSuspend", n = {"$this$flow", "targetId", "inputBoxValue", "textFieldValue", "content", "shouldUseTaggedMessage", "$this$flow", "targetId", "inputBoxValue", "textFieldValue", "$this$flow", "targetId", "inputBoxValue", "textFieldValue", "$this$flow", "targetId", "inputBoxValue", "textFieldValue", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-FileActivityReducer$handleSubmitModify$1$1", "$this$flow", "targetId", "inputBoxValue", "textFieldValue", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-FileActivityReducer$handleSubmitModify$1$1", "$this$flow", "targetId", "inputBoxValue", "textFieldValue", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-FileActivityReducer$handleSubmitModify$1$2", "$this$flow", "targetId", "inputBoxValue", "textFieldValue", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-FileActivityReducer$handleSubmitModify$1$2", "$this$flow", "targetId", "inputBoxValue", "textFieldValue", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class C16411 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        final /* synthetic */ TimestampedCommentConfig $timestampedCommentConfig;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ FileActivityReducer this$0;

        /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivityReducer$handleSubmitModify$1$WhenMappings */
        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FileActivityType.values().length];
                try {
                    iArr[FileActivityType.COMMENT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16411(State state, TimestampedCommentConfig timestampedCommentConfig, FileActivityReducer fileActivityReducer, Continuation<? super C16411> continuation) {
            super(2, continuation);
            this.$state = state;
            this.$timestampedCommentConfig = timestampedCommentConfig;
            this.this$0 = fileActivityReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16411 c16411 = new C16411(this.$state, this.$timestampedCommentConfig, this.this$0, continuation);
            c16411.L$0 = obj;
            return c16411;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16411) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:37:0x023d  */
        /* JADX WARN: Code duplicated, block: B:40:0x027b  */
        /* JADX WARN: Code duplicated, block: B:44:0x02b1  */
        /* JADX WARN: Code duplicated, block: B:46:0x02b6  */
        /* JADX WARN: Code duplicated, block: B:48:0x02ba  */
        /* JADX WARN: Code duplicated, block: B:51:0x02c6  */
        /* JADX WARN: Code duplicated, block: B:53:0x02ca  */
        /* JADX WARN: Code duplicated, block: B:56:0x030c  */
        /* JADX WARN: Code duplicated, block: B:60:0x034f  */
        /* JADX WARN: Code duplicated, block: B:62:0x0356  */
        /* JADX WARN: Code duplicated, block: B:64:0x035c A[PHI: r6 r7 r8 r12
          0x035c: PHI (r6v30 com.box.android.domain.utils.result.Result) = (r6v19 com.box.android.domain.utils.result.Result), (r6v33 com.box.android.domain.utils.result.Result) binds: [B:50:0x02c4, B:61:0x0351] A[DONT_GENERATE, DONT_INLINE]
          0x035c: PHI (r7v27 com.box.android.base.presentation.components.inputbar.InputBoxValue) = 
          (r7v18 com.box.android.base.presentation.components.inputbar.InputBoxValue)
          (r7v30 com.box.android.base.presentation.components.inputbar.InputBoxValue)
         binds: [B:50:0x02c4, B:61:0x0351] A[DONT_GENERATE, DONT_INLINE]
          0x035c: PHI (r8v19 com.box.android.domain.models.annotations.FileActivityIdModel) = 
          (r8v11 com.box.android.domain.models.annotations.FileActivityIdModel)
          (r8v21 com.box.android.domain.models.annotations.FileActivityIdModel)
         binds: [B:50:0x02c4, B:61:0x0351] A[DONT_GENERATE, DONT_INLINE]
          0x035c: PHI (r12v21 java.lang.String) = (r12v13 java.lang.String), (r12v22 java.lang.String) binds: [B:50:0x02c4, B:61:0x0351] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:69:0x0395  */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x01b2, code lost:
        
            if (r3 == r2) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x01f2, code lost:
        
            if (r3 == r2) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0230, code lost:
        
            if (r3 == r2) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x038f, code lost:
        
            if (r1.emit(new com.box.android.fileactivity.presentation.FileActivityReducer.Action.CommentSubmissionCompleted(null), r17) == r2) goto L66;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 946
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.fileactivity.presentation.FileActivityReducer.C16411.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logSubmitModifyCta(String targetActivityId, State state) {
        if (!Intrinsics.areEqual(targetActivityId, state.getId().getActivityId())) {
            BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logEditReplyCtaTriggered(state.getFileModel().getItemId().toString());
        } else {
            BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logEditCommentCtaTriggered(state.getFileModel().getItemId().toString());
        }
    }

    private final ReducerResult<State, Action> handleSubmitReply(State state, TimestampedCommentConfig timestampedCommentConfig) {
        if (WhenMappings.$EnumSwitchMapping$0[state.getId().getType().ordinal()] == 1) {
            BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logSubmitReplyCtaTriggered(state.getFileModel().getItemId().toString());
        } else {
            BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logAnnotationReplyCtaTriggered(state.getFileModel().getItemId().toString());
        }
        return new ReducerResult<>(state, new Effect((Flow) EffectKt.toEffect(FlowKt.flow(new C16421(state, timestampedCommentConfig, null)))));
    }

    /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivityReducer$handleSubmitReply$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivityReducer$handleSubmitReply$1", f = "FileActivitiesReducer.kt", i = {0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4}, l = {991, 998, 1003, 1007, 1010}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-FileActivityReducer$handleSubmitReply$1$1", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-FileActivityReducer$handleSubmitReply$1$2", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-FileActivityReducer$handleSubmitReply$1$2", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1"}, v = 1)
    static final class C16421 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        final /* synthetic */ TimestampedCommentConfig $timestampedCommentConfig;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16421(State state, TimestampedCommentConfig timestampedCommentConfig, Continuation<? super C16421> continuation) {
            super(2, continuation);
            this.$state = state;
            this.$timestampedCommentConfig = timestampedCommentConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16421 c16421 = FileActivityReducer.this.new C16421(this.$state, this.$timestampedCommentConfig, continuation);
            c16421.L$0 = obj;
            return c16421;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16421) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00e3  */
        /* JADX WARN: Code duplicated, block: B:30:0x00e7  */
        /* JADX WARN: Code duplicated, block: B:33:0x0111  */
        /* JADX WARN: Code duplicated, block: B:37:0x0138  */
        /* JADX WARN: Code duplicated, block: B:39:0x013e A[PHI: r2
          0x013e: PHI (r2v8 com.box.android.domain.utils.result.Result) = 
          (r2v6 com.box.android.domain.utils.result.Result)
          (r2v7 com.box.android.domain.utils.result.Result)
          (r2v23 com.box.android.domain.utils.result.Result)
         binds: [B:27:0x00e1, B:35:0x0135, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:41:0x0147  */
        /* JADX WARN: Code duplicated, block: B:44:0x0155  */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0174, code lost:
        
            if (r0.emit(new com.box.android.fileactivity.presentation.FileActivityReducer.Action.CommentSubmissionCompleted(r5), r13) == r1) goto L47;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 384
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.fileactivity.presentation.FileActivityReducer.C16421.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final ReducerResult<State, Action> handleTriggerDelete(State state, FileActivityIdModel targetId) {
        return new ReducerResult<>(state, new Effect(FlowKt.flow(new C16441(state, targetId, null))));
    }

    /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivityReducer$handleTriggerDelete$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivityReducer$handleTriggerDelete$1", f = "FileActivitiesReducer.kt", i = {0, 1, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5}, l = {AnalyticsListener.EVENT_VIDEO_CODEC_ERROR, 1035, 1042, 1048, 1053, 1057}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$flow", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-FileActivityReducer$handleTriggerDelete$1$1", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-FileActivityReducer$handleTriggerDelete$1$2", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-FileActivityReducer$handleTriggerDelete$1$2"}, s = {"L$0", "L$0", "L$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C16441 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        final /* synthetic */ FileActivityIdModel $targetId;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivityReducer$handleTriggerDelete$1$WhenMappings */
        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FileActivityType.values().length];
                try {
                    iArr[FileActivityType.COMMENT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16441(State state, FileActivityIdModel fileActivityIdModel, Continuation<? super C16441> continuation) {
            super(2, continuation);
            this.$state = state;
            this.$targetId = fileActivityIdModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16441 c16441 = FileActivityReducer.this.new C16441(this.$state, this.$targetId, continuation);
            c16441.L$0 = obj;
            return c16441;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16441) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x011d  */
        /* JADX WARN: Code duplicated, block: B:35:0x014b  */
        /* JADX WARN: Code duplicated, block: B:40:0x0156  */
        /* JADX WARN: Code duplicated, block: B:42:0x015a  */
        /* JADX WARN: Code duplicated, block: B:45:0x0189  */
        /* JADX WARN: Code duplicated, block: B:49:0x01b9  */
        /* JADX WARN: Code duplicated, block: B:53:0x01c2  */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x00b5, code lost:
        
            if (r9 == r1) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00e3, code lost:
        
            if (r9 == r1) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0110, code lost:
        
            if (r9 == r1) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x01b6, code lost:
        
            if (r0.emit(r2, r8) == r1) goto L48;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 474
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.fileactivity.presentation.FileActivityReducer.C16441.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logTriggerDelete(State state, FileActivityIdModel targetId) {
        if (Intrinsics.areEqual(state.getId().getActivityId(), targetId.getActivityId())) {
            BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logDeleteCommentCtaTriggered(state.getFileModel().getItemId().toString());
        } else {
            BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logDeleteReplyCtaTriggered(state.getFileModel().getItemId().toString());
        }
    }

    private final void logSingleThreadViewOpened(State state, Action action) {
        if (action instanceof Action.MoreRepliesClicked) {
            BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logSingleThreadViewOpened(state.getFileModel().getItemId().toString());
            BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logReplyCountCtaTriggered(state.getFileModel().getItemId().toString());
        } else if (action instanceof Action.ItemClicked) {
            BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logSingleThreadViewOpened(state.getFileModel().getItemId().toString());
        } else if (action instanceof Action.ReplyButtonClicked) {
            BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logSingleThreadViewOpened(state.getFileModel().getItemId().toString());
            BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logReplyCtaTriggered(state.getFileModel().getItemId().toString());
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(FileActivityReducer fileActivityReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.PageVersionBubbleClicked) {
            return fileActivityReducer.handlePageBubbleClicked(state, ((Action.PageVersionBubbleClicked) action).getContext());
        }
        if (action instanceof Action.TimestampClicked) {
            Action.TimestampClicked timestampClicked = (Action.TimestampClicked) action;
            return fileActivityReducer.handleTimestampClicked(state, timestampClicked.getTimestampMs(), timestampClicked.getVersionId(), timestampClicked.getContext());
        }
        if (action instanceof Action.FrameAnnotationClicked) {
            return fileActivityReducer.handleFrameAnnotationClicked(state, ((Action.FrameAnnotationClicked) action).getContext());
        }
        if ((action instanceof Action.ItemClicked) || Intrinsics.areEqual(action, Action.MoreRepliesClicked.INSTANCE) || Intrinsics.areEqual(action, Action.ReplyButtonClicked.INSTANCE)) {
            fileActivityReducer.logSingleThreadViewOpened(state, action);
            return new ReducerResult(state, new Effect(new Action.ChangeSingleThreadVisibility(true)));
        }
        if (action instanceof Action.ChangeSingleThreadVisibility) {
            return new ReducerResult(State.copy$default(state, null, null, null, ((Action.ChangeSingleThreadVisibility) action).getValue(), null, null, null, 119, null), null, 2, null);
        }
        if (action instanceof Action.SaveReplyActivity) {
            return new ReducerResult(State.copy$default(state, null, null, null, false, null, ((Action.SaveReplyActivity) action).getUpdatedInputBoxValue(), null, 95, null), null, 2, null);
        }
        if (action instanceof Action.SaveModifyMessage) {
            ModifyState modifyState = state.getModifyState();
            Intrinsics.checkNotNull(modifyState);
            return new ReducerResult(State.copy$default(state, null, null, null, false, ModifyState.copy$default(modifyState, null, ((Action.SaveModifyMessage) action).getUpdatedInputBoxValue(), 1, null), null, null, 111, null), null, 2, null);
        }
        if (action instanceof Action.TriggerDelete) {
            return fileActivityReducer.handleTriggerDelete(state, ((Action.TriggerDelete) action).getTargetId());
        }
        if (action instanceof Action.SubmitModify) {
            return fileActivityReducer.handleSubmitModify(state, ((Action.SubmitModify) action).getTimestampedCommentConfig());
        }
        if (action instanceof Action.SubmitUpdateStatus) {
            return fileActivityReducer.handleUpdateStatus(state, ((Action.SubmitUpdateStatus) action).getStatus());
        }
        if (action instanceof Action.SubmitReply) {
            return fileActivityReducer.handleSubmitReply(state, ((Action.SubmitReply) action).getTimestampedCommentConfig());
        }
        if (action instanceof Action.ExitModify) {
            return new ReducerResult(State.copy$default(state, null, null, null, false, null, null, null, 111, null), null, 2, null);
        }
        if (action instanceof Action.CommentSubmissionCompleted) {
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.TriggerModify) {
            Action.TriggerModify triggerModify = (Action.TriggerModify) action;
            return new ReducerResult(State.copy$default(state, null, null, null, false, new ModifyState(triggerModify.getItem().getId(), FileActivityUIModelsV2Kt.toInputBoxValue(FileActivityUIModelsV2Kt.getMessage(triggerModify.getItem()), fileActivityReducer.environment.getFeatureFlips().getVideoAnnotations().getEnabled())), null, null, 111, null), null, 2, null);
        }
        if (action instanceof Action.ShowErrorMessage) {
            return new ReducerResult(state, null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
