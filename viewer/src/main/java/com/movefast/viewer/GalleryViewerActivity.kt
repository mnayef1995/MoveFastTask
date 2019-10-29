package com.movefast.viewer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.movefast.core.utils.android.bindView

/**
 * Project: MoveFast
 * Created: Oct 29, 2019
 *
 * @author Mohamed Hamdan
 */
class GalleryViewerActivity : AppCompatActivity() {

    private val viewPager by bindView<ViewPager2>(R.id.view_pager_activity_gallery_view_images)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_viewer)

        viewPager?.adapter = ViewerAdapter(getUrls(intent))
        viewPager?.currentItem = getSelectedPosition(intent)
    }

    companion object {

        private const val EXTRA_URLS = "urls"
        private const val EXTRA_POSITION = "position"

        @JvmStatic
        fun start(context: Context, urls: Array<String?>, position: Int) {
            val intent = Intent(context, GalleryViewerActivity::class.java)
            intent.putExtra(EXTRA_URLS, urls)
            intent.putExtra(EXTRA_POSITION, position)
            context.startActivity(intent)
        }

        private fun getUrls(intent: Intent): Array<String?>? {
            return intent.getStringArrayExtra(EXTRA_URLS)
        }

        private fun getSelectedPosition(intent: Intent): Int {
            return intent.getIntExtra(EXTRA_POSITION, 0)
        }
    }
}
