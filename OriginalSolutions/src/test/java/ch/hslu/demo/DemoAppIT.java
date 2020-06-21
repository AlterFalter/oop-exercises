/*
 * Copyright 2020 Roland Gisler, HSLU Informatik, Switzerland
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
package ch.hslu.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Beispiel für Integrationstests. Namenskonvention 'IT' am Schluss. Werden mit
 * dem Goal integration-test ausgeführt.
 */
final class DemoAppIT {

    /**
     * Demo-Test für Parameterübergabe an Testfall. Sinnvoll für Interaktion mit
     * Dateisystem.
     */
    @Test
    void testTestParameter() {
        DemoApp.main(new String[0]);
        assertTrue(true); // FAKE Test, nur für Demo!
    }
}
