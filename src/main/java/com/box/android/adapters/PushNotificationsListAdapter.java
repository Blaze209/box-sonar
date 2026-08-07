package com.box.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.R;
import com.box.android.browse.adapters.BoxItemAdapter;
import com.box.android.browse.fragments.BoxBrowseFragment;
import com.box.android.common.utilities.BoxDateUtils;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.views.BoxAvatarView;
import com.box.boxandroidlibv2private.model.BoxIteratorBoxPushNotification;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
public class PushNotificationsListAdapter extends RecyclerView.Adapter<NotificationViewHolder> {
    protected final Context mContext;
    protected BoxIteratorBoxPushNotification mItems;
    protected final BoxItemAdapter.OnInteractionListener mListener;
    protected IUserContextManager mUserContextManager;

    public PushNotificationsListAdapter(Context context, BoxIteratorBoxPushNotification boxIteratorBoxPushNotification, IUserContextManager iUserContextManager, BoxItemAdapter.OnInteractionListener onInteractionListener) {
        this.mContext = context;
        this.mItems = boxIteratorBoxPushNotification;
        this.mListener = onInteractionListener;
        this.mUserContextManager = iUserContextManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(NotificationViewHolder notificationViewHolder, int i) {
        notificationViewHolder.bindEntity(getPushNotification(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected BoxPushNotification getPushNotification(int i) {
        return (BoxPushNotification) this.mItems.get(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return ((BoxPushNotification) this.mItems.get(i)).getNotifType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        BoxIteratorBoxPushNotification boxIteratorBoxPushNotification = this.mItems;
        if (boxIteratorBoxPushNotification == null) {
            return 0;
        }
        return boxIteratorBoxPushNotification.size();
    }

    public BoxIteratorBoxPushNotification getItems() {
        return this.mItems;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public NotificationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == BoxPushNotification.PushNotifType.COLLAB_INVITE_COLLABORATOR.ordinal()) {
            return new NotificationViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.push_notification_collab_list_item, viewGroup, false));
        }
        return new NotificationViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.push_notification_list_item, viewGroup, false));
    }

    public synchronized void updateItems(BoxIteratorBoxPushNotification boxIteratorBoxPushNotification) {
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new BoxIteratorPushNotificationDiffUtil(boxIteratorBoxPushNotification, this.mItems));
        this.mItems = boxIteratorBoxPushNotification;
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    public class BoxIteratorPushNotificationDiffUtil extends DiffUtil.Callback {
        List<BoxPushNotification> mNewList;
        List<BoxPushNotification> mOldList;

        public BoxIteratorPushNotificationDiffUtil(BoxIteratorBoxPushNotification boxIteratorBoxPushNotification, BoxIteratorBoxPushNotification boxIteratorBoxPushNotification2) {
            if (boxIteratorBoxPushNotification2 == null) {
                this.mOldList = new ArrayList(0);
            } else {
                this.mOldList = boxIteratorBoxPushNotification2.getEntries();
            }
            if (boxIteratorBoxPushNotification == null) {
                this.mNewList = new ArrayList(0);
            } else {
                this.mNewList = boxIteratorBoxPushNotification.getEntries();
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.mOldList.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.mNewList.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i, int i2) {
            return this.mOldList.get(i).getUserId().equals(this.mNewList.get(i2).getUserId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            if (System.currentTimeMillis() - this.mNewList.get(i2).getSentTime().longValue() < TimeUnit.DAYS.toMillis(1L)) {
                return false;
            }
            return this.mOldList.get(i).equals(this.mNewList.get(i2));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public Object getChangePayload(int i, int i2) {
            return super.getChangePayload(i, i2);
        }
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView mDateInfo;
        TextView mDescription;
        ImageButton mMoreOptions;
        View mMuteBadge;
        BoxPushNotification mTargetItem;
        BoxAvatarView mThumbView;
        TextView mTitle;
        View mView;

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }

        public NotificationViewHolder(View view) {
            super(view);
            this.mView = view;
            this.mThumbView = (BoxAvatarView) view.findViewById(R.id.initials);
            this.mDescription = (TextView) this.mView.findViewById(R.id.description);
            this.mDateInfo = (TextView) this.mView.findViewById(R.id.timestamp);
            this.mTitle = (TextView) this.mView.findViewById(R.id.title);
            this.mMuteBadge = this.mView.findViewById(R.id.badge_muted);
            this.mView.setOnClickListener(this);
            this.mMoreOptions = (ImageButton) view.findViewById(R.id.secondaryAction);
        }

        public void bindEntity(BoxPushNotification boxPushNotification) {
            this.mTargetItem = boxPushNotification;
            this.mThumbView.loadUser(boxPushNotification.getDisplayUser(), PushNotificationsListAdapter.this.mUserContextManager.getPreviewStorage().getAvatarController());
            this.mDescription.setText(boxPushNotification.getDisplayMessage().trim());
            this.mDateInfo.setText(getDateString());
            if (boxPushNotification.getMuteTypes() != null && !Objects.equals(boxPushNotification.getNotifType().getMuteCollectionType(), "") && boxPushNotification.getMuteTypes().contains(boxPushNotification.getNotifType().getMuteCollectionType())) {
                this.mMuteBadge.setVisibility(0);
            } else {
                this.mMuteBadge.setVisibility(8);
            }
            TextView textView = this.mTitle;
            if (textView != null) {
                textView.setText(this.mTargetItem.getDisplayTitle());
            }
            this.mMoreOptions.setOnClickListener(this);
            Set<String> muteTypes = boxPushNotification.getMuteTypes();
            if (muteTypes != null && muteTypes.contains(boxPushNotification.getNotifType().getMuteCollectionType())) {
                this.mMoreOptions.setVisibility(0);
            } else {
                this.mMoreOptions.setVisibility(8);
            }
        }

        private String getDateString() {
            Long sentTime = this.mTargetItem.getSentTime();
            if (this.mTargetItem.getModifiedAt() != null) {
                sentTime = Long.valueOf(this.mTargetItem.getModifiedAt().getTime());
            }
            return BoxDateUtils.getRelativeDateTimeStringInPast(PushNotificationsListAdapter.this.mContext, sentTime.longValue(), 60000L, TimeUnit.DAYS.toMillis(2L), 8);
        }

        public TextView getDescription() {
            return this.mDescription;
        }

        public TextView getDateInfo() {
            return this.mDateInfo;
        }

        public BoxAvatarView getAvatarView() {
            return this.mThumbView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.mMoreOptions) {
                BoxBrowseFragment.OnSecondaryActionListener onSecondaryActionListener = PushNotificationsListAdapter.this.mListener.getOnSecondaryActionListener();
                if (onSecondaryActionListener != null) {
                    onSecondaryActionListener.onSecondaryAction(this.mTargetItem);
                    return;
                }
                return;
            }
            if (this.mTargetItem == null || PushNotificationsListAdapter.this.mListener.getOnItemClickListener() == null) {
                return;
            }
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_NOTIFICATION_CENTER_CLICK);
            PushNotificationsListAdapter.this.mListener.getOnItemClickListener().onItemClick(this.mTargetItem);
        }
    }
}
