package com.box.android.domain.localrepo;

import android.content.SharedPreferences;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.utilities.BoxConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ILocalSharedPreferences.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\f\r\u000eJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\tH&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/localrepo/ILocalSharedPreferences;", "Lcom/box/android/domain/identity/IUserContextComponent;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "prefName", "", "getEncryptedSharedPrefs", "Lcom/box/android/domain/localrepo/ILocalSharedPreferences$PreferenceName;", "onHardDestroy", "", "PreferenceName", "GlobalPreferenceKey", "PushNotificationPreferenceKey", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ILocalSharedPreferences extends IUserContextComponent {

    /* JADX INFO: compiled from: ILocalSharedPreferences.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b(\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/box/android/domain/localrepo/ILocalSharedPreferences$PreferenceName;", "", "<init>", "(Ljava/lang/String;I)V", BoxConstants.MYPREFERENCE, "OFFLINE", "PROMOTED_PARTNER_DIALOGS", "PROMOTED_PARTNER_TOOLTIPS", "PREFERRED_PACKAGE_FOR_MIME_TYPE", "updatesPreferences", "eventsPreferences", "PREVIEW_SALTS", "PREVIEW_NUM_PAGES", "offlinedFileSharedPreferences", "offlinedFolderSharedPreferences", "DOWNLOAD_SALTS", "one_cloud_tokens", SemanticAttributes.EventDomainValues.DEVICE, "GLOBAL", "UPLOAD_SYNC_FOLDER", "DOCUMENT_PROVIDER", "AUTO_CONTENT_UPLOAD_LOCAL_META_DATA", "PUSH_NOTIFICATION", "PUSH_NOTIFICATION_GLOBAL", "EMM", "FTUX", "ANALYTICS", "COLLECTIONS", "INTUNE_AUTH", "INTUNE_AUTH_ENCRYPTED", "OBSERVABILITY", "CAPTURE", "FEATURE_BANNERS", "LAUNCH_INTO_CAPTURE", "FEATURE_FLIP_DEBUG_OVERRIDE", "GENIUS_SCAN_LICENSE", "GENIUS_SCAN_SDK_LICENSE", "MOCO_ADMIN_SETTINGS", "SPLIT_ENVIRONMENT_OVERRIDE", "ENTERPRISE_VERIFIER", "APP_UPDATES", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum PreferenceName {
        myPreference,
        OFFLINE,
        PROMOTED_PARTNER_DIALOGS,
        PROMOTED_PARTNER_TOOLTIPS,
        PREFERRED_PACKAGE_FOR_MIME_TYPE,
        updatesPreferences,
        eventsPreferences,
        PREVIEW_SALTS,
        PREVIEW_NUM_PAGES,
        offlinedFileSharedPreferences,
        offlinedFolderSharedPreferences,
        DOWNLOAD_SALTS,
        one_cloud_tokens,
        device,
        GLOBAL,
        UPLOAD_SYNC_FOLDER,
        DOCUMENT_PROVIDER,
        AUTO_CONTENT_UPLOAD_LOCAL_META_DATA,
        PUSH_NOTIFICATION,
        PUSH_NOTIFICATION_GLOBAL,
        EMM,
        FTUX,
        ANALYTICS,
        COLLECTIONS,
        INTUNE_AUTH,
        INTUNE_AUTH_ENCRYPTED,
        OBSERVABILITY,
        CAPTURE,
        FEATURE_BANNERS,
        LAUNCH_INTO_CAPTURE,
        FEATURE_FLIP_DEBUG_OVERRIDE,
        GENIUS_SCAN_LICENSE,
        GENIUS_SCAN_SDK_LICENSE,
        MOCO_ADMIN_SETTINGS,
        SPLIT_ENVIRONMENT_OVERRIDE,
        ENTERPRISE_VERIFIER,
        APP_UPDATES;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<PreferenceName> getEntries() {
            return $ENTRIES;
        }
    }

    SharedPreferences getEncryptedSharedPrefs(PreferenceName prefName);

    SharedPreferences getSharedPreferences();

    SharedPreferences getSharedPreferences(PreferenceName prefName);

    SharedPreferences getSharedPreferences(String prefName);

    @Override // com.box.android.domain.identity.IUserContextComponent
    void onHardDestroy();

    /* JADX INFO: compiled from: ILocalSharedPreferences.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/domain/localrepo/ILocalSharedPreferences$GlobalPreferenceKey;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "ALLOW_COMMENTS_PUSH_NOTIFICATION", "ALLOW_COLLABS_PUSH_NOTIFICATION", "ALLOW_UPDATES_PUSH_NOTIFICATION", "ALLOW_TASKS_PUSH_NOTIFICATION", "PUSH_NOTIF_LANGUAGE", "PUSH_NOTIF_FIREBASE_TOKEN_WITH_BOX", "PUSH_NOTIF_BOX_NOTIFICATION_ID", "PUSH_NOTIF_FIREBASE_TOKEN", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum GlobalPreferenceKey {
        ALLOW_COMMENTS_PUSH_NOTIFICATION("shared_pref_key_allow_comments_notification"),
        ALLOW_COLLABS_PUSH_NOTIFICATION("shared_pref_key_allow_collabs_notification"),
        ALLOW_UPDATES_PUSH_NOTIFICATION("shared_pref_key_allow_updates_notification"),
        ALLOW_TASKS_PUSH_NOTIFICATION("shared_pref_key_allow_tasks_notification"),
        PUSH_NOTIF_LANGUAGE("PushNotifController.language"),
        PUSH_NOTIF_FIREBASE_TOKEN_WITH_BOX("PushNotifController.firebaseToken.registeredWithbox"),
        PUSH_NOTIF_BOX_NOTIFICATION_ID("PushNotifController.boxNotificationId"),
        PUSH_NOTIF_FIREBASE_TOKEN("PushNotifController.token");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String key;

        public static EnumEntries<GlobalPreferenceKey> getEntries() {
            return $ENTRIES;
        }

        GlobalPreferenceKey(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }
    }

    /* JADX INFO: compiled from: ILocalSharedPreferences.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/box/android/domain/localrepo/ILocalSharedPreferences$PushNotificationPreferenceKey;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "COMMENT_CATEGORY_ENABLED", "COLLABORATION_INVITE_CATEGORY_ENABLED", "MENTIONS_CATEGORY_ENABLED", "EDIT_CATEGORY_ENABLED", "UPLOAD_CATEGORY_ENABLED", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum PushNotificationPreferenceKey {
        COMMENT_CATEGORY_ENABLED("comment_category_enabled"),
        COLLABORATION_INVITE_CATEGORY_ENABLED("collaboration_invite_category_enabled"),
        MENTIONS_CATEGORY_ENABLED("mentions_category_enabled"),
        EDIT_CATEGORY_ENABLED("edit_category_enabled"),
        UPLOAD_CATEGORY_ENABLED("upload_category_enabled");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String key;

        public static EnumEntries<PushNotificationPreferenceKey> getEntries() {
            return $ENTRIES;
        }

        PushNotificationPreferenceKey(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }
    }
}
