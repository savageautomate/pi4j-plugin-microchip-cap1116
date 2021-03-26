package com.pi4j.plugin.microchip.cap1116;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: PLUGIN   :: Microchip CAP1116 I/O Providers
 * FILENAME      :  MicrochipCap1116Plugin.java
 * 
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2021 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import com.pi4j.extension.Plugin;
import com.pi4j.extension.PluginService;
import com.pi4j.plugin.microchip.cap1116.provider.gpio.digital.Cap1116DigitalInputProvider;
import com.pi4j.plugin.microchip.cap1116.provider.gpio.digital.Cap1116DigitalOutputProvider;
import com.pi4j.provider.Provider;

/**
 * <p>MicrochipCap1116Plugin class.</p>
 *
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 * @version $Id: $Id
 */
public class MicrochipCap1116Plugin implements Plugin {

    private Provider providers[] = {
        Cap1116DigitalInputProvider.newInstance(),
        Cap1116DigitalOutputProvider.newInstance(),
    };

    /** {@inheritDoc} */
    @Override
    public void initialize(PluginService service) {
        // register the Microchip Cap1116 I/O Providers with the plugin service
        service.register(providers);
    }
}
