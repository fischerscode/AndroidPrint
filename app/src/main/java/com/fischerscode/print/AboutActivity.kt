/*
 * Copyright (C) 2022 Maximilian Fischer
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

package com.fischerscode.print;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mikepenz.aboutlibraries.LibsBuilder
import com.fischerscode.print.databinding.ActivityAboutBinding
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.util.withContext

class AboutActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityAboutBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val apache = Libs.Builder().withContext(this).build().licenses.first { it.spdxId == "Apache-2.0" }.licenseContent.orEmpty().replace("\n","<br />")

        val fragment = LibsBuilder()
                .withSearchEnabled(true)
                .withAboutSpecial1Description(apache)
//                .withAboutSpecial1Description(apache)
//                .withAboutSpecial2("TEST")
//                .withAboutSpecial2Description("<![CDATA[This is a small sample which can be set in the about my app description file.<br /><br /><b>You can style this with html markup :D</b>]]>")
                .supportFragment()

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}
