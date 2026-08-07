package com.box.android.notes.navigationmodernization.tabsscreen;

import androidx.compose.runtime.State;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.notes.navigationmodernization.NotesDestination;
import com.box.android.notes.navigationmodernization.NotesNavigator;
import com.box.android.notes.presentation.cpl.NotesListReducer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NotesTabsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$NotesTabContentScreen$3$1", f = "NotesTabsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class NotesTabsScreenKt$NotesTabContentScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NotesNavigator $navigator;
    final /* synthetic */ Function1<ItemModel, Unit> $onNavigateToNote;
    final /* synthetic */ State<NotesListReducer.State> $state$delegate;
    final /* synthetic */ Store<NotesListReducer.State, NotesListReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NotesTabsScreenKt$NotesTabContentScreen$3$1(Function1<? super ItemModel, Unit> function1, Store<NotesListReducer.State, NotesListReducer.Action> store, NotesNavigator notesNavigator, State<NotesListReducer.State> state, Continuation<? super NotesTabsScreenKt$NotesTabContentScreen$3$1> continuation) {
        super(2, continuation);
        this.$onNavigateToNote = function1;
        this.$store = store;
        this.$navigator = notesNavigator;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotesTabsScreenKt$NotesTabContentScreen$3$1(this.$onNavigateToNote, this.$store, this.$navigator, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotesTabsScreenKt$NotesTabContentScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NotesListReducer.Route navigationRoute = NotesTabsScreenKt.NotesTabContentScreen$lambda$0(this.$state$delegate).getNavigationRoute();
            if (navigationRoute instanceof NotesListReducer.Route.Note) {
                this.$onNavigateToNote.invoke(((NotesListReducer.Route.Note) navigationRoute).getItem());
                this.$store.send(NotesListReducer.Action.NavigationCompleted.INSTANCE);
            } else if (Intrinsics.areEqual(navigationRoute, NotesListReducer.Route.NewNote.INSTANCE)) {
                this.$navigator.navigateTo(NotesDestination.OuterDestination.NewNote.INSTANCE);
                this.$store.send(NotesListReducer.Action.NavigationCompleted.INSTANCE);
            } else if (!Intrinsics.areEqual(navigationRoute, NotesListReducer.Route.None.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
