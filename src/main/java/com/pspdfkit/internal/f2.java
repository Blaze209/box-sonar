package com.pspdfkit.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f2 {
    public static void a(ComposeUiNode.Companion companion, Composer composer, MeasurePolicy measurePolicy, Composer composer2, CompositionLocalMap compositionLocalMap) {
        Updater.m6070setimpl(composer, measurePolicy, companion.getSetMeasurePolicy());
        Updater.m6070setimpl(composer2, compositionLocalMap, companion.getSetResolvedCompositionLocals());
    }
}
