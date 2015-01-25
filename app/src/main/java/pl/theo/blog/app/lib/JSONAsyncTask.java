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
    return new JSONParser().getPosts();
  }

  @Override
  protected void onPostExecute(List<PostItem> postItemList) {
    List<PostItem> postItems = postItemList;
    arrayAdapter.clear();
    arrayAdapter.addAll(postItems);
  }
}
