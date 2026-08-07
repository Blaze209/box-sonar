package androidx.media3.common.audio;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;

/* JADX INFO: loaded from: classes8.dex */
public final class AudioBecomingNoisyManager {
    private final HandlerWrapper backgroundHandler;
    private final Context context;
    private boolean isEnabled;
    private final AudioBecomingNoisyReceiver receiver;

    public interface Listener {
        void onAudioBecomingNoisy();
    }

    public AudioBecomingNoisyManager(Context context, Looper looper, Looper looper2, Listener listener, Clock clock) {
        this.context = context.getApplicationContext();
        this.backgroundHandler = clock.createHandler(looper, null);
        this.receiver = new AudioBecomingNoisyReceiver(clock.createHandler(looper2, null), listener);
    }

    public void setEnabled(boolean z) {
        if (z == this.isEnabled) {
            return;
        }
        if (z) {
            this.backgroundHandler.post(new Runnable() { // from class: androidx.media3.common.audio.AudioBecomingNoisyManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10332xc439ca36();
                }
            });
            this.isEnabled = true;
        } else {
            this.backgroundHandler.post(new Runnable() { // from class: androidx.media3.common.audio.AudioBecomingNoisyManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10333xc5701d15();
                }
            });
            this.isEnabled = false;
        }
    }

    /* JADX INFO: renamed from: lambda$setEnabled$0$androidx-media3-common-audio-AudioBecomingNoisyManager, reason: not valid java name */
    /* synthetic */ void m10332xc439ca36() {
        this.context.registerReceiver(this.receiver, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
    }

    /* JADX INFO: renamed from: lambda$setEnabled$1$androidx-media3-common-audio-AudioBecomingNoisyManager, reason: not valid java name */
    /* synthetic */ void m10333xc5701d15() {
        this.context.unregisterReceiver(this.receiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class AudioBecomingNoisyReceiver extends MAMBroadcastReceiver {
        private final HandlerWrapper eventHandler;
        private final Listener listener;

        private AudioBecomingNoisyReceiver(HandlerWrapper handlerWrapper, Listener listener) {
            this.eventHandler = handlerWrapper;
            this.listener = listener;
        }

        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.eventHandler.post(new Runnable() { // from class: androidx.media3.common.audio.AudioBecomingNoisyManager$AudioBecomingNoisyReceiver$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.callListenerIfEnabled();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void callListenerIfEnabled() {
            if (AudioBecomingNoisyManager.this.isEnabled) {
                this.listener.onAudioBecomingNoisy();
            }
        }
    }
}
