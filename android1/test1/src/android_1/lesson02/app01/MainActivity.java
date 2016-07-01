package android_1.lesson02.app01;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {
	
	/* Fields for store links to UI components */
	private TextView tvText0 = null;
	private TextView tvText1 = null;	
	private ImageView ivImage = null; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {			
		
		/* Invoke a parent method */
		super.onCreate(savedInstanceState);
		
		/* Load UI from resources */
		setContentView(R.layout.activity_main);
		
		/* Load UI components */
		tvText0 = (TextView) this.findViewById(R.id.tvText0);
		tvText1 = (TextView) this.findViewById(R.id.tvText1);
		ivImage = (ImageView) this.findViewById(R.id.ivImage);
		
		/* Load string resource */
		String str1 = this.getString(R.string.app_name);
		String str2 = this.getResources().getString(R.string.app_name);
		
		/* Using strings */
		tvText0.setText(str1);
		tvText1.setText(str2);
				
		/* Load color resource */
		int color_r = this.getResources().getColor(R.color.text_color_r);
		int color_b = this.getResources().getColor(R.color.text_color_b);
		
		/* Using colors */
		tvText0.setTextColor(color_r);
		tvText1.setTextColor(color_b);
	
		/* Using color resource */
		tvText0.setTextColor(this.getResources().getColor(
						R.color.text_color_g));
		
		
		/* Work with array */
		String[] array = this.getResources().getStringArray(
				R.array.my_str_array);
		
		/* Convert array to string */
		StringBuilder sBuilder = new StringBuilder();
		
		for (int i = 0; i < array.length; i++) {			
			sBuilder.append(array[i] + "\n");	
		}
		
		tvText1.setText(sBuilder.toString());
		
		/* Load image resources */
		ivImage.setImageDrawable(this.getResources().getDrawable(
				R.drawable.img_01));			
		
	}

}
