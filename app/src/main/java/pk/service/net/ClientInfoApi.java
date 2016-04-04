package pk.service.net;

import java.util.List;

import pk.service.entity.ClientInfo;
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
public interface ClientInfoApi {

    @GET("/homelifeinterface/product/getProducts.do")
    Call<List<ClientInfo>> getClientInfos();


}
