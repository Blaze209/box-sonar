package sdk.pendo.io.v6;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.events.ComposeIdentificationData;
import sdk.pendo.io.events.TagsIdentifier;
import sdk.pendo.io.listeners.views.OnElementInScreenFoundListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.b1;
import sdk.pendo.io.s7.t;
import sdk.pendo.io.s7.v0;
import sdk.pendo.io.s7.y0;
import sdk.pendo.io.s7.z;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a,\u0010\f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0000\u001a.\u0010\r\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0000\u001a\u0014\u0010\f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tH\u0002\u001a\u0014\u0010\r\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tH\u0002\u001a\u001c\u0010\f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a\u0012\u0010\f\u001a\u00020\u0002*\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\r\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010\u001a\u0012\u0010\f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010\u001a.\u0010\f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t\u001a\u0014\u0010\f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/v6/a;", "composeElement", "", "d", "e", "f", "Lorg/json/JSONArray;", "textsWithElementsInfo", "identifiersWithElementsInfo", "", "includeTexts", "forCapture", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "Lorg/json/JSONObject;", "Landroidx/compose/ui/semantics/SemanticsNode;", "", "layoutNode", "tree", "Lsdk/pendo/io/listeners/views/OnElementInScreenFoundListener;", "onViewFoundListener", "jsonObject", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(a aVar) {
        String strE = a.INSTANCE.e(aVar.e());
        if (v0.a(strE)) {
            return;
        }
        aVar.c(strE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(a aVar) {
        String strG = a.INSTANCE.g(aVar.e());
        if (v0.a(strG)) {
            return;
        }
        aVar.g(strG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(a aVar) {
        if (aVar.getSdk.pendo.io.events.ComposeIdentificationData.PENDO_TAG_HASHED java.lang.String() != null || aVar.e().get("OnClick") != null) {
            aVar.a(true);
            return;
        }
        SemanticsNode semanticsNode = aVar.j().get();
        if (semanticsNode == null || aVar.e().get("ScrollBy") != null) {
            return;
        }
        for (ModifierInfo modifierInfo : semanticsNode.getLayoutInfo().getModifierInfo()) {
            String simpleName = modifierInfo.getModifier().getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            if (StringsKt.contains$default((CharSequence) simpleName, (CharSequence) "PointerInteropFilter", false, 2, (Object) null)) {
                aVar.a(true);
                return;
            }
            String simpleName2 = modifierInfo.getModifier().getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
            if (StringsKt.contains$default((CharSequence) simpleName2, (CharSequence) "PointerInput", false, 2, (Object) null)) {
                if (aVar.e().size() != 1 || aVar.e().get("IsTraversalGroup") == null) {
                    aVar.a(true);
                    return;
                }
                return;
            }
        }
    }

    private static final void a(a aVar, JSONObject jSONObject) {
        try {
            Rect rectA = aVar.getBoundsInScreen();
            if (((int) (rectA.getRight() - rectA.getLeft())) != 0 && ((int) (rectA.getBottom() - rectA.getTop())) != 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("left", Float.valueOf(rectA.getLeft()));
                jSONObject2.put(ViewProps.TOP, Float.valueOf(rectA.getTop()));
                jSONObject2.put("width", Float.valueOf(rectA.getRight() - rectA.getLeft()));
                jSONObject2.put("height", Float.valueOf(rectA.getBottom() - rectA.getTop()));
                jSONObject.put(ViewProps.POSITION, jSONObject2);
            }
        } catch (Exception e) {
            PendoLogger.e("ComposeElement addComposablePositionPropertiesToJson, Exception adding position to json " + e + ", " + e.getMessage(), new Object[0]);
        }
    }

    public static final void b(a aVar, JSONArray textsWithElementsInfo, JSONArray jSONArray, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(textsWithElementsInfo, "textsWithElementsInfo");
        try {
            ComposeIdentificationData composeIdentificationData = new ComposeIdentificationData();
            if (z) {
                b(aVar, z2);
                composeIdentificationData.setTextHashed(aVar.getTextHash());
                composeIdentificationData.setAccessibilityHashed(aVar.getContentDescriptionHash());
                String strCreateTextRetroElementIdentifier = composeIdentificationData.createTextRetroElementIdentifier();
                if (strCreateTextRetroElementIdentifier != null && strCreateTextRetroElementIdentifier.length() != 0) {
                    textsWithElementsInfo.put(y0.a(sdk.pendo.io.v7.a.a.a(strCreateTextRetroElementIdentifier), 8));
                }
            }
            a(aVar, z2);
            if (jSONArray != null) {
                String strI = aVar.getPendoTagHash();
                if (strI != null) {
                    if (StringsKt.isBlank(strI)) {
                        strI = null;
                    }
                    if (strI != null) {
                        jSONArray.put(strI);
                    }
                }
                String strL = aVar.getTestTagHash();
                if (strL != null) {
                    Object obj = StringsKt.isBlank(strL) ? null : strL;
                    if (obj != null) {
                        jSONArray.put(obj);
                    }
                }
            }
        } catch (Exception e) {
            PendoLogger.e("ComposeElement failed to add element texts and or tags, " + e + ", " + e.getStackTrace(), new Object[0]);
        }
    }

    public static final void a(SemanticsNode semanticsNode, a composeElement) {
        Intrinsics.checkNotNullParameter(semanticsNode, "<this>");
        Intrinsics.checkNotNullParameter(composeElement, "composeElement");
        try {
            Field declaredField = SemanticsNode.class.getDeclaredField("layoutNode");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(semanticsNode);
            if (obj != null) {
                b(composeElement, obj);
                a(composeElement, obj);
            }
        } catch (Exception e) {
            PendoLogger.e(e, "ComposeElement addComposeElementInfo failed - " + e.getMessage(), new Object[0]);
        }
    }

    public static final void b(a aVar, Object layoutNode) {
        String strReplace;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        try {
            MeasurePolicy measurePolicyB = aVar.b(layoutNode);
            if (measurePolicyB != null) {
                String name = measurePolicyB.getClass().getName();
                Intrinsics.checkNotNull(name);
                strReplace = StringsKt.startsWith(name, "androidx.compose", true) ? new Regex("\\$\\d.*").replace(name, "") : "CustomLayout";
            } else {
                strReplace = null;
            }
            aVar.f(strReplace);
        } catch (Exception e) {
            PendoLogger.e(e, "ComposeElement getPredicate failed - " + e.getMessage(), new Object[0]);
        }
    }

    public static final void a(a aVar, JSONArray textsWithElementsInfo, JSONArray identifiersWithElementsInfo, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(textsWithElementsInfo, "textsWithElementsInfo");
        Intrinsics.checkNotNullParameter(identifiersWithElementsInfo, "identifiersWithElementsInfo");
        b(aVar, textsWithElementsInfo, identifiersWithElementsInfo, z, z2);
        for (a aVar2 : aVar.c()) {
            Intrinsics.checkNotNull(aVar2);
            a(aVar2, textsWithElementsInfo, identifiersWithElementsInfo, z, z2);
        }
    }

    private static final void b(a aVar, boolean z) {
        a.Companion c0503a = a.INSTANCE;
        String strH = c0503a.h(aVar.e());
        String strA = c0503a.a(aVar.e());
        if (v0.a(strH) && v0.a(strA)) {
            return;
        }
        f fVarA = c0503a.a(strH);
        aVar.k(fVarA.getHashed());
        f fVarA2 = c0503a.a(strA);
        aVar.b(fVarA2.getHashed());
        if (z) {
            aVar.j(fVarA.getEncoded());
            aVar.a(fVarA2.getEncoded());
        }
    }

    public static final void a(a aVar, Object layoutNode) {
        int iA;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        try {
            iA = aVar.a(layoutNode);
        } catch (Exception e) {
            PendoLogger.e(e, "ComposeElement getDepth failed - " + e.getMessage(), new Object[0]);
            iA = -1;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        a aVarG = aVar.getParent();
        if (aVarG != null) {
            arrayList.addAll(aVarG.f());
        }
        if (iA != -1) {
            arrayList.add(Integer.valueOf(iA));
        }
        aVar.a(arrayList);
    }

    private static final JSONObject a(a aVar, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        b(aVar, jSONArray, null, z2, z);
        if (jSONArray.length() > 0) {
            jSONObject.put("retroElementHashesCollection", jSONArray);
        }
        ComposeIdentificationData composeIdentificationDataA = aVar.a(z, z2);
        jSONObject.put("clickable", aVar.getClickable());
        JSONObject jSONObjectCreateRetroElementTexts = composeIdentificationDataA.createRetroElementTexts();
        if (jSONObjectCreateRetroElementTexts != null) {
            jSONObject.put("retroElementTexts", jSONObjectCreateRetroElementTexts);
        }
        jSONObject.put("retroElementInfo", b1.a.a(composeIdentificationDataA.toJSON()));
        if (z) {
            JSONArray jSONArrayCreateTagIdentifiers = composeIdentificationDataA.createTagIdentifiers();
            if (jSONArrayCreateTagIdentifiers.length() > 0) {
                jSONObject.put(TagsIdentifier.FIELD_IDS_ARRAY, jSONArrayCreateTagIdentifiers);
            }
        }
        a(aVar, jSONObject);
        if (!z) {
            SemanticsNode semanticsNode = aVar.j().get();
            if (semanticsNode != null) {
                z.a(jSONObject, "semanticsNode", semanticsNode);
            }
            z.a(jSONObject, "boundsInWindow", aVar.getBoundsInWindow());
        }
        return jSONObject;
    }

    public static final void a(a aVar, JSONArray tree, OnElementInScreenFoundListener onElementInScreenFoundListener, boolean z, boolean z2) throws JSONException {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(tree, "tree");
        JSONObject jSONObjectA = a(aVar, z, z2);
        z.a(tree, jSONObjectA);
        if (onElementInScreenFoundListener != null) {
            onElementInScreenFoundListener.onViewFound(jSONObjectA, new WeakReference<>(null));
        }
        for (a aVar2 : aVar.c()) {
            Intrinsics.checkNotNull(aVar2);
            a(aVar2, tree, onElementInScreenFoundListener, z, z2);
        }
    }

    public static /* synthetic */ void a(a aVar, JSONArray jSONArray, OnElementInScreenFoundListener onElementInScreenFoundListener, boolean z, boolean z2, int i, Object obj) throws JSONException {
        if ((i & 8) != 0) {
            z2 = true;
        }
        a(aVar, jSONArray, onElementInScreenFoundListener, z, z2);
    }

    private static final void a(a aVar, boolean z) {
        String string;
        String string2;
        t tVar = t.a;
        String strA = null;
        aVar.e(t.a(tVar, aVar.getSdk.pendo.io.events.ComposeIdentificationData.PENDO_TAG_HASHED java.lang.String(), false, 2, null));
        aVar.i(t.a(tVar, aVar.getSdk.pendo.io.events.ComposeIdentificationData.FIELD_TEST_TAG_HASHED java.lang.String(), false, 2, null));
        if (z) {
            String strH = aVar.getSdk.pendo.io.events.ComposeIdentificationData.PENDO_TAG_HASHED java.lang.String();
            aVar.d((strH == null || (string2 = StringsKt.trim((CharSequence) strH).toString()) == null) ? null : y0.a(string2));
            String strK = aVar.getSdk.pendo.io.events.ComposeIdentificationData.FIELD_TEST_TAG_HASHED java.lang.String();
            if (strK != null && (string = StringsKt.trim((CharSequence) strK).toString()) != null) {
                strA = y0.a(string);
            }
            aVar.h(strA);
        }
    }
}
