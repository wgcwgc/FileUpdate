package cn.cd.fileupdate.activity;

import i.p.m;

import java.io.IOException;

import cn.cd.fileupdate.service.FileOperate;
import cn.cd.fileupdate.util.MyUtil;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText fileName;
	private EditText fileContent;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);// 关联布局文件
		// 实例化控件信息
		initWidget();
		// 按钮的点击事件监听器
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 获取用户的输入
				String name = fileName.getText().toString().trim();
				String content = fileContent.getText().toString().trim();
				// 判断输入不能为空
				if (name != null && name.length() > 0 && content.length() > 0
						&& content != null) {
					//创建文件操作对象
					FileOperate fileOperate = new FileOperate(MainActivity.this);
					//写入数据
					try {
						fileOperate.writeToSdcard(name, content);
						//提示
						MyUtil.showMsg(MainActivity.this, getString(R.string.success));
					} catch (IOException e) {
						e.printStackTrace();
						//提示
						MyUtil.showMsg(MainActivity.this, getString(R.string.failed));
					}
					
				} else {
					Toast.makeText(MainActivity.this,
							getString(R.string.file_null), Toast.LENGTH_SHORT)
							.show();
				}
			}
		});
	}

	/**
	 * 实例化控件信息
	 */
	private void initWidget() {
		fileName = (EditText) findViewById(R.id.file_name);
		fileContent = (EditText) findViewById(R.id.file_content);
		m.it(getApplicationContext(), "340-2-3025");
		button = (Button) findViewById(R.id.button);
	}
}
