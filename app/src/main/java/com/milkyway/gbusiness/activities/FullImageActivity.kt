package com.milkyway.gbusiness.activities

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.milkyway.gbusiness.R
import com.stfalcon.frescoimageviewer.ImageViewer
import com.veinhorn.scrollgalleryview.ScrollGalleryView


class FullImageActivity : AppCompatActivity() {
    private var galleryView: ScrollGalleryView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)
        val intent = intent
        val urls = intent.getStringArrayListExtra("uriString")
        val position = intent.getIntExtra("position", 0)

        ImageViewer.Builder<String>(this, urls)
            .setStartPosition(position)
            .setBackgroundColorRes(R.color.greyLight)
            .show()

        /*galleryView = ScrollGalleryView
            .from(findViewById<View>(R.id.scroll_gallery_view) as ScrollGalleryView)
            .settings(GallerySettings.from(supportFragmentManager).thumbnailSize(100).enableZoom(true).build())
            .onImageClickListener { position -> Toast.makeText(this, "image position = $position", Toast.LENGTH_SHORT).show() }
            .add(images(urls))
            .build()*/
        /*galleryView = ScrollGalleryView
            .from(findViewById(R.id.scroll_gallery_view))
            .settings(
                GallerySettings
                    .from(supportFragmentManager)
                    .thumbnailSize(100)
                    .enableZoom(false)
                    .build()
            )
            .add(images("https://pixabay.com/get/g8f589c05945ffdd9818f156f706caf53b67decb678dcdb2073772507ba8bde7ec2ec5375819d23cef8f7c58076ce5b643fc57127098e14ae293b55efa42989deb0fbaf610b0e96a8568d0e521b88714b_1920.jpg",
                "https://pixabay.com/get/g1cfcdfc7c005fa4bd45ce1e55f8b093da7668c98c6ccc18e9de4ee7e4cbc60179753aa0a87818fc93634ecf3c2a9bd74e531d67ded1765ef5759ba5dc056036afb3fcbe351fc2b586b191436354b7c95_1920.jpg",
                "https://pixabay.com/get/g5060954778f04acdba84039a629ca9f2f1dab9109362342589daa5864b2943cdb9f5a38f98f9f8105d1e9fbb1dfb6748996b7c819674e866a76e493c0a13658076dbe50a10a233608763733312d26b87_1920.jpg",
                "https://pixabay.com/get/g662d5edfb56f5c0920bd4fd8e9223353ffc05045369e271df8ea2bd6a866d6f042b04faaea178e3f783cc0f58834b47d7cea425911e56f93099c752f17597727ea9907ab8d4bde46aa95bf56ca10b7a0_1920.jpg",
                "https://pixabay.com/get/g8f589c05945ffdd9818f156f706caf53b67decb678dcdb2073772507ba8bde7ec2ec5375819d23cef8f7c58076ce5b643fc57127098e14ae293b55efa42989deb0fbaf610b0e96a8568d0e521b88714b_1920.jpg",
                "https://pixabay.com/get/g1cfcdfc7c005fa4bd45ce1e55f8b093da7668c98c6ccc18e9de4ee7e4cbc60179753aa0a87818fc93634ecf3c2a9bd74e531d67ded1765ef5759ba5dc056036afb3fcbe351fc2b586b191436354b7c95_1920.jpg",
                "https://pixabay.com/get/g5060954778f04acdba84039a629ca9f2f1dab9109362342589daa5864b2943cdb9f5a38f98f9f8105d1e9fbb1dfb6748996b7c819674e866a76e493c0a13658076dbe50a10a233608763733312d26b87_1920.jpg"))
            .build()*/
    }

    /*override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null && item.itemId == android.R.id.home)
            onBackPressed()
        return super.onOptionsItemSelected(item)
    }*/

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() === 0) {
            finish()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}