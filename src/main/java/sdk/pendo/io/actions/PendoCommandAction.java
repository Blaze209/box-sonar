package sdk.pendo.io.actions;

import com.facebook.infer.annotation.ThreadConfined;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import sdk.pendo.io.a0.g;
import sdk.pendo.io.a0.h;
import sdk.pendo.io.a0.i;

/* JADX INFO: loaded from: classes4.dex */
public class PendoCommandAction {
    public static final PendoCommandAction PENDO_COMMAND_ACTION_ANY = new PendoCommandAction(ThreadConfined.ANY);
    private static HashMap<String, PendoCommandAction> sActionMap = new HashMap<>();
    public final String action;

    public static class PendoCommandActionDeserializer implements h<PendoCommandAction> {
        @Override // sdk.pendo.io.a0.h
        public PendoCommandAction deserialize(i iVar, Type type, g gVar) {
            return PendoCommandAction.getAction(iVar.g());
        }
    }

    public static final class PendoCommandButtonAction extends PendoCommandTextAction {
        private PendoCommandButtonAction(String str) {
            super(str);
        }
    }

    public static final class PendoCommandFormAction extends PendoCommandAction {
        public static final PendoCommandFormAction SUBMIT = new PendoCommandFormAction("submit");
        public static final PendoCommandFormAction UPDATE = new PendoCommandFormAction("update");
        public static final PendoCommandFormAction SET_VALUE_FOR_KEY = new PendoCommandFormAction("setValueForKey");

        private PendoCommandFormAction(String str) {
            super(str);
        }
    }

    public static final class PendoCommandGlobalAction extends PendoCommandAction {
        public static final String NEXT_GUIDE_ID = "nextGuideId";
        public static final PendoCommandGlobalAction DISMISS_GUIDE = new PendoCommandGlobalAction("dismissGuide");
        public static final PendoCommandGlobalAction ADVANCE_GUIDE = new PendoCommandGlobalAction("nextStep");
        public static final PendoCommandGlobalAction LAUNCH_GUIDE = new PendoCommandGlobalAction("launchGuide");
        public static final PendoCommandGlobalAction CHANGE_SCREEN = new PendoCommandGlobalAction("changeScreen");
        public static final PendoCommandGlobalAction OPEN_URL = new PendoCommandGlobalAction("openLink");
        public static final PendoCommandGlobalAction SHOW_ALERT = new PendoCommandGlobalAction("showAlert");
        public static final PendoCommandGlobalAction SEND_ANALYTICS = new PendoCommandGlobalAction("sendAnalytics");
        public static final PendoCommandGlobalAction SEND_APP_SPECIFIC_ANALYTICS = new PendoCommandGlobalAction("sendAppSpecificAnalytics");
        public static final PendoCommandGlobalAction SEND_APP_GENERIC_ANALYTICS = new PendoCommandGlobalAction("sendAppGenericAnalytics");
        public static final PendoCommandGlobalAction SEND_GUIDE_GENERIC_ANALYTICS = new PendoCommandGlobalAction("sendGuideGenericAnalytics");
        public static final PendoCommandGlobalAction SEND_GUIDE_PARAMETERIZED_GENERIC_ANALYTICS = new PendoCommandGlobalAction("sendGuideParameterizedGenericAnalytics");
        public static final PendoCommandGlobalAction SEND_CUSTOM_ANALYTICS = new PendoCommandGlobalAction("customAnalyticsAction");
        public static final PendoCommandGlobalAction NOTIFY_CLOSE = new PendoCommandGlobalAction("notifyClose");
        public static final PendoCommandGlobalAction IN_ANIMATION_DONE = new PendoCommandGlobalAction("inAnimationDone");
        public static final PendoCommandGlobalAction OUT_ANIMATION_DONE = new PendoCommandGlobalAction("outAnimationDone");
        public static final PendoCommandGlobalAction OPEN_IN_APP_RATING = new PendoCommandGlobalAction("openRatingDialog");

        public static final class PendoInfoConsts {
            public static final String EXTERNAL_ENDPOINT_URL = "endpointURL";
            public static final String GUIDE_ID = "guideId";

            public static PendoCommandsEventBus.Parameter createPendoMetadataParam(String str) {
                return new PendoCommandsEventBus.Parameter("guideId", "string", str);
            }

            public static List<PendoCommandsEventBus.Parameter> createPendoMetadataParams(String str) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(new PendoCommandsEventBus.Parameter("guideId", "string", str));
                return linkedList;
            }
        }

        public static final class SendPendoGenericAnalyticsConsts {
            public static final String ANALYTICS_TYPE = "analyticsType";
            public static final String DISMISSED_BY = "dismissBy";
            public static final String DISMISSED_REASON = "dismiss_reason";
            public static final String GUIDE_DISMISSED = "guideDismissed";

            public static List<PendoCommandsEventBus.Parameter> createPendoDismissedAnalyticsParams(String str) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(new PendoCommandsEventBus.Parameter(ANALYTICS_TYPE, "string", GUIDE_DISMISSED));
                linkedList.add(new PendoCommandsEventBus.Parameter(DISMISSED_BY, "string", str));
                return linkedList;
            }
        }

        private PendoCommandGlobalAction(String str) {
            super(str);
        }
    }

    public static final class PendoCommandPageAction extends PendoCommandAction {
        public static final PendoCommandPageAction VALIDATE = new PendoCommandPageAction("validate");

        private PendoCommandPageAction(String str) {
            super(str);
        }
    }

    public static final class PendoCommandPagerAction extends PendoCommandAction {
        public static final PendoCommandPagerAction CHANGE_PAGE = new PendoCommandPagerAction("changePage");
        public static final PendoCommandPagerAction NEXT_PAGE = new PendoCommandPagerAction("nextPage");
        public static final PendoCommandPagerAction PREVIOUS_PAGE = new PendoCommandPagerAction("previousPage");

        private PendoCommandPagerAction(String str) {
            super(str);
        }
    }

    public static final class PendoCommandRadioButtonAction extends PendoCommandAction {
        public static final PendoCommandRadioButtonAction SELECT = new PendoCommandRadioButtonAction("select");

        private PendoCommandRadioButtonAction(String str) {
            super(str);
        }
    }

    public static final class PendoCommandRadioGroupAction extends PendoCommandAction {
        public static final PendoCommandRadioGroupAction SELECT_RADIO_BUTTON = new PendoCommandRadioGroupAction("selectRadioButton");

        private PendoCommandRadioGroupAction(String str) {
            super(str);
        }
    }

    public static final class PendoCommandRunnableAction extends PendoCommandAction {
        public static final PendoCommandRunnableAction RUN_JAVA_SCRIPT = new PendoCommandRunnableAction("evaluate");

        private PendoCommandRunnableAction(String str) {
            super(str);
        }
    }

    public static class PendoCommandTextAction extends PendoCommandAction {
        public static final PendoCommandTextAction SET_TEXT = new PendoCommandTextAction("setText");

        private PendoCommandTextAction(String str) {
            super(str);
        }
    }

    public static final class PendoCommandVideoAction extends PendoCommandAction {
        public static final PendoCommandVideoAction PLAY = new PendoCommandVideoAction("play");
        public static final PendoCommandVideoAction STOP = new PendoCommandVideoAction("stop");
        public static final PendoCommandVideoAction REWIND = new PendoCommandVideoAction("rewind");
        public static final PendoCommandVideoAction SEEK = new PendoCommandVideoAction("seek");
        public static final PendoCommandVideoAction PAUSE = new PendoCommandVideoAction("pause");

        private PendoCommandVideoAction(String str) {
            super(str);
        }
    }

    public static final class PendoCommandViewGeneralAction extends PendoCommandAction {
        public static final PendoCommandViewGeneralAction ENABLE = new PendoCommandViewGeneralAction("enable");
        public static final PendoCommandViewGeneralAction ENABLE_ACTION = new PendoCommandViewGeneralAction("enableAction");
        public static final PendoCommandViewGeneralAction SET_BACKGROUND_COLOR = new PendoCommandViewGeneralAction("setBackgroundColor");
        public static final PendoCommandViewGeneralAction SET_VISIBILITY = new PendoCommandViewGeneralAction("setVisibility");

        private PendoCommandViewGeneralAction(String str) {
            super(str);
        }
    }

    public static final class PendoInternalAction extends PendoCommandAction {
        public static final PendoInternalAction PREFETCH_IMAGES = new PendoInternalAction("prefetchImages");
        public static final PendoInternalAction IMAGES_SET = new PendoInternalAction("imagesSet");

        private PendoInternalAction(String str) {
            super(str);
        }
    }

    private PendoCommandAction(String str) {
        this.action = str;
    }

    private static void generateActionMap() {
        Class[] clsArr = {PendoInternalAction.class, PendoCommandViewGeneralAction.class, PendoCommandFormAction.class, PendoCommandRadioButtonAction.class, PendoCommandRadioGroupAction.class, PendoCommandTextAction.class, PendoCommandButtonAction.class, PendoCommandVideoAction.class, PendoCommandPagerAction.class, PendoCommandPageAction.class, PendoCommandGlobalAction.class, PendoCommandRunnableAction.class};
        for (int i = 0; i < 12; i++) {
            Class cls = clsArr[i];
            for (Field field : cls.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                    try {
                        PendoCommandAction pendoCommandAction = (PendoCommandAction) field.get(cls);
                        sActionMap.put(pendoCommandAction.action, pendoCommandAction);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public static synchronized PendoCommandAction getAction(String str) {
        if (sActionMap.isEmpty()) {
            generateActionMap();
        }
        return sActionMap.get(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PendoCommandAction)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return this.action.equals(((PendoCommandAction) obj).action);
    }

    public int hashCode() {
        return this.action.hashCode();
    }

    public String toString() {
        return "Action = {" + this.action + "}";
    }
}
