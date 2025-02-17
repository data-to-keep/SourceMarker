/*
 * Source++, the continuous feedback platform for developers.
 * Copyright (C) 2022-2023 CodeBrig, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package spp.jetbrains.marker.source.mark.api.component.swing

import spp.jetbrains.marker.source.mark.api.SourceMark
import spp.jetbrains.marker.source.mark.api.component.api.SourceMarkComponent
import spp.jetbrains.marker.source.mark.api.component.api.SourceMarkComponentProvider
import spp.jetbrains.marker.source.mark.api.component.api.config.SourceMarkComponentConfiguration
import javax.swing.JComponent

/**
 * todo: description.
 *
 * @since 0.1.0
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
abstract class SwingSourceMarkComponentProvider : SourceMarkComponentProvider {

    override val defaultConfiguration = SourceMarkComponentConfiguration()

    abstract fun makeSwingComponent(sourceMark: SourceMark): JComponent

    override fun getComponent(sourceMark: SourceMark): SourceMarkComponent {
        val component = makeSwingComponent(sourceMark)
        return object : SourceMarkComponent {
            override val configuration = defaultConfiguration.copy()

            override fun getComponent(): JComponent {
                return component
            }

            override fun dispose() {
                //do nothing
            }
        }
    }

    override fun disposeComponent(sourceMark: SourceMark) {
        //do nothing
    }
}
