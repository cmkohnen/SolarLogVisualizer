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
package me.meloni.SolarLogVisualizer;

import me.meloni.SolarLogAPI.Handling.Logger;
import me.meloni.SolarLogVisualizer.Config.WorkingDirectoryManager;
import me.meloni.SolarLogVisualizer.UI.MainWindow;

import java.io.IOException;

public class Visualizer {
    public static void main(String[] args) {
        Logger.setEnabled(true);
        try {
            WorkingDirectoryManager.createDirectory();
            new MainWindow();
        } catch (IOException e) {
            exit(e.getMessage());
        }
    }

    public static void exit(String message) {
        try {
            WorkingDirectoryManager.removeDirectory();
        } catch (NullPointerException ignored) {

        } catch (IOException e) {
            Logger.warn("Unable to clear temporary storage!");
        }
        Logger.info(String.format("Visualizer exited: %s", message));
        System.exit(0);
    }
}
