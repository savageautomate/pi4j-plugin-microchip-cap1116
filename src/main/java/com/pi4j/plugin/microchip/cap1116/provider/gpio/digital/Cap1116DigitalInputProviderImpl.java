package com.pi4j.plugin.microchip.cap1116.provider.gpio.digital;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: PLUGIN   :: Microchip CAP1116 I/O Providers
 * FILENAME      :  Cap1116DigitalInputProviderImpl.java
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

import com.pi4j.io.exception.IOException;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalInputConfig;
import com.pi4j.io.gpio.digital.DigitalInputProviderBase;

/**
 * <p>Cap1116DigitalInputProviderImpl class.</p>
 *
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 * @version $Id: $Id
 */
public class Cap1116DigitalInputProviderImpl extends DigitalInputProviderBase implements Cap1116DigitalInputProvider {

    /**
     * <p>Constructor for Cap1116DigitalInputProviderImpl.</p>
     */
    public Cap1116DigitalInputProviderImpl(){
        this.id = ID;
        this.name = NAME;
    }

    /** {@inheritDoc} */
    @Override
    public DigitalInput create(DigitalInputConfig config) {

        // validate provided address to ensure its an acceptable input for this chip
        // TODO :: I'm not sure if this the the right exception to throw or if this is the right location to perform address validation?
        if(config.address() < 1 || config.address() > 6)
            throw new IOException("Unsupported address for Microchip CAP1116 digital input; (valid rage: 1-6)");

        // create an return new digital input instance
        return new Cap1116DigitalInput(this, config);
    }
}
