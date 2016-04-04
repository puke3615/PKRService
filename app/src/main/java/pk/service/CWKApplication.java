package pk.service;

import pk.base.anno.AnnoHelper;
import pk.base.global.PKApplication;
import pk.service.net.ApiFieldHandler;

/**
 * @version 16/4/4
 * @user zijiao
 * @Mark
 */
public class CWKApplication extends PKApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AnnoHelper.instance().setFieldHandler(new ApiFieldHandler());
    }
}
