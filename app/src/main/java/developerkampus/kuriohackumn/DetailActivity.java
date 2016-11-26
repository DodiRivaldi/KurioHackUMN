package developerkampus.kuriohackumn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import developerkampus.kuriohackumn.api.service.request.UserRequest;
import developerkampus.kuriohackumn.model.User;

public class DetailActivity extends AppCompatActivity
        implements UserRequest.OnWeatherRequestListener {

    private UserRequest userRequest;
    private TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = (TextView) findViewById(R.id.tv_name);
    }

    @Override
    public void onRequestWeatherSuccess(User weatherRespone) {
        tvName.setText(weatherRespone.getName());
    }

    @Override
    public void onRequestWeatherFailure(String message) {
        tvName.setText(message);
    }
}
