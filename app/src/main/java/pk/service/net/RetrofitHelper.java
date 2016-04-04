package pk.service.net;

import com.google.gson.Gson;

import pk.base.exception.Exceptions;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * @version 16/4/4
 * @user zijiao
 * @Mark api接口代理生成帮助类
 */
public class RetrofitHelper {

    private static Retrofit sRetrofit;

    private static final String BASE_URL = "http://www.baidu.com";

    static {
        sRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public static <T> T createProxy(Class<T> cls) {
        Exceptions.checkNull(cls);
        return sRetrofit.create(cls);
    }

}
