package com.box.android.notes.presentation.cpl;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.services.IFavoritesService;
import com.box.android.notes.navigationmodernization.NotesAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesFavoritesViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesFavoritesViewModel;", "Landroidx/lifecycle/ViewModel;", "environment", "Lcom/box/android/notes/presentation/cpl/NotesFavoritesListEnvironment;", "favoritesService", "Lcom/box/android/domain/services/IFavoritesService;", "notesAnalytics", "Lcom/box/android/notes/navigationmodernization/NotesAnalytics;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/notes/presentation/cpl/NotesFavoritesListEnvironment;Lcom/box/android/domain/services/IFavoritesService;Lcom/box/android/notes/navigationmodernization/NotesAnalytics;Lcom/box/android/cpl/IStoreFactory;)V", "notesEnvironment", "Lcom/box/android/notes/presentation/cpl/NotesEnvironment;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$State;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "getInitialState", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotesFavoritesViewModel extends ViewModel {
    public static final int $stable = 8;
    private final NotesFavoritesListEnvironment environment;
    private final NotesEnvironment notesEnvironment;
    private final Store<NotesListReducer.State, NotesListReducer.Action> store;

    @Inject
    public NotesFavoritesViewModel(NotesFavoritesListEnvironment environment, IFavoritesService favoritesService, NotesAnalytics notesAnalytics, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(favoritesService, "favoritesService");
        Intrinsics.checkNotNullParameter(notesAnalytics, "notesAnalytics");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.environment = environment;
        NotesEnvironment notesEnvironment = new NotesEnvironment(environment, favoritesService, notesAnalytics);
        this.notesEnvironment = notesEnvironment;
        Store<NotesListReducer.State, NotesListReducer.Action> storeCreate = storeFactory.create(getInitialState(), new NotesListReducer(notesEnvironment), ViewModelKt.getViewModelScope(this));
        this.store = storeCreate;
        storeCreate.send(NotesListReducer.Action.Init.INSTANCE);
    }

    public final Store<NotesListReducer.State, NotesListReducer.Action> getStore() {
        return this.store;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final NotesListReducer.State getInitialState() {
        boolean z = false;
        ItemsListReducer.State state = new ItemsListReducer.State(null, null, null, FolderModel.Companion.createFromId$default(FolderModel.INSTANCE, "notes-favorites-virtual-folder", null, 2, null), false, null, null, z, MultiselectReducer.State.Unavailable.INSTANCE, null, null, null, null, null, false, false, 65271, null);
        String currentContextId = this.environment.getUserContextManager().getCurrentContextId();
        Intrinsics.checkNotNullExpressionValue(currentContextId, "getCurrentContextId(...)");
        boolean z2 = false;
        return new NotesListReducer.State(state, false, false, currentContextId, false, null, 0 == true ? 1 : 0, z2, z, 498, 0 == true ? 1 : 0);
    }
}
