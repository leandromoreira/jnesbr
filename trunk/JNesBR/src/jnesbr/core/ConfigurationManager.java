/*
This file is part of JNesBR.

JNesBR is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

JNesBR is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with JNesBR.  If not, see <http://www.gnu.org/licenses/>.
 */
package jnesbr.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import jnesbr.test.Test;

/**
 * @author dreampeppers99
 */
public final class ConfigurationManager {
    private static ConfigurationManager configurationManager;
    private Properties properties;
    private final static String FILE_NAME = "jnesbr.xml";
    public static ConfigurationManager getInstance(){
        if (configurationManager==null){
            configurationManager = new ConfigurationManager();
        }
        return configurationManager;
    }

    public void store(Properties p){
        try {
            p.storeToXML(new FileOutputStream(new File(FILE_NAME)), "Config file from " + MetaInformation.NAME);
        } catch (IOException ex) {
            Logger.getLogger(ConfigurationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Properties getProperties(){
        properties = new Properties();
        try {
            properties.loadFromXML(new FileInputStream(new File(FILE_NAME)));
            if(properties.size()==0){
                properties = createDefault();
            }
            return properties;
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return properties;
    }
    //KEYS
    public final static String LOOKANDFELL = "look.and.feel";
    
    
    //VALUES
    public final static String METAL = "javax.swing.plaf.metal.MetalLookAndFeel";
    public final static String NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
    public final static String MOTIF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    public final static String WINDOWS = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    public final static String WINDOWS_CLASSIC = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";

    private ConfigurationManager(){
    }

    private Properties createDefault() {
        Properties p = new Properties();
        p.put(LOOKANDFELL, WINDOWS);
        store(p);
        return p;
    }
}
