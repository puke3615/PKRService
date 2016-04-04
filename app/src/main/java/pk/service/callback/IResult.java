package pk.service.callback;

/**
 * @version 16/4/4
 * @user zijiao
 * @Mark 回调接口
 */
public interface IResult<T> {

    void onSuccess(T result);

    void onFailed(String message);

}
