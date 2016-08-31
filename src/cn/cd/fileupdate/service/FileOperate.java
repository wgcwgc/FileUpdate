package cn.cd.fileupdate.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import cn.cd.fileupdate.activity.R;
import cn.cd.fileupdate.util.MyUtil;

import android.content.Context;
import android.os.Environment;

/**
 * �ļ������࣬���������ļ�����
 * 
 * @since JDK 1.6
 * @version 1.0
 * @date 2013-10-13 ����9:48:13
 */
public class FileOperate {
	private Context context;// ����ʹ�ò����ļ��ķ���

	/**
	 * ʹ�ù��췽������context
	 * 
	 * @param context
	 */
	public FileOperate(Context context) {
		this.context = context;
	}

	/**
	 * ʹ��privateģʽ�����ļ�
	 * 
	 * @throws IOException
	 */
	public void saveContent(String filename, String content, int mode)
			throws IOException {
		// ����д���ļ������������
		FileOutputStream outStream = context.openFileOutput(filename, mode);
		// д����������
		saveFile(content, outStream);
	}

	/**
	 * �����ļ�(�����Ժ�ĵ���)
	 * 
	 * @throws IOException
	 */
	private void saveFile(String content, FileOutputStream outStream)
			throws IOException {
		outStream.write(content.getBytes());// д����������
		outStream.close();// �ر��ļ������
	}

	/**
	 * ��ȡ/data/data/package name/files��Ŀ¼
	 * 
	 * @return
	 */
	public String getFilesDir() {
		// ���Ȼ�ȡ�ļ�����
		File file = context.getFilesDir();
		return file.getAbsolutePath();// �����ļ���·��
	}

	/**
	 * ��ȡ/data/data/package name/cache��Ŀ¼
	 * 
	 * @return
	 */
	public String getCacheDir() {
		// ���Ȼ�ȡ�ļ�����
		File file = context.getCacheDir();
		return file.getAbsolutePath();// �����ļ���·��
	}

	/**
	 * ��ȡ˽���ļ����ݵķ���
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public String read(String filename) throws IOException {
		// �����ļ�����������
		FileInputStream inStream = context.openFileInput(filename);
		// ������ת�����������
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// ����һ���ֽڻ�������
		byte[] buffer = new byte[4096];
		// ��ȡ�����ݳ���
		int len = 0;
		// ѭ����ȡ����
		while ((len = inStream.read(buffer)) != -1) {
			// ����ȡ������д��������
			outStream.write(buffer, 0, len);
		}
		// ����ȡ������ת��Ϊ�ֽ�����
		byte[] datas = outStream.toByteArray();
		// �ر������������������
		outStream.close();
		inStream.close();
		return new String(datas);// ���ض�ȡ�ַ���
	}

	/**
	 * ��ȡSDcard·��
	 */
	private String getSdcardPath() {
		// �ж�sdcard�Ƿ���ڲ��ҿɶ�д
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			//����Sdcard�ĸ�Ŀ¼
			return Environment.getExternalStorageDirectory().getAbsolutePath();
		} else {
			return null;
		}
	}
	/**
	 * ������д��SDCard��
	 * @param name
	 * @param content
	 * @throws IOException 
	 */
	public void writeToSdcard(String name, String content) throws IOException {
		//��ȡSDcard�ĸ�Ŀ¼
		String sdcardPath = getSdcardPath();
		//�ж��Ƿ�Ϊ��
		if(sdcardPath != null){//��Ϊ��
			//�����ļ�����
			File file = new File(getSdcardPath(), name);
			//�ж��ļ��Ƿ����
			if(!file.exists()){//������
				//�����ļ�
				file.createNewFile();
			}
			//�������������
			FileOutputStream outStream = new FileOutputStream(file);
			//�����ļ�
			saveFile(content, outStream);
		}else{//Ϊ��
			MyUtil.showMsg(context, context.getString(R.string.sdcard_error));
		}
	}
}
