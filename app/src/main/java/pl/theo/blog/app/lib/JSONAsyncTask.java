package pl.theo.blog.app.lib;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import java.util.List;


/**
 * Created by michal.matlosz on 18.01.2015.
 */
public class JSONAsyncTask extends AsyncTask<ArrayAdapter, Void, List<PostItem>> {
  ArrayAdapter arrayAdapter;

  @Override
  protected List<PostItem> doInBackground(ArrayAdapter... arrayAdapters) {
    arrayAdapter = arrayAdapters[0];
    JSONParser jsonParser = new JSONParser();
    String a = jsonParser.loadJsonDocument();
    return jsonParser.parseJSONDocument(a);
  }

  @Override
  protected void onPostExecute(List<PostItem> o) {

    List<PostItem> postItems = o;
    arrayAdapter.clear();
    arrayAdapter.addAll(postItems);

  }

}
