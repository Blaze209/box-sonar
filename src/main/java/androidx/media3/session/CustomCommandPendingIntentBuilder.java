package androidx.media3.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.common.base.Preconditions;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes8.dex */
public final class CustomCommandPendingIntentBuilder {
    static final String ACTION_CUSTOM = "androidx.media3.session.CUSTOM_NOTIFICATION_ACTION";
    static final String EXTRAS_KEY_ACTION_CUSTOM = "androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION";
    static final String EXTRAS_KEY_ACTION_CUSTOM_EXTRAS = "androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS";
    private final Context context;
    private final SessionCommand customSessionCommand;
    private final Class<? extends MediaSessionService> serviceClass;
    private String sessionId;

    public CustomCommandPendingIntentBuilder(Context context, Class<? extends MediaSessionService> cls, SessionCommand sessionCommand) {
        Preconditions.checkArgument(sessionCommand.commandCode == 0);
        this.context = context;
        this.serviceClass = cls;
        this.customSessionCommand = sessionCommand;
        this.sessionId = null;
    }

    public static Intent createCustomCommandIntent(Context context, SessionCommand sessionCommand, String str, Class<? extends MediaSessionService> cls) {
        Preconditions.checkArgument(sessionCommand.commandCode == 0);
        Intent intent = new Intent(ACTION_CUSTOM);
        intent.setData(MediaSessionImpl.createSessionUri(str));
        intent.setComponent(new ComponentName(context, cls));
        intent.putExtra(EXTRAS_KEY_ACTION_CUSTOM, sessionCommand.customAction);
        intent.putExtra(EXTRAS_KEY_ACTION_CUSTOM_EXTRAS, sessionCommand.customExtras);
        return intent;
    }

    public CustomCommandPendingIntentBuilder setSessionId(String str) {
        this.sessionId = str;
        return this;
    }

    public PendingIntent build() {
        return MAMPendingIntent.getService(this.context, ThreadLocalRandom.current().nextInt(), createCustomCommandIntent(this.context, this.customSessionCommand, this.sessionId, this.serviceClass), 201326592);
    }
}
