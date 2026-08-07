package com.box.android.activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.utilities.ShortcutHelper;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.File;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class BoxItemShortcutActivity extends Hilt_BoxItemShortcutActivity {
    public static final String BOX_APP_SCHEME = "boxapp";
    public static final String BOX_DIRECT_SCHEME = "boxopendirect";
    public static final String BOX_DIRECT_URL = "url";
    public static final String BOX_EMM_SCHEME = "boxemm";
    public static final String BOX_HOST_TYPE_FILE = "file";
    public static final String BOX_HOST_TYPE_FOLDER = "folder";
    public static final String BOX_ID = "id";

    @Inject
    protected IntentServices mIntentServices;

    @Override // com.box.android.base.presentation.activities.ShortcutEntryActivity
    public int getAuthErrorMessageRes() {
        return R.string.err_login7;
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        String str;
        super.onBoxCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && intent.getData() != null && "boxopendirect".equals(intent.getData().getScheme())) {
            str = BoxAnalyticsParams.REFERRER_MDOTBOX;
        } else {
            str = BoxAnalyticsParams.REFERRER_SHORTCUT;
        }
        BoxAmplitudeAnalytics.getInstance().setReferrer(str);
    }

    private void processIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            Intent launchIntentFromShortcutIntent = getLaunchIntentFromShortcutIntent(intent, this, this.mIntentServices);
            if (launchIntentFromShortcutIntent != null) {
                startActivity(launchIntentFromShortcutIntent);
                return;
            }
            Intent launchIntentFromBoxDirectIntent = getLaunchIntentFromBoxDirectIntent(intent, this, this.mIntentServices);
            if (launchIntentFromBoxDirectIntent != null) {
                startActivity(launchIntentFromBoxDirectIntent);
            }
        }
    }

    public static Intent getLaunchIntentFromShortcutIntent(Intent intent, Context context, IntentServices intentServices) {
        Intent intentFileRouterActivityIntent;
        if (intent == null) {
            return null;
        }
        int intExtra = intent.getIntExtra(BoxCommonConstants.EXTRA_SHORTCUT_TYPE, -1);
        if (intExtra == 2) {
            intentFileRouterActivityIntent = intentServices.mainPhoneActivityIntent(context);
        } else {
            intentFileRouterActivityIntent = intentServices.fileRouterActivityIntent(context, PreviewSource.ItemShortcut.INSTANCE);
        }
        intentFileRouterActivityIntent.setFlags(335544320);
        if (intExtra == 1) {
            intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_INIT_FILE_ID, intent.getStringExtra("fileId"));
            intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_ITEM_NAME, intent.getStringExtra(BoxCommonConstants.EXTRA_FILE_NAME));
            intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, intent.getStringExtra("folderId"));
            intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_INIT_LAUNCH_NEW, true);
            return intentFileRouterActivityIntent;
        }
        if (intExtra == 2) {
            intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, intent.getStringExtra("folderId"));
            return intentFileRouterActivityIntent;
        }
        String stringExtra = intent.getStringExtra(BoxCommonConstants.EXTRA_WEB_LINK_ID);
        if (stringExtra == null) {
            return null;
        }
        intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_INIT_WEB_LINK_ID, stringExtra);
        return intentFileRouterActivityIntent;
    }

    private static boolean isIntentValid(Intent intent) {
        if (intent == null || intent.getScheme() == null) {
            return true;
        }
        return (intent.getScheme().equalsIgnoreCase("boxopendirect") || intent.getScheme().equalsIgnoreCase("boxapp") || intent.getScheme().equalsIgnoreCase("boxemm")) ? false : true;
    }

    public static Intent getLaunchIntentFromBoxDirectIntent(Intent intent, Context context, IntentServices intentServices) {
        if (!isIntentValid(intent) && intent.getData() != null && intent.getData().getHost() != null) {
            if (intent.getData().getHost().equals("file") && intent.getData().getQueryParameter("id") != null) {
                try {
                    Intent intentFileRouterActivityIntent = intentServices.fileRouterActivityIntent(context, PreviewSource.DirectLink.INSTANCE);
                    intentFileRouterActivityIntent.setFlags(335544320);
                    intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_INIT_FILE_ID, intent.getData().getQueryParameter("id"));
                    intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_INIT_LAUNCH_NEW, true);
                    intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_REDIRECT_ON_FAILURE_URL, intent.getData().getQueryParameter("url"));
                    return intentFileRouterActivityIntent;
                } catch (NumberFormatException e) {
                    BoxLogUtils.logException(e);
                }
            } else if (intent.getData().getHost().equals("folder") && intent.getData().getQueryParameter("id") != null) {
                try {
                    Intent intentMainPhoneActivityIntent = intentServices.mainPhoneActivityIntent(context);
                    intentMainPhoneActivityIntent.setFlags(335544320);
                    intentMainPhoneActivityIntent.putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, intent.getData().getQueryParameter("id"));
                    intentMainPhoneActivityIntent.putExtra(IntentConstants.EXTRA_REDIRECT_ON_FAILURE_URL, intent.getData().getQueryParameter("url"));
                    return intentMainPhoneActivityIntent;
                } catch (NumberFormatException e2) {
                    BoxLogUtils.logException(e2);
                }
            }
        }
        return null;
    }

    @Override // com.box.android.base.presentation.activities.ShortcutEntryActivity, com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected void onAuthenticated(BoxUserAuthenticationMessage boxUserAuthenticationMessage) {
        if (boxUserAuthenticationMessage.wasSuccessful()) {
            processIntent();
        }
        super.onAuthenticated(boxUserAuthenticationMessage);
    }

    public static Intent getFolderShortcutIntent(Context context, BoxFolder boxFolder, ThumbnailManager thumbnailManager) {
        Intent intent = new Intent("android.intent.action.MAIN");
        String name = boxFolder.getName();
        intent.setClass(context, BoxItemShortcutActivity.class);
        intent.putExtra(BoxCommonConstants.EXTRA_SHORTCUT_TYPE, 2);
        intent.putExtra("folderId", boxFolder.getUserId());
        intent.putExtra(BoxCommonConstants.EXTRA_FOLDER_NAME, name);
        return buildIntent(context, boxFolder, intent, thumbnailManager);
    }

    public static Intent getWebLinkShortcutIntent(Context context, BoxBookmark boxBookmark, ThumbnailManager thumbnailManager) {
        Intent intent = new Intent("android.intent.action.MAIN");
        String name = boxBookmark.getName();
        intent.setClass(context, BoxItemShortcutActivity.class);
        intent.putExtra(BoxCommonConstants.EXTRA_WEB_LINK_ID, boxBookmark.getUserId());
        intent.putExtra(BoxCommonConstants.EXTRA_WEB_LINK_NAME, name);
        return buildIntent(context, boxBookmark, intent, thumbnailManager);
    }

    public static Intent getFileShortcutIntent(Context context, BoxFile boxFile, ThumbnailManager thumbnailManager) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClass(context, BoxItemShortcutActivity.class);
        intent.putExtra(BoxCommonConstants.EXTRA_SHORTCUT_TYPE, 1);
        intent.putExtra("fileId", boxFile.getUserId());
        if (boxFile.getParent() != null) {
            intent.putExtra("folderId", boxFile.getParent().getUserId());
        }
        intent.putExtra(BoxCommonConstants.EXTRA_FILE_NAME, boxFile.getName());
        return buildIntent(context, boxFile, intent, thumbnailManager);
    }

    private static Bitmap getIcon(Context context, BoxItem boxItem, ThumbnailManager thumbnailManager) {
        File thumbnailForBoxItem;
        Bitmap bitmapDecodeFile = (boxItem.getType().equals("file") && ThumbnailManager.isThumbnailAvailable(boxItem) && (thumbnailForBoxItem = thumbnailManager.getThumbnailForBoxItem(boxItem)) != null && thumbnailForBoxItem.exists() && thumbnailForBoxItem.length() > 0) ? BitmapFactory.decodeFile(thumbnailForBoxItem.getAbsolutePath()) : null;
        if (bitmapDecodeFile == null) {
            bitmapDecodeFile = BitmapFactory.decodeResource(context.getResources(), ThumbnailManager.getDefaultIconResource(boxItem));
        }
        if (bitmapDecodeFile == null) {
            return ShortcutHelper.createShortcutIcon(context, ContextCompat.getDrawable(context, ThumbnailManager.getDefaultIconResource(boxItem)));
        }
        return ShortcutHelper.createShortcutIcon(context, bitmapDecodeFile);
    }

    private static Intent buildIntent(Context context, BoxItem boxItem, Intent intent, ThumbnailManager thumbnailManager) {
        String name = boxItem.getName();
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).createShortcutResultIntent(new ShortcutInfo.Builder(context, name).setShortLabel(name).setLongLabel(name).setIcon(Icon.createWithAdaptiveBitmap(getIcon(context, boxItem, thumbnailManager))).setIntent(intent).build());
    }
}
