/*
 * Source++, the continuous feedback platform for developers.
 * Copyright (C) 2022 CodeBrig, Inc.
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
package spp.jetbrains.sourcemarker.command.status.ui.element;

import com.intellij.openapi.project.Project;
import io.vertx.core.Vertx;
import net.miginfocom.swing.MigLayout;
import spp.jetbrains.PluginUI;
import spp.jetbrains.UserData;
import spp.jetbrains.monitor.skywalking.bridge.ServiceBridge;
import spp.protocol.platform.developer.SelfInfo;
import spp.protocol.platform.general.Service;

import javax.swing.*;

public class AutocompleteDropdown extends JPanel {

    public AutocompleteDropdown(Project project) {
        initComponents();

        infoPanel.setBackground(PluginUI.getBackgroundColor());
        availableCommandsText.setForeground(PluginUI.getPlaceholderForeground());
        totalCommandsLabel.setForeground(PluginUI.getCommandHighlightForeground());

        SelfInfo selfInfo = UserData.INSTANCE.selfInfo(project);
        userText.setForeground(PluginUI.getPlaceholderForeground());
        userLabel.setForeground(PluginUI.getCommandHighlightForeground());
        userLabel.setText(selfInfo.getDeveloper().getId());

        serviceText.setForeground(PluginUI.getPlaceholderForeground());
        Vertx vertx = UserData.INSTANCE.vertx(project);
        Service service = ServiceBridge.Companion.getCurrentServiceAwait(vertx);
        if (service != null) {
            serviceLabel.setText(service.getName());
            serviceLabel.setForeground(PluginUI.getCommandHighlightForeground());
        } else {
            serviceLabel.setText("n/a");
            serviceLabel.setForeground(PluginUI.SELECT_COLOR_RED);
        }
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.panel2.add(scrollPane);
    }

    public void setCurrentCommandsLabel(int size) {
        //currentCommandsLabel.setText(size + "");
    }

    public void setTotalCommandsLabel(int size) {
        totalCommandsLabel.setText(size + "");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel2 = new JPanel();
        infoPanel = new JPanel();
        userText = new JLabel();
        userLabel = new JLabel();
        serviceText = new JLabel();
        serviceLabel = new JLabel();
        availableCommandsText = new JLabel();
        totalCommandsLabel = new JLabel();

        //======== this ========
        setBorder(null);
        setLayout(new MigLayout(
                "fill,insets 0,hidemode 3",
                // columns
                "[grow,fill]",
                // rows
                "[grow,fill]0" +
                        "[]"));

        //======== panel2 ========
        {
            panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        }
        add(panel2, "cell 0 0");

        //======== infoPanel ========
        {
            infoPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]3" +
                            "[fill]" +
                            "[3!,fill]" +
                            "[fill]3" +
                            "[fill]" +
                            "[3!,fill]" +
                            "[grow,right]3" +
                            "[fill]",
                    // rows
                    "[]"));

            //---- userText ----
            userText.setText("User:");
            infoPanel.add(userText, "cell 0 0");

            //---- userLabel ----
            userLabel.setText("n/a");
            infoPanel.add(userLabel, "cell 1 0");

            //---- serviceText ----
            serviceText.setText("Service:");
            infoPanel.add(serviceText, "cell 3 0");

            //---- serviceLabel ----
            serviceLabel.setText("n/a");
            infoPanel.add(serviceLabel, "cell 4 0");

            //---- availableCommandsText ----
            availableCommandsText.setText("Available Commands:");
            infoPanel.add(availableCommandsText, "cell 6 0");

            //---- totalCommandsLabel ----
            totalCommandsLabel.setText("n/a");
            infoPanel.add(totalCommandsLabel, "cell 7 0");
        }
        add(infoPanel, "cell 0 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel2;
    private JPanel infoPanel;
    private JLabel userText;
    private JLabel userLabel;
    private JLabel serviceText;
    private JLabel serviceLabel;
    private JLabel availableCommandsText;
    private JLabel totalCommandsLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
