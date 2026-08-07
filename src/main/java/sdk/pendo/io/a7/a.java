package sdk.pendo.io.a7;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.tabs.TabLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nonnull;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e7.b;
import sdk.pendo.io.e7.c;
import sdk.pendo.io.e7.d;
import sdk.pendo.io.e7.e;
import sdk.pendo.io.e7.f;
import sdk.pendo.io.e7.g;
import sdk.pendo.io.e7.h;
import sdk.pendo.io.e7.i;
import sdk.pendo.io.e7.j;
import sdk.pendo.io.e7.k;
import sdk.pendo.io.e7.l;
import sdk.pendo.io.e7.m;
import sdk.pendo.io.e7.n;
import sdk.pendo.io.e7.o;
import sdk.pendo.io.e7.p;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J.\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002J\u0017\u0010\t\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\fJ(\u0010\t\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010J%\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0001¢\u0006\u0004\b\t\u0010\u0013R0\u0010\u0016\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00060\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R,\u0010\u001a\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00060\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00040\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u000b0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019¨\u0006#"}, d2 = {"Lsdk/pendo/io/a7/a;", "", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "Lsdk/pendo/io/e7/h;", "builder", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "view", "", "(Landroid/view/View;)Z", "", "id", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", "(Ljava/lang/Class;)Lsdk/pendo/io/e7/h;", "", "Ljava/util/Map;", "builders", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "builderCache", "", "c", "Ljava/util/Set;", "ignoredAssignableClasses", "d", "ignoredAssignableClassesCache", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Map<Class<? extends View>, h<? extends View>> builders = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final ConcurrentHashMap<Class<?>, h<? extends View>> builderCache = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Set<Class<? extends View>> ignoredAssignableClasses = SetsKt.setOf(ConstraintHelper.class);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final ConcurrentHashMap<Class<?>, Boolean> ignoredAssignableClassesCache = new ConcurrentHashMap<>();

    public a() {
        a(MaterialCardView.class, new g());
        a(Space.class, new m());
        a(ProgressBar.class, new j());
        a(SeekBar.class, new l());
        a(EditText.class, new d());
        a(RadioButton.class, new k());
        a(ImageView.class, new e());
        a(SwitchCompat.class, new o());
        a(CheckBox.class, new b());
        a(Chip.class, new c());
        a(TabLayout.class, new sdk.pendo.io.g7.b());
        a(Spinner.class, new sdk.pendo.io.g7.a());
        a(ViewGroup.class, new sdk.pendo.io.g7.c());
        a(WebView.class, new i());
        a(Switch.class, new n());
        a(MaterialButton.class, new f());
        a(TextView.class, new p());
        a(AppCompatToggleButton.class, new sdk.pendo.io.e7.a());
        a(View.class, new i());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final v a(int id, View view, int zIndex, s privacyConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        try {
            if (a(view)) {
                return null;
            }
            h<? extends View> hVarA = a((Class<View>) view.getClass());
            Intrinsics.checkNotNull(hVarA, "null cannot be cast to non-null type sdk.pendo.io.sessionreplay.builders.views.MultiNodesBuilder<android.view.View>");
            return hVarA.a(id, view, zIndex, privacyConfig);
        } catch (Throwable th) {
            PendoLogger.v("NativeSRNodesBuilder", "Failed to generate SRNode for the " + view.getClass().getName() + " " + th.getMessage());
            return null;
        }
    }

    @Nonnull
    public final h<? extends View> a(Class<View> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ConcurrentHashMap<Class<?>, h<? extends View>> concurrentHashMap = this.builderCache;
        h<? extends View> hVar = concurrentHashMap.get(clazz);
        if (hVar == null) {
            Class<View> superclass = clazz;
            while (true) {
                if (superclass == null) {
                    h<? extends View> hVar2 = this.builders.get(View.class);
                    Intrinsics.checkNotNull(hVar2);
                    hVar = hVar2;
                    break;
                }
                h<? extends View> hVar3 = this.builders.get(superclass);
                if (hVar3 != null) {
                    hVar = hVar3;
                    break;
                }
                superclass = superclass.getSuperclass();
            }
            h<? extends View> hVarPutIfAbsent = concurrentHashMap.putIfAbsent(clazz, hVar);
            if (hVarPutIfAbsent != null) {
                hVar = hVarPutIfAbsent;
            }
        }
        Intrinsics.checkNotNullExpressionValue(hVar, "getOrPut(...)");
        return hVar;
    }

    private final <T extends View> void a(Class<T> clazz, h<T> builder) {
        this.builders.put(clazz, builder);
    }

    public final boolean a(View view) {
        boolean z;
        Intrinsics.checkNotNullParameter(view, "view");
        Class<?> cls = view.getClass();
        ConcurrentHashMap<Class<?>, Boolean> concurrentHashMap = this.ignoredAssignableClassesCache;
        Boolean boolValueOf = concurrentHashMap.get(cls);
        if (boolValueOf == null) {
            Set<Class<? extends View>> set = this.ignoredAssignableClasses;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if (((Class) it.next()).isAssignableFrom(cls)) {
                        z = true;
                        break;
                    }
                }
            } else {
                z = false;
                break;
            }
            boolValueOf = Boolean.valueOf(z);
            Boolean boolPutIfAbsent = concurrentHashMap.putIfAbsent(cls, boolValueOf);
            if (boolPutIfAbsent != null) {
                boolValueOf = boolPutIfAbsent;
            }
        }
        Intrinsics.checkNotNullExpressionValue(boolValueOf, "getOrPut(...)");
        return boolValueOf.booleanValue();
    }
}
