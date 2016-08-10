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
public class CoaurseAdapter extends BaseAdapter {

    //Explicit
    private Context context;
    private int navigateAnInt;
    private String[] titleStrings, detailStrings;

    public CoaurseAdapter(Context context,
                          int navigateAnInt,
                          String[] titleStrings,
                          String[] detailStrings) {
        this.context = context;
        this.navigateAnInt = navigateAnInt;
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

        switch (navigateAnInt) {
            case 0:
                String shortDetail = detailStrings[i].substring(0, 20) + "...";
                detailTextView.setText(shortDetail);
                break;
            case 1:
                detailTextView.setText(detailStrings[i]);
                break;
        }

        return view1;
    }
}   // Main Class
