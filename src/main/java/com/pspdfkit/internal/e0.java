package com.pspdfkit.internal;

import android.content.Context;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import io.nutrient.domain.ai.AiAssistant;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 implements ViewModelProvider.Factory {
    public final /* synthetic */ Context a;
    public final /* synthetic */ AiAssistant b;
    public final /* synthetic */ String c;

    public e0(Context context, AiAssistant aiAssistant, String str) {
        this.a = context;
        this.b = aiAssistant;
        this.c = str;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        cls.getClass();
        creationExtras.getClass();
        if (!cls.isAssignableFrom(f0.class)) {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
        return new f0(this.b, this.c, SavedStateHandleSupport.createSavedStateHandle(creationExtras), new da(this.a));
    }
}
