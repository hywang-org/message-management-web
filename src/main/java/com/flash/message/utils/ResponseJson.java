package com.flash.message.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * @author 作者 hywang 619201932@qq.com
 *
 * @version 创建时间：2019年7月22日 上午10:15:57
 *
 */
public class ResponseJson {

	private static final String SUCCESS_CODE = "000000";

	public static JSONObject resultForm() {
		JSONObject result = new JSONObject();
		JSONObject meta = new JSONObject();
		JSONObject data = new JSONObject();

		meta.put("success", true);
		meta.put("desc", "success");
		meta.put("code", SUCCESS_CODE);

		result.put("meta", meta);
		result.put("data", data);

		return result;
	}

	public static <T> List<JSONObject> obj2Json(List<T> list) {
		List<JSONObject> jsons = new ArrayList<JSONObject>();
		if (list != null && list.size() > 0) {
			for (Object object : list) {
				jsons.add((JSONObject) JSONObject.toJSON(object));
			}
		}

		return jsons;
	}

	public static JSONObject checkJson(JSONObject json) {
		JSONObject result = resultForm();
		JSONObject meta = result.getJSONObject("meta");
		if (json != null) {
			Iterator<Entry<String, Object>> iterator = json.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, Object> next = iterator.next();
				if(next.getValue() == null || "".equals(next.getValue())) {
					meta.put("success",false);
					meta.put("desc",next.getKey()+" is empty");
					meta.put("code",300);
					break;
				}
			}
		}
		return result;
	}
	
	public static JSONObject formErr2Json(String desc,String code) {
		JSONObject json = resultForm();
		
		JSONObject meta = json.getJSONObject("meta");
		meta.put("success", false);
		meta.put("desc", desc);
		meta.put("code", code);
		json.put("meta", meta);
		
		return json;
	}
	
	public static JSONObject formNull2Json(String desc,String code) {
		JSONObject json = resultForm();
		
		JSONObject meta = json.getJSONObject("meta");
		meta.put("success", true);
		meta.put("desc", desc);
		meta.put("code", code);
		json.put("meta", meta);
		
		return json;
	}
	
	public static JSONObject formSuc2Json(String desc) {
		JSONObject json = resultForm();
		
		JSONObject meta = json.getJSONObject("meta");
		meta.put("message", desc);
		json.put("meta", meta);
		
		return json;
	}
	
	public static String jsonArraySort(String jsonArrStr,String keyName) {
        JSONArray jsonArr = JSON.parseArray(jsonArrStr);
        JSONArray sortedJsonArray = new JSONArray();
        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < jsonArr.size(); i++) {
            jsonValues.add(jsonArr.getJSONObject(i));
        }
        Collections.sort(jsonValues, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject a, JSONObject b) {
                String valA = new String();
                String valB = new String();
                try {
                    // 这里是a、b需要处理的业务，需要根据你的规则进行修改。
                    String aStr = a.getString(keyName);
                    valA = aStr.replaceAll("-", "");
                    String bStr = b.getString(keyName);
                    valB = bStr.replaceAll("-", "");
                } catch (JSONException e) {
                    // do something
                }
                return -valA.compareTo(valB);
                // if you want to change the sort order, simply use the following:
                // return -valA.compareTo(valB);
            }
        });
        for (int i = 0; i < jsonArr.size(); i++) {
            sortedJsonArray.add(jsonValues.get(i));
        }
        return sortedJsonArray.toString();
    }
	
}
