package sdk.pendo.io.b7;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import androidx.cardview.widget.CardView;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.h7.r;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lsdk/pendo/io/b7/a;", "", "Landroid/view/View;", "view", "", "b", "(Landroid/view/View;)Ljava/lang/Integer;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {
    public static final a a = new a();

    private a() {
    }

    private final Integer b(View view) {
        int colorForState;
        if (view instanceof Chip) {
            Drawable chipDrawable = ((Chip) view).getChipDrawable();
            Intrinsics.checkNotNull(chipDrawable, "null cannot be cast to non-null type com.google.android.material.chip.ChipDrawable");
            colorForState = ((ChipDrawable) chipDrawable).getResolvedTintColor();
        } else {
            if ((view instanceof ToggleButton) || ((view instanceof Button) && !(view instanceof CompoundButton))) {
                return h.a(view);
            }
            if (!(view instanceof CardView)) {
                return null;
            }
            CardView cardView = (CardView) view;
            colorForState = cardView.getCardBackgroundColor().getColorForState(cardView.getDrawableState(), cardView.getCardBackgroundColor().getDefaultColor());
        }
        return Integer.valueOf(colorForState);
    }

    public final Integer a(View view) {
        Integer numA;
        Intrinsics.checkNotNullParameter(view, "view");
        if (r.a.b() == Pendo.PendoOptions.Framework.REACT_NATIVE && (view instanceof ViewGroup) && (numA = sdk.pendo.io.d7.d.a.a(view)) != null) {
            return numA;
        }
        if (view.getBackground() == null && view.getBackgroundTintList() == null && view.getId() == 16908290) {
            View rootView = view.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
            return a(rootView);
        }
        ColorStateList backgroundTintList = view.getBackgroundTintList();
        Integer numB = null;
        Integer numValueOf = backgroundTintList != null ? Integer.valueOf(backgroundTintList.getColorForState(view.getDrawableState(), 0)) : null;
        if (view.getBackground() != null) {
            Integer numA2 = c.a.a(view.getBackground());
            boolean z = view instanceof ViewGroup;
            if ((z || ((numA2 == null || numA2.intValue() != -1) && (numA2 == null || numA2.intValue() != 0))) && (!z || numA2 == null || numA2.intValue() != 0)) {
                numB = numA2;
            }
        }
        if (numB == null) {
            numB = b(view);
        }
        return numB == null ? numValueOf : numB;
    }
}
