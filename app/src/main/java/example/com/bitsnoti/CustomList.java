package example.com.bitsnoti;

/**
 * Created by handsome on 21/6/17.
 */

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class CustomList extends ArrayAdapter<String>  {
    private String[] titles;
    private String[] descriptions;
    private String[] dates;
    private String[] times;
    private String[] images;
    private Activity context;
    private Button btnrating;


    public CustomList(Activity context, String[] titles, String[] descriptions, String[] dates, String[] times, String images[]) {
        super(context, R.layout.list_event, titles);
        this.context = context;
        this.titles = titles;
        this.descriptions = descriptions;
        this.dates = dates;
        this.times = times;
        this.images= images;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_event, null, true);
        TextView textViewtitle = (TextView) listViewItem.findViewById(R.id.textViewtitle);
        TextView textViewdescription = (TextView) listViewItem.findViewById(R.id.textViewdescription);
        TextView textViewdate = (TextView) listViewItem.findViewById(R.id.textViewdate);
        TextView textViewtime = (TextView) listViewItem.findViewById(R.id.textViewtime);
        ImageView retreiveeventimage = (ImageView)listViewItem.findViewById(R.id.retreiveeventimage);
        textViewtitle.setText(titles[position]);
        textViewdescription.setText(descriptions[position]);
        textViewdate.setText(dates[position]);
        textViewtime.setText(times[position]);
        byte[] byteArray =  Base64.decode(images[position], Base64.DEFAULT) ;
        Bitmap bmp1 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        retreiveeventimage.setImageBitmap(bmp1);

        return listViewItem;
    }
}

