package androidx.media3.session;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* JADX INFO: loaded from: classes8.dex */
public final class MediaNotification {
    public static final String NOTIFICATION_DISMISSED_EVENT_KEY = "androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY";
    public final Notification notification;
    public final int notificationId;

    public interface ActionFactory {
        NotificationCompat.Action createCustomAction(MediaSession mediaSession, IconCompat iconCompat, CharSequence charSequence, String str, Bundle bundle);

        NotificationCompat.Action createCustomActionFromCustomCommandButton(MediaSession mediaSession, CommandButton commandButton);

        NotificationCompat.Action createMediaAction(MediaSession mediaSession, IconCompat iconCompat, CharSequence charSequence, int i);

        PendingIntent createMediaActionPendingIntent(MediaSession mediaSession, int i);

        default PendingIntent createNotificationDismissalIntent(MediaSession mediaSession) {
            return createMediaActionPendingIntent(mediaSession, 3);
        }
    }

    public interface Provider {

        public interface Callback {
            void onNotificationChanged(MediaNotification mediaNotification);
        }

        MediaNotification createNotification(MediaSession mediaSession, ImmutableList<CommandButton> immutableList, ActionFactory actionFactory, Callback callback);

        NotificationChannelInfo getNotificationChannelInfo();

        boolean handleCustomCommand(MediaSession mediaSession, String str, Bundle bundle);

        public static class NotificationChannelInfo {
            private final String id;
            private final String name;

            public NotificationChannelInfo(String str, String str2) {
                this.id = str;
                this.name = str2;
            }

            public String getId() {
                return this.id;
            }

            public String getName() {
                return this.name;
            }
        }
    }

    public MediaNotification(int i, Notification notification) {
        this.notificationId = i;
        this.notification = (Notification) Preconditions.checkNotNull(notification);
    }
}
