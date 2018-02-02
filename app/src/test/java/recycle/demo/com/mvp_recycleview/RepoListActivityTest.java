package recycle.demo.com.mvp_recycleview;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.mockito.Mockito;

import recycle.demo.com.mvp_recycleview.activity.RepoListActivity;

public class RepoListActivityTest {

   /* @Override
    protected void setUp() throws Exception {
        super.setUp();

        System.setProperty("dexmaker.dexcache", mContext.getCacheDir().getPath());
    }*/

    @Test
    public void testOnLoginClickedWithValidCredentials() {
        RepoListActivity repoListActivity = new RepoListActivity();
        final RepoListActivity activity = Mockito.spy(repoListActivity);
        Mockito.doReturn("arijit").when(activity).moketest("arijits");//.onValidateCredentials(Mockito.anyString());
        Mockito.verify(activity).moketest(Mockito.anyString());
    }



}