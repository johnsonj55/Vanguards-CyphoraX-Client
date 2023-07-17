/**
* Copyright (c) Kyle Fricilone
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package net.openrs.cache.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.openrs.util.XTEAEntry;

/**
 * @author Kyle Friz
 * 
 * @since Jun 30, 2015
 */
public final class XTEAManager {

      private static final Map<Integer, int[]> maps = new HashMap<>();
      private static final Map<Integer, int[]> tables = new HashMap<>();

      public static final int[] NULL_KEYS = new int[4];

      public static int[] lookupTable(int id) {
            int[] keys = tables.get(id);
            if (keys == null)
                  return NULL_KEYS;

            return keys;
      }

      public static int[] lookup(int region) {
            return maps.getOrDefault(region, NULL_KEYS);
      }

      public static boolean load(File xteaDir) throws IOException {
    	  	if(!xteaDir.isDirectory()) {
    	  		loadFromJSON(xteaDir);
    	  	} else {
    	  		 final File[] files = xteaDir.listFiles() == null ? new File[0] : xteaDir.listFiles();

    	            for (File file : files) {
    	                  if (file.getName().endsWith(".txt")) {
    	                        final int region = Integer.valueOf(file.getName().substring(0, file.getName().indexOf(".txt")));
    	                        final int[] keys = Files.lines(xteaDir.toPath().resolve(file.getName())).map(Integer::valueOf).mapToInt(Integer::intValue).toArray();
    	                        maps.put(region, keys);
    	                  }
    	            }

    	  	}
           
            return !maps.isEmpty();
      }
      

      public static void loadFromJSON(File file) {
            try {
                  Gson gson = new Gson();
                  try (Reader reader = new FileReader(file)) {
                	  List<XTEAEntry> entries = gson.fromJson(reader, new TypeToken<List<XTEAEntry>>(){}.getType());
                      for (XTEAEntry entry : entries) {
                            maps.put(entry.getRegion(), entry.getKeys());
                            tables.put(entry.getRegion(), entry.getKeys());
                      }
                  } catch(Exception ex) {
                	  ex.printStackTrace();
                  }
                  
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }


      
}
