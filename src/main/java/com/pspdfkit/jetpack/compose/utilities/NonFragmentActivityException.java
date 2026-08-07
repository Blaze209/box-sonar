package com.pspdfkit.jetpack.compose.utilities;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/pspdfkit/jetpack/compose/utilities/NonFragmentActivityException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NonFragmentActivityException extends IllegalStateException {
    public static final int $stable = 8;

    public NonFragmentActivityException() {
        super("You need to use a fragment activity in order to use the DocumentView composable.");
    }
}
