package com.app.imagemacroscreator.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.app.imagemacroscreator.convertToBitmap
import com.app.imagemacroscreator.databinding.FragmentMainBinding
import com.app.imagemacroscreator.domain.models.IImageMacroModel
import com.app.imagemacroscreator.showToast
import com.app.imagemacroscreator.utils.CustomProgressBar
import com.app.imagemacroscreator.utils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.io.File

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by sharedViewModel()
    private lateinit var binding: FragmentMainBinding
    private val progressbar: CustomProgressBar by lazy {
        CustomProgressBar()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initObservers()
        viewModel.getColor()
        viewModel.getTemplate()
    }

    private fun initObservers() {
        lifecycleScope.launchWhenResumed {
            viewModel.dataState.observe(viewLifecycleOwner){ dataState ->
                when(dataState){
                    is DataState.Success -> {
                        handleData(dataState.data)
                    }
                    is DataState.Error -> {
                        handleError(dataState.exception)
                    }
                    is DataState.Loading -> {
                        handleLoader()
                    }
                }
            }
        }
    }

    private fun handleLoader() {
        progressbar.show(context)
    }

    private fun hideDialog(){
        progressbar.dialog.dismiss()
    }

    private fun handleError(exception: Exception) {
        hideDialog()
        context?.showToast(exception.message)
    }

    private fun handleData(data: IImageMacroModel) {
        context?.let { context ->
            hideDialog()
            data.backgroundColor?.let { color ->
                binding.containerView.setBackgroundColor(ContextCompat.getColor(
                    context, color))
            }
            data.text?.let { text ->
                binding.tvBottomText.text = text
            }
            data.image?.let {
                binding.ivImage.setImageBitmap(it)
            }
        }
    }

    private fun initListeners() {
        binding.ivColors.setOnClickListener {
            viewModel.getColor()
        }
        binding.ivDone.setOnClickListener {
            viewModel.addText(binding.etBottomText.text.toString())
        }
        binding.ivAddImage.setOnClickListener {
            viewModel.getTemplate()
        }
        binding.ivShare.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                context?.let { context ->
                    val filename = binding.containerView.convertToBitmap()
                    val fileUri = FileProvider.getUriForFile(context,
                        "com.app.imagemacroscreator.fileprovider",
                        File(context.filesDir, filename)
                    )
                    val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
                    sharingIntent.type = "image/*"
                    sharingIntent.putExtra(Intent.EXTRA_STREAM, fileUri)
                    context.startActivities(arrayOf(Intent.createChooser(sharingIntent, "Share with")))
                }

            }
        }
    }
}