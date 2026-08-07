package sdk.pendo.io.actions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.b0.c;
import sdk.pendo.io.h4.b;
import sdk.pendo.io.k3.d;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.q6.a;

/* JADX INFO: loaded from: classes4.dex */
public final class PendoCommandsEventBus {
    private static volatile PendoCommandsEventBus INSTANCE;
    public final b<PendoCommand> mCommandEventBus = b.f();

    public static final class Parameter {
        public static final String INSERT_COMMAND_PARAMETER_SERIALIZED_NAME_NAME = "name";
        public static final String INSERT_COMMAND_PARAMETER_SERIALIZED_NAME_TYPE = "type";
        public static final String INSERT_COMMAND_PARAMETER_SERIALIZED_NAME_VALUE = "value";

        @c("name")
        final String parameterName;

        @c("value")
        final String parameterValue;

        @c("type")
        final String valueType;

        public Parameter(String str, String str2, String str3) {
            this.parameterName = str;
            this.valueType = str2;
            this.parameterValue = str3;
        }

        public static List<Parameter> createParameters(f fVar) {
            LinkedList linkedList = new LinkedList();
            if (fVar != null) {
                Iterator<i> it = fVar.iterator();
                while (it.hasNext()) {
                    l lVarE = it.next().e();
                    linkedList.add(new Parameter(lVarE.a("name").g(), lVarE.a("type").g(), lVarE.a("value").g()));
                }
            }
            return linkedList;
        }

        public static <T> T getParameterValue(List<Parameter> list, String str, Class<T> cls) throws NoSuchFieldException {
            for (Parameter parameter : list) {
                try {
                    if (str.equals(parameter.getParameterName())) {
                        String parameterValue = parameter.getParameterValue();
                        if (!String.class.equals(cls) && !String.class.isInstance(cls)) {
                            if (Integer.class.isInstance(cls)) {
                                return cls.cast(Integer.valueOf(Integer.parseInt(parameterValue)));
                            }
                            if (Float.class.isInstance(cls)) {
                                return cls.cast(Float.valueOf(Float.parseFloat(parameterValue)));
                            }
                            if (Long.class.isInstance(cls)) {
                                return cls.cast(Long.valueOf(Long.parseLong(parameterValue)));
                            }
                            if (Double.class.isInstance(cls)) {
                                return cls.cast(Double.valueOf(Double.parseDouble(parameterValue)));
                            }
                            if (Boolean.class.isInstance(cls)) {
                                return cls.cast(Boolean.valueOf(Boolean.parseBoolean(parameterValue)));
                            }
                        }
                        return cls.cast(parameterValue);
                    }
                    continue;
                } catch (Exception unused) {
                }
            }
            throw new NoSuchFieldException("'" + str + "' of type: '" + cls + "' wasn't found.");
        }

        static boolean isValidPendoCommandParameterJSON(l lVar) {
            return lVar.d("name") && lVar.d("type") && lVar.d("value");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Parameter)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Parameter parameter = (Parameter) obj;
            return this.parameterName.equals(parameter.parameterName) && this.valueType.equals(parameter.valueType) && this.parameterValue.equals(parameter.parameterValue);
        }

        public String getParameterName() {
            return this.parameterName;
        }

        public String getValueType() {
            return this.valueType;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public String toString() {
            return "{ name: '" + getParameterName() + "' type: '" + getValueType() + "' value: '" + getParameterValue() + "' }";
        }

        public String getParameterValue() {
            return this.parameterValue;
        }
    }

    private PendoCommandsEventBus() {
    }

    public static synchronized PendoCommandsEventBus getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PendoCommandsEventBus();
        }
        return INSTANCE;
    }

    public d<PendoCommand> getCommandEventBus() {
        return this.mCommandEventBus.c();
    }

    void send(List<PendoCommand> list) {
        j.a((Iterable) list).a((o) sdk.pendo.io.t6.d.a(new e<PendoCommand>() { // from class: sdk.pendo.io.actions.PendoCommandsEventBus.1
            @Override // sdk.pendo.io.q3.e
            public void accept(PendoCommand pendoCommand) {
                PendoLogger.i("Sending: " + pendoCommand.toString(), new Object[0]);
                PendoCommandsEventBus.this.mCommandEventBus.onNext(pendoCommand);
            }
        }, "PendoCommandsEventBus multiple commands send observer"));
    }

    public sdk.pendo.io.o3.b subscribe(d<?> dVar, sdk.pendo.io.q3.j<PendoCommand> jVar, e<PendoCommand> eVar) {
        return subscribe(null, dVar, jVar, eVar);
    }

    void send(PendoCommand pendoCommand) {
        this.mCommandEventBus.onNext(pendoCommand);
    }

    public sdk.pendo.io.o3.b subscribe(sdk.pendo.io.k3.f<PendoCommand, PendoCommand> fVar, d<?> dVar, sdk.pendo.io.q3.j<PendoCommand> jVar, e<PendoCommand> eVar) {
        if (fVar == null && dVar == null && jVar == null) {
            return this.mCommandEventBus.a(eVar, new a("PendoCommandEventBus commandbus error consumer"));
        }
        d<PendoCommand> dVarA = fVar != null ? this.mCommandEventBus.a(fVar) : null;
        if (dVar != null) {
            dVarA = this.mCommandEventBus.b(dVar);
        }
        if (jVar != null) {
            dVarA = dVarA != null ? dVarA.a(jVar) : this.mCommandEventBus.a(jVar);
        }
        return dVarA.a(eVar, new a("PendoCommandEventBus pendoCommandObservable error consumer"));
    }

    public sdk.pendo.io.o3.b subscribe(sdk.pendo.io.k3.f<PendoCommand, PendoCommand> fVar, sdk.pendo.io.q3.j<PendoCommand> jVar, e<PendoCommand> eVar) {
        return subscribe(fVar, null, jVar, eVar);
    }

    public sdk.pendo.io.o3.b subscribe(sdk.pendo.io.q3.j<PendoCommand> jVar, e<PendoCommand> eVar) {
        return subscribe(null, null, jVar, eVar);
    }
}
