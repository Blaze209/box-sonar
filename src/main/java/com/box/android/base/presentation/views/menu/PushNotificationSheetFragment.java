package com.box.android.base.presentation.views.menu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.box.android.base.R;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IExecutorPool;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class PushNotificationSheetFragment extends Hilt_PushNotificationSheetFragment {

    @Inject
    protected BoxExtendedApiFile mBoxExtendedApiFile;
    private BoxPushNotification mNotification;

    @Inject
    protected ThumbnailManager mThumbnailManager;

    @Inject
    protected IUserContextManager mUserContextManager;

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.mNotification = (BoxPushNotification) getArguments().getSerializable(BottomSheetMenuFragment.EXTRA_BOX_ITEM);
        return super.onCreateDialog(bundle);
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        BoxFile boxFileSendForCachedResult = null;
        View viewInflate = View.inflate(getContext(), R.layout.file_folder_menu_header, null);
        ((LinearLayout) this.mContentView).addView(viewInflate, 0);
        ((TextView) viewInflate.findViewById(R.id.title)).setText(this.mNotification.getTargetResourceName());
        final ImageView imageView = (ImageView) viewInflate.findViewById(R.id.icon);
        try {
            boxFileSendForCachedResult = this.mBoxExtendedApiFile.getInfoRequest(this.mNotification.getTargetResourceId()).sendForCachedResult();
        } catch (BoxException e) {
            e.printStackTrace();
        }
        if (boxFileSendForCachedResult != null) {
            this.mThumbnailManager.loadThumbnail(boxFileSendForCachedResult, imageView);
        } else {
            BoxFutureTask<E> task = this.mBoxExtendedApiFile.getInfoRequest(this.mNotification.getTargetResourceId()).setFields(BoxApiPrivate.BASE_FIELDS).toTask();
            task.addOnCompletedListener(new BoxFutureTask.OnCompletedListener() { // from class: com.box.android.base.presentation.views.menu.PushNotificationSheetFragment.1
                @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
                public void onCompleted(BoxResponse boxResponse) {
                    if (boxResponse.isSuccess() && imageView.isAttachedToWindow()) {
                        final BoxFile boxFile = (BoxFile) boxResponse.getResult();
                        PushNotificationSheetFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.box.android.base.presentation.views.menu.PushNotificationSheetFragment.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PushNotificationSheetFragment.this.mThumbnailManager.loadThumbnail(boxFile, imageView);
                            }
                        });
                    }
                }
            });
            ((IExecutorPool) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getThumbnailsExecutor().execute(task);
        }
        this.mRecyclerView.setHasFixedSize(true);
    }

    public static PushNotificationSheetFragment newInstance(Activity activity, BoxPushNotification boxPushNotification) {
        Bundle bundle = getBundle(activity, R.menu.push_notification_menu, true);
        bundle.putSerializable(BottomSheetMenuFragment.EXTRA_BOX_ITEM, boxPushNotification);
        PushNotificationSheetFragment pushNotificationSheetFragment = new PushNotificationSheetFragment();
        pushNotificationSheetFragment.setArguments(bundle);
        return pushNotificationSheetFragment;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected void broadcastClick(Intent intent) {
        intent.putExtra(BottomSheetMenuFragment.EXTRA_BOX_ITEM, this.mNotification);
        super.broadcastClick(intent);
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_MORE_OPTIONS_PUSH_NOTIFICATION;
    }
}
