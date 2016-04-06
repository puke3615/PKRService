package pk.service.user;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import pk.service.entity.User;

/**
 * @author zijiao
 * @version 2016/4/6
 * @Mark
 */
public class UserManager {

    private User mUser;
    private final List<ILoginContext> mListeners;

    private UserManager() {
        mListeners = new ArrayList<>();
    }

    private static final class UserManagerHolder {
        static UserManager instance = new UserManager();
    }

    public static UserManager instance() {
        return UserManagerHolder.instance;
    }

    /**
     * 注册监听器
     * @param loginListener
     */
    public void register(ILoginContext loginListener) {
        if (loginListener != null) {
            synchronized (mListeners) {
                if (!mListeners.contains(loginListener)) {
                    mListeners.add(loginListener);
                }
            }
        }
    }

    /**
     * 注销监听器
     * @param loginListener
     */
    public void unRegister(ILoginContext loginListener) {
        if (loginListener != null) {
            synchronized (mListeners) {
                if (mListeners.contains(loginListener)) {
                    mListeners.remove(loginListener);
                }
            }
        }
    }

    /**
     * 通知登录回调事件
     */
    public void notifyLogin() {
        synchronized (mListeners) {
            for (ILoginContext listener : mListeners) {
                if (listener != null && listener instanceof ILoginListener) {
                    ((ILoginListener) listener).onLogin();
                }
            }
        }
    }


    /**
     * 通知登出回调事件
     */
    public void notifyLogout() {
        synchronized (mListeners) {
            for (ILoginContext listener : mListeners) {
                if (listener != null && listener instanceof ILogoutListener) {
                    ((ILogoutListener) listener).onLogout();
                }
            }
        }
    }

    private User.Result getResult() {
        return mUser == null ? null : mUser.getResult();
    }

    /**
     * 获取Uid
     * @return
     */
    public String getUid() {
        User.Result result = getResult();
        return result == null ? null : result.uid;
    }

    /**
     * 获取用户名
     * @return
     */
    public String getUsername() {
        User.Result result = getResult();
        return result == null ? null : result.username;
    }

    /**
     * 判断当前是否登录
     * @return
     */
    public boolean isLogin() {
        User.Result result = getResult();
        return result != null && !TextUtils.isEmpty(result.uid);
    }

}
