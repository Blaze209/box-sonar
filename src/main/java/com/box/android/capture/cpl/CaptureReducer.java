package com.box.android.capture.cpl;

import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.capture.audiorecording.RecordingFileState;
import com.box.android.capture.audiorecording.cpl.AudioCaptureReducer;
import com.box.android.capture.audiorecording.cpl.AudioRecordingReducer;
import com.box.android.capture.audiorecording.cpl.AudioReviewReducer;
import com.box.android.capture.documentscanning.DocumentScanningReducer;
import com.box.android.capture.documentscanning.ScanPageReducer;
import com.box.android.capture.videorecording.VideoCaptureReducer;
import com.box.android.capture.videorecording.VideoRecordingReducer;
import com.box.android.capture.videorecording.VideoReviewReducer;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.capture.CaptureMode;
import com.box.android.domain.models.capture.FlashMode;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.usecases.capture.CaptureLocalItemsUseCase;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002)*B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0012H\u0002J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0016H\u0002J$\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J,\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J2\u0010\u001d\u001a\u00020\u001e2\"\u0010\u001f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0!\u0012\u0006\u0012\u0004\u0018\u00010\"0 H\u0082@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0082@¢\u0006\u0002\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006+"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/cpl/CaptureReducer$State;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "environment", "Lcom/box/android/capture/cpl/CaptureEnvironment;", "<init>", "(Lcom/box/android/capture/cpl/CaptureEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceCapture", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceVideo", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;", "reduceCamera", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "reduceDocumentScanning", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "reduceAudioRecording", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;", "updateFlashMode", "flashMode", "Lcom/box/android/domain/models/capture/FlashMode;", "startCaptureMode", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "getDefaultCaptureFolder", "", "emit", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUploadFolderServerId", "Lcom/box/android/domain/models/ItemId$Remote;", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "State", "Action", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final CaptureEnvironment environment;

    /* JADX INFO: compiled from: CaptureReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CaptureMode.values().length];
            try {
                iArr[CaptureMode.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CaptureMode.SCAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CaptureMode.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CaptureMode.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureReducer$updateUploadFolderServerId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureReducer", f = "CaptureReducer.kt", i = {0}, l = {TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID}, m = "updateUploadFolderServerId", n = {"itemId"}, s = {"L$0"}, v = 1)
    static final class C09751 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09751(Continuation<? super C09751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CaptureReducer.this.updateUploadFolderServerId(null, this);
        }
    }

    public CaptureReducer(CaptureEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new Function2() { // from class: com.box.android.capture.cpl.CaptureReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CaptureReducer.build$lambda$0(this.f$0, (CaptureReducer.State) obj, (CaptureReducer.Action) obj2);
            }
        });
        final CaptureReducer$build$2 captureReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.capture.cpl.CaptureReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CaptureReducer.State) obj).getCaptureModeState();
            }
        };
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ImageCaptureReducer.State.class);
        final CaptureReducer$build$3 captureReducer$build$3 = CaptureReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new ImageCaptureReducer(environment), new Function1<State, ImageCaptureReducer.State>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [com.box.android.capture.cpl.ImageCaptureReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ImageCaptureReducer.State invoke(CaptureReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return KClasses.safeCast(orCreateKotlinClass, captureReducer$build$2.invoke(it));
            }
        }, new Function1<Action, ImageCaptureReducer.Action>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$2
            @Override // kotlin.jvm.functions.Function1
            public final ImageCaptureReducer.Action invoke(CaptureReducer.Action action) {
                if (!(action instanceof CaptureReducer.Action.Camera)) {
                    action = null;
                }
                CaptureReducer.Action.Camera camera = (CaptureReducer.Action.Camera) action;
                if (camera != null) {
                    return camera.getAction();
                }
                return null;
            }
        }, new Function2<State, ImageCaptureReducer.State, State>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CaptureReducer.State invoke(CaptureReducer.State parentState, ImageCaptureReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = captureReducer$build$2;
                Iterator<T> it = kotlin.reflect.full.KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CaptureReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, childState)));
                        if (rCallBy != 0) {
                            return (CaptureReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.cpl.CaptureReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ImageCaptureReducer.Action, Action>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CaptureReducer.Action invoke(ImageCaptureReducer.Action action) {
                Object objInvoke = captureReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (CaptureReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.cpl.CaptureReducer.Action");
            }
        });
        final CaptureReducer$build$5 captureReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.capture.cpl.CaptureReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CaptureReducer.State) obj).getCaptureModeState();
            }
        };
        final KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(VideoCaptureReducer.State.class);
        final CaptureReducer$build$6 captureReducer$build$6 = CaptureReducer$build$6.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new VideoCaptureReducer(environment), new Function1<State, VideoCaptureReducer.State>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [com.box.android.capture.videorecording.VideoCaptureReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final VideoCaptureReducer.State invoke(CaptureReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return KClasses.safeCast(orCreateKotlinClass2, captureReducer$build$5.invoke(it));
            }
        }, new Function1<Action, VideoCaptureReducer.Action>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$6
            @Override // kotlin.jvm.functions.Function1
            public final VideoCaptureReducer.Action invoke(CaptureReducer.Action action) {
                if (!(action instanceof CaptureReducer.Action.Video)) {
                    action = null;
                }
                CaptureReducer.Action.Video video = (CaptureReducer.Action.Video) action;
                if (video != null) {
                    return video.getAction();
                }
                return null;
            }
        }, new Function2<State, VideoCaptureReducer.State, State>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CaptureReducer.State invoke(CaptureReducer.State parentState, VideoCaptureReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = captureReducer$build$5;
                Iterator<T> it = kotlin.reflect.full.KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CaptureReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, childState)));
                        if (rCallBy != 0) {
                            return (CaptureReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.cpl.CaptureReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<VideoCaptureReducer.Action, Action>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CaptureReducer.Action invoke(VideoCaptureReducer.Action action) {
                Object objInvoke = captureReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (CaptureReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.cpl.CaptureReducer.Action");
            }
        });
        final CaptureReducer$build$8 captureReducer$build$8 = new PropertyReference1Impl() { // from class: com.box.android.capture.cpl.CaptureReducer$build$8
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CaptureReducer.State) obj).getCaptureModeState();
            }
        };
        final KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(DocumentScanningReducer.State.class);
        final CaptureReducer$build$9 captureReducer$build$9 = CaptureReducer$build$9.INSTANCE;
        IfLetReducer ifLetReducer3 = new IfLetReducer(ifLetReducer2, new DocumentScanningReducer(environment.getDocumentScanningEnvironment()), new Function1<State, DocumentScanningReducer.State>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [com.box.android.capture.documentscanning.DocumentScanningReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final DocumentScanningReducer.State invoke(CaptureReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return KClasses.safeCast(orCreateKotlinClass3, captureReducer$build$8.invoke(it));
            }
        }, new Function1<Action, DocumentScanningReducer.Action>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$10
            @Override // kotlin.jvm.functions.Function1
            public final DocumentScanningReducer.Action invoke(CaptureReducer.Action action) {
                if (!(action instanceof CaptureReducer.Action.DocumentScanning)) {
                    action = null;
                }
                CaptureReducer.Action.DocumentScanning documentScanning = (CaptureReducer.Action.DocumentScanning) action;
                if (documentScanning != null) {
                    return documentScanning.getAction();
                }
                return null;
            }
        }, new Function2<State, DocumentScanningReducer.State, State>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$11
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CaptureReducer.State invoke(CaptureReducer.State parentState, DocumentScanningReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = captureReducer$build$8;
                Iterator<T> it = kotlin.reflect.full.KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CaptureReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, childState)));
                        if (rCallBy != 0) {
                            return (CaptureReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.cpl.CaptureReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<DocumentScanningReducer.Action, Action>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CaptureReducer.Action invoke(DocumentScanningReducer.Action action) {
                Object objInvoke = captureReducer$build$9.invoke(action);
                if (objInvoke != null) {
                    return (CaptureReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.cpl.CaptureReducer.Action");
            }
        });
        final CaptureReducer$build$11 captureReducer$build$11 = new PropertyReference1Impl() { // from class: com.box.android.capture.cpl.CaptureReducer$build$11
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CaptureReducer.State) obj).getCaptureModeState();
            }
        };
        final KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(AudioCaptureReducer.State.class);
        final CaptureReducer$build$12 captureReducer$build$12 = CaptureReducer$build$12.INSTANCE;
        IfLetReducer ifLetReducer4 = new IfLetReducer(ifLetReducer3, new AudioCaptureReducer(environment), new Function1<State, AudioCaptureReducer.State>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final AudioCaptureReducer.State invoke(CaptureReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return KClasses.safeCast(orCreateKotlinClass4, captureReducer$build$11.invoke(it));
            }
        }, new Function1<Action, AudioCaptureReducer.Action>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$14
            @Override // kotlin.jvm.functions.Function1
            public final AudioCaptureReducer.Action invoke(CaptureReducer.Action action) {
                if (!(action instanceof CaptureReducer.Action.AudioRecording)) {
                    action = null;
                }
                CaptureReducer.Action.AudioRecording audioRecording = (CaptureReducer.Action.AudioRecording) action;
                if (audioRecording != null) {
                    return audioRecording.getAction();
                }
                return null;
            }
        }, new Function2<State, AudioCaptureReducer.State, State>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$15
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CaptureReducer.State invoke(CaptureReducer.State parentState, AudioCaptureReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = captureReducer$build$11;
                Iterator<T> it = kotlin.reflect.full.KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CaptureReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, childState)));
                        if (rCallBy != 0) {
                            return (CaptureReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.cpl.CaptureReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<AudioCaptureReducer.Action, Action>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$16
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CaptureReducer.Action invoke(AudioCaptureReducer.Action action) {
                Object objInvoke = captureReducer$build$12.invoke(action);
                if (objInvoke != null) {
                    return (CaptureReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.cpl.CaptureReducer.Action");
            }
        });
        final CaptureReducer$build$14 captureReducer$build$14 = new PropertyReference1Impl() { // from class: com.box.android.capture.cpl.CaptureReducer$build$14
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CaptureReducer.State) obj).getCaptureModeState();
            }
        };
        final KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(CaptureSettingsReducer.State.class);
        final CaptureReducer$build$15 captureReducer$build$15 = CaptureReducer$build$15.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer4, new CaptureSettingsReducer(environment.getCaptureSettingsEnvironment()), new Function1<State, CaptureSettingsReducer.State>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [com.box.android.capture.cpl.CaptureSettingsReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CaptureSettingsReducer.State invoke(CaptureReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return KClasses.safeCast(orCreateKotlinClass5, captureReducer$build$14.invoke(it));
            }
        }, new Function1<Action, CaptureSettingsReducer.Action>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$18
            @Override // kotlin.jvm.functions.Function1
            public final CaptureSettingsReducer.Action invoke(CaptureReducer.Action action) {
                if (!(action instanceof CaptureReducer.Action.CaptureSettings)) {
                    action = null;
                }
                CaptureReducer.Action.CaptureSettings captureSettings = (CaptureReducer.Action.CaptureSettings) action;
                if (captureSettings != null) {
                    return captureSettings.getAction();
                }
                return null;
            }
        }, new Function2<State, CaptureSettingsReducer.State, State>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$19
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CaptureReducer.State invoke(CaptureReducer.State parentState, CaptureSettingsReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = captureReducer$build$14;
                Iterator<T> it = kotlin.reflect.full.KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CaptureReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, childState)));
                        if (rCallBy != 0) {
                            return (CaptureReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.cpl.CaptureReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CaptureSettingsReducer.Action, Action>() { // from class: com.box.android.capture.cpl.CaptureReducer$special$$inlined$ifCaseScope$20
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CaptureReducer.Action invoke(CaptureSettingsReducer.Action action) {
                Object objInvoke = captureReducer$build$15.invoke(action);
                if (objInvoke != null) {
                    return (CaptureReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.cpl.CaptureReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CaptureReducer.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\t\u0010:\u001a\u00020\u000bHÆ\u0003J\t\u0010;\u001a\u00020\u000fHÆ\u0003J\t\u0010<\u001a\u00020\u000bHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0012HÆ\u0003Ju\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010?\u001a\u00020\u000b2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020BHÖ\u0001J\t\u0010C\u001a\u00020DHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001dR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010&\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0011\u0010(\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0011\u00100\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0011\u00102\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001d¨\u0006E"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$State;", "", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "selectedFolder", "Lcom/box/android/domain/models/item/FolderModel;", "selectedFolderServerId", "Lcom/box/android/domain/models/ItemId$Remote;", "folderError", "Lcom/box/android/domain/models/DomainError;", "isSelectingFolder", "", "shouldShowProgress", "isClosing", "captureModeState", "Lcom/box/android/capture/cpl/CaptureModeState;", "captureHistoryVisible", "pendingCapturePreview", "Lcom/box/android/domain/models/CaptureHistoryModel;", "<init>", "(Lcom/box/android/domain/models/capture/CaptureMode;Lcom/box/android/domain/models/item/FolderModel;Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/models/DomainError;ZZZLcom/box/android/capture/cpl/CaptureModeState;ZLcom/box/android/domain/models/CaptureHistoryModel;)V", "getCaptureMode", "()Lcom/box/android/domain/models/capture/CaptureMode;", "getSelectedFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "getSelectedFolderServerId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getFolderError", "()Lcom/box/android/domain/models/DomainError;", "()Z", "getShouldShowProgress", "getCaptureModeState", "()Lcom/box/android/capture/cpl/CaptureModeState;", "getCaptureHistoryVisible", "getPendingCapturePreview", "()Lcom/box/android/domain/models/CaptureHistoryModel;", "topBarVisible", "getTopBarVisible", "elapsedTimeVisible", "getElapsedTimeVisible", "modeSwitcherVisible", "getModeSwitcherVisible", "flashMode", "Lcom/box/android/domain/models/capture/FlashMode;", "getFlashMode", "()Lcom/box/android/domain/models/capture/FlashMode;", "folderSelectionEnabled", "getFolderSelectionEnabled", "closeButtonVisible", "getCloseButtonVisible", "settingsButtonVisible", "getSettingsButtonVisible", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final boolean captureHistoryVisible;
        private final CaptureMode captureMode;
        private final CaptureModeState captureModeState;
        private final boolean closeButtonVisible;
        private final boolean elapsedTimeVisible;
        private final FlashMode flashMode;
        private final DomainError folderError;
        private final boolean folderSelectionEnabled;
        private final boolean isClosing;
        private final boolean isSelectingFolder;
        private final boolean modeSwitcherVisible;
        private final CaptureHistoryModel pendingCapturePreview;
        private final FolderModel selectedFolder;
        private final ItemId.Remote selectedFolderServerId;
        private final boolean settingsButtonVisible;
        private final boolean shouldShowProgress;
        private final boolean topBarVisible;

        public static /* synthetic */ State copy$default(State state, CaptureMode captureMode, FolderModel folderModel, ItemId.Remote remote, DomainError domainError, boolean z, boolean z2, boolean z3, CaptureModeState captureModeState, boolean z4, CaptureHistoryModel captureHistoryModel, int i, Object obj) {
            if ((i & 1) != 0) {
                captureMode = state.captureMode;
            }
            if ((i & 2) != 0) {
                folderModel = state.selectedFolder;
            }
            if ((i & 4) != 0) {
                remote = state.selectedFolderServerId;
            }
            if ((i & 8) != 0) {
                domainError = state.folderError;
            }
            if ((i & 16) != 0) {
                z = state.isSelectingFolder;
            }
            if ((i & 32) != 0) {
                z2 = state.shouldShowProgress;
            }
            if ((i & 64) != 0) {
                z3 = state.isClosing;
            }
            if ((i & 128) != 0) {
                captureModeState = state.captureModeState;
            }
            if ((i & 256) != 0) {
                z4 = state.captureHistoryVisible;
            }
            if ((i & 512) != 0) {
                captureHistoryModel = state.pendingCapturePreview;
            }
            boolean z5 = z4;
            CaptureHistoryModel captureHistoryModel2 = captureHistoryModel;
            boolean z6 = z3;
            CaptureModeState captureModeState2 = captureModeState;
            boolean z7 = z;
            boolean z8 = z2;
            return state.copy(captureMode, folderModel, remote, domainError, z7, z8, z6, captureModeState2, z5, captureHistoryModel2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CaptureMode getCaptureMode() {
            return this.captureMode;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final CaptureHistoryModel getPendingCapturePreview() {
            return this.pendingCapturePreview;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FolderModel getSelectedFolder() {
            return this.selectedFolder;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ItemId.Remote getSelectedFolderServerId() {
            return this.selectedFolderServerId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final DomainError getFolderError() {
            return this.folderError;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsSelectingFolder() {
            return this.isSelectingFolder;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getShouldShowProgress() {
            return this.shouldShowProgress;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsClosing() {
            return this.isClosing;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final CaptureModeState getCaptureModeState() {
            return this.captureModeState;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getCaptureHistoryVisible() {
            return this.captureHistoryVisible;
        }

        public final State copy(CaptureMode captureMode, FolderModel selectedFolder, ItemId.Remote selectedFolderServerId, DomainError folderError, boolean isSelectingFolder, boolean shouldShowProgress, boolean isClosing, CaptureModeState captureModeState, boolean captureHistoryVisible, CaptureHistoryModel pendingCapturePreview) {
            Intrinsics.checkNotNullParameter(captureMode, "captureMode");
            Intrinsics.checkNotNullParameter(captureModeState, "captureModeState");
            return new State(captureMode, selectedFolder, selectedFolderServerId, folderError, isSelectingFolder, shouldShowProgress, isClosing, captureModeState, captureHistoryVisible, pendingCapturePreview);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.captureMode == state.captureMode && Intrinsics.areEqual(this.selectedFolder, state.selectedFolder) && Intrinsics.areEqual(this.selectedFolderServerId, state.selectedFolderServerId) && Intrinsics.areEqual(this.folderError, state.folderError) && this.isSelectingFolder == state.isSelectingFolder && this.shouldShowProgress == state.shouldShowProgress && this.isClosing == state.isClosing && Intrinsics.areEqual(this.captureModeState, state.captureModeState) && this.captureHistoryVisible == state.captureHistoryVisible && Intrinsics.areEqual(this.pendingCapturePreview, state.pendingCapturePreview);
        }

        public int hashCode() {
            int iHashCode = this.captureMode.hashCode() * 31;
            FolderModel folderModel = this.selectedFolder;
            int iHashCode2 = (iHashCode + (folderModel == null ? 0 : folderModel.hashCode())) * 31;
            ItemId.Remote remote = this.selectedFolderServerId;
            int iHashCode3 = (iHashCode2 + (remote == null ? 0 : remote.hashCode())) * 31;
            DomainError domainError = this.folderError;
            int iHashCode4 = (((((((((((iHashCode3 + (domainError == null ? 0 : domainError.hashCode())) * 31) + Boolean.hashCode(this.isSelectingFolder)) * 31) + Boolean.hashCode(this.shouldShowProgress)) * 31) + Boolean.hashCode(this.isClosing)) * 31) + this.captureModeState.hashCode()) * 31) + Boolean.hashCode(this.captureHistoryVisible)) * 31;
            CaptureHistoryModel captureHistoryModel = this.pendingCapturePreview;
            return iHashCode4 + (captureHistoryModel != null ? captureHistoryModel.hashCode() : 0);
        }

        public String toString() {
            return "State(captureMode=" + this.captureMode + ", selectedFolder=" + this.selectedFolder + ", selectedFolderServerId=" + this.selectedFolderServerId + ", folderError=" + this.folderError + ", isSelectingFolder=" + this.isSelectingFolder + ", shouldShowProgress=" + this.shouldShowProgress + ", isClosing=" + this.isClosing + ", captureModeState=" + this.captureModeState + ", captureHistoryVisible=" + this.captureHistoryVisible + ", pendingCapturePreview=" + this.pendingCapturePreview + ")";
        }

        /* JADX WARN: Code duplicated, block: B:44:0x009d  */
        /* JADX WARN: Code duplicated, block: B:71:0x010d  */
        /* JADX WARN: Code duplicated, block: B:72:0x010f  */
        public State(CaptureMode captureMode, FolderModel folderModel, ItemId.Remote remote, DomainError domainError, boolean z, boolean z2, boolean z3, CaptureModeState captureModeState, boolean z4, CaptureHistoryModel captureHistoryModel) {
            boolean z5;
            Intrinsics.checkNotNullParameter(captureMode, "captureMode");
            Intrinsics.checkNotNullParameter(captureModeState, "captureModeState");
            this.captureMode = captureMode;
            this.selectedFolder = folderModel;
            this.selectedFolderServerId = remote;
            this.folderError = domainError;
            this.isSelectingFolder = z;
            this.shouldShowProgress = z2;
            this.isClosing = z3;
            this.captureModeState = captureModeState;
            this.captureHistoryVisible = z4;
            this.pendingCapturePreview = captureHistoryModel;
            boolean z6 = false;
            boolean z7 = ((captureModeState instanceof ImageCaptureReducer.State.Camera) || (captureModeState instanceof DocumentScanningReducer.State.ScanPage) || (captureModeState instanceof AudioCaptureReducer.State.Recording) || (captureModeState instanceof VideoCaptureReducer.State.Recording)) && !z4;
            this.topBarVisible = z7;
            this.elapsedTimeVisible = captureModeState instanceof VideoCaptureReducer.State.Recording ? ((VideoCaptureReducer.State.Recording) captureModeState).getState().isRecording() : false;
            if (!(captureModeState instanceof DocumentScanningReducer.State.ScanPage) ? !(captureModeState instanceof AudioCaptureReducer.State.Recording) ? !(!(captureModeState instanceof VideoCaptureReducer.State.Recording) ? !((captureModeState instanceof ImageCaptureReducer.State.PermissionRequired) || (captureModeState instanceof AudioCaptureReducer.State.PermissionRequired) || (captureModeState instanceof VideoCaptureReducer.State.PermissionsRequired) || (captureModeState instanceof DocumentScanningReducer.State.PermissionRequired) || (captureModeState instanceof ImageCaptureReducer.State.Camera)) : ((VideoCaptureReducer.State.Recording) captureModeState).getState().isRecording()) : ((AudioCaptureReducer.State.Recording) captureModeState).getState().toRecordingState() != RecordingFileState.NOT_RECORDING : ((DocumentScanningReducer.State.ScanPage) captureModeState).getState().getPageCount() == 0) {
                z5 = false;
            } else if (z4) {
                z5 = false;
            } else {
                z5 = true;
            }
            this.modeSwitcherVisible = z5;
            FlashMode flashMode = null;
            if (!z4) {
                if (captureModeState instanceof ImageCaptureReducer.State.Camera) {
                    flashMode = ((ImageCaptureReducer.State.Camera) captureModeState).getFlashMode();
                } else if (captureModeState instanceof DocumentScanningReducer.State.ScanPage) {
                    flashMode = ((DocumentScanningReducer.State.ScanPage) captureModeState).getState().getFlashMode();
                } else if (captureModeState instanceof VideoCaptureReducer.State.Recording) {
                    flashMode = ((VideoCaptureReducer.State.Recording) captureModeState).getState().getFlashMode();
                }
            }
            this.flashMode = flashMode;
            this.folderSelectionEnabled = !(captureModeState instanceof DocumentScanningReducer.State.ScanPage) ? !(!(captureModeState instanceof AudioCaptureReducer.State.Recording) || ((AudioCaptureReducer.State.Recording) captureModeState).getState().toRecordingState() == RecordingFileState.NOT_RECORDING) : ((DocumentScanningReducer.State.ScanPage) captureModeState).getState().getPageCount() != 0;
            if (captureModeState instanceof AudioCaptureReducer.State.Recording) {
                if (((AudioCaptureReducer.State.Recording) captureModeState).getState().toRecordingState() == RecordingFileState.NOT_RECORDING) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            } else if (captureModeState instanceof VideoCaptureReducer.State.Recording) {
                if (((VideoCaptureReducer.State.Recording) captureModeState).getState().isRecording()) {
                    z7 = false;
                } else {
                    z7 = true;
                }
            }
            this.closeButtonVisible = z7;
            if ((captureModeState instanceof DocumentScanningReducer.State.ScanPage) || (!(captureModeState instanceof AudioCaptureReducer.State.Recording) ? !(!(captureModeState instanceof VideoCaptureReducer.State.Recording) ? !(captureModeState instanceof ImageCaptureReducer.State.Camera) : ((VideoCaptureReducer.State.Recording) captureModeState).getState().isRecording()) : ((AudioCaptureReducer.State.Recording) captureModeState).getState().toRecordingState() == RecordingFileState.NOT_RECORDING)) {
                z6 = true;
            }
            this.settingsButtonVisible = z6;
        }

        public /* synthetic */ State(CaptureMode captureMode, FolderModel folderModel, ItemId.Remote remote, DomainError domainError, boolean z, boolean z2, boolean z3, CaptureModeState captureModeState, boolean z4, CaptureHistoryModel captureHistoryModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(captureMode, folderModel, remote, domainError, z, z2, z3, captureModeState, (i & 256) != 0 ? false : z4, (i & 512) != 0 ? null : captureHistoryModel);
        }

        public final CaptureMode getCaptureMode() {
            return this.captureMode;
        }

        public final FolderModel getSelectedFolder() {
            return this.selectedFolder;
        }

        public final ItemId.Remote getSelectedFolderServerId() {
            return this.selectedFolderServerId;
        }

        public final DomainError getFolderError() {
            return this.folderError;
        }

        public final boolean isSelectingFolder() {
            return this.isSelectingFolder;
        }

        public final boolean getShouldShowProgress() {
            return this.shouldShowProgress;
        }

        public final boolean isClosing() {
            return this.isClosing;
        }

        public final CaptureModeState getCaptureModeState() {
            return this.captureModeState;
        }

        public final boolean getCaptureHistoryVisible() {
            return this.captureHistoryVisible;
        }

        public final CaptureHistoryModel getPendingCapturePreview() {
            return this.pendingCapturePreview;
        }

        public final boolean getTopBarVisible() {
            return this.topBarVisible;
        }

        public final boolean getElapsedTimeVisible() {
            return this.elapsedTimeVisible;
        }

        public final boolean getModeSwitcherVisible() {
            return this.modeSwitcherVisible;
        }

        public final FlashMode getFlashMode() {
            return this.flashMode;
        }

        public final boolean getFolderSelectionEnabled() {
            return this.folderSelectionEnabled;
        }

        public final boolean getCloseButtonVisible() {
            return this.closeButtonVisible;
        }

        public final boolean getSettingsButtonVisible() {
            return this.settingsButtonVisible;
        }
    }

    /* JADX INFO: compiled from: CaptureReducer.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0016\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0016\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./¨\u00060"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action;", "", "<init>", "()V", "SwitchMode", "InitializeFolder", "ChangeFolder", "ChangeFolderHandled", "ChangeFolderFailed", "UpdateFolder", "FolderChanged", "TryCloseCapture", "TryUpdateFolderServerIdBeforeCloseCapture", "UpdateFolderServerIdAndClose", "CloseCapture", "ToggleFlashMode", "OpenCaptureHistory", "CloseCaptureHistory", "OpenCaptureSettings", "CaptureSettings", "Camera", "Video", "DocumentScanning", "AudioRecording", "Previewing", "PreviewExited", "Lcom/box/android/capture/cpl/CaptureReducer$Action$AudioRecording;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$Camera;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$CaptureSettings;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$ChangeFolder;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$ChangeFolderFailed;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$ChangeFolderHandled;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$CloseCapture;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$CloseCaptureHistory;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$DocumentScanning;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$FolderChanged;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$InitializeFolder;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$OpenCaptureHistory;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$OpenCaptureSettings;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$PreviewExited;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$Previewing;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$SwitchMode;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$ToggleFlashMode;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$TryCloseCapture;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$TryUpdateFolderServerIdBeforeCloseCapture;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$UpdateFolder;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$UpdateFolderServerIdAndClose;", "Lcom/box/android/capture/cpl/CaptureReducer$Action$Video;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$SwitchMode;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "<init>", "(Lcom/box/android/domain/models/capture/CaptureMode;)V", "getCaptureMode", "()Lcom/box/android/domain/models/capture/CaptureMode;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SwitchMode extends Action {
            public static final int $stable = 0;
            private final CaptureMode captureMode;

            public static /* synthetic */ SwitchMode copy$default(SwitchMode switchMode, CaptureMode captureMode, int i, Object obj) {
                if ((i & 1) != 0) {
                    captureMode = switchMode.captureMode;
                }
                return switchMode.copy(captureMode);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CaptureMode getCaptureMode() {
                return this.captureMode;
            }

            public final SwitchMode copy(CaptureMode captureMode) {
                Intrinsics.checkNotNullParameter(captureMode, "captureMode");
                return new SwitchMode(captureMode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SwitchMode) && this.captureMode == ((SwitchMode) other).captureMode;
            }

            public int hashCode() {
                return this.captureMode.hashCode();
            }

            public String toString() {
                return "SwitchMode(captureMode=" + this.captureMode + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SwitchMode(CaptureMode captureMode) {
                super(null);
                Intrinsics.checkNotNullParameter(captureMode, "captureMode");
                this.captureMode = captureMode;
            }

            public final CaptureMode getCaptureMode() {
                return this.captureMode;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$InitializeFolder;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "initialFolderId", "", "initialMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/capture/CaptureMode;)V", "getInitialFolderId", "()Ljava/lang/String;", "getInitialMode", "()Lcom/box/android/domain/models/capture/CaptureMode;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InitializeFolder extends Action {
            public static final int $stable = 0;
            private final String initialFolderId;
            private final CaptureMode initialMode;

            /* JADX WARN: Multi-variable type inference failed */
            public InitializeFolder() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ InitializeFolder copy$default(InitializeFolder initializeFolder, String str, CaptureMode captureMode, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = initializeFolder.initialFolderId;
                }
                if ((i & 2) != 0) {
                    captureMode = initializeFolder.initialMode;
                }
                return initializeFolder.copy(str, captureMode);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getInitialFolderId() {
                return this.initialFolderId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final CaptureMode getInitialMode() {
                return this.initialMode;
            }

            public final InitializeFolder copy(String initialFolderId, CaptureMode initialMode) {
                return new InitializeFolder(initialFolderId, initialMode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InitializeFolder)) {
                    return false;
                }
                InitializeFolder initializeFolder = (InitializeFolder) other;
                return Intrinsics.areEqual(this.initialFolderId, initializeFolder.initialFolderId) && this.initialMode == initializeFolder.initialMode;
            }

            public int hashCode() {
                String str = this.initialFolderId;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                CaptureMode captureMode = this.initialMode;
                return iHashCode + (captureMode != null ? captureMode.hashCode() : 0);
            }

            public String toString() {
                return "InitializeFolder(initialFolderId=" + this.initialFolderId + ", initialMode=" + this.initialMode + ")";
            }

            public InitializeFolder(String str, CaptureMode captureMode) {
                super(null);
                this.initialFolderId = str;
                this.initialMode = captureMode;
            }

            public /* synthetic */ InitializeFolder(String str, CaptureMode captureMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : captureMode);
            }

            public final String getInitialFolderId() {
                return this.initialFolderId;
            }

            public final CaptureMode getInitialMode() {
                return this.initialMode;
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$ChangeFolder;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ChangeFolder extends Action {
            public static final int $stable = 0;
            public static final ChangeFolder INSTANCE = new ChangeFolder();

            private ChangeFolder() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$ChangeFolderHandled;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ChangeFolderHandled extends Action {
            public static final int $stable = 0;
            public static final ChangeFolderHandled INSTANCE = new ChangeFolderHandled();

            private ChangeFolderHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$ChangeFolderFailed;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "domainError", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getDomainError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ChangeFolderFailed extends Action {
            public static final int $stable = 8;
            private final DomainError domainError;

            public static /* synthetic */ ChangeFolderFailed copy$default(ChangeFolderFailed changeFolderFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = changeFolderFailed.domainError;
                }
                return changeFolderFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getDomainError() {
                return this.domainError;
            }

            public final ChangeFolderFailed copy(DomainError domainError) {
                Intrinsics.checkNotNullParameter(domainError, "domainError");
                return new ChangeFolderFailed(domainError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChangeFolderFailed) && Intrinsics.areEqual(this.domainError, ((ChangeFolderFailed) other).domainError);
            }

            public int hashCode() {
                return this.domainError.hashCode();
            }

            public String toString() {
                return "ChangeFolderFailed(domainError=" + this.domainError + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChangeFolderFailed(DomainError domainError) {
                super(null);
                Intrinsics.checkNotNullParameter(domainError, "domainError");
                this.domainError = domainError;
            }

            public final DomainError getDomainError() {
                return this.domainError;
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$UpdateFolder;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "selectedFolder", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getSelectedFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateFolder extends Action {
            public static final int $stable = 8;
            private final FolderModel selectedFolder;

            public static /* synthetic */ UpdateFolder copy$default(UpdateFolder updateFolder, FolderModel folderModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = updateFolder.selectedFolder;
                }
                return updateFolder.copy(folderModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getSelectedFolder() {
                return this.selectedFolder;
            }

            public final UpdateFolder copy(FolderModel selectedFolder) {
                Intrinsics.checkNotNullParameter(selectedFolder, "selectedFolder");
                return new UpdateFolder(selectedFolder);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateFolder) && Intrinsics.areEqual(this.selectedFolder, ((UpdateFolder) other).selectedFolder);
            }

            public int hashCode() {
                return this.selectedFolder.hashCode();
            }

            public String toString() {
                return "UpdateFolder(selectedFolder=" + this.selectedFolder + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateFolder(FolderModel selectedFolder) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedFolder, "selectedFolder");
                this.selectedFolder = selectedFolder;
            }

            public final FolderModel getSelectedFolder() {
                return this.selectedFolder;
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$FolderChanged;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "selectedFolder", "Lcom/box/android/domain/models/item/FolderModel;", "folderServerId", "Lcom/box/android/domain/models/ItemId$Remote;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;Lcom/box/android/domain/models/ItemId$Remote;)V", "getSelectedFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "getFolderServerId", "()Lcom/box/android/domain/models/ItemId$Remote;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FolderChanged extends Action {
            public static final int $stable = 8;
            private final ItemId.Remote folderServerId;
            private final FolderModel selectedFolder;

            public static /* synthetic */ FolderChanged copy$default(FolderChanged folderChanged, FolderModel folderModel, ItemId.Remote remote, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = folderChanged.selectedFolder;
                }
                if ((i & 2) != 0) {
                    remote = folderChanged.folderServerId;
                }
                return folderChanged.copy(folderModel, remote);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getSelectedFolder() {
                return this.selectedFolder;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ItemId.Remote getFolderServerId() {
                return this.folderServerId;
            }

            public final FolderChanged copy(FolderModel selectedFolder, ItemId.Remote folderServerId) {
                Intrinsics.checkNotNullParameter(selectedFolder, "selectedFolder");
                Intrinsics.checkNotNullParameter(folderServerId, "folderServerId");
                return new FolderChanged(selectedFolder, folderServerId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FolderChanged)) {
                    return false;
                }
                FolderChanged folderChanged = (FolderChanged) other;
                return Intrinsics.areEqual(this.selectedFolder, folderChanged.selectedFolder) && Intrinsics.areEqual(this.folderServerId, folderChanged.folderServerId);
            }

            public int hashCode() {
                return (this.selectedFolder.hashCode() * 31) + this.folderServerId.hashCode();
            }

            public String toString() {
                return "FolderChanged(selectedFolder=" + this.selectedFolder + ", folderServerId=" + this.folderServerId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FolderChanged(FolderModel selectedFolder, ItemId.Remote folderServerId) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedFolder, "selectedFolder");
                Intrinsics.checkNotNullParameter(folderServerId, "folderServerId");
                this.selectedFolder = selectedFolder;
                this.folderServerId = folderServerId;
            }

            public final ItemId.Remote getFolderServerId() {
                return this.folderServerId;
            }

            public final FolderModel getSelectedFolder() {
                return this.selectedFolder;
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$TryCloseCapture;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class TryCloseCapture extends Action {
            public static final int $stable = 0;
            public static final TryCloseCapture INSTANCE = new TryCloseCapture();

            private TryCloseCapture() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$TryUpdateFolderServerIdBeforeCloseCapture;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class TryUpdateFolderServerIdBeforeCloseCapture extends Action {
            public static final int $stable = 0;
            public static final TryUpdateFolderServerIdBeforeCloseCapture INSTANCE = new TryUpdateFolderServerIdBeforeCloseCapture();

            private TryUpdateFolderServerIdBeforeCloseCapture() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$UpdateFolderServerIdAndClose;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "folderServerId", "Lcom/box/android/domain/models/ItemId$Remote;", "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;)V", "getFolderServerId", "()Lcom/box/android/domain/models/ItemId$Remote;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateFolderServerIdAndClose extends Action {
            public static final int $stable = 8;
            private final ItemId.Remote folderServerId;

            public static /* synthetic */ UpdateFolderServerIdAndClose copy$default(UpdateFolderServerIdAndClose updateFolderServerIdAndClose, ItemId.Remote remote, int i, Object obj) {
                if ((i & 1) != 0) {
                    remote = updateFolderServerIdAndClose.folderServerId;
                }
                return updateFolderServerIdAndClose.copy(remote);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemId.Remote getFolderServerId() {
                return this.folderServerId;
            }

            public final UpdateFolderServerIdAndClose copy(ItemId.Remote folderServerId) {
                Intrinsics.checkNotNullParameter(folderServerId, "folderServerId");
                return new UpdateFolderServerIdAndClose(folderServerId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateFolderServerIdAndClose) && Intrinsics.areEqual(this.folderServerId, ((UpdateFolderServerIdAndClose) other).folderServerId);
            }

            public int hashCode() {
                return this.folderServerId.hashCode();
            }

            public String toString() {
                return "UpdateFolderServerIdAndClose(folderServerId=" + this.folderServerId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateFolderServerIdAndClose(ItemId.Remote folderServerId) {
                super(null);
                Intrinsics.checkNotNullParameter(folderServerId, "folderServerId");
                this.folderServerId = folderServerId;
            }

            public final ItemId.Remote getFolderServerId() {
                return this.folderServerId;
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$CloseCapture;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CloseCapture extends Action {
            public static final int $stable = 0;
            public static final CloseCapture INSTANCE = new CloseCapture();

            private CloseCapture() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$ToggleFlashMode;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ToggleFlashMode extends Action {
            public static final int $stable = 0;
            public static final ToggleFlashMode INSTANCE = new ToggleFlashMode();

            private ToggleFlashMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$OpenCaptureHistory;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class OpenCaptureHistory extends Action {
            public static final int $stable = 0;
            public static final OpenCaptureHistory INSTANCE = new OpenCaptureHistory();

            private OpenCaptureHistory() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$CloseCaptureHistory;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CloseCaptureHistory extends Action {
            public static final int $stable = 0;
            public static final CloseCaptureHistory INSTANCE = new CloseCaptureHistory();

            private CloseCaptureHistory() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$OpenCaptureSettings;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class OpenCaptureSettings extends Action {
            public static final int $stable = 0;
            public static final OpenCaptureSettings INSTANCE = new OpenCaptureSettings();

            private OpenCaptureSettings() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$CaptureSettings;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;)V", "getAction", "()Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CaptureSettings extends Action implements Embedded<CaptureSettingsReducer.Action> {
            public static final int $stable = 0;
            private final CaptureSettingsReducer.Action action;

            public static /* synthetic */ CaptureSettings copy$default(CaptureSettings captureSettings, CaptureSettingsReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = captureSettings.action;
                }
                return captureSettings.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CaptureSettingsReducer.Action getAction() {
                return this.action;
            }

            public final CaptureSettings copy(CaptureSettingsReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CaptureSettings(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CaptureSettings) && Intrinsics.areEqual(this.action, ((CaptureSettings) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CaptureSettings(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CaptureSettings(CaptureSettingsReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CaptureSettingsReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$Camera;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;)V", "getAction", "()Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Camera extends Action implements Embedded<ImageCaptureReducer.Action> {
            public static final int $stable = 0;
            private final ImageCaptureReducer.Action action;

            public static /* synthetic */ Camera copy$default(Camera camera, ImageCaptureReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = camera.action;
                }
                return camera.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ImageCaptureReducer.Action getAction() {
                return this.action;
            }

            public final Camera copy(ImageCaptureReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Camera(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Camera) && Intrinsics.areEqual(this.action, ((Camera) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Camera(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Camera(ImageCaptureReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ImageCaptureReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$Video;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;)V", "getAction", "()Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Video extends Action implements Embedded<VideoCaptureReducer.Action> {
            public static final int $stable = 0;
            private final VideoCaptureReducer.Action action;

            public static /* synthetic */ Video copy$default(Video video, VideoCaptureReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = video.action;
                }
                return video.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final VideoCaptureReducer.Action getAction() {
                return this.action;
            }

            public final Video copy(VideoCaptureReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Video(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Video) && Intrinsics.areEqual(this.action, ((Video) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Video(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Video(VideoCaptureReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final VideoCaptureReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$DocumentScanning;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;)V", "getAction", "()Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DocumentScanning extends Action implements Embedded<DocumentScanningReducer.Action> {
            public static final int $stable = 0;
            private final DocumentScanningReducer.Action action;

            public static /* synthetic */ DocumentScanning copy$default(DocumentScanning documentScanning, DocumentScanningReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = documentScanning.action;
                }
                return documentScanning.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentScanningReducer.Action getAction() {
                return this.action;
            }

            public final DocumentScanning copy(DocumentScanningReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new DocumentScanning(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DocumentScanning) && Intrinsics.areEqual(this.action, ((DocumentScanning) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "DocumentScanning(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DocumentScanning(DocumentScanningReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final DocumentScanningReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$AudioRecording;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;)V", "getAction", "()Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AudioRecording extends Action implements Embedded<AudioCaptureReducer.Action> {
            public static final int $stable = 0;
            private final AudioCaptureReducer.Action action;

            public static /* synthetic */ AudioRecording copy$default(AudioRecording audioRecording, AudioCaptureReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = audioRecording.action;
                }
                return audioRecording.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AudioCaptureReducer.Action getAction() {
                return this.action;
            }

            public final AudioRecording copy(AudioCaptureReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new AudioRecording(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AudioRecording) && Intrinsics.areEqual(this.action, ((AudioRecording) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "AudioRecording(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AudioRecording(AudioCaptureReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final AudioCaptureReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$Previewing;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "item", "Lcom/box/android/domain/models/CaptureHistoryModel;", "<init>", "(Lcom/box/android/domain/models/CaptureHistoryModel;)V", "getItem", "()Lcom/box/android/domain/models/CaptureHistoryModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Previewing extends Action {
            public static final int $stable = 8;
            private final CaptureHistoryModel item;

            public static /* synthetic */ Previewing copy$default(Previewing previewing, CaptureHistoryModel captureHistoryModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    captureHistoryModel = previewing.item;
                }
                return previewing.copy(captureHistoryModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CaptureHistoryModel getItem() {
                return this.item;
            }

            public final Previewing copy(CaptureHistoryModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new Previewing(item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Previewing) && Intrinsics.areEqual(this.item, ((Previewing) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            public String toString() {
                return "Previewing(item=" + this.item + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Previewing(CaptureHistoryModel item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            public final CaptureHistoryModel getItem() {
                return this.item;
            }
        }

        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureReducer$Action$PreviewExited;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PreviewExited extends Action {
            public static final int $stable = 0;
            public static final PreviewExited INSTANCE = new PreviewExited();

            private PreviewExited() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(CaptureReducer captureReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        return captureReducer.reduceCapture(state, action);
    }

    private final ReducerResult<State, Action> reduceCapture(State state, Action action) {
        ReducerResult<State, Action> reducerResultUpdateFlashMode;
        if (action instanceof Action.InitializeFolder) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, true, false, null, false, null, 991, null), EffectKt.toEffect(FlowKt.flow(new C09711(action, this, null))));
        }
        if (action instanceof Action.Previewing) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, false, null, false, ((Action.Previewing) action).getItem(), 511, null), null, 2, null);
        }
        if (action instanceof Action.PreviewExited) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, false, null, false, null, 511, null), null, 2, null);
        }
        if (action instanceof Action.ChangeFolderFailed) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, ((Action.ChangeFolderFailed) action).getDomainError(), false, false, false, null, false, null, 983, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.ChangeFolder.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, true, false, false, null, false, null, 1007, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.ChangeFolderHandled.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, false, null, false, null, 1007, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.TryCloseCapture.INSTANCE)) {
            if (state.getCaptureModeState() instanceof DocumentScanningReducer.State.ScanPage) {
                return new ReducerResult<>(state, new Effect(new Action.DocumentScanning(new DocumentScanningReducer.Action.Scanning(ScanPageReducer.Action.TryDiscardScans.INSTANCE))));
            }
            return new ReducerResult<>(state, new Effect(Action.TryUpdateFolderServerIdBeforeCloseCapture.INSTANCE));
        }
        if (Intrinsics.areEqual(action, Action.CloseCapture.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, true, null, false, null, 959, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.TryUpdateFolderServerIdBeforeCloseCapture.INSTANCE)) {
            return new ReducerResult<>(state, new Effect((Function1) new C09722(state, this, null)));
        }
        if (action instanceof Action.UpdateFolderServerIdAndClose) {
            return new ReducerResult<>(State.copy$default(state, null, null, ((Action.UpdateFolderServerIdAndClose) action).getFolderServerId(), null, false, false, false, null, false, null, 1019, null), new Effect(Action.CloseCapture.INSTANCE));
        }
        if (Intrinsics.areEqual(action, Action.ToggleFlashMode.INSTANCE)) {
            FlashMode flashMode = state.getFlashMode();
            return (flashMode == null || (reducerResultUpdateFlashMode = updateFlashMode(state, flashMode.next())) == null) ? new ReducerResult<>(state, null, 2, null) : reducerResultUpdateFlashMode;
        }
        if (action instanceof Action.SwitchMode) {
            return startCaptureMode(this.environment, state, ((Action.SwitchMode) action).getCaptureMode());
        }
        if (action instanceof Action.UpdateFolder) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass4(action, null)));
        }
        if (action instanceof Action.FolderChanged) {
            Action.FolderChanged folderChanged = (Action.FolderChanged) action;
            return new ReducerResult<>(State.copy$default(state, null, folderChanged.getSelectedFolder(), folderChanged.getFolderServerId(), null, false, false, false, null, false, null, 961, null), null, 2, null);
        }
        if (action instanceof Action.Video) {
            return reduceVideo(((Action.Video) action).getAction(), state);
        }
        if (action instanceof Action.Camera) {
            return reduceCamera(state, ((Action.Camera) action).getAction());
        }
        if (action instanceof Action.DocumentScanning) {
            return reduceDocumentScanning(state, ((Action.DocumentScanning) action).getAction());
        }
        if (action instanceof Action.AudioRecording) {
            return reduceAudioRecording(state, ((Action.AudioRecording) action).getAction());
        }
        if (Intrinsics.areEqual(action, Action.CloseCaptureHistory.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, false, null, false, null, 767, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.OpenCaptureHistory.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, false, null, true, null, 767, null), null, 2, null);
        }
        if (action instanceof Action.CaptureSettings) {
            if (((Action.CaptureSettings) action).getAction() instanceof CaptureSettingsReducer.Action.CloseSettings) {
                return startCaptureMode(this.environment, state, this.environment.getCapturePreferencesService().getLastUsedMode(CaptureMode.PHOTO));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (!Intrinsics.areEqual(action, Action.OpenCaptureSettings.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, false, new CaptureSettingsReducer.State(this.environment.getCaptureSettingsEnvironment().getLaunchIntoCaptureUseCase().getLaunchIntoCapturePreference(), this.environment.getCaptureSettingsEnvironment().getCapturePreferencesService().getReviewPhotoAfterCapture(), this.environment.getCaptureSettingsEnvironment().getCapturePreferencesService().getPhotoQuality(), this.environment.getCaptureSettingsEnvironment().getCapturePreferencesService().getVideoQuality(), this.environment.getCaptureSettingsEnvironment().getCapturePreferencesService().getSaveGpsLocation(), false, 32, null), false, null, 895, null), null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureReducer$reduceCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureReducer$reduceCapture$1", f = "CaptureReducer.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4}, l = {198, 200, 204, 207, BoxCommonConstants.REQUEST_OPTIONS}, m = "invokeSuspend", n = {"$this$flow", "it", "$i$a$-let-CaptureReducer$reduceCapture$1$1", "$this$flow", "it", "$i$a$-let-CaptureReducer$reduceCapture$1$2", "$this$flow", "it", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "folder", "$i$a$-let-CaptureReducer$reduceCapture$1$2", "$i$a$-let-CaptureReducer$reduceCapture$1$2$1", "$this$flow", "it", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$i$a$-let-CaptureReducer$reduceCapture$1$2", "$i$a$-let-CaptureReducer$reduceCapture$1$2$1", "$this$flow"}, s = {"L$0", "L$1", "I$0", "L$0", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0"}, v = 1)
    static final class C09711 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ CaptureReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09711(Action action, CaptureReducer captureReducer, Continuation<? super C09711> continuation) {
            super(2, continuation);
            this.$action = action;
            this.this$0 = captureReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09711 c09711 = new C09711(this.$action, this.this$0, continuation);
            c09711.L$0 = obj;
            return c09711;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C09711) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:33:0x00e7  */
        /* JADX WARN: Code duplicated, block: B:35:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:38:0x010d  */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00e4, code lost:
        
            if (r0.emit(r6, r11) == r1) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x010a, code lost:
        
            if (r6.getDefaultCaptureFolder(r5, r11) == r1) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0131, code lost:
        
            if (r11.this$0.getDefaultCaptureFolder(new com.box.android.capture.cpl.CaptureReducer.C09711.AnonymousClass3(r0, null), r11) == r1) goto L42;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 311
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.cpl.CaptureReducer.C09711.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureReducer$reduceCapture$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: CaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/box/android/capture/cpl/CaptureReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.cpl.CaptureReducer$reduceCapture$1$3", f = "CaptureReducer.kt", i = {0}, l = {BoxCommonConstants.REQUEST_OPTIONS}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<Action, Continuation<? super Unit>, Object> {
            final /* synthetic */ FlowCollector<Action> $$this$flow;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(FlowCollector<? super Action> flowCollector, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$$this$flow = flowCollector;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$$this$flow, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Action action, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(action, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Action action = (Action) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.label = 1;
                    if (this.$$this$flow.emit(action, this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureReducer$reduceCapture$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/cpl/CaptureReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureReducer$reduceCapture$2", f = "CaptureReducer.kt", i = {0, 0}, l = {268}, m = "invokeSuspend", n = {"it", "$i$a$-let-CaptureReducer$reduceCapture$2$1"}, s = {"L$0", "I$0"}, v = 1)
    static final class C09722 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int I$0;
        Object L$0;
        int label;
        final /* synthetic */ CaptureReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09722(State state, CaptureReducer captureReducer, Continuation<? super C09722> continuation) {
            super(1, continuation);
            this.$state = state;
            this.this$0 = captureReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C09722(this.$state, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C09722) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FolderModel selectedFolder = this.$state.getSelectedFolder();
                if (selectedFolder != null) {
                    CaptureReducer captureReducer = this.this$0;
                    ItemId itemId = selectedFolder.getItemId();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(selectedFolder);
                    this.I$0 = 0;
                    this.label = 1;
                    obj = captureReducer.updateUploadFolderServerId(itemId, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return Action.CloseCapture.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Action.UpdateFolderServerIdAndClose((ItemId.Remote) obj);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureReducer$reduceCapture$4, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/cpl/CaptureReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureReducer$reduceCapture$4", f = "CaptureReducer.kt", i = {}, l = {BoxCommonConstants.REQUEST_CHOOSE_REMOTE_UPLOAD_DIR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Action action, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CaptureReducer.this.new AnonymousClass4(this.$action, continuation);
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
                CaptureReducer.this.environment.getCapturePreferencesService().saveUploadFolderId(((Action.UpdateFolder) this.$action).getSelectedFolder().getItemId().toString());
                this.label = 1;
                obj = CaptureReducer.this.updateUploadFolderServerId(((Action.UpdateFolder) this.$action).getSelectedFolder().getItemId(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Action.FolderChanged(((Action.UpdateFolder) this.$action).getSelectedFolder(), (ItemId.Remote) obj);
        }
    }

    private final ReducerResult<State, Action> reduceVideo(VideoCaptureReducer.Action action, State state) {
        if (action instanceof VideoCaptureReducer.Action.Recording) {
            if (((VideoCaptureReducer.Action.Recording) action).getAction() instanceof VideoRecordingReducer.Action.CloseCamera) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, true, null, false, null, 959, null), null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof VideoCaptureReducer.Action.Reviewing) {
            if (((VideoCaptureReducer.Action.Reviewing) action).getAction() instanceof VideoReviewReducer.Action.UploadRecording) {
                return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new C09741(action, state, null)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureReducer$reduceVideo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureReducer$reduceVideo$1", f = "CaptureReducer.kt", i = {}, l = {381}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09741 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ VideoCaptureReducer.Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09741(VideoCaptureReducer.Action action, State state, Continuation<? super C09741> continuation) {
            super(1, continuation);
            this.$action = action;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CaptureReducer.this.new C09741(this.$action, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09741) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CaptureLocalItemsUseCase captureLocalItemsUseCase = CaptureReducer.this.environment.getCaptureLocalItemsUseCase();
                String name = ((VideoReviewReducer.Action.UploadRecording) ((VideoCaptureReducer.Action.Reviewing) this.$action).getAction()).getRecordedFile().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                FolderModel selectedFolder = this.$state.getSelectedFolder();
                ItemId itemId = selectedFolder != null ? selectedFolder.getItemId() : null;
                Intrinsics.checkNotNull(itemId);
                this.label = 1;
                if (captureLocalItemsUseCase.createFile(name, itemId, ((VideoReviewReducer.Action.UploadRecording) ((VideoCaptureReducer.Action.Reviewing) this.$action).getAction()).getRecordedFile(), this) == coroutine_suspended) {
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

    private final ReducerResult<State, Action> reduceCamera(State state, ImageCaptureReducer.Action action) {
        ItemId itemId;
        if (action instanceof ImageCaptureReducer.Action.UploadPhoto) {
            FolderModel selectedFolder = state.getSelectedFolder();
            if (selectedFolder != null && (itemId = selectedFolder.getItemId()) != null) {
                return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new CaptureReducer$reduceCamera$1$1(this, action, itemId, null)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof ImageCaptureReducer.Action.CloseCamera) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, true, null, false, null, 959, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceDocumentScanning(State state, DocumentScanningReducer.Action action) {
        if (action instanceof DocumentScanningReducer.Action.Scanning) {
            ScanPageReducer.Action action2 = ((DocumentScanningReducer.Action.Scanning) action).getAction();
            if (action2 instanceof ScanPageReducer.Action.DocumentCreated) {
                FolderModel selectedFolder = state.getSelectedFolder();
                if (selectedFolder != null && selectedFolder.getItemId() != null) {
                    return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new CaptureReducer$reduceDocumentScanning$1$1(this, action2, state, null)));
                }
                return new ReducerResult<>(state, null, 2, null);
            }
            if (action2 instanceof ScanPageReducer.Action.Close) {
                return new ReducerResult<>(state, new Effect((Function1) new C09732(null)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureReducer$reduceDocumentScanning$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/cpl/CaptureReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureReducer$reduceDocumentScanning$2", f = "CaptureReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09732 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        C09732(Continuation<? super C09732> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C09732(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C09732) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Action.TryUpdateFolderServerIdBeforeCloseCapture.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> reduceAudioRecording(State state, AudioCaptureReducer.Action action) {
        if (action instanceof AudioCaptureReducer.Action.Reviewing) {
            if (((AudioCaptureReducer.Action.Reviewing) action).getAction() instanceof AudioReviewReducer.Action.UploadRecording) {
                return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(action, state, null)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof AudioCaptureReducer.Action.Recording) {
            if (((AudioCaptureReducer.Action.Recording) action).getAction() instanceof AudioRecordingReducer.Action.CloseRecording) {
                return new ReducerResult<>(state, new Effect((Function1) new C09702(null)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureReducer$reduceAudioRecording$1, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureReducer$reduceAudioRecording$1", f = "CaptureReducer.kt", i = {}, l = {460}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ AudioCaptureReducer.Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AudioCaptureReducer.Action action, State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$action = action;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CaptureReducer.this.new AnonymousClass1(this.$action, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CaptureLocalItemsUseCase captureLocalItemsUseCase = CaptureReducer.this.environment.getCaptureLocalItemsUseCase();
                String name = ((AudioReviewReducer.Action.UploadRecording) ((AudioCaptureReducer.Action.Reviewing) this.$action).getAction()).getRecordedFile().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                FolderModel selectedFolder = this.$state.getSelectedFolder();
                Intrinsics.checkNotNull(selectedFolder);
                ItemId itemId = selectedFolder.getItemId();
                Uri uri = Uri.parse(((AudioReviewReducer.Action.UploadRecording) ((AudioCaptureReducer.Action.Reviewing) this.$action).getAction()).getRecordedFile().getPath());
                Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                this.label = 1;
                if (captureLocalItemsUseCase.createFile(name, itemId, uri, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureReducer$reduceAudioRecording$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/cpl/CaptureReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureReducer$reduceAudioRecording$2", f = "CaptureReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09702 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        C09702(Continuation<? super C09702> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C09702(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C09702) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Action.TryUpdateFolderServerIdBeforeCloseCapture.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, com.box.android.domain.models.capture.FlashMode] */
    private final ReducerResult<State, Action> updateFlashMode(State state, FlashMode flashMode) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = flashMode;
        Effect effectFireAndForget = Effect.INSTANCE.fireAndForget(new CaptureReducer$updateFlashMode$effect$1(this, objectRef, null));
        Effect effectFireAndForget2 = Effect.INSTANCE.fireAndForget(new CaptureReducer$updateFlashMode$effectVideo$1(this, objectRef, null));
        CaptureModeState captureModeState = state.getCaptureModeState();
        if (captureModeState instanceof ImageCaptureReducer.State.Camera) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, false, ImageCaptureReducer.State.Camera.copy$default((ImageCaptureReducer.State.Camera) state.getCaptureModeState(), (FlashMode) objectRef.element, null, null, false, 14, null), false, null, 895, null), effectFireAndForget);
        }
        if (captureModeState instanceof DocumentScanningReducer.State.ScanPage) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, false, new DocumentScanningReducer.State.ScanPage(ScanPageReducer.State.copy$default(((DocumentScanningReducer.State.ScanPage) state.getCaptureModeState()).getState(), (FlashMode) objectRef.element, 0, null, null, null, null, false, null, false, 510, null)), false, null, 895, null), effectFireAndForget);
        }
        if (captureModeState instanceof VideoCaptureReducer.State.Recording) {
            if (objectRef.element == FlashMode.AUTO) {
                objectRef.element = ((FlashMode) objectRef.element).next();
            }
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, false, new VideoCaptureReducer.State.Recording(VideoRecordingReducer.State.copy$default(((VideoCaptureReducer.State.Recording) state.getCaptureModeState()).getState(), (FlashMode) objectRef.element, null, null, false, null, null, null, 126, null)), false, null, 895, null), effectFireAndForget2);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> startCaptureMode(CaptureEnvironment environment, State state, CaptureMode captureMode) {
        Effect effectFireAndForget = Effect.INSTANCE.fireAndForget(new CaptureReducer$startCaptureMode$persistCaptureMode$1(environment, captureMode, null));
        int i = WhenMappings.$EnumSwitchMapping$0[captureMode.ordinal()];
        if (i == 1) {
            return new ReducerResult<>(State.copy$default(state, captureMode, null, null, null, false, false, false, ImageCaptureReducer.State.Initializing.INSTANCE, false, null, 894, null), Effect.INSTANCE.merge(effectFireAndForget, new Effect(new Action.Camera(ImageCaptureReducer.Action.Initialize.INSTANCE))));
        }
        if (i == 2) {
            return new ReducerResult<>(State.copy$default(state, captureMode, null, null, null, false, false, false, DocumentScanningReducer.State.Initializing.INSTANCE, false, null, 894, null), Effect.INSTANCE.merge(effectFireAndForget, new Effect(new Action.DocumentScanning(DocumentScanningReducer.Action.Initialize.INSTANCE))));
        }
        if (i == 3) {
            return new ReducerResult<>(State.copy$default(state, captureMode, null, null, null, false, false, false, AudioCaptureReducer.State.Initialize.INSTANCE, false, null, 894, null), Effect.INSTANCE.merge(effectFireAndForget, new Effect(new Action.AudioRecording(AudioCaptureReducer.Action.CheckPermissions.INSTANCE))));
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, captureMode, null, null, null, false, false, false, VideoCaptureReducer.State.Initializing.INSTANCE, false, null, 894, null), Effect.INSTANCE.merge(effectFireAndForget, new Effect(new Action.Video(VideoCaptureReducer.Action.CheckPermissions.INSTANCE))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getDefaultCaptureFolder(final Function2<? super Action, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objCollect = this.environment.getCaptureFolderInteractor().getCaptureFolder().collect(new FlowCollector() { // from class: com.box.android.capture.cpl.CaptureReducer.getDefaultCaptureFolder.2
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Result<FolderModel, ? extends DomainError>) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Result<FolderModel, ? extends DomainError> result, Continuation<? super Unit> continuation2) {
                if (result instanceof Result.Success) {
                    Object objInvoke = function2.invoke(new Action.UpdateFolder((FolderModel) ((Result.Success) result).getValue()), continuation2);
                    return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
                }
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                Object objInvoke2 = function2.invoke(new Action.ChangeFolderFailed((DomainError) ((Result.Error) result).getValue()), continuation2);
                return objInvoke2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke2 : Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateUploadFolderServerId(ItemId itemId, Continuation<? super ItemId.Remote> continuation) {
        C09751 c09751;
        if (continuation instanceof C09751) {
            c09751 = (C09751) continuation;
            if ((c09751.label & Integer.MIN_VALUE) != 0) {
                c09751.label -= Integer.MIN_VALUE;
            } else {
                c09751 = new C09751(continuation);
            }
        } else {
            c09751 = new C09751(continuation);
        }
        Object remoteIdOrError = c09751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09751.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remoteIdOrError);
            IdMappingService idMappingService = this.environment.getIdMappingService();
            c09751.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            c09751.label = 1;
            remoteIdOrError = idMappingService.getRemoteIdOrError(itemId, c09751);
            if (remoteIdOrError == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(remoteIdOrError);
        }
        Result result = (Result) remoteIdOrError;
        if (result instanceof Result.Success) {
            return (ItemId.Remote) ((Result.Success) result).getValue();
        }
        if (result instanceof Result.Error) {
            return ItemId.INSTANCE.getROOT_ITEM_ID();
        }
        throw new NoWhenBranchMatchedException();
    }
}
