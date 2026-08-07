package com.pspdfkit.ui.annotations;

import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/annotations/OnAnnotatingModeChangeListener;", "", "onEnterAnnotatingMode", "", "controller", "Lcom/pspdfkit/ui/special_mode/controller/AnnotatingController;", "onChangeAnnotatingMode", "onExitAnnotatingMode", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface OnAnnotatingModeChangeListener {
    void onChangeAnnotatingMode(AnnotatingController controller);

    void onEnterAnnotatingMode(AnnotatingController controller);

    void onExitAnnotatingMode(AnnotatingController controller);
}
