package sdk.pendo.io.actions.handlers;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.j4.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.models.StepSeen;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.q3.j;
import sdk.pendo.io.r5.i;
import sdk.pendo.io.r5.m;
import sdk.pendo.io.s7.c;
import sdk.pendo.io.s7.d;
import sdk.pendo.io.s7.q;
import sdk.pendo.io.s7.s0;
import sdk.pendo.io.s7.y0;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: loaded from: classes4.dex */
public final class PendoGlobalCommandHandler {
    private static final String API = "api";
    public static final int DEFAULT_EVENT_ID = -1;
    public static final j<PendoCommand> DISMISS_PENDO_FILTER;
    private static final j<PendoCommand> INSERT_ANALYTICS_EVENT_FILTER;
    private static volatile PendoGlobalCommandHandler INSTANCE = null;
    private static final String NUMBER_PARAMETER_TYPE = "number";
    public static final j<PendoCommand> OPEN_RATING_DIALOG_FILTER;
    private static final j<PendoCommand> OPEN_URL_FILTER;
    public static final String PENDO_GLOBAL_COMMAND_DEST = "Global";
    private static final String PROPS_JSON_KEY = "props";
    private static final String PROPS_PREFIX = "props.";
    private static final j<PendoCommand> RUN_SCRIPT_FILTER;
    private static final String SEEN_REASON = "seen_reason";
    private static final j<PendoCommand> SEND_APP_GENERIC_ANALYTICS_FILTER;
    private static final j<PendoCommand> SEND_APP_SPECIFIC_ANALYTICS_FILTER;
    public static final j<PendoCommand> SEND_CUSTOM_ANALYTICS_FILTER;
    private static final j<PendoCommand> SEND_GUIDE_GENERIC_ANALYTICS_FILTER;
    public static final j<PendoCommand> SEND_GUIDE_PARAMETRIZED_GENERIC_ANALYTICS_FILTER;
    public static final int SHORT_DURATION_TOAST = 2;
    private static final j<PendoCommand> SHOW_ALERT_FILTER;
    private final e<PendoCommand> sendParameterizedAnalyticsAction = new e() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda4
        @Override // sdk.pendo.io.q3.e
        public final void accept(Object obj) throws JSONException {
            this.f$0.m16685xc9eb1588((PendoCommand) obj);
        }
    };
    private final b<PendoCommand> mLaunchGuideCommandPublisher = b.m();
    private final b<PendoCommand> mDismissGuideCommandPublisher = b.m();
    private final b<PendoCommand> mAdvanceGuideCommandPublisher = b.m();

    static {
        PendoCommandAction.PendoCommandGlobalAction pendoCommandGlobalAction = PendoCommandAction.PendoCommandGlobalAction.OPEN_URL;
        PendoCommandEventType pendoCommandEventType = PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY;
        PendoCommand.PendoCommandScope pendoCommandScope = PendoCommand.PendoCommandScope.PENDO_COMMAND_SCOPE_ANY;
        OPEN_URL_FILTER = PendoCommand.createFilter("any", PENDO_GLOBAL_COMMAND_DEST, pendoCommandGlobalAction, pendoCommandEventType, pendoCommandScope);
        SHOW_ALERT_FILTER = PendoCommand.createFilter("any", PENDO_GLOBAL_COMMAND_DEST, PendoCommandAction.PendoCommandGlobalAction.SHOW_ALERT, pendoCommandEventType, pendoCommandScope);
        DISMISS_PENDO_FILTER = PendoCommand.createFilter("any", PENDO_GLOBAL_COMMAND_DEST, PendoCommandAction.PendoCommandGlobalAction.DISMISS_GUIDE, pendoCommandEventType, pendoCommandScope);
        SEND_APP_GENERIC_ANALYTICS_FILTER = PendoCommand.createFilter("any", PENDO_GLOBAL_COMMAND_DEST, PendoCommandAction.PendoCommandGlobalAction.SEND_APP_GENERIC_ANALYTICS, pendoCommandEventType, pendoCommandScope);
        SEND_APP_SPECIFIC_ANALYTICS_FILTER = PendoCommand.createFilter("any", PENDO_GLOBAL_COMMAND_DEST, PendoCommandAction.PendoCommandGlobalAction.SEND_APP_SPECIFIC_ANALYTICS, pendoCommandEventType, pendoCommandScope);
        INSERT_ANALYTICS_EVENT_FILTER = PendoCommand.createFilter("any", PENDO_GLOBAL_COMMAND_DEST, PendoCommandAction.PendoCommandGlobalAction.SEND_ANALYTICS, PendoCommandEventType.PENDO_ANALYTICS_EVENT, pendoCommandScope);
        SEND_GUIDE_GENERIC_ANALYTICS_FILTER = PendoCommand.createFilter("any", PENDO_GLOBAL_COMMAND_DEST, PendoCommandAction.PendoCommandGlobalAction.SEND_GUIDE_GENERIC_ANALYTICS, pendoCommandEventType, pendoCommandScope);
        SEND_GUIDE_PARAMETRIZED_GENERIC_ANALYTICS_FILTER = PendoCommand.createFilter("any", PENDO_GLOBAL_COMMAND_DEST, PendoCommandAction.PendoCommandGlobalAction.SEND_GUIDE_PARAMETERIZED_GENERIC_ANALYTICS, pendoCommandEventType, pendoCommandScope);
        SEND_CUSTOM_ANALYTICS_FILTER = PendoCommand.createFilter("any", PENDO_GLOBAL_COMMAND_DEST, PendoCommandAction.PendoCommandGlobalAction.SEND_CUSTOM_ANALYTICS, pendoCommandEventType, pendoCommandScope);
        OPEN_RATING_DIALOG_FILTER = PendoCommand.createFilter("any", PENDO_GLOBAL_COMMAND_DEST, PendoCommandAction.PendoCommandGlobalAction.OPEN_IN_APP_RATING, pendoCommandEventType, pendoCommandScope);
        RUN_SCRIPT_FILTER = PendoCommand.createFilter("any", JavascriptRunner.JAVA_SCRIPT_RUNNER_DESTINATION, PendoCommandAction.PendoCommandRunnableAction.RUN_JAVA_SCRIPT, pendoCommandEventType, pendoCommandScope);
    }

    private PendoGlobalCommandHandler() {
        openUrlHandler();
        showAlertHandler();
        sendAppGenericAnalyticsHandler();
        sendPendoAppSpecificAnalyticsHandler();
        sendInsertGenericAnalyticsHandler();
        sendParameterizedInsertGenericAnalyticsHandler();
        sendCustomAnalyticsHandler();
        insertAnalyticsEventHandler();
        openInAppRatingDialog();
        pendoRunnableActionsHandler();
        setupDismissGuideCommandHandler();
        setupAdvanceGuideCommandHandler();
        setupLaunchGuideCommandHandler();
    }

    private void addParameterToJSON(JSONObject jSONObject, PendoCommandsEventBus.Parameter parameter, String str, String str2, String str3) {
        Object jSONArray;
        try {
            if (!str3.equals("number")) {
                if (y0.e(str2)) {
                    jSONArray = new JSONObject(str2);
                } else {
                    jSONArray = y0.d(str2) ? new JSONArray(str2) : parameter.getParameterValue();
                }
                jSONObject.put(str, jSONArray);
                return;
            }
            if (y0.f(str2)) {
                jSONObject.put(str, Long.parseLong(str2));
            } else if (y0.c(str2)) {
                jSONObject.put(str, Integer.parseInt(str2));
            }
        } catch (JSONException unused) {
        }
    }

    public static synchronized PendoGlobalCommandHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PendoGlobalCommandHandler();
        }
        return INSTANCE;
    }

    private void insertAnalyticsEventHandler() {
        PendoCommandsEventBus.getInstance().subscribe(INSERT_ANALYTICS_EVENT_FILTER, new e() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoGlobalCommandHandler.lambda$insertAnalyticsEventHandler$4((PendoCommand) obj);
            }
        });
    }

    static /* synthetic */ void lambda$insertAnalyticsEventHandler$4(PendoCommand pendoCommand) {
        PendoCommandEventType eventType = null;
        String parameterValue = null;
        for (PendoCommandsEventBus.Parameter parameter : pendoCommand.getParameters()) {
            String parameterName = parameter.getParameterName();
            if (!parameterName.equals("guideId")) {
                if (parameterName.equals(PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.ANALYTICS_TYPE)) {
                    eventType = PendoCommandEventType.getEventType(parameter.getParameterValue());
                } else if (parameterName.equals("type")) {
                    parameterValue = parameter.getParameterValue();
                }
            }
        }
        try {
            if (eventType == null) {
                PendoLogger.e("Cannot get event type.", new Object[0]);
                return;
            }
            GuidesManager guidesManager = GuidesManager.INSTANCE;
            if (guidesManager.getGuideActions() == null) {
                PendoLogger.e("Cannot get actions.", new Object[0]);
                return;
            }
            List<PendoCommand> guideActions = guidesManager.getGuideActions();
            Iterator<PendoCommand> it = guideActions.iterator();
            while (it.hasNext()) {
                List<PendoCommandsEventBus.Parameter> parameters = it.next().getParameters();
                if (parameters != null) {
                    PendoCommandsEventBus.Parameter parameter2 = null;
                    for (PendoCommandsEventBus.Parameter parameter3 : parameters) {
                        if (parameter3.getParameterName().equals("type")) {
                            parameter2 = parameter3;
                        }
                    }
                    if (parameter2 != null) {
                        parameters.remove(parameter2);
                    }
                    if (parameterValue != null) {
                        parameters.add(new PendoCommandsEventBus.Parameter("event", "string", parameterValue));
                    }
                }
            }
            PendoCommandDispatcher.getInstance().dispatchCommands(guideActions, eventType, false);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), "commandId: " + pendoCommand.getSourceId() + " id: " + pendoCommand.getCommandId());
        }
    }

    static /* synthetic */ void lambda$openUrlHandler$7(PendoCommand pendoCommand) {
        PendoLogger.d(pendoCommand.toString(), new Object[0]);
        List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
        if (parameters == null) {
            PendoLogger.d("Got " + pendoCommand.getAction() + " and " + pendoCommand.getEventType() + " without parameters! Doing nothing.", new Object[0]);
            return;
        }
        String parameterValue = null;
        String parameterValue2 = null;
        for (PendoCommandsEventBus.Parameter parameter : parameters) {
            String parameterName = parameter.getParameterName();
            if ("url".equals(parameterName)) {
                parameterValue = parameter.getParameterValue();
            } else if ("type".equals(parameterName)) {
                parameterValue2 = parameter.getParameterValue();
            }
        }
        if (parameterValue == null || parameterValue2 == null || parameterValue.isEmpty()) {
            PendoLogger.w("URL = '" + parameterValue + "' type = '" + parameterValue2 + "', doing nothing.", new Object[0]);
        } else {
            c.b(new Intent("android.intent.action.VIEW", Uri.parse(parameterValue)), sdk.pendo.io.d6.c.h().a());
        }
    }

    static /* synthetic */ void lambda$pendoRunnableActionsHandler$1(PendoCommand pendoCommand) {
        List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
        if (parameters == null) {
            PendoLogger.d("Got " + pendoCommand.getAction() + " and " + pendoCommand.getEventType() + " without parameters! Doing nothing.", new Object[0]);
            return;
        }
        for (PendoCommandsEventBus.Parameter parameter : parameters) {
            if (JavascriptRunner.SCRIPT_NAME.equals(parameter.getParameterName())) {
                String parameterValue = parameter.getParameterValue();
                if (JavascriptRunner.JAVA_SCRIPT_TYPE.equals(parameter.getValueType())) {
                    JavascriptRunner.runCode(parameterValue, String.class, pendoCommand.getContext());
                }
            }
        }
    }

    static /* synthetic */ void lambda$sendInsertGenericAnalyticsHandler$2(PendoCommand pendoCommand) {
        PendoLogger.d(pendoCommand.toString(), new Object[0]);
        List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
        if (parameters == null) {
            PendoLogger.d("Got " + pendoCommand.getAction() + " and " + pendoCommand.getEventType() + " without parameters! Doing nothing.", new Object[0]);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        for (PendoCommandsEventBus.Parameter parameter : parameters) {
            String parameterName = parameter.getParameterName();
            String parameterValue = parameter.getParameterValue();
            String valueType = parameter.getValueType();
            if (PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.ANALYTICS_TYPE.equals(parameterName) || "type".equals(parameterName)) {
                str2 = parameterValue;
            } else if (PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.DISMISSED_BY.equals(parameterName) || PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.DISMISSED_REASON.equals(parameterName)) {
                str3 = parameterValue;
            } else if ("guideId".equals(parameterName)) {
                str = parameterValue;
            }
            try {
                if (!valueType.equals("number")) {
                    jSONObject.put(parameterName, y0.e(parameterValue) ? new JSONObject(parameterValue) : parameter.getParameterValue());
                } else if (y0.f(parameterValue)) {
                    jSONObject.put(parameterName, Long.parseLong(parameterValue));
                } else if (y0.c(parameterValue)) {
                    jSONObject.put(parameterName, Integer.parseInt(parameterValue));
                }
            } catch (JSONException unused) {
            }
        }
        VisualGuideBase visualGuide = VisualGuidesManager.getInstance().getVisualGuide(str);
        if (visualGuide == null) {
            PendoLogger.w("Visual guide already null.", new Object[0]);
            return;
        }
        m tracker = visualGuide.getTracker();
        if (tracker == null) {
            PendoLogger.w("Tracker for guide is null. Not sending analytics.", new Object[0]);
            return;
        }
        tracker.a(jSONObject);
        if (str2 == null) {
            PendoLogger.w("analyticsType is null, doing nothing.", new Object[0]);
        } else if (PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.GUIDE_DISMISSED.equalsIgnoreCase(str2)) {
            if (str3 == null) {
                PendoLogger.w("DismissBy is null, doing nothing.", new Object[0]);
            } else {
                d.a(tracker, visualGuide.getDuration(), str3, pendoCommand.getParamValueFromCommand(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.EXTERNAL_ENDPOINT_URL), null);
            }
        }
    }

    static /* synthetic */ void lambda$sendPendoAppSpecificAnalyticsHandler$5(PendoCommand pendoCommand) {
        Object jSONObject;
        PendoLogger.d(pendoCommand.toString(), new Object[0]);
        List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
        if (parameters == null) {
            PendoLogger.d("Parameters are null, doing nothing.", new Object[0]);
            return;
        }
        sdk.pendo.io.r5.d dVarA = sdk.pendo.io.r5.d.a(pendoCommand.getEventType().eventType);
        JSONObject jSONObject2 = new JSONObject();
        Integer numValueOf = -1;
        Boolean bool = Boolean.FALSE;
        try {
            JSONObject jSONObject3 = null;
            String str = "";
            for (PendoCommandsEventBus.Parameter parameter : parameters) {
                String parameterName = parameter.getParameterName();
                String parameterValue = parameter.getParameterValue();
                if ("type".equals(parameterName)) {
                    dVarA = sdk.pendo.io.r5.d.a(parameterValue);
                } else if ("orientation".equals(parameterName)) {
                    jSONObject2.put("orientation", s0.a(s0.c().getConfiguration().orientation));
                } else if ("customEventId".equals(parameterName)) {
                    numValueOf = Integer.valueOf(Integer.parseInt(parameterValue));
                } else if ("customEventData".equals(parameterName)) {
                    bool = Boolean.TRUE;
                    String parameterValue2 = parameter.getParameterValue();
                    if (y0.e(parameterValue2)) {
                        jSONObject3 = new JSONObject(parameterValue2);
                    }
                    str = parameterName;
                } else if (!y0.g(parameterValue)) {
                    if (y0.e(parameterValue)) {
                        jSONObject = new JSONObject(parameterValue);
                    } else if (y0.d(parameterValue)) {
                        jSONObject = new JSONArray(parameterValue);
                    } else {
                        jSONObject2.put(parameterName, parameterValue);
                    }
                    jSONObject2.put(parameterName, jSONObject);
                } else if (y0.f(parameterValue)) {
                    jSONObject2.put(parameterName, Long.parseLong(parameterValue));
                } else if (y0.c(parameterValue)) {
                    jSONObject2.put(parameterName, Integer.parseInt(parameterValue));
                }
            }
            if (numValueOf.intValue() != -1) {
                jSONObject2.put("customEventId", String.valueOf(numValueOf.intValue()));
            }
            if (bool.booleanValue() && numValueOf.intValue() != -1 && jSONObject3 != null) {
                jSONObject2.put(str, jSONObject3);
            }
            i.f().a(dVarA, jSONObject2, pendoCommand.getParamValueFromCommand(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.EXTERNAL_ENDPOINT_URL));
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), "PendoCommandId: " + pendoCommand.getCommandId());
        }
    }

    static /* synthetic */ boolean lambda$setupLaunchGuideCommandHandler$10(Boolean bool) {
        return !bool.booleanValue();
    }

    static /* synthetic */ void lambda$setupLaunchGuideCommandHandler$12(PendoCommand pendoCommand) {
        PendoLogger.d("LaunchGuideCommandHandler: ", pendoCommand.toString());
        String paramValueFromCommand = pendoCommand.getParamValueFromCommand("guideId");
        final String paramValueFromCommand2 = pendoCommand.getParamValueFromCommand(PendoCommandAction.PendoCommandGlobalAction.NEXT_GUIDE_ID);
        if (paramValueFromCommand == null || paramValueFromCommand2 == null) {
            PendoLogger.d("LaunchGuideCommandHandler -> either currGuideId or nextGuideId is null", new Object[0]);
            return;
        }
        GuideModel guide = GuidesManager.INSTANCE.getGuide(paramValueFromCommand2);
        if (guide == null) {
            PendoLogger.d("LaunchGuideCommandHandler: the next guide model is null", new Object[0]);
            return;
        }
        final StepModel stepModel = guide.getSteps().get(0);
        StepSeenManager.getInstance().setCurrentStepSeen(new StepSeen(paramValueFromCommand2, stepModel.getStepContentModel().getGuideStepId(), 0));
        StepSeenManager.getInstance().setIsLaunchGuideFromGuideStep(true);
        VisualGuidesManager.getInstance().getIsAnyGuideDisplayedObservable().a(new j() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda6
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return PendoGlobalCommandHandler.lambda$setupLaunchGuideCommandHandler$10((Boolean) obj);
            }
        }).f().a(sdk.pendo.io.t6.c.a(new e() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda7
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                ActivationManager.INSTANCE.handleLaunchGuideFromGuide(paramValueFromCommand2, stepModel);
            }
        }, "LaunchGuideCommandHandler: is full screen guide displayed observer"));
    }

    static /* synthetic */ void lambda$showAlertHandler$6(PendoCommand pendoCommand) {
        PendoLogger.d(pendoCommand.toString(), new Object[0]);
        List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
        if (parameters == null) {
            PendoLogger.d("Got " + pendoCommand.getAction() + " and " + pendoCommand.getEventType() + " without parameters! Doing nothing.", new Object[0]);
            return;
        }
        String parameterValue = null;
        Long lValueOf = null;
        for (PendoCommandsEventBus.Parameter parameter : parameters) {
            String parameterName = parameter.getParameterName();
            if ("title".equals(parameterName)) {
                parameter.getParameterValue();
            } else if ("message".equals(parameterName)) {
                parameterValue = parameter.getParameterValue();
            } else if ("duration".equals(parameterName) && "long".equals(parameter.getValueType())) {
                try {
                    lValueOf = Long.valueOf(parameter.getParameterValue());
                } catch (Exception e) {
                    PendoLogger.w(e, e.getMessage(), new Object[0]);
                }
            }
        }
        if (parameterValue == null || lValueOf == null) {
            PendoLogger.w("message = '" + parameterValue + "' duration = '" + lValueOf + "' doing nothing.", new Object[0]);
        } else {
            Toast.makeText(PendoInternal.o(), parameterValue, TimeUnit.MILLISECONDS.toSeconds(lValueOf.longValue()) > 2 ? 1 : 0).show();
        }
    }

    private void openInAppRatingDialog() {
        PendoCommandsEventBus.getInstance().subscribe(OPEN_RATING_DIALOG_FILTER, new e() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda9
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                q.a();
            }
        });
    }

    private void openUrlHandler() {
        PendoCommandsEventBus.getInstance().subscribe(OPEN_URL_FILTER, new e() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda10
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoGlobalCommandHandler.lambda$openUrlHandler$7((PendoCommand) obj);
            }
        });
    }

    private void pendoRunnableActionsHandler() {
        PendoCommandsEventBus.getInstance().subscribe(RUN_SCRIPT_FILTER, new e() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda12
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoGlobalCommandHandler.lambda$pendoRunnableActionsHandler$1((PendoCommand) obj);
            }
        });
    }

    private void sendAppGenericAnalyticsHandler() {
        PendoCommandsEventBus.getInstance().subscribe(SEND_APP_GENERIC_ANALYTICS_FILTER, this.sendParameterizedAnalyticsAction);
    }

    private void sendCustomAnalyticsHandler() {
        PendoCommandsEventBus.getInstance().subscribe(SEND_CUSTOM_ANALYTICS_FILTER, this.sendParameterizedAnalyticsAction);
    }

    private void sendInsertGenericAnalyticsHandler() {
        PendoCommandsEventBus.getInstance().subscribe(SEND_GUIDE_GENERIC_ANALYTICS_FILTER, new e() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoGlobalCommandHandler.lambda$sendInsertGenericAnalyticsHandler$2((PendoCommand) obj);
            }
        });
    }

    private void sendParameterizedInsertGenericAnalyticsHandler() {
        PendoCommandsEventBus.getInstance().subscribe(SEND_GUIDE_PARAMETRIZED_GENERIC_ANALYTICS_FILTER, this.sendParameterizedAnalyticsAction);
    }

    private void sendPendoAppSpecificAnalyticsHandler() {
        PendoCommandsEventBus.getInstance().subscribe(SEND_APP_SPECIFIC_ANALYTICS_FILTER, new e() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoGlobalCommandHandler.lambda$sendPendoAppSpecificAnalyticsHandler$5((PendoCommand) obj);
            }
        });
    }

    private void setupAdvanceGuideCommandHandler() {
        PendoCommandsEventBus.getInstance().subscribe(new PendoCommand.Builder().setDestinationId(PENDO_GLOBAL_COMMAND_DEST).setAction(PendoCommandAction.PendoCommandGlobalAction.ADVANCE_GUIDE).build().getFilter(), new e() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                this.f$0.m16686x1a36a606((PendoCommand) obj);
            }
        });
    }

    private void setupDismissGuideCommandHandler() {
        PendoCommandsEventBus.getInstance().subscribe(new PendoCommand.Builder().setDestinationId(PENDO_GLOBAL_COMMAND_DEST).setAction(PendoCommandAction.PendoCommandGlobalAction.DISMISS_GUIDE).build().getFilter(), new e() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda11
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                this.f$0.m16687xd1af71ff((PendoCommand) obj);
            }
        });
    }

    private void setupLaunchGuideCommandHandler() {
        PendoCommandsEventBus.getInstance().subscribe(new PendoCommand.Builder().setDestinationId(PENDO_GLOBAL_COMMAND_DEST).setAction(PendoCommandAction.PendoCommandGlobalAction.LAUNCH_GUIDE).build().getFilter(), new e() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda5
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoGlobalCommandHandler.lambda$setupLaunchGuideCommandHandler$12((PendoCommand) obj);
            }
        });
    }

    private void showAlertHandler() {
        PendoCommandsEventBus.getInstance().subscribe(SHOW_ALERT_FILTER, new e() { // from class: sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler$$ExternalSyntheticLambda8
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoGlobalCommandHandler.lambda$showAlertHandler$6((PendoCommand) obj);
            }
        });
    }

    public b<PendoCommand> getAdvanceGuideCommandPublisher() {
        return this.mAdvanceGuideCommandPublisher;
    }

    public b<PendoCommand> getDismissGuideCommandPublisher() {
        return this.mDismissGuideCommandPublisher;
    }

    public b<PendoCommand> getLaunchGuideCommandPublisher() {
        return this.mLaunchGuideCommandPublisher;
    }

    /* JADX INFO: renamed from: lambda$new$0$sdk-pendo-io-actions-handlers-PendoGlobalCommandHandler, reason: not valid java name */
    /* synthetic */ void m16685xc9eb1588(PendoCommand pendoCommand) throws JSONException {
        PendoGlobalCommandHandler pendoGlobalCommandHandler;
        JSONObject jSONObject;
        List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
        if (parameters == null) {
            PendoLogger.d("Got " + pendoCommand.getAction() + " and " + pendoCommand.getEventType() + " without parameters! Doing nothing.", new Object[0]);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        String str = null;
        String str2 = null;
        for (PendoCommandsEventBus.Parameter parameter : parameters) {
            JSONObject jSONObject4 = jSONObject3;
            String parameterName = parameter.getParameterName();
            String parameterValue = parameter.getParameterValue();
            String valueType = parameter.getValueType();
            if (parameterName.startsWith("guideId")) {
                jSONObject3 = jSONObject4;
                str = parameterValue;
            } else {
                if (parameterName.startsWith(PROPS_PREFIX)) {
                    String strReplace = parameterName.replace(PROPS_PREFIX, "");
                    PendoGlobalCommandHandler pendoGlobalCommandHandler2 = this;
                    pendoGlobalCommandHandler2.addParameterToJSON(jSONObject4, parameter, strReplace, parameterValue, valueType);
                    jSONObject = jSONObject4;
                    pendoGlobalCommandHandler = pendoGlobalCommandHandler2;
                    parameterName = strReplace;
                    parameterValue = parameterValue;
                } else {
                    pendoGlobalCommandHandler = this;
                    jSONObject = jSONObject4;
                    pendoGlobalCommandHandler.addParameterToJSON(jSONObject2, parameter, parameterName, parameterValue, valueType);
                }
                boolean zEquals = "type".equals(parameterName);
                jSONObject3 = jSONObject;
                this = pendoGlobalCommandHandler;
                if (zEquals) {
                    str2 = parameterValue;
                }
            }
        }
        JSONObject jSONObject5 = jSONObject3;
        if (StepSeenManager.getInstance().isLaunchGuideFromGuideStep() && str != null && str.equals(StepSeenManager.getInstance().getCurrentStepGuideId())) {
            jSONObject5.put(SEEN_REASON, API);
        }
        if (jSONObject5.length() > 0) {
            try {
                jSONObject2.put(PROPS_JSON_KEY, jSONObject5);
            } catch (JSONException e) {
                PendoLogger.e(e.getMessage(), e);
            }
        }
        d.a(i.e(jSONObject2), sdk.pendo.io.r5.d.a(str2), pendoCommand.getParamValueFromCommand(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.EXTERNAL_ENDPOINT_URL));
    }

    /* JADX INFO: renamed from: lambda$setupAdvanceGuideCommandHandler$8$sdk-pendo-io-actions-handlers-PendoGlobalCommandHandler, reason: not valid java name */
    /* synthetic */ void m16686x1a36a606(PendoCommand pendoCommand) {
        PendoLogger.d("mAdvanceGuideCommandPublisher: ", pendoCommand.toString());
        this.mAdvanceGuideCommandPublisher.onNext(pendoCommand);
    }

    /* JADX INFO: renamed from: lambda$setupDismissGuideCommandHandler$9$sdk-pendo-io-actions-handlers-PendoGlobalCommandHandler, reason: not valid java name */
    /* synthetic */ void m16687xd1af71ff(PendoCommand pendoCommand) {
        PendoLogger.d("DismissGuideCommandPublisher: ", pendoCommand.toString());
        this.mDismissGuideCommandPublisher.onNext(pendoCommand);
    }
}
