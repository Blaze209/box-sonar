package com.swmansion.rnscreens.gamma.common.colorscheme;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: compiled from: ColorSchemeProviding.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorSchemeProviding;", "", "getResolvedUiNightMode", "", "addColorSchemeListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorSchemeListener;", "removeColorSchemeListener", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ColorSchemeProviding {
    void addColorSchemeListener(ColorSchemeListener listener);

    int getResolvedUiNightMode();

    void removeColorSchemeListener(ColorSchemeListener listener);
}
