package androidx.media3.exoplayer.util;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.audio.AudioManagerCompat;
import androidx.media3.common.util.Util;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
public class SpatializerWrapper {
    private final Handler handler;
    private final Spatializer.OnSpatializerStateChangedListener listener;
    private final boolean spatializationSupported;
    private final Spatializer spatializer;

    public SpatializerWrapper(Context context, final Runnable runnable, Boolean bool) {
        AudioManager audioManager = context == null ? null : AudioManagerCompat.getAudioManager(context);
        if (audioManager == null || (bool != null && bool.booleanValue())) {
            this.spatializer = null;
            this.spatializationSupported = false;
            this.handler = null;
            this.listener = null;
            return;
        }
        Spatializer spatializer = audioManager.getSpatializer();
        this.spatializer = spatializer;
        this.spatializationSupported = spatializer.getImmersiveAudioLevel() != 0;
        if (runnable == null) {
            this.handler = null;
            this.listener = null;
            return;
        }
        final Handler handler = new Handler((Looper) Preconditions.checkNotNull(Looper.myLooper()));
        this.handler = handler;
        Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = new Spatializer.OnSpatializerStateChangedListener() { // from class: androidx.media3.exoplayer.util.SpatializerWrapper.1
            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerEnabledChanged(Spatializer spatializer2, boolean z) {
                runnable.run();
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerAvailableChanged(Spatializer spatializer2, boolean z) {
                runnable.run();
            }
        };
        this.listener = onSpatializerStateChangedListener;
        Objects.requireNonNull(handler);
        spatializer.addOnSpatializerStateChangedListener(new Executor() { // from class: androidx.media3.exoplayer.util.SpatializerWrapper$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable2) {
                handler.post(runnable2);
            }
        }, onSpatializerStateChangedListener);
    }

    public boolean isSupportedAvailableAndEnabled() {
        return this.spatializer != null && this.spatializationSupported && isAvailable() && isEnabled();
    }

    public boolean isSpatializationSupported() {
        return this.spatializationSupported;
    }

    public boolean isAvailable() {
        Spatializer spatializer = this.spatializer;
        return spatializer != null && spatializer.isAvailable();
    }

    public boolean isEnabled() {
        Spatializer spatializer = this.spatializer;
        return spatializer != null && spatializer.isEnabled();
    }

    public boolean canBeSpatialized(AudioAttributes audioAttributes, Format format) {
        int i;
        if (!isSupportedAvailableAndEnabled()) {
            return false;
        }
        if (Objects.equals(format.sampleMimeType, MimeTypes.AUDIO_E_AC3_JOC)) {
            i = format.channelCount == 16 ? 12 : format.channelCount;
        } else if (Objects.equals(format.sampleMimeType, MimeTypes.AUDIO_IAMF)) {
            i = format.channelCount == -1 ? 6 : format.channelCount;
        } else if (Objects.equals(format.sampleMimeType, MimeTypes.AUDIO_AC4)) {
            i = (format.channelCount == 18 || format.channelCount == 21) ? 24 : format.channelCount;
        } else {
            i = format.channelCount;
        }
        int audioTrackChannelConfig = Util.getAudioTrackChannelConfig(i);
        if (audioTrackChannelConfig == 0) {
            return false;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(audioTrackChannelConfig);
        if (format.sampleRate != -1) {
            channelMask.setSampleRate(format.sampleRate);
        }
        return ((Spatializer) Preconditions.checkNotNull(this.spatializer)).canBeSpatialized(audioAttributes.getPlatformAudioAttributes(), channelMask.build());
    }

    public List<Integer> getSpatializedChannelMasks() {
        if (!isSupportedAvailableAndEnabled()) {
            return ImmutableList.of();
        }
        if (Build.VERSION.SDK_INT >= 36) {
            return ((Spatializer) Preconditions.checkNotNull(this.spatializer)).getSpatializedChannelMasks();
        }
        return ImmutableList.of(252);
    }

    public void release() {
        Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener;
        Spatializer spatializer = this.spatializer;
        if (spatializer == null || (onSpatializerStateChangedListener = this.listener) == null || this.handler == null) {
            return;
        }
        spatializer.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
        this.handler.removeCallbacksAndMessages(null);
    }
}
