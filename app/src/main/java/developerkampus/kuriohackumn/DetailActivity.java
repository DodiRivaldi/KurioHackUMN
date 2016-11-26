package developerkampus.kuriohackumn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailActivity extends AppCompatActivity{
    private TextView tvName, tvContent, tvVote, tvHoax, tvTruth;
    private ImageView imgContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvName = (TextView) findViewById(R.id.tv_title);
        tvVote = (TextView) findViewById(R.id.tv_vote);
        tvHoax = (TextView) findViewById(R.id.tv_hoax);
        tvTruth = (TextView) findViewById(R.id.tv_truth);
        imgContent = (ImageView) findViewById(R.id.img_content);
        tvContent = (TextView) findViewById(R.id.tv_name);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if(bd != null)
        {
            String getTitle = (String) bd.get("judul");
            String getImage = (String) bd.get("gambar");
            String getContent = (String) bd.get("content");
            String getVote = (String) bd.get("vote");
            String getHoax = (String) bd.get("hoax");
            String getTruth = (String) bd.get("truth");

            Glide.with(this).load(getImage).into(imgContent);
            tvName.setText(getTitle);
            tvVote.setText(getVote);
            tvHoax.setText(getHoax);
            tvTruth.setText(getTruth);
            tvContent.setText(getContent);
            Log.d(getTitle,"Judul");
            Log.d(getImage,"Gambar");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {

            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
