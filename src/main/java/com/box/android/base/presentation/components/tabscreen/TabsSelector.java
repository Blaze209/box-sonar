package com.box.android.base.presentation.components.tabscreen;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: CommonTabsScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "channel", "Lkotlinx/coroutines/channels/Channel;", "getChannel$base_generalProdRelease", "()Lkotlinx/coroutines/channels/Channel;", "selectTab", "", "tab", "(Ljava/lang/Object;)V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TabsSelector<T> {
    public static final int $stable = 8;
    private final Channel<T> channel = ChannelKt.Channel$default(-1, null, null, 6, null);

    public final Channel<T> getChannel$base_generalProdRelease() {
        return this.channel;
    }

    public final void selectTab(T tab) {
        this.channel.mo11206trySendJP2dKIU(tab);
    }
}
