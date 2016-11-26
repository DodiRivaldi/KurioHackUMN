package developerkampus.kuriohackumn.api.service;

import developerkampus.kuriohackumn.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Dodi Rivaldi on 26/11/2016.
 */

public interface ApiClient {
    @Headers({"Accept: application/json", "X-Kurio-Client-ID : 99",
            "X-Kurio-Client-Secret : S3VyaW9IYWNrYXRvbjIw",
            "X-OS : android","X-App-Version : beta_v1"
    ,"Authorization : Bearer rqvH2ZSMDxM9CImKqkeiFw28F2EkCUuORp1JqY9l"})
    @GET("/user")
    Call<User> getDataContent();
}
