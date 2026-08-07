package sdk.pendo.io.events;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import sdk.pendo.io.b0.c;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: loaded from: classes4.dex */
public class ConditionData {
    public static final String NUMBER_VALUE = "number";
    public static final String STRING_VALUE = "string";

    @c("operator")
    private String mOperator;

    @c("parameters")
    private ConditionParam[] mParameters;

    @c("type")
    private String mType;

    @c("typeValue")
    private IdentificationData mTypeValue;

    public static class ConditionParam {

        @c("type")
        private String mType;

        @c("value")
        private String mValue;

        public String getType() {
            return this.mType;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    public enum ConditionType {
        ELEMENT_INFO(IdentificationData.SERIALIZED_NAME),
        SCRIPT(JavascriptRunner.SCRIPT_NAME),
        SHARED_PREFERENCE("sharedPreferences");

        private static final Map<String, ConditionType> LOOKUP_TABLE = new HashMap();
        private final String mConditionType;

        static {
            for (ConditionType conditionType : EnumSet.allOf(ConditionType.class)) {
                LOOKUP_TABLE.put(conditionType.mConditionType, conditionType);
            }
        }

        ConditionType(String str) {
            this.mConditionType = str;
        }

        public static ConditionType get(String str) {
            return LOOKUP_TABLE.get(str);
        }

        public boolean equals(ConditionType conditionType) {
            return this.mConditionType.equals(conditionType.mConditionType);
        }
    }

    public enum Operator {
        EXISTS("exists"),
        NOT_EXISTS("notExists"),
        STR_EQUALS("strEquals"),
        STR_NOT_EQUALS("strNotEquals"),
        STARTS_WITH("startsWith"),
        ENDS_WITH("endsWith"),
        CONTAINS("contains"),
        NOT_CONTAINS("notContaining"),
        NUM_EQUALS("numEquals"),
        NUM_NOT_EQUALS("numNotEquals"),
        LESS_THAN("lessThan"),
        LESS_THAN_OR_EQUALS("lessThanOrEquals"),
        GREATER_THAN("greaterThan"),
        GREATER_THAN_OR_EQUALS("greaterThanOrEquals");

        private static final Map<String, Operator> LOOKUP_TABLE = new HashMap();
        private final String mOperator;

        static {
            for (Operator operator : EnumSet.allOf(Operator.class)) {
                LOOKUP_TABLE.put(operator.mOperator, operator);
            }
        }

        Operator(String str) {
            this.mOperator = str;
        }

        public static Operator get(String str) {
            return LOOKUP_TABLE.get(str);
        }

        public boolean equals(Operator operator) {
            return this.mOperator.equals(operator.mOperator);
        }
    }

    public String getOperator() {
        return this.mOperator;
    }

    public ConditionParam[] getParameters() {
        return this.mParameters;
    }

    public String getType() {
        return this.mType;
    }

    public IdentificationData getTypeValue() {
        return this.mTypeValue;
    }
}
