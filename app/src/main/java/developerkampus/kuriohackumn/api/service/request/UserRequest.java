package developerkampus.kuriohackumn.api.service.request;

import developerkampus.kuriohackumn.api.service.ApiClient;
import developerkampus.kuriohackumn.api.service.ApiService;
import developerkampus.kuriohackumn.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dodi Rivaldi on 26/11/2016.
 */

public class UserRequest {
    private ApiClient apiClient;
    private Call<User> request;
    private OnWeatherRequestListener listener;

    public UserRequest(OnWeatherRequestListener listener){
        apiClient = ApiService.createService(ApiClient.class);
        this.listener=listener;
    }

    public void CallApi(String te){
        request =apiClient.getDataContent();
        request.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response!=null && response.isSuccessful()){
                    User mWeather = response.body();
                    listener.onRequestWeatherSuccess(mWeather);
                }

                else {
                    listener.onRequestWeatherFailure("Response Invalid");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                String errorMessage = t.getMessage() !=null?
                        t.getMessage():"Unable to connect to server";
                listener.onRequestWeatherFailure(errorMessage);
            }
        });
    }

    public void cancelApi(){
        if (request!=null){
            request.cancel();
        }
    }


    public interface OnWeatherRequestListener{
        void onRequestWeatherSuccess (User weatherRespone);
        void onRequestWeatherFailure(String message);
    }
}
