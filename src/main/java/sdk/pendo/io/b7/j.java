package sdk.pendo.io.b7;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.core.view.GravityCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.j7.w;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0007\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\b¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/b7/j;", "", "Landroid/view/View;", "view", "Landroid/graphics/Rect;", "b", "(Landroid/view/View;)Landroid/graphics/Rect;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/widget/TextView;", "Lsdk/pendo/io/j7/w;", "(Landroid/widget/TextView;)Lsdk/pendo/io/j7/w;", "", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class j {
    public static final j a = new j();

    private j() {
    }

    public final Rect a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (view instanceof FloatingActionButton) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            return new Rect(iArr[0], iArr[1], floatingActionButton.getWidth(), floatingActionButton.getHeight());
        }
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            return new Rect(iArr[0], iArr[1] + imageView.getPaddingTop(), imageView.getWidth(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
        }
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            return new Rect(iArr[0], iArr[1] + materialButton.getInsetTop(), materialButton.getWidth(), (materialButton.getHeight() - materialButton.getInsetTop()) - materialButton.getInsetBottom());
        }
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            return new Rect(iArr[0], iArr[1] + chip.getPaddingTop(), chip.getWidth(), (chip.getHeight() - chip.getPaddingTop()) - chip.getPaddingBottom());
        }
        if (!(view instanceof ToggleButton)) {
            return new Rect(iArr[0], iArr[1], view.getWidth(), view.getHeight());
        }
        ToggleButton toggleButton = (ToggleButton) view;
        return new Rect(iArr[0], iArr[1] + toggleButton.getPaddingTop(), toggleButton.getWidth(), (toggleButton.getHeight() - toggleButton.getPaddingTop()) - toggleButton.getPaddingBottom());
    }

    public final Rect b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view2.getLocationOnScreen(iArr2);
            i = iArr[0] - iArr2[0];
            i2 = iArr[1] - iArr2[1];
        }
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            return new Rect(i, i2 + materialButton.getInsetTop(), materialButton.getWidth(), (materialButton.getHeight() - materialButton.getInsetTop()) - materialButton.getInsetBottom());
        }
        if (!(view instanceof Chip)) {
            return new Rect(i, i2, view.getWidth(), view.getHeight());
        }
        Chip chip = (Chip) view;
        return new Rect(i, i2 + chip.getPaddingTop(), chip.getWidth(), (chip.getHeight() - chip.getPaddingTop()) - chip.getPaddingBottom());
    }

    public final w a(TextView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        String strG = i.a.g(view);
        boolean z = view.getLayoutDirection() == 1;
        boolean zAreEqual = Intrinsics.areEqual(strG, "rtl");
        w wVar = z ? new w(w.a.RIGHT) : new w(w.a.LEFT);
        w wVar2 = z ? new w(w.a.LEFT) : new w(w.a.RIGHT);
        w wVar3 = zAreEqual ? new w(w.a.RIGHT) : new w(w.a.LEFT);
        w wVar4 = zAreEqual ? new w(w.a.LEFT) : new w(w.a.RIGHT);
        int textAlignment = view.getTextAlignment();
        if (textAlignment != 2) {
            if (textAlignment == 3) {
                return wVar4;
            }
            if (textAlignment == 4) {
                return new w(w.a.CENTER);
            }
            if (textAlignment == 5) {
                return wVar;
            }
            if (textAlignment == 6) {
                return wVar2;
            }
            if ((view.getGravity() & 7) == 1) {
                return new w(w.a.CENTER);
            }
            int gravity = view.getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            if (gravity == 3) {
                return new w(w.a.LEFT);
            }
            if (gravity == 5) {
                return new w(w.a.RIGHT);
            }
            if (gravity == 8388613) {
                return wVar4;
            }
        }
        return wVar3;
    }

    public final String b(TextView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int textDirection = view.getTextDirection();
        if (textDirection == 3) {
            return "ltr";
        }
        if (textDirection == 4) {
            return "rtl";
        }
        if (textDirection != 5) {
            if (textDirection != 6) {
                return textDirection != 7 ? i.a.k(view) : "rtl";
            }
            return "ltr";
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        return TextUtils.getLayoutDirectionFromLocale(locale) == 1 ? "rtl" : "ltr";
    }
}
