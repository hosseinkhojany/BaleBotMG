//package james_gosling.projects.balebotmg;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.database.Cursor;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Environment;
//import android.provider.MediaStore;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.ajts.androidmads.telegrambotlibrary.Telegram;
//import com.ajts.androidmads.telegrambotlibrary.Utils.TelegramCallback;
//import com.ajts.androidmads.telegrambotlibrary.Utils.TelegramMediaType;
//import com.ajts.androidmads.telegrambotlibrary.models.GetMe;
//import com.ajts.androidmads.telegrambotlibrary.models.Message;
//
//import java.io.File;
//
//import okhttp3.Call;
//
//@SuppressWarnings("ConstantConditions")
//public class MainActivity2 extends AppCompatActivity {
//
//    String[] mediaColumns = {MediaStore.Video.Media._ID};
//    String imagePickedPath, videoPickedPath, audioPickedPath, documentPickedPath , chatId = "322903581";
//    ImageView imagePreview;
//    int pick_photo = 0, pick_video = 1, pick_audio = 2;
//    TextView tv2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        imagePreview = (ImageView) findViewById(R.id.image_preview);
//        tv2 = (TextView) findViewById(R.id.tv2);
//
//        documentPickedPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath()+"/download.pdf";
//
//        //tel 1306004577:AAEv9NJjLrOhmL6ov3Ioze9FAmeEV-4RuoQ
//        //bal 474370142:96de20d2d1c3b26639b3e2d314d81a26fce8b9e9
//        //username @greenrootkit_bot
//        final Telegram telegram = new Telegram("1306004577:AAEv9NJjLrOhmL6ov3Ioze9FAmeEV-4RuoQ");
//
//
//
//        findViewById(R.id.getMe).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    telegram.getMe(new TelegramCallback<GetMe>() {
//                        @Override
//                        public void onResponse(Call call, final GetMe getMe) {
//                            Log.v("response.body()", getMe.isOk() + "");
//                            tv2.setText(getMe.getDescription());
//                            Toast.makeText(MainActivity2.this, ""+getMe.getDescription(), Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void onFailure(Call call, Exception e) {
//
//                        }
//                    });
//                } catch (Exception ignored) {
//
//                }
//            }
//        });
//
//        findViewById(R.id.message).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                telegram.sendMessage(chatId, "TelegramBotLibrary", new TelegramCallback<Message>() {
//                    @Override
//                    public void onResponse(Call call, Message response) {
//                        Log.v("response.body()", response.isOk() + "");
//                    }
//
//                    @Override
//                    public void onFailure(Call call, Exception e) {
//
//                    }
//                });
//            }
//        });
//
//        findViewById(R.id.messageHtml).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                telegram.sendMessage(chatId,
//                        "<i>TelegramBotLibrary</i>",
//                        Telegram.ParseMode.HTML,
//                        new TelegramCallback<Message>() {
//                            @Override
//                            public void onResponse(Call call, Message response) {
//                                Toast.makeText(MainActivity2.this, response.isOk() + "", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onFailure(Call call, Exception e) {
//
//                            }
//                        });
//            }
//        });
//
//        findViewById(R.id.messageMD).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                telegram.sendMessage(chatId,
//                        "*TelegramBotLibrary*",
//                        Telegram.ParseMode.Markdown,
//                        new TelegramCallback<Message>() {
//                            @Override
//                            public void onResponse(Call call, Message response) {
//                                Toast.makeText(MainActivity2.this, response.isOk() + "", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onFailure(Call call, Exception e) {
//
//                            }
//                        });
//            }
//        });
//
//        findViewById(R.id.browse_photo).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
//                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(galleryIntent, pick_photo);
//            }
//        });
//
//        findViewById(R.id.send_photo).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                telegram.sendPhoto(chatId,
//                        TelegramMediaType.Image.png,
//                        new File(imagePickedPath),
//                        "telegram photo",
//                        new TelegramCallback<Message>() {
//                            @Override
//                            public void onResponse(Call call, Message response) {
//                                Toast.makeText(MainActivity2.this, response.isOk() + "", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onFailure(Call call, Exception e) {
//
//                            }
//                        });
//            }
//        });
//
//        findViewById(R.id.browse_video).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
//                        MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(galleryIntent, pick_video);
//            }
//        });
//
//        findViewById(R.id.send_video).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                telegram.sendVideo(chatId,
//                        TelegramMediaType.Video.mp4,
//                        new File(videoPickedPath),
//                        "telegram video",
//                        new TelegramCallback<Message>() {
//                            @Override
//                            public void onResponse(Call call, Message response) {
//                                Toast.makeText(MainActivity2.this, response.isOk() + "", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onFailure(Call call, Exception e) {
//
//                            }
//                        });
//            }
//        });
//
//        findViewById(R.id.browse_audio).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
//                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(galleryIntent, pick_audio);
//            }
//        });
//
//        findViewById(R.id.send_audio).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                telegram.sendAudio(chatId,
//                        TelegramMediaType.Audio.mp3,
//                        new File(audioPickedPath),
//                        "telegram audio",
//                        new TelegramCallback<Message>() {
//                            @Override
//                            public void onResponse(Call call, Message response) {
//                                Toast.makeText(MainActivity2.this, response.isOk() + "", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onFailure(Call call, Exception e) {
//
//                            }
//                        });
//            }
//        });
//
//        findViewById(R.id.send_document).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                telegram.sendDocument(chatId,
//                        TelegramMediaType.Document.file,
//                        new File(documentPickedPath),
//                        "telegram document",
//                        new TelegramCallback<Message>() {
//                            @Override
//                            public void onResponse(Call call, Message response) {
//                                Toast.makeText(MainActivity2.this, response.isOk() + "", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onFailure(Call call, Exception e) {
//
//                            }
//                        });
//            }
//        });
//
//        findViewById(R.id.send_location).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                telegram.sendLocation(chatId,
//                        "11.08",
//                        "77.36",
//                        new TelegramCallback<Message>() {
//                            @Override
//                            public void onResponse(Call call, Message response) {
//                                Toast.makeText(MainActivity2.this, response.isOk() + "", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onFailure(Call call, Exception e) {
//
//                            }
//                        });
//            }
//        });
//
//        findViewById(R.id.send_venue).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                telegram.sendVenue(chatId,
//                        "11.08",
//                        "77.36",
//                        "My venue",
//                        "India",
//                        new TelegramCallback<Message>() {
//                            @Override
//                            public void onResponse(Call call, Message response) {
//                                Toast.makeText(MainActivity2.this, response.isOk() + "", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onFailure(Call call, Exception e) {
//
//                            }
//                        });
//            }
//        });
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        try {
//            // When an Image is picked
//            if (requestCode == pick_photo && resultCode == RESULT_OK && null != data) {
//
//                // Get the Image from data
//                Uri selectedImage = data.getData();
//                String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
//                assert cursor != null;
//                cursor.moveToFirst();
//
//                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//                imagePickedPath = cursor.getString(columnIndex);
//                // Set the Image in ImageView for Previewing the Media
//                imagePreview.setImageBitmap(BitmapFactory.decodeFile(imagePickedPath));
//                cursor.close();
//
//            } // When an Video is picked
//            else if (requestCode == pick_video && resultCode == RESULT_OK && null != data) {
//
//                // Get the Video from data
//                Uri selectedVideo = data.getData();
//                String[] filePathColumn = {MediaStore.Video.Media.DATA};
//
//                Cursor cursor = getContentResolver().query(selectedVideo, filePathColumn, null, null, null);
//                assert cursor != null;
//                cursor.moveToFirst();
//
//                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//
//                videoPickedPath = cursor.getString(columnIndex);
//                // Set the Video Thumb in ImageView Previewing the Media
//                imagePreview.setImageBitmap(getThumbnailPathForLocalFile(MainActivity2.this, selectedVideo));
//                cursor.close();
//
//            }  // When an Audio is picked
//            else if (requestCode == pick_audio && resultCode == RESULT_OK && null != data) {
//
//                // Get the Audio from data
//                Uri selectedAudio = data.getData();
//                String[] filePathColumn = {MediaStore.Audio.Media.DATA};
//
//                Cursor cursor = getContentResolver().query(selectedAudio, filePathColumn, null, null, null);
//                assert cursor != null;
//                cursor.moveToFirst();
//
//                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//                audioPickedPath = cursor.getString(columnIndex);
//                cursor.close();
//
//            } else if (requestCode == pick_photo && resultCode != RESULT_OK) {
//                Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
//            } else if (requestCode == pick_video && resultCode != RESULT_OK) {
//                Toast.makeText(this, "You haven't picked Video", Toast.LENGTH_LONG).show();
//            } else if (requestCode == pick_audio && resultCode != RESULT_OK) {
//                Toast.makeText(this, "You haven't picked Audio", Toast.LENGTH_LONG).show();
//            }
//        } catch (Exception e) {
//            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
//        }
//
//    }
//
//    // Providing Thumbnail For Selected Image
//    public Bitmap getThumbnailPathForLocalFile(Activity context, Uri fileUri) {
//        long fileId = getFileId(context, fileUri);
//        return MediaStore.Video.Thumbnails.getThumbnail(context.getContentResolver(),
//                fileId, MediaStore.Video.Thumbnails.MICRO_KIND, null);
//    }
//
//    // Getting Selected File ID
//    public long getFileId(Activity context, Uri fileUri) {
//        Cursor cursor = context.managedQuery(fileUri, mediaColumns, null, null, null);
//        if (cursor.moveToFirst()) {
//            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID);
//            return cursor.getInt(columnIndex);
//        }
//        return 0;
//    }
//}