package sdk.pendo.io.b;

import android.graphics.Shader;
import java.util.EnumSet;
import java.util.Map;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    public enum a {
        MIRROR("mirror", Shader.TileMode.MIRROR),
        REPEAT("repeat", Shader.TileMode.REPEAT),
        FILL("aspectFill", null),
        FIT("aspectFit", null),
        SCALE_TO_FILL("scaleToFill", null);

        private final Shader.TileMode mMode;
        private final String mType;

        a(String str, Shader.TileMode tileMode) {
            this.mType = str;
            this.mMode = tileMode;
        }

        public static a b(String str) {
            for (a aVar : EnumSet.allOf(a.class)) {
                if (aVar.a(str)) {
                    return aVar;
                }
            }
            return null;
        }

        public boolean a(String str) {
            return this.mType.equals(str);
        }

        public Shader.TileMode b() {
            return this.mMode;
        }
    }

    static String a(Map<String, c> map, String str) {
        if (str.equals("Button") || str.equals("insert.io.Button") || str.equals("CloseButton") || str.equals("pendo.io.CircularCloseButton")) {
            return "sdk.pendo.io.views.custom.VisualActionButton";
        }
        if (str.equals("LinearLayout") || str.equals(GuideModel.TOOLTIP_WIDGET_NAME) || str.equals("RowBlock") || str.equals("MultipleChoicePollBlock") || str.equals("NumberScalePollWrapper") || str.equals("HorizontalLine")) {
            return "sdk.pendo.io.views.custom.PendoLinearLayout";
        }
        if (str.endsWith("insert.io.ImageView")) {
            return "sdk.pendo.io.views.custom.VisualActionImage";
        }
        if (str.endsWith("insert.io.TextField")) {
            return "sdk.pendo.io.views.custom.PendoEditText";
        }
        if (str.endsWith("insert.io.Form")) {
            return "sdk.pendo.io.views.custom.PendoForm";
        }
        if (str.endsWith("insert.io.RadioButton")) {
            c cVar = map.get(c.b.BUTTON_TYPE.name());
            return (cVar == null || !cVar.j().equals("nsp")) ? "sdk.pendo.io.views.custom.PendoRegularRadioButton" : "sdk.pendo.io.views.custom.PendoNSPRadioButton";
        }
        if (str.equals("nsp")) {
            return "sdk.pendo.io.views.custom.PendoNSPRadioButton";
        }
        if (str.endsWith("RadioSelectBlock")) {
            return "sdk.pendo.io.views.custom.PendoRadioGroup";
        }
        if ("NumberScaleGroup".equals(str)) {
            return "sdk.pendo.io.views.custom.PendoNSPRadioGroup";
        }
        if (str.equals("CarouselIndicatorWrapper")) {
            return "sdk.pendo.io.views.custom.PendoMultipleRowViewGroup";
        }
        if (str.equals("CarouselIndicator")) {
            return "sdk.pendo.io.views.custom.PendoCarouselIndicatorView";
        }
        if (str.equals("insert.io.MultiPageLayout")) {
            return "android.widget.RelativeLayout";
        }
        if (!str.endsWith("VideoPlayerView")) {
            return !str.contains(".") ? "android.widget." + str : str;
        }
        c cVar2 = map.get(c.b.VIDEO_PROVIDER.name());
        if (cVar2 != null) {
            if (cVar2.j().equals("youtube")) {
                return "sdk.pendo.io.views.custom.videoplayer.youtube.PendoYoutubePlayer";
            }
            if (cVar2.j().equals("vimeo")) {
                return "sdk.pendo.io.views.custom.videoplayer.vimeo.PendoVimeoPlayer";
            }
        }
        PendoLogger.e("DynamicViewUtils", "getWidgetType - Unknown video provider");
        return null;
    }
}
