package sdk.pendo.io.s7;

import sdk.pendo.io.events.ConditionData;

/* JADX INFO: loaded from: classes5.dex */
public final class x0 {
    public static boolean a(ConditionData conditionData) {
        ConditionData.Operator operator;
        return (conditionData == null || (operator = ConditionData.Operator.get(conditionData.getOperator())) == null || operator.equals(ConditionData.Operator.EXISTS) || operator.equals(ConditionData.Operator.NOT_EXISTS)) ? false : true;
    }
}
