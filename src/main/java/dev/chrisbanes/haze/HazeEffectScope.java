package dev.chrisbanes.haze;

import androidx.compose.ui.graphics.Brush;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: HazeChild.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u001bX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010'\u001a\u00020(X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010\u000b\"\u0004\b*\u0010\rR\u0018\u0010+\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b,\u0010\u000b\"\u0004\b-\u0010\rR\u0018\u0010.\u001a\u00020\"X¦\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u0004\u0018\u000104X¦\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020:8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R0\u0010A\u001a\u0010\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u0003\u0018\u00010B8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bD\u0010<\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006I"}, d2 = {"Ldev/chrisbanes/haze/HazeEffectScope;", "", "blurEnabled", "", "getBlurEnabled", "()Z", "setBlurEnabled", "(Z)V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "style", "Ldev/chrisbanes/haze/HazeStyle;", "getStyle", "()Ldev/chrisbanes/haze/HazeStyle;", "setStyle", "(Ldev/chrisbanes/haze/HazeStyle;)V", "mask", "Landroidx/compose/ui/graphics/Brush;", "getMask", "()Landroidx/compose/ui/graphics/Brush;", "setMask", "(Landroidx/compose/ui/graphics/Brush;)V", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "getBackgroundColor-0d7_KjU", "()J", "setBackgroundColor-8_81llA", "(J)V", "tints", "", "Ldev/chrisbanes/haze/HazeTint;", "getTints", "()Ljava/util/List;", "setTints", "(Ljava/util/List;)V", "blurRadius", "Landroidx/compose/ui/unit/Dp;", "getBlurRadius-D9Ej5fM", "setBlurRadius-0680j_4", "noiseFactor", "getNoiseFactor", "setNoiseFactor", "fallbackTint", "getFallbackTint", "()Ldev/chrisbanes/haze/HazeTint;", "setFallbackTint", "(Ldev/chrisbanes/haze/HazeTint;)V", "progressive", "Ldev/chrisbanes/haze/HazeProgressive;", "getProgressive", "()Ldev/chrisbanes/haze/HazeProgressive;", "setProgressive", "(Ldev/chrisbanes/haze/HazeProgressive;)V", "inputScale", "Ldev/chrisbanes/haze/HazeInputScale;", "getInputScale$annotations", "()V", "getInputScale", "()Ldev/chrisbanes/haze/HazeInputScale;", "setInputScale", "(Ldev/chrisbanes/haze/HazeInputScale;)V", "canDrawArea", "Lkotlin/Function1;", "Ldev/chrisbanes/haze/HazeArea;", "getCanDrawArea$annotations", "getCanDrawArea", "()Lkotlin/jvm/functions/Function1;", "setCanDrawArea", "(Lkotlin/jvm/functions/Function1;)V", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HazeEffectScope {

    /* JADX INFO: compiled from: HazeChild.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @ExperimentalHazeApi
        public static /* synthetic */ void getCanDrawArea$annotations() {
        }

        @ExperimentalHazeApi
        public static /* synthetic */ void getInputScale$annotations() {
        }
    }

    float getAlpha();

    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU */
    long mo14463getBackgroundColor0d7_KjU();

    boolean getBlurEnabled();

    /* JADX INFO: renamed from: getBlurRadius-D9Ej5fM */
    float mo14464getBlurRadiusD9Ej5fM();

    Function1<HazeArea, Boolean> getCanDrawArea();

    HazeTint getFallbackTint();

    HazeInputScale getInputScale();

    Brush getMask();

    float getNoiseFactor();

    HazeProgressive getProgressive();

    HazeStyle getStyle();

    List<HazeTint> getTints();

    void setAlpha(float f);

    /* JADX INFO: renamed from: setBackgroundColor-8_81llA */
    void mo14466setBackgroundColor8_81llA(long j);

    void setBlurEnabled(boolean z);

    /* JADX INFO: renamed from: setBlurRadius-0680j_4 */
    void mo14467setBlurRadius0680j_4(float f);

    void setCanDrawArea(Function1<? super HazeArea, Boolean> function1);

    void setFallbackTint(HazeTint hazeTint);

    void setInputScale(HazeInputScale hazeInputScale);

    void setMask(Brush brush);

    void setNoiseFactor(float f);

    void setProgressive(HazeProgressive hazeProgressive);

    void setStyle(HazeStyle hazeStyle);

    void setTints(List<HazeTint> list);
}
