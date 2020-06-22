/*
 * Copyright 2020 Hochschule Luzern Informatik.
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
package ch.hslu.oop.exercise.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * Tests for {@link ch.hslu.oop.exercise.common.Temperatur}.
 */
@SuppressWarnings({"PMD.TooManyMethods", "PMD.TooManyStaticImports"})
final class TemperaturTest {

    private static final float PRECISION = 0.005f;

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#createFromCelsius(float)}.
     */
    @Test
    void testCreateFromCelsiusValid() {
        final Temperatur instance = Temperatur.createFromCelsius(0.0f);
        assertEquals(0.0f, instance.getCelsius(), PRECISION);
        assertEquals(273.15f, instance.getKelvin(), PRECISION);
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#createFromCelsius(float)}.
     */
    @Test
    void testCreateFromCelsiusInvalid() {
        var iae = assertThrows(IllegalArgumentException.class, () -> Temperatur.createFromCelsius(-273.16f));
        assertThat(iae.getMessage()).startsWith("Ungültiger Wert für Temperatur");
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#createFromKelvin(float)}.
     */
    @Test
    void testCreateFromKelvinValid() {
        final Temperatur instance = Temperatur.createFromKelvin(0.0f);
        assertEquals(0.0f, instance.getKelvin(), PRECISION);
        assertEquals(-273.15f, instance.getCelsius(), PRECISION);
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#createFromKelvin(float)}.
     */
    @Test
    void testCreateFromKelvinInvalidJUnit4Style() {
        var iae = assertThrows(IllegalArgumentException.class, () -> Temperatur.createFromKelvin(-0.001f));
        assertThat(iae.getMessage()).startsWith("Ungültiger Wert für Temperatur");
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#createFromKelvin(float)}.
     */
    @Test
    void testCreateFromKelvinInvalidAssertJStyle() {
        assertThatThrownBy(() -> {
            Temperatur.createFromKelvin(-0.001f);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith("Ungültiger Wert für Temperatur");
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#Temperatur(Temperatur)}.
     */
    @Test
    void testCopyConstruktorValid() {
        final Temperatur tempOrig = Temperatur.createFromCelsius(20.0f);
        final Temperatur tempCopy = new Temperatur(tempOrig);
        assertEquals(tempCopy, tempOrig);
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#Temperatur(Temperatur)}.
     */
    @SuppressWarnings("unused")
    @Test
    void testCopyConstruktorNull() {
        assertThrows(NullPointerException.class, () -> new Temperatur(null));
    }

    /**
     * Test method for Equals-Contract.
     */
    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(Temperatur.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#equals(Object)}.
     */
    @Test
    void testEqualsSame() {
        final Temperatur temperatur = Temperatur.createFromCelsius(0.0f);
        assertSame(temperatur, temperatur);
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#equals(Object)}.
     */
    @Test
    void testEqualsEqual() {
        final Temperatur temp1 = Temperatur.createFromCelsius(1.0f);
        final Temperatur temp2 = Temperatur.createFromCelsius(1.0f);
        assertEquals(temp1, temp2);
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#equals(Object)}.
     */
    @Test
    void testEqualsNotEquals() {
        final Temperatur temp1 = Temperatur.createFromCelsius(3.0f);
        final Temperatur temp2 = Temperatur.createFromCelsius(4.0f);
        assertNotEquals(temp1, temp2);
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#compareTo(Temperatur)}.
     */
    @Test
    void testCompareDifferent() {
        final Temperatur temp1 = Temperatur.createFromCelsius(10.0f);
        final Temperatur temp2 = Temperatur.createFromCelsius(20.0f);
        assertEquals(-1, temp1.compareTo(temp2));
        assertEquals(+1, temp2.compareTo(temp1));
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#compareTo(Temperatur)}.
     */
    @Test
    void testCompareEqual() {
        final Temperatur temp1 = Temperatur.createFromCelsius(15.0f);
        final Temperatur temp2 = Temperatur.createFromCelsius(15.0f);
        assertEquals(0, temp1.compareTo(temp2));
        assertEquals(0, temp2.compareTo(temp1));
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#convertKelvinToCelsius(float)}.
     */
    @Test
    void testConvertKelvinToCelsius() {
        assertEquals(-272.15f, Temperatur.convertKelvinToCelsius(1.0f), 0.001f);
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.exercise.common.Temperatur#convertCelsiusToKelvin(float)}.
     */
    @Test
    void testConvertKelvinToCelsiusInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Temperatur.convertKelvinToCelsius(-1.0f));
    }

    /**
     * Test method for {@link ch.hslu.oop.exercise.common.Temperatur#toString()}.
     */
    @Test
    void testToString() {
        assertTrue(Temperatur.createFromCelsius(20.0f).toString().lastIndexOf("20.0") > 0);
    }
}
