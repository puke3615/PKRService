package pk.service.entity;

/**
 * @version 16/4/4
 * @user zijiao
 * @Mark 用户信息
 */
public class User extends BaseData {

    private Result result;

    public Result getResult() {
        if (result == null) {
            result = new Result();
        }
        return result;
    }

    public static class Result {
        public String uid;
        public String username;
        public String password;
    }

}
