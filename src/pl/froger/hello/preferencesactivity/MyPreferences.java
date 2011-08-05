package pl.froger.hello.preferencesactivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;

public class MyPreferences extends PreferenceActivity {
	private static final String PREFERENCES_NAME = "Preferences";
	private static final String CHECKBOX_FIELD = "checkbox";
	private static final String EDITTEXT_FIELD = "edittext";
	private static final String LIST_FIELD = "list";
	
	private SharedPreferences preferences;
	private CheckBoxPreference checkBoxPreference;
	private EditTextPreference editTextPreference;
	private ListPreference listPreference;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
		preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
		checkBoxPreference = (CheckBoxPreference) findPreference("checkbox");
		editTextPreference = (EditTextPreference) findPreference("edittext");
		listPreference = (ListPreference) findPreference("list");
		initPreferences();
	}

	private void initPreferences() {
		boolean checkBoxValue = preferences.getBoolean(CHECKBOX_FIELD, false);
		String editTextValue = preferences.getString(EDITTEXT_FIELD, "");
		String listDefaultValue = listPreference.getEntryValues()[0].toString();
		String listValue = preferences.getString(LIST_FIELD, listDefaultValue);
		checkBoxPreference.setChecked(checkBoxValue);
		editTextPreference.setText(editTextValue);
		listPreference.setValue(listValue);
	}

	@Override
	protected void onPause() {
		super.onPause();
		savePreferences();
	}
	
	private void savePreferences() {
		SharedPreferences.Editor editor = preferences.edit();
		editor.putBoolean(CHECKBOX_FIELD, checkBoxPreference.isChecked());
		editor.putString(EDITTEXT_FIELD, editTextPreference.getText());
		editor.putString(LIST_FIELD, listPreference.getValue());
		editor.commit();
	}
}