package sg.edu.rp.c346.p03_class_journal;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import sg.edu.rp.c346.p03_class_journal.DailyCA;
import sg.edu.rp.c346.p03_class_journal.R;

public class DailyAdapter extends ArrayAdapter<DailyCA> {
    private ArrayList<DailyCA> daily;
    private Context context;
    private TextView tvDG, tvDate;
    private ImageView ivImage;
    public DailyAdapter(Context context, int resource, ArrayList<DailyCA> objects){
        super(context, resource,objects);
        // Store the food that is passed to this adapter
        daily = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
// "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);
        DailyCA s = daily.get(position);
        tvDG = (TextView) rowView.findViewById(R.id.tvDaily);
        tvDG.setText(s.getDgGrade());
        tvDate = (TextView) rowView.findViewById(R.id.tvDay);
        tvDate.setText("Week " + s.getWeek());
        ivImage = (ImageView) rowView.findViewById(R.id.imageView);
        ivImage.setImageResource(R.drawable.dg);
        return rowView;
    }
}