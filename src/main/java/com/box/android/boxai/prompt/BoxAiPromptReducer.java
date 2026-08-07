package com.box.android.boxai.prompt;

import com.box.android.base.presentation.components.inputbar.BasicInputBarReducer;
import com.box.android.base.presentation.components.inputbar.TextFieldValueUIModel;
import com.box.android.base.presentation.components.permission.PermissionReducer;
import com.box.android.boxai.BoxAiEnvironment;
import com.box.android.boxai.voice.VoiceInputReducer;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
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
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BoxAiPromptReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000f\u0010\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/box/android/boxai/prompt/BoxAiPromptReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$State;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;", "environment", "Lcom/box/android/boxai/BoxAiEnvironment;", "<init>", "(Lcom/box/android/boxai/BoxAiEnvironment;)V", "reducePromptAction", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "State", "PromptOperation", "Action", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiPromptReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final BoxAiEnvironment environment;

    /* JADX INFO: compiled from: BoxAiPromptReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/boxai/prompt/BoxAiPromptReducer$PromptOperation;", "", "<init>", "(Ljava/lang/String;I)V", "VOICE_INPUT", "SUBMIT", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum PromptOperation {
        VOICE_INPUT,
        SUBMIT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<PromptOperation> getEntries() {
            return $ENTRIES;
        }
    }

    public BoxAiPromptReducer(BoxAiEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new BoxAiPromptReducer$build$1(this));
        final BoxAiPromptReducer$build$2 boxAiPromptReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BoxAiPromptReducer.State) obj).getTextInputState();
            }
        };
        final BoxAiPromptReducer$build$3 boxAiPromptReducer$build$3 = BoxAiPromptReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new BasicInputBarReducer(), new Function1<State, BasicInputBarReducer.State>() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.inputbar.BasicInputBarReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BasicInputBarReducer.State invoke(BoxAiPromptReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return boxAiPromptReducer$build$2.invoke(it);
            }
        }, new Function1<Action, BasicInputBarReducer.Action>() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final BasicInputBarReducer.Action invoke(BoxAiPromptReducer.Action action) {
                if (!(action instanceof BoxAiPromptReducer.Action.TextInputAction)) {
                    action = null;
                }
                BoxAiPromptReducer.Action.TextInputAction textInputAction = (BoxAiPromptReducer.Action.TextInputAction) action;
                if (textInputAction != null) {
                    return textInputAction.getAction();
                }
                return null;
            }
        }, new Function2<State, BasicInputBarReducer.State, State>() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final BoxAiPromptReducer.State invoke(BoxAiPromptReducer.State parentState, BasicInputBarReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = boxAiPromptReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(BoxAiPromptReducer.State.class)).iterator();
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
                            return (BoxAiPromptReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.prompt.BoxAiPromptReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BasicInputBarReducer.Action, Action>() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BoxAiPromptReducer.Action invoke(BasicInputBarReducer.Action action) {
                Object objInvoke = boxAiPromptReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (BoxAiPromptReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.prompt.BoxAiPromptReducer.Action");
            }
        });
        final BoxAiPromptReducer$build$5 boxAiPromptReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BoxAiPromptReducer.State) obj).getVoiceInputState();
            }
        };
        final BoxAiPromptReducer$build$6 boxAiPromptReducer$build$6 = BoxAiPromptReducer$build$6.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new VoiceInputReducer(environment.getVoiceInputEnvironment()), new Function1<State, VoiceInputReducer.State>() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.boxai.voice.VoiceInputReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final VoiceInputReducer.State invoke(BoxAiPromptReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return boxAiPromptReducer$build$5.invoke(it);
            }
        }, new Function1<Action, VoiceInputReducer.Action>() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final VoiceInputReducer.Action invoke(BoxAiPromptReducer.Action action) {
                if (!(action instanceof BoxAiPromptReducer.Action.VoiceInputAction)) {
                    action = null;
                }
                BoxAiPromptReducer.Action.VoiceInputAction voiceInputAction = (BoxAiPromptReducer.Action.VoiceInputAction) action;
                if (voiceInputAction != null) {
                    return voiceInputAction.getAction();
                }
                return null;
            }
        }, new Function2<State, VoiceInputReducer.State, State>() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final BoxAiPromptReducer.State invoke(BoxAiPromptReducer.State parentState, VoiceInputReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = boxAiPromptReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(BoxAiPromptReducer.State.class)).iterator();
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
                            return (BoxAiPromptReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.prompt.BoxAiPromptReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<VoiceInputReducer.Action, Action>() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BoxAiPromptReducer.Action invoke(VoiceInputReducer.Action action) {
                Object objInvoke = boxAiPromptReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (BoxAiPromptReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.prompt.BoxAiPromptReducer.Action");
            }
        });
        final BoxAiPromptReducer$build$8 boxAiPromptReducer$build$8 = new PropertyReference1Impl() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$build$8
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BoxAiPromptReducer.State) obj).getAudioPermissionsState();
            }
        };
        final BoxAiPromptReducer$build$9 boxAiPromptReducer$build$9 = BoxAiPromptReducer$build$9.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer2, new PermissionReducer(), new Function1<State, PermissionReducer.State>() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$special$$inlined$scope$9
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.permission.PermissionReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final PermissionReducer.State invoke(BoxAiPromptReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return boxAiPromptReducer$build$8.invoke(it);
            }
        }, new Function1<Action, PermissionReducer.Action>() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$special$$inlined$scope$10
            @Override // kotlin.jvm.functions.Function1
            public final PermissionReducer.Action invoke(BoxAiPromptReducer.Action action) {
                if (!(action instanceof BoxAiPromptReducer.Action.AudioPermissionsAction)) {
                    action = null;
                }
                BoxAiPromptReducer.Action.AudioPermissionsAction audioPermissionsAction = (BoxAiPromptReducer.Action.AudioPermissionsAction) action;
                if (audioPermissionsAction != null) {
                    return audioPermissionsAction.getAction();
                }
                return null;
            }
        }, new Function2<State, PermissionReducer.State, State>() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$special$$inlined$scope$11
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final BoxAiPromptReducer.State invoke(BoxAiPromptReducer.State parentState, PermissionReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = boxAiPromptReducer$build$8;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(BoxAiPromptReducer.State.class)).iterator();
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
                            return (BoxAiPromptReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.prompt.BoxAiPromptReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<PermissionReducer.Action, Action>() { // from class: com.box.android.boxai.prompt.BoxAiPromptReducer$special$$inlined$scope$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BoxAiPromptReducer.Action invoke(PermissionReducer.Action action) {
                Object objInvoke = boxAiPromptReducer$build$9.invoke(action);
                if (objInvoke != null) {
                    return (BoxAiPromptReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.prompt.BoxAiPromptReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: BoxAiPromptReducer.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/box/android/boxai/prompt/BoxAiPromptReducer$State;", "", "isVoiceInputSupported", "", "textInputState", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$State;", "voiceInputState", "Lcom/box/android/boxai/voice/VoiceInputReducer$State;", "audioPermissionsState", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$State;", "<init>", "(ZLcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$State;Lcom/box/android/boxai/voice/VoiceInputReducer$State;Lcom/box/android/base/presentation/components/permission/PermissionReducer$State;)V", "()Z", "getTextInputState", "()Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$State;", "getVoiceInputState", "()Lcom/box/android/boxai/voice/VoiceInputReducer$State;", "getAudioPermissionsState", "()Lcom/box/android/base/presentation/components/permission/PermissionReducer$State;", "promptOperation", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$PromptOperation;", "getPromptOperation", "()Lcom/box/android/boxai/prompt/BoxAiPromptReducer$PromptOperation;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final PermissionReducer.State audioPermissionsState;
        private final boolean isVoiceInputSupported;
        private final PromptOperation promptOperation;
        private final BasicInputBarReducer.State textInputState;
        private final VoiceInputReducer.State voiceInputState;

        public State() {
            this(false, null, null, null, 15, null);
        }

        public static /* synthetic */ State copy$default(State state, boolean z, BasicInputBarReducer.State state2, VoiceInputReducer.State state3, PermissionReducer.State state4, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.isVoiceInputSupported;
            }
            if ((i & 2) != 0) {
                state2 = state.textInputState;
            }
            if ((i & 4) != 0) {
                state3 = state.voiceInputState;
            }
            if ((i & 8) != 0) {
                state4 = state.audioPermissionsState;
            }
            return state.copy(z, state2, state3, state4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsVoiceInputSupported() {
            return this.isVoiceInputSupported;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final BasicInputBarReducer.State getTextInputState() {
            return this.textInputState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final VoiceInputReducer.State getVoiceInputState() {
            return this.voiceInputState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final PermissionReducer.State getAudioPermissionsState() {
            return this.audioPermissionsState;
        }

        public final State copy(boolean isVoiceInputSupported, BasicInputBarReducer.State textInputState, VoiceInputReducer.State voiceInputState, PermissionReducer.State audioPermissionsState) {
            Intrinsics.checkNotNullParameter(textInputState, "textInputState");
            Intrinsics.checkNotNullParameter(voiceInputState, "voiceInputState");
            Intrinsics.checkNotNullParameter(audioPermissionsState, "audioPermissionsState");
            return new State(isVoiceInputSupported, textInputState, voiceInputState, audioPermissionsState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.isVoiceInputSupported == state.isVoiceInputSupported && Intrinsics.areEqual(this.textInputState, state.textInputState) && Intrinsics.areEqual(this.voiceInputState, state.voiceInputState) && Intrinsics.areEqual(this.audioPermissionsState, state.audioPermissionsState);
        }

        public int hashCode() {
            return (((((Boolean.hashCode(this.isVoiceInputSupported) * 31) + this.textInputState.hashCode()) * 31) + this.voiceInputState.hashCode()) * 31) + this.audioPermissionsState.hashCode();
        }

        public String toString() {
            return "State(isVoiceInputSupported=" + this.isVoiceInputSupported + ", textInputState=" + this.textInputState + ", voiceInputState=" + this.voiceInputState + ", audioPermissionsState=" + this.audioPermissionsState + ")";
        }

        public State(boolean z, BasicInputBarReducer.State textInputState, VoiceInputReducer.State voiceInputState, PermissionReducer.State audioPermissionsState) {
            PromptOperation promptOperation;
            Intrinsics.checkNotNullParameter(textInputState, "textInputState");
            Intrinsics.checkNotNullParameter(voiceInputState, "voiceInputState");
            Intrinsics.checkNotNullParameter(audioPermissionsState, "audioPermissionsState");
            this.isVoiceInputSupported = z;
            this.textInputState = textInputState;
            this.voiceInputState = voiceInputState;
            this.audioPermissionsState = audioPermissionsState;
            if (!StringsKt.isBlank(textInputState.getTextField().getText())) {
                promptOperation = PromptOperation.SUBMIT;
            } else if (z) {
                promptOperation = PromptOperation.VOICE_INPUT;
            } else {
                if (z) {
                    throw new NoWhenBranchMatchedException();
                }
                promptOperation = null;
            }
            this.promptOperation = promptOperation;
        }

        public final boolean isVoiceInputSupported() {
            return this.isVoiceInputSupported;
        }

        public /* synthetic */ State(boolean z, BasicInputBarReducer.State state, VoiceInputReducer.State.Off off, PermissionReducer.State state2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new BasicInputBarReducer.State(null, null, 3, null) : state, (i & 4) != 0 ? new VoiceInputReducer.State.Off(false, 1, null) : off, (i & 8) != 0 ? new PermissionReducer.State(null, false, 3, null) : state2);
        }

        public final BasicInputBarReducer.State getTextInputState() {
            return this.textInputState;
        }

        public final VoiceInputReducer.State getVoiceInputState() {
            return this.voiceInputState;
        }

        public final PermissionReducer.State getAudioPermissionsState() {
            return this.audioPermissionsState;
        }

        public final PromptOperation getPromptOperation() {
            return this.promptOperation;
        }
    }

    /* JADX INFO: compiled from: BoxAiPromptReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \n2\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;", "", "<init>", "()V", "Initialize", "TextInputAction", "VoiceInputAction", "AudioPermissionsAction", "StartVoiceInput", "SubmitPrompt", "Companion", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$AudioPermissionsAction;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$Initialize;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$StartVoiceInput;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$SubmitPrompt;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$TextInputAction;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$VoiceInputAction;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BoxAiPromptReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$Initialize;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1956437551;
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

        /* JADX INFO: compiled from: BoxAiPromptReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$TextInputAction;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TextInputAction extends Action implements Embedded<BasicInputBarReducer.Action> {
            public static final int $stable = BasicInputBarReducer.Action.$stable;
            private final BasicInputBarReducer.Action action;

            public static /* synthetic */ TextInputAction copy$default(TextInputAction textInputAction, BasicInputBarReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = textInputAction.action;
                }
                return textInputAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BasicInputBarReducer.Action getAction() {
                return this.action;
            }

            public final TextInputAction copy(BasicInputBarReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new TextInputAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TextInputAction) && Intrinsics.areEqual(this.action, ((TextInputAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "TextInputAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TextInputAction(BasicInputBarReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BasicInputBarReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: BoxAiPromptReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$VoiceInputAction;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/boxai/voice/VoiceInputReducer$Action;)V", "getAction", "()Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class VoiceInputAction extends Action implements Embedded<VoiceInputReducer.Action> {
            public static final int $stable = 0;
            private final VoiceInputReducer.Action action;

            public static /* synthetic */ VoiceInputAction copy$default(VoiceInputAction voiceInputAction, VoiceInputReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = voiceInputAction.action;
                }
                return voiceInputAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final VoiceInputReducer.Action getAction() {
                return this.action;
            }

            public final VoiceInputAction copy(VoiceInputReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new VoiceInputAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof VoiceInputAction) && Intrinsics.areEqual(this.action, ((VoiceInputAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "VoiceInputAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public VoiceInputAction(VoiceInputReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final VoiceInputReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: BoxAiPromptReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$AudioPermissionsAction;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AudioPermissionsAction extends Action implements Embedded<PermissionReducer.Action> {
            public static final int $stable = PermissionReducer.Action.$stable;
            private final PermissionReducer.Action action;

            public static /* synthetic */ AudioPermissionsAction copy$default(AudioPermissionsAction audioPermissionsAction, PermissionReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = audioPermissionsAction.action;
                }
                return audioPermissionsAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PermissionReducer.Action getAction() {
                return this.action;
            }

            public final AudioPermissionsAction copy(PermissionReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new AudioPermissionsAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AudioPermissionsAction) && Intrinsics.areEqual(this.action, ((AudioPermissionsAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "AudioPermissionsAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AudioPermissionsAction(PermissionReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final PermissionReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: BoxAiPromptReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$StartVoiceInput;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;", "permissionToCheck", "", "<init>", "(Ljava/lang/String;)V", "getPermissionToCheck", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StartVoiceInput extends Action {
            public static final int $stable = 0;
            private final String permissionToCheck;

            public static /* synthetic */ StartVoiceInput copy$default(StartVoiceInput startVoiceInput, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = startVoiceInput.permissionToCheck;
                }
                return startVoiceInput.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPermissionToCheck() {
                return this.permissionToCheck;
            }

            public final StartVoiceInput copy(String permissionToCheck) {
                Intrinsics.checkNotNullParameter(permissionToCheck, "permissionToCheck");
                return new StartVoiceInput(permissionToCheck);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof StartVoiceInput) && Intrinsics.areEqual(this.permissionToCheck, ((StartVoiceInput) other).permissionToCheck);
            }

            public int hashCode() {
                return this.permissionToCheck.hashCode();
            }

            public String toString() {
                return "StartVoiceInput(permissionToCheck=" + this.permissionToCheck + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StartVoiceInput(String permissionToCheck) {
                super(null);
                Intrinsics.checkNotNullParameter(permissionToCheck, "permissionToCheck");
                this.permissionToCheck = permissionToCheck;
            }

            public final String getPermissionToCheck() {
                return this.permissionToCheck;
            }
        }

        /* JADX INFO: compiled from: BoxAiPromptReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$SubmitPrompt;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;", AuthenticationConstants.AAD.QUERY_PROMPT, "", "<init>", "(Ljava/lang/String;)V", "getPrompt", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: BoxAiPromptReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$Companion;", "", "<init>", "()V", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reducePromptAction(State state, Action action) {
        if (action instanceof Action.Initialize) {
            return new ReducerResult<>(State.copy$default(state, this.environment.getVoiceInputEnvironment().getSpeechRecognitionManager().isSpeechRecognitionSupported(), null, null, null, 14, null), null, 2, null);
        }
        if (action instanceof Action.TextInputAction) {
            if (((Action.TextInputAction) action).getAction() instanceof BasicInputBarReducer.Action.SubmitClicked) {
                return new ReducerResult<>(state, Effect.INSTANCE.merge(new Action.SubmitPrompt(state.getTextInputState().getTextField().getText()), BoxAiPromptReducerHelperKt.updatePrompt(Action.INSTANCE, new TextFieldValueUIModel("", 0, 0, null, 14, null))));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.VoiceInputAction) {
            Action.VoiceInputAction voiceInputAction = (Action.VoiceInputAction) action;
            if (voiceInputAction.getAction() instanceof VoiceInputReducer.Action.ListeningFinished) {
                int length = ((VoiceInputReducer.Action.ListeningFinished) voiceInputAction.getAction()).getText().length();
                return new ReducerResult<>(state, new Effect(BoxAiPromptReducerHelperKt.updatePrompt(Action.INSTANCE, new TextFieldValueUIModel(((VoiceInputReducer.Action.ListeningFinished) voiceInputAction.getAction()).getText(), length, length, null, 8, null))));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.AudioPermissionsAction) {
            Action.AudioPermissionsAction audioPermissionsAction = (Action.AudioPermissionsAction) action;
            if (audioPermissionsAction.getAction() instanceof PermissionReducer.Action.PermissionGranted) {
                return new ReducerResult<>(state, new Effect(new Action.StartVoiceInput(((PermissionReducer.Action.PermissionGranted) audioPermissionsAction.getAction()).getPermission())));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.StartVoiceInput) {
            if (!(state.getVoiceInputState() instanceof VoiceInputReducer.State.Off)) {
                return new ReducerResult<>(state, null, 2, null);
            }
            Action.StartVoiceInput startVoiceInput = (Action.StartVoiceInput) action;
            if (this.environment.getPermissionsHandler().isPermissionGranted(startVoiceInput.getPermissionToCheck())) {
                return new ReducerResult<>(state, new Effect(new Action.VoiceInputAction(VoiceInputReducer.Action.Initialize.INSTANCE)));
            }
            return new ReducerResult<>(state, new Effect(new Action.AudioPermissionsAction(new PermissionReducer.Action.RequestPermission(startVoiceInput.getPermissionToCheck()))));
        }
        if (action instanceof Action.SubmitPrompt) {
            return new ReducerResult<>(state, null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }
}
