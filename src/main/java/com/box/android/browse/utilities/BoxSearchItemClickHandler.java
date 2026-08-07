package com.box.android.browse.utilities;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSearchItem;
import com.box.androidsdk.content.models.BoxSession;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BoxSearchItemClickHandler.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/browse/utilities/BoxSearchItemClickHandler;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "itemClickHandler", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/base/presentation/utilities/IItemClickHandler;Landroidx/appcompat/app/AppCompatActivity;)V", "boxSession", "Lcom/box/android/coreservices/models/CustomBoxSession;", ViewProps.ON_CLICK, "", "boxSearchItem", "Lcom/box/androidsdk/content/models/BoxSearchItem;", "item", "Lcom/box/androidsdk/content/models/BoxItem;", "accessibleSharedLink", "", "Factory", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxSearchItemClickHandler {
    public static final int $stable = 8;
    private final AppCompatActivity activity;
    private final CustomBoxSession boxSession;
    private final IItemClickHandler itemClickHandler;

    /* JADX INFO: compiled from: BoxSearchItemClickHandler.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/browse/utilities/BoxSearchItemClickHandler$Factory;", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/browse/utilities/BoxSearchItemClickHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "itemClickHandler", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        BoxSearchItemClickHandler create(AppCompatActivity activity, IItemClickHandler itemClickHandler);
    }

    @AssistedInject
    public BoxSearchItemClickHandler(IUserContextManager userContextManager, @Assisted IItemClickHandler itemClickHandler, @Assisted AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(itemClickHandler, "itemClickHandler");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.itemClickHandler = itemClickHandler;
        this.activity = activity;
        BoxSession boxSession = userContextManager.getBoxSession(activity);
        Intrinsics.checkNotNull(boxSession, "null cannot be cast to non-null type com.box.android.coreservices.models.CustomBoxSession");
        this.boxSession = (CustomBoxSession) boxSession;
    }

    public final void onClick(BoxSearchItem boxSearchItem) {
        Intrinsics.checkNotNullParameter(boxSearchItem, "boxSearchItem");
        BoxItem item = boxSearchItem.getItem();
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        onClick(item, boxSearchItem.getAccessibleSharedLink());
    }

    public final void onClick(BoxItem item, String accessibleSharedLink) {
        Intrinsics.checkNotNullParameter(item, "item");
        String str = (accessibleSharedLink == null || StringsKt.isBlank(accessibleSharedLink)) ? null : accessibleSharedLink;
        if (str != null) {
            this.boxSession.setSharedLink(str);
        }
        if ((item instanceof BoxFile) && str != null) {
            this.itemClickHandler.onFileClick((BoxFile) item, new IItemClickHandler.FileClickConfig(PreviewSource.Search.INSTANCE, str, null, null, null, true, null, false, false, 476, null));
        } else {
            IItemClickHandler.onClick$default(this.itemClickHandler, item, PreviewSource.Search.INSTANCE, null, false, 12, null);
        }
    }
}
