package sdk.pendo.io.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.box.android.capture.documentscanning.logic.TextRecognitionConverter;
import com.facebook.react.uimanager.ViewProps;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.TreeJsonEncoderKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.events.TagsIdentifier;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.PersonalizationDefVal;
import sdk.pendo.io.s7.p;
import sdk.pendo.io.s7.s0;
import sdk.pendo.io.s7.v0;
import sdk.pendo.io.s7.y0;
import sdk.pendo.io.views.custom.ActionableBlock;
import sdk.pendo.io.views.custom.IBackgroundRenderView;
import sdk.pendo.io.views.custom.PendoAbstractRadioButton;
import sdk.pendo.io.views.custom.PendoCheckableCustomView;
import sdk.pendo.io.views.custom.PendoCircularCloseButton;
import sdk.pendo.io.views.custom.PendoCustomView;
import sdk.pendo.io.views.custom.PendoLinearLayout;
import sdk.pendo.io.views.custom.PendoMultipleRowViewGroup;
import sdk.pendo.io.views.custom.PendoRegularRadioButton;
import sdk.pendo.io.views.custom.PendoScrollView;
import sdk.pendo.io.views.custom.VisualActionButton;
import sdk.pendo.io.views.custom.VisualActionImage;
import sdk.pendo.io.views.custom.videoplayer.common.VideoPlayerView;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: sdk.pendo.io.b.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0346a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[c.EnumC0347c.values().length];
            b = iArr;
            try {
                iArr[c.EnumC0347c.DIMEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[c.EnumC0347c.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[c.EnumC0347c.INTEGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[c.EnumC0347c.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[c.EnumC0347c.COLOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[c.EnumC0347c.REF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[c.EnumC0347c.BASE64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[c.EnumC0347c.DRAWABLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[c.b.values().length];
            a = iArr2;
            try {
                iArr2[c.b.ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[c.b.POLLID.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[c.b.TAG.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[c.b.VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[c.b.HR_COLOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[c.b.BACKGROUND.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[c.b.MARKDOWNTEXT.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[c.b.TEXT.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[c.b.TEXTCOLOR.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[c.b.TEXTSIZE.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[c.b.ALTTEXT.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[c.b.ACCESSIBILITYTEXT.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[c.b.SHOULDIGNOREACCESSIBILITY.ordinal()] = 13;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[c.b.THEMESTYLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[c.b.SELECTEDTEXTSIZE.ordinal()] = 15;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[c.b.FONTSTYLE.ordinal()] = 16;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[c.b.PADDING.ordinal()] = 17;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[c.b.PADDING_LEFT.ordinal()] = 18;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[c.b.PADDING_TOP.ordinal()] = 19;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                a[c.b.PADDING_RIGHT.ordinal()] = 20;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                a[c.b.PADDING_BOTTOM.ordinal()] = 21;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                a[c.b.INCLUDE_FONT_PADDING.ordinal()] = 22;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                a[c.b.LAYOUT_MINWIDTH.ordinal()] = 23;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                a[c.b.ELLIPSIZE.ordinal()] = 24;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                a[c.b.MAXLINES.ordinal()] = 25;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                a[c.b.ORIENTATION.ordinal()] = 26;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                a[c.b.SUM_WEIGHT.ordinal()] = 27;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                a[c.b.WEIGHTSUM.ordinal()] = 28;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                a[c.b.GRAVITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                a[c.b.FONTFAMILY.ordinal()] = 30;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                a[c.b.SRC.ordinal()] = 31;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                a[c.b.SCALETYPE.ordinal()] = 32;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                a[c.b.ADJUSTVIEWBOUNDS.ordinal()] = 33;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                a[c.b.DRAWABLELEFT.ordinal()] = 34;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                a[c.b.DRAWABLETOP.ordinal()] = 35;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                a[c.b.DRAWABLERIGHT.ordinal()] = 36;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                a[c.b.DRAWABLEBOTTOM.ordinal()] = 37;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                a[c.b.ENABLED.ordinal()] = 38;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                a[c.b.SELECTED.ordinal()] = 39;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                a[c.b.CLICKABLE.ordinal()] = 40;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                a[c.b.SCALEX.ordinal()] = 41;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                a[c.b.SCALEY.ordinal()] = 42;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                a[c.b.FUNCTION.ordinal()] = 43;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                a[c.b.VISIBILITY.ordinal()] = 44;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                a[c.b.ONSUBMIT.ordinal()] = 45;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                a[c.b.XCOLOR.ordinal()] = 46;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                a[c.b.XWIDTH.ordinal()] = 47;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                a[c.b.FRAMECOLOR.ordinal()] = 48;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                a[c.b.FRAMEWIDTH.ordinal()] = 49;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                a[c.b.SELECTEDFRAMECOLOR.ordinal()] = 50;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                a[c.b.SELECTEDFRAMEWIDTH.ordinal()] = 51;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                a[c.b.TEXTDIRECTION.ordinal()] = 52;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                a[c.b.CHECKED.ordinal()] = 53;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                a[c.b.CHECKEDBACKGROUND.ordinal()] = 54;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                a[c.b.CHECKEDTEXTCOLOR.ordinal()] = 55;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                a[c.b.BACKGROUNDIMAGEURL.ordinal()] = 56;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                a[c.b.BACKGROUNDIMAGEFILLTYPE.ordinal()] = 57;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                a[c.b.HINT.ordinal()] = 58;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                a[c.b.VALIDATOR.ordinal()] = 59;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                a[c.b.TEXTCOLORHINT.ordinal()] = 60;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                a[c.b.SINGLELINE.ordinal()] = 61;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                a[c.b.INPUTTYPE.ordinal()] = 62;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                a[c.b.CORNERRADIUS.ordinal()] = 63;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                a[c.b.SELECTEDCORNERRADIUS.ordinal()] = 64;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                a[c.b.TEXTCOLORNORMAL.ordinal()] = 65;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                a[c.b.TEXTCOLORPRESSED.ordinal()] = 66;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                a[c.b.TEXTCOLORDISABLED.ordinal()] = 67;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                a[c.b.BACKGROUNDCOLORNORMAL.ordinal()] = 68;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                a[c.b.BACKGROUNDCOLORPRESSED.ordinal()] = 69;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                a[c.b.BACKGROUNDCOLORDISABLED.ordinal()] = 70;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                a[c.b.ICONSIZE.ordinal()] = 71;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                a[c.b.SELECTEDICONSIZE.ordinal()] = 72;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                a[c.b.SELECTEDICON.ordinal()] = 73;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                a[c.b.UNSELECTEDICON.ordinal()] = 74;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                a[c.b.SELECTEDICONCOLOR.ordinal()] = 75;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                a[c.b.UNSELECTEDICONCOLOR.ordinal()] = 76;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                a[c.b.PADDING_BETWEEN.ordinal()] = 77;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                a[c.b.PADDINGLINES.ordinal()] = 78;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                a[c.b.ASPECTRATIO.ordinal()] = 79;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                a[c.b.VIDEO_URL.ordinal()] = 80;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                a[c.b.VIDEO_ID.ordinal()] = 81;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                a[c.b.AUTOPLAY.ordinal()] = 82;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                a[c.b.IMGWIDTH.ordinal()] = 83;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                a[c.b.ARIALABEL.ordinal()] = 84;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                a[c.b.LAYOUT_HEIGHT.ordinal()] = 85;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                a[c.b.LAYOUT_WIDTH.ordinal()] = 86;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                a[c.b.MAXWIDTH.ordinal()] = 87;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                a[c.b.MINHEIGHT.ordinal()] = 88;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                a[c.b.LAYOUT_MARGIN.ordinal()] = 89;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                a[c.b.LAYOUT_MARGINLEFT.ordinal()] = 90;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                a[c.b.LAYOUT_MARGINTOP.ordinal()] = 91;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                a[c.b.LAYOUT_MARGINRIGHT.ordinal()] = 92;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                a[c.b.LAYOUT_MARGINBOTTOM.ordinal()] = 93;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                a[c.b.LAYOUT_ABOVE.ordinal()] = 94;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                a[c.b.LAYOUT_BELOW.ordinal()] = 95;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                a[c.b.LAYOUT_TOLEFTOF.ordinal()] = 96;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                a[c.b.LAYOUT_TORIGHTOF.ordinal()] = 97;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                a[c.b.LAYOUT_TOSTARTOF.ordinal()] = 98;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                a[c.b.LAYOUT_TOENDOF.ordinal()] = 99;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                a[c.b.LAYOUT_ALIGNBASELINE.ordinal()] = 100;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                a[c.b.LAYOUT_ALIGNLEFT.ordinal()] = 101;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                a[c.b.LAYOUT_ALIGNTOP.ordinal()] = 102;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                a[c.b.LAYOUT_ALIGNRIGHT.ordinal()] = 103;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                a[c.b.LAYOUT_ALIGNBOTTOM.ordinal()] = 104;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                a[c.b.LAYOUT_ALIGNSTART.ordinal()] = 105;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                a[c.b.LAYOUT_ALIGNEND.ordinal()] = 106;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                a[c.b.LAYOUT_ALIGNWITHPARENTIFMISSING.ordinal()] = 107;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                a[c.b.LAYOUT_ALIGNPARENTTOP.ordinal()] = 108;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                a[c.b.LAYOUT_ALIGNPARENTBOTTOM.ordinal()] = 109;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                a[c.b.LAYOUT_ALIGNPARENTLEFT.ordinal()] = 110;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                a[c.b.LAYOUT_ALIGNPARENTRIGHT.ordinal()] = 111;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                a[c.b.LAYOUT_ALIGNPARENTSTART.ordinal()] = 112;
            } catch (NoSuchFieldError unused120) {
            }
            try {
                a[c.b.LAYOUT_ALIGNPARENTEND.ordinal()] = 113;
            } catch (NoSuchFieldError unused121) {
            }
            try {
                a[c.b.LAYOUT_CENTERHORIZONTAL.ordinal()] = 114;
            } catch (NoSuchFieldError unused122) {
            }
            try {
                a[c.b.LAYOUT_CENTERVERTICAL.ordinal()] = 115;
            } catch (NoSuchFieldError unused123) {
            }
            try {
                a[c.b.LAYOUT_CENTERINPARENT.ordinal()] = 116;
            } catch (NoSuchFieldError unused124) {
            }
            try {
                a[c.b.LAYOUT_GRAVITY.ordinal()] = 117;
            } catch (NoSuchFieldError unused125) {
            }
            try {
                a[c.b.LAYOUT_WEIGHT.ordinal()] = 118;
            } catch (NoSuchFieldError unused126) {
            }
        }
    }

    private static void A(View view, c cVar) {
        if ((view instanceof TextView) && c.EnumC0347c.BOOLEAN == cVar.b) {
            ((TextView) view).setIncludeFontPadding(cVar.c().booleanValue());
        }
    }

    private static void B(View view, c cVar) {
        if (view instanceof EditText) {
            ((EditText) view).setInputType(a(cVar.j()));
        }
    }

    private static void C(View view, c cVar) {
        if (view instanceof TextView) {
            ((TextView) view).setMaxLines(cVar.h());
        }
    }

    private static void D(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0347c.DIMEN) {
            return;
        }
        view.setMinimumHeight(cVar.h());
    }

    private static void E(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0347c.DIMEN) {
            return;
        }
        view.setMinimumWidth(cVar.h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void F(View view, c cVar) {
        if ((view instanceof ActionableBlock) && cVar.b.equals(c.EnumC0347c.STRING)) {
            ((ActionableBlock) view).setOnSubmit(cVar.j());
        }
    }

    private static void G(View view, c cVar) {
        if (view instanceof LinearLayout) {
            int i = C0346a.b[cVar.b.ordinal()];
            if (i == 3) {
                ((LinearLayout) view).setOrientation(cVar.h() == 0 ? 0 : 1);
            } else {
                if (i != 4) {
                    return;
                }
                ((LinearLayout) view).setOrientation(!cVar.j().equalsIgnoreCase("HORIZONTAL") ? 1 : 0);
            }
        }
    }

    private static void H(View view, c cVar) {
        if (view == null || (view instanceof ScrollView) || cVar.b != c.EnumC0347c.DIMEN) {
            return;
        }
        int iH = cVar.h();
        view.setPadding(iH, iH, iH, iH);
    }

    private static void I(View view, c cVar) {
        if (cVar.b == c.EnumC0347c.DIMEN) {
            if (view instanceof PendoRegularRadioButton) {
                ((PendoRegularRadioButton) view).setPaddingBetween(cVar.h());
            } else if (view instanceof PendoMultipleRowViewGroup) {
                ((PendoMultipleRowViewGroup) view).setPaddingBetween(cVar.h());
            }
        }
    }

    private static void J(View view, c cVar) {
        if ((view instanceof PendoMultipleRowViewGroup) && cVar.b == c.EnumC0347c.DIMEN) {
            ((PendoMultipleRowViewGroup) view).setPaddingLines(cVar.h());
        }
    }

    private static void K(View view, c cVar) {
        if ((view instanceof ImageView) && cVar.b == c.EnumC0347c.STRING) {
            ((ImageView) view).setScaleType(ImageView.ScaleType.valueOf(cVar.j().toUpperCase(Locale.US)));
        }
    }

    private static void L(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0347c.BOOLEAN) {
            return;
        }
        view.setScaleX(cVar.e());
    }

    private static void M(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0347c.BOOLEAN) {
            return;
        }
        view.setScaleY(cVar.e());
    }

    private static void N(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0347c.BOOLEAN) {
            return;
        }
        view.setSelected(cVar.c().booleanValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void O(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0347c.DIMEN) {
            ((PendoCheckableCustomView) view).setSelectedCornerRadius(cVar.e());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void P(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0347c.COLOR) && (view instanceof PendoCheckableCustomView)) {
            ((PendoCheckableCustomView) view).setSelectedStrokeColor(cVar.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void Q(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0347c.DIMEN) && (view instanceof PendoCheckableCustomView)) {
            ((PendoCheckableCustomView) view).setSelectedStrokeWidth(cVar.h());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void R(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0347c.STRING) {
            ((PendoCheckableCustomView) view).setSelectedIcon(cVar.j());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void S(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0347c.COLOR) {
            ((PendoCheckableCustomView) view).setSelectedIconColor(cVar.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void T(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0347c.DIMEN) {
            ((PendoCheckableCustomView) view).setSelectedIconSize(cVar.h());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void U(View view, c cVar) {
        if (cVar.b == c.EnumC0347c.DIMEN && (view instanceof PendoCheckableCustomView)) {
            ((PendoCheckableCustomView) view).setSelectedTextSize(cVar.e());
        }
    }

    private static void V(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0347c.BOOLEAN) && cVar.c().booleanValue()) {
            view.setImportantForAccessibility(2);
        }
    }

    private static void W(View view, c cVar) {
        if (view instanceof EditText) {
            ((EditText) view).setSingleLine(cVar.c().booleanValue());
        }
    }

    private static void X(View view, c cVar) {
        if ((view instanceof VisualActionImage) && cVar.b.equals(c.EnumC0347c.STRING)) {
            ((VisualActionImage) view).setResourceURL(cVar.j());
            return;
        }
        if (view instanceof ImageView) {
            int i = C0346a.b[cVar.b.ordinal()];
            if (i == 6) {
                ((ImageView) view).setImageResource(a(view.getContext(), cVar.j()));
            } else {
                if (i != 7) {
                    return;
                }
                ((ImageView) view).setImageBitmap(cVar.a());
            }
        }
    }

    private static void Y(View view, c cVar) {
        view.setTag(cVar.j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void Z(View view, c cVar) {
        if (cVar.b == c.EnumC0347c.COLOR) {
            int iD = cVar.d();
            if (view instanceof PendoCheckableCustomView) {
                ((PendoCheckableCustomView) view).setDefaultTextColor(iD);
            } else if (view instanceof TextView) {
                ((TextView) view).setTextColor(iD);
            }
        }
    }

    private static void a(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0347c.STRING)) {
            String strJ = null;
            try {
                strJ = cVar.j();
            } catch (Exception e) {
                PendoLogger.d("DynamicHelperfailed to get string value for accessibilityText with error: " + e, new Object[0]);
            } finally {
                if (!TextUtils.isEmpty(null)) {
                    view.setContentDescription(null);
                }
            }
        }
    }

    private static void a0(View view, c cVar) {
        if ((view instanceof VisualActionButton) && cVar.b.equals(c.EnumC0347c.COLOR)) {
            ((VisualActionButton) view).setDisabledTextColor(cVar.d());
        }
    }

    private static void b(View view, c cVar) {
        try {
            if ("title".equalsIgnoreCase(cVar.j())) {
                ViewCompat.setAccessibilityHeading(view, true);
            }
        } catch (Exception e) {
            PendoLogger.d(e, "%s: applyAccessibilityHeading", "DynamicHelper");
        }
    }

    private static void b0(View view, c cVar) {
        if ((view instanceof VisualActionButton) && cVar.b.equals(c.EnumC0347c.COLOR)) {
            ((VisualActionButton) view).setNormalTextColor(cVar.d());
        }
    }

    private static void c(View view, c cVar) {
        if ((view instanceof ImageView) && cVar.b == c.EnumC0347c.BOOLEAN) {
            ((ImageView) view).setAdjustViewBounds(cVar.c().booleanValue());
        }
    }

    private static void c0(View view, c cVar) {
        if ((view instanceof VisualActionButton) && cVar.b.equals(c.EnumC0347c.COLOR)) {
            ((VisualActionButton) view).setPressedTextColor(cVar.d());
        }
    }

    public static void d(View view, c cVar) {
        if (view instanceof ViewGroup) {
            try {
                String strJ = cVar.b.equals(c.EnumC0347c.STRING) ? cVar.j() : null;
                if (v0.a(strJ)) {
                    PendoLogger.d("DynamicHelper applyAriaLabel value is empty or null", new Object[0]);
                    return;
                }
                Context context = view.getContext();
                if (context instanceof PendoGuideVisualActivity) {
                    ((PendoGuideVisualActivity) context).setTitle(strJ);
                } else {
                    ViewCompat.setAccessibilityPaneTitle(view, strJ);
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
            } catch (Exception e) {
                PendoLogger.d(e, "%s applyAriaLabel Message: %s", "DynamicHelper", e.getMessage());
            }
        }
    }

    private static void d0(View view, c cVar) {
        if (!"rtl".equals(cVar.j())) {
            view.setLayoutDirection(0);
            return;
        }
        if (view instanceof PendoRegularRadioButton) {
            ((PendoRegularRadioButton) view).setRtl(true);
        }
        view.setLayoutDirection(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void e(View view, c cVar) {
        if ((view instanceof VideoPlayerView) && cVar.b == c.EnumC0347c.STRING) {
            ((VideoPlayerView) view).setAspectRatio(cVar.j());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void e0(View view, c cVar) {
        if (cVar.b == c.EnumC0347c.DIMEN) {
            if (view instanceof PendoCheckableCustomView) {
                ((PendoCheckableCustomView) view).setDefaultTextSize(cVar.e());
            } else if (view instanceof TextView) {
                ((TextView) view).setTextSize(2, cVar.e());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void f(View view, c cVar) {
        if ((view instanceof VideoPlayerView) && cVar.b == c.EnumC0347c.BOOLEAN) {
            ((VideoPlayerView) view).setAutoPlay(cVar.c().booleanValue());
        }
    }

    private static void f0(View view, c cVar) {
        if (view instanceof TextView) {
            int i = C0346a.b[cVar.b.ordinal()];
            if (i == 3) {
                ((TextView) view).setTypeface(null, cVar.h());
                return;
            }
            if (i != 4) {
                return;
            }
            String strJ = cVar.j();
            TextView textView = (TextView) view;
            if ("bold".equals(strJ)) {
                textView.setTypeface(null, 1);
                return;
            }
            if ("italic".equals(strJ)) {
                textView.setTypeface(null, 2);
            } else if ("bold_italic".equals(strJ)) {
                textView.setTypeface(null, 3);
            } else if ("underline".equals(strJ)) {
                textView.setPaintFlags(textView.getPaintFlags() | 8);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void g(View view, c cVar) {
        if (view != 0) {
            int i = C0346a.b[cVar.b.ordinal()];
            if (i == 5) {
                int iD = cVar.d();
                if (view instanceof PendoCircularCloseButton) {
                    ((PendoCircularCloseButton) view).setCircleColor(iD);
                    return;
                } else if (view instanceof PendoCheckableCustomView) {
                    ((PendoCheckableCustomView) view).setDefaultBackgroundColor(iD);
                    return;
                } else {
                    view.setBackgroundColor(iD);
                    return;
                }
            }
            if (i == 6) {
                view.setBackgroundResource(a(view.getContext(), cVar.j()));
            } else if (i == 7) {
                view.setBackground(cVar.b());
            } else {
                if (i != 8) {
                    return;
                }
                view.setBackground(cVar.g());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void g0(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0347c.STRING) {
            ((PendoCheckableCustomView) view).setUnselectedIcon(cVar.j());
        }
    }

    private static void h(View view, c cVar) {
        if ((view instanceof VisualActionButton) && cVar.b.equals(c.EnumC0347c.COLOR)) {
            ((VisualActionButton) view).setDisabledBackgroundColor(cVar.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void h0(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0347c.COLOR) {
            ((PendoCheckableCustomView) view).setUnselectedIconColor(cVar.d());
        }
    }

    private static void i(View view, c cVar) {
        if ((view instanceof VisualActionButton) && cVar.b.equals(c.EnumC0347c.COLOR)) {
            ((VisualActionButton) view).setNormalBackgroundColor(cVar.d());
        }
    }

    private static void i0(View view, c cVar) {
    }

    private static void j(View view, c cVar) {
        if ((view instanceof VisualActionButton) && cVar.b.equals(c.EnumC0347c.COLOR)) {
            ((VisualActionButton) view).setPressedBackgroundColor(cVar.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void j0(View view, c cVar) {
        if ((view instanceof VideoPlayerView) && cVar.b == c.EnumC0347c.STRING) {
            ((VideoPlayerView) view).setVideoId(cVar.j());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void k(View view, c cVar) {
        if (view instanceof IBackgroundRenderView) {
            ((IBackgroundRenderView) view).setImageBackgroundURL(cVar.j());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void k0(View view, c cVar) {
        if ((view instanceof VideoPlayerView) && cVar.b == c.EnumC0347c.STRING) {
            ((VideoPlayerView) view).setVideoUrl(cVar.j());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void l(View view, c cVar) {
        if (view instanceof IBackgroundRenderView) {
            ((IBackgroundRenderView) view).setImageFillType(cVar.j());
        }
    }

    private static void l0(View view, c cVar) {
        int i;
        String strJ = cVar.j();
        if (strJ == null) {
            return;
        }
        if (strJ.equalsIgnoreCase("removed") || strJ.equalsIgnoreCase("gone")) {
            i = 8;
        } else if (strJ.equals(ViewProps.HIDDEN)) {
            i = 4;
        } else if (!strJ.equals(ViewProps.VISIBLE)) {
            return;
        } else {
            i = 0;
        }
        view.setVisibility(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void m(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0347c.COLOR) && (view instanceof PendoCheckableCustomView)) {
            ((PendoCheckableCustomView) view).setCheckedBackgroundColor(cVar.d());
        }
    }

    private static void m0(View view, c cVar) {
        if ((view instanceof LinearLayout) && cVar.b == c.EnumC0347c.FLOAT) {
            ((LinearLayout) view).setWeightSum(cVar.e());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void n(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0347c.COLOR) && (view instanceof PendoCheckableCustomView)) {
            ((PendoCheckableCustomView) view).setCheckedTextColor(cVar.d());
        }
    }

    private static void n0(View view, c cVar) {
        if ((view instanceof PendoCircularCloseButton) && cVar.b.equals(c.EnumC0347c.COLOR)) {
            ((PendoCircularCloseButton) view).setXColor(cVar.d());
        }
    }

    private static void o(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0347c.BOOLEAN) {
            return;
        }
        view.setClickable(cVar.c().booleanValue());
    }

    private static void o0(View view, c cVar) {
        if ((view instanceof PendoCircularCloseButton) && cVar.b.equals(c.EnumC0347c.DIMEN)) {
            ((PendoCircularCloseButton) view).setXWidth(cVar.h());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void p(View view, c cVar) {
        if (view instanceof PendoCustomView) {
            int i = C0346a.b[cVar.b.ordinal()];
            if (i == 1) {
                ((PendoCustomView) view).setCornerRadius(cVar.e());
            } else {
                if (i != 2) {
                    return;
                }
                ((PendoCustomView) view).setCornerRadii(cVar.f());
            }
        }
    }

    private static void q(View view, c cVar) {
        if (view instanceof TextView) {
            ((TextView) view).setEllipsize(TextUtils.TruncateAt.valueOf(cVar.j().toUpperCase(Locale.US).trim()));
        }
    }

    private static void r(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0347c.BOOLEAN) {
            return;
        }
        view.setEnabled(cVar.c().booleanValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void s(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0347c.COLOR) && (view instanceof PendoCustomView)) {
            ((PendoCustomView) view).setStrokeColor(cVar.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void t(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0347c.DIMEN) && (view instanceof PendoCustomView)) {
            ((PendoCustomView) view).setStrokeWidth(cVar.h());
        }
    }

    private static void u(View view, c cVar) {
        Class<?>[] clsArr;
        Object[] array;
        if (cVar.b == c.EnumC0347c.JSON) {
            try {
                JSONObject jSONObjectI = cVar.i();
                String string = jSONObjectI.getString("function");
                JSONArray jSONArray = jSONObjectI.getJSONArray("args");
                if (jSONArray == null) {
                    clsArr = new Class[0];
                    array = new Object[0];
                } else {
                    try {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            boolean zHas = jSONObject.has(TreeJsonEncoderKt.PRIMITIVE_TAG);
                            String string2 = jSONObject.getString(zHas ? TreeJsonEncoderKt.PRIMITIVE_TAG : TextRecognitionConverter.Attributes.CLASS);
                            if (!string2.contains(".")) {
                                string2 = "java.lang." + string2;
                            }
                            Class<?> cls = Class.forName(string2);
                            if (zHas) {
                                arrayList.add((Class) cls.getField(CredentialProviderBaseController.TYPE_TAG).get(null));
                            } else {
                                arrayList.add(cls);
                            }
                            try {
                                arrayList2.add(a(jSONObject, "value", cls));
                            } catch (Exception e) {
                                PendoLogger.e(e, e.getMessage(), "class: " + cls.getCanonicalName());
                            }
                        }
                        clsArr = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
                        array = arrayList2.toArray(new Object[arrayList2.size()]);
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused) {
                        clsArr = new Class[0];
                        array = new Object[0];
                    }
                }
                try {
                    view.getClass().getMethod(string, clsArr).invoke(view, array);
                } catch (NoSuchMethodException e3) {
                    PendoLogger.e(e3, e3.getMessage(), new Object[0]);
                } catch (SecurityException e4) {
                    PendoLogger.e(e4, e4.getMessage(), new Object[0]);
                }
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception e6) {
                PendoLogger.e(e6, e6.getMessage(), new Object[0]);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        if (r0 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        if (r0 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        ((android.widget.TextView) r3).setGravity(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0057, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
    
        ((android.widget.RelativeLayout) r3).setGravity(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void v(android.view.View r3, sdk.pendo.io.b.c r4) {
        /*
            boolean r0 = r3 instanceof android.widget.TextView
            if (r0 != 0) goto Lc
            boolean r1 = r3 instanceof android.widget.LinearLayout
            if (r1 != 0) goto Lc
            boolean r1 = r3 instanceof android.widget.RelativeLayout
            if (r1 == 0) goto L1c
        Lc:
            int[] r1 = sdk.pendo.io.b.a.C0346a.b
            sdk.pendo.io.b.c$c r2 = r4.b
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 3
            if (r1 == r2) goto L36
            r2 = 4
            if (r1 == r2) goto L1d
        L1c:
            return
        L1d:
            java.lang.String r1 = r4.j()
            java.lang.Integer r4 = a(r4, r1)
            int r4 = r4.intValue()
            boolean r1 = r3 instanceof sdk.pendo.io.views.custom.PendoAbstractRadioButton
            if (r1 == 0) goto L2e
            goto L3e
        L2e:
            boolean r1 = r3 instanceof android.widget.LinearLayout
            if (r1 == 0) goto L33
            goto L4a
        L33:
            if (r0 == 0) goto L58
            goto L52
        L36:
            int r4 = r4.h()
            boolean r1 = r3 instanceof sdk.pendo.io.views.custom.PendoAbstractRadioButton
            if (r1 == 0) goto L46
        L3e:
            sdk.pendo.io.views.custom.PendoAbstractRadioButton r3 = (sdk.pendo.io.views.custom.PendoAbstractRadioButton) r3
            r4 = r4 | 16
            r3.setGravity(r4)
            return
        L46:
            boolean r1 = r3 instanceof android.widget.LinearLayout
            if (r1 == 0) goto L50
        L4a:
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r3.setGravity(r4)
            return
        L50:
            if (r0 == 0) goto L58
        L52:
            android.widget.TextView r3 = (android.widget.TextView) r3
            r3.setGravity(r4)
            return
        L58:
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r3.setGravity(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.b.a.v(android.view.View, sdk.pendo.io.b.c):void");
    }

    private static void w(View view, c cVar) {
        if (view instanceof EditText) {
            ((EditText) view).setHint(cVar.j());
        }
    }

    private static void x(View view, c cVar) {
        if ((view instanceof EditText) && cVar.b.equals(c.EnumC0347c.COLOR)) {
            ((EditText) view).setHintTextColor(cVar.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void y(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0347c.DIMEN) {
            ((PendoCheckableCustomView) view).setIconSize(cVar.h());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void z(View view, c cVar) {
        if ((view instanceof VideoPlayerView) && cVar.b == c.EnumC0347c.DIMEN && cVar.k()) {
            String strReplace = cVar.j().replace("%", "");
            try {
                ((VideoPlayerView) view).setImageWidthInPercents(Integer.parseInt(strReplace));
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), "applyImageWidth with " + strReplace);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view, Map<String, c> map) {
        for (c cVar : map.values()) {
            int i = C0346a.a[cVar.a.ordinal()];
            if (i == 2 || i == 3) {
                Y(view, cVar);
            } else if (i == 6) {
                g(view, cVar);
            } else if (i == 23) {
                E(view, cVar);
            } else if (i == 63) {
                p(view, cVar);
            } else if (i == 11 || i == 12) {
                a(view, cVar);
            } else if (i == 32) {
                K(view, cVar);
            } else if (i == 33) {
                c(view, cVar);
            } else if (i == 48) {
                s(view, cVar);
            } else if (i == 49) {
                t(view, cVar);
            } else if (i == 56) {
                k(view, cVar);
            } else if (i != 57) {
                switch (i) {
                    case 26:
                        G(view, cVar);
                        break;
                    case 27:
                    case 28:
                        m0(view, cVar);
                        break;
                }
            } else {
                l(view, cVar);
            }
        }
        if (view instanceof PendoCustomView) {
            ((PendoCustomView) view).renderView();
        }
    }

    private static void b(View view, c cVar, int i) {
        if (view == null || (view instanceof ScrollView) || cVar.b != c.EnumC0347c.DIMEN) {
            return;
        }
        int[] iArr = new int[4];
        iArr[0] = view.getPaddingLeft();
        iArr[1] = view.getPaddingTop();
        iArr[2] = view.getPaddingRight();
        iArr[3] = view.getPaddingBottom();
        iArr[i] = cVar.h();
        view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    private static void a(View view, c cVar, boolean z) {
        if ((view instanceof CompoundButton) && cVar.b == c.EnumC0347c.BOOLEAN) {
            if ((view instanceof RadioButton) && z) {
                view.setId(View.generateViewId());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("elementType", "RadioButton");
                    jSONObject.put("error", "No ID for RadioButton!");
                } catch (JSONException unused) {
                }
                sdk.pendo.io.s7.d.a(sdk.pendo.io.r5.g.b.ERROR_REASON_CONFIGURATION, jSONObject);
            }
            ((CompoundButton) view).setChecked(cVar.c().booleanValue());
        }
    }

    private static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static void a(View view, c cVar, int i) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            int i2 = C0346a.b[cVar.b.ordinal()];
            if (i2 == 6) {
                try {
                    compoundDrawables[i] = view.getContext().getResources().getDrawable(a(view.getContext(), cVar.j()));
                } catch (Exception unused) {
                }
            } else if (i2 == 7) {
                compoundDrawables[i] = cVar.b();
            } else if (i2 == 8) {
                compoundDrawables[i] = cVar.g();
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    private static int b(Context context, String str) {
        return context.getResources().getIdentifier(str, "string", context.getPackageName());
    }

    private static void a(View view, c cVar, c cVar2) {
        c.EnumC0347c enumC0347c;
        String strJ = cVar.j();
        if ((view instanceof TextView) && (enumC0347c = cVar.b) != null && enumC0347c.equals(c.EnumC0347c.STRING)) {
            try {
                if (y0.d(strJ)) {
                    JSONArray jSONArray = new JSONArray(strJ);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (p.a(jSONArray.get(i).toString(), (TextView) view).booleanValue()) {
                            return;
                        }
                    }
                } else if (!y0.e(strJ) && p.a(strJ, (TextView) view).booleanValue()) {
                    return;
                }
            } catch (JSONException e) {
                PendoLogger.e(e, e.getMessage(), "font family: " + strJ);
            }
            p.a(strJ, cVar2, (TextView) view);
        }
    }

    public static float b(float f) {
        return TypedValue.applyDimension(2, f, Resources.getSystem().getDisplayMetrics());
    }

    static void a(View view, Map<String, c> map, ViewGroup viewGroup, HashMap<String, Integer> map2) {
        RelativeLayout.LayoutParams layoutParams;
        int iIntValue;
        RadioGroup.LayoutParams layoutParams2;
        int iIntValue2;
        if (viewGroup == null) {
            return;
        }
        boolean z = viewGroup instanceof ScrollView;
        ViewGroup.LayoutParams layoutParamsA = a(viewGroup);
        for (c cVar : map.values()) {
            try {
                int i = 4;
                switch (C0346a.a[cVar.a.ordinal()]) {
                    case 85:
                        c cVar2 = map.get(c.b.MAXHEIGHT.name());
                        layoutParamsA.height = a(cVar.h(), cVar2 != null ? cVar2.h() : 0);
                        continue;
                    case 86:
                        layoutParamsA.width = cVar.h();
                        continue;
                    case 87:
                        a(view, z, cVar);
                        continue;
                    case 88:
                        D(view, cVar);
                        continue;
                    case 89:
                        a(layoutParamsA, z, cVar);
                        continue;
                    case 90:
                        a(layoutParamsA, z, cVar, 0);
                        continue;
                    case 91:
                        a(layoutParamsA, z, cVar, 1);
                        continue;
                    case 92:
                        a(layoutParamsA, z, cVar, 2);
                        continue;
                    case 93:
                        a(layoutParamsA, z, cVar, 3);
                        continue;
                    case 94:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            i = 2;
                            break;
                        }
                        break;
                    case 95:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            i = 3;
                            break;
                        }
                        break;
                    case 96:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            i = 0;
                            break;
                        }
                        break;
                    case 97:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            i = 1;
                            break;
                        }
                        break;
                    case 98:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            i = 16;
                            break;
                        }
                        break;
                    case 99:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            i = 17;
                            break;
                        }
                        break;
                    case 100:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            break;
                        }
                        break;
                    case 101:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            i = 5;
                            break;
                        }
                        break;
                    case 102:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            i = 6;
                            break;
                        }
                        break;
                    case 103:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            i = 7;
                            break;
                        }
                        break;
                    case 104:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            i = 8;
                            break;
                        }
                        break;
                    case 105:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            i = 18;
                            break;
                        }
                        break;
                    case 106:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            layoutParams = (RelativeLayout.LayoutParams) layoutParamsA;
                            iIntValue = map2.get(cVar.j()).intValue();
                            i = 19;
                            break;
                        }
                        break;
                    case 107:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) layoutParamsA).alignWithParent = cVar.c().booleanValue();
                        } else {
                            continue;
                        }
                        break;
                    case 108:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) layoutParamsA).addRule(10);
                        } else {
                            continue;
                        }
                        break;
                    case 109:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) layoutParamsA).addRule(12);
                        } else {
                            continue;
                        }
                        break;
                    case 110:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) layoutParamsA).addRule(9);
                        } else {
                            continue;
                        }
                        break;
                    case 111:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) layoutParamsA).addRule(11);
                        } else {
                            continue;
                        }
                        break;
                    case 112:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) layoutParamsA).addRule(20);
                        } else {
                            continue;
                        }
                        break;
                    case 113:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) layoutParamsA).addRule(21);
                        } else {
                            continue;
                        }
                        break;
                    case 114:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) layoutParamsA).addRule(14);
                        } else {
                            continue;
                        }
                        break;
                    case 115:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) layoutParamsA).addRule(15);
                        } else {
                            continue;
                        }
                        break;
                    case 116:
                        if (layoutParamsA instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) layoutParamsA).addRule(13);
                        } else {
                            continue;
                        }
                        break;
                    case 117:
                        if (z) {
                            continue;
                        } else {
                            int i2 = C0346a.b[cVar.b.ordinal()];
                            if (i2 == 3) {
                                if (layoutParamsA instanceof LinearLayout.LayoutParams) {
                                    ((LinearLayout.LayoutParams) layoutParamsA).gravity = cVar.h();
                                }
                                if (layoutParamsA instanceof FrameLayout.LayoutParams) {
                                    ((FrameLayout.LayoutParams) layoutParamsA).gravity = cVar.h();
                                }
                                if (layoutParamsA instanceof RadioGroup.LayoutParams) {
                                    layoutParams2 = (RadioGroup.LayoutParams) layoutParamsA;
                                    iIntValue2 = cVar.h();
                                    layoutParams2.gravity = iIntValue2;
                                }
                            } else if (i2 == 4) {
                                Integer numA = a(cVar, cVar.j().toUpperCase(Locale.US));
                                if (layoutParamsA instanceof LinearLayout.LayoutParams) {
                                    ((LinearLayout.LayoutParams) layoutParamsA).gravity = numA.intValue();
                                }
                                if (layoutParamsA instanceof FrameLayout.LayoutParams) {
                                    ((FrameLayout.LayoutParams) layoutParamsA).gravity = numA.intValue();
                                }
                                if (layoutParamsA instanceof RadioGroup.LayoutParams) {
                                    layoutParams2 = (RadioGroup.LayoutParams) layoutParamsA;
                                    iIntValue2 = numA.intValue();
                                    layoutParams2.gravity = iIntValue2;
                                }
                            }
                        }
                        break;
                    case 118:
                        if (cVar.b != c.EnumC0347c.FLOAT) {
                            continue;
                        } else if (layoutParamsA instanceof LinearLayout.LayoutParams) {
                            ((LinearLayout.LayoutParams) layoutParamsA).weight = cVar.e();
                        }
                        break;
                    default:
                        continue;
                }
                layoutParams.addRule(i, iIntValue);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
        view.setLayoutParams(layoutParamsA);
    }

    private static void a(ViewGroup.LayoutParams layoutParams, boolean z, c cVar) {
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || z) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int iH = cVar.h();
        marginLayoutParams.rightMargin = iH;
        marginLayoutParams.leftMargin = iH;
        marginLayoutParams.topMargin = iH;
        marginLayoutParams.bottomMargin = iH;
    }

    private static void a(ViewGroup.LayoutParams layoutParams, boolean z, c cVar, int i) {
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || z) {
            return;
        }
        if (i == 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = cVar.h();
            return;
        }
        if (i == 1) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = cVar.h();
        } else if (i == 2) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = cVar.h();
        } else {
            if (i != 3) {
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = cVar.h();
        }
    }

    private static void a(View view, c cVar, boolean z, Map<String, PersonalizationDefVal> map, c cVar2) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            String strA = b.INSTANCE.a(cVar.j(), map);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            if (cVar2 != null && cVar2.b == c.EnumC0347c.COLOR) {
                strA = a(strA, cVar2.d());
            }
            sdk.pendo.io.x7.a.a(textView, strA);
            if (z) {
                textView.setContentDescription(textView.getText().toString());
            }
        }
    }

    private static void a(View view, boolean z, c cVar) {
        if (cVar.b == c.EnumC0347c.DIMEN) {
            if ((view instanceof PendoLinearLayout) && !z) {
                ((PendoLinearLayout) view).setLayoutMaxWidth(cVar.h());
            } else if (view instanceof PendoScrollView) {
                ((PendoScrollView) view).setLayoutMaxWidth(cVar.h());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static String a(View view, Map<String, c> map, Map<String, PersonalizationDefVal> map2) {
        String strJ = "";
        for (c cVar : map.values()) {
            boolean z = true;
            switch (C0346a.a[cVar.a.ordinal()]) {
                case 1:
                    strJ = cVar.j();
                    break;
                case 2:
                case 3:
                    Y(view, cVar);
                    break;
                case 4:
                    if (view instanceof PendoAbstractRadioButton) {
                        ((PendoAbstractRadioButton) view).setResponseId(cVar.j());
                    }
                    break;
                case 5:
                case 6:
                    g(view, cVar);
                    break;
                case 7:
                    c cVar2 = map.get(c.b.ACCESSIBILITYTEXT.name());
                    if (cVar2 != null && !cVar2.j().isEmpty()) {
                        z = false;
                    }
                    a(view, cVar, z, map2, map.get(c.b.TEXTCOLOR.name()));
                    break;
                case 8:
                    c cVar3 = map.get(c.b.ACCESSIBILITYTEXT.name());
                    if (cVar3 != null && !cVar3.j().isEmpty()) {
                        z = false;
                    }
                    a(view, cVar, z, map2);
                    break;
                case 9:
                    Z(view, cVar);
                    break;
                case 10:
                    e0(view, cVar);
                    break;
                case 11:
                case 12:
                    a(view, cVar);
                    break;
                case 13:
                    V(view, cVar);
                    break;
                case 14:
                    b(view, cVar);
                    break;
                case 15:
                    U(view, cVar);
                    break;
                case 16:
                    f0(view, cVar);
                    break;
                case 17:
                    H(view, cVar);
                    break;
                case 18:
                    b(view, cVar, 0);
                    break;
                case 19:
                    b(view, cVar, 1);
                    break;
                case 20:
                    b(view, cVar, 2);
                    break;
                case 21:
                    b(view, cVar, 3);
                    break;
                case 22:
                    A(view, cVar);
                    break;
                case 23:
                    E(view, cVar);
                    break;
                case 24:
                    q(view, cVar);
                    break;
                case 25:
                    C(view, cVar);
                    break;
                case 26:
                    G(view, cVar);
                    break;
                case 27:
                case 28:
                    m0(view, cVar);
                    break;
                case 29:
                    v(view, cVar);
                    break;
                case 30:
                    a(view, cVar, map.get(c.b.FONTSTYLE.name()));
                    break;
                case 31:
                    X(view, cVar);
                    break;
                case 32:
                    K(view, cVar);
                    break;
                case 33:
                    c(view, cVar);
                    break;
                case 34:
                    a(view, cVar, 0);
                    break;
                case 35:
                    a(view, cVar, 1);
                    break;
                case 36:
                    a(view, cVar, 2);
                    break;
                case 37:
                    a(view, cVar, 3);
                    break;
                case 38:
                    r(view, cVar);
                    break;
                case 39:
                    N(view, cVar);
                    break;
                case 40:
                    o(view, cVar);
                    break;
                case 41:
                    L(view, cVar);
                    break;
                case 42:
                    M(view, cVar);
                    break;
                case 43:
                    u(view, cVar);
                    break;
                case 44:
                    l0(view, cVar);
                    break;
                case 45:
                    F(view, cVar);
                    break;
                case 46:
                    n0(view, cVar);
                    break;
                case 47:
                    o0(view, cVar);
                    break;
                case 48:
                    s(view, cVar);
                    break;
                case 49:
                    t(view, cVar);
                    break;
                case 50:
                    P(view, cVar);
                    break;
                case 51:
                    Q(view, cVar);
                    break;
                case 52:
                    d0(view, cVar);
                    break;
                case 53:
                    a(view, cVar, map.get(c.b.ID.name()) == null);
                    break;
                case 54:
                    m(view, cVar);
                    break;
                case 55:
                    n(view, cVar);
                    break;
                case 56:
                    k(view, cVar);
                    break;
                case 57:
                    l(view, cVar);
                    break;
                case 58:
                    w(view, cVar);
                    break;
                case 59:
                    i0(view, cVar);
                    break;
                case 60:
                    x(view, cVar);
                    break;
                case 61:
                    W(view, cVar);
                    break;
                case 62:
                    B(view, cVar);
                    break;
                case 63:
                    p(view, cVar);
                    break;
                case 64:
                    O(view, cVar);
                    break;
                case 65:
                    b0(view, cVar);
                    break;
                case 66:
                    c0(view, cVar);
                    break;
                case 67:
                    a0(view, cVar);
                    break;
                case 68:
                    i(view, cVar);
                    break;
                case 69:
                    j(view, cVar);
                    break;
                case 70:
                    h(view, cVar);
                    break;
                case 71:
                    y(view, cVar);
                    break;
                case 72:
                    T(view, cVar);
                    break;
                case 73:
                    R(view, cVar);
                    break;
                case 74:
                    g0(view, cVar);
                    break;
                case 75:
                    S(view, cVar);
                    break;
                case 76:
                    h0(view, cVar);
                    break;
                case 77:
                    I(view, cVar);
                    break;
                case 78:
                    J(view, cVar);
                    break;
                case 79:
                    e(view, cVar);
                    break;
                case 80:
                    k0(view, cVar);
                    break;
                case 81:
                    j0(view, cVar);
                    break;
                case 82:
                    f(view, cVar);
                    break;
                case 83:
                    z(view, cVar);
                    break;
                case 84:
                    d(view, cVar);
                    break;
            }
        }
        if (view instanceof PendoCustomView) {
            ((PendoCustomView) view).renderView();
        }
        return strJ;
    }

    private static void a(View view, c cVar, boolean z, Map<String, PersonalizationDefVal> map) {
        if (view instanceof TextView) {
            int i = C0346a.b[cVar.b.ordinal()];
            if (i != 4) {
                if (i != 6) {
                    return;
                }
                ((TextView) view).setText(b(view.getContext(), cVar.j()));
                return;
            }
            TextView textView = (TextView) view;
            String strA = b.INSTANCE.a(cVar.j(), map);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            textView.setText(strA);
            if (z) {
                textView.setContentDescription(strA);
            }
        }
    }

    private static int a(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "textUri":
                return 16;
            case "number":
                return 2;
            case "textMultiLine":
                return 131072;
            case "text":
                return 1;
            case "phone":
                return 3;
            case "textPassword":
                return 128;
            case "textEmailAddress":
                return 32;
            default:
                return 0;
        }
    }

    static ViewGroup.LayoutParams a(ViewGroup viewGroup) {
        ViewGroup.LayoutParams layoutParams;
        if (viewGroup != null) {
            try {
                Class<?> superclass = viewGroup.getClass();
                while (!b(superclass.getName() + "$LayoutParams")) {
                    superclass = superclass.getSuperclass();
                }
                Class<?> cls = Class.forName(superclass.getName() + "$LayoutParams");
                Class<?> cls2 = Integer.TYPE;
                layoutParams = (ViewGroup.LayoutParams) cls.getConstructor(cls2, cls2).newInstance(-2, -2);
            } catch (Exception e) {
                PendoLogger.e(e, "view class: '" + viewGroup.getClass() + "' Message:" + e.getMessage(), new Object[0]);
                layoutParams = null;
            }
        } else {
            layoutParams = null;
        }
        return layoutParams == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams;
    }

    public static int a() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static float a(float f) {
        return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    private static int a(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    private static Object a(JSONObject jSONObject, String str, Class cls) {
        if (cls == Integer.class || cls == Integer.TYPE) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return Double.valueOf(jSONObject.getDouble(str));
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (cls == Long.class || cls == Long.TYPE) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (cls == String.class) {
            return jSONObject.getString(str);
        }
        return cls == JSONObject.class ? jSONObject.getJSONObject(str) : jSONObject.get(str);
    }

    private static Integer a(c cVar, String str) {
        int iIntValue = 0;
        for (String str2 : str.split("\\|")) {
            iIntValue += ((Integer) cVar.a(Gravity.class, str2.toUpperCase(Locale.US))).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    static void a(Object obj, View view, HashMap<String, Integer> map) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(e.class)) {
                String strId = ((e) field.getAnnotation(e.class)).id();
                if (strId.equalsIgnoreCase("")) {
                    strId = field.getName();
                }
                if (map.containsKey(strId)) {
                    try {
                        try {
                            field.set(obj, view.findViewById(map.get(strId).intValue()));
                        } catch (IllegalArgumentException unused) {
                        }
                    } catch (IllegalAccessException e) {
                        PendoLogger.e(e, e.getMessage(), new Object[0]);
                    }
                }
            } else if (field.getName().equalsIgnoreCase(TagsIdentifier.FIELD_IDS_ARRAY) && field.getType() == map.getClass()) {
                try {
                    field.set(obj, map);
                } catch (IllegalAccessException e2) {
                    PendoLogger.e(e2, e2.getMessage(), new Object[0]);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view) {
        if (view instanceof IBackgroundRenderView) {
            ((IBackgroundRenderView) view).renderBackground();
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            a(viewGroup.getChildAt(i));
            i++;
        }
    }

    private static int a(int i, int i2) {
        return ((i == -1 || i == -2) && i2 > 0 && ((float) i2) < ((float) s0.c().getDisplayMetrics().heightPixels)) ? i2 : i;
    }

    private static String a(String str, int i) {
        return "{color: " + String.format("#%06X", Integer.valueOf(i & ViewCompat.MEASURED_SIZE_MASK)) + "}" + str + "{/color}";
    }
}
