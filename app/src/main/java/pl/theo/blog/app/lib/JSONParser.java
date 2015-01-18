package pl.theo.blog.app.lib;

import android.util.Log;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by michal.matlosz on 18.01.2015.
 */
public class JSONParser {

  private String url = "http://blog.teamtreehouse.com/api/get_recent_summary/?count=20";

  public String getUrl() {
    return this.url;
  }

  public void get() {
    
  }

  public String loadJsonDocument() {
    try {
      URL url = new URL(getUrl());
      HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

      urlConnection.connect();
      InputStream in = new BufferedInputStream(urlConnection.getInputStream());

      char[] content = new char[urlConnection.getContentLength()];
      Reader reader = new InputStreamReader(in);
      reader.read(content);

      in.close();
      urlConnection.disconnect();
      return new String(content);

    } catch (MalformedURLException ex) {
      Log.d("DD", ex.getMessage());
    } catch (IOException ex) {
      Log.d("DD", ex.getMessage());

    }
    return "";
  }
}
