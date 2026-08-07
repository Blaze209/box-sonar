package com.swmansion.rnscreens.gamma.common.colorscheme;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ColorSchemeCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\"\u001a\u00020\u0010H\u0016J@\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2)\u0010&\u001a%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0018j\u0004\u0018\u0001`\u001dH\u0000¢\u0006\u0002\b'J\r\u0010(\u001a\u00020\u001cH\u0000¢\u0006\u0002\b)J\u0017\u0010*\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010,H\u0000¢\u0006\u0002\b-J\b\u0010.\u001a\u00020\u001cH\u0016J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u0002H\u0016J\u0010\u00101\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u0002H\u0016J\b\u00102\u001a\u00020\u001cH\u0002J\u0012\u00103\u001a\u0004\u0018\u00010\u00012\u0006\u0010$\u001a\u00020%H\u0002R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R=\u0010\u0017\u001a%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0018j\u0004\u0018\u0001`\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorSchemeCoordinator;", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorSchemeProviding;", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorSchemeListener;", "<init>", "()V", "<set-?>", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;", "colorScheme", "getColorScheme$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;", "setColorScheme$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;)V", "colorScheme$delegate", "Lkotlin/properties/ReadWriteProperty;", "parentProvider", "systemUiNightMode", "", "lastAppliedUiNightMode", "Ljava/lang/Integer;", "childListeners", "", "isSetUp", "", "onUiNightModeResolved", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "nightMode", "", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/OnUiNightModeResolvedCallback;", "getOnUiNightModeResolved$react_native_screens_release", "()Lkotlin/jvm/functions/Function1;", "setOnUiNightModeResolved$react_native_screens_release", "(Lkotlin/jvm/functions/Function1;)V", "getResolvedUiNightMode", "setup", "hostView", "Landroid/view/View;", "onUiNightModeResolvedCallback", "setup$react_native_screens_release", "teardown", "teardown$react_native_screens_release", "onConfigurationChanged", "configuration", "Landroid/content/res/Configuration;", "onConfigurationChanged$react_native_screens_release", "onParentUiNightModeChanged", "addColorSchemeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeColorSchemeListener", "applyResolvedColorScheme", "findParentColorSchemeProvider", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorSchemeCoordinator implements ColorSchemeProviding, ColorSchemeListener {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ColorSchemeCoordinator.class, "colorScheme", "getColorScheme$react_native_screens_release()Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;", 0))};
    private final List<ColorSchemeListener> childListeners;

    /* JADX INFO: renamed from: colorScheme$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty colorScheme;
    private boolean isSetUp;
    private Integer lastAppliedUiNightMode;
    private Function1<? super Integer, Unit> onUiNightModeResolved;
    private ColorSchemeProviding parentProvider;
    private int systemUiNightMode;

    /* JADX INFO: compiled from: ColorSchemeCoordinator.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorScheme.values().length];
            try {
                iArr[ColorScheme.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorScheme.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ColorScheme.INHERIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ColorSchemeCoordinator() {
        Delegates delegates = Delegates.INSTANCE;
        final ColorScheme colorScheme = ColorScheme.INHERIT;
        this.colorScheme = new ObservableProperty<ColorScheme>(colorScheme) { // from class: com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeCoordinator$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, ColorScheme oldValue, ColorScheme newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue != newValue) {
                    this.applyResolvedColorScheme();
                }
            }
        };
        this.systemUiNightMode = 16;
        this.childListeners = new ArrayList();
    }

    public final ColorScheme getColorScheme$react_native_screens_release() {
        return (ColorScheme) this.colorScheme.getValue(this, $$delegatedProperties[0]);
    }

    public final void setColorScheme$react_native_screens_release(ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "<set-?>");
        this.colorScheme.setValue(this, $$delegatedProperties[0], colorScheme);
    }

    public final Function1<Integer, Unit> getOnUiNightModeResolved$react_native_screens_release() {
        return this.onUiNightModeResolved;
    }

    public final void setOnUiNightModeResolved$react_native_screens_release(Function1<? super Integer, Unit> function1) {
        this.onUiNightModeResolved = function1;
    }

    @Override // com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeProviding
    public int getResolvedUiNightMode() {
        int i = WhenMappings.$EnumSwitchMapping$0[getColorScheme$react_native_screens_release().ordinal()];
        if (i == 1) {
            return 16;
        }
        if (i == 2) {
            return 32;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        ColorSchemeProviding colorSchemeProviding = this.parentProvider;
        return colorSchemeProviding != null ? colorSchemeProviding.getResolvedUiNightMode() : this.systemUiNightMode;
    }

    public final void setup$react_native_screens_release(View hostView, Function1<? super Integer, Unit> onUiNightModeResolvedCallback) {
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        if (this.isSetUp) {
            throw new IllegalStateException("[RNScreens] ColorSchemeCoordinator's setup method must not be called again without calling teardown() first.".toString());
        }
        this.systemUiNightMode = hostView.getResources().getConfiguration().uiMode & 48;
        ColorSchemeProviding colorSchemeProvidingFindParentColorSchemeProvider = findParentColorSchemeProvider(hostView);
        this.parentProvider = colorSchemeProvidingFindParentColorSchemeProvider;
        if (colorSchemeProvidingFindParentColorSchemeProvider != null) {
            colorSchemeProvidingFindParentColorSchemeProvider.addColorSchemeListener(this);
        }
        this.onUiNightModeResolved = onUiNightModeResolvedCallback;
        this.isSetUp = true;
        this.lastAppliedUiNightMode = null;
        applyResolvedColorScheme();
    }

    public final void teardown$react_native_screens_release() {
        ColorSchemeProviding colorSchemeProviding = this.parentProvider;
        if (colorSchemeProviding != null) {
            colorSchemeProviding.removeColorSchemeListener(this);
        }
        this.onUiNightModeResolved = null;
        this.parentProvider = null;
        this.lastAppliedUiNightMode = null;
        this.isSetUp = false;
    }

    public final void onConfigurationChanged$react_native_screens_release(Configuration configuration) {
        this.systemUiNightMode = configuration != null ? configuration.uiMode & 48 : 0;
        applyResolvedColorScheme();
    }

    @Override // com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeListener
    public void onParentUiNightModeChanged() {
        if (getColorScheme$react_native_screens_release() == ColorScheme.INHERIT) {
            applyResolvedColorScheme();
        }
    }

    @Override // com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeProviding
    public void addColorSchemeListener(ColorSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.childListeners.add(listener);
    }

    @Override // com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeProviding
    public void removeColorSchemeListener(ColorSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.childListeners.remove(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyResolvedColorScheme() {
        int resolvedUiNightMode = getResolvedUiNightMode();
        Integer num = this.lastAppliedUiNightMode;
        if (num != null && resolvedUiNightMode == num.intValue()) {
            return;
        }
        this.lastAppliedUiNightMode = Integer.valueOf(resolvedUiNightMode);
        Function1<? super Integer, Unit> function1 = this.onUiNightModeResolved;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(resolvedUiNightMode));
        }
        Iterator<T> it = this.childListeners.iterator();
        while (it.hasNext()) {
            ((ColorSchemeListener) it.next()).onParentUiNightModeChanged();
        }
    }

    private final ColorSchemeProviding findParentColorSchemeProvider(View hostView) {
        for (ViewParent parent = hostView.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ColorSchemeProviding) {
                return (ColorSchemeProviding) parent;
            }
        }
        return null;
    }
}
