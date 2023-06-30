package net.openrs.cache.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.openrs.cache.xtea.XTEA;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;

public class XTEADumper {

    public static void main(String[] args) {
        final String getUrl = "https://api.github.com/repos/runelite/runelite/tags";

        System.out.println(String.format("fetching latest runelite version: %s", getUrl));

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(getUrl).openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                return;
            }

            StringBuffer buffer = new StringBuffer();
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
            }

            final String json = buffer.toString();

            final String versionTag = json.substring(json.indexOf("runelite-parent-") + 16, json.indexOf("\",\"")).trim();

            System.out.println(String.format("latest runelite version: %s", versionTag));

            final String xteaUrl = String.format("https://api.runelite.net/runelite-%s/xtea", versionTag);

            System.out.println(String.format("runelite xtea url: %s", xteaUrl));

            connection = (HttpURLConnection) new URL(xteaUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
            responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                return;
            }

            buffer = new StringBuffer();

            Gson gson = new GsonBuilder().create();

            try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                XTEA[] xteas = gson.fromJson(reader, XTEA[].class);

                if (xteas == null) {
                    return;
                }

                int count = 0;
                for (XTEA xtea : xteas) {
                    try(PrintWriter writer = new PrintWriter(new FileWriter(Paths.get("repository", "xtea", "maps", xtea.getRegion() + ".txt").toFile()))) {
                        System.out.println("writing xtea region: " + xtea.getRegion());
                        for (int key : xtea.getKeys()) {
                            writer.println(key);
                        }
                        count++;
                    }
                }

                System.out.println(String.format("dumped: %d xteas", count));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
