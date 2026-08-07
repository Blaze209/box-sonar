package com.box.android.preview.fileactions;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.base.cpl.DeleteReducerKt;
import com.box.android.base.cpl.EndCollaborationReducerKt;
import com.box.android.base.cpl.ItemActionConfirmationReducer;
import com.box.android.base.presentation.components.fileactions.DownloadFilesReducer;
import com.box.android.base.presentation.components.fileactions.OfflineFilesReducer;
import com.box.android.boxai.BoxAiCenterReducer;
import com.box.android.boxai.BoxAiReducer;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.Combine;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileModelKt;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.fileactions.copylink.CopyLinkReducer;
import com.box.android.preview.fileactions.openin.OpenInReducer;
import com.box.android.preview.item.ItemState;
import com.box.android.preview.routing.PreviewRoute;
import com.facebook.react.modules.dialog.AlertFragment;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: FileActionsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u000234B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J$\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0017H\u0002J$\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u001aH\u0002J$\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u001cH\u0002J$\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u001eH\u0002J$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020 H\u0002J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\"2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0082@¢\u0006\u0002\u0010%J$\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120+H\u0082@¢\u0006\u0002\u0010,J&\u0010-\u001a\u00020'2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120+2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u00065"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/fileactions/FileActionsReducer$State;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "environment", "Lcom/box/android/preview/fileactions/FileActionsEnvironment;", "<init>", "(Lcom/box/android/preview/fileactions/FileActionsEnvironment;)V", "build", "Lcom/box/android/cpl/reducers/Combine;", "getBuild", "()Lcom/box/android/cpl/reducers/Combine;", "reducePreviewItemActions", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "performItemAction", "fileAction", "Lcom/box/android/preview/fileactions/FileAction;", "reduceRename", "renameAction", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "reduceDelete", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;", "reduceEndCollaboration", "reduceCopySharedLink", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;", "reduceOpenIn", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;", "reduceDownload", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;", "reduceOffline", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", "evaluateAvailableActions", "", "itemPreviewItemState", "Lcom/box/android/preview/item/ItemState;", "(Lcom/box/android/preview/fileactions/FileActionsReducer$State;Lcom/box/android/preview/item/ItemState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveOfflineAction", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", AlertFragment.ARG_ITEMS, "", "(Lcom/box/android/domain/models/item/FileModel;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOfflineActionsInSet", "canBeOfflined", "", "isOfflined", "isAnnotationAvailableForPreview", "itemPreviewState", "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActionsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Combine<State, Action> build;
    private final FileActionsEnvironment environment;

    /* JADX INFO: compiled from: FileActionsReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileAction.values().length];
            try {
                iArr[FileAction.Share.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileAction.AddComment.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileAction.Collections.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileAction.MoveOrCopy.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileAction.FileInformation.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FileAction.ViewContainingFolder.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FileAction.ViewSettings.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FileAction.ThumbnailsView.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FileAction.OutlineView.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FileAction.PageView.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[FileAction.Search.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[FileAction.Print.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[FileAction.AddAnnotations.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[FileAction.Gallery.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[FileAction.Playlist.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[FileAction.OpenIn.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[FileAction.CopySharedLink.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[FileAction.Rename.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[FileAction.MakeAvailableOffline.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[FileAction.RemoveFromOffline.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[FileAction.Download.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[FileAction.Delete.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[FileAction.EndCollaboration.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[FileAction.BoxAi.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[FileAction.Watermarking.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[FileAction.AddTask.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsReducer$evaluateAvailableActions$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileActionsReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsReducer", f = "FileActionsReducer.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8}, l = {533, 538, 566, 573, 577, 580, 586, 589, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR}, m = "evaluateAvailableActions", n = {"state", "itemPreviewItemState", AlertFragment.ARG_ITEMS, "fileModel", "state", "itemPreviewItemState", AlertFragment.ARG_ITEMS, "fileModel", "state", "itemPreviewItemState", AlertFragment.ARG_ITEMS, "fileModel", "state", "itemPreviewItemState", AlertFragment.ARG_ITEMS, "fileModel", "state", "itemPreviewItemState", AlertFragment.ARG_ITEMS, "fileModel", "state", "itemPreviewItemState", AlertFragment.ARG_ITEMS, "fileModel", "state", "itemPreviewItemState", AlertFragment.ARG_ITEMS, "fileModel", "state", "itemPreviewItemState", AlertFragment.ARG_ITEMS, "fileModel", "state", "itemPreviewItemState", AlertFragment.ARG_ITEMS, "fileModel"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsReducer.this.evaluateAvailableActions(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsReducer$resolveOfflineAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsReducer", f = "FileActionsReducer.kt", i = {0, 0, 1, 1}, l = {619, 624}, m = "resolveOfflineAction", n = {"fileModel", AlertFragment.ARG_ITEMS, "fileModel", AlertFragment.ARG_ITEMS}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C16741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C16741(Continuation<? super C16741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsReducer.this.resolveOfflineAction(null, null, this);
        }
    }

    /* JADX INFO: compiled from: FileActionsReducer.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010A\u001a\u00020\u0019HÆ\u0003J\t\u0010B\u001a\u00020\u001bHÆ\u0003J\u009f\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bHÆ\u0001J\u0013\u0010D\u001a\u00020\n2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020GHÖ\u0001J\t\u0010H\u001a\u00020IHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006J"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$State;", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "availableActions", "", "Lcom/box/android/preview/fileactions/FileAction;", "isPermanentRenameMode", "", "copyLinkState", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$State;", "renameItemState", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$State;", "deleteItemState", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer$State;", "endCollaborationState", "openInState", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$State;", "downloadState", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$State;", "offlineState", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$State;", "boxAiState", "Lcom/box/android/boxai/BoxAiReducer$State;", "boxAiCenterState", "Lcom/box/android/boxai/BoxAiCenterReducer$State;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/preview/PreviewSource;Ljava/util/Set;ZLcom/box/android/preview/fileactions/copylink/CopyLinkReducer$State;Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$State;Lcom/box/android/base/cpl/ItemActionConfirmationReducer$State;Lcom/box/android/base/cpl/ItemActionConfirmationReducer$State;Lcom/box/android/preview/fileactions/openin/OpenInReducer$State;Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$State;Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$State;Lcom/box/android/boxai/BoxAiReducer$State;Lcom/box/android/boxai/BoxAiCenterReducer$State;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getPreviewSource", "()Lcom/box/android/domain/models/preview/PreviewSource;", "getAvailableActions", "()Ljava/util/Set;", "()Z", "getCopyLinkState", "()Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$State;", "getRenameItemState", "()Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$State;", "getDeleteItemState", "()Lcom/box/android/base/cpl/ItemActionConfirmationReducer$State;", "getEndCollaborationState", "getOpenInState", "()Lcom/box/android/preview/fileactions/openin/OpenInReducer$State;", "getDownloadState", "()Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$State;", "getOfflineState", "()Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$State;", "getBoxAiState", "()Lcom/box/android/boxai/BoxAiReducer$State;", "getBoxAiCenterState", "()Lcom/box/android/boxai/BoxAiCenterReducer$State;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final Set<FileAction> availableActions;
        private final BoxAiCenterReducer.State boxAiCenterState;
        private final BoxAiReducer.State boxAiState;
        private final CopyLinkReducer.State copyLinkState;
        private final ItemActionConfirmationReducer.State deleteItemState;
        private final DownloadFilesReducer.State downloadState;
        private final ItemActionConfirmationReducer.State endCollaborationState;
        private final FileModel fileModel;
        private final boolean isPermanentRenameMode;
        private final OfflineFilesReducer.State offlineState;
        private final OpenInReducer.State openInState;
        private final PreviewSource previewSource;
        private final UpdateItemInfoReducer.State renameItemState;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, FileModel fileModel, PreviewSource previewSource, Set set, boolean z, CopyLinkReducer.State state2, UpdateItemInfoReducer.State state3, ItemActionConfirmationReducer.State state4, ItemActionConfirmationReducer.State state5, OpenInReducer.State state6, DownloadFilesReducer.State state7, OfflineFilesReducer.State state8, BoxAiReducer.State state9, BoxAiCenterReducer.State state10, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = state.fileModel;
            }
            return state.copy(fileModel, (i & 2) != 0 ? state.previewSource : previewSource, (i & 4) != 0 ? state.availableActions : set, (i & 8) != 0 ? state.isPermanentRenameMode : z, (i & 16) != 0 ? state.copyLinkState : state2, (i & 32) != 0 ? state.renameItemState : state3, (i & 64) != 0 ? state.deleteItemState : state4, (i & 128) != 0 ? state.endCollaborationState : state5, (i & 256) != 0 ? state.openInState : state6, (i & 512) != 0 ? state.downloadState : state7, (i & 1024) != 0 ? state.offlineState : state8, (i & 2048) != 0 ? state.boxAiState : state9, (i & 4096) != 0 ? state.boxAiCenterState : state10);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final DownloadFilesReducer.State getDownloadState() {
            return this.downloadState;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final OfflineFilesReducer.State getOfflineState() {
            return this.offlineState;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final BoxAiReducer.State getBoxAiState() {
            return this.boxAiState;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final BoxAiCenterReducer.State getBoxAiCenterState() {
            return this.boxAiCenterState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PreviewSource getPreviewSource() {
            return this.previewSource;
        }

        public final Set<FileAction> component3() {
            return this.availableActions;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsPermanentRenameMode() {
            return this.isPermanentRenameMode;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final CopyLinkReducer.State getCopyLinkState() {
            return this.copyLinkState;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final UpdateItemInfoReducer.State getRenameItemState() {
            return this.renameItemState;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final ItemActionConfirmationReducer.State getDeleteItemState() {
            return this.deleteItemState;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final ItemActionConfirmationReducer.State getEndCollaborationState() {
            return this.endCollaborationState;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final OpenInReducer.State getOpenInState() {
            return this.openInState;
        }

        public final State copy(FileModel fileModel, PreviewSource previewSource, Set<? extends FileAction> availableActions, boolean isPermanentRenameMode, CopyLinkReducer.State copyLinkState, UpdateItemInfoReducer.State renameItemState, ItemActionConfirmationReducer.State deleteItemState, ItemActionConfirmationReducer.State endCollaborationState, OpenInReducer.State openInState, DownloadFilesReducer.State downloadState, OfflineFilesReducer.State offlineState, BoxAiReducer.State boxAiState, BoxAiCenterReducer.State boxAiCenterState) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            Intrinsics.checkNotNullParameter(availableActions, "availableActions");
            Intrinsics.checkNotNullParameter(boxAiState, "boxAiState");
            Intrinsics.checkNotNullParameter(boxAiCenterState, "boxAiCenterState");
            return new State(fileModel, previewSource, availableActions, isPermanentRenameMode, copyLinkState, renameItemState, deleteItemState, endCollaborationState, openInState, downloadState, offlineState, boxAiState, boxAiCenterState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.fileModel, state.fileModel) && Intrinsics.areEqual(this.previewSource, state.previewSource) && Intrinsics.areEqual(this.availableActions, state.availableActions) && this.isPermanentRenameMode == state.isPermanentRenameMode && Intrinsics.areEqual(this.copyLinkState, state.copyLinkState) && Intrinsics.areEqual(this.renameItemState, state.renameItemState) && Intrinsics.areEqual(this.deleteItemState, state.deleteItemState) && Intrinsics.areEqual(this.endCollaborationState, state.endCollaborationState) && Intrinsics.areEqual(this.openInState, state.openInState) && Intrinsics.areEqual(this.downloadState, state.downloadState) && Intrinsics.areEqual(this.offlineState, state.offlineState) && Intrinsics.areEqual(this.boxAiState, state.boxAiState) && Intrinsics.areEqual(this.boxAiCenterState, state.boxAiCenterState);
        }

        public int hashCode() {
            int iHashCode = ((((((this.fileModel.hashCode() * 31) + this.previewSource.hashCode()) * 31) + this.availableActions.hashCode()) * 31) + Boolean.hashCode(this.isPermanentRenameMode)) * 31;
            CopyLinkReducer.State state = this.copyLinkState;
            int iHashCode2 = (iHashCode + (state == null ? 0 : state.hashCode())) * 31;
            UpdateItemInfoReducer.State state2 = this.renameItemState;
            int iHashCode3 = (iHashCode2 + (state2 == null ? 0 : state2.hashCode())) * 31;
            ItemActionConfirmationReducer.State state3 = this.deleteItemState;
            int iHashCode4 = (iHashCode3 + (state3 == null ? 0 : state3.hashCode())) * 31;
            ItemActionConfirmationReducer.State state4 = this.endCollaborationState;
            int iHashCode5 = (iHashCode4 + (state4 == null ? 0 : state4.hashCode())) * 31;
            OpenInReducer.State state5 = this.openInState;
            int iHashCode6 = (iHashCode5 + (state5 == null ? 0 : state5.hashCode())) * 31;
            DownloadFilesReducer.State state6 = this.downloadState;
            int iHashCode7 = (iHashCode6 + (state6 == null ? 0 : state6.hashCode())) * 31;
            OfflineFilesReducer.State state7 = this.offlineState;
            return ((((iHashCode7 + (state7 != null ? state7.hashCode() : 0)) * 31) + this.boxAiState.hashCode()) * 31) + this.boxAiCenterState.hashCode();
        }

        public String toString() {
            return "State(fileModel=" + this.fileModel + ", previewSource=" + this.previewSource + ", availableActions=" + this.availableActions + ", isPermanentRenameMode=" + this.isPermanentRenameMode + ", copyLinkState=" + this.copyLinkState + ", renameItemState=" + this.renameItemState + ", deleteItemState=" + this.deleteItemState + ", endCollaborationState=" + this.endCollaborationState + ", openInState=" + this.openInState + ", downloadState=" + this.downloadState + ", offlineState=" + this.offlineState + ", boxAiState=" + this.boxAiState + ", boxAiCenterState=" + this.boxAiCenterState + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(FileModel fileModel, PreviewSource previewSource, Set<? extends FileAction> availableActions, boolean z, CopyLinkReducer.State state, UpdateItemInfoReducer.State state2, ItemActionConfirmationReducer.State state3, ItemActionConfirmationReducer.State state4, OpenInReducer.State state5, DownloadFilesReducer.State state6, OfflineFilesReducer.State state7, BoxAiReducer.State boxAiState, BoxAiCenterReducer.State boxAiCenterState) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            Intrinsics.checkNotNullParameter(availableActions, "availableActions");
            Intrinsics.checkNotNullParameter(boxAiState, "boxAiState");
            Intrinsics.checkNotNullParameter(boxAiCenterState, "boxAiCenterState");
            this.fileModel = fileModel;
            this.previewSource = previewSource;
            this.availableActions = availableActions;
            this.isPermanentRenameMode = z;
            this.copyLinkState = state;
            this.renameItemState = state2;
            this.deleteItemState = state3;
            this.endCollaborationState = state4;
            this.openInState = state5;
            this.downloadState = state6;
            this.offlineState = state7;
            this.boxAiState = boxAiState;
            this.boxAiCenterState = boxAiCenterState;
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public /* synthetic */ State(FileModel fileModel, PreviewSource previewSource, Set set, boolean z, CopyLinkReducer.State state, UpdateItemInfoReducer.State state2, ItemActionConfirmationReducer.State state3, ItemActionConfirmationReducer.State state4, OpenInReducer.State state5, DownloadFilesReducer.State state6, OfflineFilesReducer.State state7, BoxAiReducer.State state8, BoxAiCenterReducer.State state9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileModel, (i & 2) != 0 ? PreviewSource.Unknown.INSTANCE : previewSource, (i & 4) != 0 ? SetsKt.emptySet() : set, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : state, (i & 32) != 0 ? null : state2, (i & 64) != 0 ? null : state3, (i & 128) != 0 ? null : state4, (i & 256) != 0 ? null : state5, (i & 512) != 0 ? null : state6, (i & 1024) == 0 ? state7 : null, (i & 2048) != 0 ? new BoxAiReducer.State(CollectionsKt.listOf(fileModel), null, false, null, false, false, false, null, 254, null) : state8, (i & 4096) != 0 ? new BoxAiCenterReducer.State(null, false, false, null, 15, null) : state9);
        }

        public final PreviewSource getPreviewSource() {
            return this.previewSource;
        }

        public final Set<FileAction> getAvailableActions() {
            return this.availableActions;
        }

        public final boolean isPermanentRenameMode() {
            return this.isPermanentRenameMode;
        }

        public final CopyLinkReducer.State getCopyLinkState() {
            return this.copyLinkState;
        }

        public final UpdateItemInfoReducer.State getRenameItemState() {
            return this.renameItemState;
        }

        public final ItemActionConfirmationReducer.State getDeleteItemState() {
            return this.deleteItemState;
        }

        public final ItemActionConfirmationReducer.State getEndCollaborationState() {
            return this.endCollaborationState;
        }

        public final OpenInReducer.State getOpenInState() {
            return this.openInState;
        }

        public final DownloadFilesReducer.State getDownloadState() {
            return this.downloadState;
        }

        public final OfflineFilesReducer.State getOfflineState() {
            return this.offlineState;
        }

        public final BoxAiReducer.State getBoxAiState() {
            return this.boxAiState;
        }

        public final BoxAiCenterReducer.State getBoxAiCenterState() {
            return this.boxAiCenterState;
        }
    }

    public FileActionsReducer(FileActionsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new FileActionsReducer$build$1(this));
        final FileActionsReducer$build$2 fileActionsReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FileActionsReducer.State) obj).getCopyLinkState();
            }
        };
        final FileActionsReducer$build$3 fileActionsReducer$build$3 = FileActionsReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new CopyLinkReducer(environment.getCopyLinkEnvironment()), new Function1<State, CopyLinkReducer.State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.fileactions.copylink.CopyLinkReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CopyLinkReducer.State invoke(FileActionsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return fileActionsReducer$build$2.invoke(it);
            }
        }, new Function1<Action, CopyLinkReducer.Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final CopyLinkReducer.Action invoke(FileActionsReducer.Action action) {
                if (!(action instanceof FileActionsReducer.Action.CopyLink)) {
                    action = null;
                }
                FileActionsReducer.Action.CopyLink copyLink = (FileActionsReducer.Action.CopyLink) action;
                if (copyLink != null) {
                    return copyLink.getAction();
                }
                return null;
            }
        }, new Function2<State, CopyLinkReducer.State, State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FileActionsReducer.State invoke(FileActionsReducer.State parentState, CopyLinkReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = fileActionsReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FileActionsReducer.State.class)).iterator();
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
                            return (FileActionsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CopyLinkReducer.Action, Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FileActionsReducer.Action invoke(CopyLinkReducer.Action action) {
                Object objInvoke = fileActionsReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (FileActionsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.Action");
            }
        });
        final FileActionsReducer$build$5 fileActionsReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FileActionsReducer.State) obj).getRenameItemState();
            }
        };
        final FileActionsReducer$build$6 fileActionsReducer$build$6 = FileActionsReducer$build$6.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new UpdateItemInfoReducer(environment.getUpdateItemInfoEnvironment()), new Function1<State, UpdateItemInfoReducer.State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.fileactions.UpdateItemInfoReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final UpdateItemInfoReducer.State invoke(FileActionsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return fileActionsReducer$build$5.invoke(it);
            }
        }, new Function1<Action, UpdateItemInfoReducer.Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final UpdateItemInfoReducer.Action invoke(FileActionsReducer.Action action) {
                if (!(action instanceof FileActionsReducer.Action.Rename)) {
                    action = null;
                }
                FileActionsReducer.Action.Rename rename = (FileActionsReducer.Action.Rename) action;
                if (rename != null) {
                    return rename.getAction();
                }
                return null;
            }
        }, new Function2<State, UpdateItemInfoReducer.State, State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FileActionsReducer.State invoke(FileActionsReducer.State parentState, UpdateItemInfoReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = fileActionsReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FileActionsReducer.State.class)).iterator();
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
                            return (FileActionsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<UpdateItemInfoReducer.Action, Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FileActionsReducer.Action invoke(UpdateItemInfoReducer.Action action) {
                Object objInvoke = fileActionsReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (FileActionsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.Action");
            }
        });
        final FileActionsReducer$build$8 fileActionsReducer$build$8 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsReducer$build$8
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FileActionsReducer.State) obj).getDeleteItemState();
            }
        };
        final FileActionsReducer$build$9 fileActionsReducer$build$9 = FileActionsReducer$build$9.INSTANCE;
        IfLetReducer ifLetReducer3 = new IfLetReducer(ifLetReducer2, DeleteReducerKt.createDeleteReducer(environment.getDeleteEnvironment()), new Function1<State, ItemActionConfirmationReducer.State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$9
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.cpl.ItemActionConfirmationReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ItemActionConfirmationReducer.State invoke(FileActionsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return fileActionsReducer$build$8.invoke(it);
            }
        }, new Function1<Action, ItemActionConfirmationReducer.Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$10
            @Override // kotlin.jvm.functions.Function1
            public final ItemActionConfirmationReducer.Action invoke(FileActionsReducer.Action action) {
                if (!(action instanceof FileActionsReducer.Action.Delete)) {
                    action = null;
                }
                FileActionsReducer.Action.Delete delete = (FileActionsReducer.Action.Delete) action;
                if (delete != null) {
                    return delete.getAction();
                }
                return null;
            }
        }, new Function2<State, ItemActionConfirmationReducer.State, State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$11
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FileActionsReducer.State invoke(FileActionsReducer.State parentState, ItemActionConfirmationReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = fileActionsReducer$build$8;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FileActionsReducer.State.class)).iterator();
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
                            return (FileActionsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ItemActionConfirmationReducer.Action, Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FileActionsReducer.Action invoke(ItemActionConfirmationReducer.Action action) {
                Object objInvoke = fileActionsReducer$build$9.invoke(action);
                if (objInvoke != null) {
                    return (FileActionsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.Action");
            }
        });
        final FileActionsReducer$build$11 fileActionsReducer$build$11 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsReducer$build$11
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FileActionsReducer.State) obj).getEndCollaborationState();
            }
        };
        final FileActionsReducer$build$12 fileActionsReducer$build$12 = FileActionsReducer$build$12.INSTANCE;
        IfLetReducer ifLetReducer4 = new IfLetReducer(ifLetReducer3, EndCollaborationReducerKt.createEndCollaborationReducer(environment.getEndCollaborationEnvironment()), new Function1<State, ItemActionConfirmationReducer.State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$13
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.cpl.ItemActionConfirmationReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ItemActionConfirmationReducer.State invoke(FileActionsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return fileActionsReducer$build$11.invoke(it);
            }
        }, new Function1<Action, ItemActionConfirmationReducer.Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$14
            @Override // kotlin.jvm.functions.Function1
            public final ItemActionConfirmationReducer.Action invoke(FileActionsReducer.Action action) {
                if (!(action instanceof FileActionsReducer.Action.EndCollaboration)) {
                    action = null;
                }
                FileActionsReducer.Action.EndCollaboration endCollaboration = (FileActionsReducer.Action.EndCollaboration) action;
                if (endCollaboration != null) {
                    return endCollaboration.getAction();
                }
                return null;
            }
        }, new Function2<State, ItemActionConfirmationReducer.State, State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$15
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FileActionsReducer.State invoke(FileActionsReducer.State parentState, ItemActionConfirmationReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = fileActionsReducer$build$11;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FileActionsReducer.State.class)).iterator();
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
                            return (FileActionsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ItemActionConfirmationReducer.Action, Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$16
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FileActionsReducer.Action invoke(ItemActionConfirmationReducer.Action action) {
                Object objInvoke = fileActionsReducer$build$12.invoke(action);
                if (objInvoke != null) {
                    return (FileActionsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.Action");
            }
        });
        final FileActionsReducer$build$14 fileActionsReducer$build$14 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsReducer$build$14
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FileActionsReducer.State) obj).getOpenInState();
            }
        };
        final FileActionsReducer$build$15 fileActionsReducer$build$15 = FileActionsReducer$build$15.INSTANCE;
        IfLetReducer ifLetReducer5 = new IfLetReducer(ifLetReducer4, new OpenInReducer(environment.getOpenInEnvironment()), new Function1<State, OpenInReducer.State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$17
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.fileactions.openin.OpenInReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final OpenInReducer.State invoke(FileActionsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return fileActionsReducer$build$14.invoke(it);
            }
        }, new Function1<Action, OpenInReducer.Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$18
            @Override // kotlin.jvm.functions.Function1
            public final OpenInReducer.Action invoke(FileActionsReducer.Action action) {
                if (!(action instanceof FileActionsReducer.Action.OpenIn)) {
                    action = null;
                }
                FileActionsReducer.Action.OpenIn openIn = (FileActionsReducer.Action.OpenIn) action;
                if (openIn != null) {
                    return openIn.getAction();
                }
                return null;
            }
        }, new Function2<State, OpenInReducer.State, State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$19
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FileActionsReducer.State invoke(FileActionsReducer.State parentState, OpenInReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = fileActionsReducer$build$14;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FileActionsReducer.State.class)).iterator();
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
                            return (FileActionsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<OpenInReducer.Action, Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$20
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FileActionsReducer.Action invoke(OpenInReducer.Action action) {
                Object objInvoke = fileActionsReducer$build$15.invoke(action);
                if (objInvoke != null) {
                    return (FileActionsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.Action");
            }
        });
        final FileActionsReducer$build$17 fileActionsReducer$build$17 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsReducer$build$17
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FileActionsReducer.State) obj).getDownloadState();
            }
        };
        final FileActionsReducer$build$18 fileActionsReducer$build$18 = FileActionsReducer$build$18.INSTANCE;
        IfLetReducer ifLetReducer6 = new IfLetReducer(ifLetReducer5, new DownloadFilesReducer(environment.getDownloadEnvironment()), new Function1<State, DownloadFilesReducer.State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$21
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.fileactions.DownloadFilesReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final DownloadFilesReducer.State invoke(FileActionsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return fileActionsReducer$build$17.invoke(it);
            }
        }, new Function1<Action, DownloadFilesReducer.Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$22
            @Override // kotlin.jvm.functions.Function1
            public final DownloadFilesReducer.Action invoke(FileActionsReducer.Action action) {
                if (!(action instanceof FileActionsReducer.Action.Download)) {
                    action = null;
                }
                FileActionsReducer.Action.Download download = (FileActionsReducer.Action.Download) action;
                if (download != null) {
                    return download.getAction();
                }
                return null;
            }
        }, new Function2<State, DownloadFilesReducer.State, State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$23
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FileActionsReducer.State invoke(FileActionsReducer.State parentState, DownloadFilesReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = fileActionsReducer$build$17;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FileActionsReducer.State.class)).iterator();
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
                            return (FileActionsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<DownloadFilesReducer.Action, Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$24
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FileActionsReducer.Action invoke(DownloadFilesReducer.Action action) {
                Object objInvoke = fileActionsReducer$build$18.invoke(action);
                if (objInvoke != null) {
                    return (FileActionsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.Action");
            }
        });
        final FileActionsReducer$build$20 fileActionsReducer$build$20 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsReducer$build$20
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FileActionsReducer.State) obj).getOfflineState();
            }
        };
        final FileActionsReducer$build$21 fileActionsReducer$build$21 = FileActionsReducer$build$21.INSTANCE;
        IfLetReducer ifLetReducer7 = new IfLetReducer(ifLetReducer6, new OfflineFilesReducer(environment.getOfflineFilesEnvironment()), new Function1<State, OfflineFilesReducer.State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$25
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.fileactions.OfflineFilesReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final OfflineFilesReducer.State invoke(FileActionsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return fileActionsReducer$build$20.invoke(it);
            }
        }, new Function1<Action, OfflineFilesReducer.Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$26
            @Override // kotlin.jvm.functions.Function1
            public final OfflineFilesReducer.Action invoke(FileActionsReducer.Action action) {
                if (!(action instanceof FileActionsReducer.Action.Offline)) {
                    action = null;
                }
                FileActionsReducer.Action.Offline offline = (FileActionsReducer.Action.Offline) action;
                if (offline != null) {
                    return offline.getAction();
                }
                return null;
            }
        }, new Function2<State, OfflineFilesReducer.State, State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$27
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FileActionsReducer.State invoke(FileActionsReducer.State parentState, OfflineFilesReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = fileActionsReducer$build$20;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FileActionsReducer.State.class)).iterator();
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
                            return (FileActionsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<OfflineFilesReducer.Action, Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$28
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FileActionsReducer.Action invoke(OfflineFilesReducer.Action action) {
                Object objInvoke = fileActionsReducer$build$21.invoke(action);
                if (objInvoke != null) {
                    return (FileActionsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.Action");
            }
        });
        final FileActionsReducer$build$23 fileActionsReducer$build$23 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsReducer$build$23
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FileActionsReducer.State) obj).getBoxAiState();
            }
        };
        final FileActionsReducer$build$24 fileActionsReducer$build$24 = FileActionsReducer$build$24.INSTANCE;
        IfLetReducer ifLetReducer8 = new IfLetReducer(ifLetReducer7, new BoxAiReducer(environment.getBoxAiEnvironment()), new Function1<State, BoxAiReducer.State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$29
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.boxai.BoxAiReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiReducer.State invoke(FileActionsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return fileActionsReducer$build$23.invoke(it);
            }
        }, new Function1<Action, BoxAiReducer.Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$30
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiReducer.Action invoke(FileActionsReducer.Action action) {
                if (!(action instanceof FileActionsReducer.Action.BoxAi)) {
                    action = null;
                }
                FileActionsReducer.Action.BoxAi boxAi = (FileActionsReducer.Action.BoxAi) action;
                if (boxAi != null) {
                    return boxAi.getAction();
                }
                return null;
            }
        }, new Function2<State, BoxAiReducer.State, State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$31
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FileActionsReducer.State invoke(FileActionsReducer.State parentState, BoxAiReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = fileActionsReducer$build$23;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FileActionsReducer.State.class)).iterator();
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
                            return (FileActionsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BoxAiReducer.Action, Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$32
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FileActionsReducer.Action invoke(BoxAiReducer.Action action) {
                Object objInvoke = fileActionsReducer$build$24.invoke(action);
                if (objInvoke != null) {
                    return (FileActionsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.Action");
            }
        });
        final FileActionsReducer$build$26 fileActionsReducer$build$26 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsReducer$build$26
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FileActionsReducer.State) obj).getBoxAiCenterState();
            }
        };
        final FileActionsReducer$build$27 fileActionsReducer$build$27 = FileActionsReducer$build$27.INSTANCE;
        this.build = new Combine<>(new IfLetReducer(ifLetReducer8, new BoxAiCenterReducer(), new Function1<State, BoxAiCenterReducer.State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$33
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.boxai.BoxAiCenterReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiCenterReducer.State invoke(FileActionsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return fileActionsReducer$build$26.invoke(it);
            }
        }, new Function1<Action, BoxAiCenterReducer.Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$34
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiCenterReducer.Action invoke(FileActionsReducer.Action action) {
                if (!(action instanceof FileActionsReducer.Action.BoxAiCenter)) {
                    action = null;
                }
                FileActionsReducer.Action.BoxAiCenter boxAiCenter = (FileActionsReducer.Action.BoxAiCenter) action;
                if (boxAiCenter != null) {
                    return boxAiCenter.getAction();
                }
                return null;
            }
        }, new Function2<State, BoxAiCenterReducer.State, State>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$35
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FileActionsReducer.State invoke(FileActionsReducer.State parentState, BoxAiCenterReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = fileActionsReducer$build$26;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FileActionsReducer.State.class)).iterator();
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
                            return (FileActionsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BoxAiCenterReducer.Action, Action>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$special$$inlined$scope$36
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FileActionsReducer.Action invoke(BoxAiCenterReducer.Action action) {
                Object objInvoke = fileActionsReducer$build$27.invoke(action);
                if (objInvoke != null) {
                    return (FileActionsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.FileActionsReducer.Action");
            }
        }), new FileActionsAnalyticsReducer(environment.getAnalytics()));
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: FileActionsReducer.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0014\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0014\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+¨\u0006,"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "", "<init>", "()V", "PerformAction", "EvaluateActions", "UpdateActions", "Navigate", "DocumentPreviewAction", "ItemPreviewAction", "ClosePreview", "CopyLink", "Rename", "Delete", "EndCollaboration", "OpenIn", "Download", "Offline", "BoxAi", "BoxAiCenter", "ObserveOfflineJob", "ObserveOfflineState", "GetOfflineState", "UpdateOfflineAction", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$BoxAi;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$BoxAiCenter;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$ClosePreview;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$CopyLink;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$Delete;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$DocumentPreviewAction;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$Download;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$EndCollaboration;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$EvaluateActions;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$GetOfflineState;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$ItemPreviewAction;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$Navigate;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$ObserveOfflineJob;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$ObserveOfflineState;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$Offline;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$OpenIn;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$PerformAction;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$Rename;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$UpdateActions;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$UpdateOfflineAction;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$PerformAction;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", Analytics.Data.ACTION, "Lcom/box/android/preview/fileactions/FileAction;", "<init>", "(Lcom/box/android/preview/fileactions/FileAction;)V", "getAction", "()Lcom/box/android/preview/fileactions/FileAction;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PerformAction extends Action {
            public static final int $stable = 0;
            private final FileAction action;

            public static /* synthetic */ PerformAction copy$default(PerformAction performAction, FileAction fileAction, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileAction = performAction.action;
                }
                return performAction.copy(fileAction);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileAction getAction() {
                return this.action;
            }

            public final PerformAction copy(FileAction action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new PerformAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PerformAction) && this.action == ((PerformAction) other).action;
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "PerformAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PerformAction(FileAction action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final FileAction getAction() {
                return this.action;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$EvaluateActions;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "itemPreviewItemState", "Lcom/box/android/preview/item/ItemState;", "<init>", "(Lcom/box/android/preview/item/ItemState;)V", "getItemPreviewItemState", "()Lcom/box/android/preview/item/ItemState;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EvaluateActions extends Action {
            public static final int $stable = 8;
            private final ItemState itemPreviewItemState;

            public static /* synthetic */ EvaluateActions copy$default(EvaluateActions evaluateActions, ItemState itemState, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemState = evaluateActions.itemPreviewItemState;
                }
                return evaluateActions.copy(itemState);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemState getItemPreviewItemState() {
                return this.itemPreviewItemState;
            }

            public final EvaluateActions copy(ItemState itemPreviewItemState) {
                Intrinsics.checkNotNullParameter(itemPreviewItemState, "itemPreviewItemState");
                return new EvaluateActions(itemPreviewItemState);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EvaluateActions) && Intrinsics.areEqual(this.itemPreviewItemState, ((EvaluateActions) other).itemPreviewItemState);
            }

            public int hashCode() {
                return this.itemPreviewItemState.hashCode();
            }

            public String toString() {
                return "EvaluateActions(itemPreviewItemState=" + this.itemPreviewItemState + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EvaluateActions(ItemState itemPreviewItemState) {
                super(null);
                Intrinsics.checkNotNullParameter(itemPreviewItemState, "itemPreviewItemState");
                this.itemPreviewItemState = itemPreviewItemState;
            }

            public final ItemState getItemPreviewItemState() {
                return this.itemPreviewItemState;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$UpdateActions;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "fileActions", "", "Lcom/box/android/preview/fileactions/FileAction;", "<init>", "(Ljava/util/Set;)V", "getFileActions", "()Ljava/util/Set;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateActions extends Action {
            public static final int $stable = 8;
            private final Set<FileAction> fileActions;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UpdateActions copy$default(UpdateActions updateActions, Set set, int i, Object obj) {
                if ((i & 1) != 0) {
                    set = updateActions.fileActions;
                }
                return updateActions.copy(set);
            }

            public final Set<FileAction> component1() {
                return this.fileActions;
            }

            public final UpdateActions copy(Set<? extends FileAction> fileActions) {
                Intrinsics.checkNotNullParameter(fileActions, "fileActions");
                return new UpdateActions(fileActions);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateActions) && Intrinsics.areEqual(this.fileActions, ((UpdateActions) other).fileActions);
            }

            public int hashCode() {
                return this.fileActions.hashCode();
            }

            public String toString() {
                return "UpdateActions(fileActions=" + this.fileActions + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public UpdateActions(Set<? extends FileAction> fileActions) {
                super(null);
                Intrinsics.checkNotNullParameter(fileActions, "fileActions");
                this.fileActions = fileActions;
            }

            public final Set<FileAction> getFileActions() {
                return this.fileActions;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$Navigate;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "route", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "(Lcom/box/android/preview/routing/PreviewRoute;)V", "getRoute", "()Lcom/box/android/preview/routing/PreviewRoute;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Navigate extends Action {
            public static final int $stable = 0;
            private final PreviewRoute route;

            public static /* synthetic */ Navigate copy$default(Navigate navigate, PreviewRoute previewRoute, int i, Object obj) {
                if ((i & 1) != 0) {
                    previewRoute = navigate.route;
                }
                return navigate.copy(previewRoute);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PreviewRoute getRoute() {
                return this.route;
            }

            public final Navigate copy(PreviewRoute route) {
                Intrinsics.checkNotNullParameter(route, "route");
                return new Navigate(route);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Navigate) && Intrinsics.areEqual(this.route, ((Navigate) other).route);
            }

            public int hashCode() {
                return this.route.hashCode();
            }

            public String toString() {
                return "Navigate(route=" + this.route + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Navigate(PreviewRoute route) {
                super(null);
                Intrinsics.checkNotNullParameter(route, "route");
                this.route = route;
            }

            public final PreviewRoute getRoute() {
                return this.route;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$DocumentPreviewAction;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", Analytics.Data.ACTION, "Lcom/box/android/preview/fileactions/FileAction;", "<init>", "(Lcom/box/android/preview/fileactions/FileAction;)V", "getAction", "()Lcom/box/android/preview/fileactions/FileAction;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DocumentPreviewAction extends Action {
            public static final int $stable = 0;
            private final FileAction action;

            public static /* synthetic */ DocumentPreviewAction copy$default(DocumentPreviewAction documentPreviewAction, FileAction fileAction, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileAction = documentPreviewAction.action;
                }
                return documentPreviewAction.copy(fileAction);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileAction getAction() {
                return this.action;
            }

            public final DocumentPreviewAction copy(FileAction action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new DocumentPreviewAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DocumentPreviewAction) && this.action == ((DocumentPreviewAction) other).action;
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "DocumentPreviewAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DocumentPreviewAction(FileAction action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final FileAction getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$ItemPreviewAction;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", Analytics.Data.ACTION, "Lcom/box/android/preview/fileactions/FileAction;", "<init>", "(Lcom/box/android/preview/fileactions/FileAction;)V", "getAction", "()Lcom/box/android/preview/fileactions/FileAction;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemPreviewAction extends Action {
            public static final int $stable = 0;
            private final FileAction action;

            public static /* synthetic */ ItemPreviewAction copy$default(ItemPreviewAction itemPreviewAction, FileAction fileAction, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileAction = itemPreviewAction.action;
                }
                return itemPreviewAction.copy(fileAction);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileAction getAction() {
                return this.action;
            }

            public final ItemPreviewAction copy(FileAction action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ItemPreviewAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemPreviewAction) && this.action == ((ItemPreviewAction) other).action;
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "ItemPreviewAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemPreviewAction(FileAction action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final FileAction getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$ClosePreview;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ClosePreview extends Action {
            public static final int $stable = 0;
            public static final ClosePreview INSTANCE = new ClosePreview();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ClosePreview)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1145235239;
            }

            public String toString() {
                return "ClosePreview";
            }

            private ClosePreview() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$CopyLink;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;)V", "getAction", "()Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CopyLink extends Action implements Embedded<CopyLinkReducer.Action> {
            public static final int $stable = 0;
            private final CopyLinkReducer.Action action;

            public static /* synthetic */ CopyLink copy$default(CopyLink copyLink, CopyLinkReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = copyLink.action;
                }
                return copyLink.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CopyLinkReducer.Action getAction() {
                return this.action;
            }

            public final CopyLink copy(CopyLinkReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CopyLink(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CopyLink) && Intrinsics.areEqual(this.action, ((CopyLink) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CopyLink(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CopyLink(CopyLinkReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CopyLinkReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$Rename;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;)V", "getAction", "()Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Rename extends Action implements Embedded<UpdateItemInfoReducer.Action> {
            public static final int $stable = 0;
            private final UpdateItemInfoReducer.Action action;

            public static /* synthetic */ Rename copy$default(Rename rename, UpdateItemInfoReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = rename.action;
                }
                return rename.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final UpdateItemInfoReducer.Action getAction() {
                return this.action;
            }

            public final Rename copy(UpdateItemInfoReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Rename(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Rename) && Intrinsics.areEqual(this.action, ((Rename) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Rename(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Rename(UpdateItemInfoReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final UpdateItemInfoReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$Delete;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;)V", "getAction", "()Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Delete extends Action implements Embedded<ItemActionConfirmationReducer.Action> {
            public static final int $stable = ItemActionConfirmationReducer.Action.$stable;
            private final ItemActionConfirmationReducer.Action action;

            public static /* synthetic */ Delete copy$default(Delete delete, ItemActionConfirmationReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = delete.action;
                }
                return delete.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemActionConfirmationReducer.Action getAction() {
                return this.action;
            }

            public final Delete copy(ItemActionConfirmationReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Delete(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Delete) && Intrinsics.areEqual(this.action, ((Delete) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Delete(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Delete(ItemActionConfirmationReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ItemActionConfirmationReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$EndCollaboration;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;)V", "getAction", "()Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EndCollaboration extends Action implements Embedded<ItemActionConfirmationReducer.Action> {
            public static final int $stable = ItemActionConfirmationReducer.Action.$stable;
            private final ItemActionConfirmationReducer.Action action;

            public static /* synthetic */ EndCollaboration copy$default(EndCollaboration endCollaboration, ItemActionConfirmationReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = endCollaboration.action;
                }
                return endCollaboration.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemActionConfirmationReducer.Action getAction() {
                return this.action;
            }

            public final EndCollaboration copy(ItemActionConfirmationReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new EndCollaboration(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EndCollaboration) && Intrinsics.areEqual(this.action, ((EndCollaboration) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "EndCollaboration(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EndCollaboration(ItemActionConfirmationReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ItemActionConfirmationReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$OpenIn;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;)V", "getAction", "()Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenIn extends Action implements Embedded<OpenInReducer.Action> {
            public static final int $stable = 0;
            private final OpenInReducer.Action action;

            public static /* synthetic */ OpenIn copy$default(OpenIn openIn, OpenInReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = openIn.action;
                }
                return openIn.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final OpenInReducer.Action getAction() {
                return this.action;
            }

            public final OpenIn copy(OpenInReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new OpenIn(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OpenIn) && Intrinsics.areEqual(this.action, ((OpenIn) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "OpenIn(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenIn(OpenInReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final OpenInReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$Download;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Download extends Action implements Embedded<DownloadFilesReducer.Action> {
            public static final int $stable = DownloadFilesReducer.Action.$stable;
            private final DownloadFilesReducer.Action action;

            public static /* synthetic */ Download copy$default(Download download, DownloadFilesReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = download.action;
                }
                return download.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DownloadFilesReducer.Action getAction() {
                return this.action;
            }

            public final Download copy(DownloadFilesReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Download(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Download) && Intrinsics.areEqual(this.action, ((Download) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Download(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Download(DownloadFilesReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final DownloadFilesReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$Offline;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Offline extends Action implements Embedded<OfflineFilesReducer.Action> {
            public static final int $stable = OfflineFilesReducer.Action.$stable;
            private final OfflineFilesReducer.Action action;

            public static /* synthetic */ Offline copy$default(Offline offline, OfflineFilesReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = offline.action;
                }
                return offline.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final OfflineFilesReducer.Action getAction() {
                return this.action;
            }

            public final Offline copy(OfflineFilesReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Offline(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Offline) && Intrinsics.areEqual(this.action, ((Offline) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Offline(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Offline(OfflineFilesReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final OfflineFilesReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$BoxAi;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/boxai/BoxAiReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/boxai/BoxAiReducer$Action;)V", "getAction", "()Lcom/box/android/boxai/BoxAiReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BoxAi extends Action implements Embedded<BoxAiReducer.Action> {
            public static final int $stable = BoxAiReducer.Action.$stable;
            private final BoxAiReducer.Action action;

            public static /* synthetic */ BoxAi copy$default(BoxAi boxAi, BoxAiReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = boxAi.action;
                }
                return boxAi.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAiReducer.Action getAction() {
                return this.action;
            }

            public final BoxAi copy(BoxAiReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new BoxAi(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BoxAi) && Intrinsics.areEqual(this.action, ((BoxAi) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "BoxAi(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoxAi(BoxAiReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BoxAiReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$BoxAiCenter;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/boxai/BoxAiCenterReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/boxai/BoxAiCenterReducer$Action;)V", "getAction", "()Lcom/box/android/boxai/BoxAiCenterReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BoxAiCenter extends Action implements Embedded<BoxAiCenterReducer.Action> {
            public static final int $stable = BoxAiCenterReducer.Action.$stable;
            private final BoxAiCenterReducer.Action action;

            public static /* synthetic */ BoxAiCenter copy$default(BoxAiCenter boxAiCenter, BoxAiCenterReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = boxAiCenter.action;
                }
                return boxAiCenter.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAiCenterReducer.Action getAction() {
                return this.action;
            }

            public final BoxAiCenter copy(BoxAiCenterReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new BoxAiCenter(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BoxAiCenter) && Intrinsics.areEqual(this.action, ((BoxAiCenter) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "BoxAiCenter(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoxAiCenter(BoxAiCenterReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BoxAiCenterReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$ObserveOfflineJob;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ObserveOfflineJob extends Action {
            public static final int $stable = 0;
            public static final ObserveOfflineJob INSTANCE = new ObserveOfflineJob();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ObserveOfflineJob)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 610689791;
            }

            public String toString() {
                return "ObserveOfflineJob";
            }

            private ObserveOfflineJob() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$ObserveOfflineState;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ObserveOfflineState extends Action {
            public static final int $stable = 0;
            public static final ObserveOfflineState INSTANCE = new ObserveOfflineState();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ObserveOfflineState)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1529167021;
            }

            public String toString() {
                return "ObserveOfflineState";
            }

            private ObserveOfflineState() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$GetOfflineState;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GetOfflineState extends Action {
            public static final int $stable = 0;
            public static final GetOfflineState INSTANCE = new GetOfflineState();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GetOfflineState)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2107520781;
            }

            public String toString() {
                return "GetOfflineState";
            }

            private GetOfflineState() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsReducer$Action$UpdateOfflineAction;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "isOfflined", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateOfflineAction extends Action {
            public static final int $stable = 0;
            private final boolean isOfflined;

            public static /* synthetic */ UpdateOfflineAction copy$default(UpdateOfflineAction updateOfflineAction, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = updateOfflineAction.isOfflined;
                }
                return updateOfflineAction.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsOfflined() {
                return this.isOfflined;
            }

            public final UpdateOfflineAction copy(boolean isOfflined) {
                return new UpdateOfflineAction(isOfflined);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateOfflineAction) && this.isOfflined == ((UpdateOfflineAction) other).isOfflined;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isOfflined);
            }

            public String toString() {
                return "UpdateOfflineAction(isOfflined=" + this.isOfflined + ")";
            }

            public UpdateOfflineAction(boolean z) {
                super(null);
                this.isOfflined = z;
            }

            public final boolean isOfflined() {
                return this.isOfflined;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reducePreviewItemActions(State state, Action action) {
        Effect effectNone;
        UpdateItemInfoReducer.State renameItemState;
        PermissionsModel permissions;
        if (action instanceof Action.PerformAction) {
            return performItemAction(state, ((Action.PerformAction) action).getAction());
        }
        if (action instanceof Action.EvaluateActions) {
            Action.EvaluateActions evaluateActions = (Action.EvaluateActions) action;
            FileModel fileModel = evaluateActions.getItemPreviewItemState().getFileModel();
            boolean z = (evaluateActions.getItemPreviewItemState() instanceof ItemState.BoxNote) && (permissions = fileModel.getPermissions()) != null && permissions.getCanRename() && this.environment.getFeatureFlips().getNewNoteCreationFlow().getEnabled();
            if (!FileModelKt.isWatermarkedVideo(evaluateActions.getItemPreviewItemState().getFileModel())) {
                effectNone = new Effect((Function1) new FileActionsReducer$reducePreviewItemActions$observeEffect$1(this, null));
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            Effect effect = effectNone;
            if (z) {
                renameItemState = state.getRenameItemState();
                if (renameItemState == null) {
                    renameItemState = UpdateItemInfoReducer.State.Companion.createInitialState$default(UpdateItemInfoReducer.State.INSTANCE, fileModel, null, null, null, false, false, 62, null);
                }
            } else {
                renameItemState = state.getRenameItemState();
            }
            State stateCopy$default = State.copy$default(state, fileModel, null, null, z, null, renameItemState, null, null, null, null, null, null, null, 8150, null);
            return new ReducerResult<>(stateCopy$default, Effect.INSTANCE.merge(effect, new Effect((Function1) new C16731(stateCopy$default, action, null))).cancellable("evaluateFileActionsEffect", true));
        }
        if (action instanceof Action.UpdateActions) {
            Action.UpdateActions updateActions = (Action.UpdateActions) action;
            return new ReducerResult<>(State.copy$default(state, null, null, updateActions.getFileActions(), false, null, null, null, null, null, null, null, null, null, 8187, null), new Effect(new Action.BoxAi(new BoxAiReducer.Action.UpdateSearchableState(updateActions.getFileActions().contains(FileAction.Search)))));
        }
        if (action instanceof Action.CopyLink) {
            return reduceCopySharedLink(state, ((Action.CopyLink) action).getAction());
        }
        if (action instanceof Action.Delete) {
            return reduceDelete(state, ((Action.Delete) action).getAction());
        }
        if (action instanceof Action.EndCollaboration) {
            return reduceEndCollaboration(state, ((Action.EndCollaboration) action).getAction());
        }
        if (action instanceof Action.Rename) {
            return reduceRename(state, ((Action.Rename) action).getAction());
        }
        if (action instanceof Action.OpenIn) {
            return reduceOpenIn(state, ((Action.OpenIn) action).getAction());
        }
        if (action instanceof Action.Download) {
            return reduceDownload(state, ((Action.Download) action).getAction());
        }
        if (action instanceof Action.Offline) {
            return reduceOffline(state, ((Action.Offline) action).getAction());
        }
        if (action instanceof Action.ObserveOfflineJob) {
            final Flow<Result<JobInfo.Status, DomainError>> statusOfJob = this.environment.getOfflineService().getStatusOfJob(state.getFileModel().getItemId());
            return new ReducerResult<>(state, EffectKt.toEffect(new Flow<Action.GetOfflineState>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$$inlined$mapNotNull$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super FileActionsReducer.Action.GetOfflineState> flowCollector, Continuation continuation) {
                    Object objCollect = statusOfJob.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$$inlined$mapNotNull$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$$inlined$mapNotNull$1$2", f = "FileActionsReducer.kt", i = {0, 0, 0, 0, 0, 0}, l = {52}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
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
                            FileActionsReducer.Action.GetOfflineState getOfflineState = FileActionsReducer.Action.GetOfflineState.INSTANCE;
                            if (getOfflineState != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(getOfflineState);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(getOfflineState, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
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
            }).cancellable("ObserveOfflineJobForFileActions", true));
        }
        if (action instanceof Action.ObserveOfflineState) {
            final Flow<BoxModelOfflineManager.State> stateFlow = this.environment.getBoxModelOfflineManagerWrapper().getStateFlow(state.getFileModel().getItemId());
            return new ReducerResult<>(state, EffectKt.toEffect(new Flow<Action.UpdateOfflineAction>() { // from class: com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super FileActionsReducer.Action.UpdateOfflineAction> flowCollector, Continuation continuation) {
                    Object objCollect = stateFlow.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$$inlined$map$1$2", f = "FileActionsReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                            FileActionsReducer.Action.UpdateOfflineAction updateOfflineAction = new FileActionsReducer.Action.UpdateOfflineAction(SetsKt.setOf((Object[]) new BoxModelOfflineManager.State[]{BoxModelOfflineManager.State.OFFLINE, BoxModelOfflineManager.State.OUT_OF_DATE}).contains((BoxModelOfflineManager.State) obj));
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(updateOfflineAction, anonymousClass1) == coroutine_suspended) {
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
            }).cancellable("ObserveOfflineStateForFileActions", true));
        }
        if (action instanceof Action.GetOfflineState) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass4(state, null)));
        }
        if (action instanceof Action.UpdateOfflineAction) {
            return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.flow(new AnonymousClass5(state, this, action, null))));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$1", f = "FileActionsReducer.kt", i = {}, l = {226}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16731 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $newState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16731(State state, Action action, Continuation<? super C16731> continuation) {
            super(1, continuation);
            this.$newState = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FileActionsReducer.this.new C16731(this.$newState, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C16731) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = FileActionsReducer.this.evaluateAvailableActions(this.$newState, ((Action.EvaluateActions) this.$action).getItemPreviewItemState(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Action.UpdateActions((Set) obj);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$4, reason: invalid class name */
    /* JADX INFO: compiled from: FileActionsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$4", f = "FileActionsReducer.kt", i = {}, l = {286}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(State state, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FileActionsReducer.this.new AnonymousClass4(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = FileActionsReducer.this.environment.getOfflineService().isFileOfflined(this.$state.getFileModel(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Action.UpdateOfflineAction(((Boolean) obj).booleanValue());
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$5, reason: invalid class name */
    /* JADX INFO: compiled from: FileActionsReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action$UpdateActions;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsReducer$reducePreviewItemActions$5", f = "FileActionsReducer.kt", i = {0, 0, 1, 1, 1}, l = {BoxCommonConstants.REQUEST_CHOOSE_REMOTE_UPLOAD_DIR, BoxCommonConstants.REQUEST_RETRY_SHARED_LINK}, m = "invokeSuspend", n = {"$this$flow", "updatedActions", "$this$flow", "updatedActions", "canBeOfflined"}, s = {"L$0", "L$1", "L$0", "L$1", "Z$0"}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<FlowCollector<? super Action.UpdateActions>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        final /* synthetic */ FileActionsReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(State state, FileActionsReducer fileActionsReducer, Action action, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$state = state;
            this.this$0 = fileActionsReducer;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$state, this.this$0, this.$action, continuation);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action.UpdateActions> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0088, code lost:
        
            if (r0.emit(new com.box.android.preview.fileactions.FileActionsReducer.Action.UpdateActions(r2), r7) == r1) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L2a
                if (r2 == r4) goto L22
                if (r2 != r3) goto L1a
                java.lang.Object r7 = r7.L$1
                java.util.Set r7 = (java.util.Set) r7
                kotlin.ResultKt.throwOnFailure(r8)
                goto L8b
            L1a:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L22:
                java.lang.Object r2 = r7.L$1
                java.util.Set r2 = (java.util.Set) r2
                kotlin.ResultKt.throwOnFailure(r8)
                goto L59
            L2a:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.preview.fileactions.FileActionsReducer$State r8 = r7.$state
                java.util.Set r8 = r8.getAvailableActions()
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.Set r2 = kotlin.collections.CollectionsKt.toMutableSet(r8)
                com.box.android.preview.fileactions.FileActionsReducer r8 = r7.this$0
                com.box.android.preview.fileactions.FileActionsEnvironment r8 = com.box.android.preview.fileactions.FileActionsReducer.access$getEnvironment$p(r8)
                com.box.android.coreservices.utilities.FileActionsManager r8 = r8.getFileActionsManager()
                com.box.android.preview.fileactions.FileActionsReducer$State r5 = r7.$state
                com.box.android.domain.models.item.FileModel r5 = r5.getFileModel()
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.L$0 = r0
                r7.L$1 = r2
                r7.label = r4
                java.lang.Object r8 = r8.isOfflineActionEnabled(r5, r6)
                if (r8 != r1) goto L59
                goto L8a
            L59:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                com.box.android.preview.fileactions.FileActionsReducer r4 = r7.this$0
                com.box.android.preview.fileactions.FileActionsReducer$Action r5 = r7.$action
                com.box.android.preview.fileactions.FileActionsReducer$Action$UpdateOfflineAction r5 = (com.box.android.preview.fileactions.FileActionsReducer.Action.UpdateOfflineAction) r5
                boolean r5 = r5.isOfflined()
                com.box.android.preview.fileactions.FileActionsReducer.access$updateOfflineActionsInSet(r4, r2, r8, r5)
                com.box.android.preview.fileactions.FileActionsReducer$Action$UpdateActions r4 = new com.box.android.preview.fileactions.FileActionsReducer$Action$UpdateActions
                r4.<init>(r2)
                r5 = r7
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r6
                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                r7.L$1 = r2
                r7.Z$0 = r8
                r7.label = r3
                java.lang.Object r7 = r0.emit(r4, r5)
                if (r7 != r1) goto L8b
            L8a:
                return r1
            L8b:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.fileactions.FileActionsReducer.AnonymousClass5.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final ReducerResult<State, Action> performItemAction(State state, FileAction fileAction) {
        switch (WhenMappings.$EnumSwitchMapping$0[fileAction.ordinal()]) {
            case 1:
                return new ReducerResult<>(state, new Effect(new Action.Navigate(PreviewRoute.Share.INSTANCE)));
            case 2:
                return new ReducerResult<>(state, new Effect(new Action.Navigate(new PreviewRoute.FileActivities(null, null, 3, null))));
            case 3:
                return new ReducerResult<>(state, new Effect(new Action.Navigate(PreviewRoute.Collections.INSTANCE)));
            case 4:
                return new ReducerResult<>(state, new Effect(new Action.Navigate(PreviewRoute.MoveOrCopy.INSTANCE)));
            case 5:
                return new ReducerResult<>(state, new Effect(new Action.Navigate(PreviewRoute.FileInformation.INSTANCE)));
            case 6:
                return new ReducerResult<>(state, new Effect(new Action.Navigate(PreviewRoute.ParentFolder.INSTANCE)));
            case 7:
                return new ReducerResult<>(state, new Effect(new Action.Navigate(PreviewRoute.Settings.INSTANCE)));
            case 8:
                return new ReducerResult<>(state, new Effect(new Action.DocumentPreviewAction(FileAction.ThumbnailsView)));
            case 9:
                return new ReducerResult<>(state, new Effect(new Action.DocumentPreviewAction(FileAction.OutlineView)));
            case 10:
                return new ReducerResult<>(state, new Effect(new Action.DocumentPreviewAction(FileAction.PageView)));
            case 11:
                return new ReducerResult<>(state, new Effect(new Action.DocumentPreviewAction(FileAction.Search)));
            case 12:
                return new ReducerResult<>(state, new Effect(new Action.DocumentPreviewAction(FileAction.Print)));
            case 13:
                return new ReducerResult<>(state, new Effect(new Action.ItemPreviewAction(FileAction.AddAnnotations)));
            case 14:
                return new ReducerResult<>(state, new Effect(new Action.Navigate(PreviewRoute.Gallery.INSTANCE)));
            case 15:
                return new ReducerResult<>(state, new Effect(new Action.Navigate(PreviewRoute.Playlist.INSTANCE)));
            case 16:
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, new OpenInReducer.State(null, null, 3, null), null, null, null, null, 7935, null), new Effect(new Action.OpenIn(new OpenInReducer.Action.Start(state.getFileModel()))));
            case 17:
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, new CopyLinkReducer.State(null, false, null, 7, null), null, null, null, null, null, null, null, null, 8175, null), new Effect(new Action.CopyLink(new CopyLinkReducer.Action.CopyLinkClicked(state.getFileModel()))));
            case 18:
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, UpdateItemInfoReducer.State.Companion.createInitialState$default(UpdateItemInfoReducer.State.INSTANCE, state.getFileModel(), null, null, null, false, false, 62, null), null, null, null, null, null, null, null, 8159, null), null, 2, null);
            case 19:
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, null, new OfflineFilesReducer.State(CollectionsKt.listOf(state.getFileModel()), null, 2, null), null, null, 7167, null), new Effect(new Action.Offline(OfflineFilesReducer.Action.StartMakeAvailableOffline.INSTANCE)));
            case 20:
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, null, new OfflineFilesReducer.State(CollectionsKt.listOf(state.getFileModel()), null, 2, null), null, null, 7167, null), new Effect(new Action.Offline(OfflineFilesReducer.Action.StartRemoveFromOffline.INSTANCE)));
            case 21:
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, new DownloadFilesReducer.State(null, null, 3, null), null, null, null, 7679, null), new Effect(new Action.Download(new DownloadFilesReducer.Action.Start(state.getFileModel()))));
            case 22:
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, new ItemActionConfirmationReducer.State(state.getFileModel()), null, null, null, null, null, null, 8127, null), null, 2, null);
            case 23:
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, new ItemActionConfirmationReducer.State(state.getFileModel()), null, null, null, null, null, 8063, null), null, 2, null);
            case 24:
                return new ReducerResult<>(state, Effect.INSTANCE.merge(new Effect(new Action.BoxAi(new BoxAiReducer.Action.LaunchWithFiles(CollectionsKt.listOf(state.getFileModel()), null, 2, null))), new Effect(new Action.BoxAiCenter(new BoxAiCenterReducer.Action.Show(CollectionsKt.listOf(state.getFileModel()))))));
            case 25:
                return new ReducerResult<>(state, new Effect(new Action.Navigate(PreviewRoute.Watermarking.INSTANCE)));
            case 26:
                return new ReducerResult<>(state, new Effect(new Action.Navigate(PreviewRoute.AddTask.INSTANCE)));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final ReducerResult<State, Action> reduceRename(State state, UpdateItemInfoReducer.Action renameAction) {
        if (renameAction instanceof UpdateItemInfoReducer.Action.Finish) {
            if (state.isPermanentRenameMode()) {
                return new ReducerResult<>(state, null, 2, null);
            }
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, null, null, null, null, 8159, null), null, 2, null);
        }
        if (renameAction instanceof UpdateItemInfoReducer.Action.Failed) {
            if (state.isPermanentRenameMode()) {
                UpdateItemInfoReducer.State renameItemState = state.getRenameItemState();
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, renameItemState != null ? UpdateItemInfoReducer.State.copy$default(renameItemState, null, null, state.getRenameItemState().getInitialName(), null, null, false, null, null, false, false, null, false, null, 8187, null) : null, null, null, null, null, null, null, null, 8159, null), null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceDelete(State state, ItemActionConfirmationReducer.Action renameAction) {
        if (renameAction instanceof ItemActionConfirmationReducer.Action.ConfirmAction) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, null, null, null, null, 8127, null), new Effect(Action.ClosePreview.INSTANCE));
        }
        if (!(renameAction instanceof ItemActionConfirmationReducer.Action.DismissAction)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, null, null, null, null, 8127, null), null, 2, null);
    }

    private final ReducerResult<State, Action> reduceEndCollaboration(State state, ItemActionConfirmationReducer.Action renameAction) {
        if (renameAction instanceof ItemActionConfirmationReducer.Action.ConfirmAction) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, null, null, null, null, 8063, null), new Effect(Action.ClosePreview.INSTANCE));
        }
        if (!(renameAction instanceof ItemActionConfirmationReducer.Action.DismissAction)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, null, null, null, null, 8063, null), null, 2, null);
    }

    private final ReducerResult<State, Action> reduceCopySharedLink(State state, CopyLinkReducer.Action action) {
        if (action instanceof CopyLinkReducer.Action.Finish) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, null, null, null, null, 8175, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceOpenIn(State state, OpenInReducer.Action action) {
        if (action instanceof OpenInReducer.Action.OpenInExternalApp) {
            return new ReducerResult<>(state, new Effect(new Action.Navigate(PreviewRoute.OpenInExternalApp.INSTANCE)));
        }
        if (action instanceof OpenInReducer.Action.OpenWopiUrl) {
            return new ReducerResult<>(state, new Effect(new Action.Navigate(new PreviewRoute.OpenUrl(((OpenInReducer.Action.OpenWopiUrl) action).getWopiConfiguration().getTargetUrl()))));
        }
        if (action instanceof OpenInReducer.Action.Finish) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, null, null, null, null, 7935, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceDownload(State state, DownloadFilesReducer.Action action) {
        if (action instanceof DownloadFilesReducer.Action.SelectFolder) {
            return new ReducerResult<>(state, new Effect(new Action.Navigate(PreviewRoute.SelectDownloadFolder.INSTANCE)));
        }
        if (action instanceof DownloadFilesReducer.Action.Finish) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, null, null, null, null, 7679, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceOffline(State state, OfflineFilesReducer.Action action) {
        if (action instanceof OfflineFilesReducer.Action.Finish) {
            if (this.environment.getFeatureFlips().getMigrateOfflineInfoToDb().getEnabled()) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, null, null, null, null, 7167, null), null, 2, null);
            }
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, null, null, null, null, null, 7167, null), new Effect(Action.ObserveOfflineJob.INSTANCE));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:103:0x030f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0326  */
    /* JADX WARN: Code duplicated, block: B:14:0x0054 A[PHI: r2 r3 r9 r10 r11
      0x0054: PHI (r2v27 com.box.android.preview.item.ItemState) = (r2v24 com.box.android.preview.item.ItemState), (r2v32 com.box.android.preview.item.ItemState) binds: [B:96:0x02ee, B:13:0x0041] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r3v44 com.box.android.preview.fileactions.FileActionsReducer$State) = 
      (r3v41 com.box.android.preview.fileactions.FileActionsReducer$State)
      (r3v47 com.box.android.preview.fileactions.FileActionsReducer$State)
     binds: [B:96:0x02ee, B:13:0x0041] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r9v26 com.box.android.domain.models.item.FileModel) = (r9v23 com.box.android.domain.models.item.FileModel), (r9v29 com.box.android.domain.models.item.FileModel) binds: [B:96:0x02ee, B:13:0x0041] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r10v27 java.util.Set<com.box.android.preview.fileactions.FileAction>) = 
      (r10v24 java.util.Set<com.box.android.preview.fileactions.FileAction>)
      (r10v30 java.util.Set<com.box.android.preview.fileactions.FileAction>)
     binds: [B:96:0x02ee, B:13:0x0041] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r11v68 java.lang.Object) = (r11v66 java.lang.Object), (r11v1 java.lang.Object) binds: [B:96:0x02ee, B:13:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:35:0x0153  */
    /* JADX WARN: Code duplicated, block: B:40:0x017c  */
    /* JADX WARN: Code duplicated, block: B:43:0x018a  */
    /* JADX WARN: Code duplicated, block: B:46:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:49:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:51:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:54:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:55:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:58:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:59:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:64:0x020c A[PHI: r2 r3 r9 r10 r11
      0x020c: PHI (r2v11 com.box.android.preview.item.ItemState) = (r2v8 com.box.android.preview.item.ItemState), (r2v13 com.box.android.preview.item.ItemState) binds: [B:62:0x0208, B:19:0x00ad] A[DONT_GENERATE, DONT_INLINE]
      0x020c: PHI (r3v28 com.box.android.preview.fileactions.FileActionsReducer$State) = 
      (r3v25 com.box.android.preview.fileactions.FileActionsReducer$State)
      (r3v30 com.box.android.preview.fileactions.FileActionsReducer$State)
     binds: [B:62:0x0208, B:19:0x00ad] A[DONT_GENERATE, DONT_INLINE]
      0x020c: PHI (r9v10 com.box.android.domain.models.item.FileModel) = (r9v7 com.box.android.domain.models.item.FileModel), (r9v12 com.box.android.domain.models.item.FileModel) binds: [B:62:0x0208, B:19:0x00ad] A[DONT_GENERATE, DONT_INLINE]
      0x020c: PHI (r10v11 java.util.Set<com.box.android.preview.fileactions.FileAction>) = 
      (r10v8 java.util.Set<com.box.android.preview.fileactions.FileAction>)
      (r10v13 java.util.Set<com.box.android.preview.fileactions.FileAction>)
     binds: [B:62:0x0208, B:19:0x00ad] A[DONT_GENERATE, DONT_INLINE]
      0x020c: PHI (r11v29 java.lang.Object) = (r11v19 java.lang.Object), (r11v1 java.lang.Object) binds: [B:62:0x0208, B:19:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x0214  */
    /* JADX WARN: Code duplicated, block: B:68:0x0222  */
    /* JADX WARN: Code duplicated, block: B:72:0x023a A[PHI: r2 r3 r9 r10
      0x023a: PHI (r2v14 com.box.android.preview.item.ItemState) = (r2v11 com.box.android.preview.item.ItemState), (r2v16 com.box.android.preview.item.ItemState) binds: [B:70:0x0236, B:18:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x023a: PHI (r3v31 com.box.android.preview.fileactions.FileActionsReducer$State) = 
      (r3v28 com.box.android.preview.fileactions.FileActionsReducer$State)
      (r3v33 com.box.android.preview.fileactions.FileActionsReducer$State)
     binds: [B:70:0x0236, B:18:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x023a: PHI (r9v13 com.box.android.domain.models.item.FileModel) = (r9v10 com.box.android.domain.models.item.FileModel), (r9v15 com.box.android.domain.models.item.FileModel) binds: [B:70:0x0236, B:18:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x023a: PHI (r10v14 java.util.Set<com.box.android.preview.fileactions.FileAction>) = 
      (r10v11 java.util.Set<com.box.android.preview.fileactions.FileAction>)
      (r10v16 java.util.Set<com.box.android.preview.fileactions.FileAction>)
     binds: [B:70:0x0236, B:18:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:74:0x0245  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:80:0x026f A[PHI: r2 r3 r9 r10
      0x026f: PHI (r2v17 com.box.android.preview.item.ItemState) = 
      (r2v14 com.box.android.preview.item.ItemState)
      (r2v18 com.box.android.preview.item.ItemState)
      (r2v18 com.box.android.preview.item.ItemState)
     binds: [B:73:0x0243, B:78:0x0268, B:79:0x026a] A[DONT_GENERATE, DONT_INLINE]
      0x026f: PHI (r3v34 com.box.android.preview.fileactions.FileActionsReducer$State) = 
      (r3v31 com.box.android.preview.fileactions.FileActionsReducer$State)
      (r3v35 com.box.android.preview.fileactions.FileActionsReducer$State)
      (r3v35 com.box.android.preview.fileactions.FileActionsReducer$State)
     binds: [B:73:0x0243, B:78:0x0268, B:79:0x026a] A[DONT_GENERATE, DONT_INLINE]
      0x026f: PHI (r9v16 com.box.android.domain.models.item.FileModel) = 
      (r9v13 com.box.android.domain.models.item.FileModel)
      (r9v17 com.box.android.domain.models.item.FileModel)
      (r9v17 com.box.android.domain.models.item.FileModel)
     binds: [B:73:0x0243, B:78:0x0268, B:79:0x026a] A[DONT_GENERATE, DONT_INLINE]
      0x026f: PHI (r10v17 java.util.Set<com.box.android.preview.fileactions.FileAction>) = 
      (r10v14 java.util.Set<com.box.android.preview.fileactions.FileAction>)
      (r10v18 java.util.Set<com.box.android.preview.fileactions.FileAction>)
      (r10v18 java.util.Set<com.box.android.preview.fileactions.FileAction>)
     binds: [B:73:0x0243, B:78:0x0268, B:79:0x026a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:83:0x028c A[PHI: r2 r3 r9 r10 r11
      0x028c: PHI (r2v21 com.box.android.preview.item.ItemState) = (r2v17 com.box.android.preview.item.ItemState), (r2v23 com.box.android.preview.item.ItemState) binds: [B:81:0x0288, B:16:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x028c: PHI (r3v38 com.box.android.preview.fileactions.FileActionsReducer$State) = 
      (r3v34 com.box.android.preview.fileactions.FileActionsReducer$State)
      (r3v40 com.box.android.preview.fileactions.FileActionsReducer$State)
     binds: [B:81:0x0288, B:16:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x028c: PHI (r9v20 com.box.android.domain.models.item.FileModel) = (r9v16 com.box.android.domain.models.item.FileModel), (r9v22 com.box.android.domain.models.item.FileModel) binds: [B:81:0x0288, B:16:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x028c: PHI (r10v21 java.util.Set<com.box.android.preview.fileactions.FileAction>) = 
      (r10v17 java.util.Set<com.box.android.preview.fileactions.FileAction>)
      (r10v23 java.util.Set<com.box.android.preview.fileactions.FileAction>)
     binds: [B:81:0x0288, B:16:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x028c: PHI (r11v50 java.lang.Object) = (r11v45 java.lang.Object), (r11v1 java.lang.Object) binds: [B:81:0x0288, B:16:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:85:0x0294  */
    /* JADX WARN: Code duplicated, block: B:88:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:92:0x02c7 A[PHI: r2 r3 r9 r10 r11
      0x02c7: PHI (r2v24 com.box.android.preview.item.ItemState) = (r2v21 com.box.android.preview.item.ItemState), (r2v26 com.box.android.preview.item.ItemState) binds: [B:90:0x02c3, B:15:0x0059] A[DONT_GENERATE, DONT_INLINE]
      0x02c7: PHI (r3v41 com.box.android.preview.fileactions.FileActionsReducer$State) = 
      (r3v38 com.box.android.preview.fileactions.FileActionsReducer$State)
      (r3v43 com.box.android.preview.fileactions.FileActionsReducer$State)
     binds: [B:90:0x02c3, B:15:0x0059] A[DONT_GENERATE, DONT_INLINE]
      0x02c7: PHI (r9v23 com.box.android.domain.models.item.FileModel) = (r9v20 com.box.android.domain.models.item.FileModel), (r9v25 com.box.android.domain.models.item.FileModel) binds: [B:90:0x02c3, B:15:0x0059] A[DONT_GENERATE, DONT_INLINE]
      0x02c7: PHI (r10v24 java.util.Set<com.box.android.preview.fileactions.FileAction>) = 
      (r10v21 java.util.Set<com.box.android.preview.fileactions.FileAction>)
      (r10v26 java.util.Set<com.box.android.preview.fileactions.FileAction>)
     binds: [B:90:0x02c3, B:15:0x0059] A[DONT_GENERATE, DONT_INLINE]
      0x02c7: PHI (r11v61 java.lang.Object) = (r11v58 java.lang.Object), (r11v1 java.lang.Object) binds: [B:90:0x02c3, B:15:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:94:0x02cf  */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x034d, code lost:
    
        if (r11 == r1) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x025e, code lost:
    
        if (r11 == r1) goto L111;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object evaluateAvailableActions(com.box.android.preview.fileactions.FileActionsReducer.State r9, com.box.android.preview.item.ItemState r10, kotlin.coroutines.Continuation<? super java.util.Set<? extends com.box.android.preview.fileactions.FileAction>> r11) {
        /*
            Method dump skipped, instruction units count: 912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.fileactions.FileActionsReducer.evaluateAvailableActions(com.box.android.preview.fileactions.FileActionsReducer$State, com.box.android.preview.item.ItemState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object resolveOfflineAction(FileModel fileModel, Set<FileAction> set, Continuation<? super Unit> continuation) {
        C16741 c16741;
        Set<FileAction> set2;
        if (continuation instanceof C16741) {
            c16741 = (C16741) continuation;
            if ((c16741.label & Integer.MIN_VALUE) != 0) {
                c16741.label -= Integer.MIN_VALUE;
            } else {
                c16741 = new C16741(continuation);
            }
        } else {
            c16741 = new C16741(continuation);
        }
        Object objIsOfflineActionEnabled = c16741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16741.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsOfflineActionEnabled);
            if (!FileModelKt.isWatermarkedVideo(fileModel)) {
                FileActionsManager fileActionsManager = this.environment.getFileActionsManager();
                c16741.L$0 = fileModel;
                c16741.L$1 = set;
                c16741.label = 1;
                objIsOfflineActionEnabled = fileActionsManager.isOfflineActionEnabled(fileModel, c16741);
                if (objIsOfflineActionEnabled != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            updateOfflineActionsInSet(set, false, false);
            return Unit.INSTANCE;
        }
        if (i == 1) {
            set = (Set) c16741.L$1;
            fileModel = (FileModel) c16741.L$0;
            ResultKt.throwOnFailure(objIsOfflineActionEnabled);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            set2 = (Set) c16741.L$1;
            ResultKt.throwOnFailure(objIsOfflineActionEnabled);
        }
        updateOfflineActionsInSet(set2, true, ((Boolean) objIsOfflineActionEnabled).booleanValue());
        return Unit.INSTANCE;
        if (((Boolean) objIsOfflineActionEnabled).booleanValue()) {
            IOfflineService offlineService = this.environment.getOfflineService();
            c16741.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            c16741.L$1 = set;
            c16741.label = 2;
            objIsOfflineActionEnabled = offlineService.isFileOfflined(fileModel, c16741);
            if (objIsOfflineActionEnabled != coroutine_suspended) {
                set2 = set;
                updateOfflineActionsInSet(set2, true, ((Boolean) objIsOfflineActionEnabled).booleanValue());
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        updateOfflineActionsInSet(set, false, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateOfflineActionsInSet(Set<FileAction> items, boolean canBeOfflined, boolean isOfflined) {
        items.remove(FileAction.RemoveFromOffline);
        items.remove(FileAction.MakeAvailableOffline);
        if (canBeOfflined) {
            if (isOfflined) {
                items.add(FileAction.RemoveFromOffline);
            } else {
                items.add(FileAction.MakeAvailableOffline);
            }
        }
    }

    private final boolean isAnnotationAvailableForPreview(ItemState itemPreviewState) {
        if ((itemPreviewState instanceof ItemState.Document) || (itemPreviewState instanceof ItemState.Image)) {
            return true;
        }
        return (itemPreviewState instanceof ItemState.Video) && this.environment.getFeatureFlips().getVideoAnnotations().getEnabled() && ((ItemState.Video) itemPreviewState).getState().isLoaded();
    }
}
