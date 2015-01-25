package pl.theo.blog.app.lib;

import android.text.Html;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michal.matlosz on 18.01.2015.
 */
public class JSONParser {

  private String url = "http://blog.teamtreehouse.com/api/get_recent_summary/?count=20";

  private List<PostItem> posts = new ArrayList<PostItem>();

  public static Map<String, PostItem> postsItemMap = new HashMap<String, PostItem>();


  public String getUrl() {
    return this.url;
  }

  public List<PostItem> getPosts() {
    return parseJSONDocument(loadJsonDocument());
  }

  public List<PostItem> parseJSONDocument(String jsonDocument) {
    try {
      JSONObject jsonObject = new JSONObject(jsonDocument);
      JSONArray jsonArray = jsonObject.getJSONArray("posts");
      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject post = jsonArray.getJSONObject(i);
        PostItem postItem = new PostItem();
        postItem.setId(Integer.toString(i));
        postItem.setPostId(post.getString("id"));
        postItem.setAuthor(post.getString("author"));
        postItem.setDate(post.getString("date"));
        postItem.setTitle(Html.fromHtml(post.getString("title")).toString());
        postItem.setUrl(post.getString("url"));
        posts.add(postItem);
        postsItemMap.put(postItem.getId(), postItem);
      }
    } catch (JSONException ex) {
      return null;
    }
    return posts;
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
      return "";
    } catch (IOException ex) {
      return "";
    }
  }
}
