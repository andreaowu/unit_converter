package edu.berkeley.cs160.andreawu.prog1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class UnitConverter extends Activity {

	private RadioGroup groupFrom;
	private RadioGroup groupTo;
	private Button convertBtn;
	private Button clearBtn;
	private EditText from;
	private EditText to;
	private RadioButton selectedFrom;
	private RadioButton selectedTo;
	private final String MILES = "Miles";
	private final String KILOMETERS = "Kilometers";
	private final String POUNDS = "Pounds";
	private final String GRAMS = "Grams";
	private final String FAHRENHEIT = "Fahrenheit";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_unit_converter);

		addListenerOnButton();
	}

	public void addListenerOnButton() {
    	groupFrom = (RadioGroup) findViewById(R.id.groupFrom);
    	groupTo = (RadioGroup) findViewById(R.id.groupTo);
    	convertBtn = (Button) findViewById(R.id.button1);
    	clearBtn = (Button) findViewById(R.id.button2);
    	// get selected radio button from radiogroup
    	groupFrom.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int id) {
				selectedFrom = (RadioButton) findViewById(groupFrom.getCheckedRadioButtonId());
				String fromText = (String) selectedFrom.getText();
				groupTo.clearCheck();
				if (fromText.equals(MILES)) {
					selectedTo = (RadioButton) findViewById(R.id.radioButton8);
					selectedTo.setChecked(true);
				} else if (fromText.equals(KILOMETERS)) {
					selectedTo = (RadioButton) findViewById(R.id.radioButton7);
					selectedTo.setChecked(true);
				} else if (fromText.equals(POUNDS)) {
					selectedTo = (RadioButton) findViewById(R.id.radioButton10);
					selectedTo.setChecked(true);
				} else if (fromText.equals(GRAMS)) {
					selectedTo = (RadioButton) findViewById(R.id.radioButton9);
					selectedTo.setChecked(true);
				} else if (fromText.equals(FAHRENHEIT)) {
					selectedTo = (RadioButton) findViewById(R.id.radioButton12);
					selectedTo.setChecked(true);
				} else {
					selectedTo = (RadioButton) findViewById(R.id.radioButton11);
					selectedTo.setChecked(true);
				}
			}
    	});
    	
    	convertBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				from = (EditText) findViewById(R.id.editText1);
				String fromDouble = from.getText().toString();
				float num = Float.parseFloat(fromDouble);
				to = (EditText) findViewById(R.id.editText2);
				double converted;
				RadioButton selected = (RadioButton) findViewById(groupFrom.getCheckedRadioButtonId());
				String fromText = (String) selected.getText();
				if (fromText.equals(MILES)) {
					converted = num * 1.60934; 
				} else if (fromText.equals(KILOMETERS)) {
					converted = num * 0.621371;
				} else if (fromText.equals(POUNDS)) {
					converted = num * 453.592;
				} else if (fromText.equals(GRAMS)) {
					converted = num * 0.00220462;
				} else if (fromText.equals(FAHRENHEIT)) {
					System.out.println("fah: " + (5/9));
					converted = ((num - 32) * 5) / 9;
				} else {
					System.out.println("cel");
					converted = (num * 9) /5 + 32;
				}
				System.out.println("converted: " + converted);
				to.setText(String.valueOf(converted));
			}
    	});
    	
    	clearBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				selectedFrom.setChecked(false);
				selectedTo.setChecked(false);
				from.setText("");
				to.setText("");
			}
    	});
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.unit_converter, menu);
		return true;
	}
}
