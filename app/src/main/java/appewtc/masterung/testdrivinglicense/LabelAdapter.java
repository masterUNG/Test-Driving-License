package appewtc.masterung.testdrivinglicense;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by masterUNG on 8/10/2016 AD.
 */
public class LabelAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] iconStrings, labelStrings, contentStrings;

    public LabelAdapter(Context context,
                        String[] iconStrings,
                        String[] labelStrings,
                        String[] contentStrings) {
        this.context = context;
        this.iconStrings = iconStrings;
        this.labelStrings = labelStrings;
        this.contentStrings = contentStrings;
    }

    @Override
    public int getCount() {
        return iconStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.label_listview, viewGroup, false);

        //Bind Widget
        ImageView imageView = (ImageView) view1.findViewById(R.id.imageView9);
        TextView labelTextView = (TextView) view1.findViewById(R.id.textView23);
        TextView contentTextView = (TextView) view1.findViewById(R.id.textView24);

        Picasso.with(context).load(iconStrings[i]).resize(120, 120).into(imageView);
        labelTextView.setText(labelStrings[i]);
        String contentShort = contentStrings[i].substring(0, 4) + "...";    // ค่อยมาแก้เป็น 20 ทีหลัง
        contentTextView.setText(contentShort);

        return view1;
    }
}   // Main Class
