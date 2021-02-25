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
package me.meloni.SolarLogVisualizer.Config;

import me.meloni.SolarLogAPI.FileInteraction.WorkingDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class WorkingDirectoryManager {
    public static void createDirectory() throws IOException {
        File directory = new File(Paths.get("").toAbsolutePath().toString(), "Visualizer");
        if(!directory.exists() && !directory.mkdirs()) {
            throw new IOException("Missing privileges");
        }
        WorkingDirectory.setDirectory(directory);
    }

    public static void removeDirectory() throws IOException {
        WorkingDirectory.clear();
        if(!WorkingDirectory.getDirectory().delete()) {
            throw new IOException("Missing privileges");
        }
    }
}
