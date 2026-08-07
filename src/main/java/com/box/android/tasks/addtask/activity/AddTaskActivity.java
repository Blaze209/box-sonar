package com.box.android.tasks.addtask.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.WindowManager;
import androidx.activity.EdgeToEdge;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.tasks.addtask.ui.AddTaskScreenKt;
import com.box.android.tasks.addtask.viewmodel.AddTaskViewModel;
import com.box.androidsdk.content.utils.BoxLogUtils;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: AddTaskActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/tasks/addtask/activity/AddTaskActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "viewModel", "Lcom/box/android/tasks/addtask/viewmodel/AddTaskViewModel;", "getViewModel", "()Lcom/box/android/tasks/addtask/viewmodel/AddTaskViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class AddTaskActivity extends Hilt_AddTaskActivity {

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public AddTaskActivity() {
        final AddTaskActivity addTaskActivity = this;
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AddTaskViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.tasks.addtask.activity.AddTaskActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return addTaskActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.tasks.addtask.activity.AddTaskActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return addTaskActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.tasks.addtask.activity.AddTaskActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? addTaskActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    private final AddTaskViewModel getViewModel() {
        return (AddTaskViewModel) this.viewModel.getValue();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        AddTaskActivity addTaskActivity = this;
        EdgeToEdge.enable$default(addTaskActivity, null, null, 3, null);
        super.onMAMCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.5f;
        getWindow().addFlags(2);
        getWindow().setAttributes(attributes);
        Companion companion = INSTANCE;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        if (companion.parseFileModel(intent) == null) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "File argument missing or invalid, finishing Add Task activity");
            finish();
        } else {
            ComponentActivityKt.setContent$default(addTaskActivity, null, ComposableLambdaKt.composableLambdaInstance(-1679901374, true, new Function2() { // from class: com.box.android.tasks.addtask.activity.AddTaskActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskActivity.onCreate$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final AddTaskActivity addTaskActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C53@1991L70,53@1982L79:AddTaskActivity.kt#nylqsa");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1679901374, i, -1, "com.box.android.tasks.addtask.activity.AddTaskActivity.onCreate.<anonymous> (AddTaskActivity.kt:53)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(23011917, true, new Function2() { // from class: com.box.android.tasks.addtask.activity.AddTaskActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskActivity.onCreate$lambda$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(AddTaskActivity addTaskActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C54@2009L38:AddTaskActivity.kt#nylqsa");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(23011917, i, -1, "com.box.android.tasks.addtask.activity.AddTaskActivity.onCreate.<anonymous>.<anonymous> (AddTaskActivity.kt:54)");
            }
            AddTaskScreenKt.AddTaskScreen(addTaskActivity.getViewModel().getStore(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: AddTaskActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/tasks/addtask/activity/AddTaskActivity$Companion;", "", "<init>", "()V", "parseFileModel", "Lcom/box/android/domain/models/item/FileModel;", "Landroid/content/Intent;", "getIntent", "context", "Landroid/content/Context;", "fileModel", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent(Context context, FileModel fileModel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intent intent = new Intent(context, (Class<?>) AddTaskActivity.class);
            intent.putExtra(AddTaskViewModel.EXTRA_FILE_MODEL, fileModel);
            return intent;
        }

        public final FileModel parseFileModel(Intent intent) {
            Parcelable parcelable;
            Intrinsics.checkNotNullParameter(intent, "<this>");
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) intent.getParcelableExtra(AddTaskViewModel.EXTRA_FILE_MODEL, FileModel.class);
            } else {
                Parcelable parcelableExtra = intent.getParcelableExtra(AddTaskViewModel.EXTRA_FILE_MODEL);
                if (!(parcelableExtra instanceof FileModel)) {
                    parcelableExtra = null;
                }
                parcelable = (FileModel) parcelableExtra;
            }
            return (FileModel) parcelable;
        }
    }
}
