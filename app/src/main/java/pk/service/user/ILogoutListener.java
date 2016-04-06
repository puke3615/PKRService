package pk.service.user;

/**
 * @author zijiao
 * @version 2016/4/6
 * @Mark
 */
public interface ILogoutListener extends ILoginContext {

    /**
     * 登出
     */
    void onLogout();

}
