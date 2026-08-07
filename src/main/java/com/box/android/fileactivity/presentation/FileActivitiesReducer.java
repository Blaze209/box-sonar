package com.box.android.fileactivity.presentation;

import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;
import com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer;
import com.box.android.base.presentation.components.commentbar.TimestampData;
import com.box.android.base.presentation.components.commentbar.TimestampUtil;
import com.box.android.base.presentation.components.commentbar.TimestampedCommentConfig;
import com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsReducer;
import com.box.android.base.presentation.components.inputbar.InputBoxValue;
import com.box.android.base.presentation.components.inputbar.TextFieldValueUIModel;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.IdentifiedListKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.ForEachReducer;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.FileActivityDomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.CommentContent;
import com.box.android.domain.models.annotations.FileActivityIdModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.models.annotations.FileActivityPermissionsModel;
import com.box.android.domain.models.annotations.FileActivityType;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.usecases.fileactivities.comment.CreateCommentInteractor;
import com.box.android.domain.utils.result.Result;
import com.box.android.fileactivity.R;
import com.box.android.fileactivity.model.AnnotationUIModelV2;
import com.box.android.fileactivity.model.CommentUIModelV2;
import com.box.android.fileactivity.model.FileActivityModelToUiModelMapper;
import com.box.android.fileactivity.model.FileActivityUIModelV2;
import com.box.android.fileactivity.model.FileActivityUIModelsV2Kt;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: FileActivitiesReducer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00059:;<=B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u001e\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\r\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\r\u001a\u00020\"H\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020%H\u0002J\u001a\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/H\u0002J$\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u000201H\u0002J\u001c\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u001c\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J$\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u000205H\u0002J\f\u00106\u001a\u000207*\u000208H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006>"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$State;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "environment", "Lcom/box/android/fileactivity/presentation/FileActivitiesEnvironment;", "<init>", "(Lcom/box/android/fileactivity/presentation/FileActivitiesEnvironment;)V", "getEnvironment", "()Lcom/box/android/fileactivity/presentation/FileActivitiesEnvironment;", "handleAnnotationActivityClicked", "Lcom/box/android/cpl/ReducerResult;", "state", "activity", "Lcom/box/android/fileactivity/model/AnnotationUIModelV2;", "getEffectToSwitchCommentContext", "Lcom/box/android/cpl/Effect;", "idToExitModifyOn", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "handleItemAction", Analytics.Data.ACTION, "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$FileActivityItemAction;", "handleSaveInputBoxValue", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$SaveInputBoxValue;", "createNewComment", "", "inputBoxState", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$Shown;", "(Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$State;Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$Shown;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRefreshRemote", "getUpdatedInputBoxState", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;", "getEffectiveTimestampConfig", "Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$State;", "existingConfig", "getModifiedTargetItem", "Lcom/box/android/fileactivity/model/FileActivityUIModelV2;", "getTimestampData", "Lcom/box/android/base/presentation/components/commentbar/TimestampData;", "targetActivity", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "evaluateErrorItem", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$FailedToFetchSomeItems;", "error", "Lcom/box/android/domain/models/DomainError;", "handleCommentWithMentionsAction", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "handleSubmitCommentClicked", "handleToolbarAction", "handleUpdateActivities", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$UpdateActivities;", "showKeyboard", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$CommentWithMentionsAction;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$CommentWithMentionsAction$Companion;", "State", "InitialLoadState", "FailedToFetchSomeItems", "LoadingState", "Action", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivitiesReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final FileActivitiesEnvironment environment;

    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$InitialLoadState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "NETWORK_DONE", BoxTask.REQUEST_STATUS_COMPLETE, "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum InitialLoadState {
        LOADING,
        NETWORK_DONE,
        COMPLETE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<InitialLoadState> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CommentWithMentionsReducer.InputBoxState.InputBoxType.values().length];
            try {
                iArr[CommentWithMentionsReducer.InputBoxState.InputBoxType.MODIFY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CommentWithMentionsReducer.InputBoxState.InputBoxType.REPLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CommentWithMentionsReducer.InputBoxState.InputBoxType.COMMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivitiesReducer$createNewComment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivitiesReducer", f = "FileActivitiesReducer.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {304, 306, 310, 321}, m = "createNewComment", n = {"state", "inputBoxState", "$this$createNewComment_u24lambda_u240", "inputComment", "content", "$i$a$-apply-FileActivitiesReducer$createNewComment$2", "shouldUseTaggedMessage", "state", "inputBoxState", "$this$createNewComment_u24lambda_u240", "inputComment", "$i$a$-apply-FileActivitiesReducer$createNewComment$2", "state", "inputBoxState", "$this$createNewComment_u24lambda_u240", "inputComment", "$this$onSuccess$iv", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "it", "$i$a$-apply-FileActivitiesReducer$createNewComment$2", "$i$f$onSuccess", "$i$a$-onSuccess-FileActivitiesReducer$createNewComment$2$1", "state", "inputBoxState", "$this$createNewComment_u24lambda_u240", "inputComment", "$this$onError$iv", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "error", "$i$a$-apply-FileActivitiesReducer$createNewComment$2", "$i$f$onError", "$i$a$-onError-FileActivitiesReducer$createNewComment$2$2"}, s = {"L$0", "L$1", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "I$0", "L$0", "L$1", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "L$0", "L$1", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActivitiesReducer.this.createNewComment(null, null, this);
        }
    }

    public FileActivitiesReducer(FileActivitiesEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FileActivitiesReducer.build$lambda$0(this.f$0, (FileActivitiesReducer.State) obj, (FileActivitiesReducer.Action) obj2);
            }
        });
        final FileActivitiesReducer$build$2 fileActivitiesReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.fileactivity.presentation.FileActivitiesReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FileActivitiesReducer.State) obj).getFileActivities();
            }
        };
        final FileActivitiesReducer$build$3 fileActivitiesReducer$build$3 = FileActivitiesReducer$build$3.INSTANCE;
        ForEachReducer forEachReducer = new ForEachReducer(reduce, new FileActivityReducer(environment), fileActivitiesReducer$build$2, new Function1<Action, EmbeddedItem<FileActivityIdModel, FileActivityReducer.Action>>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesReducer$special$$inlined$forEach$1
            @Override // kotlin.jvm.functions.Function1
            public final EmbeddedItem<FileActivityIdModel, FileActivityReducer.Action> invoke(FileActivitiesReducer.Action action) {
                if (!(action instanceof FileActivitiesReducer.Action.FileActivityItemAction)) {
                    action = null;
                }
                return (FileActivitiesReducer.Action.FileActivityItemAction) action;
            }
        }, new Function2<State, FileActivityReducer.State, State>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesReducer$special$$inlined$forEach$2
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FileActivitiesReducer.State invoke(FileActivitiesReducer.State parentState, FileActivityReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                IdentifiedList identifiedListListByReplacingElement = ((IdentifiedList) fileActivitiesReducer$build$2.get(parentState)).listByReplacingElement(childState);
                KProperty1 kProperty1 = fileActivitiesReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FileActivitiesReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, identifiedListListByReplacingElement)));
                        if (rCallBy != 0) {
                            return (FileActivitiesReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.fileactivity.presentation.FileActivitiesReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function2<FileActivityIdModel, FileActivityReducer.Action, Action>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesReducer$special$$inlined$forEach$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final FileActivitiesReducer.Action invoke(FileActivityIdModel id, FileActivityReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Object objInvoke = fileActivitiesReducer$build$3.invoke(id, action);
                if (objInvoke != null) {
                    return (FileActivitiesReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.fileactivity.presentation.FileActivitiesReducer.Action");
            }
        });
        final FileActivitiesReducer$build$5 fileActivitiesReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.fileactivity.presentation.FileActivitiesReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FileActivitiesReducer.State) obj).getCommentWithMentionsState();
            }
        };
        final FileActivitiesReducer$build$6 fileActivitiesReducer$build$6 = FileActivitiesReducer$build$6.INSTANCE;
        this.build = new IfLetReducer(forEachReducer, new CommentWithMentionsReducer(environment.getCommentWithMentionsEnvironment()), new Function1<State, CommentWithMentionsReducer.State>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CommentWithMentionsReducer.State invoke(FileActivitiesReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return fileActivitiesReducer$build$5.invoke(it);
            }
        }, new Function1<Action, CommentWithMentionsReducer.Action>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final CommentWithMentionsReducer.Action invoke(FileActivitiesReducer.Action action) {
                if (!(action instanceof FileActivitiesReducer.Action.CommentWithMentionsAction)) {
                    action = null;
                }
                FileActivitiesReducer.Action.CommentWithMentionsAction commentWithMentionsAction = (FileActivitiesReducer.Action.CommentWithMentionsAction) action;
                if (commentWithMentionsAction != null) {
                    return commentWithMentionsAction.getAction();
                }
                return null;
            }
        }, new Function2<State, CommentWithMentionsReducer.State, State>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FileActivitiesReducer.State invoke(FileActivitiesReducer.State parentState, CommentWithMentionsReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = fileActivitiesReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FileActivitiesReducer.State.class)).iterator();
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
                            return (FileActivitiesReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.fileactivity.presentation.FileActivitiesReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CommentWithMentionsReducer.Action, Action>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FileActivitiesReducer.Action invoke(CommentWithMentionsReducer.Action action) {
                Object objInvoke = fileActivitiesReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (FileActivitiesReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.fileactivity.presentation.FileActivitiesReducer.Action");
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
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010 \n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\u0015\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010F\u001a\u00020\u000fHÆ\u0003J\t\u0010G\u001a\u00020\u0011HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010*J\t\u0010I\u001a\u00020\u000fHÆ\u0003J\t\u0010J\u001a\u00020\u0016HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010L\u001a\u00020\u0019HÆ\u0003J\u009a\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u0019HÆ\u0001¢\u0006\u0002\u0010NJ\u0013\u0010O\u001a\u00020\u000f2\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Q\u001a\u00020\u0013HÖ\u0001J\t\u0010R\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010&R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010&R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b2\u0010&R\u0013\u00103\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u00106\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\t09¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010?\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0011\u0010@\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b@\u0010&¨\u0006S"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$State;", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "loadingState", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$LoadingState;", "fileActivities", "Lcom/box/android/cpl/IdentifiedList;", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$State;", "selectedActivityID", "", "errorItem", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$FailedToFetchSomeItems;", "isClosing", "", "commentBoxValue", "Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "errorMessageRes", "", "isCommentSubmissionInProgress", "commentWithMentionsState", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;", "scrollToCommentId", "initialLoadState", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$InitialLoadState;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$LoadingState;Lcom/box/android/cpl/IdentifiedList;Ljava/lang/String;Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$FailedToFetchSomeItems;ZLcom/box/android/base/presentation/components/inputbar/InputBoxValue;Ljava/lang/Integer;ZLcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;Ljava/lang/String;Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$InitialLoadState;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getLoadingState", "()Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$LoadingState;", "getFileActivities", "()Lcom/box/android/cpl/IdentifiedList;", "getSelectedActivityID", "()Ljava/lang/String;", "getErrorItem", "()Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$FailedToFetchSomeItems;", "()Z", "getCommentBoxValue", "()Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "getErrorMessageRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCommentWithMentionsState", "()Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;", "getScrollToCommentId", "getInitialLoadState", "()Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$InitialLoadState;", "canComment", "getCanComment", "openedFileActivity", "getOpenedFileActivity", "()Lcom/box/android/fileactivity/presentation/FileActivityReducer$State;", "currentlyModifiedActivity", "getCurrentlyModifiedActivity", "shownFileActivities", "", "getShownFileActivities", "()Ljava/util/List;", "scrollToCommentIndex", "getScrollToCommentIndex", "()I", "isInitialRefreshComplete", "isEmpty", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$LoadingState;Lcom/box/android/cpl/IdentifiedList;Ljava/lang/String;Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$FailedToFetchSomeItems;ZLcom/box/android/base/presentation/components/inputbar/InputBoxValue;Ljava/lang/Integer;ZLcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;Ljava/lang/String;Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$InitialLoadState;)Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$State;", "equals", "other", "hashCode", "toString", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final InputBoxValue commentBoxValue;
        private final CommentWithMentionsReducer.State commentWithMentionsState;
        private final FileActivityReducer.State currentlyModifiedActivity;
        private final FailedToFetchSomeItems errorItem;
        private final Integer errorMessageRes;
        private final IdentifiedList<FileActivityIdModel, FileActivityReducer.State> fileActivities;
        private final FileModel fileModel;
        private final InitialLoadState initialLoadState;
        private final boolean isClosing;
        private final boolean isCommentSubmissionInProgress;
        private final boolean isEmpty;
        private final boolean isInitialRefreshComplete;
        private final LoadingState loadingState;
        private final FileActivityReducer.State openedFileActivity;
        private final String scrollToCommentId;
        private final int scrollToCommentIndex;
        private final String selectedActivityID;
        private final List<FileActivityReducer.State> shownFileActivities;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, FileModel fileModel, LoadingState loadingState, IdentifiedList identifiedList, String str, FailedToFetchSomeItems failedToFetchSomeItems, boolean z, InputBoxValue inputBoxValue, Integer num, boolean z2, CommentWithMentionsReducer.State state2, String str2, InitialLoadState initialLoadState, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = state.fileModel;
            }
            if ((i & 2) != 0) {
                loadingState = state.loadingState;
            }
            if ((i & 4) != 0) {
                identifiedList = state.fileActivities;
            }
            if ((i & 8) != 0) {
                str = state.selectedActivityID;
            }
            if ((i & 16) != 0) {
                failedToFetchSomeItems = state.errorItem;
            }
            if ((i & 32) != 0) {
                z = state.isClosing;
            }
            if ((i & 64) != 0) {
                inputBoxValue = state.commentBoxValue;
            }
            if ((i & 128) != 0) {
                num = state.errorMessageRes;
            }
            if ((i & 256) != 0) {
                z2 = state.isCommentSubmissionInProgress;
            }
            if ((i & 512) != 0) {
                state2 = state.commentWithMentionsState;
            }
            if ((i & 1024) != 0) {
                str2 = state.scrollToCommentId;
            }
            if ((i & 2048) != 0) {
                initialLoadState = state.initialLoadState;
            }
            String str3 = str2;
            InitialLoadState initialLoadState2 = initialLoadState;
            boolean z3 = z2;
            CommentWithMentionsReducer.State state3 = state2;
            InputBoxValue inputBoxValue2 = inputBoxValue;
            Integer num2 = num;
            FailedToFetchSomeItems failedToFetchSomeItems2 = failedToFetchSomeItems;
            boolean z4 = z;
            return state.copy(fileModel, loadingState, identifiedList, str, failedToFetchSomeItems2, z4, inputBoxValue2, num2, z3, state3, str3, initialLoadState2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final CommentWithMentionsReducer.State getCommentWithMentionsState() {
            return this.commentWithMentionsState;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getScrollToCommentId() {
            return this.scrollToCommentId;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final InitialLoadState getInitialLoadState() {
            return this.initialLoadState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LoadingState getLoadingState() {
            return this.loadingState;
        }

        public final IdentifiedList<FileActivityIdModel, FileActivityReducer.State> component3() {
            return this.fileActivities;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSelectedActivityID() {
            return this.selectedActivityID;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final FailedToFetchSomeItems getErrorItem() {
            return this.errorItem;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsClosing() {
            return this.isClosing;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final InputBoxValue getCommentBoxValue() {
            return this.commentBoxValue;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getErrorMessageRes() {
            return this.errorMessageRes;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getIsCommentSubmissionInProgress() {
            return this.isCommentSubmissionInProgress;
        }

        public final State copy(FileModel fileModel, LoadingState loadingState, IdentifiedList<FileActivityIdModel, FileActivityReducer.State> fileActivities, String selectedActivityID, FailedToFetchSomeItems errorItem, boolean isClosing, InputBoxValue commentBoxValue, Integer errorMessageRes, boolean isCommentSubmissionInProgress, CommentWithMentionsReducer.State commentWithMentionsState, String scrollToCommentId, InitialLoadState initialLoadState) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(loadingState, "loadingState");
            Intrinsics.checkNotNullParameter(fileActivities, "fileActivities");
            Intrinsics.checkNotNullParameter(commentBoxValue, "commentBoxValue");
            Intrinsics.checkNotNullParameter(commentWithMentionsState, "commentWithMentionsState");
            Intrinsics.checkNotNullParameter(initialLoadState, "initialLoadState");
            return new State(fileModel, loadingState, fileActivities, selectedActivityID, errorItem, isClosing, commentBoxValue, errorMessageRes, isCommentSubmissionInProgress, commentWithMentionsState, scrollToCommentId, initialLoadState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.fileModel, state.fileModel) && Intrinsics.areEqual(this.loadingState, state.loadingState) && Intrinsics.areEqual(this.fileActivities, state.fileActivities) && Intrinsics.areEqual(this.selectedActivityID, state.selectedActivityID) && Intrinsics.areEqual(this.errorItem, state.errorItem) && this.isClosing == state.isClosing && Intrinsics.areEqual(this.commentBoxValue, state.commentBoxValue) && Intrinsics.areEqual(this.errorMessageRes, state.errorMessageRes) && this.isCommentSubmissionInProgress == state.isCommentSubmissionInProgress && Intrinsics.areEqual(this.commentWithMentionsState, state.commentWithMentionsState) && Intrinsics.areEqual(this.scrollToCommentId, state.scrollToCommentId) && this.initialLoadState == state.initialLoadState;
        }

        public int hashCode() {
            int iHashCode = ((((this.fileModel.hashCode() * 31) + this.loadingState.hashCode()) * 31) + this.fileActivities.hashCode()) * 31;
            String str = this.selectedActivityID;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            FailedToFetchSomeItems failedToFetchSomeItems = this.errorItem;
            int iHashCode3 = (((((iHashCode2 + (failedToFetchSomeItems == null ? 0 : failedToFetchSomeItems.hashCode())) * 31) + Boolean.hashCode(this.isClosing)) * 31) + this.commentBoxValue.hashCode()) * 31;
            Integer num = this.errorMessageRes;
            int iHashCode4 = (((((iHashCode3 + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.isCommentSubmissionInProgress)) * 31) + this.commentWithMentionsState.hashCode()) * 31;
            String str2 = this.scrollToCommentId;
            return ((iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.initialLoadState.hashCode();
        }

        public String toString() {
            return "State(fileModel=" + this.fileModel + ", loadingState=" + this.loadingState + ", fileActivities=" + this.fileActivities + ", selectedActivityID=" + this.selectedActivityID + ", errorItem=" + this.errorItem + ", isClosing=" + this.isClosing + ", commentBoxValue=" + this.commentBoxValue + ", errorMessageRes=" + this.errorMessageRes + ", isCommentSubmissionInProgress=" + this.isCommentSubmissionInProgress + ", commentWithMentionsState=" + this.commentWithMentionsState + ", scrollToCommentId=" + this.scrollToCommentId + ", initialLoadState=" + this.initialLoadState + ")";
        }

        public State(FileModel fileModel, LoadingState loadingState, IdentifiedList<FileActivityIdModel, FileActivityReducer.State> fileActivities, String str, FailedToFetchSomeItems failedToFetchSomeItems, boolean z, InputBoxValue commentBoxValue, Integer num, boolean z2, CommentWithMentionsReducer.State commentWithMentionsState, String str2, InitialLoadState initialLoadState) {
            FileActivityReducer.State state;
            FileActivityReducer.State next;
            boolean z3;
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(loadingState, "loadingState");
            Intrinsics.checkNotNullParameter(fileActivities, "fileActivities");
            Intrinsics.checkNotNullParameter(commentBoxValue, "commentBoxValue");
            Intrinsics.checkNotNullParameter(commentWithMentionsState, "commentWithMentionsState");
            Intrinsics.checkNotNullParameter(initialLoadState, "initialLoadState");
            this.fileModel = fileModel;
            this.loadingState = loadingState;
            this.fileActivities = fileActivities;
            this.selectedActivityID = str;
            this.errorItem = failedToFetchSomeItems;
            this.isClosing = z;
            this.commentBoxValue = commentBoxValue;
            this.errorMessageRes = num;
            this.isCommentSubmissionInProgress = z2;
            this.commentWithMentionsState = commentWithMentionsState;
            this.scrollToCommentId = str2;
            this.initialLoadState = initialLoadState;
            Iterator<FileActivityReducer.State> it = fileActivities.iterator();
            do {
                state = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!next.isSingleThreadView());
            this.openedFileActivity = next;
            for (FileActivityReducer.State state2 : this.fileActivities) {
                if (state2.getIsItemOrReplyInModifyState()) {
                    state = state2;
                    break;
                }
            }
            this.currentlyModifiedActivity = state;
            IdentifiedList<FileActivityIdModel, FileActivityReducer.State> identifiedList = this.fileActivities;
            ArrayList arrayList = new ArrayList();
            Iterator<FileActivityReducer.State> it2 = identifiedList.iterator();
            while (true) {
                z3 = false;
                if (!it2.hasNext()) {
                    break;
                }
                FileActivityReducer.State next2 = it2.next();
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.add(next2);
                spreadBuilder.addSpread(next2.getShownReplies().toArray(new FileActivityReducer.State[0]));
                CollectionsKt.addAll(arrayList, CollectionsKt.listOf(spreadBuilder.toArray(new FileActivityReducer.State[spreadBuilder.size()])));
            }
            ArrayList arrayList2 = arrayList;
            this.shownFileActivities = arrayList2;
            Iterator it3 = arrayList2.iterator();
            int i = 0;
            while (true) {
                if (!it3.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(((FileActivityReducer.State) it3.next()).getId().getActivityId(), this.scrollToCommentId)) {
                    break;
                } else {
                    i++;
                }
            }
            this.scrollToCommentIndex = i;
            boolean z4 = this.initialLoadState == InitialLoadState.COMPLETE;
            this.isInitialRefreshComplete = z4;
            if (z4 && Intrinsics.areEqual(this.loadingState, LoadingState.Loaded.INSTANCE)) {
                IdentifiedList<FileActivityIdModel, FileActivityReducer.State> identifiedList2 = this.fileActivities;
                if ((identifiedList2 instanceof Collection) && identifiedList2.isEmpty()) {
                    z3 = true;
                } else {
                    for (FileActivityReducer.State state3 : identifiedList2) {
                        if ((state3.getItem() instanceof CommentUIModelV2) || (state3.getItem() instanceof AnnotationUIModelV2)) {
                        }
                    }
                    z3 = true;
                }
            }
            this.isEmpty = z3;
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(FileModel fileModel, LoadingState loadingState, IdentifiedList identifiedList, String str, FailedToFetchSomeItems failedToFetchSomeItems, boolean z, InputBoxValue inputBoxValue, Integer num, boolean z2, CommentWithMentionsReducer.State state, String str2, InitialLoadState initialLoadState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            InputBoxValue inputBoxValue2;
            LoadingState loadingState2 = (i & 2) != 0 ? LoadingState.Loading.INSTANCE : loadingState;
            IdentifiedList identifiedListEmptyIdentifiedList = (i & 4) != 0 ? IdentifiedListKt.emptyIdentifiedList() : identifiedList;
            TextFieldValueUIModel textFieldValueUIModel = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            String str3 = (i & 8) != 0 ? null : str;
            FailedToFetchSomeItems failedToFetchSomeItems2 = (i & 16) != 0 ? null : failedToFetchSomeItems;
            boolean z3 = (i & 32) != 0 ? false : z;
            if ((i & 64) != 0) {
                inputBoxValue2 = new InputBoxValue(textFieldValueUIModel, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0);
            } else {
                inputBoxValue2 = inputBoxValue;
            }
            this(fileModel, loadingState2, identifiedListEmptyIdentifiedList, str3, failedToFetchSomeItems2, z3, inputBoxValue2, (i & 128) != 0 ? null : num, (i & 256) != 0 ? false : z2, state, (i & 1024) != 0 ? null : str2, (i & 2048) != 0 ? InitialLoadState.LOADING : initialLoadState);
        }

        public final LoadingState getLoadingState() {
            return this.loadingState;
        }

        public final IdentifiedList<FileActivityIdModel, FileActivityReducer.State> getFileActivities() {
            return this.fileActivities;
        }

        public final String getSelectedActivityID() {
            return this.selectedActivityID;
        }

        public final FailedToFetchSomeItems getErrorItem() {
            return this.errorItem;
        }

        public final boolean isClosing() {
            return this.isClosing;
        }

        public final InputBoxValue getCommentBoxValue() {
            return this.commentBoxValue;
        }

        public final Integer getErrorMessageRes() {
            return this.errorMessageRes;
        }

        public final boolean isCommentSubmissionInProgress() {
            return this.isCommentSubmissionInProgress;
        }

        public final CommentWithMentionsReducer.State getCommentWithMentionsState() {
            return this.commentWithMentionsState;
        }

        public final String getScrollToCommentId() {
            return this.scrollToCommentId;
        }

        public final InitialLoadState getInitialLoadState() {
            return this.initialLoadState;
        }

        public final boolean getCanComment() {
            PermissionsModel permissions = this.fileModel.getPermissions();
            if (permissions != null) {
                return permissions.getCanComment();
            }
            return false;
        }

        public final FileActivityReducer.State getOpenedFileActivity() {
            return this.openedFileActivity;
        }

        public final FileActivityReducer.State getCurrentlyModifiedActivity() {
            return this.currentlyModifiedActivity;
        }

        public final List<FileActivityReducer.State> getShownFileActivities() {
            return this.shownFileActivities;
        }

        public final int getScrollToCommentIndex() {
            return this.scrollToCommentIndex;
        }

        /* JADX INFO: renamed from: isInitialRefreshComplete, reason: from getter */
        public final boolean getIsInitialRefreshComplete() {
            return this.isInitialRefreshComplete;
        }

        /* JADX INFO: renamed from: isEmpty, reason: from getter */
        public final boolean getIsEmpty() {
            return this.isEmpty;
        }
    }

    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$FailedToFetchSomeItems;", "", "listOfFeatures", "", "", "<init>", "(Ljava/util/List;)V", "getListOfFeatures", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FailedToFetchSomeItems {
        public static final int $stable = 8;
        private final List<String> listOfFeatures;

        /* JADX WARN: Multi-variable type inference failed */
        public FailedToFetchSomeItems() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FailedToFetchSomeItems copy$default(FailedToFetchSomeItems failedToFetchSomeItems, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = failedToFetchSomeItems.listOfFeatures;
            }
            return failedToFetchSomeItems.copy(list);
        }

        public final List<String> component1() {
            return this.listOfFeatures;
        }

        public final FailedToFetchSomeItems copy(List<String> listOfFeatures) {
            Intrinsics.checkNotNullParameter(listOfFeatures, "listOfFeatures");
            return new FailedToFetchSomeItems(listOfFeatures);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FailedToFetchSomeItems) && Intrinsics.areEqual(this.listOfFeatures, ((FailedToFetchSomeItems) other).listOfFeatures);
        }

        public int hashCode() {
            return this.listOfFeatures.hashCode();
        }

        public String toString() {
            return "FailedToFetchSomeItems(listOfFeatures=" + this.listOfFeatures + ")";
        }

        public FailedToFetchSomeItems(List<String> listOfFeatures) {
            Intrinsics.checkNotNullParameter(listOfFeatures, "listOfFeatures");
            this.listOfFeatures = listOfFeatures;
        }

        public /* synthetic */ FailedToFetchSomeItems(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<String> getListOfFeatures() {
            return this.listOfFeatures;
        }
    }

    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$LoadingState;", "", "<init>", "()V", "Loading", "Loaded", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$LoadingState$Loaded;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$LoadingState$Loading;", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class LoadingState {
        public static final int $stable = 0;

        public /* synthetic */ LoadingState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$LoadingState$Loading;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$LoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loading extends LoadingState {
            public static final int $stable = 0;
            public static final Loading INSTANCE = new Loading();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -888687538;
            }

            public String toString() {
                return "Loading";
            }

            private Loading() {
                super(null);
            }
        }

        private LoadingState() {
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$LoadingState$Loaded;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$LoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loaded extends LoadingState {
            public static final int $stable = 0;
            public static final Loaded INSTANCE = new Loaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 248427187;
            }

            public String toString() {
                return "Loaded";
            }

            private Loaded() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0011\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0011\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%¨\u0006&"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "", "<init>", "()V", "Initialize", "RefreshFromRemote", "InitialRefreshCompleted", "UpdateActivities", "LoadItems", "LoadItemsFailed", "ToolbarAction", "SaveInputBoxValue", "ShowErrorMessage", "HandledErrorMessage", "HandledScrollToComment", "UpdateCommentWithMentionsContext", "RefreshFileModel", "FileModelRefreshed", "CommentSubmissionCompleted", "FileActivityItemAction", "CommentWithMentionsAction", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$CommentSubmissionCompleted;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$CommentWithMentionsAction;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$FileActivityItemAction;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$FileModelRefreshed;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$HandledErrorMessage;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$HandledScrollToComment;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$InitialRefreshCompleted;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$Initialize;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$LoadItems;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$LoadItemsFailed;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$RefreshFileModel;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$RefreshFromRemote;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$SaveInputBoxValue;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$ShowErrorMessage;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$ToolbarAction;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$UpdateActivities;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$UpdateCommentWithMentionsContext;", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$Initialize;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1401635549;
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

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$RefreshFromRemote;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshFromRemote extends Action {
            public static final int $stable = 0;
            public static final RefreshFromRemote INSTANCE = new RefreshFromRemote();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshFromRemote)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 382211550;
            }

            public String toString() {
                return "RefreshFromRemote";
            }

            private RefreshFromRemote() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$InitialRefreshCompleted;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InitialRefreshCompleted extends Action {
            public static final int $stable = 0;
            public static final InitialRefreshCompleted INSTANCE = new InitialRefreshCompleted();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InitialRefreshCompleted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -211899673;
            }

            public String toString() {
                return "InitialRefreshCompleted";
            }

            private InitialRefreshCompleted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$UpdateActivities;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "fileActivityModels", "", "Lcom/box/android/domain/models/annotations/FileActivityModel;", "<init>", "(Ljava/util/List;)V", "getFileActivityModels", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateActivities extends Action {
            public static final int $stable = 8;
            private final List<FileActivityModel> fileActivityModels;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UpdateActivities copy$default(UpdateActivities updateActivities, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = updateActivities.fileActivityModels;
                }
                return updateActivities.copy(list);
            }

            public final List<FileActivityModel> component1() {
                return this.fileActivityModels;
            }

            public final UpdateActivities copy(List<? extends FileActivityModel> fileActivityModels) {
                Intrinsics.checkNotNullParameter(fileActivityModels, "fileActivityModels");
                return new UpdateActivities(fileActivityModels);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateActivities) && Intrinsics.areEqual(this.fileActivityModels, ((UpdateActivities) other).fileActivityModels);
            }

            public int hashCode() {
                return this.fileActivityModels.hashCode();
            }

            public String toString() {
                return "UpdateActivities(fileActivityModels=" + this.fileActivityModels + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public UpdateActivities(List<? extends FileActivityModel> fileActivityModels) {
                super(null);
                Intrinsics.checkNotNullParameter(fileActivityModels, "fileActivityModels");
                this.fileActivityModels = fileActivityModels;
            }

            public final List<FileActivityModel> getFileActivityModels() {
                return this.fileActivityModels;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$LoadItems;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadItems extends Action {
            public static final int $stable = 0;
            public static final LoadItems INSTANCE = new LoadItems();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadItems)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1246020211;
            }

            public String toString() {
                return "LoadItems";
            }

            private LoadItems() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$LoadItemsFailed;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "domainError", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getDomainError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadItemsFailed extends Action {
            public static final int $stable = 8;
            private final DomainError domainError;

            public static /* synthetic */ LoadItemsFailed copy$default(LoadItemsFailed loadItemsFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = loadItemsFailed.domainError;
                }
                return loadItemsFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getDomainError() {
                return this.domainError;
            }

            public final LoadItemsFailed copy(DomainError domainError) {
                Intrinsics.checkNotNullParameter(domainError, "domainError");
                return new LoadItemsFailed(domainError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LoadItemsFailed) && Intrinsics.areEqual(this.domainError, ((LoadItemsFailed) other).domainError);
            }

            public int hashCode() {
                return this.domainError.hashCode();
            }

            public String toString() {
                return "LoadItemsFailed(domainError=" + this.domainError + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadItemsFailed(DomainError domainError) {
                super(null);
                Intrinsics.checkNotNullParameter(domainError, "domainError");
                this.domainError = domainError;
            }

            public final DomainError getDomainError() {
                return this.domainError;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$ToolbarAction;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ToolbarAction extends Action {
            public static final int $stable = 0;
            public static final ToolbarAction INSTANCE = new ToolbarAction();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ToolbarAction)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 661018404;
            }

            public String toString() {
                return "ToolbarAction";
            }

            private ToolbarAction() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$SaveInputBoxValue;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "updatedInputBoxValue", "Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "<init>", "(Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;)V", "getUpdatedInputBoxValue", "()Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SaveInputBoxValue extends Action {
            public static final int $stable = InputBoxValue.$stable;
            private final InputBoxValue updatedInputBoxValue;

            public static /* synthetic */ SaveInputBoxValue copy$default(SaveInputBoxValue saveInputBoxValue, InputBoxValue inputBoxValue, int i, Object obj) {
                if ((i & 1) != 0) {
                    inputBoxValue = saveInputBoxValue.updatedInputBoxValue;
                }
                return saveInputBoxValue.copy(inputBoxValue);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InputBoxValue getUpdatedInputBoxValue() {
                return this.updatedInputBoxValue;
            }

            public final SaveInputBoxValue copy(InputBoxValue updatedInputBoxValue) {
                Intrinsics.checkNotNullParameter(updatedInputBoxValue, "updatedInputBoxValue");
                return new SaveInputBoxValue(updatedInputBoxValue);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SaveInputBoxValue) && Intrinsics.areEqual(this.updatedInputBoxValue, ((SaveInputBoxValue) other).updatedInputBoxValue);
            }

            public int hashCode() {
                return this.updatedInputBoxValue.hashCode();
            }

            public String toString() {
                return "SaveInputBoxValue(updatedInputBoxValue=" + this.updatedInputBoxValue + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SaveInputBoxValue(InputBoxValue updatedInputBoxValue) {
                super(null);
                Intrinsics.checkNotNullParameter(updatedInputBoxValue, "updatedInputBoxValue");
                this.updatedInputBoxValue = updatedInputBoxValue;
            }

            public final InputBoxValue getUpdatedInputBoxValue() {
                return this.updatedInputBoxValue;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$ShowErrorMessage;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "msgRes", "", "<init>", "(I)V", "getMsgRes", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowErrorMessage extends Action {
            public static final int $stable = 0;
            private final int msgRes;

            public static /* synthetic */ ShowErrorMessage copy$default(ShowErrorMessage showErrorMessage, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showErrorMessage.msgRes;
                }
                return showErrorMessage.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getMsgRes() {
                return this.msgRes;
            }

            public final ShowErrorMessage copy(int msgRes) {
                return new ShowErrorMessage(msgRes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowErrorMessage) && this.msgRes == ((ShowErrorMessage) other).msgRes;
            }

            public int hashCode() {
                return Integer.hashCode(this.msgRes);
            }

            public String toString() {
                return "ShowErrorMessage(msgRes=" + this.msgRes + ")";
            }

            public ShowErrorMessage(int i) {
                super(null);
                this.msgRes = i;
            }

            public final int getMsgRes() {
                return this.msgRes;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$HandledErrorMessage;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HandledErrorMessage extends Action {
            public static final int $stable = 0;
            public static final HandledErrorMessage INSTANCE = new HandledErrorMessage();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HandledErrorMessage)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -249098866;
            }

            public String toString() {
                return "HandledErrorMessage";
            }

            private HandledErrorMessage() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$HandledScrollToComment;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HandledScrollToComment extends Action {
            public static final int $stable = 0;
            public static final HandledScrollToComment INSTANCE = new HandledScrollToComment();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HandledScrollToComment)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1439808504;
            }

            public String toString() {
                return "HandledScrollToComment";
            }

            private HandledScrollToComment() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$UpdateCommentWithMentionsContext;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateCommentWithMentionsContext extends Action {
            public static final int $stable = 0;
            public static final UpdateCommentWithMentionsContext INSTANCE = new UpdateCommentWithMentionsContext();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateCommentWithMentionsContext)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1688870487;
            }

            public String toString() {
                return "UpdateCommentWithMentionsContext";
            }

            private UpdateCommentWithMentionsContext() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$RefreshFileModel;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshFileModel extends Action {
            public static final int $stable = 0;
            public static final RefreshFileModel INSTANCE = new RefreshFileModel();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshFileModel)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 135053311;
            }

            public String toString() {
                return "RefreshFileModel";
            }

            private RefreshFileModel() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$FileModelRefreshed;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FileModelRefreshed extends Action {
            public static final int $stable = 8;
            private final FileModel fileModel;

            public static /* synthetic */ FileModelRefreshed copy$default(FileModelRefreshed fileModelRefreshed, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = fileModelRefreshed.fileModel;
                }
                return fileModelRefreshed.copy(fileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final FileModelRefreshed copy(FileModel fileModel) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new FileModelRefreshed(fileModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FileModelRefreshed) && Intrinsics.areEqual(this.fileModel, ((FileModelRefreshed) other).fileModel);
            }

            public int hashCode() {
                return this.fileModel.hashCode();
            }

            public String toString() {
                return "FileModelRefreshed(fileModel=" + this.fileModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FileModelRefreshed(FileModel fileModel) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$CommentSubmissionCompleted;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "newCommentId", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "<init>", "(Lcom/box/android/domain/models/annotations/FileActivityIdModel;)V", "getNewCommentId", "()Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$FileActivityItemAction;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "Lcom/box/android/cpl/EmbeddedItem;", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "id", "fileActivityAction", "<init>", "(Lcom/box/android/domain/models/annotations/FileActivityIdModel;Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;)V", "getId", "()Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "getFileActivityAction", "()Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FileActivityItemAction extends Action implements EmbeddedItem<FileActivityIdModel, FileActivityReducer.Action> {
            public static final int $stable = 8;
            private final FileActivityReducer.Action fileActivityAction;
            private final FileActivityIdModel id;

            public static /* synthetic */ FileActivityItemAction copy$default(FileActivityItemAction fileActivityItemAction, FileActivityIdModel fileActivityIdModel, FileActivityReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileActivityIdModel = fileActivityItemAction.id;
                }
                if ((i & 2) != 0) {
                    action = fileActivityItemAction.fileActivityAction;
                }
                return fileActivityItemAction.copy(fileActivityIdModel, action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileActivityIdModel getId() {
                return this.id;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final FileActivityReducer.Action getAction() {
                return this.fileActivityAction;
            }

            public final FileActivityItemAction copy(FileActivityIdModel id, FileActivityReducer.Action fileActivityAction) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(fileActivityAction, "fileActivityAction");
                return new FileActivityItemAction(id, fileActivityAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FileActivityItemAction)) {
                    return false;
                }
                FileActivityItemAction fileActivityItemAction = (FileActivityItemAction) other;
                return Intrinsics.areEqual(this.id, fileActivityItemAction.id) && Intrinsics.areEqual(this.fileActivityAction, fileActivityItemAction.fileActivityAction);
            }

            public int hashCode() {
                return (this.id.hashCode() * 31) + this.fileActivityAction.hashCode();
            }

            public String toString() {
                return "FileActivityItemAction(id=" + this.id + ", fileActivityAction=" + this.fileActivityAction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FileActivityItemAction(FileActivityIdModel id, FileActivityReducer.Action fileActivityAction) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(fileActivityAction, "fileActivityAction");
                this.id = id;
                this.fileActivityAction = fileActivityAction;
            }

            public final FileActivityReducer.Action getFileActivityAction() {
                return this.fileActivityAction;
            }

            public final FileActivityIdModel getId() {
                return this.id;
            }
        }

        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$CommentWithMentionsAction;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CommentWithMentionsAction extends Action implements Embedded<CommentWithMentionsReducer.Action> {
            private final CommentWithMentionsReducer.Action action;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            public static final int $stable = CommentWithMentionsReducer.Action.$stable;

            public static /* synthetic */ CommentWithMentionsAction copy$default(CommentWithMentionsAction commentWithMentionsAction, CommentWithMentionsReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = commentWithMentionsAction.action;
                }
                return commentWithMentionsAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CommentWithMentionsReducer.Action getAction() {
                return this.action;
            }

            public final CommentWithMentionsAction copy(CommentWithMentionsReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CommentWithMentionsAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CommentWithMentionsAction) && Intrinsics.areEqual(this.action, ((CommentWithMentionsAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CommentWithMentionsAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CommentWithMentionsAction(CommentWithMentionsReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CommentWithMentionsReducer.Action getAction() {
                return this.action;
            }

            /* JADX INFO: compiled from: FileActivitiesReducer.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$CommentWithMentionsAction$Companion;", "", "<init>", "()V", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }
    }

    private final ReducerResult<State, Action> handleAnnotationActivityClicked(State state, AnnotationUIModelV2 activity) {
        FileVersionMiniModel fileVersion = state.getFileModel().getFileVersion();
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, fileVersion != null ? Intrinsics.areEqual(fileVersion.getId(), activity.getVersion().getId()) : true, null, null, false, null, null, null, 4063, null), null, 2, null);
    }

    private final Effect<Action> getEffectToSwitchCommentContext(FileActivityIdModel idToExitModifyOn) {
        Effect effectNone;
        if (idToExitModifyOn != null) {
            effectNone = new Effect(new Action.FileActivityItemAction(idToExitModifyOn, FileActivityReducer.Action.ExitModify.INSTANCE));
        } else {
            effectNone = Effect.INSTANCE.none();
        }
        return Effect.INSTANCE.merge(effectNone, new Effect(Action.UpdateCommentWithMentionsContext.INSTANCE));
    }

    private final ReducerResult<State, Action> handleItemAction(State state, Action.FileActivityItemAction action) {
        FileActivityReducer.State next;
        FileActivityReducer.State state2 = (FileActivityReducer.State) state.getFileActivities().getById(action.getId());
        FileActivityUIModelV2 item = state2 != null ? state2.getItem() : null;
        FileActivityReducer.Action fileActivityAction = action.getFileActivityAction();
        if (fileActivityAction instanceof FileActivityReducer.Action.PageVersionBubbleClicked) {
            return item instanceof AnnotationUIModelV2 ? handleAnnotationActivityClicked(state, (AnnotationUIModelV2) item) : new ReducerResult<>(state, null, 2, null);
        }
        if (fileActivityAction instanceof FileActivityReducer.Action.ReplyButtonClicked) {
            return new ReducerResult<>(state, new Effect(showKeyboard(Action.CommentWithMentionsAction.INSTANCE)));
        }
        if (fileActivityAction instanceof FileActivityReducer.Action.ChangeSingleThreadVisibility) {
            FileActivityReducer.State currentlyModifiedActivity = state.getCurrentlyModifiedActivity();
            return new ReducerResult<>(state, getEffectToSwitchCommentContext(currentlyModifiedActivity != null ? currentlyModifiedActivity.getId() : null));
        }
        if (!(fileActivityAction instanceof FileActivityReducer.Action.TriggerModify)) {
            if (fileActivityAction instanceof FileActivityReducer.Action.CommentSubmissionCompleted) {
                return new ReducerResult<>(state, new Effect(new Action.CommentSubmissionCompleted(((FileActivityReducer.Action.CommentSubmissionCompleted) action.getFileActivityAction()).getNewCommentId())));
            }
            if (fileActivityAction instanceof FileActivityReducer.Action.ShowErrorMessage) {
                return new ReducerResult<>(state, new Effect(new Action.ShowErrorMessage(((FileActivityReducer.Action.ShowErrorMessage) action.getFileActivityAction()).getErrorMessageRes())));
            }
            if (fileActivityAction instanceof FileActivityReducer.Action.ExitModify) {
                return new ReducerResult<>(state, getEffectToSwitchCommentContext(null));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        Iterator<FileActivityReducer.State> it = state.getFileActivities().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            FileActivityReducer.State state3 = next;
            if (state3.getIsItemOrReplyInModifyState() && !Intrinsics.areEqual(state3.getId(), action.getId())) {
                break;
            }
        }
        FileActivityReducer.State state4 = next;
        return new ReducerResult<>(state, Effect.INSTANCE.merge(new Effect(showKeyboard(Action.CommentWithMentionsAction.INSTANCE)), getEffectToSwitchCommentContext(state4 != null ? state4.getId() : null)));
    }

    private final ReducerResult<State, Action> handleSaveInputBoxValue(State state, Action.SaveInputBoxValue action) {
        CommentWithMentionsReducer.InputBoxState inputBoxState = state.getCommentWithMentionsState().getInputBoxState();
        Intrinsics.checkNotNull(inputBoxState, "null cannot be cast to non-null type com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer.InputBoxState.Shown");
        int i = WhenMappings.$EnumSwitchMapping$0[((CommentWithMentionsReducer.InputBoxState.Shown) inputBoxState).getInputBoxType().ordinal()];
        if (i == 1) {
            FileActivityReducer.State currentlyModifiedActivity = state.getCurrentlyModifiedActivity();
            Intrinsics.checkNotNull(currentlyModifiedActivity);
            return new ReducerResult<>(state, new Effect(new Action.FileActivityItemAction(currentlyModifiedActivity.getId(), new FileActivityReducer.Action.SaveModifyMessage(action.getUpdatedInputBoxValue()))));
        }
        if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, false, action.getUpdatedInputBoxValue(), null, false, null, null, null, 4031, null), null, 2, null);
        }
        FileActivityReducer.State openedFileActivity = state.getOpenedFileActivity();
        Intrinsics.checkNotNull(openedFileActivity);
        return new ReducerResult<>(state, new Effect(new Action.FileActivityItemAction(openedFileActivity.getId(), new FileActivityReducer.Action.SaveReplyActivity(action.getUpdatedInputBoxValue()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:50:0x0231  */
    /* JADX WARN: Code duplicated, block: B:52:0x0235  */
    /* JADX WARN: Code duplicated, block: B:55:0x0275  */
    /* JADX WARN: Code duplicated, block: B:57:0x0287  */
    /* JADX WARN: Code duplicated, block: B:61:0x0295  */
    /* JADX WARN: Code duplicated, block: B:64:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object createNewComment(State state, CommentWithMentionsReducer.InputBoxState.Shown shown, Continuation<? super List<? extends Action>> continuation) {
        AnonymousClass1 anonymousClass1;
        String taggedString;
        State state2;
        CommentWithMentionsReducer.InputBoxState.Shown shown2;
        List list;
        List list2;
        int i;
        CommentContent.Message message;
        Result result;
        String str;
        State state3;
        List list3;
        CommentWithMentionsReducer.InputBoxState.Shown shown3;
        List list4;
        FileActivityIdModel fileActivityIdModel;
        Result result2;
        State state4;
        int i2;
        Result result3;
        List list5;
        DomainError domainError;
        Gen204FileActivityEventLogger fileActivityEventLogger;
        String string;
        Result result4;
        DomainError domainError2;
        List list6;
        FileActivityModel.CommentModel commentModel;
        FileActivityIdModel fileActivityIdModel2;
        String id;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            BoxAmplitudeAnalytics.createFileActivitiesEventPropertyBuilder().logSubmitCommentCtaTriggered(state.getFileModel().getItemId().toString());
            taggedString = CommentBarInputBoxKt.toTaggedString(shown.getInputBoxValue(), state.getCommentWithMentionsState().getTimestampedCommentConfig());
            if (!this.environment.getFeatureFlips().getFileActivitiesModernization().getEnabled()) {
                boolean zIsEmpty = shown.getInputBoxValue().getMentionSpans().isEmpty();
                int i4 = !zIsEmpty ? 1 : 0;
                if (!zIsEmpty) {
                    message = new CommentContent.TaggedMessage(taggedString);
                } else {
                    message = new CommentContent.Message(taggedString);
                }
                CreateCommentInteractor createCommentInteractor = this.environment.getCreateCommentInteractor();
                ItemId itemId = state.getFileModel().getItemId();
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(shown);
                anonymousClass1.L$2 = arrayList;
                anonymousClass1.L$3 = arrayList;
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(taggedString);
                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(message);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = i4;
                anonymousClass1.label = 1;
                Object objCreateV2 = createCommentInteractor.createV2(itemId, message, anonymousClass1);
                if (objCreateV2 != coroutine_suspended) {
                    state2 = state;
                    shown2 = shown;
                    list = arrayList;
                    list2 = list;
                    obj = objCreateV2;
                    i = 0;
                    result = (Result) obj;
                }
            } else {
                CreateCommentInteractor createCommentInteractor2 = this.environment.getCreateCommentInteractor();
                ItemId itemId2 = state.getFileModel().getItemId();
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(shown);
                anonymousClass1.L$2 = arrayList;
                anonymousClass1.L$3 = arrayList;
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(taggedString);
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 2;
                Object objCreate = createCommentInteractor2.create(itemId2, taggedString, anonymousClass1);
                if (objCreate != coroutine_suspended) {
                    state2 = state;
                    shown2 = shown;
                    list = arrayList;
                    list2 = list;
                    obj = objCreate;
                    i = 0;
                    result = (Result) obj;
                }
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            int i5 = anonymousClass1.I$1;
            i = anonymousClass1.I$0;
            taggedString = (String) anonymousClass1.L$4;
            list = (List) anonymousClass1.L$3;
            list2 = (List) anonymousClass1.L$2;
            shown2 = (CommentWithMentionsReducer.InputBoxState.Shown) anonymousClass1.L$1;
            state2 = (State) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            result = (Result) obj;
        } else if (i3 == 2) {
            i = anonymousClass1.I$0;
            taggedString = (String) anonymousClass1.L$4;
            list = (List) anonymousClass1.L$3;
            list2 = (List) anonymousClass1.L$2;
            shown2 = (CommentWithMentionsReducer.InputBoxState.Shown) anonymousClass1.L$1;
            state2 = (State) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            result = (Result) obj;
        } else {
            if (i3 == 3) {
                int i6 = anonymousClass1.I$2;
                int i7 = anonymousClass1.I$1;
                i = anonymousClass1.I$0;
                result2 = (Result) anonymousClass1.L$6;
                result3 = (Result) anonymousClass1.L$5;
                str = (String) anonymousClass1.L$4;
                list4 = (List) anonymousClass1.L$3;
                list3 = (List) anonymousClass1.L$2;
                shown3 = (CommentWithMentionsReducer.InputBoxState.Shown) anonymousClass1.L$1;
                state3 = (State) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                fileActivityIdModel = null;
                list4.add(new Action.CommentWithMentionsAction(new CommentWithMentionsReducer.Action.TextChanged(new TextFieldValueUIModel("", 0, 0, null, 14, null), 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0)));
                state4 = state3;
                result = result3;
                i2 = i;
                list5 = list4;
                if (!(result instanceof Result.Success)) {
                    if (!(result instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    domainError = (DomainError) ((Result.Error) result).getValue();
                    fileActivityEventLogger = this.environment.getFileActivityEventLogger();
                    string = domainError.toString();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(state4);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(shown3);
                    anonymousClass1.L$2 = list3;
                    anonymousClass1.L$3 = list5;
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass1.L$5 = result;
                    anonymousClass1.L$6 = result2;
                    anonymousClass1.L$7 = domainError;
                    anonymousClass1.I$0 = i2;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.label = 4;
                    if (fileActivityEventLogger.failure("comment", string, anonymousClass1) != coroutine_suspended) {
                        result4 = result2;
                        domainError2 = domainError;
                        list6 = list3;
                    }
                    return coroutine_suspended;
                }
                commentModel = (FileActivityModel.CommentModel) com.box.android.domain.utils.result.ResultKt.getOrNull(result2);
                if (commentModel != null || (id = commentModel.getId()) == null) {
                    fileActivityIdModel2 = fileActivityIdModel;
                } else {
                    fileActivityIdModel2 = new FileActivityIdModel(id, FileActivityType.COMMENT);
                }
                list5.add(new Action.CommentSubmissionCompleted(fileActivityIdModel2));
                return list3;
            }
            if (i3 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i8 = anonymousClass1.I$2;
            int i9 = anonymousClass1.I$1;
            int i10 = anonymousClass1.I$0;
            domainError2 = (DomainError) anonymousClass1.L$7;
            result4 = (Result) anonymousClass1.L$6;
            list5 = (List) anonymousClass1.L$3;
            list6 = (List) anonymousClass1.L$2;
            ResultKt.throwOnFailure(obj);
            fileActivityIdModel = null;
        }
        list5.add(new Action.ShowErrorMessage(FileActivitiesReducerKt.getCommentSubmissionErrorMessageRes(domainError2)));
        result2 = result4;
        list3 = list6;
        commentModel = (FileActivityModel.CommentModel) com.box.android.domain.utils.result.ResultKt.getOrNull(result2);
        if (commentModel != null) {
            fileActivityIdModel2 = fileActivityIdModel;
        } else {
            fileActivityIdModel2 = fileActivityIdModel;
        }
        list5.add(new Action.CommentSubmissionCompleted(fileActivityIdModel2));
        return list3;
        List list7 = list2;
        str = taggedString;
        state3 = state2;
        list3 = list7;
        shown3 = shown2;
        list4 = list;
        if (result instanceof Result.Success) {
            FileActivityModel.CommentModel commentModel2 = (FileActivityModel.CommentModel) ((Result.Success) result).getValue();
            Gen204FileActivityEventLogger fileActivityEventLogger2 = this.environment.getFileActivityEventLogger();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(state3);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(shown3);
            anonymousClass1.L$2 = list3;
            anonymousClass1.L$3 = list4;
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$5 = result;
            anonymousClass1.L$6 = result;
            anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(commentModel2);
            anonymousClass1.I$0 = i;
            anonymousClass1.I$1 = 0;
            anonymousClass1.I$2 = 0;
            anonymousClass1.label = 3;
            if (fileActivityEventLogger2.success("comment", anonymousClass1) != coroutine_suspended) {
                result2 = result;
                result3 = result2;
                fileActivityIdModel = null;
                list4.add(new Action.CommentWithMentionsAction(new CommentWithMentionsReducer.Action.TextChanged(new TextFieldValueUIModel("", 0, 0, null, 14, null), 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0)));
                state4 = state3;
                result = result3;
                i2 = i;
                list5 = list4;
                if (!(result instanceof Result.Success)) {
                    if (!(result instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    domainError = (DomainError) ((Result.Error) result).getValue();
                    fileActivityEventLogger = this.environment.getFileActivityEventLogger();
                    string = domainError.toString();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(state4);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(shown3);
                    anonymousClass1.L$2 = list3;
                    anonymousClass1.L$3 = list5;
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass1.L$5 = result;
                    anonymousClass1.L$6 = result2;
                    anonymousClass1.L$7 = domainError;
                    anonymousClass1.I$0 = i2;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.label = 4;
                    if (fileActivityEventLogger.failure("comment", string, anonymousClass1) != coroutine_suspended) {
                        result4 = result2;
                        domainError2 = domainError;
                        list6 = list3;
                        list5.add(new Action.ShowErrorMessage(FileActivitiesReducerKt.getCommentSubmissionErrorMessageRes(domainError2)));
                        result2 = result4;
                        list3 = list6;
                    }
                }
                commentModel = (FileActivityModel.CommentModel) com.box.android.domain.utils.result.ResultKt.getOrNull(result2);
                if (commentModel != null) {
                    fileActivityIdModel2 = fileActivityIdModel;
                } else {
                    fileActivityIdModel2 = fileActivityIdModel;
                }
                list5.add(new Action.CommentSubmissionCompleted(fileActivityIdModel2));
                return list3;
            }
        } else {
            fileActivityIdModel = null;
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            result2 = result;
            state4 = state3;
            i2 = i;
            list5 = list4;
            if (!(result instanceof Result.Success)) {
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                domainError = (DomainError) ((Result.Error) result).getValue();
                fileActivityEventLogger = this.environment.getFileActivityEventLogger();
                string = domainError.toString();
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(state4);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(shown3);
                anonymousClass1.L$2 = list3;
                anonymousClass1.L$3 = list5;
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$5 = result;
                anonymousClass1.L$6 = result2;
                anonymousClass1.L$7 = domainError;
                anonymousClass1.I$0 = i2;
                anonymousClass1.I$1 = 0;
                anonymousClass1.I$2 = 0;
                anonymousClass1.label = 4;
                if (fileActivityEventLogger.failure("comment", string, anonymousClass1) != coroutine_suspended) {
                    result4 = result2;
                    domainError2 = domainError;
                    list6 = list3;
                    list5.add(new Action.ShowErrorMessage(FileActivitiesReducerKt.getCommentSubmissionErrorMessageRes(domainError2)));
                    result2 = result4;
                    list3 = list6;
                }
            }
            commentModel = (FileActivityModel.CommentModel) com.box.android.domain.utils.result.ResultKt.getOrNull(result2);
            if (commentModel != null) {
                fileActivityIdModel2 = fileActivityIdModel;
            } else {
                fileActivityIdModel2 = fileActivityIdModel;
            }
            list5.add(new Action.CommentSubmissionCompleted(fileActivityIdModel2));
            return list3;
        }
        return coroutine_suspended;
    }

    private final ReducerResult<State, Action> handleRefreshRemote(State state) {
        return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.flow(new C16371(state, null))));
    }

    /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivitiesReducer$handleRefreshRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivitiesReducer$handleRefreshRemote$1", f = "FileActivitiesReducer.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4}, l = {339, 341, 345, 349, 351}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-FileActivitiesReducer$handleRefreshRemote$1$1", "$this$flow", "$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-FileActivitiesReducer$handleRefreshRemote$1$2", "$this$flow", "$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-FileActivitiesReducer$handleRefreshRemote$1$2", "$this$flow"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0"}, v = 1)
    static final class C16371 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16371(State state, Continuation<? super C16371> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16371 c16371 = FileActivitiesReducer.this.new C16371(this.$state, continuation);
            c16371.L$0 = obj;
            return c16371;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16371) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00be  */
        /* JADX WARN: Code duplicated, block: B:30:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:33:0x00ea  */
        /* JADX WARN: Code duplicated, block: B:37:0x0109  */
        /* JADX WARN: Code duplicated, block: B:39:0x010f  */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0125, code lost:
        
            if (r0.emit(com.box.android.fileactivity.presentation.FileActivitiesReducer.Action.InitialRefreshCompleted.INSTANCE, r11) == r1) goto L41;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 305
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.fileactivity.presentation.FileActivitiesReducer.C16371.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final CommentWithMentionsReducer.InputBoxState getUpdatedInputBoxState(State state) {
        CommentWithMentionsReducer.InputBoxState.Hidden shown;
        if (state.getCanComment()) {
            FileActivityReducer.State currentlyModifiedActivity = state.getCurrentlyModifiedActivity();
            if (currentlyModifiedActivity == null) {
                currentlyModifiedActivity = state.getOpenedFileActivity();
            }
            if (currentlyModifiedActivity != null) {
                if (currentlyModifiedActivity.getIsItemOrReplyInModifyState()) {
                    shown = new CommentWithMentionsReducer.InputBoxState.Shown(CommentWithMentionsReducer.InputBoxState.InputBoxType.MODIFY, currentlyModifiedActivity.getModifyDescription());
                } else if (FileActivityUIModelsV2Kt.isResolved(currentlyModifiedActivity.getItem())) {
                    shown = new CommentWithMentionsReducer.InputBoxState.ErrorMessage(R.string.resolved_comment_comment_description);
                } else {
                    FileActivityPermissionsModel permissions = FileActivityUIModelsV2Kt.getPermissions(currentlyModifiedActivity.getItem());
                    if (permissions == null || !permissions.getCanReply()) {
                        shown = CommentWithMentionsReducer.InputBoxState.Hidden.INSTANCE;
                    } else {
                        shown = new CommentWithMentionsReducer.InputBoxState.Shown(CommentWithMentionsReducer.InputBoxState.InputBoxType.REPLY, currentlyModifiedActivity.getReplyActivity());
                    }
                }
                if (shown != null) {
                    return shown;
                }
            }
            return new CommentWithMentionsReducer.InputBoxState.Shown(CommentWithMentionsReducer.InputBoxState.InputBoxType.COMMENT, state.getCommentBoxValue());
        }
        return CommentWithMentionsReducer.InputBoxState.Hidden.INSTANCE;
    }

    private final TimestampedCommentConfig getEffectiveTimestampConfig(FileActivityReducer.State activity, TimestampedCommentConfig existingConfig) {
        if (existingConfig == null) {
            return null;
        }
        if (activity != null) {
            if (activity.getIsItemOrReplyInModifyState()) {
                FileActivityUIModelV2 modifiedTargetItem = getModifiedTargetItem(activity);
                if (modifiedTargetItem == null) {
                    return existingConfig;
                }
                TimestampData timestampData = getTimestampData(modifiedTargetItem);
                if (timestampData != null) {
                    return TimestampedCommentConfig.copy$default(existingConfig, true, 0L, null, Long.valueOf(timestampData.getTimestampMs()), timestampData.getVersionId(), true, 6, null);
                }
                return TimestampedCommentConfig.copy$default(existingConfig, false, 0L, null, null, null, modifiedTargetItem.getId().getType() == FileActivityType.COMMENT, 6, null);
            }
        }
        return TimestampedCommentConfig.copy$default(existingConfig, false, 0L, null, null, null, true, 7, null);
    }

    private final FileActivityUIModelV2 getModifiedTargetItem(FileActivityReducer.State activity) {
        FileActivityIdModel targetId;
        FileActivityReducer.ModifyState modifyState = activity.getModifyState();
        Object obj = null;
        if (modifyState == null || (targetId = modifyState.getTargetId()) == null) {
            return null;
        }
        if (Intrinsics.areEqual(targetId, activity.getId())) {
            return activity.getItem();
        }
        for (Object obj2 : FileActivityUIModelsV2Kt.getReplies(activity.getItem())) {
            if (Intrinsics.areEqual(((CommentUIModelV2) obj2).getId().getActivityId(), targetId.getActivityId())) {
                obj = obj2;
                break;
            }
        }
        return (FileActivityUIModelV2) obj;
    }

    private final TimestampData getTimestampData(FileActivityUIModelV2 targetActivity) {
        if (targetActivity.getId().getType() == FileActivityType.COMMENT) {
            return (TimestampData) CollectionsKt.firstOrNull((List) TimestampUtil.INSTANCE.processTimestamp(FileActivityUIModelsV2Kt.getMessage(targetActivity).getMessage()).getTimestampDataList());
        }
        return null;
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ReducerResult build$lambda$0(final FileActivitiesReducer fileActivitiesReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 2;
        if (action instanceof Action.Initialize) {
            return new ReducerResult(state, Effect.INSTANCE.merge(new Effect(Action.RefreshFileModel.INSTANCE), new Effect(Action.RefreshFromRemote.INSTANCE), new Effect(Action.LoadItems.INSTANCE), new Effect(Action.UpdateCommentWithMentionsContext.INSTANCE)));
        }
        if (action instanceof Action.RefreshFromRemote) {
            return fileActivitiesReducer.handleRefreshRemote(state);
        }
        if (action instanceof Action.InitialRefreshCompleted) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, null, null, false, null, null, InitialLoadState.NETWORK_DONE, 2047, null), null, 2, null);
        }
        if (action instanceof Action.LoadItems) {
            final Flow<Result<List<FileActivityModel>, DomainError>> fileActivitiesV2 = fileActivitiesReducer.environment.getGetFileActivitiesInteractor().getFileActivitiesV2(state.getFileModel().getItemId());
            return new ReducerResult(state, EffectKt.toEffect(new Flow<Action>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesReducer$build$lambda$0$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super FileActivitiesReducer.Action> flowCollector, Continuation continuation) {
                    Object objCollect = fileActivitiesV2.collect(new AnonymousClass2(flowCollector, fileActivitiesReducer), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivitiesReducer$build$lambda$0$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ FileActivitiesReducer this$0;

                    /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivitiesReducer$build$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivitiesReducer$build$lambda$0$$inlined$map$1$2", f = "FileActivitiesReducer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {54, 64, 50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", "it", "$this$map$iv", "activityModels", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-FileActivitiesReducer$build$1$1", "$i$f$map", "$i$a$-map-FileActivitiesReducer$build$1$1$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", "it", "$this$mapError$iv", "error", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-FileActivitiesReducer$build$1$1", "$i$f$mapError", "$i$a$-mapError-FileActivitiesReducer$build$1$1$2", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        int I$1;
                        int I$2;
                        int I$3;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        Object L$5;
                        Object L$6;
                        Object L$7;
                        Object L$8;
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

                    public AnonymousClass2(FlowCollector flowCollector, FileActivitiesReducer fileActivitiesReducer) {
                        this.$this_unsafeFlow = flowCollector;
                        this.this$0 = fileActivitiesReducer;
                    }

                    /* JADX WARN: Code duplicated, block: B:31:0x0138  */
                    /* JADX WARN: Code duplicated, block: B:33:0x013c  */
                    /* JADX WARN: Code duplicated, block: B:36:0x0196  */
                    /* JADX WARN: Code duplicated, block: B:38:0x01b0 A[PHI: r6 r7 r8 r11 r13 r14 r15
                      0x01b0: PHI (r6v5 com.box.android.fileactivity.presentation.FileActivitiesReducer$build$lambda$0$$inlined$map$1$2$1) = 
                      (r6v3 com.box.android.fileactivity.presentation.FileActivitiesReducer$build$lambda$0$$inlined$map$1$2$1)
                      (r6v6 com.box.android.fileactivity.presentation.FileActivitiesReducer$build$lambda$0$$inlined$map$1$2$1)
                     binds: [B:29:0x0134, B:37:0x019d] A[DONT_GENERATE, DONT_INLINE]
                      0x01b0: PHI (r7v6 java.lang.Object) = (r7v3 java.lang.Object), (r7v8 java.lang.Object) binds: [B:29:0x0134, B:37:0x019d] A[DONT_GENERATE, DONT_INLINE]
                      0x01b0: PHI (r8v6 int) = (r8v3 int), (r8v8 int) binds: [B:29:0x0134, B:37:0x019d] A[DONT_GENERATE, DONT_INLINE]
                      0x01b0: PHI (r11v5 com.box.android.domain.utils.result.Result) = (r11v2 com.box.android.domain.utils.result.Result), (r11v7 com.box.android.domain.utils.result.Result$Error) binds: [B:29:0x0134, B:37:0x019d] A[DONT_GENERATE, DONT_INLINE]
                      0x01b0: PHI (r13v3 kotlinx.coroutines.flow.FlowCollector) = (r13v1 kotlinx.coroutines.flow.FlowCollector), (r13v4 kotlinx.coroutines.flow.FlowCollector) binds: [B:29:0x0134, B:37:0x019d] A[DONT_GENERATE, DONT_INLINE]
                      0x01b0: PHI (r14v4 kotlinx.coroutines.flow.FlowCollector) = (r14v2 kotlinx.coroutines.flow.FlowCollector), (r14v5 kotlinx.coroutines.flow.FlowCollector) binds: [B:29:0x0134, B:37:0x019d] A[DONT_GENERATE, DONT_INLINE]
                      0x01b0: PHI (r15v4 java.lang.Object) = (r15v2 java.lang.Object), (r15v5 java.lang.Object) binds: [B:29:0x0134, B:37:0x019d] A[DONT_GENERATE, DONT_INLINE]] */
                    /* JADX WARN: Code duplicated, block: B:43:0x01ee  */
                    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
                    /* JADX WARN: Code restructure failed: missing block: B:39:0x01e8, code lost:
                    
                        if (r13.emit((com.box.android.fileactivity.presentation.FileActivitiesReducer.Action) r0, r2) == r3) goto L40;
                     */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r18, kotlin.coroutines.Continuation r19) {
                        /*
                            Method dump skipped, instruction units count: 506
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.box.android.fileactivity.presentation.FileActivitiesReducer$build$lambda$0$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            }));
        }
        if (action instanceof Action.UpdateActivities) {
            return fileActivitiesReducer.handleUpdateActivities(state, (Action.UpdateActivities) action);
        }
        if (action instanceof Action.LoadItemsFailed) {
            return new ReducerResult(State.copy$default(state, null, LoadingState.Loaded.INSTANCE, null, null, fileActivitiesReducer.evaluateErrorItem(state, ((Action.LoadItemsFailed) action).getDomainError()), false, null, null, false, null, null, InitialLoadState.COMPLETE, 2029, null), null, 2, null);
        }
        if (action instanceof Action.FileActivityItemAction) {
            return fileActivitiesReducer.handleItemAction(state, (Action.FileActivityItemAction) action);
        }
        if (action instanceof Action.ToolbarAction) {
            return fileActivitiesReducer.handleToolbarAction(state);
        }
        if (action instanceof Action.ShowErrorMessage) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, null, Integer.valueOf(((Action.ShowErrorMessage) action).getMsgRes()), false, null, null, null, 3967, null), null, 2, null);
        }
        if (action instanceof Action.HandledErrorMessage) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, null, null, false, null, null, null, 3967, null), null, 2, null);
        }
        if (action instanceof Action.HandledScrollToComment) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, null, null, false, null, null, null, 3071, null), null, 2, null);
        }
        if (action instanceof Action.SaveInputBoxValue) {
            return fileActivitiesReducer.handleSaveInputBoxValue(state, (Action.SaveInputBoxValue) action);
        }
        if (action instanceof Action.CommentSubmissionCompleted) {
            FileActivityIdModel newCommentId = ((Action.CommentSubmissionCompleted) action).getNewCommentId();
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, null, null, false, null, newCommentId != null ? newCommentId.getActivityId() : null, null, 2815, null), new Effect(new Action.CommentWithMentionsAction(new CommentWithMentionsReducer.Action.TextChanged(new TextFieldValueUIModel("", 0, 0, null, 14, null), null, i, 0 == true ? 1 : 0))));
        }
        if (action instanceof Action.UpdateCommentWithMentionsContext) {
            FileActivityReducer.State currentlyModifiedActivity = state.getCurrentlyModifiedActivity();
            if (currentlyModifiedActivity == null) {
                currentlyModifiedActivity = state.getOpenedFileActivity();
            }
            return new ReducerResult(state, new Effect(new Action.CommentWithMentionsAction(new CommentWithMentionsReducer.Action.UpdateInputBoxStateWithTimestamp(fileActivitiesReducer.getUpdatedInputBoxState(state), fileActivitiesReducer.getEffectiveTimestampConfig(currentlyModifiedActivity, state.getCommentWithMentionsState().getTimestampedCommentConfig())))));
        }
        if (action instanceof Action.CommentWithMentionsAction) {
            return fileActivitiesReducer.handleCommentWithMentionsAction(state, ((Action.CommentWithMentionsAction) action).getAction());
        }
        if (action instanceof Action.RefreshFileModel) {
            return new ReducerResult(state, EffectKt.toEffect(FlowKt.flow(new FileActivitiesReducer$build$1$2(state, fileActivitiesReducer, null))));
        }
        if (!(action instanceof Action.FileModelRefreshed)) {
            throw new NoWhenBranchMatchedException();
        }
        IdentifiedList identifiedList = new IdentifiedList();
        IdentifiedList<FileActivityIdModel, FileActivityReducer.State> fileActivities = state.getFileActivities();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fileActivities, 10));
        Iterator<FileActivityReducer.State> it = fileActivities.iterator();
        while (it.hasNext()) {
            arrayList.add(FileActivityReducer.State.copy$default(it.next(), null, null, ((Action.FileModelRefreshed) action).getFileModel(), false, null, null, null, 123, null));
        }
        CollectionsKt.toCollection(arrayList, identifiedList);
        return new ReducerResult(State.copy$default(state, ((Action.FileModelRefreshed) action).getFileModel(), null, identifiedList, null, null, false, null, null, false, null, null, null, 4090, null), null, 2, null);
    }

    private final FailedToFetchSomeItems evaluateErrorItem(State state, DomainError error) {
        if (error instanceof FileActivityDomainError.CouldNotFetchActivityError) {
            ArrayList arrayList = new ArrayList();
            FileActivityDomainError.CouldNotFetchActivityError couldNotFetchActivityError = (FileActivityDomainError.CouldNotFetchActivityError) error;
            if (couldNotFetchActivityError.getAnnotationNotFetched()) {
                arrayList.add(CommonBoxUtil.LS(R.string.annotation_text));
            }
            if (couldNotFetchActivityError.getCommentsNotFetched()) {
                arrayList.add(CommonBoxUtil.LS(R.string.comment_text));
            }
            if (couldNotFetchActivityError.getVersionsNotFetched()) {
                arrayList.add(CommonBoxUtil.LS(R.string.version_text));
            }
            return new FailedToFetchSomeItems(arrayList);
        }
        return state.getErrorItem();
    }

    private final ReducerResult<State, Action> handleCommentWithMentionsAction(State state, CommentWithMentionsReducer.Action action) {
        if (action instanceof CommentWithMentionsReducer.Action.TextChanged) {
            CommentWithMentionsReducer.InputBoxState inputBoxState = state.getCommentWithMentionsState().getInputBoxState();
            Intrinsics.checkNotNull(inputBoxState, "null cannot be cast to non-null type com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer.InputBoxState.Shown");
            return new ReducerResult<>(state, new Effect(new Action.SaveInputBoxValue(((CommentWithMentionsReducer.InputBoxState.Shown) inputBoxState).getInputBoxValue())));
        }
        if (action instanceof CommentWithMentionsReducer.Action.Collaborators) {
            if (Intrinsics.areEqual(((CommentWithMentionsReducer.Action.Collaborators) action).getAction(), CollaboratorsMentionsReducer.Action.LoadingCollaboratorsFailed.INSTANCE)) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, false, null, Integer.valueOf(R.string.error_getting_collaborators), false, null, null, null, 3967, null), null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (!(action instanceof CommentWithMentionsReducer.Action.ExitModifyClicked)) {
            return action instanceof CommentWithMentionsReducer.Action.SubmitCommentClicked ? handleSubmitCommentClicked(state) : new ReducerResult<>(state, null, 2, null);
        }
        FileActivityReducer.State currentlyModifiedActivity = state.getCurrentlyModifiedActivity();
        FileActivityIdModel activityId = currentlyModifiedActivity != null ? currentlyModifiedActivity.getId() : null;
        Intrinsics.checkNotNull(activityId);
        return new ReducerResult<>(state, new Effect(new Action.FileActivityItemAction(activityId, FileActivityReducer.Action.ExitModify.INSTANCE)));
    }

    private final ReducerResult<State, Action> handleSubmitCommentClicked(State state) {
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, false, null, null, true, null, null, null, 3839, null), EffectKt.toEffect(FlowKt.flow(new C16381(state, this, null))));
    }

    /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivitiesReducer$handleSubmitCommentClicked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivitiesReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivitiesReducer$handleSubmitCommentClicked$1", f = "FileActivitiesReducer.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {632, 639, 647, 647}, m = "invokeSuspend", n = {"$this$flow", "inputBoxState", "$this$flow", "inputBoxState", "$this$flow", "inputBoxState", "$this$flow", "inputBoxState", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-FileActivitiesReducer$handleSubmitCommentClicked$1$1"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C16381 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ FileActivitiesReducer this$0;

        /* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivitiesReducer$handleSubmitCommentClicked$1$WhenMappings */
        /* JADX INFO: compiled from: FileActivitiesReducer.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CommentWithMentionsReducer.InputBoxState.InputBoxType.values().length];
                try {
                    iArr[CommentWithMentionsReducer.InputBoxState.InputBoxType.MODIFY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CommentWithMentionsReducer.InputBoxState.InputBoxType.REPLY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CommentWithMentionsReducer.InputBoxState.InputBoxType.COMMENT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16381(State state, FileActivitiesReducer fileActivitiesReducer, Continuation<? super C16381> continuation) {
            super(2, continuation);
            this.$state = state;
            this.this$0 = fileActivitiesReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16381 c16381 = new C16381(this.$state, this.this$0, continuation);
            c16381.L$0 = obj;
            return c16381;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16381) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0085, code lost:
        
            if (r11 == r1) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0107, code lost:
        
            if (r0.emit(new com.box.android.fileactivity.presentation.FileActivitiesReducer.Action.FileActivityItemAction(r3.getActivityId(), new com.box.android.fileactivity.presentation.FileActivityReducer.Action.SubmitReply(r10.$state.getCommentWithMentionsState().getTimestampedCommentConfig())), r10) == r1) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0142, code lost:
        
            if (r0.emit(new com.box.android.fileactivity.presentation.FileActivitiesReducer.Action.FileActivityItemAction(r3.getActivityId(), new com.box.android.fileactivity.presentation.FileActivityReducer.Action.SubmitModify(r10.$state.getCommentWithMentionsState().getTimestampedCommentConfig())), r10) == r1) goto L33;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 328
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.fileactivity.presentation.FileActivitiesReducer.C16381.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final ReducerResult<State, Action> handleToolbarAction(State state) {
        if (state.getOpenedFileActivity() != null) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, false, null, null, false, null, null, null, 4063, null), new Effect(new Action.FileActivityItemAction(state.getOpenedFileActivity().getId(), new FileActivityReducer.Action.ChangeSingleThreadVisibility(false))));
        }
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, true, null, null, false, null, null, null, 4063, null), null, 2, null);
    }

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
    private final ReducerResult<State, Action> handleUpdateActivities(State state, Action.UpdateActivities action) {
        InitialLoadState initialLoadState;
        boolean zContains;
        InputBoxValue inputBoxValue;
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        List<FileActivityModel> fileActivityModels = action.getFileActivityModels();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fileActivityModels, 10));
        Iterator<T> it = fileActivityModels.iterator();
        while (true) {
            String id = null;
            objArr3 = 0;
            objArr2 = 0;
            objArr = 0;
            if (!it.hasNext()) {
                break;
            }
            FileActivityModel fileActivityModel = (FileActivityModel) it.next();
            FileActivityModelToUiModelMapper fileActivityModelToUiModelMapper = FileActivityModelToUiModelMapper.INSTANCE;
            FileVersionMiniModel fileVersion = state.getFileModel().getFileVersion();
            if (fileVersion != null) {
                id = fileVersion.getId();
            }
            arrayList.add(fileActivityModelToUiModelMapper.toUIModel(fileActivityModel, id));
        }
        ArrayList<FileActivityUIModelV2> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (FileActivityUIModelV2 fileActivityUIModelV2 : arrayList2) {
            FileActivityReducer.State state2 = (FileActivityReducer.State) state.getFileActivities().getById(fileActivityUIModelV2.getId());
            String currentContextId = this.environment.getUserContextManager().getCurrentContextId();
            Intrinsics.checkNotNullExpressionValue(currentContextId, "getCurrentContextId(...)");
            FileModel fileModel = state.getFileModel();
            if (state2 != null) {
                zContains = state2.isSingleThreadView();
            } else {
                List<CommentUIModelV2> replies = FileActivityUIModelsV2Kt.getReplies(fileActivityUIModelV2);
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(replies, 10));
                Iterator<T> it2 = replies.iterator();
                while (it2.hasNext()) {
                    arrayList4.add(((CommentUIModelV2) it2.next()).getActivityId());
                }
                zContains = CollectionsKt.contains(arrayList4, state.getScrollToCommentId());
            }
            boolean z = zContains;
            FileActivityReducer.ModifyState modifyState = state2 != null ? state2.getModifyState() : null;
            if (state2 == null || (inputBoxValue = state2.getReplyActivity()) == null) {
                inputBoxValue = new InputBoxValue(objArr == true ? 1 : 0, objArr2 == true ? 1 : 0, 3, objArr3 == true ? 1 : 0);
            }
            arrayList3.add(new FileActivityReducer.State(fileActivityUIModelV2, currentContextId, fileModel, z, modifyState, inputBoxValue, null, 64, null));
        }
        ArrayList arrayList5 = arrayList3;
        IdentifiedList identifiedList = new IdentifiedList();
        if (state.getInitialLoadState() == InitialLoadState.NETWORK_DONE) {
            initialLoadState = InitialLoadState.COMPLETE;
        } else {
            initialLoadState = state.getInitialLoadState();
        }
        return new ReducerResult<>(State.copy$default(state, null, LoadingState.Loaded.INSTANCE, (IdentifiedList) CollectionsKt.toCollection(arrayList5, identifiedList), null, null, false, null, null, false, null, null, initialLoadState, 2041, null), new Effect(Action.UpdateCommentWithMentionsContext.INSTANCE));
    }

    private final Action.CommentWithMentionsAction showKeyboard(Action.CommentWithMentionsAction.Companion companion) {
        return new Action.CommentWithMentionsAction(CommentWithMentionsReducer.Action.ShowKeyboard.INSTANCE);
    }
}
