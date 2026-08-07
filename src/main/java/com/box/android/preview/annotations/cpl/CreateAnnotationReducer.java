package com.box.android.preview.annotations.cpl;

import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;
import com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer;
import com.box.android.base.presentation.components.inputbar.InputBoxValue;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.annotations.AnnotationTargetModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.usecases.fileactivities.annotation.CreateAnnotationInteractor;
import com.box.android.domain.utils.result.Result;
import com.box.android.fileactivity.model.UserUIModel;
import com.box.android.preview.annotations.PdfAnnotationModelMapper;
import com.box.android.preview.annotations.managers.BoxAnnotationMarkupType;
import com.box.android.preview.annotations.managers.BoxAnnotationTool;
import com.box.android.preview.annotations.managers.CreateAnnotationsManager;
import com.box.android.preview.annotations.model.Annotation;
import com.box.android.preview.annotations.model.DocumentSize;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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

/* JADX INFO: compiled from: CreateAnnotationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u001c\u001d\u001e\u001f B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006!"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "environment", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;", "<init>", "(Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "createAnnotation", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "Lcom/box/android/domain/models/DomainError;", "state", "(Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isBelowSizeLimit", "", "annotation", "Lcom/box/android/preview/annotations/model/Annotation;", "updateInputBox", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$CommentWithMentionsAction;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$CommentWithMentionsAction$Companion;", "newInputBox", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;", "State", "SwitchingMarkupTypeState", "PageInfo", "Action", AuthenticationConstants.BUNDLE_MESSAGE, "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateAnnotationReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final CreateAnnotationEnvironment environment;

    /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Message;", "", "<init>", "(Ljava/lang/String;I)V", "SaveFailed", "SaveSuccess", "AnnotationDrawnOutsideActivePage", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Message {
        SaveFailed,
        SaveSuccess,
        AnnotationDrawnOutsideActivePage;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Message> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BoxAnnotationMarkupType.values().length];
            try {
                iArr[BoxAnnotationMarkupType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CreateAnnotationReducer(CreateAnnotationEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new Function2() { // from class: com.box.android.preview.annotations.cpl.CreateAnnotationReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CreateAnnotationReducer.build$lambda$0(this.f$0, (CreateAnnotationReducer.State) obj, (CreateAnnotationReducer.Action) obj2);
            }
        });
        final CreateAnnotationReducer$build$2 createAnnotationReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.annotations.cpl.CreateAnnotationReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CreateAnnotationReducer.State) obj).getCommentWithMentionsState();
            }
        };
        final CreateAnnotationReducer$build$3 createAnnotationReducer$build$3 = CreateAnnotationReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new CommentWithMentionsReducer(environment.getCommentWithMentionsEnvironment()), new Function1<State, CommentWithMentionsReducer.State>() { // from class: com.box.android.preview.annotations.cpl.CreateAnnotationReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CommentWithMentionsReducer.State invoke(CreateAnnotationReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return createAnnotationReducer$build$2.invoke(it);
            }
        }, new Function1<Action, CommentWithMentionsReducer.Action>() { // from class: com.box.android.preview.annotations.cpl.CreateAnnotationReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final CommentWithMentionsReducer.Action invoke(CreateAnnotationReducer.Action action) {
                if (!(action instanceof CreateAnnotationReducer.Action.CommentWithMentionsAction)) {
                    action = null;
                }
                CreateAnnotationReducer.Action.CommentWithMentionsAction commentWithMentionsAction = (CreateAnnotationReducer.Action.CommentWithMentionsAction) action;
                if (commentWithMentionsAction != null) {
                    return commentWithMentionsAction.getAction();
                }
                return null;
            }
        }, new Function2<State, CommentWithMentionsReducer.State, State>() { // from class: com.box.android.preview.annotations.cpl.CreateAnnotationReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CreateAnnotationReducer.State invoke(CreateAnnotationReducer.State parentState, CommentWithMentionsReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = createAnnotationReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CreateAnnotationReducer.State.class)).iterator();
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
                            return (CreateAnnotationReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.annotations.cpl.CreateAnnotationReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CommentWithMentionsReducer.Action, Action>() { // from class: com.box.android.preview.annotations.cpl.CreateAnnotationReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CreateAnnotationReducer.Action invoke(CommentWithMentionsReducer.Action action) {
                Object objInvoke = createAnnotationReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (CreateAnnotationReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.annotations.cpl.CreateAnnotationReducer.Action");
            }
        });
    }

    public final CreateAnnotationEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b9\b\u0087\b\u0018\u0000 W2\u00020\u0001:\u0001WB¯\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0006\u0010@\u001a\u00020\u0017J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010E\u001a\u00020\fHÆ\u0003J\t\u0010F\u001a\u00020\u000eHÆ\u0003J\t\u0010G\u001a\u00020\bHÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00101J\t\u0010I\u001a\u00020\u0013HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010K\u001a\u00020\u0017HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010M\u001a\u00020\u0017HÆ\u0003J\t\u0010N\u001a\u00020\u0017HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\t\u0010P\u001a\u00020\u001fHÆ\u0003J¾\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fHÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020\u00172\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010U\u001a\u00020\u0011HÖ\u0001J\t\u0010V\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u00107R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u001a\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u00107R\u0011\u0010\u001b\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b:\u00107R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010?\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b?\u00107¨\u0006X"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "", "itemId", "Lcom/box/android/domain/models/ItemId;", "itemVersionId", "", "additionalMarkups", "", "Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "pageWithAnnotation", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$PageInfo;", "currentUser", "Lcom/box/android/fileactivity/model/UserUIModel;", "tool", "Lcom/box/android/preview/annotations/managers/BoxAnnotationTool;", "markupType", "color", "", "commentWithMentionsState", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;", "annotation", "Lcom/box/android/preview/annotations/model/Annotation;", "isAnnotationBelowSizeLimit", "", "switchingMarkupType", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$SwitchingMarkupTypeState;", "isSavingInProcess", "showPendingAnnotationWarning", "message", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Message;", "annotationLocationModel", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "<init>", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Ljava/util/List;Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$PageInfo;Lcom/box/android/fileactivity/model/UserUIModel;Lcom/box/android/preview/annotations/managers/BoxAnnotationTool;Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;Ljava/lang/Integer;Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;Lcom/box/android/preview/annotations/model/Annotation;ZLcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$SwitchingMarkupTypeState;ZZLcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Message;Lcom/box/android/domain/models/annotations/AnnotationLocationModel;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "getItemVersionId", "()Ljava/lang/String;", "getAdditionalMarkups", "()Ljava/util/List;", "getPageWithAnnotation", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$PageInfo;", "getCurrentUser", "()Lcom/box/android/fileactivity/model/UserUIModel;", "getTool", "()Lcom/box/android/preview/annotations/managers/BoxAnnotationTool;", "getMarkupType", "()Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCommentWithMentionsState", "()Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;", "getAnnotation", "()Lcom/box/android/preview/annotations/model/Annotation;", "()Z", "getSwitchingMarkupType", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$SwitchingMarkupTypeState;", "getShowPendingAnnotationWarning", "getMessage", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Message;", "getAnnotationLocationModel", "()Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "isInWritingCommentState", "hasPendingAnnotation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Ljava/util/List;Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$PageInfo;Lcom/box/android/fileactivity/model/UserUIModel;Lcom/box/android/preview/annotations/managers/BoxAnnotationTool;Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;Ljava/lang/Integer;Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;Lcom/box/android/preview/annotations/model/Annotation;ZLcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$SwitchingMarkupTypeState;ZZLcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Message;Lcom/box/android/domain/models/annotations/AnnotationLocationModel;)Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "equals", "other", "hashCode", "toString", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        private final List<BoxAnnotationMarkupType> additionalMarkups;
        private final Annotation annotation;
        private final AnnotationLocationModel annotationLocationModel;
        private final Integer color;
        private final CommentWithMentionsReducer.State commentWithMentionsState;
        private final UserUIModel currentUser;
        private final boolean isAnnotationBelowSizeLimit;
        private final boolean isInWritingCommentState;
        private final boolean isSavingInProcess;
        private final ItemId itemId;
        private final String itemVersionId;
        private final BoxAnnotationMarkupType markupType;
        private final Message message;
        private final PageInfo pageWithAnnotation;
        private final boolean showPendingAnnotationWarning;
        private final SwitchingMarkupTypeState switchingMarkupType;
        private final BoxAnnotationTool tool;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, ItemId itemId, String str, List list, PageInfo pageInfo, UserUIModel userUIModel, BoxAnnotationTool boxAnnotationTool, BoxAnnotationMarkupType boxAnnotationMarkupType, Integer num, CommentWithMentionsReducer.State state2, Annotation annotation, boolean z, SwitchingMarkupTypeState switchingMarkupTypeState, boolean z2, boolean z3, Message message, AnnotationLocationModel annotationLocationModel, int i, Object obj) {
            ItemId itemId2 = (i & 1) != 0 ? state.itemId : itemId;
            return state.copy(itemId2, (i & 2) != 0 ? state.itemVersionId : str, (i & 4) != 0 ? state.additionalMarkups : list, (i & 8) != 0 ? state.pageWithAnnotation : pageInfo, (i & 16) != 0 ? state.currentUser : userUIModel, (i & 32) != 0 ? state.tool : boxAnnotationTool, (i & 64) != 0 ? state.markupType : boxAnnotationMarkupType, (i & 128) != 0 ? state.color : num, (i & 256) != 0 ? state.commentWithMentionsState : state2, (i & 512) != 0 ? state.annotation : annotation, (i & 1024) != 0 ? state.isAnnotationBelowSizeLimit : z, (i & 2048) != 0 ? state.switchingMarkupType : switchingMarkupTypeState, (i & 4096) != 0 ? state.isSavingInProcess : z2, (i & 8192) != 0 ? state.showPendingAnnotationWarning : z3, (i & 16384) != 0 ? state.message : message, (i & 32768) != 0 ? state.annotationLocationModel : annotationLocationModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemId getItemId() {
            return this.itemId;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Annotation getAnnotation() {
            return this.annotation;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getIsAnnotationBelowSizeLimit() {
            return this.isAnnotationBelowSizeLimit;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final SwitchingMarkupTypeState getSwitchingMarkupType() {
            return this.switchingMarkupType;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final boolean getIsSavingInProcess() {
            return this.isSavingInProcess;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final boolean getShowPendingAnnotationWarning() {
            return this.showPendingAnnotationWarning;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final AnnotationLocationModel getAnnotationLocationModel() {
            return this.annotationLocationModel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getItemVersionId() {
            return this.itemVersionId;
        }

        public final List<BoxAnnotationMarkupType> component3() {
            return this.additionalMarkups;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final PageInfo getPageWithAnnotation() {
            return this.pageWithAnnotation;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final UserUIModel getCurrentUser() {
            return this.currentUser;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final BoxAnnotationTool getTool() {
            return this.tool;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final BoxAnnotationMarkupType getMarkupType() {
            return this.markupType;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final CommentWithMentionsReducer.State getCommentWithMentionsState() {
            return this.commentWithMentionsState;
        }

        public final State copy(ItemId itemId, String itemVersionId, List<? extends BoxAnnotationMarkupType> additionalMarkups, PageInfo pageWithAnnotation, UserUIModel currentUser, BoxAnnotationTool tool, BoxAnnotationMarkupType markupType, Integer color, CommentWithMentionsReducer.State commentWithMentionsState, Annotation annotation, boolean isAnnotationBelowSizeLimit, SwitchingMarkupTypeState switchingMarkupType, boolean isSavingInProcess, boolean showPendingAnnotationWarning, Message message, AnnotationLocationModel annotationLocationModel) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(itemVersionId, "itemVersionId");
            Intrinsics.checkNotNullParameter(additionalMarkups, "additionalMarkups");
            Intrinsics.checkNotNullParameter(currentUser, "currentUser");
            Intrinsics.checkNotNullParameter(tool, "tool");
            Intrinsics.checkNotNullParameter(markupType, "markupType");
            Intrinsics.checkNotNullParameter(commentWithMentionsState, "commentWithMentionsState");
            Intrinsics.checkNotNullParameter(annotationLocationModel, "annotationLocationModel");
            return new State(itemId, itemVersionId, additionalMarkups, pageWithAnnotation, currentUser, tool, markupType, color, commentWithMentionsState, annotation, isAnnotationBelowSizeLimit, switchingMarkupType, isSavingInProcess, showPendingAnnotationWarning, message, annotationLocationModel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.itemId, state.itemId) && Intrinsics.areEqual(this.itemVersionId, state.itemVersionId) && Intrinsics.areEqual(this.additionalMarkups, state.additionalMarkups) && Intrinsics.areEqual(this.pageWithAnnotation, state.pageWithAnnotation) && Intrinsics.areEqual(this.currentUser, state.currentUser) && this.tool == state.tool && this.markupType == state.markupType && Intrinsics.areEqual(this.color, state.color) && Intrinsics.areEqual(this.commentWithMentionsState, state.commentWithMentionsState) && Intrinsics.areEqual(this.annotation, state.annotation) && this.isAnnotationBelowSizeLimit == state.isAnnotationBelowSizeLimit && Intrinsics.areEqual(this.switchingMarkupType, state.switchingMarkupType) && this.isSavingInProcess == state.isSavingInProcess && this.showPendingAnnotationWarning == state.showPendingAnnotationWarning && this.message == state.message && Intrinsics.areEqual(this.annotationLocationModel, state.annotationLocationModel);
        }

        public int hashCode() {
            int iHashCode = ((((this.itemId.hashCode() * 31) + this.itemVersionId.hashCode()) * 31) + this.additionalMarkups.hashCode()) * 31;
            PageInfo pageInfo = this.pageWithAnnotation;
            int iHashCode2 = (((((((iHashCode + (pageInfo == null ? 0 : pageInfo.hashCode())) * 31) + this.currentUser.hashCode()) * 31) + this.tool.hashCode()) * 31) + this.markupType.hashCode()) * 31;
            Integer num = this.color;
            int iHashCode3 = (((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.commentWithMentionsState.hashCode()) * 31;
            Annotation annotation = this.annotation;
            int iHashCode4 = (((iHashCode3 + (annotation == null ? 0 : annotation.hashCode())) * 31) + Boolean.hashCode(this.isAnnotationBelowSizeLimit)) * 31;
            SwitchingMarkupTypeState switchingMarkupTypeState = this.switchingMarkupType;
            int iHashCode5 = (((((iHashCode4 + (switchingMarkupTypeState == null ? 0 : switchingMarkupTypeState.hashCode())) * 31) + Boolean.hashCode(this.isSavingInProcess)) * 31) + Boolean.hashCode(this.showPendingAnnotationWarning)) * 31;
            Message message = this.message;
            return ((iHashCode5 + (message != null ? message.hashCode() : 0)) * 31) + this.annotationLocationModel.hashCode();
        }

        public String toString() {
            return "State(itemId=" + this.itemId + ", itemVersionId=" + this.itemVersionId + ", additionalMarkups=" + this.additionalMarkups + ", pageWithAnnotation=" + this.pageWithAnnotation + ", currentUser=" + this.currentUser + ", tool=" + this.tool + ", markupType=" + this.markupType + ", color=" + this.color + ", commentWithMentionsState=" + this.commentWithMentionsState + ", annotation=" + this.annotation + ", isAnnotationBelowSizeLimit=" + this.isAnnotationBelowSizeLimit + ", switchingMarkupType=" + this.switchingMarkupType + ", isSavingInProcess=" + this.isSavingInProcess + ", showPendingAnnotationWarning=" + this.showPendingAnnotationWarning + ", message=" + this.message + ", annotationLocationModel=" + this.annotationLocationModel + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(ItemId itemId, String itemVersionId, List<? extends BoxAnnotationMarkupType> additionalMarkups, PageInfo pageInfo, UserUIModel currentUser, BoxAnnotationTool tool, BoxAnnotationMarkupType markupType, Integer num, CommentWithMentionsReducer.State commentWithMentionsState, Annotation annotation, boolean z, SwitchingMarkupTypeState switchingMarkupTypeState, boolean z2, boolean z3, Message message, AnnotationLocationModel annotationLocationModel) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(itemVersionId, "itemVersionId");
            Intrinsics.checkNotNullParameter(additionalMarkups, "additionalMarkups");
            Intrinsics.checkNotNullParameter(currentUser, "currentUser");
            Intrinsics.checkNotNullParameter(tool, "tool");
            Intrinsics.checkNotNullParameter(markupType, "markupType");
            Intrinsics.checkNotNullParameter(commentWithMentionsState, "commentWithMentionsState");
            Intrinsics.checkNotNullParameter(annotationLocationModel, "annotationLocationModel");
            this.itemId = itemId;
            this.itemVersionId = itemVersionId;
            this.additionalMarkups = additionalMarkups;
            this.pageWithAnnotation = pageInfo;
            this.currentUser = currentUser;
            this.tool = tool;
            this.markupType = markupType;
            this.color = num;
            this.commentWithMentionsState = commentWithMentionsState;
            this.annotation = annotation;
            this.isAnnotationBelowSizeLimit = z;
            this.switchingMarkupType = switchingMarkupTypeState;
            this.isSavingInProcess = z2;
            this.showPendingAnnotationWarning = z3;
            this.message = message;
            this.annotationLocationModel = annotationLocationModel;
            this.isInWritingCommentState = commentWithMentionsState.getInputBoxState() instanceof CommentWithMentionsReducer.InputBoxState.Shown;
        }

        public final ItemId getItemId() {
            return this.itemId;
        }

        public final String getItemVersionId() {
            return this.itemVersionId;
        }

        public /* synthetic */ State(ItemId itemId, String str, List list, PageInfo pageInfo, UserUIModel userUIModel, BoxAnnotationTool boxAnnotationTool, BoxAnnotationMarkupType boxAnnotationMarkupType, Integer num, CommentWithMentionsReducer.State state, Annotation annotation, boolean z, SwitchingMarkupTypeState switchingMarkupTypeState, boolean z2, boolean z3, Message message, AnnotationLocationModel annotationLocationModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(itemId, str, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : pageInfo, userUIModel, (i & 32) != 0 ? BoxAnnotationTool.MARKER : boxAnnotationTool, (i & 64) != 0 ? BoxAnnotationMarkupType.DRAW : boxAnnotationMarkupType, (i & 128) != 0 ? null : num, (i & 256) != 0 ? new CommentWithMentionsReducer.State(itemId, null, null, null, null, 30, null) : state, (i & 512) != 0 ? null : annotation, (i & 1024) != 0 ? true : z, (i & 2048) != 0 ? null : switchingMarkupTypeState, (i & 4096) != 0 ? false : z2, (i & 8192) != 0 ? false : z3, (i & 16384) != 0 ? null : message, annotationLocationModel);
        }

        public final List<BoxAnnotationMarkupType> getAdditionalMarkups() {
            return this.additionalMarkups;
        }

        public final PageInfo getPageWithAnnotation() {
            return this.pageWithAnnotation;
        }

        public final UserUIModel getCurrentUser() {
            return this.currentUser;
        }

        public final BoxAnnotationTool getTool() {
            return this.tool;
        }

        public final BoxAnnotationMarkupType getMarkupType() {
            return this.markupType;
        }

        public final Integer getColor() {
            return this.color;
        }

        public final CommentWithMentionsReducer.State getCommentWithMentionsState() {
            return this.commentWithMentionsState;
        }

        public final Annotation getAnnotation() {
            return this.annotation;
        }

        public final boolean isAnnotationBelowSizeLimit() {
            return this.isAnnotationBelowSizeLimit;
        }

        public final SwitchingMarkupTypeState getSwitchingMarkupType() {
            return this.switchingMarkupType;
        }

        public final boolean isSavingInProcess() {
            return this.isSavingInProcess;
        }

        public final boolean getShowPendingAnnotationWarning() {
            return this.showPendingAnnotationWarning;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final AnnotationLocationModel getAnnotationLocationModel() {
            return this.annotationLocationModel;
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State$Companion;", "", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX INFO: renamed from: isInWritingCommentState, reason: from getter */
        public final boolean getIsInWritingCommentState() {
            return this.isInWritingCommentState;
        }

        public final boolean hasPendingAnnotation() {
            return this.annotation != null;
        }
    }

    /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$SwitchingMarkupTypeState;", "", "markupType", "Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "confirmed", "", "<init>", "(Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;Z)V", "getMarkupType", "()Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "getConfirmed", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SwitchingMarkupTypeState {
        public static final int $stable = 0;
        private final boolean confirmed;
        private final BoxAnnotationMarkupType markupType;

        public static /* synthetic */ SwitchingMarkupTypeState copy$default(SwitchingMarkupTypeState switchingMarkupTypeState, BoxAnnotationMarkupType boxAnnotationMarkupType, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                boxAnnotationMarkupType = switchingMarkupTypeState.markupType;
            }
            if ((i & 2) != 0) {
                z = switchingMarkupTypeState.confirmed;
            }
            return switchingMarkupTypeState.copy(boxAnnotationMarkupType, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BoxAnnotationMarkupType getMarkupType() {
            return this.markupType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getConfirmed() {
            return this.confirmed;
        }

        public final SwitchingMarkupTypeState copy(BoxAnnotationMarkupType markupType, boolean confirmed) {
            Intrinsics.checkNotNullParameter(markupType, "markupType");
            return new SwitchingMarkupTypeState(markupType, confirmed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SwitchingMarkupTypeState)) {
                return false;
            }
            SwitchingMarkupTypeState switchingMarkupTypeState = (SwitchingMarkupTypeState) other;
            return this.markupType == switchingMarkupTypeState.markupType && this.confirmed == switchingMarkupTypeState.confirmed;
        }

        public int hashCode() {
            return (this.markupType.hashCode() * 31) + Boolean.hashCode(this.confirmed);
        }

        public String toString() {
            return "SwitchingMarkupTypeState(markupType=" + this.markupType + ", confirmed=" + this.confirmed + ")";
        }

        public SwitchingMarkupTypeState(BoxAnnotationMarkupType markupType, boolean z) {
            Intrinsics.checkNotNullParameter(markupType, "markupType");
            this.markupType = markupType;
            this.confirmed = z;
        }

        public /* synthetic */ SwitchingMarkupTypeState(BoxAnnotationMarkupType boxAnnotationMarkupType, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(boxAnnotationMarkupType, (i & 2) != 0 ? false : z);
        }

        public final boolean getConfirmed() {
            return this.confirmed;
        }

        public final BoxAnnotationMarkupType getMarkupType() {
            return this.markupType;
        }
    }

    /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$PageInfo;", "", FirebaseAnalytics.Param.INDEX, "", "size", "Lcom/box/android/preview/annotations/model/DocumentSize;", "<init>", "(ILcom/box/android/preview/annotations/model/DocumentSize;)V", "getIndex", "()I", "getSize", "()Lcom/box/android/preview/annotations/model/DocumentSize;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PageInfo {
        public static final int $stable = 0;
        private final int index;
        private final DocumentSize size;

        public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, int i, DocumentSize documentSize, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = pageInfo.index;
            }
            if ((i2 & 2) != 0) {
                documentSize = pageInfo.size;
            }
            return pageInfo.copy(i, documentSize);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DocumentSize getSize() {
            return this.size;
        }

        public final PageInfo copy(int index, DocumentSize size) {
            Intrinsics.checkNotNullParameter(size, "size");
            return new PageInfo(index, size);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageInfo)) {
                return false;
            }
            PageInfo pageInfo = (PageInfo) other;
            return this.index == pageInfo.index && Intrinsics.areEqual(this.size, pageInfo.size);
        }

        public int hashCode() {
            return (Integer.hashCode(this.index) * 31) + this.size.hashCode();
        }

        public String toString() {
            return "PageInfo(index=" + this.index + ", size=" + this.size + ")";
        }

        public PageInfo(int i, DocumentSize size) {
            Intrinsics.checkNotNullParameter(size, "size");
            this.index = i;
            this.size = size;
        }

        public final int getIndex() {
            return this.index;
        }

        public final DocumentSize getSize() {
            return this.size;
        }
    }

    /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00162\u00020\u0001:\u0013\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0012\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'(¨\u0006)"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "", "<init>", "()V", "SetActivePage", "UpdateTool", "UpdateMarkUpType", "UpdateColor", "UpdateCreatedAnnotation", "Commenting", "Drawing", "CommentWithMentionsAction", "AnnotationSaveSuccess", "AnnotationSaveFailed", "MessageShown", "AnnotationDrawnOutsideActivePage", "NewMarkupTypeSelected", "ExitSelected", "Exit", "ShowPendingAnnotationWarning", "RemovePendingAnnotationConfirmed", "RemovePendingAnnotationCancelled", "Companion", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$AnnotationDrawnOutsideActivePage;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$AnnotationSaveFailed;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$AnnotationSaveSuccess;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$CommentWithMentionsAction;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$Commenting;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$Drawing;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$Exit;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$ExitSelected;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$MessageShown;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$NewMarkupTypeSelected;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$RemovePendingAnnotationCancelled;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$RemovePendingAnnotationConfirmed;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$SetActivePage;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$ShowPendingAnnotationWarning;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$UpdateColor;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$UpdateCreatedAnnotation;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$UpdateMarkUpType;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$UpdateTool;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$SetActivePage;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "newPage", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$PageInfo;", "<init>", "(Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$PageInfo;)V", "getNewPage", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$PageInfo;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SetActivePage extends Action {
            public static final int $stable = 0;
            private final PageInfo newPage;

            public static /* synthetic */ SetActivePage copy$default(SetActivePage setActivePage, PageInfo pageInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    pageInfo = setActivePage.newPage;
                }
                return setActivePage.copy(pageInfo);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PageInfo getNewPage() {
                return this.newPage;
            }

            public final SetActivePage copy(PageInfo newPage) {
                return new SetActivePage(newPage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetActivePage) && Intrinsics.areEqual(this.newPage, ((SetActivePage) other).newPage);
            }

            public int hashCode() {
                PageInfo pageInfo = this.newPage;
                if (pageInfo == null) {
                    return 0;
                }
                return pageInfo.hashCode();
            }

            public String toString() {
                return "SetActivePage(newPage=" + this.newPage + ")";
            }

            public SetActivePage(PageInfo pageInfo) {
                super(null);
                this.newPage = pageInfo;
            }

            public final PageInfo getNewPage() {
                return this.newPage;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$UpdateTool;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "tool", "Lcom/box/android/preview/annotations/managers/BoxAnnotationTool;", "<init>", "(Lcom/box/android/preview/annotations/managers/BoxAnnotationTool;)V", "getTool", "()Lcom/box/android/preview/annotations/managers/BoxAnnotationTool;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateTool extends Action {
            public static final int $stable = 0;
            private final BoxAnnotationTool tool;

            public static /* synthetic */ UpdateTool copy$default(UpdateTool updateTool, BoxAnnotationTool boxAnnotationTool, int i, Object obj) {
                if ((i & 1) != 0) {
                    boxAnnotationTool = updateTool.tool;
                }
                return updateTool.copy(boxAnnotationTool);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAnnotationTool getTool() {
                return this.tool;
            }

            public final UpdateTool copy(BoxAnnotationTool tool) {
                Intrinsics.checkNotNullParameter(tool, "tool");
                return new UpdateTool(tool);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateTool) && this.tool == ((UpdateTool) other).tool;
            }

            public int hashCode() {
                return this.tool.hashCode();
            }

            public String toString() {
                return "UpdateTool(tool=" + this.tool + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateTool(BoxAnnotationTool tool) {
                super(null);
                Intrinsics.checkNotNullParameter(tool, "tool");
                this.tool = tool;
            }

            public final BoxAnnotationTool getTool() {
                return this.tool;
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$UpdateMarkUpType;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "markupType", "Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "<init>", "(Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;)V", "getMarkupType", "()Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateMarkUpType extends Action {
            public static final int $stable = 0;
            private final BoxAnnotationMarkupType markupType;

            public static /* synthetic */ UpdateMarkUpType copy$default(UpdateMarkUpType updateMarkUpType, BoxAnnotationMarkupType boxAnnotationMarkupType, int i, Object obj) {
                if ((i & 1) != 0) {
                    boxAnnotationMarkupType = updateMarkUpType.markupType;
                }
                return updateMarkUpType.copy(boxAnnotationMarkupType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAnnotationMarkupType getMarkupType() {
                return this.markupType;
            }

            public final UpdateMarkUpType copy(BoxAnnotationMarkupType markupType) {
                Intrinsics.checkNotNullParameter(markupType, "markupType");
                return new UpdateMarkUpType(markupType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateMarkUpType) && this.markupType == ((UpdateMarkUpType) other).markupType;
            }

            public int hashCode() {
                return this.markupType.hashCode();
            }

            public String toString() {
                return "UpdateMarkUpType(markupType=" + this.markupType + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateMarkUpType(BoxAnnotationMarkupType markupType) {
                super(null);
                Intrinsics.checkNotNullParameter(markupType, "markupType");
                this.markupType = markupType;
            }

            public final BoxAnnotationMarkupType getMarkupType() {
                return this.markupType;
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$UpdateColor;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "color", "", "<init>", "(I)V", "getColor", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateColor extends Action {
            public static final int $stable = 0;
            private final int color;

            public static /* synthetic */ UpdateColor copy$default(UpdateColor updateColor, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = updateColor.color;
                }
                return updateColor.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getColor() {
                return this.color;
            }

            public final UpdateColor copy(int color) {
                return new UpdateColor(color);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateColor) && this.color == ((UpdateColor) other).color;
            }

            public int hashCode() {
                return Integer.hashCode(this.color);
            }

            public String toString() {
                return "UpdateColor(color=" + this.color + ")";
            }

            public UpdateColor(int i) {
                super(null);
                this.color = i;
            }

            public final int getColor() {
                return this.color;
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$UpdateCreatedAnnotation;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "createdAnnotation", "Lcom/box/android/preview/annotations/model/Annotation;", "<init>", "(Lcom/box/android/preview/annotations/model/Annotation;)V", "getCreatedAnnotation", "()Lcom/box/android/preview/annotations/model/Annotation;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateCreatedAnnotation extends Action {
            public static final int $stable = 8;
            private final Annotation createdAnnotation;

            public static /* synthetic */ UpdateCreatedAnnotation copy$default(UpdateCreatedAnnotation updateCreatedAnnotation, Annotation annotation, int i, Object obj) {
                if ((i & 1) != 0) {
                    annotation = updateCreatedAnnotation.createdAnnotation;
                }
                return updateCreatedAnnotation.copy(annotation);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Annotation getCreatedAnnotation() {
                return this.createdAnnotation;
            }

            public final UpdateCreatedAnnotation copy(Annotation createdAnnotation) {
                return new UpdateCreatedAnnotation(createdAnnotation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateCreatedAnnotation) && Intrinsics.areEqual(this.createdAnnotation, ((UpdateCreatedAnnotation) other).createdAnnotation);
            }

            public int hashCode() {
                Annotation annotation = this.createdAnnotation;
                if (annotation == null) {
                    return 0;
                }
                return annotation.hashCode();
            }

            public String toString() {
                return "UpdateCreatedAnnotation(createdAnnotation=" + this.createdAnnotation + ")";
            }

            public UpdateCreatedAnnotation(Annotation annotation) {
                super(null);
                this.createdAnnotation = annotation;
            }

            public final Annotation getCreatedAnnotation() {
                return this.createdAnnotation;
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$Commenting;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Commenting extends Action {
            public static final int $stable = 0;
            public static final Commenting INSTANCE = new Commenting();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Commenting)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1346165824;
            }

            public String toString() {
                return "Commenting";
            }

            private Commenting() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$Drawing;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Drawing extends Action {
            public static final int $stable = 0;
            public static final Drawing INSTANCE = new Drawing();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Drawing)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 880244385;
            }

            public String toString() {
                return "Drawing";
            }

            private Drawing() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$CommentWithMentionsAction;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

            /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$CommentWithMentionsAction$Companion;", "", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$AnnotationSaveSuccess;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AnnotationSaveSuccess extends Action {
            public static final int $stable = 0;
            public static final AnnotationSaveSuccess INSTANCE = new AnnotationSaveSuccess();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AnnotationSaveSuccess)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -731694502;
            }

            public String toString() {
                return "AnnotationSaveSuccess";
            }

            private AnnotationSaveSuccess() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$AnnotationSaveFailed;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AnnotationSaveFailed extends Action {
            public static final int $stable = 0;
            public static final AnnotationSaveFailed INSTANCE = new AnnotationSaveFailed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AnnotationSaveFailed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 832860934;
            }

            public String toString() {
                return "AnnotationSaveFailed";
            }

            private AnnotationSaveFailed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$MessageShown;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MessageShown extends Action {
            public static final int $stable = 0;
            public static final MessageShown INSTANCE = new MessageShown();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MessageShown)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1312577703;
            }

            public String toString() {
                return "MessageShown";
            }

            private MessageShown() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$AnnotationDrawnOutsideActivePage;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AnnotationDrawnOutsideActivePage extends Action {
            public static final int $stable = 0;
            public static final AnnotationDrawnOutsideActivePage INSTANCE = new AnnotationDrawnOutsideActivePage();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AnnotationDrawnOutsideActivePage)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -668485476;
            }

            public String toString() {
                return "AnnotationDrawnOutsideActivePage";
            }

            private AnnotationDrawnOutsideActivePage() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$NewMarkupTypeSelected;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "markupType", "Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "<init>", "(Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;)V", "getMarkupType", "()Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NewMarkupTypeSelected extends Action {
            public static final int $stable = 0;
            private final BoxAnnotationMarkupType markupType;

            public static /* synthetic */ NewMarkupTypeSelected copy$default(NewMarkupTypeSelected newMarkupTypeSelected, BoxAnnotationMarkupType boxAnnotationMarkupType, int i, Object obj) {
                if ((i & 1) != 0) {
                    boxAnnotationMarkupType = newMarkupTypeSelected.markupType;
                }
                return newMarkupTypeSelected.copy(boxAnnotationMarkupType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAnnotationMarkupType getMarkupType() {
                return this.markupType;
            }

            public final NewMarkupTypeSelected copy(BoxAnnotationMarkupType markupType) {
                Intrinsics.checkNotNullParameter(markupType, "markupType");
                return new NewMarkupTypeSelected(markupType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NewMarkupTypeSelected) && this.markupType == ((NewMarkupTypeSelected) other).markupType;
            }

            public int hashCode() {
                return this.markupType.hashCode();
            }

            public String toString() {
                return "NewMarkupTypeSelected(markupType=" + this.markupType + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NewMarkupTypeSelected(BoxAnnotationMarkupType markupType) {
                super(null);
                Intrinsics.checkNotNullParameter(markupType, "markupType");
                this.markupType = markupType;
            }

            public final BoxAnnotationMarkupType getMarkupType() {
                return this.markupType;
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$ExitSelected;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ExitSelected extends Action {
            public static final int $stable = 0;
            public static final ExitSelected INSTANCE = new ExitSelected();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ExitSelected)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 467593526;
            }

            public String toString() {
                return "ExitSelected";
            }

            private ExitSelected() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$Exit;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Exit extends Action {
            public static final int $stable = 0;
            public static final Exit INSTANCE = new Exit();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Exit)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1884668549;
            }

            public String toString() {
                return "Exit";
            }

            private Exit() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$ShowPendingAnnotationWarning;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowPendingAnnotationWarning extends Action {
            public static final int $stable = 0;
            public static final ShowPendingAnnotationWarning INSTANCE = new ShowPendingAnnotationWarning();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowPendingAnnotationWarning)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1227294224;
            }

            public String toString() {
                return "ShowPendingAnnotationWarning";
            }

            private ShowPendingAnnotationWarning() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$RemovePendingAnnotationConfirmed;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RemovePendingAnnotationConfirmed extends Action {
            public static final int $stable = 0;
            public static final RemovePendingAnnotationConfirmed INSTANCE = new RemovePendingAnnotationConfirmed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RemovePendingAnnotationConfirmed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 569666650;
            }

            public String toString() {
                return "RemovePendingAnnotationConfirmed";
            }

            private RemovePendingAnnotationConfirmed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CreateAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action$RemovePendingAnnotationCancelled;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RemovePendingAnnotationCancelled extends Action {
            public static final int $stable = 0;
            public static final RemovePendingAnnotationCancelled INSTANCE = new RemovePendingAnnotationCancelled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RemovePendingAnnotationCancelled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1850364492;
            }

            public String toString() {
                return "RemovePendingAnnotationCancelled";
            }

            private RemovePendingAnnotationCancelled() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:9:0x0039  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ReducerResult build$lambda$0(CreateAnnotationReducer createAnnotationReducer, State state, Action action) throws InterruptedException {
        AnnotationLocationModel.Page annotationLocationModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 2;
        InputBoxValue inputBoxValue = null;
        Object[] objArr = 0;
        if (action instanceof Action.SetActivePage) {
            if (state.getAnnotationLocationModel() instanceof AnnotationLocationModel.Page) {
                Action.SetActivePage setActivePage = (Action.SetActivePage) action;
                if (setActivePage.getNewPage() != null) {
                    annotationLocationModel = new AnnotationLocationModel.Page(setActivePage.getNewPage().getIndex() + 1);
                } else {
                    annotationLocationModel = state.getAnnotationLocationModel();
                }
            } else {
                annotationLocationModel = state.getAnnotationLocationModel();
            }
            return new ReducerResult(State.copy$default(state, null, null, null, ((Action.SetActivePage) action).getNewPage(), null, null, null, null, null, null, false, null, false, false, null, annotationLocationModel, 32759, null), null, 2, null);
        }
        if (action instanceof Action.AnnotationDrawnOutsideActivePage) {
            if (state.getMarkupType() == BoxAnnotationMarkupType.DRAW) {
                CreateAnnotationsManager createAnnotationManager = createAnnotationReducer.environment.getAnnotationManagersProvider().getCreateAnnotationManager(state.getItemId());
                PageInfo pageWithAnnotation = state.getPageWithAnnotation();
                Intrinsics.checkNotNull(pageWithAnnotation);
                createAnnotationManager.removeAnnotationsNotOnPage(pageWithAnnotation.getIndex());
                return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, null, false, false, Message.AnnotationDrawnOutsideActivePage, null, 49151, null), null, 2, null);
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.UpdateTool) {
            Action.UpdateTool updateTool = (Action.UpdateTool) action;
            createAnnotationReducer.environment.getAnnotationManagersProvider().getCreateAnnotationManager(state.getItemId()).setDrawingTool(updateTool.getTool());
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, updateTool.getTool(), null, null, null, null, false, null, false, false, null, null, 65503, null), null, 2, null);
        }
        if (action instanceof Action.UpdateMarkUpType) {
            Action.UpdateMarkUpType updateMarkUpType = (Action.UpdateMarkUpType) action;
            createAnnotationReducer.environment.getAnnotationManagersProvider().getCreateAnnotationManager(state.getItemId()).switchMarkupMode(updateMarkUpType.getMarkupType());
            if (updateMarkUpType.getMarkupType() == BoxAnnotationMarkupType.DRAW) {
                createAnnotationReducer.environment.getAnnotationManagersProvider().getCreateAnnotationManager(state.getItemId()).setDrawingTool(state.getTool());
            }
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, updateMarkUpType.getMarkupType(), null, null, null, false, null, false, false, null, null, 63423, null), null, 2, null);
        }
        if (action instanceof Action.UpdateColor) {
            Action.UpdateColor updateColor = (Action.UpdateColor) action;
            createAnnotationReducer.environment.getAnnotationManagersProvider().getCreateAnnotationManager(state.getItemId()).setColor(updateColor.getColor(), state.getTool());
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, Integer.valueOf(updateColor.getColor()), null, null, false, null, false, false, null, null, 65407, null), null, 2, null);
        }
        if (action instanceof Action.Commenting) {
            return new ReducerResult(state, Effect.INSTANCE.merge(createAnnotationReducer.updateInputBox(Action.CommentWithMentionsAction.INSTANCE, new CommentWithMentionsReducer.InputBoxState.Shown(CommentWithMentionsReducer.InputBoxState.InputBoxType.COMMENT, inputBoxValue, i, objArr == true ? 1 : 0)), new Action.CommentWithMentionsAction(CommentWithMentionsReducer.Action.ShowKeyboard.INSTANCE)));
        }
        if (action instanceof Action.Drawing) {
            return new ReducerResult(state, new Effect(createAnnotationReducer.updateInputBox(Action.CommentWithMentionsAction.INSTANCE, CommentWithMentionsReducer.InputBoxState.Hidden.INSTANCE)));
        }
        if (action instanceof Action.CommentWithMentionsAction) {
            if (((Action.CommentWithMentionsAction) action).getAction() instanceof CommentWithMentionsReducer.Action.SubmitCommentClicked) {
                return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, null, true, false, null, null, 61439, null), new Effect((Function1) new CreateAnnotationReducer$build$1$1(createAnnotationReducer, state, null)));
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.AnnotationSaveSuccess) {
            createAnnotationReducer.environment.getAnnotationManagersProvider().getCreateAnnotationManager(state.getItemId()).removePendingAnnotations();
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, null, false, false, Message.SaveSuccess, null, 44543, null), new Effect(createAnnotationReducer.updateInputBox(Action.CommentWithMentionsAction.INSTANCE, CommentWithMentionsReducer.InputBoxState.Hidden.INSTANCE)));
        }
        if (action instanceof Action.AnnotationSaveFailed) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, null, false, false, Message.SaveFailed, null, 45055, null), null, 2, null);
        }
        if (action instanceof Action.MessageShown) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, null, false, false, null, null, 49151, null), null, 2, null);
        }
        if (action instanceof Action.UpdateCreatedAnnotation) {
            Action.UpdateCreatedAnnotation updateCreatedAnnotation = (Action.UpdateCreatedAnnotation) action;
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, updateCreatedAnnotation.getCreatedAnnotation(), createAnnotationReducer.isBelowSizeLimit(updateCreatedAnnotation.getCreatedAnnotation(), state), null, false, false, null, null, 63999, null), null, 2, null);
        }
        if (action instanceof Action.NewMarkupTypeSelected) {
            if (!state.hasPendingAnnotation()) {
                return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, new SwitchingMarkupTypeState(((Action.NewMarkupTypeSelected) action).getMarkupType(), true), false, false, null, null, 63487, null), null, 2, null);
            }
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, new SwitchingMarkupTypeState(((Action.NewMarkupTypeSelected) action).getMarkupType(), false), false, false, null, null, 63487, null), new Effect(Action.ShowPendingAnnotationWarning.INSTANCE));
        }
        if (action instanceof Action.ExitSelected) {
            if (!state.hasPendingAnnotation()) {
                return new ReducerResult(state, new Effect(Action.Exit.INSTANCE));
            }
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, new SwitchingMarkupTypeState(BoxAnnotationMarkupType.NONE, false), false, false, null, null, 63487, null), new Effect(Action.ShowPendingAnnotationWarning.INSTANCE));
        }
        if (action instanceof Action.ShowPendingAnnotationWarning) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, null, false, true, null, null, GeneratorBase.SURR2_LAST, null), null, 2, null);
        }
        if (action instanceof Action.RemovePendingAnnotationConfirmed) {
            SwitchingMarkupTypeState switchingMarkupType = state.getSwitchingMarkupType();
            BoxAnnotationMarkupType markupType = switchingMarkupType != null ? switchingMarkupType.getMarkupType() : null;
            int i2 = markupType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[markupType.ordinal()];
            if (i2 == -1) {
                return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, null, false, false, null, null, GeneratorBase.SURR2_LAST, null), null, 2, null);
            }
            if (i2 == 1) {
                return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, null, false, false, null, null, GeneratorBase.SURR2_LAST, null), new Effect(Action.Exit.INSTANCE));
            }
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, new SwitchingMarkupTypeState(state.getSwitchingMarkupType().getMarkupType(), true), false, false, null, null, 55295, null), null, 2, null);
        }
        if (action instanceof Action.RemovePendingAnnotationCancelled) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, null, null, null, null, null, false, null, false, false, null, null, 55295, null), null, 2, null);
        }
        if (!(action instanceof Action.Exit)) {
            throw new NoWhenBranchMatchedException();
        }
        createAnnotationReducer.environment.getAnnotationManagersProvider().getCreateAnnotationManager(state.getItemId()).removePendingAnnotations();
        createAnnotationReducer.environment.getAnnotationManagersProvider().getCreateAnnotationManager(state.getItemId()).exitAnnotationMarkupMode();
        return new ReducerResult(state, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createAnnotation(State state, Continuation<? super Result<FileActivityModel.AnnotationModel, ? extends DomainError>> continuation) {
        CreateAnnotationInteractor createAnnotationInteractor = this.environment.getCreateAnnotationInteractor();
        String itemVersionId = state.getItemVersionId();
        ItemId itemId = state.getItemId();
        CommentWithMentionsReducer.InputBoxState inputBoxState = state.getCommentWithMentionsState().getInputBoxState();
        Intrinsics.checkNotNull(inputBoxState, "null cannot be cast to non-null type com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer.InputBoxState.Shown");
        String taggedString = CommentBarInputBoxKt.toTaggedString(((CommentWithMentionsReducer.InputBoxState.Shown) inputBoxState).getInputBoxValue(), state.getCommentWithMentionsState().getTimestampedCommentConfig());
        PdfAnnotationModelMapper pdfAnnotationModelMapper = this.environment.getPdfAnnotationModelMapper();
        Annotation annotation = state.getAnnotation();
        PageInfo pageWithAnnotation = state.getPageWithAnnotation();
        Intrinsics.checkNotNull(pageWithAnnotation);
        AnnotationTargetModel annotationTargetModel = pdfAnnotationModelMapper.toAnnotationTargetModel(annotation, pageWithAnnotation.getSize());
        Intrinsics.checkNotNull(annotationTargetModel);
        return createAnnotationInteractor.create(itemVersionId, itemId, taggedString, annotationTargetModel, state.getAnnotationLocationModel(), continuation);
    }

    private final boolean isBelowSizeLimit(Annotation annotation, State state) {
        boolean zAreEqual = false;
        if (annotation != null) {
            PdfAnnotationModelMapper pdfAnnotationModelMapper = this.environment.getPdfAnnotationModelMapper();
            PageInfo pageWithAnnotation = state.getPageWithAnnotation();
            Intrinsics.checkNotNull(pageWithAnnotation);
            AnnotationTargetModel annotationTargetModel = pdfAnnotationModelMapper.toAnnotationTargetModel(annotation, pageWithAnnotation.getSize());
            zAreEqual = Intrinsics.areEqual((Object) (annotationTargetModel != null ? Boolean.valueOf(this.environment.getCreateAnnotationInteractor().isSizeNotAboveLimit(annotationTargetModel)) : null), (Object) false);
        }
        return !zAreEqual;
    }

    private final Action.CommentWithMentionsAction updateInputBox(Action.CommentWithMentionsAction.Companion companion, CommentWithMentionsReducer.InputBoxState inputBoxState) {
        return new Action.CommentWithMentionsAction(new CommentWithMentionsReducer.Action.UpdateInputBoxState(inputBoxState));
    }
}
