/*
Copyright 2020 - 2021 Christoph Kohnen
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package me.meloni.SolarLogVisualizer.UI.Components;

import me.meloni.SolarLogVisualizer.Config.Colors;
import me.meloni.SolarLogVisualizer.UI.VisualizerPanel;

import javax.swing.*;

public class Options extends JTabbedPane {
    public void initialize(VisualizerPanel instance) {
        addTab("Day View", new DayView(instance));
        addTab("Month View", new MonthView(instance));
        addTab("Year View", new YearView(instance));
        setBackground(Colors.optionsColor);
    }
}
