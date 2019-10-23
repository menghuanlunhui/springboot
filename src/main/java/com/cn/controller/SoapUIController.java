package com.cn.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.entity.Group;
import com.cn.service.GroupService;
import com.cn.util.XmlParse;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/soapUI")
public class SoapUIController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /****************正式环境配置*************************/
    //同步人力系统部门数据url
    protected static final String  DEPARTMENT_URL = "http://10.10.10.71:8089/v1/ps/get/department/sync";
    //同步人力系统人员数据url
    protected static final String  EMPLOYEE_URL = "http://10.10.10.72:8089/v1/ps/get/employee/sync";
    //同步人力系统岗位数据url
    protected static final String  JOB_URL = "http://10.10.10.72:8089/v1/ps/get/job/sync";
    //同步中台加盟商数据url
    protected static final String  CUSTACCOUNTS_URL = "http://10.10.10.71:8083/v1/oms/custAccounts/read";

    protected static final String  USER_NAME = "SSO";
    protected static final String  USER_PASWORD = "#SSO#@";



    @Autowired
    GroupService groupService;

    /**
     * 从人力系统同步部门信息
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/departmentSync")
    @ResponseBody
    public JSONObject departmentSync(HttpServletResponse response)throws Exception{
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject resultJson = new JSONObject();
        //body请求内容
        String body="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ps=\"http://ps.hr.service/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ps:getDepartment/>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        //发送请求代码
        URL url = new URL(DEPARTMENT_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        conn.setRequestMethod("POST");
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
       /* conn.setConnectTimeout(10000);
        conn.setReadTimeout(10000);*/
        String encoding = new String(Base64.encode(new String(USER_NAME+":"+USER_PASWORD).getBytes()));
        conn.setRequestProperty( "Authorization","Basic "+encoding);
        DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
        dos.write(body.getBytes("utf-8"));
        dos.flush();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        String line = null;
        StringBuffer strBuf = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            strBuf.append(line);
        }
        dos.close();
        reader.close();
        String rs = strBuf.toString();
        List<Map<String,Object>> mapList = XmlParse.parse(rs);
        if(mapList.size()>0){
            resultJson.put("status","SUCCESS");
            resultJson.put("msg",mapList);
            for (int i = 0; i < mapList.size(); i++) {
                Group group = new Group();
                Map<String,Object> map =mapList.get(i);
                if(map.get("departmentCode")!=null){
                    group.setId(map.get("departmentCode").toString());
                    group.setCode(map.get("departmentCode").toString());
                }
                if(map.get("departmentFullName")!=null){
                    group.setName(map.get("departmentFullName").toString());
                }
                if(map.get("departmentShortName")!=null){
                    group.setDesc(map.get("departmentShortName").toString());
                }
                if(map.get("parentDepartmentCode")!=null){
                    group.setParentId(map.get("parentDepartmentCode").toString());
                }
                if(group.getCode()!=null && !"".equals(group.getCode())){
                    Group selectGroup = groupService.getByCode(group.getCode());
                    if(selectGroup!=null){
                        group.setUpdateTime(new Date());
                        //后期需要登陆用户的信息
                        group.setUpdateBy("admin");
                        int j = groupService.update(group);
                        if(j<=0){
                            logger.info("更新组织信息失败，组织信息："+JSON.toJSONString(group));
                        }
                    }else{
                        group.setCreateBy("admin");
                        int j = groupService.create(group);
                        if(j<=0){
                            logger.info("新增组织信息失败，组织信息："+JSON.toJSONString(group));
                        }
                    }
                }
            }
        }else{
            resultJson.put("status","NODATA");
            resultJson.put("msg","未查询到数据");
        }

        return resultJson;
    }

}
