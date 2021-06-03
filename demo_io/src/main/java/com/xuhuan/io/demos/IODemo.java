package com.xuhuan.io.demos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huan.xu
 * @ClassName Demo1
 * @date 2021/4/8 11:10
 * @Description IO demo
 * 复制文本文件,既可用字符流方式,也可以用字节流方式.
 * 复制非文本文件,只能用字节流方式.
 */
public class IODemo {

    private static Logger logger = LoggerFactory.getLogger(IODemo.class);

    private IODemo() {

    }

    /**
     * 字符流方式复制文件,一次复制一个字符
     *
     * @param srcFilePath
     * @param destFilePath
     */
    public static void copyFileChar(String srcFilePath, String destFilePath) {
        long startTime = System.currentTimeMillis();
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader(srcFilePath);
            fileWriter = new FileWriter(destFilePath);

            int charRead = 0;
            while ((charRead = fileReader.read()) != -1) {
                fileWriter.write(charRead);
            }
            fileWriter.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        long endTime = System.currentTimeMillis();
        logger.info("方法[{}]复制文件[{}]花费时间[{}]毫秒", "copyFileChar", srcFilePath, (endTime - startTime));

    }

    /**
     * 字符流读写复制文件,每次复制一个字符数组
     *
     * @param srcFilePath
     * @param destFilePath
     */
    public static void copyFileCharArray(String srcFilePath, String destFilePath) {
        long startTime = System.currentTimeMillis();
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader(srcFilePath);
            fileWriter = new FileWriter(destFilePath);

            int readLeng = 0;
            char[] charArray = new char[1024];
            while ((readLeng = fileReader.read(charArray)) != -1) {
                fileWriter.write(charArray, 0, readLeng);
            }
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        long endTime = System.currentTimeMillis();
        logger.info("方法[{}]复制文件[{}]花费时间[{}]毫秒", "copyFileCharArray", srcFilePath, (endTime - startTime));
    }

    /**
     * 缓冲字符流读写复制文件,每次复制复制一个字符
     *
     * @param srcFilePath
     * @param destFilePath
     */
    public static void copyFileBufferedChar(String srcFilePath, String destFilePath) {
        long startTime = System.currentTimeMillis();
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileReader = new FileReader(srcFilePath);
            fileWriter = new FileWriter(destFilePath);

            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);

            int readLeng = 0;
            while ((readLeng = bufferedReader.read()) != -1) {
                bufferedWriter.write(readLeng);
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        long endTime = System.currentTimeMillis();
        logger.info("方法[{}]复制文件[{}]花费时间[{}]毫秒", "copyFileBufferedChar", srcFilePath, (endTime - startTime));
    }

    /**
     * 缓冲字符流读写复制文件,每次复制一个字符数组
     *
     * @param srcFilePath
     * @param destFilePath
     */
    public static void copyFileBufferedCharArray(String srcFilePath, String destFilePath) {
        long startTime = System.currentTimeMillis();
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileReader = new FileReader(srcFilePath);
            fileWriter = new FileWriter(destFilePath);

            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);

            int readLeng = 0;
            char[] charArray = new char[1024];
            while ((readLeng = bufferedReader.read(charArray)) != -1) {
                bufferedWriter.write(charArray, 0, readLeng);
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        long endTime = System.currentTimeMillis();
        logger.info("方法[{}]复制文件[{}]花费时间[{}]毫秒", "copyFileBufferedCharArray", srcFilePath, (endTime - startTime));
    }

    /**
     * 缓冲字符流读写复制文件,每次复制一行
     *
     * @param srcFilePath
     * @param destFilePath
     */
    public static void copyFileBufferedCharLine(String srcFilePath, String destFilePath) {
        long startTime = System.currentTimeMillis();
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileReader = new FileReader(srcFilePath);
            fileWriter = new FileWriter(destFilePath);

            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);

            String lineRead;
            //读取一行,null代表已经读到流末尾
            while ((lineRead = bufferedReader.readLine()) != null) {
                bufferedWriter.write(lineRead);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        logger.info("方法[{}]复制文件[{}]花费时间[{}]毫秒", "copyFileBufferedCharLine", srcFilePath, (endTime - startTime));
    }

    /**
     * 字节流读写复制文件,每次复制一个字节
     *
     * @param srcFilePath
     * @param destFilePath
     */
    public static void copyFileByte(String srcFilePath, String destFilePath) {
        long startTime = System.currentTimeMillis();
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);

            int charRead = 0;
            while ((charRead = fileInputStream.read()) != -1) {
                //写入单个字节
                fileOutputStream.write(charRead);
            }
            fileOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        long endTime = System.currentTimeMillis();
        logger.info("方法[{}]复制文件[{}]花费时间[{}]毫秒", "copyFileByte", srcFilePath, (endTime - startTime));
    }

    /**
     * 字节流读写复制文件,每次复制一个字节数组
     *
     * @param srcFilePath
     * @param destFilePath
     */
    public static void copyFileByteArray(String srcFilePath, String destFilePath) {
        long startTime = System.currentTimeMillis();
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);

            int readLength = 0;
            byte[] byteArray = new byte[1024];
            /**
             * 每次读取byteArray.length个字符存入byteArray,-1代表已经到流的末尾
             * readLength为读取的长度,一般为byteArray.length,最后一次循环时一般不足byteArray.length,为实际读取长度
             */
            while ((readLength = fileInputStream.read(byteArray)) != -1) {
                //写入读取的字节数组
                fileOutputStream.write(byteArray, 0, readLength);
            }
            fileOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        long endTime = System.currentTimeMillis();
        logger.info("方法[{}]复制文件[{}]花费时间[{}]毫秒", "copyFileByteArray", srcFilePath, (endTime - startTime));
    }

    /**
     * 缓冲字节流读写复制文件,每次复制一个字节
     *
     * @param srcFilePath
     * @param destFilePath
     */
    public static void copyFileByteBuffered(String srcFilePath, String destFilePath) {
        long startTime = System.currentTimeMillis();
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            int readByte = 0;
            while ((readByte = bufferedInputStream.read()) != -1) {
                //写入单个字节
                bufferedOutputStream.write(readByte);
            }
            bufferedOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        long endTime = System.currentTimeMillis();
        logger.info("方法[{}]复制文件[{}]花费时间[{}]毫秒", "copyFileByteBuffered", srcFilePath, (endTime - startTime));
    }

    /**
     * 缓冲字节流读写复制文件,每次复制一个字节数组
     *
     * @param srcFilePath
     * @param destFilePath
     */
    public static void copyFileByteArrayBuffered(String srcFilePath, String destFilePath) {
        long startTime = System.currentTimeMillis();
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            int readLeng = 0;
            byte[] byteArray = new byte[1024];
            while ((readLeng = bufferedInputStream.read(byteArray)) != -1) {
                bufferedOutputStream.write(byteArray, 0, readLeng);
            }
            bufferedOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        long endTime = System.currentTimeMillis();
        logger.info("方法[{}]复制文件[{}]花费时间[{}]毫秒", "copyFileByteArrayBuffered", srcFilePath, (endTime - startTime));
    }

    /**
     * 获取目录下的文件，存入fileList中
     *
     * @param fileList
     * @param dir        目录的地址
     * @param containDir 是否包含目录
     * @return
     */
    public static List<File> listFile(List<File> fileList, File dir, boolean containDir) {
        if (fileList == null) {
            fileList = new ArrayList<>();
        }
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    if (containDir) {
                        fileList.add(file);
                    }
                    listFile(fileList, file, containDir);
                } else {
                    fileList.add(file);
                }
            }
        } else {
            fileList.add(dir);
        }
        return fileList;
    }

    /**
     * 使用缓冲字节流复制文件夹
     *
     * @param srcDirPath
     * @param destDirPath
     */
    public static void copyDirFile(String srcDirPath, String destDirPath) {
        long startTime = System.currentTimeMillis();
        List<File> fileList = new ArrayList<>();
        //1.首先找到所有要复制的文件
        listFile(fileList, new File(srcDirPath), false);
        long endTime = System.currentTimeMillis();
        logger.info("查找[{}]所有文件，总个数[{}]，花费时间[{}]毫秒", srcDirPath, fileList.size(), (endTime - startTime));
        //2.组装目标地址,并复制文件
        fileList.stream().forEach(f -> {
            logger.info("找到文件[{}]", f.getPath());
            String destFilePath = f.getPath().replace(srcDirPath, destDirPath);
            File destFile=new File(destFilePath);
            String destFileDirPath = destFile.getParent();
            File destFileDir=new File(destFileDirPath);
            if(!destFileDir.exists()){
                destFileDir.mkdirs();
            }
            copyFileByteArrayBuffered(f.getPath(),destFile.getPath());

        });
        long endTime2 = System.currentTimeMillis();
        logger.info("复制[{}]所有文件，总个数[{}]，花费时间[{}]秒", srcDirPath, fileList.size(), (endTime2 - startTime)/1000);
    }

}
