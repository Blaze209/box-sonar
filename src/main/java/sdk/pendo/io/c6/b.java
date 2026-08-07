package sdk.pendo.io.c6;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import sdk.pendo.io.events.ConditionData;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.s7.c1;
import sdk.pendo.io.s7.d1;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.x0;
import sdk.pendo.io.x1.d;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static synchronized IdentificationData a(View view, IdentificationData identificationData) {
        TextView textViewA;
        IdentificationData.LegacyTexts legacyTexts = identificationData.getLegacyTexts();
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            legacyTexts.setText(((TextView) view).getText().toString());
        }
        if (e1.k(view) && (textViewA = e1.a(view, true)) != null && textViewA.getText() != null && !TextUtils.isEmpty(legacyTexts.getLegacyTextBase64())) {
            legacyTexts.setText(textViewA.getText().toString().trim());
        }
        if (view.isClickable() && TextUtils.isEmpty(legacyTexts.getLegacyTextBase64())) {
            e1.b bVar = new e1.b();
            e1.a(view, true, bVar, true);
            if (bVar.c() != null) {
                legacyTexts.setText(bVar.c().trim());
            }
            if (bVar.a() != null) {
                legacyTexts.setAccessibilityData(bVar.a());
            }
            if (bVar.b() != null && bVar.b().size() > 1) {
                legacyTexts.setNestedTexts(bVar.b());
            }
        }
        String strC = e1.c(view);
        if (!TextUtils.isEmpty(strC) && legacyTexts.getLegacyAccessibilityBase64() == null) {
            legacyTexts.setAccessibilityData(strC);
        }
        return identificationData;
    }

    public static synchronized sdk.pendo.io.c2.b<Boolean, Integer> a(IdentificationData identificationData, IdentificationData identificationData2, boolean z, ConditionData conditionData) {
        d dVarDiff = identificationData.diff(identificationData2);
        int i = 100;
        if (dVarDiff.b() == 0 && !x0.a(conditionData)) {
            return sdk.pendo.io.c2.b.a(Boolean.TRUE, 100);
        }
        Iterator<sdk.pendo.io.x1.b<?>> it = dVarDiff.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String strC = it.next().c();
            if (!IdentificationData.FIELD_PARENT_ID.equals(strC) && !IdentificationData.FIELD_INDEX_IN_PARENT.equals(strC) && ((!IdentificationData.FIELD_ID_OF_PARENTS.equals(strC) || z) && !"id".equals(strC) && !"type".equals(strC) && !"text".equals(strC) && !IdentificationData.RA_PREDICATE.equals(strC) && !"label".equals(strC))) {
                if (IdentificationData.FIELD_CHILD_COUNT.equals(strC)) {
                    i -= 5;
                }
            }
            i = 0;
            break;
        }
        return sdk.pendo.io.c2.b.a(Boolean.valueOf(i >= 70), Integer.valueOf(i));
    }

    public static synchronized IdentificationData a(View view, Boolean bool, Boolean bool2) {
        int iIndexOfChild;
        String strF;
        String strG;
        TextView textViewD;
        IdentificationData identificationData = new IdentificationData();
        if (view == null) {
            return identificationData;
        }
        identificationData.setPredicate(view);
        identificationData.retrieveViewTag(view);
        if (bool.booleanValue()) {
            if ((view instanceof TextView) && !(view instanceof EditText)) {
                identificationData.setText(((TextView) view).getText().toString());
            }
            if (e1.k(view) && (textViewD = e1.d(view)) != null && textViewD.getText() != null && TextUtils.isEmpty(identificationData.getTextBase64())) {
                identificationData.setText(textViewD.getText().toString().trim());
            }
            if (TextUtils.isEmpty(identificationData.getAccessibilityBase64())) {
                String strC = e1.c(view);
                if (!TextUtils.isEmpty(strC)) {
                    identificationData.setAccessibility(strC);
                }
            }
            if (c1.b(view)) {
                e1.b bVar = new e1.b();
                e1.a(view, bool2.booleanValue(), bVar);
                if (bVar.c() != null && TextUtils.isEmpty(identificationData.getTextBase64())) {
                    identificationData.setText(bVar.c().trim());
                }
                if (bVar.a() != null && TextUtils.isEmpty(identificationData.getAccessibilityBase64())) {
                    identificationData.setAccessibility(bVar.a());
                }
                if (bool2.booleanValue() && bVar.b() != null && bVar.b().size() > 1) {
                    identificationData.setNestedTexts(bVar.b());
                }
                if (identificationData.getViewTagBase64() == null && (strG = d1.a.g(view)) != null) {
                    identificationData.setViewTagBase64(strG);
                }
            }
        }
        String strF2 = e1.f(view);
        if (strF2 != null) {
            identificationData.setId(strF2);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if ((parent instanceof View) && (strF = e1.f((View) parent)) != null) {
                arrayList.add(strF);
            }
        }
        identificationData.setIdOfParents(arrayList);
        if (view instanceof ViewGroup) {
            identificationData.setChildCount(((ViewGroup) view).getChildCount());
        }
        if (e1.l(view)) {
            identificationData.setInsideList(true);
        }
        ViewParent parent2 = view.getParent();
        if ((parent2 instanceof ViewGroup) && (iIndexOfChild = ((ViewGroup) parent2).indexOfChild(view)) != -1) {
            identificationData.setIndexInParent(Integer.valueOf(iIndexOfChild));
        }
        if (e1.b()) {
            identificationData.setInsideDrawer(true);
        }
        if (e1.j(view)) {
            identificationData.setIsList(true);
        }
        identificationData.setType(view.getClass().getSimpleName());
        return identificationData;
    }

    public static synchronized IdentificationData a(View view) {
        TextView textViewD;
        CharSequence text;
        if (view == null) {
            return null;
        }
        IdentificationData identificationData = new IdentificationData();
        identificationData.retrieveViewTag(view);
        if ((view instanceof TextView) && !(view instanceof EditText) && (text = ((TextView) view).getText()) != null) {
            identificationData.setText(text.toString());
        }
        if (e1.k(view) && (textViewD = e1.d(view)) != null && textViewD.getText() != null && TextUtils.isEmpty(identificationData.getTextBase64())) {
            identificationData.setText(textViewD.getText().toString().trim());
        }
        if (TextUtils.isEmpty(identificationData.getAccessibilityBase64())) {
            String strC = e1.c(view);
            if (!TextUtils.isEmpty(strC)) {
                identificationData.setAccessibility(strC);
            }
        }
        if (c1.b(view)) {
            e1.b bVar = new e1.b();
            e1.a(view, false, bVar);
            if (bVar.c() != null && TextUtils.isEmpty(identificationData.getTextBase64())) {
                identificationData.setText(bVar.c().trim());
            }
            if (bVar.a() != null && TextUtils.isEmpty(identificationData.getAccessibilityBase64())) {
                identificationData.setAccessibility(bVar.a());
            }
        }
        return identificationData;
    }
}
