package com.box.android.utilities;

import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.messages.BoxLocalUsersDataMessage;
import com.box.android.domain.models.BoxAuthMap;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes13.dex */
public final class BoxCollectionUtils {

    public interface IPredicate<T> {
        boolean apply(T t);
    }

    private BoxCollectionUtils() {
    }

    public static <T> Collection<T> filter(Collection<T> collection, IPredicate<T> iPredicate) {
        ArrayList arrayList = new ArrayList();
        for (T t : collection) {
            if (iPredicate.apply(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static List<BoxUser> getUsersExcludingInvalid(IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        BoxAuthMap payload;
        try {
            payload = ((BoxLocalUsersDataMessage) iMoCoBoxGlobalSettings.getAllUsersData().get()).getPayload();
        } catch (Exception e) {
            BoxLogUtils.logException(e);
            payload = null;
        }
        ArrayList arrayList = new ArrayList();
        if (payload != null) {
            Iterator<BoxAuthentication.BoxAuthenticationInfo> it = payload.iterator();
            while (it.hasNext()) {
                BoxUser user = it.next().getUser();
                if (user != null && !StringUtils.isEmpty(user.getUserId())) {
                    arrayList.add(user);
                }
            }
        }
        return arrayList;
    }
}
