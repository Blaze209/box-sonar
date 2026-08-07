package com.pspdfkit.internal;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import androidx.media3.common.MimeTypes;
import com.microsoft.intune.mam.client.media.MAMMediaPlayer;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.sound.WavWriter;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j6 implements AudioManager.OnAudioFocusChangeListener {
    public final MediaPlayer a;
    public final AudioManager b;
    public b c;
    public a d;
    public final AudioAttributes e;
    public AudioFocusRequest f;

    public interface a {
        void a(b bVar);
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.j6$b[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.j6$b[]) from 0x002e: INVOKE (r0v1 com.pspdfkit.internal.j6$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class b {
        PLAYING,
        PAUSED,
        STOPPED,
        RELEASED;

        static {
            EnumEntriesKt.enumEntries(bVarArr);
        }

        public b() {
            super(str, i);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) e.clone();
        }
    }

    public j6(Context context, Uri uri) throws IOException {
        MAMMediaPlayer mAMMediaPlayer = new MAMMediaPlayer();
        this.a = mAMMediaPlayer;
        Object systemService = context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        systemService.getClass();
        this.b = (AudioManager) systemService;
        this.c = b.STOPPED;
        mAMMediaPlayer.setDataSource(context, uri);
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).build();
        this.e = audioAttributesBuild;
        mAMMediaPlayer.setAudioAttributes(audioAttributesBuild);
        mAMMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.pspdfkit.internal.j6$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                j6.a(this.f$0, mediaPlayer);
            }
        });
        mAMMediaPlayer.prepare();
    }

    public static final void a(j6 j6Var, MediaPlayer mediaPlayer) {
        j6Var.a();
        b bVar = b.STOPPED;
        if (j6Var.c == bVar) {
            return;
        }
        j6Var.c = bVar;
        a aVar = j6Var.d;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    public final void b() {
        boolean z;
        int iRequestAudioFocus;
        synchronized (this) {
            z = true;
            if (this.e != null) {
                if (this.f != null) {
                    a();
                }
                AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(1).setOnAudioFocusChangeListener(this).setWillPauseWhenDucked(true).setAudioAttributes(this.e).build();
                this.f = audioFocusRequestBuild;
                iRequestAudioFocus = this.b.requestAudioFocus(audioFocusRequestBuild);
            } else {
                iRequestAudioFocus = this.b.requestAudioFocus(this, 3, 1);
            }
            if (iRequestAudioFocus != 1) {
                z = false;
            }
        }
        if (z) {
            this.a.start();
            b bVar = b.PLAYING;
            if (this.c == bVar) {
                return;
            }
            this.c = bVar;
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(bVar);
            }
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        if (i == -3 || i == -2 || i == -1) {
            a();
            this.a.pause();
            b bVar = b.PAUSED;
            if (this.c == bVar) {
                return;
            }
            this.c = bVar;
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(bVar);
            }
        }
    }

    public final synchronized void a() {
        AudioFocusRequest audioFocusRequest = this.f;
        if (audioFocusRequest != null) {
            this.b.abandonAudioFocusRequest(audioFocusRequest);
            this.f = null;
        }
    }

    public static final class c {
        public static Single a(final Context context, final SoundAnnotation soundAnnotation) {
            context.getClass();
            Single singleDefer = Single.defer(new Supplier() { // from class: com.pspdfkit.internal.j6$c$$ExternalSyntheticLambda0
                @Override // io.reactivex.rxjava3.functions.Supplier
                public final Object get() {
                    return j6.c.a(soundAnnotation, context);
                }
            });
            synchronized (ar.class) {
                q10.c();
            }
            Scheduler schedulerIo = Schedulers.io();
            schedulerIo.getClass();
            Single singleSubscribeOn = singleDefer.subscribeOn(schedulerIo);
            singleSubscribeOn.getClass();
            return singleSubscribeOn;
        }

        public static final SingleSource a(SoundAnnotation soundAnnotation, Context context) throws IOException {
            String strValueOf;
            uw.b(soundAnnotation.hasAudioData(), "No audio data is attached to sound annotation.");
            File fileA = wg.a(context);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String uuid = soundAnnotation.getInternal().getUuid();
            k4 annotationResource = soundAnnotation.getInternal().getAnnotationResource();
            if (annotationResource == null) {
                strValueOf = "";
            } else {
                strValueOf = String.valueOf(annotationResource.hashCode());
            }
            File file = new File(fileA, String.format("sound_%s_%s.wav", Arrays.copyOf(new Object[]{uuid, strValueOf}, 2)));
            if (!file.exists()) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    WavWriter.INSTANCE.forAnnotation(soundAnnotation).writeToStream(bufferedOutputStream);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedOutputStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedOutputStream, th);
                        throw th2;
                    }
                }
            }
            Uri uriFromFile = Uri.fromFile(file);
            uriFromFile.getClass();
            return Single.just(new j6(context, uriFromFile));
        }
    }
}
