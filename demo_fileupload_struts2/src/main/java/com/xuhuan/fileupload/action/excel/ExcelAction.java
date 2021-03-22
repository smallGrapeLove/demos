package com.xuhuan.fileupload.action.excel;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huan.xu
 * @Time 2019-06-25 18:50
 */
public class ExcelAction extends ActionSupport {

    public String excelDemo() {
        Map param = new HashMap();
        List<Map> dataList = new ArrayList<>();
        param.put("dataList", dataList);

        for (int i = 0; i < 5; i++) {
            Map map = new HashMap();
            map.put("name", "name" + i);
            map.put("value", "value" + i);
            dataList.add(map);
        }

        String tempPath = "D:\\git_repositorys\\demo_repository\\demo_fileupload_struts2\\src\\main\\webapp\\temp\\template.xlsx";

        String exportPath = "D:\\git_repositorys\\demo_repository\\demo_fileupload_struts2\\src\\main\\webapp\\temp\\template_data.xlsx";

        XLSTransformer transFormer = new XLSTransformer();

        try {
            transFormer.transformXLS(tempPath, param, exportPath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return "success";
    }


}
