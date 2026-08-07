package com.box.androidsdk.content.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.box.android.dataaccess.content.R;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.box.androidsdk.content.models.BoxDownload;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.SdkUtils;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public class BoxAvatarView extends LinearLayout {
    private static final String DEFAULT_NAME = "";
    private static final String EXTRA_AVATAR_CONTROLLER = "extraAvatarController";
    private static final String EXTRA_PARENT = "extraParent";
    private static final String EXTRA_USER = "extraUser";
    private ImageView mAvatar;
    private AvatarController mAvatarController;
    private WeakReference<BoxFutureTask<BoxDownload>> mAvatarDownloadTaskRef;
    private TextView mInitials;
    private BoxCollaborator mUser;

    public interface AvatarController {
        BoxFutureTask<BoxDownload> executeAvatarDownloadRequest(String str, BoxAvatarView boxAvatarView);

        File getAvatarFile(String str);
    }

    public BoxAvatarView(Context context) {
        this(context, null);
    }

    public BoxAvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BoxAvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BoxAvatarView, i, 0);
        View viewInflate = layoutInflaterFrom.inflate(R.layout.boxsdk_avatar_item, (ViewGroup) this, true);
        this.mInitials = (TextView) viewInflate.findViewById(R.id.box_avatar_initials);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.BoxAvatarView_avatarTextSize, 0);
        if (integer != 0) {
            this.mInitials.setTextSize(2, integer);
        }
        View viewFindViewById = viewInflate.findViewById(R.id.avatar_outline);
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.BoxAvatarView_showOutline, false)) {
            viewFindViewById.setBackgroundResource(R.drawable.initials_count_thumb_background);
        } else {
            viewFindViewById.setBackground(null);
        }
        this.mAvatar = (ImageView) viewInflate.findViewById(R.id.box_avatar_image);
    }

    public <T extends Serializable & AvatarController> void loadUser(BoxCollaborator boxCollaborator, T t) {
        if (t != null) {
            this.mAvatarController = t;
        }
        BoxCollaborator boxCollaborator2 = this.mUser;
        if (boxCollaborator2 == null || boxCollaborator == null || !TextUtils.equals(boxCollaborator2.getId(), boxCollaborator.getId())) {
            this.mUser = boxCollaborator;
            WeakReference<BoxFutureTask<BoxDownload>> weakReference = this.mAvatarDownloadTaskRef;
            if (weakReference != null && weakReference.get() != null) {
                try {
                    this.mAvatarDownloadTaskRef.get().cancel(true);
                } catch (Exception unused) {
                }
            }
            updateAvatar();
        }
    }

    protected void updateAvatar() {
        String login;
        int i;
        if (this.mUser == null || this.mAvatarController == null) {
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            post(new Runnable() { // from class: com.box.androidsdk.content.views.BoxAvatarView.1
                @Override // java.lang.Runnable
                public void run() {
                    BoxAvatarView.this.updateAvatar();
                }
            });
            return;
        }
        File avatarFile = this.mAvatarController.getAvatarFile(this.mUser.getId());
        if (avatarFile.exists()) {
            this.mAvatar.setImageDrawable(Drawable.createFromPath(avatarFile.getAbsolutePath()));
            this.mAvatar.setVisibility(0);
            this.mInitials.setVisibility(8);
            return;
        }
        BoxCollaborator boxCollaborator = this.mUser;
        if (boxCollaborator instanceof BoxCollaborator) {
            login = boxCollaborator.getName();
        } else {
            login = "";
            if (SdkUtils.isBlank("")) {
                BoxCollaborator boxCollaborator2 = this.mUser;
                if (boxCollaborator2 instanceof BoxUser) {
                    login = ((BoxUser) boxCollaborator2).getLogin();
                }
            }
        }
        try {
            i = Integer.parseInt(login);
        } catch (NumberFormatException unused) {
            i = 0;
        }
        if (i == 0) {
            SdkUtils.setInitialsThumb(getContext(), this.mInitials, login);
        } else {
            SdkUtils.setCollabNumberThumb(getContext(), this.mInitials, i);
        }
        this.mAvatar.setVisibility(8);
        this.mInitials.setVisibility(0);
        this.mAvatarDownloadTaskRef = new WeakReference<>(this.mAvatarController.executeAvatarDownloadRequest(this.mUser.getId(), this));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_AVATAR_CONTROLLER, (Serializable) this.mAvatarController);
        bundle.putSerializable(EXTRA_USER, this.mUser);
        bundle.putParcelable(EXTRA_PARENT, super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mAvatarController = (AvatarController) bundle.getSerializable(EXTRA_AVATAR_CONTROLLER);
            this.mUser = (BoxCollaborator) bundle.getSerializable(EXTRA_USER);
            super.onRestoreInstanceState(bundle.getParcelable(EXTRA_PARENT));
            if (this.mUser != null) {
                updateAvatar();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
