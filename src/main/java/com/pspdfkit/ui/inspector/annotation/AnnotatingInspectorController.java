package com.pspdfkit.ui.inspector.annotation;

import android.os.Bundle;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotatingInspectorController extends AnnotationInspectorController {
    void bindController(AnnotatingController annotatingController);

    void onRestoreInstanceState(Bundle bundle);

    void onSaveInstanceState(Bundle bundle);

    void unbindController();
}
