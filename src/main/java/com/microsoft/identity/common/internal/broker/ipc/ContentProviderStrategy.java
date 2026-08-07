package com.microsoft.identity.common.internal.broker.ipc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.util.ParcelableUtil;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;

/* JADX INFO: loaded from: classes14.dex */
public class ContentProviderStrategy extends AbstractIpcStrategyWithServiceValidation {
    private static final String TAG = "ContentProviderStrategy";
    private final IContentProviderStatusLoader mCache;
    private final Context mContext;

    public ContentProviderStrategy(Context context, IPlatformComponents iPlatformComponents) {
        super(false);
        this.mContext = context;
        this.mCache = new ContentProviderStatusLoader(context, iPlatformComponents);
    }

    protected ContentProviderStrategy(Context context, IContentProviderStatusLoader iContentProviderStatusLoader, boolean z) {
        super(z);
        this.mContext = context;
        this.mCache = iContentProviderStatusLoader;
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.AbstractIpcStrategyWithServiceValidation
    protected Bundle communicateToBrokerAfterValidation(BrokerOperationBundle brokerOperationBundle) throws BrokerCommunicationException {
        String str = TAG + ":communicateToBroker";
        Logger.info(str, "Broker operation name: " + brokerOperationBundle.getOperation().name() + " brokerPackage: " + brokerOperationBundle.getTargetBrokerAppPackageName());
        Uri contentProviderURI = getContentProviderURI(brokerOperationBundle.getTargetBrokerAppPackageName(), brokerOperationBundle.getContentProviderPath());
        Logger.info(str, "Request to BrokerContentProvider for uri path " + brokerOperationBundle.getContentProviderPath());
        Bundle bundle = brokerOperationBundle.getBundle();
        Cursor cursorQuery = MAMContentResolverManagement.query(this.mContext.getContentResolver(), contentProviderURI, null, bundle != null ? Base64.encodeToString(ParcelableUtil.marshall(bundle), 0) : null, null, null);
        try {
            if (cursorQuery != null) {
                try {
                    Bundle extras = cursorQuery.getExtras();
                    if (extras == null) {
                        Logger.error(str, "Received an empty bundle. This means the operation is not supported on the other side. If you're using a newer feature, please bump the minimum protocol version.", null);
                        throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE, getType(), "Received an empty bundle. This means the operation is not supported on the other side. If you're using a newer feature, please bump the minimum protocol version.", null);
                    }
                    Logger.info(str, "Received successful result from Broker Content Provider.");
                    cursorQuery.close();
                    return extras;
                } catch (RuntimeException e) {
                    Logger.error(str, "Failed to get result from Broker Content Provider", e);
                    throw new BrokerCommunicationException(BrokerCommunicationException.Category.CONNECTION_ERROR, getType(), "Failed to get result from Broker Content Provider", null);
                }
            }
            Logger.error(str, "Failed to get result from Broker Content Provider, cursor is null", null);
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.NULL_CURSOR, getType(), "Failed to get result from Broker Content Provider, cursor is null", null);
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public IIpcStrategy.Type getType() {
        return IIpcStrategy.Type.CONTENT_PROVIDER;
    }

    private Uri getContentProviderURI(String str, String str2) {
        return Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + getContentProviderAuthority(str) + str2);
    }

    public static String getContentProviderAuthority(String str) {
        return str + ".microsoft.identity.broker";
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public boolean isSupportedByTargetedBroker(String str) {
        return this.mCache.supportsContentProvider(str);
    }
}
