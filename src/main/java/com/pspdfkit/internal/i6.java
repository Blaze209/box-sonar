package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.ui.audio.AudioModeManager;
import com.pspdfkit.ui.audio.AudioPlaybackController;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class i6 implements AudioPlaybackController, j6.a, AnnotationProvider.OnAnnotationUpdatedListener {
    public final y5 a;
    public final go<AudioPlaybackController.AudioPlaybackListener> b = new go<>();
    public SoundAnnotation c;
    public Disposable d;
    public j6 e;

    public i6(y5 y5Var) {
        this.a = y5Var;
    }

    public final void a(Context context, SoundAnnotation soundAnnotation, final boolean z, final int i) {
        context.getClass();
        if (Intrinsics.areEqual(this.c, soundAnnotation)) {
            return;
        }
        a(false);
        if (this.c == null) {
            this.c = soundAnnotation;
            x5 x5Var = this.a.a;
            x5Var.getClass();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new s5(x5Var, this, null), 3, null);
        } else {
            this.c = soundAnnotation;
            x5 x5Var2 = this.a.a;
            x5Var2.getClass();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new r5(x5Var2, this, null), 3, null);
        }
        Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.i6$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return i6.a(z, this, i);
            }
        };
        yz.a(this.d);
        this.d = j6.c.a(context, soundAnnotation).observeOn(AndroidSchedulers.mainThread()).subscribe(new e6(this, function0), new f6(this));
        a(j30.PLAYING_PAUSED);
        soundAnnotation.getInternal().addOnAnnotationUpdatedListener(this);
    }

    @Override // com.pspdfkit.ui.audio.AudioPlaybackController
    public final void addAudioPlaybackListener(AudioPlaybackController.AudioPlaybackListener audioPlaybackListener) {
        audioPlaybackListener.getClass();
        this.b.a(audioPlaybackListener);
    }

    @Override // com.pspdfkit.ui.audio.AudioPlaybackController
    public final void exitAudioPlaybackMode() {
        a(true);
    }

    @Override // com.pspdfkit.ui.audio.AudioPlaybackController
    public final AudioModeManager getAudioModeManager() {
        return this.a;
    }

    @Override // com.pspdfkit.ui.audio.AudioPlaybackController
    public final int getCurrentPosition() {
        j6 j6Var = this.e;
        if (j6Var != null) {
            return j6Var.a.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.pspdfkit.ui.audio.AudioPlaybackController
    public final int getDuration() {
        j6 j6Var = this.e;
        if (j6Var != null) {
            return j6Var.a.getDuration();
        }
        return 0;
    }

    @Override // com.pspdfkit.ui.audio.AudioPlaybackController
    public final boolean isReady() {
        return this.e != null;
    }

    @Override // com.pspdfkit.ui.audio.AudioPlaybackController
    public final boolean isResumed() {
        j6 j6Var = this.e;
        if (j6Var != null) {
            return j6Var.a.isPlaying();
        }
        return false;
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationCreated(Annotation annotation) {
        annotation.getClass();
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationRemoved(Annotation annotation) {
        annotation.getClass();
        a(true);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationUpdated(Annotation annotation) {
        annotation.getClass();
        if (!(annotation instanceof SoundAnnotation) || ((SoundAnnotation) annotation).hasAudioData()) {
            return;
        }
        a(true);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationZOrderChanged(int i, List<? extends Annotation> list, List<? extends Annotation> list2) {
        list.getClass();
        list2.getClass();
    }

    @Override // com.pspdfkit.ui.audio.AudioPlaybackController
    public final void pause() {
        j6 j6Var = this.e;
        if (j6Var != null) {
            j6Var.a();
            j6Var.a.pause();
            j6.b bVar = j6.b.PAUSED;
            if (j6Var.c == bVar) {
                return;
            }
            j6Var.c = bVar;
            j6.a aVar = j6Var.d;
            if (aVar != null) {
                aVar.a(bVar);
            }
        }
    }

    @Override // com.pspdfkit.ui.audio.AudioPlaybackController
    public final void removeAudioPlaybackListener(AudioPlaybackController.AudioPlaybackListener audioPlaybackListener) {
        audioPlaybackListener.getClass();
        this.b.b(audioPlaybackListener);
    }

    @Override // com.pspdfkit.ui.audio.AudioPlaybackController
    public final void resume() {
        j6 j6Var = this.e;
        if (j6Var != null) {
            j6Var.b();
        }
    }

    @Override // com.pspdfkit.ui.audio.AudioPlaybackController
    public final void seekTo(int i) {
        j6 j6Var;
        if (i > getDuration() || (j6Var = this.e) == null) {
            return;
        }
        j6Var.a.seekTo(i);
    }

    public static final Unit a(boolean z, i6 i6Var, int i) {
        j6 j6Var;
        if (z && (j6Var = i6Var.e) != null) {
            j6Var.b();
        }
        if (i > 0) {
            i6Var.seekTo(i);
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.j6.a
    public final void a(j6.b bVar) {
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            a(j30.PLAYING);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new b6(this, null), 3, null);
            return;
        }
        if (iOrdinal == 1) {
            a(j30.PLAYING_PAUSED);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new a6(this, null), 3, null);
        } else if (iOrdinal == 2) {
            a(j30.PLAYING_PAUSED);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new d6(this, null), 3, null);
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            a(j30.STOPPED);
        }
    }

    public final void a(j30 j30Var) {
        SoundAnnotation soundAnnotation = this.c;
        if (soundAnnotation == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new g6(soundAnnotation, j30Var, null), 3, null);
    }

    public final void a(boolean z) {
        yz.a(this.d);
        j6 j6Var = this.e;
        if (j6Var != null) {
            j6Var.a();
            j6Var.a.release();
            j6.b bVar = j6.b.RELEASED;
            if (j6Var.c != bVar) {
                j6Var.c = bVar;
                j6.a aVar = j6Var.d;
                if (aVar != null) {
                    aVar.a(bVar);
                }
            }
            j6Var.d = null;
            this.e = null;
        }
        SoundAnnotation soundAnnotation = this.c;
        if (soundAnnotation == null) {
            return;
        }
        soundAnnotation.getInternal().removeOnAnnotationUpdatedListener(this);
        a(j30.STOPPED);
        this.c = null;
        if (z) {
            x5 x5Var = this.a.a;
            x5Var.getClass();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new t5(x5Var, this, null), 3, null);
        }
    }
}
