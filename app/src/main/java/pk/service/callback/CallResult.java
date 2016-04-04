package pk.service.callback;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * @version 16/4/4
 * @user zijiao
 * @Mark
 */
public abstract class CallResult<T> implements Callback<T>, IResult<T> {

    @Override
    public void onResponse(Response<T> response) {
        onSuccess(response.body());
    }

    @Override
    public void onFailure(Throwable t) {
        onFailed(t.getMessage());
    }
}
