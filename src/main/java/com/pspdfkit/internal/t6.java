package com.pspdfkit.internal;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.annotations.configuration.SoundAnnotationConfiguration;
import com.pspdfkit.ui.audio.AudioModeManager;
import com.pspdfkit.ui.audio.AudioRecordingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.undo.edit.annotations.AudioResourceEdit;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Action;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class t6 implements AudioRecordingController, AnnotationProvider.OnAnnotationUpdatedListener {
    public final y5 a;
    public final a70 b;
    public final go<AudioRecordingController.AudioRecordingListener> c = new go<>();
    public final k0 d = new k0(new String[]{"android.permission.RECORD_AUDIO"}, R.string.pspdf__permission_rationale_record_audio_denied_permanently);
    public SoundAnnotation e;
    public k6 f;

    public t6(y5 y5Var, a70 a70Var) {
        this.a = y5Var;
        this.b = a70Var;
    }

    public final void a(Context context, final SoundAnnotation soundAnnotation, final boolean z) {
        context.getClass();
        if (Intrinsics.areEqual(this.e, soundAnnotation)) {
            return;
        }
        a(false);
        SoundAnnotation soundAnnotation2 = this.e;
        if (soundAnnotation2 != null) {
            soundAnnotation2.getInternal().removeOnAnnotationUpdatedListener(this);
            a(j30.STOPPED);
            this.e = null;
        }
        Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.t6$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return t6.a(this.f$0, soundAnnotation, z, ((Boolean) obj).booleanValue());
            }
        };
        hw hwVar = new hw(context);
        boolean zA = hwVar.a("android.permission.RECORD_AUDIO");
        if (!zA) {
            function1.invoke(Boolean.valueOf(zA));
            return;
        }
        Activity activityA = a80.a(context);
        FragmentManager supportFragmentManager = activityA instanceof FragmentActivity ? ((FragmentActivity) activityA).getSupportFragmentManager() : null;
        if (supportFragmentManager != null) {
            this.d.a(context, supportFragmentManager, hwVar, function1);
        } else {
            function1.invoke(Boolean.valueOf(ContextCompat.checkSelfPermission(hwVar.a, "android.permission.RECORD_AUDIO") == 0));
        }
    }

    @Override // com.pspdfkit.ui.audio.AudioRecordingController
    public final void addAudioRecordingListener(AudioRecordingController.AudioRecordingListener audioRecordingListener) {
        audioRecordingListener.getClass();
        this.c.a(audioRecordingListener);
    }

    @Override // com.pspdfkit.ui.audio.AudioRecordingController
    public final void discardRecording() {
        k6 k6Var = this.f;
        if (k6Var != null) {
            synchronized (k6Var) {
                k6Var.f = false;
                k6Var.j.clear();
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((int) (k6Var.d * k6Var.b));
                ByteOrder byteOrderNativeOrder = ByteOrder.nativeOrder();
                byteOrderNativeOrder.getClass();
                ByteBuffer byteBufferOrder = byteBufferAllocateDirect.order(byteOrderNativeOrder);
                byteBufferOrder.getClass();
                k6Var.j = byteBufferOrder;
            }
        }
    }

    @Override // com.pspdfkit.ui.audio.AudioRecordingController
    public final void exitAudioRecordingMode(boolean z) {
        a(z);
        SoundAnnotation soundAnnotation = this.e;
        if (soundAnnotation == null) {
            return;
        }
        soundAnnotation.getInternal().removeOnAnnotationUpdatedListener(this);
        a(j30.STOPPED);
        this.e = null;
        x5 x5Var = this.a.a;
        x5Var.getClass();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new w5(x5Var, this, null), 3, null);
    }

    @Override // com.pspdfkit.ui.audio.AudioRecordingController
    public final AudioModeManager getAudioModeManager() {
        return this.a;
    }

    @Override // com.pspdfkit.ui.audio.AudioRecordingController
    public final int getCurrentPosition() {
        k6 k6Var = this.f;
        if (k6Var != null) {
            return k6Var.a();
        }
        return 0;
    }

    @Override // com.pspdfkit.ui.audio.AudioRecordingController
    public final int getRecordingTimeLimit() {
        k6 k6Var = this.f;
        if (k6Var != null) {
            return k6Var.b;
        }
        return 0;
    }

    @Override // com.pspdfkit.ui.audio.AudioRecordingController
    public final Flowable<ByteBuffer> getVisualizerFlowable() {
        k6 k6Var = this.f;
        if (k6Var != null) {
            Flowable<ByteBuffer> flowable = k6Var.k.toFlowable(BackpressureStrategy.LATEST);
            flowable.getClass();
            return flowable;
        }
        Flowable<ByteBuffer> flowableEmpty = Flowable.empty();
        flowableEmpty.getClass();
        return flowableEmpty;
    }

    @Override // com.pspdfkit.ui.audio.AudioRecordingController
    public final boolean isReady() {
        return this.f != null;
    }

    @Override // com.pspdfkit.ui.audio.AudioRecordingController
    public final boolean isResumed() {
        boolean z;
        k6 k6Var = this.f;
        if (k6Var == null) {
            return false;
        }
        synchronized (k6Var) {
            z = k6Var.f;
        }
        return z;
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationCreated(Annotation annotation) {
        annotation.getClass();
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationRemoved(Annotation annotation) {
        annotation.getClass();
        exitAudioRecordingMode();
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationUpdated(Annotation annotation) {
        annotation.getClass();
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationZOrderChanged(int i, List<? extends Annotation> list, List<? extends Annotation> list2) {
        list.getClass();
        list2.getClass();
    }

    @Override // com.pspdfkit.ui.audio.AudioRecordingController
    public final void pause() {
        k6 k6Var = this.f;
        if (k6Var != null) {
            synchronized (k6Var) {
                k6Var.f = false;
            }
        }
    }

    @Override // com.pspdfkit.ui.audio.AudioRecordingController
    public final void removeAudioRecordingListener(AudioRecordingController.AudioRecordingListener audioRecordingListener) {
        audioRecordingListener.getClass();
        this.c.b(audioRecordingListener);
    }

    @Override // com.pspdfkit.ui.audio.AudioRecordingController
    public final void resume() {
        k6 k6Var = this.f;
        if (k6Var != null) {
            k6Var.b();
        }
    }

    public static final Unit a(t6 t6Var, SoundAnnotation soundAnnotation, boolean z, boolean z2) {
        k6 k6Var;
        k6 k6Var2;
        if (!z2) {
            return Unit.INSTANCE;
        }
        if (t6Var.e == null) {
            t6Var.e = soundAnnotation;
            x5 x5Var = t6Var.a.a;
            x5Var.getClass();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new v5(x5Var, t6Var, null), 3, null);
        } else {
            t6Var.e = soundAnnotation;
            x5 x5Var2 = t6Var.a.a;
            x5Var2.getClass();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new u5(x5Var2, t6Var, null), 3, null);
        }
        AnnotationConfigurationRegistry annotationConfiguration = t6Var.a.b.getAnnotationConfiguration();
        annotationConfiguration.getClass();
        SoundAnnotationConfiguration soundAnnotationConfiguration = (SoundAnnotationConfiguration) annotationConfiguration.get(AnnotationTool.SOUND, SoundAnnotationConfiguration.class);
        if (soundAnnotationConfiguration != null) {
            k6Var = new k6(soundAnnotationConfiguration.getRecordingSampleRate(), soundAnnotationConfiguration.getAudioRecordingTimeLimit());
        } else {
            k6Var = new k6(22050, ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_IN_MILISECONDS);
        }
        k6Var.c = t6Var;
        t6Var.f = k6Var;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new o6(t6Var, null), 3, null);
        if (z && (k6Var2 = t6Var.f) != null) {
            k6Var2.b();
        }
        t6Var.a(j30.RECORDING_PAUSED);
        soundAnnotation.getInternal().addOnAnnotationUpdatedListener(t6Var);
        return Unit.INSTANCE;
    }

    public final void a(final boolean z) {
        k6 k6Var = this.f;
        if (k6Var == null) {
            return;
        }
        final SoundAnnotation soundAnnotation = this.e;
        if (soundAnnotation != null && soundAnnotation.isAttached()) {
            k6Var.a(soundAnnotation).doOnComplete(new Action() { // from class: com.pspdfkit.internal.t6$$ExternalSyntheticLambda1
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() {
                    t6.a(this.f$0, soundAnnotation, z);
                }
            }).subscribe().getClass();
        } else {
            synchronized (k6Var) {
                k6Var.f = false;
                k6Var.j.clear();
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((int) (k6Var.d * k6Var.b));
                ByteOrder byteOrderNativeOrder = ByteOrder.nativeOrder();
                byteOrderNativeOrder.getClass();
                ByteBuffer byteBufferOrder = byteBufferAllocateDirect.order(byteOrderNativeOrder);
                byteBufferOrder.getClass();
                k6Var.j = byteBufferOrder;
            }
        }
        this.f = null;
    }

    public static final void a(t6 t6Var, SoundAnnotation soundAnnotation, boolean z) {
        t6Var.b.b(new AudioResourceEdit(soundAnnotation));
        if (z) {
            t6Var.a.enterAudioPlaybackMode(soundAnnotation);
        }
    }

    public final void a(j30 j30Var) {
        o3 annotationProvider;
        Annotation annotation = this.e;
        if (annotation == null || annotation.getInternal().getSoundAnnotationState() == j30Var) {
            return;
        }
        annotation.getInternal().setSoundAnnotationState(j30Var);
        lm internalDocument = annotation.getInternal().getInternalDocument();
        if (internalDocument == null || (annotationProvider = internalDocument.getAnnotationProvider()) == null) {
            return;
        }
        annotationProvider.e(annotation);
    }
}
