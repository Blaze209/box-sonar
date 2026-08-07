package sdk.pendo.io.actions;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.b0.c;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.q3.h;
import sdk.pendo.io.q3.j;
import sdk.pendo.io.s7.w;
import sdk.pendo.io.s7.y0;
import sdk.pendo.io.utilities.script.JavascriptRunner;
import sdk.pendo.io.x1.g;

/* JADX INFO: loaded from: classes4.dex */
public final class PendoCommand {
    public static final String COMMAND_STRING_ANY = "any";
    public static final String INSERT_COMMANDS_SERIALIZED_NAME = "actions";
    private static final String INSERT_COMMAND_SERIALIZED_NAME_ACTION = "action";
    private static final String INSERT_COMMAND_SERIALIZED_NAME_DESTINATION = "destination";
    public static final String INSERT_COMMAND_SERIALIZED_NAME_EVENT_TYPE = "eventType";
    private static final String INSERT_COMMAND_SERIALIZED_NAME_ID = "id";
    private static final String INSERT_COMMAND_SERIALIZED_NAME_PARAMETERS = "parameters";
    private static final String INSERT_COMMAND_SERIALIZED_NAME_SCOPE = "scope";
    private static final String INSERT_COMMAND_SERIALIZED_NAME_SOURCE = "source";
    private static final String INSERT_COMMAND_SERIALIZED_NAME_SOURCE_ACTION_ID = "sourceActionId";

    @c("action")
    final PendoCommandAction action;

    @c("id")
    final String commandId;
    JavascriptRunner.GuideContext context;

    @c("destination")
    final String destinationId;

    @c("eventType")
    final PendoCommandEventType eventType;

    @c(INSERT_COMMAND_SERIALIZED_NAME_PARAMETERS)
    List<PendoCommandsEventBus.Parameter> parameters;

    @c("scope")
    final PendoCommandScope scope;

    @c(INSERT_COMMAND_SERIALIZED_NAME_SOURCE_ACTION_ID)
    final String sourceActionId;

    @c("source")
    final String sourceId;

    public static class Builder {
        private PendoCommandAction mAction;
        private String mCommandId;
        private String mDestinationId;
        private PendoCommandEventType mEventType;
        private List<PendoCommandsEventBus.Parameter> mParameters;
        private PendoCommandScope mScope;
        private String mSourceId;

        public Builder() {
            this.mCommandId = null;
            this.mSourceId = "any";
            this.mDestinationId = "any";
            this.mEventType = PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY;
            this.mScope = PendoCommandScope.PENDO_COMMAND_SCOPE_ANY;
            this.mParameters = null;
        }

        public Builder addParameter(PendoCommandsEventBus.Parameter parameter) {
            if (this.mParameters == null) {
                this.mParameters = new LinkedList();
            }
            this.mParameters.add(parameter);
            return this;
        }

        public PendoCommand build() {
            return new PendoCommand(this.mCommandId, this.mSourceId, this.mDestinationId, this.mAction, this.mEventType, this.mScope, this.mParameters);
        }

        public Builder setAction(PendoCommandAction pendoCommandAction) {
            this.mAction = pendoCommandAction;
            return this;
        }

        Builder setCommandId(String str) {
            this.mCommandId = str;
            return this;
        }

        public Builder setDestinationId(String str) {
            this.mDestinationId = str;
            return this;
        }

        Builder setEventType(PendoCommandEventType pendoCommandEventType) {
            this.mEventType = pendoCommandEventType;
            return this;
        }

        public Builder setParameters(List<PendoCommandsEventBus.Parameter> list) {
            this.mParameters = list;
            return this;
        }

        public Builder setScope(PendoCommandScope pendoCommandScope) {
            this.mScope = pendoCommandScope;
            return this;
        }

        public Builder setSourceId(String str) {
            this.mSourceId = str;
            return this;
        }

        public Builder(PendoCommandAction pendoCommandAction, PendoCommandEventType pendoCommandEventType) {
            this.mCommandId = null;
            this.mSourceId = "any";
            this.mDestinationId = "any";
            this.mEventType = PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY;
            this.mScope = PendoCommandScope.PENDO_COMMAND_SCOPE_ANY;
            this.mParameters = null;
            this.mAction = pendoCommandAction;
            this.mEventType = pendoCommandEventType;
        }
    }

    public enum PendoCommandScope {
        ONCE_PER_SESSION("session"),
        ALWAYS("always"),
        PENDO_COMMAND_SCOPE_ANY("any");

        private static final Map<String, PendoCommandScope> LOOKUP_TABLE = new HashMap();
        private final String mScope;

        static {
            for (PendoCommandScope pendoCommandScope : EnumSet.allOf(PendoCommandScope.class)) {
                LOOKUP_TABLE.put(pendoCommandScope.mScope, pendoCommandScope);
            }
        }

        PendoCommandScope(String str) {
            this.mScope = str;
        }

        public static PendoCommandScope getScope(String str) {
            return LOOKUP_TABLE.get(str);
        }

        public boolean equals(PendoCommandScope pendoCommandScope) {
            return this.mScope.equals(pendoCommandScope.mScope);
        }
    }

    public PendoCommand(String str, String str2, String str3, PendoCommandAction pendoCommandAction, PendoCommandEventType pendoCommandEventType, PendoCommandScope pendoCommandScope, List<PendoCommandsEventBus.Parameter> list) {
        this.commandId = str == null ? UUID.randomUUID().toString() : str;
        this.sourceId = str2;
        this.destinationId = str3;
        this.action = pendoCommandAction;
        this.eventType = pendoCommandEventType;
        this.scope = pendoCommandScope;
        this.parameters = list;
        this.sourceActionId = null;
    }

    private void addParameters(List<PendoCommandsEventBus.Parameter> list) {
        Iterator<PendoCommandsEventBus.Parameter> it = list.iterator();
        while (it.hasNext()) {
            addParameter(it.next());
        }
    }

    public static List<PendoCommand> commandFactory(l lVar) {
        PendoCommandScope scope;
        LinkedList linkedList = new LinkedList();
        if (!isValidPendoCommandJSON(lVar)) {
            PendoLogger.e("Pendo command is not a valid JSON: " + lVar.toString(), new Object[0]);
            return linkedList;
        }
        Builder builder = new Builder();
        try {
            builder.setCommandId(lVar.a("id").g());
        } catch (Exception unused) {
        }
        builder.setAction(PendoCommandAction.getAction(lVar.a("action").g()));
        try {
            builder.setDestinationId(lVar.a("destination").g());
        } catch (Exception unused2) {
        }
        try {
            builder.setSourceId(lVar.a("source").g());
        } catch (Exception unused3) {
        }
        try {
            i iVarA = lVar.a("scope");
            if (iVarA != null && (scope = PendoCommandScope.getScope(iVarA.g())) != null) {
                builder.setScope(scope);
            }
        } catch (Exception unused4) {
        }
        try {
            if (lVar.d(INSERT_COMMAND_SERIALIZED_NAME_PARAMETERS)) {
                builder.setParameters(PendoCommandsEventBus.Parameter.createParameters(lVar.a(INSERT_COMMAND_SERIALIZED_NAME_PARAMETERS).d()));
            }
        } catch (Exception unused5) {
        }
        String strG = lVar.a("eventType").g();
        if (strG.contains("|")) {
            for (String str : strG.split("\\|")) {
                PendoCommandEventType eventType = PendoCommandEventType.getEventType(str.trim());
                if (eventType != null) {
                    builder.setEventType(eventType);
                    linkedList.add(builder.build());
                }
            }
        } else {
            builder.setEventType(PendoCommandEventType.getEventType(strG));
            linkedList.add(builder.build());
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean compareField(boolean z, Object obj, Object obj2) {
        if (z) {
            if ((obj instanceof PendoCommandAction) && (obj2 instanceof PendoCommandAction)) {
                PendoCommandAction pendoCommandAction = PendoCommandAction.PENDO_COMMAND_ACTION_ANY;
                if (pendoCommandAction.equals(obj) || pendoCommandAction.equals(obj2)) {
                    return true;
                }
            }
            if ((obj instanceof PendoCommandEventType) && (obj2 instanceof PendoCommandEventType)) {
                PendoCommandEventType pendoCommandEventType = PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY;
                if (pendoCommandEventType.equals(obj) || pendoCommandEventType.equals(obj2)) {
                    return true;
                }
            }
            if ((obj instanceof PendoCommandScope) && (obj2 instanceof PendoCommandScope)) {
                PendoCommandScope pendoCommandScope = PendoCommandScope.PENDO_COMMAND_SCOPE_ANY;
                if (pendoCommandScope.equals(obj) || pendoCommandScope.equals(obj2)) {
                    return true;
                }
            }
            if ("any".equals(obj) || "any".equals(obj2)) {
                return true;
            }
        }
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static h<PendoCommand, Boolean> createFilter(String str, String str2, PendoCommandAction pendoCommandAction, PendoCommandEventType pendoCommandEventType, PendoCommandScope pendoCommandScope, Pair<String, String> pair) {
        return new PendoCommand((String) null, str, str2, pendoCommandAction, pendoCommandEventType, pendoCommandScope, new PendoCommandsEventBus.Parameter[0]).getFilter(pair);
    }

    private h<PendoCommand, Boolean> getFilter(final Pair<String, String>... pairArr) {
        return new h<PendoCommand, Boolean>() { // from class: sdk.pendo.io.actions.PendoCommand.2
            @Override // sdk.pendo.io.q3.h
            public Boolean apply(PendoCommand pendoCommand) {
                return Boolean.valueOf(PendoCommand.this.equals(true, pendoCommand) && pendoCommand.hasParameters(pairArr));
            }
        };
    }

    public static List<PendoCommand> getPendoCommands(f fVar) {
        LinkedList linkedList = new LinkedList();
        if (fVar != null) {
            for (int i = 0; i < fVar.size(); i++) {
                l lVarA = w.a(fVar, i);
                List<PendoCommand> listCommandFactory = commandFactory(lVarA);
                if (listCommandFactory.isEmpty()) {
                    PendoLogger.d("Cannot create command from: " + lVarA.toString(), new Object[0]);
                } else {
                    linkedList.addAll(listCommandFactory);
                }
            }
        }
        return linkedList;
    }

    public static List<PendoCommand> getPendoCommandsWithParameters(List<PendoCommand> list, List<PendoCommandsEventBus.Parameter> list2, JavascriptRunner.GuideContext guideContext) {
        if (list == null) {
            return new LinkedList();
        }
        for (PendoCommand pendoCommand : list) {
            pendoCommand.addParameters(list2);
            pendoCommand.setContext(guideContext);
        }
        return list;
    }

    private static boolean isValidPendoCommandJSON(l lVar) {
        if (lVar == null || !lVar.d("id") || !lVar.d("destination") || !lVar.d("action") || !lVar.d("eventType")) {
            return false;
        }
        if (!lVar.d(INSERT_COMMAND_SERIALIZED_NAME_PARAMETERS)) {
            return true;
        }
        try {
            f fVarB = lVar.b(INSERT_COMMAND_SERIALIZED_NAME_PARAMETERS);
            if (fVarB == null) {
                return true;
            }
            for (int i = 0; i < fVarB.size(); i++) {
                if (!PendoCommandsEventBus.Parameter.isValidPendoCommandParameterJSON(fVarB.a(i).e())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            PendoLogger.w(e, "Cannot get parameters JSON.", new Object[0]);
            return false;
        }
    }

    public void addParameter(PendoCommandsEventBus.Parameter parameter) {
        if (this.parameters == null) {
            this.parameters = new ArrayList();
        }
        this.parameters.add(parameter);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PendoCommand)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return equals(false, (PendoCommand) obj);
    }

    public PendoCommandAction getAction() {
        return this.action;
    }

    public String getCommandId() {
        return this.commandId;
    }

    public JavascriptRunner.GuideContext getContext() {
        return this.context;
    }

    public String getDestinationId() {
        return this.destinationId;
    }

    public PendoCommandEventType getEventType() {
        return this.eventType;
    }

    public String getParamValueFromCommand(String str) {
        List<PendoCommandsEventBus.Parameter> parameters = getParameters();
        if (parameters == null) {
            return null;
        }
        for (PendoCommandsEventBus.Parameter parameter : parameters) {
            if (str.equals(parameter.getParameterName())) {
                return parameter.getParameterValue();
            }
        }
        return null;
    }

    public List<PendoCommandsEventBus.Parameter> getParameters() {
        return this.parameters;
    }

    public PendoCommandScope getScope() {
        return this.scope;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public boolean hasParameters(Pair<String, String>... pairArr) {
        List<PendoCommandsEventBus.Parameter> parameters = getParameters();
        if (y0.a((Collection) parameters) && pairArr != null && pairArr.length > 0) {
            return false;
        }
        if (!y0.a((Collection) parameters) && pairArr == null) {
            return false;
        }
        boolean z = true;
        for (Pair<String, String> pair : pairArr) {
            String str = (String) pair.first;
            String str2 = (String) pair.second;
            for (PendoCommandsEventBus.Parameter parameter : parameters) {
                if (parameter.getParameterName().equals(str) && !parameter.getParameterValue().equals(str2)) {
                    z = false;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return g.a(17, 37, this, false, null, new String[0]);
    }

    public boolean removeParameter(PendoCommandsEventBus.Parameter parameter) {
        List<PendoCommandsEventBus.Parameter> list = this.parameters;
        if (list == null) {
            return false;
        }
        return list.remove(parameter);
    }

    public void setContext(JavascriptRunner.GuideContext guideContext) {
        this.context = guideContext;
    }

    public void setParameters(List<PendoCommandsEventBus.Parameter> list) {
        this.parameters = list;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Command:{ source: ").append(getSourceId()).append(" -> destination: ").append(getDestinationId()).append(" action: ").append(getAction()).append(" event: ").append(getEventType()).append(" parameter: ");
        List<PendoCommandsEventBus.Parameter> list = this.parameters;
        return sbAppend.append(list != null ? Arrays.toString(list.toArray()) : AbstractJsonLexerKt.NULL).append(" }").toString();
    }

    public PendoCommand(String str, String str2, String str3, PendoCommandAction pendoCommandAction, PendoCommandEventType pendoCommandEventType, PendoCommandScope pendoCommandScope, PendoCommandsEventBus.Parameter... parameterArr) {
        this.commandId = str == null ? UUID.randomUUID().toString() : str;
        this.sourceId = str2;
        this.destinationId = str3;
        this.action = pendoCommandAction;
        this.eventType = pendoCommandEventType;
        this.scope = pendoCommandScope;
        if (parameterArr != null) {
            this.parameters = Arrays.asList(parameterArr);
        }
        this.sourceActionId = null;
    }

    public static j<PendoCommand> createFilter(String str, String str2, List<PendoCommandAction> list, List<PendoCommandEventType> list2) {
        return createFilter(str, str2, list, list2, PendoCommandScope.PENDO_COMMAND_SCOPE_ANY);
    }

    public static List<PendoCommand> getPendoCommandsWithParameters(f fVar, List<PendoCommandsEventBus.Parameter> list) {
        return getPendoCommandsWithParameters(fVar, list, (JavascriptRunner.GuideContext) null);
    }

    public boolean equals(boolean z, PendoCommand pendoCommand) {
        return compareField(z, this.action, pendoCommand.action) && compareField(z, this.eventType, pendoCommand.eventType) && compareField(z, this.sourceId, pendoCommand.sourceId) && compareField(z, this.destinationId, pendoCommand.destinationId) && compareField(z, this.scope, pendoCommand.scope);
    }

    public j<PendoCommand> getFilter() {
        return new j<PendoCommand>() { // from class: sdk.pendo.io.actions.PendoCommand.1
            @Override // sdk.pendo.io.q3.j
            public boolean test(PendoCommand pendoCommand) {
                return PendoCommand.this.equals(true, pendoCommand);
            }
        };
    }

    public static j<PendoCommand> createFilter(final String str, final String str2, final List<PendoCommandAction> list, final List<PendoCommandEventType> list2, final PendoCommandScope pendoCommandScope) {
        return new j<PendoCommand>() { // from class: sdk.pendo.io.actions.PendoCommand.3
            @Override // sdk.pendo.io.q3.j
            public boolean test(PendoCommand pendoCommand) {
                boolean z;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if (pendoCommand.compareField(true, pendoCommand.action, (PendoCommandAction) it.next())) {
                        z = true;
                        break;
                    }
                }
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (pendoCommand.compareField(true, pendoCommand.eventType, (PendoCommandEventType) it2.next())) {
                        break;
                    }
                }
                if (pendoCommand.compareField(true, pendoCommand.sourceId, str) && pendoCommand.compareField(true, pendoCommand.destinationId, str2) && pendoCommand.compareField(true, pendoCommandScope, pendoCommand.scope)) {
                    return z;
                }
                return false;
            }
        };
    }

    public static List<PendoCommand> getPendoCommandsWithParameters(f fVar, List<PendoCommandsEventBus.Parameter> list, JavascriptRunner.GuideContext guideContext) {
        return getPendoCommandsWithParameters(getPendoCommands(fVar), list, guideContext);
    }

    public static j<PendoCommand> createFilter(String str, String str2, List<PendoCommandAction> list, PendoCommandEventType pendoCommandEventType) {
        return createFilter(str, str2, list, (List<PendoCommandEventType>) Collections.singletonList(pendoCommandEventType));
    }

    public static j<PendoCommand> createFilter(String str, String str2, PendoCommandAction pendoCommandAction, List<PendoCommandEventType> list) {
        return createFilter(str, str2, (List<PendoCommandAction>) Collections.singletonList(pendoCommandAction), list);
    }

    public static j<PendoCommand> createFilter(String str, String str2, PendoCommandAction pendoCommandAction, PendoCommandEventType pendoCommandEventType, PendoCommandScope pendoCommandScope) {
        return new PendoCommand((String) null, str, str2, pendoCommandAction, pendoCommandEventType, pendoCommandScope, new PendoCommandsEventBus.Parameter[0]).getFilter();
    }
}
