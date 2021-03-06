package hello.leavesC.chat.view.me;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.tencent.bugly.beta.Beta;

import butterknife.ButterKnife;
import butterknife.OnClick;
import hello.leavesC.chat.BuildConfig;
import hello.leavesC.chat.R;
import hello.leavesC.chat.view.base.BaseActivity;
import hello.leavesC.common.common.OptionView;

/**
 * 作者：叶应是叶
 * 时间：2018/1/21 19:28
 * 说明：关于
 */
public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setToolbarTitle("关于");
        OptionView ov_version = findViewById(R.id.ov_version);
        ov_version.setContent("version：" + BuildConfig.VERSION_NAME + "\nbuildTime：" + BuildConfig.buildTime);
        ButterKnife.bind(this);
    }

    @Override
    protected ViewModel initViewModel() {
        return null;
    }

    @OnClick({R.id.ov_gitHub, R.id.ov_contact, R.id.ov_checkUpgrade})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ov_gitHub: {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/leavesC/Chat")));
                break;
            }
            case R.id.ov_contact: {
                AppIntroductionActivity.navigation(AboutActivity.this, "联系方式", getString(R.string.about_contact));
                break;
            }
            case R.id.ov_checkUpgrade: {
                Beta.checkUpgrade();
                break;
            }
        }
    }

}