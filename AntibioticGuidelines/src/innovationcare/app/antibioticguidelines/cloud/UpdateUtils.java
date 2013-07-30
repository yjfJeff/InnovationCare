/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 *
 */
package innovationcare.app.antibioticguidelines.cloud;

import innovationcare.app.antibioticguidelines.Antibiotic;
import innovationcare.app.antibioticguidelines.CategoryMenu;
import innovationcare.app.antibioticguidelines.database.GuidelineDataAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import android.os.Environment;
import android.util.Base64;

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
		getAllInfectionContentsFromCloud(dao);
		getAllSurgeryContentsFromCloud(dao);
	}
	public static void getAllAntibioticFromCloud(final GuidelineDataAccess dao) {
		HashMap<String, String> param = new HashMap<String, String>();
		Kumulos.call("getAntibiotics", param, new ResponseHandler() {
			@Override
			public void didCompleteWithResult(Object result) {
				List<Object> result2 = (ArrayList<Object>) result;
				for (Object o : result2) {
					LinkedHashMap<String, Object> ob = (LinkedHashMap<String, Object>) o;
					String original = ob.get("summaryPDF").toString();
					String renal = ob.get("renalPDF").toString();
					String title = ob.get("summaryPDFTitle").toString()
							+ ".pdf";
					String renaltitle = ob.get("renalPDFTitle").toString()
							+ ".pdf";
					String id = ob.get("antibioticTableID").toString();
					String infoLink2Title = ob.get("infoLink2Title").toString();
					String infoLink1Title = ob.get("infoLink1Title").toString();
					String infoLink1 = ob.get("infoLink1").toString();
					String infoLink2 = ob.get("infoLink2").toString();
					Antibiotic antibiotic = new Antibiotic(Long.parseLong(id),
							title, infoLink1Title, infoLink1, infoLink2Title,
							infoLink2);
					dao.insertAntibiotic(antibiotic);
					byte[] data = Base64.decode(original, Base64.DEFAULT);
					byte[] renaldata = Base64.decode(renal, Base64.DEFAULT);
					try {
						String text = new String(data, "UTF-8");
						String filename = title;
						File tempFile = new File(Environment
								.getExternalStorageDirectory()
								.getAbsolutePath(), filename);
						if (tempFile.exists()) {

						}
						FileOutputStream fos = new FileOutputStream(tempFile);
						fos.write(data);
						fos.close();
						text = new String(renaldata, "UTF-8");
						filename = renaltitle;
						tempFile = new File(Environment
								.getExternalStorageDirectory()
								.getAbsolutePath(), filename);
						if (tempFile.exists()) {

						}
						fos = new FileOutputStream(tempFile);
						fos.write(data);
						fos.close();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}

	public static void getAllCategoryMenusFromCloud(
			final GuidelineDataAccess dao) {
		HashMap<String, String> param = new HashMap<String, String>();
		Kumulos.call("getAllCategoryMenus", param, new ResponseHandler() {
			@Override
			public void didCompleteWithResult(Object result) {
				ArrayList<Object> resultSet = (ArrayList<Object>) result;
				dao.open();
				for (Object object : resultSet) {
					LinkedHashMap<String, Object> objectHashMap = (LinkedHashMap<String, Object>) object;
					String name = objectHashMap.get("name").toString();
					String id = objectHashMap.get("categoryMenuID").toString();
					CategoryMenu newCateMenu = new CategoryMenu(Long
							.parseLong(id), name);
					dao.insertCategoryMenu(newCateMenu);

				}
				dao.close();
			}
		});
	}

	public static void getAllMenusFromCloud(final GuidelineDataAccess dao) {
		HashMap<String, String> param2 = new HashMap<String, String>();
		Kumulos.call("getAllMenus", param2, new ResponseHandler() {
			@Override
			public void didCompleteWithResult(Object result) {

				ArrayList<Object> resultSet = (ArrayList<Object>) result;
				dao.open();
				for (Object object : resultSet) {
					LinkedHashMap<String, Object> objectDetails = (LinkedHashMap<String, Object>) object;
					String id = objectDetails.get("menuID").toString();
					String name = objectDetails.get("name").toString();
					String type = objectDetails.get("type").toString();
					String categoryMenuId = objectDetails.get("categoryMenuId")
							.toString();
					innovationcare.app.antibioticguidelines.Menu newMenu = new innovationcare.app.antibioticguidelines.Menu(
							Long.parseLong(id), name, type, Long
									.parseLong(categoryMenuId));
					dao.insertMenu(newMenu);
				}
				dao.close();
			}
		});
	}

	public static void getAllInfectionContentsFromCloud(
			final GuidelineDataAccess dao) {
		HashMap<String, String> param2 = new HashMap<String, String>();
		Kumulos.call("getAllInfectionContents", param2, new ResponseHandler() {
			@Override
			public void didCompleteWithResult(Object result) {

				ArrayList<Object> resultSet = (ArrayList<Object>) result;
				dao.open();
				for (Object object : resultSet) {
					LinkedHashMap<String, Object> objectDetails = (LinkedHashMap<String, Object>) object;
					String id = objectDetails.get("infectionContentID")
							.toString();
					String presentation = objectDetails.get("presentation")
							.toString();
					String organism = objectDetails.get("organism").toString();
					String antibiotic = objectDetails.get("antibiotic")
							.toString();
					String comments = objectDetails.get("comments").toString();
					String menuId = objectDetails.get("menuId").toString();
					innovationcare.app.antibioticguidelines.InfectionContent newInfectionContent = new innovationcare.app.antibioticguidelines.InfectionContent(
							Long.parseLong(id), presentation, organism,
							antibiotic, comments, Long.parseLong(menuId));
					dao.insertInfectionContent(newInfectionContent);
				}
				dao.close();
			}
		});
	}

	public static void getAllSurgeryContentsFromCloud(
			final GuidelineDataAccess dao) {
		HashMap<String, String> param2 = new HashMap<String, String>();
		Kumulos.call("getAllSurgeryContents", param2, new ResponseHandler() {
			@Override
			public void didCompleteWithResult(Object result) {

				ArrayList<Object> resultSet = (ArrayList<Object>) result;
				dao.open();
				for (Object object : resultSet) {
					LinkedHashMap<String, Object> objectDetails = (LinkedHashMap<String, Object>) object;
					String id = objectDetails.get("surgeryContentID")
							.toString();
					String operation = objectDetails.get("operation")
							.toString();
					String antibiotic = objectDetails.get("antibiotic")
							.toString();
					String duration = objectDetails.get("duration").toString();
					String comments = objectDetails.get("comments").toString();
					String menuId = objectDetails.get("menuId").toString();
					innovationcare.app.antibioticguidelines.SurgeryContent newInfectionContent = new innovationcare.app.antibioticguidelines.SurgeryContent(
							Long.parseLong(id), operation, antibiotic,
							duration, comments, Long.parseLong(menuId));
					dao.insertSurgeryContent(newInfectionContent);
				}
				dao.close();
			}
		});
	}
}
