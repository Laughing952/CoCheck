package com.unistrong.business.utile;

import android.content.Context;
import android.database.Cursor;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

import com.unistrong.business.R;
import com.waterbase.utile.GlideUtile;
import com.waterbase.utile.LogUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 图片加载帮助类
 * Created by Water on 2018/4/9.
 */

public class LoadImageUtile {

    @BindingAdapter({"res"})
    public static void LocalImageLoad(ImageView imageView, int res) {
        imageView.setImageResource(res);
    }

    /**
     * 根据图片Uri转为上传图片所需MultipartBody.Part参数
     * Created by Water on 2018/4/9.
     */
    public static MultipartBody.Part getPart(Context context, Uri uri) {
        //  File file = new File(uri.getPath());
        // :content://com.mybese/my_images/Android/data/cn.com.eapple.nongfubao/cache/1AB2567D975C4C1E4C3F42CF3D07B5CB.jpg
        String path = getPicPathByUri(context, uri);
        LogUtil.d("TAG", "path:" + path);
        File file = new File(path);
        LogUtil.d("TAG", "file:" + file.exists());
        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data;charset=UTF-8"), file);
        return MultipartBody.Part.createFormData("file", file.getName(), body);
    }

    /**
     * 根据Uri获取图片路径
     * Created by Water on 2018/4/9.
     */
    protected static String getPicPathByUri(Context context, Uri selectedImage) {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            cursor = null;

            if (picturePath == null || picturePath.equals("null")) {
                Toast toast = Toast.makeText(context, "Can't find pictures", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return null;
            }
            return picturePath;
        } else {
            File file = new File(selectedImage.getPath());
            if (!file.exists()) {
                Toast toast = Toast.makeText(context, "Can't find pictures", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return null;

            }
            return file.getAbsolutePath();
        }

    }

    /**
     * Base64图片的解码
     * Created by cuihao on 2018/4/21.
     */
    public static Bitmap base64ToBitmap(String string) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray = Base64.decode(string.split(",")[1], Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /**
     * 图片根据path转为Base64图片编码
     * Created by cuihao on 2018/4/21.
     */
    public static String filePathToString(String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bm = BitmapFactory.decodeFile(filePath, options);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] b = baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }

    public static RequestBody convertToRequestBody(String param) {
//        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), param);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), param);
        return requestBody;
    }

    public static MultipartBody.Part fileToMultipartBodyParts(File file) {
//        RequestBody requestBody =  RequestBody.create(MediaType.parse("multipart/form-data"), file);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("imgfile", file.getName(), requestBody);
        return part;
    }
    public static void loadCircleImage(ImageView imageView, String url) {
        GlideUtile.loadCircleImage(imageView, url, R.mipmap.iv_flow_people_photo_default, R.mipmap.iv_flow_people_photo_default);
    }

}
