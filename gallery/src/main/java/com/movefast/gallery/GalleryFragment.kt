package com.movefast.gallery

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.movefast.core.fragments.BaseFragment
import com.movefast.data.network.Resource
import com.movefast.viewer.GalleryViewerActivity
import com.paginate.Paginate
import javax.inject.Inject


/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
class GalleryFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: GalleryViewModel

    private val adapter by lazy { GalleryAdapter(viewModel) }
    private var recyclerViewImages: RecyclerView? = null
    private var progressBarImages: ProgressBar? = null

    override val layoutId: Int = R.layout.fragment_gallery

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        getNextPage()
    }

    private fun initViews() {
        recyclerViewImages = view?.findViewById(R.id.recycler_view_fragment_gallery_images)
        progressBarImages = view?.findViewById(R.id.progress_bar_fragment_gallery_images)

        recyclerViewImages?.adapter = adapter

        Paginate.with(recyclerViewImages, viewModel)
            .setLoadingTriggerThreshold(2)
            .addLoadingListItem(false)
            .build()
    }

    private fun initListeners() {
        adapter.setOnItemClickListener { _, position ->
            GalleryViewerActivity.start(requireContext(), viewModel.getPhotoUrls(), position)
        }
    }

    private fun getNextPage() {
        viewModel.photosLiveData.observe(this, this::handleResource)
    }

    private fun handleResource(resource: Resource<Unit>) {
        when (resource) {
            is Resource.Loading -> {
                handleLoadingResource(resource)
            }
            is Resource.Success -> {
                handleSuccessResource()
            }
            is Resource.Error -> {
                handleErrorResource(resource)
            }
        }
    }

    private fun handleLoadingResource(resource: Resource.Loading<Unit>) {
        if (resource.show) {
            progressBarImages?.visibility = View.VISIBLE
        } else {
            progressBarImages?.visibility = View.GONE
        }
    }

    private fun handleSuccessResource() {
        recyclerViewImages?.adapter?.notifyDataSetChanged()
    }

    private fun handleErrorResource(resource: Resource.Error<Unit>) {
        view?.let { view ->
            Snackbar.make(view, resource.error.message ?: "", Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.action_retry) { getNextPage() }
        }
    }
}
