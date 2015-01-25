package pl.theo.blog.app.lib;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import java.util.List;


/**
 * Created by michal.matlosz on 18.01.2015.
 */
public class JSONAsyncTask extends AsyncTask<ArrayAdapter, Void, List<PostItem>> {
  private ArrayAdapter arrayAdapter;

  @Override
  protected List<PostItem> doInBackground(ArrayAdapter... arrayAdapters) {
    arrayAdapter = arrayAdapters[0];
    JSONParser jsonParser = new JSONParser();
    String jsonDocument = jsonParser.loadJsonDocument();
    return jsonParser.parseJSONDocument(jsonDocument);
  }

  @Override
  protected void onPostExecute(List<PostItem> postItemList) {
    List<PostItem> postItems = postItemList;
    arrayAdapter.clear();
    arrayAdapter.addAll(postItems);
  }
}
