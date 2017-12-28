package com.armstring.linkchattingapplication.ui.view;

/**
 * Created by Darkwood on 12/28/2017.
 */

public class Draft {
}

/*
//4.2 save the image on firebase reference.
                /*filePath.putFile(resultUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SettingsActivity.this, "Image Has been added to firebase", Toast.LENGTH_LONG).show();
                            final String image_url = task.getResult().getDownloadUrl().toString();//image_url is the thing we just uploaded to firebase storage
                            UploadTask uploadTask = thumbImagePath.putBytes(thumbByteArray);
                            uploadTask.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> thumTask) {
                                    String thumbImageUrlOnFirebase = thumTask.getResult().getDownloadUrl().toString();
                                    if(thumTask.isSuccessful()){

                                        Map updateHashMap = new HashMap();
                                        //updateHashMap.put("image", image_url); using image_url overloads the phone cuz its heavy!
                                        updateHashMap.put("image", thumbImageUrlOnFirebase);
                                        updateHashMap.put("thumb_image", thumbImageUrlOnFirebase);


                                        reference.updateChildren(updateHashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                progressDialog.dismiss();
                                                Toast.makeText(SettingsActivity.this, "Image Saved", Toast.LENGTH_LONG).show();
                                            }
                                        });
                                    }else{
                                        Toast.makeText(SettingsActivity.this, "Unexpected Error Happened, While Uploading Thumb Image", Toast.LENGTH_LONG).show();
                                        progressDialog.dismiss();
                                    }
                                }
                            });

                        }else{
                            Toast.makeText(SettingsActivity.this, "Unexpected Error Happened While Uploading Profile Image", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                });*/
