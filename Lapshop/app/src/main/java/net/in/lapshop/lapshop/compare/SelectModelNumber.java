package net.in.lapshop.lapshop.compare;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.homepage.compare;
import net.in.lapshop.lapshop.link;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SelectModelNumber extends AppCompatActivity {
    android.support.v4.app.Fragment fragment=new compare();
    ListView MobileDetailsListView;
    ProgressBar MobileProgressBar;
    String HttpUrl =null;
    static int count=0;
    static String sid1,sid2;
    List<String> MobileList = new ArrayList<String>();
    List<String> MobileList1 = new ArrayList<String>();
    ArrayAdapter<String> MobileArrayAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_homepage);
        setContentView(R.layout.activity_select_brand);

        MobileDetailsListView = (ListView)findViewById(R.id.listview1);
HttpUrl= link.url+"/Lapshop/retrive_data_for_compare.php?laptop_brand="+getIntent().getStringExtra("ListViewValue");
        MobileProgressBar = (ProgressBar)findViewById(R.id.progressBar);

        new GetHttpResponse(SelectModelNumber.this).execute();

        MobileDetailsListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(count==0){
                    count++;
                    sid1=MobileList1.get(position);
                    Intent i=new Intent(SelectModelNumber.this,SelectBrand.class);

                    startActivity(i);

                }else{
                    sid2=MobileList1.get(position);
                    Intent i=new Intent(SelectModelNumber.this,show_compare_data.class);
                    i.putExtra("sid2",sid2);
                    i.putExtra("sid1",sid1);
                    startActivity(i);
                }

            }
        });
    }

    private class GetHttpResponse extends AsyncTask<Void, Void, Void>
    {
        public Context context;

        String JSonResult;

        public GetHttpResponse(Context context)
        {
            this.context = context;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {
            HttpServicesClass httpServicesClass = new HttpServicesClass(HttpUrl);
            try
            {
                httpServicesClass.ExecutePostRequest();

                if(httpServicesClass.getResponseCode() == 200)
                {
                    JSonResult = httpServicesClass.getResponse();

                    if(JSonResult != null)
                    {
                        JSONArray jsonArray = null;

                        try {
                            jsonArray = new JSONArray(JSonResult);

                            JSONObject jsonObject;

                            for(int i=0; i<jsonArray.length(); i++)
                            {
                                String s=null,s1=null;
                                jsonObject = jsonArray.getJSONObject(i);
                                MobileList1.add(String.valueOf(jsonObject.getInt("sid")));
                                s=jsonObject.getString("laptop_modelname").toString();
                                s1=jsonObject.getString("laptop_modelno").toString();
                                MobileList.add(s+" "+s1);

                            }
                        }
                        catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                else
                {
                    Toast.makeText(context, httpServicesClass.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)

        {
            MobileProgressBar.setVisibility(View.GONE);

            MobileDetailsListView.setVisibility(View.VISIBLE);

            // Start code for remove duplicate listview values.



            //End code here for remove duplicate values.

            MobileArrayAdapter = new ArrayAdapter<String>(SelectModelNumber.this,android.R.layout.simple_list_item_2, android.R.id.text1, MobileList);

            MobileDetailsListView.setAdapter(MobileArrayAdapter);

        }
    }

}
