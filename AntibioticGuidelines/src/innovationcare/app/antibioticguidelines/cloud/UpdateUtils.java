/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 *
 */
package innovationcare.app.antibioticguidelines.cloud;

import innovationcare.app.antibioticguidelines.CategoryMenu;
import innovationcare.app.antibioticguidelines.database.GuidelineDataAccess;
import innovationcare.app.antibioticguidelines.ui.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.kumulos.android.jsonclient.Kumulos;
import com.kumulos.android.jsonclient.ResponseHandler;

/*
 * Modification History
 * --------------------
 * 22-Jul-2013  JY  Initial version.
 */
/**
 * @author I73933
 *
 */
public class UpdateUtils {
	
	public static void getAllDataFromCloud(final GuidelineDataAccess dao) {
		getAllCategoryMenusFromCloud(dao);
		getAllMenusFromCloud(dao);
	}
	public static void getAllCategoryMenusFromCloud(final GuidelineDataAccess dao) {
		HashMap<String, String> param = new HashMap<String, String>();
		Kumulos.call("getAllCategoryMenus", param, new ResponseHandler() {
			@Override
			public void didCompleteWithResult(Object result) {
				ArrayList<Object> resultSet = (ArrayList<Object>) result;
				dao.open();
				for (Object object : resultSet) {
					LinkedHashMap<String,Object> objectHashMap = (LinkedHashMap<String,Object>) object;
					String name = objectHashMap.get("name").toString();
					String id = objectHashMap.get("categoryMenuID").toString();
					CategoryMenu newCateMenu = 
							new CategoryMenu(Long.parseLong(id), name);
					dao.insertCategoryMenu(newCateMenu);

				}
				dao.close();
			}
		});
	}
	
	
	public static void getAllMenusFromCloud(final GuidelineDataAccess dao) {
		HashMap<String, String> param = new HashMap<String, String>();
		Kumulos.call("getAllMenus", param, new ResponseHandler() {
			@Override
			public void didCompleteWithResult(Object result) {
				
				ArrayList<Object> resultSet = (ArrayList<Object>) result;
				dao.open();
				for (Object object : resultSet) {
					LinkedHashMap<String,Object> objectDetails = (LinkedHashMap<String,Object>) object;
					String id = objectDetails.get("menuID").toString();
					String name = objectDetails.get("name").toString();
					String type = objectDetails.get("type").toString();
					String categoryMenuId = objectDetails.get("categoryId").toString();
					innovationcare.app.antibioticguidelines.Menu newMenu = 
							new innovationcare.app.antibioticguidelines.Menu(
									Long.parseLong(id), name, type, Long.parseLong(categoryMenuId));
					dao.insertMenu(newMenu);
				}
				dao.close();
			}
		});
	}
}
