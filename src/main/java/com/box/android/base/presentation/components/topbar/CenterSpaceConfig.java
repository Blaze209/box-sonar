package com.box.android.base.presentation.components.topbar;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxPrimaryTopBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/CenterSpaceConfig;", "", "<init>", "()V", "SearchBarConfig", "TitleBarConfig", "Lcom/box/android/base/presentation/components/topbar/CenterSpaceConfig$SearchBarConfig;", "Lcom/box/android/base/presentation/components/topbar/CenterSpaceConfig$TitleBarConfig;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class CenterSpaceConfig {
    public static final int $stable = 0;

    public /* synthetic */ CenterSpaceConfig(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: BoxPrimaryTopBar.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/CenterSpaceConfig$SearchBarConfig;", "Lcom/box/android/base/presentation/components/topbar/CenterSpaceConfig;", "text", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getText", "()Ljava/lang/String;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SearchBarConfig extends CenterSpaceConfig {
        public static final int $stable = 0;
        private final Function0<Unit> onClick;
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchBarConfig(String text, Function0<Unit> onClick) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.text = text;
            this.onClick = onClick;
        }

        public final Function0<Unit> getOnClick() {
            return this.onClick;
        }

        public final String getText() {
            return this.text;
        }
    }

    private CenterSpaceConfig() {
    }

    /* JADX INFO: compiled from: BoxPrimaryTopBar.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/CenterSpaceConfig$TitleBarConfig;", "Lcom/box/android/base/presentation/components/topbar/CenterSpaceConfig;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TitleBarConfig extends CenterSpaceConfig {
        public static final int $stable = 0;
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleBarConfig(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }
}
