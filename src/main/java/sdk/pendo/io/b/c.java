package sdk.pendo.io.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.ByteArrayInputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.w;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    public b a;
    public EnumC0347c b;
    public Object c;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC0347c.values().length];
            a = iArr;
            try {
                iArr[EnumC0347c.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC0347c.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC0347c.DIMEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC0347c.COLOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumC0347c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumC0347c.BASE64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[EnumC0347c.ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum b {
        NO_VALID,
        ID,
        LAYOUT_WIDTH,
        LAYOUT_HEIGHT,
        PADDING_LEFT,
        PADDING_RIGHT,
        PADDING_TOP,
        PADDING_BOTTOM,
        PADDING,
        INCLUDE_FONT_PADDING,
        LAYOUT_MARGINLEFT,
        LAYOUT_MARGINRIGHT,
        LAYOUT_MARGINTOP,
        LAYOUT_MARGINBOTTOM,
        LAYOUT_MARGIN,
        BACKGROUND,
        ENABLED,
        SELECTED,
        CLICKABLE,
        SCALEX,
        SCALEY,
        LAYOUT_MINWIDTH,
        MINHEIGHT,
        MAXHEIGHT,
        MAXWIDTH,
        ASPECTRATIO,
        MARKDOWNTEXT,
        TEXT,
        ALTTEXT,
        ACCESSIBILITYTEXT,
        SHOULDIGNOREACCESSIBILITY,
        THEMESTYLE,
        TEXTCOLOR,
        TEXTSIZE,
        FONTSTYLE,
        FONTFAMILY,
        ELLIPSIZE,
        MAXLINES,
        GRAVITY,
        DRAWABLETOP,
        DRAWABLEBOTTOM,
        DRAWABLELEFT,
        DRAWABLERIGHT,
        SRC,
        SCALETYPE,
        ADJUSTVIEWBOUNDS,
        VIDEO_ID,
        VIDEO_URL,
        VIDEO_THUMB_URL,
        VIDEO_TITLE,
        AUTOPLAY,
        VIDEO_PROVIDER,
        IMGWIDTH,
        STEPS,
        HINTLOCATION,
        MINVALUEHINTTEXT,
        MAXVALUEHINTTEXT,
        ICONSIZE,
        SELECTEDICON,
        UNSELECTEDICON,
        SELECTEDICONCOLOR,
        UNSELECTEDICONCOLOR,
        SELECTEDICONSIZE,
        SELECTEDTEXTSIZE,
        SELECTEDTEXTSTYLE,
        SELECTEDTEXTFONTFAMILY,
        PADDING_BETWEEN,
        PADDINGLINES,
        LAYOUT_ABOVE,
        LAYOUT_ALIGNBASELINE,
        LAYOUT_ALIGNBOTTOM,
        LAYOUT_ALIGNEND,
        LAYOUT_ALIGNLEFT,
        LAYOUT_ALIGNPARENTBOTTOM,
        LAYOUT_ALIGNPARENTEND,
        LAYOUT_ALIGNPARENTLEFT,
        LAYOUT_ALIGNPARENTRIGHT,
        LAYOUT_ALIGNPARENTSTART,
        LAYOUT_ALIGNPARENTTOP,
        LAYOUT_ALIGNRIGHT,
        LAYOUT_ALIGNSTART,
        LAYOUT_ALIGNTOP,
        LAYOUT_ALIGNWITHPARENTIFMISSING,
        LAYOUT_BELOW,
        LAYOUT_CENTERHORIZONTAL,
        LAYOUT_CENTERINPARENT,
        LAYOUT_CENTERVERTICAL,
        LAYOUT_TOENDOF,
        LAYOUT_TOLEFTOF,
        LAYOUT_TORIGHTOF,
        LAYOUT_TOSTARTOF,
        LAYOUT_GRAVITY,
        LAYOUT_WEIGHT,
        SUM_WEIGHT,
        WEIGHTSUM,
        ORIENTATION,
        VISIBILITY,
        TAG,
        FUNCTION,
        ACTION,
        ACTIONTYPE,
        ONSUBMIT,
        TEXTDIRECTION,
        BACKGROUNDIMAGEURL,
        BACKGROUNDIMAGEFILLTYPE,
        CHECKED,
        CHECKEDBACKGROUND,
        CHECKEDTEXTCOLOR,
        XCOLOR,
        XWIDTH,
        FRAMECOLOR,
        FRAMEWIDTH,
        SELECTEDFRAMECOLOR,
        SELECTEDFRAMEWIDTH,
        CORNERRADIUS,
        SELECTEDCORNERRADIUS,
        TEXTCOLORNORMAL,
        TEXTCOLORPRESSED,
        TEXTCOLORDISABLED,
        BACKGROUNDCOLORNORMAL,
        BACKGROUNDCOLORPRESSED,
        BACKGROUNDCOLORDISABLED,
        HINT,
        TEXTCOLORHINT,
        INPUTTYPE,
        SINGLELINE,
        VALIDATOR,
        POLLTITLEID,
        POLLID,
        VALUE,
        BUTTON_TYPE,
        HR_COLOR,
        ARIALABEL
    }

    /* JADX INFO: renamed from: sdk.pendo.io.b.c$c, reason: collision with other inner class name */
    public enum EnumC0347c {
        NO_VALID,
        STRING,
        DIMEN,
        INTEGER,
        FLOAT,
        ARRAY,
        COLOR,
        REF,
        BOOLEAN,
        BASE64,
        DRAWABLE,
        JSON,
        REGEX
    }

    public c(l lVar) {
        try {
            this.a = g.c(w.a(lVar, "name"));
        } catch (Exception unused) {
            this.a = b.NO_VALID;
        }
        try {
            this.b = g.d(w.a(lVar, "type"));
        } catch (Exception unused2) {
            this.b = EnumC0347c.NO_VALID;
        }
        try {
            this.c = b(lVar.a("value"));
        } catch (Exception e) {
            PendoLogger.e(e, "Dynamic property converting value failure", "jsonObject is: " + lVar);
        }
    }

    private Object b(i iVar) {
        if (iVar == null) {
            return null;
        }
        switch (a.a[this.b.ordinal()]) {
            case 1:
                return Integer.valueOf(iVar.c());
            case 2:
                String strG = iVar.g();
                return (strG.endsWith("dp") || strG.endsWith("sp") || strG.endsWith("px")) ? a(iVar) : Float.valueOf(iVar.b());
            case 3:
                return a(iVar);
            case 4:
                return Integer.valueOf(g.b(iVar.g()));
            case 5:
                String strG2 = iVar.g();
                if (strG2.equalsIgnoreCase("t")) {
                    return Boolean.TRUE;
                }
                if (strG2.equalsIgnoreCase("f")) {
                    return Boolean.FALSE;
                }
                if (strG2.equalsIgnoreCase(TelemetryEventStrings.Value.TRUE)) {
                    return Boolean.TRUE;
                }
                if (strG2.equalsIgnoreCase("false")) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf(Integer.parseInt(strG2) == 1);
            case 6:
                try {
                    return BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(iVar.g(), 0)));
                } catch (Exception unused) {
                    return null;
                }
            case 7:
                try {
                    float[] fArr = new float[8];
                    sdk.pendo.io.a0.f fVarD = iVar.d();
                    if (fVarD != null) {
                        for (int i = 0; i < fVarD.size(); i++) {
                            fArr[i] = fVarD.a(i).b();
                        }
                    }
                    return fArr;
                } catch (Exception unused2) {
                    return null;
                }
            default:
                return iVar;
        }
    }

    public Object a(i iVar) {
        String strG = iVar.g();
        if (strG.equals("auto")) {
            return null;
        }
        b bVar = this.a;
        if (bVar != null) {
            if (bVar.equals(b.IMGWIDTH) && strG.endsWith("%")) {
                return strG;
            }
            if ((this.a.equals(b.TEXTSIZE) || this.a.equals(b.SELECTEDTEXTSIZE)) && strG.endsWith("dp")) {
                return Float.valueOf(strG.replace("dp", ""));
            }
        }
        return Float.valueOf(a(strG));
    }

    Boolean c() {
        return (Boolean) this.c;
    }

    public int d() {
        if (this.b == EnumC0347c.COLOR) {
            return ((Integer) this.c).intValue();
        }
        return -1;
    }

    float e() {
        return ((Float) this.c).floatValue();
    }

    float[] f() {
        return (float[]) this.c;
    }

    Drawable g() {
        return (Drawable) this.c;
    }

    public int h() {
        Object obj = this.c;
        if (!(obj instanceof Integer) && (obj instanceof Float)) {
            return (int) e();
        }
        return ((Integer) obj).intValue();
    }

    JSONObject i() {
        return (JSONObject) this.c;
    }

    public String j() {
        Object obj = this.c;
        return obj instanceof String ? (String) obj : ((i) obj).g();
    }

    public boolean k() {
        Object obj = this.c;
        return (obj instanceof String) && ((String) obj).endsWith("%");
    }

    public boolean l() {
        return this.c != null;
    }

    public String toString() {
        return "DynamicProperty{" + this.b + ":" + this.c + "}";
    }

    public float a(String str) {
        if (str.endsWith("dp")) {
            return sdk.pendo.io.b.a.a(Float.parseFloat(str.replace("dp", "")));
        }
        if (str.endsWith("sp")) {
            return sdk.pendo.io.b.a.b(Float.parseFloat(str.replace("sp", "")));
        }
        if (str.endsWith("px")) {
            return Integer.parseInt(str.replace("px", ""));
        }
        if (str.endsWith("%")) {
            return (int) ((Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f) * sdk.pendo.io.b.a.a());
        }
        if (str.equalsIgnoreCase("match_parent")) {
            return -1.0f;
        }
        if (str.equalsIgnoreCase("wrap_content")) {
            return -2.0f;
        }
        return str.contains(".") ? Float.parseFloat(str) : Integer.parseInt(str);
    }

    Drawable b() {
        return new BitmapDrawable(Resources.getSystem(), a());
    }

    Bitmap a() {
        return (Bitmap) this.c;
    }

    Object a(Class cls, String str) {
        try {
            return cls.getField(str).get(cls);
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder("var name ");
            if (str == null) {
                str = "no var name";
            }
            PendoLogger.e(e, message, sb.append(str).append(" class: ").append(cls != null ? cls.getCanonicalName() : AbstractJsonLexerKt.NULL).toString());
            return null;
        }
    }
}
