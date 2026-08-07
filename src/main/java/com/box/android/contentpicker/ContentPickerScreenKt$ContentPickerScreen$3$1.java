package com.box.android.contentpicker;

import android.app.Activity;
import android.content.Intent;
import com.box.android.contentpicker.multitabitempicker.ItemPickerTab;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ContentPickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.contentpicker.ContentPickerScreenKt$ContentPickerScreen$3$1", f = "ContentPickerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ContentPickerScreenKt$ContentPickerScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Store<ContentPickerReducer.State, ContentPickerReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContentPickerScreenKt$ContentPickerScreen$3$1(Activity activity, Store<ContentPickerReducer.State, ContentPickerReducer.Action> store, Continuation<? super ContentPickerScreenKt$ContentPickerScreen$3$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContentPickerScreenKt$ContentPickerScreen$3$1(this.$activity, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentPickerScreenKt$ContentPickerScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ContentPickerActivity.Companion companion = ContentPickerActivity.INSTANCE;
        Intent intent = this.$activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        EnumEntries<ItemPickerTab> enabledTabs = companion.parseEnabledTabs(intent);
        if (enabledTabs == null) {
            enabledTabs = ItemPickerTab.getEntries();
        }
        this.$store.send(new ContentPickerReducer.Action.Initialize(enabledTabs));
        return Unit.INSTANCE;
    }
}
