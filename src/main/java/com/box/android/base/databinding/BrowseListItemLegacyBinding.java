package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;
import com.box.android.base.presentation.views.OfflineBadge;
import com.box.android.base.views.JobStatusView;
import com.google.android.material.imageview.ShapeableImageView;

/* JADX INFO: loaded from: classes9.dex */
public final class BrowseListItemLegacyBinding implements ViewBinding {
    public final LinearLayout badgeChat;
    public final AppCompatTextView badgeChatCount;
    public final FrameLayout badgeCollection;
    public final LinearLayout badgeContainer;
    public final OfflineBadge badgeOffline;
    public final FrameLayout badgeSharedLink;
    public final TextView boxBrowsesdkNameText;
    public final ShapeableImageView boxBrowsesdkThumbImage;
    public final AppCompatCheckBox boxItemCheckBox;
    public final FrameLayout boxItemSelectedLayout;
    public final ImageView icCollectionsLink;
    public final ShapeableImageView icJobIndicator;
    public final JobStatusView jobProgressView;
    public final TextView metalineDescription;
    public final ImageView offlineOverlayBadgeRedesigned;
    public final ImageView parentFolderIcon;
    private final FrameLayout rootView;
    public final AppCompatImageButton secondaryAction;
    public final FrameLayout secondaryContainer;
    public final ProgressBar spinner;
    public final TextView updateButtonRedesigned;

    private BrowseListItemLegacyBinding(FrameLayout frameLayout, LinearLayout linearLayout, AppCompatTextView appCompatTextView, FrameLayout frameLayout2, LinearLayout linearLayout2, OfflineBadge offlineBadge, FrameLayout frameLayout3, TextView textView, ShapeableImageView shapeableImageView, AppCompatCheckBox appCompatCheckBox, FrameLayout frameLayout4, ImageView imageView, ShapeableImageView shapeableImageView2, JobStatusView jobStatusView, TextView textView2, ImageView imageView2, ImageView imageView3, AppCompatImageButton appCompatImageButton, FrameLayout frameLayout5, ProgressBar progressBar, TextView textView3) {
        this.rootView = frameLayout;
        this.badgeChat = linearLayout;
        this.badgeChatCount = appCompatTextView;
        this.badgeCollection = frameLayout2;
        this.badgeContainer = linearLayout2;
        this.badgeOffline = offlineBadge;
        this.badgeSharedLink = frameLayout3;
        this.boxBrowsesdkNameText = textView;
        this.boxBrowsesdkThumbImage = shapeableImageView;
        this.boxItemCheckBox = appCompatCheckBox;
        this.boxItemSelectedLayout = frameLayout4;
        this.icCollectionsLink = imageView;
        this.icJobIndicator = shapeableImageView2;
        this.jobProgressView = jobStatusView;
        this.metalineDescription = textView2;
        this.offlineOverlayBadgeRedesigned = imageView2;
        this.parentFolderIcon = imageView3;
        this.secondaryAction = appCompatImageButton;
        this.secondaryContainer = frameLayout5;
        this.spinner = progressBar;
        this.updateButtonRedesigned = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BrowseListItemLegacyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BrowseListItemLegacyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.browse_list_item_legacy, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BrowseListItemLegacyBinding bind(View view) {
        int i = R.id.badge_chat;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.badge_chat_count;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
            if (appCompatTextView != null) {
                i = R.id.badge_collection;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.badge_container;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.badge_offline;
                        OfflineBadge offlineBadge = (OfflineBadge) ViewBindings.findChildViewById(view, i);
                        if (offlineBadge != null) {
                            i = R.id.badge_shared_link;
                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout2 != null) {
                                i = R.id.box_browsesdk_name_text;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.box_browsesdk_thumb_image;
                                    ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view, i);
                                    if (shapeableImageView != null) {
                                        i = R.id.boxItemCheckBox;
                                        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, i);
                                        if (appCompatCheckBox != null) {
                                            i = R.id.boxItemSelectedLayout;
                                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                            if (frameLayout3 != null) {
                                                i = R.id.ic_collections_link;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView != null) {
                                                    i = R.id.ic_job_indicator;
                                                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) ViewBindings.findChildViewById(view, i);
                                                    if (shapeableImageView2 != null) {
                                                        i = R.id.job_progress_view;
                                                        JobStatusView jobStatusView = (JobStatusView) ViewBindings.findChildViewById(view, i);
                                                        if (jobStatusView != null) {
                                                            i = R.id.metaline_description;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView2 != null) {
                                                                i = R.id.offline_overlay_badge_redesigned;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView2 != null) {
                                                                    i = R.id.parent_folder_icon;
                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView3 != null) {
                                                                        i = R.id.secondaryAction;
                                                                        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                                                                        if (appCompatImageButton != null) {
                                                                            i = R.id.secondaryContainer;
                                                                            FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (frameLayout4 != null) {
                                                                                i = R.id.spinner;
                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                if (progressBar != null) {
                                                                                    i = R.id.update_button_redesigned;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView3 != null) {
                                                                                        return new BrowseListItemLegacyBinding((FrameLayout) view, linearLayout, appCompatTextView, frameLayout, linearLayout2, offlineBadge, frameLayout2, textView, shapeableImageView, appCompatCheckBox, frameLayout3, imageView, shapeableImageView2, jobStatusView, textView2, imageView2, imageView3, appCompatImageButton, frameLayout4, progressBar, textView3);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
