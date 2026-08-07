package com.box.android.coreservices.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.common.providers.LegacyCompatFileProvider;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.dao.NameIdPair;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.localrepo.ISQLHelper;
import com.box.android.domain.localrepo.sqlitetables.BoxFolderSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxItemSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxTypedObjectSQLData;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.utils.MimeTypeHelper;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import com.microsoft.intune.mam.client.identity.MAMPolicyManager;
import com.microsoft.intune.mam.policy.OpenLocation;
import com.microsoft.intune.mam.policy.SaveLocation;
import dagger.hilt.EntryPoints;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: CoreServiceUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002Z[B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001e\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0014\u0010\u0012\u001a\u00020\u000f2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0007J\u0014\u0010\u0016\u001a\u00020\u000f2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0007J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J,\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0007H\u0007J&\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0007H\u0007J\u0018\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010\"2\u0006\u0010)\u001a\u00020*J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020(0,2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020(0,2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/J.\u00101\u001a\b\u0012\u0004\u0012\u00020(0,2\f\u00102\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\u000fH\u0002JV\u00106\u001a\u00020\u001c2\f\u00102\u001a\b\u0012\u0004\u0012\u0002000\"2\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u0002002\u0006\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020(0,2\u0006\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\u000fH\u0002J\u0012\u0010=\u001a\u00020\u000f2\b\u0010>\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0012\u0010@\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u0018\u0010A\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010B\u001a\u00020CH\u0007J$\u0010A\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010E\u001a\u00020\u000fH\u0007J\b\u0010F\u001a\u00020\u000fH\u0007J\u001a\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0007H\u0007J\u001a\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020M2\b\u0010J\u001a\u0004\u0018\u00010\u0007H\u0007J.\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TJ0\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020*2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0007J\u0010\u0010U\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010V\u001a\u00020\u001cH\u0003J\u0010\u0010W\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010W\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020PH\u0007J\u0010\u0010Y\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/box/android/coreservices/utilities/CoreServiceUtils;", "", "<init>", "()V", "MINIMUM_ACCOUNT_UPLOAD_LIMIT", "", CoreServiceUtils.GRAPH_QL_UPDATE_ACTION, "", "getLocalizedItemName", "boxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "context", "Landroid/content/Context;", "getLocalizedUploadItemName", "canOfflineFile", "", "userSharedPrefs", "Landroid/content/SharedPreferences;", "isConnectionIssueException", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "hasShieldPermissionError", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "getConflictResolveName", "fileNameWithExtension", "broadcastIntent", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "intent", "Landroid/content/Intent;", "getLineage", "", "Lcom/box/android/coreservices/jobmanager/dao/NameIdPair;", "itemId", "itemType", "getParentId", "getAllIntentsAvailableToOpenFile", "Lcom/box/android/coreservices/utilities/DisplayResolveInfo;", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "getAvailableIntents", "Ljava/util/ArrayList;", "getDisplayResolveInfos", "resolveInfos", "", "Landroid/content/pm/ResolveInfo;", "processList", "rList", "mPm", "Landroid/content/pm/PackageManager;", "shouldFilter", "processGroup", "start", "end", "ro", "roLabel", "", "mList", "isItemOutsideTree", "item", "logcatIntent", "getNumIntentsAvailableToOpenFile", "getOpenIntent", "file", "Ljava/io/File;", "_mimeType", "getIsScreenCaptureAllowedByMAMPolicy", "getIsPinRequiredByMAMPolicy", "getIsSaveToLocationAllowed", "saveLocation", "Lcom/microsoft/intune/mam/policy/SaveLocation;", "s", "getIsOpenFromLocationAllowed", "openLocation", "Lcom/microsoft/intune/mam/policy/OpenLocation;", "openFileExternally", AbstractJwtRequest.ClaimNames.CTX, "Lcom/box/android/domain/models/item/FileModel;", "notificationServices", "Lcom/box/android/coreservices/services/NotificationServices;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "isRateLimited", "displayRateLimitedToast", "canSeeShareInfo", "fileModel", "unAuthorized", "CoreServiceUtilsEntryPoint", "ErrorType", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CoreServiceUtils {
    public static final String GRAPH_QL_UPDATE_ACTION = "GRAPH_QL_UPDATE_ACTION";
    public static final CoreServiceUtils INSTANCE = new CoreServiceUtils();
    public static final int MINIMUM_ACCOUNT_UPLOAD_LIMIT = 26214400;

    /* JADX INFO: compiled from: CoreServiceUtils.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/box/android/coreservices/utilities/CoreServiceUtils$CoreServiceUtilsEntryPoint;", "", "notificationServices", "Lcom/box/android/coreservices/services/NotificationServices;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface CoreServiceUtilsEntryPoint {
        NotificationServices notificationServices();
    }

    private CoreServiceUtils() {
    }

    @JvmStatic
    public static final String getLocalizedItemName(BoxItem boxItem, Context context) {
        Intrinsics.checkNotNullParameter(boxItem, "boxItem");
        Intrinsics.checkNotNullParameter(context, "context");
        return ((boxItem instanceof BoxFolder) && Intrinsics.areEqual("0", ((BoxFolder) boxItem).getUserId())) ? context.getString(R.string.files) : boxItem.getName();
    }

    @JvmStatic
    public static final String getLocalizedUploadItemName(BoxItem boxItem, Context context) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strLS = CommonBoxUtil.LS(R.string.upload_to_x);
        Intrinsics.checkNotNull(boxItem);
        Intrinsics.checkNotNull(context);
        String str = String.format(strLS, Arrays.copyOf(new Object[]{getLocalizedItemName(boxItem, context)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @JvmStatic
    public static final boolean canOfflineFile(BoxItem boxItem, SharedPreferences userSharedPrefs) {
        EnumSet<BoxItem.Permission> permissions;
        if (boxItem == null || (permissions = boxItem.getPermissions()) == null) {
            return false;
        }
        return permissions.contains(BoxItem.Permission.CAN_DOWNLOAD) || (((boxItem instanceof BoxFolder) || (SupportedFileExtensions.INSTANCE.isSupportedExtension(CommonBoxUtil.getFileExtension(boxItem.getName(), "")) && permissions.contains(BoxItem.Permission.CAN_PREVIEW))) && (userSharedPrefs != null ? BoxAccountManager.isMobilePreviewOnlyOffliningEnabled(userSharedPrefs) : false));
    }

    @JvmStatic
    public static final boolean isConnectionIssueException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if ((exception instanceof IOException) && !(exception instanceof FileNotFoundException)) {
            if (exception.getCause() != null) {
                return exception.getCause() instanceof UnknownHostException;
            }
            return true;
        }
        if (!(exception instanceof BoxException)) {
            return false;
        }
        Throwable cause = exception.getCause();
        return (cause instanceof IOException) && !(cause instanceof FileNotFoundException);
    }

    @JvmStatic
    public static final boolean hasShieldPermissionError(BoxMessage<?> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message instanceof BoxResponseMessage) {
            BoxResponseMessage boxResponseMessage = (BoxResponseMessage) message;
            if (boxResponseMessage.getException() instanceof BoxException) {
                Exception exception = boxResponseMessage.getException();
                Intrinsics.checkNotNull(exception, "null cannot be cast to non-null type com.box.androidsdk.content.BoxException");
                if (((BoxException) exception).getErrorType() == BoxException.ErrorType.FORBIDDEN_DUE_TO_SHIELD_POLICY) {
                    return true;
                }
            }
        }
        return false;
    }

    @JvmStatic
    public static final String getConflictResolveName(String fileNameWithExtension) {
        Intrinsics.checkNotNullParameter(fileNameWithExtension, "fileNameWithExtension");
        String[] fileNameAndExt = CommonBoxUtil.getFileNameAndExt(fileNameWithExtension);
        String str = fileNameAndExt[0];
        String str2 = fileNameAndExt[1];
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, Soundex.SILENT_MARKER, 0, false, 6, (Object) null);
        String str3 = "-1";
        if (iLastIndexOf$default > 0) {
            try {
                String strSubstring = str.substring(iLastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                str3 = CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + Integer.toString(Integer.parseInt(strSubstring) + 1);
                String strSubstring2 = fileNameWithExtension.substring(0, iLastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                str = strSubstring2;
            } catch (Exception e) {
                BoxLogUtils.e("getAutoRenamedFileName", e);
            }
        }
        String str4 = str + str3 + str2;
        Intrinsics.checkNotNullExpressionValue(str4, "toString(...)");
        return str4;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.box.android.coreservices.utilities.CoreServiceUtils$broadcastIntent$1] */
    @JvmStatic
    public static final void broadcastIntent(final IUserContextManager userContextManager, final Intent intent) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            CommonBoxUtil.dumpIntent(intent, Controller.class.getName());
            if (intent instanceof BoxMessage) {
                BoxMessage boxMessage = (BoxMessage) intent;
                if (boxMessage.getException() != null) {
                    Exception exception = boxMessage.getException();
                    Intrinsics.checkNotNullExpressionValue(exception, "getException(...)");
                    BoxLogUtils.logException(exception);
                }
            }
        }
        CoreServiceUtils coreServiceUtils = INSTANCE;
        if (coreServiceUtils.isRateLimited(intent)) {
            coreServiceUtils.displayRateLimitedToast();
        }
        if (coreServiceUtils.unAuthorized(intent)) {
            new Thread() { // from class: com.box.android.coreservices.utilities.CoreServiceUtils.broadcastIntent.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Intent intent2 = intent;
                    Intrinsics.checkNotNull(intent2, "null cannot be cast to non-null type com.box.android.coreservices.modelcontroller.messages.BoxMessage<*>");
                    Exception exception2 = ((BoxMessage) intent2).getException();
                    Intrinsics.checkNotNull(exception2, "null cannot be cast to non-null type com.box.androidsdk.content.BoxException");
                    BoxLogUtils.e(IUserContextManager.LOGOUT_CURRENT_USER, "Token refresh failed. Cause: " + ((BoxException) exception2).getErrorType());
                    IUserContextManager iUserContextManager = userContextManager;
                    iUserContextManager.destroyUser(iUserContextManager.getCurrentContextId());
                }
            }.start();
        } else {
            LocalBroadcastManager.getInstance(ApplicationProvider.getApplication()).sendBroadcast(intent);
        }
    }

    @JvmStatic
    public static final List<NameIdPair> getLineage(IUserContextManager userContextManager, String itemId, String itemType) throws SQLException {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        ArrayList arrayList = new ArrayList();
        try {
            ISQLHelper sQLHelper = userContextManager.getCurrentContext().getSQLHelper();
            BoxTypedObjectSQLData boxTypedObjectSQLDataQueryForId = sQLHelper.getQueryManager().queryForId(sQLHelper.getDao(itemType).getDataClass(), itemId);
            Intrinsics.checkNotNull(boxTypedObjectSQLDataQueryForId, "null cannot be cast to non-null type com.box.android.domain.localrepo.sqlitetables.BoxItemSQLData");
            BoxItemSQLData boxItemSQLData = (BoxItemSQLData) boxTypedObjectSQLDataQueryForId;
            while (boxItemSQLData != null && !StringUtils.isBlank(boxItemSQLData.getParentId())) {
                boxItemSQLData = (BoxItemSQLData) sQLHelper.getQueryManager().queryForId(BoxFolderSQLData.class, boxItemSQLData.getParentId());
                if (boxItemSQLData != null) {
                    if (Intrinsics.areEqual(((BoxFolderSQLData) boxItemSQLData).getId(), "0")) {
                        arrayList.add(new NameIdPair(CommonBoxUtil.LS(R.string.files), ((BoxFolderSQLData) boxItemSQLData).getId()));
                        return arrayList;
                    }
                    arrayList.add(new NameIdPair(((BoxFolderSQLData) boxItemSQLData).getName(), ((BoxFolderSQLData) boxItemSQLData).getId()));
                }
            }
            return arrayList;
        } catch (Exception e) {
            BoxLogUtils.logException(e);
            return arrayList;
        }
    }

    @JvmStatic
    public static final String getParentId(IUserContextManager userContextManager, String itemId, String itemType) throws SQLException {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        ISQLHelper sQLHelper = userContextManager.getCurrentContext().getSQLHelper();
        BoxTypedObjectSQLData boxTypedObjectSQLDataQueryForId = sQLHelper.getQueryManager().queryForId(sQLHelper.getDao(itemType).getDataClass(), itemId);
        BoxItemSQLData boxItemSQLData = boxTypedObjectSQLDataQueryForId instanceof BoxItemSQLData ? (BoxItemSQLData) boxTypedObjectSQLDataQueryForId : null;
        if (boxItemSQLData != null) {
            return boxItemSQLData.getParentId();
        }
        return null;
    }

    public final List<DisplayResolveInfo> getAllIntentsAvailableToOpenFile(BoxFile boxFile) {
        Intrinsics.checkNotNullParameter(boxFile, "boxFile");
        File file = new File("/non_existent_faux_folder/", boxFile.getName());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), MimeTypeHelper.getTypeFromExt(CommonBoxUtil.getFileExtension(boxFile.getName(), "")));
        return getAvailableIntents(intent);
    }

    @JvmStatic
    public static final ArrayList<DisplayResolveInfo> getAvailableIntents(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        PackageManager packageManager = ApplicationProvider.getApplication().getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(packageManager, intent, 65600);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        ArrayList<DisplayResolveInfo> arrayListProcessList$default = processList$default(INSTANCE, listQueryIntentActivities, packageManager, false, 4, null);
        if (arrayListProcessList$default.isEmpty()) {
            return new ArrayList<>(0);
        }
        HashSet hashSet = new HashSet(arrayListProcessList$default.size());
        Iterator<DisplayResolveInfo> it = arrayListProcessList$default.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            DisplayResolveInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            DisplayResolveInfo displayResolveInfo = next;
            if (hashSet.contains(displayResolveInfo.getPackageName())) {
                it.remove();
            } else {
                hashSet.add(displayResolveInfo.getPackageName());
            }
        }
        return arrayListProcessList$default;
    }

    public final ArrayList<DisplayResolveInfo> getDisplayResolveInfos(List<ResolveInfo> resolveInfos) {
        Intrinsics.checkNotNullParameter(resolveInfos, "resolveInfos");
        PackageManager packageManager = ApplicationProvider.getApplication().getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        return processList(resolveInfos, packageManager, false);
    }

    static /* synthetic */ ArrayList processList$default(CoreServiceUtils coreServiceUtils, List list, PackageManager packageManager, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return coreServiceUtils.processList(list, packageManager, z);
    }

    private final ArrayList<DisplayResolveInfo> processList(List<ResolveInfo> rList, PackageManager mPm, boolean shouldFilter) {
        List<ResolveInfo> list = rList;
        PackageManager packageManager = mPm;
        ArrayList<DisplayResolveInfo> arrayList = new ArrayList<>();
        int size = list.size();
        if (size > 0) {
            int i = 0;
            ResolveInfo resolveInfo = list.get(0);
            int i2 = size;
            for (int i3 = 1; i3 < size; i3++) {
                ResolveInfo resolveInfo2 = list.get(i3);
                if (resolveInfo.priority != resolveInfo2.priority || resolveInfo.isDefault != resolveInfo2.isDefault) {
                    while (i3 < i2) {
                        list.remove(i3);
                        i2--;
                    }
                }
            }
            if (i2 > 1) {
                Collections.sort(list, new ResolveInfo.DisplayNameComparator(packageManager));
            }
            ResolveInfo resolveInfo3 = list.get(0);
            CharSequence charSequenceLoadLabel = resolveInfo3.loadLabel(packageManager);
            Intrinsics.checkNotNullExpressionValue(charSequenceLoadLabel, "loadLabel(...)");
            ResolveInfo resolveInfo4 = resolveInfo3;
            CharSequence charSequence = charSequenceLoadLabel;
            int i4 = 1;
            while (i4 < i2) {
                ResolveInfo resolveInfo5 = list.get(i4);
                CharSequence charSequenceLoadLabel2 = resolveInfo5.loadLabel(packageManager);
                Intrinsics.checkNotNullExpressionValue(charSequenceLoadLabel2, "loadLabel(...)");
                if (!Intrinsics.areEqual(charSequenceLoadLabel2, charSequence)) {
                    processGroup(list, i, i4 - 1, resolveInfo4, charSequence, arrayList, packageManager, shouldFilter);
                    i = i4;
                    resolveInfo4 = resolveInfo5;
                    charSequence = charSequenceLoadLabel2;
                }
                i4++;
                list = rList;
                packageManager = mPm;
            }
            processGroup(rList, i, i2 - 1, resolveInfo4, charSequence, arrayList, mPm, shouldFilter);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processGroup(List<? extends ResolveInfo> rList, int start, int end, ResolveInfo ro, CharSequence roLabel, ArrayList<DisplayResolveInfo> mList, PackageManager mPm, boolean shouldFilter) {
        if (Intrinsics.areEqual(ApplicationProvider.getApplication().getPackageName(), ro.activityInfo.packageName) && shouldFilter) {
            return;
        }
        boolean z = true;
        if ((end - start) + 1 == 1) {
            mList.add(new DisplayResolveInfo(ro, roLabel, null));
            return;
        }
        CharSequence charSequenceLoadLabel = ro.activityInfo.applicationInfo.loadLabel(mPm);
        Intrinsics.checkNotNullExpressionValue(charSequenceLoadLabel, "loadLabel(...)");
        HashSet hashSet = new HashSet();
        hashSet.add(charSequenceLoadLabel);
        int i = start + 1;
        if (i > end) {
            z = false;
            break;
        }
        while (true) {
            CharSequence charSequenceLoadLabel2 = rList.get(i).activityInfo.applicationInfo.loadLabel(mPm);
            Intrinsics.checkNotNullExpressionValue(charSequenceLoadLabel2, "loadLabel(...)");
            if (!hashSet.contains(charSequenceLoadLabel2)) {
                hashSet.add(charSequenceLoadLabel2);
                if (i == end) {
                    z = false;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        hashSet.clear();
        if (start > end) {
            return;
        }
        while (true) {
            ResolveInfo resolveInfo = rList.get(start);
            if (!Intrinsics.areEqual(ApplicationProvider.getApplication().getPackageName(), resolveInfo.activityInfo.packageName)) {
                if (z) {
                    mList.add(new DisplayResolveInfo(resolveInfo, roLabel, resolveInfo.activityInfo.packageName));
                } else {
                    mList.add(new DisplayResolveInfo(resolveInfo, roLabel, resolveInfo.activityInfo.applicationInfo.loadLabel(mPm)));
                }
            }
            if (start == end) {
                return;
            } else {
                start++;
            }
        }
    }

    @JvmStatic
    public static final boolean isItemOutsideTree(BoxItem item) {
        if (item != null && item.getPathCollection() != null) {
            List entries = item.getPathCollection().getEntries();
            Intrinsics.checkNotNullExpressionValue(entries, "getEntries(...)");
            List list = entries;
            if (!list.isEmpty() && Intrinsics.areEqual(((BoxFolder) list.get(0)).getUserId(), "0")) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final void logcatIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            Log.i("BOX", "action: " + intent.getAction());
            Log.i("BOX", "package: " + intent.getPackage());
            Log.i("BOX", "component: " + intent.getComponent());
            Log.i("BOX", "data: " + intent.getDataString());
            Log.i("BOX", "type: " + intent.getType());
            if (intent instanceof BoxResponseMessage) {
                BoxResponseMessage boxResponseMessage = (BoxResponseMessage) intent;
                Log.i("BoxRequest ", "request " + boxResponseMessage.getRequest());
                if (boxResponseMessage.getResponse().getResult() instanceof BoxJsonObject) {
                    BoxObject result = boxResponseMessage.getResponse().getResult();
                    Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxJsonObject");
                    Log.i("BoxResponse ", "result " + ((BoxJsonObject) result).toJson());
                }
                if (boxResponseMessage.getException() != null) {
                    boxResponseMessage.getException().printStackTrace();
                }
            }
            if (intent.getExtras() == null) {
                return;
            }
            Bundle extras = intent.getExtras();
            Intrinsics.checkNotNull(extras);
            for (String str : extras.keySet()) {
                Bundle extras2 = intent.getExtras();
                Intrinsics.checkNotNull(extras2);
                Log.i("BOX", "extra: " + str + " => " + extras2.get(str));
            }
        }
    }

    @JvmStatic
    public static final int getNumIntentsAvailableToOpenFile(BoxFile boxFile) {
        CoreServiceUtils coreServiceUtils = INSTANCE;
        Intrinsics.checkNotNull(boxFile);
        List<DisplayResolveInfo> allIntentsAvailableToOpenFile = coreServiceUtils.getAllIntentsAvailableToOpenFile(boxFile);
        if (allIntentsAvailableToOpenFile == null) {
            return 0;
        }
        return allIntentsAvailableToOpenFile.size();
    }

    @JvmStatic
    public static final Intent getOpenIntent(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(file.getName()));
        if (mimeTypeFromExtension == null) {
            mimeTypeFromExtension = "*/*";
        }
        return getOpenIntent(context, file, mimeTypeFromExtension);
    }

    @JvmStatic
    public static final Intent getOpenIntent(Context context, File file, String _mimeType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Context applicationContext = context.getApplicationContext();
        String string = context.getResources().getString(R.string.fileProviderAuthority);
        Intrinsics.checkNotNull(file);
        Uri uriForFile = FileProvider.getUriForFile(applicationContext, string, file);
        LegacyCompatFileProvider.addUriMapping(uriForFile, file);
        intent.setDataAndType(uriForFile, _mimeType);
        intent.setFlags(3);
        return intent;
    }

    @JvmStatic
    public static final boolean getIsScreenCaptureAllowedByMAMPolicy() {
        return MAMPolicyManager.getCurrentThreadPolicy().getIsScreenCaptureAllowed();
    }

    @JvmStatic
    public static final boolean getIsPinRequiredByMAMPolicy() {
        return MAMPolicyManager.getCurrentThreadPolicy().getIsPinRequired();
    }

    @JvmStatic
    public static final boolean getIsSaveToLocationAllowed(SaveLocation saveLocation, String s) {
        Intrinsics.checkNotNullParameter(saveLocation, "saveLocation");
        return MAMPolicyManager.getCurrentThreadPolicy().getIsSaveToLocationAllowedForOID(saveLocation, s);
    }

    @JvmStatic
    public static final boolean getIsOpenFromLocationAllowed(OpenLocation openLocation, String s) {
        Intrinsics.checkNotNullParameter(openLocation, "openLocation");
        return MAMPolicyManager.getCurrentThreadPolicy().getIsOpenFromLocationAllowedForOID(openLocation, s);
    }

    public final void openFileExternally(Context ctx, IUserContextManager userContextManager, FileModel file, NotificationServices notificationServices, IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(notificationServices, "notificationServices");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        openFileExternally(ctx, userContextManager, FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, file, false, 1, null), notificationServices, intentServices);
    }

    @JvmStatic
    public static final void openFileExternally(Context ctx, IUserContextManager userContextManager, BoxFile file, NotificationServices notificationServices, IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(notificationServices, "notificationServices");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        IUserContextComponent userContextComponent = userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_SHARED_PREFERENCES);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.domain.localrepo.ILocalSharedPreferences");
        SharedPreferences sharedPreferences = ((ILocalSharedPreferences) userContextComponent).getSharedPreferences();
        if (getNumIntentsAvailableToOpenFile(file) < 1) {
            int i = R.string.err_app;
            Context applicationContext = ApplicationProvider.getApplication().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            notificationServices.displayToast(i, applicationContext);
            return;
        }
        if (!getIsSaveToLocationAllowed(SaveLocation.LOCAL, null) || BoxAccountManager.isSaveOnDeviceAdminDisabled(sharedPreferences) || !BoxAccountManager.isMobileOpenInEnabled(userContextManager)) {
            notificationServices.displayDialog(R.string.Feature_disabled, R.string.This_feature_has_been_disabled_by_your_or_your_administrator);
            return;
        }
        if (BoxAccountManager.doesSaveOnDeviceRequireEncryptedDevice(sharedPreferences)) {
            notificationServices.displayDialog(R.string.Feature_disabled, R.string.Encrypted_device_requird_for_this_feature);
            return;
        }
        if (Permissions.hasPermission(file, Permissions.ACTION.DOWNLOAD, false, sharedPreferences)) {
            String externalStorageState = Environment.getExternalStorageState();
            if (externalStorageState != null) {
                if (Intrinsics.areEqual(externalStorageState, "mounted")) {
                    ctx.startActivity(intentServices.openFileIntent(ctx, file, null));
                    return;
                }
                int i2 = R.string.toast_sdcard1;
                Context applicationContext2 = ApplicationProvider.getApplication().getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                notificationServices.displayToast(i2, applicationContext2);
                return;
            }
            return;
        }
        int i3 = R.string.you_do_not_have_permission_to_open_or_download_this_item;
        Context applicationContext3 = ApplicationProvider.getApplication().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
        notificationServices.displayToast(i3, applicationContext3);
    }

    private final boolean isRateLimited(Intent intent) {
        Integer status;
        if (intent instanceof BoxMessage) {
            Exception exception = ((BoxMessage) intent).getException();
            if (exception instanceof BoxException) {
                BoxException boxException = (BoxException) exception;
                if (boxException.getAsBoxError() != null && (status = boxException.getAsBoxError().getStatus()) != null && 429 == status.intValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void displayRateLimitedToast() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.coreservices.utilities.CoreServiceUtils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CoreServiceUtils.displayRateLimitedToast$lambda$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayRateLimitedToast$lambda$0() {
        Toast toastMakeText = Toast.makeText(ApplicationProvider.getApplication(), R.string.Box_is_temporarily_busy, 1);
        Intrinsics.checkNotNullExpressionValue(toastMakeText, "makeText(...)");
        toastMakeText.setGravity(48, 0, 10);
        Object obj = EntryPoints.get(ApplicationProvider.getApplication(), CoreServiceUtilsEntryPoint.class);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        ((CoreServiceUtilsEntryPoint) obj).notificationServices().displayToast(toastMakeText, CommonBoxUtil.LS(R.string.Box_is_temporarily_busy), ApplicationProvider.getApplication());
    }

    @JvmStatic
    public static final boolean canSeeShareInfo(BoxItem boxItem) {
        Intrinsics.checkNotNullParameter(boxItem, "boxItem");
        EnumSet<BoxItem.Permission> permissions = boxItem.getPermissions();
        return (!(permissions != null ? permissions.contains(BoxItem.Permission.CAN_SHARE) : false) && isItemOutsideTree(boxItem) && boxItem.getSharedLink() == null) ? false : true;
    }

    @JvmStatic
    public static final boolean canSeeShareInfo(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        return canSeeShareInfo(ItemModelMapper.INSTANCE.toBoxItem(fileModel, true));
    }

    private final boolean unAuthorized(Intent intent) {
        if (intent instanceof BoxMessage) {
            Exception exception = ((BoxMessage) intent).getException();
            if ((exception instanceof BoxException.RefreshFailure) && ((BoxException.RefreshFailure) exception).isErrorFatal()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.box.android.coreservices.utilities.CoreServiceUtils$ErrorType, still in use, count: 1, list:
      (r0v0 com.box.android.coreservices.utilities.CoreServiceUtils$ErrorType) from 0x0358: INVOKE 
      (r14v60 java.util.HashMap<java.lang.String, com.box.android.coreservices.utilities.CoreServiceUtils$ErrorType>)
      (wrap java.lang.String:SGET  A[WRAPPED] com.box.android.coreservices.utilities.APIErrorStringProvider.ERROR_INVITE_COLLAB_PERMISSION java.lang.String)
      (r0v0 com.box.android.coreservices.utilities.CoreServiceUtils$ErrorType)
     INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:823)
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: CoreServiceUtils.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\bH\b\u0086\u0081\u0002\u0018\u0000 H2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001HB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bG¨\u0006I"}, d2 = {"Lcom/box/android/coreservices/utilities/CoreServiceUtils$ErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "ACCESS_DENIED_ERR", "ITEM_LOCKED_ERR", "TERMS_OF_SERVICE_REQUIRED_ERR", "INCORRECT_SHARED_ITEM_PASSWORD_ERR", "SETTINGS_NOT_ALLOWED_ERR", "FILE_IS_STREAM_ONLY", "CANNOT_DOWNLOAD_EXECUTABLES", "ENTERPRISE_NOT_PUBLISHED_ERR", "CANNOT_EDIT_DIFFERENT_SERVICE_ERR", "BREADTH_LIMIT_EXCEEDED", "DEPTH_LIMIT_EXCEEDED", "USER_CANNOT_BE_UPGRADED_ERR", "CANNOT_REUSE_RECEIPT_ERR", "UNVERIFIED_RECEIPT_ERR", "FILESIZE_LIMIT_ERR", "ACCOUNT_SPACE_ERR", "PENDING_INSTANT_MODE_FOLDER_SIZE_LIMIT_ERR", "BOX_API_INSUFFICIENT_STORAGE_ERR", "USER_EMAIL_CONFIRMATION_REQUIRED", "ACCESS_FROM_LOCATION_BLOCKED", "ACCESS_OPERATION_NOT_ALLOWED", "OPERATION_LIMIT_EXCEEDED_ERR", "OPERATION_LIMIT_EXCEEDED_ENT_SETTING_ERR", "INVALID_PARAMETERS_ERR", "FOLDER_NOT_EMPTY_ERR", "NAME_INVALID_ERR", "NAME_TOO_LONG_ERR", "NAME_EXISTS_ERR", "PUSH_NOTIFICATION_DEVICE_EXISTS_ERR", "INVALID_KEY_ERR", "INVALID_AUTH_TOKEN_ERR", "CYCLICAL_FOLDER_STRUCTURE_ERR", "SYNC_ITEM_MOVE_ERR", "COLLAB_ITEM_MOVE_ERR", "COLLAB_ITEM_MAKE_COLLABED_SUBFOLDER_PRIVATE_ERR", "RATE_LIMIT_EXCEEDED_ERR", "SIMILAR_COMMENT_ERR", "IF_MATCH_MISSING_ERR", "REQUESTED_PREVIEW_UNAVAILABLE_ERR", "PREVIEW_CONVERSION_FAILED_ERR", "COLLABORATIONS_NOT_AVAILABLE_ON_ROOT_ERR", "USER_ALREADY_COLLABORATOR_ERR", "STRONG_PASSWORD_REQUIRED_FOR_COLLABORATION_ERR", "COLLABORATION_STATUS_CHANGE_INVALID_ERR", "CANNOT_INVITE_SELF_AS_COLLABORATOR_ERR", "CANNOT_INVITE_DEACTIVATED_USER", "COLLABORATION_ROLE_UNAVAILABLE_ERR", "INVALID_COLLABORATION_ITEM_ERR", "NEW_OWNER_NOT_COLLABORATOR_ERR", "INVALID_COLLABORATION_ROLE_ERR", "EXTERNAL_COLLAB_RESTRICTED_ERR", "TERMS_OF_SERVICE_ERR", "INVALID_AUTHORIZATION_HEADER", "REQUESTED_REPRESENTATION_PAGE_OUT_OF_RANGE_ERR", "BAD_DIGEST_ERR", "INVALID_DIGEST_ERR", "PRECONDITION_FAILED_ERR", "METHOD_NOT_ALLOWED_ERR", "USER_EXISTS_ERR", "FILE_NOT_READY", "TRASHED_ERR", "NOT_TRASHED_ERR", "INVALID_RECEIPT_ERR", "TASK_ASSIGNEE_NOT_ALLOWED_ERR", "SHARED_ITEM_LOGIN_REQUIRED", "OPERATION_BLOCKED_TEMPORARY", "INVALID_ROLE_FOR_SINGLE_FILE_COLLAB", "OTHER", "Companion", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ErrorType {
        ACCESS_DENIED_ERR,
        ITEM_LOCKED_ERR,
        TERMS_OF_SERVICE_REQUIRED_ERR,
        INCORRECT_SHARED_ITEM_PASSWORD_ERR,
        SETTINGS_NOT_ALLOWED_ERR,
        FILE_IS_STREAM_ONLY,
        CANNOT_DOWNLOAD_EXECUTABLES,
        ENTERPRISE_NOT_PUBLISHED_ERR,
        CANNOT_EDIT_DIFFERENT_SERVICE_ERR,
        BREADTH_LIMIT_EXCEEDED,
        DEPTH_LIMIT_EXCEEDED,
        USER_CANNOT_BE_UPGRADED_ERR,
        CANNOT_REUSE_RECEIPT_ERR,
        UNVERIFIED_RECEIPT_ERR,
        FILESIZE_LIMIT_ERR,
        ACCOUNT_SPACE_ERR,
        PENDING_INSTANT_MODE_FOLDER_SIZE_LIMIT_ERR,
        BOX_API_INSUFFICIENT_STORAGE_ERR,
        USER_EMAIL_CONFIRMATION_REQUIRED,
        ACCESS_FROM_LOCATION_BLOCKED,
        ACCESS_OPERATION_NOT_ALLOWED,
        OPERATION_LIMIT_EXCEEDED_ERR,
        OPERATION_LIMIT_EXCEEDED_ENT_SETTING_ERR,
        INVALID_PARAMETERS_ERR,
        FOLDER_NOT_EMPTY_ERR,
        NAME_INVALID_ERR,
        NAME_TOO_LONG_ERR,
        NAME_EXISTS_ERR,
        PUSH_NOTIFICATION_DEVICE_EXISTS_ERR,
        INVALID_KEY_ERR,
        INVALID_AUTH_TOKEN_ERR,
        CYCLICAL_FOLDER_STRUCTURE_ERR,
        SYNC_ITEM_MOVE_ERR,
        COLLAB_ITEM_MOVE_ERR,
        COLLAB_ITEM_MAKE_COLLABED_SUBFOLDER_PRIVATE_ERR,
        RATE_LIMIT_EXCEEDED_ERR,
        SIMILAR_COMMENT_ERR,
        IF_MATCH_MISSING_ERR,
        REQUESTED_PREVIEW_UNAVAILABLE_ERR,
        PREVIEW_CONVERSION_FAILED_ERR,
        COLLABORATIONS_NOT_AVAILABLE_ON_ROOT_ERR,
        USER_ALREADY_COLLABORATOR_ERR,
        STRONG_PASSWORD_REQUIRED_FOR_COLLABORATION_ERR,
        COLLABORATION_STATUS_CHANGE_INVALID_ERR,
        CANNOT_INVITE_SELF_AS_COLLABORATOR_ERR,
        CANNOT_INVITE_DEACTIVATED_USER,
        COLLABORATION_ROLE_UNAVAILABLE_ERR,
        INVALID_COLLABORATION_ITEM_ERR,
        NEW_OWNER_NOT_COLLABORATOR_ERR,
        INVALID_COLLABORATION_ROLE_ERR,
        EXTERNAL_COLLAB_RESTRICTED_ERR,
        TERMS_OF_SERVICE_ERR,
        INVALID_AUTHORIZATION_HEADER,
        REQUESTED_REPRESENTATION_PAGE_OUT_OF_RANGE_ERR,
        BAD_DIGEST_ERR,
        INVALID_DIGEST_ERR,
        PRECONDITION_FAILED_ERR,
        METHOD_NOT_ALLOWED_ERR,
        USER_EXISTS_ERR,
        FILE_NOT_READY,
        TRASHED_ERR,
        NOT_TRASHED_ERR,
        INVALID_RECEIPT_ERR,
        TASK_ASSIGNEE_NOT_ALLOWED_ERR,
        SHARED_ITEM_LOGIN_REQUIRED,
        OPERATION_BLOCKED_TEMPORARY,
        INVALID_ROLE_FOR_SINGLE_FILE_COLLAB,
        OTHER;

        private static final /* synthetic */ EnumEntries $ENTRIES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private static final HashMap<String, ErrorType> ERROR_CODE_MAP;

        public static EnumEntries<ErrorType> getEntries() {
            return $ENTRIES;
        }

        public static ErrorType valueOf(String str) {
            return (ErrorType) Enum.valueOf(ErrorType.class, str);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) $VALUES.clone();
        }

        private ErrorType() {
            super(str, i);
        }

        static {
            ErrorType errorType = ACCESS_FROM_LOCATION_BLOCKED;
            ErrorType errorType2 = ACCESS_OPERATION_NOT_ALLOWED;
            ErrorType errorType3 = OPERATION_LIMIT_EXCEEDED_ERR;
            ErrorType errorType4 = OPERATION_LIMIT_EXCEEDED_ENT_SETTING_ERR;
            ErrorType[] errorTypeArrValues = values();
            $ENTRIES = EnumEntriesKt.enumEntries(errorTypeArrValues);
            INSTANCE = new Companion(null);
            HashMap<String, ErrorType> map = new HashMap<>(67);
            ERROR_CODE_MAP = map;
            map.put(APIErrorStringProvider.ERROR_INVITE_COLLAB_PERMISSION, errorType);
            map.put("access_denied_item_locked", errorType);
            map.put("terms_of_service_required", errorType);
            map.put("incorrect_shared_item_password", errorType);
            map.put("settings_not_allowed_for_service", errorType);
            map.put("file_is_stream_only", errorType);
            map.put("cannot_download_executables", errorType);
            map.put("enterprise_not_published", errorType);
            map.put("cannot_edit_different_service", errorType);
            map.put("breadth_limit_exceeded", errorType);
            map.put("depth_limit_exceeded", errorType);
            map.put("user_cannot_be_upgraded", errorType);
            map.put("cannot_reuse_receipt", errorType);
            map.put("unverified_receipt", errorType);
            map.put("file_size_limit_exceeded", errorType);
            map.put("storage_limit_exceeded", errorType);
            map.put("pending_app_folder_size_limit", errorType);
            map.put("insufficient_storage", errorType);
            map.put("user_email_confirmation_required", errorType);
            map.put("access_from_location_blocked", errorType);
            map.put("operation_not_allowed_by_enterprise", errorType2);
            map.put("operation_limit_exceeded", errorType3);
            map.put("operation_limit_exceeded_enterprise_settings", errorType4);
            map.put("access_from_location_blocked", errorType);
            map.put("operation_not_allowed_by_enterprise", errorType2);
            map.put("operation_limit_exceeded", errorType3);
            map.put("operation_limit_exceeded_enterprise_settings", errorType4);
            map.put("recent_similar_comment", errorType);
            map.put("if_match_header_missing", errorType);
            map.put("requested_preview_unavailable", errorType);
            map.put("preview_cannot_be_generated", errorType);
            map.put("collaborations_not_available_on_root_folder", errorType);
            map.put("user_already_collaborator", errorType);
            map.put("needs_strong_password", errorType);
            map.put("invalid_status", errorType);
            map.put("Cannot invite self as a collaborator", errorType);
            map.put("cannot_invite_deactivated_user", errorType);
            map.put("collaboration_role_unavailable", errorType);
            map.put("invalid_collaboration_item", errorType);
            map.put("new_owner_not_collaborator", errorType);
            map.put("invalid_collaboration_role", errorType);
            map.put("external_collaboration_restricted", errorType);
            map.put("terms_of_service_required", errorType);
            map.put("invalid_authorization_header", errorType);
            map.put("requested_page_out_of_range", errorType);
            map.put("bad_digest", errorType);
            map.put("invalid_digest", errorType);
            map.put("precondition_failed", errorType);
            map.put("method_not_allowed", errorType);
            map.put("user_login_already_used", errorType);
            map.put("file_not_ready", errorType);
            map.put("trashed", errorType);
            map.put("not_trashed", errorType);
            map.put("invalid_receipt", errorType);
            map.put("task_assignee_not_allowed", errorType);
            map.put("shared_item_login_required", errorType);
            map.put("operation_blocked_temporary", errorType);
            map.put("collab_role_not_supported_on_file_type", errorType);
        }

        /* JADX INFO: compiled from: CoreServiceUtils.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/coreservices/utilities/CoreServiceUtils$ErrorType$Companion;", "", "<init>", "()V", "ERROR_CODE_MAP", "Ljava/util/HashMap;", "", "Lcom/box/android/coreservices/utilities/CoreServiceUtils$ErrorType;", "getErrorType", "exception", "Lcom/box/androidsdk/content/BoxException;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ErrorType getErrorType(BoxException exception) {
                ErrorType errorType;
                Intrinsics.checkNotNullParameter(exception, "exception");
                return (exception.getAsBoxError() == null || (errorType = (ErrorType) ErrorType.ERROR_CODE_MAP.get(exception.getAsBoxError().getCode())) == null) ? ErrorType.OTHER : errorType;
            }
        }
    }
}
