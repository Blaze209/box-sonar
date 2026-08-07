package androidx.media3.common.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.BackgroundExecutor;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import com.google.common.base.Preconditions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes8.dex */
public final class AudioManagerCompat {
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    public static final int AUDIOFOCUS_NONE = 0;
    private static final String TAG = "AudioManagerCompat";
    private static Context applicationContext;
    private static AudioManager audioManager;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioFocusGain {
    }

    public static synchronized AudioManager getAudioManager(Context context) {
        final Context applicationContext2 = context.getApplicationContext();
        if (applicationContext != applicationContext2) {
            audioManager = null;
        }
        AudioManager audioManager2 = audioManager;
        if (audioManager2 != null) {
            return audioManager2;
        }
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null && looperMyLooper != Looper.getMainLooper()) {
            final ConditionVariable conditionVariable = new ConditionVariable();
            BackgroundExecutor.get().execute(new Runnable() { // from class: androidx.media3.common.audio.AudioManagerCompat$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AudioManagerCompat.lambda$getAudioManager$0(applicationContext2, conditionVariable);
                }
            });
            conditionVariable.blockUninterruptible();
            return (AudioManager) Preconditions.checkNotNull(audioManager);
        }
        AudioManager audioManager3 = (AudioManager) applicationContext2.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        audioManager = audioManager3;
        return (AudioManager) Preconditions.checkNotNull(audioManager3);
    }

    static /* synthetic */ void lambda$getAudioManager$0(Context context, ConditionVariable conditionVariable) {
        audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        conditionVariable.open();
    }

    public static int requestAudioFocus(AudioManager audioManager2, AudioFocusRequestCompat audioFocusRequestCompat) {
        return audioManager2.requestAudioFocus(audioFocusRequestCompat.getAudioFocusRequest());
    }

    public static int abandonAudioFocusRequest(AudioManager audioManager2, AudioFocusRequestCompat audioFocusRequestCompat) {
        return audioManager2.abandonAudioFocusRequest(audioFocusRequestCompat.getAudioFocusRequest());
    }

    public static int getStreamMaxVolume(AudioManager audioManager2, int i) {
        return audioManager2.getStreamMaxVolume(i);
    }

    public static int getStreamMinVolume(AudioManager audioManager2, int i) {
        return audioManager2.getStreamMinVolume(i);
    }

    public static int getStreamVolume(AudioManager audioManager2, int i) {
        try {
            return audioManager2.getStreamVolume(i);
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not retrieve stream volume for stream type " + i, e);
            return audioManager2.getStreamMaxVolume(i);
        }
    }

    public static boolean isStreamMute(AudioManager audioManager2, int i) {
        return audioManager2.isStreamMute(i);
    }

    private AudioManagerCompat() {
    }
}
