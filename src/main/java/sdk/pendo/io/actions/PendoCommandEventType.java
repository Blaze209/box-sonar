package sdk.pendo.io.actions;

import com.facebook.infer.annotation.ThreadConfined;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import sdk.pendo.io.a0.g;
import sdk.pendo.io.a0.h;
import sdk.pendo.io.a0.i;

/* JADX INFO: loaded from: classes4.dex */
public class PendoCommandEventType {
    public final String eventType;
    public static final PendoCommandEventType PENDO_COMMAND_EVENT_TYPE_ANY = new PendoCommandEventType(ThreadConfined.ANY);
    public static final PendoCommandEventType PENDO_ANALYTICS_EVENT = new PendoCommandEventType("insertAnalyticsEvent");
    private static HashMap<String, PendoCommandEventType> sEventTypeMap = new HashMap<>();

    public static final class AnalyticsEventType extends PendoCommandEventType {
        private static final List<PendoCommandEventType> ANALYTICS_EVENT_TYPES;
        public static final AnalyticsEventType GUIDE_DISMISSED_BACK_BUTTON;
        public static final AnalyticsEventType GUIDE_DISMISSED_STATE_CHANGED;
        public static final AnalyticsEventType GUIDE_DISMISSED_TIMEOUT;
        public static final AnalyticsEventType GUIDE_DISMISSED_USER_ACTION;
        public static final AnalyticsEventType GUIDE_DISPLAYED;
        public static final AnalyticsEventType GUIDE_NOT_DISPLAYED_CONTENT_ERROR;
        public static final AnalyticsEventType GUIDE_NOT_DISPLAYED_CONTENT_NOT_READY;
        public static final AnalyticsEventType GUIDE_NOT_DISPLAYED_CONTROL_GROUP;
        public static final AnalyticsEventType GUIDE_NOT_DISPLAYED_ERROR;
        public static final AnalyticsEventType GUIDE_NOT_DISPLAYED_IMAGE_ERROR;
        public static final AnalyticsEventType GUIDE_NOT_DISPLAYED_NO_CONNECTIVITY;
        public static final AnalyticsEventType GUIDE_NOT_DISPLAYED_OUT_OF_CAPPING;
        public static final AnalyticsEventType GUIDE_NOT_SEEN;
        public static final AnalyticsEventType GUIDE_RECEIVED;

        static {
            AnalyticsEventType analyticsEventType = new AnalyticsEventType("onGuideDisplayed");
            GUIDE_DISPLAYED = analyticsEventType;
            AnalyticsEventType analyticsEventType2 = new AnalyticsEventType("onGuideReceived");
            GUIDE_RECEIVED = analyticsEventType2;
            AnalyticsEventType analyticsEventType3 = new AnalyticsEventType("onGuideNotDisplayedCapping");
            GUIDE_NOT_DISPLAYED_OUT_OF_CAPPING = analyticsEventType3;
            AnalyticsEventType analyticsEventType4 = new AnalyticsEventType("onGuideNotDisplayedNoConnectivity");
            GUIDE_NOT_DISPLAYED_NO_CONNECTIVITY = analyticsEventType4;
            GUIDE_NOT_DISPLAYED_CONTROL_GROUP = new AnalyticsEventType("onGuideNotDisplayedControlGroup");
            AnalyticsEventType analyticsEventType5 = new AnalyticsEventType("guideNotDisplayedErrorEvent");
            GUIDE_NOT_DISPLAYED_ERROR = analyticsEventType5;
            AnalyticsEventType analyticsEventType6 = new AnalyticsEventType("onGuideDismissedTimeout");
            GUIDE_DISMISSED_TIMEOUT = analyticsEventType6;
            AnalyticsEventType analyticsEventType7 = new AnalyticsEventType("onGuideDismissedStateChanged");
            GUIDE_DISMISSED_STATE_CHANGED = analyticsEventType7;
            AnalyticsEventType analyticsEventType8 = new AnalyticsEventType("onGuideDismissedBackButton");
            GUIDE_DISMISSED_BACK_BUTTON = analyticsEventType8;
            AnalyticsEventType analyticsEventType9 = new AnalyticsEventType("onGuideDismissedUserAction");
            GUIDE_DISMISSED_USER_ACTION = analyticsEventType9;
            AnalyticsEventType analyticsEventType10 = new AnalyticsEventType("guideNotSeen");
            GUIDE_NOT_SEEN = analyticsEventType10;
            GUIDE_NOT_DISPLAYED_CONTENT_NOT_READY = new AnalyticsEventType("onGuideNotDisplayedContentNotReady");
            GUIDE_NOT_DISPLAYED_IMAGE_ERROR = new AnalyticsEventType("onGuideNotDisplayedImageDownloadError");
            GUIDE_NOT_DISPLAYED_CONTENT_ERROR = new AnalyticsEventType("onGuideNotDisplayedContentDownloadError");
            ArrayList arrayList = new ArrayList();
            ANALYTICS_EVENT_TYPES = arrayList;
            arrayList.add(analyticsEventType);
            arrayList.add(analyticsEventType2);
            arrayList.add(analyticsEventType3);
            arrayList.add(analyticsEventType4);
            arrayList.add(analyticsEventType5);
            arrayList.add(analyticsEventType6);
            arrayList.add(analyticsEventType7);
            arrayList.add(analyticsEventType8);
            arrayList.add(analyticsEventType9);
            arrayList.add(analyticsEventType10);
        }

        private AnalyticsEventType(String str) {
            super(str);
        }

        public static List<PendoCommandEventType> getAnalyticsEventTypes() {
            return Collections.unmodifiableList(ANALYTICS_EVENT_TYPES);
        }
    }

    public static final class AppEventType extends PendoCommandEventType {
        public static final AppEventType APP_IN_BACKGROUND = new AppEventType("onAppInBackground");
        public static final AppEventType APP_IN_FOREGROUND = new AppEventType("onAppInForeground");
        public static final AppEventType APP_SESSION_START = new AppEventType("onAppSessionStart");
        public static final AppEventType APP_SESSION_END = new AppEventType("onAppSessionEnd");

        private AppEventType(String str) {
            super(str);
        }
    }

    public static final class FormEventType extends PendoCommandEventType {
        public static final FormEventType ON_SUBMIT = new FormEventType("onSubmit");
        public static final FormEventType ON_VALID = new FormEventType("onValid");
        public static final FormEventType ON_INVALID = new FormEventType("onInvalid");
        public static final FormEventType ON_SELECTION_CHANGED = new FormEventType("onSelectionChanged");

        private FormEventType(String str) {
            super(str);
        }
    }

    public static final class PagerEventType extends PendoCommandEventType {
        public static final PagerEventType ON_CHANGE_PAGE = new PagerEventType("onChangePage");
        public static final PagerEventType ON_FIRST_PAGE = new PagerEventType("onFirstPage");
        public static final PagerEventType ON_LAST_PAGE = new PagerEventType("onLastPage");
        public static final PagerEventType ON_INNER_PAGE = new PagerEventType("onInnerPage");

        private PagerEventType(String str) {
            super(str);
        }
    }

    public static final class PagerPageEventType extends PendoCommandEventType {
        public static final PagerPageEventType ON_APPEAR = new PagerPageEventType("onAppear");
        public static final PagerPageEventType ON_DISAPPEAR = new PagerPageEventType("onDisappear");

        private PagerPageEventType(String str) {
            super(str);
        }
    }

    public static class PendoCommandEventTypeDeserializer implements h<PendoCommandEventType> {
        @Override // sdk.pendo.io.a0.h
        public PendoCommandEventType deserialize(i iVar, Type type, g gVar) {
            return PendoCommandEventType.getEventType(iVar.g());
        }
    }

    public static final class PendoPreparationEventType extends PendoCommandEventType {
        public static final PendoPreparationEventType PREFETCH_IMAGES_END = new PendoPreparationEventType("prefetchImagesEnd");

        private PendoPreparationEventType(String str) {
            super(str);
        }
    }

    public static final class SdkEventType extends PendoCommandEventType {
        public static final SdkEventType GUIDE_DISMISSED = new SdkEventType(PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.GUIDE_DISMISSED);
        public static final SdkEventType TIME_OUT = new SdkEventType("timeOut");
        public static final SdkEventType ANIMATION_DONE = new SdkEventType("animationDone");
        public static final SdkEventType HOST_APP_DEVELOPER_CALL = new SdkEventType("hostAppDeveloperCall");
        public static final SdkEventType TRIGGER_OCCURRED = new SdkEventType("triggerOccurred");

        private SdkEventType(String str) {
            super(str);
        }
    }

    public static final class TextFieldEventType extends PendoCommandEventType {
        public static final TextFieldEventType ON_TEXT_CHANGED = new TextFieldEventType("onTextChanged");

        private TextFieldEventType(String str) {
            super(str);
        }
    }

    public static final class UserEventType extends PendoCommandEventType {
        public static final UserEventType TAP_ON = new UserEventType("click");
        public static final UserEventType SWIPE_LEFT = new UserEventType("swipeLeft");
        public static final UserEventType SWIPE_RIGHT = new UserEventType("swipeRight");
        public static final UserEventType PINCH_IN = new UserEventType("pinchIn");
        public static final UserEventType PINCH_OUT = new UserEventType("pinchOut");

        private UserEventType(String str) {
            super(str);
        }
    }

    public static final class VideoEventType extends PendoCommandEventType {
        public static final VideoEventType ON_START = new VideoEventType("onStart");
        public static final VideoEventType ON_STOP = new VideoEventType("onStop");
        public static final VideoEventType ON_COMPLETE = new VideoEventType("onComplete");
        public static final VideoEventType ON_PAUSE = new VideoEventType("onPause");

        private VideoEventType(String str) {
            super(str);
        }
    }

    private PendoCommandEventType(String str) {
        this.eventType = str;
    }

    private static void generateEventTypeMap() {
        Class[] clsArr = {SdkEventType.class, PendoPreparationEventType.class, UserEventType.class, FormEventType.class, TextFieldEventType.class, PagerEventType.class, PagerPageEventType.class, VideoEventType.class, AnalyticsEventType.class, AppEventType.class};
        for (int i = 0; i < 10; i++) {
            Class cls = clsArr[i];
            for (Field field : cls.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                    try {
                        PendoCommandEventType pendoCommandEventType = (PendoCommandEventType) field.get(cls);
                        sEventTypeMap.put(pendoCommandEventType.eventType, pendoCommandEventType);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public static synchronized PendoCommandEventType getEventType(String str) {
        if (sEventTypeMap.isEmpty()) {
            generateEventTypeMap();
        }
        return sEventTypeMap.get(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PendoCommandEventType)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return this.eventType.equals(((PendoCommandEventType) obj).eventType);
    }

    public int hashCode() {
        return this.eventType.hashCode();
    }

    public String toString() {
        return "Event type = {" + this.eventType + "}";
    }
}
