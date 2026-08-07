package com.box.android.capture.audiorecording;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.RemoteViews;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.media3.common.MimeTypes;
import com.box.android.base.BoxNotificationManager;
import com.box.android.capture.R;
import com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel;
import com.box.android.domain.identity.IUserContextComponentListener;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.AudioRecordingError;
import com.box.android.domain.utils.result.Result;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;
import com.microsoft.intune.mam.client.os.MAMBinder;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: RecorderService.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u001d \b\u0007\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0002OPB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0016J\u001e\u0010%\u001a\u00020#2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020#H\u0002J\b\u0010+\u001a\u00020#H\u0002J\"\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\r2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-H\u0016J\u0014\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040302H\u0016J\u0014\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040306H\u0016J\"\u00107\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u000209082\u0006\u0010:\u001a\u00020;H\u0096@¢\u0006\u0002\u0010<J\"\u0010=\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u000209082\u0006\u0010>\u001a\u00020?H\u0096@¢\u0006\u0002\u0010@J\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020908H\u0096@¢\u0006\u0002\u0010BJ\u000e\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH\u0016J\u001a\u0010F\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020908H\u0097@¢\u0006\u0002\u0010BJ\b\u0010G\u001a\u00020?H\u0016J\b\u0010H\u001a\u00020?H\u0016J\u0018\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020E2\u0006\u0010L\u001a\u00020)H\u0002J\u0010\u0010M\u001a\u00020N2\u0006\u0010.\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u0006Q"}, d2 = {"Lcom/box/android/capture/audiorecording/RecorderService;", "Landroidx/lifecycle/LifecycleService;", "Lcom/box/android/capture/audiorecording/IRecordManager;", "<init>", "()V", "telephonyManager", "Landroid/telephony/TelephonyManager;", "audioManager", "Landroid/media/AudioManager;", "pauseIntent", "Landroid/app/PendingIntent;", "resumeIntent", "notificationIntent", "Landroid/content/Intent;", "recordingFileManager", "Lcom/box/android/capture/audiorecording/IRecordingFileManager;", "getRecordingFileManager", "()Lcom/box/android/capture/audiorecording/IRecordingFileManager;", "setRecordingFileManager", "(Lcom/box/android/capture/audiorecording/IRecordingFileManager;)V", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "viewModel", "Lcom/box/android/capture/audiorecording/viewmodel/RecorderServiceViewModel;", "phoneStateListener", "com/box/android/capture/audiorecording/RecorderService$phoneStateListener$1", "Lcom/box/android/capture/audiorecording/RecorderService$phoneStateListener$1;", "audioRecordingCallback", "com/box/android/capture/audiorecording/RecorderService$audioRecordingCallback$1", "Lcom/box/android/capture/audiorecording/RecorderService$audioRecordingCallback$1;", "resumeIfAutoPaused", "", "onCreate", "prepareIntents", "targetClass", "Ljava/lang/Class;", "folderId", "", "startListeningForInterruptions", "stopListeningForInterruptions", "onStartCommand", "", "intent", "flags", "startId", "getRecordedSamples", "Landroidx/lifecycle/LiveData;", "", "", "getRecordedSamplesAsFlow", "Lkotlinx/coroutines/flow/Flow;", "startRecording", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/AudioRecordingError;", "file", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pauseRecording", "isAutoPaused", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumeRecording", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecordingStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/box/android/capture/audiorecording/RecordingFileState;", "stopRecording", "isRecording", "hasPendingRecording", "getNotification", "Landroid/app/Notification;", "recordingFileState", "elapsedTime", "onBind", "Landroid/os/IBinder;", "RecorderBinder", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class RecorderService extends Hilt_RecorderService implements IRecordManager {
    public static final int AUDIO_BIT_RATE = 64000;
    public static final int AUDIO_NUMBER_OF_CHANNELS = 1;
    public static final int AUDIO_SAMPLING_RATE = 44100;
    public static final String EXTRA_NOTIFICATION_TARGET_CLASS = "notificationTargetClass";
    private static final String PAUSE_ACTION = "PAUSE_RECORDING_ACTION";
    private static final String RESUME_ACTION = "RESUME_RECORDING_ACTION";
    private AudioManager audioManager;
    private Intent notificationIntent;
    private PendingIntent pauseIntent;

    @Inject
    public IRecordingFileManager recordingFileManager;
    private PendingIntent resumeIntent;
    private TelephonyManager telephonyManager;

    @Inject
    public IUserContextManager userContextManager;
    private RecorderServiceViewModel viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final RecorderService$phoneStateListener$1 phoneStateListener = new PhoneStateListener() { // from class: com.box.android.capture.audiorecording.RecorderService$phoneStateListener$1
        @Override // android.telephony.PhoneStateListener
        @Deprecated(message = "Deprecated in Java")
        public void onCallStateChanged(int state, String phoneNumber) {
            if (state == 0) {
                this.this$0.resumeIfAutoPaused();
            } else {
                if (state != 1) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RecorderService$phoneStateListener$1$onCallStateChanged$1(this.this$0, null), 3, null);
            }
        }
    };
    private final RecorderService$audioRecordingCallback$1 audioRecordingCallback = new AudioManager.AudioRecordingCallback() { // from class: com.box.android.capture.audiorecording.RecorderService$audioRecordingCallback$1
        @Override // android.media.AudioManager.AudioRecordingCallback
        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> configs) {
            AudioRecordingConfiguration audioRecordingConfiguration;
            super.onRecordingConfigChanged(configs);
            if (configs != null && (audioRecordingConfiguration = (AudioRecordingConfiguration) CollectionsKt.first((List) configs)) != null && audioRecordingConfiguration.isClientSilenced()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RecorderService$audioRecordingCallback$1$onRecordingConfigChanged$1(this.this$0, null), 3, null);
            } else {
                this.this$0.resumeIfAutoPaused();
            }
        }
    };

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.RecorderService$pauseRecording$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecorderService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.RecorderService", f = "RecorderService.kt", i = {0}, l = {262}, m = "pauseRecording", n = {"isAutoPaused"}, s = {"Z$0"}, v = 1)
    static final class C09631 extends ContinuationImpl {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C09631(Continuation<? super C09631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecorderService.this.pauseRecording(false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.RecorderService$resumeRecording$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecorderService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.RecorderService", f = "RecorderService.kt", i = {}, l = {273}, m = "resumeRecording", n = {}, s = {}, v = 1)
    static final class C09651 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09651(Continuation<? super C09651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecorderService.this.resumeRecording(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.RecorderService$startRecording$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecorderService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.RecorderService", f = "RecorderService.kt", i = {0}, l = {227}, m = "startRecording", n = {"file"}, s = {"L$0"}, v = 1)
    static final class C09661 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09661(Continuation<? super C09661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecorderService.this.startRecording(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.RecorderService$stopRecording$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecorderService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.RecorderService", f = "RecorderService.kt", i = {}, l = {284}, m = "stopRecording", n = {}, s = {}, v = 1)
    static final class C09671 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09671(Continuation<? super C09671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecorderService.this.stopRecording(this);
        }
    }

    public final IRecordingFileManager getRecordingFileManager() {
        IRecordingFileManager iRecordingFileManager = this.recordingFileManager;
        if (iRecordingFileManager != null) {
            return iRecordingFileManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recordingFileManager");
        return null;
    }

    public final void setRecordingFileManager(IRecordingFileManager iRecordingFileManager) {
        Intrinsics.checkNotNullParameter(iRecordingFileManager, "<set-?>");
        this.recordingFileManager = iRecordingFileManager;
    }

    public final IUserContextManager getUserContextManager() {
        IUserContextManager iUserContextManager = this.userContextManager;
        if (iUserContextManager != null) {
            return iUserContextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userContextManager");
        return null;
    }

    public final void setUserContextManager(IUserContextManager iUserContextManager) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<set-?>");
        this.userContextManager = iUserContextManager;
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.RecorderService$resumeIfAutoPaused$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecorderService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.RecorderService$resumeIfAutoPaused$1", f = "RecorderService.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09641(Continuation<? super C09641> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecorderService.this.new C09641(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RecorderService.this.resumeRecording(this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeIfAutoPaused() {
        RecorderServiceViewModel recorderServiceViewModel = this.viewModel;
        if (recorderServiceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            recorderServiceViewModel = null;
        }
        if (recorderServiceViewModel.getRecordingState().getValue() == RecordingFileState.AUTO_PAUSED) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C09641(null), 3, null);
        }
    }

    @Override // com.box.android.capture.audiorecording.Hilt_RecorderService, androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Object systemService = getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        this.telephonyManager = (TelephonyManager) systemService;
        Object systemService2 = getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService2;
        this.viewModel = new RecorderServiceViewModel(getRecordingFileManager());
        getUserContextManager().addUserContextListener(RecorderService.class.getName(), new IUserContextComponentListener() { // from class: com.box.android.capture.audiorecording.RecorderService.onCreate.1
            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onCreate(String contextId) {
            }

            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onSoftDestroy() {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(RecorderService.this), null, null, new RecorderService$onCreate$1$onSoftDestroy$1(RecorderService.this, null), 3, null);
                RecorderService.this.stopSelf();
            }

            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onHardDestroy() {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(RecorderService.this), null, null, new RecorderService$onCreate$1$onHardDestroy$1(RecorderService.this, null), 3, null);
                RecorderService.this.stopSelf();
            }
        });
        RecorderServiceViewModel recorderServiceViewModel = this.viewModel;
        if (recorderServiceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            recorderServiceViewModel = null;
        }
        recorderServiceViewModel.getSamplingLoop().observe(this, new RecorderService$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.capture.audiorecording.RecorderService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecorderService.onCreate$lambda$0((Unit) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(Unit unit) {
        return Unit.INSTANCE;
    }

    private final void prepareIntents(Class<?> targetClass, String folderId) {
        RecorderService recorderService = this;
        Intent intent = new Intent(recorderService, (Class<?>) RecorderService.class);
        intent.setAction(PAUSE_ACTION);
        Class<?> cls = targetClass;
        intent.putExtra(EXTRA_NOTIFICATION_TARGET_CLASS, cls);
        Unit unit = Unit.INSTANCE;
        PendingIntent foregroundService = MAMPendingIntent.getForegroundService(recorderService, 0, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(foregroundService, "getForegroundService(...)");
        this.pauseIntent = foregroundService;
        Intent intent2 = new Intent(recorderService, (Class<?>) RecorderService.class);
        intent2.setAction(RESUME_ACTION);
        intent2.putExtra(EXTRA_NOTIFICATION_TARGET_CLASS, cls);
        Unit unit2 = Unit.INSTANCE;
        PendingIntent foregroundService2 = MAMPendingIntent.getForegroundService(recorderService, 0, intent2, 201326592);
        Intrinsics.checkNotNullExpressionValue(foregroundService2, "getForegroundService(...)");
        this.resumeIntent = foregroundService2;
        Intent intent3 = new Intent(recorderService, targetClass);
        intent3.putExtra("folderId", folderId);
        this.notificationIntent = intent3;
    }

    private final void startListeningForInterruptions() {
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
            audioManager = null;
        }
        audioManager.registerAudioRecordingCallback(this.audioRecordingCallback, null);
    }

    private final void stopListeningForInterruptions() {
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
            audioManager = null;
        }
        audioManager.unregisterAudioRecordingCallback(this.audioRecordingCallback);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0060  */
    /* JADX WARN: Code duplicated, block: B:22:0x0069  */
    /* JADX WARN: Code duplicated, block: B:24:0x006f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0073  */
    /* JADX WARN: Code duplicated, block: B:27:0x0082  */
    /* JADX WARN: Code duplicated, block: B:29:0x0088  */
    /* JADX WARN: Code duplicated, block: B:30:0x008c  */
    @Override // androidx.lifecycle.LifecycleService, com.microsoft.intune.mam.client.app.MAMService, com.microsoft.intune.mam.client.app.HookedService
    public int onMAMStartCommand(Intent intent, int i, int i2) {
        RecorderServiceViewModel recorderServiceViewModel;
        RecorderServiceViewModel recorderServiceViewModel2;
        RecorderServiceViewModel recorderServiceViewModel3 = null;
        String action = intent != null ? intent.getAction() : null;
        if (action == null) {
            if (Build.VERSION.SDK_INT >= 34) {
                RecordingFileState recordingFileState = RecordingFileState.RECORDING;
                recorderServiceViewModel2 = this.viewModel;
                if (recorderServiceViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    recorderServiceViewModel3 = recorderServiceViewModel2;
                }
                startForeground(1, getNotification(recordingFileState, recorderServiceViewModel3.getElapsedTime()), 128);
            } else {
                RecordingFileState recordingFileState2 = RecordingFileState.RECORDING;
                recorderServiceViewModel = this.viewModel;
                if (recorderServiceViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    recorderServiceViewModel3 = recorderServiceViewModel;
                }
                startForeground(1, getNotification(recordingFileState2, recorderServiceViewModel3.getElapsedTime()));
            }
            Unit unit = Unit.INSTANCE;
        } else {
            int iHashCode = action.hashCode();
            if (iHashCode != -1419460691) {
                if (iHashCode == -1202992586 && action.equals(RESUME_ACTION)) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RecorderService$onStartCommand$2(this, null), 3, null);
                } else {
                    if (Build.VERSION.SDK_INT >= 34) {
                        RecordingFileState recordingFileState3 = RecordingFileState.RECORDING;
                        recorderServiceViewModel2 = this.viewModel;
                        if (recorderServiceViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            recorderServiceViewModel3 = recorderServiceViewModel2;
                        }
                        startForeground(1, getNotification(recordingFileState3, recorderServiceViewModel3.getElapsedTime()), 128);
                    } else {
                        RecordingFileState recordingFileState4 = RecordingFileState.RECORDING;
                        recorderServiceViewModel = this.viewModel;
                        if (recorderServiceViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            recorderServiceViewModel3 = recorderServiceViewModel;
                        }
                        startForeground(1, getNotification(recordingFileState4, recorderServiceViewModel3.getElapsedTime()));
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            } else if (action.equals(PAUSE_ACTION)) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RecorderService$onStartCommand$1(this, null), 3, null);
            } else {
                if (Build.VERSION.SDK_INT >= 34) {
                    RecordingFileState recordingFileState5 = RecordingFileState.RECORDING;
                    recorderServiceViewModel2 = this.viewModel;
                    if (recorderServiceViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        recorderServiceViewModel3 = recorderServiceViewModel2;
                    }
                    startForeground(1, getNotification(recordingFileState5, recorderServiceViewModel3.getElapsedTime()), 128);
                } else {
                    RecordingFileState recordingFileState6 = RecordingFileState.RECORDING;
                    recorderServiceViewModel = this.viewModel;
                    if (recorderServiceViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        recorderServiceViewModel3 = recorderServiceViewModel;
                    }
                    startForeground(1, getNotification(recordingFileState6, recorderServiceViewModel3.getElapsedTime()));
                }
                Unit unit3 = Unit.INSTANCE;
            }
        }
        return super.onMAMStartCommand(intent, i, i2);
    }

    @Override // com.box.android.capture.audiorecording.IRecordManager
    public LiveData<List<Double>> getRecordedSamples() {
        RecorderServiceViewModel recorderServiceViewModel = this.viewModel;
        if (recorderServiceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            recorderServiceViewModel = null;
        }
        return recorderServiceViewModel.getRecordedFileSamples();
    }

    @Override // com.box.android.capture.audiorecording.IRecordManager
    public Flow<List<Double>> getRecordedSamplesAsFlow() {
        return FlowLiveDataConversions.asFlow(getRecordedSamples());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.capture.audiorecording.IRecordManager
    public Object startRecording(File file, Continuation<? super Result<Unit, ? extends AudioRecordingError>> continuation) {
        C09661 c09661;
        if (continuation instanceof C09661) {
            c09661 = (C09661) continuation;
            if ((c09661.label & Integer.MIN_VALUE) != 0) {
                c09661.label -= Integer.MIN_VALUE;
            } else {
                c09661 = new C09661(continuation);
            }
        } else {
            c09661 = new C09661(continuation);
        }
        Object obj = c09661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09661.label;
        int i2 = 1;
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AudioManager audioManager = this.audioManager;
                if (audioManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("audioManager");
                    audioManager = null;
                }
                List<AudioRecordingConfiguration> activeRecordingConfigurations = audioManager.getActiveRecordingConfigurations();
                Intrinsics.checkNotNullExpressionValue(activeRecordingConfigurations, "getActiveRecordingConfigurations(...)");
                if (!activeRecordingConfigurations.isEmpty()) {
                    return new Result.Error(new AudioRecordingError.MicrophoneInUseError(str, i2, objArr5 == true ? 1 : 0));
                }
                RecorderServiceViewModel recorderServiceViewModel = this.viewModel;
                if (recorderServiceViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    recorderServiceViewModel = null;
                }
                c09661.L$0 = SpillingKt.nullOutSpilledVariable(file);
                c09661.label = 1;
                if (recorderServiceViewModel.startRecording(c09661) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            startListeningForInterruptions();
            RecorderServiceViewModel recorderServiceViewModel2 = this.viewModel;
            if (recorderServiceViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                recorderServiceViewModel2 = null;
            }
            recorderServiceViewModel2.getRecordedTime().observe(this, new RecorderService$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.capture.audiorecording.RecorderService$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return RecorderService.startRecording$lambda$0(this.f$0, (String) obj2);
                }
            }));
            RecorderServiceViewModel recorderServiceViewModel3 = this.viewModel;
            if (recorderServiceViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                recorderServiceViewModel3 = null;
            }
            recorderServiceViewModel3.getRecordingState().observe(this, new RecorderService$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.capture.audiorecording.RecorderService$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return RecorderService.startRecording$lambda$1(this.f$0, (RecordingFileState) obj2);
                }
            }));
            getApplication().startForegroundService(new Intent(getApplication(), (Class<?>) RecorderService.class));
            return new Result.Success(Unit.INSTANCE);
        } catch (IOException unused) {
            return new Result.Error(new AudioRecordingError.AudioRecordingStartError(objArr4 == true ? 1 : 0, i2, objArr3 == true ? 1 : 0));
        } catch (IllegalStateException unused2) {
            return new Result.Error(new AudioRecordingError.AudioRecordingStartError(objArr2 == true ? 1 : 0, i2, objArr == true ? 1 : 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startRecording$lambda$0(RecorderService recorderService, String str) {
        RecorderServiceViewModel recorderServiceViewModel = recorderService.viewModel;
        if (recorderServiceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            recorderServiceViewModel = null;
        }
        RecordingFileState recordingFileStateM12329getRecordingState = recorderServiceViewModel.m12329getRecordingState();
        Intrinsics.checkNotNull(str);
        BoxNotificationManager.notify(1, recorderService.getNotification(recordingFileStateM12329getRecordingState, str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startRecording$lambda$1(RecorderService recorderService, RecordingFileState recordingFileState) {
        if (recordingFileState == RecordingFileState.NOT_RECORDING) {
            BoxNotificationManager.cancel(1);
        } else {
            Intrinsics.checkNotNull(recordingFileState);
            RecorderServiceViewModel recorderServiceViewModel = recorderService.viewModel;
            if (recorderServiceViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                recorderServiceViewModel = null;
            }
            BoxNotificationManager.notify(1, recorderService.getNotification(recordingFileState, recorderServiceViewModel.getElapsedTime()));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.capture.audiorecording.IRecordManager
    public Object pauseRecording(boolean z, Continuation<? super Result<Unit, ? extends AudioRecordingError>> continuation) {
        C09631 c09631;
        if (continuation instanceof C09631) {
            c09631 = (C09631) continuation;
            if ((c09631.label & Integer.MIN_VALUE) != 0) {
                c09631.label -= Integer.MIN_VALUE;
            } else {
                c09631 = new C09631(continuation);
            }
        } else {
            c09631 = new C09631(continuation);
        }
        Object obj = c09631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09631.label;
        int i2 = 1;
        String str = null;
        Object[] objArr = 0;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RecorderServiceViewModel recorderServiceViewModel = this.viewModel;
                if (recorderServiceViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    recorderServiceViewModel = null;
                }
                if (recorderServiceViewModel.getRecordingState().getValue() == RecordingFileState.RECORDING) {
                    RecorderServiceViewModel recorderServiceViewModel2 = this.viewModel;
                    if (recorderServiceViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        recorderServiceViewModel2 = null;
                    }
                    c09631.Z$0 = z;
                    c09631.label = 1;
                    if (recorderServiceViewModel2.pauseRecording(z, c09631) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return new Result.Success(Unit.INSTANCE);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z2 = c09631.Z$0;
                ResultKt.throwOnFailure(obj);
            }
            return new Result.Success(Unit.INSTANCE);
        } catch (IllegalStateException unused) {
            return new Result.Error(new AudioRecordingError.AudioRecordingPauseError(str, i2, objArr == true ? 1 : 0));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.capture.audiorecording.IRecordManager
    public Object resumeRecording(Continuation<? super Result<Unit, ? extends AudioRecordingError>> continuation) {
        C09651 c09651;
        if (continuation instanceof C09651) {
            c09651 = (C09651) continuation;
            if ((c09651.label & Integer.MIN_VALUE) != 0) {
                c09651.label -= Integer.MIN_VALUE;
            } else {
                c09651 = new C09651(continuation);
            }
        } else {
            c09651 = new C09651(continuation);
        }
        Object obj = c09651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09651.label;
        String str = null;
        Object[] objArr = 0;
        int i2 = 1;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RecorderServiceViewModel recorderServiceViewModel = this.viewModel;
                if (recorderServiceViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    recorderServiceViewModel = null;
                }
                c09651.label = 1;
                if (recorderServiceViewModel.resumeRecording(c09651) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Result.Success(Unit.INSTANCE);
        } catch (IllegalStateException unused) {
            return new Result.Error(new AudioRecordingError.AudioRecordingResumeError(str, i2, objArr == true ? 1 : 0));
        }
    }

    @Override // com.box.android.capture.audiorecording.IRecordManager
    public StateFlow<RecordingFileState> getRecordingStateFlow() {
        RecorderServiceViewModel recorderServiceViewModel = this.viewModel;
        if (recorderServiceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            recorderServiceViewModel = null;
        }
        return recorderServiceViewModel.getRecordingStateFlow();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.capture.audiorecording.IRecordManager
    public Object stopRecording(Continuation<? super Result<Unit, ? extends AudioRecordingError>> continuation) {
        C09671 c09671;
        if (continuation instanceof C09671) {
            c09671 = (C09671) continuation;
            if ((c09671.label & Integer.MIN_VALUE) != 0) {
                c09671.label -= Integer.MIN_VALUE;
            } else {
                c09671 = new C09671(continuation);
            }
        } else {
            c09671 = new C09671(continuation);
        }
        Object obj = c09671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09671.label;
        String str = null;
        Object[] objArr = 0;
        int i2 = 1;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                stopListeningForInterruptions();
                RecorderServiceViewModel recorderServiceViewModel = this.viewModel;
                if (recorderServiceViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    recorderServiceViewModel = null;
                }
                c09671.label = 1;
                if (recorderServiceViewModel.stopRecording(c09671) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            stopForeground(true);
            return new Result.Success(Unit.INSTANCE);
        } catch (IllegalStateException unused) {
            return new Result.Error(new AudioRecordingError.AudioRecordingStopError(str, i2, objArr == true ? 1 : 0));
        }
    }

    @Override // com.box.android.capture.audiorecording.IRecordManager
    public boolean isRecording() {
        RecorderServiceViewModel recorderServiceViewModel = this.viewModel;
        if (recorderServiceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            recorderServiceViewModel = null;
        }
        return recorderServiceViewModel.getRecordingState().getValue() == RecordingFileState.RECORDING;
    }

    @Override // com.box.android.capture.audiorecording.IRecordManager
    public boolean hasPendingRecording() {
        RecorderServiceViewModel recorderServiceViewModel = this.viewModel;
        if (recorderServiceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            recorderServiceViewModel = null;
        }
        return recorderServiceViewModel.getRecordingState().getValue() != RecordingFileState.NOT_RECORDING;
    }

    private final Notification getNotification(RecordingFileState recordingFileState, String elapsedTime) {
        String string;
        RecorderService recorderService = this;
        Intent intent = this.notificationIntent;
        PendingIntent pendingIntent = null;
        if (intent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationIntent");
            intent = null;
        }
        PendingIntent activity = MAMPendingIntent.getActivity(recorderService, 0, intent, 201326592);
        Integer messageElapsedTimeId = recordingFileState.getMessageElapsedTimeId();
        if (messageElapsedTimeId == null || (string = getString(messageElapsedTimeId.intValue(), new Object[]{elapsedTime})) == null) {
            string = "";
        }
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.recording_notification_small);
        RemoteViews remoteViews2 = new RemoteViews(getPackageName(), R.layout.recording_notification_big);
        String str = string;
        remoteViews.setTextViewText(R.id.notification_title, str);
        remoteViews2.setTextViewText(R.id.notification_title, str);
        if (recordingFileState == RecordingFileState.PAUSED || recordingFileState == RecordingFileState.AUTO_PAUSED) {
            int i = R.id.recording_action;
            PendingIntent pendingIntent2 = this.resumeIntent;
            if (pendingIntent2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resumeIntent");
            } else {
                pendingIntent = pendingIntent2;
            }
            remoteViews2.setOnClickPendingIntent(i, pendingIntent);
            remoteViews2.setTextViewText(R.id.recording_action, getString(R.string.audio_recording_resume_action));
        } else if (recordingFileState == RecordingFileState.RECORDING) {
            int i2 = R.id.recording_action;
            PendingIntent pendingIntent3 = this.pauseIntent;
            if (pendingIntent3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pauseIntent");
            } else {
                pendingIntent = pendingIntent3;
            }
            remoteViews2.setOnClickPendingIntent(i2, pendingIntent);
            remoteViews2.setTextViewText(R.id.recording_action, getString(R.string.audio_recording_pause_action));
        }
        Notification notificationBuild = new NotificationCompat.Builder(recorderService, BoxNotificationManager.RECORDER_CHANNEL_ID).setContentIntent(activity).setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setCustomContentView(remoteViews).setCustomBigContentView(remoteViews2).setSmallIcon(android.R.drawable.ic_btn_speak_now).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    @Override // androidx.lifecycle.LifecycleService, com.microsoft.intune.mam.client.app.HookedService
    public IBinder onMAMBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onMAMBind(intent);
        String stringExtra = intent.getStringExtra("folderId");
        Class<?> cls = (Class) intent.getSerializableExtra(EXTRA_NOTIFICATION_TARGET_CLASS);
        Intrinsics.checkNotNull(cls);
        prepareIntents(cls, stringExtra);
        return new RecorderBinder();
    }

    /* JADX INFO: compiled from: RecorderService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/capture/audiorecording/RecorderService$RecorderBinder;", "Landroid/os/Binder;", "<init>", "(Lcom/box/android/capture/audiorecording/RecorderService;)V", "getRecordManager", "Lcom/box/android/capture/audiorecording/IRecordManager;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class RecorderBinder extends MAMBinder {
        public RecorderBinder() {
        }

        public final IRecordManager getRecordManager() {
            return RecorderService.this;
        }
    }

    /* JADX INFO: compiled from: RecorderService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/capture/audiorecording/RecorderService$Companion;", "", "<init>", "()V", "EXTRA_NOTIFICATION_TARGET_CLASS", "", "AUDIO_BIT_RATE", "", "AUDIO_SAMPLING_RATE", "AUDIO_NUMBER_OF_CHANNELS", "PAUSE_ACTION", "RESUME_ACTION", "getFileDuration", "", "file", "Ljava/io/File;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getFileDuration(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return (long) ((file.length() / 8000) * 1000);
        }
    }
}
