package com.manggeek.learndemo.activityLearn;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.manggeek.android.geek.bitmap.GeekBitmap;
import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.utils.TimeUtil;
import com.manggeek.android.geek.view.CircleImageView;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.Entity.Book;
import com.manggeek.learndemo.Entity.CityModel;
import com.manggeek.learndemo.Entity.DistrictModel;
import com.manggeek.learndemo.Entity.ProvinceModel;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.control.BaseActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by zhangshengwei
 * Time: 2018/12/12 10:30
 * describe: 数据格式解析  xml文件  json数据等...
 */
public class DataUtilActivity extends BaseActivity {

    private @FindViewById(id = R.id.xmlbtn) TextView xmlTv;
    private @FindViewById(id = R.id.jsonbtn) TextView jsonTv;
    private @FindViewById(id = R.id.listview) ListView listView;
    private @FindViewById(id = R.id.time) TextView timeTv;
    private String time = "暂未开始解析";
    private List<ProvinceModel> proList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_util);
        initView();
    }

    private void initView() {
        xmlTv.setOnClickListener(click);
        jsonTv.setOnClickListener(click);
        listView.setAdapter(adapter);

        timeTv.setText(time);
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == xmlTv){
                UtilXML();
            }else if(view == jsonTv){
                UtilJson();
            }
        }
    };
    //解析xml文件
    private void UtilXML() {
        List<ProvinceModel> provinceList;
        AssetManager asset = mActivity.getAssets();
        InputStream inputStream;
        try {
            long beginTime = System.currentTimeMillis();
            inputStream = asset.open("area.xml");
            proList = UseDomMethod(inputStream);
            long endTime = System.currentTimeMillis();
            long timeLong = endTime - beginTime;
            time = timeLong+"";
            timeTv.setText("解析所消耗时间:" + time+"  毫秒");
            adapter.notifyDataSetChanged();
//            inputStream = asset.open("book.xml");
//            List<Book> books = UseDomTestMethod(inputStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //解析area.xml
    private List<ProvinceModel> UseDomMethod(InputStream inputStream) {
        List<ProvinceModel> proList = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            //获取XML文档结构
            Document document = builder.parse(inputStream);
            //获取根节点
            Element rootElement = document.getDocumentElement();
            NodeList provinceNodeList = rootElement.getElementsByTagName("province");       //省级节点
//            PrintUtil.log("http--->nodeList.getLength()(省级数量):"+nodeList.getLength());
            for (int proI = 0; proI < provinceNodeList.getLength(); proI++){
                ProvinceModel provinceModel = new ProvinceModel();
                List<CityModel> cityList = new ArrayList<>();
                //Node转为Element
                //接卸name关键字
                Element provinceElement = (Element) provinceNodeList.item(proI);
                provinceModel.setName(provinceElement.getAttribute("name"));
                NodeList cityNodeList = provinceElement.getElementsByTagName("city");

                for (int cityI = 0; cityI < cityNodeList.getLength(); cityI++){
                    CityModel cityModel = new CityModel();
                    List<DistrictModel> districtList = new ArrayList<>();
                    Element cityElement = (Element) cityNodeList.item(cityI);
                    cityModel.setName(cityElement.getAttribute("name"));
                    NodeList districNodeList = cityElement.getElementsByTagName("district");
                    for (int districI = 0; districI < districNodeList.getLength(); districI++) {
                        DistrictModel districtModel = new DistrictModel();
                        Element districElement = (Element) districNodeList.item(districI);
                        districtModel.setName(districElement.getAttribute("name"));
                        districtModel.setZipcode(districElement.getAttribute("zipcode"));
//                        if (cityI == 0 &&districI == 0){
//                            PrintUtil.log("http--->省:" + provinceModel.getName() + " 城市:" + cityModel.getName() + "  地区名:" + districtModel.getName()+"  地区编号:"+districtModel.getZipcode());
//                        }
                        districtList.add(districtModel);
                    }
                    cityModel.setDistrictList(districtList);
                    cityList.add(cityModel);
                }
                provinceModel.setCityList(cityList);
                proList.add(provinceModel);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return proList;
    }
    //解析book.xml
    private List<Book> UseDomTestMethod(InputStream inputStream) {
//        List<ProvinceModel> proList = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            //获取XML文档结构
            Document document = builder.parse(inputStream);
            //获取根节点
            Element rootElement = document.getDocumentElement();
            NodeList nodeList = rootElement.getElementsByTagName("Book");
            for (int i = 0;i<nodeList.getLength();i++){
                Book book = new Book();
                //Node转为Element
                //接卸name关键字
                Element element = (Element) nodeList.item(i);
                book.setName(element.getAttribute("name"));
                //解析每项节点的title
                Element eleTitleElement = (Element)element.getElementsByTagName("Title").item(0);
                String title = eleTitleElement.getFirstChild().getNodeValue();
                book.setTitle(title);
                //解析每项节点的picture
                Element elePicElement = (Element) element.getElementsByTagName("Picture").item(0);
                String picString = elePicElement.getFirstChild().getNodeValue();
                book.setPicture(picString);
                bookList.add(book);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    //解析json文件
    private void UtilJson() {


    }



    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return proList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            ViewHolder viewHolder;
            if (view == null) {
                view = mInflater.inflate(R.layout.item_data_util, null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            ProvinceModel provinceModel = proList.get(position);
            String provinceName = provinceModel.getName();
            List<CityModel> cityList = provinceModel.getCityList();
            String cityName = "";
            for (int i = 0; i<cityList.size();i++){
                cityName = cityName +" << "+ cityList.get(i).getName()+" >>";
                List<DistrictModel> districtModels = cityList.get(i).getDistrictList();
                cityName = cityName + "cityId: " + districtModels.get(0).getZipcode();
                for (int j = 0;j < districtModels.size();j++){
                    cityName = cityName + "-->" + districtModels.get(j).getName()+"";
                }
                cityName = "" + cityName + "  \n"+" \n";
            }
            viewHolder.showDataTv.setText("  "+provinceName+"\n"+"  "+cityName);
            return view;
        }
        class ViewHolder{
            TextView showDataTv;
            public ViewHolder(View view) {
                showDataTv = view.findViewById(R.id.show_data);
            }
        }
    };
}
