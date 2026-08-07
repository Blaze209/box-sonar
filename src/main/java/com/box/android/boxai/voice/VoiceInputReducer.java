package com.box.android.boxai.voice;

import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: VoiceInputReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0015\u0016\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0002J\u0013\u0010\u0011\u001a\u00020\u0012*\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/boxai/voice/VoiceInputReducer$State;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "environment", "Lcom/box/android/boxai/voice/VoiceInputEnvironment;", "<init>", "(Lcom/box/android/boxai/voice/VoiceInputEnvironment;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "observeRecognitionEventsAsEffect", "Lcom/box/android/cpl/Effect;", "observeElapsedTimeAsEffect", "observeAudioLevelSamplesAsEffect", "cleanupAsEffect", "roundToWholeSeconds", "Lkotlin/time/Duration;", "roundToWholeSeconds-wmV0flA", "(J)J", "State", "Action", "Companion", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VoiceInputReducer implements Reducable<State, Action> {
    private static final String AUDIO_LEVEL_SAMPLES_EFFECT_ID = "audio_level_samples_effect_id";
    private static final long AUDIO_LEVEL_SAMPLE_INTERVAL;
    private static final String ELAPSED_TIME_EFFECT_ID = "elapsed_time_effect_id";
    private static final long ELAPSED_TIME_UPDATE_INTERVAL;
    private static final String RECOGNITION_STATE_EFFECT_ID = "recognition_state_effect_id";
    private final Reduce<State, Action> build;
    private final VoiceInputEnvironment environment;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public VoiceInputReducer(VoiceInputEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new Function2() { // from class: com.box.android.boxai.voice.VoiceInputReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return VoiceInputReducer.build$lambda$0(this.f$0, (VoiceInputReducer.State) obj, (VoiceInputReducer.Action) obj2);
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: VoiceInputReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0004\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$State;", "", "<init>", "()V", "elapsedTime", "Lkotlin/time/Duration;", "getElapsedTime-FghU774", "()Lkotlin/time/Duration;", "audioLevelSamples", "", "", "getAudioLevelSamples", "()Ljava/util/List;", "Off", "Starting", "Listening", "Finishing", "Lcom/box/android/boxai/voice/VoiceInputReducer$State$Finishing;", "Lcom/box/android/boxai/voice/VoiceInputReducer$State$Listening;", "Lcom/box/android/boxai/voice/VoiceInputReducer$State$Off;", "Lcom/box/android/boxai/voice/VoiceInputReducer$State$Starting;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class State {
        public static final int $stable = 8;
        private final List<Float> audioLevelSamples;
        private final Duration elapsedTime;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$State$Off;", "Lcom/box/android/boxai/voice/VoiceInputReducer$State;", "shouldShowError", "", "<init>", "(Z)V", "getShouldShowError", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Off extends State {
            public static final int $stable = 8;
            private final boolean shouldShowError;

            public Off() {
                this(false, 1, null);
            }

            public static /* synthetic */ Off copy$default(Off off, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = off.shouldShowError;
                }
                return off.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getShouldShowError() {
                return this.shouldShowError;
            }

            public final Off copy(boolean shouldShowError) {
                return new Off(shouldShowError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Off) && this.shouldShowError == ((Off) other).shouldShowError;
            }

            public int hashCode() {
                return Boolean.hashCode(this.shouldShowError);
            }

            public String toString() {
                return "Off(shouldShowError=" + this.shouldShowError + ")";
            }

            public Off(boolean z) {
                super(null);
                this.shouldShowError = z;
            }

            public /* synthetic */ Off(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z);
            }

            public final boolean getShouldShowError() {
                return this.shouldShowError;
            }
        }

        private State() {
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$State$Starting;", "Lcom/box/android/boxai/voice/VoiceInputReducer$State;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Starting extends State {
            public static final Starting INSTANCE = new Starting();
            public static final int $stable = 8;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Starting)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1811841309;
            }

            public String toString() {
                return "Starting";
            }

            private Starting() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J*\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$State$Listening;", "Lcom/box/android/boxai/voice/VoiceInputReducer$State;", "elapsedTime", "Lkotlin/time/Duration;", "audioLevelSamples", "", "", "<init>", "(JLjava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getElapsedTime-UwyO8pc", "()J", "J", "getAudioLevelSamples", "()Ljava/util/List;", "component1", "component1-UwyO8pc", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-VtjQ1oo", "(JLjava/util/List;)Lcom/box/android/boxai/voice/VoiceInputReducer$State$Listening;", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Listening extends State {
            public static final int $stable = 8;
            private final List<Float> audioLevelSamples;
            private final long elapsedTime;

            public /* synthetic */ Listening(long j, List list, DefaultConstructorMarker defaultConstructorMarker) {
                this(j, list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: copy-VtjQ1oo$default, reason: not valid java name */
            public static /* synthetic */ Listening m12154copyVtjQ1oo$default(Listening listening, long j, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = listening.elapsedTime;
                }
                if ((i & 2) != 0) {
                    list = listening.audioLevelSamples;
                }
                return listening.m12156copyVtjQ1oo(j, list);
            }

            /* JADX INFO: renamed from: component1-UwyO8pc, reason: not valid java name and from getter */
            public final long getElapsedTime() {
                return this.elapsedTime;
            }

            public final List<Float> component2() {
                return this.audioLevelSamples;
            }

            /* JADX INFO: renamed from: copy-VtjQ1oo, reason: not valid java name */
            public final Listening m12156copyVtjQ1oo(long elapsedTime, List<Float> audioLevelSamples) {
                Intrinsics.checkNotNullParameter(audioLevelSamples, "audioLevelSamples");
                return new Listening(elapsedTime, audioLevelSamples, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Listening)) {
                    return false;
                }
                Listening listening = (Listening) other;
                return Duration.m16161equalsimpl0(this.elapsedTime, listening.elapsedTime) && Intrinsics.areEqual(this.audioLevelSamples, listening.audioLevelSamples);
            }

            public int hashCode() {
                return (Duration.m16177hashCodeimpl(this.elapsedTime) * 31) + this.audioLevelSamples.hashCode();
            }

            public String toString() {
                return "Listening(elapsedTime=" + Duration.m16196toStringimpl(this.elapsedTime) + ", audioLevelSamples=" + this.audioLevelSamples + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            private Listening(long j, List<Float> audioLevelSamples) {
                super(null);
                Intrinsics.checkNotNullParameter(audioLevelSamples, "audioLevelSamples");
                this.elapsedTime = j;
                this.audioLevelSamples = audioLevelSamples;
            }

            @Override // com.box.android.boxai.voice.VoiceInputReducer.State
            /* JADX INFO: renamed from: getElapsedTime-FghU774 */
            public /* bridge */ /* synthetic */ Duration getElapsedTime() {
                return Duration.m16154boximpl(m12157getElapsedTimeUwyO8pc());
            }

            public /* synthetic */ Listening(long j, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? Duration.INSTANCE.m16251getZEROUwyO8pc() : j, (i & 2) != 0 ? CollectionsKt.emptyList() : list, null);
            }

            /* JADX INFO: renamed from: getElapsedTime-UwyO8pc, reason: not valid java name */
            public long m12157getElapsedTimeUwyO8pc() {
                return this.elapsedTime;
            }

            @Override // com.box.android.boxai.voice.VoiceInputReducer.State
            public List<Float> getAudioLevelSamples() {
                return this.audioLevelSamples;
            }
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J*\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$State$Finishing;", "Lcom/box/android/boxai/voice/VoiceInputReducer$State;", "elapsedTime", "Lkotlin/time/Duration;", "audioLevelSamples", "", "", "<init>", "(JLjava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getElapsedTime-UwyO8pc", "()J", "J", "getAudioLevelSamples", "()Ljava/util/List;", "component1", "component1-UwyO8pc", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-VtjQ1oo", "(JLjava/util/List;)Lcom/box/android/boxai/voice/VoiceInputReducer$State$Finishing;", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Finishing extends State {
            public static final int $stable = 8;
            private final List<Float> audioLevelSamples;
            private final long elapsedTime;

            public /* synthetic */ Finishing(long j, List list, DefaultConstructorMarker defaultConstructorMarker) {
                this(j, list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: copy-VtjQ1oo$default, reason: not valid java name */
            public static /* synthetic */ Finishing m12150copyVtjQ1oo$default(Finishing finishing, long j, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = finishing.elapsedTime;
                }
                if ((i & 2) != 0) {
                    list = finishing.audioLevelSamples;
                }
                return finishing.m12152copyVtjQ1oo(j, list);
            }

            /* JADX INFO: renamed from: component1-UwyO8pc, reason: not valid java name and from getter */
            public final long getElapsedTime() {
                return this.elapsedTime;
            }

            public final List<Float> component2() {
                return this.audioLevelSamples;
            }

            /* JADX INFO: renamed from: copy-VtjQ1oo, reason: not valid java name */
            public final Finishing m12152copyVtjQ1oo(long elapsedTime, List<Float> audioLevelSamples) {
                Intrinsics.checkNotNullParameter(audioLevelSamples, "audioLevelSamples");
                return new Finishing(elapsedTime, audioLevelSamples, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Finishing)) {
                    return false;
                }
                Finishing finishing = (Finishing) other;
                return Duration.m16161equalsimpl0(this.elapsedTime, finishing.elapsedTime) && Intrinsics.areEqual(this.audioLevelSamples, finishing.audioLevelSamples);
            }

            public int hashCode() {
                return (Duration.m16177hashCodeimpl(this.elapsedTime) * 31) + this.audioLevelSamples.hashCode();
            }

            public String toString() {
                return "Finishing(elapsedTime=" + Duration.m16196toStringimpl(this.elapsedTime) + ", audioLevelSamples=" + this.audioLevelSamples + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            private Finishing(long j, List<Float> audioLevelSamples) {
                super(null);
                Intrinsics.checkNotNullParameter(audioLevelSamples, "audioLevelSamples");
                this.elapsedTime = j;
                this.audioLevelSamples = audioLevelSamples;
            }

            @Override // com.box.android.boxai.voice.VoiceInputReducer.State
            public List<Float> getAudioLevelSamples() {
                return this.audioLevelSamples;
            }

            @Override // com.box.android.boxai.voice.VoiceInputReducer.State
            /* JADX INFO: renamed from: getElapsedTime-FghU774 */
            public /* bridge */ /* synthetic */ Duration getElapsedTime() {
                return Duration.m16154boximpl(m12153getElapsedTimeUwyO8pc());
            }

            /* JADX INFO: renamed from: getElapsedTime-UwyO8pc, reason: not valid java name */
            public long m12153getElapsedTimeUwyO8pc() {
                return this.elapsedTime;
            }
        }

        /* JADX INFO: renamed from: getElapsedTime-FghU774, reason: not valid java name and from getter */
        public Duration getElapsedTime() {
            return this.elapsedTime;
        }

        public List<Float> getAudioLevelSamples() {
            return this.audioLevelSamples;
        }
    }

    /* JADX INFO: compiled from: VoiceInputReducer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "", "<init>", "()V", "Initialize", "ListeningStarted", "ElapsedTimeUpdated", "AudioLevelSampleObtained", "FinishListening", "CancelListening", "ListeningFinished", "ListeningCancelled", "RecognitionError", "RecognitionErrorShown", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action$AudioLevelSampleObtained;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action$CancelListening;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action$ElapsedTimeUpdated;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action$FinishListening;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action$Initialize;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action$ListeningCancelled;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action$ListeningFinished;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action$ListeningStarted;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action$RecognitionError;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action$RecognitionErrorShown;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$Action$Initialize;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1175613032;
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

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$Action$ListeningStarted;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ListeningStarted extends Action {
            public static final int $stable = 0;
            public static final ListeningStarted INSTANCE = new ListeningStarted();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ListeningStarted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -393289698;
            }

            public String toString() {
                return "ListeningStarted";
            }

            private ListeningStarted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$Action$ElapsedTimeUpdated;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "elapsedTime", "Lkotlin/time/Duration;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getElapsedTime-UwyO8pc", "()J", "J", "component1", "component1-UwyO8pc", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-LRDsOJo", "(J)Lcom/box/android/boxai/voice/VoiceInputReducer$Action$ElapsedTimeUpdated;", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ElapsedTimeUpdated extends Action {
            public static final int $stable = 0;
            private final long elapsedTime;

            public /* synthetic */ ElapsedTimeUpdated(long j, DefaultConstructorMarker defaultConstructorMarker) {
                this(j);
            }

            /* JADX INFO: renamed from: copy-LRDsOJo$default, reason: not valid java name */
            public static /* synthetic */ ElapsedTimeUpdated m12144copyLRDsOJo$default(ElapsedTimeUpdated elapsedTimeUpdated, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = elapsedTimeUpdated.elapsedTime;
                }
                return elapsedTimeUpdated.m12146copyLRDsOJo(j);
            }

            /* JADX INFO: renamed from: component1-UwyO8pc, reason: not valid java name and from getter */
            public final long getElapsedTime() {
                return this.elapsedTime;
            }

            /* JADX INFO: renamed from: copy-LRDsOJo, reason: not valid java name */
            public final ElapsedTimeUpdated m12146copyLRDsOJo(long elapsedTime) {
                return new ElapsedTimeUpdated(elapsedTime, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ElapsedTimeUpdated) && Duration.m16161equalsimpl0(this.elapsedTime, ((ElapsedTimeUpdated) other).elapsedTime);
            }

            public int hashCode() {
                return Duration.m16177hashCodeimpl(this.elapsedTime);
            }

            public String toString() {
                return "ElapsedTimeUpdated(elapsedTime=" + Duration.m16196toStringimpl(this.elapsedTime) + ")";
            }

            private ElapsedTimeUpdated(long j) {
                super(null);
                this.elapsedTime = j;
            }

            /* JADX INFO: renamed from: getElapsedTime-UwyO8pc, reason: not valid java name */
            public final long m12147getElapsedTimeUwyO8pc() {
                return this.elapsedTime;
            }
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$Action$AudioLevelSampleObtained;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "sample", "", "<init>", "(F)V", "getSample", "()F", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AudioLevelSampleObtained extends Action {
            public static final int $stable = 0;
            private final float sample;

            public static /* synthetic */ AudioLevelSampleObtained copy$default(AudioLevelSampleObtained audioLevelSampleObtained, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = audioLevelSampleObtained.sample;
                }
                return audioLevelSampleObtained.copy(f);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final float getSample() {
                return this.sample;
            }

            public final AudioLevelSampleObtained copy(float sample) {
                return new AudioLevelSampleObtained(sample);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AudioLevelSampleObtained) && Float.compare(this.sample, ((AudioLevelSampleObtained) other).sample) == 0;
            }

            public int hashCode() {
                return Float.hashCode(this.sample);
            }

            public String toString() {
                return "AudioLevelSampleObtained(sample=" + this.sample + ")";
            }

            public AudioLevelSampleObtained(float f) {
                super(null);
                this.sample = f;
            }

            public final float getSample() {
                return this.sample;
            }
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$Action$FinishListening;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FinishListening extends Action {
            public static final int $stable = 0;
            public static final FinishListening INSTANCE = new FinishListening();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FinishListening)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1674359408;
            }

            public String toString() {
                return "FinishListening";
            }

            private FinishListening() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$Action$CancelListening;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CancelListening extends Action {
            public static final int $stable = 0;
            public static final CancelListening INSTANCE = new CancelListening();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CancelListening)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -30613623;
            }

            public String toString() {
                return "CancelListening";
            }

            private CancelListening() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$Action$ListeningFinished;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ListeningFinished extends Action {
            public static final int $stable = 0;
            private final String text;

            public static /* synthetic */ ListeningFinished copy$default(ListeningFinished listeningFinished, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = listeningFinished.text;
                }
                return listeningFinished.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final ListeningFinished copy(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                return new ListeningFinished(text);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ListeningFinished) && Intrinsics.areEqual(this.text, ((ListeningFinished) other).text);
            }

            public int hashCode() {
                return this.text.hashCode();
            }

            public String toString() {
                return "ListeningFinished(text=" + this.text + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ListeningFinished(String text) {
                super(null);
                Intrinsics.checkNotNullParameter(text, "text");
                this.text = text;
            }

            public final String getText() {
                return this.text;
            }
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$Action$ListeningCancelled;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ListeningCancelled extends Action {
            public static final int $stable = 0;
            public static final ListeningCancelled INSTANCE = new ListeningCancelled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ListeningCancelled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1683860050;
            }

            public String toString() {
                return "ListeningCancelled";
            }

            private ListeningCancelled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$Action$RecognitionError;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RecognitionError extends Action {
            public static final int $stable = 0;
            public static final RecognitionError INSTANCE = new RecognitionError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RecognitionError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 440909161;
            }

            public String toString() {
                return "RecognitionError";
            }

            private RecognitionError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VoiceInputReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$Action$RecognitionErrorShown;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RecognitionErrorShown extends Action {
            public static final int $stable = 0;
            public static final RecognitionErrorShown INSTANCE = new RecognitionErrorShown();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RecognitionErrorShown)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1979044136;
            }

            public String toString() {
                return "RecognitionErrorShown";
            }

            private RecognitionErrorShown() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(VoiceInputReducer voiceInputReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (action instanceof Action.Initialize) {
            if (state instanceof State.Off) {
                return new ReducerResult(State.Starting.INSTANCE, Effect.INSTANCE.merge(EffectKt.toEffect(FlowKt.flow(new VoiceInputReducer$build$1$1(voiceInputReducer, null))), voiceInputReducer.observeRecognitionEventsAsEffect()));
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.ListeningStarted) {
            return new ReducerResult(new State.Listening(0L, null, 3, null), Effect.INSTANCE.merge(voiceInputReducer.observeElapsedTimeAsEffect(), voiceInputReducer.observeAudioLevelSamplesAsEffect()));
        }
        if (action instanceof Action.ElapsedTimeUpdated) {
            if (state instanceof State.Listening) {
                return new ReducerResult(State.Listening.m12154copyVtjQ1oo$default((State.Listening) state, ((Action.ElapsedTimeUpdated) action).m12147getElapsedTimeUwyO8pc(), null, 2, null), null, 2, null);
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.AudioLevelSampleObtained) {
            if (state instanceof State.Listening) {
                State.Listening listening = (State.Listening) state;
                return new ReducerResult(State.Listening.m12154copyVtjQ1oo$default(listening, 0L, CollectionsKt.plus((Collection<? extends Float>) listening.getAudioLevelSamples(), Float.valueOf(((Action.AudioLevelSampleObtained) action).getSample())), 1, null), null, 2, null);
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.FinishListening) {
            if (state instanceof State.Listening) {
                State.Listening listening2 = (State.Listening) state;
                return new ReducerResult(new State.Finishing(listening2.m12157getElapsedTimeUwyO8pc(), listening2.getAudioLevelSamples(), defaultConstructorMarker), EffectKt.toEffect(FlowKt.flow(new VoiceInputReducer$build$1$2(voiceInputReducer, null))));
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.CancelListening) {
            if (state instanceof State.Listening) {
                State.Listening listening3 = (State.Listening) state;
                return new ReducerResult(new State.Finishing(listening3.m12157getElapsedTimeUwyO8pc(), listening3.getAudioLevelSamples(), defaultConstructorMarker), EffectKt.toEffect(FlowKt.flow(new VoiceInputReducer$build$1$3(voiceInputReducer, null))));
            }
            return new ReducerResult(state, null, 2, null);
        }
        if ((action instanceof Action.ListeningFinished) || (action instanceof Action.ListeningCancelled) || (action instanceof Action.RecognitionError)) {
            return new ReducerResult(new State.Off(action instanceof Action.RecognitionError), voiceInputReducer.cleanupAsEffect());
        }
        if (!(action instanceof Action.RecognitionErrorShown)) {
            throw new NoWhenBranchMatchedException();
        }
        if (state instanceof State.Off) {
            return new ReducerResult(((State.Off) state).copy(false), null, 2, null);
        }
        return new ReducerResult(state, null, 2, null);
    }

    private final Effect<Action> observeRecognitionEventsAsEffect() {
        return Effect.cancellable$default(EffectKt.toEffect(FlowKt.flow(new VoiceInputReducer$observeRecognitionEventsAsEffect$$inlined$transform$1(this.environment.getSpeechRecognitionManager().getRecognitionEventFlow(), null))), RECOGNITION_STATE_EFFECT_ID, false, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.boxai.voice.VoiceInputReducer$observeElapsedTimeAsEffect$1, reason: invalid class name */
    /* JADX INFO: compiled from: VoiceInputReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.voice.VoiceInputReducer$observeElapsedTimeAsEffect$1", f = "VoiceInputReducer.kt", i = {0, 0, 1, 1}, l = {183, 184}, m = "invokeSuspend", n = {"$this$flow", "elapsedTime", "$this$flow", "elapsedTime"}, s = {"L$0", "J$0", "L$0", "J$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = VoiceInputReducer.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0024  */
        /* JADX WARN: Code duplicated, block: B:13:0x0034  */
        /* JADX WARN: Code duplicated, block: B:14:0x003f  */
        /* JADX WARN: Code duplicated, block: B:18:0x005b A[PHI: r5
          0x005b: PHI (r5v4 long) = (r5v1 long), (r5v5 long) binds: [B:16:0x0058, B:9:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006c -> B:11:0x0024). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r9.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L21
                if (r2 == r4) goto L1b
                if (r2 != r3) goto L13
                goto L21
            L13:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1b:
                long r5 = r9.J$0
                kotlin.ResultKt.throwOnFailure(r10)
                goto L5b
            L21:
                kotlin.ResultKt.throwOnFailure(r10)
            L24:
                com.box.android.boxai.voice.VoiceInputReducer r10 = com.box.android.boxai.voice.VoiceInputReducer.this
                com.box.android.boxai.voice.VoiceInputEnvironment r10 = com.box.android.boxai.voice.VoiceInputReducer.access$getEnvironment$p(r10)
                com.box.android.boxai.voice.ISpeechRecognitionManager r10 = r10.getSpeechRecognitionManager()
                kotlin.time.Duration r10 = r10.mo12127getElapsedTimeFghU774()
                if (r10 == 0) goto L3f
                com.box.android.boxai.voice.VoiceInputReducer r2 = com.box.android.boxai.voice.VoiceInputReducer.this
                long r5 = r10.getRawValue()
                long r5 = com.box.android.boxai.voice.VoiceInputReducer.m12142access$roundToWholeSecondswmV0flA(r2, r5)
                goto L45
            L3f:
                kotlin.time.Duration$Companion r10 = kotlin.time.Duration.INSTANCE
                long r5 = r10.m16251getZEROUwyO8pc()
            L45:
                com.box.android.boxai.voice.VoiceInputReducer$Action$ElapsedTimeUpdated r10 = new com.box.android.boxai.voice.VoiceInputReducer$Action$ElapsedTimeUpdated
                r2 = 0
                r10.<init>(r5, r2)
                r2 = r9
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r9.L$0 = r0
                r9.J$0 = r5
                r9.label = r4
                java.lang.Object r10 = r0.emit(r10, r2)
                if (r10 != r1) goto L5b
                goto L6e
            L5b:
                long r7 = com.box.android.boxai.voice.VoiceInputReducer.access$getELAPSED_TIME_UPDATE_INTERVAL$cp()
                r10 = r9
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r9.L$0 = r0
                r9.J$0 = r5
                r9.label = r3
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.m16309delayVtjQ1oo(r7, r10)
                if (r10 != r1) goto L24
            L6e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.boxai.voice.VoiceInputReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Effect<Action> observeElapsedTimeAsEffect() {
        return Effect.cancellable$default(EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(null))), ELAPSED_TIME_EFFECT_ID, false, 2, null);
    }

    private final Effect<Action> observeAudioLevelSamplesAsEffect() {
        final Flow<RecognitionEvent> recognitionEventFlow = this.environment.getSpeechRecognitionManager().getRecognitionEventFlow();
        final Flow<Float> flowM12124resampleAndNormalizeAudioLevelHG0u8IE = AudioUtils.INSTANCE.m12124resampleAndNormalizeAudioLevelHG0u8IE(new Flow<Float>() { // from class: com.box.android.boxai.voice.VoiceInputReducer$observeAudioLevelSamplesAsEffect$$inlined$mapNotNull$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Float> flowCollector, Continuation continuation) {
                Object objCollect = recognitionEventFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.boxai.voice.VoiceInputReducer$observeAudioLevelSamplesAsEffect$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.boxai.voice.VoiceInputReducer$observeAudioLevelSamplesAsEffect$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.boxai.voice.VoiceInputReducer$observeAudioLevelSamplesAsEffect$$inlined$mapNotNull$1$2", f = "VoiceInputReducer.kt", i = {0, 0, 0, 0, 0, 0}, l = {52}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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
                        RecognitionEvent recognitionEvent = (RecognitionEvent) obj;
                        RecognitionEvent.AudioLevelSample audioLevelSample = recognitionEvent instanceof RecognitionEvent.AudioLevelSample ? (RecognitionEvent.AudioLevelSample) recognitionEvent : null;
                        Float fBoxFloat = audioLevelSample != null ? Boxing.boxFloat(audioLevelSample.getRmsdB()) : null;
                        if (fBoxFloat != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(fBoxFloat);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(fBoxFloat, anonymousClass1) == coroutine_suspended) {
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
        }, AUDIO_LEVEL_SAMPLE_INTERVAL);
        return Effect.cancellable$default(EffectKt.toEffect(new Flow<Action.AudioLevelSampleObtained>() { // from class: com.box.android.boxai.voice.VoiceInputReducer$observeAudioLevelSamplesAsEffect$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super VoiceInputReducer.Action.AudioLevelSampleObtained> flowCollector, Continuation continuation) {
                Object objCollect = flowM12124resampleAndNormalizeAudioLevelHG0u8IE.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.boxai.voice.VoiceInputReducer$observeAudioLevelSamplesAsEffect$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.boxai.voice.VoiceInputReducer$observeAudioLevelSamplesAsEffect$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.boxai.voice.VoiceInputReducer$observeAudioLevelSamplesAsEffect$$inlined$map$1$2", f = "VoiceInputReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                        VoiceInputReducer.Action.AudioLevelSampleObtained audioLevelSampleObtained = new VoiceInputReducer.Action.AudioLevelSampleObtained(((Number) obj).floatValue());
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(audioLevelSampleObtained, anonymousClass1) == coroutine_suspended) {
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
        }), AUDIO_LEVEL_SAMPLES_EFFECT_ID, false, 2, null);
    }

    private final Effect<Action> cleanupAsEffect() {
        return Effect.INSTANCE.merge(Effect.INSTANCE.cancel(RECOGNITION_STATE_EFFECT_ID), Effect.INSTANCE.cancel(ELAPSED_TIME_EFFECT_ID), Effect.INSTANCE.cancel(AUDIO_LEVEL_SAMPLES_EFFECT_ID));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: roundToWholeSeconds-wmV0flA, reason: not valid java name */
    public final long m12143roundToWholeSecondswmV0flA(long j) {
        Duration.Companion companion = Duration.INSTANCE;
        return DurationKt.toDuration(Duration.m16170getInWholeSecondsimpl(j), DurationUnit.SECONDS);
    }

    /* JADX INFO: compiled from: VoiceInputReducer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0013\u0010\u000b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputReducer$Companion;", "", "<init>", "()V", "RECOGNITION_STATE_EFFECT_ID", "", "ELAPSED_TIME_EFFECT_ID", "AUDIO_LEVEL_SAMPLES_EFFECT_ID", "ELAPSED_TIME_UPDATE_INTERVAL", "Lkotlin/time/Duration;", "J", "AUDIO_LEVEL_SAMPLE_INTERVAL", "getAUDIO_LEVEL_SAMPLE_INTERVAL-UwyO8pc", "()J", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getAUDIO_LEVEL_SAMPLE_INTERVAL-UwyO8pc, reason: not valid java name */
        public final long m12148getAUDIO_LEVEL_SAMPLE_INTERVALUwyO8pc() {
            return VoiceInputReducer.AUDIO_LEVEL_SAMPLE_INTERVAL;
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        ELAPSED_TIME_UPDATE_INTERVAL = DurationKt.toDuration(100, DurationUnit.MILLISECONDS);
        Duration.Companion companion2 = Duration.INSTANCE;
        AUDIO_LEVEL_SAMPLE_INTERVAL = DurationKt.toDuration(100, DurationUnit.MILLISECONDS);
    }
}
