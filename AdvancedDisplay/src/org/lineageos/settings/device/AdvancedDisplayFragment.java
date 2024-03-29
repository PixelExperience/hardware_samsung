/*
 * Copyright (C) 2017 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.device;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.preference.PreferenceFragment;

import org.lineageos.settings.device.R;

public class AdvancedDisplayFragment extends PreferenceFragment {
    private mDNIeScenario mmDNIeScenario;
    private mDNIeAccessibility mmDNIeAccessibility;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.screen_preferences);
        Resources res = getResources();

        /* mDNIe */
        mmDNIeScenario = (mDNIeScenario) findPreference(Constants.KEY_MDNIE_SCENARIO);
        mmDNIeScenario.setEnabled(
                FileUtils.isFileWritable(res.getString(R.string.mdnie_scenario_sysfs_file)));

        mmDNIeAccessibility = (mDNIeAccessibility) findPreference(Constants.KEY_MDNIE_ACCESSIBILITY);
        mmDNIeAccessibility.setEnabled(
                FileUtils.isFileWritable(res.getString(R.string.mdnie_accessibility_sysfs_file)));
    }
}
