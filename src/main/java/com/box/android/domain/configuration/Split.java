package com.box.android.domain.configuration;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BOX_AI_API_CHANGES_SAFEGUARD' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: SplitConfiguration.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*¨\u0006+"}, d2 = {"Lcom/box/android/domain/configuration/Split;", "", "featureName", "", "defaultValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getFeatureName", "()Ljava/lang/String;", "getDefaultValue", "()Z", "TEST_SPLIT", "JOB_CHUNK_DOWNLOAD", "FILE_ACTIVITIES_MODERNIZATION", "COMPOSE_FILE_ACTIVITIES", "USE_CO_AUTHORING", "SPLUNK_RUM", "BOX_AI_API_CHANGES_SAFEGUARD", "DOWNLOAD_FOLDER_JOB_MIGRATION", "VIDEO_WATERMARKING_MODERNIZATION", "WATERMARKING_SETTINGS", "RESET_JOB_INFO", "MOVE_COPY_V2", "HUBS", "IN_APP_UPDATES", "BOX_AI_MULTIDOC", "BOX_AI_STUDIO_SETTINGS_UPDATE", "BOX_AI_QUICK_ACTION", "VIDEO_ANNOTATIONS", "MIGRATE_OFFLINE_INFO_ROOM", "PROMPT_LIBRARY", "OFFLINE_V2", "USE_GRAPHQL_ENDPOINT", "MAIN_SCREEN_REDESIGN", "AX_EXPERIENCE", "AX_EXPERIENCE_FOR_PREVIEW_MULTIDOC", "EXIF_METADATA_EXTRACTION", "UNIFIED_SEARCH", "AX_FOR_SEARCH", "WEBAUTHN_IN_LOGIN_WEBVIEW", "NOTES_SCREEN", "NEW_NOTE_CREATION_FLOW", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Split {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Split[] $VALUES;
    public static final Split BOX_AI_API_CHANGES_SAFEGUARD;
    public static final Split BOX_AI_STUDIO_SETTINGS_UPDATE;
    public static final Split IN_APP_UPDATES;
    public static final Split PROMPT_LIBRARY;
    public static final Split RESET_JOB_INFO;
    public static final Split VIDEO_WATERMARKING_MODERNIZATION;
    private final boolean defaultValue;
    private final String featureName;
    public static final Split TEST_SPLIT = new Split("TEST_SPLIT", 0, "test_split", false, 2, null);
    public static final Split JOB_CHUNK_DOWNLOAD = new Split("JOB_CHUNK_DOWNLOAD", 1, "job_chunk_download_mobile", true);
    public static final Split FILE_ACTIVITIES_MODERNIZATION = new Split("FILE_ACTIVITIES_MODERNIZATION", 2, "preview_threaded_replies_q1fy24", false, 2, null);
    public static final Split COMPOSE_FILE_ACTIVITIES = new Split("COMPOSE_FILE_ACTIVITIES", 3, "compose_file_activities_mobile", false, 2, null);
    public static final Split USE_CO_AUTHORING = new Split("USE_CO_AUTHORING", 4, "wopi_coauthoring_mobile", false, 2, null);
    public static final Split SPLUNK_RUM = new Split("SPLUNK_RUM", 5, "splunk_rum_mobile", false, 2, null);
    public static final Split DOWNLOAD_FOLDER_JOB_MIGRATION = new Split("DOWNLOAD_FOLDER_JOB_MIGRATION", 7, "download_folder_job_migration", true);
    public static final Split WATERMARKING_SETTINGS = new Split("WATERMARKING_SETTINGS", 9, "mobile_security_watermarking_settings", true);
    public static final Split MOVE_COPY_V2 = new Split("MOVE_COPY_V2", 11, "job_system_move_copy_mobile", false, 2, null);
    public static final Split HUBS = new Split("HUBS", 12, "hubs_mobile", false, 2, null);
    public static final Split BOX_AI_MULTIDOC = new Split("BOX_AI_MULTIDOC", 14, "box_ai_multidoc_mobile", true);
    public static final Split BOX_AI_QUICK_ACTION = new Split("BOX_AI_QUICK_ACTION", 16, "box_ai_quick_action_mobile", true);
    public static final Split VIDEO_ANNOTATIONS = new Split("VIDEO_ANNOTATIONS", 17, "video_annotations_mobile", true);
    public static final Split MIGRATE_OFFLINE_INFO_ROOM = new Split("MIGRATE_OFFLINE_INFO_ROOM", 18, "migrate_offline_info_to_room_mobile", true);
    public static final Split OFFLINE_V2 = new Split("OFFLINE_V2", 20, "job_system_offline_mobile", true);
    public static final Split USE_GRAPHQL_ENDPOINT = new Split("USE_GRAPHQL_ENDPOINT", 21, "use_graphql_endpoint_mobile", true);
    public static final Split MAIN_SCREEN_REDESIGN = new Split("MAIN_SCREEN_REDESIGN", 22, "new_main_screen_with_redesign_mobile", true);
    public static final Split AX_EXPERIENCE = new Split("AX_EXPERIENCE", 23, "ax_bottom_tab", true);
    public static final Split AX_EXPERIENCE_FOR_PREVIEW_MULTIDOC = new Split("AX_EXPERIENCE_FOR_PREVIEW_MULTIDOC", 24, "ax_for_preview_and_multidoc", true);
    public static final Split EXIF_METADATA_EXTRACTION = new Split("EXIF_METADATA_EXTRACTION", 25, "exif_metadata_extraction_mobile", true);
    public static final Split UNIFIED_SEARCH = new Split("UNIFIED_SEARCH", 26, "unified_search", true);
    public static final Split AX_FOR_SEARCH = new Split("AX_FOR_SEARCH", 27, "ax_for_search", true);
    public static final Split WEBAUTHN_IN_LOGIN_WEBVIEW = new Split("WEBAUTHN_IN_LOGIN_WEBVIEW", 28, "mobile_security_webauthn_in_login_webview", true);
    public static final Split NOTES_SCREEN = new Split("NOTES_SCREEN", 29, "notes_screen_mobile", true);
    public static final Split NEW_NOTE_CREATION_FLOW = new Split("NEW_NOTE_CREATION_FLOW", 30, "new_note_creation_flow_mobile", true);

    private static final /* synthetic */ Split[] $values() {
        return new Split[]{TEST_SPLIT, JOB_CHUNK_DOWNLOAD, FILE_ACTIVITIES_MODERNIZATION, COMPOSE_FILE_ACTIVITIES, USE_CO_AUTHORING, SPLUNK_RUM, BOX_AI_API_CHANGES_SAFEGUARD, DOWNLOAD_FOLDER_JOB_MIGRATION, VIDEO_WATERMARKING_MODERNIZATION, WATERMARKING_SETTINGS, RESET_JOB_INFO, MOVE_COPY_V2, HUBS, IN_APP_UPDATES, BOX_AI_MULTIDOC, BOX_AI_STUDIO_SETTINGS_UPDATE, BOX_AI_QUICK_ACTION, VIDEO_ANNOTATIONS, MIGRATE_OFFLINE_INFO_ROOM, PROMPT_LIBRARY, OFFLINE_V2, USE_GRAPHQL_ENDPOINT, MAIN_SCREEN_REDESIGN, AX_EXPERIENCE, AX_EXPERIENCE_FOR_PREVIEW_MULTIDOC, EXIF_METADATA_EXTRACTION, UNIFIED_SEARCH, AX_FOR_SEARCH, WEBAUTHN_IN_LOGIN_WEBVIEW, NOTES_SCREEN, NEW_NOTE_CREATION_FLOW};
    }

    public static EnumEntries<Split> getEntries() {
        return $ENTRIES;
    }

    public static Split valueOf(String str) {
        return (Split) Enum.valueOf(Split.class, str);
    }

    public static Split[] values() {
        return (Split[]) $VALUES.clone();
    }

    private Split(String str, int i, String str2, boolean z) {
        super(str, i);
        this.featureName = str2;
        this.defaultValue = z;
    }

    /* synthetic */ Split(String str, int i, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i2 & 2) != 0 ? false : z);
    }

    public final boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final String getFeatureName() {
        return this.featureName;
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        BOX_AI_API_CHANGES_SAFEGUARD = new Split("BOX_AI_API_CHANGES_SAFEGUARD", 6, "disable_box_ai_below_app_version_mobile", false, 2, defaultConstructorMarker);
        int i = 2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        boolean z = false;
        VIDEO_WATERMARKING_MODERNIZATION = new Split("VIDEO_WATERMARKING_MODERNIZATION", 8, "mobile_security_watermarking_modernization", z, i, defaultConstructorMarker2);
        RESET_JOB_INFO = new Split("RESET_JOB_INFO", 10, "reset_job_info_mobile", z, i, defaultConstructorMarker2);
        IN_APP_UPDATES = new Split("IN_APP_UPDATES", 13, "in_app_updates_mobile", false, 2, defaultConstructorMarker);
        int i2 = 2;
        DefaultConstructorMarker defaultConstructorMarker3 = null;
        boolean z2 = false;
        BOX_AI_STUDIO_SETTINGS_UPDATE = new Split("BOX_AI_STUDIO_SETTINGS_UPDATE", 15, "box_aistudio_ai_settings_updates", z2, i2, defaultConstructorMarker3);
        PROMPT_LIBRARY = new Split("PROMPT_LIBRARY", 19, "prompt_library_mobile", z2, i2, defaultConstructorMarker3);
        Split[] splitArr$values = $values();
        $VALUES = splitArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(splitArr$values);
    }
}
