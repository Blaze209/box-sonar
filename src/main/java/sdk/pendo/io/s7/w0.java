package sdk.pendo.io.s7;

import android.R;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.react.uimanager.ViewProps;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
public class w0 {
    private static final HashSet<String> a = new HashSet<>(Arrays.asList(ViewProps.PADDING_BOTTOM, ViewProps.PADDING_LEFT, ViewProps.PADDING_RIGHT, ViewProps.PADDING_TOP, "layout_marginBottom", "layout_marginLeft", "layout_marginRight", "layout_marginTop", "layout_minWidth"));

    public static boolean a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ViewGroup) && a((ViewGroup) childAt)) {
                return true;
            }
            if (childAt != null && childAt.isFocusable() && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str) {
        if (!str.endsWith("dp") && !str.endsWith("px")) {
            return null;
        }
        String strReplace = str.replace("dp", "").replace("px", "");
        if (sdk.pendo.io.y1.a.a(strReplace)) {
            return strReplace;
        }
        return null;
    }

    public static String a(String str) {
        int length;
        return (str.startsWith("#") && (length = str.length()) != 4 && length != 7 && length == 9) ? String.format("#%s%s", str.substring(7), str.substring(1, 7)) : str;
    }

    private static sdk.pendo.io.a0.f a(sdk.pendo.io.a0.f fVar) {
        sdk.pendo.io.a0.f fVar2 = new sdk.pendo.io.a0.f();
        fVar2.a(a("layout_width", "dimen", "wrap_content"));
        fVar2.a(a("layout_height", "dimen", "wrap_content"));
        fVar2.a(a("orientation", "string", "vertical"));
        fVar2.a(a("enabled", TypedValues.Custom.S_BOOLEAN, Boolean.TRUE));
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            sdk.pendo.io.a0.l lVarA = a(fVar, it.next());
            if (lVarA != null) {
                fVar2.a(lVarA);
            }
        }
        return fVar2;
    }

    private static sdk.pendo.io.a0.l a(String str, String str2, Object obj) {
        sdk.pendo.io.a0.l lVar = new sdk.pendo.io.a0.l();
        lVar.a("name", str);
        lVar.a("type", str2);
        if (str2.contains("string") || str2.contains("dimen")) {
            lVar.a("value", (String) obj);
            return lVar;
        }
        if (str2.contains(TypedValues.Custom.S_BOOLEAN)) {
            lVar.a("value", (Boolean) obj);
        }
        return lVar;
    }

    public static ViewGroup a(View view) {
        View rootView = view.getRootView();
        if (rootView == null) {
            return null;
        }
        View viewFindViewById = rootView.findViewById(R.id.content);
        if (viewFindViewById instanceof FrameLayout) {
            return (FrameLayout) viewFindViewById;
        }
        if (viewFindViewById instanceof RelativeLayout) {
            return (RelativeLayout) viewFindViewById;
        }
        if (viewFindViewById instanceof ConstraintLayout) {
            return (ConstraintLayout) viewFindViewById;
        }
        PendoLogger.e("TooltipUtils", "The layout hierarchy content is of an unexpected type: " + viewFindViewById, (Throwable) null);
        return null;
    }

    public static int a(String str, int i) {
        return sdk.pendo.io.y1.a.a(str) ? e1.a(Float.parseFloat(str)) : i;
    }

    public static sdk.pendo.io.a0.l a(sdk.pendo.io.a0.f fVar, String str) {
        if (fVar != null && fVar.size() != 0) {
            for (int i = 0; i < fVar.size(); i++) {
                sdk.pendo.io.a0.l lVarE = fVar.a(i).e();
                sdk.pendo.io.a0.n nVarC = lVarE.c("name");
                if (nVarC != null && str.contentEquals(nVarC.g())) {
                    return lVarE;
                }
            }
        }
        return null;
    }

    public static boolean a(Rect rect, Rect rect2) {
        return rect.contains(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    public static boolean a(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean((String) obj);
    }

    public static sdk.pendo.io.a0.l a(sdk.pendo.io.a0.l lVar, GuideActionConfiguration.VisualGuideType visualGuideType) {
        sdk.pendo.io.a0.l lVar2 = new sdk.pendo.io.a0.l();
        lVar2.a("properties", a(lVar.b("properties")));
        lVar2.a(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS, lVar.b(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS));
        lVar2.a("widget", "LinearLayout");
        lVar2.a("id", "insert_container");
        lVar2.a("scrollable", Boolean.valueOf(visualGuideType.equals(GuideActionConfiguration.VisualGuideType.BANNER)));
        return lVar2;
    }
}
