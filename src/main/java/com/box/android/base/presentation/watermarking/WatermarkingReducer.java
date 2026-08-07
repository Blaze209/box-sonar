package com.box.android.base.presentation.watermarking;

import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.WatermarkModel;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyReplyChannel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: WatermarkingReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005+,-./B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u001c\u0010\u0011\u001a\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u001aH\u0002J2\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010#J2\u0010$\u001a\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020\u0015H\u0002J\u001e\u0010(\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u00060"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;", "environment", "Lcom/box/android/base/presentation/watermarking/WatermarkingEnvironment;", "<init>", "(Lcom/box/android/base/presentation/watermarking/WatermarkingEnvironment;)V", "getEnvironment", "()Lcom/box/android/base/presentation/watermarking/WatermarkingEnvironment;", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "loadWatermarkDataEffect", "Lcom/box/android/cpl/Effect;", "state", "mapResultToAction", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "mapDomainErrorToWatermarkingError", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "error", "saveWatermarkEffect", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State$Loaded;", "performWatermarkOperation", "", "target", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;", "isWatermarkingEnabled", "", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;ZLcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleSaveResult", "(Lcom/box/android/domain/utils/result/Result;Lcom/box/android/domain/models/ItemId;Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State$Loaded;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toFailReasonString", "", "refreshAndCreateSaveCompletedAction", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State$Loaded;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapDomainErrorToSaveError", "WatermarkingDisabledReason", "WatermarkingTarget", "State", "WatermarkingError", "Action", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WatermarkingReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final WatermarkingEnvironment environment;

    /* JADX INFO: renamed from: com.box.android.base.presentation.watermarking.WatermarkingReducer$refreshAndCreateSaveCompletedAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WatermarkingReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.watermarking.WatermarkingReducer", f = "WatermarkingReducer.kt", i = {0, 0}, l = {372}, m = "refreshAndCreateSaveCompletedAction", n = {"itemId", "state"}, s = {"L$0", "L$1"}, v = 1)
    static final class C09361 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09361(Continuation<? super C09361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WatermarkingReducer.this.refreshAndCreateSaveCompletedAction(null, null, this);
        }
    }

    public WatermarkingReducer(WatermarkingEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatermarkingReducer.build$lambda$0(this.f$0, (WatermarkingReducer.State) obj, (WatermarkingReducer.Action) obj2);
            }
        });
    }

    public final WatermarkingEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: WatermarkingReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "", "<init>", "()V", "EnabledAtParentLevel", "EnforcedByAccessPolicy", "NotSupportedForFileType", "NoPermission", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason$EnabledAtParentLevel;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason$EnforcedByAccessPolicy;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason$NoPermission;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason$NotSupportedForFileType;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class WatermarkingDisabledReason {
        public static final int $stable = 0;

        public /* synthetic */ WatermarkingDisabledReason(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private WatermarkingDisabledReason() {
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason$EnabledAtParentLevel;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EnabledAtParentLevel extends WatermarkingDisabledReason {
            public static final int $stable = 0;
            public static final EnabledAtParentLevel INSTANCE = new EnabledAtParentLevel();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EnabledAtParentLevel)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -126700468;
            }

            public String toString() {
                return "EnabledAtParentLevel";
            }

            private EnabledAtParentLevel() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason$EnforcedByAccessPolicy;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EnforcedByAccessPolicy extends WatermarkingDisabledReason {
            public static final int $stable = 0;
            public static final EnforcedByAccessPolicy INSTANCE = new EnforcedByAccessPolicy();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EnforcedByAccessPolicy)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1927198507;
            }

            public String toString() {
                return "EnforcedByAccessPolicy";
            }

            private EnforcedByAccessPolicy() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason$NotSupportedForFileType;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NotSupportedForFileType extends WatermarkingDisabledReason {
            public static final int $stable = 0;
            public static final NotSupportedForFileType INSTANCE = new NotSupportedForFileType();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NotSupportedForFileType)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 501900190;
            }

            public String toString() {
                return "NotSupportedForFileType";
            }

            private NotSupportedForFileType() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason$NoPermission;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NoPermission extends WatermarkingDisabledReason {
            public static final int $stable = 0;
            public static final NoPermission INSTANCE = new NoPermission();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoPermission)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -794604618;
            }

            public String toString() {
                return "NoPermission";
            }

            private NoPermission() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: WatermarkingReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0002\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;", "", "<init>", "()V", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "isFile", "", "()Z", "itemId", "Lcom/box/android/domain/models/ItemId;", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "File", "Folder", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget$File;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget$Folder;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class WatermarkingTarget {
        public static final int $stable = 0;

        public /* synthetic */ WatermarkingTarget(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget$File;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class File extends WatermarkingTarget {
            public static final int $stable = 8;
            private final FileModel fileModel;

            public static /* synthetic */ File copy$default(File file, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = file.fileModel;
                }
                return file.copy(fileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final File copy(FileModel fileModel) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new File(fileModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof File) && Intrinsics.areEqual(this.fileModel, ((File) other).fileModel);
            }

            public int hashCode() {
                return this.fileModel.hashCode();
            }

            public String toString() {
                return "File(fileModel=" + this.fileModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public File(FileModel fileModel) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }

        private WatermarkingTarget() {
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget$Folder;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;", "folderModel", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolderModel", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Folder extends WatermarkingTarget {
            public static final int $stable = 8;
            private final FolderModel folderModel;

            public static /* synthetic */ Folder copy$default(Folder folder, FolderModel folderModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = folder.folderModel;
                }
                return folder.copy(folderModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getFolderModel() {
                return this.folderModel;
            }

            public final Folder copy(FolderModel folderModel) {
                Intrinsics.checkNotNullParameter(folderModel, "folderModel");
                return new Folder(folderModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Folder) && Intrinsics.areEqual(this.folderModel, ((Folder) other).folderModel);
            }

            public int hashCode() {
                return this.folderModel.hashCode();
            }

            public String toString() {
                return "Folder(folderModel=" + this.folderModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Folder(FolderModel folderModel) {
                super(null);
                Intrinsics.checkNotNullParameter(folderModel, "folderModel");
                this.folderModel = folderModel;
            }

            public final FolderModel getFolderModel() {
                return this.folderModel;
            }
        }

        public final String getDisplayName() {
            if (this instanceof File) {
                return ((File) this).getFileModel().getName();
            }
            if (this instanceof Folder) {
                return ((Folder) this).getFolderModel().getName();
            }
            throw new NoWhenBranchMatchedException();
        }

        public final boolean isFile() {
            return this instanceof File;
        }

        public final ItemId getItemId() {
            if (this instanceof File) {
                return ((File) this).getFileModel().getItemId();
            }
            if (this instanceof Folder) {
                return ((Folder) this).getFolderModel().getItemId();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: WatermarkingReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\nR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\n\u0082\u0001\u0003\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State;", "", "<init>", "()V", "target", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;", "getTarget", "()Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;", "isSaving", "", "()Z", "isDismissing", "isToggleEnabled", "hasChanges", "getHasChanges", "isSaveEnabled", "isLoading", "shouldDismissWithSuccess", "getShouldDismissWithSuccess", "Loading", "Loaded", "Error", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State$Error;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State$Loaded;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State$Loading;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class State {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract WatermarkingTarget getTarget();

        /* JADX INFO: renamed from: isDismissing */
        public abstract boolean getIsDismissing();

        /* JADX INFO: renamed from: isSaving */
        public abstract boolean getIsSaving();

        private State() {
        }

        public final boolean isToggleEnabled() {
            if (this instanceof Loading) {
                return false;
            }
            if (this instanceof Loaded) {
                Loaded loaded = (Loaded) this;
                return loaded.getDisabledReason() == null && !loaded.getIsSaving();
            }
            if (this instanceof Error) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final boolean getHasChanges() {
            if (this instanceof Loading) {
                return false;
            }
            if (this instanceof Loaded) {
                Loaded loaded = (Loaded) this;
                return loaded.isWatermarkingEnabled() != loaded.getInitialWatermarkingEnabled();
            }
            if (this instanceof Error) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final boolean isSaveEnabled() {
            return (!getHasChanges() || getIsSaving() || (this instanceof Loading)) ? false : true;
        }

        public final boolean isLoading() {
            return this instanceof Loading;
        }

        public final boolean getShouldDismissWithSuccess() {
            return (getIsSaving() || !getIsDismissing() || getHasChanges()) ? false : true;
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State$Loading;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State;", "target", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;", "<init>", "(Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;)V", "getTarget", "()Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;", "isSaving", "", "()Z", "isDismissing", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loading extends State {
            public static final int $stable = 0;
            private final boolean isDismissing;
            private final boolean isSaving;
            private final WatermarkingTarget target;

            public static /* synthetic */ Loading copy$default(Loading loading, WatermarkingTarget watermarkingTarget, int i, Object obj) {
                if ((i & 1) != 0) {
                    watermarkingTarget = loading.target;
                }
                return loading.copy(watermarkingTarget);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final WatermarkingTarget getTarget() {
                return this.target;
            }

            public final Loading copy(WatermarkingTarget target) {
                Intrinsics.checkNotNullParameter(target, "target");
                return new Loading(target);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Loading) && Intrinsics.areEqual(this.target, ((Loading) other).target);
            }

            public int hashCode() {
                return this.target.hashCode();
            }

            public String toString() {
                return "Loading(target=" + this.target + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(WatermarkingTarget target) {
                super(null);
                Intrinsics.checkNotNullParameter(target, "target");
                this.target = target;
            }

            @Override // com.box.android.base.presentation.watermarking.WatermarkingReducer.State
            public WatermarkingTarget getTarget() {
                return this.target;
            }

            @Override // com.box.android.base.presentation.watermarking.WatermarkingReducer.State
            /* JADX INFO: renamed from: isSaving, reason: from getter */
            public boolean getIsSaving() {
                return this.isSaving;
            }

            @Override // com.box.android.base.presentation.watermarking.WatermarkingReducer.State
            /* JADX INFO: renamed from: isDismissing, reason: from getter */
            public boolean getIsDismissing() {
                return this.isDismissing;
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0014\u0010\n\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\""}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State$Loaded;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State;", "target", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;", "isWatermarkingEnabled", "", "initialWatermarkingEnabled", "disabledReason", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "isSaving", "isDismissing", "<init>", "(Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;ZZLcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;ZZ)V", "getTarget", "()Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;", "()Z", "getInitialWatermarkingEnabled", "getDisabledReason", "()Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "isTargetFile", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loaded extends State {
            public static final int $stable = 0;
            private final WatermarkingDisabledReason disabledReason;
            private final boolean initialWatermarkingEnabled;
            private final boolean isDismissing;
            private final boolean isSaving;
            private final boolean isWatermarkingEnabled;
            private final WatermarkingTarget target;

            public static /* synthetic */ Loaded copy$default(Loaded loaded, WatermarkingTarget watermarkingTarget, boolean z, boolean z2, WatermarkingDisabledReason watermarkingDisabledReason, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    watermarkingTarget = loaded.target;
                }
                if ((i & 2) != 0) {
                    z = loaded.isWatermarkingEnabled;
                }
                if ((i & 4) != 0) {
                    z2 = loaded.initialWatermarkingEnabled;
                }
                if ((i & 8) != 0) {
                    watermarkingDisabledReason = loaded.disabledReason;
                }
                if ((i & 16) != 0) {
                    z3 = loaded.isSaving;
                }
                if ((i & 32) != 0) {
                    z4 = loaded.isDismissing;
                }
                boolean z5 = z3;
                boolean z6 = z4;
                return loaded.copy(watermarkingTarget, z, z2, watermarkingDisabledReason, z5, z6);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final WatermarkingTarget getTarget() {
                return this.target;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsWatermarkingEnabled() {
                return this.isWatermarkingEnabled;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getInitialWatermarkingEnabled() {
                return this.initialWatermarkingEnabled;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final WatermarkingDisabledReason getDisabledReason() {
                return this.disabledReason;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getIsSaving() {
                return this.isSaving;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsDismissing() {
                return this.isDismissing;
            }

            public final Loaded copy(WatermarkingTarget target, boolean isWatermarkingEnabled, boolean initialWatermarkingEnabled, WatermarkingDisabledReason disabledReason, boolean isSaving, boolean isDismissing) {
                Intrinsics.checkNotNullParameter(target, "target");
                return new Loaded(target, isWatermarkingEnabled, initialWatermarkingEnabled, disabledReason, isSaving, isDismissing);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics.areEqual(this.target, loaded.target) && this.isWatermarkingEnabled == loaded.isWatermarkingEnabled && this.initialWatermarkingEnabled == loaded.initialWatermarkingEnabled && Intrinsics.areEqual(this.disabledReason, loaded.disabledReason) && this.isSaving == loaded.isSaving && this.isDismissing == loaded.isDismissing;
            }

            public int hashCode() {
                int iHashCode = ((((this.target.hashCode() * 31) + Boolean.hashCode(this.isWatermarkingEnabled)) * 31) + Boolean.hashCode(this.initialWatermarkingEnabled)) * 31;
                WatermarkingDisabledReason watermarkingDisabledReason = this.disabledReason;
                return ((((iHashCode + (watermarkingDisabledReason == null ? 0 : watermarkingDisabledReason.hashCode())) * 31) + Boolean.hashCode(this.isSaving)) * 31) + Boolean.hashCode(this.isDismissing);
            }

            public String toString() {
                return "Loaded(target=" + this.target + ", isWatermarkingEnabled=" + this.isWatermarkingEnabled + ", initialWatermarkingEnabled=" + this.initialWatermarkingEnabled + ", disabledReason=" + this.disabledReason + ", isSaving=" + this.isSaving + ", isDismissing=" + this.isDismissing + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(WatermarkingTarget target, boolean z, boolean z2, WatermarkingDisabledReason watermarkingDisabledReason, boolean z3, boolean z4) {
                super(null);
                Intrinsics.checkNotNullParameter(target, "target");
                this.target = target;
                this.isWatermarkingEnabled = z;
                this.initialWatermarkingEnabled = z2;
                this.disabledReason = watermarkingDisabledReason;
                this.isSaving = z3;
                this.isDismissing = z4;
            }

            public /* synthetic */ Loaded(WatermarkingTarget watermarkingTarget, boolean z, boolean z2, WatermarkingDisabledReason watermarkingDisabledReason, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(watermarkingTarget, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : watermarkingDisabledReason, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4);
            }

            @Override // com.box.android.base.presentation.watermarking.WatermarkingReducer.State
            public WatermarkingTarget getTarget() {
                return this.target;
            }

            public final boolean isWatermarkingEnabled() {
                return this.isWatermarkingEnabled;
            }

            public final boolean getInitialWatermarkingEnabled() {
                return this.initialWatermarkingEnabled;
            }

            public final WatermarkingDisabledReason getDisabledReason() {
                return this.disabledReason;
            }

            @Override // com.box.android.base.presentation.watermarking.WatermarkingReducer.State
            /* JADX INFO: renamed from: isSaving */
            public boolean getIsSaving() {
                return this.isSaving;
            }

            @Override // com.box.android.base.presentation.watermarking.WatermarkingReducer.State
            /* JADX INFO: renamed from: isDismissing */
            public boolean getIsDismissing() {
                return this.isDismissing;
            }

            public final boolean isTargetFile() {
                return getTarget().isFile();
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State$Error;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State;", "target", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;", "error", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "isSaving", "", "isDismissing", "<init>", "(Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;ZZ)V", "getTarget", "()Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingTarget;", "getError", "()Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "()Z", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends State {
            public static final int $stable = 0;
            private final WatermarkingError error;
            private final boolean isDismissing;
            private final boolean isSaving;
            private final WatermarkingTarget target;

            public static /* synthetic */ Error copy$default(Error error, WatermarkingTarget watermarkingTarget, WatermarkingError watermarkingError, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    watermarkingTarget = error.target;
                }
                if ((i & 2) != 0) {
                    watermarkingError = error.error;
                }
                if ((i & 4) != 0) {
                    z = error.isSaving;
                }
                if ((i & 8) != 0) {
                    z2 = error.isDismissing;
                }
                return error.copy(watermarkingTarget, watermarkingError, z, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final WatermarkingTarget getTarget() {
                return this.target;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final WatermarkingError getError() {
                return this.error;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsSaving() {
                return this.isSaving;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsDismissing() {
                return this.isDismissing;
            }

            public final Error copy(WatermarkingTarget target, WatermarkingError error, boolean isSaving, boolean isDismissing) {
                Intrinsics.checkNotNullParameter(target, "target");
                Intrinsics.checkNotNullParameter(error, "error");
                return new Error(target, error, isSaving, isDismissing);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return Intrinsics.areEqual(this.target, error.target) && Intrinsics.areEqual(this.error, error.error) && this.isSaving == error.isSaving && this.isDismissing == error.isDismissing;
            }

            public int hashCode() {
                return (((((this.target.hashCode() * 31) + this.error.hashCode()) * 31) + Boolean.hashCode(this.isSaving)) * 31) + Boolean.hashCode(this.isDismissing);
            }

            public String toString() {
                return "Error(target=" + this.target + ", error=" + this.error + ", isSaving=" + this.isSaving + ", isDismissing=" + this.isDismissing + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(WatermarkingTarget target, WatermarkingError error, boolean z, boolean z2) {
                super(null);
                Intrinsics.checkNotNullParameter(target, "target");
                Intrinsics.checkNotNullParameter(error, "error");
                this.target = target;
                this.error = error;
                this.isSaving = z;
                this.isDismissing = z2;
            }

            public /* synthetic */ Error(WatermarkingTarget watermarkingTarget, WatermarkingError watermarkingError, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(watermarkingTarget, watermarkingError, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
            }

            @Override // com.box.android.base.presentation.watermarking.WatermarkingReducer.State
            public WatermarkingTarget getTarget() {
                return this.target;
            }

            public final WatermarkingError getError() {
                return this.error;
            }

            @Override // com.box.android.base.presentation.watermarking.WatermarkingReducer.State
            /* JADX INFO: renamed from: isSaving */
            public boolean getIsSaving() {
                return this.isSaving;
            }

            @Override // com.box.android.base.presentation.watermarking.WatermarkingReducer.State
            /* JADX INFO: renamed from: isDismissing */
            public boolean getIsDismissing() {
                return this.isDismissing;
            }
        }
    }

    /* JADX INFO: compiled from: WatermarkingReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "", "<init>", "()V", "NetworkError", "ItemNotFound", "SaveError", PasskeyReplyChannel.DOM_EXCEPTION_UNKNOWN_ERROR, "PermissionDataMissing", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError$ItemNotFound;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError$NetworkError;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError$PermissionDataMissing;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError$SaveError;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError$UnknownError;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class WatermarkingError {
        public static final int $stable = 0;

        public /* synthetic */ WatermarkingError(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError$NetworkError;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NetworkError extends WatermarkingError {
            public static final int $stable = 0;
            public static final NetworkError INSTANCE = new NetworkError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NetworkError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1840366056;
            }

            public String toString() {
                return "NetworkError";
            }

            private NetworkError() {
                super(null);
            }
        }

        private WatermarkingError() {
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError$ItemNotFound;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemNotFound extends WatermarkingError {
            public static final int $stable = 0;
            public static final ItemNotFound INSTANCE = new ItemNotFound();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ItemNotFound)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -229314032;
            }

            public String toString() {
                return "ItemNotFound";
            }

            private ItemNotFound() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError$SaveError;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SaveError extends WatermarkingError {
            public static final int $stable = 0;
            public static final SaveError INSTANCE = new SaveError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SaveError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1510793251;
            }

            public String toString() {
                return "SaveError";
            }

            private SaveError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError$UnknownError;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UnknownError extends WatermarkingError {
            public static final int $stable = 0;
            public static final UnknownError INSTANCE = new UnknownError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UnknownError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 540565836;
            }

            public String toString() {
                return PasskeyReplyChannel.DOM_EXCEPTION_UNKNOWN_ERROR;
            }

            private UnknownError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError$PermissionDataMissing;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PermissionDataMissing extends WatermarkingError {
            public static final int $stable = 0;
            public static final PermissionDataMissing INSTANCE = new PermissionDataMissing();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PermissionDataMissing)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1832665249;
            }

            public String toString() {
                return "PermissionDataMissing";
            }

            private PermissionDataMissing() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: WatermarkingReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;", "", "<init>", "()V", "Initialize", "ToggleWatermarking", "WatermarkingDataLoaded", "WatermarkingDataLoadFailed", "Save", "SaveCompleted", "SaveFailed", "Cancel", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$Cancel;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$Initialize;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$Save;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$SaveCompleted;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$SaveFailed;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$ToggleWatermarking;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$WatermarkingDataLoadFailed;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$WatermarkingDataLoaded;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$Initialize;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -1547977570;
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

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$ToggleWatermarking;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ToggleWatermarking extends Action {
            public static final int $stable = 0;
            private final boolean enabled;

            public static /* synthetic */ ToggleWatermarking copy$default(ToggleWatermarking toggleWatermarking, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = toggleWatermarking.enabled;
                }
                return toggleWatermarking.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getEnabled() {
                return this.enabled;
            }

            public final ToggleWatermarking copy(boolean enabled) {
                return new ToggleWatermarking(enabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ToggleWatermarking) && this.enabled == ((ToggleWatermarking) other).enabled;
            }

            public int hashCode() {
                return Boolean.hashCode(this.enabled);
            }

            public String toString() {
                return "ToggleWatermarking(enabled=" + this.enabled + ")";
            }

            public ToggleWatermarking(boolean z) {
                super(null);
                this.enabled = z;
            }

            public final boolean getEnabled() {
                return this.enabled;
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$WatermarkingDataLoaded;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;", "isEnabled", "", "disabledReason", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "<init>", "(ZLcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;)V", "()Z", "getDisabledReason", "()Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class WatermarkingDataLoaded extends Action {
            public static final int $stable = 0;
            private final WatermarkingDisabledReason disabledReason;
            private final boolean isEnabled;

            public static /* synthetic */ WatermarkingDataLoaded copy$default(WatermarkingDataLoaded watermarkingDataLoaded, boolean z, WatermarkingDisabledReason watermarkingDisabledReason, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = watermarkingDataLoaded.isEnabled;
                }
                if ((i & 2) != 0) {
                    watermarkingDisabledReason = watermarkingDataLoaded.disabledReason;
                }
                return watermarkingDataLoaded.copy(z, watermarkingDisabledReason);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsEnabled() {
                return this.isEnabled;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final WatermarkingDisabledReason getDisabledReason() {
                return this.disabledReason;
            }

            public final WatermarkingDataLoaded copy(boolean isEnabled, WatermarkingDisabledReason disabledReason) {
                return new WatermarkingDataLoaded(isEnabled, disabledReason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof WatermarkingDataLoaded)) {
                    return false;
                }
                WatermarkingDataLoaded watermarkingDataLoaded = (WatermarkingDataLoaded) other;
                return this.isEnabled == watermarkingDataLoaded.isEnabled && Intrinsics.areEqual(this.disabledReason, watermarkingDataLoaded.disabledReason);
            }

            public int hashCode() {
                int iHashCode = Boolean.hashCode(this.isEnabled) * 31;
                WatermarkingDisabledReason watermarkingDisabledReason = this.disabledReason;
                return iHashCode + (watermarkingDisabledReason == null ? 0 : watermarkingDisabledReason.hashCode());
            }

            public String toString() {
                return "WatermarkingDataLoaded(isEnabled=" + this.isEnabled + ", disabledReason=" + this.disabledReason + ")";
            }

            public WatermarkingDataLoaded(boolean z, WatermarkingDisabledReason watermarkingDisabledReason) {
                super(null);
                this.isEnabled = z;
                this.disabledReason = watermarkingDisabledReason;
            }

            public final WatermarkingDisabledReason getDisabledReason() {
                return this.disabledReason;
            }

            public final boolean isEnabled() {
                return this.isEnabled;
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$WatermarkingDataLoadFailed;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;", "error", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "<init>", "(Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;)V", "getError", "()Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class WatermarkingDataLoadFailed extends Action {
            public static final int $stable = 0;
            private final WatermarkingError error;

            public static /* synthetic */ WatermarkingDataLoadFailed copy$default(WatermarkingDataLoadFailed watermarkingDataLoadFailed, WatermarkingError watermarkingError, int i, Object obj) {
                if ((i & 1) != 0) {
                    watermarkingError = watermarkingDataLoadFailed.error;
                }
                return watermarkingDataLoadFailed.copy(watermarkingError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final WatermarkingError getError() {
                return this.error;
            }

            public final WatermarkingDataLoadFailed copy(WatermarkingError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new WatermarkingDataLoadFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof WatermarkingDataLoadFailed) && Intrinsics.areEqual(this.error, ((WatermarkingDataLoadFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "WatermarkingDataLoadFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public WatermarkingDataLoadFailed(WatermarkingError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final WatermarkingError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$Save;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Save extends Action {
            public static final int $stable = 0;
            public static final Save INSTANCE = new Save();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Save)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1025829621;
            }

            public String toString() {
                return "Save";
            }

            private Save() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$SaveCompleted;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;", "refreshedWatermarkStatus", "", "disabledReason", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "<init>", "(ZLcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;)V", "getRefreshedWatermarkStatus", "()Z", "getDisabledReason", "()Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SaveCompleted extends Action {
            public static final int $stable = 0;
            private final WatermarkingDisabledReason disabledReason;
            private final boolean refreshedWatermarkStatus;

            public static /* synthetic */ SaveCompleted copy$default(SaveCompleted saveCompleted, boolean z, WatermarkingDisabledReason watermarkingDisabledReason, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = saveCompleted.refreshedWatermarkStatus;
                }
                if ((i & 2) != 0) {
                    watermarkingDisabledReason = saveCompleted.disabledReason;
                }
                return saveCompleted.copy(z, watermarkingDisabledReason);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getRefreshedWatermarkStatus() {
                return this.refreshedWatermarkStatus;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final WatermarkingDisabledReason getDisabledReason() {
                return this.disabledReason;
            }

            public final SaveCompleted copy(boolean refreshedWatermarkStatus, WatermarkingDisabledReason disabledReason) {
                return new SaveCompleted(refreshedWatermarkStatus, disabledReason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SaveCompleted)) {
                    return false;
                }
                SaveCompleted saveCompleted = (SaveCompleted) other;
                return this.refreshedWatermarkStatus == saveCompleted.refreshedWatermarkStatus && Intrinsics.areEqual(this.disabledReason, saveCompleted.disabledReason);
            }

            public int hashCode() {
                int iHashCode = Boolean.hashCode(this.refreshedWatermarkStatus) * 31;
                WatermarkingDisabledReason watermarkingDisabledReason = this.disabledReason;
                return iHashCode + (watermarkingDisabledReason == null ? 0 : watermarkingDisabledReason.hashCode());
            }

            public String toString() {
                return "SaveCompleted(refreshedWatermarkStatus=" + this.refreshedWatermarkStatus + ", disabledReason=" + this.disabledReason + ")";
            }

            public SaveCompleted(boolean z, WatermarkingDisabledReason watermarkingDisabledReason) {
                super(null);
                this.refreshedWatermarkStatus = z;
                this.disabledReason = watermarkingDisabledReason;
            }

            public final WatermarkingDisabledReason getDisabledReason() {
                return this.disabledReason;
            }

            public final boolean getRefreshedWatermarkStatus() {
                return this.refreshedWatermarkStatus;
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$SaveFailed;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;", "error", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "<init>", "(Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;)V", "getError", "()Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SaveFailed extends Action {
            public static final int $stable = 0;
            private final WatermarkingError error;

            public static /* synthetic */ SaveFailed copy$default(SaveFailed saveFailed, WatermarkingError watermarkingError, int i, Object obj) {
                if ((i & 1) != 0) {
                    watermarkingError = saveFailed.error;
                }
                return saveFailed.copy(watermarkingError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final WatermarkingError getError() {
                return this.error;
            }

            public final SaveFailed copy(WatermarkingError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new SaveFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SaveFailed) && Intrinsics.areEqual(this.error, ((SaveFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "SaveFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SaveFailed(WatermarkingError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final WatermarkingError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: WatermarkingReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action$Cancel;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Cancel extends Action {
            public static final int $stable = 0;
            public static final Cancel INSTANCE = new Cancel();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Cancel)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1561908872;
            }

            public String toString() {
                return "Cancel";
            }

            private Cancel() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(WatermarkingReducer watermarkingReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, Action.Initialize.INSTANCE)) {
            return new ReducerResult(new State.Loading(state.getTarget()), watermarkingReducer.loadWatermarkDataEffect(state));
        }
        if (action instanceof Action.ToggleWatermarking) {
            if (state instanceof State.Loaded) {
                if (state.isToggleEnabled()) {
                    return new ReducerResult(State.Loaded.copy$default((State.Loaded) state, null, ((Action.ToggleWatermarking) action).getEnabled(), false, null, false, false, 61, null), null, 2, null);
                }
                return new ReducerResult(state, null, 2, null);
            }
            if (!(state instanceof State.Loading) && !(state instanceof State.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.WatermarkingDataLoaded) {
            Action.WatermarkingDataLoaded watermarkingDataLoaded = (Action.WatermarkingDataLoaded) action;
            return new ReducerResult(new State.Loaded(state.getTarget(), watermarkingDataLoaded.isEnabled(), watermarkingDataLoaded.isEnabled(), watermarkingDataLoaded.getDisabledReason(), false, false, 48, null), null, 2, null);
        }
        if (action instanceof Action.WatermarkingDataLoadFailed) {
            return new ReducerResult(new State.Error(state.getTarget(), ((Action.WatermarkingDataLoadFailed) action).getError(), false, false, 12, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.Save.INSTANCE)) {
            if (state instanceof State.Loaded) {
                if (state.isSaveEnabled()) {
                    State.Loaded loaded = (State.Loaded) state;
                    return new ReducerResult(State.Loaded.copy$default(loaded, null, false, false, null, true, false, 47, null), watermarkingReducer.saveWatermarkEffect(loaded));
                }
                return new ReducerResult(state, null, 2, null);
            }
            if (!(state instanceof State.Loading) && !(state instanceof State.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.SaveCompleted) {
            if (state instanceof State.Loaded) {
                Action.SaveCompleted saveCompleted = (Action.SaveCompleted) action;
                return new ReducerResult(State.Loaded.copy$default((State.Loaded) state, null, saveCompleted.getRefreshedWatermarkStatus(), saveCompleted.getRefreshedWatermarkStatus(), saveCompleted.getDisabledReason(), false, true, 1, null), null, 2, null);
            }
            if (!(state instanceof State.Loading) && !(state instanceof State.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.SaveFailed) {
            if (state instanceof State.Loaded) {
                return new ReducerResult(new State.Error(((State.Loaded) state).getTarget(), ((Action.SaveFailed) action).getError(), false, false, 12, null), null, 2, null);
            }
            if (!(state instanceof State.Loading) && !(state instanceof State.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (!Intrinsics.areEqual(action, Action.Cancel.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        if (state instanceof State.Loaded) {
            return new ReducerResult(State.Loaded.copy$default((State.Loaded) state, null, false, false, null, false, true, 31, null), null, 2, null);
        }
        if (state instanceof State.Loading) {
            return new ReducerResult(new State.Error(((State.Loading) state).getTarget(), WatermarkingError.UnknownError.INSTANCE, false, false, 12, null), null, 2, null);
        }
        if (state instanceof State.Error) {
            return new ReducerResult(State.Error.copy$default((State.Error) state, null, null, false, true, 7, null), null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.watermarking.WatermarkingReducer$loadWatermarkDataEffect$1, reason: invalid class name */
    /* JADX INFO: compiled from: WatermarkingReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.watermarking.WatermarkingReducer$loadWatermarkDataEffect$1", f = "WatermarkingReducer.kt", i = {0, 0, 1, 1, 1}, l = {282, 283}, m = "invokeSuspend", n = {"$this$flow", "itemId", "$this$flow", "itemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ WatermarkingReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, WatermarkingReducer watermarkingReducer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = state;
            this.this$0 = watermarkingReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$state, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x007e, code lost:
        
            if (r0.emit(r8.this$0.mapResultToAction(r9), r8) == r1) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r8.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L2e
                if (r2 == r4) goto L26
                if (r2 != r3) goto L1e
                java.lang.Object r0 = r8.L$2
                com.box.android.domain.utils.result.Result r0 = (com.box.android.domain.utils.result.Result) r0
                java.lang.Object r8 = r8.L$1
                com.box.android.domain.models.ItemId r8 = (com.box.android.domain.models.ItemId) r8
                kotlin.ResultKt.throwOnFailure(r9)
                goto L81
            L1e:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L26:
                java.lang.Object r2 = r8.L$1
                com.box.android.domain.models.ItemId r2 = (com.box.android.domain.models.ItemId) r2
                kotlin.ResultKt.throwOnFailure(r9)
                goto L5b
            L2e:
                kotlin.ResultKt.throwOnFailure(r9)
                com.box.android.base.presentation.watermarking.WatermarkingReducer$State r9 = r8.$state
                com.box.android.base.presentation.watermarking.WatermarkingReducer$WatermarkingTarget r9 = r9.getTarget()
                com.box.android.domain.models.ItemId r2 = r9.getItemId()
                com.box.android.base.presentation.watermarking.WatermarkingReducer r9 = r8.this$0
                com.box.android.base.presentation.watermarking.WatermarkingEnvironment r9 = r9.getEnvironment()
                com.box.android.domain.services.IRemoteItemService r9 = r9.getRemoteItemService()
                com.box.android.domain.configuration.DataPolicy r5 = com.box.android.domain.configuration.DataPolicy.REMOTE
                r6 = r8
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r8.L$0 = r0
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                r8.L$1 = r7
                r8.label = r4
                java.lang.Object r9 = r9.itemWithWatermarkData(r2, r5, r6)
                if (r9 != r1) goto L5b
                goto L80
            L5b:
                com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
                com.box.android.base.presentation.watermarking.WatermarkingReducer r4 = r8.this$0
                com.box.android.base.presentation.watermarking.WatermarkingReducer$Action r4 = com.box.android.base.presentation.watermarking.WatermarkingReducer.access$mapResultToAction(r4, r9)
                r5 = r8
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r8.L$0 = r6
                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                r8.L$1 = r2
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                r8.L$2 = r9
                r8.label = r3
                java.lang.Object r8 = r0.emit(r4, r5)
                if (r8 != r1) goto L81
            L80:
                return r1
            L81:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.base.presentation.watermarking.WatermarkingReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Effect<Action> loadWatermarkDataEffect(State state) {
        return EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(state, this, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Action mapResultToAction(Result<? extends ItemModel, ? extends DomainError> result) {
        if (result instanceof Result.Success) {
            ItemModel itemModel = (ItemModel) ((Result.Success) result).getValue();
            WatermarkModel watermarkModelExtractWatermarkFromItem = WatermarkingReducerKt.extractWatermarkFromItem(itemModel);
            PermissionsModel permissionsModelExtractPermissionsFromItem = WatermarkingReducerKt.extractPermissionsFromItem(itemModel);
            if (permissionsModelExtractPermissionsFromItem == null) {
                return new Action.WatermarkingDataLoadFailed(WatermarkingError.PermissionDataMissing.INSTANCE);
            }
            return new Action.WatermarkingDataLoaded(watermarkModelExtractWatermarkFromItem != null ? watermarkModelExtractWatermarkFromItem.isWatermarked() : false, WatermarkingReducerKt.disabledReasonFrom(itemModel, watermarkModelExtractWatermarkFromItem, permissionsModelExtractPermissionsFromItem));
        }
        if (result instanceof Result.Error) {
            return new Action.WatermarkingDataLoadFailed(mapDomainErrorToWatermarkingError((DomainError) ((Result.Error) result).getValue()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final WatermarkingError mapDomainErrorToWatermarkingError(DomainError error) {
        if (error instanceof DomainError.NoResultFoundError) {
            return WatermarkingError.ItemNotFound.INSTANCE;
        }
        return error instanceof DomainError.NetworkError ? WatermarkingError.NetworkError.INSTANCE : WatermarkingError.UnknownError.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.watermarking.WatermarkingReducer$saveWatermarkEffect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WatermarkingReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.watermarking.WatermarkingReducer$saveWatermarkEffect$1", f = "WatermarkingReducer.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {312, 313, 313}, m = "invokeSuspend", n = {"$this$flow", "itemId", "$this$flow", "itemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flow", "itemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
    static final class C09371 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State.Loaded $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ WatermarkingReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09371(State.Loaded loaded, WatermarkingReducer watermarkingReducer, Continuation<? super C09371> continuation) {
            super(2, continuation);
            this.$state = loaded;
            this.this$0 = watermarkingReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09371 c09371 = new C09371(this.$state, this.this$0, continuation);
            c09371.L$0 = obj;
            return c09371;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C09371) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x00b7, code lost:
        
            if (r2.emit(r10, r9) == r1) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r9.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L43
                if (r2 == r5) goto L3a
                if (r2 == r4) goto L2a
                if (r2 != r3) goto L22
                java.lang.Object r0 = r9.L$2
                com.box.android.domain.utils.result.Result r0 = (com.box.android.domain.utils.result.Result) r0
                java.lang.Object r9 = r9.L$1
                com.box.android.domain.models.ItemId r9 = (com.box.android.domain.models.ItemId) r9
                kotlin.ResultKt.throwOnFailure(r10)
                goto Lba
            L22:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L2a:
                java.lang.Object r2 = r9.L$3
                kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                java.lang.Object r4 = r9.L$2
                com.box.android.domain.utils.result.Result r4 = (com.box.android.domain.utils.result.Result) r4
                java.lang.Object r5 = r9.L$1
                com.box.android.domain.models.ItemId r5 = (com.box.android.domain.models.ItemId) r5
                kotlin.ResultKt.throwOnFailure(r10)
                goto L99
            L3a:
                java.lang.Object r2 = r9.L$1
                com.box.android.domain.models.ItemId r2 = (com.box.android.domain.models.ItemId) r2
                kotlin.ResultKt.throwOnFailure(r10)
                r5 = r2
                goto L70
            L43:
                kotlin.ResultKt.throwOnFailure(r10)
                com.box.android.base.presentation.watermarking.WatermarkingReducer$State$Loaded r10 = r9.$state
                com.box.android.base.presentation.watermarking.WatermarkingReducer$WatermarkingTarget r10 = r10.getTarget()
                com.box.android.domain.models.ItemId r10 = r10.getItemId()
                com.box.android.base.presentation.watermarking.WatermarkingReducer r2 = r9.this$0
                com.box.android.base.presentation.watermarking.WatermarkingReducer$State$Loaded r6 = r9.$state
                com.box.android.base.presentation.watermarking.WatermarkingReducer$WatermarkingTarget r6 = r6.getTarget()
                com.box.android.base.presentation.watermarking.WatermarkingReducer$State$Loaded r7 = r9.$state
                boolean r7 = r7.isWatermarkingEnabled()
                r8 = r9
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r9.L$0 = r0
                r9.L$1 = r10
                r9.label = r5
                java.lang.Object r2 = com.box.android.base.presentation.watermarking.WatermarkingReducer.access$performWatermarkOperation(r2, r6, r7, r10, r8)
                if (r2 != r1) goto L6e
                goto Lb9
            L6e:
                r5 = r10
                r10 = r2
            L70:
                com.box.android.domain.utils.result.Result r10 = (com.box.android.domain.utils.result.Result) r10
                com.box.android.base.presentation.watermarking.WatermarkingReducer r2 = r9.this$0
                com.box.android.base.presentation.watermarking.WatermarkingReducer$State$Loaded r6 = r9.$state
                r7 = r9
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r9.L$0 = r8
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                r9.L$1 = r8
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
                r9.L$2 = r8
                r9.L$3 = r0
                r9.label = r4
                java.lang.Object r2 = com.box.android.base.presentation.watermarking.WatermarkingReducer.access$handleSaveResult(r2, r10, r5, r6, r7)
                if (r2 != r1) goto L96
                goto Lb9
            L96:
                r4 = r10
                r10 = r2
                r2 = r0
            L99:
                r6 = r9
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r9.L$0 = r0
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                r9.L$1 = r0
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                r9.L$2 = r0
                r0 = 0
                r9.L$3 = r0
                r9.label = r3
                java.lang.Object r9 = r2.emit(r10, r6)
                if (r9 != r1) goto Lba
            Lb9:
                return r1
            Lba:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.base.presentation.watermarking.WatermarkingReducer.C09371.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Effect<Action> saveWatermarkEffect(State.Loaded state) {
        return EffectKt.toEffect(FlowKt.flow(new C09371(state, this, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performWatermarkOperation(WatermarkingTarget watermarkingTarget, boolean z, ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        if (watermarkingTarget instanceof WatermarkingTarget.File) {
            if (z) {
                return this.environment.getWatermarkService().applyWatermarkToFile(itemId, continuation);
            }
            return this.environment.getWatermarkService().removeWatermarkFromFile(itemId, continuation);
        }
        if (!(watermarkingTarget instanceof WatermarkingTarget.Folder)) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return this.environment.getWatermarkService().applyWatermarkToFolder(itemId, continuation);
        }
        return this.environment.getWatermarkService().removeWatermarkFromFolder(itemId, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleSaveResult(Result<Unit, ? extends DomainError> result, ItemId itemId, State.Loaded loaded, Continuation<? super Action> continuation) {
        ItemId.Remote remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
        if (result instanceof Result.Success) {
            if (remote != null) {
                this.environment.getWatermarkingEventLogger().logSuccess(remote, loaded.isWatermarkingEnabled());
            }
            return refreshAndCreateSaveCompletedAction(itemId, loaded, continuation);
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (remote != null) {
            this.environment.getWatermarkingEventLogger().logFailure(remote, loaded.isWatermarkingEnabled(), toFailReasonString((DomainError) ((Result.Error) result).getValue()));
        }
        return new Action.SaveFailed(mapDomainErrorToSaveError((DomainError) ((Result.Error) result).getValue()));
    }

    private final String toFailReasonString(DomainError domainError) {
        if (domainError instanceof DomainError.NetworkError) {
            return "network_error";
        }
        return domainError instanceof DomainError.NoResultFoundError ? "item_not_found" : "unknown_error";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object refreshAndCreateSaveCompletedAction(ItemId itemId, State.Loaded loaded, Continuation<? super Action> continuation) {
        C09361 c09361;
        if (continuation instanceof C09361) {
            c09361 = (C09361) continuation;
            if ((c09361.label & Integer.MIN_VALUE) != 0) {
                c09361.label -= Integer.MIN_VALUE;
            } else {
                c09361 = new C09361(continuation);
            }
        } else {
            c09361 = new C09361(continuation);
        }
        Object objItemWithWatermarkData = c09361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09361.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItemWithWatermarkData);
            IRemoteItemService remoteItemService = this.environment.getRemoteItemService();
            DataPolicy dataPolicy = DataPolicy.REMOTE;
            c09361.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            c09361.L$1 = loaded;
            c09361.label = 1;
            objItemWithWatermarkData = remoteItemService.itemWithWatermarkData(itemId, dataPolicy, c09361);
            if (objItemWithWatermarkData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            loaded = (State.Loaded) c09361.L$1;
            ResultKt.throwOnFailure(objItemWithWatermarkData);
        }
        Result result = (Result) objItemWithWatermarkData;
        if (result instanceof Result.Success) {
            ItemModel itemModel = (ItemModel) ((Result.Success) result).getValue();
            WatermarkModel watermarkModelExtractWatermarkFromItem = WatermarkingReducerKt.extractWatermarkFromItem(itemModel);
            PermissionsModel permissionsModelExtractPermissionsFromItem = WatermarkingReducerKt.extractPermissionsFromItem(itemModel);
            if (permissionsModelExtractPermissionsFromItem == null) {
                return new Action.SaveCompleted(loaded.isWatermarkingEnabled(), loaded.getDisabledReason());
            }
            return new Action.SaveCompleted(watermarkModelExtractWatermarkFromItem != null ? watermarkModelExtractWatermarkFromItem.isWatermarked() : false, WatermarkingReducerKt.disabledReasonFrom(itemModel, watermarkModelExtractWatermarkFromItem, permissionsModelExtractPermissionsFromItem));
        }
        if (result instanceof Result.Error) {
            return new Action.SaveCompleted(loaded.isWatermarkingEnabled(), loaded.getDisabledReason());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final WatermarkingError mapDomainErrorToSaveError(DomainError error) {
        if (error instanceof DomainError.NetworkError) {
            return WatermarkingError.NetworkError.INSTANCE;
        }
        return error instanceof DomainError.NoResultFoundError ? WatermarkingError.ItemNotFound.INSTANCE : WatermarkingError.SaveError.INSTANCE;
    }
}
