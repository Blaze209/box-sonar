package com.box.android.domain.models;

import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.eclipsesource.json.JsonObject;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class BoxAuthMap extends BoxJsonObject implements Iterable<BoxAuthentication.BoxAuthenticationInfo> {
    private static final long serialVersionUID = -3782456340686624108L;

    public BoxAuthMap(JsonObject jsonObject) {
        super(jsonObject);
    }

    public BoxAuthMap() {
    }

    @Override // com.box.androidsdk.content.models.BoxJsonObject
    public boolean remove(String str) {
        return super.remove(str);
    }

    public BoxAuthentication.BoxAuthenticationInfo get(String str) {
        return (BoxAuthentication.BoxAuthenticationInfo) getPropertyAsJsonObject(getObjectCreator(), str);
    }

    protected BoxJsonObject.BoxJsonObjectCreator<BoxAuthentication.BoxAuthenticationInfo> getObjectCreator() {
        return BoxJsonObject.getBoxJsonObjectCreator(BoxAuthentication.BoxAuthenticationInfo.class);
    }

    public void add(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        if (boxAuthenticationInfo.getUser() == null) {
            BoxLogUtils.e("BoxAuthMap.add", " unknown user being added user null");
        } else {
            set(boxAuthenticationInfo.getUser().getId(), boxAuthenticationInfo);
        }
    }

    public int size() {
        return getPropertiesKeySet().size();
    }

    @Override // java.lang.Iterable
    public Iterator<BoxAuthentication.BoxAuthenticationInfo> iterator() {
        final List<String> propertiesKeySet = getPropertiesKeySet();
        return new Iterator<BoxAuthentication.BoxAuthenticationInfo>() { // from class: com.box.android.domain.models.BoxAuthMap.1
            int mIndex = 0;

            @Override // java.util.Iterator
            public void remove() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.mIndex < propertiesKeySet.size();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public BoxAuthentication.BoxAuthenticationInfo next() {
                BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = BoxAuthMap.this.get((String) propertiesKeySet.get(this.mIndex));
                this.mIndex++;
                return boxAuthenticationInfo;
            }
        };
    }

    @Override // com.box.androidsdk.content.models.BoxJsonObject
    public JsonObject toJsonObject() {
        return super.toJsonObject();
    }

    @Override // com.box.androidsdk.content.models.BoxJsonObject
    public String toJson() {
        return super.toJson();
    }
}
