package pl.theo.blog.app.lib;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by michal.matlosz on 18.01.2015.
 */
public class JSONAsyncTask extends AsyncTask {
  @Override
  protected Object doInBackground(Object[] objects) {

    JSONParser jsonParser = new JSONParser();
    String a = jsonParser.loadJsonDocument();
    Log.d("JSON", a);

    return null;
  }
}
