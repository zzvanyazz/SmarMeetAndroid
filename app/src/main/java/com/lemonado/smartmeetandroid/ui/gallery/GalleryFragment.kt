package com.lemonado.smartmeetandroid.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker
import com.lemonado.smartmeetandroid.R
import com.lemonado.smartmeetandroid.databinding.FragmentGalleryBinding
import com.lemonado.smartmeetandroid.repositories.CurrentTime
import java.util.*

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private lateinit var btnChooseTime: MaterialButton
    private val datePicker = MaterialDatePicker.Builder
        .datePicker()
        .setTitleText("")
        .build()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        btnChooseTime = binding.root.findViewById(R.id.btn_choose_time)

        datePicker.addOnPositiveButtonClickListener { onDatePicked(it) }
        btnChooseTime.setOnLongClickListener { onDateChoosing() }
        CurrentTime.date.observeForever { onDateChanged(it) }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onDateChanged(date: Date) {
        btnChooseTime.text = date.toString()
    }

    private fun onDateChoosing(): Boolean {
        datePicker.show(fragmentManager!!, "tag")
        return true
    }

    private fun onDatePicked(time: Long) {
        val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        calendar.timeInMillis = time
        CurrentTime.updateDate(calendar.time)
    }
}