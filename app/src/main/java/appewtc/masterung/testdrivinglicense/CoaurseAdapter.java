package appewtc.masterung.testdrivinglicense;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by masterUNG on 7/21/2016 AD.
 */
public class CoaurseAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] titleStrings, detailStrings;

    public CoaurseAdapter(Context context,
                          String[] titleStrings,
                          String[] detailStrings) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return titleStrings.length;
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
        View view1 = layoutInflater.inflate(R.layout.coaurse_layout, viewGroup, false);

        //Initial Widget
        TextView titleTextView = (TextView) view1.findViewById(R.id.textView13);
        TextView detailTextView = (TextView) view1.findViewById(R.id.textView14);

        titleTextView.setText(titleStrings[i]);
        String shortDetail = detailStrings[i].substring(0, 20) + "...";
        detailTextView.setText(shortDetail);


        return view1;
    }
}   // Main Class
