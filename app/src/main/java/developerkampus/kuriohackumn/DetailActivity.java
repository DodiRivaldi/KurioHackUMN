package developerkampus.kuriohackumn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class DetailActivity extends AppCompatActivity{
    private TextView tvName, tvContent, tvVote, tvHoax, tvTruth,tvVoteHoax, tvVoteTruth;
    private ImageView imgContent;
    private EditText edtLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtLink = (EditText) findViewById(R.id.edt_link);
        tvName = (TextView) findViewById(R.id.tv_title);
        tvVote = (TextView) findViewById(R.id.tv_vote);
        tvVoteTruth = (TextView) findViewById(R.id.tv_vote_truth);
        tvVoteHoax = (TextView) findViewById(R.id.tv_vote_hoax);
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
            tvHoax.setText("Hoax : "+getHoax);
            tvTruth.setText("Truth : "+getTruth);
            tvContent.setText(getContent);
            Log.d(getTitle,"Judul");
            Log.d(getImage,"Gambar");
        }

        tvVoteTruth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtLink.getText().toString().equals("")){
                    Toast.makeText(DetailActivity.this,"Wajib sertakan link sumber",Toast.LENGTH_LONG).show();
                }

                else {
                    int quantity= Integer.parseInt(tvVote.getText().toString()+1);
                    displayVote(quantity);
                    Toast.makeText(DetailActivity.this,"Terima kasih atas partisipasi anda",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void displayVote(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.tv_vote);
        quantityTextView.setText("" + number);
    }


    private void displayTruth(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.tv_truth);
        quantityTextView.setText("" + number);
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
