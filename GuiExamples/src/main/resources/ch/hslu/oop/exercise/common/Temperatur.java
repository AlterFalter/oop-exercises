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

import java.util.Objects;

/**
 * Repräsentation einer Temperatur. Die Temperatur wird intern in der Einheit Kelvin gespeichert.
 */
public final class Temperatur implements Comparable<Temperatur> {

    private static final float KELVIN_OFFSET = 273.15f;
    private static final float MIN_KELVIN = 0.0f;
    private static final float MIN_CELSIUS = MIN_KELVIN - KELVIN_OFFSET;

    private final float kelvin;

    /**
     * Privater Konstruktor mit Temperatur in Kelvin.
     * @param kelvin Temperatur in Kelvin.
     */
    private Temperatur(final float kelvin) {
        this.kelvin = kelvin;
    }

    /**
     * Copy-Konstruktor.
     * @param temperatur Temperatur-Objekt.
     * @throws java.lang.NullPointerException bei ungültigem Temperaturobjekt.
     */
    public Temperatur(final Temperatur temperatur) {
        this(temperatur.kelvin);
    }

    /**
     * Liefert die Temperatur in Kelvin.
     * @return Temperatur in Kelvin.
     */
    public float getKelvin() {
        return this.kelvin;
    }

    /**
     * Liefert die Temperatur in Celsius.
     * @return Temperatur in Celsius
     */
    public float getCelsius() {
        return convertKelvinToCelsius(this.kelvin);
    }

    /**
     * Vergleicht Temperatur auf Value-Gleichheit.
     */
    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Temperatur)) {
            return false;
        }
        final Temperatur other = (Temperatur) object;
        return Float.compare(other.kelvin, this.kelvin) == 0;
    }

    /**
     * Liefert den Hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.kelvin));
    }

    /**
     * Liefert eine einfache String-Repräsentation des Objektes.
     */
    @Override
    public String toString() {
        return String.format("Temperatur[kelvin=%.1f;celsius=%.1f]", this.getKelvin(), this.getCelsius());
    }

    /**
     * Vergleicht Temperatur nach dem Wert.
     */
    @Override
    public int compareTo(final Temperatur other) {
        return Float.compare(this.kelvin, other.kelvin);
    }

    /**
     * Factorymethode für Temperatur mit Initialwert in Kelvin.
     * @param kelvin Tempertur in Kelvin.
     * @return Temperaturobjekt.
     * @throws java.lang.IllegalArgumentException bei ungültigem Temperaturwert.
     */
    public static Temperatur createFromKelvin(final float kelvin) {
        if (kelvin >= MIN_KELVIN) {
            return new Temperatur(kelvin);
        }
        throw new IllegalArgumentException("Ungültiger Wert für Temperatur in Kelvin: " + kelvin);
    }

    /**
     * Factorymethode für Temperatur mit Initialwert in Celsius.
     * @param celsius Tempertur in Celsius.
     * @return Temperaturobjekt.
     * @throws java.lang.IllegalArgumentException bei ungültigem Temperaturwert.
     */
    public static Temperatur createFromCelsius(final float celsius) {
        return createFromKelvin(convertCelsiusToKelvin(celsius));
    }

    /**
     * Konvertiert einen Wert in Kelvin nach Celsius.
     * @param kelvin Temperatur in Kelvin.
     * @return Temperatur in Celsius.
     * @throws java.lang.IllegalArgumentException bei ungültigem Temperaturwert.
     */
    public static float convertKelvinToCelsius(final float kelvin) {
        if (kelvin >= MIN_KELVIN) {
            return kelvin - KELVIN_OFFSET;
        }
        throw new IllegalArgumentException("Ungültiger Wert für Temperatur in Kelvin: " + kelvin);
    }

    /**
     * Konvertiert einen Wert in Celsius nach Kelvin.
     * @param celsius Temperatur in Celsius.
     * @return Temperatur in Kelvin.
     * @throws java.lang.IllegalArgumentException bei ungültigem Temperaturwert.
     */
    public static float convertCelsiusToKelvin(final float celsius) {
        if (celsius >= MIN_CELSIUS) {
            return celsius + KELVIN_OFFSET;
        }
        throw new IllegalArgumentException("Ungültiger Wert für Temperatur in Celsius: " + celsius);
    }
}
