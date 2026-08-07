package sdk.pendo.io.s7;

import android.util.Pair;
import android.view.View;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collections;
import sdk.pendo.io.events.ConditionData;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: loaded from: classes5.dex */
public final class m0 {
    private static void a(View view, StringBuilder sb) {
        Integer numA;
        if (e1.j(view)) {
            return;
        }
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            if (!e1.j(view2) || (numA = e1.a(view2, view)) == null || numA.intValue() == -1) {
                return;
            }
            sb.append("[").append("indexPath=(0,").append(numA).append(")").append("]");
        }
    }

    public static boolean a(IdentificationData identificationData, View view, ConditionData conditionData) {
        Boolean bool = Boolean.FALSE;
        return a(identificationData, sdk.pendo.io.c6.b.a(view, bool, bool), conditionData);
    }

    public static boolean a(IdentificationData identificationData, IdentificationData identificationData2, ConditionData conditionData) {
        String rAPredicate = identificationData.getRAPredicate();
        String rAPredicate2 = identificationData2.getRAPredicate();
        return (rAPredicate2 == null || !rAPredicate2.equals(rAPredicate) || x0.a(conditionData)) ? false : true;
    }

    public static synchronized String a(View view) {
        StringBuilder sb;
        ArrayList<Pair> arrayList = new ArrayList();
        arrayList.add(new Pair(view.getClass().getName(), view));
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            arrayList.add(new Pair(parent.getClass().getName(), parent));
        }
        sb = new StringBuilder();
        Collections.reverse(arrayList);
        for (Pair pair : arrayList) {
            sb.append("[").append((String) pair.first).append("]");
            Object obj = pair.second;
            if (obj instanceof View) {
                a((View) obj, sb);
            }
        }
        return sb.toString();
    }
}
