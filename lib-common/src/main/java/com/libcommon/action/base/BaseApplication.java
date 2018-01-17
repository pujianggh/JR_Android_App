package com.libcommon.action.base;

import android.support.multidex.MultiDexApplication;

/**
 * Application基类
 *
 * @author pujiang
 * @date 2017-12-15 17:04
 * @mail 515210530@qq.com
 * @Description: 包含主要功能初始化，如：热修复、Application对象获取等
 */
public class BaseApplication extends MultiDexApplication {
//    protected OkHttpCall mOkHttpCall;
//    protected DownloadMgr mDownloadMgr;
//    private PatchManager mPatchManager;
//
//    /**
//     * 热修复补丁初始化
//     */
//    protected void initAndFix(String appVersion) {
//        String[] permiss = new String[]{
//                Manifest.permission.WRITE_EXTERNAL_STORAGE,//往SDCard写入数据权限
//                Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS//在SDCard中创建与删除文件权限
//        };
//        //权限判断
//        if (!PermissionUtil.checkPermissions(this, permiss)) {
//            return;
//        }
//        mPatchManager = new PatchManager(this);
//        mPatchManager.init(appVersion);
//        mPatchManager.loadPatch();
//        FileUtil.makeRootDirectory(AppConfig.FILE_PATCH_PATH);
//        try {
//            //文件存在判断
//            if (FileUtil.isFileExist(AppConfig.FILE_PATCH_PATH + "/" + AppConfig.FILE_PATCH_NAME)) {
//                File file = new File(AppConfig.FILE_PATCH_PATH, AppConfig.FILE_PATCH_NAME);
//                mPatchManager.addPatch(file.getAbsolutePath());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 初始化ImageLoader
//     *
//     * @param context
//     */
//    protected void initImageLoader(Context context) {
//        DisplayImageOptions defaultDisplayImageOptions = new DisplayImageOptions.Builder()
//                .showImageOnFail(R.drawable.pic_default)
//                .showImageForEmptyUri(R.drawable.pic_default)
//                .cacheInMemory(true).cacheOnDisc(true)
//                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
//                .bitmapConfig(Bitmap.Config.RGB_565)
//                .showImageOnLoading(null)
//                //.displayer(new RoundedBitmapDisplayer(0))
//                .build();
//
//        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
//        config.threadPriority(Thread.NORM_PRIORITY - 2);
//        config.denyCacheImageMultipleSizesInMemory();
//        config.discCacheFileNameGenerator(new Md5FileNameGenerator());
//        config.discCacheSize(50 * 1024 * 1024); // 50 MiB
//        config.tasksProcessingOrder(QueueProcessingType.LIFO);
//        config.writeDebugLogs(); // Remove for release app
//        config.defaultDisplayImageOptions(defaultDisplayImageOptions);
//        ImageLoader.getInstance().init(config.build());
//    }
//
//    /**
//     * 初始化OkHttp参数
//     */
//    protected void initOkHttpConfig() {
//        //持久化存储cookie
//        ClearableCookieJar cookieJar =
//                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));
//
//        //log拦截器
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        //自定义OkHttp
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(20000L, TimeUnit.MILLISECONDS)
//                .readTimeout(20000L, TimeUnit.MILLISECONDS)
//                .cookieJar(cookieJar)       //设置开启cookie
//                .addInterceptor(logging)            //设置开启log
//                .build();
//        mOkHttpCall = new OkHttpCall(okHttpClient);
//
//        mDownloadMgr = (DownloadMgr) new DownloadMgr.Builder()
//                .myOkHttp(mOkHttpCall)
//                .maxDownloadIngNum(5)       //设置最大同时下载数量（不设置默认5）
//                .saveProgressBytes(50 * 1204)   //设置每50kb触发一次saveProgress保存进度 （不能在onProgress每次都保存 过于频繁） 不设置默认50kb
//                .build();
//        //mDownloadMgr.resumeTasks();     //恢复本地所有未完成的任务
//        //mDownloadManager.pauseAllTask();    //暂停所有任务
//        //mDownloadManager.addTask();//添加任务
//        //mDownloadManager.deleteTask();//删除任务
//    }
//
//    /**
//     * 微客服初始化
//     */
//    protected void initKeFuData() {
//        //默认关闭调试模式
//        KFAPIs.DEBUG = false;
//        //第一个参数默认设置为false, 即登录普通服务器, 如果设置为true, 则登录IP服务器,
//        //注意: 当第一个参数设置为true的时候, 客服端需要选择登录ip服务器 才能够会话
//        //正常情况下第一个参数请设置为false
//        KFAPIs.enableIPServerMode(false, this);
//        //第一种登录方式，推荐
//        KFAPIs.visitorLogin(this);
//        //第二种登录方式，传入user_id , 注意user_id中只能包含数字、字母和下划线_,不能含有汉字
//        //KFAPIs.loginWithUserID("1111111111", this);
//        //第三中登录方式，首先使用user_id调用注册接口注册一个用户，一个user_id只能注册一次，不能重复注册
//        //KFAPIs.registerWithUsernameAndPassword(userid, password, this);
//        //注册用户之后，使用user_id调用登录接口登录
//        //KFAPIs.loginWithUsernameAndPassword(userid, password, this);
//    }
//
//    public PatchManager getmPatchManager() {
//        return mPatchManager;
//    }
//
//    public OkHttpCall getOkHttpCall() {
//        return mOkHttpCall;
//    }
//
//    public DownloadMgr getmDownloadMgr() {
//        return mDownloadMgr;
//    }
}
