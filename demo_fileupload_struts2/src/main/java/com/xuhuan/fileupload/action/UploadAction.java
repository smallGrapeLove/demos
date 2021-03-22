package com.xuhuan.fileupload.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;

public class UploadAction extends ActionSupport {

    //表单文本数据
    private String readme;
    //表单文件,必须是一个File类型
    private File uploadFile;
    //上传的文件名,格式必须是File名称 + FileName
    private String uploadFileFileName;
    //上传的文件类型,格式必须是File名称 + ContentType
    private String uploadFileContentType;
    private String message;

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getUploadFileFileName() {
        return uploadFileFileName;
    }

    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    public String getUploadFileContentType() {
        return uploadFileContentType;
    }

    public void setUploadFileContentType(String uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //上传
    public String upload() throws IOException {
        //获取上传的绝对路径
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/files");
        //如果提交过来的File不为null，才执行上传操作
        if (uploadFile != null) {
            //根据文件名以及上传的路径构建一个新的File对象
            File saveFile = new File(uploadPath, uploadFileFileName);
            //先判断上传的目录是否存在，如果不存在则创建出来
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            //使用文件复制执行上传
            FileUtils.copyFile(uploadFile, saveFile);
            //提示成功信息
            message = "上传成功";
        }
        return "success";
    }
}
