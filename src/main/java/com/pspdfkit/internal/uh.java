package com.pspdfkit.internal;

import android.view.View;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public interface uh<T extends FormElement> extends FormManager.OnFormElementEditingModeChangeListener {
    View a();

    Object a(Continuation<? super Boolean> continuation);

    void d();

    void g();

    T getFormElement();

    void l();
}
