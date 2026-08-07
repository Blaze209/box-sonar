package com.box.android.boxai.qa;

import com.box.android.base.presentation.components.CopyTextReducer;
import com.box.android.boxai.BoxAiEnvironment;
import com.box.android.boxai.citations.BoxAiCitationsReducer;
import com.box.android.boxai.clearchat.BoxAiClearChatReducer;
import com.box.android.boxai.prompt.BoxAiPromptReducer;
import com.box.android.common.extensions.StringExtensionsKt;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.Combine;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import com.box.android.domain.metrics.boxai.BoxAiObservability;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.boxai.AiAnswerStreamingModel;
import com.box.android.domain.models.boxai.AiCitationModel;
import com.box.android.domain.models.boxai.AiFileType;
import com.box.android.domain.models.boxai.AiUnavailabilityReason;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IBoxAiService;
import com.box.android.domain.utils.result.Result;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BoxAiQaReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0007!\"#$%&'B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J4\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000eH\u0002J6\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t*\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\tH\u0002J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0019H\u0002J$\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J$\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J$\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006("}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$State;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "environment", "Lcom/box/android/boxai/BoxAiEnvironment;", "<init>", "(Lcom/box/android/boxai/BoxAiEnvironment;)V", "modifyItemIfPresent", "", "Lcom/box/android/boxai/qa/BoxAiQaReducer$DialogueItem;", "promptId", "", Gen204FileActivityEventLogger.ACTION_MODIFY, "Lkotlin/Function1;", "appendToItemIfPresent", "text", "citations", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "handleGetAnswer", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$GetAnswer;", "handleSubmitFeedback", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$SubmitFeedback;", "reduceAnalytics", "reduceObservability", "reduceQaAiAction", "build", "Lcom/box/android/cpl/reducers/Combine;", "getBuild", "()Lcom/box/android/cpl/reducers/Combine;", "State", "AiResponse", "DialogueItem", "SuggestedQuestionSet", "AnswerFeedback", "Action", "Companion", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiQaReducer implements Reducable<State, Action> {
    private static final String GET_ANSWER_EFFECT_ID = "GET_ANSWER_EFFECT_ID";
    private final Combine<State, Action> build;
    private final BoxAiEnvironment environment;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;", "", "<init>", "(Ljava/lang/String;I)V", "POSITIVE", "NEGATIVE", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum AnswerFeedback {
        POSITIVE,
        NEGATIVE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<AnswerFeedback> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$SuggestedQuestionSet;", "", "<init>", "(Ljava/lang/String;I)V", "DOCUMENT_QUESTIONS", "IMAGE_QUESTIONS", "MULTIDOC_QUESTIONS", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum SuggestedQuestionSet {
        DOCUMENT_QUESTIONS,
        IMAGE_QUESTIONS,
        MULTIDOC_QUESTIONS;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<SuggestedQuestionSet> getEntries() {
            return $ENTRIES;
        }
    }

    public BoxAiQaReducer(BoxAiEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new BoxAiQaReducer$build$1(this));
        final BoxAiQaReducer$build$2 boxAiQaReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BoxAiQaReducer.State) obj).getPromptInputState();
            }
        };
        final BoxAiQaReducer$build$3 boxAiQaReducer$build$3 = BoxAiQaReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new BoxAiPromptReducer(environment), new Function1<State, BoxAiPromptReducer.State>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.boxai.prompt.BoxAiPromptReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiPromptReducer.State invoke(BoxAiQaReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return boxAiQaReducer$build$2.invoke(it);
            }
        }, new Function1<Action, BoxAiPromptReducer.Action>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiPromptReducer.Action invoke(BoxAiQaReducer.Action action) {
                if (!(action instanceof BoxAiQaReducer.Action.PromptInputAction)) {
                    action = null;
                }
                BoxAiQaReducer.Action.PromptInputAction promptInputAction = (BoxAiQaReducer.Action.PromptInputAction) action;
                if (promptInputAction != null) {
                    return promptInputAction.getState();
                }
                return null;
            }
        }, new Function2<State, BoxAiPromptReducer.State, State>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final BoxAiQaReducer.State invoke(BoxAiQaReducer.State parentState, BoxAiPromptReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = boxAiQaReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(BoxAiQaReducer.State.class)).iterator();
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
                            return (BoxAiQaReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.qa.BoxAiQaReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BoxAiPromptReducer.Action, Action>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BoxAiQaReducer.Action invoke(BoxAiPromptReducer.Action action) {
                Object objInvoke = boxAiQaReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (BoxAiQaReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.qa.BoxAiQaReducer.Action");
            }
        });
        final BoxAiQaReducer$build$5 boxAiQaReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BoxAiQaReducer.State) obj).getCopyTextState();
            }
        };
        final BoxAiQaReducer$build$6 boxAiQaReducer$build$6 = BoxAiQaReducer$build$6.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new CopyTextReducer(environment.getClipboardService()), new Function1<State, CopyTextReducer.State>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.CopyTextReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CopyTextReducer.State invoke(BoxAiQaReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return boxAiQaReducer$build$5.invoke(it);
            }
        }, new Function1<Action, CopyTextReducer.Action>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final CopyTextReducer.Action invoke(BoxAiQaReducer.Action action) {
                if (!(action instanceof BoxAiQaReducer.Action.CopyTextAction)) {
                    action = null;
                }
                BoxAiQaReducer.Action.CopyTextAction copyTextAction = (BoxAiQaReducer.Action.CopyTextAction) action;
                if (copyTextAction != null) {
                    return copyTextAction.getState();
                }
                return null;
            }
        }, new Function2<State, CopyTextReducer.State, State>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final BoxAiQaReducer.State invoke(BoxAiQaReducer.State parentState, CopyTextReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = boxAiQaReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(BoxAiQaReducer.State.class)).iterator();
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
                            return (BoxAiQaReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.qa.BoxAiQaReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CopyTextReducer.Action, Action>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BoxAiQaReducer.Action invoke(CopyTextReducer.Action action) {
                Object objInvoke = boxAiQaReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (BoxAiQaReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.qa.BoxAiQaReducer.Action");
            }
        });
        final BoxAiQaReducer$build$8 boxAiQaReducer$build$8 = new PropertyReference1Impl() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$build$8
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BoxAiQaReducer.State) obj).getCitationsState();
            }
        };
        final BoxAiQaReducer$build$9 boxAiQaReducer$build$9 = BoxAiQaReducer$build$9.INSTANCE;
        IfLetReducer ifLetReducer3 = new IfLetReducer(ifLetReducer2, new BoxAiCitationsReducer(), new Function1<State, BoxAiCitationsReducer.State>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$9
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.boxai.citations.BoxAiCitationsReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiCitationsReducer.State invoke(BoxAiQaReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return boxAiQaReducer$build$8.invoke(it);
            }
        }, new Function1<Action, BoxAiCitationsReducer.Action>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$10
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiCitationsReducer.Action invoke(BoxAiQaReducer.Action action) {
                if (!(action instanceof BoxAiQaReducer.Action.CitationAction)) {
                    action = null;
                }
                BoxAiQaReducer.Action.CitationAction citationAction = (BoxAiQaReducer.Action.CitationAction) action;
                if (citationAction != null) {
                    return citationAction.getState();
                }
                return null;
            }
        }, new Function2<State, BoxAiCitationsReducer.State, State>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$11
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final BoxAiQaReducer.State invoke(BoxAiQaReducer.State parentState, BoxAiCitationsReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = boxAiQaReducer$build$8;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(BoxAiQaReducer.State.class)).iterator();
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
                            return (BoxAiQaReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.qa.BoxAiQaReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BoxAiCitationsReducer.Action, Action>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BoxAiQaReducer.Action invoke(BoxAiCitationsReducer.Action action) {
                Object objInvoke = boxAiQaReducer$build$9.invoke(action);
                if (objInvoke != null) {
                    return (BoxAiQaReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.qa.BoxAiQaReducer.Action");
            }
        });
        final BoxAiQaReducer$build$11 boxAiQaReducer$build$11 = new PropertyReference1Impl() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$build$11
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BoxAiQaReducer.State) obj).getClearChatState();
            }
        };
        final BoxAiQaReducer$build$12 boxAiQaReducer$build$12 = BoxAiQaReducer$build$12.INSTANCE;
        this.build = new Combine<>(new IfLetReducer(ifLetReducer3, new BoxAiClearChatReducer(), new Function1<State, BoxAiClearChatReducer.State>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$13
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.boxai.clearchat.BoxAiClearChatReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiClearChatReducer.State invoke(BoxAiQaReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return boxAiQaReducer$build$11.invoke(it);
            }
        }, new Function1<Action, BoxAiClearChatReducer.Action>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$14
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiClearChatReducer.Action invoke(BoxAiQaReducer.Action action) {
                if (!(action instanceof BoxAiQaReducer.Action.ClearChatAction)) {
                    action = null;
                }
                BoxAiQaReducer.Action.ClearChatAction clearChatAction = (BoxAiQaReducer.Action.ClearChatAction) action;
                if (clearChatAction != null) {
                    return clearChatAction.getState();
                }
                return null;
            }
        }, new Function2<State, BoxAiClearChatReducer.State, State>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$15
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final BoxAiQaReducer.State invoke(BoxAiQaReducer.State parentState, BoxAiClearChatReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = boxAiQaReducer$build$11;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(BoxAiQaReducer.State.class)).iterator();
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
                            return (BoxAiQaReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.qa.BoxAiQaReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BoxAiClearChatReducer.Action, Action>() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$special$$inlined$scope$16
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BoxAiQaReducer.Action invoke(BoxAiClearChatReducer.Action action) {
                Object objInvoke = boxAiQaReducer$build$12.invoke(action);
                if (objInvoke != null) {
                    return (BoxAiQaReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.qa.BoxAiQaReducer.Action");
            }
        }), new Reduce(new BoxAiQaReducer$build$14(this)), new Reduce(new BoxAiQaReducer$build$15(this)));
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001B»\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010A\u001a\u0004\u0018\u00010\u00142\u0006\u0010B\u001a\u00020\nJ\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001b\u0010D\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003HÆ\u0003J\t\u0010E\u001a\u00020\nHÆ\u0003J\t\u0010F\u001a\u00020\fHÆ\u0003J\t\u0010G\u001a\u00020\fHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010I\u001a\u00020\u0010HÆ\u0003J\t\u0010J\u001a\u00020\u0012HÆ\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0016HÆ\u0003J\t\u0010M\u001a\u00020\u0018HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010O\u001a\u00020\fHÆ\u0003J\t\u0010P\u001a\u00020\fHÆ\u0003J\t\u0010Q\u001a\u00020\fHÆ\u0003JÁ\u0001\u0010R\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\fHÆ\u0001J\u0013\u0010S\u001a\u00020\f2\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010U\u001a\u000204HÖ\u0001J\t\u0010V\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010$R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0011\u0010\u001a\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0011\u0010\u001b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0011\u0010\u001c\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0011\u00103\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b5\u00106R\u0011\u00107\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b8\u0010$R\u0011\u00109\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0011\u0010;\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u0011\u0010=\u001a\u00020>8F¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006W"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$State;", "", "fileModels", "", "Lcom/box/android/domain/models/item/FileModel;", "unsupportedItems", "Lkotlin/Pair;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/boxai/AiUnavailabilityReason;", "itemSession", "", "isMultidoc", "", "isItemSearchable", "contextSession", "promptInputState", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$State;", "copyTextState", "Lcom/box/android/base/presentation/components/CopyTextReducer$State;", "dialogueHistory", "Lcom/box/android/boxai/qa/BoxAiQaReducer$DialogueItem;", "citationsState", "Lcom/box/android/boxai/citations/BoxAiCitationsReducer$State;", "clearChatState", "Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$State;", "agentId", "shouldShowFeedbackSubmitted", "showFileListSheet", "showPromptLibraryButton", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZZLjava/lang/String;Lcom/box/android/boxai/prompt/BoxAiPromptReducer$State;Lcom/box/android/base/presentation/components/CopyTextReducer$State;Ljava/util/List;Lcom/box/android/boxai/citations/BoxAiCitationsReducer$State;Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$State;Ljava/lang/String;ZZZ)V", "getFileModels", "()Ljava/util/List;", "getUnsupportedItems", "getItemSession", "()Ljava/lang/String;", "()Z", "getContextSession", "getPromptInputState", "()Lcom/box/android/boxai/prompt/BoxAiPromptReducer$State;", "getCopyTextState", "()Lcom/box/android/base/presentation/components/CopyTextReducer$State;", "getDialogueHistory", "getCitationsState", "()Lcom/box/android/boxai/citations/BoxAiCitationsReducer$State;", "getClearChatState", "()Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$State;", "getAgentId", "getShouldShowFeedbackSubmitted", "getShowFileListSheet", "getShowPromptLibraryButton", "totalFileCount", "", "getTotalFileCount", "()I", "hasUnsupportedFiles", "getHasUnsupportedFiles", "hasChatHistory", "getHasChatHistory", "hasRequestInProgress", "getHasRequestInProgress", "suggestedQuestionSet", "Lcom/box/android/boxai/qa/BoxAiQaReducer$SuggestedQuestionSet;", "getSuggestedQuestionSet", "()Lcom/box/android/boxai/qa/BoxAiQaReducer$SuggestedQuestionSet;", "getDialogueItem", "promptId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final String agentId;
        private final BoxAiCitationsReducer.State citationsState;
        private final BoxAiClearChatReducer.State clearChatState;
        private final String contextSession;
        private final CopyTextReducer.State copyTextState;
        private final List<DialogueItem> dialogueHistory;
        private final List<FileModel> fileModels;
        private final boolean hasChatHistory;
        private final boolean hasRequestInProgress;
        private final boolean isItemSearchable;
        private final boolean isMultidoc;
        private final String itemSession;
        private final BoxAiPromptReducer.State promptInputState;
        private final boolean shouldShowFeedbackSubmitted;
        private final boolean showFileListSheet;
        private final boolean showPromptLibraryButton;
        private final List<Pair<ItemModel, AiUnavailabilityReason>> unsupportedItems;

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AiFileType.values().length];
                try {
                    iArr[AiFileType.IMAGE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, List list2, String str, boolean z, boolean z2, String str2, BoxAiPromptReducer.State state2, CopyTextReducer.State state3, List list3, BoxAiCitationsReducer.State state4, BoxAiClearChatReducer.State state5, String str3, boolean z3, boolean z4, boolean z5, int i, Object obj) {
            return state.copy((i & 1) != 0 ? state.fileModels : list, (i & 2) != 0 ? state.unsupportedItems : list2, (i & 4) != 0 ? state.itemSession : str, (i & 8) != 0 ? state.isMultidoc : z, (i & 16) != 0 ? state.isItemSearchable : z2, (i & 32) != 0 ? state.contextSession : str2, (i & 64) != 0 ? state.promptInputState : state2, (i & 128) != 0 ? state.copyTextState : state3, (i & 256) != 0 ? state.dialogueHistory : list3, (i & 512) != 0 ? state.citationsState : state4, (i & 1024) != 0 ? state.clearChatState : state5, (i & 2048) != 0 ? state.agentId : str3, (i & 4096) != 0 ? state.shouldShowFeedbackSubmitted : z3, (i & 8192) != 0 ? state.showFileListSheet : z4, (i & 16384) != 0 ? state.showPromptLibraryButton : z5);
        }

        public final List<FileModel> component1() {
            return this.fileModels;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final BoxAiCitationsReducer.State getCitationsState() {
            return this.citationsState;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final BoxAiClearChatReducer.State getClearChatState() {
            return this.clearChatState;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getAgentId() {
            return this.agentId;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final boolean getShouldShowFeedbackSubmitted() {
            return this.shouldShowFeedbackSubmitted;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final boolean getShowFileListSheet() {
            return this.showFileListSheet;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final boolean getShowPromptLibraryButton() {
            return this.showPromptLibraryButton;
        }

        public final List<Pair<ItemModel, AiUnavailabilityReason>> component2() {
            return this.unsupportedItems;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getItemSession() {
            return this.itemSession;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsMultidoc() {
            return this.isMultidoc;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsItemSearchable() {
            return this.isItemSearchable;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getContextSession() {
            return this.contextSession;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final BoxAiPromptReducer.State getPromptInputState() {
            return this.promptInputState;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final CopyTextReducer.State getCopyTextState() {
            return this.copyTextState;
        }

        public final List<DialogueItem> component9() {
            return this.dialogueHistory;
        }

        public final State copy(List<FileModel> fileModels, List<? extends Pair<? extends ItemModel, ? extends AiUnavailabilityReason>> unsupportedItems, String itemSession, boolean isMultidoc, boolean isItemSearchable, String contextSession, BoxAiPromptReducer.State promptInputState, CopyTextReducer.State copyTextState, List<DialogueItem> dialogueHistory, BoxAiCitationsReducer.State citationsState, BoxAiClearChatReducer.State clearChatState, String agentId, boolean shouldShowFeedbackSubmitted, boolean showFileListSheet, boolean showPromptLibraryButton) {
            Intrinsics.checkNotNullParameter(fileModels, "fileModels");
            Intrinsics.checkNotNullParameter(unsupportedItems, "unsupportedItems");
            Intrinsics.checkNotNullParameter(itemSession, "itemSession");
            Intrinsics.checkNotNullParameter(promptInputState, "promptInputState");
            Intrinsics.checkNotNullParameter(copyTextState, "copyTextState");
            Intrinsics.checkNotNullParameter(dialogueHistory, "dialogueHistory");
            Intrinsics.checkNotNullParameter(citationsState, "citationsState");
            Intrinsics.checkNotNullParameter(clearChatState, "clearChatState");
            return new State(fileModels, unsupportedItems, itemSession, isMultidoc, isItemSearchable, contextSession, promptInputState, copyTextState, dialogueHistory, citationsState, clearChatState, agentId, shouldShowFeedbackSubmitted, showFileListSheet, showPromptLibraryButton);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.fileModels, state.fileModels) && Intrinsics.areEqual(this.unsupportedItems, state.unsupportedItems) && Intrinsics.areEqual(this.itemSession, state.itemSession) && this.isMultidoc == state.isMultidoc && this.isItemSearchable == state.isItemSearchable && Intrinsics.areEqual(this.contextSession, state.contextSession) && Intrinsics.areEqual(this.promptInputState, state.promptInputState) && Intrinsics.areEqual(this.copyTextState, state.copyTextState) && Intrinsics.areEqual(this.dialogueHistory, state.dialogueHistory) && Intrinsics.areEqual(this.citationsState, state.citationsState) && Intrinsics.areEqual(this.clearChatState, state.clearChatState) && Intrinsics.areEqual(this.agentId, state.agentId) && this.shouldShowFeedbackSubmitted == state.shouldShowFeedbackSubmitted && this.showFileListSheet == state.showFileListSheet && this.showPromptLibraryButton == state.showPromptLibraryButton;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.fileModels.hashCode() * 31) + this.unsupportedItems.hashCode()) * 31) + this.itemSession.hashCode()) * 31) + Boolean.hashCode(this.isMultidoc)) * 31) + Boolean.hashCode(this.isItemSearchable)) * 31;
            String str = this.contextSession;
            int iHashCode2 = (((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.promptInputState.hashCode()) * 31) + this.copyTextState.hashCode()) * 31) + this.dialogueHistory.hashCode()) * 31) + this.citationsState.hashCode()) * 31) + this.clearChatState.hashCode()) * 31;
            String str2 = this.agentId;
            return ((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.shouldShowFeedbackSubmitted)) * 31) + Boolean.hashCode(this.showFileListSheet)) * 31) + Boolean.hashCode(this.showPromptLibraryButton);
        }

        public String toString() {
            return "State(fileModels=" + this.fileModels + ", unsupportedItems=" + this.unsupportedItems + ", itemSession=" + this.itemSession + ", isMultidoc=" + this.isMultidoc + ", isItemSearchable=" + this.isItemSearchable + ", contextSession=" + this.contextSession + ", promptInputState=" + this.promptInputState + ", copyTextState=" + this.copyTextState + ", dialogueHistory=" + this.dialogueHistory + ", citationsState=" + this.citationsState + ", clearChatState=" + this.clearChatState + ", agentId=" + this.agentId + ", shouldShowFeedbackSubmitted=" + this.shouldShowFeedbackSubmitted + ", showFileListSheet=" + this.showFileListSheet + ", showPromptLibraryButton=" + this.showPromptLibraryButton + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(List<FileModel> fileModels, List<? extends Pair<? extends ItemModel, ? extends AiUnavailabilityReason>> unsupportedItems, String itemSession, boolean z, boolean z2, String str, BoxAiPromptReducer.State promptInputState, CopyTextReducer.State copyTextState, List<DialogueItem> dialogueHistory, BoxAiCitationsReducer.State citationsState, BoxAiClearChatReducer.State clearChatState, String str2, boolean z3, boolean z4, boolean z5) {
            Intrinsics.checkNotNullParameter(fileModels, "fileModels");
            Intrinsics.checkNotNullParameter(unsupportedItems, "unsupportedItems");
            Intrinsics.checkNotNullParameter(itemSession, "itemSession");
            Intrinsics.checkNotNullParameter(promptInputState, "promptInputState");
            Intrinsics.checkNotNullParameter(copyTextState, "copyTextState");
            Intrinsics.checkNotNullParameter(dialogueHistory, "dialogueHistory");
            Intrinsics.checkNotNullParameter(citationsState, "citationsState");
            Intrinsics.checkNotNullParameter(clearChatState, "clearChatState");
            this.fileModels = fileModels;
            this.unsupportedItems = unsupportedItems;
            this.itemSession = itemSession;
            this.isMultidoc = z;
            this.isItemSearchable = z2;
            this.contextSession = str;
            this.promptInputState = promptInputState;
            this.copyTextState = copyTextState;
            this.dialogueHistory = dialogueHistory;
            this.citationsState = citationsState;
            this.clearChatState = clearChatState;
            this.agentId = str2;
            this.shouldShowFeedbackSubmitted = z3;
            this.showFileListSheet = z4;
            this.showPromptLibraryButton = z5;
            boolean zIsEmpty = dialogueHistory.isEmpty();
            this.hasChatHistory = !zIsEmpty;
            this.hasRequestInProgress = !zIsEmpty && ((DialogueItem) CollectionsKt.last((List) dialogueHistory)).getResponse() == null;
        }

        public final List<FileModel> getFileModels() {
            return this.fileModels;
        }

        public /* synthetic */ State(List list, List list2, String str, boolean z, boolean z2, String str2, BoxAiPromptReducer.State state, CopyTextReducer.State state2, List list3, BoxAiCitationsReducer.State state3, BoxAiClearChatReducer.State state4, String str3, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, str, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? new BoxAiPromptReducer.State(false, null, null, null, 15, null) : state, (i & 128) != 0 ? new CopyTextReducer.State(false, false, 3, null) : state2, (i & 256) != 0 ? CollectionsKt.emptyList() : list3, (i & 512) != 0 ? new BoxAiCitationsReducer.State(false, false, null, 7, null) : state3, (i & 1024) != 0 ? new BoxAiClearChatReducer.State(false, false, 3, null) : state4, (i & 2048) != 0 ? null : str3, (i & 4096) != 0 ? false : z3, (i & 8192) != 0 ? false : z4, (i & 16384) != 0 ? false : z5);
        }

        public final List<Pair<ItemModel, AiUnavailabilityReason>> getUnsupportedItems() {
            return this.unsupportedItems;
        }

        public final String getItemSession() {
            return this.itemSession;
        }

        public final boolean isMultidoc() {
            return this.isMultidoc;
        }

        public final boolean isItemSearchable() {
            return this.isItemSearchable;
        }

        public final String getContextSession() {
            return this.contextSession;
        }

        public final BoxAiPromptReducer.State getPromptInputState() {
            return this.promptInputState;
        }

        public final CopyTextReducer.State getCopyTextState() {
            return this.copyTextState;
        }

        public final List<DialogueItem> getDialogueHistory() {
            return this.dialogueHistory;
        }

        public final BoxAiCitationsReducer.State getCitationsState() {
            return this.citationsState;
        }

        public final BoxAiClearChatReducer.State getClearChatState() {
            return this.clearChatState;
        }

        public final String getAgentId() {
            return this.agentId;
        }

        public final boolean getShouldShowFeedbackSubmitted() {
            return this.shouldShowFeedbackSubmitted;
        }

        public final boolean getShowFileListSheet() {
            return this.showFileListSheet;
        }

        public final boolean getShowPromptLibraryButton() {
            return this.showPromptLibraryButton;
        }

        public final int getTotalFileCount() {
            return this.fileModels.size() + this.unsupportedItems.size();
        }

        public final boolean getHasUnsupportedFiles() {
            return !this.unsupportedItems.isEmpty();
        }

        public final boolean getHasChatHistory() {
            return this.hasChatHistory;
        }

        public final boolean getHasRequestInProgress() {
            return this.hasRequestInProgress;
        }

        public final SuggestedQuestionSet getSuggestedQuestionSet() {
            if (this.fileModels.size() > 1) {
                return SuggestedQuestionSet.MULTIDOC_QUESTIONS;
            }
            AiFileType aiFileTypeFromExtensionOrNull = AiFileType.INSTANCE.fromExtensionOrNull(((FileModel) CollectionsKt.single((List) this.fileModels)).getExtension());
            if ((aiFileTypeFromExtensionOrNull == null ? -1 : WhenMappings.$EnumSwitchMapping$0[aiFileTypeFromExtensionOrNull.ordinal()]) == 1) {
                return SuggestedQuestionSet.IMAGE_QUESTIONS;
            }
            return SuggestedQuestionSet.DOCUMENT_QUESTIONS;
        }

        public final DialogueItem getDialogueItem(String promptId) {
            Object next;
            Intrinsics.checkNotNullParameter(promptId, "promptId");
            Iterator it = CollectionsKt.asReversed(this.dialogueHistory).iterator();
            while (it.hasNext()) {
                next = it.next();
                if (Intrinsics.areEqual(((DialogueItem) next).getPromptId(), promptId)) {
                    return (DialogueItem) next;
                }
            }
            next = null;
            return (DialogueItem) next;
        }
    }

    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$AiResponse;", "", "<init>", "()V", "Answer", "Error", "Lcom/box/android/boxai/qa/BoxAiQaReducer$AiResponse$Answer;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$AiResponse$Error;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class AiResponse {
        public static final int $stable = 0;

        public /* synthetic */ AiResponse(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$AiResponse$Answer;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$AiResponse;", "answer", "", "citations", "", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getAnswer", "()Ljava/lang/String;", "getCitations", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Answer extends AiResponse {
            public static final int $stable = 8;
            private final String answer;
            private final List<AiCitationModel> citations;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Answer copy$default(Answer answer, String str, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = answer.answer;
                }
                if ((i & 2) != 0) {
                    list = answer.citations;
                }
                return answer.copy(str, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getAnswer() {
                return this.answer;
            }

            public final List<AiCitationModel> component2() {
                return this.citations;
            }

            public final Answer copy(String answer, List<AiCitationModel> citations) {
                Intrinsics.checkNotNullParameter(answer, "answer");
                Intrinsics.checkNotNullParameter(citations, "citations");
                return new Answer(answer, citations);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Answer)) {
                    return false;
                }
                Answer answer = (Answer) other;
                return Intrinsics.areEqual(this.answer, answer.answer) && Intrinsics.areEqual(this.citations, answer.citations);
            }

            public int hashCode() {
                return (this.answer.hashCode() * 31) + this.citations.hashCode();
            }

            public String toString() {
                return "Answer(answer=" + this.answer + ", citations=" + this.citations + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Answer(String answer, List<AiCitationModel> citations) {
                super(null);
                Intrinsics.checkNotNullParameter(answer, "answer");
                Intrinsics.checkNotNullParameter(citations, "citations");
                this.answer = answer;
                this.citations = citations;
            }

            public /* synthetic */ Answer(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
            }

            public final String getAnswer() {
                return this.answer;
            }

            public final List<AiCitationModel> getCitations() {
                return this.citations;
            }
        }

        private AiResponse() {
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$AiResponse$Error;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$AiResponse;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends AiResponse {
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
    }

    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JK\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$DialogueItem;", "", AuthenticationConstants.AAD.QUERY_PROMPT, "", "response", "Lcom/box/android/boxai/qa/BoxAiQaReducer$AiResponse;", "promptId", "responseFinished", "", "agentId", "feedback", "Lcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;", "<init>", "(Ljava/lang/String;Lcom/box/android/boxai/qa/BoxAiQaReducer$AiResponse;Ljava/lang/String;ZLjava/lang/String;Lcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;)V", "getPrompt", "()Ljava/lang/String;", "getResponse", "()Lcom/box/android/boxai/qa/BoxAiQaReducer$AiResponse;", "getPromptId", "getResponseFinished", "()Z", "getAgentId", "getFeedback", "()Lcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DialogueItem {
        public static final int $stable = 0;
        private final String agentId;
        private final AnswerFeedback feedback;
        private final String prompt;
        private final String promptId;
        private final AiResponse response;
        private final boolean responseFinished;

        public static /* synthetic */ DialogueItem copy$default(DialogueItem dialogueItem, String str, AiResponse aiResponse, String str2, boolean z, String str3, AnswerFeedback answerFeedback, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dialogueItem.prompt;
            }
            if ((i & 2) != 0) {
                aiResponse = dialogueItem.response;
            }
            if ((i & 4) != 0) {
                str2 = dialogueItem.promptId;
            }
            if ((i & 8) != 0) {
                z = dialogueItem.responseFinished;
            }
            if ((i & 16) != 0) {
                str3 = dialogueItem.agentId;
            }
            if ((i & 32) != 0) {
                answerFeedback = dialogueItem.feedback;
            }
            String str4 = str3;
            AnswerFeedback answerFeedback2 = answerFeedback;
            return dialogueItem.copy(str, aiResponse, str2, z, str4, answerFeedback2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPrompt() {
            return this.prompt;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AiResponse getResponse() {
            return this.response;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPromptId() {
            return this.promptId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getResponseFinished() {
            return this.responseFinished;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAgentId() {
            return this.agentId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final AnswerFeedback getFeedback() {
            return this.feedback;
        }

        public final DialogueItem copy(String prompt, AiResponse response, String promptId, boolean responseFinished, String agentId, AnswerFeedback feedback) {
            Intrinsics.checkNotNullParameter(prompt, "prompt");
            Intrinsics.checkNotNullParameter(promptId, "promptId");
            return new DialogueItem(prompt, response, promptId, responseFinished, agentId, feedback);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DialogueItem)) {
                return false;
            }
            DialogueItem dialogueItem = (DialogueItem) other;
            return Intrinsics.areEqual(this.prompt, dialogueItem.prompt) && Intrinsics.areEqual(this.response, dialogueItem.response) && Intrinsics.areEqual(this.promptId, dialogueItem.promptId) && this.responseFinished == dialogueItem.responseFinished && Intrinsics.areEqual(this.agentId, dialogueItem.agentId) && this.feedback == dialogueItem.feedback;
        }

        public int hashCode() {
            int iHashCode = this.prompt.hashCode() * 31;
            AiResponse aiResponse = this.response;
            int iHashCode2 = (((((iHashCode + (aiResponse == null ? 0 : aiResponse.hashCode())) * 31) + this.promptId.hashCode()) * 31) + Boolean.hashCode(this.responseFinished)) * 31;
            String str = this.agentId;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            AnswerFeedback answerFeedback = this.feedback;
            return iHashCode3 + (answerFeedback != null ? answerFeedback.hashCode() : 0);
        }

        public String toString() {
            return "DialogueItem(prompt=" + this.prompt + ", response=" + this.response + ", promptId=" + this.promptId + ", responseFinished=" + this.responseFinished + ", agentId=" + this.agentId + ", feedback=" + this.feedback + ")";
        }

        public DialogueItem(String prompt, AiResponse aiResponse, String promptId, boolean z, String str, AnswerFeedback answerFeedback) {
            Intrinsics.checkNotNullParameter(prompt, "prompt");
            Intrinsics.checkNotNullParameter(promptId, "promptId");
            this.prompt = prompt;
            this.response = aiResponse;
            this.promptId = promptId;
            this.responseFinished = z;
            this.agentId = str;
            this.feedback = answerFeedback;
        }

        public final String getPrompt() {
            return this.prompt;
        }

        public final AiResponse getResponse() {
            return this.response;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ DialogueItem(String str, AiResponse aiResponse, String str2, boolean z, String str3, AnswerFeedback answerFeedback, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 4) != 0) {
                str2 = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(str2, "toString(...)");
            }
            this(str, aiResponse, str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : answerFeedback);
        }

        public final String getPromptId() {
            return this.promptId;
        }

        public final boolean getResponseFinished() {
            return this.responseFinished;
        }

        public final String getAgentId() {
            return this.agentId;
        }

        public final AnswerFeedback getFeedback() {
            return this.feedback;
        }
    }

    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00172\u00020\u0001:\u0014\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0013\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*¨\u0006+"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "", "<init>", "()V", "Initialize", "UpdateFiles", "GetAnswer", "SubmitSuggestedQuestion", "SubmitPrompt", "Retry", "ResponseFinished", "ResponseAppended", "ResponseError", "PromptInputAction", "CopyTextAction", "CitationAction", "CitationClicked", "ClearChatAction", "SubmitFeedback", "FeedbackSubmittedShown", "SetAgent", "ShowFileList", "HideFileList", "Companion", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$CitationAction;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$CitationClicked;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$ClearChatAction;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$CopyTextAction;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$FeedbackSubmittedShown;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$GetAnswer;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$HideFileList;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$Initialize;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$PromptInputAction;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$ResponseAppended;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$ResponseError;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$ResponseFinished;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$Retry;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$SetAgent;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$ShowFileList;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$SubmitFeedback;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$SubmitPrompt;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$SubmitSuggestedQuestion;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$UpdateFiles;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$Initialize;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1760447831;
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

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001b\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003HÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$UpdateFiles;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "fileModels", "", "Lcom/box/android/domain/models/item/FileModel;", "unsupportedItems", "Lkotlin/Pair;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/boxai/AiUnavailabilityReason;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getFileModels", "()Ljava/util/List;", "getUnsupportedItems", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateFiles extends Action {
            public static final int $stable = 8;
            private final List<FileModel> fileModels;
            private final List<Pair<ItemModel, AiUnavailabilityReason>> unsupportedItems;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UpdateFiles copy$default(UpdateFiles updateFiles, List list, List list2, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = updateFiles.fileModels;
                }
                if ((i & 2) != 0) {
                    list2 = updateFiles.unsupportedItems;
                }
                return updateFiles.copy(list, list2);
            }

            public final List<FileModel> component1() {
                return this.fileModels;
            }

            public final List<Pair<ItemModel, AiUnavailabilityReason>> component2() {
                return this.unsupportedItems;
            }

            public final UpdateFiles copy(List<FileModel> fileModels, List<? extends Pair<? extends ItemModel, ? extends AiUnavailabilityReason>> unsupportedItems) {
                Intrinsics.checkNotNullParameter(fileModels, "fileModels");
                Intrinsics.checkNotNullParameter(unsupportedItems, "unsupportedItems");
                return new UpdateFiles(fileModels, unsupportedItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateFiles)) {
                    return false;
                }
                UpdateFiles updateFiles = (UpdateFiles) other;
                return Intrinsics.areEqual(this.fileModels, updateFiles.fileModels) && Intrinsics.areEqual(this.unsupportedItems, updateFiles.unsupportedItems);
            }

            public int hashCode() {
                return (this.fileModels.hashCode() * 31) + this.unsupportedItems.hashCode();
            }

            public String toString() {
                return "UpdateFiles(fileModels=" + this.fileModels + ", unsupportedItems=" + this.unsupportedItems + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public UpdateFiles(List<FileModel> fileModels, List<? extends Pair<? extends ItemModel, ? extends AiUnavailabilityReason>> unsupportedItems) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModels, "fileModels");
                Intrinsics.checkNotNullParameter(unsupportedItems, "unsupportedItems");
                this.fileModels = fileModels;
                this.unsupportedItems = unsupportedItems;
            }

            public final List<FileModel> getFileModels() {
                return this.fileModels;
            }

            public /* synthetic */ UpdateFiles(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
            }

            public final List<Pair<ItemModel, AiUnavailabilityReason>> getUnsupportedItems() {
                return this.unsupportedItems;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$GetAnswer;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "promptId", "", AuthenticationConstants.AAD.QUERY_PROMPT, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPromptId", "()Ljava/lang/String;", "getPrompt", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GetAnswer extends Action {
            public static final int $stable = 0;
            private final String prompt;
            private final String promptId;

            public static /* synthetic */ GetAnswer copy$default(GetAnswer getAnswer, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = getAnswer.promptId;
                }
                if ((i & 2) != 0) {
                    str2 = getAnswer.prompt;
                }
                return getAnswer.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPromptId() {
                return this.promptId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getPrompt() {
                return this.prompt;
            }

            public final GetAnswer copy(String promptId, String prompt) {
                Intrinsics.checkNotNullParameter(promptId, "promptId");
                Intrinsics.checkNotNullParameter(prompt, "prompt");
                return new GetAnswer(promptId, prompt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GetAnswer)) {
                    return false;
                }
                GetAnswer getAnswer = (GetAnswer) other;
                return Intrinsics.areEqual(this.promptId, getAnswer.promptId) && Intrinsics.areEqual(this.prompt, getAnswer.prompt);
            }

            public int hashCode() {
                return (this.promptId.hashCode() * 31) + this.prompt.hashCode();
            }

            public String toString() {
                return "GetAnswer(promptId=" + this.promptId + ", prompt=" + this.prompt + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GetAnswer(String promptId, String prompt) {
                super(null);
                Intrinsics.checkNotNullParameter(promptId, "promptId");
                Intrinsics.checkNotNullParameter(prompt, "prompt");
                this.promptId = promptId;
                this.prompt = prompt;
            }

            public final String getPrompt() {
                return this.prompt;
            }

            public final String getPromptId() {
                return this.promptId;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$SubmitSuggestedQuestion;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "question", "", "<init>", "(Ljava/lang/String;)V", "getQuestion", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SubmitSuggestedQuestion extends Action {
            public static final int $stable = 0;
            private final String question;

            public static /* synthetic */ SubmitSuggestedQuestion copy$default(SubmitSuggestedQuestion submitSuggestedQuestion, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = submitSuggestedQuestion.question;
                }
                return submitSuggestedQuestion.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getQuestion() {
                return this.question;
            }

            public final SubmitSuggestedQuestion copy(String question) {
                Intrinsics.checkNotNullParameter(question, "question");
                return new SubmitSuggestedQuestion(question);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SubmitSuggestedQuestion) && Intrinsics.areEqual(this.question, ((SubmitSuggestedQuestion) other).question);
            }

            public int hashCode() {
                return this.question.hashCode();
            }

            public String toString() {
                return "SubmitSuggestedQuestion(question=" + this.question + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SubmitSuggestedQuestion(String question) {
                super(null);
                Intrinsics.checkNotNullParameter(question, "question");
                this.question = question;
            }

            public final String getQuestion() {
                return this.question;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$SubmitPrompt;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", AuthenticationConstants.AAD.QUERY_PROMPT, "", "<init>", "(Ljava/lang/String;)V", "getPrompt", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SubmitPrompt extends Action {
            public static final int $stable = 0;
            private final String prompt;

            public static /* synthetic */ SubmitPrompt copy$default(SubmitPrompt submitPrompt, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = submitPrompt.prompt;
                }
                return submitPrompt.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPrompt() {
                return this.prompt;
            }

            public final SubmitPrompt copy(String prompt) {
                Intrinsics.checkNotNullParameter(prompt, "prompt");
                return new SubmitPrompt(prompt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SubmitPrompt) && Intrinsics.areEqual(this.prompt, ((SubmitPrompt) other).prompt);
            }

            public int hashCode() {
                return this.prompt.hashCode();
            }

            public String toString() {
                return "SubmitPrompt(prompt=" + this.prompt + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SubmitPrompt(String prompt) {
                super(null);
                Intrinsics.checkNotNullParameter(prompt, "prompt");
                this.prompt = prompt;
            }

            public final String getPrompt() {
                return this.prompt;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$Retry;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "promptId", "", "<init>", "(Ljava/lang/String;)V", "getPromptId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Retry extends Action {
            public static final int $stable = 0;
            private final String promptId;

            public static /* synthetic */ Retry copy$default(Retry retry, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = retry.promptId;
                }
                return retry.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPromptId() {
                return this.promptId;
            }

            public final Retry copy(String promptId) {
                Intrinsics.checkNotNullParameter(promptId, "promptId");
                return new Retry(promptId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Retry) && Intrinsics.areEqual(this.promptId, ((Retry) other).promptId);
            }

            public int hashCode() {
                return this.promptId.hashCode();
            }

            public String toString() {
                return "Retry(promptId=" + this.promptId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Retry(String promptId) {
                super(null);
                Intrinsics.checkNotNullParameter(promptId, "promptId");
                this.promptId = promptId;
            }

            public final String getPromptId() {
                return this.promptId;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$ResponseFinished;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "promptId", "", "contextSession", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPromptId", "()Ljava/lang/String;", "getContextSession", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ResponseFinished extends Action {
            public static final int $stable = 0;
            private final String contextSession;
            private final String promptId;

            public static /* synthetic */ ResponseFinished copy$default(ResponseFinished responseFinished, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = responseFinished.promptId;
                }
                if ((i & 2) != 0) {
                    str2 = responseFinished.contextSession;
                }
                return responseFinished.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPromptId() {
                return this.promptId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getContextSession() {
                return this.contextSession;
            }

            public final ResponseFinished copy(String promptId, String contextSession) {
                Intrinsics.checkNotNullParameter(promptId, "promptId");
                return new ResponseFinished(promptId, contextSession);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ResponseFinished)) {
                    return false;
                }
                ResponseFinished responseFinished = (ResponseFinished) other;
                return Intrinsics.areEqual(this.promptId, responseFinished.promptId) && Intrinsics.areEqual(this.contextSession, responseFinished.contextSession);
            }

            public int hashCode() {
                int iHashCode = this.promptId.hashCode() * 31;
                String str = this.contextSession;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "ResponseFinished(promptId=" + this.promptId + ", contextSession=" + this.contextSession + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ResponseFinished(String promptId, String str) {
                super(null);
                Intrinsics.checkNotNullParameter(promptId, "promptId");
                this.promptId = promptId;
                this.contextSession = str;
            }

            public final String getContextSession() {
                return this.contextSession;
            }

            public final String getPromptId() {
                return this.promptId;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$ResponseAppended;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "promptId", "", "text", "citations", "", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getPromptId", "()Ljava/lang/String;", "getText", "getCitations", "()Ljava/util/List;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ResponseAppended extends Action {
            public static final int $stable = 8;
            private final List<AiCitationModel> citations;
            private final String promptId;
            private final String text;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ResponseAppended copy$default(ResponseAppended responseAppended, String str, String str2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = responseAppended.promptId;
                }
                if ((i & 2) != 0) {
                    str2 = responseAppended.text;
                }
                if ((i & 4) != 0) {
                    list = responseAppended.citations;
                }
                return responseAppended.copy(str, str2, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPromptId() {
                return this.promptId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final List<AiCitationModel> component3() {
                return this.citations;
            }

            public final ResponseAppended copy(String promptId, String text, List<AiCitationModel> citations) {
                Intrinsics.checkNotNullParameter(promptId, "promptId");
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(citations, "citations");
                return new ResponseAppended(promptId, text, citations);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ResponseAppended)) {
                    return false;
                }
                ResponseAppended responseAppended = (ResponseAppended) other;
                return Intrinsics.areEqual(this.promptId, responseAppended.promptId) && Intrinsics.areEqual(this.text, responseAppended.text) && Intrinsics.areEqual(this.citations, responseAppended.citations);
            }

            public int hashCode() {
                return (((this.promptId.hashCode() * 31) + this.text.hashCode()) * 31) + this.citations.hashCode();
            }

            public String toString() {
                return "ResponseAppended(promptId=" + this.promptId + ", text=" + this.text + ", citations=" + this.citations + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ResponseAppended(String promptId, String text, List<AiCitationModel> citations) {
                super(null);
                Intrinsics.checkNotNullParameter(promptId, "promptId");
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(citations, "citations");
                this.promptId = promptId;
                this.text = text;
                this.citations = citations;
            }

            public final List<AiCitationModel> getCitations() {
                return this.citations;
            }

            public final String getPromptId() {
                return this.promptId;
            }

            public final String getText() {
                return this.text;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$ResponseError;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "promptId", "", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;)V", "getPromptId", "()Ljava/lang/String;", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ResponseError extends Action {
            public static final int $stable = 8;
            private final DomainError error;
            private final String promptId;

            public static /* synthetic */ ResponseError copy$default(ResponseError responseError, String str, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = responseError.promptId;
                }
                if ((i & 2) != 0) {
                    domainError = responseError.error;
                }
                return responseError.copy(str, domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPromptId() {
                return this.promptId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final ResponseError copy(String promptId, DomainError error) {
                Intrinsics.checkNotNullParameter(promptId, "promptId");
                Intrinsics.checkNotNullParameter(error, "error");
                return new ResponseError(promptId, error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ResponseError)) {
                    return false;
                }
                ResponseError responseError = (ResponseError) other;
                return Intrinsics.areEqual(this.promptId, responseError.promptId) && Intrinsics.areEqual(this.error, responseError.error);
            }

            public int hashCode() {
                return (this.promptId.hashCode() * 31) + this.error.hashCode();
            }

            public String toString() {
                return "ResponseError(promptId=" + this.promptId + ", error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ResponseError(String promptId, DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(promptId, "promptId");
                Intrinsics.checkNotNullParameter(error, "error");
                this.promptId = promptId;
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }

            public final String getPromptId() {
                return this.promptId;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$PromptInputAction;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;)V", "getAction", "()Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PromptInputAction extends Action implements Embedded<BoxAiPromptReducer.Action> {
            public static final int $stable = 0;
            private final BoxAiPromptReducer.Action action;

            public static /* synthetic */ PromptInputAction copy$default(PromptInputAction promptInputAction, BoxAiPromptReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = promptInputAction.action;
                }
                return promptInputAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAiPromptReducer.Action getState() {
                return this.action;
            }

            public final PromptInputAction copy(BoxAiPromptReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new PromptInputAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PromptInputAction) && Intrinsics.areEqual(this.action, ((PromptInputAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "PromptInputAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PromptInputAction(BoxAiPromptReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BoxAiPromptReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$CopyTextAction;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/CopyTextReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/CopyTextReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/CopyTextReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CopyTextAction extends Action implements Embedded<CopyTextReducer.Action> {
            public static final int $stable = CopyTextReducer.Action.$stable;
            private final CopyTextReducer.Action action;

            public static /* synthetic */ CopyTextAction copy$default(CopyTextAction copyTextAction, CopyTextReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = copyTextAction.action;
                }
                return copyTextAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CopyTextReducer.Action getState() {
                return this.action;
            }

            public final CopyTextAction copy(CopyTextReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CopyTextAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CopyTextAction) && Intrinsics.areEqual(this.action, ((CopyTextAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CopyTextAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CopyTextAction(CopyTextReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CopyTextReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$CitationAction;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action;)V", "getAction", "()Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CitationAction extends Action implements Embedded<BoxAiCitationsReducer.Action> {
            public static final int $stable = 0;
            private final BoxAiCitationsReducer.Action action;

            public static /* synthetic */ CitationAction copy$default(CitationAction citationAction, BoxAiCitationsReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = citationAction.action;
                }
                return citationAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAiCitationsReducer.Action getState() {
                return this.action;
            }

            public final CitationAction copy(BoxAiCitationsReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CitationAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CitationAction) && Intrinsics.areEqual(this.action, ((CitationAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CitationAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CitationAction(BoxAiCitationsReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BoxAiCitationsReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$CitationClicked;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "citation", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "<init>", "(Lcom/box/android/domain/models/boxai/AiCitationModel;)V", "getCitation", "()Lcom/box/android/domain/models/boxai/AiCitationModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CitationClicked extends Action {
            public static final int $stable = 8;
            private final AiCitationModel citation;

            public static /* synthetic */ CitationClicked copy$default(CitationClicked citationClicked, AiCitationModel aiCitationModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    aiCitationModel = citationClicked.citation;
                }
                return citationClicked.copy(aiCitationModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AiCitationModel getCitation() {
                return this.citation;
            }

            public final CitationClicked copy(AiCitationModel citation) {
                Intrinsics.checkNotNullParameter(citation, "citation");
                return new CitationClicked(citation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CitationClicked) && Intrinsics.areEqual(this.citation, ((CitationClicked) other).citation);
            }

            public int hashCode() {
                return this.citation.hashCode();
            }

            public String toString() {
                return "CitationClicked(citation=" + this.citation + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CitationClicked(AiCitationModel citation) {
                super(null);
                Intrinsics.checkNotNullParameter(citation, "citation");
                this.citation = citation;
            }

            public final AiCitationModel getCitation() {
                return this.citation;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$ClearChatAction;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action;)V", "getAction", "()Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ClearChatAction extends Action implements Embedded<BoxAiClearChatReducer.Action> {
            public static final int $stable = 0;
            private final BoxAiClearChatReducer.Action action;

            public static /* synthetic */ ClearChatAction copy$default(ClearChatAction clearChatAction, BoxAiClearChatReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = clearChatAction.action;
                }
                return clearChatAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAiClearChatReducer.Action getState() {
                return this.action;
            }

            public final ClearChatAction copy(BoxAiClearChatReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ClearChatAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ClearChatAction) && Intrinsics.areEqual(this.action, ((ClearChatAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "ClearChatAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ClearChatAction(BoxAiClearChatReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BoxAiClearChatReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$SubmitFeedback;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "promptId", "", "feedback", "Lcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;", "<init>", "(Ljava/lang/String;Lcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;)V", "getPromptId", "()Ljava/lang/String;", "getFeedback", "()Lcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SubmitFeedback extends Action {
            public static final int $stable = 0;
            private final AnswerFeedback feedback;
            private final String promptId;

            public static /* synthetic */ SubmitFeedback copy$default(SubmitFeedback submitFeedback, String str, AnswerFeedback answerFeedback, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = submitFeedback.promptId;
                }
                if ((i & 2) != 0) {
                    answerFeedback = submitFeedback.feedback;
                }
                return submitFeedback.copy(str, answerFeedback);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPromptId() {
                return this.promptId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final AnswerFeedback getFeedback() {
                return this.feedback;
            }

            public final SubmitFeedback copy(String promptId, AnswerFeedback feedback) {
                Intrinsics.checkNotNullParameter(promptId, "promptId");
                Intrinsics.checkNotNullParameter(feedback, "feedback");
                return new SubmitFeedback(promptId, feedback);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SubmitFeedback)) {
                    return false;
                }
                SubmitFeedback submitFeedback = (SubmitFeedback) other;
                return Intrinsics.areEqual(this.promptId, submitFeedback.promptId) && this.feedback == submitFeedback.feedback;
            }

            public int hashCode() {
                return (this.promptId.hashCode() * 31) + this.feedback.hashCode();
            }

            public String toString() {
                return "SubmitFeedback(promptId=" + this.promptId + ", feedback=" + this.feedback + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SubmitFeedback(String promptId, AnswerFeedback feedback) {
                super(null);
                Intrinsics.checkNotNullParameter(promptId, "promptId");
                Intrinsics.checkNotNullParameter(feedback, "feedback");
                this.promptId = promptId;
                this.feedback = feedback;
            }

            public final AnswerFeedback getFeedback() {
                return this.feedback;
            }

            public final String getPromptId() {
                return this.promptId;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$FeedbackSubmittedShown;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FeedbackSubmittedShown extends Action {
            public static final int $stable = 0;
            public static final FeedbackSubmittedShown INSTANCE = new FeedbackSubmittedShown();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FeedbackSubmittedShown)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1424864510;
            }

            public String toString() {
                return "FeedbackSubmittedShown";
            }

            private FeedbackSubmittedShown() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$SetAgent;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "agentId", "", "<init>", "(Ljava/lang/String;)V", "getAgentId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SetAgent extends Action {
            public static final int $stable = 0;
            private final String agentId;

            public static /* synthetic */ SetAgent copy$default(SetAgent setAgent, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = setAgent.agentId;
                }
                return setAgent.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getAgentId() {
                return this.agentId;
            }

            public final SetAgent copy(String agentId) {
                Intrinsics.checkNotNullParameter(agentId, "agentId");
                return new SetAgent(agentId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetAgent) && Intrinsics.areEqual(this.agentId, ((SetAgent) other).agentId);
            }

            public int hashCode() {
                return this.agentId.hashCode();
            }

            public String toString() {
                return "SetAgent(agentId=" + this.agentId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetAgent(String agentId) {
                super(null);
                Intrinsics.checkNotNullParameter(agentId, "agentId");
                this.agentId = agentId;
            }

            public final String getAgentId() {
                return this.agentId;
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$ShowFileList;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowFileList extends Action {
            public static final int $stable = 0;
            public static final ShowFileList INSTANCE = new ShowFileList();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowFileList)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1614407074;
            }

            public String toString() {
                return "ShowFileList";
            }

            private ShowFileList() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/qa/BoxAiQaReducer$Action$HideFileList;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HideFileList extends Action {
            public static final int $stable = 0;
            public static final HideFileList INSTANCE = new HideFileList();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HideFileList)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -200210525;
            }

            public String toString() {
                return "HideFileList";
            }

            private HideFileList() {
                super(null);
            }
        }
    }

    private final List<DialogueItem> modifyItemIfPresent(List<DialogueItem> list, String str, Function1<? super DialogueItem, DialogueItem> function1) {
        List<DialogueItem> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DialogueItem dialogueItemInvoke : list2) {
            if (Intrinsics.areEqual(dialogueItemInvoke.getPromptId(), str)) {
                dialogueItemInvoke = function1.invoke(dialogueItemInvoke);
            }
            arrayList.add(dialogueItemInvoke);
        }
        return arrayList;
    }

    private final List<DialogueItem> appendToItemIfPresent(List<DialogueItem> list, String str, final String str2, final List<AiCitationModel> list2) {
        return modifyItemIfPresent(list, str, new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxAiQaReducer.appendToItemIfPresent$lambda$0(str2, list2, (BoxAiQaReducer.DialogueItem) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogueItem appendToItemIfPresent$lambda$0(String str, List list, DialogueItem item) {
        AiResponse.Answer answer;
        Intrinsics.checkNotNullParameter(item, "item");
        AiResponse response = item.getResponse();
        if (response instanceof AiResponse.Answer) {
            AiResponse.Answer answer2 = (AiResponse.Answer) response;
            answer = new AiResponse.Answer(answer2.getAnswer() + str, CollectionsKt.sortedWith(CollectionsKt.plus((Collection) answer2.getCitations(), (Iterable) list), new Comparator() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$appendToItemIfPresent$lambda$0$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((AiCitationModel) t).getLocation(), ((AiCitationModel) t2).getLocation());
                }
            }));
        } else {
            answer = new AiResponse.Answer(str, list);
        }
        return DialogueItem.copy$default(item, null, answer, null, false, null, null, 61, null);
    }

    private final ReducerResult<State, Action> handleGetAnswer(final State state, Action.GetAnswer action) {
        return new ReducerResult<>(State.copy$default(state, null, null, null, false, false, null, null, null, modifyItemIfPresent(state.getDialogueHistory(), action.getPromptId(), new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxAiQaReducer.handleGetAnswer$lambda$0(state, (BoxAiQaReducer.DialogueItem) obj);
            }
        }), null, null, null, false, false, false, 32511, null), Effect.cancellable$default(EffectKt.toEffect(FlowKt.flow(new AnonymousClass2(state, action, null))), GET_ANSWER_EFFECT_ID, false, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogueItem handleGetAnswer$lambda$0(State state, DialogueItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DialogueItem.copy$default(it, null, null, null, false, state.getAgentId(), null, 47, null);
    }

    /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$handleGetAnswer$2, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$handleGetAnswer$2", f = "BoxAiQaReducer.kt", i = {0, 0}, l = {Token.ARROW}, m = "invokeSuspend", n = {"$this$flow", "contextSession"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action.GetAnswer $action;
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(State state, Action.GetAnswer getAnswer, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$state = state;
            this.$action = getAnswer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = BoxAiQaReducer.this.new AnonymousClass2(this.$state, this.$action, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                IBoxAiService boxAiService = BoxAiQaReducer.this.environment.getBoxAiService();
                List<FileModel> fileModels = this.$state.getFileModels();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fileModels, 10));
                Iterator<T> it = fileModels.iterator();
                while (it.hasNext()) {
                    arrayList.add(((FileModel) it.next()).getItemId());
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(objectRef);
                this.label = 1;
                if (FlowKt.onCompletion(boxAiService.getAnswerQAStreaming(arrayList, this.$state.isMultidoc(), this.$action.getPrompt(), this.$state.getItemSession(), this.$state.getContextSession(), this.$state.getAgentId()), new C01242(flowCollector, this.$action, objectRef, null)).collect(new AnonymousClass3(flowCollector, this.$action, objectRef), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$handleGetAnswer$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel;", "Lcom/box/android/domain/models/DomainError;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$handleGetAnswer$2$2", f = "BoxAiQaReducer.kt", i = {}, l = {Token.METHOD}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01242 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends AiAnswerStreamingModel, ? extends DomainError>>, Throwable, Continuation<? super Unit>, Object> {
            final /* synthetic */ FlowCollector<Action> $$this$flow;
            final /* synthetic */ Action.GetAnswer $action;
            final /* synthetic */ Ref.ObjectRef<String> $contextSession;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01242(FlowCollector<? super Action> flowCollector, Action.GetAnswer getAnswer, Ref.ObjectRef<String> objectRef, Continuation<? super C01242> continuation) {
                super(3, continuation);
                this.$$this$flow = flowCollector;
                this.$action = getAnswer;
                this.$contextSession = objectRef;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super Result<? extends AiAnswerStreamingModel, ? extends DomainError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return new C01242(this.$$this$flow, this.$action, this.$contextSession, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$$this$flow.emit(new Action.ResponseFinished(this.$action.getPromptId(), this.$contextSession.element), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$handleGetAnswer$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        static final class AnonymousClass3<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<Action> $$this$flow;
            final /* synthetic */ Action.GetAnswer $action;
            final /* synthetic */ Ref.ObjectRef<String> $contextSession;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(FlowCollector<? super Action> flowCollector, Action.GetAnswer getAnswer, Ref.ObjectRef<String> objectRef) {
                this.$$this$flow = flowCollector;
                this.$action = getAnswer;
                this.$contextSession = objectRef;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x00a5, code lost:
            
                if (r12.emit(r4, r0) == r1) goto L43;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x00d7, code lost:
            
                if (r12.emit(r5, r0) == r1) goto L43;
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x0128, code lost:
            
                if (r12.emit(r5, r0) == r1) goto L43;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.box.android.domain.utils.result.Result<? extends com.box.android.domain.models.boxai.AiAnswerStreamingModel, ? extends com.box.android.domain.models.DomainError> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
                /*
                    Method dump skipped, instruction units count: 314
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.boxai.qa.BoxAiQaReducer.AnonymousClass2.AnonymousClass3.emit(com.box.android.domain.utils.result.Result, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((Result<? extends AiAnswerStreamingModel, ? extends DomainError>) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    private final ReducerResult<State, Action> handleSubmitFeedback(State state, final Action.SubmitFeedback action) {
        DialogueItem dialogueItem = state.getDialogueItem(action.getPromptId());
        if (dialogueItem == null || dialogueItem.getFeedback() != null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(State.copy$default(state, null, null, null, false, false, null, null, null, modifyItemIfPresent(state.getDialogueHistory(), action.getPromptId(), new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxAiQaReducer.handleSubmitFeedback$lambda$0(action, (BoxAiQaReducer.DialogueItem) obj);
            }
        }), null, null, null, true, false, false, 28415, null), Effect.INSTANCE.fireAndForget(new C09392(action, this, state, dialogueItem, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogueItem handleSubmitFeedback$lambda$0(Action.SubmitFeedback submitFeedback, DialogueItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DialogueItem.copy$default(it, null, null, null, false, null, submitFeedback.getFeedback(), 31, null);
    }

    /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$handleSubmitFeedback$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$handleSubmitFeedback$2", f = "BoxAiQaReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09392 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action.SubmitFeedback $action;
        final /* synthetic */ DialogueItem $item;
        final /* synthetic */ State $state;
        int label;
        final /* synthetic */ BoxAiQaReducer this$0;

        /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$handleSubmitFeedback$2$WhenMappings */
        /* JADX INFO: compiled from: BoxAiQaReducer.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnswerFeedback.values().length];
                try {
                    iArr[AnswerFeedback.POSITIVE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnswerFeedback.NEGATIVE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09392(Action.SubmitFeedback submitFeedback, BoxAiQaReducer boxAiQaReducer, State state, DialogueItem dialogueItem, Continuation<? super C09392> continuation) {
            super(1, continuation);
            this.$action = submitFeedback;
            this.this$0 = boxAiQaReducer;
            this.$state = state;
            this.$item = dialogueItem;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C09392(this.$action, this.this$0, this.$state, this.$item, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09392) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i = WhenMappings.$EnumSwitchMapping$0[this.$action.getFeedback().ordinal()];
            if (i == 1) {
                this.this$0.environment.getBoxAiAnalytics().positiveFeedbackSubmitted(this.$state.getFileModels(), this.$item.getAgentId());
            } else if (i == 2) {
                this.this$0.environment.getBoxAiAnalytics().negativeFeedbackSubmitted(this.$state.getFileModels(), this.$item.getAgentId());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceAnalytics(State state, Action action) {
        if (action instanceof Action.GetAnswer) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(state, null)));
        }
        if (action instanceof Action.ResponseFinished) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new C09402(state, null)));
        }
        if (action instanceof Action.CopyTextAction) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass3(action, this, state, null)));
        }
        if (action instanceof Action.Retry) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass4(state, null)));
        }
        if (action instanceof Action.PromptInputAction) {
            if (((Action.PromptInputAction) action).getAction() instanceof BoxAiPromptReducer.Action.StartVoiceInput) {
                return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass5(state, null)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.SubmitSuggestedQuestion) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass6(state, action, null)));
        }
        if (action instanceof Action.ClearChatAction) {
            if (((Action.ClearChatAction) action).getAction() instanceof BoxAiClearChatReducer.Action.ClearChatConfirmed) {
                return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass7(state, null)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$1", f = "BoxAiQaReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BoxAiQaReducer.this.new AnonymousClass1(this.$state, continuation);
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
            BoxAiQaReducer.this.environment.getBoxAiAnalytics().promptSubmitted(this.$state.getFileModels());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$2", f = "BoxAiQaReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09402 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09402(State state, Continuation<? super C09402> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BoxAiQaReducer.this.new C09402(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09402) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BoxAiQaReducer.this.environment.getBoxAiAnalytics().answerReceived(this.$state.getFileModels());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$3, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$3", f = "BoxAiQaReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;
        final /* synthetic */ BoxAiQaReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Action action, BoxAiQaReducer boxAiQaReducer, State state, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$action = action;
            this.this$0 = boxAiQaReducer;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass3(this.$action, this.this$0, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (((Action.CopyTextAction) this.$action).getAction() instanceof CopyTextReducer.Action.CopyText) {
                this.this$0.environment.getBoxAiAnalytics().copyResponseClicked(this.$state.getFileModels());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$4, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$4", f = "BoxAiQaReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(State state, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BoxAiQaReducer.this.new AnonymousClass4(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BoxAiQaReducer.this.environment.getBoxAiAnalytics().retryButtonClicked(this.$state.getFileModels());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$5, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$5", f = "BoxAiQaReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(State state, Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BoxAiQaReducer.this.new AnonymousClass5(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BoxAiQaReducer.this.environment.getBoxAiAnalytics().microphoneButtonClicked(this.$state.getFileModels());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$6, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$6", f = "BoxAiQaReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(State state, Action action, Continuation<? super AnonymousClass6> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BoxAiQaReducer.this.new AnonymousClass6(this.$state, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BoxAiQaReducer.this.environment.getBoxAiAnalytics().suggestedQuestionClicked(this.$state.getFileModels(), ((Action.SubmitSuggestedQuestion) this.$action).getQuestion());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$7, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$reduceAnalytics$7", f = "BoxAiQaReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(State state, Continuation<? super AnonymousClass7> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BoxAiQaReducer.this.new AnonymousClass7(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BoxAiQaReducer.this.environment.getBoxAiAnalytics().clearChatClicked(this.$state.getFileModels());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x004f  */
    public final ReducerResult<State, Action> reduceObservability(State state, Action action) {
        int iIntValue;
        AiResponse response;
        String answer;
        if (action instanceof Action.GetAnswer) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new C09411(state, action, null)));
        }
        if (action instanceof Action.ResponseFinished) {
            DialogueItem dialogueItem = state.getDialogueItem(((Action.ResponseFinished) action).getPromptId());
            if (dialogueItem == null || (response = dialogueItem.getResponse()) == null) {
                iIntValue = 0;
            } else {
                AiResponse.Answer answer2 = response instanceof AiResponse.Answer ? (AiResponse.Answer) response : null;
                Integer numValueOf = (answer2 == null || (answer = answer2.getAnswer()) == null) ? null : Integer.valueOf(StringExtensionsKt.wordCount(answer));
                if (numValueOf != null) {
                    iIntValue = numValueOf.intValue();
                } else {
                    iIntValue = 0;
                }
            }
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new C09422(state, iIntValue, null)));
        }
        if (action instanceof Action.ResponseError) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new C09433(state, action, null)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$reduceObservability$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$reduceObservability$1", f = "BoxAiQaReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09411 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09411(State state, Action action, Continuation<? super C09411> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BoxAiQaReducer.this.new C09411(this.$state, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09411) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BoxAiObservability.logPromptSubmitted$default(BoxAiQaReducer.this.environment.getBoxAiObservability(), this.$state.getFileModels(), StringExtensionsKt.wordCount(((Action.GetAnswer) this.$action).getPrompt()), 0L, 4, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$reduceObservability$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$reduceObservability$2", f = "BoxAiQaReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09422 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $answerLength;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09422(State state, int i, Continuation<? super C09422> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$answerLength = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BoxAiQaReducer.this.new C09422(this.$state, this.$answerLength, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09422) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BoxAiObservability.logSuccessResponseReceived$default(BoxAiQaReducer.this.environment.getBoxAiObservability(), this.$state.getFileModels(), this.$answerLength, 0L, 4, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.boxai.qa.BoxAiQaReducer$reduceObservability$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiQaReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$reduceObservability$3", f = "BoxAiQaReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09433 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09433(State state, Action action, Continuation<? super C09433> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BoxAiQaReducer.this.new C09433(this.$state, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09433) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BoxAiObservability.logErrorResponseReceived$default(BoxAiQaReducer.this.environment.getBoxAiObservability(), this.$state.getFileModels(), ((Action.ResponseError) this.$action).getError(), 0L, 4, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceQaAiAction(State state, final Action action) {
        if (action instanceof Action.Initialize) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(new Action.PromptInputAction(BoxAiPromptReducer.Action.Initialize.INSTANCE)));
        }
        if (action instanceof Action.UpdateFiles) {
            Action.UpdateFiles updateFiles = (Action.UpdateFiles) action;
            return new ReducerResult<>(State.copy$default(state, updateFiles.getFileModels(), updateFiles.getUnsupportedItems(), null, false, false, null, null, null, null, null, null, null, false, false, false, 32764, null), null, 2, null);
        }
        if (action instanceof Action.GetAnswer) {
            return handleGetAnswer(state, (Action.GetAnswer) action);
        }
        if (action instanceof Action.SubmitSuggestedQuestion) {
            return new ReducerResult<>(state, new Effect(new Action.SubmitPrompt(((Action.SubmitSuggestedQuestion) action).getQuestion())));
        }
        if (action instanceof Action.SubmitPrompt) {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Action.SubmitPrompt submitPrompt = (Action.SubmitPrompt) action;
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, false, null, null, null, CollectionsKt.plus((Collection<? extends DialogueItem>) state.getDialogueHistory(), new DialogueItem(submitPrompt.getPrompt(), null, string, false, null, null, 56, null)), null, null, null, false, false, false, 32511, null), new Effect(new Action.GetAnswer(string, submitPrompt.getPrompt())));
        }
        if (action instanceof Action.Retry) {
            Action.Retry retry = (Action.Retry) action;
            DialogueItem dialogueItem = state.getDialogueItem(retry.getPromptId());
            String prompt = dialogueItem != null ? dialogueItem.getPrompt() : null;
            if (prompt != null) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, false, null, null, null, modifyItemIfPresent(state.getDialogueHistory(), retry.getPromptId(), new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiQaReducer.reduceQaAiAction$lambda$0((BoxAiQaReducer.DialogueItem) obj);
                    }
                }), null, null, null, false, false, false, 32511, null), new Effect(new Action.GetAnswer(retry.getPromptId(), prompt)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.ResponseFinished) {
            Action.ResponseFinished responseFinished = (Action.ResponseFinished) action;
            if (state.getDialogueItem(responseFinished.getPromptId()) != null) {
                String contextSession = responseFinished.getContextSession();
                if (contextSession == null) {
                    contextSession = state.getContextSession();
                }
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, false, contextSession, null, null, modifyItemIfPresent(state.getDialogueHistory(), responseFinished.getPromptId(), new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiQaReducer.reduceQaAiAction$lambda$1((BoxAiQaReducer.DialogueItem) obj);
                    }
                }), null, null, null, false, false, false, 32479, null), null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.ResponseAppended) {
            Action.ResponseAppended responseAppended = (Action.ResponseAppended) action;
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, false, null, null, null, appendToItemIfPresent(state.getDialogueHistory(), responseAppended.getPromptId(), responseAppended.getText(), responseAppended.getCitations()), null, null, null, false, false, false, 32511, null), null, 2, null);
        }
        if (action instanceof Action.ResponseError) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, false, null, null, null, modifyItemIfPresent(state.getDialogueHistory(), ((Action.ResponseError) action).getPromptId(), new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaReducer$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxAiQaReducer.reduceQaAiAction$lambda$2(action, (BoxAiQaReducer.DialogueItem) obj);
                }
            }), null, null, null, false, false, false, 32511, null), null, 2, null);
        }
        if (action instanceof Action.PromptInputAction) {
            Action.PromptInputAction promptInputAction = (Action.PromptInputAction) action;
            if (promptInputAction.getAction() instanceof BoxAiPromptReducer.Action.SubmitPrompt) {
                return new ReducerResult<>(state, new Effect(new Action.SubmitPrompt(((BoxAiPromptReducer.Action.SubmitPrompt) promptInputAction.getAction()).getPrompt())));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (!(action instanceof Action.CitationAction) && !(action instanceof Action.CopyTextAction)) {
            if (action instanceof Action.ClearChatAction) {
                if (((Action.ClearChatAction) action).getAction() instanceof BoxAiClearChatReducer.Action.ClearChatConfirmed) {
                    return new ReducerResult<>(State.copy$default(state, null, null, null, false, false, null, null, null, CollectionsKt.emptyList(), null, null, null, false, false, false, 32479, null), Effect.INSTANCE.cancel(GET_ANSWER_EFFECT_ID));
                }
                return new ReducerResult<>(state, null, 2, null);
            }
            if (action instanceof Action.CitationClicked) {
                return new ReducerResult<>(state, null, 2, null);
            }
            if (action instanceof Action.SubmitFeedback) {
                return handleSubmitFeedback(state, (Action.SubmitFeedback) action);
            }
            if (action instanceof Action.FeedbackSubmittedShown) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, false, null, null, null, null, null, null, null, false, false, false, 28671, null), null, 2, null);
            }
            if (action instanceof Action.SetAgent) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, false, null, null, null, null, null, null, ((Action.SetAgent) action).getAgentId(), false, false, false, 30719, null), null, 2, null);
            }
            if (action instanceof Action.ShowFileList) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, false, null, null, null, null, null, null, null, false, true, false, 24575, null), null, 2, null);
            }
            if (!(action instanceof Action.HideFileList)) {
                throw new NoWhenBranchMatchedException();
            }
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, false, null, null, null, null, null, null, null, false, false, false, 24575, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogueItem reduceQaAiAction$lambda$0(DialogueItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DialogueItem.copy$default(it, null, null, null, false, null, null, 61, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogueItem reduceQaAiAction$lambda$1(DialogueItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DialogueItem.copy$default(it, null, null, null, true, null, null, 55, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogueItem reduceQaAiAction$lambda$2(Action action, DialogueItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DialogueItem.copy$default(it, null, new AiResponse.Error(((Action.ResponseError) action).getError()), null, false, null, null, 61, null);
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }
}
