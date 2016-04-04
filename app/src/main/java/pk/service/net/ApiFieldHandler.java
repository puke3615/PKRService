package pk.service.net;

import android.view.View;

import java.lang.reflect.Field;

import pk.base.anno.handler.FieldHandler;

/**
 * @version 16/4/4
 * @user zijiao
 * @Mark
 */
public class ApiFieldHandler extends FieldHandler {

    @Override
    public void handleField(Object obj, View view, Field field) {
        super.handleField(obj, view, field);
        if (obj == null || field == null) {
            return;
        }
        try {
            Class filedType = field.getType();
            if (filedType.isAnnotationPresent(Api.class)) {
                Object apiProxy = RetrofitHelper.createProxy(filedType);
                if (apiProxy != null) {
                    field.setAccessible(true);
                    field.set(obj, apiProxy);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
