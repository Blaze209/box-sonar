package sdk.pendo.io.actions.handlers;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.q3.j;
import sdk.pendo.io.t4.g;

/* JADX INFO: loaded from: classes4.dex */
public final class PendoCommandViewHandlerUtility {
    private static final String PARAMETER_NAME_TEXT = "text";

    private PendoCommandViewHandlerUtility() {
    }

    public static void handlePendoCommandsForView(View view, String str) {
        j<PendoCommand> jVarCreateFilter = PendoCommand.createFilter("any", str, PendoCommandAction.PENDO_COMMAND_ACTION_ANY, PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY, PendoCommand.PendoCommandScope.PENDO_COMMAND_SCOPE_ANY);
        setupViewGeneralHandler(view, jVarCreateFilter);
        if (view instanceof TextView) {
            setupTextViewHandler(view, jVarCreateFilter);
        }
    }

    private static void setupTextViewHandler(final View view, j<PendoCommand> jVar) {
        PendoCommandsEventBus.getInstance().subscribe(g.a(view), jVar, new e<PendoCommand>() { // from class: sdk.pendo.io.actions.handlers.PendoCommandViewHandlerUtility.2
            @Override // sdk.pendo.io.q3.e
            public void accept(PendoCommand pendoCommand) {
                PendoLogger.d(pendoCommand.toString(), new Object[0]);
                PendoCommandAction action = pendoCommand.getAction();
                List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
                if (parameters == null) {
                    PendoLogger.w("Got " + pendoCommand.getAction() + " and " + pendoCommand.getEventType() + " without parameters! Doing nothing.", new Object[0]);
                    return;
                }
                String parameterValue = null;
                for (PendoCommandsEventBus.Parameter parameter : parameters) {
                    if ("text".equals(parameter.getParameterName())) {
                        parameterValue = parameter.getParameterValue();
                    }
                }
                if (PendoCommandAction.PendoCommandTextAction.SET_TEXT.equals(action) && !TextUtils.isEmpty(parameterValue)) {
                    ((TextView) view).setText(parameterValue);
                    view.setContentDescription(parameterValue);
                }
                PendoCommandAction.PendoCommandPageAction.VALIDATE.equals(action);
            }
        });
    }

    private static void setupViewGeneralHandler(final View view, j<PendoCommand> jVar) {
        PendoCommandsEventBus.getInstance().subscribe(g.a(view), jVar, new e<PendoCommand>() { // from class: sdk.pendo.io.actions.handlers.PendoCommandViewHandlerUtility.1
            @Override // sdk.pendo.io.q3.e
            public void accept(PendoCommand pendoCommand) {
                View view2;
                int i;
                PendoLogger.d(pendoCommand.toString(), new Object[0]);
                PendoCommandAction action = pendoCommand.getAction();
                List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
                if (parameters == null) {
                    PendoLogger.w("Got " + pendoCommand.getAction() + " and " + pendoCommand.getEventType() + " without parameters! Doing nothing.", new Object[0]);
                    return;
                }
                Boolean boolValueOf = null;
                String parameterValue = null;
                String parameterValue2 = null;
                for (PendoCommandsEventBus.Parameter parameter : parameters) {
                    String parameterName = parameter.getParameterName();
                    if ("visibility".equals(parameterName)) {
                        parameterValue2 = parameter.getParameterValue();
                    } else if ("color".equals(parameterName)) {
                        parameterValue = parameter.getParameterValue();
                    } else if ("enabled".equals(parameterName) && TypedValues.Custom.S_BOOLEAN.equalsIgnoreCase(parameter.getValueType())) {
                        try {
                            boolValueOf = Boolean.valueOf(parameter.getParameterValue());
                        } catch (Exception e) {
                            PendoLogger.w(e, e.getMessage(), new Object[0]);
                        }
                    }
                }
                if (PendoCommandAction.PendoCommandViewGeneralAction.ENABLE.equals(action)) {
                    if (boolValueOf == null) {
                        PendoLogger.w("enable is null doing nothing.", new Object[0]);
                        return;
                    } else {
                        view.setEnabled(boolValueOf.booleanValue());
                        return;
                    }
                }
                if (PendoCommandAction.PendoCommandViewGeneralAction.SET_BACKGROUND_COLOR.equals(action)) {
                    if (parameterValue == null) {
                        PendoLogger.w("color is null doing nothing.", new Object[0]);
                        return;
                    }
                    try {
                        view.setBackgroundColor(Color.parseColor(parameterValue));
                        return;
                    } catch (Exception e2) {
                        PendoLogger.w(e2, "Got color: " + parameterValue, new Object[0]);
                        return;
                    }
                }
                if (PendoCommandAction.PendoCommandViewGeneralAction.SET_VISIBILITY.equals(action)) {
                    if (parameterValue2 == null) {
                        PendoLogger.w("visibility is null doing nothing.", new Object[0]);
                        return;
                    }
                    parameterValue2.hashCode();
                    switch (parameterValue2) {
                        case "hidden":
                            view2 = view;
                            i = 4;
                            break;
                        case "visible":
                            view.setVisibility(0);
                            return;
                        case "removed":
                            view2 = view;
                            i = 8;
                            break;
                        default:
                            PendoLogger.w("Got unsupported visibility: " + parameterValue2, new Object[0]);
                            return;
                    }
                    view2.setVisibility(i);
                }
            }
        });
    }
}
