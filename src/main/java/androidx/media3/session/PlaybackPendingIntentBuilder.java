package androidx.media3.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.google.common.base.Preconditions;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;

/* JADX INFO: loaded from: classes8.dex */
public final class PlaybackPendingIntentBuilder {
    private final int command;
    private final Context context;
    private Bundle extras;
    private final int keyCode;
    private final Class<? extends MediaSessionService> serviceClass;
    private String sessionId;
    private boolean startAsForegroundService;

    private static boolean isSupportedKeyCode(int i) {
        return i == 87 || i == 88 || i == 86 || i == 90 || i == 89 || i == 85;
    }

    private static int toKeyCode(int i) {
        if (i == 1) {
            return 85;
        }
        if (i == 3) {
            return 86;
        }
        if (i == 11) {
            return 89;
        }
        if (i == 12) {
            return 90;
        }
        switch (i) {
            case 6:
            case 7:
                return 88;
            case 8:
            case 9:
                return 87;
            default:
                return 0;
        }
    }

    public PlaybackPendingIntentBuilder(Context context, int i, Class<? extends MediaSessionService> cls) {
        this.context = context;
        this.command = i;
        int keyCode = toKeyCode(i);
        this.keyCode = keyCode;
        Preconditions.checkArgument(isSupportedKeyCode(keyCode));
        this.serviceClass = cls;
        this.startAsForegroundService = false;
        this.sessionId = null;
        this.extras = Bundle.EMPTY;
    }

    public static Intent createMediaButtonIntent(Context context, int i, Bundle bundle, String str, Class<? extends MediaSessionService> cls) {
        return createMediaButtonIntentInternal(context, toKeyCode(i), bundle, str, cls);
    }

    public PlaybackPendingIntentBuilder setStartAsForegroundService(boolean z) {
        this.startAsForegroundService = z;
        return this;
    }

    public PlaybackPendingIntentBuilder setSessionId(String str) {
        this.sessionId = str;
        return this;
    }

    public PlaybackPendingIntentBuilder setExtras(Bundle bundle) {
        this.extras = (Bundle) Preconditions.checkNotNull(bundle);
        return this;
    }

    public PendingIntent build() {
        if (this.startAsForegroundService && this.command == 1) {
            Context context = this.context;
            int i = this.keyCode;
            return MAMPendingIntent.getForegroundService(context, i, createMediaButtonIntentInternal(context, i, this.extras, this.sessionId, this.serviceClass), 201326592);
        }
        Context context2 = this.context;
        int i2 = this.keyCode;
        return MAMPendingIntent.getService(context2, i2, createMediaButtonIntentInternal(context2, i2, this.extras, this.sessionId, this.serviceClass), 201326592);
    }

    public static boolean isCommandSupported(int i) {
        return isSupportedKeyCode(toKeyCode(i));
    }

    static Intent createMediaButtonIntentInternal(Context context, int i, Bundle bundle, String str, Class<? extends MediaSessionService> cls) {
        Preconditions.checkArgument(isSupportedKeyCode(i));
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setData(MediaSessionImpl.createSessionUri(str));
        intent.setComponent(new ComponentName(context, cls));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, i));
        return intent;
    }
}
