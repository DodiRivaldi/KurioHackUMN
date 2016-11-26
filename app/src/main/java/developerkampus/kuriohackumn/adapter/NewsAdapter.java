package developerkampus.kuriohackumn.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import developerkampus.kuriohackumn.R;
import developerkampus.kuriohackumn.model.News;

/**
 * Created by Dodi Rivaldi on 26/11/2016.
 */

public class NewsAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<News> movieItems;
    private Context context;

    public NewsAdapter(Activity activity, List<News> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.news_list, null);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.img_tumb_update);
        TextView category = (TextView) convertView.findViewById(R.id.tv_judul_update);
        // getting movie data for the row
        News m = movieItems.get(position);

        category.setText(m.getTitle());
        Glide.with(activity).load(m.getImage()).into(imageView);

        return convertView;
    }

}
