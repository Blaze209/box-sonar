package com.box.android.domain.analytics;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.amplitude.api.AmplitudeClient;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.services.IAppInBackgroundService;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxError;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.model.BoxTask;
import dagger.hilt.EntryPoints;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class BoxAmplitudeAnalytics {
    private static final String AMPLITUDE_PROXY_URL = "https://client-log.box.com/analytics-events/";
    private static final String AMPLITUDE_PROXY_URL_FEDRAMP_COMPLIANT = "https://client-log.box-gov.com/analytics-events/";
    private static final String AMPLITUDE_SESSION_SHARED_PREF_KEY = "amplitude_session_container";
    private static final String PROPERTY_SEPARATOR = "|";
    private static final String SESSION_ID = "session_id";
    static final String TAG = "Box-Amplitude";
    private static final String TAG_SET_CURRENT_PAGE = "Amplitude setCurrentPage";
    private static volatile BoxAmplitudeAnalytics sInstance;
    protected Context mAppContext;
    String mAppFlavor;
    IAppInBackgroundService mAppInBackgroundService;
    protected IAppRestrictionsManager mAppRestrictionsManager;
    private final AmplitudeClient mClient;
    FeatureFlips mFeatureFlips;
    SharedPreferences mGlobalSharedPreferences;
    private long mPageStartTime;
    private JSONObject mSessionContainer;
    IUserContextManager mUserContextManager;

    public interface BoxAmplitudeAnalyticsEntryPoint {
        @Named("app-flavor")
        String appFlavor();

        IAppInBackgroundService appInBackgroundService();

        IAppRestrictionsManager appRestrictionsManager();

        FeatureFlips featureFlips();

        @Named("global-shared-preference")
        SharedPreferences globalSharedPreferences();

        IUserContextManager userContextManager();
    }

    private BoxAmplitudeAnalytics(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        BoxAmplitudeAnalyticsEntryPoint boxAmplitudeAnalyticsEntryPoint = (BoxAmplitudeAnalyticsEntryPoint) EntryPoints.get(applicationContext, BoxAmplitudeAnalyticsEntryPoint.class);
        this.mUserContextManager = boxAmplitudeAnalyticsEntryPoint.userContextManager();
        this.mGlobalSharedPreferences = boxAmplitudeAnalyticsEntryPoint.globalSharedPreferences();
        this.mAppFlavor = boxAmplitudeAnalyticsEntryPoint.appFlavor();
        this.mAppRestrictionsManager = boxAmplitudeAnalyticsEntryPoint.appRestrictionsManager();
        this.mAppInBackgroundService = boxAmplitudeAnalyticsEntryPoint.appInBackgroundService();
        this.mFeatureFlips = boxAmplitudeAnalyticsEntryPoint.featureFlips();
        AmplitudeClient amplitudeClient = new AmplitudeClient();
        this.mClient = amplitudeClient;
        amplitudeClient.initialize(context, "c6eb3d709c5c30ca80c0381080bcc254").enableForegroundTracking((Application) context.getApplicationContext());
        amplitudeClient.disableLocationListening();
        amplitudeClient.setServerUrl(this.mAppRestrictionsManager.isAppFedrampHighCompliant() ? AMPLITUDE_PROXY_URL_FEDRAMP_COMPLIANT : AMPLITUDE_PROXY_URL);
        restoreSessionContainer();
        this.mAppInBackgroundService.add(new IAppInBackgroundService.Listener() { // from class: com.box.android.domain.analytics.BoxAmplitudeAnalytics.1
            @Override // com.box.android.domain.services.IAppInBackgroundService.Listener
            public void onMoveToForeground() {
            }

            @Override // com.box.android.domain.services.IAppInBackgroundService.Listener
            public void onMoveToBackground() {
                BoxAmplitudeAnalytics.this.removeSessionProperty(PushNotifEventPropertyBuilder.EVENT_PROPERTY_NOTIF_TYPE);
            }
        });
    }

    private void restoreSessionContainer() {
        JSONObject jsonForString = getJsonForString(getSessionInfoSharedPrefs().getString(AMPLITUDE_SESSION_SHARED_PREF_KEY, null));
        if (!jsonForString.has("session_id")) {
            try {
                jsonForString.put("session_id", this.mClient.getSessionId());
                getSessionInfoSharedPrefs().edit().putString(AMPLITUDE_SESSION_SHARED_PREF_KEY, jsonForString.toString()).apply();
            } catch (JSONException e) {
                BoxLogUtils.e(TAG, "Could not initialize session ID for amplitude", e);
            }
        }
        this.mSessionContainer = jsonForString;
    }

    public static BoxAmplitudeAnalytics getInstance() {
        if (sInstance == null) {
            synchronized (BoxAmplitudeAnalytics.class) {
                if (sInstance == null) {
                    sInstance = new BoxAmplitudeAnalytics(ApplicationProvider.application.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    public synchronized boolean setCurrentPage(String str) {
        String sessionPropertyAsString = getSessionPropertyAsString(BoxAnalyticsParams.SESSION_PAGE_NAME);
        if (sessionPropertyAsString != null && sessionPropertyAsString.equals(str)) {
            return false;
        }
        setSessionProperty(BoxAnalyticsParams.SESSION_PAGE_NAME, str);
        setSessionProperty(BoxAnalyticsParams.SESSION_PREVIOUS_PAGE_NAME, sessionPropertyAsString);
        this.mPageStartTime = System.currentTimeMillis();
        BoxLogUtils.i(TAG_SET_CURRENT_PAGE, str);
        return true;
    }

    synchronized String getCurrentPage() {
        return getSessionPropertyAsString(BoxAnalyticsParams.SESSION_PAGE_NAME);
    }

    public long getCurrentPageStartTime() {
        return this.mPageStartTime;
    }

    private synchronized void setReferrer(String str, JSONArray jSONArray) {
        setSessionProperty(BoxAnalyticsParams.SESSION_EXTERNAL_REFERRER, str);
        if (jSONArray != null) {
            setSessionProperty(BoxAnalyticsParams.SESSION_EXTERNAL_TRACKING_CODE, jSONArray);
        }
    }

    public void setReferrer(String str, Uri uri) {
        setReferrer(str, getReferrerTrackingArray(uri));
    }

    public static JSONArray getReferrerTrackingArray(Uri uri) {
        Set<String> queryParameterNames;
        if (uri == null || (queryParameterNames = uri.getQueryParameterNames()) == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : queryParameterNames) {
            if (BoxAnalyticsParams.INSTANCE.getEXPECTED_TRACKING_CODES().contains(str)) {
                jSONArray.put(str + "|" + uri.getQueryParameter(str));
            }
        }
        return jSONArray;
    }

    public void setReferrer(String str) {
        setReferrer(str, (JSONArray) null);
    }

    private synchronized String getSessionPropertyAsString(String str) {
        JSONObject sessionProperties = getSessionProperties();
        if (sessionProperties.has(str)) {
            try {
                return sessionProperties.getString(str);
            } catch (JSONException unused) {
                BoxLogUtils.e(TAG, "Could not retrieve property from session - propertyName:" + str);
                return null;
            }
        }
        return null;
    }

    void appendSessionPropertiesToEvent(EventPropertyBuilder eventPropertyBuilder) {
        if (eventPropertyBuilder != null) {
            JSONObject sessionProperties = getSessionProperties();
            Iterator<String> itKeys = sessionProperties.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!"session_id".equals(next)) {
                    try {
                        eventPropertyBuilder.setProperty(next, sessionProperties.get(next));
                    } catch (JSONException e) {
                        BoxLogUtils.e(TAG, "Could not include session data into event", e);
                    }
                }
            }
        }
    }

    private synchronized JSONObject getSessionProperties() {
        try {
            if (this.mClient.getSessionId() != -1 && this.mClient.getSessionId() != this.mSessionContainer.getLong("session_id")) {
                if (this.mSessionContainer.getLong("session_id") == -1) {
                    this.mSessionContainer.put("session_id", this.mClient.getSessionId());
                    getSessionInfoSharedPrefs().edit().putString(AMPLITUDE_SESSION_SHARED_PREF_KEY, this.mSessionContainer.toString()).apply();
                    return this.mSessionContainer;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("session_id", this.mClient.getSessionId());
                    JSONObject jSONObject2 = createAppInfoBuilder(this.mGlobalSharedPreferences, this.mAppFlavor).mProperties;
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.put(next, jSONObject2.get(next));
                    }
                    jSONObject.put(BoxAnalyticsParams.SESSION_EXTERNAL_REFERRER, "direct");
                    getSessionInfoSharedPrefs().edit().putString(AMPLITUDE_SESSION_SHARED_PREF_KEY, jSONObject.toString()).apply();
                } catch (JSONException e) {
                    BoxLogUtils.e(TAG, "getSessionProperties - failed to populate new session info", e);
                }
                this.mSessionContainer = jSONObject;
                return jSONObject;
            }
            return this.mSessionContainer;
        } catch (JSONException e2) {
            BoxLogUtils.e(TAG, "getSessionProperties - failed to retrieve session data", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setSessionProperty(String str, Object obj) {
        JSONObject sessionProperties = getSessionProperties();
        try {
            sessionProperties.put(str, obj);
            getSessionInfoSharedPrefs().edit().putString(AMPLITUDE_SESSION_SHARED_PREF_KEY, sessionProperties.toString()).apply();
        } catch (JSONException e) {
            BoxLogUtils.e(TAG, "setSessionProperty failed for property:" + str, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeSessionProperty(String str) {
        JSONObject sessionProperties = getSessionProperties();
        sessionProperties.remove(str);
        getSessionInfoSharedPrefs().edit().putString(AMPLITUDE_SESSION_SHARED_PREF_KEY, sessionProperties.toString()).apply();
    }

    private SharedPreferences getSessionInfoSharedPrefs() {
        return this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.ANALYTICS);
    }

    public static EventPropertyBuilder createEventBuilder() {
        return new EventPropertyBuilder();
    }

    public static DocumentScanningEventPropertyBuilder createDocumentScanningEventBuilder() {
        return new DocumentScanningEventPropertyBuilder();
    }

    public static PreviewEventPropertyBuilder createPreviewEventPropertyBuilder() {
        return new PreviewEventPropertyBuilder();
    }

    public static AudioRecordingEventPropertyBuilder createAudioRecordingEventBuilder() {
        return new AudioRecordingEventPropertyBuilder();
    }

    public static CaptureEventPropertyBuilder createCaptureEventBuilder() {
        return new CaptureEventPropertyBuilder();
    }

    public static JobEventPropertyBuilder createJobEventBuilder(String str, boolean z) {
        return new JobEventPropertyBuilder(str, z);
    }

    public static FeatureBannerEventPropertyBuilder createFeatureBannerEventBuilder() {
        return new FeatureBannerEventPropertyBuilder();
    }

    public static ShareEventPropertyBuilder createShareEventBuilder() {
        return new ShareEventPropertyBuilder();
    }

    public static SearchEventPropertyBuilder createSearchEventBuilder() {
        return new SearchEventPropertyBuilder();
    }

    public static TaskEventPropertyBuilder createTaskEventBuilder() {
        return new TaskEventPropertyBuilder();
    }

    public static CaptureSettingsPropertyBuilder createCaptureSettingsEventBuilder() {
        return new CaptureSettingsPropertyBuilder();
    }

    public static BackgroundEventPropertyBuilder createBackgroundEventPropertyBuilder() {
        return new BackgroundEventPropertyBuilder();
    }

    public static PushNotifEventPropertyBuilder createPushNotifEventPropertyBuilder() {
        return new PushNotifEventPropertyBuilder();
    }

    public static BoxUploadFlowPropertyBuilder createBoxUploadFlowPropertyBuilder() {
        return new BoxUploadFlowPropertyBuilder();
    }

    public static NotifBlockedEventPropertyBuilder createNotifBlockedEventPropertyBuilder() {
        return new NotifBlockedEventPropertyBuilder();
    }

    public static FileActivitiesEventPropertyBuilder createFileActivitiesEventPropertyBuilder() {
        return new FileActivitiesEventPropertyBuilder();
    }

    public static BoxAiEventPropertyBuilder createBoxAiEventPropertyBuilder() {
        return new BoxAiEventPropertyBuilder();
    }

    public static MfaSetupEventPropertyBuilder createMfaSetupEventPropertyBuilder() {
        return new MfaSetupEventPropertyBuilder();
    }

    public static ForceUpdateEventPropertyBuilder createForceUpdateEventPropertyBuilder() {
        return new ForceUpdateEventPropertyBuilder();
    }

    public static ApplicationPropertyBuilder createAppInfoBuilder(SharedPreferences sharedPreferences, String str) {
        return new ApplicationPropertyBuilder(sharedPreferences, str);
    }

    public static void sendAnalyticsEventForOptions(String str, String str2) {
        EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = createEventBuilder();
        eventPropertyBuilderCreateEventBuilder.setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
        eventPropertyBuilderCreateEventBuilder.setCtaPageLocation(str2);
        eventPropertyBuilderCreateEventBuilder.setCtaTarget(str);
        eventPropertyBuilderCreateEventBuilder.logEvent(BoxAnalyticsParams.EVENT_MORE_OPTIONS_TRIGGERED);
    }

    public static abstract class AmplitudeBuilder {
        protected final boolean mAmplitudeEnabled;
        protected final BoxAmplitudeAnalytics mBoxAmplitudeAnalytics;
        protected final AmplitudeClient mBuilderClient;
        protected JSONObject mProperties = new JSONObject();

        public AmplitudeBuilder() {
            BoxAmplitudeAnalytics boxAmplitudeAnalytics = BoxAmplitudeAnalytics.getInstance();
            this.mBoxAmplitudeAnalytics = boxAmplitudeAnalytics;
            this.mBuilderClient = boxAmplitudeAnalytics.mClient;
            this.mAmplitudeEnabled = !CommonBoxUtil.isRunningAutomatedTest();
        }

        protected void setProperty(String str, Object obj) {
            try {
                this.mProperties.put(str, obj);
            } catch (JSONException unused) {
                BoxLogUtils.e(BoxAmplitudeAnalytics.TAG, "Could not set amplitude property - key:" + str);
            }
        }

        protected String getPropertyAsString(String str) {
            try {
                return this.mProperties.getString(str);
            } catch (JSONException unused) {
                BoxLogUtils.e(BoxAmplitudeAnalytics.TAG, "Could not get property as string - key:" + str);
                return null;
            }
        }

        protected void removeProperty(String str) {
            this.mProperties.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject getJsonForString(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                BoxLogUtils.e(TAG, "Could not create JsonObject", e);
            }
        }
        return new JSONObject();
    }

    public static class EventPropertyBuilder extends AmplitudeBuilder {
        private static final String AUTH_INFO_REFRESH_TOKEN_LOADED_SIZE = "auth_info_refresh_token_loaded_size";
        private static final String AUTH_INFO_REFRESH_TOKEN_STORED_SIZE = "auth_info_refresh_token_stored_size";
        private static final String AUTH_INFO_STORAGE_STACK_TRACE = "auth_info_storage_stack_trace";
        private static final String CONNECTOR = ":";
        private static final String CONTENT_OWNERSHIP_TYPE = "content_ownership_type";
        private static final String CREATE_COLLECTION_ERROR_TYPE = "create_collection_error_type";
        private static final String CTA_DESCRIPTION = "cta_description";
        private static final String CTA_FULL_NAME = "cta_full_name";
        private static final String CTA_ITEM_COUNT = "cta_item_count";
        private static final String CTA_MOBILE_TYPE = "cta_mobile_app_type";
        private static final String CTA_PAGE_LOCATION = "cta_page_location";
        private static final String CTA_STYLE = "cta_style";
        private static final String CTA_TARGET = "cta_target";
        private static final String CTA_TEXT = "cta_text";
        private static final String DARK_MODE = "dark_mode";
        private static final String ERROR_CODE = "error_code";
        private static final String ERROR_MESSAGE = "error_text";
        private static final String ERROR_ORIGIN = "error_origin";
        private static final String ERROR_TYPE = "error_type";
        protected static final String EVENT_PROPERTY_TOGGLE = "toggle_value";
        private static final String EXPERIMENT_DISABLED = "control";
        private static final String EXPERIMENT_ENABLED = "enabled";
        private static final String FILE_EXTENSION = "file_extension";
        private static final String FILE_ID = "file_id";
        private static final String FILE_SIZE = "file_size";
        private static final String FILE_TYPE = "file_type";
        private static final String FLOW = "flow";
        private static final String FOLDER_ID = "folder_id";
        private static final String FOLDER_LEVEL = "folder_level";
        private static final String IS_COLLECTION_ITEM = "is_collection_item";
        private static final String IS_FAVORITE = "is_favorite";
        public static final String IS_SUCCESSFUL_CREATION = "is_successful_creation";
        public static final String ITEM_TYPE = "item_type";
        private static final String MENU_ITEM_SELECTED = "menu_item_selected";
        private static final String MOBILE_TEST_ID = "mobile_test_id";
        private static final String NEW_DATA = "new_data";
        protected static final String NOTIFICATION_BOX_SOURCE = "box_source";
        protected static final String NOTIFICATION_CHANNEL = "channel";
        public static final String NUM_OF_AUTO_RETRIES = "number_of_auto_retries";
        private static final String PAGE_EXPERIENCE = "page_experience";
        protected static final String PROPERTY_DISABLED = "disabled";
        protected static final String PROPERTY_ENABLED = "enabled";
        public static final String ROUND_TRIP_TIME = "round_trip_time";
        public static final String SOURCE = "source";
        private static final String TIME_ON_PAGE = "time_on_page";
        private final int mUiMode = ApplicationProvider.application.getApplicationContext().getResources().getConfiguration().uiMode;

        public EventPropertyBuilder setPageExperience(String str) {
            setProperty(PAGE_EXPERIENCE, str);
            return this;
        }

        public EventPropertyBuilder setFlow(String str) {
            setProperty(FLOW, str);
            return this;
        }

        public EventPropertyBuilder setCtaPageLocation(String str) {
            setProperty(CTA_PAGE_LOCATION, str);
            return this;
        }

        public EventPropertyBuilder setCtaTarget(String str) {
            setProperty(CTA_TARGET, str);
            return this;
        }

        public EventPropertyBuilder setCtaItemCount(Integer num) {
            setProperty(CTA_ITEM_COUNT, num);
            return this;
        }

        public EventPropertyBuilder setIsSuccessfulCreation(boolean z) {
            setProperty(IS_SUCCESSFUL_CREATION, Boolean.valueOf(z));
            return this;
        }

        public EventPropertyBuilder setTimeOnPage(long j) {
            setProperty(TIME_ON_PAGE, Long.valueOf(j > 0 ? Math.round(j / 1000.0d) : 0L));
            return this;
        }

        public EventPropertyBuilder setMobileCtaType(String str) {
            setProperty(CTA_MOBILE_TYPE, str);
            return this;
        }

        public EventPropertyBuilder setBoxItem(BoxItem boxItem) {
            if (boxItem instanceof BoxFolder) {
                removeProperty("file_id");
                removeProperty("file_type");
                removeProperty("file_size");
                setProperty("folder_id", boxItem.getUserId());
                setProperty(FOLDER_LEVEL, calculateFolderLevel((BoxFolder) boxItem));
                return this;
            }
            BoxFolder parent = boxItem.getParent();
            if (parent != null) {
                setProperty(FOLDER_LEVEL, calculateFolderLevel(parent));
            }
            if (boxItem instanceof BoxFile) {
                String fileExtension = CommonBoxUtil.getFileExtension(boxItem.getName(), "other");
                if (SupportedFileExtensions.INSTANCE.isSupportedExtension(fileExtension)) {
                    setProperty("file_extension", fileExtension.toLowerCase(Locale.ENGLISH));
                    setProperty("file_type", BoxAnalyticsParams.INSTANCE.calculateFileType(fileExtension));
                    return this;
                }
                setProperty("file_extension", "other");
                setProperty("file_type", "other");
            }
            return this;
        }

        public EventPropertyBuilder setContentOwnershipType(String str) {
            setProperty(CONTENT_OWNERSHIP_TYPE, str);
            return this;
        }

        private static String calculateFolderLevel(BoxFolder boxFolder) {
            String id = boxFolder.getUserId();
            if (id == null) {
                return "";
            }
            if (id.equals("0")) {
                return BoxAnalyticsParams.FOLDER_LEVEL_ALL_FILES;
            }
            return "other";
        }

        public EventPropertyBuilder setTimeOnPage() {
            return setTimeOnPage(System.currentTimeMillis() - this.mBoxAmplitudeAnalytics.getCurrentPageStartTime());
        }

        public EventPropertyBuilder setFileExtension(String str) {
            setProperty("file_extension", str);
            return this;
        }

        public EventPropertyBuilder setFileType(String str) {
            setProperty("file_type", str);
            return this;
        }

        public EventPropertyBuilder setItemType(String str) {
            setProperty("item_type", str);
            return this;
        }

        public EventPropertyBuilder setIsCollectionItem(boolean z) {
            setProperty(IS_COLLECTION_ITEM, Boolean.valueOf(z));
            return this;
        }

        public EventPropertyBuilder setIsFavorite(boolean z) {
            setProperty(IS_FAVORITE, Boolean.valueOf(z));
            return this;
        }

        public EventPropertyBuilder setMenuItemSelected(String str) {
            setProperty(MENU_ITEM_SELECTED, str);
            return this;
        }

        public EventPropertyBuilder setFileSize(long j) {
            setProperty("file_size", Long.valueOf(j));
            return this;
        }

        public EventPropertyBuilder setAuthInfoStorageStackTrace(String str) {
            setProperty(AUTH_INFO_STORAGE_STACK_TRACE, str);
            return this;
        }

        public EventPropertyBuilder setRefreshTokenSize(Integer num) {
            setProperty(AUTH_INFO_REFRESH_TOKEN_STORED_SIZE, num);
            return this;
        }

        public EventPropertyBuilder setRefreshTokenLoadedSize(Integer num) {
            setProperty(AUTH_INFO_REFRESH_TOKEN_LOADED_SIZE, num);
            return this;
        }

        private void setCtaFullName() {
            if (TextUtils.isEmpty(getPropertyAsString(CTA_TARGET))) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.mBoxAmplitudeAnalytics.getCurrentPage());
            appendIfNotEmpty(sb, getPropertyAsString(CTA_PAGE_LOCATION));
            appendIfNotEmpty(sb, getPropertyAsString(CTA_STYLE));
            appendIfNotEmpty(sb, getPropertyAsString(CTA_DESCRIPTION));
            appendIfNotEmpty(sb, getPropertyAsString(CTA_TARGET));
            setProperty(CTA_FULL_NAME, sb.toString());
        }

        private void setUIMode() {
            setProperty(DARK_MODE, (this.mUiMode & 48) == 32 ? "enabled" : PROPERTY_DISABLED);
        }

        private void preProcess() {
            setCtaFullName();
            setUIMode();
        }

        private static void appendIfNotEmpty(StringBuilder sb, String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            sb.append(CONNECTOR);
            sb.append(str);
        }

        public EventPropertyBuilder setError(int i, String str, int i2) {
            return setError(String.valueOf(i), str, String.valueOf(i2));
        }

        public EventPropertyBuilder setError(String str, String str2, String str3) {
            setProperty("error_type", str);
            setProperty(ERROR_MESSAGE, str2);
            setProperty("error_code", str3);
            return this;
        }

        public EventPropertyBuilder setErrorOrigin(String str) {
            setProperty(ERROR_ORIGIN, str);
            return this;
        }

        public EventPropertyBuilder setRoundTripTime(String str) {
            setProperty(ROUND_TRIP_TIME, str);
            return this;
        }

        public EventPropertyBuilder setCreateCollectionErrorType(String str) {
            setProperty(CREATE_COLLECTION_ERROR_TYPE, str);
            return this;
        }

        public EventPropertyBuilder setNewDataOnRefresh(boolean z) {
            setProperty(NEW_DATA, Boolean.valueOf(z));
            return this;
        }

        public EventPropertyBuilder setCtaText(String str) {
            setProperty(CTA_TEXT, str);
            return this;
        }

        public void logEvent(String str) {
            if (this.mAmplitudeEnabled) {
                this.mBoxAmplitudeAnalytics.appendSessionPropertiesToEvent(this);
                preProcess();
                this.mBuilderClient.logEvent(str, this.mProperties);
                PendoAnalytics.INSTANCE.trackEvent(str, this.mProperties);
                BoxLogUtils.i(BoxAmplitudeAnalytics.TAG, str);
                BoxLogUtils.i(BoxAmplitudeAnalytics.TAG, this.mProperties.toString());
            }
        }
    }

    public static class BoxUploadFlowPropertyBuilder extends BackgroundEventPropertyBuilder {
        public static final String ELAPSED_TIME_SINCE_TRIGGERED = "elapsed_time_since_triggered";
        public static final String MOBILE_UNIQUE_ID = "mobile_unique_id";
        public static final String NUM_TRIES = "num_tries";

        public void setNumTriesProperty(int i) {
            setProperty(NUM_TRIES, Integer.valueOf(i));
        }

        public void setMobileUniqueId(String str) {
            setProperty(MOBILE_UNIQUE_ID, str);
        }

        public void setElapsedTimeSinceTriggered(long j) {
            setProperty(ELAPSED_TIME_SINCE_TRIGGERED, Long.valueOf(j));
        }
    }

    public static class PreviewEventPropertyBuilder extends EventPropertyBuilder {
        private static final String LAUNCH_MODE = "launch_mode";

        public PreviewEventPropertyBuilder setLaunchMode(String str) {
            setProperty(LAUNCH_MODE, str);
            return this;
        }
    }

    public static class DocumentScanningEventPropertyBuilder extends EventPropertyBuilder {
        private static final String NUMBER_OF_PAGES = "num_pages";
        private static final String OCR_DURATION = "ocr_duration_in_seconds";
        private static final String OCR_LANGUAGE = "ocr_language";

        public DocumentScanningEventPropertyBuilder setNumberOfPages(Integer num) {
            setProperty(NUMBER_OF_PAGES, num);
            return this;
        }

        public DocumentScanningEventPropertyBuilder setOcrLanguage(String str) {
            setProperty(OCR_LANGUAGE, str);
            return this;
        }

        public DocumentScanningEventPropertyBuilder setOcrDuration(Double d) {
            setProperty(OCR_DURATION, d);
            return this;
        }
    }

    public static class AudioRecordingEventPropertyBuilder extends EventPropertyBuilder {
        private static final String DURATION_IN_MINUTES = "duration_in_minutes";

        public AudioRecordingEventPropertyBuilder setDurationInMinutes(String str) {
            setProperty(DURATION_IN_MINUTES, str);
            return this;
        }
    }

    public static class CaptureEventPropertyBuilder extends EventPropertyBuilder {
        public void logCaptureLaunched() {
            logEvent(BoxAnalyticsParams.EVENT_CAPTURE_LAUNCHED);
        }

        public void logCapturePhotoSnapped() {
            logEvent(BoxAnalyticsParams.EVENT_CAPTURE_PHOTO_SNAPPED);
        }
    }

    public static class FileActivitiesEventPropertyBuilder extends EventPropertyBuilder {
        private static final String FILE_ID = "file_id";

        public void logEditCommentCtaTriggered(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.EDIT_COMMENT_CTA_TRIGGERED);
        }

        public void logEditReplyCtaTriggered(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.EDIT_REPLY_CTA_TRIGGERED);
        }

        public void logDeleteCommentCtaTriggered(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.DELETE_COMMENT_CTA_TRIGGERED);
        }

        public void logDeleteReplyCtaTriggered(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.DELETE_REPLY_CTA_TRIGGERED);
        }

        public void logReplyCtaTriggered(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.REPLY_CTA_TRIGGERED);
        }

        public void logReplyCountCtaTriggered(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.REPLY_COUNT_CTA_TRIGGERED);
        }

        public void logPageNumberCtaTriggered(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.PAGE_NUMBER_CTA_TRIGGERED);
        }

        public void logSubmitCommentCtaTriggered(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.SUBMIT_COMMENT_CTA_TRIGGERED);
        }

        public void logSubmitReplyCtaTriggered(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.SUBMIT_REPLY_CTA_TRIGGERED);
        }

        public void logFileActivityCtaTriggered(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.FILE_ACTIVITY_CTA_TRIGGERED);
        }

        public void logSingleThreadViewOpened(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.SINGLE_THREAD_VIEW_OPENED);
        }

        public void logCommentResolved(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.COMMENT_RESOLVED);
        }

        public void logCommentUnresolved(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.COMMENT_UNRESOLVED);
        }

        public void logAnnotationReplyCtaTriggered(String str) {
            setProperty("file_id", str);
            logEvent(BoxAnalyticsParams.ANNOTATION_REPLY_CREATED);
        }
    }

    public static class JobEventPropertyBuilder extends EventPropertyBuilder {
        private static final String FAILURE_CAUSE = "failure_cause";
        public static final String JOB_FIELD_FILE_EXTENSION = "file_extension";
        public static final String JOB_FIELD_FILE_SIZE = "file_size";
        public static final String JOB_FIELD_FILE_TYPE = "file_type";
        private static final String JOB_SYSTEM = "job_system_version";
        private static final String JOB_SYSTEM_VAL = "v2";
        private static final String JOB_TYPE = "job_type";
        public static final String JOB_TYPE_AUTO_UPLOAD = "auto_upload";
        public static final String JOB_TYPE_COPY_JOB = "copy";
        public static final String JOB_TYPE_DELETE_JOB = "delete";
        public static final String JOB_TYPE_DOWNLOAD_JOB = "download";
        public static final String JOB_TYPE_MARK_OFFLINE_FOLDER_JOB = "mark_offline_folder";
        public static final String JOB_TYPE_MARK_OFFLINE_JOB = "mark_offline";
        public static final String JOB_TYPE_MOVE_JOB = "move";
        public static final String JOB_TYPE_UPLOAD_FOLDER_JOB = "upload_folder";
        public static final String JOB_TYPE_UPLOAD_JOB = "upload";
        private static final String LEGACY_JOB_MANAGER_VAL = "v1";

        JobEventPropertyBuilder(String str, boolean z) {
            setProperty(JOB_TYPE, str);
            setProperty(JOB_SYSTEM, z ? LEGACY_JOB_MANAGER_VAL : "v2");
        }

        public JobEventPropertyBuilder setAdditionalInfos(Map<String, Object> map) {
            if (map != null) {
                for (String str : map.keySet()) {
                    setProperty(str, map.get(str));
                }
            }
            return this;
        }

        public JobEventPropertyBuilder setSource(String str) {
            setProperty("source", str);
            return this;
        }

        public JobEventPropertyBuilder setAutoRetries(int i) {
            setProperty(EventPropertyBuilder.NUM_OF_AUTO_RETRIES, Integer.valueOf(i));
            return this;
        }

        public void logJobInitiated() {
            logEvent(String.format(BoxAnalyticsParams.EVENT_JOB_INITIATED_FORMAT, getPropertyAsString(JOB_TYPE)));
        }

        public void logJobStarted() {
            logEvent(String.format(BoxAnalyticsParams.EVENT_JOB_STARTED_FORMAT, getPropertyAsString(JOB_TYPE)));
        }

        public void logJobSuccess() {
            logEvent(String.format(BoxAnalyticsParams.EVENT_JOB_SUCCEEDED_FORMAT, getPropertyAsString(JOB_TYPE)));
        }

        public void logJobCancelled() {
            logEvent(String.format(BoxAnalyticsParams.EVENT_JOB_CANCELLED_FORMAT, getPropertyAsString(JOB_TYPE)));
        }

        public void logJobFailed(String str) {
            if (str != null) {
                setProperty(FAILURE_CAUSE, str);
            }
            logEvent(String.format(BoxAnalyticsParams.EVENT_JOB_FAILED_FORMAT, getPropertyAsString(JOB_TYPE)));
        }
    }

    public static class CaptureSettingsPropertyBuilder extends EventPropertyBuilder {
        private static final String PHOTO_QUALITY = "photo_quality";
        private static final String VIDEO_QUALITY = "video_quality";

        public void logVideoQuality(String str) {
            setProperty(VIDEO_QUALITY, str);
            logEvent(BoxAnalyticsParams.CAPTURE_SETTINGS_VIDEO_QUALITY_UPDATED);
        }

        public void logPhotoQuality(String str) {
            setProperty(PHOTO_QUALITY, str);
            logEvent(BoxAnalyticsParams.CAPTURE_SETTINGS_PHOTO_QUALITY_UPDATED);
        }
    }

    public static class FeatureBannerEventPropertyBuilder extends EventPropertyBuilder {
        private static final String BANNER_ID = "banner_id";
        private static final String FEATURE = "feature";

        public FeatureBannerEventPropertyBuilder setFeature(String str) {
            setProperty(FEATURE, str);
            return this;
        }

        public FeatureBannerEventPropertyBuilder setBannerId(int i) {
            setProperty(BANNER_ID, Integer.valueOf(i));
            return this;
        }
    }

    public static class SearchEventPropertyBuilder extends EventPropertyBuilder {
        public static final String SEARCH_ACTION_TYPE = "action_type";
        public static final String SEARCH_FILTER_TYPE = "filter_type";
        private static final String SEARCH_RESULT_POSITION_TAPPED = "position_tapped";
        private static final String SEARCH_RESULT_TYPE = "search_result_type";
        public static final String SEARCH_TIME_SPENT = "time_spent";

        public SearchEventPropertyBuilder setFilterType(String str) {
            setProperty(SEARCH_FILTER_TYPE, str);
            return this;
        }

        public SearchEventPropertyBuilder setSearchResultType(String str) {
            setProperty(SEARCH_RESULT_TYPE, str);
            return this;
        }

        public SearchEventPropertyBuilder setPositionTapped(int i) {
            setProperty(SEARCH_RESULT_POSITION_TAPPED, Integer.valueOf(i));
            return this;
        }

        public enum SearchAction {
            SEARCH_ACTION_TYPING,
            SEARCH_ACTION_RECENT,
            SEARCH_ACTION_SUGGESTION;

            @Override // java.lang.Enum
            public String toString() {
                int i = AnonymousClass2.$SwitchMap$com$box$android$domain$analytics$BoxAmplitudeAnalytics$SearchEventPropertyBuilder$SearchAction[ordinal()];
                if (i == 1) {
                    return "recent";
                }
                if (i == 2) {
                    return "suggestion";
                }
                return "typing";
            }
        }

        public void logTriggered() {
            logEvent(BoxAnalyticsParams.EVENT_SEARCH_CTA_TRIGGERED);
        }

        public void logAction(SearchAction searchAction) {
            setProperty("action_type", searchAction.toString());
            logEvent(BoxAnalyticsParams.EVENT_SEARCH_STARTED);
        }

        public void logTimeSpent(long j) {
            setProperty(SEARCH_TIME_SPENT, Long.valueOf(j));
            logEvent(BoxAnalyticsParams.EVENT_SEARCH_PAGE_RESULT_VIEWED);
        }

        public void logResultTapped(int i, String str) {
            setProperty(SEARCH_RESULT_TYPE, str);
            setProperty(SEARCH_RESULT_POSITION_TAPPED, Integer.valueOf(i));
            logEvent(BoxAnalyticsParams.EVENT_SEARCH_RESULT_TAPPED);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.analytics.BoxAmplitudeAnalytics$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$domain$analytics$BoxAmplitudeAnalytics$SearchEventPropertyBuilder$SearchAction;

        static {
            int[] iArr = new int[SearchEventPropertyBuilder.SearchAction.values().length];
            $SwitchMap$com$box$android$domain$analytics$BoxAmplitudeAnalytics$SearchEventPropertyBuilder$SearchAction = iArr;
            try {
                iArr[SearchEventPropertyBuilder.SearchAction.SEARCH_ACTION_RECENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$domain$analytics$BoxAmplitudeAnalytics$SearchEventPropertyBuilder$SearchAction[SearchEventPropertyBuilder.SearchAction.SEARCH_ACTION_SUGGESTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class NotifBlockedEventPropertyBuilder extends EventPropertyBuilder {
        private CharSequence notifCategory = "unknown";

        public NotifBlockedEventPropertyBuilder setNotifCategory(CharSequence charSequence) {
            this.notifCategory = charSequence;
            return this;
        }

        public void logEvent() {
            logEvent(String.format(BoxAnalyticsParams.EVENT_NOTIF_BLOCKED, this.notifCategory));
        }
    }

    public static class PushNotifEventPropertyBuilder extends EventPropertyBuilder {
        public static final String EVENT_PROPERTY_NOTIF_TYPE = "notification_type";
        public static final String NOTIF_TYPE_COMMENTS = "Comments";
        public static final String NOTIF_TYPE_RELEVANT_UPDATES = "Relevant Updates";
        public static final String NOTIF_TYPE_SHARING = "Sharing";
        public static final String NOTIF_TYPE_TASKS = "Tasks";

        PushNotifEventPropertyBuilder() {
        }

        public void logSettingToggled(String str, boolean z) {
            setProperty(EVENT_PROPERTY_NOTIF_TYPE, str);
            setProperty("toggle_value", z ? "enabled" : "disabled");
            logEvent(BoxAnalyticsParams.EVENT_PUSH_NOTIF_SETTING_TOGGLED);
        }

        public void logPushNotifDisplayed(BoxPushNotification.PushNotifType pushNotifType) {
            logPushNotifDisplayed(getNotifCategory(pushNotifType));
        }

        public void logNotificationDeeplinkLaunched(Uri uri) {
            if (uri == null || uri.getQueryParameterNames() == null) {
                return;
            }
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames.containsAll(Arrays.asList("channel", "box_source"))) {
                HashMap map = new HashMap();
                for (String str : queryParameterNames) {
                    map.put(str, uri.getQueryParameter(str));
                }
                logNotificationDeeplinkLaunched(map);
            }
        }

        private static String getNotifCategory(BoxPushNotification.PushNotifType pushNotifType) {
            if (pushNotifType == BoxPushNotification.PushNotifType.COMMENT_CREATE) {
                return NOTIF_TYPE_COMMENTS;
            }
            if (pushNotifType == BoxPushNotification.PushNotifType.COLLAB_INVITE_COLLABORATOR) {
                return NOTIF_TYPE_SHARING;
            }
            return NOTIF_TYPE_RELEVANT_UPDATES;
        }

        public void logPushNotifDisplayed(String str) {
            setProperty(EVENT_PROPERTY_NOTIF_TYPE, str);
            logEvent(BoxAnalyticsParams.EVENT_PUSH_NOTIF_DISPLAYED);
        }

        public void logNotificationDeeplinkLaunched(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                setProperty(entry.getKey(), entry.getValue());
            }
            logEvent(BoxAnalyticsParams.EVENT_NOTIF_DEEPLINK_LAUNCHED);
        }

        public static synchronized void setNotificationTypeForSession(BoxPushNotification.PushNotifType pushNotifType) {
            BoxAmplitudeAnalytics.getInstance().setSessionProperty(EVENT_PROPERTY_NOTIF_TYPE, getNotifCategory(pushNotifType));
        }
    }

    public static class ShareEventPropertyBuilder extends EventPropertyBuilder {
        private static final String ACCESS_TYPE = "accessType";

        ShareEventPropertyBuilder() {
            setFlow(BoxAnalyticsParams.FLOW_SHARE);
        }

        public ShareEventPropertyBuilder setAccessTypeUpdate(BoxCollaboration.Role role, BoxCollaboration.Role role2) {
            setProperty("OldAccessType", role.toString());
            setProperty("NewAccessType", role2.toString());
            return this;
        }

        public ShareEventPropertyBuilder setAccessType(BoxCollaboration.Role role) {
            setProperty(ACCESS_TYPE, role.toString());
            return this;
        }
    }

    public static class TaskEventPropertyBuilder extends EventPropertyBuilder {
        private static final String TASK_CREATOR_ID = "creatorUserId";
        private static final String TASK_ID = "taskId";
        private static final String TASK_TOTAL = "totalTasks";
        private static final String TASK_TOTAL_ASSIGNEES = "totalTaskAssignees";
        private static final String TASK_TOTAL_DAYS = "totalDays";
        private static final String TASK_TYPE = "taskType";
        private static final String VIEW_SOURCE = "viewSource";

        public TaskEventPropertyBuilder setTask(BoxTask boxTask) {
            long jConvert = TimeUnit.DAYS.convert(Math.abs(System.currentTimeMillis() - boxTask.getCreatedAt().getTime()), TimeUnit.MILLISECONDS);
            setProperty(TASK_ID, boxTask.getUserId());
            setProperty("taskType", boxTask.getType());
            setProperty(TASK_CREATOR_ID, boxTask.getCreatedByCollaborator().getUserId());
            setProperty(TASK_TOTAL_DAYS, Long.valueOf(jConvert));
            setProperty(TASK_TOTAL_ASSIGNEES, Integer.valueOf(boxTask.getAssignmentCollaborators().getEntries().size()));
            return this;
        }

        public TaskEventPropertyBuilder setTotalTasks(int i) {
            setProperty(TASK_TOTAL, Integer.valueOf(i));
            return this;
        }

        public TaskEventPropertyBuilder setViewSource(String str) {
            setProperty("viewSource", str);
            return this;
        }
    }

    public static class BackgroundEventPropertyBuilder extends EventPropertyBuilder {
        @Override // com.box.android.domain.analytics.BoxAmplitudeAnalytics.EventPropertyBuilder
        public void logEvent(String str) {
            if (this.mAmplitudeEnabled) {
                this.mBoxAmplitudeAnalytics.appendSessionPropertiesToEvent(this);
                this.mProperties.remove(BoxAnalyticsParams.SESSION_PAGE_NAME);
                this.mProperties.remove(BoxAnalyticsParams.SESSION_PREVIOUS_PAGE_NAME);
                this.mBuilderClient.logEvent(str, this.mProperties);
                PendoAnalytics.INSTANCE.trackEvent(str, this.mProperties);
                BoxLogUtils.i(BoxAmplitudeAnalytics.TAG, str);
                BoxLogUtils.i(BoxAmplitudeAnalytics.TAG, this.mProperties.toString());
            }
        }

        public EventPropertyBuilder setError(Exception exc) {
            if (exc instanceof BoxException) {
                BoxException boxException = (BoxException) exc;
                String string = boxException.getErrorType().toString();
                String message = boxException.getMessage();
                String strValueOf = String.valueOf(boxException.getResponseCode());
                BoxError asBoxError = boxException.getAsBoxError();
                if (asBoxError != null) {
                    string = asBoxError.getCode();
                    if (asBoxError.getStatus() != null) {
                        strValueOf = asBoxError.getStatus().toString();
                    }
                    setErrorOrigin(BoxAnalyticsParams.ERROR_ORIGIN_SERVER);
                }
                super.setError(string, message, strValueOf);
                return this;
            }
            super.setError(exc.getClass().getSimpleName(), exc.getMessage(), "");
            return this;
        }
    }

    public static class BoxAiEventPropertyBuilder extends EventPropertyBuilder {
        private static final String AGENT_ID = "agent_id";
        private static final String FILE_EXTENSIONS = "file_extensions";
        private static final String FILE_IDS = "file_ids";
        private static final String FILE_TYPES = "file_types";
        private static final String IS_MULTIDOC = "is_multidoc";

        public BoxAiEventPropertyBuilder setFileIds(String str) {
            setProperty(FILE_IDS, str);
            return this;
        }

        public BoxAiEventPropertyBuilder setFileExtensions(String str) {
            setProperty(FILE_EXTENSIONS, str);
            return this;
        }

        public BoxAiEventPropertyBuilder setFileTypes(String str) {
            setProperty(FILE_TYPES, str);
            return this;
        }

        public BoxAiEventPropertyBuilder setIsMultidoc(boolean z) {
            setProperty(IS_MULTIDOC, Boolean.valueOf(z));
            return this;
        }

        public BoxAiEventPropertyBuilder setAgentId(String str) {
            setProperty(AGENT_ID, str);
            return this;
        }
    }

    public static class MfaSetupEventPropertyBuilder extends EventPropertyBuilder {
        private static final String MOBILE_SESSION_ID = "mobile_session_id";

        public MfaSetupEventPropertyBuilder setMobileSessionId(String str) {
            if (str != null) {
                setProperty(MOBILE_SESSION_ID, str);
            }
            return this;
        }
    }

    public static class ForceUpdateEventPropertyBuilder extends EventPropertyBuilder {
        private static final String BLOCK_REASON = "block_reason";

        public ForceUpdateEventPropertyBuilder setBlockReason(String str) {
            setProperty(BLOCK_REASON, str);
            return this;
        }
    }

    public static class UserPropertyBuilder extends AmplitudeBuilder {
        private static final String ACCOUNT_CREATED_DATE = "account_created_date";
        private static final String ENTERPRISE_ID = "enterprise_id";
        private static final String MOBILE_USER_PAID_STATUS = "mobile_user_paid_status";

        public UserPropertyBuilder setUser(BoxUser boxUser) {
            if (this.mAmplitudeEnabled) {
                this.mBuilderClient.setUserId(boxUser.getUserId());
                if (boxUser.getEnterprise() != null) {
                    setProperty(ENTERPRISE_ID, boxUser.getEnterprise().getUserId());
                }
                if (boxUser.getUserCreatedAt() != null) {
                    setProperty(ACCOUNT_CREATED_DATE, boxUser.getPropertyValue("created_at").asString());
                }
            }
            return this;
        }

        public UserPropertyBuilder setUserId(String str) {
            if (this.mAmplitudeEnabled) {
                this.mBuilderClient.setUserId(str);
            }
            return this;
        }

        public UserPropertyBuilder setUserType(String str) {
            setProperty(MOBILE_USER_PAID_STATUS, str);
            return this;
        }

        public void updateUserProperties() {
            if (this.mAmplitudeEnabled) {
                this.mBuilderClient.setUserProperties(this.mProperties);
            }
        }
    }

    public static class ApplicationPropertyBuilder extends AmplitudeBuilder {
        private static final String APP_PROPERTIES = "amplitude_app_properties";
        private static final String CLIENT = "client";
        private static final String PROPERTY_INSTALLATION_REFERRER = "mobile_app_installation_referrer";
        private static final String PROPERTY_INSTALLATION_REFERRER_TRACKING_CODE = "mobile_app_installation_tracking_code";
        private static final String VALUE_DEFAULT_SOFTWARE_CLIENT = "mobile app";
        private final SharedPreferences mGlobalSharedPreferences;

        public ApplicationPropertyBuilder(SharedPreferences sharedPreferences, String str) {
            this.mGlobalSharedPreferences = sharedPreferences;
            loadAppProperties();
            try {
                this.mProperties.put(PROPERTY_INSTALLATION_REFERRER, str);
                this.mProperties.put(CLIENT, VALUE_DEFAULT_SOFTWARE_CLIENT);
            } catch (JSONException e) {
                BoxLogUtils.logException(BoxAmplitudeAnalytics.TAG, "Could not instantiate app builder", e);
            }
        }

        public ApplicationPropertyBuilder setInstallationReferrerTrackingCode(Uri uri) {
            if (uri != null) {
                try {
                    this.mProperties.put(PROPERTY_INSTALLATION_REFERRER_TRACKING_CODE, BoxAmplitudeAnalytics.getReferrerTrackingArray(uri));
                    return this;
                } catch (JSONException e) {
                    BoxLogUtils.logException(BoxAmplitudeAnalytics.TAG, "Could not set installation referrer tracking code", e);
                }
            }
            return this;
        }

        public void update() {
            if (this.mAmplitudeEnabled) {
                Iterator<String> itKeys = this.mProperties.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        this.mBoxAmplitudeAnalytics.setSessionProperty(next, this.mProperties.get(next));
                    } catch (JSONException e) {
                        BoxLogUtils.logException(BoxAmplitudeAnalytics.TAG, "Could not load app property with key:" + next, e);
                    }
                }
                this.mGlobalSharedPreferences.edit().putString(APP_PROPERTIES, this.mProperties.toString()).apply();
            }
        }

        private void loadAppProperties() {
            this.mProperties = BoxAmplitudeAnalytics.getJsonForString(this.mGlobalSharedPreferences.getString(APP_PROPERTIES, null));
        }
    }
}
