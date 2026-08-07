package com.pspdfkit.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e2 {
    public static Function2 a(ComposeUiNode.Companion companion, Composer composer, Integer num, Composer composer2) {
        Updater.m6066initimpl(composer, num, companion.getSetCompositeKeyHash());
        Updater.m6068reconcileimpl(composer2, companion.getApplyOnDeactivatedNodeAssertion());
        return companion.getSetModifier();
    }
}
