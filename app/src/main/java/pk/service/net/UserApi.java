package pk.service.net;

import pk.service.entity.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @version 16/4/4
 * @user zijiao
 * @Mark
 */
@Api
public interface UserApi {

    @GET("/homelifeinterface/product/getProducts.do")
    Call<User> login(@Query("username") String username,
                     @Query("password") String password);


}
